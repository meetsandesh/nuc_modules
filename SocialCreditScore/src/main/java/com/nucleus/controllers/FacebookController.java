package com.nucleus.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nucleus.entity.social.media.FacebookConnection;
import com.nucleus.entity.social.media.NucUser;
import com.nucleus.service.NucUserService;
import com.nucleus.service.social.credit.score.FacebookCreditScoreImpl;
import com.nucleus.service.social.credit.score.SocialCreditScore;
import com.nucleus.vo.NucUserVO;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FacebookController {
    
    @Autowired
    private NucUserService nucUserService;
    @Autowired
    private FacebookCreditScoreImpl socialCreditScore;
    private final Facebook facebook;
    private final ConnectionRepository connectionRepository;

    public FacebookController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @RequestMapping("/access/facebook")
    public String connectToFacebookNUC(Model model, @RequestParam("userId") String userId,
            @RequestParam("name") String name, @RequestParam("email") List<String> email,
            @RequestParam("mobile") List<String> mobile,@RequestParam("calulateScore") boolean calulateScore, HttpSession session) {
        NucUserVO nucUserVO=new NucUserVO();
        nucUserVO.setNucUserId(userId);
        nucUserVO.setNucUserName(name);
        nucUserVO.setNucUserMobile(mobile);
        nucUserVO.setNucUserEmail(email);
        //check if user is indeed from cas???
        
        //if no throw error
        
        //if yes
        NucUser nucUser=nucUserService.findNucUserByEmail(email);
        if(nucUser==null){
            nucUserService.saveNucUser(nucUserVO);
        }
        session.setAttribute("UserId", userId);
        session.setAttribute("calulateScore", calulateScore);
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }
        else{
            //if connection successful
            return "facebook_redirect_back";
        }
    }
    
    @RequestMapping("/facebook_redirect_back")
    public String redirectBack(Model model, HttpSession session) throws Exception{
        //if connection successful
        User user=facebook.userOperations().getUserProfile();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        FacebookConnection facebookConnection=new FacebookConnection();
        facebookConnection.setNucUserFacebookData(json);
        String email=user.getEmail();
        NucUser nucUser=nucUserService.findNucUserByEmail(email);
        if(nucUser!=null){
            nucUser.setNucFacebookData(facebookConnection);
            nucUserService.saveNucUser(nucUser);
            //Calculate Score
            boolean calulateScore=(boolean) session.getAttribute("calulateScore");
            if(calulateScore){
                socialCreditScore.calculateSocialCreditScore(email);
            }
            return "facebook_last_page";
        }
        else{
            return "facebook_error_page";
        }
    }

}

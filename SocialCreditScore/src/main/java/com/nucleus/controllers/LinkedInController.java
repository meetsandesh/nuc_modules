package com.nucleus.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nucleus.entity.social.media.LinkedInConnection;
import com.nucleus.entity.social.media.NucUser;
import com.nucleus.service.NucUserService;
import com.nucleus.service.social.credit.score.LinkedInCreditScoreImpl;
import com.nucleus.service.social.credit.score.SocialCreditScore;
import com.nucleus.vo.NucUserVO;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.linkedin.api.LinkedInProfileFull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LinkedInController {

    @Autowired
    private NucUserService nucUserService;
    @Autowired
    private LinkedInCreditScoreImpl socialCreditScore;
    private final ConnectionRepository connectionRepository;

    public LinkedInController(ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }

    @RequestMapping("/access/linkedIn")
    public String connectToLinkedIn(Model model, @RequestParam("userId") String userId,
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
        if (connectionRepository.findPrimaryConnection(LinkedIn.class) == null) {
            return "redirect:/connect/linkedin";
        }
        else{
            //if connection successful
            return "linkedin_redirect_back";
        }
    }
    
    @RequestMapping("/linkedin_redirect_back")
    public String redirectBack(Model model, HttpSession session) throws Exception{
        //if connection successful
        //LinkedInProfile linkedInProfile=connectionRepository.findPrimaryConnection(LinkedIn.class).getApi().profileOperations().getUserProfile();
        LinkedInProfileFull linkedInProfileFull=connectionRepository.findPrimaryConnection(LinkedIn.class).getApi().profileOperations().getUserProfileFull();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(linkedInProfileFull);
        LinkedInConnection nucLinkedInData=new LinkedInConnection();
        nucLinkedInData.setNucUserLinkedInFullData(json);
        String email=linkedInProfileFull.getEmailAddress();
        NucUser nucUser=nucUserService.findNucUserByEmail(email);
        if(nucUser!=null){
            nucUser.setNucLinkedInData(nucLinkedInData);
            nucUserService.saveNucUser(nucUser);
            //Calculate Score
            boolean calulateScore=(boolean) session.getAttribute("calulateScore");
            if(calulateScore){
                socialCreditScore.calculateSocialCreditScore(email);
            }
            return "linkedin_last_page";
        }
        else{
            return "linked_error_page";
        }
    }

}

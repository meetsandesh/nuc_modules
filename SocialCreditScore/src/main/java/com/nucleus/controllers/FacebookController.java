package com.nucleus.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nucleus.entity.social.media.FacebookConnection;
import com.nucleus.entity.social.media.NucUser;
import com.nucleus.repositories.NucUserRepository;
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
    private NucUserRepository nucUserRepository;
    private final Facebook facebook;
    private final ConnectionRepository connectionRepository;

    public FacebookController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @RequestMapping("/access/facebook")
    public String connectToFacebookNUC(Model model, @RequestParam("userId") String userId,
            @RequestParam("name") String name, @RequestParam("email") String email,
            @RequestParam("mobile") String mobile, HttpSession session) {
        //check if user is indeed from cas???
        
        //if no throw error
        
        //if yes
        NucUser nucUser=nucUserRepository.findByNucUserEmail(email);
        if(nucUser==null){
            nucUser=new NucUser();
            nucUser.setNucUserEmail(email);
            nucUser.setNucUserId(userId);
            nucUser.setNucUserMobile(mobile);
            nucUser.setNucUserName(name);
            nucUserRepository.save(nucUser);
        }
        session.setAttribute("UserEmail", email);
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
        String email=session.getAttribute("UserEmail").toString();
        NucUser nucUser=nucUserRepository.findByNucUserEmail(email);
        nucUser.setNucFacebookData(facebookConnection);
        nucUserRepository.save(nucUser);
        return "facebook_last_page";
    }

}

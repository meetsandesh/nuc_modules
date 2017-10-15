package com.nucleus.controllers;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FacebookController {

    private final Facebook facebook;
    private final ConnectionRepository connectionRepository;

    public FacebookController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @RequestMapping("/access/facebook")
    public String connectToFacebook(Model model, @RequestParam("applicationNumber") String applicationNumber,
            @RequestParam("name") String name, @RequestParam("email") String email,
            @RequestParam("mobile") String mobile) {
        //check if user is indeed from cas???
        
        //if no throw error
        
        //if yes
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }
        else{
            //if connection successful
            return "facebook_redirect_back";
        }
    }
    
    @RequestMapping("/facebook_redirect_back")
    public String redirectBack(Model model) {
        //if connection successful
        User user=facebook.userOperations().getUserProfile();
        return "facebook_last_page";
    }

}
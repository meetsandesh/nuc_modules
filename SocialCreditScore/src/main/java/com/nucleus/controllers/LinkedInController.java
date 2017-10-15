package com.nucleus.controllers;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.linkedin.api.LinkedInProfile;
import org.springframework.social.linkedin.api.LinkedInProfileFull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LinkedInController {

    private final ConnectionRepository connectionRepository;

    public LinkedInController(ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }

    @RequestMapping("/access/linkedIn")
    public String connectToLinkedIn(Model model, @RequestParam("applicationNumber") String applicationNumber,
            @RequestParam("name") String name, @RequestParam("email") String email,
            @RequestParam("mobile") String mobile) {
        //check if user is indeed from cas???
        
        //if no throw error
        
        //if yes
        if (connectionRepository.findPrimaryConnection(LinkedIn.class) == null) {
            return "redirect:/connect/linkedin";
        }
        else{
            //if connection successful
            return "linkedin_redirect_back";
        }
    }
    
    @RequestMapping("/linkedin_redirect_back")
    public String redirectBack(Model model) {
        //if connection successful
        //User user=facebook.userOperations().getUserProfile();
        LinkedInProfile linkedInProfile=connectionRepository.findPrimaryConnection(LinkedIn.class).getApi().profileOperations().getUserProfile();
        LinkedInProfileFull linkedInProfileFull=connectionRepository.findPrimaryConnection(LinkedIn.class).getApi().profileOperations().getUserProfileFull();
        return "linkedin_last_page";
    }

}

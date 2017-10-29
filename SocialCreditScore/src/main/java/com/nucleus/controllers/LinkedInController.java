package com.nucleus.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nucleus.entity.social.media.LinkedInConnection;
import com.nucleus.entity.social.media.NucUser;
import com.nucleus.repositories.NucUserRepository;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private NucUserRepository nucUserRepository;
    private final ConnectionRepository connectionRepository;

    public LinkedInController(ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }

    @RequestMapping("/access/linkedIn")
    public String connectToLinkedIn(Model model, @RequestParam("userId") String userId,
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
        String email=session.getAttribute("UserEmail").toString();
        NucUser nucUser=nucUserRepository.findByNucUserEmail(email);
        nucUser.setNucLinkedInData(nucLinkedInData);
        nucUserRepository.save(nucUser);
        return "linkedin_last_page";
    }

}

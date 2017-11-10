package com.nucleus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/config")
@Controller
public class ConfigController {

    @RequestMapping("/facebook")
    public String dashboard() {
        return "facebook_config";
    }
    
    @RequestMapping("/linkedIn")
    public String home() {
        return "linkedIn_config";
    }

}

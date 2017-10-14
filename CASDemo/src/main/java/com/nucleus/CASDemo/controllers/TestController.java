package com.nucleus.CASDemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @Value("${cas.use.social.credit.score.module}")
    private boolean socialCreditScoreModule;
    
    @RequestMapping("/welcome")
    public String welcomePage(ModelMap map) {
        map.put("socialCreditScoreModule", socialCreditScoreModule);
        return "welcome";
    }

}

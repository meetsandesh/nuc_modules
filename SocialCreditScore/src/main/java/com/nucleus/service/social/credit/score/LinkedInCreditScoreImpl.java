package com.nucleus.service.social.credit.score;

import org.springframework.stereotype.Service;

@Service
public class LinkedInCreditScoreImpl implements SocialCreditScore{

    @Override
    public void calculateSocialCreditScore(String email) {
        System.out.println("CALLED FROM LINKEDIN");
    }
    
}

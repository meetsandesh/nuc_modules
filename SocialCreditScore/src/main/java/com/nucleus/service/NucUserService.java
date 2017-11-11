package com.nucleus.service;

import com.nucleus.entity.social.media.NucUser;
import com.nucleus.vo.NucUserVO;
import java.util.List;

public interface NucUserService {
    
    public void saveNucUser(NucUserVO nucUserVO);
    
    public void saveNucUser(NucUser nucUser);
    
    public void updateNucUser(NucUser nucUser);
    
    public List<NucUser> findAllNucUser();
    
    public NucUser findNucUserByEmail(String email);
    
    public NucUser findNucUserByEmail(List<String> emailList);
    
    public NucUser findNucUserByMobile(String mobile);
    
    public NucUser findNucUserByMobile(List<String> mobileList);
    
    public NucUser findNucUserByUserName(String userName);
    
    public NucUser findNucUserByUserId(String userId);
    
}

package com.nucleus.service;

import com.google.common.collect.Lists;
import com.nucleus.entity.social.media.NucUser;
import com.nucleus.repositories.NucUserRepository;
import com.nucleus.vo.NucUserVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NucUserServiceImpl implements NucUserService {
    
    @Autowired
    private NucUserRepository nucUserRepository;

    @Override
    public void saveNucUser(NucUserVO nucUserVO) {
        NucUser nucUser=new NucUser();
        nucUser.setNucUserEmail(nucUserVO.getNucUserEmail());
        nucUser.setNucUserId(nucUserVO.getNucUserId());
        nucUser.setNucUserMobile(nucUserVO.getNucUserMobile());
        nucUser.setNucUserName(nucUserVO.getNucUserName());
        nucUserRepository.save(nucUser);
    }

    @Override
    public void saveNucUser(NucUser nucUser) {
        nucUserRepository.save(nucUser);
    }

    @Override
    public void updateNucUser(NucUser nucUser) {
        nucUserRepository.save(nucUser);
    }

    @Override
    public List<NucUser> findAllNucUser() {
        List<NucUser> list=Lists.newArrayList(nucUserRepository.findAll());
        return list;
    }

    @Override
    public NucUser findNucUserByEmail(String email) {
        List<NucUser> list=Lists.newArrayList(nucUserRepository.findAll());
        NucUser nucUser=null;
        for(NucUser nu:list){
            for(String e:nu.getNucUserEmail()){
                if(e.equalsIgnoreCase(email)){
                    nucUser=nu;
                    break;
                }
            }
            if(nucUser!=null){
                break;
            }
        }
        return nucUser;
    }
    
    @Override
    public NucUser findNucUserByEmail(List<String> emailList) {
        List<NucUser> list=Lists.newArrayList(nucUserRepository.findAll());
        NucUser nucUser=null;
        for(String email:emailList){
            for(NucUser nu:list){
                for(String e:nu.getNucUserEmail()){
                    if(e.equalsIgnoreCase(email)){
                        nucUser=nu;
                        break;
                    }
                }
                if(nucUser!=null){
                    break;
                }
            }
            if(nucUser!=null){
                break;
            }
        }
        return nucUser;
    }

    @Override
    public NucUser findNucUserByMobile(String mobile) {
        List<NucUser> list=Lists.newArrayList(nucUserRepository.findAll());
        NucUser nucUser=null;
        for(NucUser nu:list){
            for(String m:nu.getNucUserMobile()){
                if(m.equalsIgnoreCase(mobile)){
                    nucUser=nu;
                    break;
                }
            }
            if(nucUser!=null){
                break;
            }
        }
        return nucUser;
    }
    
    @Override
    public NucUser findNucUserByMobile(List<String> mobileList) {
        List<NucUser> list=Lists.newArrayList(nucUserRepository.findAll());
        NucUser nucUser=null;
        for(String mobile:mobileList){
            for(NucUser nu:list){
                for(String m:nu.getNucUserMobile()){
                    if(m.equalsIgnoreCase(mobile)){
                        nucUser=nu;
                        break;
                    }
                }
                if(nucUser!=null){
                    break;
                }
            }
            if(nucUser!=null){
                break;
            }
        }
        return nucUser;
    }

    @Override
    public NucUser findNucUserByUserName(String userName) {
        NucUser nucUser=nucUserRepository.findByNucUserName(userName);
        return nucUser;
    }

    @Override
    public NucUser findNucUserByUserId(String userId) {
        NucUser nucUser=nucUserRepository.findByNucUserId(userId);
        return nucUser;
    }

}

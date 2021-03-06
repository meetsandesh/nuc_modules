package com.nucleus.repositories;

import com.nucleus.entity.social.media.NucUser;
import org.springframework.data.repository.CrudRepository;

public interface NucUserRepository extends CrudRepository<NucUser, Long> {

    NucUser findByNucUserName(String nucUserName); 
    
    NucUser findByNucUserId(String nucUserId); 
    
}
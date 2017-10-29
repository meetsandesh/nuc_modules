package com.nucleus.entity.social.media;

import com.nucleus.entity.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name="SCSM_LINKEDIN_CONNECTION")
@Entity
@Getter 
@Setter 
@ToString
public class LinkedInConnection extends BaseEntity{

    private static final long serialVersionUID = 1L;
    
    private String nucUserLinkedInFullData;
    
}

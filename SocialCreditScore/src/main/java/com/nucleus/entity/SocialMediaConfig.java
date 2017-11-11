package com.nucleus.entity;

import com.nucleus.entity.score.parameters.ParameterCategory;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name="SCSM_SOCIAL_MEDIA_CONFIG")
@Entity
@Getter 
@Setter 
@ToString
public class SocialMediaConfig extends BaseMasterEntity{
    
    private static final long serialVersionUID = 1L;
    private String socialMediaType;
    private String clientID;
    private String clientKey;
    @OneToMany
    private List<ParameterCategory> captureFields;
    
}

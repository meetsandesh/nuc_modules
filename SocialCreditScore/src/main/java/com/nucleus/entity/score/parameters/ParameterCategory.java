package com.nucleus.entity.score.parameters;

import com.nucleus.entity.BaseMasterEntity;
import com.nucleus.others.SocialMediaType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="SCSM_PARAMETER_CATEGORY")
@Entity
public class ParameterCategory extends BaseMasterEntity{
    
    private static final long serialVersionUID = 1L;
    private SocialMediaType socialMediaType;
    private double categoryWeight;
    
}

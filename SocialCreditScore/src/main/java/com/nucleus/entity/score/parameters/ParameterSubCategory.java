package com.nucleus.entity.score.parameters;

import com.nucleus.entity.BaseMasterEntity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="SCSM_PARAMETER_SUB_CATEGORY")
@Entity
public class ParameterSubCategory extends BaseMasterEntity{
    
    private static final long serialVersionUID = 1L;
    @ManyToOne
    private ParameterCategory paramaterCategory;
    private double categoryTypeWeight;
    
}

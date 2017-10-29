package com.nucleus.entity.others;

import com.nucleus.entity.BaseMasterEntity;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="SCSM_GENERIC_PARAMETER")
@Entity
public class GenericParameter extends BaseMasterEntity{
    
    private static final long serialVersionUID = 1L;
    private String type;
    
}

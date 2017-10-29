package com.nucleus.entity;

import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter 
@Setter 
@ToString
public class BaseMasterEntity extends BaseEntity{
    
    private static final long serialVersionUID = 1L;
    private String name;
    private String code;
    private int version;
    
}

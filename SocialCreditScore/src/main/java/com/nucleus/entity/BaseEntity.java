package com.nucleus.entity;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter 
@Setter 
@ToString
public abstract class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int status = 0;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	public void setDeleted(boolean option){
		status = option == true ? 1 : 0; 
	}
	
	public boolean isDeleted(){
		return status != 0;
	}

}

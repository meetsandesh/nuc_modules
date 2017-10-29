package com.nucleus.entity.social.media;

import com.nucleus.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name="SCSM_FACEBOOK_CONNECTION")
@Entity
@Getter 
@Setter 
@ToString
public class FacebookConnection extends BaseEntity{

    private static final long serialVersionUID = 1L;
    
    @OneToOne(mappedBy = "nucFacebookData")
    private NucUser nucUser;
    @Lob
    @Column( length = 100000 )
    private String nucUserFacebookData;
    
}

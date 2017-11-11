package com.nucleus.entity.social.media;

import com.nucleus.entity.BaseEntity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Table(name="SCSM_NUC_USER")
@Entity
@Getter 
@Setter 
@ToString
public class NucUser extends BaseEntity{
    
    private static final long serialVersionUID = 1L;
    private String nucUserId;
    private String nucUserName;
    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> nucUserMobile;
    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> nucUserEmail;
    @OneToOne(cascade = {javax.persistence.CascadeType.ALL})
    @JoinColumn(name = "nuc_facebook_data_id")
    private FacebookConnection nucFacebookData;
    @Cascade(CascadeType.ALL)
    @OneToOne(fetch = FetchType.LAZY)
    private LinkedInConnection nucLinkedInData;
    
}

package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;


@Entity
@Table(name = "user_application_settings", schema = "egovcommon")

@FilterDef(name="tenancyFilter", parameters={
		@ParamDef( name="tenancyId", type="integer" )})
@Filters( {
    @Filter(name="tenancyFilter" ,condition="tenancyid = :tenancyId")})

@DataTransferObject(type = "hibernate3")
public class UserApplicationSettings implements java.io.Serializable{

	
	 @Id	
	    @Column(name="user_application_settings_id", nullable=false ,unique=true)	
	    @SequenceGenerator(name="user_application_settings_seq", sequenceName="user_application_settings_seq")
	    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="user_application_settings_seq") 
	private long userApplicationSettingsId;
	
	 @ManyToOne
		@JoinColumn(name = "user_id", nullable = false)
	private User user = new User();
	 @ManyToOne
		@JoinColumn(name = "ward_id", nullable = false)
	private WardMaster ward = null;
	 @Transient
	 @ManyToOne
		@JoinColumn(name = "collection_center_id", nullable = false)
    private CollectionCenter collectionCenter = null;
    
    public long getUserApplicationSettingsId() {
		return userApplicationSettingsId;
	}
    
    public void setUserApplicationSettingsId(long userApplicationSettingsId) {
		this.userApplicationSettingsId = userApplicationSettingsId;
	}
    
    public User getUser() {
		return user;
	}
    
    public void setUser(User user) {
		this.user = user;
	}
    public WardMaster getWard() {
		return ward;
	}

	public void setWard(WardMaster ward) {
		this.ward = ward;
	}

	public CollectionCenter getCollectionCenter() {
		return collectionCenter;
	}

	public void setCollectionCenter(CollectionCenter collectionCenter) {
		this.collectionCenter = collectionCenter;
	}
}

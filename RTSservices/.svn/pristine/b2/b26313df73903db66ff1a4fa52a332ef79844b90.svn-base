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


@Entity
@Table(name = "USER_APPLICATION", schema = "egovcommon")
public class UserApplication implements java.io.Serializable{
	
	@Id	
	@Column(name="USER_APPLICATION_ID", nullable=false ,unique=true)	
	@SequenceGenerator(name="egovcommon.USER_APPLICATION_SEQ", sequenceName="egovcommon.USER_APPLICATION_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="egovcommon.USER_APPLICATION_SEQ") 
	private long userApplicationId;
	
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
	private User user = new User();
	
	@ManyToOne
	@JoinColumn(name = "application_Id",nullable = false)
	private Application application = new Application();
	
	public long getUserApplicationId() {
		return userApplicationId;
	}
	
	public void setUserApplicationId(long userApplicationId) {
		this.userApplicationId = userApplicationId;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Application getApplication() {
		return application;
	}
	
	public void setApplication(Application application) {
		this.application = application;
	}
		
}

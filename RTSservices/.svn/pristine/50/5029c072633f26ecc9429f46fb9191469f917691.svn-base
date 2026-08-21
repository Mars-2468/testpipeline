package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "user_attempts", schema = "egovcommon")
public class UserAttempts implements java.io.Serializable
{
	@Id	
    @Column(name="user_attempts_id", nullable=false ,unique=true)	
    @SequenceGenerator(name="egovcommon.user_attempts_seq", sequenceName="egovcommon.user_attempts_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="egovcommon.user_attempts_seq") 
    private long userAttemptsId;

	@Column(name="username", nullable=false ,unique=false)
	private String userName;

	@Column(name="attempts", nullable=false)
	private int attempts;
	
	@Column(name="update_time", nullable=true)
	private String updateTime;

	public long getUserAttemptsId() {
		return userAttemptsId;
	}

	public void setUserAttemptsId(long userAttemptsId) {
		this.userAttemptsId = userAttemptsId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	
}

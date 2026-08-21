package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "APPLICATION", schema = "egovcommon")
public class Application implements java.io.Serializable{
	
	@Id	
	@Column(name="application_Id", nullable=false ,unique=true)	
	@SequenceGenerator(name="application_seq", sequenceName="application_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="application_seq") 
	private long applicationId;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "status", nullable = true)
	private int status;

	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "IMAGE_URL", nullable = false)
	private String imageUrl;
	
	@Column(name = "application_Url", nullable = false)
	private String applicationUrl;
	
	public long getApplicationId() {
		return applicationId;
	}
	
	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the applicationUrl
	 */
	public String getApplicationUrl() {
		return applicationUrl;
	}

	/**
	 * @param applicationUrl the applicationUrl to set
	 */
	public void setApplicationUrl(String applicationUrl) {
		this.applicationUrl = applicationUrl;
	}
	
}

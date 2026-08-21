package com.mars.rti.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.mars.common.model.User;
import com.mars.common.utils.CommonUtils;

@Entity
@Table(name = "inbox", schema = "egovrti")
public class Inbox implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "inbox_id", nullable = false, unique = true)
	@SequenceGenerator(name = "egovrti.Inbox_SEQ", sequenceName = "egovrti.Inbox_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egovrti.Inbox_SEQ")
	private long inboxId;
	
	@Column(name = "inward_no", nullable = true)
	private String inwardNo;
	
	@Column(name = "status", nullable = true)
	private int status;
	
	@Column(name = "created_date", nullable = false)
    private String createdDate=CommonUtils.getCurrentStringUIDate();
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rti_application_id", nullable = true)
	private RTIApplication rtiApplication;
	
	@ManyToOne
    @JoinColumn(name = "from_user_id", nullable = false)
	private User fromUser=new User();

	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
	private User user=new User();
		
	@Column(name = "active", nullable = true)
	private int active=1;
	
	@Column(name = "tenancyid", nullable = true)
	private int tenancyId;
	

	public long getInboxId() {
		return inboxId;
	}

	public void setInboxId(long inboxId) {
		this.inboxId = inboxId;
	}

	public String getInwardNo() {
		return inwardNo;
	}

	public void setInwardNo(String inwardNo) {
		this.inwardNo = inwardNo;
	}
	
	public RTIApplication getRtiApplication() {
		return rtiApplication;
	}

	public void setRtiApplication(RTIApplication rtiApplication) {
		this.rtiApplication = rtiApplication;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getTenancyId() {
		return tenancyId;
	}
	public void setTenancyId(int tenancyId) {
		this.tenancyId = tenancyId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	

	public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}
	
}

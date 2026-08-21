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
@Table(name = "outbox", schema = "egovrti")
public class Outbox implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "outbox_id", nullable = false, unique = true)
	@SequenceGenerator(name = "egovrti.Outbox_SEQ", sequenceName = "egovrti.Outbox_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egovrti.Outbox_SEQ")
	private long outboxId;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rti_application_id", nullable = true)
	private RTIApplication rtiApplication;

	@ManyToOne
    @JoinColumn(name = "created_user_id", nullable = false)
	private User createdUser=new User();

	@ManyToOne
    @JoinColumn(name = "to_user_id", nullable = false)
	private User toUser=new User();
	
	@Column(name = "created_date", nullable = true)
    private String applnForwardDate=CommonUtils.getCurrentStringUIDate();
	
	@Column(name = "outward_no", nullable = true)
	private String outwardNo;
	
	@Column(name = "status", nullable = true)
	private int status;
	
	@Column(name = "tenancyid", nullable = true)
	private int tenancyId;

	
	public RTIApplication getRtiApplication() {
		return rtiApplication;
	}

	public void setRtiApplication(RTIApplication rtiApplication) {
		this.rtiApplication = rtiApplication;
	}

	public long getOutboxId() {
		return outboxId;
	}

	public void setOutboxId(long outboxId) {
		this.outboxId = outboxId;
	}

	public User getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(User createdUser) {
		this.createdUser = createdUser;
	}

	public User getToUser() {
		return toUser;
	}

	public void setToUser(User toUser) {
		this.toUser = toUser;
	}

	public String getApplnForwardDate() {
		return applnForwardDate;
	}

	public void setApplnForwardDate(String applnForwardDate) {
		this.applnForwardDate = applnForwardDate;
	}

	public String getOutwardNo() {
		return outwardNo;
	}

	public void setOutwardNo(String outwardNo) {
		this.outwardNo = outwardNo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTenancyId() {
		return tenancyId;
	}

	public void setTenancyId(int tenancyId) {
		this.tenancyId = tenancyId;
	}

}

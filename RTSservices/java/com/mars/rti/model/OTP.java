package com.mars.rti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="otp",schema="egovrti")
public class OTP {

	@Id
	@SequenceGenerator(name = "otp_seq", sequenceName = "otp_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "otp_seq")	
	private long optid;
		
	private String time;
	
	private long mobileno;
	
	private long otp;

	public long getOptid() {
		return optid;
	}

	public void setOptid(long optid) {
		this.optid = optid;
	}


	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public long getOtp() {
		return otp;
	}

	public void setOtp(long otp) {
		this.otp = otp;
	}

	

	
	
}

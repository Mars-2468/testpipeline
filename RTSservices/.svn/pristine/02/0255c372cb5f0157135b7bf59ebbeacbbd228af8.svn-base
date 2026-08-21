package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.OTP;

public interface OTPService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public OTP merge(OTP otp);
	
	public OTP getOtpDetails(long mobileNo);
}

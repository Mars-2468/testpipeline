package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.OTPDAO;
import com.mars.rti.model.OTP;
import com.mars.rti.service.OTPService;

@Service
public class OTPServiceImpl implements OTPService{

	@Autowired
	private OTPDAO otpdao;

	@Override
	public OTP merge(OTP otp) {
		// TODO Auto-generated method stub
		return otpdao.merge(otp);
	}

	@Override
	public OTP getOtpDetails(long mobileNo) {
		// TODO Auto-generated method stub
		return otpdao.getOtpDetails(mobileNo);
	}
	
	
	
}

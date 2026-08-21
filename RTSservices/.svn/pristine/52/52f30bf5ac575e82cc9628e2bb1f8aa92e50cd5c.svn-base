package com.mars.rti.ws.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SendSMS;
import com.mars.rti.model.OTP;
import com.mars.rti.service.OTPService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.OTPAuthenticationRestDTO;

@Controller
public class OTPAuthenticationRestController {

	@Autowired
	private OTPService otpService;

	@RequestMapping(method = RequestMethod.POST, value = "/saveOtp")
	public @ResponseBody OTPAuthenticationRestDTO saveOtp(@RequestBody OTPAuthenticationRestDTO oard,
			HttpServletRequest request, HttpServletResponse response) {

		long number = 0;
		OTPAuthenticationRestDTO failed = new OTPAuthenticationRestDTO();
		OTP otp = new OTP();
		OTP getotp=null;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String requestType = null;
		boolean snotp = false;
		boolean rsotp = false;
		boolean vlotp = false;
		boolean vlvaotp = true;
		boolean request_type = false;

		try {
			if (oard != null) {
				requestType = oard.getRequestType();
				if (requestType != null && !requestType.isEmpty()) {
					if (requestType.equals("SNOTP")) {
						snotp = true;
						request_type = true;
					} else if (requestType.equals("RSOTP")) {
						rsotp = true;
						request_type = true;
					} else if (requestType.equals("VLOTP")) {
						vlotp = true;
						request_type = true;
					} else {
						request_type = false;
					}

				} else {
					request_type = false;
				}

				if (request_type) {
					if (vlotp) {
						getotp = otpService.getOtpDetails(oard.getMobileNumber());
						if (getotp != null) {

							long otp1 = oard.getOtp();
							long otp2 = getotp.getOtp();

							if (otp1 == otp2) {

								long time = checkOtpTime(dateFormat.format(date), getotp.getTime(), dateFormat);
								if (time >= 5) {
									vlvaotp = false;
								} else if(time>=0){
									vlvaotp = true;
								}else {
									vlvaotp = false;
								}

							} else {
								vlvaotp = false;
							}

						} else {

							vlvaotp = false;
						}

						if (vlvaotp) {
							oard.setOtp(getotp.getOtp());
							oard.setResponseStatus("OTP Validated Successfully");
							oard.setResponseCode("200 ok");
							oard.setResult(String.valueOf(getotp.getOtp()));
							response.setStatus(HttpStatus.OK.value());
						} else {
							oard.setResponseStatus("Incorrect OTP");
							oard.setResponseCode("500");
							response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
						}
					}

					if (snotp || rsotp) {

						number = ThreadLocalRandom.current().nextInt(100000, 1000000);
						String mobileNo = String.valueOf(oard.getMobileNumber());
						String msg = "One Time Password (OTP) for NMC application logging is " + number
								+ " Please use this OTP for logging NMCGov. Pls do not share this with any one, Valid for 5 minutes.";

						msg.replace("var3", "");
						getotp = otpService.getOtpDetails(oard.getMobileNumber());
                        if(getotp!=null) {
						// Saving OTP details
						getotp.setOtp(number);
						getotp.setTime(CommonUtils.getCurrentStringDateAndTime());
						otp = otpService.merge(getotp);
                        }else {
                        	otp.setMobileno(oard.getMobileNumber());
    						otp.setOtp(number);
    						otp.setTime(CommonUtils.getCurrentStringDateAndTime());
    						otp = otpService.merge(otp);
                        }
						if (otp != null) {
							SendSMS.sendSingleSMS("nmcgov", CoreConstants.SMS_LOGIN, "NMCGov", mobileNo, msg);
							oard.setOtp(number);
							oard.setResponseCode("200 ok");
							oard.setResult(String.valueOf(number));
							oard.setResponseStatus("OTP generated Sucessfully");
							response.setStatus(HttpStatus.OK.value());
						} else {
							oard.setResponseStatus("OTP generation failed");
							oard.setResponseCode("500");
							response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

						}

					}

				} else {
					oard.setResponseStatus("Request type is Invalid");
					oard.setResponseCode("500");
					response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				}

			} else {
				failed.setResponseStatus("Something Went Wrong");
				failed.setResponseCode("500");
				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			}

		} catch (Exception ex) {

			ex.printStackTrace();
			oard.setResult(ex.getMessage());
			oard.setResponseCode("405");
			response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());

		}
		return oard;
	}

	public long checkOtpTime(String date2, String date1, DateFormat dateFormat) {

		Date d1 = null;
		Date d2 = null;
		try {
			d1 = dateFormat.parse(date1);
			d2 = dateFormat.parse(date2);

			// in milliseconds
			long diff = d2.getTime() - d1.getTime();
			long diffMinutes = diff / (60 * 1000) % 60;

			return diffMinutes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}
}

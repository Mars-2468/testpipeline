//package com.mars.rti.controller;
//
//import java.time.Year;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//import com.mars.rti.service.RTIApplicationService;
//
//@Controller
//public class RTSApplicationNumberGenerator {
//
//	@Autowired
//	private RTIApplicationService applicationService;
//	
//	
//	
//	public String getApplicationNumber(Integer integer,String serviceCode) {
//		
//		String result = null;
//		
//		//get current year
//	      String year = String.valueOf(Year.now());
//		
//	      //get max of record
//	      
//	      long count = applicationService.getRTSApllicationListByServiceIDAndYear(integer,year);
//	      
//	      result = serviceCode+Year.now()+"/"+(count+1);
//	      
//		  return result;
//	}
//}

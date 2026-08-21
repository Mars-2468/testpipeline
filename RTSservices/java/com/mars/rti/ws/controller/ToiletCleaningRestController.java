package com.mars.rti.ws.controller;
//package com.mars.rti.controller;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.UUID;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import com.mars.rti.model.ToiletCleaningRequest;
//import com.mars.rti.model.StatueCleaning;
//import com.mars.rti.service.StatueCleaningService;
//
//
//@Controller
//@RequestMapping("/api/toilet")
//public class ToiletCleaningRestController {
//	
//
//  @Autowired
//  private StatueCleaningService statueCleaningService;
//
////  @RequestMapping(value = "/save.do", method = RequestMethod.POST)
////  @ResponseBody
////  public String saveToiletCleaning(@RequestBody ToiletCleaningRequest request) {
////
//  	@RequestMapping(
//  		    value = "/save.do",
//  		    method = RequestMethod.POST,
//  		    consumes = "application/json",
//  		    produces = "text/plain"
//  		)
//  		@ResponseBody
//  		public String saveToiletCleaning(@RequestBody ToiletCleaningRequest request) {
//      try {
//
//          StatueCleaning cleaning = new StatueCleaning();
//
//          cleaning.setStaffName(request.getStaffName());
//          cleaning.setZoneName(request.getZoneName());
//          cleaning.setZoneid(request.getZoneid());
//          cleaning.setBlockNo(request.getBlockNo());
//          cleaning.setBlockUnit(request.getBlockUnit());
//          cleaning.setShift(request.getShift());
//          cleaning.setToiletType(request.getToiletType());
//          cleaning.setToiletCondition(request.getCondition());
//          cleaning.setComments(request.getComments());
//          cleaning.setLatitude(request.getLatitude());
//          cleaning.setLongitude(request.getLongitude());
//
//          statueCleaningService.saveStatueCleaning(cleaning);
//
//          return "SUCCESS";
//
//      } catch (Exception e) {
//          e.printStackTrace();
//          return "ERROR";
//      }
//  }
//}


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mars.rti.model.StatueCleaning;
import com.mars.rti.ws.model.ToiletCleaningRequest;
import com.mars.rti.service.StatueCleaningService;

@Controller
public class ToiletCleaningRestController {

  @Autowired
  private StatueCleaningService statueCleaningService;

  @RequestMapping(method = RequestMethod.POST, value = "/saveToiletCleaning")
  public @ResponseBody String saveToiletCleaning(
          @RequestBody ToiletCleaningRequest toiletCleaningRequest,
          HttpServletRequest request,
          HttpServletResponse response)
          throws ServletException {

      try {

          StatueCleaning cleaning = new StatueCleaning();

          cleaning.setStaffName(toiletCleaningRequest.getStaffName());
          cleaning.setZoneName(toiletCleaningRequest.getZoneName());
          cleaning.setZoneid(toiletCleaningRequest.getZoneid());

          cleaning.setBlockNo(toiletCleaningRequest.getBlockNo());
          cleaning.setBlockUnit(toiletCleaningRequest.getBlockUnit());

          cleaning.setCurrentDate(toiletCleaningRequest.getCurrentDate());

          cleaning.setShift(toiletCleaningRequest.getShift());
          cleaning.setToiletType(toiletCleaningRequest.getToiletType());

          cleaning.setToiletCondition(
                  toiletCleaningRequest.getCondition());

          cleaning.setComments(
                  toiletCleaningRequest.getComments());

          cleaning.setLatitude(
                  toiletCleaningRequest.getLatitude());

          cleaning.setLongitude(
                  toiletCleaningRequest.getLongitude());

          cleaning.setBeforeImageTime(
                  toiletCleaningRequest.getBeforeImageTime());

          cleaning.setAfterImageTime(
                  toiletCleaningRequest.getAfterImageTime());

          cleaning.setFilesPath(
                  toiletCleaningRequest.getFilesPath());

          cleaning.setWorkFlowStatus(0);
          cleaning.setIsDraft("1");
          cleaning.setCreatedBy("API_USER");

          String groupId =
                  toiletCleaningRequest.getEntryGroupId();

          if (groupId == null || groupId.trim().isEmpty()) {
              groupId = UUID.randomUUID().toString();
          }

          cleaning.setEntryGroupId(groupId);

          DateTimeFormatter formatter =
                  DateTimeFormatter.ofPattern("HH:mm:ss");

          cleaning.setSavetime(
                  LocalDateTime.now().format(formatter));

          statueCleaningService.saveStatueCleaning(cleaning);

          response.setStatus(HttpStatus.OK.value());

          return "SUCCESS";

      } catch (Exception e) {

          e.printStackTrace();

          response.setStatus(
                  HttpStatus.INTERNAL_SERVER_ERROR.value());

          return "ERROR : " + e.getMessage();
      }
  }
  
  @RequestMapping(method = RequestMethod.POST,
          value = "/testToilet")
  public @ResponseBody String testToilet(
          @RequestBody String json,
          HttpServletRequest request,
          HttpServletResponse response) {

      System.out.println("JSON = " + json);

      return "SUCCESS";
  }
}

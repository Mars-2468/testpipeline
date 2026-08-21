package com.mars.rti.controller;

import com.mars.common.controller.AapleSarkarPortalIntegrationNagpur;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.rti.model.Collection;
import com.mars.rti.model.CollectionBuffer;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.payment.BOMInitiatePayment;
import com.mars.rti.payment.PaymentConstants;
import com.mars.rti.payment.BOMInitiateFirePayment;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.CollectionBufferService;
import com.mars.rti.service.CollectionService;
import com.mars.rti.service.RTIApplicationService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class CitizenController extends MultiActionController {
   private static Log log = LogFactory.getLog(CitizenController.class);
   
   String clientCode = "NMCDeptN";
	String checkSumkey = "GNGMCA8v3G7M";
	String Department = "NGMCN";
	String clientEncryptKey = "@pn@NGM@m@h@0nl!ne@30308";
	String clientEncryptIV  = "NGM@01@6";

   @Autowired
   private CollectionBufferService collectionBufferService;
   @Autowired
   private CollectionService collectionService;
   @Autowired
   public RTIApplicationService rtiApplicationService;
   
   @Autowired
	private AapleSarkarPortalIntegrationNagpur aapleSarkarPortalIntegrationNagpur;


   @RequestMapping({"ws/pay"})
   public ModelAndView pay(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
      String rtsApplicationNumber = request.getParameter("rtsNo");
      double pendingAmount = 0.0D;
      double advancedAmount = 0.0D;
      long rtiserviceid = 0L;
      if (rtsApplicationNumber != null && rtsApplicationNumber.trim().length() > 0 && !rtsApplicationNumber.isEmpty()) {
         new ArrayList();
         RTIApplicationSearch applicationSearch = new RTIApplicationSearch();
         List<RTIApplication> rtsMobileApplicationList = new ArrayList();
         if (rtsApplicationNumber != null && rtsApplicationNumber.trim().length() > 0) {
            applicationSearch.setRtiApplicationNumber(rtsApplicationNumber);
            applicationSearch.setRtiserviceid(0);
            List<RTIApplication> rtiApplicationList2 = this.rtiApplicationService.getRTIApplicationList(applicationSearch);
            if (rtiApplicationList2 == null) {
               request.setAttribute("errMessage", "Record Not Found !!");
               return new ModelAndView("manageWebPayment");
            }

            rtiserviceid = (long)((RTIApplication)rtiApplicationList2.get(0)).getRtiserviceid();
            if (((RTIApplication)rtiApplicationList2.get(0)).getRtiserviceid() == 11) {
               Collection existingCollection = this.collectionService.getCollection(((RTIApplication)rtiApplicationList2.get(0)).getRtiApplicationId());
               if (existingCollection != null && ((RTIApplication)rtiApplicationList2.get(0)).getWorkFlowStatus() == 3) {
                  if (((RTIApplication)rtiApplicationList2.get(0)).getApplicationCost() > existingCollection.getAmount()) {
                     pendingAmount = ((RTIApplication)rtiApplicationList2.get(0)).getApplicationCost() - existingCollection.getAmount();
                  } else {
                     pendingAmount = 0.0D;
                  }

                  advancedAmount = ((RTIApplication)rtiApplicationList2.get(0)).getApplicationCost() - existingCollection.getAmount();
                  request.setAttribute("pendingAmount", pendingAmount);
                  request.setAttribute("advancedAmount", existingCollection.getAmount());
                  request.setAttribute("rtiserviceid", rtiserviceid);
                  request.setAttribute("flag", true);
               }
            }

            rtsMobileApplicationList.addAll(rtiApplicationList2);
            request.getSession().setAttribute("refid", ((RTIApplication)rtiApplicationList2.get(0)).getRtiApplicationRefId());
         }

         return new ModelAndView("manageWebPayment", "rtsMobileApplicationList", rtsMobileApplicationList);
      } else {
         return new ModelAndView("manageWebPayment");
      }
   }

   @RequestMapping({"ws/rtsapplication/payment.do"})
   public void payment(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
      String applicationNumber = request.getParameter("rtiApplicationNumber");
      RTIApplicationSearch applicationSearch = new RTIApplicationSearch();
      if (applicationNumber != null && applicationNumber.trim().length() > 0) {
         applicationSearch.setRtiserviceid(0);
         applicationSearch.setRtiApplicationNumber(applicationNumber);
      }

      List<RTIApplication> rtiApplicationList = this.rtiApplicationService.getRTIApplicationList(applicationSearch);
      Long refid = (Long)request.getSession().getAttribute("refid");
      Long apprefid = ((RTIApplication)rtiApplicationList.get(0)).getRtiApplicationRefId();
      double applicationCost = 0.0D;
      
      if (!refid.equals(apprefid)) {
         throw new NullPointerException("Somthing went wrong.");
      } else {
         if (rtiApplicationList.size() > 0) {
            RTIApplication rtiApplication = (RTIApplication)rtiApplicationList.get(0);
            String applicantName = rtiApplication.getApplicantName();
            String mobileNumber = rtiApplication.getMobileNumber();
            String email = rtiApplication.getEmail();
            Integer workFlowStatus = rtiApplication.getWorkFlowStatus();
            Integer fireServiceId = rtiApplication.getRtiserviceid();

            if (workFlowStatus != 2) {
               String random = Integer.toString((new Random()).nextInt(31)) + System.currentTimeMillis() / 1000L;
               if (rtiApplication.getRtiserviceid() == 11) {
                  Collection existingCollection = this.collectionService.getCollection(rtiApplication.getRtiApplicationId());
                  if (existingCollection != null) {
                     if (rtiApplication.getApplicationCost() > existingCollection.getAmount()) {
                        applicationCost = rtiApplication.getApplicationCost() - existingCollection.getAmount();
                     } else {
                        applicationCost = 0.0D;
                     }
                  } else {
                     applicationCost = rtiApplication.getApplicationCost();
                  }
               } else {
                  applicationCost = rtiApplication.getApplicationCost();
               }

               String url = request.getParameter("url");
               HashMap<String, String> params = new HashMap();
               params.put("surl", url + "rtsapplication/printReceipt.do");
               params.put("furl", url + "rtsapplication/printReceipt.do");
               params.put("txnid", random);
               
               double originalApplicationCost = applicationCost;
               BigDecimal roundedAmount = BigDecimal.valueOf(applicationCost)
                       .setScale(0, BigDecimal.ROUND_HALF_UP);
               double roundOffAmount = roundedAmount.doubleValue() - originalApplicationCost;

               applicationCost = roundedAmount.doubleValue();   // this is the exact amount sent to the bank

//               
//               BigDecimal roundedAmount = BigDecimal.valueOf(applicationCost)
//           	        .setScale(0, BigDecimal.ROUND_HALF_UP);
//
//           	applicationCost = roundedAmount.doubleValue();

           	params.put("amount", roundedAmount.toPlainString());
           	
              
               params.put("amount", String.valueOf(applicationCost));
               params.put("firstname", applicantName != null && applicantName.trim().length() != 0 ? applicantName : "demoName");
               params.put("email", email != null && email.trim().length() != 0 ? email : "demo@gmail.com");
               params.put("phone", mobileNumber != null && mobileNumber.trim().length() != 0 ? mobileNumber : "0123456789");
               params.put("productinfo", rtiApplication.getSubject());
               log.debug(params);
               CollectionBuffer collectionBuffer = new CollectionBuffer();
               collectionBuffer.setrTIApplication(rtiApplication);
               collectionBuffer.setStatus(-1);
               
               collectionBuffer.setAmount(applicationCost);
               collectionBuffer.setBankName("Bank of Maharashtra");
               collectionBuffer.setPaymentMode("Online");
               collectionBuffer.setReceiptDate(LocalDate.now().toString());
               int randomNumber = (new Random()).nextInt(900000) + 100000;
               collectionBuffer.setReceiptNumber(String.valueOf(randomNumber));
               collectionBuffer.setUniqPgid(random);
               this.collectionBufferService.saveCollectionBuffer(collectionBuffer);
               
               
               String responseURL = "";

               if (rtiApplication.getRtiserviceid() == 69) {
            	    params.put("sub_merchant_id", PaymentConstants.Submerchant2);  //fire
            	    params.put("sub_merchant_name", PaymentConstants.Submerchant_name);  //


                   responseURL = BOMInitiateFirePayment.initiatePayment(params);

                   log.debug("Bank Response=" + responseURL);
               } else {
           	    params.put("sub_merchant_id", PaymentConstants.BOM_TEST_SUBMERCHANT_ID);  //
        	    params.put("sub_merchant_name", PaymentConstants.BOM_TEST_SUBMERCHANT_NAME);  //

                   responseURL = BOMInitiatePayment.initiatePayment(params);
                   log.debug("Bank Response=" + responseURL);
               }

               if (responseURL == null || responseURL.length() == 0) {
                   throw new NullPointerException("Something went wrong.");
               }          
                        
               response.sendRedirect(responseURL);
            }
         }

      }
   }
//
//   @RequestMapping({"ws/rtsapplication/printReceipt.do"})
//   public ModelAndView printReceipt(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
//      log.debug("Print Receipt is Trigerred");
//      ModelAndView modelAndView = new ModelAndView();
//      RTIApplication updatedRtiApplication = null;
//
//      try {
//         if (BOMInitiatePayment.compareHash(request)) {
//            String txnid = request.getParameter("txnid");
//            log.debug("Transaction=" + txnid);
//            String status = request.getParameter("status");
//            log.debug("status=" + status);
//            String refNum = request.getParameter("bank_ref_num");
//            log.debug("Reference Number=" + refNum);
//            CollectionBuffer bufferPgData = this.collectionBufferService.getBufferPgData(txnid);
//            long rtiApplicationId = bufferPgData.getrTIApplication().getRtiApplicationId();
//            RTIApplication rtiApplication = this.rtiApplicationService.get(rtiApplicationId);
//            String Dept = rtiApplication.getDepartment();
//    		long isApleSarkarApp=rtiApplication.getIsApleSarkarApp();
//
//            bufferPgData.setReferenceNumber(refNum);
//            bufferPgData.setStatus(status.equalsIgnoreCase("success") ? 2 : -1);
//            bufferPgData.setAmount(bufferPgData.getAmount());
//            log.debug("COllection Buffer Data Updating");
//            bufferPgData = this.collectionBufferService.saveCollectionbuffer(bufferPgData, txnid);
//            log.debug("COllection Buffer Dtata after Sucess=" + bufferPgData);
//            log.debug("Status=" + status);
//            if (status.equalsIgnoreCase("success")) {
//               log.debug("Success True Collection Saving");
//               Collection collection = new Collection();
//               collection.setRtiApplication(rtiApplication.getRtiApplicationId());
//               collection.setBankName(bufferPgData.getBankName());
//               collection.setReceiptDate(bufferPgData.getReceiptDate());
//               collection.setAmount(bufferPgData.getAmount());
//               collection.setPaymentMode(bufferPgData.getPaymentMode());
//               collection.setStatus(2);
//               collection.setReceiptNumber(bufferPgData.getReceiptNumber());
//               collection.setUniqPgid(bufferPgData.getUniqPgid());
//               collection.setReferenceNumber(bufferPgData.getReferenceNumber());
//               log.debug("Setting Collecton data from Collection BufferData");
//               updatedRtiApplication = this.rtiApplicationService.get(rtiApplicationId);
//               if (updatedRtiApplication.getRtiApplicationId() != 2094L && updatedRtiApplication.getRtiApplicationId() != 2130L && updatedRtiApplication.getRtiApplicationId() != 2101L && updatedRtiApplication.getRtiApplicationId() != 2126L && updatedRtiApplication.getRtiApplicationId() != 2139L && updatedRtiApplication.getRtiApplicationId() != 2177L && updatedRtiApplication.getRtiApplicationId() != 2164L && updatedRtiApplication.getRtiApplicationId() != 2270L && updatedRtiApplication.getRtiApplicationId() != 2153L) {
//                  updatedRtiApplication.setWorkFlowStatus(2);
//               } else {
//                  updatedRtiApplication.setWorkFlowStatus(1);
//               }
//
//               updatedRtiApplication.setFinalStatus("Approved");
//               Collection existingCollection = this.collectionService.getCollection(rtiApplicationId);
//               log.debug("Getting Existing Collection");
//               String user_name;
//               if (existingCollection == null || !bufferPgData.getUniqPgid().equals(existingCollection.getUniqPgid())) {
//                  log.debug("Saving RTI Applicaton Workflow Status");
//                  updatedRtiApplication = this.rtiApplicationService.merge(updatedRtiApplication);
//                  log.debug("RTI Applicaton Workflow Status is Saved");
//                  log.debug("Saving Collection");
//                  this.collectionService.saveCollection(collection);
//                  log.debug("Collection Saving has been saved");
//              	if(isApleSarkarApp==1) {
//    				String distric="NA";
//    				String trackid=rtiApplication.getAaple_user_track_id();
//    				String userid=rtiApplication.getAaple_user_id();
//    				String mobile=rtiApplication.getAapleSarkarUserMobileNo();
//    				String name=rtiApplication.getApplicantName();
//    				double amount = rtiApplication.getApplicationCost();
//    				String str="NA";
//    				
//    				String retrurnurl="";
//    				String appId=rtiApplication.getRtiApplnNumber();	
//    				appId = appId.replace("/", "");
//
//					String paymentStatus="Y";
//    				String paymentDate="NA";
//    				String digitalSignStatus="N";
//    				String digitalSignDate="NA";
//    				int estServiceDays=1;
//    				String estServiceDate="NA";
//
//    				int reqFlag=0;
//    				int appStatus=3;
//    				String remark="NA";						
//    				String serviceId= rtiApplication.getAaple_service_id();
//    				String mobileApla=rtiApplication.getMobileNumber();
//    				//retunRti.setAaple_application_id(appId);
//    			String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric,trackid,userid,mobile,name, str,serviceId,  appId,  retrurnurl, paymentStatus, paymentDate,
//    						 digitalSignStatus,digitalSignDate,estServiceDays, 
//    						 estServiceDate,amount,reqFlag,appStatus,remark,distric,mobileApla); 
//                log.debug("Aple Sarkar pushBackrespose workflow payment completed: " +pushBackrespose);
//				log.debug("data pushing to pushBackrespose : "+ " distric:"+ distric+" trackid :"+trackid+" userid :"+userid+
//						" mobile:"+mobile +" name:"+name+"str : "+str +" serviceId :"+serviceId+" appId :"+appId+ " retrurnurl:"+retrurnurl+
//						" paymentStatus :"+paymentStatus +"paymentDate :"+paymentDate+" digitalSignStatus :"+digitalSignStatus+
//						" digitalSignDate :"+digitalSignDate+" estServiceDays :"+estServiceDays +" estServiceDate :"+estServiceDate+
//						" amount :"+amount+" reqFlag :"+reqFlag+" appStatus :"+appStatus+" remark :"+remark +" distric: "+distric+" mobileApla: "+mobileApla
//				);
//              	}
//                  String phNo = rtiApplication.getPhoneNumber();
//                  user_name = rtiApplication.getRtiApplnNumber();
//                  String name = rtiApplication.getApplicantName();
//                  String link = "https://nmcnagpur.gov.in/rr";
//                 // String msg = "Dear " + name + " your payment towards " + user_name + " has been received. Please click on this link " + link + " to download the payment receipt. Regards, NMCGOV";
//                  
//                  String msg = "Dear "+name+" your payment towards "+user_name+" has been received. Please click on this link "+link+" to download the payment receipt. Regards, NMCGOV";
//                  msg.replace("var3", "");
//                  SendEmail.sendEmail(rtiApplication.getEmail(), "Payment Received Successfully" + user_name, msg);
//                  log.debug("Email Sent");
//                 // SendSMS.sendSingleSMS("1707170780469399255", "NMCGov", phNo, msg);
//                  SendSMS.sendSingleSMS("1707170780469399255", "NMCGOV", phNo, msg);
//
//                  log.debug("SMS Sent");
//                  
//                  
//
//               }
//
//               modelAndView.addObject("collection", bufferPgData);
//               modelAndView.addObject("rts", updatedRtiApplication);
//               log.debug("Payment Success Receipt Returns");
////               if (rtiApplication.getDepartment().equals("TOWN-PLANNING-DEPARTMENT") && Dept.equals("TOWN-PLANNING-DEPARTMENT")) {
////                  Object as_status = request.getSession().getAttribute("as_status");
////                  user_name = null;
////                  Object user_login = request.getSession().getAttribute("name");
////                  if (user_login != null) {
////                     user_name = (String)user_login;
////                  }
////
////                  if (as_status != null && user_name == null) {
////                     return new ModelAndView("redirect:/as/rtsapplication/newRTSSuccess.do?rtsAppNo=" + rtiApplication.getRtiApplnNumber());
////                  }
////
////                  return new ModelAndView("redirect:/ws/rtsapplication/newRtSZonecertificatesSuccess.do?rtsAppNo=" + rtiApplication.getRtiApplnNumber());
////               }
//
//               modelAndView.setViewName("paymentReceipt");
//               modelAndView.setViewName("paymentReceipt");
//            } else {
//               Map<String, String[]> parameters1 = request.getParameterMap();
//               Iterator var24 = parameters1.keySet().iterator();
//
//               while(var24.hasNext()) {
//                  String parameter = (String)var24.next();
//                  log.debug(parameter + " : " + ((String[])parameters1.get(parameter))[0].toString());
//               }
//
//               modelAndView.addObject("collection", bufferPgData);
//               modelAndView.addObject("rts", rtiApplication);
//               log.debug("Payment Failed Receipt Returns");
//               modelAndView.setViewName("paymentfailedReciept");
//            }
//         } else {
//            modelAndView.setViewName("redirect:ws/pay.do");
//         }
//      } catch (Exception var20) {
//         var20.printStackTrace();
//         var20.getMessage();
//         log.debug(var20.getMessage());
//      }
//
//      return modelAndView;
//   }
//   
  
//   @RequestMapping({"ws/rtsapplication/printReceipt.do"})
//   public ModelAndView printReceipt(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
//      log.debug("Print Receipt is Trigerred");
//      ModelAndView modelAndView = new ModelAndView();
//      RTIApplication updatedRtiApplication = null;
//
//      try {
//    	   String txnid = request.getParameter("txnid");
//           log.debug("Transaction=" + txnid);
//
//           CollectionBuffer bufferPgData = this.collectionBufferService.getBufferPgData(txnid);
//
//           RTIApplication rtiApplication = bufferPgData.getrTIApplication();
//
//           int fireServiceId = rtiApplication.getRtiserviceid(); 
//
//           boolean isValidHash;
//
//           if (fireServiceId == 69) {
//               isValidHash = BOMInitiateFirePayment.compareHash(request);
//           } else {
//               isValidHash = BOMInitiatePayment.compareHash(request);
//           }
//
//           if (isValidHash) {       	   
//           
//             String status = request.getParameter("status");
//            log.debug("status=" + status);
//            String refNum = request.getParameter("bank_ref_num");
//            log.debug("Reference Number=" + refNum);
//             bufferPgData = this.collectionBufferService.getBufferPgData(txnid);
//            long rtiApplicationId = bufferPgData.getrTIApplication().getRtiApplicationId();
//             rtiApplication = this.rtiApplicationService.get(rtiApplicationId);
//            String Dept = rtiApplication.getDepartment();
//    		long isApleSarkarApp=rtiApplication.getIsApleSarkarApp();
//
//            bufferPgData.setReferenceNumber(refNum);
//            bufferPgData.setStatus(status.equalsIgnoreCase("success") ? 2 : -1);
//            bufferPgData.setAmount(bufferPgData.getAmount());
//            log.debug("COllection Buffer Data Updating");
//            bufferPgData = this.collectionBufferService.saveCollectionbuffer(bufferPgData, txnid);
//            log.debug("COllection Buffer Dtata after Sucess=" + bufferPgData);
//            log.debug("Status=" + status);
//            if (status.equalsIgnoreCase("success")) {
//               log.debug("Success True Collection Saving");
//               Collection collection = new Collection();
//               collection.setRtiApplication(rtiApplication.getRtiApplicationId());
//               collection.setBankName(bufferPgData.getBankName());
//               collection.setReceiptDate(bufferPgData.getReceiptDate());
//               collection.setAmount(bufferPgData.getAmount());
//               collection.setPaymentMode(bufferPgData.getPaymentMode());
//               collection.setStatus(2);
//               collection.setReceiptNumber(bufferPgData.getReceiptNumber());
//               collection.setUniqPgid(bufferPgData.getUniqPgid());
//               collection.setReferenceNumber(bufferPgData.getReferenceNumber());
//               log.debug("Setting Collecton data from Collection BufferData");
//               updatedRtiApplication = this.rtiApplicationService.get(rtiApplicationId);
//               if (updatedRtiApplication.getRtiApplicationId() != 2094L && updatedRtiApplication.getRtiApplicationId() != 2130L && updatedRtiApplication.getRtiApplicationId() != 2101L && updatedRtiApplication.getRtiApplicationId() != 2126L && updatedRtiApplication.getRtiApplicationId() != 2139L && updatedRtiApplication.getRtiApplicationId() != 2177L && updatedRtiApplication.getRtiApplicationId() != 2164L && updatedRtiApplication.getRtiApplicationId() != 2270L && updatedRtiApplication.getRtiApplicationId() != 2153L) {
//                  updatedRtiApplication.setWorkFlowStatus(2);
//               } else {
//                  updatedRtiApplication.setWorkFlowStatus(1);
//               }
//
//               updatedRtiApplication.setFinalStatus("Approved");
//               Collection existingCollection = this.collectionService.getCollection(rtiApplicationId);
//               log.debug("Getting Existing Collection");
//               String user_name;
//               if (existingCollection == null || !bufferPgData.getUniqPgid().equals(existingCollection.getUniqPgid())) {
//                  log.debug("Saving RTI Applicaton Workflow Status");
//                  updatedRtiApplication = this.rtiApplicationService.merge(updatedRtiApplication);
//                  log.debug("RTI Applicaton Workflow Status is Saved");
//                  log.debug("Saving Collection");
//                  this.collectionService.saveCollection(collection);
//                  log.debug("Collection Saving has been saved");
//              	if(isApleSarkarApp==1) {
//    				String distric="NA";
//    				String trackid=rtiApplication.getAaple_user_track_id();
//    				String userid=rtiApplication.getAaple_user_id();
//    				String mobile=rtiApplication.getAapleSarkarUserMobileNo();
//    				String name=rtiApplication.getApplicantName();
//    				double amount = rtiApplication.getApplicationCost();
//    				String str="NA";
//    				
//    				String retrurnurl="";
//    				String appId=rtiApplication.getRtiApplnNumber();	
//    				appId = appId.replace("/", "");
//
//					String paymentStatus="Y";
//    				String paymentDate="NA";
//    				String digitalSignStatus="N";
//    				String digitalSignDate="NA";
//    				int estServiceDays=1;
//    				String estServiceDate="NA";
//
//    				int reqFlag=0;
//    				int appStatus=3;
//    				String remark="NA";						
//    				String serviceId= rtiApplication.getAaple_service_id();
//    				String mobileApla=rtiApplication.getMobileNumber();
//    				//retunRti.setAaple_application_id(appId);
//    			String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric,trackid,userid,mobile,name, str,serviceId,  appId,  retrurnurl, paymentStatus, paymentDate,
//    						 digitalSignStatus,digitalSignDate,estServiceDays, 
//    						 estServiceDate,amount,reqFlag,appStatus,remark,distric,mobileApla); 
//                log.debug("Aple Sarkar pushBackrespose workflow payment completed: " +pushBackrespose);
//				log.debug("data pushing to pushBackrespose : "+ " distric:"+ distric+" trackid :"+trackid+" userid :"+userid+
//						" mobile:"+mobile +" name:"+name+"str : "+str +" serviceId :"+serviceId+" appId :"+appId+ " retrurnurl:"+retrurnurl+
//						" paymentStatus :"+paymentStatus +"paymentDate :"+paymentDate+" digitalSignStatus :"+digitalSignStatus+
//						" digitalSignDate :"+digitalSignDate+" estServiceDays :"+estServiceDays +" estServiceDate :"+estServiceDate+
//						" amount :"+amount+" reqFlag :"+reqFlag+" appStatus :"+appStatus+" remark :"+remark +" distric: "+distric+" mobileApla: "+mobileApla
//				);
//              	}
//                  String phNo = rtiApplication.getPhoneNumber();
//                  user_name = rtiApplication.getRtiApplnNumber();
//                  String name = rtiApplication.getApplicantName();
//                  String link = "https://nmcnagpur.gov.in/rr";
//                 
//                  String msg = "Dear "+name+" your payment towards "+user_name+" has been received. Please click on this link "+link+" to download the payment receipt. Regards, NMCGOV";
//                  msg.replace("var3", "");
//                  SendEmail.sendEmail(rtiApplication.getEmail(), "Payment Received Successfully" + user_name, msg);
//                  log.debug("Email Sent");
//                  SendSMS.sendSingleSMS("1707170780469399255", "NMCGOV", phNo, msg);
//
//                  log.debug("SMS Sent");
//                  
//                  
//
//               }
//
//               modelAndView.addObject("collection", bufferPgData);
//               modelAndView.addObject("rts", updatedRtiApplication);
//               log.debug("Payment Success Receipt Returns");
//               modelAndView.setViewName("paymentReceipt");
//              // modelAndView.setViewName("paymentReceipt");
//            } else {
//               Map<String, String[]> parameters1 = request.getParameterMap();
//               Iterator var24 = parameters1.keySet().iterator();
//
//               while(var24.hasNext()) {
//                  String parameter = (String)var24.next();
//                  log.debug(parameter + " : " + ((String[])parameters1.get(parameter))[0].toString());
//               }
//
//               modelAndView.addObject("collection", bufferPgData);
//               modelAndView.addObject("rts", rtiApplication);
//               log.debug("Payment Failed Receipt Returns");
//               modelAndView.setViewName("paymentfailedReciept");
//            }
//         } else {
//            modelAndView.setViewName("redirect:ws/pay.do");
//         }
//      } catch (Exception var20) {
//         var20.printStackTrace();
//         var20.getMessage();
//         log.debug(var20.getMessage());
//      }
//
//      return modelAndView;
//   }
   
   @RequestMapping({"ws/rtsapplication/printReceipt.do"})
   public ModelAndView printReceipt(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
       log.debug("Print Receipt is Trigerred");
       ModelAndView modelAndView = new ModelAndView();
       RTIApplication updatedRtiApplication = null;

       try {
           String txnid = request.getParameter("txnid");
           log.debug("Transaction=" + txnid);

           CollectionBuffer bufferPgData = this.collectionBufferService.getBufferPgData(txnid);

           if (bufferPgData == null) {
               log.debug("No collection buffer found for txnid=" + txnid);
               modelAndView.setViewName("redirect:ws/pay.do");
               return modelAndView;
           }

           RTIApplication rtiApplication = bufferPgData.getrTIApplication();
           int fireServiceId = rtiApplication.getRtiserviceid();

           // --- Idempotency short-circuit: already processed by a previous/concurrent hit ---
           if (bufferPgData.getStatus() == 2) {
               log.debug("txnid=" + txnid + " already processed successfully. Skipping re-save, rendering existing receipt.");
               modelAndView.addObject("collection", bufferPgData);
               modelAndView.addObject("rts", rtiApplication);
               modelAndView.setViewName("paymentReceipt");
               return modelAndView;
           }

           boolean isValidHash;
           if (fireServiceId == 69) {
               isValidHash = BOMInitiateFirePayment.compareHash(request);
           } else {
               isValidHash = BOMInitiatePayment.compareHash(request);
           }

           if (isValidHash) {

               String status = request.getParameter("status");
               log.debug("status=" + status);
               String refNum = request.getParameter("bank_ref_num");
               log.debug("Reference Number=" + refNum);

               long rtiApplicationId = bufferPgData.getrTIApplication().getRtiApplicationId();
               rtiApplication = this.rtiApplicationService.get(rtiApplicationId);
               String Dept = rtiApplication.getDepartment();
               long isApleSarkarApp = rtiApplication.getIsApleSarkarApp();

               bufferPgData.setReferenceNumber(refNum);
               bufferPgData.setStatus(status.equalsIgnoreCase("success") ? 2 : -1);
               // Do NOT touch bufferPgData.setAmount() here — it already holds the exact amount
               // that was sent to the bank in payment(). Recomputing it from rtiApplication would be wrong.
               log.debug("Collection Buffer Data Updating");
               bufferPgData = this.collectionBufferService.saveCollectionbuffer(bufferPgData, txnid);
               log.debug("Collection Buffer Data after Sucess=" + bufferPgData);
               log.debug("Status=" + status);

               if (status.equalsIgnoreCase("success")) {
                   log.debug("Success True Collection Saving");
                   Collection collection = new Collection();
                   collection.setRtiApplication(rtiApplication.getRtiApplicationId());
                   collection.setBankName(bufferPgData.getBankName());
                   collection.setReceiptDate(bufferPgData.getReceiptDate());
                   collection.setAmount(bufferPgData.getAmount());              // actual amount paid to bank
                  // collection.setRoundOffAmount(bufferPgData.getRoundOffAmount()); // round-off delta
                   collection.setPaymentMode(bufferPgData.getPaymentMode());
                   collection.setStatus(2);
                   collection.setReceiptNumber(bufferPgData.getReceiptNumber());
                   collection.setUniqPgid(bufferPgData.getUniqPgid());
                   collection.setReferenceNumber(bufferPgData.getReferenceNumber());
                   log.debug("Setting Collecton data from Collection BufferData");

                   updatedRtiApplication = this.rtiApplicationService.get(rtiApplicationId);
                   if (updatedRtiApplication.getRtiApplicationId() != 2094L && updatedRtiApplication.getRtiApplicationId() != 2130L
                           && updatedRtiApplication.getRtiApplicationId() != 2101L && updatedRtiApplication.getRtiApplicationId() != 2126L
                           && updatedRtiApplication.getRtiApplicationId() != 2139L && updatedRtiApplication.getRtiApplicationId() != 2177L
                           && updatedRtiApplication.getRtiApplicationId() != 2164L && updatedRtiApplication.getRtiApplicationId() != 2270L
                           && updatedRtiApplication.getRtiApplicationId() != 2153L) {
                       updatedRtiApplication.setWorkFlowStatus(2);
                   } else {
                       updatedRtiApplication.setWorkFlowStatus(1);
                   }
                   updatedRtiApplication.setFinalStatus("Approved");

                   Collection existingCollection = this.collectionService.getCollection(rtiApplicationId);
                   log.debug("Getting Existing Collection");
                   String user_name;

                   if (existingCollection == null || !bufferPgData.getUniqPgid().equals(existingCollection.getUniqPgid())) {
                       boolean savedNow = false;
                       try {
                           log.debug("Saving RTI Applicaton Workflow Status");
                           updatedRtiApplication = this.rtiApplicationService.merge(updatedRtiApplication);
                           log.debug("RTI Applicaton Workflow Status is Saved");
                           log.debug("Saving Collection");
                           this.collectionService.saveCollection(collection);
                           log.debug("Collection Saving has been saved");
                           savedNow = true;
                       } catch (org.springframework.dao.DataIntegrityViolationException dup) {
                           // Another concurrent request already inserted this txnid — not an error, just a race we lost.
                           log.warn("Duplicate collection insert prevented for txnid=" + txnid, dup);
                           savedNow = false;
                       }

                       // Only run the one-time side effects (Aaple Sarkar push, email, SMS) if THIS request actually won the race.
                       if (savedNow) {
                           if (isApleSarkarApp == 1) {
                               String distric = "NA";
                               String trackid = rtiApplication.getAaple_user_track_id();
                               String userid = rtiApplication.getAaple_user_id();
                               String mobile = rtiApplication.getAapleSarkarUserMobileNo();
                               String name = rtiApplication.getApplicantName();
                               double amount = rtiApplication.getApplicationCost();
                               String str = "NA";
                               String retrurnurl = "";
                               String appId = rtiApplication.getRtiApplnNumber();
                               appId = appId.replace("/", "");
                               String paymentStatus = "Y";
                               String paymentDate = "NA";
                               String digitalSignStatus = "N";
                               String digitalSignDate = "NA";
                               int estServiceDays = 1;
                               String estServiceDate = "NA";
                               int reqFlag = 0;
                               int appStatus = 3;
                               String remark = "NA";
                               String serviceId = rtiApplication.getAaple_service_id();
                               String mobileApla = rtiApplication.getMobileNumber();

                               String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric, trackid, userid, mobile, name, str, serviceId, appId, retrurnurl, paymentStatus, paymentDate,
                                       digitalSignStatus, digitalSignDate, estServiceDays,
                                       estServiceDate, amount, reqFlag, appStatus, remark, distric, mobileApla);
                               log.debug("Aple Sarkar pushBackrespose workflow payment completed: " + pushBackrespose);
                               log.debug("data pushing to pushBackrespose : " + " distric:" + distric + " trackid :" + trackid + " userid :" + userid +
                                       " mobile:" + mobile + " name:" + name + "str : " + str + " serviceId :" + serviceId + " appId :" + appId + " retrurnurl:" + retrurnurl +
                                       " paymentStatus :" + paymentStatus + "paymentDate :" + paymentDate + " digitalSignStatus :" + digitalSignStatus +
                                       " digitalSignDate :" + digitalSignDate + " estServiceDays :" + estServiceDays + " estServiceDate :" + estServiceDate +
                                       " amount :" + amount + " reqFlag :" + reqFlag + " appStatus :" + appStatus + " remark :" + remark + " distric: " + distric + " mobileApla: " + mobileApla
                               );
                           }
                           String phNo = rtiApplication.getPhoneNumber();
                           user_name = rtiApplication.getRtiApplnNumber();
                           String name = rtiApplication.getApplicantName();
                           String link = "https://nmcnagpur.gov.in/rr";

                           String msg = "Dear " + name + " your payment towards " + user_name + " has been received. Please click on this link " + link + " to download the payment receipt. Regards, NMCGOV";
                           msg.replace("var3", "");
                           SendEmail.sendEmail(rtiApplication.getEmail(), "Payment Received Successfully" + user_name, msg);
                           log.debug("Email Sent");
                           SendSMS.sendSingleSMS("1707170780469399255", "NMCGOV", phNo, msg);
                           log.debug("SMS Sent");
                       } else {
                           // Lost the race — re-fetch whatever the winning request saved.
                           updatedRtiApplication = this.rtiApplicationService.get(rtiApplicationId);
                       }
                   }

                   modelAndView.addObject("collection", bufferPgData);
                   modelAndView.addObject("rts", updatedRtiApplication);
                   log.debug("Payment Success Receipt Returns");
                   modelAndView.setViewName("paymentReceipt");
               } else {
                   Map<String, String[]> parameters1 = request.getParameterMap();
                   Iterator var24 = parameters1.keySet().iterator();
                   while (var24.hasNext()) {
                       String parameter = (String) var24.next();
                       log.debug(parameter + " : " + ((String[]) parameters1.get(parameter))[0].toString());
                   }
                   modelAndView.addObject("collection", bufferPgData);
                   modelAndView.addObject("rts", rtiApplication);
                   log.debug("Payment Failed Receipt Returns");
                   modelAndView.setViewName("paymentfailedReciept");
               }
           } else {
               modelAndView.setViewName("redirect:ws/pay.do");
           }
       } catch (Exception var20) {
           var20.printStackTrace();
           var20.getMessage();
           log.debug(var20.getMessage());
       }

       return modelAndView;
   }
   
}


package com.mars.rti.controller;

import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.util.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SendSMSEmailController {
	
	public static String safeSubstring(String input, int maxLength) {
	    if (input == null) return "";
	    return input.length() <= maxLength ? input : input.substring(0, maxLength);
	}

   public static void sendApplicationSubmitted(String name, String mobileNo, String applnNo, String email) {
      String msg = "Dear " + safeSubstring(name, 30) + " your application with Application No. " + applnNo + " submitted successfully. Kindly Save for RTS Tracking record.Regards, NMCGOV";
      Log.debug("Application Submitted Successfully msg" + msg);
      email = email.toLowerCase();
      msg.replace("var3", "");
      SendSMS.sendSingleSMS("1707170747454278417", "NMCGOV", mobileNo, msg);
      Log.debug("Application Submitted Successfully sms sent to " + mobileNo);
      SendEmail.sendEmail(email, "Application Submitted Successfully" + applnNo, msg);
      Log.debug("Application Submitted Successfully email sent to " + email);
   }

   public static void sendPayment(String name, String mobileNo, String applnNo, String email) {
      String paymentLink = "https://nmcnagpur.gov.in/RTSservices/ws/pay.do?rtsNo=" + applnNo;
      (new StringBuilder("rtsNo=")).append(applnNo).toString();
      String msg = "Dear " + safeSubstring(name, 30) + " your document verification has been successfully completed. Kindly use this link " + paymentLink + " to make a payment in order for your application " + applnNo + " to be processed further. Regards, NMCGOV";
      Log.debug("send payment" + msg);
      email = email.toLowerCase();
      msg.replace("var3", "");
      SendEmail.sendEmail(email, "Payment link for your Appl. No." + mobileNo, msg);
      Log.debug("Application payment link email sent to " + email);
      SendSMS.sendSingleSMS("1707170780411449071", "NMCGOV", mobileNo, msg);
      Log.debug("Application payment link sms sent to " + mobileNo);
   }

   public static void sendApplicationCompleted(String name, String mobileNo, String applnNo, String email) {
      String link = "https://nmcnagpur.gov.in/rs";
      String msg = "Dear " + safeSubstring(name, 30) + " please click on this link link to download the Certificate for yourapplication " + applnNo + " Regards, NMCGOV";
      Log.debug("send application completed" + msg);
      email = email.toLowerCase();
      msg.replace("var3", "");
      SendEmail.sendEmail(email, "Completion of your Appl. No." + applnNo, msg);
      Log.debug("Application completed email sent to " + email);
      SendSMS.sendSingleSMS("1707170780433162520", "NMCGOV", mobileNo, msg);
      Log.debug("Application completed sms sent to " + mobileNo);
   }

   public static void sendApplicationRejected(String name, String mobileNo, String applnNo, String email) {
      String link = "https://nmcnagpur.gov.in/rs";
      String msg = "Dear" + safeSubstring(name, 30) + " your " + applnNo + " has been rejected due to shortfall of documents. Please use this link " + link + " to know the pending mandatory documents and track the status of your application.Regards, NMCGOV";
      email = email.toLowerCase();
      Log.debug("application rejected" + msg);
      msg.replace("var3", "");
      SendEmail.sendEmail(email, "Rejection of your Appl. No." + applnNo, msg);
      Log.debug("Application rejected email sent to " + email);
      SendSMS.sendSingleSMS("1707170780459248425", "NMCGOV", mobileNo, msg);
      Log.debug("Application rejected sms sent to " + mobileNo);
   }

   public static void sendWaterPayment(String name, String mobileNo, String applnNo, String email) {
      String msg = "Dear " + safeSubstring(name, 30) + " Your document verification has been successfully completed. Kindly make a payment to proceed with the processing of your application " + applnNo + ", Regards,NMCGOV";
      email = email.toLowerCase();
      Log.debug("send water payment" + msg);
      msg.replace("var3", "");
      SendEmail.sendEmail(email, "Payment link for your Appl. No." + mobileNo, msg);
      Log.debug("send water payment email to " + email);
      SendSMS.sendSingleSMS("1707170780487900000", "NMCGOV", mobileNo, msg);
      Log.debug("send water payment sms to" + mobileNo);
   }

   public static void sendPaymentCompleted(String name, String mobileNo, String applnNo, String email) {
      String link = "https://nmcnagpur.gov.in/rr";
      String msg = "Dear " + safeSubstring(name, 30) + " your payment towards " + applnNo + " has been received. Please click on this link " + link + " to download the payment receipt. Regards, NMCGOV";
      email = email.toLowerCase();
      Log.debug("send payment completed" + msg);
      msg.replace("var3", "");
      SendEmail.sendEmail(email, "Payment Received Successfully" + applnNo, msg);
      Log.debug("Payment completed receipt download email to" + email);
      SendSMS.sendSingleSMS("1707170780469399255", "NMCGOV", mobileNo, msg);
      Log.debug("Payment completed receipt download sms to" + mobileNo);
   }

   public static void sendMarriagePayment(String name, String mobileNo, String applnNo, String email) {
      String paymentLink = "https://nmcnagpur.gov.in/RTSservices/ws/pay.do";
      String paymentLink2 = "?rtsNo=" + applnNo;
      String msg = "Dear " + safeSubstring(name, 30) + ", your visit verification has been successfully completed. Kindly use this link " + paymentLink + paymentLink2 + ", to make a payment in order for your marriage application " + applnNo + " to be processed further. Regards, NMCGOV.";
      email = email.toLowerCase();
      Log.debug("send marriage payment" + msg);
      msg.replace("var3", "");
      SendEmail.sendEmail(email, "Payment link for your Appl. No." + mobileNo, msg);
      Log.debug("Marriage Payment link email to " + email);
      SendSMS.sendSingleSMS("1707171463128481731", "NMCGOV", mobileNo, msg);
      Log.debug("Marriage Payment link sms to " + mobileNo);
   }

   public static void sendPaymentOfPropertyTax(String name, String mobileNo, String applnNo, String email) {
      String paymentLink = "https://nmcnagpur.gov.in/";
      String paymentLink2 = "pro";
      String msg = "Dear " + safeSubstring(name, 30) + " your document verification has been successfully completed. Kindly use this link " + paymentLink + "/" + paymentLink2 + " to make a payment in order for your application " + applnNo + " to be processed further. Regards, NMCGOV";
      email = email.toLowerCase();
      Log.debug("send payment tax" + msg);
      msg.replace("var3", "");
      SendEmail.sendEmail(email, "Payment link for your Appl. No." + mobileNo, msg);
      Log.debug("Tax Payment link email to " + email);
      SendSMS.sendSingleSMS("1707171463128481731", "NMCGOV", mobileNo, msg);
      Log.debug("Tax Payment link sms to " + mobileNo);
   }

   @RequestMapping({"/sendSMSForMarriage.do"})
   public ModelAndView sendSMSForMarriage(String name, String mobileNo, String applnNo, String email) {
      try {
         String paymentLink = "https://nmcnagpur.gov.in/rp";
         String paymentLink2 = "rtsNo=" + applnNo;
         String fullPaymentLink = paymentLink + "?" + paymentLink2;
         String msg = "Dear " + safeSubstring(name, 30) + ", Please ensure that the balance amount for your marriage application " + applnNo + " is paid. The certificate will not be valid until the payment is completed. You can make the payment using the following link: " + fullPaymentLink + ". Regards, NMCGOV";
         email = email.toLowerCase();
         Log.debug("send payment" + msg);
         msg.replace("var3", "");
         SendSMS.sendSingleSMS("1707172292669346339", "NMCGOV", mobileNo, msg);
         Log.debug("Marriage Payment link sms to " + mobileNo);
         SendEmail.sendEmail(email, "Payment link for your Appl. No." + mobileNo, msg);
         Log.debug("Marriage Payment link email to " + email);
      } catch (Exception var9) {
         var9.printStackTrace();
      }

      return new ModelAndView("manageMarriageSms");
   }

   @RequestMapping({"/rtiApplication/resendMarriagePayment.do"})
   public void resendMarriagePayment(HttpServletRequest request, HttpServletResponse response) {
      try {
         String name = request.getParameter("name");
         String mobileNo = request.getParameter("mobileNo");
         String applnNo = request.getParameter("applnNo");
         String email = request.getParameter("email");
         sendMarriagePayment(name, mobileNo, applnNo, email);
         Log.debug("resend payment sms/email successfully to " + mobileNo + email);
         response.setStatus(200);
      } catch (Exception var7) {
         var7.printStackTrace();
         response.setStatus(500);
         Log.debug("resend payment sms/email failed :" + var7);
      }

   }

   @RequestMapping({"/rtiApplication/resendFirePayment.do"})
   public void resendFirePayment(HttpServletRequest request, HttpServletResponse response) {
      try {
         String name = request.getParameter("name");
         String mobileNo = request.getParameter("mobileNo");
         String applnNo = request.getParameter("applnNo");
         String email = request.getParameter("email");
         sendPayment(name, mobileNo, applnNo, email);
         Log.debug("resend payment sms/email successfully to " + mobileNo + email);
         response.setStatus(200);
      } catch (Exception var7) {
         var7.printStackTrace();
         response.setStatus(500);
         Log.debug("resend payment sms/email failed :" + var7);
      }

   }
   
   @RequestMapping({"/rtiApplication/resendDurgaPayment.do"})
   public void resendDurgaPayment(HttpServletRequest request, HttpServletResponse response) {
      try {
         String name = request.getParameter("name");
         String mobileNo = request.getParameter("mobileNo");
         String applnNo = request.getParameter("applnNo");
         String email = request.getParameter("email");
         sendPayment(name, mobileNo, applnNo, email);
         Log.debug("resend payment sms/email successfully to " + mobileNo + email);
         response.setStatus(200);
      } catch (Exception var7) {
         var7.printStackTrace();
         response.setStatus(500);
         Log.debug("resend payment sms/email failed :" + var7);
      }

   }
   
   @RequestMapping({"/rtiApplication/resendPayment.do"})
   public void resendPayment(HttpServletRequest request, HttpServletResponse response) {
      try {
         String name = request.getParameter("name");
         String mobileNo = request.getParameter("mobileNo");
         String applnNo = request.getParameter("applnNo");
         String email = request.getParameter("email");
         sendPayment(name, mobileNo, applnNo, email);
         Log.debug("resend payment sms/email successfully to " + mobileNo + email);
         response.setStatus(200);
      } catch (Exception var7) {
         var7.printStackTrace();
         response.setStatus(500);
         Log.debug("resend payment sms/email failed :" + var7);
      }

   }

}


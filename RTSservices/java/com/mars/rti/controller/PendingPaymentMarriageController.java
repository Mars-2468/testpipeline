
package com.mars.rti.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
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

import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.rti.model.Collection;
import com.mars.rti.model.CollectionBuffer;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.payment.BOMInitiatePayment;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.CollectionBufferService;
import com.mars.rti.service.CollectionService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;

@Controller
public class PendingPaymentMarriageController  extends MultiActionController {

	private static Log log = LogFactory.getLog(CitizenController.class);

	@Autowired
	private CollectionBufferService collectionBufferService;

	@Autowired
	private CollectionService collectionService;

	@Autowired
	public RTIApplicationService rtiApplicationService;

	@RequestMapping("ws/pendingPaymentMarriage.do")
	public ModelAndView pendingPaymentMarriage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		String rtsApplicationNumber = request.getParameter("rtsNo");
		double pendingAmount=0;
		double advancedAmount=0;
		if ((rtsApplicationNumber != null && rtsApplicationNumber.trim().length() > 0
				&& !rtsApplicationNumber.isEmpty())) {
			RTIApplicationSearch applicationSearch = new RTIApplicationSearch();
			List<RTIApplication> rtsMobileApplicationList = new ArrayList<RTIApplication>();
			if ((rtsApplicationNumber != null && rtsApplicationNumber.trim().length() > 0)) {
				applicationSearch.setRtiApplicationNumber(rtsApplicationNumber);
				applicationSearch.setRtiserviceid(0);
				List<RTIApplication> rtiApplicationList2 = rtiApplicationService
						.getRTIApplicationList(applicationSearch);				
				if (rtiApplicationList2 != null) {
					if(rtiApplicationList2.get(0).getWorkFlowStatus()==11) {
					advancedAmount=rtiApplicationList2.get(0).getApplicationCost();
					//getting Paid Collection
					Collection existingCollection = collectionService.getCollection(rtiApplicationList2.get(0).getRtiApplicationId());
					if(existingCollection!=null) {
						if(rtiApplicationList2.get(0).getApplicationCost()>existingCollection.getAmount())
						pendingAmount=rtiApplicationList2.get(0).getApplicationCost()-existingCollection.getAmount();
						else
							pendingAmount=0;
					}
					rtiApplicationList2.get(0).setApplicationCost(pendingAmount);
					}
					rtsMobileApplicationList.addAll(rtiApplicationList2);
					request.getSession().setAttribute("refid", rtiApplicationList2.get(0).getRtiApplicationRefId());
					request.setAttribute("advancedAmount", advancedAmount);
				}else {
					request.setAttribute("errMessage", "Record Not Found !!");
					
					return new ModelAndView("manageMarriageWebPayment");
				}
			}

			return new ModelAndView("manageMarriageWebPayment", "rtsMobileApplicationList", rtsMobileApplicationList);

		}
		return new ModelAndView("manageMarriageWebPayment");
	}

	@RequestMapping("ws/rtsapplication/marriagePayment.do")
	public void marriagePayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		String applicationNumber = request.getParameter("rtiApplicationNumber");
		RTIApplicationSearch applicationSearch = new RTIApplicationSearch();
		if (applicationNumber != null && applicationNumber.trim().length() > 0) {
			applicationSearch.setRtiserviceid(0);
			applicationSearch.setRtiApplicationNumber(applicationNumber);
		}
		List<RTIApplication> rtiApplicationList = rtiApplicationService.getRTIApplicationList(applicationSearch);
		Long refid = (long) (request.getSession().getAttribute("refid"));
		Long apprefid = rtiApplicationList.get(0).getRtiApplicationRefId();
		double applicationCost=0;
		if (refid.equals(apprefid)) {
			if (rtiApplicationList.size() > 0) {
				RTIApplication rtiApplication = rtiApplicationList.get(0);
				String applicantName = rtiApplication.getApplicantName();
				String mobileNumber = rtiApplication.getMobileNumber();
				String email = rtiApplication.getEmail();
				Integer workFlowStatus = rtiApplication.getWorkFlowStatus();
				if (workFlowStatus != 2) {
					String random = Integer.toString(new Random().nextInt(Integer.SIZE - 1))
							+ (System.currentTimeMillis() / 1000L);
                   if(rtiApplication.getRtiserviceid()==11) {
					//getting Paid Collection
					Collection existingCollection = collectionService.getCollection(rtiApplication.getRtiApplicationId());
					if(existingCollection!=null) {
						if(rtiApplication.getApplicationCost()>existingCollection.getAmount())
						 applicationCost =rtiApplication.getApplicationCost()-existingCollection.getAmount();
						else
							applicationCost=0;
					}
                   }else{
                	   applicationCost = rtiApplication.getApplicationCost();
                   }
					String url = request.getParameter("url");
					HashMap<String, String> params = new HashMap<>();
					params.put("surl", url + "rtsapplication/marriagePrintReceipt.do");
					params.put("furl", url + "rtsapplication/marriagePrintReceipt.do");
					params.put("txnid", random);
					params.put("amount", applicationCost + "");
					params.put("firstname",
							(applicantName != null && applicantName.trim().length() != 0) ? applicantName : "demoName");
					params.put("email", (email != null && email.trim().length() != 0) ? email : "demo@gmail.com");
					params.put("phone",
							(mobileNumber != null && mobileNumber.trim().length() != 0) ? mobileNumber : "0123456789");
					params.put("productinfo", rtiApplication.getSubject());
					log.debug(params);
					CollectionBuffer collectionBuffer = new CollectionBuffer();
					collectionBuffer.setrTIApplication(rtiApplication);
					collectionBuffer.setStatus(-1);
					collectionBuffer.setAmount(applicationCost);
					collectionBuffer.setBankName("Bank of Maharashtra");
					collectionBuffer.setPaymentMode("Online");
					collectionBuffer.setReceiptDate(LocalDate.now().toString());
					int randomNumber = new Random().nextInt(900000) + 100000;
					collectionBuffer.setReceiptNumber(String.valueOf(randomNumber));
					collectionBuffer.setUniqPgid(random);
					collectionBufferService.saveCollectionBuffer(collectionBuffer);
					String responseURL = BOMInitiatePayment.initiatePayment(params);
					log.debug("Bank Response="+responseURL);
					if (responseURL.length() > 0) {
						response.sendRedirect(responseURL);
					} else {
						throw new NullPointerException("Somthing went wrong.");
					}
				}
			}
		} else {
			throw new NullPointerException("Somthing went wrong.");
		}
	}

	@RequestMapping("ws/rtsapplication/marriagePrintReceipt.do")
	public ModelAndView marriagePrintReceipt(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		log.debug("Print Receipt is Trigerred");
		ModelAndView modelAndView = new ModelAndView();
		RTIApplication updatedRtiApplication = null;
		try {
		if (BOMInitiatePayment.compareHash(request)) {
			String txnid = request.getParameter("txnid");
			log.debug("Transaction="+txnid);
			String status = request.getParameter("status");
			log.debug("status="+status);
			String refNum = request.getParameter("bank_ref_num");
			log.debug("Reference Number="+refNum);
			CollectionBuffer bufferPgData = collectionBufferService.getBufferPgData(txnid);
			long rtiApplicationId = bufferPgData.getrTIApplication().getRtiApplicationId();
			RTIApplication rtiApplication = rtiApplicationService.get(rtiApplicationId);
			String Dept=rtiApplication.getDepartment();
			bufferPgData.setReferenceNumber(refNum);
			bufferPgData.setStatus(status.equalsIgnoreCase("success") ? 2 : -1);
			bufferPgData.setAmount(rtiApplication.getApplicationCost());
			log.debug("COllection Buffer Data Updating");
			bufferPgData = collectionBufferService.saveCollectionbuffer(bufferPgData, txnid);
			log.debug("COllection Buffer Dtata after Sucess="+bufferPgData);

            log.debug("Status="+status);
			if (status.equalsIgnoreCase("success")) {
				log.debug("Success True Collection Saving");
				Collection collection = new Collection();
				collection.setRtiApplication(rtiApplication.getRtiApplicationId());
				collection.setBankName(bufferPgData.getBankName());
				collection.setReceiptDate(bufferPgData.getReceiptDate());
				collection.setAmount(bufferPgData.getAmount());
				collection.setPaymentMode(bufferPgData.getPaymentMode());
				collection.setStatus(2);
				collection.setReceiptNumber(bufferPgData.getReceiptNumber());
				collection.setUniqPgid(bufferPgData.getUniqPgid());
				collection.setReferenceNumber(bufferPgData.getReferenceNumber());
				log.debug("Setting Collecton data from Collection BufferData");
				 updatedRtiApplication = rtiApplicationService.get(rtiApplicationId);
				updatedRtiApplication.setWorkFlowStatus(1);
				updatedRtiApplication.setFinalStatus(CoreConstants.RTI_FINALSTATUS_APPROVED);

				Collection existingCollection = collectionService.getCollection(rtiApplicationId);
				log.debug("Getting Existing Collection");

				if (existingCollection == null
						|| !bufferPgData.getUniqPgid().equals(existingCollection.getUniqPgid())) {
					log.debug("Saving RTI Applicaton Workflow Status");
					updatedRtiApplication = rtiApplicationService.merge(updatedRtiApplication);
					log.debug("RTI Applicaton Workflow Status is Saved");
					log.debug("Saving Collection");
					collectionService.saveCollection(collection);
					log.debug("Collection Saving has been saved");

					// Send email and SMS
					String phNo = rtiApplication.getPhoneNumber();
					String rtiApplicatonNumber = rtiApplication.getRtiApplnNumber();
					String name = rtiApplication.getApplicantName();
					String link = "https://tinyurl.com/muzmhtjv";
					String msg = "Dear " + name + " your payment towards " + rtiApplicatonNumber
							+ " has been received. Please click on this link " + link
							+ " to download the payment receipt. Regards, NMCGOV";
					msg.replace("var3", "");
					SendEmail.sendEmail(rtiApplication.getEmail(),
							"Payment Received Successfully" + rtiApplicatonNumber, msg);
					log.debug("Email Sent");
					SendSMS.sendSingleSMS(CoreConstants.SMS_PAYMENT_COMPLTED, "NMCGov", phNo, msg);
					log.debug("SMS Sent");

				}

				modelAndView.addObject("collection", bufferPgData);
				modelAndView.addObject("rts", updatedRtiApplication);
				log.debug("Payment Success Receipt Returns");
				if (!rtiApplication.getDepartment().equals("TOWN-PLANNING-DEPARTMENT") || !Dept.equals("TOWN-PLANNING-DEPARTMENT")) {
				    modelAndView.setViewName("paymentReceipt");
				} else {
					
					Object as_status=request.getSession().getAttribute("as_status");
					String user_name=null;
					Object user_login= request.getSession().getAttribute("name");
					if(user_login!=null) {
						 user_name = (String)user_login;
					}
					if(as_status!=null && user_name==null) {
						return new ModelAndView("redirect:/as/rtsapplication/newRTSSuccess.do?rtsAppNo="+rtiApplication.getRtiApplnNumber());

					}else {
					    return new ModelAndView("redirect:/ws/rtsapplication/newRtSZonecertificatesSuccess.do?rtsAppNo=" + rtiApplication.getRtiApplnNumber());
					}				}
				modelAndView.setViewName("paymentReceipt");
			} else {
				Map<String, String[]> parameters1 = request.getParameterMap();
				for (String parameter : parameters1.keySet()) {
					log.debug(parameter + " : " + parameters1.get(parameter)[0].toString());
				}
				modelAndView.addObject("collection", bufferPgData);
				modelAndView.addObject("rts", rtiApplication);
				log.debug("Payment Failed Receipt Returns");
				modelAndView.setViewName("paymentfailedReciept");
			}
		} else {
			modelAndView.setViewName("redirect:ws/pendingPaymentMarriage.do");
		}
		}catch(Exception ex){
			ex.printStackTrace();
			ex.getMessage();
			log.debug(ex.getMessage());
		}
		return modelAndView;
	}
	
	
	
}

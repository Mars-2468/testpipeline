package com.mars.rti.dwr;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mars.common.model.Section;
import com.mars.common.model.User;
import com.mars.common.search.UserSearch;
import com.mars.common.service.DocumentMasterService;
import com.mars.common.service.SectionService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SessionUser;
import com.mars.dms.service.DmsDocumentService;
import com.mars.rti.controller.PropertyTaxTokenGeneration;
import com.mars.rti.model.FeeMaster;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationNoting;
import com.mars.rti.service.FeeMasterService;
import com.mars.rti.service.RTIApplicationService;
 /**

 * <p>Title: fileCreationDaoImpl.java </p>

 * @see com.mars.common.model.FileCreate
 
 * <p>Description: This class is used for hibernate operations for FileCreate module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * 
 
 */

@RemoteProxy
public class CommonServiceDWR {
 
	 
	  @Autowired
	  private UserService  userservice;
	  
	  @Autowired
	  private DmsDocumentService dmsDocumentService;
	 
	  @Autowired
	  private DocumentMasterService documentMasterService;
	 
	  @Autowired
	  private FeeMasterService feeMasterService;
	  
	  @Autowired 
	  private SectionService sectionService;
	  
		private static Log log = LogFactory
				.getLog(PropertyTaxTokenGeneration.class);
		
	  @Autowired
	  private RTIApplicationService rtiApplicationService;

		public void setUserservice(UserService userservice) {
		this.userservice = userservice;
		}
		
		public void setDocumentMasterService(DocumentMasterService documentMasterService) {
			this.documentMasterService = documentMasterService;
		}
	
		public void setDmsDocumentService(DmsDocumentService dmsDocumentService) {
			this.dmsDocumentService = dmsDocumentService;
		}
		public void setFeeMasterService(FeeMasterService feeMasterService) {
			this.feeMasterService = feeMasterService;
		}
	
	
		@RemoteMethod
		 public List<User> getUsersOnDepartment(long departmentId){
		    	List<User> userList = null;    	
		    	try {
					userList = userservice.findByProperty("department.departmentId", departmentId);
					
					if(userList == null)
						userList = new ArrayList<User>();
					//Doing this to overcome lazy in case of DWR method call
					for (User user : userList) {
						user.getDepartment().getName();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
		    	return userList;
		 }
			
		@RemoteMethod
	    public FeeMaster getCertificateFeeAmount(String createdDate,long noOfCopies,int feeCategory) throws Exception
	    {
	    	return getCalulcatedFeeMaster(createdDate,noOfCopies,feeCategory);
	    }
	
	    private FeeMaster getCalulcatedFeeMaster (String createdDate,long noOfCopies,int feeCategory) throws Exception
	    {
	    	double amount=0;
	    	FeeMaster feeMstr=null;
	
	    	//If Application Date is empty then take Current date as Application Date
	    	if(!(createdDate.length()>0 && createdDate !=null))
	    		createdDate= CommonUtils.getCurrentStringDate();
	
	    	feeMstr = feeMasterService.getApplicationCopyFeeDetails(createdDate,feeCategory);
	
	    	/*if(feeMstr!=null){ 
		    	if(noOfCopies > 0)
		    	{
		    		amount=(noOfCopies* feeMstr.getAmountPerCopy() )+feeMstr.getAmount();
		    	}
		    	else {
		    		amount= feeMstr.getAmount();
		    	}
	
		    	feeMstr.setFeeMasterId(feeMstr.getFeeMasterId());
	    	}else{
	    		
	    		feeMstr=new FeeMaster();
	    		amount=-1;
	    	}*/
	    		
	
	    	//feeMstr.setCalcAmountForCopies(amount);;
	    	return feeMstr;
	    }		 
	    

		@RemoteMethod
		 public List<User> getUsersOnDepartment(long departmentId,long tenancyId){
		    	List<User> userList = null;    	
		    	try {
		    		UserSearch userSearch= new UserSearch();
		    		userSearch.setTenancyId(tenancyId);
		    		userSearch.setDepartmentId(departmentId);
					userList = userservice.getUserByType(userSearch);
					//userList = userservice.findByProperty("department.departmentId", departmentId);
					
					if(userList == null)
						userList = new ArrayList<User>();
					//Doing this to overcome lazy in case of DWR method call
					for (User user : userList) {
						user.getDepartment().getName();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		    	return userList;
		    }
		
		
		@RemoteMethod
		 public List<Section> getSectionsOnDepartment(long departmentId){
		    	List<Section> sectionList = null;    	
		    	try {
		    		sectionList = sectionService.findByProperty("department.departmentId", departmentId);
					
					if(sectionList == null)
						sectionList = new ArrayList<Section>();
					//Doing this to overcome lazy in case of DWR method call
					for (Section section : sectionList) {
						//section.getDepartment().getName();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		    	return sectionList;
		    }
		
		@RemoteMethod
		 public List<User> getUsersOnSection(long sectionId){
		    	List<User> userList = null;    	
		    	try {
					userList = userservice.findByProperty("section.sectionId", sectionId); 
					
					if(userList == null)
						userList = new ArrayList<User>();
					//Doing this to overcome lazy in case of DWR method call
					for (User user : userList) {
						//user.getDepartment().getName();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		    	return userList;
		    }
		@RemoteMethod
		 public List<User> getUsersOnSection(long sectionId, long tenancyId){
		    	List<User> userList = null;    	
		    	try {
		    		/*UserSearch userSearch= new UserSearch();
		    		userSearch.setTenancyId(tenancyId);
		    		userSearch.setSectionId(sectionId);
					userList = userservice.getUserByType(userSearch);*///findByProperty("section.sectionId", sectionId);		    		
		    		userList = userservice.findByProperty("section.sectionId="+sectionId+" and user.tenancy.tenancyId", tenancyId);
					if(userList == null)
						userList = new ArrayList<User>();
					//Doing this to overcome lazy in case of DWR method call
					for (User user : userList) {
						//user.getDepartment().getName();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		    	return userList;
		    }
		
		@RemoteMethod
		public String saveRTIApplicationNoting(String rtiApplicationId, String rtiApplicationDetailsId, String notingText, String notingId){
			 
			   if(notingText.equalsIgnoreCase("<div><br></div>") || notingText.equalsIgnoreCase("<div><br/></div>")){
				   return "E";
			    }
			    WebContext ctx = WebContextFactory.get();
				HttpServletRequest request = ctx.getHttpServletRequest();
				HttpSession session=request.getSession();				
		    	SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
				long userId = sessionUser.getUserId();
				User user = userservice.get(userId);
				String v= request.getParameter("notingText");
				RTIApplication rtiApplication=null;			
				/*String fileCreationId = request.getParameter("fileCreationId");
				String fileCreationDetailsId=request.getParameter("fileCreationDetailsId");	*/
				if (StringUtils.isNotEmpty(rtiApplicationId) && StringUtils.isNotEmpty(rtiApplicationDetailsId) 
						&& !rtiApplicationId.equals("0") && !rtiApplicationDetailsId.equals("0")) {		
					rtiApplication = rtiApplicationService.get(Long.parseLong(rtiApplicationId));
					if(rtiApplication != null){	
						if(user!=null && userId>0){	
							try{
								RTIApplicationNoting fileCreationNoting = new RTIApplicationNoting(); 
								//fileCreationNoting.setRtiApplication(rtiApplication);
								if(notingId!=null && notingId.length()>0){
									//fileCreationNoting.setRtiApplicationNotingId(Long.parseLong(notingId)); 
									fileCreationNoting = rtiApplicationService.getRTIApplicationNoting(Long.parseLong(notingId)) ;
								}								 
								fileCreationNoting.setNoting(notingText);						
								fileCreationNoting.setNotingDate(CommonUtils.getCurrentStringDateAndTime());
								fileCreationNoting.setNotingUser(user);
								fileCreationNoting.setStatus(1);
								fileCreationNoting.setRtiApplicationDetailsId(Long.parseLong(rtiApplicationDetailsId));								
								//rtiApplication.addRtiApplicationNoting(fileCreationNoting);									
								rtiApplicationService.save(rtiApplication);
								return "Y";
							}catch(Exception ex){
								return "N";
							}
						}			
						else{
							return "N";
						}				
					}
				}else{
					return "N";
				}
				return "N";
		 }
		public RTIApplication getRTIApplicationDetails(String rtiApplicationNumber ){
			
			String hqlQuery = "select rtiApplication from RTIApplication rtiApplication Where rtiApplication.rtiApplnNumber = '"+rtiApplicationNumber+"' ";
			List<RTIApplication>  listRTIApplication = rtiApplicationService.getListByHqlQuery(hqlQuery);
			if(listRTIApplication.isEmpty() || listRTIApplication == null || listRTIApplication.size()>0){
				return null;
			} else{
				return listRTIApplication.get(0);
			}			 
		}
		 
		
		
		@RemoteMethod
	    @RequestMapping(value = "/getepochtime", method = RequestMethod.GET)
		public static String getepochtime() {
			String token = null;
			try {
				// Date time
				Date date = new Date();
				long fastTime = date.getTime();
				DateTimeFormatter formatter = DateTimeFormatter
						.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
				String formatterDate = formatter
						.format(date.toInstant().atOffset(ZoneOffset.UTC));
				LocalDateTime dateTime = LocalDateTime.parse(formatterDate,
						formatter);
				int milliseconds = dateTime.getNano() / 1000000;

				DateTime currentDateTime = DateTime.parse(formatterDate);

						
				//ServerTime
				DateTime epochDateTime = DateTime.parse("1970-01-01T00:00:00Z");
				Duration duration = new Duration(epochDateTime, currentDateTime);
				long t1 = (long) duration.toStandardSeconds().getSeconds();
				System.out.println("Server Time: " + t1);

				long t2 = ((fastTime - milliseconds) / 1000);

				long t= t1+((t2-t1)/2);
				
				long serverTime = t-t1;
				// calculation
				long adjustedTimestamp = ((fastTime - milliseconds) / 1000)
						+ serverTime;
				if (log.isDebugEnabled()) {
					
					log.debug("Server Time: " + serverTime);
					
				}
				System.out.println("Server Time: " + adjustedTimestamp);
				String key = "4kD7s3h8E%1&";
				MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
				byte[] sha1Bytes = sha1.digest(key.getBytes());

				String data = "apiuser" + ":" + adjustedTimestamp;
				Mac hmacSha1 = Mac.getInstance("HmacSHA1");
				hmacSha1.init(new SecretKeySpec(sha1Bytes, "HmacSHA1"));
				byte[] hmacBytes = hmacSha1
						.doFinal(data.getBytes(StandardCharsets.UTF_8));
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < hmacBytes.length; i++) {
					sb.append(Integer.toString((hmacBytes[i] & 0xff) + 0x100, 16)
							.substring(1));
				}
				String sha1Hex = sb.toString();
				token = Base64.getEncoder().encodeToString(
						(sha1Hex + "|" + "apiuser" + ":" + adjustedTimestamp)
								.getBytes(StandardCharsets.UTF_8));
				System.out.println("Token = " + token);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return token;
		}
}
	  


package com.mars.rti.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.model.User;
import com.mars.common.service.TenancyService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.Draft;
import com.mars.rti.model.DraftSentThrough;
import com.mars.rti.model.DraftSentThroughDetails;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.search.DraftSearch;
import com.mars.rti.service.DraftService;
import com.mars.rti.service.RTIApplicationService;


 
@Controller
public class DraftController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(DraftController.class);

    @Autowired
    private RTIApplicationService rtiApplicationService;

    
    @Autowired
	private TenancyService tenancyService; 
    
    @Autowired
    private UserService userService; 
         
	@Autowired
	private DraftService draftService ;
	
 
	
   
	public void setTenancyService(TenancyService tenancyService) {
		this.tenancyService = tenancyService;
	}

	public void afterPropertiesSet() throws Exception
    {

    }

    /**
     * This method is to bind the date objects in the specifed format.
     *
     */
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception
    {
	SimpleDateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);
	//df.setLenient(true);
	binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(df, true));
    }
    

    
    /*@RequestMapping("draft/saveDraft.do")
    public ModelAndView saveDraft(HttpServletRequest request, HttpServletResponse response, Draft draft) throws Exception
    {
    	HttpSession session = request.getSession();
    	SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		long userId = sessionUser.getUserId();
		User user=userService.get(userId);
    	
		if (log.isDebugEnabled())
		{
			log.debug("Invoking Draft save");
		}

		String rtiApplicationId = request.getParameter("manageRTIApplicationId");
		String draftId = request.getParameter("draftId");
		RTIApplication rtiApplication =null;
		if(StringUtils.isNotEmpty(rtiApplicationId) && !rtiApplicationId.equalsIgnoreCase("0")){
			rtiApplication = rtiApplicationService.get(Long.parseLong(rtiApplicationId));
		}
		if(StringUtils.isNotEmpty(draftId) && !draftId.equalsIgnoreCase("0")){ 			
		}
		
		if (rtiApplication != null && draft!=null)
		{ 
			if (CommonTokenUtils.allowFormSubmit(request))
			{ 						
				   String[] draftModeName= request.getParameterValues("draftModeName");
				 
				   List  <DraftSentThrough> draftSentThroughList =new ArrayList<DraftSentThrough>();
				   if(draftModeName!=null){
					   for(int i=0; i<draftModeName.length; i++){
						   DraftSentThrough draftSentThrough =  new DraftSentThrough();
						   draftSentThrough.setDraft(draft);
						   draftSentThrough.setDeliveryMode(draftService.getDraftMode(Long.parseLong(draftModeName[i])));
						   draftSentThroughList.add(draftSentThrough);
						   
						   List  <DraftSentThroughDetails> draftSentThroughDetailsList =new ArrayList<DraftSentThroughDetails>();
						   String[] fieldsValue = request.getParameterValues("fields"+draftModeName[i]);
						   String[] fieldsLbl = request.getParameterValues("fieldsLbl"+draftModeName[i]);
						   String[] flieCommunicationFieldsId = request.getParameterValues("fieldsId"+draftModeName[i]);
						   
						   if(fieldsValue!=null && fieldsLbl!=null){
							   for(int j=0; j<fieldsValue.length; j++){
								   DraftSentThroughDetails draftSentThroughDetails =  new DraftSentThroughDetails();  
								   draftSentThroughDetails.setDraftSentThrough(draftSentThrough);
								   draftSentThroughDetails.setDeliveryModeFields(draftService.getDraftModeFields(Long.parseLong(flieCommunicationFieldsId[j])));
								   draftSentThroughDetails.setDraftFieldName(fieldsLbl[j]);
								   draftSentThroughDetails.setDraftFieldValue(fieldsValue[j]);								   
								   draftSentThroughDetailsList.add(draftSentThroughDetails);
								   draftSentThrough.setDraftSentThroughDetailsList(draftSentThroughDetailsList);
							   }
						   }						   	
					   }
					   draft.setDraftsSentThroughList(draftSentThroughList);					   
				   }
					 
				    
					if(draft.getDraftId()== 0 ){
						draft.setCreationDate(CommonUtils.getCurrentStringDateAndTime());	
						draft.setCreatedByUser(user);
					}
					if(draft.getTenancy()== null && sessionUser.getTenancyId()>0){
						long tenancyId = sessionUser.getTenancyId();
						draft.setTenancy(tenancyService.get(tenancyId));
					}
					  
					String sentStatus = request.getParameter("sentOrGenerateOnly");					
					if(Integer.parseInt(sentStatus) == 1){
						draft.setSentByUser(user);
						draft.setSentDate(CommonUtils.getCurrentStringDateAndTime());
					}
					
					draft.setDraftType(Integer.parseInt(request.getParameter("draftType")));
					draft.setSentStatus(Integer.parseInt(sentStatus));
					draft.setRtiApplication(rtiApplication);
					session.setAttribute("message", "Draft details saved successfully");
					draftService.save(draft);
			} 
		}
  
		return listDraft(request, response);
    }
*/    
   
    @RequestMapping("/draft/saveDraft.do")
    public ModelAndView saveDraft(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	HttpSession session = request.getSession();
    	SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		long userId = sessionUser.getUserId();
		User user=userService.get(userId);
    	
		if (log.isDebugEnabled())
		{
			log.debug("Invoking Draft save");
		}

		String rtiApplicationId = request.getParameter("manageRTIApplicationId");
		String draftId = request.getParameter("draftId");
		RTIApplication rtiApplication =null;
		Draft draft =  new Draft();
		if(StringUtils.isNotEmpty(rtiApplicationId) && !rtiApplicationId.equalsIgnoreCase("0")){
			rtiApplication = rtiApplicationService.get(Long.parseLong(rtiApplicationId));
		}
		if(StringUtils.isNotEmpty(draftId) && !draftId.equalsIgnoreCase("0")){ 	
			draft.setDraftId(Long.parseLong(draftId));
			draft.setDraftNumber(request.getParameter("draftNumber"));
			draft.setCreationDate(request.getParameter("creationDate"));
		}
				
		if (rtiApplication != null)
		{ 
			if (CommonTokenUtils.allowFormSubmit(request))
			{ 						
				
				List  <DraftSentThrough> draftSentThroughList =new ArrayList<DraftSentThrough>(); 
										
				String draftModeNameEmail = request.getParameter("draftModeNameEmail") ;
				String draftModeNameSMS = request.getParameter("draftModeNameSMS") ;
				String draftModeNamePost = request.getParameter("draftModeNamePost") ;
				if(draftModeNameEmail != null && draftModeNameEmail.length()>0 ){					
					DraftSentThrough draftSentThrough =new DraftSentThrough();				
					String emailModeId = request.getParameter("emailModeId") ;
					if(emailModeId != null && emailModeId.length()>0){
						draftSentThrough.setDraftSentThroughId(Long.parseLong(emailModeId));
					}
					draftSentThrough.setDeliveryMode(draftService.getDraftMode(Long.parseLong(draftModeNameEmail)));
					draftSentThrough.setDraft(draft);					
					draftSentThroughList.add(draftSentThrough);
					
					
					List  <DraftSentThroughDetails> draftSentThroughDetailsList =new ArrayList<DraftSentThroughDetails>();					
					
					DraftSentThroughDetails draftSentThroughDetailsTo =new DraftSentThroughDetails();	
					String emailToId = request.getParameter("emailToId") ;
					if(emailToId != null && emailToId.length()>0){
						draftSentThroughDetailsTo.setDraftSentThroughDetailsId(Long.parseLong(emailToId));
					}
					draftSentThroughDetailsTo.setDraftFieldName("To");					
					draftSentThroughDetailsTo.setDraftFieldValue(request.getParameter("to"));
					draftSentThroughDetailsTo.setDraftSentThrough(draftSentThrough);			
					draftSentThroughDetailsList.add(draftSentThroughDetailsTo);	
					
					DraftSentThroughDetails draftSentThroughDetailsCC =new DraftSentThroughDetails();	
					String emailCcId = request.getParameter("emailCcId") ;
					if(emailCcId != null && emailCcId.length()>0){
						draftSentThroughDetailsCC.setDraftSentThroughDetailsId(Long.parseLong(emailCcId));
					}
					draftSentThroughDetailsCC.setDraftFieldName("CC");
					draftSentThroughDetailsCC.setDraftFieldValue(request.getParameter("cc"));
					draftSentThroughDetailsCC.setDraftSentThrough(draftSentThrough);
					draftSentThroughDetailsList.add(draftSentThroughDetailsCC);
					
					DraftSentThroughDetails draftSentThroughDetailsSubject =new DraftSentThroughDetails();
					String emailSubjectId = request.getParameter("emailSubjectId") ;
					if(emailSubjectId != null && emailSubjectId.length()>0){
						draftSentThroughDetailsSubject.setDraftSentThroughDetailsId(Long.parseLong(emailSubjectId));
					}
					draftSentThroughDetailsSubject.setDraftFieldName("Subject");
					draftSentThroughDetailsSubject.setDraftFieldValue(request.getParameter("subject"));
					draftSentThroughDetailsSubject.setDraftSentThrough(draftSentThrough);
					draftSentThroughDetailsList.add(draftSentThroughDetailsSubject);
					
					DraftSentThroughDetails draftSentThroughDetailsContent =new DraftSentThroughDetails();
					String emailContentId = request.getParameter("emailContentId") ;
					if(emailContentId != null && emailContentId.length()>0){
						draftSentThroughDetailsContent.setDraftSentThroughDetailsId(Long.parseLong(emailContentId));
					}
					draftSentThroughDetailsContent.setDraftFieldName("Content");
					draftSentThroughDetailsContent.setDraftFieldValue(request.getParameter("content"));
					draftSentThroughDetailsContent.setDraftSentThrough(draftSentThrough);
					draftSentThroughDetailsList.add(draftSentThroughDetailsContent);
					
					draftSentThrough.setDraftSentThroughDetailsList(draftSentThroughDetailsList); 
					
				}
				if(draftModeNameSMS != null && draftModeNameSMS.length()>0 ){
					DraftSentThrough draftSentThrough =new DraftSentThrough();
					String smsModeId = request.getParameter("smsModeId") ;
					if(smsModeId != null && smsModeId.length()>0){
						draftSentThrough.setDraftSentThroughId(Long.parseLong(smsModeId));
					}
					draftSentThrough.setDeliveryMode(draftService.getDraftMode(Long.parseLong(draftModeNameSMS)));
					draftSentThrough.setDraft(draft);					
					draftSentThroughList.add(draftSentThrough);
					   
					List  <DraftSentThroughDetails> draftSentThroughDetailsListSMS =new ArrayList<DraftSentThroughDetails>();					
					
					DraftSentThroughDetails draftSentThroughDetailsMobile =new DraftSentThroughDetails();		
					String mobileNumberId = request.getParameter("mobileNumberId") ;
					if(mobileNumberId != null && mobileNumberId.length()>0){
						draftSentThroughDetailsMobile.setDraftSentThroughDetailsId(Long.parseLong(mobileNumberId));
					}
					draftSentThroughDetailsMobile.setDraftFieldName("Mobile Number");
					draftSentThroughDetailsMobile.setDraftFieldValue(request.getParameter("mobileNumber"));
					draftSentThroughDetailsMobile.setDraftSentThrough(draftSentThrough);
					draftSentThroughDetailsListSMS.add(draftSentThroughDetailsMobile);					
					 
					
					DraftSentThroughDetails draftSentThroughDetailsText =new DraftSentThroughDetails();	
					String textMessageId = request.getParameter("textMessageId") ;
					if(textMessageId != null && textMessageId.length()>0){
						draftSentThroughDetailsText.setDraftSentThroughDetailsId(Long.parseLong(textMessageId));
					}
					draftSentThroughDetailsText.setDraftFieldName("Text Message");
					draftSentThroughDetailsText.setDraftFieldValue(request.getParameter("textMessage"));
					draftSentThroughDetailsText.setDraftSentThrough(draftSentThrough);
					draftSentThroughDetailsListSMS.add(draftSentThroughDetailsText);					
					
					draftSentThrough.setDraftSentThroughDetailsList(draftSentThroughDetailsListSMS);
									
				}
				if(draftModeNamePost != null && draftModeNamePost.length()>0 ){
					DraftSentThrough draftSentThrough =new DraftSentThrough();
					String postModeId = request.getParameter("postModeId") ;
					if(postModeId != null && postModeId.length()>0){
						draftSentThrough.setDraftSentThroughId(Long.parseLong(postModeId));
					}
					draftSentThrough.setDeliveryMode(draftService.getDraftMode(Long.parseLong(draftModeNamePost)));
					draftSentThrough.setDraft(draft);					
					draftSentThroughList.add(draftSentThrough);
					   
					List  <DraftSentThroughDetails> draftSentThroughDetailsListPost =new ArrayList<DraftSentThroughDetails>();					
					
					DraftSentThroughDetails draftSentThroughDetailsAddress =new DraftSentThroughDetails();	
					String postalAddressId = request.getParameter("postalAddressId") ;
					if(postalAddressId != null && postalAddressId.length()>0){
						draftSentThroughDetailsAddress.setDraftSentThroughDetailsId(Long.parseLong(postalAddressId));
					}
					draftSentThroughDetailsAddress.setDraftFieldName("Postal Address");
					draftSentThroughDetailsAddress.setDraftFieldValue(request.getParameter("postalAddress"));
					draftSentThroughDetailsAddress.setDraftSentThrough(draftSentThrough);
					draftSentThroughDetailsListPost.add(draftSentThroughDetailsAddress);					
					  
					draftSentThrough.setDraftSentThroughDetailsList(draftSentThroughDetailsListPost);
							
				}
				draft.setDraftsSentThroughList(draftSentThroughList);				    
				if(draft.getDraftId()== 0 ){
					draft.setCreationDate(CommonUtils.getCurrentStringDateAndTime());	
					draft.setCreatedByUser(user);
				}
				if(draft.getTenancy()== null && sessionUser.getTenancyId()>0){
					long tenancyId = sessionUser.getTenancyId();
					draft.setTenancy(tenancyService.get(tenancyId));
				}
				  
				String sentStatus = request.getParameter("sentOrGenerateOnly");					
				if(Integer.parseInt(sentStatus) == 1){
					draft.setSentByUser(user);
					draft.setSentDate(CommonUtils.getCurrentStringDateAndTime());
				}
				
				draft.setDraftType(draftService.getDraftTypeById(Integer.parseInt(request.getParameter("draftType"))));
				draft.setDraftContent(request.getParameter("draftContent"));
				
				draft.setSentStatus(Integer.parseInt(sentStatus));
				draft.setRtiApplication(rtiApplication);
				session.setAttribute("message", "Draft details saved successfully");
				draftService.save(draft);
			} 
		}
  
		return listDraft(request, response);
    }

    
    @RequestMapping("/draft/editDraft.do")
    public ModelAndView editDraft(HttpServletRequest request, HttpServletResponse response) throws ServletException  {
		if (log.isDebugEnabled())
		{
		    log.debug("Invoking editDraft");
		}
				
		 HttpSession session = request.getSession();
		 SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
		 RTIApplication rtiApplication = null;
		 Draft draft =null;
		 		
		 String draftId = request.getParameter("draftId");
		 String rtiApplicationId  = null;	   
		 
		if (StringUtils.isNotEmpty(draftId))
		{
			draft = draftService.get(Long.parseLong(draftId));
			rtiApplication =  draft.getRtiApplication();	 
			rtiApplicationId = rtiApplication.getRtiApplicationId()+"";
		} else
		{
			draft = new Draft();
			rtiApplicationId = request.getParameter("manageRTIApplicationId");
			rtiApplication =  rtiApplicationService.get(Long.parseLong(rtiApplicationId));
		}
		 		
		request.setAttribute("manageRTIApplicationId", rtiApplicationId); 
		request.setAttribute("deliveryModeList", draftService.getDraftModeList()); 	
		request.setAttribute("draftTypeList", draftService.getAllDraftType()); 	
		request.setAttribute("rtiApplication", rtiApplication); 
		CommonTokenUtils.setNewToken(request); 
		
		return new ModelAndView("createDraft", "draft", draft);			
	}
    
    @RequestMapping("/draft/viewDraft.do")
    public ModelAndView viewDraft(HttpServletRequest request, HttpServletResponse response) throws ServletException  {
		if (log.isDebugEnabled())
		{
		    log.debug("Invoking viewSentDraft");
		}
		
		 HttpSession session = request.getSession();
		 SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
		 RTIApplication rtiApplication = null;
		 Draft draft =null;
		 
		
		 String draftId = request.getParameter("draftId");
		 String rtiApplicationId  = null;
	 
		 
		if (StringUtils.isNotEmpty(draftId))
		{
			draft = draftService.get(Long.parseLong(draftId));
			rtiApplication =  draft.getRtiApplication(); 
			rtiApplicationId = rtiApplication.getRtiApplicationId()+"";
		} else
		{
			listDraft(request, response);
		}
		 
		
		request.setAttribute("manageRTIApplicationId", rtiApplicationId); 
		request.setAttribute("deliveryModeList", draftService.getDraftModeList()); 
		request.setAttribute("draftTypeList", draftService.getAllDraftType()); 	
		
		request.setAttribute("rtiApplication", rtiApplication); 	
		
		
		CommonTokenUtils.setNewToken(request); 
		
		return new ModelAndView("viewDraft", "draft", draft);
	}
    
 
    @RequestMapping("/draft/listDraft.do")
    public ModelAndView listDraft(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listDraft");
		}
		HttpSession session = request.getSession();
    	SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		long tenancyId=sessionUser.getTenancyId();
		
		    DraftSearch searchOptions=new DraftSearch();
		    searchOptions.setTenancyId(tenancyId);
		    setSearchParameters(searchOptions, request); 
		    

		    List<Draft> draftList = draftService.getDraftListBySearch(searchOptions);
			try
			{
				long totalCount = draftService.getDraftCountBySearch(searchOptions);
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			
 	
		if(draftList==null){
			draftList = new ArrayList<Draft>();	
		}
		
		 User  user= userService.get(sessionUser.getUserId());
		
		 request.setAttribute("user",user);
			request.setAttribute("currentPage", searchOptions.getCurrentPage());
			request.setAttribute(const_OrderBy, searchOptions.getOrderBy());
			request.setAttribute(const_SortBy, searchOptions.getSortBy());
			request.setAttribute("SearchOptions", searchOptions);
			
		return new ModelAndView("listDraft","draftList",draftList);
    }
     
    private void setSearchParameters(DraftSearch searchOptions, HttpServletRequest request){
    	if(log.isDebugEnabled()){
    		log.debug("setSearchParameters Method is called");
    	}
    	
    	try{
    		long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
			String orderBy = request.getParameter(const_OrderBy);
			String sortBy = request.getParameter(const_SortBy);	
			 
			if (orderBy == null || orderBy.length() < 1) {
				orderBy = "draftNumber";
				sortBy = "desc";
			}
			 
			searchOptions.setCurrentPage(longCurrentPage);
			searchOptions.setOrderBy(orderBy);
			searchOptions.setSortBy(sortBy);
			
			searchOptions.setDraftNumber(request.getParameter("draftNumber"));
			searchOptions.setCreationDate(request.getParameter("creationDate"));
			searchOptions.setSentDate(request.getParameter("sentDate"));
			
			searchOptions.setSubject(request.getParameter("subject"));
			
			if(request.getParameter("sentStatus")!=null && !request.getParameter("sentStatus").equals(""))
				searchOptions.setSentStatus(Integer.parseInt(request.getParameter("sentStatus")));
			else{
				searchOptions.setSentStatus(null);
			}
			
			 
			
    	}catch(Exception err){
    		log.error(err.getMessage());
    	}
    }
    
  
 
}

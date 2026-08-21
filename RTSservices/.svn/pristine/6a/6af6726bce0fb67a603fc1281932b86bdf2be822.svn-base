package com.mars.rti.controller;

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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.Inbox;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.search.InboxSearch;
import com.mars.rti.service.InboxService;
import com.mars.rti.service.InwardNumGenarationService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;

@Controller
public class InboxController extends MultiActionController implements InitializingBean
{

	private static String const_OrderBy = "OrderBy";

	private static String const_SortBy = "SortBy";

	private static Log log = LogFactory.getLog(InboxController.class);
	   
    @Autowired
    private InboxService inboxService;
    
    @Autowired
    private  RTIApplicationService rtiApplicationService;
    
    @Autowired
    private InwardNumGenarationService inwardNumGenarationService;


	public void setInwardNumGenarationService(InwardNumGenarationService inwardNumGenarationService) {
		this.inwardNumGenarationService = inwardNumGenarationService;
	}
    
	public void setRtiApplicationService(RTIApplicationService rtiApplicationService) {
		this.rtiApplicationService = rtiApplicationService;
	}

	public void setInboxService(InboxService inboxService) {
		this.inboxService = inboxService;
	}
	
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

	    
	@RequestMapping("/inbox/listInbox.do")
	public ModelAndView listInbox(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
		List<Inbox> inboxList=null;
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listInbox");
		}
		try{
			HttpSession session = request.getSession();
	    	SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
			long userId = sessionUser.getUserId();
			InboxSearch searchInbox=new InboxSearch();
			searchInbox.setUserId(userId);
			setSearchParameters(searchInbox, request);
			inboxList=inboxService.getInboxListBySearch(searchInbox);
						
			long totalCount = inboxService.getInboxCountBySearch(searchInbox);
		    request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		    request.setAttribute("totalCount", totalCount);
			
			request.setAttribute("currentPage", searchInbox.getCurrentPage());
			request.setAttribute(const_OrderBy, searchInbox.getOrderBy());
			request.setAttribute(const_SortBy, searchInbox.getSortBy());	
			request.setAttribute("SearchInbox", searchInbox);
			if (inboxList == null) {
				inboxList = new ArrayList<Inbox>();
			}
			request.setAttribute("inboxList", inboxList.size());
			
		}catch(Exception e){
			e.printStackTrace();
			log.error(e);
			
		}
		return new ModelAndView("listInbox","inboxList",inboxList);
    }
	    
	private void setSearchParameters(InboxSearch searchOptions, HttpServletRequest request) {
		if(log.isDebugEnabled()){
    		log.debug("setSearchParameters Method is called");
    	}
    	long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
		String orderBy = request.getParameter(const_OrderBy);
		String sortBy = request.getParameter(const_SortBy);	
    	
    	// setting default order by on userName
    	if (orderBy == null || orderBy.length() < 1) {
    		orderBy = "inbox.inboxId";
    	    sortBy = "desc";
    	}
		
    	try {
			searchOptions.setCurrentPage(longCurrentPage);
			searchOptions.setOrderBy(orderBy);
			searchOptions.setSortBy(sortBy);							
		
			String application=request.getParameter("searchApplication");
			searchOptions.setApplication(application);
						
		} catch(Exception err) {
			log.error(err.getMessage());
		}
    }

		
    @RequestMapping("/inbox/acceptFile.do")
    public ModelAndView acceptFile(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
		if (log.isDebugEnabled())
		{
		    log.debug("Invoking acceptFile");
		}

		Inbox inbox = null;
		String inboxId = request.getParameter("inboxId");
		long rtiApplicationId=0; 
		long userId=0;
		RTIApplication rtiApplication =null;
		if (StringUtils.isNotEmpty(inboxId))
		{
			inbox= inboxService.get(Long.parseLong(inboxId));
			inbox.setStatus(CoreConstants.RTI_STATUS_ACCEPTED);
			inboxService.merge(inbox);
			
			rtiApplicationId=inbox.getRtiApplication().getRtiApplicationId();
			
			if(rtiApplicationId >0)
			{
				rtiApplication=rtiApplicationService.get(rtiApplicationId);
	 						
				userId=inbox.getUser().getUserId();
				RTIApplicationDetails rtiApplicationDetails=new RTIApplicationDetails();
				//rtiApplicationDetails.setUserId(userId);
				rtiApplicationDetails.setStatus(CoreConstants.RTI_STATUS_ACCEPTED);
			//	rtiApplication.addRtiApplicationDetails(rtiApplicationDetails);
				rtiApplicationService.save(rtiApplication);
			}
		
		} 
		return listInbox(request, response);
	}

}

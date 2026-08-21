package com.mars.rti.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.Outbox;
import com.mars.rti.search.OutboxSearch;
import com.mars.rti.service.OutboxService;
import com.mars.rti.service.RTIApplicationService;

@Controller
public class OutboxController extends MultiActionController implements InitializingBean{

	private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(OutboxController.class);
   
    @Autowired
    private OutboxService outboxService;
    
    @Autowired
    private  RTIApplicationService rtiApplicationService;
    
    
    public void setOutboxService(OutboxService outboxService) {
		this.outboxService = outboxService;
	}

    public void setRtiApplicationService(RTIApplicationService rtiApplicationService) {
		this.rtiApplicationService = rtiApplicationService;
	}
	    

	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception
    {
	SimpleDateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);
	df.setLenient(true);
	binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(df, true));
    }
    
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
	    
    @RequestMapping("/outbox/listOutbox.do")
	public ModelAndView listOutbox(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
		List<Outbox> outboxList=null;
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listOutbox");
		}
		try{
			HttpSession session = request.getSession();
	    	SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
			long userId = sessionUser.getUserId();
			OutboxSearch searchOutbox=new OutboxSearch();
			searchOutbox.setUserId(userId);
			setSearchParameters(searchOutbox, request);
			outboxList=outboxService.getOutboxListBySearch(searchOutbox);
			
			long totalCount = outboxService.getOutboxCountBySearch(searchOutbox);
		    request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		    request.setAttribute("totalCount", totalCount);

			request.setAttribute("currentPage", searchOutbox.getCurrentPage());
			request.setAttribute(const_OrderBy, searchOutbox.getOrderBy());
			request.setAttribute(const_SortBy, searchOutbox.getSortBy());	
			request.setAttribute("SearchOutbox", searchOutbox);
			if (outboxList == null) {
				outboxList = new ArrayList<Outbox>();
			}
			request.setAttribute("outboxList", outboxList.size());
			
		}catch(Exception e){
			e.printStackTrace();
			log.error(e);
			
		}
		return new ModelAndView("listOutbox","outboxList",outboxList);
    }
    
	private void setSearchParameters(OutboxSearch searchOptions, HttpServletRequest request) {
    	long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
		String orderBy = request.getParameter(const_OrderBy);
		String sortBy = request.getParameter(const_SortBy);	
    	
    	// setting default order by on userName
    	if (orderBy == null || orderBy.length() < 1) {
    		orderBy = "outbox.outboxId";
    	    sortBy = "desc";
    	}
		
    	try {
			searchOptions.setCurrentPage(longCurrentPage);
			searchOptions.setOrderBy(orderBy);
			searchOptions.setSortBy(sortBy);							
		
			String searchApplication = request.getParameter("searchApplication");
			searchOptions.setApplication(searchApplication);
								
		} catch(Exception err) {
			log.error(err.getMessage());
		}
    }
		
}

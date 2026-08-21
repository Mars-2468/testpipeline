package com.mars.rti.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.Collection;
import com.mars.rti.model.CollectionBuffer;
import com.mars.rti.model.EasebuzzWebhook;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.CollectionBufferService;
import com.mars.rti.service.CollectionService;
import com.mars.rti.service.EasebuzzWebhookService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;

import de.odysseus.el.tree.impl.Parser.ParseException;

@Controller
public class FailedPaymentController {
	
	private static Log log = LogFactory.getLog(FailedPaymentController.class);


	private static String const_OrderBy = "OrderBy";

	private static String const_SortBy = "SortBy";
	
	@Autowired
	private CollectionService collectionService;
	
	@Autowired
	private EasebuzzWebhookService  eazebuzzService;
	
	@Autowired
	private CollectionBufferService collectionBufferService;
	
	@Autowired
	private RTIApplicationService rTIApplicationService;
	
	
	@RequestMapping("/rtsapplication/failedCollectionEdit.do")
	public ModelAndView failedCollectionEdit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			ParseException{
		
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		if(sessionUser!=null) {
		if (log.isDebugEnabled()) {
			log.debug("Invoking getFaileCollectionList");
		}
		
		long longCurrentPage = CommonUtils
				.checkPaginationAttributes(request);
		StringBuilder sqlQuery = new StringBuilder();
		StringBuilder sqlQuery1 = new StringBuilder();

		sqlQuery.append( " " );
		
		RTIApplicationSearch applicationSearch = new RTIApplicationSearch();

		setSearchParameters(applicationSearch, request);
			
			sqlQuery.append("select * from egovrti.collection_buffer cb,egovrti.easebuzzwebhook e ,egovrti.rti_application ra where"+" "
					+ "e.txnid = cb.uniq_pg_id and cb.rti_application_id = ra.rti_application_id and e.status ='success' and ra.workflow_status in (3, -1)");
			sqlQuery1.append("select count(*) from egovrti.collection_buffer cb,egovrti.easebuzzwebhook e ,egovrti.rti_application ra where"+" "
					+ "e.txnid = cb.uniq_pg_id and cb.rti_application_id = ra.rti_application_id and e.status ='success' and ra.workflow_status in (3, -1)");
		
		List<CollectionBuffer> allFailedCollections=null;
		allFailedCollections = collectionService.getAllFailedCollections(sqlQuery.toString(),longCurrentPage,applicationSearch);
		long totalCount = collectionService.getAllFailedCollectionsCount(sqlQuery1.toString(),longCurrentPage,applicationSearch);
   request.setAttribute("totalCount", totalCount);
	/*	request.setAttribute("fromDate", fromDate);
		request.setAttribute("toDate", toDate);*/
	request.setAttribute("currentPage", longCurrentPage);
	request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("failedCollectionEdit");
		
			modelAndView.addObject("list", allFailedCollections);
		
		
		
		return modelAndView;
	}
	
	return new ModelAndView("redirect:/login.do");
	}
	
	
	private void setSearchParameters(RTIApplicationSearch searchFileCreate,
			HttpServletRequest request) {
		if (log.isDebugEnabled()) {
			log.debug("setSearchParameters Method is called");
		}

		try {
			long longCurrentPage = CommonUtils
					.checkPaginationAttributes(request);
			String orderBy = request.getParameter(const_OrderBy);
			String sortBy = request.getParameter(const_SortBy);

			// setting default order by on fileCreateId
			if (orderBy == null || orderBy.length() < 1) {
				orderBy = "rtiApplicationId";
				sortBy = "desc";
			}

			searchFileCreate.setCurrentPage(longCurrentPage);
			searchFileCreate.setOrderBy(orderBy);
			searchFileCreate.setSortBy(sortBy);

			searchFileCreate.setRtiApplicationNumber(
					request.getParameter("searchrtiApplnNumber"));
			searchFileCreate.setSubject(request.getParameter("subject"));
			searchFileCreate.setCreationToDate(request.getParameter("toDate"));
			searchFileCreate
					.setCreationFromDate(request.getParameter("fromDate"));

			if (request.getParameter("rtiAplicationReceivedDepartment") != null
					&& !request.getParameter("rtiAplicationReceivedDepartment")
							.equals("")) {
				searchFileCreate.setRtiAplicationReceivedDepartment(
						Long.parseLong(request.getParameter(
								"rtiAplicationReceivedDepartment")));
			}
			if (request.getParameter("assignedDepartment") != null
					&& !request.getParameter("assignedDepartment").equals("")) {
				searchFileCreate.setAssignedDepartment(Long
						.parseLong(request.getParameter("assignedDepartment")));
			}
			if (request.getParameter("assignedSection") != null
					&& !request.getParameter("assignedSection").equals("")) {
				searchFileCreate.setAssignedSection(Long
						.parseLong(request.getParameter("assignedSection")));
			}
			if (request.getParameter("assignedUser") != null
					&& !request.getParameter("assignedUser").equals("")) {
				searchFileCreate.setAssignedUser(
						Long.parseLong(request.getParameter("assignedUser")));
			}

			searchFileCreate.setReceivedFileRefNo(
					request.getParameter("receivedFileRefNo"));

			String fileStatus = request.getParameter("finalStatus");
			searchFileCreate.setFinalStatus(fileStatus);

			if (request.getParameter("isRTIAppealApplication") != null
					&& !request.getParameter("isRTIAppealApplication")
							.equals("")) {
				searchFileCreate.setIsRTIAppealApplication(Integer.parseInt(
						request.getParameter("isRTIAppealApplication")));
			} else {
				searchFileCreate.setIsRTIAppealApplication(null);
			}

		} catch (Exception err) {
			log.error(err.getMessage());
		}
	}
	
	
	 @RequestMapping("/rtsapplication/updateCollectionList.do")
	 public ModelAndView updateCollectionList(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		 
		 HttpSession session = request.getSession();
		 String responseMessage =null;
			if (log.isDebugEnabled())
			{
			    log.debug("Invoking updateCollectionList method");
			}
		
			try{
				List<CollectionBuffer> ob =new ArrayList<>();
				String collectionBufferIds = request.getParameter("collectionbufferid");
				String[] ids = collectionBufferIds.split(",");
				Long[] colIds=new Long[ids.length];
				StringBuffer collNumbers=new StringBuffer();
				for(int i=0;i<ids.length;i++)
				{
				  collNumbers.append(ids[i]+",");
				  colIds[i]=Long.parseLong(ids[i]);
				  CollectionBuffer cb = collectionBufferService.getCollectionId(colIds[i]);
				  ob.add(cb);
				}
				 List<RTIApplication> listrts= new ArrayList<>();
			    	List<Collection> listcollection = new ArrayList<>();
			    	List<CollectionBuffer> listcollectionbuffer = new ArrayList<>();
				    	 if(ob != null && ob.size() > 0){
				    	
				    
				    	for(CollectionBuffer cb : ob) {
				    					 
				    			 RTIApplication rTIApplication =rTIApplicationService.get(cb.getrTIApplication().getRtiApplicationId());
				    			 if (rTIApplication.getWorkFlowStatus() == -1) {
				    				    rTIApplication.setWorkFlowStatus(0);
				    				} else {
				    				    rTIApplication.setWorkFlowStatus(2);
				    				}
				    			 
				    			// rTIApplication.setWorkFlowStatus(2);
				    			 rTIApplication.setFinalStatus(CoreConstants.RTI_FINALSTATUS_APPROVED);

				    			 
				    			 CollectionBuffer cb1 = collectionBufferService.getBufferPgData(cb.getUniqPgid());
				    			 EasebuzzWebhook ez = eazebuzzService.getEasebuzz(cb1.getUniqPgid());
				    				cb1.setReferenceNumber(ez.getBank_ref_num());
				    				cb1.setStatus(2);				    				
				    			 
				    			
				    			 Collection collection = new Collection();
				 				collection.setRtiApplication(cb1.getrTIApplication().getRtiApplicationId());
				 				collection.setBankName(cb1.getBankName());
				 				collection.setReceiptDate(cb1.getReceiptDate());
				 				collection.setAmount(cb1.getAmount());
				 				collection.setPaymentMode(cb1.getPaymentMode());
				 				collection.setStatus(2);
				 				collection.setReceiptNumber(cb1.getReceiptNumber());
				 				collection.setUniqPgid(cb1.getUniqPgid());
				 				collection.setReferenceNumber(cb1.getReferenceNumber());
				    			
				 				listrts.add(rTIApplication);
				 				listcollection.add(collection);
				 				listcollectionbuffer.add(cb1);
				 				
				    			 
				    				 }
				    		 }
				    	 if(listrts!=null && listrts.size() > 0 || listcollection!=null && listcollection.size() > 0 || listcollectionbuffer!=null && listcollectionbuffer.size() > 0) {
				    		 
				    		//Updating RTIApplication
				    		 rTIApplicationService.savePaymentList(listrts);
				    		 
				    		 //Updating CollectionBuffer
				    		 collectionBufferService.saveCollectionBufferList(listcollectionbuffer);
				    		 
				    		 //Saving Collection
				    		 collectionService.saveCollectionList(listcollection);
				    		 
				    		 
				    	 
				    	 
				    	 responseMessage="Entries  updated Successfully!! ";
				    	 session.setAttribute("message", responseMessage);	
				    	 }
				    	 
			}catch(Exception e){
				
				 session.setAttribute("message", "Sorry,CollectionList not Updated!!");
				e.printStackTrace();
				
				
			}
			
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("redirect:/rtsapplication/failedCollectionEdit.do");

		 return modelAndView;
	 }
	
	

}

package com.mars.rti.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.InboxDAO;
import com.mars.rti.model.Inbox;
import com.mars.rti.search.InboxSearch;
import com.mars.rti.service.InboxService;
import com.mars.rti.service.InwardNumGenarationService;
import com.mars.rti.utils.CoreConstants;


@Service("inboxService")
public class InboxServiceImpl implements InboxService {

	 private static final Log log = LogFactory.getLog(InboxServiceImpl.class);
	 
	 @Autowired
	 private InboxDAO inboxDAO;
	 
	 private static String   rti_inbox_screen="RTI_INBOX_SCREEN";

	 private static String property="entityName";
	
	
	 @Autowired
	 private InwardNumGenarationService inwardNumGenarationService;

	 public void setInwardNumGenarationService(
				InwardNumGenarationService inwardNumGenarationService) {
			this.inwardNumGenarationService = inwardNumGenarationService;
	 }
	 
	 public void setInboxDAO(InboxDAO inboxDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setInboxDAO Method is called ");
		}
		this.inboxDAO = inboxDAO;
	 }

	 @Override
	 public Inbox get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return inboxDAO.get(id);
	 }

	 @Override
	 public void save(Inbox entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		if(entity.getStatus()== CoreConstants.RTI_STATUS_ACCEPTED)
			setInwardNumber(entity);
			
		inboxDAO.save(entity);
		
	 }
	 
	 private void setInwardNumber(Inbox entity) {
			String inwardEntityName = rti_inbox_screen;
			String preFix="RTI/[INWARD]/[YEAR]/";
			String postFix = "";
			Boolean resetFlag=true;
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dNow = new Date();
			String currentDate=(dateFormat.format(dNow));
			int year = Integer.parseInt(currentDate.substring(6,10));
			String inwardNum = inwardNumGenarationService.getInwardNumber(property,inwardEntityName,preFix,postFix,year);
			if(inwardNum != null ) {
				inwardNum = inwardNum.replace("[YEAR]", Integer.toString(year));
				entity.setInwardNo(inwardNum);
		}
	 }


	 @Override
	 public Inbox merge(Inbox entity) {
		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		
		if(entity.getStatus()== CoreConstants.RTI_STATUS_ACCEPTED)
			setInwardNumber(entity);
		
		return inboxDAO.merge(entity);
	 }

	 @Override
	 public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		inboxDAO.delete(id);
	 }

	 @Override
	 public List<Inbox> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return inboxDAO.getAll();
	 }

	 @Override
	 public void saveAll(List<Inbox> listInbox) {
		if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		inboxDAO.saveAll(listInbox);
	 }

	 @Override
	 public void deleteAll(List<Inbox> listInbox) {
		 if (log.isDebugEnabled()) {
				log.debug("deleteAll Method is called");
			}
		 inboxDAO.deleteAll(listInbox);
	 }

	@Override
	public List<Inbox> getInboxList(long pageNumber, String orderBy,
			String sortBy) {
		if (log.isDebugEnabled()) {
			log.debug("getAreaList Method is called");
		}
		return inboxDAO.getInboxList(pageNumber,orderBy,sortBy);
	}

	@Override
	public List<Inbox> getInboxListBySearch(InboxSearch searchInbox) {
		if (log.isDebugEnabled()) {
			log.debug("getInboxListBySearch Method is called");
		}
		return inboxDAO.getInboxListBySearch(searchInbox);
	}

	@Override
	public long getInboxCount() {
		if (log.isDebugEnabled()) {
			log.debug("getInboxCount Method is called");
		}
		return inboxDAO.getInboxCount();
	}

	@Override
	public long getInboxCountBySearch(InboxSearch searchInbox) {
		if (log.isDebugEnabled()) {
			log.debug("getInboxCountBySearch Method is called");
		}
		return inboxDAO.getInboxCountBySearch(searchInbox);
	}

	@Override
	public List<Inbox> findByProperty(String propertyName, Object value) {
		if (log.isDebugEnabled()) {
			log.debug("findByProperty Method is called");
		}
		return inboxDAO.findByProperty(propertyName,value);
	}

	@Override
	public Inbox checkForDuplicates(Inbox inbox) {
		if (log.isDebugEnabled()) {
			log.debug("checkForDuplicates Method is called");
		}
		return inboxDAO.checkForDuplicates(inbox);
	}

	@Override
	public List<Inbox> getListByNamedQuery(String namedQuery,
			Hashtable<String, Object> hstKeyValues) {
		if (log.isDebugEnabled()) {
			log.debug("getListByNamedQuery Method is called");
		}
		return inboxDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}

	@Override
	public List<Inbox> getEntityListBySQLQuery(String strSql,
			Hashtable<String, NullableType> hstDataTypes) {
		if (log.isDebugEnabled()) {
			log.debug("getEntityListBySQLQuery Method is called");
		}
		return inboxDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<ArrayList> getListBySQLQuery(String strSql,
			Hashtable<String, NullableType> hstDataTypes) {
		if (log.isDebugEnabled()) {
			log.debug("getListBySQLQuery Method is called");
		}
		return inboxDAO.getListBySQLQuery(strSql,hstDataTypes);
	}

	  	
	
	}

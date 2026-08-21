package com.mars.rti.service.impl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.OutboxDAO;
import com.mars.rti.model.Outbox;
import com.mars.rti.search.OutboxSearch;
import com.mars.rti.service.OutboxService;
import com.mars.rti.service.OutwardNumGenarationService;
//import com.mars.fts.service.OutwardNumGenarationService;
import com.mars.rti.utils.CoreConstants;


@Service("outboxService") 
public class OutboxServiceImpl implements OutboxService {

	
	private static final Log log = LogFactory.getLog(OutboxServiceImpl.class);
	 
	 @Autowired
	 private OutboxDAO outboxDAO;
	 
	 private static String   rti_outbox_screen="RTI_OUTBOX_SCREEN";

	 private static String property="entityName";
	 
	 @Autowired
	 private OutwardNumGenarationService outwardNumGenarationService;

	 public void setOutwardNumGenarationService(
				OutwardNumGenarationService inwardNumGenarationService) {
			this.outwardNumGenarationService = outwardNumGenarationService;
	 }
	 
	 public void setOutboxDAO(OutboxDAO outboxDAO) {
			if (log.isDebugEnabled()) {
				log.debug("setOutboxDAO Method is called ");
			}
			this.outboxDAO = outboxDAO;
	 }

	 @Override
	 public Outbox get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return outboxDAO.get(id);
	 }

	@Override
	public void save(Outbox entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		
		if(entity.getStatus()== CoreConstants.RTI_STATUS_FORWARD)
			setOutwardNumber(entity);
		outboxDAO.save(entity);
			
	 }
		
		
	private void setOutwardNumber(Outbox entity) {
		String outwardEntityName = rti_outbox_screen;
		String preFix="RTI/[OUTWARD]/[YEAR]/";
		String postFix = "";
		Boolean resetFlag=true;
		int year = Integer.parseInt(entity.getApplnForwardDate().substring(6,10));
		String outwardNum = outwardNumGenarationService.getOutwardNumber(property,outwardEntityName,preFix,postFix,year);
		if(outwardNum != null ) {
			outwardNum = outwardNum.replace("[YEAR]", Integer.toString(year));
			entity.setOutwardNo(outwardNum);
		}
	}

	@Override
	public Outbox merge(Outbox entity) {
		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		if(entity.getStatus()== CoreConstants.RTI_STATUS_FORWARD)
			setOutwardNumber(entity);
		
		return outboxDAO.merge(entity);
	}

	@Override
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		outboxDAO.delete(id);
		
	}

	@Override
	public List<Outbox> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return outboxDAO.getAll();
	}

	@Override
	public void saveAll(List<Outbox> listOutbox) {
		if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		outboxDAO.saveAll(listOutbox);
		
	}

	@Override
	public void deleteAll(List<Outbox> listOutbox) {
		 if (log.isDebugEnabled()) {
				log.debug("deleteAll Method is called");
			}
		 outboxDAO.deleteAll(listOutbox);
		
	}

	@Override
	public List<Outbox> getOutboxList(long pageNumber, String orderBy,
			String sortBy) {
		if (log.isDebugEnabled()) {
			log.debug("getAreaList Method is called");
		}
		return outboxDAO.getOutboxList(pageNumber,orderBy,sortBy);
	}

	@Override
	public List<Outbox> getOutboxListBySearch(OutboxSearch searchOutbox) {
		if (log.isDebugEnabled()) {
			log.debug("getOutboxListBySearch Method is called");
		}
		return outboxDAO.getOutboxListBySearch(searchOutbox);
	}

	@Override
	public long getOutboxCount() {
		if (log.isDebugEnabled()) {
			log.debug("getOutboxCount Method is called");
		}
		return outboxDAO.getOutboxCount();
	}

	@Override
	public long getOutboxCountBySearch(OutboxSearch searchOutbox) {
		if (log.isDebugEnabled()) {
			log.debug("getOutboxCountBySearch Method is called");
		}
		return outboxDAO.getOutboxCountBySearch(searchOutbox);
	}

	@Override
	public List<Outbox> findByProperty(String propertyName, Object value) {
		if (log.isDebugEnabled()) {
			log.debug("findByProperty Method is called");
		}
		return outboxDAO.findByProperty(propertyName,value);
	}

	@Override
	public Outbox checkForDuplicates(Outbox outbox) {
		if (log.isDebugEnabled()) {
			log.debug("checkForDuplicates Method is called");
		}
		return outboxDAO.checkForDuplicates(outbox);
	}

	@Override
	public List<Outbox> getListByNamedQuery(String namedQuery,
			Hashtable<String, Object> hstKeyValues) {
		if (log.isDebugEnabled()) {
			log.debug("getListByNamedQuery Method is called");
		}
		return outboxDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}

	@Override
	public List<Outbox> getEntityListBySQLQuery(String strSql,
			Hashtable<String, NullableType> hstDataTypes) {
		if (log.isDebugEnabled()) {
			log.debug("getEntityListBySQLQuery Method is called");
		}
		return outboxDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<ArrayList> getListBySQLQuery(String strSql,
			Hashtable<String, NullableType> hstDataTypes) {
		if (log.isDebugEnabled()) {
			log.debug("getListBySQLQuery Method is called");
		}
		return outboxDAO.getListBySQLQuery(strSql,hstDataTypes);
	}

}

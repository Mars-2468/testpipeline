/**
 * 
 */
package com.mars.rti.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.common.utils.Constants;
import com.mars.rti.dao.BirthRegistrationDAO;
import com.mars.rti.model.BirthRegistration;
import com.mars.rti.search.RTIApplicationSearch;

/**
 * @author Sanket Bhoyane
 *
 */
@Repository("birthRegistrationDAO")
public class BirthRegistrationDAOImpl extends HibernateDaoSupport implements BirthRegistrationDAO {
	
	
	private static final Log log = LogFactory.getLog(BirthRegistrationDAOImpl.class);
	
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}


	/* (non-Javadoc)
	 * @see com.mars.rti.dao.BirthRegistrationDAO#birthRegistrationCertificate(com.mars.rti.model.BirthRegistration)
	 */
	@Override
	public void birthRegistrationCertificate(BirthRegistration birthRegistration) {
		// TODO Auto-generated method stub
		
				try
				{
				    if (log.isDebugEnabled())
				    {
					log.debug("save Method is called ");
				    }
				    getHibernateTemplate().saveOrUpdate(birthRegistration);
				} catch (NullPointerException nullpointerexception)
				{
				    log.error(nullpointerexception.getStackTrace());
				    throw new NullPointerException();
				} catch (HibernateException hibernateException)
				{
				    hibernateException.printStackTrace();
				    log.error(hibernateException.getStackTrace());
				    throw new HibernateException(hibernateException.getMessage());
				} catch (Exception exception)
				{
				    exception.printStackTrace();
				    log.error(exception.getStackTrace());
				    throw new RuntimeException(exception.getCause());
				}
	}
	
	
	@Override
	public long birthRegistrationSave(BirthRegistration birthRegistration) {
		// TODO Auto-generated method stub
		BirthRegistration b=null;
				try
				{
				    if (log.isDebugEnabled())
				    {
					log.debug("save Method is called ");
				    }
				    b=(BirthRegistration)getHibernateTemplate().merge(birthRegistration);
				    
				    if(b!=null){
				    	return b.getBirthRegistrationId();
				    }
				} catch (NullPointerException nullpointerexception)
				{
				    log.error(nullpointerexception.getStackTrace());
				    throw new NullPointerException();
				} catch (HibernateException hibernateException)
				{
				    hibernateException.printStackTrace();
				    log.error(hibernateException.getStackTrace());
				    throw new HibernateException(hibernateException.getMessage());
				} catch (Exception exception)
				{
				    exception.printStackTrace();
				    log.error(exception.getStackTrace());
				    throw new RuntimeException(exception.getCause());
				}
				return b.getBirthRegistrationId();
	}
	
	public List<BirthRegistration> getBirthRegistrationList(RTIApplicationSearch rTIApplicationSearch){
		try {
			long pageNumber = rTIApplicationSearch.getCurrentPage();
			String orderBy = rTIApplicationSearch.getOrderBy();
			String sortBy = rTIApplicationSearch.getSortBy();
			

			String sqlString = "select birthRegistration from BirthRegistration birthRegistration";

			String fromClause = getSearchQuery(rTIApplicationSearch);

			sqlString = StringUtils.isNotEmpty(fromClause) ? sqlString + " where " + fromClause : sqlString;

			fromClause = sqlString + " order by " + orderBy + " " + sortBy;
			Query query = getSession().createQuery(fromClause);

			if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
				if (pageNumber > 1) {
					query.setFirstResult((int) ((pageNumber - 1) * Constants.DEFAULT_ROWS_PER_PAGE));
					query.setMaxResults((int) Constants.DEFAULT_ROWS_PER_PAGE);
				} else {
					query.setFirstResult(0);
					query.setMaxResults((int) Constants.DEFAULT_ROWS_PER_PAGE);
				}
			}

			List<BirthRegistration> list = query.list();

			if (list != null && list.size() > 0) {
				return list;
			}
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	
	public long getRTIApplicationCount(RTIApplicationSearch searchOptions) {
		try {

			String sqlString = "select count(*) from RTIApplication rtiApplication";
			String fromClause = getSearchQuery(searchOptions);

			sqlString = StringUtils.isNotEmpty(fromClause) ? sqlString + " where " + fromClause : sqlString;
			Query query = getSession().createQuery(sqlString);
			List list = query.list();
			if (list != null && list.size() > 0)
				return Long.parseLong(list.get(0).toString());
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return 0;
	}
	
	private String getSearchQuery(RTIApplicationSearch searchOptions) {
		String condition = " and ";
		String fromClause = "";
		boolean conditionFound = false;
		//String fromDate=searchOptions.getFromDate();
		//String toDate=searchOptions.getToDate();
		long tenancyId=searchOptions.getTenancyId();
		
		if (searchOptions != null) {

			String searchrtiApplnNumber = searchOptions.getRtiApplicationNumber();
			String refNumber =  searchOptions.getReceivedFileRefNo();
			String RegistrationFromDate =  searchOptions.getCreationFromDate();
			String RegistrationToDate =  searchOptions.getCreationToDate();
			
			long department = searchOptions.getAssignedDepartment();
			long section = searchOptions.getAssignedSection();
			long user = searchOptions.getAssignedUser();
			String finalStatus = searchOptions.getFinalStatus();
				
			if (StringUtils.isNotEmpty(searchrtiApplnNumber)) {
				if (conditionFound)
					fromClause = fromClause + condition;
				
				fromClause = fromClause +"rtiApplnNumber='"+searchrtiApplnNumber+"'";
				conditionFound = true;
			}
			
			if (StringUtils.isNotEmpty(refNumber)) {
				if (conditionFound)
					fromClause = fromClause + condition;
				
				fromClause = fromClause +"receivedRefNo='"+refNumber+"'";
				conditionFound = true;
			}
			
			
			if((RegistrationFromDate != null && RegistrationFromDate.length() > 0) && (RegistrationToDate != null && RegistrationToDate.length() > 0))
			{
				if (conditionFound)
					fromClause = fromClause + condition;
				fromClause = fromClause +(" (to_date(rtiApplication.registrationDate,'" + Constants.DATE_FORMAT + "') between to_date('" + RegistrationFromDate + "','" + Constants.DATE_FORMAT + "') " +
	    				"and to_date('" + RegistrationToDate + "','" + Constants.DATE_FORMAT + "'))");
				conditionFound = true;
			}
			
			if (searchOptions.getRtiAplicationReceivedDepartment() > 0) {
				if (conditionFound)
					fromClause = fromClause + condition;
				
				fromClause = fromClause +" rtiApplication.applicationDepartment.departmentId="+searchOptions.getRtiAplicationReceivedDepartment()+" ";
				conditionFound = true;
			}
			
			if (department>0) {
				if (conditionFound)
					fromClause = fromClause + condition;
				
				fromClause = fromClause +" rtiApplication.assignedDepartment.departmentId="+department+" ";
				conditionFound = true;
			}
			
			if (section>0) {
				if (conditionFound)
					fromClause = fromClause + condition;
				
				fromClause = fromClause +" rtiApplication.assignedSection.sectionId="+section+" " ;
				conditionFound = true;
			}
			   
			if (user>0) {
				if (conditionFound)
					fromClause = fromClause + condition;
				
				fromClause = fromClause +" rtiApplication.assigneeUserId.userId="+user +" ";
				conditionFound = true;
			}
								
			if(tenancyId>0){
				
				if (conditionFound)
					fromClause = fromClause + condition;
				
				fromClause = fromClause +"rtiApplication.tenancy.tenancyId="+tenancyId+" ";
				conditionFound = true;
			}
			
			if(finalStatus!=null && finalStatus.length()>0 && finalStatus.equalsIgnoreCase("Closed_Not_Re_Assign")){
				if (conditionFound)
					fromClause = fromClause + condition;
				
				fromClause = fromClause +"upper(rtiApplication.finalStatus) = upper('"+finalStatus+"') ";
				conditionFound = true;
			}
			else if(finalStatus!=null && !finalStatus.equals("") && finalStatus.length()>0 && !finalStatus.equalsIgnoreCase("all")){
				if (conditionFound)
					fromClause = fromClause + condition;
				
				fromClause = fromClause +"upper(rtiApplication.finalStatus) = upper('"+finalStatus+"') ";
				conditionFound = true;
			}
			
			if(searchOptions.getIsRTIAppealApplication()!=null ){
				if (conditionFound)
					fromClause = fromClause + condition;
				
				fromClause = fromClause +" rtiApplication.isRTIAppealApplication  ="+searchOptions.getIsRTIAppealApplication() +" ";
				conditionFound = true;
			}
		}
		return fromClause;
	}
	
	public BirthRegistration get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (BirthRegistration) getHibernateTemplate().get(BirthRegistration.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}

	}

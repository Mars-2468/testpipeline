package com.mars.rti.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.common.utils.Constants;
import com.mars.rti.dao.NOCOfTradeDashboardDAO;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.search.DashBoardLabelSearch;
@Repository
public class NOCOfTradeDashboardDAOImpl extends HibernateDaoSupport implements NOCOfTradeDashboardDAO{
		
	
			private static final Log log = LogFactory.getLog(NOCOfTradeDashboardDAOImpl.class);

				@Autowired
				public void init(SessionFactory factory) {
					setSessionFactory(factory);
				}
				
				@Override
				public long getPieChartOrBarChartData() {
					if(log.isDebugEnabled()){
						log.debug("getPieChartOrBarChartData Method is called");
					}
					
					try{
						List<Long> list=new ArrayList<>();
						
						StringBuffer sql=new StringBuffer();
						String fromClause="select count(r) from RTIApplication r where rti_service_id=32";
						sql.insert(0, fromClause);
						Query query=getSession().createQuery(sql.toString());
						list=query.list();
						
						if(list!=null && list.size()>0)
							return Long.parseLong(list.get(0).toString());
						else
							return 0;
					}catch (NullPointerException nullpointerexception) {
			    		log.error(nullpointerexception.getStackTrace());
			    		throw new NullPointerException();
			    	} catch (HibernateException hibernateException) {
			    		log.error(hibernateException.getStackTrace());
			    		throw new HibernateException(hibernateException.getMessage());
			    	} catch (Exception exception) {
			    		log.error(exception.getStackTrace());
			    		exception.printStackTrace();
			    		throw new RuntimeException(exception.getCause());
			    	}
				}
				@Override
				public long getPieChartOrBarChartData(String condValue) {
					if(log.isDebugEnabled()){
						log.debug("getPieChartOrBarChartData Method is called");
					}
					
					try{
						List<Long> list=new ArrayList<>();
						
						StringBuffer sql=new StringBuffer();
						String fromClause="select count(r) from RTIApplication r where r.finalStatus='"+condValue+"' and (rti_service_id=32)";
						
						sql.insert(0, fromClause);
						Query query=getSession().createQuery(sql.toString());
						list=query.list();
						
						if(list!=null && list.size()>0)
							return Long.parseLong(list.get(0).toString());
						else
							return 0;
					}catch (NullPointerException nullpointerexception) {
			    		log.error(nullpointerexception.getStackTrace());
			    		throw new NullPointerException();
			    	} catch (HibernateException hibernateException) {
			    		log.error(hibernateException.getStackTrace());
			    		throw new HibernateException(hibernateException.getMessage());
			    	} catch (Exception exception) {
			    		log.error(exception.getStackTrace());
			    		exception.printStackTrace();
			    		throw new RuntimeException(exception.getCause());
			    	}
				}
				@Override
				public long getPieChartOrBarChartData(String condValue1,
						String condValue2,String condValue3) {
					if(log.isDebugEnabled()){
						log.debug("getPieChartOrBarChartData Method is called");
					}
					
					try{
						List<Long> list=new ArrayList<>();
						
						StringBuffer sql=new StringBuffer();
						String fromClause="select count(r) from RTIApplication r where r.finalStatus not in ('"+condValue1+"','"+condValue2+"','"+condValue3+"')and (rti_service_id=32)";
							
						
						sql.insert(0, fromClause);
						Query query=getSession().createQuery(sql.toString());
						list=query.list();
						
						if(list!=null && list.size()>0)
							return  Long.parseLong(list.get(0).toString());
						else
							return 0;
					}catch (NullPointerException nullpointerexception) {
			    		log.error(nullpointerexception.getStackTrace());
			    		throw new NullPointerException();
			    	} catch (HibernateException hibernateException) {
			    		log.error(hibernateException.getStackTrace());
			    		throw new HibernateException(hibernateException.getMessage());
			    	} catch (Exception exception) {
			    		log.error(exception.getStackTrace());
			    		exception.printStackTrace();
			    		throw new RuntimeException(exception.getCause());
			    	}
				}
				
				@Override
				public List<BigInteger> getPieChartOrBarChartBasedOnSearch(String registrtionFromDate,String registrtionToDate,String category){
					try{
						List<BigInteger> list=new ArrayList<>();
						StringBuffer sql=new StringBuffer();
						String fromClause="";
						if((registrtionFromDate!=null&&registrtionFromDate.length()>0)  && (registrtionToDate!=null&&registrtionToDate.length()>0) && (category!=null&&category!="")){
							 fromClause+="select count(r) as pendingCount from egovrti.rti_application r where r.final_status='New' "
							 		+ "and to_date(r.registration_date,'" + Constants.DATE_FORMAT + "') between to_date('" + registrtionFromDate + "','" + Constants.DATE_FORMAT + "') "
							 				+ " and to_date('" + registrtionToDate + "','" + Constants.DATE_FORMAT + "') and r.bpl="+category+" UNION ALL   "
							 				
							 				+ "select count(r) as rejectedCount from egovrti.rti_application r where r.final_status='Rejected' "
							 		+ "and to_date(r.registration_date,'" + Constants.DATE_FORMAT + "') between to_date('" + registrtionFromDate + "','" + Constants.DATE_FORMAT + "') "
					 				+ " and to_date('" + registrtionToDate + "','" + Constants.DATE_FORMAT + "') and r.bpl="+category+" UNION  ALL "
					 				
							 		+ "select count(r) as closedCount from egovrti.rti_application r where r.final_status='Closed' "
							 		+ "and to_date(r.registration_date,'" + Constants.DATE_FORMAT + "') between to_date('" + registrtionFromDate + "','" + Constants.DATE_FORMAT + "') "
					 				+ "and to_date('" + registrtionToDate + "','" + Constants.DATE_FORMAT + "') and r.bpl="+category+" UNION  ALL "
					 				
							 		+ "select count(r) as approvedCount from egovrti.rti_application r where r.final_status='Approved' "
							 		+ "and to_date(r.registration_date,'" + Constants.DATE_FORMAT + "') between to_date('" + registrtionFromDate + "','" + Constants.DATE_FORMAT + "') "
					 				+ " and to_date('" + registrtionToDate + "','" + Constants.DATE_FORMAT + "') and r.bpl="+category+" UNION ALL "
							 		+ "select count(r) as pendingCount from egovrti.rti_application r where r.final_status not in ('Approved','Closed','New') "
							 		+ "and to_date(r.registration_date,'" + Constants.DATE_FORMAT + "') between to_date('" + registrtionFromDate + "','" + Constants.DATE_FORMAT + "') "
					 				+ " and to_date('" + registrtionToDate + "','" + Constants.DATE_FORMAT + "') and r.bpl="+category+" UNION ALL "
							 		+ "select count(r) as totalCount from egovrti.rti_application r  where to_date(r.registration_date,'" + Constants.DATE_FORMAT + "') between to_date('" + registrtionFromDate + "','" + Constants.DATE_FORMAT + "') "
					 				+ " and to_date('" + registrtionToDate + "','" + Constants.DATE_FORMAT + "') and r.bpl="+category+"";
						}else if((registrtionFromDate!=null&&registrtionFromDate.length()>0)  && (registrtionToDate!=null&&registrtionToDate.length()>0)){
							fromClause+="select count(r) as pendingCount from egovrti.rti_application r where r.final_status='New' "
							 		+ "and to_date(r.registration_date,'" + Constants.DATE_FORMAT + "') between to_date('" + registrtionFromDate + "','" + Constants.DATE_FORMAT + "') "
							 				+ " and to_date('" + registrtionToDate + "','" + Constants.DATE_FORMAT + "')  UNION ALL   "
							 				+ "select count(r) as rejectedCount from egovrti.rti_application r where r.final_status='Rejected' "
							 		+ "and to_date(r.registration_date,'" + Constants.DATE_FORMAT + "') between to_date('" + registrtionFromDate + "','" + Constants.DATE_FORMAT + "') "
					 				+ " and to_date('" + registrtionToDate + "','" + Constants.DATE_FORMAT + "')  UNION  ALL "
							 		+ "select count(r) as closedCount from egovrti.rti_application r where r.final_status='Closed' "
							 		+ "and to_date(r.registration_date,'" + Constants.DATE_FORMAT + "') between to_date('" + registrtionFromDate + "','" + Constants.DATE_FORMAT + "') "
					 				+ " and to_date('" + registrtionToDate + "','" + Constants.DATE_FORMAT + "') UNION  ALL "
							 		+ "select count(r) as approvedCount from egovrti.rti_application r where r.final_status='Approved' "
							 		+ "and to_date(r.registration_date,'" + Constants.DATE_FORMAT + "') between to_date('" + registrtionFromDate + "','" + Constants.DATE_FORMAT + "') "
					 				+ " and to_date('" + registrtionToDate + "','" + Constants.DATE_FORMAT + "') UNION ALL "
							 		+ "select count(r) as pendingCount from egovrti.rti_application r where r.final_status not in ('Approved','Closed','New','Rejected') "
							 		+ "and to_date(r.registration_date,'" + Constants.DATE_FORMAT + "') between to_date('" + registrtionFromDate + "','" + Constants.DATE_FORMAT + "') "
					 				+ " and to_date('" + registrtionToDate + "','" + Constants.DATE_FORMAT + "')  UNION ALL "
							 		+ "select count(r) as totalCount from egovrti.rti_application r where to_date(r.registration_date,'" + Constants.DATE_FORMAT + "') between to_date('" + registrtionFromDate + "','" + Constants.DATE_FORMAT + "') "
					 				+ " and to_date('" + registrtionToDate + "','" + Constants.DATE_FORMAT + "')  ";
							
						}else if(category!=null&& category!=""){
							fromClause+="select count(r) as pendingCount from egovrti.rti_application r where r.final_status='New' "
							 		+ " and r.bpl="+category+" UNION ALL   "
							 		+ "select count(r) as closedCount from egovrti.rti_application r where r.final_status='Closed' "
							 		+ "  and r.bpl="+category+" UNION  ALL "
							 		+ "select count(r) as rejectedCount from egovrti.rti_application r where r.final_status='Rejected' "
							 		+ "  and r.bpl="+category+" UNION  ALL "
							 		+ "select count(r) as approvedCount from egovrti.rti_application r where r.final_status='Approved' "
							 		+ " and r.bpl="+category+" UNION ALL "
							 		+ "select count(r) as pendingCount from egovrti.rti_application r where r.final_status not in ('Approved','Closed','New','Rejected') "
							 		+ " and r.bpl="+category+" UNION ALL "
							 		+ "select count(r) as totalCount from egovrti.rti_application r where r.bpl="+category+" ";
							
						}
						
						
						//String fromClause="select count(r) as pendingCount from RTIApplication r where r.finalStatus not in ('Approved','Closed','New')";
						
						sql.insert(0, fromClause);
						Query query=getSession().createSQLQuery(sql.toString());
						list=query.list();
						
						if(list!=null && list.size()>0)
							return  list;
						else
							return null;
					}catch (NullPointerException nullpointerexception) {
			    		log.error(nullpointerexception.getStackTrace());
			    		throw new NullPointerException();
			    	} catch (HibernateException hibernateException) {
			    		log.error(hibernateException.getStackTrace());
			    		throw new HibernateException(hibernateException.getMessage());
			    	} catch (Exception exception) {
			    		log.error(exception.getStackTrace());
			    		exception.printStackTrace();
			    		throw new RuntimeException(exception.getCause());
			    	}
				}
				
			@Override
			public List<RTIApplication> getRTIApplicationListByLabel(
					DashBoardLabelSearch dashBoardLabelSearch) {
				if(log.isDebugEnabled()){
					log.debug("getRTIApplicationListByLabel Method is called");
				}
				
				try{
					long pageNumber=dashBoardLabelSearch.getCurrentPage();
					String orderBy=dashBoardLabelSearch.getOrderBy();
					String sortBy=dashBoardLabelSearch.getSortBy();
					StringBuffer sql=new StringBuffer();
					String fromClause="select r from RTIApplication r where rti_service_id=32";
					List<RTIApplication> list=null;
					boolean flag=false;
					
					if(dashBoardLabelSearch!=null){
						
						if(dashBoardLabelSearch.getReceiptSatus()!=null && dashBoardLabelSearch.getReceiptSatus().length()>0){
							
							if(!dashBoardLabelSearch.getReceiptSatus().equals("All")){
								if(!flag){
									flag=true;
									sql.append(" where ");
								}else
									sql.append(" and ");
							}
							
							if(dashBoardLabelSearch.getReceiptSatus().equals("Pending")){
								sql.append("r.finalStatus not in('New','Closed','Approved','Rejected')");
								
							}else if(dashBoardLabelSearch.getReceiptSatus().equals("All")){
								sql.append("");
							}
							
							else{
								sql.append("r.finalStatus='"+dashBoardLabelSearch.getReceiptSatus()+"'");
							}
							    
						}
						
						if(dashBoardLabelSearch.getCategory()!=null && dashBoardLabelSearch.getCategory().length()>0){
							if(!flag){
								flag=true;
								sql.append(" where ");
							}else
								sql.append(" and ");
							
							    sql.append("r.bpl="+ dashBoardLabelSearch.getCategory()+"");
						}
						if((dashBoardLabelSearch.getRegistrationFromDate()!= null && dashBoardLabelSearch.getRegistrationFromDate().length() > 0) && (dashBoardLabelSearch.getRegistrationToDate()!= null && dashBoardLabelSearch.getRegistrationToDate().length() > 0)) 
						{
							if(!flag){
								flag=true;
								sql.append(" where ");
							}else
								sql.append(" and ");
							
								
							sql.append("to_date(r.registrationDate,'" + Constants.DATE_FORMAT + "') between to_date('" + dashBoardLabelSearch.getRegistrationFromDate() + "','" + Constants.DATE_FORMAT + "')  and to_date('" + dashBoardLabelSearch.getRegistrationToDate() + "','" + Constants.DATE_FORMAT + "')");
							
						}
						
						
					}
					
					
					
					
					sql.insert(0, fromClause).append(" order by " + orderBy + " "+ sortBy);
					Query query=getSession().createQuery(sql.toString());
					
					if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS.intValue()) {
						if (pageNumber > 1) {
							query.setFirstResult((int) ((pageNumber - 1) * Constants.DEFAULT_ROWS_PER_PAGE));
							query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
						} else {
							query.setFirstResult(0);
							query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
						}
					}
					list=query.list();
					return list;
				}catch (NullPointerException nullpointerexception) {
					log.error(nullpointerexception.getStackTrace());
					nullpointerexception.printStackTrace();
					throw new NullPointerException();
				} catch (HibernateException hibernateException) {
					log.error(hibernateException.getStackTrace());
					throw new HibernateException(hibernateException.getMessage());
				} catch (Exception exception) {
					log.error(exception.getStackTrace());
					throw new RuntimeException(exception.getCause());
				}	

			}

			@Override
			public long getRTIApplicationCountByLabel(
					DashBoardLabelSearch dashBoardLabelSearch) {
				if(log.isDebugEnabled()){
					log.debug("getRTIApplicationCountByLabel Method is called");
				}
				
				try{
					
					
					StringBuffer sql=new StringBuffer();
					String fromClause="select count(r) from RTIApplication r where rti_service_id=32";
					List list=null;
					boolean flag=false;

					if(dashBoardLabelSearch!=null){
						
						if(dashBoardLabelSearch.getReceiptSatus()!=null && dashBoardLabelSearch.getReceiptSatus().length()>0){
							if(!dashBoardLabelSearch.getReceiptSatus().equals("All")){
								if(!flag){
									flag=true;
									sql.append(" where ");
								}else
									sql.append(" and ");
							}
							
							
							if(dashBoardLabelSearch.getReceiptSatus().equals("Pending")){
								sql.append("r.finalStatus not in('New','Closed','Approved','Rejected')");
								
							}else{
								sql.append("r.finalStatus='"+dashBoardLabelSearch.getReceiptSatus()+"'");
							}
							
						}
						
						if(dashBoardLabelSearch.getCategory()!=null && dashBoardLabelSearch.getCategory().length()>0){
							if(!flag){
								flag=true;
								sql.append(" where ");
							}else
								sql.append(" and ");
							
							    sql.append("r.bpl="+ dashBoardLabelSearch.getCategory()+"");
						}
						if((dashBoardLabelSearch.getRegistrationFromDate()!= null && dashBoardLabelSearch.getRegistrationFromDate().length() > 0) && (dashBoardLabelSearch.getRegistrationToDate()!= null && dashBoardLabelSearch.getRegistrationToDate().length() > 0)) 
						{
							if(!flag){
								flag=true;
								sql.append(" where ");
							}else
								sql.append(" and ");
							
								
							sql.append("to_date(r.registrationDate,'" + Constants.DATE_FORMAT + "') between to_date('" + dashBoardLabelSearch.getRegistrationFromDate() + "','" + Constants.DATE_FORMAT + "')  and to_date('" + dashBoardLabelSearch.getRegistrationToDate() + "','" + Constants.DATE_FORMAT + "')");
							
						}
						
						
					}
					
					
					
					sql.insert(0, fromClause);
					Query query=getSession().createQuery(sql.toString());
					list=query.list();
					
					if(list!=null && list.size()>0)
						return Long.parseLong(list.get(0).toString());
					else
						return 0;
				}catch (NullPointerException nullpointerexception) {
					log.error(nullpointerexception.getStackTrace());
					throw new NullPointerException();
				} catch (HibernateException hibernateException) {
					log.error(hibernateException.getStackTrace());
					throw new HibernateException(hibernateException.getMessage());
				} catch (Exception exception) {
					log.error(exception.getStackTrace());
					exception.printStackTrace();
					throw new RuntimeException(exception.getCause());
				}	
			}
			@Override
			public double getPieChartOrBarChartDatas() {
				
				
				if(log.isDebugEnabled()){
					log.debug("getPieChartOrBarChartData Method is called");
				}
				try {
					
					String sqlString = "select sum(applicationCost) from RTIApplication rtiApplication where workFlowStatus in(2,1) and (rti_service_id=32)";
				
						//	+ "where r.subject ='TRADE-LICENCE-RENEWAL' and r.final_status='Approved'";
					System.out.println("sqlString"+sqlString);
			        Query query = getSession().createQuery(sqlString);
					List list = query.list();
					if (list != null && list.size() > 0)
						
						System.out.println("sqlString"+list.get(0).toString());
						return Double.valueOf(list.get(0).toString());
				} catch (Exception exception) {
					log.error(exception.getStackTrace(), exception);
					exception.printStackTrace();
				}
				return 0.0;
			}
			

	

	

}

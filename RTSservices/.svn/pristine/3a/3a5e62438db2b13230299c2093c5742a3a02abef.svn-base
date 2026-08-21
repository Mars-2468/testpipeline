package com.mars.quartz.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.mars.common.search.UserSearch;
import com.mars.common.service.UserService;
import com.mars.common.utils.Constants;
import com.mars.workflow.service.WorkflowService;

public class WorkFlowUsersSyncJob extends QuartzJobBean {
	
	private static Log log = LogFactory.getLog(WorkFlowUsersSyncJob.class);
	
	protected void executeInternal(JobExecutionContext ctx) {
		
		try{
			SchedulerContext schedulerContext = ctx.getScheduler().getContext();

			ApplicationContext applicationContext = (ApplicationContext) schedulerContext.get("applicationContext");
			
			UserService userService = (UserService) applicationContext.getBean("userService");
			WorkflowService workflowService = (WorkflowService)applicationContext.getBean("workflowService");
			SessionFactory sessionFactory = (SessionFactory) applicationContext
																	.getBean( "sessionFactory" );
			Session session = SessionFactoryUtils.getSession( sessionFactory, true );
			TransactionSynchronizationManager.bindResource( sessionFactory, new SessionHolder(session ) );
			
			//Getting only users who have permission to the current application.
			UserSearch searchOptions = new UserSearch();
			setSearchParameters(searchOptions);
			/*List<User> usersList = userService.getUserByType(searchOptions);
			
			try	{
				for  (User user : usersList) {
					log.info("Synchronizing users " + user.getUserId() + " Name : " +user.getUserName());
					workflowService.saveOrUpdateUser(user.getUserName(), user.getFirstName(), user.getLastName(), user.getEmail());
				}
			}catch(Exception e) {
				log.info("Error in UsersSyncJob while saving Users " );
				log .error(e.getMessage());
			} finally{
				TransactionSynchronizationManager.unbindResource(sessionFactory);
			}*/
		} catch (JobExecutionException e) {
			log.error(e.getMessage());
		} catch (SchedulerException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
	   private void setSearchParameters(UserSearch searchOptions) 
	   {
	    	long longCurrentPage = Constants.DEFAULT_PAGINATION_ALL_ROWS.intValue();
			String orderBy = "upper(user.userName)";
			String sortBy = "asc";
			
	    	try {
				searchOptions.setCurrentPage(longCurrentPage);
				searchOptions.setOrderBy(orderBy);
				searchOptions.setSortBy(sortBy);							

				searchOptions.setApplicationId(Constants.APPLICATION_ID);
					
			} catch(Exception err) {
				log.error(err.getMessage());
			}
	    }
}

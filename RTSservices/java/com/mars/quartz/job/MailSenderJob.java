package com.mars.quartz.job;


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

import com.mars.mail.service.MailService;





public class MailSenderJob extends QuartzJobBean{
	
	protected void executeInternal(JobExecutionContext ctx)
			throws JobExecutionException {
		
		try {
			SchedulerContext schedulerContext = ctx.getScheduler().getContext();

			// get ref to context thro scheduler 
			ApplicationContext applicationContext = (ApplicationContext) schedulerContext.get("applicationContext");
			
			SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean( "sessionFactory" );
			Session session = SessionFactoryUtils.getSession( sessionFactory, true );
			TransactionSynchronizationManager.bindResource( sessionFactory, new SessionHolder(session ) );
    		MailService mailService = (MailService) applicationContext.getBean( "mailService" );

    		mailService.sendEmailNotifiactations();
		      
    		
    		
    		
    	    	
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	 
}


package com.mars.rti.controller;

import java.util.Timer;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/* created on 26 feb 2013
 * @Author Anshu Gupta
 * 
 * This class has init method and initAnnotation method 
 * that is equivalent to init-param and will be called
 * once the application is initialized. The annotation @postConstruct will
 * help to identify which method should be called before the whole application
 * can build.  
 */

public class PropertyTaxCustomScheduler {

	
	     @Autowired
		private TaxSchedule taxSchedule;

	     
		

		public TaxSchedule getTaxSchedule() {
			return taxSchedule;
		}

		public void setTaxSchedule(TaxSchedule taxSchedule) {
			this.taxSchedule = taxSchedule;
		}

		private static final Log LOG = LogFactory.getLog(PropertyTaxCustomScheduler.class);

		public void init()
		{

			LOG.info("in the initialization method");
		}

		@PostConstruct
		public void initAnnotation()
		{

			LOG.info("calling method to update via scheduler");

			// create a new object of timer
			Timer t = new Timer();

			// call method to schedule the task that is to be performed at given interval
			//Every 15 mins one time scheduler wil run
			t.schedule(getTaxSchedule(), 500, 15 * 60 * 1000);
			// Change the scheduler to run every 24 hours
			//t.schedule(getTaxSchedule(), 500, 24 * 60 * 60 * 1000);

		}
		

	}
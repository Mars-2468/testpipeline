package com.mars.rti.dao;

import java.util.List;
import java.util.Map;

import com.mars.common.search.ApplicationSearch;
import com.mars.rti.model.Collection;
import com.mars.rti.model.FireApplicationDTO;
import com.mars.rti.model.FireDetails;
import com.mars.rti.model.FireRecommendation;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.search.RTIApplicationSearch;

 public interface FireRecommendationDAO {

	public FireRecommendation saveFireRecommendation(FireRecommendation fireRecommendation) ;
	public long fireRecommendationSave(FireRecommendation fireRecommendation);
	public FireRecommendation get(long id);
	public List<RTIApplication> getnoc(long serviceId);
	public FireRecommendation getnocDetails(long serviceId);
	public List<FireDetails> getFireDetails(long fireRecommendationId);
	public void delete(long id);
	public FireRecommendation merge(FireRecommendation entity);
	
	public FireRecommendation getApplicationId(String  applicationId);

	 public List<RTIApplication> getFireApplications(RTIApplicationSearch applicationSearch,String userZone,String userLevel, boolean isZoneUser);
	   

	   public long getFireApplicationsCount(RTIApplicationSearch applicationSearch,String userZone,String userLevel, boolean isZoneUser);		   
	   List<FireDetails> findByFireRecommendationId(long fireRecommendationId);
	   void update(FireRecommendation fireRecommendation);
		public FireRecommendation getDetails(long rtiApplicationId) ;
		
	
		public void saveUpdatedFees(Long fireId,
		                            String feesRemarks,
		                            String updatedScrutinyFees,
		                            String updatedTotalFees) ;
		public String getForwardUser(String zone, String category);
		Map<Long, List<Collection>> getPaymentMap(List<RTIApplication> applications);

		public List<RTIApplication> getCitizenApplications(
		        RTIApplicationSearch applicationSearch,
		        String userZone,
		        String userLevel,
		        boolean isZoneUser);
		public long getCitizenApplicationsCount(
		        RTIApplicationSearch applicationSearch,
		        String userZone,
		        String userLevel,
		        boolean isZoneUser);
		
		public List<RTIApplication> getForwardedApplications(
		        RTIApplicationSearch applicationSearch,
		        String userZone,
		        String userLevel,
		        boolean isZoneUser);
		public long getForwardedApplicationsCount(
		        RTIApplicationSearch applicationSearch,
		        String userZone,
		        String userLevel,
		        boolean isZoneUser);
		public List<RTIApplication> getL1Applications(
		        RTIApplicationSearch applicationSearch,
		        String userZone,
		        String userLevel,
		        boolean isZoneUser) ;
		public long getL1ApplicationsCount(
		        RTIApplicationSearch applicationSearch,
		        String userZone,
		        String userLevel,
		        boolean isZoneUser);
		public List<FireApplicationDTO> getTotalApplications(
		        RTIApplicationSearch applicationSearch,
		        String userZone,
		        String userLevel,
		        boolean isZoneUser);
		public long getTotalApplicationsCount(
		        RTIApplicationSearch applicationSearch,
		        String userZone,
		        String userLevel,
		        boolean isZoneUser);
		
		
		public List<RTIApplication> getCompletedApplications(
		        RTIApplicationSearch applicationSearch,
		        String userZone,
		        String userLevel,
		        boolean isZoneUser);
		public long getCompletedApplicationsCount(
		        RTIApplicationSearch applicationSearch,
		        String userZone,
		        String userLevel,
		        boolean isZoneUser);
		
}

 
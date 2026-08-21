package com.mars.rti.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.dao.FireRecommendationDAO;
import com.mars.rti.model.Collection;
import com.mars.rti.model.FireApplicationDTO;
import com.mars.rti.model.FireDetails;
import com.mars.rti.model.FireRecommendation;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.common.search.ApplicationSearch;
import com.mars.rti.service.FireRecommendationService;
import com.mars.workflow.model.WorkflowTemplateUserMappingDetails;

@Service
public class FireRecommendationServiceImpl implements FireRecommendationService {
    
	@Autowired
	private FireRecommendationDAO fireRecommendationDAO;
	@Override
	public FireRecommendation saveFireForm(FireRecommendation fireRecommendation) {
		return fireRecommendationDAO.saveFireRecommendation(fireRecommendation);

	}

	public FireRecommendation merge(FireRecommendation entity) {
		
		return fireRecommendationDAO.merge(entity);
	}
	
	@Override
	public long fireRecommendation(FireRecommendation fireRecommendation){
		
		return fireRecommendationDAO.fireRecommendationSave(fireRecommendation);
	}

	@Override
	public FireRecommendation get(long rtiApplicationRefId) {
		
		return fireRecommendationDAO.get(rtiApplicationRefId);
	}
	
	@Override
	public  List<RTIApplication> getnoc(long serviceId){
		return fireRecommendationDAO.getnoc(serviceId);
	}
	
	@Override
	public FireRecommendation getnocDetails(long serviceId) {
		return fireRecommendationDAO.getnocDetails(serviceId);
	}
 
	@Override
	public List<FireDetails> getFireDetails(long fireRecommendationId){
		return fireRecommendationDAO.getFireDetails(fireRecommendationId);
	}
	
	public void delete(long id) {
		
		fireRecommendationDAO.delete(id);
	}
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public FireRecommendation getApplicationId(String  applicationId) {
		return fireRecommendationDAO.getApplicationId(applicationId);
	}

	@Override
	public List<RTIApplication> getFireApplications(RTIApplicationSearch applicationSearch,String userZone,String userLevel,boolean isZoneUser) {
	      return this.fireRecommendationDAO.getFireApplications(applicationSearch, userZone, userLevel, isZoneUser);
	   }

	@Override
	public long getFireApplicationsCount(RTIApplicationSearch applicationSearch,String userZone,String userLevel,boolean isZoneUser) {
		      return this.fireRecommendationDAO.getFireApplicationsCount(applicationSearch, userZone, userLevel, isZoneUser);
	   }

	@Override
	public List<FireDetails> findByFireRecommendationId(long fireRecommendationId) {
	    return fireRecommendationDAO.findByFireRecommendationId(fireRecommendationId);
	}
	
	@Override
	public void updateFireForm(FireRecommendation fireRecommendation) {
		fireRecommendationDAO.update(fireRecommendation);
	}
	
	@Override
	public FireRecommendation getDetails(long rtiApplicationId) {
		return fireRecommendationDAO.getDetails(rtiApplicationId);
	}
	
	// ===================== SERVICE METHOD =====================

	@Override
	@Transactional
	public void saveUpdatedFees(Long fireId,
	                            String feesRemarks,
	                            String updatedScrutinyFees,
	                            String updatedTotalFees) {

	    fireRecommendationDAO.saveUpdatedFees(
	            fireId,
	            feesRemarks,
	            updatedScrutinyFees,
	            updatedTotalFees);
	}
	
	@Override
	public String getForwardUser(String zone, String category) {
		return fireRecommendationDAO.getForwardUser(zone,category);
	}
	
	@Override
	public Map<Long, List<Collection>> getPaymentMap(List<RTIApplication> applications) {

	    return fireRecommendationDAO.getPaymentMap(applications);
	}
	
	@Override
	public List<RTIApplication> getCitizenApplications(
	        RTIApplicationSearch applicationSearch,
	        String userZone,
	        String userLevel,
	        boolean isZoneUser){
	    return fireRecommendationDAO.getCitizenApplications(applicationSearch,userZone,userLevel,isZoneUser);

	}
	@Override
	public long getCitizenApplicationsCount(
	        RTIApplicationSearch applicationSearch,
	        String userZone,
	        String userLevel,
	        boolean isZoneUser) {
	    return fireRecommendationDAO.getCitizenApplicationsCount(applicationSearch,userZone,userLevel,isZoneUser);

		
	}
	
	@Override
	public List<RTIApplication> getForwardedApplications(
	        RTIApplicationSearch applicationSearch,
	        String userZone,
	        String userLevel,
	        boolean isZoneUser){
	    return fireRecommendationDAO.getForwardedApplications(applicationSearch,userZone,userLevel,isZoneUser);

		
	}
	
	@Override
	public long getForwardedApplicationsCount(
	        RTIApplicationSearch applicationSearch,
	        String userZone,
	        String userLevel,
	        boolean isZoneUser) {
		
	    return fireRecommendationDAO.getForwardedApplicationsCount(applicationSearch,userZone,userLevel,isZoneUser);

	}
	
	@Override
	public List<RTIApplication> getL1Applications(
	        RTIApplicationSearch applicationSearch,
	        String userZone,
	        String userLevel,
	        boolean isZoneUser) {
	    return fireRecommendationDAO.getL1Applications(applicationSearch,userZone,userLevel,isZoneUser);

	}
	
	@Override
	public long getL1ApplicationsCount(
	        RTIApplicationSearch applicationSearch,
	        String userZone,
	        String userLevel,
	        boolean isZoneUser) {
	    return fireRecommendationDAO.getL1ApplicationsCount(applicationSearch,userZone,userLevel,isZoneUser);

		
	}

	@Override
	public List<FireApplicationDTO> getTotalApplications(RTIApplicationSearch applicationSearch, String userZone,
			String userLevel, boolean isZoneUser) {
		// TODO Auto-generated method stub
	    return fireRecommendationDAO.getTotalApplications(applicationSearch,userZone,userLevel,isZoneUser);
	}

	@Override
	public long getTotalApplicationsCount(RTIApplicationSearch applicationSearch, String userZone, String userLevel,
			boolean isZoneUser) {
		// TODO Auto-generated method stub
	    return fireRecommendationDAO.getTotalApplicationsCount(applicationSearch,userZone,userLevel,isZoneUser);
	}

	@Override
	public List<RTIApplication> getCompletedApplications(RTIApplicationSearch applicationSearch, String userZone,
			String userLevel, boolean isZoneUser) {
		// TODO Auto-generated method stub
	    return fireRecommendationDAO.getCompletedApplications(applicationSearch,userZone,userLevel,isZoneUser);
	}

	@Override
	public long getCompletedApplicationsCount(RTIApplicationSearch applicationSearch, String userZone, String userLevel,
			boolean isZoneUser) {
		// TODO Auto-generated method stub
	    return fireRecommendationDAO.getCompletedApplicationsCount(applicationSearch,userZone,userLevel,isZoneUser);
	}
}
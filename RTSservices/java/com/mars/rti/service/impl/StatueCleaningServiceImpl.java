package com.mars.rti.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.dao.StatueCleaningDAO;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.StatueCleaning;
//import com.mars.rti.model.ToiletCleaningBlockUnit;
//import com.mars.rti.model.ToiletCleaningZones;
import com.mars.rti.search.RTIApplicationSearch;
//import com.mars.rti.search.StatueCleaningSearch;
import com.mars.rti.service.StatueCleaningService;

@Service
public class StatueCleaningServiceImpl implements StatueCleaningService {
	@Autowired
	private StatueCleaningDAO statueCleaningDAO;

	@Override
	public String getCurrentShiftFromDB() {
	    return statueCleaningDAO.getCurrentShiftFromDB();
	}

	@Transactional
	public void saveStatueCleaning(StatueCleaning statueCleaning) {

		this.statueCleaningDAO.saveStatueCleaning(statueCleaning);
	}

	@Override
	public long getCleaningId(StatueCleaning statueCleaning) {

		return this.statueCleaningDAO.getCleaningId(statueCleaning);
	}

	@Override
	public List<StatueCleaning> getStatueCleaningList() {
		return this.statueCleaningDAO.getStatueCleaningList();

	}

	@Override
	public StatueCleaning get(long cleaningId) {

		return this.statueCleaningDAO.get(cleaningId);
	}

	@Override
	public StatueCleaning merge(StatueCleaning entity) {

		return statueCleaningDAO.merge(entity);
	}

//	public List<StatueCleaning> getStatueCleaningList(StatueCleaningSearch searchOptions) {
//		
//		return statueCleaningDAO.getStatueCleaningList(searchOptions);
//		
//	}
//	
//	public long getStatueCleanApplicationCount(StatueCleaningSearch searchOptions) {
//		
//		return statueCleaningDAO.getStatueCleanApplicationCount(searchOptions);
//	}
//	
//	public List<StatueCleaning> getStatueCleaningDraftList(StatueCleaningSearch searchOptions,String todayDate,String currentShift){
//		return statueCleaningDAO.getStatueCleaningDraftList(searchOptions,todayDate,currentShift);
//
//	}
//	
//	public long getStatueCleanApplicationDraftCount(StatueCleaningSearch searchOptions,String todayDate,String currentShift) {
//		return statueCleaningDAO.getStatueCleanApplicationDraftCount(searchOptions,todayDate,currentShift);
//
//	}
	
	
	public void save(StatueCleaning entity) {
		
		statueCleaningDAO.save(entity);
	}

	//@Override
//	public List<ToiletCleaningZones> getToiletCleaningZones() {
//		// TODO Auto-generated method stub
//		return statueCleaningDAO.getToiletCleaningZones();
//	}
//
//	@Override
//	public List<ToiletCleaningBlockUnit> getToiletCleaningBlockUnit() {
//		// TODO Auto-generated method stub
//		return statueCleaningDAO.getToiletCleaningBlockUnit();
//	}

	@Override
	public List<StatueCleaning> getBlockExistingNumberLists(String zone, String shift, String currentDate) {
		// TODO Auto-generated method stub
		return statueCleaningDAO.getBlockExistingNumberLists(zone,shift,currentDate);
	}
	
//	@Override
//	public List<Object[]> getStatueCleaningDraft(StatueCleaningSearch searchOptions, String currentDate, String shift) {
//		return statueCleaningDAO.getStatueCleaningDraft(searchOptions,currentDate,shift);
//
//	}
//	
//	@Override
//	public long getStatueCleanApplicationDraft(StatueCleaningSearch searchOptions,String todayDate,String currentShift) {
//		return statueCleaningDAO.getStatueCleanApplicationDraft(searchOptions,todayDate,currentShift);
//
//	}
//	
//	
	@Override
	public List<StatueCleaning> getByGroupId(String groupId) {
		return statueCleaningDAO.getByGroupId(groupId);
		
	}
	

}

	
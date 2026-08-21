package com.mars.rti.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.StatueCleaning;
//import com.mars.rti.model.ToiletCleaningBlockUnit;
//import com.mars.rti.model.ToiletCleaningZones;
import com.mars.rti.search.RTIApplicationSearch;
//import com.mars.rti.search.StatueCleaningSearch;

public interface StatueCleaningService {

	String getCurrentShiftFromDB();

	void saveStatueCleaning(StatueCleaning statueCleaning);

	long getCleaningId(StatueCleaning statueCleaning);
	
	public List<StatueCleaning> getStatueCleaningList();
	
	public StatueCleaning get(long cleaningId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public StatueCleaning merge(StatueCleaning entity);
	
//	public List<StatueCleaning> getStatueCleaningList(StatueCleaningSearch searchOptions);
//	
//	public long getStatueCleanApplicationCount(StatueCleaningSearch searchOptions);
//	
//	
//	public List<StatueCleaning> getStatueCleaningDraftList(StatueCleaningSearch searchOptions,String todayDate,String currentShift);
//	
//	public long getStatueCleanApplicationDraftCount(StatueCleaningSearch searchOptions,String todayDate,String currentShift);
//	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(StatueCleaning entity);
	
//	 @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
//		public List<ToiletCleaningZones> getToiletCleaningZones();
//	    
//	 @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
//		public List<ToiletCleaningBlockUnit> getToiletCleaningBlockUnit();
//	 
	 @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
		public List<StatueCleaning> getBlockExistingNumberLists(String zone,String shift,String currentDate);
//	 public List<Object[]> getStatueCleaningDraft(StatueCleaningSearch searchOptions, String currentDate, String shift);
//		
//		public long getStatueCleanApplicationDraft(StatueCleaningSearch searchOptions,String todayDate,String currentShift);

	 public List<StatueCleaning> getByGroupId(String groupId) ;

}

package com.mars.rti.dao;

import java.util.List;
import java.util.Map;

import com.mars.rti.model.StatueCleaning;
//import com.mars.rti.model.ToiletCleaningBlockUnit;
//import com.mars.rti.model.ToiletCleaningZones;
import com.mars.rti.search.RTIApplicationSearch;
//import com.mars.rti.search.StatueCleaningSearch;

public interface StatueCleaningDAO {

	String getCurrentShiftFromDB();

	void saveStatueCleaning(StatueCleaning statuecleaning);

	long getCleaningId(StatueCleaning var1);

	public List<StatueCleaning> getStatueCleaningList();

	public StatueCleaning get(long cleaningId);

	public StatueCleaning merge(StatueCleaning entity);
	
	//public List<StatueCleaning> getStatueCleaningList(StatueCleaningSearch searchOptions);
	
	//public long getStatueCleanApplicationCount(StatueCleaningSearch searchOptions);
	
	public void save(StatueCleaning entity);
	//public List<ToiletCleaningZones> getToiletCleaningZones();

	//public List<ToiletCleaningBlockUnit> getToiletCleaningBlockUnit();
	public List<StatueCleaning> getBlockExistingNumberLists(String zone,String shift,String currentDate);

	//public List<StatueCleaning> getStatueCleaningDraftList(StatueCleaningSearch searchOptions,String todayDate,String currentShift);
	
	//public long getStatueCleanApplicationDraftCount(StatueCleaningSearch searchOptions,String todayDate,String currentShift);
	
	public List<StatueCleaning> getDataByGroupId(String groupId);
	

	//public List<Object[]> getStatueCleaningDraft(StatueCleaningSearch searchOptions, String currentDate, String shift) ;
	
	//public long getStatueCleanApplicationDraft(StatueCleaningSearch searchOptions,String todayDate,String currentShift);
	
	public List<StatueCleaning> getByGroupId(String groupId) ;

}
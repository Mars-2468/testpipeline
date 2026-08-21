package com.mars.rti.dao;

import java.math.BigInteger;
import java.util.List;

import com.mars.rti.model.RTIApplication;
import com.mars.rti.search.DashBoardLabelSearch;

public interface DashBoardDAO {
	
	public long getPieChartOrBarChartData(String userZone,String serviceId,String currentYear);
	//public long getPieChartOrBarChartDatas(String condValue,String serviceId);
	public long getPieChartOrBarChartData(String condValue,String userZone,String serviceId,String currentYear);
	public long getPieChartOrBarChartData(String condValue1,String condValue2,String condValue3,String userZone,String serviceId,String currentYear);
	
	public List<BigInteger> getPieChartOrBarChartBasedOnSearch(String registrtionFromDate,
            String registrtionToDate,
            String departments,
           String services,String userZone,String serviceId,String currentYear);
	
	public List<RTIApplication> getRTIApplicationListByLabel(DashBoardLabelSearch dashBoardLabelSearch,String userZone,String serviceId,String currentYear,String searchrtiApplnNumber);
	public List<RTIApplication> getRTIApplicationListByLabelAll(DashBoardLabelSearch dashBoardLabelSearch,String userZone,String serviceId,String currentYear,String searchrtiApplnNumber);

	public long getRTIApplicationCountByLabel(
			DashBoardLabelSearch dashBoardLabelSearch,String userZone,String serviceId,String currentYear,String searchrtiApplnNumber);
	//public long getPieChartOrBarChartDatas(long serviceId);
	public double getPieChartOrBarChartDatas(String userZone,String serviceId,String currentYear);
	public long getPieChartOrBarChartDataForPoliceNoc(String userZone,String serviceId,String currentYear);
	public long getPieChartOrBarChartDataForTrafficNoc(String userZone,String serviceId,String currentYear);
	public long getPieChartOrBarChartDataForFireNoc(String userZone,String serviceId,String currentYear);
	List<Object> getServiceId(String sql);
	
}

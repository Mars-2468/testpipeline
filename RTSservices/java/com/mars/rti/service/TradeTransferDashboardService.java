package com.mars.rti.service;

import java.math.BigInteger;
import java.util.List;

import com.mars.rti.model.RTIApplication;
import com.mars.rti.search.DashBoardLabelSearch;

public interface TradeTransferDashboardService {
	public long getPieChartOrBarChartData();
	public long getPieChartOrBarChartData(String condValue);
	public long getPieChartOrBarChartData(String condValue1,String condValue2,String condValue3);
	
	public List<BigInteger> getPieChartOrBarChartBasedOnSearch(String registrtionFromDate,String registrtionToDate,String category);
	
	public List<RTIApplication> getRTIApplicationListByLabel(DashBoardLabelSearch dashBoardLabelSearch);
	public long getRTIApplicationCountByLabel(
			DashBoardLabelSearch dashBoardLabelSearch);
	public double getPieChartOrBarChartDatas();


}

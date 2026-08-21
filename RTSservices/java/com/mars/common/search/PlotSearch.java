package com.mars.common.search;

public class PlotSearch extends BaseSearchObject {

	private String number;
	private long plotTypeId;
	private long sectorId;
	private long nodeMasterId;
	private long wardId;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
		if(this.number!=null && this.number.length()>0){
			setSearchParamSet(true);			
		}
	}
	public long getPlotTypeId() {
		return plotTypeId;
	}
	public void setPlotTypeId(long plotTypeId) {
		this.plotTypeId = plotTypeId;
		if(this.plotTypeId>0){
			setSearchParamSet(true);
		}
	}
	public long getSectorId() {
		return sectorId;
	}
	public void setSectorId(long sectorId) {
		this.sectorId = sectorId;
		if(this.sectorId>0){
			setSearchParamSet(true);
		}
	}
	public long getNodeMasterId() {
		return nodeMasterId;
	}
	public void setNodeMasterId(long nodeMasterId) {
		this.nodeMasterId = nodeMasterId;
		if(this.nodeMasterId>0){
			setSearchParamSet(true);
		}
	}
	public long getWardId() {
		return wardId;
	}
	public void setWardId(long wardId) {
		this.wardId = wardId;
		if(this.wardId>0){
			setSearchParamSet(true);
		}
	}
	
}

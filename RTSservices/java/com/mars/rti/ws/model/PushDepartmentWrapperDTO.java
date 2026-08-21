package com.mars.rti.ws.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PushDepartmentWrapperDTO {

    private Integer Year;
    private Integer Month;
    private List<PushDepartmentDTO> RowData;
	public Integer getYear() {
		return Year;
	}
	public void setYear(Integer year) {
		Year = year;
	}
	public Integer getMonth() {
		return Month;
	}
	public void setMonth(Integer month) {
		Month = month;
	}
	public List<PushDepartmentDTO> getRowData() {
		return RowData;
	}
	public void setRowData(List<PushDepartmentDTO> rowData) {
		RowData = rowData;
	}

   
}

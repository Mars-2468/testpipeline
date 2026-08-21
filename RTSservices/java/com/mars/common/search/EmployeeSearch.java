package com.mars.common.search;

public class EmployeeSearch extends BaseSearchObject {
	
	private String firstName;
	//private String middleName;
	private String lastName;
	private long designationId;
	private long departmentId;
	
	public EmployeeSearch(){
	}
	
	public EmployeeSearch(String firstName){
		this.firstName=firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
		if (this.firstName != null && this.firstName.length() > 0)
		      setSearchParamSet(true);
	}

	
	public long getDesignationId() {
		return designationId;
	}

	public void setDesignationId(long designationId) {
		this.designationId = designationId;
		if(this.designationId != 0)setSearchParamSet(true);
	}
	
	
	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
		if(this.departmentId != 0)setSearchParamSet(true);
	}
	
	/*public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
		if(this.middleName != null  && this.middleName.length() > 0) setSearchParamSet(true);
	}
*/
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		if(this.lastName != null  && this.lastName.length() > 0)setSearchParamSet(true);
	}

	
	
	
}

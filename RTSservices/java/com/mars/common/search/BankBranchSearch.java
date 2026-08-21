package com.mars.common.search;

public class BankBranchSearch extends BaseSearchObject {

	private String branchName;
	
	private long bankId;
	
	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
		if(this.bankId>0){
			setSearchParamSet(true);
		}
	}

	public BankBranchSearch(){
	}
	
	public BankBranchSearch(String branchName,Long bankId){
		this.branchName=branchName;
		this.bankId=bankId;
	}
	
	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
		if (this.branchName != null && this.branchName.length() > 0)
		      setSearchParamSet(true);
	}
	
	
}

package com.mars.common.search;

public class BankSearch extends BaseSearchObject {
	
	private String bankName;
	
	public BankSearch(){
	}
	
	public BankSearch(String bankName){
		this.bankName=bankName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
		if (this.bankName != null && this.bankName.length() > 0)
		      setSearchParamSet(true);
	}
	
	

}

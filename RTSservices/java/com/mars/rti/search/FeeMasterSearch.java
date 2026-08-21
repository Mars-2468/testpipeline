package com.mars.rti.search;
import com.mars.common.search.BaseSearchObject;

public class FeeMasterSearch extends BaseSearchObject {
	
	
		
		private String name;
		private String fromDate;
		private String toDate;
		private int category=-1;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;

			if(this.name!=null && this.name.length()>0){
				setSearchParamSet(true);
			}
		}
		public String getFromDate() {
			return fromDate;
		}
		public void setFromDate(String fromDate) {
			this.fromDate = fromDate;

			if(this.fromDate!=null && this.fromDate.length()>0){
				setSearchParamSet(true);
			}
		}
		public String getToDate() {
			return toDate;
		}
		public void setToDate(String toDate) {
			this.toDate = toDate;

			if(this.toDate!=null && this.toDate.length()>0){
				setSearchParamSet(true);
			}
		}
		public int getCategory() {
			return category;
		}
		public void setCategory(int category) {
			this.category = category;

			if(this.category>=0){
				setSearchParamSet(true);
			}
		}
		
		
		
    
}

package com.mars.rti.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WaterDisconnectionPOJO {
	
		
	        @JsonProperty("status")
		    private int status;
	        
	        @JsonProperty("msg")
		    private String msg;
	        
	        @JsonProperty("data")
		    private List<Data> data;

		    public int getStatus() {
		        return status;
		    }

		    public void setStatus(int status) {
		        this.status = status;
		    }

		    public String getMsg() {
		        return msg;
		    }

		    public void setMsg(String msg) {
		        this.msg = msg;
		    }

		    public List<Data> getData() {
		        return data;
		    }

		    public void setData(List<Data> data) {
		        this.data = data;
		    }

		    public static class Data {
		        private String type;
		        private String contractAccountNo;
		        private String consumerName;
		        private String address;
		        private String meterNo;
		        private String zone;
		        private String command_area;
		        private String tap_size;
		        private String category;
		        private String balance_arrears;
		        private String cut_off_date;
		        private String contact_no;
		        private String email_id;


		        public String getType() {
		            return type;
		        }

		        public void setType(String type) {
		            this.type = type;
		        }

		        public String getContractAccountNo() {
		            return contractAccountNo;
		        }

		        public void setContractAccountNo(String contractAccountNo) {
		            this.contractAccountNo = contractAccountNo;
		        }

		        public String getConsumerName() {
		            return consumerName;
		        }

		        public void setConsumerName(String consumerName) {
		            this.consumerName = consumerName;
		        }

		        public String getAddress() {
		            return address;
		        }

		        public void setAddress(String address) {
		            this.address = address;
		        }

		        public String getMeterNo() {
		            return meterNo;
		        }

		        public void setMeterNo(String meterNo) {
		            this.meterNo = meterNo;
		        }

		        public String getZone() {
		            return zone;
		        }

		        public void setZone(String zone) {
		            this.zone = zone;
		        }

				public String getCommand_area() {
					return command_area;
				}

				public void setCommand_area(String command_area) {
					this.command_area = command_area;
				}

				public String getTap_size() {
					return tap_size;
				}

				public void setTap_size(String tap_size) {
					this.tap_size = tap_size;
				}

				public String getCategory() {
					return category;
				}

				public void setCategory(String category) {
					this.category = category;
				}

				public String getBalance_arrears() {
					return balance_arrears;
				}

				public void setBalance_arrears(String balance_arrears) {
					this.balance_arrears = balance_arrears;
				}

				public String getCut_off_date() {
					return cut_off_date;
				}

				public void setCut_off_date(String cut_off_date) {
					this.cut_off_date = cut_off_date;
				}

				public String getContact_no() {
					return contact_no;
				}

				public void setContact_no(String contact_no) {
					this.contact_no = contact_no;
				}

				public String getEmail_id() {
					return email_id;
				}

				public void setEmail_id(String email_id) {
					this.email_id = email_id;
				}
				
				
				
		        
		    }
		}


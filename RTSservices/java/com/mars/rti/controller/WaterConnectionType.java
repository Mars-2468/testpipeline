package com.mars.rti.controller;

import java.util.List;

public class WaterConnectionType {

	 private int status;
	    private String msg;
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
	        private String ConsumerName;
	        private String address;
	        private String meterNo;
	        private String zone;

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
	            return ConsumerName;
	        }

	        public void setConsumerName(String consumerName) {
	            ConsumerName = consumerName;
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
	    }
	
	
	
}

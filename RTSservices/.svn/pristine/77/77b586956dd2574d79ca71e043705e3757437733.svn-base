package com.mars.rti.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PropertyTaxToken {
	
	@JsonProperty("token")
    private String token;
	 
	@JsonProperty("clientId")
    private int clientId;
	 
	@JsonProperty("rptInpt")
    private RptInput rptInpt;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public RptInput getRptInpt() {
        return rptInpt;
    }

    public void setRptInpt(RptInput rptInpt) {
        this.rptInpt = rptInpt;
    }

    public static class RptInput {
    	
   	    @JsonProperty("ReportKey")
        private String reportKey;
   	 
   	    @JsonProperty("ReportParameter")
        private ReportParameter reportParameter;

       
        public String getReportKey() {
			return reportKey;
		}


		public void setReportKey(String reportKey) {
			this.reportKey = reportKey;
		}


		public ReportParameter getReportParameter() {
			return reportParameter;
		}


		public void setReportParameter(ReportParameter reportParameter) {
			this.reportParameter = reportParameter;
		}


		public static class ReportParameter {
        	
          	 @JsonProperty("PTN")
            private String ptn;

			public String getPtn() {
				return ptn;
			}

			public void setPtn(String ptn) {
				this.ptn = ptn;
			}

           
        }
    }
}

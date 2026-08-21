package com.mars.rti.ws.model;
import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mars.rti.model.RTIApplication;

	@SuppressWarnings("serial")
	@JsonPropertyOrder({ "FireCompliance" })

public class FirecompliancenocrestDTO  implements Serializable {
		private List<RTIApplication> FireCompliance;
		
		@XmlElement(name = "FireCompliance")
		public List<RTIApplication> getFireCompliance() {
			return FireCompliance;
		}

		
		public void setFireCompliance(List<RTIApplication> fireCompliance) {
			FireCompliance = fireCompliance;
		}


		public static void setResponse(String string) {
			// TODO Auto-generated method stub
			
		}


		public static void setResponseStatus(String string) {
			// TODO Auto-generated method stub
			
		}


		public static void setResponseStatus(int i) {
			// TODO Auto-generated method stub
			
		}


		public static void setStatus(String string) {
			// TODO Auto-generated method stub
			
		}


		
}

package com.mars.common.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mars.common.model.User;
import com.mars.rti.controller.AppliSarkarController;
import com.mars.rti.ws.model.AuthenticationResponseDTO;

import java.io.*;
import groovy.util.XmlParser;

@Controller
public class AapleSarkarPortalIntegrationNagpur {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AapleSarkarPortalIntegrationNagpur.class);

	private static Log log = LogFactory.getLog(AppliSarkarController.class);
	
	
	/*
	 * @Autowired private AapleSarkarPortalIntegrationNagpur
	 * aapleSarkarPortalIntegrationNagpur;
	 */

	String clientCode = "NMCDeptN";
	String checkSumkey = "GNGMCA8v3G7M";
	String Department = "NGMCN";
	String clientEncryptKey = "@pn@NGM@m@h@0nl!ne@30308";
	String clientEncryptIV  = "NGM@01@6";

	
	public String authentication(String str,String serviceId){
		
		String response = "false";
		
		try {

			
			String requestDecryStr = simpleTripleDesDecrypt(str, clientEncryptKey, clientEncryptIV);
			log.debug("requestDecryStr : " +requestDecryStr);
			log.debug("str in authentication method: "+str);

			String param[] = requestDecryStr.split("\\|");
			
			String checkValueRowData = "";
			String userId = param[0];
			String userTimeStamp = param[1];
			String userSession = param[2];
			String clientCheckSumValue = param[3]; // 2491092092
			String strServiceCookie = param[4];

			checkValueRowData = String.format("%s|%s|%s|%s|%s", userId, userTimeStamp, userSession, checkSumkey,
					strServiceCookie);
			log.debug("authentication checkValueRowData"+checkValueRowData);

			String caluculatedCheckSumValue = generateCheckSumValue(checkValueRowData); // 2491092092
			log.debug("authentication caluculatedCheckSumValue : " + caluculatedCheckSumValue);

			if (clientCheckSumValue.equals(caluculatedCheckSumValue)) {
				
				String responseXML = "";

				String xmlResponse = "";

				/*String xmlResponse1="";*/
			    
				xmlResponse = callPushWebService(str, clientCode);
				log.debug("authentication callPushWebService xmlResponse : "+xmlResponse);

				responseXML = simpleTripleDesDecrypt(xmlResponse, clientEncryptKey, clientEncryptIV);
				log.debug("authentication simpleTripleDesDecrypt responseXML" + responseXML);
				 XmlParser parser = new XmlParser();
//			        User user = parser.parseXml(responseXML);
			        
			        
			        

				LOGGER.error("ResponseXml: " + responseXML);
				
				
				List<String> output= new ArrayList<>();
				try {
					//output = getParameterResultFromXML(responseXML, "UserID");
					
					String trackId = getParameterResultFromXML(responseXML, "TrackId").get(0);
					log.debug("trackId :" + trackId);
					String clienctCode=clientCode;
					log.debug("clienctCode"+clienctCode);

					String userId1 = getParameterResultFromXML(responseXML, "UserID").get(0);
					log.debug("userId1 :"+userId1);
					String serviceID= serviceId;
					log.debug("serviceID :"+serviceID);
					String applicationId = "appId"; // Setting this since our applicationId will generate later
					log.debug("applicationId :" +applicationId);
					String payStatus = "N";
					log.debug(payStatus);
				    String payDate = "NA";
					String digitalstatus = "N";
					String digitalDate = "NA";
					String serviceDays = "365";
					String serviceDate = "NA";
					String amount = "0.0";
					String requestFlag = "0";
					String appstatus = "appStatus";
					String remark = "remark"; 
					String districtId = getParameterResultFromXML(responseXML, "DistrictID").get(0);
					log.debug("districtId : "+districtId);

					String mobileNo= getParameterResultFromXML(responseXML, "MobileNo").get(0);
					log.debug("mobileNo:"+mobileNo);

					String name = getParameterResultFromXML(responseXML, "FullName").get(0);
					log.debug("name :" +name);

					
					
					
					String request1 = String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s", 
							trackId, clienctCode, userId1, serviceID, applicationId, payStatus, payDate, digitalstatus, digitalDate, serviceDays, 
							serviceDate, amount, requestFlag, appstatus, remark, districtId, mobileNo, name, "NA", "NA", checkSumkey);
					log.debug("authentication request1"+request1);

					LOGGER.error("Request1: " + request1);
					
				
				    String checksumvalue = generateCheckSumValue(request1);
				 
					LOGGER.error(" authentication checksumvalue: " + checksumvalue);

				    response = String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s",
				    		trackId, clienctCode, userId, serviceID, applicationId, payStatus, payDate, digitalstatus, digitalDate, serviceDays, 
							serviceDate, amount, requestFlag, appstatus, remark, districtId, mobileNo, name, "NA", "NA", checksumvalue);
					log.debug("authentication method response : "+response);
				    LOGGER.error("request2: " + response);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				response = "false";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
		
	public AuthenticationResponseDTO authenticationResponseDTO(String str, String serviceId) {
	    AuthenticationResponseDTO dto = null;

	    try {
			/*
			 * String requestDecryStr = simpleTripleDesDecrypt(str, clientEncryptKey,
			 * clientEncryptIV); log.debug("Decrypted Request String: " + requestDecryStr);
			 * 
			 * String[] param = requestDecryStr.split("\\|");
			 * 
			 * if (param.length < 5) { log.error("Invalid request parameters."); return
			 * null; }
			 */
	        
			/*
			 * for (int i = 0; i < param.length; i++) {
			 * log.debug("response from apale sarkar XX: " + i + ": " + param[i]); }
			 */
	        
	        String xmlResponse_NEW = authentication(str, serviceId);
			
			log.debug("RESPONSE DTO XML -->: "+xmlResponse_NEW);
			
			
			if(!xmlResponse_NEW.equalsIgnoreCase("false")) {
			 String[] fields = xmlResponse_NEW.split("\\|");
			 
			 for (int i = 0; i < fields.length; i++) {
	        	  log.debug("RESPONSE DTO XX: " + i + ": " + fields[i]);
	        }
			}
			
			InputStream is = new ByteArrayInputStream(xmlResponse_NEW.getBytes());

	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        Document doc = builder.parse(is);
	        doc.getDocumentElement().normalize();

	        // Get specific element by tag name
	        String trackId = doc.getElementsByTagName("TrackId").item(0).getTextContent();
	        System.out.println("TrackId = " + trackId);

	        String Username = doc.getElementsByTagName("Username").item(0).getTextContent();
	        System.out.println("Username = " + Username);
	        
	        //String serviceIdnew = doc.getElementsByTagName("TrackId").item(0).getTextContent();
	       // System.out.println("serviceId = " + serviceId);
	       
	        //String clienctCode = doc.getElementsByTagName("clienctCode").item(0).getTextContent();
	       // System.out.println("serviceId = " + clienctCode);
	        
	        //String payStatus = doc.getElementsByTagName("payStatus").item(0).getTextContent();
	        //System.out.println("serviceId = " + payStatus);
	        
	        //String payDate = doc.getElementsByTagName("payDate").item(0).getTextContent();
	       // System.out.println("serviceId = " + payDate);
	        
	        //String digitalDate = doc.getElementsByTagName("digitalDate").item(0).getTextContent();
	       // System.out.println("digitalDate = " + digitalDate);
	        
	        //String serviceDays = doc.getElementsByTagName("serviceDays").item(0).getTextContent();
	        //System.out.println("serviceDays = " + digitalDate);
	        
	        
	      //  String serviceDate = doc.getElementsByTagName("serviceDate").item(0).getTextContent();
	        //System.out.println("serviceDays = " + serviceDate);
	        
	        
	       // String amount = doc.getElementsByTagName("amount").item(0).getTextContent();
	       // System.out.println("amount = " + amount);
	        
	        //String amount = doc.getElementsByTagName("amount").item(0).getTextContent();
	       // System.out.println("amount = " + amount);
	        
	        
	      //  String appStatus = doc.getElementsByTagName("appStatus").item(0).getTextContent();
	      //  System.out.println("amount = " + appStatus);
	        
	        
	       // String remark = doc.getElementsByTagName("remark").item(0).getTextContent();
	        //System.out.println("remark = " + remark);
	        
	        String districtId = doc.getElementsByTagName("DistrictID").item(0).getTextContent();
	        System.out.println("districtId = " + districtId);
	        
	        String mobileNo = doc.getElementsByTagName("MobileNo").item(0).getTextContent();
	        System.out.println("mobileNo = " + mobileNo);
	        
	        
	        String name = doc.getElementsByTagName("FullName").item(0).getTextContent();
	        System.out.println("name = " + name);
	        
	        
	      //  String digitalStatus = doc.getElementsByTagName(digitalStatus).item(0).getTextContent();
	       // System.out.println("digitalStatus = " + digitalStatus);
	        
	      //  String requestFlag = doc.getElementsByTagName(requestFlag).item(0).getTextContent();
	       // System.out.println("requestFlag = " + requestFlag);
	        
	       // String checksumValue = doc.getElementsByTagName(checksumValue).item(0).getTextContent();
	        //System.out.println("checksumValue = " + checksumValue);
	        
			 dto = new AuthenticationResponseDTO(); 
			 dto.setTrackId(trackId);
			 // dto.setClientCode(clienctCode); 
			  //dto.setUserId(userId1);
			 //dto.setServiceId(clienctCode); 
			 
			// dto.setApplicationId(applicationId);
			 //dto.setPayStatus(payStatus); 
			 //dto.setPayDate(payDate);
			//  dto.setDigitalStatus(digitalStatus); 
			  
			 // dto.setDigitalDate(digitalDate);
			 //dto.setServiceDays(serviceDays); 
			 //dto.setServiceDate(serviceDate);
			// dto.setAmount(amount); 
			 //dto.setRequestFlag(requestFlag);
			 // dto.setAppStatus(appStatus); 
			 // dto.setRemark(remark);
			 dto.setDistrictId(districtId); 
			 dto.setMobileNo(mobileNo); dto.setName(name);
			 dto.setReserved1("NA"); 
			 dto.setReserved2("NA");
			// dto.setChecksumValue(checksumValue);

	        //String userId = param[0];
	       // String userTimeStamp = param[1];
	       // String userSession = param[2];
	       // String clientCheckSumValue = param[3];
	       // String strServiceCookie = param[4];
	        
	       
	        //String checkValueRowData = String.format("%s|%s|%s|%s|%s", userId, userTimeStamp, userSession, checkSumkey, strServiceCookie);
	       // log.debug("Checksum Input String: " + checkValueRowData);

	       // String calculatedCheckSumValue = generateCheckSumValue(checkValueRowData);
	        //log.debug("Calculated Checksum: " + calculatedCheckSumValue);

			/*
			 * if (clientCheckSumValue.equals(calculatedCheckSumValue)) { String xmlResponse
			 * = callPushWebService(str, clientCode); log.debug("Encrypted XML Response: " +
			 * xmlResponse);
			 * 
			 * String responseXML = simpleTripleDesDecrypt(xmlResponse, clientEncryptKey,
			 * clientEncryptIV); log.debug("Decrypted XML Response: " + responseXML);
			 * LOGGER.error("Response XML: " + responseXML);
			 * 
			 * try { String trackId = getParameterResultFromXML(responseXML,
			 * "TrackId").get(0); String clienctCode = clientCode; String userId1 =
			 * getParameterResultFromXML(responseXML, "UserID").get(0); String applicationId
			 * = "appId"; String payStatus = "N"; String payDate = "NA"; String
			 * digitalStatus = "N"; String digitalDate = "NA"; String serviceDays = "365";
			 * String serviceDate = "NA"; String amount = "0.0"; String requestFlag = "0";
			 * String appStatus = "appStatus"; String remark = "remark"; String districtId =
			 * getParameterResultFromXML(responseXML, "DistrictID").get(0); String mobileNo
			 * = getParameterResultFromXML(responseXML, "MobileNo").get(0); String name =
			 * getParameterResultFromXML(responseXML, "FullName").get(0);
			 * 
			 * String request1 = String.format(
			 * "%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s", trackId,
			 * clienctCode, userId1, serviceId, applicationId, payStatus, payDate,
			 * digitalStatus, digitalDate, serviceDays, serviceDate, amount, requestFlag,
			 * appStatus, remark, districtId, mobileNo, name, "NA", "NA", checkSumkey);
			 * 
			 * log.debug("Checksum Input for Response: " + request1);
			 * LOGGER.error("Request1: " + request1);
			 * 
			 * String checksumValue = generateCheckSumValue(request1);
			 * LOGGER.error("Checksum Value: " + checksumValue);
			 * 
			 * dto = new AuthenticationResponseDTO(); dto.setTrackId(trackId);
			 * dto.setClientCode(clienctCode); dto.setUserId(userId1);
			 * dto.setServiceId(serviceId); dto.setApplicationId(applicationId);
			 * dto.setPayStatus(payStatus); dto.setPayDate(payDate);
			 * dto.setDigitalStatus(digitalStatus); dto.setDigitalDate(digitalDate);
			 * dto.setServiceDays(serviceDays); dto.setServiceDate(serviceDate);
			 * dto.setAmount(amount); dto.setRequestFlag(requestFlag);
			 * dto.setAppStatus(appStatus); dto.setRemark(remark);
			 * dto.setDistrictId(districtId); dto.setMobileNo(mobileNo); dto.setName(name);
			 * dto.setReserved1("NA"); dto.setReserved2("NA");
			 * dto.setChecksumValue(checksumValue);
			 * 
			 * } catch (Exception e) { log.error("Error parsing response XML", e); } } else
			 * { log.error("Checksum validation failed."); }
			 */

	    } catch (Exception e) {
	        log.error("Exception in authenticationResponseDTO", e);
	    }

	    return dto;
	}

	public String getUpdateStatus(String str){

		String xmlResponse1="";
	    
		try {

		    LOGGER.error("request2: " + str);
		    
		    String encKey = simpleTripleDes(str, clientEncryptKey, clientEncryptIV);
		    
		    
		    //String encKey = SimpleTripleDes(str, clientEncryptKey, clientEncryptIV);
		    
		    
		    LOGGER.error("EncKey: " + encKey);

		    xmlResponse1 = callPullWebService(encKey, clientCode);
		    
		    String requestDecryStr = simpleTripleDesDecrypt(xmlResponse1, clientEncryptKey, clientEncryptIV);
		    
		    xmlResponse1 =requestDecryStr;
		    
			LOGGER.error("Response Array is "+ xmlResponse1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		return xmlResponse1;
		
	}	
	
	
	public String getParameterData(List<String> output){
		
		
		String[] strarray = new String[output.size()];
		 String[] array = output.toArray(strarray);
		
		 String userID="";
		 
		 if(array.length>0){
				log.debug(strarray);
				log.debug(array);

		 LOGGER.error("Response Array is "+ array[0]);
		 userID=array[0];
		 }
		
		return "";
	}

	
		public String simpleTripleDesDecrypt(String Data, String strKey, String striv)
		{
			byte[] key = strKey.getBytes(StandardCharsets.UTF_8);
		    byte[] iv = striv.getBytes(StandardCharsets.UTF_8);
		    byte[] data = stringToByteArray(Data);
		    log.debug("simpleTripleDesDecrypt key :" +key);
	        log.debug("simpleTripleDesDecrypt iv :" +iv);
	        log.debug("simpleTripleDesDecrypt data :" +data);
		    byte[] enc = new byte[0];
		    try {
		        Cipher cipher = Cipher.getInstance("DESede/CBC/NoPadding");
		        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "DESede");
				log.debug(cipher);
		        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
				log.debug(ivParameterSpec);
		        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
				log.debug(cipher);
		        enc = cipher.doFinal(data); 
				log.debug(enc);

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		  return new String(enc, StandardCharsets.UTF_8).trim().replaceAll("[" + "\0" + "]+$", "").replaceAll("[" + "|" + "]+$", "");
		}
		
		public static String bytesToHex(byte[] bytes) {
		    StringBuilder hexString = new StringBuilder();
		    for (byte b : bytes) {
		        String hex = Integer.toHexString(0xff & b);
		        if (hex.length() == 1) {
		            hexString.append('0');
		        }
		        hexString.append(hex);
		    }
		    return hexString.toString();
		}

		private byte[] stringToByteArray(String hex) {
			int numberChars = hex.length();
        
			byte[] bytes = new byte[numberChars / 2];
			for (int i = 0; i < numberChars; i += 2) {
            bytes[i / 2] = (byte) Integer.parseInt(hex.substring(i, i + 2), 16);
        	}
	        log.debug("stringToByteArray bytes: "+bytes);

        return bytes;
		}
		
		public static String generateCheckSumValue(String reqStr) {
		    byte[] bytes = reqStr.getBytes(StandardCharsets.US_ASCII);
		    CRC32 crc32 = new CRC32();
		    crc32.update(bytes);
		    long checksumvalue = crc32.getValue();
		    return Long.toString(checksumvalue);
		}
		
		
		public static String callPushWebService(String str,String clientCode){
			String xmlResponse="";
			try {
				
//				 String url= ApplicationSession.getInstance().getMessage("aaple.sarkar.url");
				// String url = "http://testcitizenservices.MahaITgov.in/Dept_Authentication.asmx";
				String url="https://aaplesarkar.mahaonline.gov.in/Dept_Authentication.asmx";
				 URL obj = new URL(url);
				 HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				 con.setRequestMethod("POST");
				 con.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
				 //String encKey="C6A85267FD7B63F14F9A787E21CE488097E8990F2648C005CB4F4E7C15268D29AB322B347962659F1AACB9F8EF66E6488C4D7375533BFFD48887ACBEB6E7088454B84F649B2C1FA186EBFCFA60C59B5AE3020E3EBDF4CB8344BCDBD184A5D7A71CD0FDFBE050482C431AF0F4C01B1E6998D8F57969D174142994B6E8F16CC724";
				 //String deptCode="CIDCO";
				 String xml = "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\"> <soap12:Body> <GetParameterNew xmlns=\"http://tempuri.org/\"> <EncyKey>"+str+"</EncyKey> <DeptCode>"+clientCode+"</DeptCode> </GetParameterNew> </soap12:Body> </soap12:Envelope>";
				 con.setDoOutput(true);
				 DataOutputStream wr = new DataOutputStream(con.getOutputStream());
				 wr.writeBytes(xml);
				 wr.flush();
				 wr.close();
				 String responseStatus = con.getResponseMessage();
				 System.out.println(responseStatus);
				 BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				 String inputLine;
				 StringBuffer response = new StringBuffer();
				 while ((inputLine = in.readLine()) != null) {
				 response.append(inputLine);
				 }
				 in.close();
				 LOGGER.error("response:" + response.toString());
				 String string2 = response.toString();
				
				 List<String> output = getParameterResultFromXML(string2, "GetParameterNewResult");
				 
				 String[] strarray = new String[output.size()];
				 String[] array = output.toArray(strarray);
				
				 if(array.length>0){
				 LOGGER.error("Response Array is "+ array[0]);
				 xmlResponse=array[0];
				 }
				 
			} catch (Exception e) {
				LOGGER.error("Response Array is "+ e); 
				 }
			
			return xmlResponse;
			
		}
		
		public static Document loadXMLString(String response) throws Exception
		{
		    DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
		    DocumentBuilder db = dbf.newDocumentBuilder();
		    InputSource is = new InputSource(new StringReader(response));

		    return db.parse(is);
		}

		public static List<String> getParameterResultFromXML(String response, String tagName) throws Exception {
		    Document xmlDoc = loadXMLString(response);
		    NodeList nodeList = xmlDoc.getElementsByTagName(tagName);
		    List<String> ids = new ArrayList<String>(nodeList.getLength());
		    for(int i=0;i<nodeList.getLength(); i++) {
		        org.w3c.dom.Node x = nodeList.item(i);
		        ids.add(x.getFirstChild().getNodeValue());             
		        System.out.println(nodeList.item(i).getFirstChild().getNodeValue());
		    }
		    return ids;
		}
		
		
		public static String simpleTripleDes(String Data, String strKey, String striv) {
	        byte[] key = strKey.getBytes(StandardCharsets.UTF_8);
	        byte[] iv = striv.getBytes(StandardCharsets.UTF_8);
	        byte[] data = Data.getBytes(StandardCharsets.UTF_8);
	        log.debug("simpleTripleDes key :" +key);
	        log.debug("simpleTripleDes iv :" +iv);
	        log.debug("simpleTripleDes data :" +data);

	        byte[] enc;
	        String encrypted;
	        try {
	           // Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
	        	Cipher cipher = Cipher.getInstance("DESede/CBC/NoPadding");
	            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "DESede");
	            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
	            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
	            byte[] paddedData = padZeros(data, 8); // Padding with zeros to match C# PaddingMode.Zeros
	           enc = cipher.doFinal(paddedData);
	           encrypted = bytesToHex(enc);;
	            return encrypted;
	            //enc = cipher.doFinal(data);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    

	
		}
		
		   private static byte[] padZeros(byte[] source, int blockSize) {
		        int paddedSize = ((source.length + blockSize - 1) / blockSize) * blockSize;
		        byte[] padded = new byte[paddedSize];
		        System.arraycopy(source, 0, padded, 0, source.length);
		        return padded;
		    }
		
		
		public static String callPullWebService(String str,String clientCode){
			String xmlResponse="";
			try {
				
//				 String url= ApplicationSession.getInstance().getMessage("aaple.sarkar.url");
				 //String url = "http://testcitizenservices.MahaITgov.in/Dept_Authentication.asmx";
				String url="https://aaplesarkar.mahaonline.gov.in/Dept_Authentication.asmx";
				 URL obj = new URL(url);
				 HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				 con.setRequestMethod("POST");
				 con.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
				 //String encKey="C6A85267FD7B63F14F9A787E21CE488097E8990F2648C005CB4F4E7C15268D29AB322B347962659F1AACB9F8EF66E6488C4D7375533BFFD48887ACBEB6E7088454B84F649B2C1FA186EBFCFA60C59B5AE3020E3EBDF4CB8344BCDBD184A5D7A71CD0FDFBE050482C431AF0F4C01B1E6998D8F57969D174142994B6E8F16CC724";
				 //String deptCode="CIDCO";
				 //String xml = "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\"> <soap12:Body> <GetParameterNew xmlns=\"http://tempuri.org/\"> <EncyKey>"+str+"</EncyKey> <DeptCode>"+clientCode+"</DeptCode> </GetParameterNew> </soap12:Body> </soap12:Envelope>";
				 
				 String xml = "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\"> <soap12:Body> <SetAppStatus xmlns=\"http://tempuri.org/\"> <EncyKey>"+str+"</EncyKey> <DeptCode>"+clientCode+"</DeptCode> </SetAppStatus> </soap12:Body> </soap12:Envelope>";

				 con.setDoOutput(true);
				 DataOutputStream wr = new DataOutputStream(con.getOutputStream());
				 wr.writeBytes(xml);
				 wr.flush();
				 wr.close();
				 String responseStatus = con.getResponseMessage();
				 System.out.println(responseStatus);
				 BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				 String inputLine;
				 StringBuffer response = new StringBuffer();
				 while ((inputLine = in.readLine()) != null) {
				 response.append(inputLine);
				 }
				 in.close();
				 LOGGER.error("response:" + response.toString());
				 String string2 = response.toString();
				
				 List<String> output = getParameterResultFromXML(string2, "SetAppStatusResult");
				 
				 String[] strarray = new String[output.size()];
				 String[] array = output.toArray(strarray);
				
				 if(array.length>0){
				 LOGGER.error("Response Array is "+ array[0]);
				 xmlResponse=array[0];
				 }
				 
			} catch (Exception e) {
				LOGGER.error("Response Array is "+ e); 
				 }
			
			return xmlResponse;
			
		}


	public String redirectForAapleSarkarPayment(String str, String appId, String retrurnurl) {

		String[] parts = str.split("\\|");
		String trackId = parts[0];
		//String clientCode = clientCode;
		String serviceID = parts[3];
		String applicationID = appId;
		String districtid = parts[15];
		String userID = parts[2];
		String mobileNo = parts[16];
		String name = parts[17];
		String returnurl = "http://localhost:8083/CitizenHome.html";
		LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String applicationDate = currentDate.format(formatter);
		
        String payStatus="Y";
        String digitalstatus="Y";
        //String checksumvalue = generateCheckSumValue(str);
		
        String serviceDays=parts[9];
        String amount="23.00";
        String requestFlag = "0";
        String appstatus = "2";
		
        String remark = "Under Scrutiny";
        
		String response = String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s", 
				trackId, clientCode, userID,serviceID, applicationID, payStatus, applicationDate, digitalstatus, applicationDate, serviceDays, 
				applicationDate, amount, requestFlag, appstatus, remark, "NA", "NA", "NA", "NA", "NA",
				checkSumkey);
		
		LOGGER.error("Response: "+ response); 
		
		String checksumvalue=generateCheckSumValue(response);
		
		LOGGER.error("CheckSumKey: "+ checksumvalue); 
		
		String finalstring = String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s",
				clientCode, checksumvalue, serviceID, applicationID, districtid, applicationDate, trackId, userID,
				mobileNo, name, returnurl, "NA", "NA", "NA", "NA", "NA");
		
		LOGGER.error("finalstring: "+ finalstring);
		
			String encKey=null; 
			try{
			encKey= simpleTripleDes(finalstring, clientEncryptKey, clientEncryptIV);
			}
			catch(Exception e){
				e.printStackTrace();
			}

		/*String callPaymentGateWayService = callPaymentGateWayService(encKey,clientCode);

		String keyClientCodePayKey = null;

		if (null != callPaymentGateWayService.toString()) {

			keyClientCodePayKey = encKey + MainetConstants.operator.ORR + clientCode
					+ MainetConstants.operator.ORR + callPaymentGateWayService.toString();
		}*/

		return encKey;

	}
	public AuthenticationResponseDTO redirectForAapleSarkarPaymentFinal(String district,String trackId,String userID,String mobile,String name, String str,String serviceId, String appId, String retrurnurl) {

		//AuthenticationResponseDTO xmlResponse = authenticationResponseDTO(str, serviceId);
		AuthenticationResponseDTO authenticationResponseDTO =new AuthenticationResponseDTO();
		//log.debug("DTO response xxxxxxx "+xmlResponse);
		/*
		 * if(!xmlResponse.equalsIgnoreCase("false")) { String[] fields =
		 * xmlResponse.split("\\|");
		 * 
		 * String[] parts = str.split("\\|"); String trackId = parts[0]; //String
		 * clientCode = clientCode; String serviceID = parts[3]; String applicationID =
		 * appId; String districtid = parts[15]; String userID = parts[2]; String
		 * mobileNo = parts[16]; String name = parts[17];
		 */
		String returnurl = retrurnurl;
		log.debug("paymentmethod returnurl "+returnurl);

		LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String applicationDate = currentDate.format(formatter);
        String checkValueRowData = "";
        
        
      		
        String payStatus="Y";
        String digitalstatus="Y";
        //String checksumvalue = generateCheckSumValue(str);
		
      // String serviceDays=parts[9];
        String amount="23.00";
        String requestFlag = "0";
        String appstatus = "2";
		
        String remark = "Under Scrutiny";
        
    	String requestDecryStr = simpleTripleDesDecrypt(str, clientEncryptKey, clientEncryptIV);

		String param[] = requestDecryStr.split("\\|");
		String userId = param[0];
		String userTimeStamp = param[1];
		String userSession = param[2];
		String clientCheckSumValue = param[3]; // 2491092092
		String strServiceCookie = param[4];
		String districtPrefix=district;
		String track_id=trackId;
		String userid=userID;
		String mobileNo=mobile;
		String username=name;
		//log.debug("paymentmethod clientCheckSumValue "+clientCheckSumValue);

		checkValueRowData = String.format("%s|%s|%s|%s|%s", userId, userTimeStamp, userSession, checkSumkey,
				strServiceCookie);
		log.debug("paymentmethod checkValueRowData "+checkValueRowData);

		String caluculatedCheckSumValue = generateCheckSumValue(checkValueRowData);

		LOGGER.debug("CheckSumKey: "+ caluculatedCheckSumValue); 
		
		 String finalAppId = appId.replace("/", "");
		
		String finalstring = String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s",
				clientCode, caluculatedCheckSumValue, serviceId, finalAppId, districtPrefix, applicationDate, track_id, userID,
				mobileNo, username, returnurl, "NA", "NA", "NA", "NA", "NA");
		log.debug(".AapleSarkarPortalIntegrationNagpur.redirectForAapleSarkarPaymentFinal paymentmethod finalstring "+finalstring);

		
		LOGGER.debug("finalstring: "+ finalstring);
		
			String encKey=null; 
			try{
			encKey= simpleTripleDes(finalstring, clientEncryptKey, clientEncryptIV);
			log.debug(".AapleSarkarPortalIntegrationNagpur.redirectForAapleSarkarPaymentFinal simpleTripleDes encKey 4444"+encKey);

			}
			catch(Exception e){
				e.printStackTrace();
			}

		String callPaymentGateWayService = callPaymentGateWayService(encKey,clientCode);
		log.debug("paymentmethod callPaymentGateWayService res 444"+callPaymentGateWayService);


		String keyClientCodePayKey = null;

		if (callPaymentGateWayService!=null) {

			log.error(" callPaymentGateWayService message XXX Final out Put 555=" + callPaymentGateWayService);
			authenticationResponseDTO.setKey(callPaymentGateWayService.toString());
			/*
			 * keyClientCodePayKey = encKey + MainetConstants.operator.ORR + clientCode +
			 * MainetConstants.operator.ORR + callPaymentGateWayService.toString();
			 */
		}

		authenticationResponseDTO.setWebstring(encKey);
		return authenticationResponseDTO;

	}
	

	
	public String redirectPushApi(String district,String trackid,String userid,String mobile,String name, String str,String serviceId, String appId, String retrurnurl,String paymentStatus,String paymentDate,
			String digitalSignStatus,String digitalSignDate, int estServiceDays, 
			String estServiceDate, Double amount, int reqFlag, int appStatus, String remark, String distric, String mobileApla) {
	
		 String finalAppId = appId.replace("/", "");
		 
		  DecimalFormat df = new DecimalFormat("0.00");
	      String Famt = df.format(amount);
	      LOGGER.error("Amt: " + Famt);
	      
		String request1 = String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s", 
				trackid, clientCode, userid, serviceId, finalAppId, paymentStatus, paymentDate, digitalSignStatus, digitalSignDate, estServiceDays, 
				estServiceDate, Famt, reqFlag, appStatus, remark, 123,"NMCDeptN", "NA", "NA", "NA", checkSumkey);
		
		log.debug("Request1: " + request1);

	    String checksumvalue = generateCheckSumValue(request1);	    
	   
		LOGGER.error("checksumvalue: " + checksumvalue);

	    String finalstring = String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s",
	    		trackid, clientCode, userid, serviceId, finalAppId, paymentStatus, paymentDate, digitalSignStatus, digitalSignDate, estServiceDays, 
	    		estServiceDate, Famt, reqFlag, appStatus, remark,123,"NMCDeptN", "NA", "NA", "NA", checksumvalue);
		
	    LOGGER.debug("finalstring push: "+ finalstring);
		
		String encKey=null; 
		try{
		encKey= simpleTripleDes(finalstring, clientEncryptKey, clientEncryptIV);
		log.debug("paymentmethod encKey 4444"+encKey);

		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		String callbackPushService = callPushRecordWebService(encKey,clientCode);
		log.debug("paymentmethod callbackPushService XXXXX:"+callbackPushService);
		
		   String requestDecryStr = simpleTripleDesDecrypt(callbackPushService, clientEncryptKey, clientEncryptIV);
		   log.debug("paymentmethod Decrypt message XXXX :"+requestDecryStr);
		   
		return requestDecryStr;
		
	}
	
		private static String getTagValue(String tagName, Element element) {
	        NodeList nl = element.getElementsByTagName(tagName);
	        if (nl != null && nl.getLength() > 0 && nl.item(0).getFirstChild() != null) {
	            return nl.item(0).getFirstChild().getNodeValue();
	        } else {
	            return ""; // default if missing or empty
	        }
	    }
		
		
		public  String callPaymentGateWayService(String encKey,String clienctCode){
			HttpURLConnection conn=null;
			String key = null;
			try{
				   
				log.error("Key:" +encKey);
				log.error("deptcode:" +clienctCode);
		       String jsonString = "{\"webstr\": \"" + encKey + "\", \"deptcode\": \"" + clienctCode + "\"}";
				log.debug("paymentwebservice jsonString "+jsonString);

		       log.error("JsonRequest:" + jsonString);
		       
				//String url="http://testcitizenservices.mahaitgov.in/en/OutPayment/ValidateRequest";
		       String url="https://aaplesarkar.mahaonline.gov.in/en/OutPayment/ValidateRequest";
//		       String url = ApplicationSession.getInstance().getMessage("aaple.sarkar.validaterequest.url");
				
				URL obj = new URL(url);
				
				
				conn= (HttpURLConnection) obj.openConnection();
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
				conn.setUseCaches(false);
				conn.setRequestProperty("Content-Type","application/json");
				conn.setRequestProperty("Accept","application/json");
				try(DataOutputStream dos= new DataOutputStream(conn.getOutputStream())){
					dos.writeBytes(jsonString);
				}
				
				StringBuffer respbuf = new StringBuffer();
				log.error("ResponseCode:" + conn.getResponseCode());
				try(BufferedReader bf= new BufferedReader(new InputStreamReader(conn.getInputStream()))){
					String line;
					while((line=bf.readLine())!=null){
						log.error(line);	
						respbuf.append(line);
					}
				}
				if (conn.getResponseCode() == 200) {
					//log.error(" response message =" + respbuf.toString());
					
					ObjectMapper objectMapper = new ObjectMapper();

		            Map<String, String> map = objectMapper.readValue(respbuf.toString(), new TypeReference<Map<String,String>>(){});

					String string2 = map.get("Key");
					
					log.debug("Response Key 122333445455655-->:" +string2);
					key=string2;
					
				}
				
				
			   }
			   catch(Exception e){
				   e.printStackTrace();
			   }finally {
		            if (conn != null) {
		                conn.disconnect();
		            }
		      }
			
			return key;
		}
		

		public static String callPushRecordWebService(String str,String clientCode){
			String xmlResponse="";
			try {
				
				 //String url= ApplicationSession.getInstance().getMessage("aaple.sarkar.url");
				// String url = "http://testcitizenservices.MahaITgov.in/Dept_Authentication.asmx";
				String url="https://aaplesarkar.mahaonline.gov.in/Dept_Authentication.asmx";
				 URL obj = new URL(url);
				 HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				 con.setRequestMethod("POST");
				 con.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
				 //String encKey="C6A85267FD7B63F14F9A787E21CE488097E8990F2648C005CB4F4E7C15268D29AB322B347962659F1AACB9F8EF66E6488C4D7375533BFFD48887ACBEB6E7088454B84F649B2C1FA186EBFCFA60C59B5AE3020E3EBDF4CB8344BCDBD184A5D7A71CD0FDFBE050482C431AF0F4C01B1E6998D8F57969D174142994B6E8F16CC724";
				 //String deptCode="CIDCO";
				 //String xml = "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\"> <soap12:Body> <GetParameterNew xmlns=\"http://tempuri.org/\"> <EncyKey>"+str+"</EncyKey> <DeptCode>"+clientCode+"</DeptCode> </GetParameterNew> </soap12:Body> </soap12:Envelope>";
				 
				  String xml = "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\"> <soap12:Body> <SetAppStatus xmlns=\"http://tempuri.org/\"> <EncyKey>"+str+"</EncyKey> <DeptCode>"+clientCode+"</DeptCode> </SetAppStatus> </soap12:Body> </soap12:Envelope>";

				 con.setDoOutput(true);
				 DataOutputStream wr = new DataOutputStream(con.getOutputStream());
				 wr.writeBytes(xml);
				 wr.flush();
				 wr.close();
				 String responseStatus = con.getResponseMessage();
				 System.out.println(responseStatus);
				 BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				 String inputLine;
				 StringBuffer response = new StringBuffer();
				 while ((inputLine = in.readLine()) != null) {
				 response.append(inputLine);
				 }
				 in.close();
				 LOGGER.error("response:" + response.toString());
				 String string2 = response.toString();
				
				 List<String> output = getParameterResultFromXML(string2, "SetAppStatusResult");
				 
				 String[] strarray = new String[output.size()];
				 String[] array = output.toArray(strarray);
				
				 if(array.length>0){
				 LOGGER.error("Response Array is "+ array[0]);
				 xmlResponse=array[0];
				 }
				 
			} catch (Exception e) {
				LOGGER.error("Response Array is "+ e); 
				 }
			
			return xmlResponse;
			
		}

}



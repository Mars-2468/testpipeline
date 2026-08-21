package com.mars.rti.ws.controller;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mars.rti.model.EasebuzzWebhook;
import com.mars.rti.service.EasebuzzWebhookService;

@Controller
public class EasebuzzWebhookController {

	@Autowired
	private EasebuzzWebhookService easebuzzWebhookService;


	@RequestMapping(method = RequestMethod.POST, value = "/webhook", consumes=MediaType.APPLICATION_FORM_URLENCODED)
	public ResponseEntity<String>  webhook(@RequestBody String formData) {
		
		try {
		Map<String, String> payload = parseFormData(formData);
		
		EasebuzzWebhook dto = convertMapToObject(payload);

		easebuzzWebhookService.saveWebhook(dto);

	    return new ResponseEntity<>("Data Saved Successfully",HttpStatus.OK);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return new ResponseEntity<>("Data Not Saved Successfully",HttpStatus.METHOD_NOT_ALLOWED);
	}


	private EasebuzzWebhook convertMapToObject(Map<String, String> formDataMap) {
	    EasebuzzWebhook dto = new EasebuzzWebhook();
	    
	    dto.setTxnid(formDataMap.get("txnid"));
	    dto.setFirstname(formDataMap.get("firstname"));
	    dto.setEmail(formDataMap.get("email"));
	    dto.setPhone(formDataMap.get("phone"));
	    dto.setKey(formDataMap.get("key"));
	    dto.setMode(formDataMap.get("mode"));
	    dto.setStatus(formDataMap.get("status"));
	    dto.setUnmappedstatus(formDataMap.get("unmappedstatus"));
	    dto.setCardCategory(formDataMap.get("cardCategory"));
	    dto.setAddedon(formDataMap.get("addedon"));
	    dto.setPayment_source(formDataMap.get("payment_source"));
	    dto.setPG_TYPE(formDataMap.get("PG_TYPE"));
	    dto.setBank_ref_num(formDataMap.get("bank_ref_num"));
	    dto.setBankcode(formDataMap.get("bankcode"));
	    dto.setError(formDataMap.get("error"));
	    dto.setName_on_card(formDataMap.get("name_on_card"));
	    dto.setCardnum(formDataMap.get("cardnum"));
	    dto.setIssuing_bank(formDataMap.get("issuing_bank"));
	    dto.setCard_type(formDataMap.get("card_type"));
	    dto.setEasepayid(formDataMap.get("easepayid"));
	    dto.setAmount(formDataMap.get("amount"));
	    dto.setNet_amount_debit(formDataMap.get("net_amount_debit"));
	    dto.setCash_back_percentage(formDataMap.get("cash_back_percentage"));
	    dto.setDeduction_percentage(formDataMap.get("deduction_percentage"));
	    dto.setProductinfo(formDataMap.get("productinfo"));
	    dto.setHash(formDataMap.get("hash"));
	    dto.setSurl(formDataMap.get("surl"));
	    dto.setFurl(formDataMap.get("furl"));
	    dto.setError_Message(formDataMap.get("error_Message"));
	    dto.setMerchant_logo(formDataMap.get("merchant_logo"));
	    dto.setUpi_va(formDataMap.get("upi_va"));

	    return dto;
	}
	
	
	private Map<String, String> parseFormData(String payload) {
	    Map<String, String> formData = new HashMap<>();

	    try {
	        String decodedPayload = URLDecoder.decode(payload, "UTF-8");
	        String[] keyValuePairs = decodedPayload.split("&");
	        for (String keyValuePair : keyValuePairs) {
	            String[] parts = keyValuePair.split("=");
	            if (parts.length >= 2) {
	                String key = parts[0];
	                String value = parts[1];
	                formData.put(key, value);
	            } else if (parts.length == 1) {
	                String key = parts[0];
	                String value = "";
	                formData.put(key, value);
	            }
	        }
        } catch (Exception ex) {
		   ex.printStackTrace();
		   ex.getMessage();
        }

        return formData;
    }
}

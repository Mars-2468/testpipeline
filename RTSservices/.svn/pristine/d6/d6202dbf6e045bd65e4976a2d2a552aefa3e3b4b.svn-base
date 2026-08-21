package com.mars.rti.ws.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebhookController {

    @RequestMapping(method = RequestMethod.POST, value = "/whatsapp")
    public void handleWhatsAppMessage(@RequestBody Map<String, Object> webhookPayload) {
        String receivedMessage = extractMessageFromWebhook(webhookPayload);

        String phoneNumber = "";

        // Call the method to send the WhatsApp message
        WhatsAppMessageSender.sendMessage(phoneNumber, receivedMessage);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/webhookVerify")
    public ResponseEntity<String> webhookVerify(@RequestParam("hub.mode") String mode,
                                                @RequestParam("hub.challenge") String challenge,
                                                @RequestParam("hub.verify_token") String token) {
        System.out.println(mode);
        System.out.println(challenge);
        System.out.println(token);
        if (mode.equals("subscribe") && token.equals("Hello")) {
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Verification token or mode mismatch", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getRequest", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public void getRequest(@RequestBody LinkedHashMap json) {
        System.out.println(json);

        String phoneNumber = "919985651070";
        String message = "";
        JSONObject jsonObject = new JSONObject(json);

        JSONArray entryArray = jsonObject.getJSONArray("entry");
        for (int i = 0; i < entryArray.length(); i++) {
            JSONObject entry = entryArray.getJSONObject(i);

            JSONArray changesArray = entry.getJSONArray("changes");
            for (int j = 0; j < changesArray.length(); j++) {
                JSONObject change = changesArray.getJSONObject(j);
                JSONObject value = change.getJSONObject("value");

                // Accessing specific fields within the "value" object
                phoneNumber = value.getJSONArray("contacts").getJSONObject(0).getString("wa_id");
                message = value.getJSONArray("messages").getJSONObject(0).getJSONObject("button").getString("text");
            }
        }

        // Call the method to send the WhatsApp message
        WhatsAppMessageSender.sendMessage(phoneNumber, message);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sendWhatsappMessage")
    public void sendWhatsAppMessage(@RequestBody String phoneNumber) {

        // Call the method to send the WhatsApp message
        WhatsAppMessageSender.sendMessage(phoneNumber, "");
    }

    private String extractMessageFromWebhook(Map<String, Object> webhookPayload) {
        // Replace this with your actual logic to extract the message from the webhook payload
        return webhookPayload.get("message").toString();
    }

//    // Simulated method to create a message from the received webhook content
//    private Map<String, Object> createMessageFromWebhook(String receivedMessage) {
//        Map<String, Object> message = new HashMap<>();
//        message.put("text", receivedMessage);
//        // Add any additional message parameters based on your webhook content
//        return message;
//    }
}


package com.mars.rti.ws.controller;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;



public class WhatsAppMessageSender {

    public static void sendMessage(String phoneNumber, String message){
        String apiUrl = "https://graph.facebook.com/v17.0/191667634037207/messages";
        String accessToken = "EAAECmraSKGsBO6aF6EFcBDpluNudxKwhFnZAU0CA4PZAIbz9dAT1zFViOsHeHZBvv3kgABZAlaxNqPJnAZAZBtoYzQfZAxoGBh9SSVPeatqvoaa77ItD6AtZBdixcKC6Y1cNA1oKBotMq4uRncfq8vzJ1tRqGq1HrZCVQZAZB6Yv8eKIVPFUzgptB0NyHLVIntPZBVfm5Kh7peDKIZAQGi73qFCOuo1q22AUZD";

        String template = "first_template";
        String newMessage = "";
        String type = "template";
        if (message.equalsIgnoreCase("Property Tax")){
            template = "property_tax_details_more";
            type = "template";
        }else if (message.equalsIgnoreCase("Water Tax")){
            template = "water_tax_details_more";
            type = "template";
        }else if (message.contains("Property Tax Details")){
            newMessage = "Row Hs No.63, श्री विहार, देवळाई, Z8/114/1733, -, छत्रपती संभाजीनगर";
            type = "text";
        }else if (message.equalsIgnoreCase("Property Tax Out Standing")){
            newMessage = "Rs 100000";
            type = "text";
        }else if (message.equalsIgnoreCase("Property Tax Owner Detail")){
            newMessage = "SAGAR";
            type = "text";
        }else if (message.equalsIgnoreCase("Property Tax Mobile No")){
            newMessage = "Mobile no :9999999999";
            type = "text";
        }else if (message.equalsIgnoreCase("Water Tax Details")){
            newMessage = "GW0012175";
            type = "text";
        }else if (message.equalsIgnoreCase("Water Tax Out Standing")){
            newMessage = "Rs 50000";
            type = "text";
        }else if (message.equalsIgnoreCase("Water Tax Owner Details")){
            newMessage = "Md Faizuddin";
            type = "text";
        }else if (message.equalsIgnoreCase("Water Tax Mobile No")){
            newMessage = "mobile no :7777777";
            type = "text";
        }

        String requestBody = "{ \"messaging_product\": \"whatsapp\", \"recipient_type\": \"individual\", \"to\": \""+ phoneNumber + "\", \"type\": \"template\", \"template\": { \"name\": \"" +template+ "\", \"language\": { \"code\": \"en_US\" } } }";

        if (type.equals("text")){
            requestBody = "{ \"messaging_product\": \"whatsapp\", \"recipient_type\": \"individual\", \"to\": \""+ phoneNumber + "\", \"type\": \"text\", \"text\": { \"body\": \"" +newMessage+ "\"} }";
        }

        System.out.println("requestBody: " + requestBody);

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("POST");

            // Set request headers
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + accessToken);

            // Enable input/output streams
            connection.setDoOutput(true);

            // Write request body
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = requestBody.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Get response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read response
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response body here
            } else {
                // Handle error response
            }

            // Close the connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

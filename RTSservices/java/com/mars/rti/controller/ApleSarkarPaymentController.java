//package com.mars.rti.controller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import your.package.name.dto.ValidateRequestDTO;     // Replace with the actual package name
//import your.package.name.service.PaymentService;      // Replace with the actual package name
//import your.package.name.util.ChecksumUtil;           // Replace with the actual package name
//
//
//	@RestController
//	public class ApleSarkarPaymentController {
//
//	    @Autowired
//	    private PaymentService paymentService;
//
//	    @PostMapping("/validatePaymentRequest")
//	    public ResponseEntity<String> validatePaymentRequest(@RequestBody ValidateRequestDTO dto) {
//	        try {
//	            // Compute checksum (example: checksum = SHA256(ClientCode + ServiceID + secretKey))
//	            String checksum = ChecksumUtil.calculateChecksum(dto.getClientCode() + dto.getServiceID(), "SECRET_KEY");
//	            dto.setCheckSum(checksum);
//
//	            String response = paymentService.sendValidateRequest(dto, "https://mahait.gov.in/validateRequestEndpoint");
//	            return ResponseEntity.ok(response);
//	        } catch (Exception e) {
//	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
//	        }
//	    }
//	}
//

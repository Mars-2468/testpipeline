package com.mars.rti.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

@Controller
public class ApplicationQRCodeGenerator{

	
	private Log log = LogFactory.getLog(ApplicationQRCodeGenerator.class);
	
	
	public String createQR(String data, String charset, Map hashMap, int height, int width)
			throws WriterException, IOException {

		log.debug("Created Qr code Generator Object...XXXXXXXX");
		BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset),
				BarcodeFormat.QR_CODE, width, height);
		log.debug("Or Code is generating............XXXXXXXX");
		String base64Image=null;
		try {
		   // MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), file);
			 ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	            MatrixToImageWriter.writeToStream(matrix, "PNG", outputStream);
	            byte[] imageBytes = outputStream.toByteArray();
	            outputStream.close();
	            
	             base64Image = Base64.getEncoder().encodeToString(imageBytes);
			log.debug("Image saved successfully!");
		} catch (IOException e) {
		    e.printStackTrace();
		   log.debug("Failed to save the image: " + e.getMessage());
		}		log.debug("Or Code is generated");
		
		return base64Image;
	}

	public String getQrCode(int rtiApplrefid,String url) throws WriterException, IOException, NotFoundException {

		String data =url;
		
		log.debug("Entered Generate Method of Qr Code...XXXXXXXX");
		if(rtiApplrefid>0) {
		 data = data+"/ws/getApplicationDetails.do?rtiApplrefid="+rtiApplrefid;
		
		}else {
			data = data ;
		 //data = "https://nmcnagpur.gov.in/";

		}

		
		String charset = "UTF-8";

		Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();

		hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.Q);
        log.debug("Called Create Qr...XXXXXXXX");

		String base64 = createQR(data, charset, hashMap, 400, 400);
		System.out.println("QR Code Generated!!! ");
		
		return base64;
	}
	
	
	
}

package com.mars.rti.controller;


	import java.io.*;
	import java.util.*;

	import org.apache.commons.logging.Log;
	import org.apache.commons.logging.LogFactory;
	import org.springframework.stereotype.Service;

	import com.google.zxing.*;
	import com.google.zxing.client.j2se.MatrixToImageWriter;
	import com.google.zxing.common.BitMatrix;
	import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

	@Service
	public class QRGeneratorApplications {

		private Log log = LogFactory.getLog(ApplicationQRCodeGenerator.class);

		public String getQrCode(int applicationId, String url) throws WriterException, IOException {
			String data = url + "/ws/getApplicationDetails.do?rtiApplrefid=" + applicationId;
			String charset = "UTF-8";
			Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<>();
			hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.Q);

			return createQR(data, charset, hashMap, 400, 400);
		}

		private String createQR(String data, String charset, Map<EncodeHintType, ErrorCorrectionLevel> hashMap, int height, int width)
				throws WriterException, IOException {

			BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset),
					BarcodeFormat.QR_CODE, width, height);

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(matrix, "PNG", outputStream);
			byte[] imageBytes = outputStream.toByteArray();
			outputStream.close();

			return Base64.getEncoder().encodeToString(imageBytes);
		}
	
}

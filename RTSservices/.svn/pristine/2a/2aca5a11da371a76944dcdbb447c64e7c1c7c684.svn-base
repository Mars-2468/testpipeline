package com.mars.rti.controller;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyTaxUploadURLGenerationController {


	public static String generateTaxUploadURL(String filePath, HttpServletRequest request) throws Exception {
		StringBuilder message = new StringBuilder();
		String url = null;
		String temp = null;

		try {
			if (filePath.endsWith(",")) {
				filePath = filePath.substring(0, filePath.length() - 1);
			}
			String[] files = filePath.split(",");
			for (int i = 0; i < files.length; i++) {
				String urlEncodedFilePath = URLEncoder.encode(files[i], StandardCharsets.UTF_8.toString());
				String  base64path = Base64.getEncoder().encodeToString(urlEncodedFilePath.getBytes(StandardCharsets.UTF_8));

				temp = "https" + "://" + request.getServerName() + "/RTSservices" + "/rtsApplication/getPdf.do" + "?fp="
						+ base64path;
				message.append(temp).append(",");

			}
			if (message != null) {
				if (message.charAt(message.length() - 1) == ',') {
					message.deleteCharAt(message.length() - 1);
				}
				url = message.toString();
			}

		} catch (Exception ex) {
			ex.getMessage();
		}
		return url;
	}
}


	package com.mars.rti.payment;

	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.io.PrintStream;
	import java.net.URL;
	import java.net.URLEncoder;
	import java.security.MessageDigest;
	import java.security.NoSuchAlgorithmException;
	import java.util.Enumeration;
	import java.util.HashMap;
	import java.util.Map;

	import javax.net.ssl.HttpsURLConnection;
	import javax.servlet.http.HttpServletRequest;

	import org.apache.commons.lang.exception.ExceptionUtils;
	import org.apache.commons.logging.Log;
	import org.apache.commons.logging.LogFactory;
	import org.json.simple.JSONObject;
	import org.json.simple.parser.JSONParser;

	public class BOMInitiateFirePayment {

		private static Log log = LogFactory.getLog(BOMInitiateFirePayment.class);

		public static boolean empty(String s) {
			if (s == null || s.trim().equals("")) {
				return true;
			} else {
				return false;
			}
		}

		public static String clean(String s) {
			s.trim();
			return s;
		}

		public static String Easebuzz_Generatehash512(String type, String str) {
			byte[] hashseq = str.getBytes();
			StringBuffer hexString = new StringBuffer();
			try {
				MessageDigest algorithm = MessageDigest.getInstance(type);
				algorithm.reset();
				algorithm.update(hashseq);
				byte messageDigest[] = algorithm.digest();

				for (int i = 0; i < messageDigest.length; i++) {
					String hex = Integer.toHexString(0xFF & messageDigest[i]);
					if (hex.length() == 1) {
						hexString.append("0");
					}
					hexString.append(hex);
				}

			} catch (NoSuchAlgorithmException ex) {
				log.error(ExceptionUtils.getStackTrace(ex));
			}
			return hexString.toString();
		}

		public static String initiatePayment(HashMap<String, String> params) {
			String redirectURL = "";

			try {                      
				String hashString = "";
				String hash = "";     
				params.put("key", PaymentConstants.BOM_FIRE_TEST_KEY);
				log.debug("initiatePayment params "+params);
				if (!empty(params.get("key"))) {

					String[] hashVarSeq = PaymentConstants.REQUEST_HASHSEQUENCE.split("\\|");

					for (String part : hashVarSeq) {
						hashString = (empty(params.get(part))) ? hashString.concat("")
								: hashString.concat(params.get(part));
						hashString = hashString.concat("|");
					}

					hashString = hashString.concat(PaymentConstants.BOM_FIRE_TEST_SALT);
					hash = Easebuzz_Generatehash512("SHA-512", hashString);
					params.put("hash", hash);
					log.debug("initiatePayment hashString "+hashString);
					log.debug("initiatePayment hash "+hash);
					log.debug("initiatePayment params "+params);


					StringBuilder sb = new StringBuilder();
					for (Map.Entry<String, String> e : params.entrySet()) {
						if (sb.length() > 0) {
							sb.append('&');
						}
						sb.append(URLEncoder.encode(e.getKey().trim(), "UTF-8")).append('=')
								.append(URLEncoder.encode(e.getValue().trim(), "UTF-8"));
					}

					URL url = new URL(PaymentConstants.BOM_TEST_URL + "payment/initiateLink");
	                
					log.debug("initiatePayment url "+url);
					log.debug("Making Connection:"+url);
					HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
					con.setRequestMethod("POST");
					con.setDoOutput(true);
					PrintStream ps = new PrintStream(con.getOutputStream());
					log.debug("Getting Output Stream from connection");
					ps.println(sb);
					ps.close();
					con.connect();
					log.debug("Connection is connected");

					StringBuilder res = new StringBuilder();
					if (con.getResponseCode() == HttpsURLConnection.HTTP_OK) {
						log.debug("Reading bank reponse");
						BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
						String line;
						while ((line = br.readLine()) != null) {
							res.append(line);
						}
						br.close();
					}
					con.disconnect();
					log.debug("Connection Disconnected");
					Object obj = new JSONParser().parse(res.toString());
					
					JSONObject jo = (JSONObject) obj;
	                log.debug("Payment Response Status"+jo);
					if (jo.get("status").toString().equals("1")) {
						redirectURL = PaymentConstants.BOM_TEST_URL + "pay/" + jo.get("data").toString();
					} else {
						String errorDesc = jo.toJSONString();
						log.error(errorDesc);
						log.debug("Payment Failed:"+jo.toString());
						throw new RuntimeException(errorDesc);
						
					}

				}
			} catch (Exception ex) {
				log.error(ExceptionUtils.getStackTrace(ex));
				ex.printStackTrace();
			}
			return redirectURL;

		}

		public static boolean compareHash(HttpServletRequest request) {
			Enumeration paramNames = request.getParameterNames();
			HashMap<String, String> params = new HashMap<String, String>();
			while (paramNames.hasMoreElements()) {
				String paramName = (String) paramNames.nextElement();

				String paramValue = ((String) request.getParameter(paramName)).trim();
				params.put(paramName, paramValue);
			}

			Map<String, String[]> parameters = request.getParameterMap();
			for (String parameter : parameters.keySet()) {
				params.put(parameter, parameters.get(parameter)[0].toString());
			}
			params.put("salt", PaymentConstants.BOM_FIRE_TEST_SALT);
			params.put("status", request.getParameter("status"));
			String hashString = "";
			String hash = "";

			String[] hashVarSeq = PaymentConstants.RESPONSE_HASHSEQUENCE.split("\\|");

			for (String part : hashVarSeq) {
				hashString = (BOMInitiatePayment.empty(params.get(part))) ? hashString.concat("")
						: hashString.concat(params.get(part));
				hashString = hashString.concat("|");
			}
			hashString = hashString.concat(request.getParameter("key"));
			hash = BOMInitiatePayment.Easebuzz_Generatehash512("SHA-512", hashString);
			String responseHash = request.getParameter("hash");
			if (hash.trim().equals(responseHash.trim())) {
				return true;
			}
			return false;
		}
	}


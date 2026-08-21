package com.mars.common.utils;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class GisProxy extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		URLCodec coder = new URLCodec();
		Map map = request.getParameterMap();		
		String url=null;
		String responseText = "";
		Map params = request.getParameterMap();
		Iterator i = params.keySet().iterator();

		while (i.hasNext()) {
			String key = (String) i.next();
			String value = ((String[]) params.get( key ))[ 0 ];
			if(key.equalsIgnoreCase("url")){
				url = value;
				break;
			}
		}

		if(url!=null){	
			//System.out.println("URL string: "+url);
			if(url.contains("_param")){
				try {
					String hostPath = url.substring(0,url.indexOf("_param=")+7);
					String urlArgs = url.substring(url.indexOf("_param=")+7);
					//System.out.println("host: "+hostPath+" arg: "+urlArgs);
					urlArgs = coder.encode(urlArgs);
					url = hostPath+urlArgs;
					//System.out.println("URL Encoded string: "+url);
				} catch (EncoderException e) {
					e.printStackTrace();
				}
			}
			url = url.replace("119.226.93.115:9090","172.16.25.60:9090");
			url = url.replace("119.226.93.115:9091","172.16.25.41:9091");
		
			HttpGet httpget = new HttpGet(url);
			HttpResponse myresponse = httpclient.execute(httpget);
			HttpEntity entity = myresponse.getEntity(); 
			DataInputStream input = new DataInputStream(entity.getContent());
			for (String str = ""; (str = input.readLine()) != null;) {
				responseText = (new StringBuilder(String.valueOf(responseText))).append(str).toString();
			}
			//System.out.println("response: "+responseText);
			input.close();
			entity.consumeContent();
		}
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.println("" + responseText + "");
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

/**
 * 
 */
package com.mars.rti.security;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 */
public class CORSFilter implements Filter {

	private static final String UAT_URL = "https://nagpur.egovmars.in";
	private static final String PROD_URL = "https://nmcnagpur.gov.in";
	String protocall = "https://";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Any initialization logic if needed
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		String host = httpRequest.getHeader("Host");
		String methodName = httpRequest.getMethod();

		/* Set CORS headers based on the Origin and Combine protocol and host */

		if (host != null) {
			String origin = protocall.concat(host);
			if (UAT_URL.equals(origin)) {

				/* If the Origin matches the UAT URL, allow CORS for UAT */

				httpResponse.setHeader("Access-Control-Allow-Origin", UAT_URL);
			} else if (PROD_URL.equals(origin)) {

				/* If the Origin matches the Production URL, allow CORS for Production */

				httpResponse.setHeader("Access-Control-Allow-Origin", PROD_URL);
			} else {

				/*
				 * If the Origin doesn't match either URL, disallow CORS by not setting the
				 * header and Empty string disables CORS also Optionally
				 */

				 httpResponse.setHeader("Access-Control-Allow-Origin", "");

				/* If the Origin doesn't match either URL, allow CORS for localhost */

				//httpResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
			}
		}

		/* Set other CORS headers (common for both preflight and regular requests) */
		if (methodName == "GET" || methodName == "POST" || methodName == "PUT" || methodName == "DELETE") {
			httpResponse.setHeader("Access-Control-Allow-Methods", methodName);
			httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
			httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
			httpResponse.setHeader("Access-Control-Max-Age", "3600");
		}

		/* Continue with the request */

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// Clean up resources (if needed)
	}
}
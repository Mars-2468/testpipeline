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
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@WebFilter("/*") // Apply this filter to all incoming requests
public class HostHeaderValidationFilter implements Filter {

	private static final List<String> VALID_HOSTS = Arrays.asList("nagpur.egovmars.in", "nmcnagpur.gov.in","localhost:8080");    //"localhost:8080"

	public void init(FilterConfig filterConfig) throws ServletException {
		// Filter initialization (if needed)
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String hostHeader = httpRequest.getHeader("Host");

		// Validate the Host header
		if (hostHeader == null || !VALID_HOSTS.contains(hostHeader)) {
			// Optionally, log the attack attempt here
			httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST); // Bad request if invalid host
			httpResponse.getWriter().write("Invalid Host header");
			return; // Terminate request processing
		}

		// If the Host header is valid, continue with the request
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// Filter destruction (if needed)
	}
}

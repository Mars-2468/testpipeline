package com.mars.rti.cookies;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecureCookieFilter implements Filter {

	// Initialize filter if needed
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Initialization logic (if any)
	}

	// Filter processing logic
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// Ensure the response is of type HttpServletResponse

		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		// true creates a new session if it doesn't exist

		HttpSession session = httpRequest.getSession();

		// Get the session ID

		String sessionId = session.getId();

		// Add cookies with security attributes (e.g., JSESSIONID)

		Cookie cookie = new Cookie("JSESSIONID", sessionId);

		/*
		 * Set secure cookie properties , 1 hour expiration , Ensure the cookie is sent
		 * only over HTTPS , Prevent JavaScript access to the cookie
		 */
		cookie.setPath("/");
		cookie.setMaxAge(3600);
		cookie.setSecure(true);
		cookie.setHttpOnly(true);

		/*
		 * Manually add SameSite attribute since it's not directly supported by Cookie
		 * API in older Servlets and Use Strict, Lax, or None depending on your needs
		 */

		String sameSiteValue = "None";

		// Create a custom Set-Cookie header with SameSite attribute

		String cookieHeader = "JSESSIONID=" + cookie.getValue() + "; Path=" + cookie.getPath() + "; Max-Age="
				+ cookie.getMaxAge() + "; HttpOnly" + "; Secure" + "; SameSite=" + sameSiteValue;

		// Add the custom Set-Cookie header to the response

		httpResponse.setHeader("Set-Cookie", cookieHeader);

		// Continue the request-response cycle
		chain.doFilter(request, response);
	}

	// Cleanup logic (if any) when the filter is destroyed
	@Override
	public void destroy() {
		// Clean up resources (if needed)
	}
}

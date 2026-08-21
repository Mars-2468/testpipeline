<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="include.jsp" %>
<%
	String strRequestURI = (String)request.getAttribute("javax.servlet.forward.request_uri");
	String strContextPath =  (String)request.getAttribute("javax.servlet.forward.context_path");
	if(strRequestURI!=null && strContextPath!=null)
	{
		String strReferer = request.getHeader("referer");
		if(strReferer!=null && strReferer.matches(strContextPath))
		{
			response.sendRedirect(strReferer);
		}
		else if(strRequestURI.equalsIgnoreCase(strContextPath) || strRequestURI.equalsIgnoreCase(strContextPath+"/"))
		{	
			response.sendRedirect(strRequestURI+"/login.do");
		}	
	}
%>
<html>
	<head>
		<title>NMC - Right To Information</title>
		<meta http-equiv="PRAGMA" content="NO-CACHE" />
		<meta name="FORMAT" content="text/html" />
		<meta name="CHARSET" content="ISO-8859-1" />
		<meta name="DOCUMENTLANGUAGECODE" content="en" />
		<meta name="DOCUMENTCOUNTRYCODE" content="us" />
		<meta name="DC.LANGUAGE" scheme="rfc1766" content="en-us" />
		<meta name="COPYRIGHT"
			content="Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd" />
		<meta name="SECURITY" content="Public" />
		<meta name="ROBOTS" content="index,follow" />
		<meta name="GOOGLEBOT" content="index,follow" />
		<meta name="Author" content="Mars Telecom Systems Private Ltd" />
		<link rel="stylesheet" type="text/css"
			href="<c:out value="${contextRoot}"/>/styles/styles.css" />
		<script language="javascript"
			src="<c:out value="${contextRoot}"/>/scripts/utils.js"
			type="text/javascript"></script>
	</head>
	<body>
		<form name="frmPage" method="post">
			<table cellpadding="0" cellspacing="0" border="0"
				class="ClsPageWidth" id="tbl_base_title">
				<tr>
					<td>
						<div class="ClsMTLogo">
							<a href="#" title="Metler Toledo"></a>
						</div>
						<!-- ==============  Metler Toledo Logo Comes here ============ -->
						<div class="ClseCDBLogo"></div>
						<!-- ==============  EContactDataBase Logo Comes here ============ -->

					</td>
				</tr>
				<tr>
					<td>
						<div>
							<hr />
							<h2>
								<font face="verdana">The page cannot be found</font>
							</h2>
							<br />
							<h4>
								<font face="verdana">We&rsquo;re Sorry...</font>
							</h4>
							<p>
								<font face="verdana">The page you are looking for might
									have been removed or is temporarily unavailable.</font>
							</p>
							<br />
							<br />
							<p>
								<font face="verdana">An error has occured on the page you
									were requesting. If this problem persists, please contact the
									site administrator.</font>
							</p>
							<br />
							<hr />
						</div>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>


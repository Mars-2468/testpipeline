<%@ page isErrorPage="true" import="java.io.PrintWriter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/pages/common/include.jsp" %>
<html>
	<head>
		<title>NMC - Rights To Services</title>
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
	<body scroll=auto>
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
								<font face="verdana">Unable to process your request</font>
							</h2>
							<br />
							<h4>
								<font face="verdana">We&rsquo;re Sorry...</font>
							</h4>
							<p>
								<font face="verdana">An error has occured on the page you
									were requesting. If this problem persists, please contact the
									site administrator.</font>
							</p>
							<hr />
							<br />
							<pre>
							  <%
							  	    // unwrap ServletExceptions.
							  	    if (exception != null)
							  	    {
							  		while (exception instanceof ServletException)
							  		    exception = ((ServletException) exception).getRootCause();
							  		// print stack trace.
							  		exception.printStackTrace(new PrintWriter(out));
							  	    }
							  %>
						  </pre>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

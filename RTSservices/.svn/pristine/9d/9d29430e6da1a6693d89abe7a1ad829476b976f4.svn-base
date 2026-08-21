<%@ page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="org.springframework.security.core.Authentication"%>
<%@ page import="org.springframework.security.web.access.AccessDeniedHandlerImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/pages/common/include.jsp"%>
<html>
	<head>
		<title>RTS</title>
		<meta http-equiv="PRAGMA" content="NO-CACHE" />
		<meta name="FORMAT" content="text/html" />
		<meta name="CHARSET" content="ISO-8859-1" />
		<meta name="DOCUMENTLANGUAGECODE" content="en" />
		<meta name="DOCUMENTCOUNTRYCODE" content="us" />
		<meta name="DC.LANGUAGE" scheme="rfc1766" content="en-us" />
		<meta name="COPYRIGHT" content="Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd" />
		<meta name="SECURITY" content="Public" />
		<meta name="ROBOTS" content="index,follow" />
		<meta name="GOOGLEBOT" content="index,follow" />
		<meta name="Author" content="Mars Telecom Systems Private Ltd" />
		<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/styles.css" />
		<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/calendarcontrol.css" />
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/utils.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/calendar.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/PagePref.js"></script>
	</head>
	<body onload="javascript:GetWindowSize('SetBrowserHeight','SetFormHeight','OnLoadWindowSize')" onresize="javascript:GetWindowSize('SetBrowserHeight','SetFormHeight','OnReSizeWindowSize')">

		<form name="frmPage" method="post">
			<div id="SetBrowserHeight">
				<table cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td>
							<%@ include file="/WEB-INF/tiles/common/topband.jsp"%>
						</td>
					</tr>
					<tr>
						<td>
							<%@ include file="/WEB-INF/tiles/common/topnav.jsp"%>
						</td>
					</tr>
					<%-- <tr>
						<td valign="top">
							<div id="SetFormHeight" class="ClsScrollMainContainer">
								<br />
								<h4>
									<font face="verdana">We&rsquo;re Sorry, access is denied</font>
								</h4>
								<p>
									<font face="verdana">If this problem persists, please contact the site administrator.</font>
								</p>
								<br />
								<%=request.getAttribute(AccessDeniedHandlerImpl.SPRING_SECURITY_ACCESS_DENIED_EXCEPTION_KEY)%>
								<% 
								     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
								%>
							</div>
						</td>
					</tr>--%>
					<tr>
						<td>
							<%@ include file="/WEB-INF/tiles/common/footer.jsp"%>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>

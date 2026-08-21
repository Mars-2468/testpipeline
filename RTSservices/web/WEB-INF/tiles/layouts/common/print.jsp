<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/pages/common/include.jsp"%>
<%--<tiles:importAttribute scope="request" name="breadcrumbsList" ignore="true" />--%>
<tiles:importAttribute scope="request" name="parentMenu" ignore="true" />
<html>
	<head>
<title>NMC - RTS</title>
		<meta http-equiv="PRAGMA" content="NO-CACHE" />
		<meta name="FORMAT" content="text/html" />
		<meta name="CHARSET" content="ISO-8859-1" />
		<meta name="DOCUMENTLANGUAGECODE" content="en" />
		<meta name="DOCUMENTCOUNTRYCODE" content="us" />
		<meta name="DC.LANGUAGE" scheme="rfc1766" content="en-us" />
		<meta name="COPYRIGHT" content="Copyright (c) 2022 NMC" />
		<meta name="SECURITY" content="Public" />
		<meta name="ROBOTS" content="index,follow" />
		<meta name="GOOGLEBOT" content="index,follow" />
		<meta name="Author" content="NMC" />
		<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/styles.css" />
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/utils.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/PagePref.js"></script>

	</head>
	<body>
		<c:choose>
			<c:when test="${requestScope.SetEncType != null && requestScope.SetEncType==true}">
				<form name="frmPage" method="post" enctype="multipart/form-data">
			</c:when>
			<c:otherwise>
				<form name="frmPage" method="post">
			</c:otherwise>
		</c:choose>
		<div class="wrapper">
			<div style="background: url(${contextRoot}/images/print-head.gif); HEIGHT:150px" class="header">
				<tiles:insertAttribute name="topband" flush="true" ignore="true" />
			<%--	<tiles:insertAttribute name="header" flush="true" ignore="true" />--%>
			</div>
			<div class="main">
				<table style="width: 100%">
					<tbody>
						<tr>
							
							<td class="rightCol" style="height:460px" valign="top">
								<div class="error" id="idErrorBox" style="display:none">
									<c:if test="${not empty message}">
										<script>displayError('<c:out value="${message}" />')</script>
									</c:if>
								</div>

								<c:if test="${not empty message}">
								</c:if>
								<c:if test="${not empty sessionScope.message }">
									<c:remove var="message" scope="session" />
								</c:if>
								<tiles:insertAttribute name="content" flush="true" />
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="footer">
				<tiles:insertAttribute name="footer" flush="true" ignore="true" />
			</div>
		</div>
		</form>
		<script>
		setContextRoot('<c:out value="${contextRoot}"/>');
		</script>
	</body>
</html>


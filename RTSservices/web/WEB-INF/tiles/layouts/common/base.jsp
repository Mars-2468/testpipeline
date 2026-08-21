<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/pages/common/include.jsp"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="com.mars.common.utils.SessionUser"%>
<%@ page import="com.mars.common.model.User"%>

<tiles:importAttribute scope="request" name="breadcrumbsList"
	ignore="true" />
<tiles:importAttribute scope="request" name="parentMenu" ignore="true" />
<tiles:importAttribute scope="request" name="selectedMenu" ignore="true" />
<html>
<head>
<title>NMC - RTS</title>
<meta http-equiv="PRAGMA" content="NO-CACHE" />
<meta name="FORMAT" content="text/html" />
<meta name="CHARSET" content="ISO-8859-1" />
<meta name="DOCUMENTLANGUAGECODE" content="en" />
<meta name="DOCUMENTCOUNTRYCODE" content="us" />
<meta name="DC.LANGUAGE" scheme="rfc1766" content="en-us" />
<meta name="COPYRIGHT"
	content="Copyright (c) 2022 for amc
		<meta name="SECURITY" content="Public" />
		<meta name="ROBOTS" content="index,follow" />
		<meta name="GOOGLEBOT" content="index,follow" />
		<meta name="Author" content="NMC" />
		<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/styles.css" />
		
		<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/autocomplete.css" />
		<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/example.css" />
		<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/home.css" />
		<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/swfupload.css" />		
				
		<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/jquery/demos.css" />
		<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/jquery/ui.autocomplete.css" />
		<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/jquery/ui.core.css" />
		<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/jquery/ui.datepicker.css" />
		<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/jquery/ui.dialog.css" />
		<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/jquery/ui.tabs.css" />
		<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/jquery/ui.theme.css" />
		
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/utils.js"></script>
<style>
.solid {
    border-style: none;
    display: flex;
    justify-content: space-between;
    align-items: center;
margin-right: 0px;
margin-left:0px;

}
header img {
    width: 75px;
    height: 75px;
    flex-shrink: 0;
    margin: 4px 3px 4px 2px;
}
header h1 {

 
    margin: 0px;
    text-align: center;
    text-transform: ;
    letter-spacing: 1px;
    word-spacing: 0px;
    font-size: 4vw;
    color: floralwhite;
    font-family: sans-serif;
}
.header{
 
  background-color: white;
  align-items: center;
}
img {
    vertical-align: middle;
}img {
    border: 0;
}


</style>
<%
	HttpSession session1 = request.getSession();
	SessionUser sessionUser = (SessionUser) session1.getAttribute("SessionUser");
	String firstname = (String) sessionUser.getFirstName();
	String lastname = (String) sessionUser.getLastName();
	Long departmentId = (Long) sessionUser.getDepartmentId();
	String departmentname = "";
if(departmentId == 1){
		departmentname = "Admin Department";
	}else if (departmentId == 2) {
		departmentname = "Health Department";
	} else if (departmentId == 3) {
		departmentname = "Veterinary Department";
	} else if (departmentId == 4) {
		departmentname = "Property Tax Department";
	} else if (departmentId == 5) {
		departmentname = "Town Planning Department";
	} else if (departmentId == 6) {
		departmentname = "Water Department";
	} else if (departmentId == 7) {
		departmentname = "Fire Department";
	} else if (departmentId == 8) {
		departmentname = "Estate Department";
	} else if (departmentId == 9) {
		departmentname = "Market Department";
	}else if (departmentId == 10) {
		departmentname = "Garden Department";
	}else if (departmentId == 11) {
		departmentname = "HOD Department";
	}else if (departmentId == 12) {
		departmentname = "Fire Department";
	}
%>
		
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
		<div class="page-wrapper">
		   <div class="page-content">				
				
				<!-- Header start -->
				<header class="header">
					<div class="toggle-btns">
						<a id="toggle-sidebar" href="#">
							<i class="icon-menu"></i>
						</a>
						<a id="pin-sidebar" href="#">
							<i class="icon-menu"></i>
						</a>
					</div>
					<div class="header-items">
						 
                       <header class="solid">
                            <img src="<c:out value="${contextRoot}"/>/images/nagpur.png" class="profile-thumb" alt="">&nbsp
                             <h1>Nagpur Municipal Corporation</h1>&nbsp
                            <img src="<c:out value="${contextRoot}"/>/images/g20.png" class="profile-thumb" alt="">
                       </header>

						<!-- Header actions start -->
						<ul class="header-actions">
							 

							<li class="dropdown user-settings">
								<a href="#" id="userSettings" data-toggle="dropdown" aria-haspopup="true">
									<img src="<c:out value="${contextRoot}"/>/styles/dashboard/img/user2.png" class="user-avatar" alt="Avatar">
								</a>
								<div class="dropdown-menu dropdown-menu-right" aria-labelledby="userSettings">
									<div class="header-profile-actions">
										<div class="header-user-profile">
											<div class="header-user">
												<img src="<c:out value="${contextRoot}"/>/styles/dashboard/img/user2.png" alt="Admin Template" />
											</div>
											
											<h6><%= firstname+" "+lastname %></h6>
											<h6 style="font-size: 12px;">[<%= departmentname %>]</h6>
		 
										</div>
										<a href="" class="homeLnk"><i class="icon-user1"></i> Home</a>
<!-- 										<a href="#"><i class="icon-user1"></i> My Profile</a>
 -->										<a href="<c:out value="${contextRoot}"/>/workflow/listTasks.do"">
	<i class="icon-user1"></i> My Tasks</a> <a
		href="<c:out value="${contextRoot}"/>/logout.do" class="signoutLnk"><i
		class="icon-log-out1"></i>Sign Out</a>
	</div>
	</div>
	</li>
	</ul>
	<!-- Header actions end -->
	</div>
	</header>
	<!-- Header end -->
	<!-- Main container start -->
	<div class="main-container">
		<div class="${headerClass}">
			<tiles:insertAttribute name="topband" flush="true" ignore="true" />
			<tiles:insertAttribute name="header" flush="true" ignore="true" />
		</div>
		<div class="table-responsive">
			<table class="table table-bordered m-0" border="0">
				<tbody>
					<tr>
						<c:if test="${not empty sessionScope.SessionUser}">
							<tiles:insertAttribute name="leftnav" flush="true" ignore="true" />
						</c:if>
						<%-- <td class="rightCol" valign="top">
								<div class="error" id="idErrorBox" style="display:none">
									<c:if test="${not empty message && empty workflow_error}">
										<script>document.getElementById('idErrorBox').style.display='';	</script>
										<div class="clsErrorInformation"><c:out value="${message}" escapeXml="false" /></div>
									</c:if>
									<c:if test="${not empty workflow_error}">
										<script>document.getElementById('idErrorBox').style.display='';	</script>
										<div class="clsErrorInformation"><c:out value="${workflow_error}" escapeXml="false"/></div>
									</c:if>									
								</div>
								<c:if test="${not empty sessionScope.message }">
									<c:remove var="message" scope="session" />
								</c:if>
								<tiles:insertAttribute name="content" flush="true" />
							</td> --%>
						<td>
							<div class="error" id="idErrorBox" style="display: none">
								<c:if test="${not empty errMessage && empty workflow_error}">
									<script>
										document.getElementById('idErrorBox').style.display = '';
									</script>
									<div class="clsErrorInformation">
										<c:out value="${errMessage}" escapeXml="false" />
									</div>
								</c:if>

								<c:if test="${not empty workflow_error}">
									<script>
										document.getElementById('idErrorBox').style.display = '';
									</script>
									<div class="clsErrorInformation">
										<c:out value="${workflow_error}" escapeXml="false" />
									</div>
								</c:if>
							</div>

							<div class="messageBox" id="idMsgBox" style="display: none">
								<c:if test="${not empty message}">
									<script>
										document.getElementById('idMsgBox').style.display = '';
									</script>
									<div class="clsInformation">
										<c:out value="${message}" escapeXml="false" />
									</div>
								</c:if>
							</div> <c:if test="${not empty sessionScope.errMessage }">
								<c:remove var="errMessage" scope="session" />
							</c:if> <c:if test="${not empty sessionScope.message }">
								<c:remove var="message" scope="session" />
							</c:if> <tiles:insertAttribute name="content" flush="true" />
						</td>

					</tr>
				</tbody>
			</table>
		</div>
	</div>
	</div>
	<!--div class="footer">
				<tiles:insertAttribute name="footer" flush="true" ignore="true" />
			</div-->
	<div class="container-fluid">
		<!-- Row start -->
		<div class="row gutters">
			<div class="col-12">
				<!-- Footer start -->
				<div class="footer" align="right">Copyright Â© 2023 @NMC . All Rights Reserved.</div>
				<!-- Footer end -->
			</div>
		</div>
		<!-- Row end -->
	</div>
	</div>
	</form>
	<script>
		setContextRoot('<c:out value="${contextRoot}"/>');
		setCurrentDate('<c:out value="${CURRENT_DATE}"/>');
	</script>
	</body>
</html>


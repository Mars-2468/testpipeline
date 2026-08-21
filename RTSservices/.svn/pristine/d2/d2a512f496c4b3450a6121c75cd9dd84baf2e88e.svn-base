<jsp:directive.include file="/pages/common/include.jsp" />
<script type="text/javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery.animate-shadow.js"></script>
<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/home.css" />

<title>NMC - My Applications</title>
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);%>

<div class="landingPageWrapper">

<div class="landingPageHeader">
	<div class="landingPageLogo"><img src="<c:out value="${contextRoot}"/>/images/JMC_Logo.jpg" height="70px;" alt="Logo"></div>
	<div class="landingPageLogoTxt">Government Of Rajasthan</div>
	<div align="right" style="font-weight:bold;align:right;padding-top: 5px;padding-right: 10px;">
		<a href="<c:out value="${contextRoot}"/>/changePassword.do" class="chngPwdLnk">Change Password</a>  | 
		<a href="<c:out value="${contextRoot}"/>/logout.do" class="signoutLnk">Sign Out</a>
	</div>
	
	<div class="welcome">
		<BR>
		 <c:out value="${sessionScope.SessionUser.firstName}" /> &nbsp;<c:out value="${sessionScope.SessionUser.lastName}" />
		 ,&nbsp;
		 <c:out value="${sessionScope.SessionUser.userName}" />
	</div>
</div>
<br>


<div class="landingPageHeading">
	<h3> 
		<fmt:message key="user.manage.label.myapps"/>
	</h3>
</div>



<div class="mars-module-list">
	<c:forEach var="userApp" items="${requestScope.userAppSet}" varStatus="rowNumber">
		<a href="<c:out value="${userApp.application.applicationUrl}"/>">
			<div id="module<c:out value="${userApp.application.applicationId}"/>" class="mars-module" 
			onmouseout="$('#module<c:out value="${userApp.application.applicationId}"/>').stop().animate({boxShadow: '0px 0px 0px  #000'},'fast')" 
			onmouseover="$('#module<c:out value="${userApp.application.applicationId}"/>').stop().animate({boxShadow: '10px 10px 15px #000000'},'fast')"
			style="box-shadow: 0px 0px 0px 0px rgb(0, 0, 0);top: 0px;">
				<div class="module-icon">
					<img src="<c:out value="${contextRoot}"/>/images/modules/<c:out value="${userApp.application.imageUrl}"/>" width="69" height="76" />
				</div>
				<div class="module-info">
					<h4><c:out value="${userApp.application.name}"/></h4>
					<c:out value="${userApp.application.description}"/>
			  	</div> 
			</div>
		</a>			
	</c:forEach>
</div>

<div class="landingPageFooter"> Site designed and created by <a href="http://www.mars-india.com" target="_blank" style="color: white;text-decoration: underline">Mars Telecom Systems  </a></div>

</div>

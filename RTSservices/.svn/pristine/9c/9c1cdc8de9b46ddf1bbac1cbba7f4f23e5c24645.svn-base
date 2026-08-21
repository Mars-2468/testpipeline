



<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.include file="/pages/core-pages/nmc_user/dashboard/header.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants" />
<jsp:directive.page import="com.mars.common.utils.CommonUtils" />

 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>Nagpur Muncipal Corporation</title>
 </head>

 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js" rel="stylesheet"
 integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
 <link href=" https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" rel="stylesheet"
 integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
 
 <link rel="icon" href="img/favicon.ico" type="image/x-icon">
  
  <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@200;400&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="<%=url%>css/bootstrap.min.css">
  
<link rel="stylesheet" type="text/css" href="<c:out value='${contextRoot}'/>/pages/core-pages/nmc_user/css/style2.css" />
 
 <%
pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
String fname = (String) session.getAttribute("name");
String email = (String) session.getAttribute("email");
String number = (String) session.getAttribute("mobileNo");
//long rowno =((long) session.getAttribute("rowsize")-(long) session.getAttribute("rowsize"))+1;
//
long rowno=1;
//pageContext.setAttribute("statusList", CommonUtils.getStatus());
%>



  

<style type="text/css">
.ui-autocomplete-loading {
	background: white
		url('/Proper/styles/jquery/images/ui-anim_basic_16x16.gif') right
		center no-repeat;
}

.solid {
	border-style: none;
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-right: 0px;
	margin-left: 0px;
	background: #3b90b7;
}

.ClsLabel {
	font-size: 15px;
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
	text-transform: uppercase;
	letter-spacing: 1px;
	word-spacing: 1px;
	font-size: 3vw;
	color: floralwhite;
	font-family: sans-serif;
}

.inputtype {
	height: 40px;
	width: 348px;
	margin-right: 0;
}

header {
	align-items: center;
}

img {
	vertical-align: middle;
}

img {
	border: 0;
}



input[type=text] {
	width: 290px;
	padding: 10px 30px;
	margin: 15px 0;
	box-sizing: border-box;
	border: 0px solid black;
	box-shadow: 0 0 3px;
	border-radius: 5px;
}

.form-control1 {
	width: 290px;
	padding: 10px 30px;
	margin: 18px 0;
	box-sizing: border-box;
	border: 1px solid black;
	box-shadow: 0 0 5px;
	border-radius: 30px;
	font-size: 18px;
}




.value {
	font-size: 15px;
}
</style>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>






<div class="form-group" style="margin-top:-40px;" align="center" >
	<br> <br>
	<h2 style="font-weight: bold">Application Details</h2>
	<br> 
<div class="container-fluid mt-2" style="width: 180vh">

	

	<table class="table table-bordered table-striped" align="center" width="70%" height="100%"
		style="font-size: 13px;">
		<tr style="background-color:#9d9d9f;e4;color:white">
			<th class="ClsLabel">Sr No.</th>
			<th class="ClsLabel">Application Number</th>
			<th class="ClsLabel">Application Name</th>
			<th class="ClsLabel">Date Of Application</th>
			
			<th class="ClsLabel">Status</th>
						<th class="ClsLabel"></th>
			
		</tr>
		
		<c:forEach var="rtiApplication"  items="${rtiApplicationList}" varStatus="rowNumber">
			
			<tr> 
				<td class="value" >${rowNumber.index + 1}</td>    
				<td class="value">${rtiApplication.rtiApplnNumber}</td>
				<td class="value">${rtiApplication.subject}</td>
				<td class="value">${rtiApplication.registrationDate}</td>
				

					<td style="width: 230px; height: 30px"><span class="ClsLabel"
				style="font-size: 14px"> <c:if
						test="${rtiApplication.workFlowStatus==0}">
						Form Submitted 
					</c:if> <c:if test="${rtiApplication.workFlowStatus==3}">
						Payment Pending 
					</c:if> <c:if test="${rtiApplication.workFlowStatus==2}">
						Payment Completed
					</c:if> <c:if test="${rtiApplication.workFlowStatus==1}">
						Completed
					</c:if> <c:if test="${rtiApplication.workFlowStatus==5}">
						Rejected
					</c:if></span></td>
									
					<td>
    <a href="<%= request.getContextPath() %>/rtiapplication/generateApplicationPdf.do?rtiApplicationId=${rtiApplication.rtiApplicationId}&serviceId=${rtiApplication.rtiserviceid}" 
       target="_blank" onclick="downloadPDF(event, this)">
        <img src="<%=url%>img/pdf.png" alt="PDF Icon" style="width: 40px; height: 40px;">
    </a>
</td>

					

			</tr>
			
		</c:forEach>
		
	</table>
	
	
</div>
</div>

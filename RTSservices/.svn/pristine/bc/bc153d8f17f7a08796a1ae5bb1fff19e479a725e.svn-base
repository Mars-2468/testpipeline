<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page	import="com.mars.common.utils.Constants" />
<jsp:directive.page	import="com.mars.common.utils.CommonUtils" />
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="com.mars.common.utils.SessionUser"%>
<%@ page import="com.mars.common.model.User"%>
<script type="text/javascript"
	src="<c:out value=" ${contextRoot}" />/scripts/jquery/jquery.ajaxfileupload.js"></script>
<head>  
<%
    HttpSession session1 = request.getSession();
    //Object as_success = session1.getAttribute("as_status");
    String name_1 = (String) request.getSession().getAttribute("name");
    String asStatus=null;
    if (name_1 != null) {
    	asStatus = "-1";
        request.setAttribute("asStatus", asStatus);
    }
%>
		
<%
    pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
    pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
    pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
    pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
    pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
    pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
    ///pageContext.setAttribute("statusList", CommonUtils.getStatus());
    String name=(String)session.getAttribute("name"); 
    String contextPath = request.getContextPath();
    String url = contextPath + "/pages/core-pages/nmc_user/";
    %>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Nagpur Municipal Corporation</title>
<link rel="icon" href="img/favicon.ico" type="image/x-icon">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@200;400&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="<%=url%>css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<c:out value='${contextRoot}'/>/pages/core-pages/nmc_user/css/style2.css" />

<style>
   #xyz {
    background-image: url("<%= url %>img/dashbackground.jpg");
    background-size: cover; 
    background-repeat: no-repeat; 
    background-position: center; 
}

</style>
</head>
<body id="home" class="bg-grey">
<div class="container-fluid">
    <div class="row p-2 border bg-blue d-flex align-items-center" id="xyz">
        <div class="col-md-1">
            <img src="<%=url%>img/nagpur.png" class="img-fluid">
        </div>

        <div class="col-md-10"> <!-- Modified column width to 10 -->
            <h3 class="m-0" style="color:white;align-content: end;font-size:22;">नागपूर महानगरपालिका, नागपूर</h3>
            <h3 class="m-0" style="color:white;font-size:22;">Right to Services</h3>
        </div>
            	    	<div class="col-md-1"><img src="<%= url%>img/g21.png" class="img-fluid"></div>
    </div>
    

<c:choose>
<c:when test="${asStatus == '-1'}">
<!-- Navigation bar below the main content -->
<div class="container-fluid p-0 bg-white">
    <div class="container "> 
    	<div class="row">
        	<div class="col-md-6 d-flex align-items-center">
            	<ol class="breadcrumb bg-white pb-0">
            	
                    <li class="breadcrumb-item" style="font-size:16px;"><a href='<c:out value="${contextRoot}"/>/ws/nmc/dashboard.do'><strong>मुख्यपृष्ठ</strong></a></li>
                    <li class="breadcrumb-item active" style="font-size:16px;"><strong>डॅशबोर्ड</strong> </li>
                 
              </ol>
            </div>
            
            <div class="col-md-6 d-flex justify-content-end ">
            	<a class="nav-link dropdown-toggle d-flex align-items-center" id="navbarDropdownMenuLink-4" data-toggle="dropdown"
                  aria-haspopup="true" aria-expanded="false"  style="font-size:15px";>
                  <i class="fa fa-user-circle  bg-gery pr-3"  ></i><c:out value="${requestScope.name}"></c:out></a>
            	
                
                <div class="dropdown-menu">											
                  <a class="dropdown-item" href='<c:out value="${contextRoot}"/>/ws/dashboard/myprofile.do'><i class="fa fa-user p-2"></i>  My Account</a>
                  <a class="dropdown-item" href="#" onclick="find()"><i class="fa fa-sticky-note-o p-2"></i> My Application</a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href='<c:out value="${contextRoot}"/>/ws/user/logout.do'><i class="fa fa-sign-out p-2"></i> Log out</a>
                </div>
                
                <!-- Basic dropdown -->
            </div>
        </div>
    </div> 
    
</div>
</c:when>
<c:otherwise>
<br>
</c:otherwise>



</c:choose>
    </div>

<!-- Additional CSS for overall styling -->
<style>
/* Add your additional CSS styling here */
</style>

<!-- Additional JavaScript Libraries -->
<script type="text/javascript" src="<%=url%>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=url%>js/popper.min.js"></script>
<script type="text/javascript" src="<%=url%>js/bootstrap.js"></script>
<script type="text/javascript" src="<%=url%>js/mdb.min.js"></script>

<!-- Your existing JavaScript function -->
<script type="text/javascript">
function find() {
    onPageSubmit('<c:out value="${contextRoot}"/>/ws/dashboard/myapplication.do');
}
</script>
</body>
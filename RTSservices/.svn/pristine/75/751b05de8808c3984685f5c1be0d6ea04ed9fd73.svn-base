<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page	import="com.mars.common.utils.Constants" />
<jsp:directive.page	import="com.mars.common.utils.CommonUtils" />
<script type="text/javascript"
	src="<c:out value=" ${contextRoot}" />/scripts/jquery/jquery.ajaxfileupload.js"></script>
<head>  

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
   <form action=""> 
    
	<div class="row p-5 mt-5" >
    	<div class="col-md-12 pl-md-0">        	
        	<div class="row align-items-center justify-content-center">
            	<div class="col-md-5 p-md-0 ">
                	<div class="sign-card">
                    	<h3 class="h3 text-center pb-3">User Details</h3>
                   <!--    <ul class="nav nav-tabs mb-4">
                          <li class="nav-item w-50">
                            <a  href="" target="_blank" class="border-button btn btn-primary bd-highlight w-100" style="border-radius:.25rem 0 0 .25rem">User Id</a>
                          </li>  
                          <li class="nav-item w-50" >
                            <a  href="" target="_blank" class="bg-button btn btn-primary bd-highlight w-100" style="border-radius: 0 .25rem .25rem 0">Mobile number</a>
                          </li>--> 
                          
                        </ul>
                        <c:choose>
                        <c:when test="${not empty msg}">
                        
                        <p  style="color:red" ><c:out value="${msg}"/></p>
       
                        </c:when>
                        <c:otherwise>             
                        </c:otherwise>
                   </c:choose>  
                         <input id="user" class="search form-control form-control-lg mb-3" type="text" maxlength="15" placeholder="Enter User Name" name="mobileNo"  
                        <c:choose>
                        <c:when test="${not empty mobileNo && empty error}">
                              readOnly=”true” value="<%= request.getParameter("mobileNo") %>"
                              
                        </c:when>
                        <c:otherwise>
                        </c:otherwise>
                        </c:choose>  >
                        
                        
                               
                             
                          <p id="userError" style="color:red"></p>
                          
                             
                         <c:choose>
                         <c:when test="${not empty otp}">
                               <div>
                            <input id="mobile" class="search form-control form-control-lg mb-3" type="number" maxlength="10" placeholder=""  name="mobileNo"  value="${requestScope.userMobileNumber}" readonly/>
                       
                               <input id="otp" class="search form-control form-control-lg mb-1" type="number" name="otp" placeholder="Enter OTP"   onblur="validateOTP()">
                               <input id="count" class="search form-control form-control-lg mb-1" type="hidden" name="id" value="${requestScope.id}">
                               
                               </div>
                              <p id="otpError" style="color:red"></p>
                              
                               <div>
                                <a   class="bg-button btn btn-primary bd-highlight"  onclick="javascript:login(this.form);" >Submit</a>
                                 <a class=vpn"active float-right" onclick="javascript:resend(this.form);" id="resend">Resend OTP</a>                                
 </div>
                          </c:when>
                          
                                                   <c:when test="${not empty otp1 || not empty id}">
                    
                          
                          <input id="" class="search form-control form-control-lg mb-3" type="password" maxlength="" placeholder="Enter Old Password" value="${requestScope.oldPassword}" name="oldPassword" />
                                                 <input id="" class="search form-control form-control-lg mb-3" type="password" maxlength="" placeholder="Entter New Password" value="${requestScope.newPassword}" name="newPassword" />
                       
                               <input id="" class="search form-control form-control-lg mb-1" type="password" name="retypePassword" value="${requestScope.strRetypePassword}" placeholder="Re Enter New Password">
                                                           <input id="" class="search form-control form-control-lg mb-1" type="hidden" name="id" value="${requestScope.id}">
                             
                               <br>
                                                          <a   class="bg-button btn btn-primary bd-highlight" onclick="javascript:changePassword(this.form);">Submit</a>
                                                                                           <a class=vpn"active float-right" href='<c:out value="${contextRoot}"/>/login.do' id="resend">Login</a>                                
                          
                          
                          </c:when>
                          <c:otherwise>
                                <div class="pt-4">
                                
                                <a   class="bg-button btn btn-primary bd-highlight" onclick="javascript:save(this.form);">Submit</a>
                                                                 <a class=vpn"active float-right" href='<c:out value="${contextRoot}"/>/login.do' id="resend">Login</a>                                
                                
                                </div>  
                          </c:otherwise>
                          </c:choose>
                          
                          	
                </div>
         </div>
   	
        </div>
    </div>
	
</div>
</form>
</body>
 <script type="text/javascript">

 $(document).ready(function() {
	  history.pushState(null, null, location.href);
	  window.onpopstate = function () {
	    history.go();
	  };
	});


 /* window.onload = function() {
     window.history.forward();
 } */
 
function save(){
console.log("hello");
/* if(!validateUser()){
	return;
} else{ */
onPageSubmit('<c:out value="${contextRoot}"/>/changepassword.do');
 //}
} 


function login() {
	
	    
		onPageSubmit('<c:out value="${contextRoot}"/>/changepassword.do');
	
}
                                                          

function changePassword(){                          

 
	onPageSubmit('<c:out value="${contextRoot}"/>/changepassword.do');



	
}
$(document).ready(function() {
	  $('#resend').click(function() {
	    $('#count').val('2');
	    onPageSubmit('<c:out value="${contextRoot}"/>/changepassword.do');
	  });
	});


/*   function validateUser() {
    var mobile = document.getElementById("user").value;
    var mobileError = document.getElementById("userError");
    if (!mobileRegex.test(mobile)) {
        mobileError.innerHTML = "Invalid User Name";
        return false;
    } else {
        mobileError.innerHTML = "";
        return true;
    }
}   */
</script> 
</html>
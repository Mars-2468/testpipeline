<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page	import="com.mars.common.utils.Constants" />
<jsp:directive.page	import="com.mars.common.utils.CommonUtils" />
<script type="text/javascript"
	src="<c:out value=" ${contextRoot}" />/scripts/jquery/user-script.js"></script>
    
  <meta charset="UTF-8">
  <meta name="keywords" content="human centered design process, ihcd">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Sign In</title>
  
  <link rel="icon" href="img/favicon.ico" type="image/x-icon">
  
  <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@200;400&display=swap" rel="stylesheet">
  <!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="css/bootstrap.min.css">
  
  
<link rel="stylesheet" type="text/css" href="<c:out value='${contextRoot}'/>/pages/core-pages/nmc_user/css/style1.css" /> 
	
 <%
pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
///pageContext.setAttribute("statusList", CommonUtils.getStatus());
String contextPath = request.getContextPath();
String url = contextPath + "/pages/core-pages/nmc_user/";

%>
 
</head>
<style>
#home{

background-image:url('<c:out value=" ${contextRoot}" />/pages/core-pages/nmc_user/img/citizenbackground.jpg');
background-position: bottom center;
    background-size: cover; 
  background-repeat:no-repeat;

}

#xyz {
        background-image: url("<%= url %>img/dashbackground.jpg");
        background-size: cover; 
        background-repeat: no-repeat; 
        background-position: center; 
    }
</style>
<body id="home">
<div class="container-fluid"  style="height:100vh;">
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
    
    <%--  <div class="row p-2 border bg-blue d-flex align-items-center" id="xyz" style="padding-left: 0rem !important;padding-right: 0rem !important;">
        <div class="col-md-1">
            <img src="<%=url%>img/nagpur.png" class="img-fluid">
        </div>
         <div class="col-md-1">
             <img src="<%=url%>img/mars_logo.jpg"  class="img-responsive" style="height:95px;width:125px;margin-left:-8px">
        </div>

        <div class="col-md-9"> <!-- Modified column width to 10 -->
            <h3 class="m-0 ms-2" style="color:white;align-content: end;font-size:22;">नागपूर महानगरपालिका, नागपूर</h3>
            <h3 class="m-0 ms-2" style="color:white;font-size:22;">Right to Services</h3>
        </div>
            	    	<div class="col-md-1"><img src="<%= url%>img/g21.png" class="img-fluid"></div>
    </div> --%>
   <form action=""> 
    
	<div class="row p-5 mt-5" >
    	<div class="col-md-12 pl-md-0">        	
        	<div class="row align-items-center justify-content-center">
            	<div class="col-md-5 p-md-0 ">
                	<div class="sign-card">
                    	<h3 class="h3 text-center pb-3">Sign In</h3>
                   <!--    <ul class="nav nav-tabs mb-4">
                          <li class="nav-item w-50">
                            <a  href="" target="_blank" class="border-button btn btn-primary bd-highlight w-100" style="border-radius:.25rem 0 0 .25rem">User Id</a>
                          </li>  
                          <li class="nav-item w-50" >
                            <a  href="" target="_blank" class="bg-button btn btn-primary bd-highlight w-100" style="border-radius: 0 .25rem .25rem 0">Mobile number</a>
                          </li>--> 
                          
                        </ul>
                        
                         <input id="mobile" class="search form-control form-control-lg mb-3" type="text" maxlength="10" placeholder="Enter Mobile Number"  name="mobileNo" pattern="[6-9]{1}[0-9]{9}"  onblur="validateMobile()"
                        <c:choose>
                        <c:when test="${not empty mobileNo}">
                              readOnly=”true” value="<%= request.getParameter("mobileNo") %>"
                        </c:when>
                        <c:otherwise>
                        </c:otherwise>
                        </c:choose>  >
                        
                        
                        <!-- Hidden input to store the mobile number -->
  <input type="hidden" name="originalMobileNo" id="originalMobileNo" value="<%= request.getParameter("mobileNo") %>">
  
  <script>
   
  document.addEventListener('DOMContentLoaded', function() {
	  const mobileInput = document.getElementById('mobile');
	  const originalMobileNo = document.getElementById('originalMobileNo').value;

	  console.log(mobileInput, "mobileInput");

	  // Prevent editing of the mobile input field if it's readonly
	  if (mobileInput.hasAttribute('readonly')) {
	    mobileInput.addEventListener('keydown', function(e) {
	      e.preventDefault();
	    });
	    mobileInput.addEventListener('cut', function(e) {
	      e.preventDefault();
	    });
	    mobileInput.addEventListener('paste', function(e) {
	      e.preventDefault();
	    });
	    mobileInput.addEventListener('input', function(e) {
	      e.preventDefault();
	      mobileInput.value = originalMobileNo;  // Reset the value to original
	    });

	    setInterval(function() {
		    if (mobileInput.value !== originalMobileNo) {
		      mobileInput.value = originalMobileNo;  // Reset the value to original
		    }
		  }, 10);
	  }

	  // Continuously check the value and reset if it changes
	  // Check every second
	});


  </script>
                        
                        <c:choose>
                        <c:when test="${not empty msg}">
                        
                        <p  style="color:red" ><c:out value="${msg}"/></p>
       
                        </c:when>
                        <c:otherwise>
                              
                        </c:otherwise>
                   </c:choose>  
                               
                             
                          <p id="mobileError" style="color:red"></p>
                             
                         <c:choose>
                         <c:when test="${not empty otp}">
                               <div>
<input
  id="otp"
  class="search form-control form-control-lg mb-1"
  type="text"
  name="otp"
  placeholder="Enter OTP"
  pattern="\d{6}" 
  maxlength="6"
  oninput="this.value = this.value.replace(/[^0-9]/g, '').slice(0, 6)"
  onblur="validateOTP()"
>                                 <input type="hidden" name="originalOtp" id="originalOtp" value="">
                               
                               </div>
                               
                               <script>
                               document.addEventListener('DOMContentLoaded', function() {
                            	   const otpInput = document.getElementById('otp');
                            	   const originalOtpInput = document.getElementById('originalOtp');

                            	   // Function to validate OTP (optional)
                            	   function validateOTP() {
                            	     const otpValue = otpInput.value;
                            	     // Add your OTP validation logic here
                            	     if (otpValue.length === 6) { // Example: OTP should be 6 digits
                            	       originalOtpInput.value = otpValue; // Store the original OTP value
                            	     } else {
                            	       alert('Invalid OTP');
                            	     }
                            	   }

                            	   // Continuously check the value and reset if it changes
                            	 /*   setInterval(function() {
                            	     if (otpInput.value !== originalOtpInput.value) {
                            	       otpInput.value = originalOtpInput.value;  // Reset the value to original
                            	     }
                            	   }, 1000);  // Check every second */

                            	   // Add the onblur event listener
                            	   otpInput.addEventListener('blur', validateOTP);
                            	 });


                               </script>
                              <p id="otpError" style="color:red"></p>
                              
                               <div>
                                <a   class="bg-button btn btn-primary bd-highlight"  onclick="javascript:login(this.form);" >Login</a>
                                <a id="resendBtn" class="bg-button btn btn-primary bd-highlight" onclick="javascript:resend(this.form);">Resend OTP</a>   
                                                                                                                                <span id="timer" style="display:none;color:black;margin-left:80px; margin-top:20px;" ></span>
                                                             
                                </div>
                                
                          </c:when>
                          <c:otherwise>
                                <div class="pt-4">
                                <a   class="bg-button btn btn-primary bd-highlight" onclick="javascript:save(this.form);">Send OTP</a>
                                <a class="active float-right" onclick="javascript:register(this.form);">Register</a>
                                
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
function save(){
console.log("hello");
if(!validateMobile()){
	return;
} else{
onPageSubmit('<c:out value="${contextRoot}"/>/ws/nmc/user/login.do');
}
}


function login() {
	
	if(!validateOTP()){
		return;
	} else{
		onPageSubmit('<c:out value="${contextRoot}"/>/ws/user/dashboard.do');
	}
}



<%-- 
 function resend() {
	
	onPageSubmit('<c:out value="${contextRoot}"/>/ws/nmc/user/login.do');

}  --%>


function register() {
	
	onPageSubmit('<c:out value="${contextRoot}"/>/ws/user/registration.do');

}
</script>


<script>
let timerInterval; // To hold the interval ID for clearing it later
let countdownTime = 60; // Countdown timer (in seconds)

// Function to handle OTP resend logic
function resend() {
  // Disable the button to prevent multiple clicks
  const resendBtn = document.getElementById("resendBtn");
  resendBtn.disabled = true;
  resendBtn.style.color = 'grey';
  resendBtn.style.cursor = 'not-allowed'; 

  // Show the timer
  const timerElement = document.getElementById("timer");
  timerElement.style.display = 'inline-block';
  timerElement.textContent ='Please wait ' + countdownTime + ' seconds';

  // Debugging output to check the initial state
  console.log("Initial timer text:", timerElement.textContent);

  // Start the countdown
  startCountdown(timerElement, resendBtn);

  // Your resend OTP logic here (e.g., send OTP via API)
  console.log("Resend OTP request made...");
   


  var formData = new FormData();

  var mobile = document.getElementById("mobile").value;
  formData.append("mobileNo", mobile);

  for (var pair of formData.entries()) {
      console.log(pair[0] + ': ' + pair[1]);
  }

       var mbno=$('#mobile').val();
       $.ajax({
    	   url: "/RTSservices/ws/nmc/user/resendOtp.do?mobileNo="+mbno,
    	   type: "POST",
           dataType: "json",
           success: function (response) {
               var status=response.status;
               if(status===true || status==='true'){

                   return true;
               }else{
            	   alert("Something Went Wrong!!");
            	   return false;
                   }
           },
           error: function(xhr, status, error) {
               console.error("An error occurred: " + status + "\n" + error);
           }
       });
}

// Function to handle countdown logic
function startCountdown(timerElement, resendBtn) {
  timerInterval = setInterval(function () {
    countdownTime--; // Decrease the countdown timer

    // Debugging output
    console.log("Countdown time:", countdownTime);

    // Update the timer text
   timerElement.textContent = 'Please wait ' + countdownTime + ' seconds';


    // Debugging output to confirm the update
    console.log("Updated timer text:", timerElement.textContent);

    // When the countdown reaches 0, enable the resend button again
    if (countdownTime <= 0) {
      clearInterval(timerInterval); // Stop the countdown
      resendBtn.disabled = false; // Enable the button
      timerElement.style.display = 'none'; // Hide the timer text
      resendBtn.style.cursor = 'pointer'; 
      resendBtn.style.color = 'white'; // Reset color to blue
       countdownTime = 60; // Reset the countdown time for the next use
    }
  }, 1000); // Update every second
}
</script>
</html>
<%@ include file="/pages/common/include.jsp"%>
<script type="text/javascript">
	// validating user in login page
	function validate(form) {
		var arrElements = new Array('j_username', 'j_password');
		var arrElementNames = new Array('<fmt:message key="login.username"/>',
				'<fmt:message key="login.password"/>');
		if (checkMandatoryDetailed(arrElements, arrElementNames)) {
			if (validatePasswordLength('j_password')) {
				form.action = "<c:out value="${contextRoot}"/>/j_spring_security_check";
				form.submit();
			}
		}
	}
	window.onload = function() {
		var errMessage = "${errMessage}";
		var unblockMessage = "${unblockedmessage}";
		if (errMessage.length > 0) {
		      var alertBox = document.createElement("div");
		      alertBox.style.color = "black";
		      alertBox.style.background = "rgba(239, 158, 158, 0.214)";
		      alertBox.style.border = "1px solid black";
		      alertBox.textContent = errMessage;
		      alertBox.style.fontSize = "18px";
		        alertBox.style.height = "50px"; // Set the desired height here
		        alertBox.style.textAlign = "center"; // Center the text
		        alertBox.style.paddingTop = "10px"; // Add space above the text
		        
		        var textSpan = document.createElement("span");
		        textSpan.textContent = errMessage;
		        textSpan.style.marginTop = "100px"; // Set the desired margin top for text


		      var bodyElement = document.getElementsByTagName("body")[0];
		      bodyElement.insertBefore(alertBox, bodyElement.firstChild);
		      alert(errMessage);
	      }

		if (unblockMessage.length > 0) {
	        var alertBox = document.createElement("div");
	        alertBox.style.color = "rgb(48, 145, 37)";
	        alertBox.style.background = "rgba(31, 132, 20, 0.127)";
	        alertBox.style.border = "1px solid green";
	        alertBox.textContent = unblockMessage;
	        alertBox.style.fontSize = "18px";
	        alertBox.style.height = "50px"; // Set the desired height here
	        alertBox.style.textAlign = "center"; // Center the text
	        alertBox.style.paddingTop = "10px"; // Add space above the text
	        

	        var textSpan = document.createElement("span");
	        textSpan.textContent = errMessage;
	        textSpan.style.marginTop = "100px"; // Set the desired margin top for text


	        var bodyElement = document.getElementsByTagName("body")[0];
	        bodyElement.insertBefore(alertBox, bodyElement.firstChild);
	        alert(unblockMessage);
	    }

	};
</script>


<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1.0, shrink-to-fit=no">
<link href="<c:out value="${contextRoot}"/>/login/images/favicon.png"
	rel="icon" />
<title>e-Governance @NMC</title>
<meta name="description" content="e-Governance @Aurangabad">


<!-- Web Fonts
========================= -->
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900'
	type='text/css'>

<!-- Stylesheet
========================= -->
<link rel="stylesheet" type="text/css"
	href="<c:out value="${contextRoot}"/>/styles/login/css/bootstrap.min.css" />
<!--<link rel="stylesheet" type="text/css" href="css/all.min.css" />-->
<link rel="stylesheet" type="text/css"
	href="<c:out value="${contextRoot}"/>/styles/login/css/stylesheet.css" />
<!-- Colors Css -->
<link id="color-switcher" type="text/css" rel="stylesheet"
	href="<c:out value="${contextRoot}"/>/styles/login/css/color-purple.css" />

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">

</head>
<body>



	<div id="main-wrapper" class="login-register">
		<div class="hero-wrap">
			<div class="hero-mask opacity-8 bg-dark"></div>
			<div class="hero-bg hero-bg-scroll"
				style="background-image:url('<c:out value="${contextRoot}"/>/styles/login/images/login-bg-4.jpg');"></div>
			<div class="hero-content w-100">
				<div class="container">
					<div class="row g-0">
						<div class="col-lg-11 col-xl-9 mx-auto">
							<div class="row g-0 min-vh-100">
								<!-- Welcome Text ========================= -->
								<div class="col-md-6">
									<div class="hero-wrap h-100">
										<div class="hero-mask opacity-7 bg-primary"></div>
										<div class="hero-bg hero-bg-scroll"
											style="background-image:url('<c:out value="${contextRoot}"/>/styles/login/images/login-bg_nmc.jpg');"></div>
										<div class="hero-content w-100 min-vh-100 d-flex flex-column">
											<div class="row g-0">
												<div class="col-10 col-lg-9 mx-auto"></div>
											</div>
											<div class="row g-0 my-auto">
												<div class="col-10 col-lg-9 mx-auto">
													<h1 class="text-10 text-white fw-700 text-uppercase mb-4">
														TO KEEP CONNECTED WITH <br> e-Governance @NMC
													</h1>

													<p class="text-white fw-300 lh-base mb-5">
														We are glad to see you again! <br> Get access to your
														Tasks.
													</p>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- Welcome Text End -->
								<!-- Login Form
			  ========================= -->
								<div class="col-md-6 d-flex flex-column bg-light shadow-lg">
									<div class="container my-auto py-5">
										<div class="row g-0">
											<div class="col-10 col-lg-9 mx-auto">
												<h3 class="text-7 fw-600 mb-2">Log In</h3>

												<form id="loginForm" class="form-border" method="post">
													<div class="icon-group icon-group-end mb-3">
														<tr>
															<!-- ===="Username" label==== -->
															<td>
															<span class="ClsLabel"><fmt:message
																		key="login.username" /> </span> <span
																class="ClsRequiredFields" style="color: red">*</span></td>
															<input type="text" maxlength="30" id="j_username"
																name="j_username" class="form-control login"
																value="${requestScope.userName}"
																style="width:150px;background: url(${contextRoot}/images/icon_user.gif) no-repeat scroll 5px 2px transparent;padding: 4px 3px 4px 25px;"
																onkeypress="javascript:doLoginOnEnterClick(event)" />
																
															<span class="icon-inside"><i
																class="fas fa-envelope"></i></span>
														</tr>
													</div>
													<div class="icon-group icon-group-end mb-3">
														<tr>
															<td><span class="ClsLabel"><fmt:message
																		key="login.password" /> </span> <span
																class="ClsRequiredFields" style="color: red">*</span></td>
															<td><input type="password"  maxlength="30"id="j_password" 
																name="j_password"class="form-control login" 
                                                                value="${requestScope.userPassword}"
																style="width:150px;background: url(${contextRoot}/images/icon_pass.gif) no-repeat scroll 5px 2px transparent;padding: 4px 3px 4px 25px;"
																onkeypress="javascript:doLoginOnEnterClick(event)" /> <span
																onclick="passwordShow()" style="margin-top: 50px;">
																	<svg xmlns="http://www.w3.org/2000/svg" width="15"
																		height="22" viewBox="0 0 24 24"
																		style="margin-top: -28px; margin-left: 125px;">
																		<path
																			d="M12.015 7c4.751 0 8.063 3.012 9.504 4.636-1.401 1.837-4.713 5.364-9.504 5.364-4.42 0-7.93-3.536-9.478-5.407 1.493-1.647 4.817-4.593 9.478-4.593zm0-2c-7.569 0-12.015 6.551-12.015 6.551s4.835 7.449 12.015 7.449c7.733 0 11.985-7.449 11.985-7.449s-4.291-6.551-11.985-6.551zm-.015 3c-2.209 0-4 1.792-4 4 0 2.209 1.791 4 4 4s4-1.791 4-4c0-2.208-1.791-4-4-4z" /></svg>
															</span> <span class="icon-inside"><i class="fas fa-lock"></i></span>
															</td>
														</tr>
													</div>

													<c:if test="${not empty requestScope.mobileNo}">
														<div class="icon-group icon-group-end mb-3">
															<span class="ClsLabel"><fmt:message
																	key="Mobile Number" /> </span> <span
																class="ClsRequiredFields" style="color: red">*</span> <input
																type="number" maxlength="10" id="mobileNo"
																name="mobileNo" class="form-control login"
																style="width: 200px; padding: 4px 3px 4px 15px; margin-bottom: -5px;"
																value="${requestScope.mobileNo}" readonly>


														</div>
													</c:if>

													<c:if test="${ not empty requestScope.otp}">
														<div class="icon-group icon-group-end mb-3">
															<span class="ClsLabel"><fmt:message key="OTP" />
															</span> <span class="ClsRequiredFields" style="color: red">*</span>

															<input
  type="number"
  id="otp"
  name="optNo"
  class="form-control login"
  style="width: 200px; padding: 4px 3px 4px 15px;"
  value=""
  oninput="this.value = this.value.slice(0, 6)"
/>

														</div>
														<div
															style="display: flex; flex-direction: column; gap: 0px;">
															<p class="mt-3">
																<button type="button" class="btn custom-bt" id="resendBtn"
																	onclick="resend(this.form)" style="background: none; border: none; padding: 0; color: blue; cursor: pointer; text-decoration: underline;">Resend
																	OTP</button>
                                                                <span id="timer" style="margin-left: 20px !important;"> </span>
                                                                </p>
<!-- 
															<p class="mt-3">
																<button type="button" class="btn custom-bt"
																	onclick="resetDetails(this.form)"
																	style="background: none; border: none; padding: 0; color: red; cursor: pointer; text-decoration: underline; margin-top: -26px;">Go
																	back</button>
															</p> -->

														</div>

													</c:if>
													
													<input type="hidden" name="userOtp" id="userOtp" value="${requestScope.userOtp}">
		                   		                   <input type="hidden" name="resentotp" id="resentotp" value="${requestScope.resentotp}">

													<tr>
														<td align="center" colspan="2"><input type="button"
															name="login" id="login" value="Log In" name="login"
															id="login" class="btn btn-primary rounded-0 my-4"
															onclick="validate(this.form);"> <input
															type="button" value="Reset"
															class="btn btn-primary rounded-0 my-4"
															onclick="javascript:document.frmPage.reset();clearContorls();">

														</td>
													</tr>
												</form>
												<p class="mt-3">
													<a class="text-2" href="javascript:passwordChanged()">Forgot
														your password?</a>
												</p>
											</div>
										</div>
									</div>
									<div class="container pt-2 pb-3">
										<div class="row">
											<div class="col-10 col-lg-9 mx-auto">
												<p class="text-2 text-muted mb-0">
													Copyright Â© 2023 <a href="javascript:void(0)">@NMC </a>.
													All Rights Reserved.
												</p>
											</div>
										</div>
									</div>
								</div>
								<!-- Login Form End -->

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- Script -->
	<script
		src="<c:out value="${contextRoot}"/>/styles/login/js/jquery.min.js"></script>
	<script
		src="<c:out value="${contextRoot}"/>/styles/login/js/bootstrap.bundle.min.js"></script>
	<!-- Style Switcher -->
	<script
		src="<c:out value="${contextRoot}"/>/styles/login/js/switcher.min.js"></script>
	<script src="<c:out value="${contextRoot}"/>/styles/login/js/theme.js"></script>
</body>
</html>
<input type="hidden" id="lang" name="lang" value="en">
<script type="text/javascript">
	document.getElementById('j_username').focus();

	function updateLanguage(langCode) {
		document.getElementById("lang").value = langCode
		onPageSubmit('<c:out value="${contextRoot}"/>/login.do');
	}

	function passwordChanged() {
		onPageSubmit('<c:out value="${contextRoot}"/>/changePassword.do');
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
      resendBtn.style.textDecoration = 'none';


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

      // Manually collect form values using getElementById
      var mobileNo = document.getElementById("mobileNo").value;
       var userName = document.getElementById("j_username").value;
      

      // Append values to FormData with the same name attributes as the form fields
      formData.append("j_username", userName);
      formData.append("mobileNo", mobileNo);

      

      // Log FormData entries for debugging
      for (var pair of formData.entries()) {
          console.log(pair[0] + ': ' + pair[1]);
      }

      var mbno=$('#mobileNo').val();
      $.ajax({
   	   url: "/RTSservices/resendOtp.do?mobileNo="+mbno,
   	   type: "POST",
          dataType: "json",
          success: function (response) {
              var status=response.status;
              if(status===true || status==='true'){

            	  var resendOtp=response.resendOtp;
            	  $('#resentotp').val(resendOtp);
            	  $('#userOtp').val(resendOtp);
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
          resendBtn.style.color = 'blue'; // Reset color to blue
          resendBtn.style.textDecoration = 'underline'; // Reset underline
          resendBtn.style.backG
          countdownTime = 60; // Reset the countdown time for the next use
        }
      }, 1000); // Update every second
    }
  </script>
  
  

<script>
	function passwordShow() {
		var password = document.getElementById("j_password");
		if (password.type === "password") {
			password.type = "text";
		} else {
			password.type = "password";
		}
	}
	
	$(document).ready(function() {
	    var mobile = ${requestScope.mobileNo};
	    if (mobile !== '') {
	        $('#j_username').attr("readonly", true);
	        $('#j_password').attr("readonly", true);
	    }
	});
</script>
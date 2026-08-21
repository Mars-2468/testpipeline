<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants" />
<jsp:directive.page import="com.mars.common.utils.CommonUtils" />
<script type="text/javascript"
	src="<c:out value=" ${contextRoot}" />/scripts/jquery/jquery.ajaxfileupload.js"></script>
<%
pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
///pageContext.setAttribute("statusList", CommonUtils.getStatus());
%>
  <title>MCD</title>
  
  <link rel="icon" href="img/favicon.ico" type="image/x-icon">
  
  <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@200;400&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
  <!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="css/bootstrap.min.css">
  
  <link rel="stylesheet" href="css/style.css">
 
<style>
</style>
  
</head>
<body id="home" class="bg-grey" style="background-image:url(img/bg.jpg); background-position: bottom center;
    background-size: cover; background-repeat:no-repeat;">

<div class="container-fluid"  style="height:100vh;">
	<div class="row p-4 border bg-blue">
    	<div class="col-md-1"><img src="img/aurangabad.png" class="img-fluid"></div>
        <div class="col-md-10"><p class="h2 text-center text-white">Nagpur Muncipal Corporation	</p></div>
        <div class="col-md-1"></div>
    </div>
    
    
	<div class="row p-5" >
    	<div class="col-md-12 pl-md-0">        	
        	<div class="row align-items-center justify-content-center">
            	<div class="col-md-5 p-md-0 ">
                	<div class="sign-card">
                    	<h3 class="h3 text-center pb-3">Sign In with</h3>
                        <ul class="nav nav-tabs mb-4">
                          <li class="nav-item w-50">
                            <a  href="" target="_blank" class="border-button btn btn-primary bd-highlight w-100" style="border-radius:.25rem 0 0 .25rem">User Id</a>
                          </li>
                          <li class="nav-item w-50" >
                            <a  href="" target="_blank" class="bg-button btn btn-primary bd-highlight w-100" style="border-radius: 0 .25rem .25rem 0">Mobile number</a>
                          </li>
                          
                        </ul>
                        
                        <input id="email" class="search form-control form-control-lg mb-3" type="text" placeholder="Enter Mobile number">
                                <input id="email" class="search form-control form-control-lg mb-1" type="text" placeholder="Enter OTP">	
                                <!--<a class="active">Resend OTP</a>-->
                                <!--<p class="small mt-2"></p>-->
                                <div class="pt-4">
                                    <a  href="" target="_blank" class="bg-button btn btn-primary bd-highlight">Send OTP</a>
                                    <a class="active float-right">Resend OTP</a>
                                </div>
                       
                    </div>
                    	
                </div>
            	
         </div>
        	
            	<!--<div class="row align-items-center">
                <div class="col">
                  One of three columns
                </div>
             </div>-->
        	
        </div>
    </div>
	
</div>
































  <!-- jQuery -->
  <script type="text/javascript" src="js/jquery.min.js"></script>
 
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  
  <!-- Your custom scripts (optional) -->
  <script type="text/javascript" src="js/main.js"></script>
  <!--<script type="text/javascript">
    async function postData(url = '', data = {}) {
        // Default options are marked with *
        const response = await fetch(url, {
            method: 'POST', // *GET, POST, PUT, DELETE, etc.
            mode: 'cors', // no-cors, *cors, same-origin
            cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
            credentials: 'same-origin', // include, *same-origin, omit
            headers: {
                'Content-Type': 'application/json'
                // 'Content-Type': 'application/x-www-form-urlencoded',
            },
            redirect: 'follow', // manual, *follow, error
            referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
            body: JSON.stringify(data) // body data type must match "Content-Type" header
        });
        return response.json(); // parses JSON response into native JavaScript objects
    }
    function subscribeToNewsletter() {
        var email = document.getElementById('email');
        if (email && email.value) {
            postData('https://muvmadebmf.execute-api.us-east-1.amazonaws.com/prod/', { email: email.value })
                .then(data => {
                    console.log(data); // JSON data parsed by `data.json()` call
                    email.value = '';
                    $('#subscribed-modal').modal('show')
                });
        }
    }

</script>-->
</body>
</html>

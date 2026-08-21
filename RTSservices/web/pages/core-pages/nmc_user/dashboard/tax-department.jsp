 <%@page contentType="text/html" pageEncoding="UTF-8"%>
 <jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants" />
<jsp:directive.page import="com.mars.common.utils.CommonUtils" />
<tiles:importAttribute scope="request" name="breadcrumbsList" ignore="true" />
<tiles:importAttribute scope="request" name="parentMenu" ignore="true" />
<tiles:importAttribute scope="request" name="selectedMenu" ignore="true" />

<%
pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
String name=(String)session.getAttribute("name"); 

String contextPath = request.getContextPath();
String url = contextPath + "/pages/core-pages/nmc_user/";
%>
<head>  
    
  <meta charset="UTF-8">
  
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Nagpur Municipal Corporation</title>
  
  <link rel="icon" href="img/favicon.ico" type="image/x-icon">
  
  <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@200;400&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <!-- Bootstrap core CSS -->
 <link rel="stylesheet" href="<%=url%>css/bootstrap.min.css">
  
<link rel="stylesheet" type="text/css" href="<c:out value='${contextRoot}'/>/pages/core-pages/nmc_user/css/style2.css" /><style>
  body {
    font-family: 'Roboto', sans-serif;
  }
</style>

<script>
  $(document).ready(function () {
    // Add smooth scrolling to your page links
    $('a[href^="#"]').on('click', function (event) {
      var target = $($(this).attr('href'));

      if (target.length) {
        event.preventDefault();
        $('html, body').animate({
          scrollTop: target.offset().top
        }, 1000);
      }
    });
  });
</script>

<style>
@keyframes fadeIn {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}

.card {
  animation: fadeIn 0.5s;
}

  body {
    font-family: 'Source Sans Pro', sans-serif;
  }

  .breadcrumb {
    transition: background-color 0.3s ease-in-out;
  }

  .breadcrumb:hover {
    background-color: #f8f9fa;
  }

  .dropdown-menu {
    animation: fadeInDown 0.5s;
  }


.card {
  transition: transform 0.2s ease-in-out, opacity 0.2s ease-in-out;
  animation: fadeInDown 0.4s ease-in-out; 
  
}
.element-to-animate {
    will-change: transform, opacity;
}

.card:hover {
  transform: scale(1.01) translate(-1px); 
  opacity: 1;
}

  .image-icon {
    width: 50px; /* Adjust the size as needed */
    height: auto;
  }
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


<div class="container-fluid p-0 bg-white">
    <div class="container "> 
    	<div class="row">
        	<div class="col-md-6 d-flex align-items-center">
            	<ol class="breadcrumb bg-white pb-0">
                    <li class="breadcrumb-item" style="font-size:16px";><a href='<c:out value="${contextRoot}"/>/ws/nmc/dashboard.do'><Strong>मुख्यपृष्ठ</Strong></a></li>
                    <li class="breadcrumb-item active" style="font-size:16px";><Strong>कर व कर आकारणी विभाग</Strong></li>
                 
              </ol>
            </div>
            
                <div class="col-md-6 d-flex justify-content-end ">
            	<a class="nav-link dropdown-toggle d-flex align-items-center" id="navbarDropdownMenuLink-4" data-toggle="dropdown"
                  aria-haspopup="true" aria-expanded="false"  style="font-size:15px";>
                  <i class="fa fa-user-circle  bg-gery pr-3"  ></i><%= name %></a>
            	
                
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
    
</div>
	


<div class="container-fluid my-3">
	<div class="container">
    	<div class="row mb-4">
            <div class="col-md-3 mb-4">
                <a class="card" style="width: 272px;height:108px" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIPropertyTaxUtara.do'>
                    <div class="card-body d-flex align-items-top justify-content-between">                    			 
                                  <span class="title-width platform-title"><p class="h5 m-0"><b>मालमत्ता कर उतारा <br>देणे (DCB)</b></p></span>
                                    <p class="image-icon d-inline-block m-0 mr-0 float-right"><img src="<%=url%>img/propertyUtara.png"></p>                               
                                  
                                  
                                                                 
                              </div>
                </a>
            </div>
            
            
            <div class="col-md-3 mb-4">
                <a class="card" style="width: 272px;height:108px" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIPropertyTaxNoDues.do'>
                    <div class="card-body d-flex align-items-top justify-content-between">
                                  <span class="title-width platform-title"><p class="h5 m-0"><strong>थकबाकी नसल्याचा<br> दाखला देणे</strong></p></span>
                                   <p class="image-icon d-inline-block m-0 mr-0 float-right"><i class="fas fa-rupee-sign"></i></p>                               
                              </div>
                </a>
            </div>
            
            
            <div class="col-md-3 mb-4">
                <a class="card" style="width: 272px;height:108px" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIPropertyTransferRegistration.do'>
                    <div class="card-body d-flex align-items-top justify-content-between">
                                  <span class="title-width platform-title"><p class="h5 m-0"><strong> मालमत्ता हस्तांतरण नोंद प्रमाणपत्र दाखला देणे <br>अ)दस्तऐवजाच्या आधारे<br>ब)वारसाहक्काने </strong></p></span>
                                    <p class="image-icon d-inline-block m-0 mr-0 float-right"><img src="<%=url%>img/propertyTransferRegistration.png"></p>                               
                              </div>
                </a>
            </div>
             <div class="col-md-3 mb-4">
                 <a class="card" style="width: 272px;height:108px" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIPropertyTaxRecovery.do'>
                    <div class="card-body d-flex align-items-top justify-content-between">
                                  <span class="title-width platform-title"><p class="h5 m-0"><strong> नव्याने कर आकारणी <br>अ)नामांतरणाशिवाय
                                  </strong></p></span>
                                    <p class="image-icon d-inline-block m-0 mr-0 float-right"><img src="<%=url%>img/propertyMutation.png"></p>                               
                              </div>
                </a>
            </div>
            
         
            
            <div class="col-md-3 mb-4">
                <a class="card" style="width: 272px;height:108px" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTInewRTIPropertyAssessment.do'>
                    <div class="card-body d-flex align-items-top justify-content-between">
                                  <span class="title-width platform-title"><p class="h5 m-0"><strong>पुनः कर आकारणी/मालमत्ता <br>कर अद्यावत करणे</strong></p></span>
                                    <p class="image-icon d-inline-block m-0 mr-0 float-right"><img src="<%=url%>img/propertyTranscript.png"></p>                               
                              </div>
                </a>
            </div>
            
            <div class="col-md-3 mb-4">
                <a class="card" style="width: 272px;height:108px" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIPropertyTaxDemand.do'>
                    <div class="card-body d-flex align-items-top justify-content-between">
                                  <span class="title-width platform-title"><p class="h5 m-0"><strong>कराची मागणी पत्र <br>तयार करणे</strong></p></span>
                                    <p class="image-icon d-inline-block m-0 mr-0 float-right"><img src="<%=url%>img/propertyTaxDemand.png"></p>                               
                              </div>
                </a>
            </div>
            
            <div class="col-md-3 mb-4">
                <a class="card" style="width: 272px;height:108px" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIPropertyTaxExemption.do'>
                    <div class="card-body d-flex align-items-top justify-content-between">
                                  <span class="title-width platform-title"><p class="h5 m-0"><strong>कर माफी <br>मिळणे</strong></p></span>
                                   <p class="image-icon d-inline-block m-0 mr-0 float-right"><i class="fas fa-file-invoice"></i></p>                               
                              </div>
                </a>
            </div>
            
           <!--   <div class="col-md-3 mb-4">
               <a class="card" style="width: 272px;height:108px" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIPropertyTaxForNonResidential.do'>
                    <div class="card-body d-flex align-items-top justify-content-between">
                                  <span class="title-width platform-title"><p class="h5 m-0"><strong>रहिवासी नसलेल्या मालमत्ता <br>करात सूट  मिळणे </strong></p></span>
                                    <p class="image-icon d-inline-block m-0 mr-0 float-right"><img src="<%=url%>img/taxExemptionNonResidential.png"></p>                               
                              </div>
                </a>
            </div> -->
            
          <!-- <div class="col-md-3 mb-4">
                <a class="card" style="width: 272px;height:108px" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIPropertyTaxSelfAssessment.do'>
                    <div class="card-body d-flex align-items-top justify-content-between">
                                  <span class="title-width platform-title"><p class="h5 m-0"> <strong>स्वयंमुल्यांकन</strong></p></span>
                                   <p class="image-icon d-inline-block m-0 mr-0 float-right"><i class="fas fa-globe"></i></p>                               
                              </div>
                </a>
            </div> -->
            
           <!--  <div class="col-md-3 mb-4">
                <a class="card" style="width: 272px;height:108px" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIPropertyComplaintRegistration.do'>
                    <div class="card-body d-flex align-items-top justify-content-between">
                                  <span class="title-width platform-title"><p class="h5 m-0"><strong>आक्षेप नोंदविणे</strong></p></span>
                                   <p class="image-icon d-inline-block m-0 mr-0 float-right"><i class="fas fa-file-invoice"></i></p>                               
                              </div>
                </a>
            </div> -->
            
        <!--    <div class="col-md-3 mb-4">
                <a class="card" href="/TAX_DEPT/ApplicationFormforPropertyTaxNoDuesCertificate.html">
                    <div class="card-body d-flex align-items-top justify-content-between">
                                  <span class="title-width platform-title"><p class="h5 m-0">Objection<br>Registration</p></span>
                                   <p class="image-icon d-inline-block m-0 mr-0 float-right"><img src="img/advertisement.png"></p>                               
                              </div>
                </a>
            </div> -->
            
           <!--  <div class="col-md-3 mb-4">
                            <a class="card border" style="width: 272px;height:108px" href='<c:out value="${contextRoot}"/>/ws/rtsapplication/newRTSPartitionOfPropertyApplication.do'>
                    <div class="card-body d-flex align-items-top justify-content-between">
                                  <span class="title-width platform-title"><p class="h5 m-0"><strong>उपविभागामध्ये मालमत्ता <br>विभाजन
                                  </strong></p></span>
                                   <p class="image-icon d-inline-block m-0 mr-0 float-right"><i class="fas fa-building"></i></p>                               
                              </div>
                </a>
            </div>
            
            <div class="col-md-3 mb-4">
                            <a class="card border" style="width: 272px;height:108px" href='<c:out value="${contextRoot}"/>/ws/rtsapplication/newRTSNewlyConstructedPropertyApplication.do'>
                    <div class="card-body d-flex align-items-top justify-content-between">
                                  <span class="title-width platform-title"><p class="h5 m-0"><strong>इमारत पाडण्यात आलेल्या मालमत्तेकरिता अद्यावत मालमत्ता कर आकारणी करणे</strong></p></span>
                                    <p class="image-icon d-inline-block m-0 mr-0 float-right"><img src="<%=url%>img/newProperty.png"></p>                               
                              </div>
                </a>
            </div>-->
            
      <!--      <div class="col-md-3 mb-4">
                <a class="card" href="/TAX_DEPT/ApplicationFormforPropertyTaxNoDuesCertificate.html">
                    <div class="card-body d-flex align-items-top justify-content-between">
                                  <span class="title-width platform-title"><p class="h5 m-0">Severage<br>connection</p></span>
                                   <p class="image-icon d-inline-block m-0 mr-0 float-right"><i class="fas fa-certificate"></i></p>                               
                              </div>
                </a>
            </div>
            
        </div>
        -->
        
        
        
        
        
        
        
        
    
    </div>
</div>

















<script type="text/javascript" src="<%=url%>js/jquery.min.js"></script>
<script>
function find() {
	
	onPageSubmit('<c:out value="${contextRoot}"/>/ws/dashboard/myapplication.do');
	
}
</script>
<script type="text/javascript" src="<%=url%>js/popper.min.js"></script>
<script type="text/javascript" src="<%=url%>js/bootstrap.js"></script>
<script type="text/javascript" src="<%=url%>js/mdb.min.js"></script>
</body>
</html>

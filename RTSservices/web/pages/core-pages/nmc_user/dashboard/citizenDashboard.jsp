<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants" />
<jsp:directive.page import="com.mars.common.utils.CommonUtils" />
<tiles:importAttribute scope="request" name="breadcrumbsList"
	ignore="true" />
<tiles:importAttribute scope="request" name="parentMenu" ignore="true" />
<tiles:importAttribute scope="request" name="selectedMenu" ignore="true" />

<%
pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);

String contextPath = request.getContextPath();
String url = contextPath + "/pages/core-pages/nmc_user/";
String name=(String)session.getAttribute("name"); 

%>
<head>

<meta charset="UTF-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Nagpur Municipal Corporation</title>

<link rel="icon" href="img/favicon.ico" type="image/x-icon">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@200;400&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="<%=url%>css/bootstrap.min.css">

<link rel="stylesheet" type="text/css"
	href="<c:out value='${contextRoot}'/>/pages/core-pages/nmc_user/css/style2.css" />
<x-masterlayoutlinks pagename="Dashboard">

<style>
/* Reset existing problematic styles */
* {
	box-sizing: border-box;
}

/* Main container improvements */
.container-fluid {
	padding: 0 !important;
}

/* Cards container */
.cards-container {
	display: grid;
	grid-template-columns: repeat(auto-fit, minmax(350px, 1fr));
	gap: 24px;
	padding: 28px 16px;
	background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
	min-height: calc(100vh - 200px);
}

/* Individual service cards */
.service-card {
	background: #ffffff;
	border: none;
	border-radius: 16px;
	box-shadow: 0 8px 32px rgba(31, 38, 135, 0.15);
	backdrop-filter: blur(4px);
	transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);
	overflow: hidden;
	position: relative;
	margin-bottom: 0;
}

.service-card:hover {
	transform: translateY(-8px) scale(1.02);
	box-shadow: 0 12px 40px rgba(31, 38, 135, 0.25);
}

/* Card header styling */
.card-header {
	background: linear-gradient(135deg, #667eea 0%, #764ba2 100%) !important;
	border: none !important;
	border-radius: 0 !important;
	padding: 18px 20px !important;
	min-height: 10px !important;
	display: flex !important;
	align-items: center !important;
	justify-content: space-between !important;
	position: relative;
}

.card-header .mm_col {
	width: 100%;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.card-header .lbleng, .card-header .lblmrt {
	color: #ffffff !important;
	font-weight: 600 !important;
	font-size: 0.95rem !important;
	text-transform: uppercase !important;
	letter-spacing: 0.5px !important;
	text-decoration: none !important;
	line-height: 1.0 !important;
}

.card-header .wtt_ {
	margin-left: 12px;
	opacity: 0.9;
}

.card-header .wtt_ img {
	width: 32px !important;
	height: 32px !important;
	filter: brightness(0) invert(1);
	opacity: 0.85;
}

/* Card body improvements */
.card-body {
	padding: 24px !important;
	background: #ffffff;
	border-radius: 0 !important;
	max-height: 280px !important;
	overflow-y: auto !important;
}

/* List styling */
.watermark-text1 {
	margin: 0 !important;
	padding: 0 !important;
	counter-reset: item;
}

.watermark-text1 li {
	display: flex !important;
	align-items: center;
	margin-bottom: 8px !important;
	padding: 5px 0 !important;
	border-bottom: 1px solid #f1f3f4 !important;
	font-size: 17px !important; /* Increased font size */
	line-height: 1.4 !important;
	gap: 0px;
	counter-increment: item;
	position: relative;
}

.watermark-text1 li:last-child {
	border-bottom: none !important;
}

.watermark-text1 li:before {
	content: counter(item) ". ";
	font-weight: 600;
	color: #667eea;
	margin-right: 8px;
}

/* Link improvements */
.watermark-text1 li a {
	color: black !important;
	text-decoration: none !important;
	font-weight: 500 !important;
	font-size: 16px !important;
	transition: all 0.2s ease !important;
	display: inline-block;
	margin-right: 0px;
}

.watermark-text1 li a:hover {
	color: #dc2626 !important;
	transform: translateX(4px);
}

.watermark-text1 li .lbleng {
	margin-bottom: 0px;
}

.watermark-text1 li .lblmrt {
	color: #6b7280 !important;
	font-size: 14px !important;
	font-style: italic;
}

/* Zoom text effect */
.zoom-text {
	transition: all 0.2s ease-in-out !important;
	display: inline-block;
}

.zoom-text:hover {
	transform: scale(1.05) !important;
}

/* Custom scrollbar */
.card-body::-webkit-scrollbar {
	width: 6px;
}

.card-body::-webkit-scrollbar-track {
	background: #f1f3f4;
	border-radius: 8px;
}

.card-body::-webkit-scrollbar-thumb {
	background: #d1d5db;
	border-radius: 8px;
}

.card-body::-webkit-scrollbar-thumb:hover {
	background: #9ca3af;
}

/* Different color schemes for different departments */
.bbxx1 .card-header {
	background: linear-gradient(135deg, #667eea 0%, #764ba2 100%) !important;
}

.bbxx2 .card-header {
	background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%) !important;
}

.bbxx3 .card-header {
	background: linear-gradient(135deg, #4facfe 0%, #00f2fe 100%) !important;
}

/* Responsive design */
@media ( max-width : 1200px) {
	.cards-container {
		grid-template-columns: repeat(auto-fit, minmax(320px, 1fr));
		gap: 20px;
		padding: 20px 12px;
	}
}

@media ( max-width : 768px) {
	.cards-container {
		grid-template-columns: 1fr;
		gap: 16px;
		padding: 16px 8px;
	}
	.service-card {
		margin: 0 4px;
	}
	.card-header {
		padding: 16px 20px !important;
		min-height: 70px !important;
	}
	.card-body {
		padding: 20px !important;
		max-height: 240px !important;
	}
}

/* Additional utility classes */
.pointer {
	cursor: pointer !important;
}

/* Remove any conflicting Bootstrap margins */
.mb-3 {
	margin-bottom: 0 !important;
}

.shadow {
	box-shadow: none !important;
}

.service-number {
	color: #667eea;
	font-weight: 700;
	font-size: 19px;
	flex-shrink: 0;
	margin-right: 8px;
}

.service-link {
	color: #2563eb !important;
	font-weight: 500 !important;
	text-decoration: none !important;
	font-size: 18px !important;
	transition: all 0.2s ease !important;
	display: inline-flex;
	align-items: center;
	gap: 8px;
}

.service-link:hover {
	color: #dc2626 !important;
	text-decoration: underline !important;
}

.service-name-mr {
	color: #505050 !important;
	font-size: 17px !important;
	font-weight: 400;
	font-style: italic;
	margin-left: 4px;
}
.cards-outer-wrapper {
  display: flex;
  justify-content: center;
  width: 100%;
    margin-bottom: 0px !important;
  
}

.cards-container {
  max-width: 1360px;
  margin: 0 auto;
  width: 100%;
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(350px, 1fr));
  gap: 18px;
  row-gap: 26px; /* Extra vertical row spacing */
  min-height: calc(100vh - 200px);
}

.row {
  margin-bottom: 10px !important;
}
.page-heading-wrapper {
  width: 100%;
  display: flex;
  justify-content: center;
  margin: 10px 0 8px 0;
      margin-bottom: 0px !important;
  
}
.page-heading {
  font-size: 1.6rem;
  font-weight: 600;
  color: #212121;
  letter-spacing: 0px;
  text-align: center;
  margin: 0;
}
/* Make all cards the same height and structure properly */
.service-card, .card {
  height: 280px;      /* Set your preferred fixed card height */
  min-height: 280px;  /* You can use min-height instead of height for responsive flexibility */
  display: flex;
  flex-direction: column;
}

.card-header {
  flex-shrink: 0;
}

.card-body {
  flex: 1 1 auto;
  overflow-y: auto;
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
                    <li class="breadcrumb-item" style="font-size:16px;"><a href='<c:out value="${contextRoot}"/>/ws/nmc/dashboard.do'><strong>मुख्यपृष्ठ</strong></a></li>
<li class="breadcrumb-item active" style="font-size:16px;"><strong>डॅशबोर्ड</strong> </li>                 
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
                
        
            </div>
        </div>
       </div> 
    </div>  
    
</div>

<div class="page-heading-wrapper">
  <h2 class="page-heading">ONLINE CITIZEN SERVICES (64)</h2>
</div>

<div class="cards-outer-wrapper">
  <div class="cards-container">


	<div
		class="row mt-3 mt-sm-0 mb-5 d-flex align-items-center justify-content-start1">
		<div class="row ">

			<div class="col-md-4">
				<div class="card shadow text-bg-secondary1 mb-3  bbxx1">
					<div class="card-header pointer">
						<div class="d-flex justify-content-between mm_col">
							<a class="lbleng zoom-text" href="#"> Public Health (आरोग्य
								विभाग)<span class="service-count">(9)</span>
							</a>
							<div class="wtt_">
								<img src="<%=url%>img/health_dept.png" alt="health dept">
							</div>
						</div>
					</div>
					<div class="card-body">
						<ol class="watermark-text1" type="1">
							<li><a class="lbleng zoom-text"
								href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIBirthApplication.do'>Issuance
									of Birth Certificate (जन्म प्रमाणपत्र देणे)</a></li>
							<li><a class="lbleng zoom-text"
								href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIDeathApplication.do'>Issuance
									of Death Certificate (मृत्यू प्रमाणपत्र देणे)</a></li>
							<li><a class="lbleng zoom-text"
								href='<c:out value="${contextRoot}"/>/ws/rtsapplication/newRTIMarriageApplication.do'>Marriage
									Registration Certificate (विवाह नोंदणी प्रमाणपत्र देणे)</a></li>
							<li><a class="lbleng zoom-text"
								href='<c:out value="${contextRoot}"/>/ws/rtsapplication/newRTSBioMedicalWaste.do'>Biomedical
									Waste Management (जैव वैद्यकीय कचरा)</a></li>
							<li><a class="lbleng zoom-text"
								href='<c:out value="${contextRoot}"/>/ws/rtsapplication/newRTSMTPRegistrationCertificate.do'>MTP
									Registration Certificate (MTP नोंदणी प्रमाणपत्र)</a></li>
							<li><a class="lbleng zoom-text"
								href='https://maha-mnhregistration.co.in/' target="_blank">Nursing
									Home Registration Certificate Renewal (नर्सिंग होम नोंदणी
									प्रमाणपत्राचे नूतनीकरण)</a></li>
							<li><a class="lbleng zoom-text"
								href='https://maha-mnhregistration.co.in/' target="_blank">Change
									in Number of Beds/Usage (बेड/वापराच्या संख्येत बदल)</a></li>
							<li><a class="lbleng zoom-text"
								href='https://maha-mnhregistration.co.in/' target="_blank">Change
									of Partner Name in Nursing Home Registration Certificate
									(नर्सिंग होम नोंदणी प्रमाणपत्र भागीदाराचे नाव बदलणे) </a></li>
							<li><a class="lbleng zoom-text"
								href='https://maha-mnhregistration.co.in/' target="_blank">Nursing
									Home Registration Certificate (नर्सिंग होम नोंदणी प्रमाणपत्र)</a></li>

						</ol>
					</div>
				</div>
			</div>
			<!-- Veterinary Department -->
			<div class="col-md-4">
				<div class="card shadow text-bg-secondary1 mb-3  bbxx1">
					<div
						class="card-header pointer d-flex justify-content-between align-items-center">
						<a class="lbleng zoom-text" href="#"> Veterinary (पशुवैद्यकीय
							विभाग)<span class="service-count">(2)</span> </a>
						<div class="wtt_">
							<img src="<%=url%>img/solidWasteDept1.png" alt="Veterinary">
						</div>
					</div>
					<div class="card-body">
						<ol class="watermark-text1" type="1">
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIDogLicence.do'>Dog License
									Registration (श्वान परवाना नोंदणी प्रमाणपत्र)</a></li>
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIDogRenewalLicence.do'>Dog License
									Renewal (श्वान परवाना नोंदणी प्रमाणपत्र नूतनीकरण)</a></li>
						</ol>
					</div>
				</div>
			</div>

			<!-- Tax & Assessment Department -->
			<div class="col-md-4">
				<div class="card shadow text-bg-secondary1 mb-3  bbxx1">
					<div
						class="card-header pointer d-flex justify-content-between align-items-center">
						<a class="lbleng zoom-text" href="#"> Tax & Assessment (कर व
							कर आकारणी विभाग)<span class="service-count">(12)</span> </a>
						<div class="wtt_">
							<img src="<%=url%>img/property_tax.png" alt="Tax & Assessment">
						</div>
					</div>
					<div class="card-body">
						<ol class="watermark-text1" type="1">
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIPropertyTaxUtara.do'>Property Tax
									Extract (DCB) (मालमत्ता कर उतारा देणे (DCB))</a></li>
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIPropertyTaxNoDues.do'>No Dues
									Certificate (थकबाकी नसल्याचा दाखला देणे)</a></li>
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIPropertyTransferRegistration.do'>Property
									Transfer Record Certificate (मालमत्ता हस्तांतरण नोंद
									प्रमाणपत्र)</a></li>
							<!-- <li><a class="lbleng zoom-text" href="#">Document-based
									(दस्तऐवजाच्या आधारे)</a></li>
							<li><a class="lbleng zoom-text" href="#">Inheritance-based
									(वारसाहक्काने)</a></li>-->
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIPropertyTaxRecovery.do'>New Tax
									Assessment (Without Name Transfer) (नव्याने कर आकारणी
									(नामांतरणाशिवाय))</a></li>
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTInewRTIPropertyAssessment.do'>Re-assessment/Property
									Tax Update (पुनः कर आकारणी/मालमत्ता कर अद्यावत करणे)</a></li>
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIPropertyTaxDemand.do'>Tax Demand
									Letter Generation (कराची मागणी पत्र तयार करणे)</a></li>
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIPropertyTaxExemption.do'>Tax Waiver (कर
									माफी मिळणे)</a></li>
					
							<li><a class="lbleng zoom-text" href="https://geocivicnmcapp.nmcptax.com/CitizenServices/CitizenTax/index.html"  target='_blank'>Filing a
									Self-Assessment Objection (स्वयम मूल्यांकन आक्षेप नोंदविणे)</a></li>
							<li><a class="lbleng zoom-text" href="https://nmcnagpur.gov.in/pay-your-dues" target='_blank'>Property
									Division in Subdivision (उपविभाग मध्ये मालमत्ता विभाजन)</a></li>
						<li><a class="lbleng zoom-text" href="#" target='_blank'>
									Property demolition and reconstruction tax levy (मालमत्ता पाडणे व पुनःबांधणी कर आकारणी)</a></li>
						
						<li><a class="lbleng zoom-text" href="#" target='_blank'>
									self assessment (स्वयम मूल्यांकन)</a></li>
						<li><a class="lbleng zoom-text" href="#" target='_blank'>
									Non-resident property exemption (रहिवासी नसलेल्या मालमत्ता ना सूट मिळणे)</a></li>
						
						</ol>
					</div>
				</div>
			</div>
			</div>
					<div class="row ">
			

			<!-- Town Planning Department -->
			<div class="col-md-4">
				<div class="card shadow text-bg-secondary1 mb-3  bbxx1">
					<div
						class="card-header pointer d-flex justify-content-between align-items-center">
						<a class="lbleng zoom-text" href="#"> Town Planning (नगर रचना
							विभाग)<span class="service-count">(6)</span> </a>
						<div class="wtt_">
							<img src="<%=url%>img/townplanning.png" alt="Town Planning">
						</div>
					</div>
					<div class="card-body">
						<ol class="watermark-text1" type="1">
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIZoneApplication.do'>Zone
									Certificate (झोन दाखला देणे)</a></li>
							<li><a class="lbleng zoom-text" href="https://mahavastu.maharashtra.gov.in/">Building Permit
									(बांधकाम परवाना देणे)</a></li>
							<li><a class="lbleng zoom-text" href="https://mahavastu.maharashtra.gov.in/">Jote
									Certificate (झोते प्रमाणपात्र देणे)</a></li>
							<li><a class="lbleng zoom-text" href="https://mahavastu.maharashtra.gov.in/">Bhogavata
									Certificate (भोगावटा प्रमाणपत्र)</a></li>
							<li><a class="lbleng zoom-text" href="https://mahavastu.maharashtra.gov.in/">Mobile Tower
									Permit (मोबाईल टॉवर परवाना)</a></li>
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIPartMapApplication.do'>Plot Map (भाग
									नकाशा देणे)</a></li>
						</ol>
					</div>
				</div>
			</div>

			<!-- Water Supply Department -->
			<div class="col-md-4">
				<div class="card shadow text-bg-secondary1 mb-3  bbxx1">
					<div
						class="card-header pointer d-flex justify-content-between align-items-center">
						<a class="lbleng zoom-text" href="#"> Water Supply (पाणी
							पुरवठा विभाग) <span class="service-count">(12)</span></a>
						<div class="wtt_">
							<img src="<%=url%>img/waterdept.png" alt="Water Supply">
						</div>
					</div>
					<div class="card-body">
						<ol class="watermark-text1" type="1">
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtsapplication/newRTINewWaterConnectionApplication.do'>New Water
									Connection (नवीन नळ जोडणी देणे)</a></li>
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIChangeInOwnershipType.do'>Ownership
									Change (मालकी हक्कात बदल करणे)</a></li>
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIWaterConnectionTypeChange.do'>Water
									Connection Size Change (नळ जोडणी आकारामध्ये बदल करणे)</a></li>
							<li><a class="lbleng zoom-text"  href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIWaterDisconnection.do'>Temporary/Permanent
									Disconnection (तात्पुरते/कायमस्वरूपी नळ जोडणी खंडित करणे)</a></li>
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIWaterReconnection.do'>Reconnection
									(पुनः जोडणी करणे)</a></li>
							<li><a class="lbleng zoom-text"  href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIWaterConnectionUsage.do'>Consumer Type
									Change (ग्राहक प्रकारामध्ये बदल करणे)</a></li>
							<li><a class="lbleng zoom-text" href='https://ocwindia.com/consumer_corner' target='_blank'>Water Bill
									Payment (पाणी देयक भरणे)</a></li>
							<li><a class="lbleng zoom-text" href="https://www.nmcnagpur.gov.in/grievance/complaint_form.php" target='_blank'>Complaint for
									Faulty Meter (नादुरुस्त मिटर तक्रार करणे)</a></li>
							<li><a class="lbleng zoom-text" href="https://www.nmcnagpur.gov.in/grievance/complaint_form.php" target='_blank'>Complaint for
									Unauthorized Water Connection (अनधिकृत नळ जोडणी तक्रार करणे)</a></li>
							<li><a class="lbleng zoom-text" href="https://www.nmcnagpur.gov.in/grievance/complaint_form.php" target='_blank'>Complaint for
									Low Water Pressure (पाण्याची दाबाब क्षमता तक्रार)</a></li>
							<li><a class="lbleng zoom-text" href="https://www.nmcnagpur.gov.in/grievance/complaint_form.php" target='_blank'>Complaint for
									Water Quality (पाण्याची गुणवत्ता तक्रार)</a></li>
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIWaterNoDueApplication.do'>No Dues
									Certificate (थकबाकी नसल्याचा दाखला)</a></li>
						</ol>
					</div>
				</div>
			</div>

			<!-- Fire Brigade Department -->
			<div class="col-md-4">
				<div class="card shadow text-bg-secondary1 mb-3  bbxx1">
					<div
						class="card-header pointer d-flex justify-content-between align-items-center">
						<a class="lbleng zoom-text" href="#"> Fire Brigade (अग्निशमन
							विभाग)<span class="service-count">(3)</span> </a>
						<div class="wtt_">
							<img src="<%=url%>img/firedepartment1.png" alt="Fire Brigade">
						</div>
					</div>
					<div class="card-body">
						<ol class="watermark-text1" type="1">
							<li><a class="lbleng zoom-text"  href='<c:out value="${contextRoot}"/>/ws/rtsapplication/newRTSFireCrackerShopLicense.do'>Firecracker
									Shop License (फटाके दुकानाचा परवाना)</a></li>
							<li><a class="lbleng zoom-text"  href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTSFireRecommendationLetter.do'>Temporary Fire
									NOC (तात्पुरती ना-हरकत दाखला देणे)</a></li>
							<li><a class="lbleng zoom-text"  href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIFireComplianceCertificateApplication.do'>Final Fire NOC
									(अंतिम ना-हरकत दाखला देणे)</a></li>
						</ol>
					</div>
				</div>
			</div>
</div>
		<div class="row ">

			<!-- Estate Department -->
			<div class="col-md-4">
				<div class="card shadow text-bg-secondary1 mb-3  bbxx1">
					<div
						class="card-header pointer d-flex justify-content-between align-items-center">
						<a class="lbleng zoom-text" href="#"> Estate (स्थावर विभाग)<span class="service-count">(1)</span> </a>
						<div class="wtt_">
							<img src="<%=url%>img/estate.png" alt="Estate">
						</div>
					</div>
					<div class="card-body">
						<ol class="watermark-text1" type="1">
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTIMandapApplication.do'>No Objection
									Certificate for Pandal (मंडपासाठी ना हरकत प्रमाणपत्र)</a></li>
						</ol>
					</div>
				</div>
			</div>

			<!-- Garden Department -->
			<div class="col-md-4">
				<div class="card shadow text-bg-secondary1 mb-3  bbxx1">
					<div
						class="card-header pointer d-flex justify-content-between align-items-center">
						<a class="lbleng zoom-text" href="#"> Garden (उद्यान विभाग)<span class="service-count">(2)</span> </a>
						<div class="wtt_">
							<img src="<%=url%>/img/garden_dept.png" alt="Garden">
						</div>
					</div>
					<div class="card-body">
						<ol class="watermark-text1" type="1">
							<li><a class="lbleng zoom-text"  href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTSApplicationFromTreeCuting.do'>Tree Cutting
									Permission (वृक्ष तोड परवानगी देणे)</a></li>
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTSTreeTrimmingApplication.do'>Branch Pruning
									Permission (वृक्षांच्या फांद्या कापण्यासाठी परवानगी)</a></li>
						
						</ol>
					</div>
				</div>
			</div>
			
			<div class="col-md-4">
				<div class="card shadow text-bg-secondary1 mb-3  bbxx1">
					<div
						class="card-header pointer d-flex justify-content-between align-items-center">
						<a class="lbleng zoom-text" href="#"> Festival
									Permissions<span class="service-count">(2)</span>  </a>
						<div class="wtt_">
							<img src="<%=url%>/img/ganesh.png" alt="Garden">
						</div>
					</div>
					<div class="card-body">
						<ol class="watermark-text1" type="1">
							
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtsapplication/newRTSGaneshApplication.do'>Ganesh Mandap
									Permission (गणेश मंडप परवानी)</a></li>
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtsapplication/newRTSDurgaUtsavApplication.do'>Durga
									Utsav/Garba Mandap Permission (दुर्गा उत्सव/गरबा मंडप परवानी)</a></li>
						</ol>
					</div>
				</div>
			</div>
</div>
		<div class="row ">

			<!-- Market License Department -->
			<div class="col-md-4">
				<div class="card shadow text-bg-secondary1 mb-3  bbxx1">
					<div
						class="card-header pointer d-flex justify-content-between align-items-center">
						<a class="lbleng zoom-text" href="#"> Market License (बाजार
							परवाना विभाग)<span class="service-count">(11)</span>
						</a>
						<div class="wtt_">
							<img src="<%=url%>img/market.png" alt="Market License">
						</div>
					</div>
					<div class="card-body">
						<ol class="watermark-text1" type="1">
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTINOCOfTradeApplication.do'>NOC for
									Trade/Business/Storage (व्यापार/व्यवसाय/साठा करणेसाठी नाहरकत
									प्रमाणपत्र)</a></li>
							<li><a class="lbleng zoom-text"  href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTITradeLicenceNew.do'>New License
									Issuance (नवीन परवाना मिळणे)</a></li>
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTITradeLicenceRenewal.do'>License Renewal
									(परवान्याचे नुतनीकरण)</a></li>
							<li><a class="lbleng zoom-text"  href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTITradeLicenseTransfer.do'>License
									Transfer (परवाना हस्तांतरण)</a></li>
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTITradeLicenseDuplicateCopyApplication.do'>License
									Duplicate Copy (परवाना दुय्यम प्रत)</a></li>
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTITradeLicenseNameChangeApplication.do'>Business Name
									Change (व्यवसायाचे नाव बदलणे)</a></li>
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTITradeLicenseTypeChangeApplication.do'>Business Type
									Change (व्यवसाय बदलणे)</a></li>
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTITradeLicencePartnerChange.do'>Partner Name
									Change (भागीदाराचे नाव बदलणे)</a></li>
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTITradePartnerCountUpdate.do'>Change in
									Number of Partners (भागीदाराच्या संख्येत बदल (वाढ/कमी))</a></li>
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTITradeLicenseCancellationApplication.do'>License
									Cancellation (परवाना रद्द करणे)</a></li>
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/rtiapplication/newRTITradeLicenseOutdatedRenewalApplication.do'>Renewal Notice
									for Expired License (कालबाह्य परवान्यासाठी नुतनीकरण सुचना)</a></li>
						</ol>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card shadow text-bg-secondary1 mb-3  bbxx1">
					<div
						class="card-header pointer d-flex justify-content-between align-items-center">
						<a class="lbleng zoom-text" href="#"> sky sign department(आकाश चिन्ह विभाग)
<span class="service-count">(1)</span></a>
						<div class="wtt_">
							<img src="<%=url%>img/estate.png" alt="Estate">
						</div>
					</div>
					<div class="card-body">
						<ol class="watermark-text1" type="1">
								<li><a class="lbleng zoom-text" href="https://geocivicnmcapp.nmcptax.com/CitizenServices/CitizenTax/index.html" target='_blank'>Sky Sign -
									New/Renewal License (आकाश चिन्ह नवीन जाहिरात आकाश चिन्ह पारवाना
									/ व परवाना नूतनीकरण)</a></li>
						</ol>
					</div>
				</div>
			</div>
			<!-- Estate Department -->
			<div class="col-md-4">
				<div class="card shadow text-bg-secondary1 mb-3  bbxx1">
					<div
						class="card-header pointer d-flex justify-content-between align-items-center">
						<a class="lbleng zoom-text" href="#"> Hot mixed planned & other Department<span class="service-count">(3)</span></a>
						<div class="wtt_">
							<img src="<%=url%>img/estate.png" alt="Estate">
						</div>
					</div>
					<div class="card-body">
						<ol class="watermark-text1" type="1">
							<li><a class="lbleng zoom-text" href="https://www.nmcnagpur.gov.in/grievance/complaint_form.php"  target='_blank'>filling potholes on the road (रस्त्यावरील खड्डे बुजवणे)(HMP)</a></li>
							<li><a class="lbleng zoom-text" href="https://www.nmcnagpur.gov.in/grievance/complaint_form.php"  target='_blank'>Keeping the manhole cover open(गटारावरील झाकण सुस्थितीत ठेवणे)(PHE)</a></li>
							<li><a class="lbleng zoom-text" href="https://www.nmcnagpur.gov.in/grievance/complaint_form.php"  target='_blank'>Maintaining cleanliness in the city (शहरात स्वच्छता ठेवणे)(SWM)</a></li>
						</ol>
					</div>
				</div>
			</div>
			
			</div>
		<div class="row ">
	
			<div class="col-md-4">
				<div class="card shadow text-bg-secondary1 mb-3  bbxx1">
					<div
						class="card-header pointer d-flex justify-content-between align-items-center">
						<a class="lbleng zoom-text" href="#"> Check your application status (अर्जाची स्थिती तपासा) </a>
						<div class="wtt_">
							<img src="<%=url%>img/appcheck.png" alt="Application Status">
						</div>
					</div>
					<div class="card-body">
						<ol class="watermark-text1" type="1">
							<li><a class="lbleng zoom-text" href='<c:out value="${contextRoot}"/>/ws/nmc/dashboard/newApplicationDetails.do'>
				Check your application status (अर्जाची स्थिती तपासा)</a></li>
						</ol>
					</div>
				</div>
			</div>

</div>
		</div>
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

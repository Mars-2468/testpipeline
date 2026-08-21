<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.include
	file="/pages/core-pages/nmc_user/dashboard/header.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants" />
<jsp:directive.page import="com.mars.common.utils.CommonUtils" />
		<jsp:directive.page import="com.mars.rti.utils.CoreConstants" />



<head>
<title>Nagpur Municipal Corporation</title>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="csrf-token"
	content="L1tBXJBCG7Qg3zc8hd8zkv3US8Yq8R7ihDGuzHIc" />
<script src="https://code.jquery.com/jquery-3.6.3.min.js"
	integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="jquery-3.6.1.min.js"></script>
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript"
	src="<c:out value=" ${contextRoot}" />/scripts/jquery/jquery.ajaxfileupload.js">
        </script>
<link rel="stylesheet"
	href="<c:out value='${contextRoot}'/>/pages/core-pages/nmc_user/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<c:out value='${contextRoot}'/>/pages/core-pages/nmc_user/css/style2.css" />
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>
	
    <link rel="stylesheet" type="text/css"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">




<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


<script src="${pageContext.request.contextPath}/scripts/jquery-3.6.1.min.js"></script>

<script src="${pageContext.request.contextPath}/scripts/PagePref.js"></script>

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/styles/jquery/jquery-ui.css"/>

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/styles/jquery/jquery-ui.theme.css"/>


<%
pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES); ///pageContext.setAttribute("statusList", CommonUtils.getStatus());
pageContext.setAttribute("UPLOAD_PATH", CoreConstants.UPLOAD_PATH);

%>
<style>
    .table-hover thead tr.tr-header th {
background-color: #e5effa;
}

.table-hover tbody tr:nth-child(odd) {
background-color: #fadbf1;
}

.table-hover tbody tr:nth-child(even) {
background-color: #f4d2e7;
}

a {
  display: inline-block;
  padding: 1px 5px;
  background-color: rgb(181, 249, 233); /* Button color */
  color: #fff; /* Text color */
  text-decoration: none;
  border-radius: 5px;
  cursor: pointer;
  background-color: #afe6fa;
}

/* Hover effect */
a:hover {
  background-color: #afe6fa; /* Button color on hover */
}

/* Active effect */
a:active {
  background-color: rgb(248, 127, 234), 0, 113); 
}
label {
	font-weight: 600;
}

h3 {
	font-weight: 500;
}

#tb22
{
	display : none;
}

.card {
      background-color: rgb(247, 251, 251); 
      border-color: #f3fbfc; 
	  border-radius: 5%;
    }

    .card-body {
      color: #495057; 
    }

    .form-control {
      border-color: #ced4da; 
    }

    .form-control:focus {
      border-color: #175ba3; 
      box-shadow: 0 0 0 0.2rem rgba(103, 138, 175, 0.25); 
    }

   
</style>
<style>
.table-hover thead tr.tr-header th { background-color: #e5effa; }
.table-hover tbody tr:nth-child(odd) { background-color: #fadbf1; }
.table-hover tbody tr:nth-child(even) { background-color: #f4d2e7; }

a {
  display: inline-block;
  padding: 1px 5px;
  color: #fff;
  text-decoration: none;
  border-radius: 5px;
  cursor: pointer;
  background-color: #afe6fa;
}
a:hover { background-color: #afe6fa; }
a:active { background-color: rgb(248, 127, 234); }

label { font-weight: 600; }
h3 { font-weight: 500; }
#tb22 { display: none; }

.card { background-color: rgb(247, 251, 251); border-color: #f3fbfc; border-radius: 5%; }
.card-body { color: #495057; }
.form-control { border-color: #ced4da; }
.form-control:focus {
  border-color: #175ba3;
  box-shadow: 0 0 0 0.2rem rgba(103, 138, 175, 0.25);
}

/* ---- PRINT FIXES ---- */

</style>
<!-- -PRINT STYLES-->
<style>
/* =========================================================
   PRINT CSS - FIRE NOC FORM
   A4 LANDSCAPE
   ========================================================= */

@page {
    size: A4 landscape;
    margin: 8mm;
}

@media print {

    /* -----------------------------------------------------
       BASIC PAGE RESET
       ----------------------------------------------------- */

    html,
    body {
        width: 100% !important;
        min-width: 0 !important;
        max-width: none !important;
        margin: 0 !important;
        padding: 0 !important;
        background: #ffffff !important;
        overflow: visible !important;
    }

    body {
        font-family: Arial, "Noto Sans Devanagari", sans-serif !important;
        font-size: 10px !important;
        line-height: 1.25 !important;

        /* DO NOT use transform or zoom on body */
        transform: none !important;
        zoom: 1 !important;

        color: #000000 !important;
    }


    /* -----------------------------------------------------
       HIDE NON-PRINT ELEMENTS
       ----------------------------------------------------- */

    .printMe,
    #submit,
    button,
    input[type="submit"],
    input[type="button"],
    .btn,
    .navbar,
    .nav,
    .sidebar,
    .menu,
    .footer,
    .header-menu,
    .dashboard-header,
    .breadcrumb,
    .modal,
    .alert-dismissible,
    .print-hide,
    .print-hide-temp {
        display: none !important;
    }


    /* -----------------------------------------------------
       MAIN FORM
       ----------------------------------------------------- */

    form#\Fire\ Recommendation\ Letter,
    form[name="Fire Recommendation Letter"],
    #Fire\ Recommendation\ Letter {
        width: 100% !important;
        max-width: 100% !important;
        min-width: 0 !important;

        margin: 0 !important;
        padding: 0 !important;

        display: block !important;
    }


    /*
       IMPORTANT:
       Your original form container has width: 200vh.
       Override it during print.
    */

    .print-form-container,
    form .container-fluid,
    form > .container-fluid {
        width: 100% !important;
        max-width: 100% !important;
        min-width: 0 !important;

        margin: 0 !important;
        padding: 0 !important;
    }


    /* -----------------------------------------------------
       BOOTSTRAP CONTAINER FIX
       ----------------------------------------------------- */

    .container,
    .container-fluid {
        width: 100% !important;
        max-width: 100% !important;
        min-width: 0 !important;
    }


    /* -----------------------------------------------------
       BOOTSTRAP ROW FIX
       ----------------------------------------------------- */

    .row {
        width: 100% !important;
        max-width: 100% !important;

        margin-left: 0 !important;
        margin-right: 0 !important;

        display: flex !important;
        flex-wrap: wrap !important;

        page-break-inside: avoid;
        break-inside: avoid;
    }


    /* -----------------------------------------------------
       COLUMN FIX
       ----------------------------------------------------- */

    .row > [class*="col-"] {
        box-sizing: border-box !important;
    }


    /* -----------------------------------------------------
       HEADINGS
       ----------------------------------------------------- */

    h1,
    h2,
    h3,
    h4,
    h5,
    h6 {
        color: #000000 !important;

        page-break-after: avoid !important;
        break-after: avoid !important;

        page-break-inside: avoid !important;
        break-inside: avoid !important;
    }

    h2 {
        font-size: 18px !important;
        line-height: 1.25 !important;

        text-align: center !important;

        margin-top: 3mm !important;
        margin-bottom: 4mm !important;
    }

    h3 {
        font-size: 14px !important;
    }

    h6 {
        font-size: 11px !important;

        padding: 5px !important;
        margin: 5px 0 !important;

        background: #e5e5e5 !important;
        border: 1px solid #999999 !important;
    }


    /* -----------------------------------------------------
       LABELS
       ----------------------------------------------------- */

    label {
        color: #000000 !important;
        font-weight: 600 !important;

        font-size: 9px !important;

        margin-bottom: 2px !important;
    }


    /* -----------------------------------------------------
       FORM CONTROLS
       ----------------------------------------------------- */

    .form-control,
    .form-select,
    select,
    input,
    textarea {
        box-sizing: border-box !important;

        width: 100% !important;
        max-width: 100% !important;

        min-height: 25px !important;
        height: auto !important;

        padding: 3px 5px !important;

        font-size: 9px !important;
        line-height: 1.2 !important;

        color: #000000 !important;
        background: #ffffff !important;

        border: 1px solid #777777 !important;
        border-radius: 2px !important;

        box-shadow: none !important;
    }


    textarea {
        min-height: 45px !important;
        resize: none !important;
    }


    /*
       Make disabled/read-only fields print normally.
    */

    input:disabled,
    select:disabled,
    textarea:disabled,
    .form-control:disabled {
        color: #000000 !important;
        background: #ffffff !important;
        opacity: 1 !important;
    }


    /* -----------------------------------------------------
       TABLES
       ----------------------------------------------------- */

    table {
        width: 100% !important;
        max-width: 100% !important;

        table-layout: fixed !important;

        border-collapse: collapse !important;
        border-spacing: 0 !important;

        margin: 4px 0 !important;

        font-size: 8.5px !important;

        page-break-inside: auto;
        break-inside: auto;
    }


    table thead {
        display: table-header-group !important;
    }


    table tfoot {
        display: table-footer-group !important;
    }


    table tr {
        page-break-inside: avoid !important;
        break-inside: avoid !important;
    }


    table th,
    table td {
        padding: 3px 4px !important;

        border: 1px solid #555555 !important;

        vertical-align: middle !important;

        color: #000000 !important;

        word-wrap: break-word !important;
        overflow-wrap: break-word !important;
    }


    table th {
        font-weight: 700 !important;
        background: #e5e5e5 !important;
    }


    /* -----------------------------------------------------
       EXISTING TABLE COLORS
       Convert them to printer-friendly grayscale
       ----------------------------------------------------- */

    .table-hover thead tr.tr-header th {
        background-color: #e5e5e5 !important;
        color: #000000 !important;
    }

    .table-hover tbody tr:nth-child(odd),
    .table-hover tbody tr:nth-child(even) {
        background-color: #ffffff !important;
    }


    /* -----------------------------------------------------
       CARD
       ----------------------------------------------------- */

    .card {
        width: 100% !important;
        max-width: 100% !important;

        margin: 0 0 5px 0 !important;
        padding: 0 !important;

        background: #ffffff !important;

        border: 1px solid #777777 !important;
        border-radius: 0 !important;

        box-shadow: none !important;

        page-break-inside: avoid !important;
        break-inside: avoid !important;
    }


    .card-body {
        padding: 5px !important;
        color: #000000 !important;
    }


    /* -----------------------------------------------------
       SECTION HEADERS
       ----------------------------------------------------- */

    .rounded-2 {
        border-radius: 0 !important;
    }


    /* -----------------------------------------------------
       LINKS
       ----------------------------------------------------- */

    a {
        color: #000000 !important;
        background: transparent !important;

        padding: 0 !important;

        text-decoration: none !important;
    }


    /* -----------------------------------------------------
       IMAGES
       ----------------------------------------------------- */

    img {
        max-width: 100% !important;
        height: auto !important;
    }


    /* -----------------------------------------------------
       SPACING
       ----------------------------------------------------- */

    .mt-1 {
        margin-top: 2px !important;
    }

    .mt-2 {
        margin-top: 3px !important;
    }

    .mt-3 {
        margin-top: 4px !important;
    }

    .mt-4 {
        margin-top: 5px !important;
    }

    .mb-1 {
        margin-bottom: 2px !important;
    }

    .mb-2 {
        margin-bottom: 3px !important;
    }

    .mb-3 {
        margin-bottom: 4px !important;
    }

    .mb-4 {
        margin-bottom: 5px !important;
    }


    /* -----------------------------------------------------
       REMOVE LARGE EMPTY SPACE
       ----------------------------------------------------- */

    br {
        display: none !important;
    }


    /* -----------------------------------------------------
       PAGE BREAK CONTROL
       ----------------------------------------------------- */

    .print-section,
    .card,
    .row,
    .form-group {
        page-break-inside: avoid !important;
        break-inside: avoid !important;
    }


    .page-break-before {
        page-break-before: always !important;
        break-before: page !important;
    }


    .page-break-after {
        page-break-after: always !important;
        break-after: page !important;
    }


    /* -----------------------------------------------------
       DON'T BREAK IMPORTANT FORM GROUPS
       ----------------------------------------------------- */

    h2,
    h3,
    h4,
    h5,
    h6,
    table,
    thead {
        page-break-after: avoid !important;
    }


    /* -----------------------------------------------------
       PRINT COLORS
       ----------------------------------------------------- */

    *,
    *::before,
    *::after {
        -webkit-print-color-adjust: exact !important;
        print-color-adjust: exact !important;
    }


    /* -----------------------------------------------------
       REMOVE FOCUS / SHADOWS
       ----------------------------------------------------- */

    *:focus {
        outline: none !important;
        box-shadow: none !important;
    }


    /* -----------------------------------------------------
       TEXT ALIGNMENT
       ----------------------------------------------------- */

    .text-center {
        text-align: center !important;
    }

    .text-start {
        text-align: left !important;
    }

    .text-end {
        text-align: right !important;
    }


    /* -----------------------------------------------------
       CHECKBOX / RADIO
       ----------------------------------------------------- */

    input[type="checkbox"],
    input[type="radio"] {
        width: auto !important;
        min-height: auto !important;

        margin-right: 3px !important;
    }


    /* -----------------------------------------------------
       BUTTON AREA
       ----------------------------------------------------- */

    .text-center:has(.printMe) {
        display: none !important;
    }


    /* -----------------------------------------------------
       PREVENT HORIZONTAL OVERFLOW
       ----------------------------------------------------- */

    .table-responsive {
        overflow: visible !important;
        width: 100% !important;
    }


    /* -----------------------------------------------------
       FORCE CONTENT TO STAY INSIDE PRINT PAGE
       ----------------------------------------------------- */

    .print-form-container * {
        max-width: 100% !important;
        box-sizing: border-box !important;
    }


    /* -----------------------------------------------------
       FINAL PRINT WIDTH
       ----------------------------------------------------- */

    #Fire\ Recommendation\ Letter,
    .print-form-container {
        width: 100% !important;
        max-width: 100% !important;
        min-width: 0 !important;
    }
}

@media print {

    /* Hide all images from print */
    img,
    picture,
    svg,
    canvas {
        display: none !important;
        visibility: hidden !important;
    }

    /* Specifically hide NMC / G20 header images */
    .fire-noc-form img,
    .fire-noc-form picture,
    .fire-noc-form svg {
        display: none !important;
        visibility: hidden !important;
    }
}
</style>


</head>

<body >

	<br>


	

<form name="Fire Recommendation Letter"
      action=""
      id="FireRecommendationLetter"
      class="fire-noc-form">
<div class="container-fluid mt-2 print-form-container"  style="width: 200vh">
					<h2 style="text-align: center; font-weight: 500;">
						<b>अग्निशमन ना-हरकत दाखला देणे (तात्पुरते)<br>(Temporary Fire NOC)</b>
					</h2>


					<h6 style="background-color: #dce2e8; padding: 10px;margin-left: -10px;"
						class="  rounded-2">
						<strong> 
						Applicant details for Building Construction 
						</strong>
					</h6>
					


					
                    <div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

                        <div style="width: 33%;">
								<label for="" class="form-label lbleng">Title&nbsp(शीर्षक)<span
									class="text-danger" style="color: red;">*</span>
								</label> <select class="form-control" style="background-image: none;"
									name="title"  required>
									<option value="">-Select-</option>
									<option value="1">Mr</option>
									<option value="2">Mrs</option>
									<option value="3">Ms</option>
								</select>
								<div class="invalid-feedback">Please Select Title..</div>
							</div>
						

                            <div style="width: 33%;">
								<label for="" class="form-label lbleng">First Name&nbsp(पहिले
									नाव)<span class="text-danger">*</span>
								</label> <input type="text" class="form-control"
									style="background-image: none;" id="first_name" placeholder=""
									name="firstName" value="" pattern="[A-Za-z]+"
									onchange="Display(this.id)" required>
								<div class="invalid-feedback">Please Enter Valid First
									Name.</div>
							</div>
						

                            <div style="width: 33%;">
								<label for="" class="form-label lbleng">Middle Name&nbsp(मधले
									नाव)</label> <input type="text" class="form-control"
									style="background-image: none;" id="middle_name" placeholder=""
									name="middleName" value="" pattern="[A-Za-z]+"
									onchange="Display(this.id)">


							</div>
						</div>

                        <div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

                            <div style="width: 33%;">
								<label for="" class="form-label lbleng">Last Name&nbsp(आडनाव)<span
									class="text-danger" style="color: red;">*</span></label> <input
									type="text" class="form-control"
									style="background-image: none;" name="lastName" id="last_name"
									value="" pattern="[A-Za-z]+" onchange="Display(this.id)"
									required>
								<div class="invalid-feedback">Please Enter Valid Last
									Name.</div>
							</div>
					
                            <div style="width: 33%;">
								<label for="" class="form-label">Full Name&nbsp(पूर्ण नाव) </label> <input
									type="text" class="form-control"
									style="background-image: none;" id="full_name" placeholder=""
									name="fullName" value="" readonly>
							</div>
					


						<script>
                            function Display(id) {
                                $('#full_name').val($('#first_name').val() + " " + $('#middle_name').val() + " " + $('#last_name').val())
                            }
                        </script>
					<div style="width: 33%;">
								<label for="" class="form-label lbleng">Plot/ Flat
									No&nbsp(प्लॉट/फ्लॅट क्र.) </label> <input type="text" class="form-control"
									style="background-image: none;" id="plotNumber" placeholder=""
									name="plotNumber" value="">
								<div class="invalid-feedback">Please Enter Valid Plot/
									Flat No.</div>
							</div>
						</div>

                        <div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

                            <div style="width: 33%;">
								<label for="" class="form-label lbleng">City Survey
									No&nbsp(सिटी सर्व्हे क्र.)</label> <input type="text" class="form-control"
									style="background-image: none;" id="surveyNo" placeholder=""
									name="surveyNo" value="">
                                    <div class="invalid-feedback">Please Enter City Survey.</div>
							</div>
							
						
						
						<div style="width: 33%;">
								<label for="" class="form-label lbleng">Sheet No&nbsp(शिट क्रमांक)</label> <input type="text" class="form-control"
									style="background-image: none;" id="sheetNo" placeholder=""
									name="sheetNo" value="">
							</div>
							<div class="invalid-feedback">Please Enter Sheet No.</div>
						

                            <div style="width: 33%;">
								<label for="" class="form-label lbleng">Khasara No&nbsp(खसरा क्रमांक)</label> <input type="text" class="form-control"
									style="background-image: none;" id="khasaraNo" placeholder=""
									name="khasaraNo" value="">
							</div>
							<div class="invalid-feedback">Please Enter Khasara No.</div>
						</div>
						
                        <div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

                            <div style="width: 33%;">
								<label for="" class="form-label lbleng">Name of the
									Street&nbsp(रस्त्याचे नाव) <span class="text-danger"
									style="color: red;">*</span>
								</label> </label> <input type="text" class="form-control"
									style="background-image: none;" id="streetName" placeholder=""
									name="streetName" value="" required>
								<div class="invalid-feedback">Please Enter Valid Name of
									the Street.</div>
							
						</div>

						<div style="width: 33%;">
								<label for="" class="form-label lbleng">House Mouza
									No&nbsp(घर मौजा क्र.) </label> <input type="text" class="form-control"
									style="background-image: none;" id="" placeholder=""
									name="houseNo" value="">
								<div class="invalid-feedback">Please Enter Valid House
									Mouza No.</div>
							
						</div>


						<div style="width: 33%;">
								<label for="" class="form-label">Pin Code&nbsp(पिन कोड)<span
									class="text-danger" style="color: red;">*</span></label> <input
									type="text" class="form-control"
									style="background-image: none;" id="pinCode" placeholder=""
									name="pinCode" value=""
									onkeypress="return (event.charCode !=6 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))"
									maxlength="6" required>
								<div class="invalid-feedback">Please Enter Valid Pin Code.
								</div>
							</div>
						</div>


                        <div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

                            <div style="width: 33%;">
								<label for="" class="form-label lbleng">Landmark&nbsp(लँडमार्क)</label>
								<input type="text" class="form-control"
									style="background-image: none;" id="landmark" placeholder=""
									name="landmark" value="">
							</div>
						


                        <div style="width: 33%;">
								<label for="" class="form-label"> Mobile No&nbsp(मोबाईल
									क्र.)<span class="text-danger" style="color: red;">*</span>
								</label> <input type="text" class="form-control"
									style="background-image: none;" id="mobileNo" placeholder=""
									name="mobileNo" value="" pattern="[6-9]{1}[0-9]{9}"
									maxlength="10" required>
								<div class="invalid-feedback">Please Enter Valid Mobile
									No.</div>
							</div>
						



                            <div style="width: 33%;">
								<label for="" class="form-label lbleng">Email Id&nbsp(ई - मेल
									आयडी) <span class="text-danger" style="color: red;">*</span>
								</label> <input type="email" class="form-control"
									style="background-image: none;" id="appEmail" placeholder=""
									name="appEmail" value="" required>
								<div class="invalid-feedback">Please Enter Valid Email Id.
								</div>
							</div>

						</div>

			
                        <div class="row" style="display: flex; width: 99%; margin-bottom: 0.1rem; height: 80px;">
								<label for="" class="form-label">Address of Owner
								</label>
								<textarea class="form-control" style="background-image: none;"
									id="addressOfPowerAttorney" placeholder=""
									name="addressOfPowerAttorney" rows="2" ></textarea>
								<div class="invalid-feedback">Please Enter Valid Address
									of Power of Attorney.</div>
							</div>
						





					<h6 style="background-color: #dce2e8; padding: 10px;margin-left: -5px;"
						class="  rounded-2">
						<strong> Architecture Details for Building Constructions </strong>
					</h6>
					

                    <div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

                        <div style="width: 33%;">
								<label for="" class="form-label lbleng">Title&nbsp(शीर्षक)<span
									class="text-danger" style="color: red;">*</span>
								</label> <select class="form-control" style="background-image: none;"
									name="titleArchitecture" required>
									<option value="">-Select-</option>
									<option value="1">Mr</option>
									<option value="2">Mrs</option>
									<option value="3">Ms</option>
								</select>
								<div class="invalid-feedback">Please Select Title..</div>
							</div>
					

                            <div style="width: 33%;">
								<label for="" class="form-label lbleng">First Name&nbsp(पहिले
									नाव)<span class="text-danger">*</span>
								</label> <input type="text" class="form-control"
									style="background-image: none;" id="first_name_architecture"
									placeholder="" name="firstNameArchitecture" value=""
									pattern="[A-Za-z]+" onchange="DisplayArch(this.id)" required>
								<div class="invalid-feedback">Please Enter Valid First
									Name.</div>
							</div>
					

                            <div style="width: 33%;">
								<label for="" class="form-label lbleng">Middle Name&nbsp(मधले
									नाव)</label> <input type="text" class="form-control"
									style="background-image: none;" id="middle_name_architecture"
									placeholder="" name="middleNameArchitecture" value=""
									pattern="[A-Za-z]+" onchange="DisplayArch(this.id)">
							</div>
						</div>

                        <div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

                            <div style="width: 33%;">
								<label for="" class="form-label lbleng">Last Name&nbsp(आडनाव)<span
									class="text-danger" style="color: red;">*</span></label> <input
									type="text" class="form-control"
									style="background-image: none;" name="lastNameArchitecture"
									id="last_name_architecture" value="" pattern="[A-Za-z]+"
									onchange="DisplayArch(this.id)" required>
								<div class="invalid-feedback">Please Enter Valid Last
									Name.</div>
							</div>
						
                            <div style="width: 33%;">
								<label for="" class="form-label">Full Name&nbsp(पूर्ण नाव) </label> <input
									type="text" class="form-control"
									style="background-image: none;" id="full_name_architecture"
									placeholder="" name="fullNameArchitecture" value="" readonly>
							</div>
					


						<script>
                            function DisplayArch(id) {
                                $('#full_name_architecture').val($('#first_name_architecture').val() + " " + $('#middle_name_architecture').val() + " " + $('#last_name_architecture').val())
                            }
                        </script>


<div style="width: 33%;">
								<label for="" class="form-label"> Mobile No&nbsp(मोबाईल
									क्र.)<span class="text-danger" style="color: red;">*</span>
								</label> <input type="text" class="form-control"
									style="background-image: none;" id="mobileNoArchitecturee"
									placeholder="" name="mobileNoArchitecture" value=""
									pattern="[6-9]{1}[0-9]{9}" maxlength="10" required>
								<div class="invalid-feedback">Please Enter Valid Mobile
									No.</div>
							</div>
						

</div>

<div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

    <div style="width: 33%;">
								<label for="" class="form-label lbleng">Email Id&nbsp(ई - मेल
									आयडी) <span class="text-danger" style="color: red;">*</span>
								</label> <input type="email" class="form-control"
									style="background-image: none;" id="appEmailArchitecturee"
									placeholder="" name="appEmailArchitecture" value="" required>
								<div class="invalid-feedback">Please Enter Valid Email Id.
								</div>
							</div>

					
						
                            <div style="width: 33%;">
								<label for="" class="form-label lbleng">Architect Licence Number&nbsp(वास्तुकार परवानगी क्रमांक) <span class="text-danger" style="color: red;">*</span>
								</label> <input type="text" class="form-control"
									style="background-image: none;" id="architectLicenceNumber"
									placeholder="" name="architectLicenceNumber" value="" required>
								<div class="invalid-feedback">Please Enter Valid Architect Licence Number.
								</div>
							</div>

						</div>
							
						
							
							
							
					
<br>

					
						<h6 style="background-color: #dce2e8; padding: 10px;margin-left: -5px;"
							class="  rounded-2">
							<strong> Application Form Details</strong>
						</h6>
						
                        <div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

                            <div style="width: 50%;">
								<label for="" class="form-label lbleng">Name of Building Owner&nbsp(इमारत मालकाचे नाव) <span class="text-danger" style="color: red;">*</span>
								</label> <input type="text" class="form-control"
									style="background-image: none;" id="nameofBuildingOwner"
									placeholder="" name="nameofBuildingOwner" value="" required>
								<div class="invalid-feedback">Please Enter Valid Name of Building Owner.
								</div>
							</div>
                            <div style="width: 49%;">
								<label for="" class="form-label">Address of Building
								</label>
								<textarea class="form-control" style="background-image: none;"
									id="addressofbuilding" placeholder=""
									name="addressofbuilding" rows="1" ></textarea>
								<div class="invalid-feedback">Please Enter Valid Address
									of Power of Building.</div>
							</div>
                            </div>
						
                        <div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

                            <div style="width: 33%;">
								<label for="" class="form-label lbleng">Type Of
									Building&nbsp(इमारतीचा प्रकार)<span class="text-danger"
									style="color: red;">*</span>
								</label> <select id="typeOfBuilding" class="form-control"
									style="height: 35px; background-image: none;"
									onchange="feesCalculate();forSubType();showTypeBUilding()"
									name="typeOfBuilding" required>

									<option value="" selected disabled>--- Select---</option>
									<c:forEach var="fireRecommendationTypeOfBuilding"
										items="${requestScope.fireRecommendationTypeOfBuilding}">
										<option
											value="${fireRecommendationTypeOfBuilding.fireTypeOfBuildingId}">
											<c:out
												value="${fireRecommendationTypeOfBuilding.firetypeofbuildingnames}" />
										</option>
									</c:forEach>
								</select>
								<div class="invalid-feedback">Please Enter Valid Type Of
									Building.</div>

							</div>
						
						
						
						<script>
					 	function showTypeBUilding()
					{
							
					 		var selectedValue = document.getElementsByName("typeOfBuilding")[0].value;
					 		var selectedText = document.getElementsByName("typeOfBuilding")[0].options[document.getElementsByName("typeOfBuilding")[0].selectedIndex].text;
					 		$('#selectedBuildingType').val(selectedText);

	} 
						
	function forSubType()
	{
		
		var typeOfBuilding = $("#typeOfBuilding").val();
        

		$.ajax({
	        type: "POST",
	        url: "${pageContext.request.contextPath}/rtiapplication/subType.do",
	        data: {
	            typeOfBuilding: typeOfBuilding 
	        },
	        dataType: "json",
	        success: function(data) {
	            var options = '<option value="" selected disabled>--- Select ---</option>';
	            $.each(data.subTypeOfbuilding, function(index, subType) {
	                options += '<option value="' + subType.subTypeOfBuildingId + '">' + subType.subTypeOfBuildingName + '</option>';
	            });
	            $("#subTypeOfBuilding").html(options);
	        },
	        error: function() {
	        }
	    });
	}
	</script>
						
                        <div style="width: 33%;">
								<label for="" class="form-label lbleng">Sub Type Of
									Building&nbsp(इमारतीचा प्रकार)<span class="text-danger"
									style="color: red;">*</span>
								</label> <select id="subTypeOfBuilding" class="form-control"
									style="height: 35px; background-image: none;"
									 name="subTypeOfBuilding" required>

									<option value="" selected disabled>--- Select---</option>
									<c:forEach var="subTypeOfbuilding"
										items="${requestScope.subTypeOfbuilding}">
										<option
											value="${subTypeOfbuilding.subTypeOfBuildingId}">
											<c:out
												value="${subTypeOfbuilding.subTypeOfBuildingName}" />
										</option>
									</c:forEach>
								</select>
								<div class="invalid-feedback">Please Enter Valid Sub Type Of
									Building.</div>

							</div>
						
						

						
							<div style="width: 33%;">
								<label for="" class="form-label lbleng">Height Of
									Building&nbsp(इमारतीचा उप प्रकार)<span class="text-danger"
									style="color: red;">*</span>
								</label> <select id="typeOfHeight" class="form-control"
									style="height: 35px; background-image: none;"
									name="typeOfHeight" onchange="feesCalculate();showHeight()" required>

									<option value="" selected disabled>--- Select---</option>
									<c:forEach var="fireBuildingHeight"
										items="${requestScope.fireBuildingHeight}">
										<option value="${fireBuildingHeight.fireBuildingHeightId}">
											<c:out value="${fireBuildingHeight.fireBuildingType}" />
										</option>
									</c:forEach>
								</select>


								<div class="invalid-feedback">Please Enter Valid Type Of
									Building Height.</div>
							</div>
					</div>
						<script type="text/javascript">
						function showHeight()
						{
						
					         var selectedValue = document.getElementsByName("typeOfHeight")[0].value;
						 		var selectedText = document.getElementsByName("typeOfHeight")[0].options[document.getElementsByName("typeOfHeight")[0].selectedIndex].text;
						 		$('#selectedBuildingHeight').val(selectedText);
						}
						</script>
						
                        <div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

                            <div style="width: 33%;">
								<label for="subType1" class="form-label lbleng" lang="en">Type
									of Construction&nbsp(बांधकामाचा प्रकार)<span class="text-danger"
									style="color: red;">*</span>
								</label> <select class="form-control"
									style="background-image: none;" name="typeOfConstruction" id="typeOfConstruction"
									onchange="feesCalculate()" required>
									<option value="" selected disabled>--- Select---</option>
									<c:forEach var="fireTypeOfConstruction"
										items="${requestScope.fireTypeOfConstruction}">
										<option
											value="${fireTypeOfConstruction.fireBuildingconstructionTypeId}">
											<c:out
												value="${fireTypeOfConstruction.fireBuildingConstructionTypeName}" />
										</option>
									</c:forEach>
								</select>

								<div class="invalid-feedback">Please Enter a Valid Type Of
									Construction Building.</div>
						</div>
						
					

                        <div style="width: 33%;">
								<label for="" class="form-label lbleng">Zone No&nbsp(झोन
									क्र.)<span class="text-danger" style="color: red;">*</span>
								</label> <select class="form-select "
									style="height: 35px; background-image: none;"
									id="main-dropdown" name="zoneNO" required>
									<option value="" selected="">-Select Zone-</option>
									<option value="1">Zone No.1 - Laxmi Nagar (लक्ष्मी
										नगर)</option>
									<option value="2">Zone No.2 - Dharmpeth (धरमपेठ)</option>
									<option value="3">Zone No.3 - Hanuman Nagar (हनुमान
										नगर)</option>
									<option value="4">Zone No.4 - Dhantoli (धंतोली)</option>
									<option value="5">Zone No.5 - Nehru Nagar (नेहरू नगर)</option>
									<option value="6">Zone No.6 - Gandhibag (गांधीबाग)</option>
									<option value="7">Zone No.7 - Satranjipura
										(सतरंजीपुरा)</option>
									<option value="8">Zone No.8 - Lakadganj (लकडगंज)</option>
									<option value="9">Zone No.9 - Aashi Nagar (आशी नगर)</option>
									<option value="10">Zone No.10 - Mangalwari (मंगळवारी)</option>
								</select>


								<div class="invalid-feedback">Please Enter Valid Zone No.</div>
							</div>
					


                            <div style="width: 33%;">
								<label for="" class="form-label"> Ward No&nbsp(प्रभाग क्र.)
									<span class="text-danger" style="color: red;">*</span>
								</label> <select class="form-select"
									style="height: 35px; background-image: none;"
									id="dependent-dropdown" name="wardNo" required disabled>

									<option value="" selected>-Select Ward-</option>
									<option value="Ward No. 16">Ward No. 16</option>
									<option value="Ward No. 36">Ward No. 36</option>
									<option value="Ward No. 37">Ward No. 37</option>
									<option value="Ward No. 38">Ward No. 38</option>


									<option value="Ward No. 12">Ward No. 12</option>
									<option value="Ward No. 13">Ward No. 13</option>
									<option value="Ward No. 14">Ward No. 14</option>
									<option value="Ward No. 15">Ward No. 15</option>


									<option value="Ward No. 29">Ward No. 29</option>
									<option value="Ward No. 31">Ward No. 31</option>
									<option value="Ward No. 32">Ward No. 32</option>
									<option value="Ward No. 34">Ward No. 34</option>


									<option value="Ward No. 17">Ward No. 17</option>
									<option value="Ward No. 33">Ward No. 33</option>
									<option value="Ward No. 35">Ward No. 35</option>

									<option value="Ward No. 26">Ward No. 26</option>
									<option value="Ward No. 27">Ward No. 27</option>
									<option value="Ward No. 28">Ward No. 28</option>
									<option value="Ward No. 30">Ward No. 30</option>


									<option value="Ward No. 8">Ward No. 8</option>
									<option value="Ward No. 18">Ward No. 18</option>
									<option value="Ward No. 19">Ward No. 19</option>
									<option value="Ward No. 22">Ward No. 22</option>


									<option value="Ward No. 5">Ward No. 5</option>
									<option value="Ward No. 20">Ward No. 20</option>
									<option value="Ward No. 21">Ward No. 21</option>

									<option value="Ward No. 4">Ward No. 4</option>
									<option value="Ward No. 23">Ward No. 23</option>
									<option value="Ward No. 24">Ward No. 24</option>
									<option value="Ward No. 25">Ward No. 25</option>


									<option value="Ward No. 2">Ward No. 2</option>
									<option value="Ward No. 3">Ward No. 3</option>
									<option value="Ward No. 6">Ward No. 6</option>
									<option value="Ward No. 7">Ward No. 7</option>


									<option value="Ward No. 1">Ward No. 1</option>
									<option value="Ward No. 9">Ward No. 9</option>
									<option value="Ward No. 10">Ward No. 10</option>
									<option value="Ward No. 11">Ward No. 11</option>


								</select>
								<div class="invalid-feedback">Please Enter Valid Ward No.</div>
							</div>
</div>
						
						<script>
                            $('#main-dropdown').on('change', function () {
                                document.getElementById("dependent-dropdown").removeAttribute('disabled');

                                var selectedValue = $('#main-dropdown').val();

                                var options = [];

                                if (selectedValue === '1') {
                                    options = ['-Select Ward-', 'Ward No. 16', 'Ward No. 36', 'Ward No. 37', 'Ward No. 38'];
                                } else if (selectedValue === '2') {
                                    options = ['-Select Ward-', 'Ward No. 12', 'Ward No. 13', 'Ward No. 14', 'Ward No. 15'];
                                } else if (selectedValue === '3') {
                                    options = ['-Select Ward-', 'Ward No. 29', 'Ward No. 31', 'Ward No. 32', 'Ward No. 34'];
                                } else if (selectedValue === '4') {
                                    options = ['-Select Ward-', 'Ward No. 17', 'Ward No. 33', 'Ward No. 35'];
                                } else if (selectedValue === '5') {
                                    options = ['-Select Ward-', 'Ward No. 26', 'Ward No. 27', 'Ward No. 28', 'Ward No. 30'];
                                } else if (selectedValue === '6') {
                                    options = ['-Select Ward-', 'Ward No. 8', 'Ward No. 18', 'Ward No. 19', 'Ward No. 22'];
                                } else if (selectedValue === '7') {
                                    options = ['-Select Ward-', 'Ward No. 5', 'Ward No. 20', 'Ward No. 21'];
                                } else if (selectedValue === '8') {
                                    options = ['-Select Ward-', 'Ward No. 4', 'Ward No. 23', 'Ward No. 24', 'Ward No. 25'];
                                } else if (selectedValue === '9') {
                                    options = ['-Select Ward-', 'Ward No. 2', 'Ward No. 3', 'Ward No. 6', 'Ward No. 7'];
                                } else if (selectedValue === '10') {
                                    options = ['-Select Ward-', 'Ward No. 1', 'Ward No. 9', 'Ward No. 10', 'Ward No. 11'];
                                } else if (selectedValue === 'select-zone') {
                                    options = ['select-ward'];
                                }
                                $('#dependent-dropdown').empty();
                                for (var i = 0; i < options.length; i++) {
                                    $('#dependent-dropdown').append('<option value="' + (options[i] === '-Select Ward-' ? '' : options[i]) + '">' + options[i] + '</option>');
                                }
                            });
                        </script>


<div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

    <div style="width: 33%;">
								<label for="" class="form-label lbleng">Height of
									Building&nbsp(इमारतीची उंची-mtr)<span class="text-danger"
									style="color: red;">*</span>
								</label> <input type="text" step="any"  class="form-control"
									style="background-image: none;" id="hightOfBuilding"
									placeholder="" name="hightOfBuilding" value="" required>
								<div class="invalid-feedback">Please Enter Valid Height of
									Building.</div>
							</div>
						
						
	
						

                            <div style="width: 33%;">
								<label for="" class="form-label lbleng">Floors&nbsp(मजले) <span
									class="text-danger" style="color: red;">*</span></label> <input
									class="form-control" id="floors"
									style="height: 35px; background-image: none;"
									name="floors" required>

								<div class="invalid-feedback">Please Enter Valid Floors.</div>

							</div>
						



						


						
                            <div style="width: 33%;">
								<label for="" class="form-label lbleng"> Total Plot
									Area&nbsp(एकूण भूखंड क्षेत्र-sq.mtr)<span class="text-danger" style="color: red;">*</span>
								</label> <input type="Number" step="any" class="form-control"
									style="background-image: none;" id="totalPlotArea"
									placeholder="" name="totalPlotArea" value="" required>
								<div class="invalid-feedback">Please Enter Valid Total
									Plot Area.</div>
							</div>
					
</div>
<div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

    <div style="width: 33%;">
								<label for="" class="form-label lbleng">Built Up
									Area&nbsp(बिल्ट अप एरिया-sqmtr) <span class="text-danger"
									style="color: red;">*</span>
								</label> <input type="number" step="any" class="form-control"
									style="background-image: none;" id="buildUpArea"
									placeholder="" name="buildUpArea" value=""
									required>
								<div class="invalid-feedback">Please Enter Valid Built Up
									Area.</div>
							</div>
					

                            <div style="width: 33%;">
								<label for="" class="form-label lbleng">Super Built Up
									Area&nbsp(सुपर बिल्ट अप एरिया-sqmtr) <span class="text-danger"
									style="color: red;">*</span>
								</label> <input type="number" step="any" class="form-control"
									style="background-image: none;" id="superBuildarea"
									placeholder="" name="superBuildarea" value=""
									required>
								<div class="invalid-feedback">Please Enter Valid Super
									Built Up Area.</div>
							</div>
						

                            <div style="width: 33%;">
								<label for="" class="form-label lbleng">Number of
									Buildings&nbsp(इमारतींची संख्या)</label><span class="text-danger" style="color: red;">*</span> <input type="number"
									class="form-control" style="background-image: none;"
									id="numberOfBuilding" placeholder="Number"
									name="numberOfBuilding" value="" required>
								<div class="invalid-feedback">Please Enter Valid Number of
									Buildings.</div>
							</div>
                        </div>


                        <div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

                            <div style="width: 33%;">
								<label for="" class="form-label">Number of Wings&nbsp(विंग्स ची संख्या)<span class="text-danger" style="color: red;">*</span> </label> <input type="Number" class="form-control"
									style="background-image: none;" id="numOfWings" placeholder=""
									name="numOfWings" value="" required>
								<div class="invalid-feedback">Please Enter Valid Number of
									Wings.</div>
							</div>
						


                            <div style="width: 33%;">
								<label for="" class="form-label lbleng">Present Position of Building(इमारतीची वर्तमान स्थिती) <span class="text-danger" style="color: red;">*</span>
								</label> <select id="presentPosition" class="form-select"
									style="height: 35px; background-image: none;"
									name="presentPosition" required>
									<option value="">-Select-</option>
									<option value="1">Proposed</option>
									<option value="2">Existing</option>
								</select>
								<div class="invalid-feedback">Please Select Valid Present
									Position.</div>


							</div>
						


                                <div style="width: 33%;">
								<label for="" class="form-label">Front Margin Width&nbsp(समोरच्या समासाची रुंदी-mtr)<span class="text-danger" style="color: red;">*</span> </label> <input type="Number"
									class="form-control" step="any" style="background-image: none;"
									id="frontMarginWidth" placeholder="" name="frontMarginWidth"
									value="" required>
									<div class="invalid-feedback">Please Enter Valid Front Margin.</div>
							</div>
						</div>

						<div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

                            <div style="width: 33%;">
								<label for="" class="form-label">Rear Margin&nbsp(मागील समास)<span class="text-danger" style="color: red;">*</span></label>
								<input type="text" step="any" class="form-control"
									style="background-image: none;" id="realMargin" placeholder=""
									name="realMargin" value="" required>
									<div class="invalid-feedback">Please Enter Valid Rear Margin.</div>
							</div>
						


                            <div style="width: 33%;">
								<label for="" class="form-label">Side Margin1&nbsp(बाजूची कडा1)<span class="text-danger" style="color: red;">*</span></label>
								
								<input type="text" class="form-control"
									style="background-image: none;" id="sideMargine" placeholder=""
									name="sideMargine" value="" required>
								<div class="invalid-feedback">Please Enter Valid Side Margin1.</div>
									
							</div>
						
						
                            <div style="width: 33%;">
								<label for="" class="form-label">Side Margin2&nbsp(बाजूची कडा2)<span class="text-danger" style="color: red;">*</span></label>
								
								<input type="text" class="form-control"
									style="background-image: none;" id="sideMargineTwo" placeholder=""
									name="sideMargineTwo" value="" required>
									<div class="invalid-feedback">Please Enter Valid Side Margin2.</div>
									
							</div>
						</div>



						<div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

                            <div style="width: 33%;">
								<label for=""  class="form-label">Width of	Entrance&nbsp(प्रवेशद्वाराची रुंदी - mtr)<span class="text-danger" style="color: red;">*</span> </label> <input type="Number"
									class="form-control" step="any" style="background-image: none;"
									id="widthOfEntrance" placeholder="" name="widthOfEntrance"
									value="" required>
																		<div class="invalid-feedback">Please Enter Valid Width of Entrance.</div>
									
							</div>
					




                            <div style="width: 33%;">
								<label for=""  class="form-label">Area of
									Basement&nbsp(तळघराचे क्षेत्रफळ - sqmtr)<span class="text-danger" style="color: red;">*</span></label> <input type="Number"
									class="form-control" step="any" style="background-image: none;"
									id="areaOfBasement" placeholder="" name="areaOfBasement"
									value="" required>
							<div class="invalid-feedback">Please Enter Valid Area of Basement.</div>
									
							</div>
					

                            <div style="width: 33%;">
								<label for=""  class="form-label">Capacity of Underground Tank&nbsp(भूमिगत टाकीची क्षमता-ltr)<span class="text-danger" style="color: red;">*</span></label> <input type="Number"
									class="form-control" step="any" style="background-image: none;"
									id="capacityOfUnderGroundTank" placeholder=""
									name="capacityOfUnderGroundTank" value="" required>
							<div class="invalid-feedback">Please Enter Valid Capacity of Underground Tank.</div>
									
							</div>
						</div>
						<div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

                            <div style="width: 33%;">
								<label for="" class="form-label">Capacity of Overhead
									Tank&nbsp(ओव्हरहेड टाकीची क्षमता-ltr)<span class="text-danger" style="color: red;">*</span></label> <input type="Number"
									class="form-control" step="any" style="background-image: none;"
									id="capacityOFOverHeadTank" placeholder=""
									name="capacityOFOverHeadTank" value="" required>
									<div class="invalid-feedback">Please Enter Valid Capacity of Overhead Tank.</div>
							</div>




                            <div style="width: 33%;">
								<label for="" class="form-label lbleng">Location of
									Transformer Room&nbsp(ट्रान्सफॉर्मर रूमचे स्थान)<span class="text-danger" style="color: red;">*</span> </label> <input type="text"
									class="form-control" style="background-image: none;"
									id="locationOfTransferRoom" placeholder=""
									name="locationOfTransferRoom" value="" required>
									<div class="invalid-feedback">Please Enter Valid Location of Transformer Room.</div>
							</div>
						


						
                            <div style="width: 33%;">
								<label for="" class="form-label">Proposed site of A.C
									Plant&nbsp(A.C प्लांटची प्रस्तावित जागा)<span class="text-danger" style="color: red;">*</span></label> <input type="text"
									class="form-control" style="background-image: none;" id=""
									placeholder="" name="acPlant" value="" required>
									<div class="invalid-feedback">Please Enter Valid Proposed site of A.C
									Plant.</div>
							</div>
						</div>
						
						<div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

                  
                        
	
        <label style="display: flex; width: 100%;margin-top: 20px;margin-left: -10px; margin-bottom: 0.1rem; height: 30px;" for="" class="form-label lbleng">FireFighting System as per N.B.C&nbsp(N.B.C नुसार अग्निशमन यंत्रणा)<span class="text-danger" style="color: red;">*</span></label>
        <div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 20px;">
            <div style="width: 22%;">
                <input type="checkbox" id="fireExtinguisher" name="fireFightingSystemNBC" value="Fire Extinguisher">
                <label for="fireExtinguisher">Fire Extinguisher</label>
            </div>
            <div style="width: 22%;">
                <input type="checkbox" id="riserCheckbox" name="fireFightingSystemNBC" value="Wet riser/ down comer">
                <label for="riserCheckbox">Wet riser/ down comer</label>
            </div>
            <div style="width: 30%;">
                <input type="checkbox" id="automaticFireAlarmDetectionSystem" name="fireFightingSystemNBC" value="Automatic Fire Alarm & Detection System">
                <label for="automaticFireAlarmDetectionSystemCheckbox">Automatic Fire Alarm & Detection System</label>
            </div>
            <div style="width: 10%;">
                <input type="checkbox" id="hoseReelCheckbox" name="fireFightingSystemNBC" value="Hose reel">
                <label for="hoseReelCheckbox">Hose reel</label>
            </div>
           
        </div>
        <div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 30px;">

            <div style="width: 22%;">
                <input type="checkbox" id="yardHydrantCheckbox" name="fireFightingSystemNBC" value="Yard Hydrant">
                <label for="yardHydrantCheckbox">Yard hydrant</label>
            </div>
            <div style="width: 22%;">
                <input type="checkbox" id="manualFireAlarmSystemCheckbox" name="fireFightingSystemNBC" value="Manual Fire Alarm System">
                <label for="manualFireAlarmSystemCheckbox">Manual Fire Alarm System</label>
            </div>
            <div style="width: 22%;">
                <input type="checkbox" id="sprinklerCheckbox" name="fireFightingSystemNBC" value="Sprinkle">
                <label for="sprinklerCheckbox">Sprinkle</label>
<div class="invalid-feedback">Please select valid option</div>

            </div>
          
           
        </div>

     
            <div style="margin-left: -10;margin-top: 10px;">
                <label for="" class="form-label lbleng">Number of Exposure Hazard [As per sanctioned plan] </label><span class="text-danger" style="color: red;">*</span>
            </div>
        
            
<div class="container mt-4" style="margin-left: -10px;">
<table class="table table-bordered">
<tbody>
<tr>
<td class="align-middle">East</td>
<td><input type="text" class="form-control" name="east" style="background-image: none;" required>
<div class="invalid-feedback">Please Enter Valid East</div>
</td>
</tr>
<tr>
<td class="align-middle">West</td>
<td><input type="text" class="form-control" name="west" style="background-image: none;" required>
<div class="invalid-feedback">Please Enter Valid West</div></td>
</tr>
<tr>
<td class="align-middle">North</td>
<td><input type="text" class="form-control" name="north" style="background-image: none;" required>
<div class="invalid-feedback">Please Enter Valid North</div></td>
</tr>
<tr>
<td class="align-middle">South</td>
<td><input type="text" class="form-control" name="south" style="background-image: none;" required>
<div class="invalid-feedback">Please Enter Valid South</div></td>
</tr>
</tbody>
</table>
</div>

					
					
				
						<div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

                            <div style="width: 50%;">
								<label for="" class="form-label lbleng">Electric
									Pump&nbsp(इलेक्ट्रिक पंप) <span class="text-danger"
									style="color: red;">*</span>
								</label>

								<div class="d-flex mt-2 border rounded  p-2">
									<div class="form-check ms-3">
										<input type="radio" class="form-check-input" id="radio3"
											name="electricPump" value="1" required>Yes <label
											class="form-check-label" for="radio1"></label>
									</div>

									<div class="form-check ms-3">
										<input type="radio" class="form-check-input" id="radio4"
											name="electricPump" value="2" required>No <label
											class="form-check-label" for="radio1"></label>
																		<div class="invalid-feedback">Please Select Valid Option</div>

									</div>
								</div>
                                <label id="pob-error" class="error" for="pob"></label>
                            </div>
								
                                <div style="width: 50%;" id="electricPumpDp">
                                    <label for="" style="margin-top: 4px;" class="form-label lbleng">Electric Pump
                                        Capacity&nbsp(विद्युत पंप क्षमता)<span class="text-danger"
                                        style="color: red; ">*</span>
                                    </label> 									
                                        <select class="form-control" style="background-image: none;" name="electricPumpCapacity" id="electricPumpCapacity">
      <option value="" selected>-- Select --</option>
      <option value="450">450 lpm</option>
      <option value="900">900 lpm</option>
      <option value="1620">1620 lpm</option>
      <option value="2280">2280 lpm</option>
      <option value="2850">2850 lpm</option>
    </select>									<div class="invalid-feedback">Please Select Valid Option</div>
    
                                        
                                </div>
                           

							</div>
						



                            <div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

                                <div style="width: 50%;">
								<label for="" class="form-label lbleng">Diesel
									Pump&nbsp(डिझेल पंप)<span class="text-danger" style="color: red;">*</span>
								</label>

								<div class="d-flex mt-2 border rounded  p-2">
									<div class="form-check ms-3">
										<input type="radio" class="form-check-input" id="radio5"
											name="dieselPump" value="1" required>Yes <label
											class="form-check-label" for="radio1"></label>
									</div>

									<div class="form-check ms-3">
										<input type="radio" class="form-check-input" id="radio6"
											name="dieselPump" value="2" required>No <label
											class="form-check-label" for="radio1"></label>
																		<div class="invalid-feedback">Please Select Valid Option</div>

									</div>
									
								</div>
								<label id="pob-error" class="error" for="pob"></label>
							</div>

                           
                                <div style="width: 50%;" id="dieselPumpDp">
                                    <label for="" style="margin-top: 4px;" class="form-label lbleng">Diesel Pump
                                        Capacity&nbsp(डिझेल पंप क्षमता)<span class="text-danger"
                                        style="color: red;">*</span>
                                    </label>
                                        
                                        <select class="form-control" style="background-image: none;" name="dieselPumpCapacity" id="dieselPumpCapacity">
    <option value="" selected>-- Select --</option>
      <option value="450">450 lpm</option>
      <option value="900">900 lpm</option>
      <option value="1620">1620 lpm</option>
      <option value="2280">2280 lpm</option>
      <option value="2850">2850 lpm</option>
    </select>
    									<div class="invalid-feedback">Please Select Valid Option</div>
    
                                </div>
                           

						</div>

                        <div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

                            <div style="width: 50%;">
								<label for="" class="form-label lbleng">Jocky Pump&nbsp(जॉकी
									पंप)<span class="text-danger" style="color: red;">*</span>
								</label>

								<div class="d-flex mt-2 border rounded  p-2">
									<div class="form-check ms-3">
										<input type="radio" class="form-check-input" id="radio7"
											name="jockyPump" value="1" required>Yes <label
											class="form-check-label" for="radio1"></label>
									</div>

									<div class="form-check ms-3">
										<input type="radio" class="form-check-input" id="radio8"
											name="jockyPump" value="2" required>No <label
											class="form-check-label" for="radio1"></label>
																		<div class="invalid-feedback">Please Select Valid Option</div>

									</div>
									
								</div>
								<label id="pob-error" class="error" for="pob"></label>
							</div>

                         
                                <div style="width: 50%;" id="jockyPumpDp">
                                    <label for="" style="margin-top: 4px;" class="form-label lbleng">Jocky Pump
                                        Capacity&nbsp(जॉकी पंप क्षमता)<span class="text-danger"
                                        style="color: red;">*</span>
                                    </label>									
                                            <select class="form-control" style="background-image: none;" name="jockyPumpCapacity" id="jockyPumpCapacity">
      <option value="" selected>-- Select --</option>
      <option value="180">180 lpm</option>
      <option value="450">450 lpm</option>
      <option value="900">900 lpm</option>
      <option value="1620">1620 lpm</option>
      <option value="2280">2280 lpm</option>
      <option value="2850">2850 lpm</option>
    </select>
                 
                 									<div class="invalid-feedback">Please Select Valid Option</div>
                               
                            </div>
                        </div>
					


				
                            <div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

                                <div style="width: 50%;">
								<label for="" class="form-label lbleng">Booster
									Pump&nbsp(बुस्टर पंप)<span class="text-danger" style="color: red;">*</span>
								</label>

								<div class="d-flex mt-2 border rounded  p-2">
									<div class="form-check ms-3">
										<input type="radio" class="form-check-input" id="radio9"
											name="boosterPump" value="1" required>Yes <label
											class="form-check-label" for="radio1"></label>
									</div>

									<div class="form-check ms-3">
										<input type="radio" class="form-check-input" id="radio10"
											name="boosterPump" value="2" required>No <label
											class="form-check-label" for="radio1"></label>
																		<div class="invalid-feedback">Please Select Valid Option</div>

									</div>
									
								</div>
								<label id="pob-error" class="error" for="pob"></label>
							</div>
                            <div  style="width: 50%;" id="boosterPumpDp">
								<label for="" style="margin-top: 4px;" class="form-label lbleng">Booster Pump
									Capacity&nbsp(बूस्टर पंप क्षमता)<span class="text-danger"
									style="color: red;">*</span>
								</label> 									
									<select class="form-control" style="background-image: none;" name="boosterPumpCapacity" id="boosterPumpCapacity">
  <option value="" selected>-- Select --</option>
  <option value="450">450 lpm</option>
  <option value="900">900 lpm</option>
  <option value="1620">1620 lpm</option>
  <option value="2280">2280 lpm</option>
  <option value="2850">2850 lpm</option>
</select>
									<div class="invalid-feedback">Please Select Valid Option</div>

							</div>

						</div>
					

				
			

				

					

					
						
					


					<script>
                        $(document).ready(function () {
                            $("input[name='electricPump']").change(function () {
                                if ($(this).val() === '1') {
                                    $("#electricPumpDp").show();
                                    document.getElementById("electricPumpCapacity").setAttribute("required", "required");

                                } else {
                                    $("#electricPumpDp").hide();
                                    document.getElementById("electricPumpCapacity").removeAttribute("required");

                                }
                            });

                            $("input[name='dieselPump']").change(function () {
                                if ($(this).val() === '1') {
                                    $("#dieselPumpDp").show();
                                    document.getElementById("dieselPumpCapacity").setAttribute("required", "required");

                                } else {
                                    $("#dieselPumpDp").hide();
                                    document.getElementById("dieselPumpCapacity").removeAttribute("required");

                                }
                            });

                            $("input[name='jockyPump']").change(function () {
                                if ($(this).val() === '1') {
                                    $("#jockyPumpDp").show();
                                    document.getElementById("jockyPumpCapacity").setAttribute("required", "required");
                                } else {
                                    $("#jockyPumpDp").hide();
                                    document.getElementById("jockyPumpCapacity").removeAttribute("required");

                                }
                            });

                            $("input[name='boosterPump']").change(function () {
                                if ($(this).val() === '1') {
                                    $("#boosterPumpDp").show();
                                    document.getElementById("boosterPumpCapacity").setAttribute("required", "required");
                                } else {
                                    $("#boosterPumpDp").hide();
                                    document.getElementById("boosterPumpCapacity").removeAttribute("required");

                                }
                            });
                        });
                    </script>

					<script>
                        $(document).ready(function () {
                            var internalStaircaseValues = []; // Variable to store the values      

                            $("#numInternalStaircaseProvided").on("input", function () {
                                var num = $(this).val();
                                var table = '<table class="table"><thead><tr><th scope="col">Internal Staircase Number</th><th scope="col">Width of Internal Staircase(अंतर्गत पायऱ्याची रुंदी-mtr)</th><th scope="col">From (पासून)</th></tr></thead><tbody>';
                                for (var i = 1; i <= num; i++) {
                                    table += '<tr><td>Internal Staircase' + i + '</td><td><input type="text" class="form-control staircase-input" style="background-image: none;"  name="widthInternalStaircaseProvided" placeholder="" required><div class="invalid-feedback">Please Enter Valid Data</div></td><td><input type="text" class="form-control staircase-input" style="background-image: none;"  name="fromInternalStaricase" placeholder="" required><div class="invalid-feedback">Please Enter Valid Data</div></td></tr>';
                                }
                                table += '</tbody></table>';
                                $(".dynamic-stairs").html(table);

                                // Clear the array and add new values when the number changes
                                internalStaircaseValues = [];
                                $(".staircase-input").on("input", function () {
                                    internalStaircaseValues = $(".staircase-input").map(function () {
                                        return $(this).val();
                                    }).get();
                                    console.log(internalStaircaseValues.join(","));
                                });
                            });
                        });
                    </script>
                    
                    
                    
                    	
					
                    <div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

                        <div style="width: 50%;">
								<label for=""  class="form-label">Number of Internal
									Staircase Provided&nbsp(प्रदान केलेल्या अंतर्गत पायऱ्यांची संख्या)<span
									class="text-danger" style="color: red;">*</span>
								</label> <input  type="Number" class="form-control"
									style="background-image: none;"
									id="numInternalStaircaseProvided" placeholder=""
									name="numInternalStaircaseProvided" value="" required>
								<div class="invalid-feedback">Please Select Valid Number
									of Internal Staircase Provided.</div>
							</div>
						
							<div style="width: 50%;">
								<label for="" class="form-label">Number of
									External/Emergency Staircase Provided&nbsp(प्रदान केलेल्या
									बाह्य/आणीबाणीच्या पायऱ्यांची संख्या) <span class="text-danger"
									style="color: red;">* </span>
								</label> <input type="Number" class="form-control"
									style="background-image: none;" id="numberOfExternal"
									placeholder="" name="numberOfExternal" value="" required>
								<div class="invalid-feedback">Please Select Valid Number
									of External/Emergency Staircase Provided.</div>
						
						</div>
</div>


					<div class="row">
						<div class="col-md-6">
							<div class="mb-3 mt-3">
								<div class="dynamic-stairs"></div>

							</div>
						</div>

						<div class="col-md-6">
							<div class="mb-3 mt-3">
								<div class="dynamic-external-stairs"></div>

							</div>
						</div>
					</div>

					<script>
                        $(document).ready(function () {
                            var externalStaircaseValues = [];

                            $("#numberOfExternal").on("input", function () {
                                var num = $(this).val();
                                var table = '<table class="table"><thead><tr><th scope="col">External Staircase Number</th><th scope="col">Width of External Staircase (बाह्य पायऱ्याची रुंदी-mtr)</th><th scope="col">From (पासून)</th></tr></thead><tbody>';
                                for (var i = 1; i <= num; i++) {
                                    table += '<tr><td>External Staircase ' + i + '</td><td><input type="text" class="form-control external-staircase-input" style="background-image: none;" name="widthOfExternal" placeholder="" required><div class="invalid-feedback">Please Enter Valid Data</div></td><td><input type="text" class="form-control external-staircase-input" style="background-image: none;" name="fromExternalStaricase" placeholder="" required><div class="invalid-feedback">Please Enter Valid Data</div></td></tr>';
                                }
                                table += '</tbody></table>';
                                $(".dynamic-external-stairs").html(table);

                                // Clear the array and add new values when the number changes
                                externalStaircaseValues = [];
                                $(".external-staircase-input").on("input", function () {
                                    externalStaircaseValues = $(".external-staircase-input").map(function () {
                                        return $(this).val();
                                    }).get();
                                    console.log(externalStaircaseValues.join(","));
                                });
                            });
                        });
                    </script>
					        <div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">
                                <div style="width: 50%;">
                    <label for="" class="form-label">Number of Lifts
                        Provided&nbsp(प्रदान केलेल्या लिफ्टची संख्या)</label> <input type="Number"
                        class="form-control" style="background-image: none;"
                        id="noLift" placeholder="" name="noLift" value="">
                </div>

            </div>
					
					

<script>
    $(document).ready(function () {
        var externalStaircaseValues = [];

        $("#noLift").on("input", function () {
            var num = $(this).val();
            var table = '<table class="table"><thead><tr><th scope="col">SrNo</th><th scope="col">Type Of Lift</th></tr></thead><tbody>';  //<th scope="col">No of Lift</th><th scope="col">Capacity</th>
            for (var i = 1; i <= num; i++) {
                table += '<tr><td>'+i+'</td><td><select style="background-image: none;" class="form-control type-lift-select" name="noLift"><option value="" selected>--Select--</option><option value="Passenger Lift">Passenger Lift</option><option value="Fire Lift">Fire Lift</option><option value="Stretcher Lift">Stretcher Lift</option><option value="Service Lift">Service Lift</option></select><div class="invalid-feedback">Please Select Valid Option</div></td></tr>';  
            }
            table += '</tbody></table>';
            $(".dynamic-type-lift").html(table);

            // Clear the array and add new values when the number changes
            externalStaircaseValues = [];
            $(".external-staircase-input").on("input", function () {
                externalStaircaseValues = $(".external-staircase-input").map(function () {
                    return $(this).val();
                }).get();
                console.log(externalStaircaseValues.join(","));
            });
        });
    });
</script>


					<div class="row">
						<div class="col-md-6">
							<div class="mb-3 mt-3">
								<div class="dynamic-type-lift"></div>

							</div>
						</div>
					</div>


                    <div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">
                        <div style="width: 25%;">
        <label for="" class="form-label lbleng">Selected Type Of Building</label>
        <input type="text" id="selectedBuildingType" class="form-control" readonly>
    </div>

    <div style="width: 25%;">
        <label for="" class="form-label lbleng">Selected Building height</label>
        <input type="text" id="selectedBuildingHeight" class="form-control" readonly>
    </div>
  
        

        <div style="width: 25%;">
                    <label for="selectBox">Fire Stations<span class="text-danger" style="color: red;">*</span></label>

                 <select style="background-image: none;" class="form-control" name="fireDepartmentWiseLogin" id="fireDepartmentWiseLogin" required>
    <option value="" selected disabled>--- Select ---</option>
    <c:forEach var="fireDepartmentWiseLogin" items="${requestScope.fireDepartmentWiseLogin}">
        <option value="${fireDepartmentWiseLogin.fireDepartmentWiseLoginId}">
            <c:out value="${fireDepartmentWiseLogin.fireDepartmentWiseLoginName}"/>
        </option>
    </c:forEach>
</select>
																		<div class="invalid-feedback">Please Select Valid Option</div>


                </div>

            
                <div style="width: 25%;">
                  <label for="inputBox">Category<span class="text-danger" style="color: red;">*</span></label>
			<select style="background-image: none;" class="form-control" name="fireSubDepartmentWiseLogin" id="fireSubDepartmentWiseLogin" required>
    <option value="" selected disabled>--- Select ---</option>
    <c:forEach var="fireSubDepartmentWiseLogin" items="${requestScope.fireSubDepartmentWiseLogin}">
        <option value="${fireSubDepartmentWiseLogin.fireSubDepartmentWiseLoginId}">
            <c:out value="${fireSubDepartmentWiseLogin.fireSubDepartmentWiseLoginName}"/>
        </option>
    </c:forEach>
</select>  
																		<div class="invalid-feedback">Please Select Valid Option</div>
              </div>
       
    </div>
   










  
			
                        <table class="table table-hover small-text ms-1" style="margin-top: 70px;">
                            <thead>
<tr>
<td colspan="7">
    <span style="font-size:16px;color:#666;">
        For any non-applicable area category, please enter <b>0</b> or <b>0.0</b> to ensure accurate fee calculation and successful form submission.
    </span>
</td>
</tr>
								<tr class="tr-header">
									
									<th rowspan="2">Categories</th>
									<th colspan="7">Construction Area&nbsp(Sq.mt)</th>
								</tr>


								<tr class="tr-header">
									<th>Type of Floor<span class="text-danger" style="color: red;">*</span></th>
									<th>Residential<span class="text-danger" style="color: red;">*</span></th>
									<th>Institutional<span class="text-danger" style="color: red;">*</span></th>
									<th>Commercial<span class="text-danger" style="color: red;">*</span></th>
									<th>Industrial<span class="text-danger" style="color: red;">*</span></th>
									<th>Total Fees(₹)</th>
                                    <th><a href="javascript:void(0);" id="addMoree"><span class="glyphicon glyphicon-plus"></span></a></th>
								</tr>
							</thead>
                            <tbody id="tb11">
                                <tr>
                                

                                    <td ><select  class="floorName" onchange="feesCalculate();typeFloor(this)"
                                        style="width: 150px; height: 30px;" name="floorName"
                                       id="floorName" required>

                                           <option value="" selected disabled>--- Select---</option>
                                           <c:forEach var="fireFloorName"
                                               items="${requestScope.fireFloorTypes}">
                                               <option value="${fireFloorName.fireFloorTypesId}">
                                                   <c:out value="${fireFloorName.fireFloorTypesName}" />
                                               </option>
                                           </c:forEach>
                                   </select>
                                   	<div class="invalid-feedback">Please Select Valid Option</div>
                                   
                                   
                                   
                                   </td>
                                    <td>
									
                                        <select id="fireFloorTypes"  class="form-control fireFloorTypes"
                                        style="width: 150px; height: 30px; background-image: none;"
                                         name="fireFloorTypes[]" required>
    
                                        <option value="" selected disabled>--- Select---</option>
                                        <c:forEach var="fireFloorName"
                                            items="${requestScope.fireFloorName}">
                                            <option
                                                value="${fireFloorName.fireFloorNameId}">
                                                <c:out
                                                    value="${fireFloorName.fireFloorNames}" />
                                            </option>
                                        </c:forEach>
                                    </select>
                                    <div class="invalid-feedback">Please Select Valid Option</div>
                                    
                                        </td>
                                        

<td valign="middle">
<input style="width:150px;height:30px;"
type="text"
class="txtCal areaValidation"
placeholder="Sq.mt"
name="residArea"
onchange="feesCalculate()"
maxlength="8"
required>
<div class="invalid-feedback">Please Select Valid Option</div>
</td>

<td valign="middle">
<input style="width:150px;height:30px;"
type="text"
class="txtCal areaValidation"
placeholder="Sq.mt"
name="primumAr"
onchange="feesCalculate()"
maxlength="8"
required>
<div class="invalid-feedback">Please Select Valid Option</div>
</td>

<td valign="middle">
<input style="width:150px;height:30px;"
type="text"
class="txtCal areaValidation"
placeholder="Sq.mt"
name="commArea"
onchange="feesCalculate()"
maxlength="8"
required>
<div class="invalid-feedback">Please Select Valid Option</div>
</td>

<td valign="middle">
<input style="width:150px;height:30px;"
type="text"
class="txtCal areaValidation"
placeholder="Sq.mt"
name="otherUse"
onchange="feesCalculate()"
maxlength="8"
required>
<div class="invalid-feedback">Please Select Valid Option</div>
</td>

                               
                                       <!--   <td valign="middle"><input
                                            style="width: 150px; height: 30px;" type="number"
                                            class="txtCal" 
                                            onchange="feesCalculate()" step="any" placeholder="Sq.mt" id="residArea"
                                            name="residArea"></td>
                                        <td valign="middle"><input
                                            style="width: 150px; height: 30px;" type="number"
                                            class="txtCal" 
                                            onchange="feesCalculate()" step="any" placeholder="Sq.mt" id="primumar"
                                            name="primumAr"></td>
                                        <td valign="middle"><input style="width: 150px; height: 30px;" type="number" class="txtCal" 
                                        onchange="feesCalculate();" step="any" placeholder="Sq.mt" id="commArea" name="commArea">
                                            
                                        <td valign="middle"><input
                                            style="width: 150px; height: 30px;" type="number"
                                            class="txtCal" 
                                            onchange="feesCalculate()" step="any" placeholder="Sq.mt" id="otherUse"
                                            name="otherUse"></td>-->
                                       
                                            <td valign="middle"><input
                                            style="width: 150px; height: 30px;" type="number"
                                            class="txtCal" id="totalTabl" step="any" placeholder="Sq.mt"
                                            name="totalTabl[]" readonly></td>
                                            
                                            <td><a href="javascript:void(0);" class="removeLastt" onchange="feesCalculate()">Remove</a></td>
                                </tr>
                            </tbody>
                            <tfoot>
                            	<tr>
                            	<td></td>
                            	<td></td>
                            	<td></td>
                            	<td></td>
                            	<td></td>
                            	
                            	<td>Grand Total</td>
                            	
                            		<td>
                            			<p id="grandTotal"></p>
                            		</td>
                            	</tr>
                            	<tr>
                            	<td></td>
                            	<td></td>
                            	<td></td>
                            	<td></td>
                            	<td></td>
                            	
                            	<td>2% Scrutiny Fees</td>
                            	
                            		<td>
                            			<p id="scrutinyFees"></p>
                            		</td>
                            	</tr>
                            </tfoot>
                        </table>
                        
                       
                        
                     <table class="table table-hover small-text ms-2">
    <tbody id="tb22">
        <tr>
            
            <td valign="middle">
                <select style="width: 150px; height: 30px;"  name="floorNamee[]" class="floorNamere" required>
                    <option value="" selected disabled>--- Select---</option>
                    <c:forEach var="fireFloorName" items="${requestScope.fireFloorTypes}">
                        <option value="${fireFloorName.fireFloorTypesId}">
                            <c:out value="${fireFloorName.fireFloorTypesName}" />
                        </option>
                    </c:forEach>
                </select>
                <div class="invalid-feedback">Please Select Valid Option</div>
            </td>
            <td>
                <select class="form-control fireFloorTypess"  style="width: 150px; height: 30px; background-image: none;" name="fireFloorTypess" required>
                    <option value="" selected disabled>--- Select---</option>
                    <c:forEach var="fireFloorName" items="${requestScope.fireFloorName}">
                        <option value="${fireFloorName.fireFloorNameId}">
                            <c:out value="${fireFloorName.fireFloorNames}" />
                        </option>
                    </c:forEach>
                </select>
                <div class="invalid-feedback">Please Select Valid Option</div>
            </td>
         
            <td valign="middle"><input style="width: 150px; height: 30px;" type="number" step="any" class="txtCal residAreaa"  placeholder="Sq.mt" name="residAreaa[]"><div class="invalid-feedback">Please Select Valid Option</div></td>
            <td valign="middle"><input style="width: 150px; height: 30px;" type="number" step="any" class="txtCal primumArr"  placeholder="Sq.mt" name="primumArr[]"><div class="invalid-feedback">Please Select Valid Option</div></td>
            <td valign="middle"><input style="width: 150px; height: 30px;" type="number" step="any" class="txtCal commArea"  placeholder="Sq.mt" name="commAreaa[]"><div class="invalid-feedback">Please Select Valid Option</div></td>
            <td valign="middle"><input style="width: 150px; height: 30px;" type="number" step="any" class="txtCal otherUsee"  placeholder="Sq.mt" name="otherUsee[]"><div class="invalid-feedback">Please Select Valid Option</div></td>
            <td valign="middle"><input style="width: 150px; height: 30px;" type="number" step="any" class="txtCal totalFees" placeholder="Sq.mt" name="rowWiseTotalFees[]" readonly><div class="invalid-feedback">Please Select Valid Option</div></td>
            <td><a href="javascript:void(0);" class="removeLastt">Remove</a></td>
        </tr>
    </tbody>
</table>

                
                       
                        



						<div id="totalConstructionArea" name="superBuildUpArea"></div>
						<br>
						<div id="totalFees"></div>
						<br>
						<div id="scrutinyFees"></div>
				


					<div class="col-md-12"><strong>(<b>Note :</strong>- As per Maharashtra fire prevention and life safety measures Amendment Act 2023, schedule-II
clause no 2(2) :- For the purpose of assessment of fee, the built-up area shall be gross built-up area,
which includes area of basement, easements, stilts, podium, staircase, lifts, lobbies, passages, balconies,
cantilever portions, service floors, refuge areas, etc., as shown in the building plan certified by the
Architect and submitted to the Authority along with the application for permission for construction of a
building. The built-up area to be calculated for this purpose will have no relation with the floor space index
or the built-up area calculated in any other manner.)</p></div>

					<!-- <div class="col-md-12 text-start mb-5">
						<div class="text-center">
							<button type="button" onclick="feesCalculate()">Check Fees</button>

						</div>
					</div> -->



					<div>

						<input type="hidden" class="form-control"
							style="background-image: none;" id="superBuildUpArea"
							placeholder="" name="superBuildUpArea" value="" readonly
							required> <input type="hidden" name="forwardWorkflow">
						<input type="hidden" name="filesPath" id="filesPath" /> <input
							type="hidden" class="form-control"
							style="background-image: none;" id="noStandby" placeholder=""
							name="noStandby" value=""> <input type="hidden"
							name="totalFeess"> <input type="hidden"
							name="scrutinyFeesOnAboveTotal">





                            <div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

						<h6 class="mt-3">
							<strong style="font-size: 20px;"> List of Documents (Attachment) </strong>
						</h6>

						<div class="alert alert-info mb-0 p-2 ms-2">
							<small> <h7 style="font-size: 15px;"><strong>Note: </strong> Upload Below Files only
								pdf, etc.. (File Size Max upto 5MB)</h7> </small>
						</div>

                        </div>



                        <div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">
                            <div style="width: 33%;">
        <label for="" class="form-label">Form P Certificate 
            <span class="text-danger" style="color: red;">*</span>
            <a   onclick="downloadFile()">Download</a>
        </label>
        <input type="file" accept=".pdf" class="form-control" style="background-image: none;" id="doc1" placeholder="" name="formPCertificate" required>
        <div class="invalid-feedback">File selected is either greater than 5Mb or not of type .pdf.</div>
    </div>




						
							 <div style="width: 33%;">
								<label for="" class="form-label">NMC Tax Receipt Current
									Year <span class="text-danger" style="color: red;">*</span>
								</label> <input type="file" accept=".pdf" class="form-control"
									style="background-image: none;" id="doc2" placeholder=""
									name="taxReceipt" required>
								<div class="invalid-feedback">File selected is either
									greater than 5Mb or not of type .pdf.</div>
							</div>
					



						

                            <div style="width: 33%;">
								<label for="" class="form-label">Covering Letter of Sanctioning Authority<span
									class="text-danger" style="color: red;">*</span>
								</label> <input type="file" accept=".pdf" class="form-control"
									style="background-image: none;" id="doc4" placeholder=""
									name="coveringLetter" required>
								<div class="invalid-feedback">File selected is either
									greater than 5Mb or not of type .pdf.</div>
							</div>
        </div>
                            <div class="row" style="display: flex; width: 100%; margin-bottom: 0.1rem; height: 80px;">

                            <div style="width: 33%;">
								<label for="" class="form-label">Tentative Approval Fire Designing Proposed/Existing Building Plan<span
									class="text-danger" style="color: red;">*</span>
								</label> <input type="file" accept=".pdf" class="form-control"
									style="background-image: none;" id="doc3" placeholder=""
									name="buildingPlan" multiple required>
								<div class="invalid-feedback">File selected is either
									greater than 5Mb or not of type .pdf.</div>
							</div>



				</div>
					<div class="col-md-12">
						<div class="mb-5 mt-4 ">
							<div class="form-check">
								<input class="form-check-input" type="checkbox" id="check11"
									name="declaration" value="something" required> <label
									class="form-check-label ms-3 lbleng" style="margin-top: 0px;">
									<strong>Declaration <span class="text-danger"
										style="color: red;">*</span>:-
								</strong>I hereby declare that, all the information provided by me in the
									above application is true.If it found wrong or not related, I
									permit to reject the application.
								</label>
								<div class="invalid-feedback">Please check the
									declaration.</div>
							</div>
						</div>
					</div>
					

					<div class="col-md-12 text-start mb-5">
						<div class="text-center">
							<button type="button" class="btn btn-danger btn_sm printMe">
								View and Print</button>
							<button class="btn btn-success btn_sm" type="submit" id="submit">
								Submit</button>

						</div>
					</div>
				</div>
	</div>
	</div>
	


	</form>
</body>


</html>
<script>
function typeFloor(element) {

    var floorName = $(element).val();

    // find current row
    var currentRow = $(element).closest('tr');

    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath}/rtiapplication/floorType.do",
        data: {
            floorName: floorName
        },
        dataType: "json",
        success: function (data) {

            // target ONLY that row dropdown
            var dropdown = currentRow.find('.fireFloorTypes');

            dropdown.empty();
            dropdown.append('<option value="">--- Select---</option>');

            $.each(data.subTypeOfbuilding, function(index, item) {
                dropdown.append(
                    '<option value="' + item.subTypeOfBuildingId + '">' 
                    + item.subTypeOfBuildingName + 
                    '</option>'
                );
            });

        }
    });
}
</script>    
<script>
  
                        function feesCalculate() {
                            var superBuildUpArea = $("#superBuildUpArea").val();
                          //  var typeOfBuilding = $("#typeOfBuilding").val();
                            var typeOfConstruction = $("#typeOfConstruction").val();
                            var typeOfHeight = $("#typeOfHeight").val();
                            
                            var floorNamee = $('select[name="floorNamee[]"]').map(function() {
                                return $(this).val();
                            }).get();
                            
                            var commAreaValues = $('input[name="commAreaa[]"]').map(function() {
                                return $(this).val();
                            }).get();

                            var residAreaa = $('input[name="residAreaa[]"]').map(function() {
                                return $(this).val();
                            }).get();
                            
                            var primumArr = $('input[name="primumArr[]"]').map(function() {
                                return $(this).val();
                            }).get();

                            var otherUsee = $('input[name="otherUsee[]"]').map(function() {
                                return $(this).val();
                            }).get();

                            $.ajax({
                                type: "POST",
                                url: "${pageContext.request.contextPath}/rtiapplication/calculate.do",
                                data: {
                                    superBuildUpArea: superBuildUpArea,
                                    typeOfConstruction: typeOfConstruction,
                                    typeOfHeight: typeOfHeight,
                                    commAreaa: commAreaValues,
                                    residAreaa: residAreaa,
                                    otherUsee : otherUsee,
                                    primumArr : primumArr,
                                    floorNamee : floorNamee
                                },
                                dataType: "json",
                                success: function (data) {
                                	var rowWiseTotalFeesToBeShown = data.rowWiseTotalFeesToBeShown;
                                	for (var i = 0; i < rowWiseTotalFeesToBeShown.length; i++) {
                                	    $('[name="totalTabl[]"]').eq(i).val(rowWiseTotalFeesToBeShown[i]);
                                	}
                                	$('#grandTotal').text(data.grandTotal);
                                	$('#scrutinyFees').text(data.scrutinyFees);
           
                                },
                                error: function () {
                                  //  alert("Error occurred while calculating.");
                                }
                            });
                        }


                            $(function () {
                                var maxRows = 30;
                                var j = 1;
                            
                                $('#addMoree').on('click', function () {
                                    if (j < maxRows) {
                                        var data1 = $("#tb11 tr:eq(0)").clone(true).appendTo("#tb11");
                                        var data2 = $("#tb22 tr:eq(0)").clone(true).appendTo("#tb22");

                                        data1.find("input").val('');
                                        data2.find("input").val('');

                                        // strip duplicate ids from the new row, keep classes/names
                                        data1.find("[id]").removeAttr("id");
                                        data2.find("[id]").removeAttr("id");

                                        // reset dropdowns to the placeholder option so user must re-select
                                        data1.find("select").prop("selectedIndex", 0);
                                        data2.find("select").prop("selectedIndex", 0);

                                        var nameAttributes = [];
                                        $("#tb22 tr:eq(0) td input").each(function() {
                                            nameAttributes.push($(this).attr("name"));
                                        });
                                        data2.find("input").each(function(index) {
                                            $(this).attr("name", nameAttributes[index]);
                                        });

                                        j++;
                                        //updateSerialNumbers();
                                    } else {
                                        alert("You have reached the maximum number of rows allowed.");
                                        $('#addMoree').prop('disabled', true);
                                    }
                                });
                            
                                $('#tb11').on('click', '.removeLastt', function () {
                                    var rowCount = $('#tb11 tr').length;
                                    if (rowCount > 1) {
                                        var index = $(this).closest('tr').index();
                                        $('#tb11 tr:eq(' + index + '), #tb22 tr:eq(' + index + ')').remove();
                                        //updateSerialNumbers();
                                        j--;
                                        $('#addMoree').prop('disabled', false); // Enable the add button
                                    } else {
                                        alert("Sorry!! Can't remove the first row!");
                                    }
                                });
                            
                                // Input event to synchronize values between corresponding cells
                                $('#tb11').on('input', 'input[type="text"], input[type="number"], select', function () {
                                    var rowIndex = $(this).closest('tr').index();
                                    var columnIndex = $(this).closest('td').index();
                                    var value = $(this).val();
                                    $('#tb22 tr:eq(' + rowIndex + ') td:eq(' + columnIndex + ')').find('input, select').val(value);
                                });
                              
                            });
                            </script>
                      
                      
                      	<script type="text/javascript">

    
   $(document).ready(function () {
         var isUploadInProgress = false;
       $("#submit").click(function (event) {

           $("form:first").addClass("needs-validation");
           $("form:first").attr("novalidate", "");
           
           const forms = document.querySelectorAll('.needs-validation');
           
           Array.from(forms).forEach(form => {
               form.addEventListener('submit', event => {
                   var isFormValid = true;
                   
                   form.querySelectorAll('input[type="file"]').forEach(fileInput => {
                       if (fileInput.files.length > 0) {
                           var name = fileInput.files[0].name;
                           if (!(name.endsWith('.pdf'))) {
                               isFormValid = false;
                               fileInput.classList.remove('is-valid');
                               fileInput.classList.add('is-invalid');
                           } else if (fileInput.files[0].size >= 5000000) {
                               isFormValid = false;
                               fileInput.classList.remove('is-valid');
                               fileInput.classList.add('is-invalid');
                           } else {
                               fileInput.classList.remove('is-invalid');
                               fileInput.classList.add('is-valid');
                           }
                       }
                   });
                   
                   if (!form.checkValidity() || !isFormValid) {
                       event.preventDefault();
                       event.stopPropagation();
                   } else {
                      if (isUploadInProgress) {
                       return false;
                        }
                      isUploadInProgress = true;
                      upload(function(status) {
                      
                          if (status === true || status === 'true') {
                              $("#submit").attr("disabled", true);
                              onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveFireRecommendationLatter.do');
                          } 
                          
                          isUploadInProgress = false; 
                      });
                      
                   }
                   
                   form.classList.add('was-validated');
               }, false);
           });
       });
       
       $('input[type="file"],input,select,textarea').on('focusout', function () {
           var isFileAllowed = true;
           if(this.getAttribute("type")=== 'file'){
           var name = this.files[0].name;
           
           if ((this.files[0].size < 5000000) && !(name.endsWith('.pdf'))) {
               isFileAllowed = false;
           }
           }
           
           if (this.checkValidity() && isFileAllowed) {
               this.classList.remove('is-invalid');
               this.classList.add('is-valid');
           } else {
               this.classList.remove('is-valid');
               this.classList.add('is-invalid');
           }
       });
   });
   
       function upload(callback) {
           console.log("@@upoading@@");
           var url = window.location.href;
           var basePath = '${pageContext.getAttribute("UPLOAD_PATH")}';
           var filesPath = "";
           var data = new FormData();
           data.append('idProof1', $("#doc1").get(0).files[0]);
           data.append('idProof2', $("#doc2").get(0).files[0]);
           data.append('idProof3', $("#doc3").get(0).files[0]);
           data.append('idProof4', $("#doc4").get(0).files[0]);

           var isFileSelected = false
           const id = Math.floor(Math.random() * 9000) + 1000;
           var array_element = "";
           var file = $('input[type="file"]');
           for (var i = 0; i < file.length; i++) {
                  var array_element = file[i];
                  var element = array_element.value.split("\\");
                  var a = element[element.length-1];
                  const splitName = a.split(".pdf")[0].replaceAll(/[^a-zA-Z0-9]/g, ""); 
                  const value = splitName + ".pdf";
                   if(a==='' || a===undefined){
                      filesPath += "null" + ",";
                       isFileSelected = false;
               } else {
                   filesPath = filesPath + basePath + "FireRecommendationLatter/" + id + value + ","
                   isFileSelected = true;
               }
           }
         //  var a = filesPath.substring(0, filesPath.lastIndexOf(","));
         //  filesPath = filesPath.replace(/\s/g, "");
         //  $("#filesPath").val(filesPath);
           
           filesPath = filesPath.substring(0, filesPath.lastIndexOf(","));
           filesPath = filesPath.replace(/\s/g, "");
           $("#filesPath").val(filesPath);
           
           console.log(filesPath);

           $.ajax({
                url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadsFireRecommendation.do?id="+id,
               type: 'POST',
               data: data,
               cache: false,
               dataType: 'json',
               processData: false,
               contentType: false,
               async: false, // Set to synchronous
               success: function(data) {
                   var status = data.status;
                   if (callback && typeof callback === 'function' && status==true) {
                       callback(status);
                   }else if (status === false) {
                       alert("Something Went Wrong!!");
                   }
               },
               error: function(jqXHR, textStatus, errorThrown) {
                   console.error("AJAX Error:", textStatus, errorThrown);
                   if (callback && typeof callback === 'function') {
                       callback('error');
                   }
               }
           });

          
       }
   </script>


<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
    
<script src="https://code.jquery.com/jquery-3.6.1.js">
   
    </script>

<script type="text/javascript">
$('.printMe').on('click', function () {

    window.print();
});
</script>
<script type="text/javascript">     
       

        function downloadFile() {
            var contextRoot = "<c:out value='${contextRoot}'/>";
            var fileUrl = contextRoot + "/pages/citizendocument/FormP.pdf";
            var fileName = "Form4.pdf";

            var downloadLink = document.createElement("a");
            downloadLink.href = fileUrl;
            downloadLink.download = fileName;
            document.body.appendChild(downloadLink);
            downloadLink.click();
            document.body.removeChild(downloadLink);
        }

        
        $(document).ready(function(){

            //Validation:
            //before decimal -> max 4 digits
            //after decimal -> max 3 digits

            $(document).on("input",".areaValidation",function(){

                var value=$(this).val();

                // allow only digits and decimal
                value=value.replace(/[^0-9.]/g,'');

                // prevent multiple dots
                var parts=value.split('.');
                if(parts.length>2){
                    value=parts[0]+"."+parts[1];
                    parts=value.split('.');
                }

                // max 4 digits before decimal
                if(parts[0].length>4){
                    parts[0]=parts[0].substring(0,4);
                }

                // max 3 digits after decimal
                if(parts.length>1){
                    parts[1]=parts[1].substring(0,3);
                    value=parts[0]+"."+parts[1];
                }else{
                    value=parts[0];
                }

                $(this).val(value);

            });

        });

    </script>
    
    
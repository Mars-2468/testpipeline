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
<script src="Vjdog.js"></script>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript"
	src="<c:out value=" ${contextRoot}" />/scripts/jquery/jquery.ajaxfileupload.js"></script>
<link rel="stylesheet"
	href="<c:out value=" ${contextRoot}" />/pages/core-pages/nmc_user/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<c:out value=" ${contextRoot}" />/pages/core-pages/nmc_user/css/style2.css" />
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>
<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
	pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
	pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
	pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
	pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
	pageContext.setAttribute("UPLOAD_PATH", CoreConstants.UPLOAD_PATH);

	///pageContext.setAttribute("statusList", CommonUtils.getStatus());
%>



<style>

input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}
</style>

<style>

.prompt {
	background-color: #f2f2f2;
	border: 1px solid black;
	padding: 20px;
	margin: 10px;
}
</style>
<style>

@page {
  size: legal landscape; /* Landscape orientation for Legal size */
}
@media print {
  body {
    transform: scale(0.9); /* Adjust the scale factor as needed */
    transform-origin: center center;
  }

}

 @page {
     size: auto ;
     }
</style>


<form class="needs-validation" novalidate id="waterNewConnectionForm">
	<div class="container-fluid mt-2" style="width: 190vh">
		<input type="hidden" name="Token" value="xyz">
		<div class="printable">
			<h3 class="text-center">
				<strong>Application Form For New Water Connection (नवीन नळ जोडणी अर्ज)</strong>
			</h3>
		</div>
		<h6 style="background-color: #dce2e8; padding: 10px;"
			class="  rounded-2">
			<strong>Applicant Details (अर्जदाराचे तपशील)</strong>
		</h6>
		<div class="row">
	<input type="hidden" name="str" value="<c:out value='${str}'/>">
			<input type="hidden" name="serviceId" value="<c:out value='${serviceId}'/>">
			<input type="hidden" name="fields" value="<c:out value='${fields_aps}'/>">
			<input type="hidden" name="distric" value="<c:out value='${distric}'/>">
			<input type="hidden" name="trackid" value="<c:out value='${trackid}'/>">
			<input type="hidden" name="user" value="<c:out value='${user}'/>">
			<input type="hidden" name="mobile" value="<c:out value='${mobile}'/>">
			<input type="hidden" name="name" value="<c:out value='${name}'/>">
			<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label lbleng">Title (शीर्षक)<span class="text-danger" style="color: red;">*</span>
					</label> <select class="form-select" style="background-image: none;"
						name="title" required>
						<option value="">-Select-</option>
						<option value="Mr (श्री)">Mr (श्री)</option>
						<option value="Mrs (सौ)">Mrs (सौ)</option>
						<option value="Ms (कु)">Ms (कु)</option>
					</select>
					<div class="invalid-feedback">Please Select Title.</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label lbleng">Name (नाव)<span class="text-danger">*</span>
					</label> <input type="text" class="form-control"
						style="background-image: none;" id="first_name" placeholder=""
						name="firstName"  maxlength="40" value="" pattern="[A-Za-z]+"
						onchange="Display(this.id)" required>
					<div class="invalid-feedback">Please Enter Valid Name.
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label lbleng">Father's Name (वडिलांचे नाव)<span class="text-danger">*</span></label><input type="text" class="form-control"
						style="background-image: none;" id="middle_name" placeholder=""
						name="middleName" value="" pattern="[A-Za-z]+"
						onchange="Display(this.id)" required>
					<div class="invalid-feedback">Please Enter Valid Father's Name.
</div>

				</div>
			</div>

			<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label lbleng">Surname (आडनाव)<span
						class="text-danger" style="color: red;">*</span></label> <input
						type="text" class="form-control" style="background-image: none;"
						name="lastName" id="last_name" value=""maxlength="80" pattern="[A-Za-z]+"
						onchange="Display(this.id)" required>
					<div class="invalid-feedback">Please Enter Valid Surname.</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label">Full Name (संपूर्ण नाव)</label> <input
						type="text" class="form-control" style="background-image: none;"
						id="full_name" placeholder="" name="fullName" value="" readonly>
				</div>
			</div>

			<script>
                    function Display(id) {
                                  $('#full_name').val( $('#first_name').val()+" "+ $('#middle_name').val()+" "+ $('#last_name').val())
                            }
                    </script>





			<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label lbleng">Pin Code (पिन कोड)<span
						class="text-danger">*</span></label> <input type="text"
						class="form-control" style="background-image: none;"
						pattern="^(?!0{6}$)\d{6}$" name="pinCode" value="" maxlength="6" required>
					<div class="invalid-feedback">Please Enter Valid Pincode.</div>
				</div>
			</div>
			<!-- <div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label"> Aadhaar No. (आधार क्र.) </label>
					<input type="text" class="form-control "
						style="background-image: none;" id="aadhaarNumber1" placeholder=""
						name="aadhaarNo" value="" pattern="(?!0{12}$)[0-9]{12}}" maxlength="12">
					<div class="invalid-feedback">Please Enter Valid Aadhaar
						Number.</div>
				</div>
			</div>-->

			<div class="col-md-3">
				<div class="mb-3 mt-3">

					<label for="email" class="form-label lbleng"> Email Id (ई -
						मेल आयडी)<span class="text-danger">*</span>
					</label> <input type="email" class="form-control "
						style="background-image: none;" id="email" placeholder=""
						name="email" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}" value="" required>
					<div class="invalid-feedback">Please Enter Valid EmailId.</div>
				</div>
			</div>


			<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label"> Mobile No. (मोबाईल क्र.)<span
						class="text-danger" style="color: red;">*</span>
					</label> <input type="text" class="form-control "
						style="background-image: none;" id="txtMobileNumber"
						placeholder="" name="mobileNo" value="" pattern="[6-9]{1}[0-9]{9}"
						maxlength="10" required>
					<div class="invalid-feedback">Please Enter Valid Mobile
						Number.</div>
				</div>
			</div>
			<!-- <div class="col-md-12">
                            <div class="mb-3 mt-3">
                                <label for="" class="form-label ">Address For Correspondence (पत्रव्यवहारासाठी पत्ता)<span class="mand_error" style="color: red;"">*</span></label>
                                <textarea oninput="validateTextarea()" type=" text" maxlength="255" class="form-control"  style="background-image: none;" id="myTextarea" placeholder="" name="address" value="" rows="2" required></textarea>                           
                                <div class="invalid-feedback" id="errorFeedback">
                                    Please Enter Valid Address.
                                </div>
                            </div>
                        </div>-->


		<h6 style="background-color: #dce2e8; padding: 10px;"
			class=" mt-3 rounded-2">
			<strong>Application Form
                        Details (अर्जाचा तपशील)</strong>
		</h6>
		<div class="row">

			<div class="col-md-3">
    <div class="mb-3 mt-3">
        <label for="" class="form-label lbleng">House/Plot/Flat No.
            (घर/प्लॉट/फ्लॅट क्र.) <span class="text-danger">*</span>
        </label>
        <input type=" number" class="form-control" pattern="^\s*\S.*$"
							style="background-image: none;" id="plot_no" placeholder=""
							name="plotNo" value="" maxlength="255"
							onchange="change(this.id)" required>
       <div class="invalid-feedback">Please enter a valid Plot No.</div>
    </div>
</div>


			<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label lbleng">Name of Building
						(इमारतीचे नाव)</label> <input type="text" class="form-control"
						style="background-image: none;" id="buildingName" placeholder=""
					maxlength="80"	name="buildingName" value="">
					<div class="invalid-feedback">Please Enter Valid Building
						Name.</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label lbleng">Name Of Layout
						(लेआउटचे नाव)<span class="text-danger" style="color: red;">*</span>
					</label> <input type="text" class="form-control"
						style="background-image: none;" id="street_name" placeholder=""
						name="layoutName" value="" required>
					<div class="invalid-feedback">Please Enter Valid Layout Name.
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label lbleng">Name Of Road
						(रस्त्याचे नाव)
					</label> <input type="text" class="form-control"
						style="background-image: none;" id="areaName" placeholder=""
						name="roadName" value="" maxlength="80">

					<div class="invalid-feedback">Please Enter Valid Name Of
						Road.</div>
				</div>
			</div>



			<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label lbleng">Nearby Landmark
						(जवळील लँडमार्क)</label> <input type="text" class="form-control"
					maxlength="80"	style="background-image: none;" id="landmark" placeholder=""
						name="landmark" value="">
				</div>
			</div>
			<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label lbleng">City (शहर)<span
						class="text-danger" style="color: red;">*</span></label> 
						<input type="text" class="form-control"
					maxlength="80"	style="background-image: none;" id="city" placeholder=""
						name="city" pattern="[A-Za-z]+" value="Nagpur" required>
				</div>
			</div>




			<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label ">Zone No.(झोन क्र.)<span
						class="text-danger" style="color: red;" id="zone"">*</span>
					</label> <select class="form-select " style="background-image: none;" id=""
						name="zoneNo" required>
						 <option value="" selected="">-Select Zone-</option>
                                <option value="1">Zone No.1 - Laxmi Nagar (लक्ष्मी नगर)</option>
                                <option value="2">Zone No.2 - Dharmpeth (धरमपेठ)</option>
                                <option value="3">Zone No.3 - Hanuman Nagar (वंदनीय राष्ट्रसंत तुकडोजी महाराज)</option>
                                <option value="4">Zone No.4 - Dhantoli (धंतोली)</option>
                                <option value="5">Zone No.5 - Nehru Nagar (नेहरू नगर श्रेत्रिय कार्यालय)</option>
                                <option value="6">Zone No.6 - Gandhi Zone Mahal (गांधी झोन ​​महाल)</option>
                                <option value="7">Zone No.7 - Satranjipura (सतरंजीपुरा)</option>
                                <option value="8">Zone No.8 - Lakadganj (लकडगंज)</option>
                                <option value="9">Zone No.9 - Aashi Nagar (आशी नगर)</option>
                                <option value="10">Zone No.10 - Mangalwari (मंगळवारी)</option>
            

					</select>
					<div class="invalid-feedback">Please Enter Valid Zone No.</div>
				</div>
			</div>
<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label"> Alternate Mobile No. (पर्यायी मोबाईल क्र.)
					</label> <input type="text" class="form-control waterRequired "
						style="background-image: none;" id="contact_no"
						placeholder="" name="alterMobileNo"
						value=""
						pattern="[6-9]{1}[0-9]{9}" maxlength="10">
					<div class="invalid-feedback">Please Enter Valid Mobile No.</div>
				</div>
			</div>
			<div class="col-md-12">
    <div class="mb-3 mt-3">
        <label for="primary_full_address" class="form-label">Full Address (संपूर्ण पत्ता)&nbsp;&nbsp;
            (Same as above (वरील प्रमाणे)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" class="form-check-input" name="yes" id="yes" value="1" onclick="change()"> Yes (होय)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" class="form-check-input" name="yes" id="no" value="2" onclick="change()"> No (नाही)&nbsp;)<span class="text-danger">*</span></label>

        <textarea class="form-control" oninput="validateTextarea()" style="background-image: none;" rows="2" id="Address" name="address" required></textarea>
        <div class="invalid-feedback" id="errorFeedback">
            Please Enter Valid Address.
        </div>
    </div>
</div>

<script>
function change() {
    var isOperated = $("#yes").prop('checked');
    var addressParts = [];

    // Check each input field and add to the addressParts array if it has a value
    if ($("#plot_no").val()) {
        addressParts.push($("#plot_no").val());
    }

    if ($("#buildingName").val()) {
        addressParts.push($("#buildingName").val());
    }

    if ($("#street_name").val()) {
        addressParts.push($("#street_name").val());
    }

    if ($("#areaName").val()) {
        addressParts.push($("#areaName").val());
    }

    if ($("#landmark").val()) {
        addressParts.push($("#landmark").val());
    }

    if ($("#city").val()) {
        addressParts.push($("#city").val());
    }

    if ($("#pin_code").val()) {
        addressParts.push($("#pin_code").val());
    }

    // If "Yes" is selected, update the address textarea
    if (isOperated) {
        $("#Address").val(addressParts.join(','));
    } else {
        $("#Address").val("");
    }
}

function validateTextarea() {
    const textarea = document.getElementById('Address');
    const errorFeedback = document.getElementById('errorFeedback');
    const text = textarea.value;

    // Regular expression to check for leading spaces before the first letter
    const regex = /^\s*(\S)/;

    if (regex.test(text)) {
        textarea.classList.remove('is-invalid');
        errorFeedback.style.display = 'none';
    } else {
        textarea.classList.add('is-invalid');
        errorFeedback.style.display = 'block';
    }
}
</script>
                           
			<div class="row">

				<div class="col-md-4">
					<div class="mb-3 mt-4">
						<label for="" class="form-label lbleng">Purpose
								Of Water Connection (पाणी जोडणीचा उद्देश)<span
						class="text-danger" style="color: red;" id="zone">*</span></label>
					
					<select id="waterform" class="form-control" style="width: 263px; height: 35px; background-image: none;" name="purposeOfWater" required>

									<option value="" selected disabled>--- Select---</option>
									<c:forEach var="purposeOfWater" items="${requestScope.purposeOfWater}">
										<option value="${purposeOfWater.purposeName}">
											<c:out value="${purposeOfWater.purposeName}" />
										</option>
									</c:forEach>
								</select>
								
					
					<!-- <select class="form-select" style="background-image: none;"
						id="waterform" name="purposeOfWater" required>
						<option value="">-Select-</option>
						<option value="Residential (निवासी)">Residential (निवासी)</option>
						<option value="Slum (झोपडपट्टी)">Slum (झोपडपट्टी)</option>
						<option value="Flat Scheme (फ्लॅट योजना)">Flat Scheme (फ्लॅट योजना)</option>
						
						<option value="Institutional (संस्थात्मक)">Institutional
							(संस्थात्मक)</option>
						<option value="Commercial (व्यावसायिक)">Commercial
							(व्यावसायिक)</option>
					</select> -->
					<div class="invalid-feedback">Please Select Purpose of Water
						Connection.</div>
					</div>
<a class="fa fa-download" onClick="downloadFile()" style="color: blue; font-size: medium;">&nbsp;&nbsp;Refer the attachment for Purpose of connection</a>

				</div>

				<!-- <div class="col-md-3" id="d111">
					<div class="mb-3 mt-4">
						<label for="" class="form-label lbleng">Residential
							(निवासी)</label>
						<div class="form-check ms-3" id="radio1">
							<input type="radio" class="form-check-input" id="a111"
								name="residential" value="Flat (फ्लॅट)">Flat (फ्लॅट) <label
								class="form-check-label" for="radio1"></label>
						</div>


						<div class="form-check ms-3" id="d111_1">
							<input type="radio" class="form-check-input" id="a111_1"
								name="residential" value="House (घर)">House (घर) <label
								class="form-check-label" for="radio2"></label>
						</div>
					</div>
				</div>-->

				<div class="col-md-5" id="x">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Slum</label>
						<div class="form-check ms-3" id="radio1">
							<input type="radio" class="form-check-input" id="x1"
								value="Hut(House without concreter roof) (झोपडी (काँक्रीटच्या छताशिवाय घर))" name="slum" required>Hut(House without
							concreter roof) (झोपडी (काँक्रीटच्या छताशिवाय घर)) <label
								class="form-check-label" for="radio1"></label>
						</div>

						<div class="form-check ms-3" id="d112_1">
							<input type="radio" class="form-check-input" 
								id="x2" value="House with Solid Construction Upto 500 sq.ft. (घन सह 500 चौ.फूट पर्यंत बांधकाम)" name="slum" required>House with
							Solid Construction Upto 500 sq.ft. (घन सह 500 चौ.फूट पर्यंत
							बांधकाम) <label class="form-check-label" for="radio2"></label>
						</div>
						<div class="form-check ms-3" id="d112_2">
							<input type="radio" class="form-check-input" value="House with Solid Construction Above 500 sq.ft. (500 चौ.फूट वरील ठोस बांधकाम असलेले घर.)" id="x3" name="slum" required>House with Solid
							Construction Above 500 sq.ft. (500 चौ.फूट वरील ठोस बांधकाम असलेले
							घर.) <label class="form-check-label" for="radio3"></label>
						</div>

					</div>
				</div>

		 	<div class="col-md-3" id="tp">
					<div class="mb-3 mt-4">
					<label for="" class="form-label lbleng">Tap Size (टॅप आकार)<span
						class="text-danger">*</span>
					</label> 
					
					
										<select id="tip" class="form-control" style="width: 263px; height: 35px; background-image: none;" name="tapSize" required>

									<option value="" selected disabled>--- Select---</option>
									<c:forEach var="tapSize" items="${requestScope.tapSize}">
										<option value="${tapSize.tapSizeNameValue}">
											<c:out value="${tapSize.tapSizeNameValue}" />
										</option>
									</c:forEach>
								</select>
					
					<!-- <select class="form-select waterRequired"
						style="background-image: none;" id="tip" name="newtapSize"
						 required> 
						<option value="">-Select-</option>
						<option value="15mm.">15mm.</option>
						<option value="20mm.">20mm.</option>
						<option value="25mm.">25mm.</option>
						<option value="40mm.">40mm.</option>
					    <option value="50mm.">50mm.</option>
						<option value="80mm.">80mm.</option>
						<option value="150mm.">150mm.</option>												
						<option value="100mm.">100mm.</option>
						<option value="200mm.">200mm.</option>
						<option value="250mm.">250mm.</option>
						<option value="300mm.">300mm.</option>
						
					</select>-->
					<div class="invalid-feedback">Please Select Valid Tap Size.</div>
				</div>
			</div>
			<div class="col-md-5" id="y">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Proposed Category for Institutional</label>
						<div class="form-check ms-3" id="radio1">
							<input type="radio" class="form-check-input"  id="y1"
								value="IA (Institutional A)" name="instCategory" required>IA (Institutional A) <label
								class="form-check-label" for="radio1"></label>
						</div>

						<div class="form-check ms-3" id="d112_1">
							<input type="radio" class="form-check-input"
								id="y2" value="IB (Institutional B)" name="instCategory" required>IB (Institutional B)<label class="form-check-label" for="radio2"></label>
						</div>
						
					</div>
				</div>
				<div class="col-md-5" id="z">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Proposed Category for Commercial</label>
						<div class="form-check ms-3" id="radio1">
							<input type="radio" class="form-check-input"  id="z1"
								value="C1A (Commercial A)" name="commCategory" required>C1A (Commercial A) <label
								class="form-check-label" for="radio1"></label>
						</div>

						<div class="form-check ms-3" id="d112_1">
							<input type="radio" class="form-check-input"
								id="z2" value="C1B (Commercial B)" name="commCategory" required>C1B (Commercial B)
						 <label class="form-check-label" for="radio2"></label>
						</div>
						<div class="form-check ms-3" id="d112_2">
							<input type="radio" class="form-check-input"  value="C2 (Commercial 2)"
								id="z3" name="commCategory" required>C2 (Commercial 2) <label class="form-check-label" for="radio3"></label>
						</div>

					</div>
				</div>
		


		<div class="col-md-3" id="p">
    <div class="mb-3 mt-4">
        <label for="" class="form-label"> Total number of Flats (फ्लॅटची एकूण संख्या)
            <span class="text-danger" style="color: red;" required>*</span>
        </label>
        <input type="text" class="form-control" style="background-image: none;" id="p1" placeholder=""
            name="totalPlotNo" value="" oninput="validateNumber(this)" required>
        <div class="invalid-feedback">Please enter a valid Total number of Flats.</div>
    </div>
</div>

<script>
    function validateNumber(input) {
        // Remove non-numeric characters
        input.value = input.value.replace(/\D/g, '');

        // Check if the value is not all zeros or starts with zero
        if (/^0+$/.test(input.value) || input.value.startsWith('0')) {
            input.setCustomValidity("Invalid value");
        } else {
            input.setCustomValidity("");
        }

        // Limit input to three digits
        if (input.value.length > 3) {
            input.value = input.value.slice(0, 3);
        }
    }
</script>
		



				<!--  <label id="d116" for="" style="margin-top: 30px;" class="form-label lbleng"> <strong>Group
						Housing Apartment with One Group Connection(With Mixed Use) (एका
						गटासह ग्रुप हाउसिंग अपार्टमेंट कनेक्शन (मिश्र वापरासह))</strong></label>
				<div class="col-md-6" id="d116_3">
					<div class="mb-3 mt-3">

						<div class="form-check ms-3" id="">
							<input type="checkbox" class="form-check-input check1" id="a116"
								name="groupHousingApartment" onchange="s4()"
								value="Total number of Residental Flat/Tenement/Dwelling Unit (निवासी सदनिका/निवासी/निवासी युनिटची एकूण संख्या)">Total
							number of Residental Flat/Tenement/Dwelling Unit (निवासी
							सदनिका/निवासी/निवासी युनिटची एकूण संख्या) <label
								class="form-check-label" for="a116"></label>
						</div>

						<div class="form-check ms-3">
							<input type="checkbox" class="form-check-input check2"
								id="a116_1" name="groupHousingApartment" onchange="s4()"
								value="Total number of Non Residential units where water is not to be used for Business (व्यवसायासाठी पाणी वापरले जाणार नाही अशा अनिवासी युनिट्सची एकूण संख्या)">Total
							number of Non Residential units where water is not to be used for
							Business (व्यवसायासाठी पाणी वापरले जाणार नाही अशा अनिवासी
							युनिट्सची एकूण संख्या) <label class="form-check-label"
								for="a116_1"></label>
						</div>


						<div class="form-check ms-3">
							<input type="checkbox" class="form-check-input check3"
								id="a116_2" name="groupHousingApartment" onchange="s4()"
								value="Total number of Non Residential units where water is to be used for Business (व्यवसायासाठी पाणी वापरल्या जाणार्‍या अनिवासी युनिटची एकूण संख्या)">Total
							number of Non Residential units where water is to be used for
							Business (व्यवसायासाठी पाणी वापरल्या जाणार्‍या अनिवासी युनिटची
							एकूण संख्या) <label class="form-check-label" for="a116_2"></label>
						</div>




					</div>
				</div>
				<br>


				<div class="row">
					<div class="col-md-4" id="dcal1">
						<div class="mb-3" style="margin-top:41px;">
							<label for="" class="form-label"> Total number of
								Residental Flat/Tenement/Dwelling Unit (निवासी
								सदनिका/निवासी/निवासी युनिटची एकूण संख्या)<span
								class="text-danger" style="color: red;" required>*</span>
							</label> <input id="cal1" type="number" class="form-control"
								style="background-image: none;" placeholder=""
								name="totalNumberOfResidentialFlats" value="" required="true">
						</div>
					</div>
					<div class="col-md-4" id="dcal2">
						<div class="mb-3 mt-3">
							<label for="" class="form-label"> Total number of Non
								Residential units where water is not to be used for Business
								(व्यवसायासाठी पाणी वापरले जाणार नाही अशा अनिवासी युनिट्सची एकूण
								संख्या)<span class="text-danger" style="color: red;" required>*</span>
							</label> <input id="cal2" type="number" class="form-control"
								style="background-image: none;" placeholder=""
								name="totalNoResidentialUnitsNotUsed" value="" required="true">
						</div>
					</div>
					<div class="col-md-4" id="dcal3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label"> Total number of Non
								Residential units where water is to be used for Business
								(व्यवसायासाठी पाणी वापरल्या जाणार्‍या अनिवासी युनिटची एकूण
								संख्या)<span class="text-danger" style="color: red;" required>*</span>
							</label> <input id="cal3" type="number" class="form-control"
								style="background-image: none;" placeholder=""
								name="totalNoResidentialUnitsUsed" value="" required="true">
						</div>
					</div>


					<div class="col-md-4" id="d120">
						<div class="mb-3" style="margin-top: 40px;">
							<label for="" class="form-label"> Total number of Flats
								used for Business (व्यवसायासाठी वापरलेल्या फ्लॅटची एकूण संख्या)<span
								class="text-danger"></span>
							</label> <input id="sum4" value="0" type="number" class="form-control"
								style="background-image: none;" placeholder=""
								name="total_no_residential_units" readonly value=""
								required="true">
						</div>
					</div>

				</div>-->



				<!-- <script>
    
    $(function () {
        console.log("hi");
            $("#cal1, #cal2, #cal3").on("input", sum);
            function sum() {
               $("#sum4").val(Number($("#cal1").val() ) + Number($("#cal2").val() )+Number($("#cal3").val() ));
            }
        });  
    </script> -->





<br>
				<div class="row">

					<h6 style="background-color: white; padding: 5px;"
						class="mt-1 rounded-2 ms-2">
						<strong> List of Documents (with attachment)(कागदपत्रांची
							यादी (संलग्नकांसह))</strong>
					</h6>
					<div class="alert alert-info mb-2 p-2 mb-4 ms-2">
						<small class="form-label "><strong class="form-label ">Note(नोंद):
						</strong> Upload below files in .pdf(खालील फाइल .pdf मध्ये
							अपलोड करा.)</small>
					</div>

					<input type="hidden" name="filesPath" id="filesPath" />
					<div class="row">
						<div class="col-md-3" id="d1">
							<div class="mb-3 mt-0">
								<label for="" class="form-label">  Self-Attested Applicant's ID
									Proof(Aadhaar/PAN/Driving License/Passport)(स्वयं-साक्षांकित अर्जदाराचा ओळखपत्र
									पुरावा (आधार/पॅन/ड्रायव्हिंग लायसन्स/पासपोर्ट))<span
									class="text-danger" style="color: red;" required>*</span>
								</label> <input type="file" class="form-control"
									style="background-image: none;" accept=".pdf" id="a1" placeholder=""
									name="applicantIdProof" required="true">
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>

							</div>
						</div>
						<div class="col-md-3" id="d3">
							<div class="mb-3" style="margin-top:23px;">
								<label for="" class="form-label">Copy Of Tax Receipt/Rent Agreement/Consent Letter of Owner(कर पावती/भाडे करार/मालकाच्या संमती पत्राची प्रत)<span class="text-danger" style="color: red;"
									required>*</span>
								</label> <input type="file" class="form-control"
									style="background-image: none;" accept=".pdf" id="a3" placeholder=""
									name="currentBill" required="true">
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>

							</div>
						</div>
						<!-- </div>
        <br>
        <div id="f2" class="row"> -->
						<!-- <label for="" class="form-label lbleng" style="font-size: 17px;"><strong>Residential</strong></label> -->
						<div class="col-md-3" id="d4">
							<div class="mb-3" style="margin-top:70px;">
								<label for="" class="form-label"> Registry/Sale/Lease Deed(नोंदणी/विक्री/लीज करारपत्र)<span class="text-danger"
									style="color: red;" required>*</span>
								</label> <input type="file" class="form-control"
									style="background-image: none;" accept=".pdf" id="a4" placeholder=""
									name="registrySaleDeed" required="true">
								<div class="invalid-feedback">File selected is either
									greater than 5Mb or not of type .pdf.</div>

							</div>
						</div>
						<!-- <div class="col-md-3" id="d4">
							<div class="mb-3" style="margin-top:69px;">
								<label for="" class="form-label"> Photographs(Passport
									Size) (छायाचित्रे (पासपोर्ट आकार))<span class="text-danger"
									style="color: red;" required>*</span>
								</label> <input type="file" class="form-control"
									style="background-image: none;" accept=".pdf" id="a4" placeholder=""
									name="photographs" required="true">
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>

							</div>
						</div>-->
						<!-- </div>
<br>
<div  id="f3" class="row"> -->
						<!-- <label for="" class="form-label lbleng" style="font-size: 17px;"><strong>Slum</strong></label> -->
						<div class="col-md-3" id="d5">
							<div class="mb-3" style="margin-top:23px;">
								<label for="" class="form-label"> Slum Certificate Slum Photo Pass/Kabja Patra(Possession Certificate)(झोपडपट्टी प्रमाणपत्र झोपडपट्टी फोटो पास/कबजा पत्र (ताबा प्रमाणपत्र))
								</label> <input type="file" class="form-control"
									style="background-image: none;" accept=".pdf" id="a5" placeholder=""
									name="slumCertificate">
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>

							</div>
						</div>
						<div class="col-md-3" id="d6">
							<div class="mb-3" style="margin-top:93px;">
								<label for="" class="form-label"> Copy Of Tax Receipt (कर पावतीची प्रत)<span
									class="text-danger" style="color: red;" required>*</span>
								</label> <input type="file" class="form-control"
									style="background-image: none;" accept=".pdf" id="a6" placeholder=""
									name="kabjaPatra" required="true">
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>

							</div>
						</div>
						<!--  <div class="col-md-3" id="d7">
							<div class="mb-3" style="margin-top:70px;">
								<label for="" class="form-label">Photographs(Passport
									Size)(छायाचित्रे (पासपोर्ट आकार))<span class="text-danger"
									style="color: red;" required>*</span>
								</label> <input type="file" class="form-control"
									style="background-image: none;" accept=".pdf" id="a7" placeholder=""
									name="photographs1" required="true">
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>
							</div>
						</div>-->
						<!-- </div>
<br>
<div id="f4" class="row"> -->
						<!-- <label for="" class="form-label lbleng" style="font-size: 17px;"><strong>Commercial/Institutional</strong></label> -->
						<div class="col-md-3" id="d12">
							<div class="mb-3" style="margin-top:46px;">
								<label for="" class="form-label"> Registry/Sale Deed/Agreement of Rent/Consent Letter of Owner(नोंदणी/विक्री करार/मालकाच्या संमती पत्राची प्रत)<span class="text-danger"
									style="color: red;" required>*</span>
								</label> <input type="file" class="form-control"
									style="background-image: none;" accept=".pdf" id="a12" placeholder=""
									name="registrySaleDeed1" required="true">
								<div class="invalid-feedback">File selected is either
									greater than 5Mb or not of type .pdf.</div>

							</div>
						</div>
						<div class="col-md-3" id="d13">
							<div class="mb-3" style="margin-top:45px;">
								<label for="" class="form-label"> Gumasta
									License/Licenses For Running Business (गुमास्ता परवाना/व्यवसाय
									चालवण्यासाठी परवाने)<span class="text-danger"
									style="color: red;" required>*</span>
								</label> <input type="file" class="form-control"
									style="background-image: none;" accept=".pdf" id="a13" placeholder=""
									name="gumastaLicense" required="true">
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>

							</div>
						</div>
						<!-- <div class="col-md-3" id="d10">
							<div class="mb-3" style="margin-top:91px;">
								<label for="" class="form-label">Copy Of Tax Receipt (कर पावतीची प्रत)<span class="text-danger inst"
									style="color: red;" required>*</span>
								</label> <input type="file" class="form-control"
									style="background-image: none;" accept=".pdf" id="a10" placeholder=""
									name="sanctionedBuildingPlan" required="true">
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>

							</div>
						</div>
						<div class="col-md-3" id="d11">
							<div class="mb-3" style="margin-top: 40px;">
								<label for="" class="form-label"> Photographs(Passport
									Size)(छायाचित्रे (पासपोर्ट आकार))<span class="text-danger"
									style="color: red;" required>*</span>
								</label> <input type="file" class="form-control"
									style="background-image: none;" accept=".pdf" id="a11" placeholder=""
									name="photographs2" required="true">
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>

							</div>
						</div>
						<!-- </div>
<br>
<div id="f5" class="row"> -->
						<!-- <label for="" class="form-label lbleng" style="font-size: 17px;"><strong>Apartments/Flat Scheme</strong></label> -->

						<div class="col-md-3" id="d7">
							<div class="mb-3" style="margin-top:95px;">
								<label for="" class="form-label">Registry/Sale Deed
									(नोंदणी/विक्री करार)
								</label> <input type="file" class="form-control"
									style="background-image: none;" accept=".pdf" id="a7" placeholder=""
									name="registrySaleDeed2">
								<div class="invalid-feedback">File selected is either
									greater than 5Mb or not of type .pdf.</div>

							</div>
						</div>
						<div class="col-md-3" id="d8">
							<div class="mb-3" style="margin-top:45px;">
								<label for="" class="form-label"> 
								Consent Letter From Flat Owners/Builder Application(Details of Flats)(फ्लॅट मालकांचे संमती पत्र)<span class="text-danger" style="color: red;">*</span>
								
							
								</label> <input type="file" class="form-control"
									style="background-image: none;" accept=".pdf" id="a8" placeholder=""
									name="consentLetter" required="true">
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>

							</div>
						</div>
						<div class="col-md-3" id="d9">
							<div class="mb-3" style="margin-top:4px;">
								<label for="" class="form-label"> DOD Deed Of
									Declaration (डीओडी डीड ऑफ डिक्लेरेशन)
								</label> <input type="file" class="form-control"
									style="background-image: none;" accept=".pdf" id="a9" placeholder=""
									name="dod" >
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>

							</div>
						</div>
						<div class="col-md-3" id="d10">
							<div class="mb-3" style="margin-top:4px;">
								<label for="" class="form-label">NMC/NIT Building
									Sanction Plan (NMC/NIT इमारत मंजुरी योजना)<span
									class="text-danger" style="color: red;" required>*</span>
								</label> <input type="file" class="form-control"
									style="background-image: none;" accept=".pdf" id="a10" placeholder=""
									name="nmcNit" required="true">
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>

							</div>
						</div>
						<div class="col-md-3" id="d11">
							<div class="mb-3 mt-1">
								<label for="" class="form-label">Architect Completion
									Certificate (आर्किटेक्ट पूर्णत्व प्रमाणपत्र)<span
									class="text-danger" style="color: red;" required>*</span>
								</label> <input type="file" class="form-control"
									style="background-image: none;" accept=".pdf" id="a11" placeholder=""
									name="architectCompletionCertificate" required="true">
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>
							</div>
						</div>
						<!-- <div class="col-md-3" id="d17">
							<div class="mb-3" style="margin-top:29px;">
								<label for="" class="form-label">Copy Of Tax Receipt (कर पावतीची प्रत) <span
									class="text-danger" style="color: red;" required>*</span>
								</label> <input type="file" class="form-control"
									style="background-image: none;" accept=".pdf" id="a17" placeholder=""
									name="buildersApplication" required="true">
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>
							</div>
						</div>-->
						<div class="col-md-3" id="d2">
							<div class="mb-3 mt-1">
								<label for="" class="form-label">Photographs(Passport
									Size)(छायाचित्रे (पासपोर्ट आकार))<span class="text-danger"
									style="color: red;" required>*</span>
								</label> <input type="file" class="form-control"
									style="background-image: none;" accept=".pdf" id="a2" placeholder=""
									name="photographs3" required="true">
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>
							</div>
						</div>
					<!-- <div class="col-md-3">
						<div class="mb-3" style="margin-top: 71px;">

							<label class="form-label lbleng">Any other Supporting document
								(इतर कोणतेही सहाय्यक दस्तऐवज)
							</label> <input type="file" class="form-control waterRequired "
								accept=".jsp" style="background-image: none;" id="a19"
								placeholder="" name="signatureOfConsumer" >
							<div class="invalid-feedback">File selected is either
								greater than 2Mb or not of type .pdf.</div>
						</div>
					</div>
-->
					</div>
					<br>							<div class="form-group">
    <label for="agreementPdf" class="control-label" style="    color: chocolate;
    font-weight: bold;">
        <i class="far fa-file-pdf mr-2"></i> Refer attached PDF: Agreement for Supply of Water.&nbsp;&nbsp;<a class="fa fa-download" onClick="downloadAgreementFile()" style="color: blue; font-size: medium;"></a>
        
    </label>
    <div class="d-flex align-items-center">
            <input type="text" class="form-control mr-3" style="font-family: serif;" id="agreementPdf" name="agreementPdf" value="Note: Keep it ready before Site inspection for further processing." readonly>
    </div>
    
</div>
					<div class="col-md-12">
						<div class="mb-5 mt-4">
							<div class="form-check">
								<input class="form-check-input" type="checkbox" id="check11"
									name="declaration" value="something" required> <label
									class="form-check-label ms-3 lbleng" style="margin-top: -1px;">
									<strong>Declaration (घोषणा)<span class="text-danger"
										style="color: red;">*</span>:-
								</strong>The above mentioned information is true to the best of my
									knowledge and belief. (वर नमूद केलेली माहिती माझ्या माहितीनुसार
									आणि विश्वासानुसार खरी आहे).
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
							<button class="btn btn-success btn_sm" type="submit" id="submit"
								>Submit</button>
						</div>
					</div>
				</div>
</form>
</body>

<script>
    function downloadAgreementFile() {
        var fileUrl = "<c:out value="${contextRoot}"/>/pages/citizendocument/Agreement.pdf";
        var fileName = "Agreement.pdf";
        
        var downloadLink = document.createElement("a");
        downloadLink.href = fileUrl;
        downloadLink.download = fileName;
        document.body.appendChild(downloadLink);
        downloadLink.click();
        document.body.removeChild(downloadLink);
    }
</script>
<script>
function a(event) {
var char = event.which;
if (char > 31 && char != 32 && (char < 65 || char > 90) && (char < 97 || char > 123)) {
return false;
}
}
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script type="text/javascript">

</script>
<script>

$(document).ready(function() {
    // Function to hide and disable elements
    var hideAndDisable = function(elements) {
        elements.forEach(function(id) {
            $(id).hide();
            $(id.replace("#d", "#a")).prop('required', false);
        });
    };

    // List of elements to hide and disable initially
    var elements = ["#d3", "#d4", "#d5", "#d6", "#d7", "#d8", "#d9", "#d10", "#d11", "#d12", "#d13",
                    "#a3", "#a4", "#a5", "#a6", "#a7", "#a8", "#a9", "#a10", "#a11", "#a12", "#a13",
                    "#x", "#x1", "#x2", "#x3", "#y", "#y1", "#y2", "#z", "#z1", "#z2", "#z3", "#p", "#p1"];

    hideAndDisable(elements);

    // Show initial elements and make them required
    $("#d1, #d2, #a1, #a2, #tip, #tp").show();
    $("#a1, #a2, #tip").prop('required', true);

    $("#d2 .mb-3").css("margin-top", "70px");  // Add the margin-top

    // Handle form change event
    $("#waterform").change(function () {
        var select = this.value;
        // Hide and disable all elements first
        hideAndDisable(elements);
        
        if (select == 'Residential (निवासी)') {
            $("#d3, #d4, #a3, #a4").show();
            $("#a3, #a4").prop('required', true);
            $("#a5, #a6, #a7, #a8, #a9, #a10, #a11, #a12, #a13").prop('required', false);

            $("#d2 .mb-3").css("margin-top", "70px");  // Ensure margin-top is added

        } else if (select == 'Slum (झोपडपट्टी)') {
            $("#d5, #d6, #a5, #a6, #x, #x1, #x2, #x3").show();
            $("#a6, #x, #x1, #x2, #x3").prop('required', true);
            $("#a5, #a3, #a4, #a7, #a8, #a9, #a10, #a11, #a12, #a13").prop('required', false);

            $("#d2 .mb-3").css("margin-top", "70px");  // Ensure margin-top is added

        } else if (select == 'Flat Scheme (फ्लॅट योजना)') {
            $("#d6, #d7, #d8, #d9, #d10, #d11, #a6, #a7, #a8, #a9, #a10, #a11, #p, #p1").show();
            $("#a6, #a8, #a10, #a11, #p, #p1").prop('required', true);
            
            $("#a5, #a7, #a3, #a9, #a4, #a12, #a13").prop('required', false);

            $("#d2 .mb-3").css("margin-top", "");  // Remove the margin-top

        } else if (select == 'Institutional (संस्थात्मक)') {
            $("#d6, #d12, #d13, #a6, #a12, #a13, #y, #y1, #y2").show();
            $("#a6, #a12, #a13, #y, #y1, #y2").prop('required', true);
            $("#a5, #a3, #a4, #a7, #a8, #a9, #a10, #a11").prop('required', false);

            $("#d2 .mb-3").css("margin-top", "");  // Remove the margin-top

        } else if (select == 'Commercial (व्यावसायिक)') {
            $("#d6, #d12, #d13, #a6, #a12, #a13, #z, #z1, #z2, #z3").show();
            $("#a6, #a12, #a13, #z, #z1, #z2, #z3").prop('required', true);
            
            $("#a5, #a3, #a4, #a7, #a8, #a9, #a10, #a11").prop('required', false);

            $("#d2 .mb-3").css("margin-top", "");  // Remove the margin-top
        }
    });
});


let input1;

// function s1(){

//     if($('.check1').prop('checked')){

//   document.getElementById('cal1').style.display ="block";
//    document.getElementById('sum4').style.display ="block";

//   $(function () {
//                         console.log("hi");
//                             $("#cal1, #cal2, #cal3").on("input", sum);
//                             function sum() {
//                                $("#sum4").val(Number($("#cal1").val() ) + Number($("#cal2").val() )+Number($("#cal3").val() ));
//                             }
//             });
//     }
//   else if(!$('.check1').is(":checked")){

//   $(function () {
//                         console.log("hi");
//                             $("#cal1, #cal2, #cal3").on("input", sum);
//                             function sum() {
//                                $("#sum4").val( Number($("#cal2").val() )+Number($("#cal3").val() ));
//                             }
//             });
//             document.getElementById('cal1').style.display ="none";
//             $("#sum4").val( Number($("#cal2").val() )+Number($("#cal3").val() ));


// }



// }
// function s2(){

//     if($('.check2').is(":checked")){
//   document.getElementById('cal2').style.display = 'block';
//    document.getElementById('sum4').style.display = 'block';
//    $(function () {
//                         console.log("hi");
//                             $("#cal1, #cal2, #cal3").on("input", sum);
//                             function sum() {
//                                $("#sum4").val(Number($("#cal1").val() ) + Number($("#cal2").val() )+Number($("#cal3").val() ));
//                             }
//                         });  

//     }
//   else if(!$('.check2').is(":checked")){

//   $(function () {
//                         console.log("hi");
//                             $("#cal1, #cal2, #cal3").on("input", sum);
//                             function sum() {
//                                $("#sum4").val(Number($("#cal1").val() ) + Number($("#cal3").val() ));
//                             }
//                         });  
//                         document.getElementById('cal2').style.display ="none";
//                         $("#sum4").val(Number($("#cal1").val() ) + Number($("#cal3").val() ));


// }




// }
// function s3(){

//     if($('.check3').is(":checked")){
//   document.getElementById('cal3').style.display ='block';
//   document.getElementById('sum4').style.display ='block';
//   $(function () {
//                         console.log("hi");
//                             $("#cal1, #cal2, #cal3").on("input", sum);
//                             function sum() {
//                                $("#sum4").val(Number($("#cal1").val() ) + Number($("#cal2").val() )+Number($("#cal3").val() ));
//                             }
//                         });  
//     }
//   else if(!$('.check3').is(":checked"))
//   {

//   $(function () {
//                             $("#cal1, #cal2, #cal3").on("input", sum);
//                             function sum() {
//                                $("#sum4").val(Number($("#cal1").val() ) + Number($("#cal2").val() ));
//                             }
//                         });  
//                         document.getElementById('cal3').style.display ="none";
//                          $("#sum4").val(Number($("#cal1").val() ) + Number($("#cal2").val() ));

// 	}


// }
function s4()
{
console.log("dddddd");
if(!$('.check3').is(":checked")&&!$('.check2').is(":checked")&&!$('.check1').is(":checked"))
{
document.getElementById('dcal3').style.display ="none";
document.getElementById('dcal2').style.display ="none";
document.getElementById('dcal1').style.display ="none";
document.getElementById('d120').style.display ="none";

}
else if($('.check3').is(":checked")&&$('.check2').is(":checked")&&$('.check1').is(":checked"))
{
document.getElementById('dcal3').style.display ="block";
document.getElementById('dcal2').style.display ="block";
document.getElementById('dcal1').style.display ="block";
document.getElementById('d120').style.display ="block";
document.getElementById('cal3').style.display ="block";
document.getElementById('cal2').style.display ="block";
document.getElementById('cal1').style.display ="block";
document.getElementById('sum4').style.display ="block";
$("#sum4").val(Number($("#cal1").val() ) + Number($("#cal2").val() )+Number($("#cal3").val() ));
$(function () {
            $("#cal1, #cal2, #cal3").on("input", sum);
            function sum() {
                $("#sum4").val(Number($("#cal1").val() ) + Number($("#cal2").val() )+Number($("#cal3").val() ));
            }
        });  



}
else if(!$('.check3').is(":checked")&&!$('.check2').is(":checked"))
{
document.getElementById('dcal3').style.display ="none";
document.getElementById('dcal2').style.display ="none";
document.getElementById('dcal1').style.display ="block";
document.getElementById('d120').style.display ="block";
document.getElementById('cal1').style.display ="block";
document.getElementById('sum4').style.display ="block";
$("#sum4").val( Number($("#cal1").val() )); 

$(function () {
            $("#cal1").on("input", sum);
            function sum() {
                $("#sum4").val( Number($("#cal1").val() ));                            }
        });  

}
else if(!$('.check3').is(":checked")&&!$('.check1').is(":checked"))
{
document.getElementById('dcal3').style.display ="none";
document.getElementById('dcal2').style.display ="block";
document.getElementById('cal2').style.display ="block";
document.getElementById('dcal1').style.display ="none";
document.getElementById('d120').style.display ="block";
document.getElementById('sum4').style.display ="block";


$("#sum4").val( Number($("#cal2").val() )); 

$(function () {
            $("#cal2").on("input", sum);
            function sum() {
                $("#sum4").val( Number($("#cal2").val() ));                            }
        });  
}
else if(!$('.check1').is(":checked")&&!$('.check2').is(":checked"))
{
document.getElementById('dcal3').style.display ="block";
document.getElementById('cal3').style.display ="block";
document.getElementById('dcal2').style.display ="none";
document.getElementById('dcal1').style.display ="none";
document.getElementById('d120').style.display ="block";
document.getElementById('sum4').style.display ="block";
$("#sum4").val( Number($("#cal3").val() ));   

$(function () {
            $("#cal3").on("input", sum);
            function sum() {
                $("#sum4").val( Number($("#cal3").val() ));                            }
        });  
}
// ===============
else if($('.check3').is(":checked")&&$('.check2').is(":checked"))
{
document.getElementById('dcal3').style.display ="block";
document.getElementById('dcal2').style.display ="block";
document.getElementById('cal3').style.display ="block";
document.getElementById('cal2').style.display ="block";
document.getElementById('dcal1').style.display ="none";
document.getElementById('d120').style.display ="block";
document.getElementById('sum4').style.display ="block";

$("#sum4").val( Number($("#cal2").val() )+Number($("#cal3").val() ));

$(function () {
            $("#cal2, #cal3").on("input", sum);
            function sum() {
                $("#sum4").val( Number($("#cal2").val() )+Number($("#cal3").val() ));
                               }
        });  

}
else if($('.check3').is(":checked")&&$('.check1').is(":checked"))
{
document.getElementById('dcal3').style.display ="block";
document.getElementById('cal3').style.display ="block";
document.getElementById('dcal2').style.display ="none";
document.getElementById('dcal1').style.display ="block";
document.getElementById('cal1').style.display ="block";
document.getElementById('d120').style.display ="block";
document.getElementById('sum4').style.display ="block";
$("#sum4").val( Number($("#cal1").val() )+Number($("#cal3").val() ));

$(function () {
            $("#cal1, #cal3").on("input", sum);
            function sum() {
                $("#sum4").val( Number($("#cal1").val() )+Number($("#cal3").val() ));
                               }
        });  
}
else if($('.check1').is(":checked")&&$('.check2').is(":checked"))
{
document.getElementById('dcal3').style.display ="none";
document.getElementById('dcal2').style.display ="block";
document.getElementById('dcal1').style.display ="block";
document.getElementById('d120').style.display ="block";
document.getElementById('cal2').style.display ="block";
document.getElementById('cal1').style.display ="block";
document.getElementById('sum4').style.display ="block";
$("#sum4").val( Number($("#cal2").val() )+Number($("#cal1").val() ));
$(function () {
            $("#cal2, #cal1").on("input", sum);
            function sum() {
                $("#sum4").val( Number($("#cal2").val() )+Number($("#cal1").val() ));
                               }
        });  
}
// ++++++++++++
else if(!$('.check3').is(":checked"))
{
document.getElementById('dcal3').style.display ="none";
document.getElementById('d120').style.display ="block";
document.getElementById('sum4').style.display ="block";
$("#sum4").val( Number($("#cal2").val() )+Number($("#cal1").val() ));

$(function () {
            $("#cal1, #cal2").on("input", sum);
            function sum() {
                $("#sum4").val( Number($("#cal2").val() )+Number($("#cal1").val() ));
                               }
        });  
}
else if(!$('.check2').is(":checked"))
{
document.getElementById('dcal2').style.display ="none";
document.getElementById('d120').style.display ="block";
document.getElementById('sum4').style.display ="block";
$("#sum4").val( Number($("#cal1").val() )+Number($("#cal3").val() ));
$(function () {
            $("#cal1, #cal3").on("input", sum);
            function sum() {

               
                               }
        });  
}
else if(!$('.check1').is(":checked"))
{
document.getElementById('dcal1').style.display ="none";
document.getElementById('d120').style.display ="block";
document.getElementById('sum4').style.display ="block";

$("#sum4").val( Number($("#cal2").val() )+Number($("#cal3").val() ));

$(function () {
            $("#cal2, #cal3").on("input", sum);
            function sum() {
               
                $("#sum4").val( Number($("#cal2").val() )+Number($("#cal3").val() ));
                               }
        });  

}
else if($('.check3').is(":checked"))
{
document.getElementById('dcal3').style.display ="block";
document.getElementById('d120').style.display ="block";
document.getElementById('sum4').style.display ="block";
$("#sum4").val(Number($("#cal3").val() ));
$(function () {
            $("#cal3").on("input", sum);
            function sum() {
                
                $("#sum4").val(Number($("#cal3").val() ));
                               }
        });  
}
else if($('.check2').is(":checked"))
{
document.getElementById('dcal2').style.display ="block";
document.getElementById('d120').style.display ="block";
document.getElementById('sum4').style.display ="block";

$("#sum4").val( Number($("#cal2").val() ));
$(function () {
            $("#cal2").on("input", sum);
            function sum() {
                $("#sum4").val( Number($("#cal2").val() ));
                               }
        });  
}
else if($('.check1').is(":checked"))
{
document.getElementById('dcal1').style.display ="none";
document.getElementById('d120').style.display ="block";
document.getElementById('sum4').style.display ="block";

$("#sum4").val( Number($("#cal1").val() ));
$(function () {
            $("#cal1").on("input", sum);
            function sum() {
                $("#sum4").val( Number($("#cal1").val() ));
                               }
        });  
}

}
//$(function (){
//     $("#cal1,#cal2,#cal3").on("input",sum);
//     function sum(){
//     $("#sum4").val(Number($("#cal1").val()*0)+Number($("#cal2").val()*0)+Number($("#cal3").val()*0));

// }
// });
// var firstfield=document.getElementById('cal1');
// var secodinputfield=document.getElementById('cal2');
// var thirdinputfield=document.getElementById('cal3');
// var totalfield=document.getElementById('sum4');


</script>
<script>
var firstcheck=document.getElementById('cal1');
var secondcheck=document.getElementById('cal2');
var thirdcheck=document.getElementById('cal3');
function a(event) {
var char = event.which;
if (char > 31 && char != 32 && (char < 65 || char > 90) && (char < 97 || char > 123)) {
return false;
}
}
</script>


<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
$('.printMe').on('click', function () {

    window.print();
});
</script>

<div id="myModal" class="modal fade" >

            <div class="modal-dialog" >

                <div class="modal-content">

                    <div class="modal-header">

                        <h6><strong>Note(नोंद): </strong> Upload below files in .pdf...(खालील फाइल .pdf मध्ये अपलोड करा.)</h6>

                    </div>

                    <!-- dialog body -->

                    <div class="modal-body" style="color:green">



                       <p style="color:red">

                         <strong>List of document to be attached :</strong>   

                        </p>

                        <ul style="color:rgb(3, 125, 76)">
						
<b><i><label style="color:black;">Common Documents</label></i></b>

<li>1.Self-Attested Applicant's ID Proof(Aadhaar/PAN/Driving License/Passport) (स्वयं-साक्षांकित अर्जदाराचा ओळखपत्र पुरावा (आधार/पॅन/ड्रायव्हिंग लायसन्स/पासपोर्ट))(Max upto 2 MB)<span class="text-danger" style="color: red;">*</span><li>
<li>2.Photographs(Passport Size)(छायाचित्रे (पासपोर्ट आकार))(Max upto 2 MB)<span class="text-danger" style="color: red;">*</span></li>


<b><i><label style="color:black;">For Residential Purpose</label></i></b>
<li>1.Registry/Sale/Lease Deed(नोंदणी/विक्री/लीज करारपत्र)(Max upto 5 MB)<span class="text-danger" style="color: red;">*</span></li>
<li>2.Copy Of Tax Receipt/Rent Agreement/Consent Letter of Owner(कर पावती/भाडे करार/मालकाच्या संमती पत्राची प्रत)(Max upto 2 MB)<span class="text-danger" style="color: red;">*</span></li>

<b><i><label style="color:black;">For slum Purpose</label></i></b>

<li>1.Slum Certificate Slum Photo Pass/Kabja Patra(Possession Certificate)(झोपडपट्टी प्रमाणपत्र झोपडपट्टी फोटो पास/कबजा पत्र (ताबा प्रमाणपत्र))(Max upto 2 MB)</li>
<li>2.Copy Of Tax Receipt (कर पावतीची प्रत)(Max upto 2 MB)<span class="text-danger" style="color: red;">*</span></li>

<b><i><label style="color:black;">For Flat Scheme Purpose</label></i></b>

<li>1.Registry/Sale Deed (नोंदणी/विक्री करार)(Max upto 5 MB)</li>
<li>2.Copy Of Tax Receipt (कर पावतीची प्रत)(Max upto 2 MB)<span class="text-danger" style="color: red;">*</span></li>
<li>3.Consent Letter From Flat Owners/Builder Application(Details of Flats)(फ्लॅट मालकांचे संमती पत्र)(Max upto 2 MB)<span class="text-danger" style="color: red;">*</span></li>
<li>4.DOD Deed Of Declaration (डीओडी डीड ऑफ डिक्लेरेशन)(Max upto 2 MB)</li>
<li>5.NMC/NIT Building Sanction Plan (NMC/NIT इमारत मंजुरी योजना)(Max upto 2 MB)<span class="text-danger" style="color: red;">*</span></li>
<li>6.Architect Completion Certificate (आर्किटेक्ट पूर्णत्व प्रमाणपत्र)(Max upto 2 MB)<span class="text-danger" style="color: red;">*</span></li>

<b><i><label style="color:black;">For Institutional Purpose</label></i></b>

<li>1.Registry/Sale Deed/Agreement of Rent/Consent Letter of Owner(नोंदणी/विक्री करार)(Max upto 5 MB)<span class="text-danger" style="color: red;">*</span></li>
<li>2.Gumasta License/Licenses For Running Business (गुमास्ता परवाना/व्यवसाय चालवण्यासाठी परवाने)(Max upto 2 MB)<span class="text-danger" style="color: red;">*</span></li>
<li>3.Copy Of Tax Receipt (कर पावतीची प्रत)(Max upto 2 MB)<span class="text-danger" style="color: red;">*</span></li>

<b><i><label style="color:black;">For Commercial Purpose</label></i></b>

<li>1.Registry/Sale Deed/Agreement of Rent/Consent Letter of Owner(नोंदणी/विक्री करार/मालकाच्या संमती पत्राची प्रत)(Max upto 5 MB)<span class="text-danger" style="color: red;">*</span></li>
<li>2.Gumasta License/Licenses For Running Business (गुमास्ता परवाना/व्यवसाय चालवण्यासाठी परवाने)(Max upto 2 MB)<span class="text-danger" style="color: red;">*</span></li>
<li>3.Copy Of Tax Receipt (कर पावतीची प्रत)(Max upto 2 MB)<span class="text-danger" style="color: red;">*</span></li>




                        </ul>

                    </div>

                    <!-- dialog buttons -->

                    <div class="modal-footer"><button type="button" class="btn btn-primary">OK</button></div>

                </div>

            </div>

        </div>
        <script>
        $(window).on('load', function(){
            
            
            $('#myModal').modal('show');
            
            $('#myModal .modal-footer .btn').on('click', function(e) {
                console.log('button pressed');              
                // just as an example...
                $('#myModal').modal('hide');                
                // dismiss the dialog
            });
        })

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
                              var maxSize = (fileInput.id === 'a4' || fileInput.id === 'a7' || fileInput.id === 'a12') ? 5000000 : 2000000; // 5 MB for a4, a7, a12; 2 MB for others
                         if (!(name.endsWith('.pdf'))) {
	                            isFormValid = false;
	                            fileInput.classList.remove('is-valid');
	                            fileInput.classList.add('is-invalid');
	                        } else if (fileInput.files[0].size >= maxSize) {
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
           	        $("#submit").attr("disabled", true);
                   	isUploadInProgress = true;
                   	upload(function(status) {
                   	    if (status === true || status === 'true') {
                     onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveNewWaterConnection.do');
                   	    } else {
                   	        $("#submit").attr("disabled", false);
                   	        alert("Something Went Wrong!!");
                   	        
                   	    }
                   	    isUploadInProgress = false; // Reset the flag
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
             var maxSize = (fileInput.id === 'a4' || fileInput.id === 'a7' || fileInput.id === 'a12') ? 5000000 : 2000000; // 5 MB for a4, a7, a12; 2 MB for others
                                  
            if ((this.files[0].size < maxSize) && !(name.endsWith('.pdf'))) {
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

           
            data.append('idProof1', $("#a1").get(0).files[0]);
            data.append('idProof2', $("#a2").get(0).files[0]);
            data.append('idProof3', $("#a3").get(0).files[0]);
            data.append('idProof4', $("#a4").get(0).files[0]);
            data.append('idProof5', $("#a5").get(0).files[0]);
            data.append('idProof6', $("#a6").get(0).files[0]);
            data.append('idProof7', $("#a7").get(0).files[0]);
            data.append('idProof8', $("#a8").get(0).files[0]);
            data.append('idProof9', $("#a9").get(0).files[0]);
            data.append('idProof10', $("#a10").get(0).files[0]);
            data.append('idProof11', $("#a11").get(0).files[0]);
            data.append('idProof12', $("#a12").get(0).files[0]);
            data.append('idProof13', $("#a13").get(0).files[0]);
          
          //  data.append('idProof18', $("#a19").get(0).files[0]);




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
                    filesPath = filesPath + basePath + "NewWaterConnection/" + id + value + ","
                    isFileSelected = true;
                }
            }
            $.ajax({
                url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadDocumentNewWaterConnection.do?id="+id,
                type: 'POST',
                data: data,
                cache: false,
                dataType: 'json',
                processData: false,
                contentType: false,
                async: false, 
                success: function(data) {
                    var status = data.status;
                    if (callback && typeof callback === 'function') {
                    	 var a = filesPath.substring(0, filesPath.lastIndexOf(","));
                         filesPath = filesPath.replace(/\s/g, "");
                         $("#filesPath").val(filesPath);
                         console.log(filesPath);
                        callback(status);
                    }
                }
            });

           

        }
    </script>


 <script>

    
    
    function downloadFile() {
    	
        var fileUrl = "<c:out value="${contextRoot}"/>/pages/citizendocument/Water_Works.pdf";
        var fileName = "WaterWorks.pdf";
        
        var downloadLink = document.createElement("a");
        downloadLink.href = fileUrl;
        downloadLink.download = fileName;
        document.body.appendChild(downloadLink);
        downloadLink.click();
        document.body.removeChild(downloadLink);
    }
</script>






</html>












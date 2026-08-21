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
	src="<c:out value="${contextRoot}" />/scripts/jquery/jquery.ajaxfileupload.js"></script>
	<link rel="stylesheet" href="<c:out value="${contextRoot}" />/pages/core-pages/nmc_user/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}" />/pages/core-pages/nmc_user/css/style2.css" /> 
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

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
label {
	font-weight: 600;
}

h3 {
	font-weight: 500;
}

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
	size: auto;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
	padding: 8px;
}

.btn-container {
	display: flex;
	align-items: center;
}

.btn-container button {
	margin-right: 5px;
}

.btn {
	cursor: pointer;
	padding: 5px 10px;
	margin: 2px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 3px;
}

.btn-remove {
	background-color: #f44336;
}
th, td {
    border: 1px solid black;
    padding: 8px;
}
</style>








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
<div id="myModal" class="modal fade">

	<div class="modal-dialog">

		<div class="modal-content">

			<div class="modal-header">

				<h6>
					<strong>Note(नोंद): </strong> Upload below files in .pdf...Max upto
					2 MB.
				</h6>

			</div>

			<!-- dialog body -->

			<div class="modal-body" style="color: green">



				<p style="color: red">

					<strong>List of document to be attached :</strong>

				</p>

				<ul style="color: rgb(3, 125, 76)">
					<Strong style="color: black;">List Of Hospital Documents:</Strong>

					<li>1.Owner's PG degree certificate and valid M.M.C certificate<span
						class="text-danger" style="color: red;" id="zone">*</span></li>
					<li>2.Nursing Home Certificate<span class="text-danger"
						style="color: red;" id="zone">*</span></li>
					<li>3.Undertaking from owner for 24 hrs.blood supply
						availability and not doing MTP till Registration<span
						class="text-danger" style="color: red;" id="zone">*</span>
					</li>


					<li>4.MOU of blood bank (Minimum 2)<span class="text-danger"
						style="color: red;" id="zone">*</span></li>

					<li>5.Biomedical Certificate <span class="text-danger"
						style="color: red;" id="zone">*</span></li>
					<li>6.Maharashtra Pollution Control Board Certificate<span
						class="text-danger" style="color: red;" id="zone">*</span></li>
					<li>7.Fire NOC<span class="text-danger" style="color: red;"
						id="zone">*</span></li>
					<li>8.Affidavit with notary(applicable only if renewal or any
						change in MTP Certificate)</li>




					<br>
					<Strong style="color: black;">List Of Documents for
						Medical Practitioner</Strong>
					<li>1.M.B.B.S Certificate<span class="text-danger"
						style="color: red;" id="zone">*</span></li>
					<li>2.P.G Certificate<span class="text-danger"
						style="color: red;" id="zone">*</span></li>
					<li>3.M.M.C Certificate<span class="text-danger"
						style="color: red;" id="zone">*</span></li>
					<li>4.Marriage Certificate/Govt. Gazette (If change in name)</li>

					<br>
					<Strong style="color: black;">List Of Documents for
						Medical Assistant</Strong>
					<li>1.M.B.B.S Certificate<span class="text-danger"
						style="color: red;" id="zone">*</span></li>
					<li>2.P.G Certificate<span class="text-danger"
						style="color: red;" id="zone">*</span></li>
					<li>3.M.M.C Certificate<span class="text-danger"
						style="color: red;" id="zone">*</span></li>

					<br>


					<Strong style="color: black;">List Of Documents for
						Anaesthist</Strong>
					<li>1.M.B.B.S Certificate<span class="text-danger"
						style="color: red;" id="zone">*</span></li>
					<li>2.P.G Certificate<span class="text-danger"
						style="color: red;" id="zone">*</span></li>
					<li>3.M.M.C Certificate<span class="text-danger"
						style="color: red;" id="zone">*</span></li>

					<br>
					<Strong style="color: black;">List Of Documents of trained
						nurse</Strong>

					<li>1.Diploma Certificate<span class="text-danger"
						style="color: red;" id="zone">*</span></li>

					<li>2.Valid Certificate<span class="text-danger"
						style="color: red;" id="zone">*</span></li>

					<br>

				</ul>

			</div>

			<!-- dialog buttons -->

			<div class="modal-footer">
				<button type="button" class="btn btn-primary">OK</button>
			</div>

		</div>

	</div>

</div>

</head>
<body>

	<form class="needs-validation" novalidate>
		<div class="container-fluid mt-2" style="width: 180vh">
			<div class="printable">
				<h3 class="text-center">Application Form For Medical
					Termination Of Pregnancy Hospital Registration</h3>
			</div>
			<h6 style="background-color: #dce2e8; padding: 10px;"
				class="  rounded-2">
				<strong> Applicant Details </strong>
			</h6>




			<div class="row">

				<div class="col-md-7">
					<div class="d-flex align-items-center mb-3 mt-3">
						<label for="full_name" class="form-label me-2 flex-shrink-0"
							style="width: 200px;"> Name<span class="text-danger"
							style="color: red;">*</span>
						</label> <input type="text" class="form-control" id="full_name"
							style="background-image: none;" placeholder="" name="full_name"
							pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" maxlength="200" value="" required>
						<div class="invalid-feedback">Please Enter Valid Name</div>
					</div>
				</div>


				<div class="col-md-7">
					<div class="d-flex align-items-center mb-3 mt-3">
						<label for="full_name" class="form-label me-2 flex-shrink-0"
							style="width: 200px;"> Full Address <span
							class="text-danger" style="color: red;" id="zone">*</span>
						</label>
						<textarea class="form-control" id="" placeholder=""
							style="background-image: none;" name="current_address" value=""
							required></textarea>
						<div class="invalid-feedback">Please Enter valid Full
							Address</div>

					</div>
				</div>
				<div class="row">
					<div class="col-md-7">
						<div class="d-flex align-items-center mb-3 mt-3">
							<label for="full_name" class="form-label me-2 flex-shrink-0"
								style="width: 200px;"> Mobile No.<span
								class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control " id="txtMobileNumber"
								style="background-image: none;" placeholder=""
								name="phoneNumber" value="" pattern="[6-9]{1}[0-9]{9}"
								maxlength="10" required>
							<div class="invalid-feedback">Please Enter Valid Mobile No.
							</div>
						</div>
					</div>
				</div>
				<div class="row">

					<div class="col-md-7">
						<div class="d-flex align-items-center mb-3 mt-3">
							<label for="full_name" class="form-label me-2 flex-shrink-0"
								style="width: 200px;"> Email Id <span
								class="text-danger">*</span>
							</label> <input type="email" class="form-control "
								style="background-image: none;" name="email" value="" required>
							<div class="invalid-feedback">Please Enter Valid Email Id.</div>

						</div>
					</div>
				</div>
				<div class="col-md-12 mb-3 mt-3">
					<h6 style="background-color: #dce2e8; padding: 10px;"
						class="rounded-2">
						<strong>Hospital Information</strong>
					</h6>
				</div>


				<div class="row">
					<div class="col-md-12">
						<div class="d-flex align-items-center mb-3 mt-1">
							<label class="form-label me-2 flex-shrink-0"
								style="width: 290px;"> Category of Approved Place <span
								class="text-danger" id="zone">*</span>
							</label>
							<div class="border p-2">

								<div class="form-check form-check-inline me-2">
									<input class="form-check-input" type="radio"
										name="pregnancy_termination" id="upTo12Weeks"
										value="upTo12Weeks" required> <label
										class="form-check-label" for="upTo12Weeks"> Pregnancy
										can be terminated up to 12 weeks </label>
								</div>
								&nbsp;&nbsp;&nbsp;

								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio"
										name="pregnancy_termination" id="upTo24Weeks"
										value="upTo24Weeks" required> <label
										class="form-check-label" for="upTo24Weeks"> Pregnancy
										can be terminated up to 20 weeks </label>
								</div>
							</div>

							<div class="invalid-feedback ml-3">Please select a valid
								Category of Approved Place</div>
						</div>
					</div>
				</div>


				<div class="row">
					<div class="col-md-8">
						<div class="d-flex align-items-center mb-3 mt-3">
							<label for="full_name" class="form-label me-2 flex-shrink-0"
								style="width: 290px;"> Institute Type <span
								class="text-danger">*</span>
							</label> <select class="form-select" id="instituteType"
								name="institute_type" style="background-image: none;" required>
								<option value="">Select Option</option>
								<option value="Government">Government</option>
								<option value="Private">Private</option>
								<option value="Trust">Trust</option>
							</select>
							<div class="invalid-feedback">Please Enter Valid Institute
								Type.</div>
						</div>
					</div>
					<div class="col-md-8" id="otherInstituteTypeContainer"
						style="display: none;">
						<div class="d-flex align-items-center mb-3 mt-3">
							<label for="full_name" class="form-label me-2 flex-shrink-0"
								style="width: 270px;"> Other Institute Type <span
								class="text-danger">*</span>
							</label> <input type="text" class="form-control" id="otherInstituteType"
								name="other_institute_type" style="background-image: none;"
								required>
							<div class="invalid-feedback">Please Enter Valid Other
								Institute Type.</div>
						</div>
					</div>
				</div>

				<script>
    $(document).ready(function() {
        $('#instituteType').on('change', function() {
            var selectedValue = $(this).val();
            if (selectedValue === 'Other Institutions') {
                $('#otherInstituteTypeContainer').show();
                $('#otherInstituteType').attr('required', true);
            } else {
                $('#otherInstituteTypeContainer').hide();
                $('#otherInstituteType').attr('required', false);
            }
        });
    });
</script>


				<div class="row">
					<div class="col-md-8">
						<div class="d-flex align-items-center mb-3 mt-3">
							<label for="full_name" class="form-label me-2 flex-shrink-0"
								style="width: 290px;">Zone No<span class="text-danger"
								style="color: red;" id="zone" onclick="Zoneno(this.form)">*</span>
							</label> <select class="form-select " style="background-image: none;"
								id="iFunction" name="zoneNo" onchange="changeddl(this)" required>
								<option value="" selected="">-Select Zone-</option>
								<option value="1">Zone No.1 - Laxmi Nagar</option>
								<option value="2">Zone No.2 - Dharmpeth</option>
								<option value="3">Zone No.3 - Hanuman Nagar</option>
								<option value="4">Zone No.4 - Dhantoli</option>
								<option value="5">Zone No.5 - Nehru Nagar</option>
								<option value="6">Zone No.6 - Gandhi Zone Mahal</option>
								<option value="7">Zone No.7 - Satranjipura</option>
								<option value="8">Zone No.8 - Lakadganj</option>
								<option value="9">Zone No.9 - Aashi Nagar</option>
								<option value="10">Zone No.10 - Mangalwari</option>

							</select>

							<div class="invalid-feedback ">Please Enter Valid Zone No.
							</div>

						</div>
					</div>
				</div>

			



				<div class="row">
					<div class="col-md-8">
						<div class="d-flex align-items-center mb-3 mt-3">
							<label for="full_name" class="form-label me-2 flex-shrink-0"
								style="width: 290px;">Hospital Owner Name<span
								class="text-danger" style="color: red;" id="zone">*</span></label>
							<input type="text" onkeydown="return /[a-z ]/i.test(event.key)"
								class="form-control" id="" style="background-image: none;"
								placeholder="" name="ownername" value="" required>
							<div class="invalid-feedback">Please Enter valid Owner Name</div>

						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-8">
						<div class="d-flex align-items-center mb-3 mt-3">
							<label for="full_name" class="form-label me-2 flex-shrink-0"
								style="width: 290px;"> Mobile No.<span
								class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control " id="txtMobileNumber"
								style="background-image: none;" placeholder=""
								name="place_phonee" value="" pattern="[6-9]{1}[0-9]{9}"
								maxlength="10" required>
							<div class="invalid-feedback">Please Enter Valid Phone No.
							</div>
						</div>
					</div>
				</div>


				<div class="row">

					<div class="col-md-8">
						<div class="d-flex align-items-center mb-3 mt-3">
							<label for="full_name" class="form-label me-2 flex-shrink-0"
								style="width: 290px;"> Email Id<span class="text-danger">*</span>
							</label> <input type="email" class="form-control "
								style="background-image: none;" name="place_email_id" value=""
								required>
							<div class="invalid-feedback">Please Enter Valid Email Id.</div>

						</div>
					</div>

				</div>




				<div class="row">

					<div class="col-md-8">
						<div class="d-flex align-items-center mb-3 mt-3">
							<label for="full_name" class="form-label me-2 flex-shrink-0"
								style="width: 290px;"> Hospital Name<span
								class="text-danger" style="color: red;" id="zone">*</span></label>
							<input type="text"class="form-control" id="name_place" placeholder=""
							style="background-image: none;" name="name_place" value=""
							required oninput="this.value = this.value.toUpperCase()" onkeydown="return /[a-z ]/i.test(event.key)">
							
						
							<div class="invalid-feedback">Please Enter valid Hospital
								Name</div>

						</div>
					</div>
				</div>
				<div class="row">
									<div class="col-md-8">
				
					<div class="d-flex align-items-center mb-3 mt-3">
						<label for="full_name" class="form-label me-2 flex-shrink-0"
							style="width: 290px;">Hospital Address<span
							class="text-danger" style="color: red;" id="zone">*</span>
						</label>
						<textarea class="form-control" id=""
							style="background-image: none;" placeholder=""
							name="place_full_adrresss" value="" required></textarea>
						<div class="invalid-feedback">Please Enter valid Full
							Address</div>

					</div>
</div>
				</div>
				<div class="row">

					<div class="col-md-8">
						<div class="d-flex align-items-center mb-3 mt-3">
							<label for="full_name" class="form-label me-2 flex-shrink-0"
								style="width: 290px;">Nursing Home/Hospital Registration
								Number<span class="text-danger" style="color: red;" id="nmcreg">*</span>
							</label> <input type="text" class="form-control" id=""
								style="background-image: none;" placeholder=""
								name="nmcregnumber" value="" required>
							<div class="invalid-feedback">Enter Valid Nursing
								Home/Hospital Registration Number</div>

						</div>
					</div>
				</div>

				<div class="row">
    <div class="col-md-8">
        <div class="d-flex align-items-center mb-3 mt-3">
            <label for="total_no_beds" class="form-label me-2 flex-shrink-0" style="width: 290px;">
                Total No of Beds
                <span class="text-danger" id="zone">*</span>
            </label>
            <input type="number" class="form-control" id="total_no_beds" style="background-image: none;" placeholder="" name="total_no_beds" max="99999" required>
            <div class="invalid-feedback">Please enter a valid Total No of Beds.</div>
        </div>
    </div>
</div>

<script>
    document.getElementById('total_no_beds').addEventListener('input', function (e) {
        var value = e.target.value;
        if (value.length > 5) {
            e.target.value = value.slice(0, 5);
        }
    });
</script>


				<div class="row">
					<div class="col-md-8">
						<div class="d-flex align-items-center mb-3 mt-3">
							<label for="full_name" class="form-label me-2 flex-shrink-0"
								style="width: 290px;"> i) Maternity Bed/Beds<span
								class="text-danger" style="color: red;">*</span>
							</label> <input type="number" class="form-control " id="obscticals"
								style="background-image: none;" placeholder="" name="obscticals"
								value="" maxlength="50" max="99999" required>
							<div class="invalid-feedback">Please Enter Valid Maternity
								Bed/Beds.</div>
						</div>
					</div>

				</div>
				<div class="row">


					<div class="col-md-8">
						<div class="d-flex align-items-center mb-3 mt-3">
							<label for="full_name" class="form-label me-2 flex-shrink-0"
								style="width: 290px;"> ii) Other Bed/Beds<span
								class="text-danger">*</span>
							</label> <input type="number" class="form-control "
								style="background-image: none;" max="99999" id="gyn_case" name="gyn_case" value=""
								required>
							<div class="invalid-feedback">Please Enter Valid Other Bed/Beds.</div>

						</div>
					</div>

				</div>
				
				
<script>
    document.getElementById('obscticals').addEventListener('input', function (e) {
        var value = e.target.value;
        if (value.length > 5) {
            e.target.value = value.slice(0, 5);
        }
    });
</script>

<script>
    document.getElementById('gyn_case').addEventListener('input', function (e) {
        var value = e.target.value;
        if (value.length > 5) {
            e.target.value = value.slice(0, 5);
        }
    });
</script>

				<div class="row">


					<div class="col-md-8">
						<div class="d-flex align-items-center mb-3 mt-3">
							<label for="full_name" class="form-label me-2 flex-shrink-0"
								style="width: 290px;"> Number of Deliveries During
								Previous 12 Months <span class="text-danger" style="color: red;"
								id="zone">*</span>
							</label> <input type="number" class="form-control" id="no_of_deliveries"
								style="background-image: none;" placeholder=""
								name="no_of_deliveries" value="" max="99999" required>
							<div class="invalid-feedback">Please Enter valid Number of
								Deliveries During Previous Twelve Months</div>

						</div>
					</div>

				</div>



				<div class="row">

					<div class="col-md-8">
						<div class="d-flex align-items-center mb-3 mt-3">
							<label for="full_name" class="form-label me-2 flex-shrink-0"
								style="width: 290px;"> Number of Dilation and Curettage
								during Previous 12 month <span class="text-danger"
								style="color: red;" id="zone">*</span>
							</label> <input type="number" class="form-control" id="dilatation"
								style="background-image: none;" max="99999" placeholder="" name="dilatation"
								value="" required>
							<div class="invalid-feedback">Enter valid No of Dilation
								and Curettage During Previous 12 Month</div>

						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-8">
						<div class="d-flex align-items-center mb-3 mt-3">
							<label for="full_name" class="form-label me-2 flex-shrink-0"
								style="width: 290px;"> Number of Abdominal Operations
								During Previous 12 Months <span class="text-danger">*</span>
							</label> <input type="number" class="form-control" id="abdominal"
								style="background-image: none;" max="99999" name="abdominal" placeholder=""
								required>
							<div class="invalid-feedback">Enter Valid No of Abdominal
								Operations During Previous 12 Months</div>
						</div>
					</div>
				</div>

<script>
    document.getElementById('no_of_deliveries').addEventListener('input', function (e) {
        var value = e.target.value;
        if (value.length > 5) {
            e.target.value = value.slice(0, 5);
        }
    });
</script>

<script>
    document.getElementById('dilatation').addEventListener('input', function (e) {
        var value = e.target.value;
        if (value.length > 5) {
            e.target.value = value.slice(0, 5);
        }
    });
</script>
<script>
    document.getElementById('abdominal').addEventListener('input', function (e) {
        var value = e.target.value;
        if (value.length > 5) {
            e.target.value = value.slice(0, 5);
        }
    });
</script>








				<!-- <div class="row">
		
<div class="col-md-8">
    <div class="d-flex align-items-center mb-3 mt-3">
        <label for="full_name" class="form-label me-2 flex-shrink-0" style="width: 270px;">Name of the Place (ठिकाणाचे नाव) <span class="text-danger" style="color: red;" id="zone">*</span></label>
    <input type="text" class="form-control" id="changeOwnerName" oninput="this.value = this.value.toUpperCase()" onblur="validateUpperCase(this)" placeholder="" name="name_of_place" style="background-image: none;" value="" required>
</div>
</div>
</div>
</div>-->
				<script type="text/javascript">
    function validateUpperCase(input) {
        if (/[a-z]/.test(input.value)) {
            alert("Please enter only uppercase letters.");
            input.value = input.value.toUpperCase();
        }
    }
</script>




	<div class="col-md-12 mt-3 mb-3">

					<label for="" class="form-label">State, if the following
						facilities are available at the place </label>

				</div>
				<h6 style="background-color: #dce2e8; padding: 10px;"
					class="  rounded-2">
					<strong> Category A </strong>
				</h6>



				<!-- new code -->

				<div class="col-md-12 mt-2 mb-3">

					<div class="mb-3 mt-3" style="display: flex; align-items: center;">
						<div class="border p-2">

							<label class="form-check-label" for="radio1"
								style="margin-right: 15px; width: 500px;">Gynecological examination/labour
							</label>

							<div class="form-check form-check-inline me-2"
								style="margin-right: 10px;">
								<input type="radio" class="form-check-input cat-a" id="radio1"
									name="gynaecological" value="Yes" required="required">
								<label class="form-check-label" for="radio1">Yes</label>
							</div>
							<div class="form-check form-check-inline">
								<input type="radio" class="form-check-input cat-a" id="radio2"
									name="gynaecological" value="No" required="required"> <label
									class="form-check-label" for="radio2">No</label>
							</div>
						</div>
					</div>
					<div class="mb-3 mt-3" style="display: flex; align-items: center;">
						<div class="border p-2">

							<label class="form-check-label " for="radio2"
								style="margin-right: 15px; width: 500px;">Resuscitation
								equipment</label>

							<div class="form-check form-check-inline"
								style="margin-right: 10px;">
								<input type="radio" class="form-check-input cat-a"
									id="radio2-yes" name="resuscitation" value="Yes"
									required="required"> <label class="form-check-label"
									for="radio2-yes">Yes</label>
							</div>
							<div class="form-check form-check-inline">
								<input type="radio" class="form-check-input cat-a"
									id="radio2-no" name="resuscitation" value="No"
									required="required"> <label class="form-check-label"
									for="radio2-no">No</label>
							</div>
						</div>
					</div>

					<div class="mb-3 mt-3" style="display: flex; align-items: center;">
						<div class="border p-2">

							<label class="form-check-label" for="radio3"
								style="margin-right: 15px; width: 500px;">Sterilization
								equipment</label>

							<div class="form-check form-check-inline"
								style="margin-right: 10px;">
								<input type="radio" class="form-check-input cat-a"
									id="radio3-yes" name="sterilization" value="Yes"
									required="required"> <label class="form-check-label"
									for="radio3-yes">Yes</label>
							</div>
							<div class="form-check form-check-inline">
								<input type="radio" class="form-check-input cat-a"
									id="radio3-no" name="sterilization" value="No"
									required="required"> <label class="form-check-label"
									for="radio3-no">No</label>
							</div>
						</div>
					</div>
					<div class="mb-3 mt-3" style="display: flex; align-items: center;">
						<div class="border p-2">

							<label class="form-check-label" for="radio4"
								style="margin-right: 15px; width: 500px;">Facilities for
								treatment of shock, including emergency drugs</label>

							<div class="form-check form-check-inline"
								style="margin-right: 10px;">
								<input type="radio" class="form-check-input cat-a"
									id="radio4-yes" name="emergency" value="Yes"
									required="required"> <label class="form-check-label"
									for="radio4-yes">Yes</label>
							</div>
							<div class="form-check form-check-inline">
								<input type="radio" class="form-check-input cat-a"
									id="radio4-no" name="emergency" value="No" required="required">
								<label class="form-check-label" for="radio4-no">No</label>
							</div>
						</div>
					</div>
					<div class="mb-3 mt-3" style="display: flex; align-items: center;">
						<div class="border p-2">

							<label class="form-check-label" for="radio5"
								style="margin-right: 15px; width: 500px;">Facilities for
								transportation, if required</label>

							<div class="form-check form-check-inline"
								style="margin-right: 10px;">
								<input type="radio" class="form-check-input cat-a"
									id="radio5-yes" name="transportation" value="Yes"
									required="required"> <label class="form-check-label"
									for="radio5-yes">Yes</label>
							</div>
							<div class="form-check form-check-inline">
								<input type="radio" class="form-check-input cat-a"
									id="radio5-no" name="transportation" value="No"
									required="required"> <label class="form-check-label"
									for="radio5-no">No</label>
							</div>
						</div>
					</div>
					<span class="" id="category_a_checkError" style="color: red;"></span>
				</div>






				<h6 style="background-color: #dce2e8; padding: 10px;"
					class="  rounded-2">
					<strong> Category B </strong>
				</h6>

				<div class="mb-3 mt-3" style="display: flex; align-items: center;">
					<div class="border p-2">

						<label class="form-check-label" for="radio1"
							style="margin-right: 15px; width: 700px;">An operation
							table and instruments for performing abdominal or Gynecological 
							surgery</label>
						<div class="form-check form-check-inline"
							style="margin-right: 10px;">
							<input type="radio" class="form-check-input cat-b"
								id="radio1-yes" name="gynaecologicalsurgery" value="Yes"
								required="required"> <label class="form-check-label"
								for="radio1-yes">Yes</label>
						</div>
						<div class="form-check form-check-inline">
							<input type="radio" class="form-check-input cat-b" id="radio1-no"
								name="gynaecologicalsurgery" value="No" required="required">
							<label class="form-check-label" for="radio1-no">No</label>
						</div>
					</div>
				</div>

				<div class="mb-3 mt-3" style="display: flex; align-items: center;">
					<div class="border p-2">

						<label class="form-check-label" for="radio2"
							style="margin-right: 15px; width: 700px;"> Drugs and
							parental fluid in sufficient supply for emergency cases</label>
						<div class="form-check form-check-inline"
							style="margin-right: 10px;">
							<input type="radio" class="form-check-input cat-b"
								id="radio2-yes" name="drugsparental" value="Yes"
								required="required"> <label class="form-check-label"
								for="radio2-yes">Yes</label>
						</div>
						<div class="form-check form-check-inline">
							<input type="radio" class="form-check-input cat-b" id="radio2-no"
								name="drugsparental" value="No" required="required"> <label
								class="form-check-label" for="radio2-no">No</label>
						</div>
					</div>
				</div>
				<div class="mb-3 mt-3" style="display: flex; align-items: center;">
					<div class="border p-2">

						<label class="form-check-label" for="radio3"
							style="margin-right: 15px; width: 700px;"> Anaesthetic
							equipment, resuscitation equipment and sterilization equipment</label>
						<div class="form-check form-check-inline"
							style="margin-right: 10px;">
							<input type="radio" class="form-check-input cat-b"
								id="radio3-yes" name="resuscitationequipment" value="Yes"
								required="required"> <label class="form-check-label"
								for="radio3-yes">Yes</label>
						</div>
						<div class="form-check form-check-inline">
							<input type="radio" class="form-check-input cat-b" id="radio3-no"
								name="resuscitationequipment" value="No" required="required">
							<label class="form-check-label" for="radio3-no">No</label>
						</div>
					</div>
				</div>
				<span class="" id="category_b_checkError" style="color: red;"></span>
				<br>

				<div class="alert alert-info mb-0 p-2 mb-4 ms-2">
					<small class="form-label "><strong class="form-label " style="font-size:16px;">
							Name of Registered Medical Practitioner, Employed in the place
							and their Qualification and Experience in Gynaecology and
							Obstetrics <span class="text-danger">*</span> :
					</strong></small>

				</div>


<table id="medicalTable" data-table-name="MedicalPractitioner">

    <thead>
        <tr>
            <th>Sr.No</th>
            <th>Name of Registered Medical Practitioner</th>
            <th>Qualification</th>
            <th>Full-time/Part-time</th>
            <th>Experience (In Years)</th>
            <th>M.B.B.S Certificate</th>
            <th>P.G Certificate</th>
            <th>M.M.C Certificate</th>
            <th>Marriage Certificate/Govt. Gazette(If change in name)</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td><input type="text" class="form-control" name="medical_practitoner_name" style="background-image: none; width: 180px;" pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" maxlength="200" required></td>
            <td><input type="text" class="form-control" name="medical_practitoner_qualification" style="background-image: none; width: 130px;" required></td>
            <td><select class="form-select" name="medical_practitoner_fullparttime" style="background-image: none; width: 140px;" required="required">
                    <option value="">Select</option>
                    <option value="Full-time">Full-time</option>
                    <option value="Part-time">Part-time</option>
                </select></td>
			<td><input type="number" class="form-control" name="medical_practitoner_experience" style="background-image: none; width: 100px;" required="required" max="99"></td>
 			
 <td>
    <input type="file" class="form-control" style="width: 130px; background-image: none;" accept=".pdf" name="mbbs" id="mbbs" onchange="uploadMedicalTableFile(this, 'mbbs')" required>
                    <div class="invalid-feedback">File selected is either greater than 2Mb or not of type .pdf.</div></td>
    
 			
 			<td>
 			    <input type="file" class="form-control" style="width: 130px; background-image: none;" accept=".pdf" name="pg" id="pg" onchange="uploadMedicalTableFile(this, 'pg')" required>
 			                    <div class="invalid-feedback">File selected is either greater than 2Mb or not of type .pdf.</div></td>
 			    
 			
             <td>
           <input type="file" class="form-control" style="width: 130px; background-image: none;" accept=".pdf" name="mmc" id="mmc" onchange="uploadMedicalTableFile(this, 'mmc')" required>
                            <div class="invalid-feedback">File selected is either greater than 2Mb or not of type .pdf.</div></td>
             
              
             <td>
             <input type="file" class="form-control" style="width: 130px; background-image: none;" accept=".pdf" name="marriageCertificate" id="marriageCertificate" onchange="uploadMedicalTableFile(this, 'marriageCertificate')" required>
                            <div class="invalid-feedback">File selected is either greater than 2Mb or not of type .pdf.</div></td>
             
            
 <!-- <td><input type="file" class="form-control" style="width: 130px; background-image: none;" accept=".pdf" name="medical1" id="medical1" required onchange="validateAndUploadFile(this)">
    <div class="invalid-feedback">File selected is either greater than 2Mb or not of type .pdf.</div></td>
<td><input type="file" class="form-control" style="width: 130px; background-image: none;" accept=".pdf" name="medical2" id="medical2" required onchange="validateAndUploadFile(this)">
    <div class="invalid-feedback">File selected is either greater than 2Mb or not of type .pdf.</div></td>
<td><input type="file" class="form-control" style="width: 130px; background-image: none;" accept=".pdf" name="medical3" id="medical3" required onchange="validateAndUploadFile(this)">
    <div class="invalid-feedback">File selected is either greater than 2Mb or not of type .pdf.</div></td>
<td><input type="file" class="form-control" style="width: 130px; background-image: none;" accept=".pdf" name="medical4" id="medical4" onchange="validateAndUploadFile(this)">
    <div class="invalid-feedback">File selected is either greater than 2Mb or not of type .pdf.</div></td>-->

            <td class="btn-container">
                <button type="button" class="btn btn-add" onclick="addMedicalRow()">+</button>
                <button type="button" class="btn btn-remove" onclick="deleteMedicalRow(this)">-</button>
            </td>
        </tr>
    </tbody>
</table>

<script>
    function addMedicalRow() {
        var table = document.getElementById("medicalTable").getElementsByTagName('tbody')[0];
        var newRow = table.rows[0].cloneNode(true);
        var rowCount = table.rows.length + 1;

        newRow.cells[0].innerHTML = rowCount;
        var inputs = newRow.getElementsByTagName('input');
        for (var i = 0; i < inputs.length; i++) {
            inputs[i].value = '';
        }

        table.appendChild(newRow);
        updateMedicalSerialNumbers("medicalTable");
    }

    function deleteMedicalRow(button) {
        var row = button.parentNode.parentNode;
        var table = row.parentNode;
        if (table.rows.length > 1) {
            row.parentNode.removeChild(row);
            updateMedicalSerialNumbers("medicalTable");
        }
    }

    function updateMedicalSerialNumbers(tableId) {
        var table = document.getElementById(tableId).getElementsByTagName('tbody')[0];
        var rows = table.getElementsByTagName('tr');
        for (var i = 0; i < rows.length; i++) {
            rows[i].cells[0].innerHTML = i + 1;
        }
    }
    
    function uploadMedicalTableFile(inputElement, certificateType) {
        const tableName = document.getElementById("medicalTable").getAttribute("data-table-name");
        const rowId = inputElement.closest('tr').querySelector('td:first-child').innerText; // Get row ID dynamically

        if (!inputElement || !inputElement.files || inputElement.files.length === 0) {
            alert("No file selected.");
            return;
        }

        const file = inputElement.files[0];

        // File size check
        if (file.size > 2 * 1024 * 1024) {
            alert("File size exceeds 2MB limit.");
            return;
        }

        // Check if the file is a PDF
        if (!file.name.endsWith('.pdf')) {
            alert("Invalid file type. Only PDFs are allowed.");
            return;
        }

        const formData = new FormData();
        formData.append("file", file);
        formData.append("id", rowId); // Pass the row ID as part of the data
        formData.append("certificateType", certificateType); // Pass certificateType to the backend

        // Make the AJAX request to upload the file
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadDocumentBirths.do?rowId=" + rowId + "&certificateType=" + certificateType + "&tableName=" + tableName,
            type: 'POST',
            data: formData,
            cache: false,
            dataType: 'json',
            processData: false,
            contentType: false,
            success: function(data) {
                if (data.status) {
                    alert("File uploaded successfully!");

                    // Retrieve the file path from the server response
                    const filePath = data.filePath; // Ensure server returns the path in JSON format

                    // Create or update a hidden input to store this file path
                    const hiddenInputName = inputElement.name + "Path"; // Distinct hidden input name for the file
                    let hiddenInput = inputElement.closest('td').querySelector('input[type="hidden"][name="' + hiddenInputName + '"]');

                    if (!hiddenInput) {
                        // If the hidden input doesn't exist, create it
                        hiddenInput = document.createElement('input');
                        hiddenInput.type = 'hidden';
                        hiddenInput.name = hiddenInputName;

                        // Append the hidden input to the same cell as the file input
                        inputElement.closest('td').appendChild(hiddenInput);
                    }

                    // Always overwrite the hidden input's value with the latest file path
                    hiddenInput.value = filePath;

                } else {
                    alert("File upload failed: " + data.message);
                }
            },
            error: function(xhr, status, error) {
                console.error('Error:', error);
                alert('File upload failed. Please try again.');
            }
        });
    }

</script>

<br>
<div class="alert alert-info mb-0 p-2 mb-4 ms-2">
    <small class="form-label "><strong class="form-label " style="font-size:16px;">
            Assistant Gynaecology Details<span class="text-danger">*</span> :
    </strong></small>
</div>

<table id="assistantTable" data-table-name="assistantGynaecology">


    <thead>
        <tr>
            <th>Sr.No</th>
            <th>Name of Assistant</th>
            <th>Qualification</th>
            <th>Full-time/Part-time</th>
            <th>Experience (In Years)</th>
            <th>M.B.B.S Certificate</th>
            <th>P.G Certificate</th>
            <th>M.M.C Certificate</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td><input type="text" class="form-control" name="assistantName" style="background-image: none; width: 180px;" pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" maxlength="200" required></td>
            <td><input type="text" class="form-control" name="assistantQualification" style="background-image: none; width: 140px;" required></td>
            <td><select class="form-select" name="assistantFullparttime" style="background-image: none; width: 140px;" required>
                    <option value="">Select</option>
                    <option value="Full-time">Full-time</option>
                    <option value="Part-time">Part-time</option>
                </select></td>
            <td><input type="number" class="form-control" name="assistantExperience" style="background-image: none; width: 100px;" required max="99"></td>
    <td>
    <input type="file" class="form-control" style="width: 140px; background-image: none;" accept=".pdf" name="mbbsCertificate" id="mbbsCertificate" required onchange="uploadFile(this, 'mbbsCertificate')">
                    <div class="invalid-feedback">File selected is either greater than 2Mb or not of type .pdf.</div></td>
    

<td>
    <input type="file" class="form-control" style="width: 140px; background-image: none;" accept=".pdf" name="pgCertificate" id="pgCertificate" onchange="uploadFile(this, 'pgCertificate')" required>
                   <div class="invalid-feedback">File selected is either greater than 2Mb or not of type .pdf.</div></td>
   

<td>
    <input type="file" class="form-control" style="width: 180px; background-image: none;" accept=".pdf" name="mmcCertificate" id="mmcCertificate" onchange="uploadFile(this, 'mmcCertificate')" required>
                   <div class="invalid-feedback">File selected is either greater than 2Mb or not of type .pdf.</div></td>
   

            <td class="btn-container">
                <button type="button" class="btn btn-add" onclick="addAssistantRow()">+</button>
                <button type="button" class="btn btn-remove" onclick="deleteAssistantRow(this)">-</button>
            </td>
        </tr>
    </tbody>
</table>
<script>
    function addAssistantRow() {
        var table = document.getElementById("assistantTable").getElementsByTagName('tbody')[0];
        var newRow = table.rows[0].cloneNode(true);
        var rowCount = table.rows.length + 1;

        newRow.cells[0].innerHTML = rowCount;
        var inputs = newRow.getElementsByTagName('input');
        for (var i = 0; i < inputs.length; i++) {
            inputs[i].value = '';
        }

        table.appendChild(newRow);
        updateAssistantSerialNumbers("assistantTable");
    }

    function deleteAssistantRow(button) {
        var row = button.parentNode.parentNode;
        var table = row.parentNode;
        if (table.rows.length > 1) {
            row.parentNode.removeChild(row);
            updateAssistantSerialNumbers("assistantTable");
        }
    }

    function updateAssistantSerialNumbers(tableId) {
        var table = document.getElementById(tableId).getElementsByTagName('tbody')[0];
        var rows = table.getElementsByTagName('tr');
        for (var i = 0; i < rows.length; i++) {
            rows[i].cells[0].innerHTML = i + 1;
        }
    }
    
    function uploadFile(inputElement, certificateType) {
        const tableName = document.getElementById("assistantTable").getAttribute("data-table-name");
        const rowId = inputElement.closest('tr').querySelector('td:first-child').innerText; // Get row ID dynamically

        if (!inputElement || !inputElement.files || inputElement.files.length === 0) {
            alert("No file selected.");
            return;
        }

        const file = inputElement.files[0];

        // File size check
        if (file.size > 2 * 1024 * 1024) {
            alert("File size exceeds 2MB limit.");
            return;
        }

        // Check if the file is a PDF
        if (!file.name.endsWith('.pdf')) {
            alert("Invalid file type. Only PDFs are allowed.");
            return;
        }

        const formData = new FormData();
        formData.append("file", file);
        formData.append("id", rowId); // Pass the row ID as part of the data
        formData.append("certificateType", certificateType); // Pass certificateType to the backend

        // Make the AJAX request to upload the file
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadDocumentBirths.do?rowId=" + rowId + "&certificateType=" + certificateType + "&tableName=" + tableName,
            type: 'POST',
            data: formData,
            cache: false,
            dataType: 'json',
            processData: false,
            contentType: false,
            success: function(data) {
                if (data.status) {
                    alert("File uploaded successfully!");

                    // Retrieve the file path from the server response
                    const filePath = data.filePath; // Ensure server returns the path in JSON format

                    // Create or update a hidden input to store this file path
                    const hiddenInputName = inputElement.name + "Path"; // Distinct hidden input name for the file
                    let hiddenInput = inputElement.closest('td').querySelector('input[type="hidden"][name="' + hiddenInputName + '"]');

                    if (!hiddenInput) {
                        // If the hidden input doesn't exist, create it
                        hiddenInput = document.createElement('input');
                        hiddenInput.type = 'hidden';
                        hiddenInput.name = hiddenInputName;

                        // Append the hidden input to the same cell as the file input
                        inputElement.closest('td').appendChild(hiddenInput);
                    }

                    // Always overwrite the hidden input's value with the latest file path
                    hiddenInput.value = filePath;

                } else {
                    alert("File upload failed: " + data.message);
                }
            },
            error: function(xhr, status, error) {
                console.error('Error:', error);
                alert('File upload failed. Please try again.');
            }
        });
    }

   

    
</script>


				<br>


				<!-- Anesthetist Details -->
<div class="alert alert-info mb-0 p-2 mb-4 ms-2">
    <small class="form-label "><strong class="form-label " style="font-size:16px;">Anesthetist Details<span class="text-danger">*</span> :</strong></small>
</div>

<table id="data-table" data-table-name="Anesthetist">

    <thead>
        <tr>
            <th>Sr.No.</th>
            <th>Name of an Anaesthetist</th>
            <th>M.B.B.S Certificate</th>
            <th>P.G Certificate</th>
            <th>M.M.C Certificate</th>
            <th style="padding: 8px;">Action <span class="text-danger"></span></th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td><input type="text" class="form-control" style="width: 250px; background-image: none;" name="ancName" pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" maxlength="200" required></td>
            <td>
                <input type="file" class="form-control" style="width: 180px; background-image: none;" accept=".pdf" name="anesthetistMbbs" id="anesthetistMbbs" onchange="uploadtable3File(this, 'anesthetistMbbs')" required>
            
                <div class="invalid-feedback">File selected is either greater than 2Mb or not of type .pdf.</div></td>
            <td>
                            <input type="file" class="form-control" style="width: 180px; background-image: none;" accept=".pdf" name="anesthetistPG" id="anesthetistPG" onchange="uploadtable3File(this, 'anesthetistPG')" required>
            
                <div class="invalid-feedback">File selected is either greater than 2Mb or not of type .pdf.</div></td>
            <td>
             <input type="file" class="form-control" style="width: 180px; background-image: none;" accept=".pdf" name="anesthetistMMC" id="anesthetistMMC" onchange="uploadtable3File(this, 'anesthetistMMC')" required>
            
                <div class="invalid-feedback">File selected is either greater than 2Mb or not of type .pdf.</div></td>
            <td class="btn-container">
                <button type="button" class="btn btn-add" onclick="addAnesthetistRow()">+</button>
                <button type="button" class="btn btn-remove" onclick="deleteAnesthetistRow(this)">-</button>
            </td>
        </tr>
    </tbody>
</table>

<script>
function addAnesthetistRow() {
    var table = document.getElementById("data-table").getElementsByTagName('tbody')[0];
    var newRow = table.rows[0].cloneNode(true);
    var rowCount = table.rows.length + 1;

    newRow.cells[0].innerHTML = rowCount;

    var inputs = newRow.getElementsByTagName('input');
    for (var i = 0; i < inputs.length; i++) {
        inputs[i].value = '';
        var name = inputs[i].name;
        var id = inputs[i].id;

        if (name) {
            var newName = name.replace(/\d+$/, '') + rowCount;
            inputs[i].name = newName;
        }

        if (id) {
            var newId = id.replace(/\d+$/, '') + rowCount;
            inputs[i].id = newId;
        }
    }

    table.appendChild(newRow);
    updateAnesthetistSerialNumbers("data-table");
}

function deleteAnesthetistRow(button) {
    var row = button.parentNode.parentNode;
    var table = row.parentNode;
    if (table.rows.length > 1) {
        row.parentNode.removeChild(row);
        updateAnesthetistSerialNumbers("data-table");
    }
}

function updateAnesthetistSerialNumbers(tableId) {
    var table = document.getElementById(tableId).getElementsByTagName('tbody')[0];
    var rows = table.getElementsByTagName('tr');
    for (var i = 0; i < rows.length; i++) {
        rows[i].cells[0].innerHTML = i + 1;
    }
}

function uploadtable3File(inputElement, certificateType) {
    const tableName = document.getElementById("data-table").getAttribute("data-table-name");
    const rowId = inputElement.closest('tr').querySelector('td:first-child').innerText; // Get row ID dynamically

    if (!inputElement || !inputElement.files || inputElement.files.length === 0) {
        alert("No file selected.");
        return;
    }

    const file = inputElement.files[0];

    // File size check
    if (file.size > 2 * 1024 * 1024) {
        alert("File size exceeds 2MB limit.");
        return;
    }

    // Check if the file is a PDF
    if (!file.name.endsWith('.pdf')) {
        alert("Invalid file type. Only PDFs are allowed.");
        return;
    }

    const formData = new FormData();
    formData.append("file", file);
    formData.append("id", rowId); // Pass the row ID as part of the data
    formData.append("certificateType", certificateType); // Pass certificateType to the backend

    // Make the AJAX request to upload the file
    $.ajax({
        url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadDocumentBirths.do?rowId=" + rowId + "&certificateType=" + certificateType + "&tableName=" + tableName,
        type: 'POST',
        data: formData,
        cache: false,
        dataType: 'json',
        processData: false,
        contentType: false,
        success: function(data) {
            if (data.status) {
                alert("File uploaded successfully!");

                // Retrieve the file path from the server response
                const filePath = data.filePath; // Ensure server returns the path in JSON format

                // Create or update a hidden input to store this file path
                const hiddenInputName = inputElement.name + "Path"; // Distinct hidden input name for the file
                let hiddenInput = inputElement.closest('td').querySelector('input[type="hidden"][name="' + hiddenInputName + '"]');

                if (!hiddenInput) {
                    // If the hidden input doesn't exist, create it
                    hiddenInput = document.createElement('input');
                    hiddenInput.type = 'hidden';
                    hiddenInput.name = hiddenInputName;

                    // Append the hidden input to the same cell as the file input
                    inputElement.closest('td').appendChild(hiddenInput);
                }

                // Always overwrite the hidden input's value with the latest file path
                hiddenInput.value = filePath;

            } else {
                alert("File upload failed: " + data.message);
            }
        },
        error: function(xhr, status, error) {
            console.error('Error:', error);
            alert('File upload failed. Please try again.');
        }
    });
}


</script>


<!-- Nurse Information -->
<div class="alert alert-info mb-0 p-2 mb-4 ms-2 mt-3">
    <small class="form-label " style="font-size:16px;"><strong class="form-label ">Full time trained nurse working at the place with details. <span class="text-danger">*</span> :</strong></small>
</div>
<table id="nurseTable" data-table-name="TrainedNurse">

    <thead>
        <tr>
            <th>Sr.No.</th>
            <th>Name</th>
            <th>Diploma Certificate</th>
            <th>Valid Certificate</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td><input type="text" class="form-control" style="width: 320px; background-image: none;" name="nursename" pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" maxlength="200" required="required">
              <div class="invalid-feedback">please enter valid name.</div></td>
            <td>
              <input type="file" class="form-control" style="width: 250px; background-image: none;" accept=".pdf" name="diplomaCerti" id="diplomaCerti" onchange="uploadNurseTableFile(this, 'diplomaCerti')" required>
            
                <div class="invalid-feedback">File selected is either greater than 2Mb or not of type .pdf.</div></td>
            <td>
             <input type="file" class="form-control" style="width: 250px; background-image: none;" accept=".pdf" name="validCerti" id="validCerti" onchange="uploadNurseTableFile(this, 'validCerti')" required>
            
                <div class="invalid-feedback">File selected is either greater than 2Mb or not of type .pdf.</div></td>
            <td class="btn-container">
                <button type="button" class="btn btn-add" onclick="addNurseRow()">+</button>
                <button type="button" class="btn btn-remove" onclick="deleteNurseRow(this)">-</button>
            </td>
        </tr>
    </tbody>
</table>

<script>
function addNurseRow() {
    var table = document.getElementById("nurseTable").getElementsByTagName('tbody')[0];
    var newRow = table.rows[0].cloneNode(true);
    var rowCount = table.rows.length + 1;

    newRow.cells[0].innerHTML = rowCount;
    var inputs = newRow.getElementsByTagName('input');
    for (var i = 0; i < inputs.length; i++) {
        inputs[i].value = '';
    }

    table.appendChild(newRow);
    updateNurseSerialNumbers("nurseTable");
}

function deleteNurseRow(button) {
    var row = button.parentNode.parentNode;
    var table = row.parentNode;
    if (table.rows.length > 1) {
        row.parentNode.removeChild(row);
        updateNurseSerialNumbers("nurseTable");
    }
}

function updateNurseSerialNumbers(tableId) {
    var table = document.getElementById(tableId).getElementsByTagName('tbody')[0];
    var rows = table.getElementsByTagName('tr');
    for (var i = 0; i < rows.length; i++) {
        rows[i].cells[0].innerHTML = i + 1;
    }
}

function uploadNurseTableFile(inputElement, certificateType) {
    const tableName = document.getElementById("nurseTable").getAttribute("data-table-name");
    const rowId = inputElement.closest('tr').querySelector('td:first-child').innerText; // Get row ID dynamically

    if (!inputElement || !inputElement.files || inputElement.files.length === 0) {
        alert("No file selected.");
        return;
    }

    const file = inputElement.files[0];

    // File size check
    if (file.size > 2 * 1024 * 1024) {
        alert("File size exceeds 2MB limit.");
        return;
    }

    // Check if the file is a PDF
    if (!file.name.endsWith('.pdf')) {
        alert("Invalid file type. Only PDFs are allowed.");
        return;
    }

    const formData = new FormData();
    formData.append("file", file);
    formData.append("id", rowId); // Pass the row ID as part of the data
    formData.append("certificateType", certificateType); // Pass certificateType to the backend

    // Make the AJAX request to upload the file
    $.ajax({
        url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadDocumentBirths.do?rowId=" + rowId + "&certificateType=" + certificateType + "&tableName=" + tableName,
        type: 'POST',
        data: formData,
        cache: false,
        dataType: 'json',
        processData: false,
        contentType: false,
        success: function(data) {
            if (data.status) {
                alert("File uploaded successfully!");

                // Retrieve the file path from the server response
                const filePath = data.filePath; // Ensure server returns the path in JSON format

                // Create or update a hidden input to store this file path
                const hiddenInputName = inputElement.name + "Path"; // Distinct hidden input name for the file
                let hiddenInput = inputElement.closest('td').querySelector('input[type="hidden"][name="' + hiddenInputName + '"]');

                if (!hiddenInput) {
                    // If the hidden input doesn't exist, create it
                    hiddenInput = document.createElement('input');
                    hiddenInput.type = 'hidden';
                    hiddenInput.name = hiddenInputName;

                    // Append the hidden input to the same cell as the file input
                    inputElement.closest('td').appendChild(hiddenInput);
                }

                // Always overwrite the hidden input's value with the latest file path
                hiddenInput.value = filePath;

            } else {
                alert("File upload failed: " + data.message);
            }
        },
        error: function(xhr, status, error) {
            console.error('Error:', error);
            alert('File upload failed. Please try again.');
        }
    });
}


</script>

				<br>


<div class="alert alert-info mb-0 p-2 mb-4 ms-2  mt-3">
    <small class="form-label"><strong class="form-label" style="font-size:16px;">Undertaking of Blood Bank<span class="text-danger">*</span> :</strong></small>
</div>

<table id="specificTable" data-table-name="BloodBank">

    <thead>
        <tr>
            <th>Sr. No.</th>
            <th>Name of Blood Bank</th>
            <th>Registration Number</th>
            <th>Validity of Registration</th>
            <th>Distance From Approved Place (in km.)</th>
            <th>Mobile Number</th>
            <th>Blood Bank Undertaking Certificate</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td><input type="text" class="form-control" style="width: 170px; background-image: none;" name="bloodbankName" required></td>
            <td><input type="text" class="form-control" style="width: 150px; background-image: none;" name="bloodbregistrationNumber" required></td>
            <td><input type="date" class="form-control" style="width: 140px; background-image: none;" name="bloodbregistrationValidity" required></td>
          <td><input type="text" class="form-control" style="width: 140px; background-image: none;" name="bloodbdistanceFromApprovedPlace" required pattern="^\d{1,4}(\.\d+)?$" oninput="validateDistance(this)"></td>

<script>
function validateDistance(input) {
    const value = input.value;
    const regex = /^\d{0,4}(\.\d*)?$/;
    if (!regex.test(value)) {
        input.value = value.slice(0, -1);
    }
}
</script>
          
            <td><input type="text" class="form-control" style="width: 140px; background-image: none;" name="bloodbmobilenum" pattern="[6-9]{1}[0-9]{9}"
								maxlength="10" required></td>
            <td>
            <input type="file" class="form-control" style="width: 170px; background-image: none;" accept=".pdf" name="undertaking" id="undertaking" onchange="uploadzBloodBTableFile(this, 'undertaking')" required>
            
                <div class="invalid-feedback">File selected is either greater than 2Mb or not of type .pdf.</div></td>
            <td class="btn-container">
                <button type="button" class="btn btn-add" onclick="addBloodRow()">+</button>
                <button type="button" class="btn btn-remove" onclick="deleteBloodRow(this)">-</button>
            </td>
        </tr>
        <tr>
            <td>2</td>
            <td><input type="text" class="form-control" style="width: 170px; background-image: none;" name="bloodbankName" required></td>
            <td><input type="text" class="form-control" style="width: 150px; background-image: none;" name="bloodbregistrationNumber" required></td>
            <td><input type="date" class="form-control" style="width: 140px; background-image: none;" name="bloodbregistrationValidity" required></td>
            <td><input type="text" class="form-control" style="width: 140px; background-image: none;" name="bloodbdistanceFromApprovedPlace" pattern="^\d{1,4}(\.\d+)?$" oninput="validateDistance(this)" required></td>
            <td><input type="text" class="form-control" style="width: 140px; background-image: none;" name="bloodbmobilenum" pattern="[6-9]{1}[0-9]{9}"
								maxlength="10" required></td>
            <td>
                        <input type="file" class="form-control" style="width: 170px; background-image: none;" accept=".pdf" name="undertaking" id="undertaking" onchange="uploadzBloodBTableFile(this, 'undertakingCerti')" required>
            
                <div class="invalid-feedback">File selected is either greater than 2Mb or not of type .pdf.</div></td>
            <td class="btn-container">
                <button type="button" class="btn btn-add" onclick="addBloodRow()">+</button>
                <button type="button" class="btn btn-remove" onclick="deleteBloodRow(this)">-</button>
            </td>
        </tr>
    </tbody>
</table>

<div id="errorMsg" style="color: red; display: none;">At least two rows are required.</div>

<script>
function addBloodRow() {
    var table = document.getElementById("specificTable").getElementsByTagName('tbody')[0];
    var newRow = table.rows[0].cloneNode(true);
    var rowCount = table.rows.length + 1;

    newRow.cells[0].innerHTML = rowCount;

    var inputs = newRow.getElementsByTagName('input');
    for (var i = 0; i < inputs.length; i++) {
        inputs[i].value = '';
    }

    table.appendChild(newRow);
    updateBloodSerialNumbers();
}

function deleteBloodRow(button) {
    var table = document.getElementById("specificTable").getElementsByTagName('tbody')[0];
    if (table.rows.length > 2) {
        var row = button.parentNode.parentNode;
        table.removeChild(row);

        updateBloodSerialNumbers();
    } else {
        document.getElementById("errorMsg").style.display = "block";
        setTimeout(function() {
            document.getElementById("errorMsg").style.display = "none";
        }, 3000);
    }
}

function updateBloodSerialNumbers() {
    var table = document.getElementById("specificTable").getElementsByTagName('tbody')[0];
    for (var i = 0; i < table.rows.length; i++) {
        table.rows[i].cells[0].innerHTML = i + 1;
    }
}

function uploadzBloodBTableFile(inputElement, certificateType) {
    const tableName = document.getElementById("specificTable").getAttribute("data-table-name");
    const rowId = inputElement.closest('tr').querySelector('td:first-child').innerText; // Get row ID dynamically

    if (!inputElement || !inputElement.files || inputElement.files.length === 0) {
        alert("No file selected.");
        return;
    }

    const file = inputElement.files[0];

    // File size check
    if (file.size > 2 * 1024 * 1024) {
        alert("File size exceeds 2MB limit.");
        return;
    }

    // Check if the file is a PDF
    if (!file.name.endsWith('.pdf')) {
        alert("Invalid file type. Only PDFs are allowed.");
        return;
    }

    const formData = new FormData();
    formData.append("file", file);
    formData.append("id", rowId); // Pass the row ID as part of the data
    formData.append("certificateType", certificateType); // Pass certificateType to the backend

    // Make the AJAX request to upload the file
    $.ajax({
        url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadDocumentBirths.do?rowId=" + rowId + "&certificateType=" + certificateType + "&tableName=" + tableName,
        type: 'POST',
        data: formData,
        cache: false,
        dataType: 'json',
        processData: false,
        contentType: false,
        success: function(data) {
            if (data.status) {
                alert("File uploaded successfully!");

                // Retrieve the file path from the server response
                const filePath = data.filePath; // Ensure server returns the path in JSON format

                // Create or update a hidden input to store this file path
                const hiddenInputName = inputElement.name + "Path"; // Distinct hidden input name for the file
                let hiddenInput = inputElement.closest('td').querySelector('input[type="hidden"][name="' + hiddenInputName + '"]');

                if (!hiddenInput) {
                    // If the hidden input doesn't exist, create it
                    hiddenInput = document.createElement('input');
                    hiddenInput.type = 'hidden';
                    hiddenInput.name = hiddenInputName;

                    // Append the hidden input to the same cell as the file input
                    inputElement.closest('td').appendChild(hiddenInput);
                }

                // Always overwrite the hidden input's value with the latest file path
                hiddenInput.value = filePath;

            } else {
                alert("File upload failed: " + data.message);
            }
        },
        error: function(xhr, status, error) {
            console.error('Error:', error);
            alert('File upload failed. Please try again.');
        }
    });
}




</script>





					<div class="mb-12">

						<div class="mb-3 mt-3" style="display: flex; align-items: center;">
							<div class="border p-2">

								<label class="form-check-label" style="width: 1050px;">
									An Operation Table And Instruments Performing Abdominal And
									Gynecological surgery. </label>

								<div class="form-check form-check-inline me-2"
									style="margin-right: 10px;">
									<input type="radio" class="form-check-input cat-a" id="radio1"
										name="operationTableAndInstruments" value="Yes"
										required="required"> <label class="form-check-label"
										for="radio1">Yes</label>
								</div>
								<div class="form-check form-check-inline">
									<input type="radio" class="form-check-input cat-a" id="radio2"
										name="operationTableAndInstruments" value="No"
										required="required"> <label class="form-check-label"
										for="radio2">No</label>
								</div>
							</div>
						</div>
					</div>

					<div class="mb-12">
						<div class="mb-3 mt-3" style="display: flex; align-items: center;">
							<div class="border p-2">

								<label class="form-check-label" style="width: 1050px;">
									Drug and parental fluids including plasma volume Expander in
									sufficient supply for emergency cases. </label>
								<!-- Radio button for "Yes" -->

								<div class="form-check form-check-inline me-2"
									style="margin-right: 10px;">
									<input type="radio" class="form-check-input cat-a" id="radio1"
										name="drugsAndParacetamol" value="Yes" required="required">
									<label class="form-check-label" for="radio1">Yes</label>
								</div>
								<div class="form-check form-check-inline">
									<input type="radio" class="form-check-input cat-a" id="radio2"
										name="drugsAndParacetamol" value="No" required="required">
									<label class="form-check-label" for="radio2">No</label>
								</div>
							</div>
						</div>

					</div>






					<div class="mb-12">
						<div class="mb-3 mt-3" style="display: flex; align-items: center;">
							<div class="border p-2">

								<label class="form-check-label" style="width: 1050px;">Anesthesia
									equipment including equipment for administration of anesthetic
									cases and resuscitation including equipment for
									blood transfusion.</label>

								<div class="form-check form-check-inline me-2"
									style="margin-right: 10px;">
									<input type="radio" class="form-check-input cat-a" id="radio1"
										name="anestheticEquipments" value="Yes" required="required">
									<label class="form-check-label" for="radio1">Yes</label>
								</div>
								<div class="form-check form-check-inline">
									<input type="radio" class="form-check-input cat-a" id="radio2"
										name="anestheticEquipments" value="No" required="required">
									<label class="form-check-label" for="radio2">No</label>
								</div>
							</div>
						</div>

					</div>


					<div class="mb-12">

						<div class="mb-3 mt-3" style="display: flex; align-items: center;">
							<div class="border p-2">
								<label class="form-label" style="width: 1050px;">
									Cylinder Containing Oxygen.</label>


								<div class="form-check form-check-inline me-2"
									style="margin-right: 10px;">
									<input type="radio" class="form-check-input cat-a" id="radio1"
										name="oxygenCylinder" value="Yes" required="required">
									<label class="form-check-label" for="radio1">Yes</label>
								</div>
								<div class="form-check form-check-inline">
									<input type="radio" class="form-check-input cat-a" id="radio2"
										name="oxygenCylinder" value="No" required="required">
									<label class="form-check-label" for="radio2">No</label>
								</div>
							</div>
						</div>
					</div>

					<label style="display: inline-block; vertical-align: middle;">
						<input type="checkbox" id="acknowledge" name="acknowledge" required
						style="vertical-align: middle; transform: scale(1.5);"> <strong>I
							undertake to explain the said Act and Rules to all employees of
							MTP center is applicable lawfully.</strong>
								<div class="invalid-feedback">Please check the undertaking statement.</div>
					</label>



					<h6 class="mt-4">
						<strong class="form-label "> List Of Hospital Documents
							(with attachment) </strong>
					</h6>
					<input type="hidden" name="filesPath" id="filesPath" /> <input
						type="hidden" name="signMedicalfiles" id="signMedicalfiles" /> <input
						type="hidden" name="nursesupportingdocs" id="nursesupportingdocs" />
					<input type="hidden" name="Anaesthistfiles" id="Anaesthistfiles" />

					<div class="alert alert-info mb-0 p-2 mb-4 ms-2">
						<small class="form-label "><strong class="form-label ">Note:
						</strong> Upload below files in .pdf(Max upto 2 MB)</small>

					</div>
					<div class="row">
						<div class="col-md-3">
							<div class="mb-3 mt-4">
								<label for="" class="form-label"> Owner's PG degree
									Certificate and Valid M.M.C Certificate<span class="text-danger" style="color: red;"
									id="zone">*</span> </label> <input type="file"
									class="form-control" style="background-image: none" id="doc1"
									placeholder="" accept=".pdf" name="doc1" value="" required>
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>

							</div>
						</div>
							<div class="col-md-3">
							<div class="mb-3" style="margin-top: 48px;">
								<label for="" class="form-label">Nursing Home
									Certificate <span class="text-danger" style="color: red;"
									id="zone">*</span>
								</label> <input type="file" class="form-control"
									style="background-image: none" id="doc2" placeholder=""
									accept=".pdf" name="doc2" value="" required>
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>

							</div>
						</div>

						<div class="col-md-3">
							<div class="mb-3 mt-0">
								<label for="" class="form-label"> Undertaking form owner
									for 24 hrs. blood supply availability & Not Doing MTP
									till Registration<span class="text-danger" style="color: red;"
									id="zone">*</span>
								</label> <input type="file" class="form-control"
									style="background-image: none" id="doc3" placeholder=""
									accept=".pdf" name="doc3" value="" required>
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>

							</div>
						</div>
						
						<div class="col-md-3">
							<div class="mb-3 mt-5">
								<label for="" class="form-label"> Biomedical Certificate<span
									class="text-danger" style="color: red;" id="zone">*</span></label>
								<input type="file" class="form-control"
									style="background-image: none" id="doc4" placeholder=""
									accept=".pdf" name="doc4" value="" required>
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>

							</div>
						</div>

</div>
							<div class="row">

						<div class="col-md-3">
							<div class="mb-3 mt-4">
								<label for="" class="form-label"> Maharastra Pollution
									Control Board Certificate <span class="text-danger"
									style="color: red;" id="zone">*</span>
								</label> <input type="file" class="form-control"
									style="background-image: none" id="doc5" placeholder=""
									accept=".pdf" name="doc5" value="" required>
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>

							</div>
						</div>


						<div class="col-md-3">
							<div class="mb-3" style="margin-top: 49px;">
								<label for="" class="form-label"> Fire NOC<span
									class="text-danger" style="color: red;" id="zone">*</span></label>
								<input type="file" class="form-control"
									style="background-image: none" id="doc6" placeholder=""
									accept=".pdf" name="doc6" value="" required>
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>

							</div>
						</div>

						<div class="col-md-3">
							<div class="mb-3 mt-1">
								<label for="" class="form-label"> Affidavit with
									notary(applicable only if renewal or any change in MTP
									Certificate) </label> <input type="file" class="form-control"
									style="background-image: none" id="doc7" placeholder=""
									accept=".pdf" name="doc7" value="">
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>

							</div>
						</div>
					</div>

				

					

						<!-- <div class="col-md-3">
                                        <div class="mb-3" style="margin-top:38px;">
                                            <label for="" class="form-label">Blood Bank Undertaking Certificate(रक्तपेढी उपक्रम प्रमाणपत्र)  <span
								class="text-danger" style="color: red;" id="zone"
								>*</span></label>
                                            <input type="file" class="form-control" style="background-image: none" id="doc7" placeholder="" accept=".pdf" name="doc7"
                                                value="" required>
                                                <div class="invalid-feedback">File selected is either
										greater than 2Mb or not of type .pdf.</div>

								</div>
                                    </div>-->

					

					</div>
					<!--  
                                             <div class="col-md-4" style="margin-top: -5px">
                                        <div class="mb-3 ">
                                            <label for="" class="form-label">OT Swab 72 Hours, 48 Hours,24 Hours(ओटी स्वॅब 72 तास, 48 तास, 24 तास)  <span
								class="text-danger" style="color: red;" id="zone"
								>*</span></label>
                                            <input type="file" class="form-control" style=" id="doc16" placeholder="" name="swab"
                                                value="" required>
                                                <div class="invalid-feedback">File selected is either
										greater than 2Mb or not of type .pdf.</div>

								</div>
                                    </div>
                                    -->

				<div class="col-md-12">
					<div class="mb-3 mt-4">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" id="check1"
								name="declaration" value="something" required> <label
								class="form-check-label mt-0 ms-2 " style="margin-top: -15px;">
								<strong>Declaration<span class="text-danger"
									style="color: red;">*</span>:-
							</strong>I hereby declare that , all the information provided by me in the
								above application is true. If it found wrong or not related , I
								permit to reject the application.<br>
							</label>

							<div class="invalid-feedback">Please check the declaration.</div>

						</div>
					</div>
				</div>
				<div class="col-md-12 text-start mb-5">
					<div class="text-center">
						<button type="button" class="btn btn-danger btn_sm printMe">
							View and Print</button>
						<button class="btn btn-success btn_sm" type="submit" id="submit">Submit</button>
					</div>
				</div>


			</div>
	</form>

</body>
<script type="text/javascript">
$('.printMe').on('click', function () {

    window.print();
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
	                        } else if (fileInput.files[0].size >= 2000000) {
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
                            onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/saveMTPRegistrationCertificate.do');
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
            
            if ((this.files[0].size < 2000000) && !(name.endsWith('.pdf'))) {
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
     data.append('idProof5', $("#doc5").get(0).files[0]);

     data.append('idProof6', $("#doc6").get(0).files[0]);
     data.append('idProof7', $("#doc7").get(0).files[0]);



            var isFileSelected = false
            const id = Math.floor(Math.random() * 9000) + 1000;
            var array_element = "";
            var file = $('input[name="doc1"], input[name="doc2"],input[name="doc3"],input[name="doc4"],input[name="doc5"],input[name="doc6"],input[name="doc7"]');

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
                    filesPath = filesPath + basePath + "mtpregistrationcertificate/" + id + value + ","
                    isFileSelected = true;
                }
            }
            $.ajax({
                url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadMTPRegistrationCertificate.do?id="+id,
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

            var a = filesPath.substring(0, filesPath.lastIndexOf(","));
            filesPath = filesPath.replace(/\s/g, "");
            $("#filesPath").val(filesPath);
            console.log(filesPath);

        }
    </script>
   <script>
 
   //first medical table -1 file per row-medical_practitoner_seq 
   function dogoperatedfile(callback) {
        //var noOfDogs = $('#medical_practitoner_seq').val();
        var noOfDogs = $('#medicalTable tbody tr').length;
        var url = window.location.href;
        var basePath = '${pageContext.getAttribute("UPLOAD_PATH")}';
        var filesPath = "";
        var data = new FormData();

            
        data.append('medical1', $("#medical1").get(0).files[0]);
        data.append('medical2', $("#medical2").get(0).files[0]);
        data.append('medical3', $("#medical3").get(0).files[0]);
        data.append('medical4', $("#medical4").get(0).files[0]);

        
         for (var i = 0; i < noOfDogs - 1; i++) {
           	data.append('medical1'+i, $("#medical1"+i).get(0).files[0]);
           	data.append('medical2'+i, $("#medical2"+i).get(0).files[0]);
           	data.append('medical3'+i, $("#medical3"+i).get(0).files[0]);
        	 data.append('medical4'+i, $("#medical4"+i).get(0).files[0]);
          } 
        var isFileSelected = false
        const id = Math.floor(Math.random() * 9000) + 1000;
        var array_element = "";
        var file = $('input[name="medical1"], input[name="medical2"], input[name="medical3"], input[name="medical4"]');

        for (var i = 0; i < file.length; i++) {
            var array_element = file[i];
            var element = array_element.value.split("\\");
            var a = element[element.length-1];
            const splitName = a.split(".pdf")[0].replaceAll(/[^a-zA-Z0-9]/g, ""); 
            const value = splitName + ".pdf";

            if (a === '' || a === undefined) {
                filesPath += "null" + ",";
                isFileSelected = false;
            } else {
                filesPath = filesPath + basePath + "mtpMedical/" + id + value + ",";
                isFileSelected = true;
            }
        }

        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtiapplication/mtpMedical.do?id=" + id,
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false,
            contentType: false,
            async: false, // Set to synchronous
            success: function(data) {
                var status = data.status;
                if (callback && typeof callback === 'function') {
                    callback(status);
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error("AJAX Error:", textStatus, errorThrown);
                if (callback && typeof callback === 'function') {
                    callback(false);
                }
            }
        });

        var a = filesPath.substring(0, filesPath.lastIndexOf(","));
        filesPath = filesPath.replace(/\s/g, "");
        $("#signMedicalfiles").val(filesPath);
        console.log(filesPath);
    }

   //second nurse table-1 file per row- id="nursesno"
   function dogCertificate(callback) {
	   
       var noOfDogs = $('#nurseTable tbody tr').length;

      //  var noOfDogs = $('#nursesno').val();
        var url = window.location.href;
        var basePath = '${pageContext.getAttribute("UPLOAD_PATH")}';
        var filesPath = "";
        var data = new FormData();

        data.append('nursesupportingdoc', $("#nursesupportingdoc").get(0).files[0]);

        
     for (var i = 0; i < noOfDogs - 1; i++) {
        	data.append('nursesupportingdoc'+i, $("#nursesupportingdoc"+i).get(0).files[0]);
        } 
        var isFileSelected = false
        const id = Math.floor(Math.random() * 9000) + 1000;
        var array_element = "";
        var file = $('input[name="nursesupportingdoc"]');

        for (var i = 0; i < file.length; i++) {
            var array_element = file[i];
            var element = array_element.value.split("\\");
            var a = element[element.length-1];
            const splitName = a.split(".pdf")[0].replaceAll(/[^a-zA-Z0-9]/g, ""); 
            const value = splitName + ".pdf";

            if (a === '' || a === undefined) {
                filesPath += "null" + ",";
                isFileSelected = false;
            } else {
                filesPath = filesPath + basePath + "mtpNurse/" + id + value + ",";
                isFileSelected = true;
            }
        }

        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtiapplication/mtpNurse.do?id=" + id,
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false,
            contentType: false,
            async: false, // Set to synchronous
            success: function(data) {
                var status = data.status;
                if (callback && typeof callback === 'function') {
                    callback(status);
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error("AJAX Error:", textStatus, errorThrown);
                if (callback && typeof callback === 'function') {
                    callback(false);
                }
            }
        });

        var a = filesPath.substring(0, filesPath.lastIndexOf(","));
        filesPath = filesPath.replace(/\s/g, "");
        $("#nursesupportingdocs").val(filesPath);
        console.log(filesPath);
        
        
    }
   
   //third Anaesthist table-5 files per row.anaesthistSrNo
   function dogCertificateSecond(callback) {
        //var noOfDogs = $('#anaesthistSrNo').val();
               var noOfDogs = $('#data-table tbody tr').length;

        var url = window.location.href;
        var basePath = '${pageContext.getAttribute("UPLOAD_PATH")}';
        var filesPath = "";
        var data = new FormData();

        data.append('Anaesthistfile1', $("#Anaesthistfile1").get(0).files[0]);
        data.append('Anaesthistfile2', $("#Anaesthistfile2").get(0).files[0]);
        data.append('Anaesthistfile3', $("#Anaesthistfile3").get(0).files[0]);
        data.append('Anaesthistfile4', $("#Anaesthistfile4").get(0).files[0]);

        
     for (var i = 0; i < noOfDogs - 1; i++) {
        	data.append('Anaesthistfile1'+i, $("#Anaesthistfile1"+i).get(0).files[0]);
        	data.append('Anaesthistfile2'+i, $("#Anaesthistfile2"+i).get(0).files[0]);
        	data.append('Anaesthistfile3'+i, $("#Anaesthistfile3"+i).get(0).files[0]);
        	data.append('Anaesthistfile4'+i, $("#Anaesthistfile4"+i).get(0).files[0]);

        } 
        var isFileSelected = false
        const id = Math.floor(Math.random() * 9000) + 1000;
        var array_element = "";
        var file = $('input[name="Anaesthistfile1"], input[name="Anaesthistfile2"],input[name="Anaesthistfile3"],input[name="Anaesthistfile4"]"]');

        for (var i = 0; i < file.length; i++) {
            var array_element = file[i];
            var element = array_element.value.split("\\");
            var a = element[element.length-1];
            const splitName = a.split(".pdf")[0].replaceAll(/[^a-zA-Z0-9]/g, ""); 
            const value = splitName + ".pdf";

            if (a === '' || a === undefined) {
                filesPath += "null" + ",";
                isFileSelected = false;
            } else {
                filesPath = filesPath + basePath + "mtpAnaesthist/" + id + value + ",";
                isFileSelected = true;
            }
        }

        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtiapplication/mtpAnaesthist.do?id=" + id,
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false,
            contentType: false,
            async: false, // Set to synchronous
            success: function(data) {
                var status = data.status;
                if (status == true) {
                    if (callback && typeof callback === 'function') {
                        callback(status);
                    }
                } else {
                    alert("Something Went Wrong!!");
                    if (callback && typeof callback === 'function') {
                        callback(false);
                    }
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error("AJAX Error:", textStatus, errorThrown);
                if (callback && typeof callback === 'function') {
                    callback(false);
                }
            }
        });

        var a = filesPath.substring(0, filesPath.lastIndexOf(","));
        filesPath = filesPath.replace(/\s/g, "");
        $("#Anaesthistfiles").val(filesPath);
        console.log(filesPath);
        
        
    }
</script>





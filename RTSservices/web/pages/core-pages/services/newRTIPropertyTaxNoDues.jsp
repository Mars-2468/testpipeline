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
	href="<c:out value='${contextRoot}'/>/pages/core-pages/nmc_user/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<c:out value='${contextRoot}'/>/pages/core-pages/nmc_user/css/style2.css" />
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

///pageContext.setAttribute("statusList", CommonUtils.getStatus()
%>
<style>
    /* Overlay */
    .custom-alert-overlay {
        display: none;
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, 0.5);
        align-items: center;
        justify-content: center;
        z-index: 9999;
    }

    /* Modal */
    .custom-alert-modal {
            background-color: aliceblue;
    color: #333;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
    text-align: center;
    font-family: math;
    max-width: 750px;
    margin-left: 420px;
    margin-top: 300px;
    font-size: larger;
}

    /* Close button */
    .custom-alert-close-btn {
        cursor: pointer;
        position: absolute;
        top: 100px;
        right: 100px;
        font-size: 20px;
        color: #333;
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
     size: auto ;
     }
</style>
<style>
 .custom-hr {
  border-color: #420101;
  border-width: 2px;
  margin: 10px 0;
}
</style>

<style>
  .pay-now-button {
   background-color: lightblue;
    color: darkblue;
    font-size: 16px;
    font-weight: bold;
    padding: 8px 13px;
    border: 2px solid #349b;
    border-radius: 5px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    transition: background-color 0.3s ease, color 0.3s ease;
}
    .pay-now-button:hover {
      background-color: #3498db; /* Blue background on hover */
      color: #fff; /* White text on hover */
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
</head>
<body>

	<form class="needs-validation" novalidate>
	<div id="myModal" class="modal fade">

            <div class="modal-dialog">

                <div class="modal-content">

                    <div class="modal-header">

                        <h6><strong>Note(नोंद): </strong> Upload below files in .pdf...Max upto 5 MB(खालील फाइल .pdf मध्ये अपलोड करा..कमाल ५ MB पर्यंत)</h6>

                    </div>

                    <!-- dialog body -->

                    <div class="modal-body" style="color:green">



                      <p style="color:red">

                        <strong>List of document to be attached :
                        </strong>    
                        </p>

                        <ul style="color:rgb(3, 125, 76)">




                            <li>1. Self Attested Applicant's Id Proof (स्वत: प्रमाणित अर्जदाराचा आयडी पुरावा)<span class="text-danger"  style="color: red;">*</span></li>
  <li>2.Any Other Supporting Document (इतर कोणतेही सहाय्यक दस्तऐवज) </li>

                        </ul>

                    </div>

                    <!-- dialog buttons -->

                    <div class="modal-footer"><button type="button" class="btn btn-primary">OK</button></div>

                </div>

            </div>

        </div>
		<div class="container-fluid mt-4" style="width: 180vh">
			<div class="printable">
				<h3 class="text-center">
					Property Tax No Due Certificate (मालमत्ता कर थकबाकी नसल्याचा दाखला देणे)
				</h3>
			</div>
<hr class="custom-hr">

			<!-- <h6 style="background-color: #dce2e8; padding: 10px;"
				class="  rounded-2">
				<strong> Applicant Details (अर्जदाराचे तपशील) </strong>
			</h6>-->
			<div class="row">
				<input type="hidden" name="_token" value="xyz">
				<input type="hidden" name="str" value="<c:out value='${str}'/>">
			<input type="hidden" name="serviceId" value="<c:out value='${serviceId}'/>">
			<input type="hidden" name="fields" value="<c:out value='${fields_aps}'/>">
			<input type="hidden" name="distric" value="<c:out value='${distric}'/>">
			<input type="hidden" name="trackid" value="<c:out value='${trackid}'/>">
			<input type="hidden" name="user" value="<c:out value='${user}'/>">
			<input type="hidden" name="mobile" value="<c:out value='${mobile}'/>">
			<input type="hidden" name="name" value="<c:out value='${name}'/>">
             
                                  <div class="row">
				<div class="col-md-3">
    <div class="mb-3 mt-3">
        <label for="upinNo" class="form-label lbleng">UPIN No. (UPIN क्र.)<span class="text-danger upin" style="color: red;">*</span></label>
        <input type="text" class="form-control" style="background-image: none;" id="upinNo" placeholder="" name="upinNo" value="" maxlength="14" required>
        <div class="invalid-feedback">Please Enter Valid UPIN No.</div>
    </div>
</div>

<div class="col-md-3">
    <div class="mb-3 mt-3">
        <label for="indexNo" class="form-label lbleng">Index No. (निर्देशांक क्र.)<span class="text-danger indexNo" style="color: red;">*</span></label>
        <input type="text" class="form-control" style="background-image: none;" id="indexNo" placeholder="" name="indexNo" value="" maxlength="14" required>
        <div class="invalid-feedback">Please Enter Valid Index No.</div>
    </div>
</div>		<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Applicant's Name (अर्जदाराचे नाव)<span class="text-danger">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="first_name" placeholder=""
							name="name" value="" pattern="^[A-Za-z ]+$"
							  required>
						<div class="invalid-feedback">Please Enter Valid  Name.
						</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">

						<label for="email" class="form-label lbleng">Applicant's Mail ID (अर्जदाराचा मेल आयडी)<span class="text-danger">*</span>
						</label> <input type="email" class="form-control"
							style="background-image: none;" name="emailid"value="" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}"  required>
						<div class="invalid-feedback">Please Enter Valid Email Id.</div>
					</div>
				</div>


				<div class="col-md-3">
					<div class="mb-3 mt-4">
						<label for="" class="form-label">Applicant's Mobile No.(अर्जदाराचा मोबाईल क्र)<span
							class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="txtMobileNumber"
							placeholder="" name="mobileNo" value=""
							pattern="[6-9]{1}[0-9]{9}" maxlength="10"  required>
						<div class="invalid-feedback">Please Enter Valid Mobile No.
						</div>
					</div>
				</div>


			
		
<script>
function validateTextarea() {
  const textarea = document.getElementById('myTextarea');
  const errorFeedback = document.getElementById('errorFeedback');
  const text = textarea.value;

  // Regular expression to check for leading spaces before the first letter
  const regex = /^[a-zA-Z0-9]+$/;

  if (regex.test(text)) {
    textarea.classList.remove('is-invalid');
    errorFeedback.style.display = 'none';
  } else {
    textarea.classList.add('is-invalid');
    errorFeedback.style.display = 'block';
  }
}
</script>
<div class="overlay" id="custom-alert-overlay">
    <div class="modal">
        <span class="close-btn" onclick="closeCustomAlert()">&times;</span>
        <div id="custom-alert-content"></div>
    </div>
</div>

	<div class="col-md-3">
						<div class="mb-3 mt-0">
							<label for="" class="form-label"> Name of Property
								Holders/Occupants (मालमत्ताधारक/ भोगवटादारांचे नाव)</label> <input
								type="text" class="form-control" style="background-image: none;"
								id="propertyHolderName" name="propertyHolderName" value=""
								maxlength="255" readonly>
							<div class="invalid-feedback">Please Enter Valid name of Property Holders/Occupants.</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="mb-3 mt-4">
							<label for="" class="form-label"> House No.(घर क्र)</label> <input
								type="text" class="form-control" style="background-image: none;"
								id="houseNo" name="houseNo" value=""
								maxlength="255" readonly>
							<div class="invalid-feedback">Please Enter Valid name of Property Holders/Occupants.</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="mb-3 mt-4">
							<label for="" class="form-label lbleng">Zone No. (झोन
								क्र.)<span class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control"
								style="background-image: none;" class="form-select "
								style="background-image: none;" id="zoneNo" name="zoneNo"
								required readonly>
							<div class="invalid-feedback">Please Enter Valid Zone No.</div>
						</div>
					</div>



					<div class="col-md-3">
						<div class="mb-3" style="margin-top: 23px;">
							<label for="upinNo" class="form-label lbleng">Ward No.
								(प्रभाग क्र.)<span class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control"
								style="background-image: none;" id="blockNo" placeholder=""
								name="blockNo" value="" maxlength="10" required readonly>
							<div class="invalid-feedback">Please Enter Valid Block No.</div>
						</div>
					</div>


					<div class="col-md-3">
						<div class="mb-3" style="margin-top: 23px;">
							<label for="upinNo" class="form-label lbleng">Ward Name
								(प्रभाग नाव)<span class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control"
								style="background-image: none;" id="blockName" placeholder=""
								name="blockName" value="" maxlength="10" required readonly>
							<div class="invalid-feedback">Please Enter Valid BLock
								Name.</div>
						</div>
					</div>
					
					
					<div class="col-md-3">
						<div class="mb-3" style="margin-top: 23px;">
							<label for="upinNo" class="form-label lbleng">Pincode
								(पिन कोड)<span class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control"
								style="background-image: none;" id="taxPincode" placeholder=""
								name="taxPincode" value="" maxlength="10" required readonly>
							<div class="invalid-feedback">Please Enter Valid Pincode.</div>
						</div>
					</div>


					<div class="col-md-12">
						<div class="mb-3 mt-3 ">
							<label for="primary_full_address" class="form-label lbleng">Address(पत्ता)<span
								class="text-danger">*</span>
							</label>

							<textarea class="form-control " rows="2" id="address"
								style="background-image: none;" name="address" maxlength="80"
								required readonly></textarea>
							<div class="invalid-feedback" id="errorFeedback">Please
								Enter Valid Address.</div>

						</div>
					</div>








					<!-- New Fields -->



					<div class="col-md-3">
						<div class="mb-3" style="margin-top: 23px;">
							<label for="upinNo" class="form-label lbleng">Owner Name
								(मालकाचे नाव)<span class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control"
								style="background-image: none;" id="ownerName" placeholder=""
								name="ownerName" value="" maxlength="10" required readonly>
							<div class="invalid-feedback">Please Enter Valid Owner
								Name.</div>
						</div>
					</div>


					<div class="col-md-3">
						<div class="mb-3" style="margin-top: px;">
							<label for="upinNo" class="form-label lbleng">Registered
								Mobile Number (नोंदणीकृत मोबाईल क्रमांक)<span
								class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control"
								style="background-image: none;" id="taxMobileNo" placeholder=""
								name="taxMobileNo" value="" maxlength="10" required>
							<div class="invalid-feedback">Please Enter Valid Registered
								Mobile Number.</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="mb-3" style="margin-top: 23px;">
							<label for="upinNo" class="form-label lbleng">Arrears in Rs.(थकबाकी रु.)<span class="text-danger" style="color: red;">*</span>
							</label> <input type="number" class="form-control"
								style="background-image: none;" id="areasPending" placeholder=""
								name="areasPending" value="" maxlength="10" required readonly>
							<div class="invalid-feedback">Please Enter Valid Arrears.</div>
						</div>
					</div>


					<div class="col-md-3">
						<div class="mb-3" style="margin-top: 23px;">
							<label for="upinNo" class="form-label lbleng">Arrears
								Status (थकबाकी स्थिती)<span class="text-danger"
								style="color: red;">*</span>
							</label> <input type="text" class="form-control"
								style="background-image: none;" id="areasPendingStatus"
								placeholder="" name="areasPendingStatus" value="" maxlength="10"
								required readonly>
							<div class="invalid-feedback">Please Enter Valid Arrears
								Status.</div>
						</div>
					</div>

<div class="col-md-3">
    <div class="mb-3" style="margin-top: 23px;">
        <label for="upinNo" class="form-label lbleng">Pending Dues (प्रलंबित थकबाकी)<span class="text-danger" style="color: red;">*</span></label>
        <input type="text" class="form-control" style="background-image: none;" id="dues" placeholder="" name="duesAmt" value="" maxlength="10" required readonly>
        <div class="invalid-feedback">Please Enter Valid Dues Amount.</div>
    </div>
</div>

<!-- 
<div class="col-md-3">
    <div class="mb-3" style="margin-top: 50px;">
        <a href="https://geocivicnmcapp.nmcptax.com/CitizenServices/CitizenTax/index.html" class="pay-now-button" target="_blank">Pay Your Tax</a>
    </div>
</div> -->

		<!-- 	<h6 style="background-color: #dce2e8; padding: 10px;"
				class="  rounded-2">
				<strong>Application Form Details (अर्ज तपशील) </strong>
			</h6>-->


			
	
		 
    
   
				



<!-- <script>
    function validateInput(inputId, minLength, maxLength) {
        var input = document.getElementById(inputId);
        var inputValue = input.value.trim(); // Trim the input to remove leading/trailing whitespace.

        var alphanumericRegex = /^[A-Za-z0-9]+$/;

        if (inputValue === '' || (alphanumericRegex.test(inputValue) && inputValue.length === 10)) {
            input.setCustomValidity(''); // Reset the custom validity.
            input.classList.remove("is-invalid");
        } else {
            input.setCustomValidity('Please enter a valid value.'); // Set a custom validation message.
            input.classList.add("is-invalid");
        }
    }

    var upinNoInput = document.getElementById("upinNo");
    var indexNoInput = document.getElementById("indexNo");

    upinNoInput.addEventListener("input", function() {
        validateInput("upinNo", 10, 10);
    });

    indexNoInput.addEventListener("input", function() {
        validateInput("indexNo", 10, 10);
    });

    // Prevent form submission if there are validation errors.
    var form = document.querySelector("form");
    form.addEventListener("submit", function (event) {
        if (!form.checkValidity()) {
            event.preventDefault(); // Prevent form submission if there are errors.
        }
    });
</script> -->
					<hr class="custom-hr">

			<div class="row">

				<!-- <h6 style="background-color: white; padding: 5px;"
					class="mt-1 rounded-2">
					<strong> List of Documents (with attachment) (दस्तऐवजांची
						यादी (सह संलग्नक)) </strong>
				</h6>-->
					<div class="">
											<br>
				
					<strong style="color: red;">Note (नोंद): </strong> Upload below file
						only .pdf(Max upto 5 MB) (खाली फक्त .pdf फाइल अपलोड करा (कमाल ५ MB
						पर्यंत))
				</div><br>
				<input type="hidden" name="filesPath" id="filesPath" />

				<div class="col-md-3">
					<div class="mb-3 mt-5">
						<label for="" class="form-label"> Self Attested Applicant's Id Proof (स्वत: प्रमाणित अर्जदाराचा आयडी पुरावा)<span class="text-danger"
							style="color: red;">*</span>
						</label> <input type="file" class="form-control"
							style="background-image: none;" accept=".pdf" name="applicantIdproof" id="doc1"
							required>
						<div class="invalid-feedback">File selected is either
							greater than 5Mb or not of type .pdf.</div>

					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3" style="margin-top:49px">
						<label for="" class="form-label">
						Any Other Supporting Document (इतर कोणतेही सहाय्यक दस्तावेज)
						</label> <input type="file" class="form-control"
							style="background-image: none;" accept=".pdf" name="taxPaymentReceipt"
							id="doc2">
						<div class="invalid-feedback">File selected is either
							greater than 5Mb or not of type .pdf.</div>
					</div>
				</div>
				<!-- <div class="col-md-3">
					<div class="mb-3 mt-5">
						<label for="" class="form-label">Copy of Demand Bill of
							Current Year (चालू वर्षाच्या मागणी बिलाची प्रत)<span
							class="text-danger" style="color: red;">*</span>
						</label> <input type="file" class="form-control"
							style="background-image: none;" accept=".pdf" name="copyOfDemandBill" id="doc3"
							required>
						<div class="invalid-feedback">File selected is either
							greater than 5Mb or not of type .pdf.</div>
					</div>
				</div>-->

						<hr class="custom-hr">




				<div class="col-md-12">
					<div class="mb-5 mt-4 ">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" id="check11"
								name="declaration" value="something" required> <label
								class="form-check-label ms-3 lbleng" style="margin-top: 0px;">
								<strong>Declaration (घोषणा)<span class="text-danger"
									style="color: red;">*</span>:-
							</strong>The above mentioned information is true to the best of my
								knowledge and belief (वर नमूद केलेली माहिती माझ्या माहितीनुसार
								आणि विश्वासानुसार खरी आहे).
							</label>
							<div class="invalid-feedback">Please check the declaration.
							</div>
						</div>
					</div>
				</div>
				
				<input type="hidden" value="" id="due" />
				
				<div class="col-md-12 text-start mb-5">
					<div class="text-center">
						<button type="button" class="btn btn-danger btn_sm printMe">
							View and Print</button>
						<button class="btn btn-success btn_sm" type="submit" id="submit"
							>Submit</button>
					</div>
				</div>
			</div>
			<input type="hidden" name="dues_amt" id="dues_amt" />
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
            var due=$('#dues_amt').val();
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
           	        $("#submit").attr("disabled", true);
                   	isUploadInProgress = true;
           	    	if(parseInt(due)>0){
                        alert("Please pay dues amount of Rs." + due + "/- in order to get a no dues certificate.");
                        isUploadInProgress=false;
                        return false;
           	    	}else{
                   	upload(function(status) {
                   	    if (status === true || status === 'true') {
                   	   
                           		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/savePropertyTaxNoDues.do');
                   	    	
                   	    } else {
                   	        $("#submit").attr("disabled", false);
                   	        alert("Something Went Wrong!!");
                   	        
                   	    }
                   	    isUploadInProgress = false; // Reset the flag
                   	});
                   	
                    }
                       
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
     	//data.append('idProof3', $("#doc3").get(0).files[0]);


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
                    filesPath = filesPath + basePath + "propertyTaxNoDues/" + id + value + ","
                    isFileSelected = true;
                }
            }
            $.ajax({
                url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadDocumentPropertyTaxNoDues.do?id="+id,
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
                        callback(status);
                    }
                }, error: function (jqXHR, textStatus, errorThrown) {
                    alert("Something went wrong!!");
                }
            });

            var a = filesPath.substring(0, filesPath.lastIndexOf(","));
            filesPath = filesPath.replace(/\s/g, "");
            $("#filesPath").val(filesPath);
            console.log(filesPath);

        }
    </script>

<script src="https://code.jquery.com/jquery-3.6.3.min.js"
	integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
	crossorigin="anonymous"></script>
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
    
    <script>
    
      $(document).ready(function () {
            function validateFields() {
                var upinNoValue = $("#upinNo").val().trim();
                var indexNoValue = $("#indexNo").val().trim();
                
                var isUpinNoEmpty = (upinNoValue === "");
                var isIndexNoEmpty = (indexNoValue === "");
                
                if (isIndexNoEmpty) {
                    $("#upinNo").prop("required", true);
                    $(".upin").show();
                } else {
                    $("#upinNo").prop("required", false);
                    $(".upin").hide();
                }
                
                if (isUpinNoEmpty) {
                    $("#indexNo").prop("required", true);
                    $(".indexNo").show();
                } else {
                    $("#indexNo").prop("required", false);
                    $(".indexNo").hide();
                }
                
                if(isUpinNoEmpty || isIndexNoEmpty)
                $("#upinNo, #indexNo").toggleClass('is-valid', isUpinNoEmpty && isIndexNoEmpty)
                                       .toggleClass('is-invalid', !isUpinNoEmpty && !isIndexNoEmpty);
            }

            $("#upinNo, #indexNo").on("keyup input change", function () {
                validateFields();
            });
        });
    </script>
    
    
    
    <script>
    
    $(function () {
        $("#upinNo, #indexNo").on('change', function (event) {
        	var ptnValue = this.value;
            var appType;

            if (event.target.id === "upinNo") {
                appType = 1;
            } else if (event.target.id === "indexNo") {
                appType = 2;
            }          
           
                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/rtsapplication/getPropertyCollectionDetails.do?ptnNo=" + ptnValue+"&apptype="+appType,
                    dataType: "json",
                    success: function (data) {
                        var status = data.status;
                        if (status === true || status === 'true') {
                            $("#upinNo").val(data.ptn);
                            $("#indexNo").val(data.indexNo);
                            $("#address").val(data.address);
                            $("#blockNo").val(data.wardNo);
                            $("#blockId").val(data.blockNo);
                            $("#blockName").val(data.blockname);
                            $("#ownerName").val(data.ownerName);
                            $("#areasPending").val(data.arreaspending);
                            $("#areasPendingStatus").val(data.areaspaymentstatus);
                            $("#dues_amt").val(data.DueAmount);
                            $("#dues").val(data.DueAmount);
                            $("#taxMobileNo").val(data.mobileNo);
                            $("#taxPincode").val(data.pincode);
                            $("#propertyHolderName").val(data.occupierName);
                            $("#zoneNo").val(data.zone);
                            $("#houseNo").val(data.houseNo);
                            //getNoDuesCertificate(ptnValue,appType);
                            //ward();
                            var due=$("#dues_amt").val();
                            if(parseInt(due)>0){
                                showCustomAlert("Clear your dues before proceeding with further procedures. <br> Your pending dues: Rs." + due + "/- <br> To pay your pending dues, please use the following secure link: <a href='https://geocivicnmcapp.nmcptax.com/CitizenServices/CitizenTax/index.html' target='_blank'><br><button style='padding: 10px 16px; background-color: darkslategray; color: #fff; border:2px solid #a2bfde; border-radius: 4px; cursor: pointer; font-size: 14px; transition: background-color 0.3s;margin-top: 10px;'>Pay Now</button></a><br><br><button class='btn btn-primary btn_sm' type='button' id='submitBtn' value='Save'><i class='fa-solid fa-check'></i> <a href='<c:out value="${contextRoot}"/>/ws/nmc/dashboard/taxDepartment.do' style='color: ivory;'>Back to home</a></button>");

                                $("#submit").attr("disabled", true);
                                return false;
                            }else{
                            	 $("#submit").attr("disabled", false);
                            }
                        } else {
                            alert("Record Not Found! Please Enter Valid UPIN/Index No.");
                            $("#upinNo").val("");
                            $("#indexNo").val("");
                            $("#address").val("");
                            $("#blockNo").val("");
                            $("#blockName").val("");
                            $("#ownerName").val("");
                            $("#areasPending").val("");
                            $("#areasPendingStatus").val("");
                            $("#dues").val("");
                            $("#taxMobileNo").val("");
                            $("#taxPincode").val("");
                            $("#propertyHolderName").val("");
                            $("#zoneNo").val("");
                            $("#houseNo").val("");
                        }
                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                        alert("Something went wrong!!");
                        $("#upinNo").val("");
                        $("#indexNo").val("");
                        $("#address").val("");
                        $("#blockNo").val("");
                        $("#blockName").val("");
                        $("#ownerName").val("");
                        $("#areasPending").val("");
                        $("#areasPendingStatus").val("");
                        $("#dues").val("");
                        $("#taxMobileNo").val("");
                        $("#taxPincode").val("");
                        $("#propertyHolderName").val("");
                        $("#zoneNo").val("");
                    }
                });
            
        });
    });

   

    
    
  
        function getNoDuesCertificate(ptnValue,apptype) {
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/rtsapplication/getPropertyTaxNoDuesCertitifcate.do?ptnNo=" + ptnValue+"&apptype="+apptype,
                dataType: "json",
                //async: false,
                success: function (data) {
                    var status = data.status;
                	var dueAmt = data.duesAmt;
                	$('#due').val(dueAmt);
                    if (status === true || status === 'true') {
                    	return true;
                    } else {
                        alert("Please pay dues amount of Rs." + dueAmt + "/- in order to get a no dues certificate.");
                    	return false;
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("Something went wrong!!");
                }
            });
        }
        
        
        function showCustomAlert(message) {
            // Dynamically create modal elements
            var overlay = $('<div class="custom-alert-overlay"></div>');
            var modal = $('<div class="custom-alert-modal"></div>');
           // var closeBtn = $('<span class="custom-alert-close-btn" onclick="closeCustomAlert()">&times;</span>');
            var content = $('<div id="custom-alert-content"></div>');

            // Append elements to modal
           // modal.append(closeBtn);
            modal.append(content);
            overlay.append(modal);

            // Set content
            content.html(message);

            // Append overlay to body and display
            $('body').append(overlay);
            overlay.fadeIn();
        }

        function closeCustomAlert() {
            // Remove overlay when closing
            $('.custom-alert-overlay').fadeOut(function() {
                $(this).remove();
            });
        }
   

    </script>
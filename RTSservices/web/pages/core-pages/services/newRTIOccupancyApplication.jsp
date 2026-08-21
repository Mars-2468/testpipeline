<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.include
	file="/pages/core-pages/nmc_user/dashboard/header.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants" />
<jsp:directive.page import="com.mars.common.utils.CommonUtils" />



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
	href="/RTS/pages/core-pages/nmc_user/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/RTS/pages/core-pages/nmc_user/css/style2.css" />
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>
<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
	pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
	pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
	pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
	pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
	///pageContext.setAttribute("statusList", CommonUtils.getStatus());
%>

<script type="text/javascript">
       $(document).ready(function(){
  
  $("#submit").click(function(){
	  

	  $("form:first").addClass("needs-validation");
	  $("form:first").attr("novalidate","");
  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  const forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }else{
  		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveOccupancyCertificate.do');
      }

      form.classList.add('was-validated')
    }, false)
  })});
  
  $('input,select,textarea').on('focusout', function() {
  
  var isFileAllowed=true;
  if(this.getAttribute("type")=== 'file'){
  var name = this.files[0].name;
  if((this.files[0].size <2000000) && (name.endsWith('.pdf'))){
  isFileAllowed = true;
  }else{
  isFileAllowed = false;
  }
  }

  if(this.checkValidity() && isFileAllowed){
  this.classList.remove('is-invalid')
  this.classList.add('is-valid')
  }else{
  this.classList.remove('is-valid')
  this.classList.add('is-invalid')
  }
});
  
 
  
});
</script>

<head>
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


<!-- validating input field numeric only allow and spaces -->


 <script>
    function validateInput(event) {
      var input = event.target.value;       //validating input field only accept alphabets
      var regex = /^[a-zA-Z\s]*$/;
      var isValid = regex.test(input);
      
      if (!isValid) {
        event.target.value = input.replace(/[^A-Za-z]+/g, '');
      }
    }
  </script>
  


</head>
<body>

	<form>
		<div class="container-fluid mt-2" style="width: 180vh">
			<div class="printable">
				<h3 class="text-center">
					<strong>Application Form For Occupancy Certificate (भोगवटा प्रमाणपत्रासाठी अर्ज)</strong>
				</h3>
			</div>
			<h6 style="background-color: #dce2e8; padding: 10px;"
				class="  rounded-2">
				<strong> Applicant Details (अर्जदाराचे तपशील) </strong>
			</h6>
			<div class="row">
				<input type="hidden" name="token" value="xyz">
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Title (अर्जदाराचे शीर्षक) <span
							class="text-danger">*</span>
						</label> <select class="form-select" name="title" style="background-image: none;" required>
							<option value="">-Select-</option>
							<option value="1">Mr (श्री)</option>
							<option value="2">Mrs (सौ)</option>
							<option value="3">Ms (कु)</option>
						</select>
						<div class="invalid-feedback">Please Select title.</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Name (नाव)<span
							class="text-danger">*</span></label> <input type="text"
							class="form-control " id="first_name" placeholder=""
							name="firstName"  style="background-image: none;"  value="" maxlength="40"  pattern="[A-Za-z]+"
							onchange="Display(this.id)" required>
						<div class="invalid-feedback">Please Enter Valid First Name.
						</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Father's Name (वडिलांचे नाव)</label> <input
							type="text" class="form-control"  style="background-image: none;"  id="middle_name" placeholder=""
							name="middleName" value="" maxlength="80" 
							onchange="Display(this.id)">


					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Surname (आडनाव)<span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control"  style="background-image: none;"  name="lastName" id="last_name"
							value="" maxlength="80"  pattern="[A-Za-z]+" onchange="Display(this.id)" required>
						<div class="invalid-feedback">Please Enter Valid Last Name.
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Full Name (पूर्ण नाव) </label> <input
							type="text" class="form-control"   style="background-image: none;" id="full_name" placeholder=""
							name="fullName" value="" readonly>
					</div>
				</div>






				<script>
    function Display(id) {
                  $('#full_name').val( $('#first_name').val()+" "+ $('#middle_name').val()+" "+ $('#last_name').val())
            }

            function multiplyBy(form) {
            if (form.area.value <= 500) {
                document.getElementById("fees").value = 1000;
            }
            else if (form.area.value > 500) {
                document.getElementById("fees").value = document.getElementById("number").value * 2;
            }
        }
    </script>



				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Pin Code (पिन कोड) <span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control"  style="background-image: none;"  pattern="[0-9]{6}"
							name="pinCode" value="" maxlength="6" required>

						<div class="invalid-feedback">Please Enter Valid Pincode.</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label"> Aadhaar No. (आधार क्र.) </label> <input
							type="text" class="form-control "  style="background-image: none;"  id="aadhaarNumber1"
							placeholder="" name="aadharNo" value="" pattern="[0-9]{12}"
							maxlength="12">


					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">

						<label for="email" class="form-label lbleng">Email Id (ईमेल आयडी ) <span
							class="text-danger">*</span>
						</label> <input type="email" class="form-control "  style="background-image: none;"  name="email" value=""
							required>
						<div class="invalid-feedback">Please Enter Valid Email Id .
						</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label"> Mobile No. (मोबाईल क्र.)<span
							class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control " id="txtMobileNumber"
							placeholder="" name="mobileNo" value=""
							pattern="[6-9]{1}[0-9]{9}" maxlength="10"  style="background-image: none;"  required>
						<div class="invalid-feedback">Please Enter Mobile No.</div>
					</div>
				</div>


			<div class="col-md-12">
    <div class="mb-3 mt-3">
        <label for="primary_full_address" class="form-label">Address For Correspondence (पत्रव्यवहारासाठी पत्ता)<span class="text-danger">*</span></label>

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
                           

			<h6 style="background-color: #dce2e8; padding: 10px;"
				class="rounded-2">
				<strong> Application Form Details (अर्जाचा तपशील)</strong>
			</h6>
			<div class="row">
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Building No. (इमारत क्र.)<span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control" id="" pattern="^\s*\S.*$"   style="background-image: none;" placeholder=""
							name="buildingNo" value="" required>
						<div class="invalid-feedback">Please Enter Valid Building
							No.</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3" style="margin-top: 14px;">
						<label for="" class="form-label lbleng">Zone No. (झोन क्र.) 
						</label> <select class="form-select " style="background-image: none;"
							id="" name="zoneNo" >
							<option value="select-zone" selected="">-Select Zone-</option>
							<option value="Zone No.1 - Laxmi Nagar (लक्ष्मी नगर)">Zone
									No.1 - Laxmi Nagar (लक्ष्मी नगर)</option>
								<option value="Zone No.2 - Dharmpeth (धर्मपेठ)">Zone
									No.2 - Dharmpeth (धर्मपेठ)</option>
								<option value="Zone No.3 - Hanuman Nagar (हनुमान नगर)">Zone
									No.3 - Hanuman Nagar (हनुमान नगर)</option>
								<option value="Zone No.4 - Dhantoli (धंतोली)">Zone No.4
									- Dhantoli (धंतोली)</option>
								<option value="Zone No.5 - Nehru Nagar (नेहरू नगर)">Zone
									No.5 - Nehru Nagar (नेहरू नगर)</option>
								<option value="Zone No.6 - Gandhibag (गांधीबाग)">Zone
									No.6 - Gandhibag (गांधीबाग)</option>
								<option value="Zone No.7 - Satranjipura (सतरंजीपुरा)">Zone
									No.7 - Satranjipura (सतरंजीपुरा)</option>
								<option value="Zone No.8 - Lakadganj (लकडगंज)">Zone
									No.8 - Lakadganj (लकडगंज)</option>
								<option value="Zone No.9 - Aashi Nagar (आशी नगर)">Zone
									No.9 - Aashi Nagar (आशी नगर)</option>
								<option value="Zone No.10 - Mangalwari (मंगळवारी)">Zone
									No.10 - Mangalwari (मंगळवारी)</option>

						</select>


						<div class="invalid-feedback">Please Enter Valid Zone No.</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Plot No. (भूखंड क्र.)<span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control" id=""  pattern="^\s*\S.*$"  style="background-image: none;"  placeholder=""
							name="plotNo" value="" required="true">

						<div class="invalid-feedback">Please Enter Valid Plot No.</div>
					</div>
				</div>


				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Revenue No. (महसूल क्र.)<span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control" id=""  pattern="^\s*\S.*$" style="background-image: none;"  placeholder=""
							name="revenueNo" value="" required>
						<div class="invalid-feedback">Please Enter Valid Revenue No.
						</div>
					</div>
				</div>



				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Gat No.(गॅट क्र.)</label> <input type="text"
							class="form-control" id="" placeholder="" pattern="^\s*\S.*$"  style="background-image: none;"  name="gatNo" value="">
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Khasara No. (खसारा क्र.) <span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control" id=""  pattern="^\s*\S.*$"  style="background-image: none;"  placeholder=""
							name="khasaraNo" value="" required="true">
						<div class="invalid-feedback">Please Enter Valid Khasara No.
						</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">City Survey No. (सिटी सर्व्हे क्र.) <span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control" id="" pattern="^\s*\S.*$"   style="background-image: none;"  placeholder=""
							name="citySurveyNo" value="" required="true">
						<div class="invalid-feedback">Please Enter Valid City Survey
							No.</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Final Plot No.(अंतिम प्लॉट क्र.) <span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control" id=""  style="background-image: none;"  placeholder=""
							name="finalPlotNo" pattern="^\s*\S.*$" value="" required="true">
						<div class="invalid-feedback">Please Enter ValidFinal Plot
							No.</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Completion under the
							Supervision (Architect Name) (अंतर्गत पूर्ण
पर्यवेक्षण (आर्किटेक्टचे नाव))<span class="text-danger"
							style="color: red;">*</span>
						</label> <input type="text" class="form-control" id="" placeholder=""
							name="architectName" value="" pattern="^\s*\S.*$"  style="background-image: none;"  required="true">
						<div class="invalid-feedback">Please Enter Valid Completion
							under the Supervision .</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Licensed Engineer
							/Structural Engineer License No. (परवानाधारक अभियंता
/स्ट्रक्चरल अभियंता परवाना क्र) <span class="text-danger"
							style="color: red;">*</span>
						</label> <input type="text" class="form-control" id="" placeholder=""
							name="structuralLicenseNo" value=""  pattern="^\s*\S.*$"  style="background-image: none;" required="true">
						<div class="invalid-feedback">Please Enter Valid Licensed
							Engineer /Structural Engineer License No.</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3" style="margin-top: 64px;">
							<label for="" class="form-label lbleng">Mouza (मौजा)<span class="text-danger"
												style="color: red;">*</span>
										</label> <select class="form-select " style="background-image: none;"
											id="main-dropdown" name="mouje" required>
											<option value="" selected="">-Select Mouza-</option>
											<option value="PARSODI">PARSODI</option>
											<option value="BHAMTI">BHAMTI</option>
											<option value="JAITALA">JAITALA</option>
											<option value="SONEGAON">SONEGAON</option>
											<option value="SHIVANGAON">SHIVANGAON</option>
											<option value="CHIKHALI DEO">CHIKHALI DEO</option>
											<option value="KALAMANA">KALAMANA</option>
											<option value="WATHODA">WATHODA</option>
											<option value="HERITAGE">HERITAGE</option>
											<option value="NAGPUR">NAGPUR</option>
											<option value="DABHA">DABHA</option>
											<option value="PARDI">PARDI</option>
											<option value="PUNAPUR">PUNAPUR</option>
											<option value="BHARATWADA">BHARATWADA</option>
											<option value="INDORA">INDORA</option>
											<option value="BHANDEWADI">BHANDEWADI</option>
											<option value="HANSAPURI">HANSAPURI</option>
											<option value="JARIPATKA">JARIPATKA</option>
											<option value="JATTARODI">JATTARODI</option>
											<option value="NARI">NARI</option>
											<option value="TELANGKHEDI">TELANGKHEDI</option>
											<option value="TAKLI SIM">TAKLI SIM</option>
											<option value="NARA">NARA</option>
											<option value="BHANKHEDA">BHANKHEDA</option>
											<option value="LENDRA">LENDRA</option>
											<option value="AMBAZARI">AMBAZARI</option>
											<option value="KACHIMET">KACHIMET</option>
											<option value="FUTALA">FUTALA</option>
											<option value="POLICE LIKE TAKLI">POLICE LIKE TAKLI</option>
											<option value="SAKKARDARA">SAKKARDARA</option>
											<option value="WADPAKHAD">WADPAKHAD</option>
											<option value="GADGA">GADGA</option>
											<option value="SITABULDI">SITABULDI</option>
											<option value="BORGAON">BORGAON</option>
											<option value="HAJARIPAHAD">HAJARIPAHAD</option>
											<option value="GOREWADA">GOREWADA</option>
											<option value="ZINGABAI TAKLI">ZINGABAI TAKLI</option>
											<option value="BINAKHI">BINAKHI</option>
											<option value="SOMALWADA">SOMALWADA</option>
											<option value="MANKAPUR">MANKAPUR</option>
											<option value="AJANI">AJANI</option>
											<option value="BABULKHEDA">BABULKHEDA</option>
											<option value="WANJARA">WANJARA</option>
											<option value="WANJARI">WANJARI</option>
											<option value="DIGHORI">DIGHORI</option>
											<option value="BIDIPETH">BIDIPETH</option>
											<option value="HUDKESHWAR">HUDKESHWAR</option>
											<option value="NARSALA">NARSALA</option>
											<option value="PANDHARABODI">PANDHARABODI</option>
											<option value="DHANTOLI">DHANTOLI</option>
											<option value="MANEWADA">MANEWADA</option>
											<option value="HIWARI">HIWARI</option>
											<option value="CHIKHALI KHURD">CHIKHALI KHURD</option>
											<option value="HARPRU">HARPRU</option>
											<option value="DHARAMPETH">DHARAMPETH</option>
											<option value="KHAMLA">KHAMLA</option>
											<option value="CHINCHBHUWAN">CHINCHBHUWAN</option>


										</select>
										<div class="invalid-feedback">Please Enter Valid Mouza.</div>
									</div>
								</div>

								<input type="hidden" class="form-control" style="background-image: none;"
									name="mouzaZone" value="" id="mouzaZone" maxlength="6" required readonly>


							<script>
								$('#main-dropdown').on('change', function () {
									var selectedValue = $('#main-dropdown').val();
									var options = [];

									if (selectedValue === 'PARSODI' || selectedValue === 'BHAMTI' || selectedValue === 'JAITALA' || selectedValue === 'SONEGAON' || selectedValue === 'SHIVANGAON' || selectedValue === 'CHIKHALI DEO' || selectedValue === 'KALAMANA' || selectedValue === 'WATHODA' || selectedValue === 'HERITAGE') {
										$("#mouzaZone").val(1);
									} else if (selectedValue === 'NAGPUR' || selectedValue === 'DABHA' || selectedValue === 'PARDI' || selectedValue === 'PUNAPUR' || selectedValue === 'BHARATWADA' || selectedValue === 'INDORA' || selectedValue === 'BHANDEWADI' || selectedValue === 'HANSAPURI') {
										$("#mouzaZone").val(2);
									} else if (selectedValue === 'JARIPATKA' || selectedValue === 'JATTARODI' || selectedValue === 'NARI' || selectedValue === 'TELANGKHEDI' || selectedValue === 'TAKLI SIM' || selectedValue === 'NARA' || selectedValue === 'BHANKHEDA') {
										$("#mouzaZone").val(3);
									} else if (selectedValue === 'LENDRA' || selectedValue === 'AMBAZARI' || selectedValue === 'KACHIMET' || selectedValue === 'FUTALA' || selectedValue === 'POLICE LIKE TAKLI' || selectedValue === 'SAKKARDARA' || selectedValue === 'WADPAKHAD') {
										$("#mouzaZone").val(4);
									} else if (selectedValue === 'GADGA' || selectedValue === 'SITABULDI' || selectedValue === 'BORGAON' || selectedValue === 'HAJARIPAHAD' || selectedValue === 'GOREWADA' || selectedValue === 'ZINGABAI TAKLI' || selectedValue === 'BINAKHI' || selectedValue === 'SOMALWADA' || selectedValue === 'MANKAPUR') {
										$("#mouzaZone").val(5);
									} else if (selectedValue === 'AJANI' || selectedValue === 'BABULKHEDA' || selectedValue === 'WANJARA' || selectedValue === 'WANJARI' || selectedValue === 'DIGHORI' || selectedValue === 'BIDIPETH' || selectedValue === 'HUDKESHWAR' || selectedValue === 'NARSALA') {
										$("#mouzaZone").val(6);
									} else if (selectedValue === 'PANDHARABODI' || selectedValue === 'DHANTOLI' || selectedValue === 'MANEWADA' || selectedValue === 'HIWARI' || selectedValue === 'CHIKHALI KHURD' || selectedValue === 'HARPRU' || selectedValue === 'DHARAMPETH' || selectedValue === 'KHAMLA' || selectedValue === 'CHINCHBHUWAN') {
										$("#mouzaZone").val(7);
									} else if (selectedValue === 'select-mouza') {
										$("#mouzaZone").val("");
									}
								});


							</script>
				<div class="col-md-10">
					<div class="mb-4 mt-3">
						<label for="" class="form-label ">Application Fee Details (अर्ज फी तपशील)<span
							class="text-danger" style="color: red;"">*</span></label>
						<div class=" d-flex mt-2 border rounded p-2"
							style="height: 180px;">
							<div class="col-md-4 mb-3 ms-4">
								<div class="mb-3" style="margin-top: 15px;">
									<label for="" class="form-label">Occupancy Certificate
										(Minimum days for Occupancy Certificate is 30 days ) (भोगवटा प्रमाणपत्र
(भोगवटा प्रमाणपत्रासाठी किमान दिवस ३० दिवस आहेत))<span
										class="text-danger" style="color: red;">*</span>
									</label> <input type="number" class="form-control" id=""
										placeholder="Occupancy Certificate" pattern="^\s*\S.*$" 
										name="occupancyCertificate"  style="background-image: none;"  rows="4" min="30"
										onkeypress="return (event.charCode !=29 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))"
										 required></input>
								
								<div class="invalid-feedback">Please Enter Valid Days
							.</div></div>
                            
							</div>
							<div class="col-md-3 mb-3 ms-4">
								<div class="mb-3 ms-3" style="margin-top: 84px;">
									<label for="" class="form-label">Area (क्षेत्रफळ)<span
										class="text-danger" style="color: red;">*</span>
									</label> <input type="number" class="form-control" id="number"
										placeholder="Area in sq.mtr" name="area" pattern="^\s*\S.*$"  style="background-image: none;"
										oninput="multiplyBy(this.form)"
										onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))" required></input>
								
								<div class="invalid-feedback">Please Enter Valid Area
							.</div>
							</div></div>
							
							<div class="col-mb-3 ms-5">
								<div class="mb-3" style="margin-top: 35px; width: 300px;">
									<label for="" class="form-label">Fees Applicable (Auto
										calculate as per the basis on Area) (शुल्क लागू (ऑटो
क्षेत्रफळाच्या आधारावर गणना करा))<span class="text-danger"
										style="color: red;">*</span>
									</label> <input type="number" class="form-control" id="fees"  style="background-image: none;"
										placeholder="" name="feesApplicable" rows="4" readonly
										required></input>

								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<h6 class="mt-3">
						<strong> List of Documents (with attachment) (दस्तऐवजांची यादी (संलग्नकांसह)) </strong>
					</h6>
					<div class="alert alert-info mb-0 p-2 mb-3 ms-2">
						<small><strong>Note: </strong>Upload below files only .pdf (Max upto 2 MB)</small>
					</div>

					<input type="hidden" name="filesPath" id="filesPath" />
					<div class="col-md-3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label">Construction Starting
								Date Certificate (बांधकाम सुरू
तारीख प्रमाणपत्र)<span class="mand_error" style="color: red;">*</span>
							</label> <input type="file" accept=".pdf"  class="form-control" id="city_survey"
								placeholder=""  style="background-image: none;"  name="7/12_file" required="true"
								accept=".pdf">
								<div class="invalid-feedback ">File selected is either
							greater than 2Mb or not of type .pdf.</div>

						</div>
					</div>


					<!-- <div class="col-md-3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label"> City Survey Map
								Location<span class="mand_error" style="color: red;">*</span>
							</label> <input type="file" class="imagefile" id="idProof"
								style="width: 168px">
							<input type="button"
						class="ClsButton clsButtonUpload" id="idProof1" class="imagefile"
						value="Upload" onclick="javascript:upload();">

						</div>
					</div> -->



					<div class="col-md-3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label">Architect Certificate (वास्तुविशारद प्रमाणपत्र)<span
								class="mand_error" style="color: red;">*</span></label> <input
								type="file"  accept=".pdf" class="form-control"  style="background-image: none;"  id="city_survey1"
								placeholder="" name="7/12_file" required="true">
								<div class="invalid-feedback ">File selected is either
							greater than 2Mb or not of type .pdf.</div>

						</div>
					</div>

					<div class="col-md-3">
						<div class="mb-3" style="margin-top:40px;">
							<label for="" class="form-label">Tax Receipt(कर पावती)<span
								class="mand_error" style="color: red;">*</span></label> <input
								type="file" accept=".pdf"  class="form-control"  style="background-image: none;"  id="city_survey2"
								placeholder="" name="khasara" required="true">
								<div class="invalid-feedback ">File selected is either
							greater than 2Mb or not of type .pdf.</div>

						</div>
					</div>

					<div class="col-md-3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label">Construction Permission
								Certificate (बांधकाम परवानगी
प्रमाणपत्र)<span class="mand_error" style="color: red;">*</span>
							</label> <input type="file" accept=".pdf"  class="form-control"  style="background-image: none;"  id="city_survey3"
								placeholder="" name="khasara" required="true">
								<div class="invalid-feedback ">File selected is either
							greater than 2Mb or not of type .pdf.</div>

						</div>
					</div>

					<!--  <div>
						<div>
							<input type="button" class="ClsButton clsButtonUpload"
								id="idProof" class="imagefile" value="Upload"
								onclick="javascript:upload();">

						</div>
					</div>  -->
				</div>

				<div class="col-md-12">
					<div class="mb-5 mt-4">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" id="check1"
								name="option1"   style="background-image: none;" value="something" required> <label
								class="form-check-label ms-2"> <strong>Declaration(घोषणा):-
							</strong>I hereby declare that , all the information provided by me in the
								above application is true. If it found wrong or not related , I
								permit to reject the application.(मी याद्वारे घोषित करतो की, माझ्याद्वारे प्रदान केलेली सर्व माहिती
            वरील अर्ज खरा आहे. जर ते चुकीचे आढळले किंवा संबंधित नाही,
            मी अर्ज नाकारण्याची परवानगी देतो.)
							</label>
						</div>
					</div>
				</div>

				<div class="col-md-12 text-start mb-5">
					<div class="text-center">
						<button type="button" class="btn btn-danger btn_sm printMe">
							 View and Print
						</button>
						<button class="btn btn-success btn_sm" type="submit" id="submit"
							>
							 Submit
						</button>
					</div>
				</div>

			</div>
		</div>
	</form>
	
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

                        <h6><strong>Note(नोंद): </strong> Upload below files in .pdf...Max upto 2 MB(खालील फाइल .pdf मध्ये अपलोड करा..कमाल २ MB पर्यंत)</h6>

                    </div>

                    <!-- dialog body -->

                    <div class="modal-body" style="color:green">



                      <p style="color:red">

                        <strong>List of document to be attached :
                        </strong>    
                        </p>

                        <ul style="color:rgb(3, 125, 76)">




                            <li>1.Construction Starting
								Date Certificate (बांधकाम सुरू
तारीख प्रमाणपत्र)<span class="text-danger"  style="color: red;">*</span></li>
                            <li>2.Architect Certificate (वास्तुविशारद प्रमाणपत्र)<span class="text-danger"  style="color: red;">*</span> </li>
                            <li>3.Tax Receipt(कर पावती)<span class="text-danger"  style="color: red;">*</span></li>
  <li>4.Construction Permission Certificate (बांधकाम परवानगी प्रमाणपत्र)<span class="text-danger"  style="color: red;">*</span></li>
                        </ul>

                    </div>

                    <!-- dialog buttons -->

                    <div class="modal-footer"><button type="button" class="btn btn-primary">OK</button></div>

                </div>

            </div>

        </div>
</html>

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
                                onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveOccupancyCertificate.do');
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
            var basePath = url.split('${contextRoot}')[0] + '${contextRoot}/';
            var filesPath = "";
            var data = new FormData();

            	data.append('idProof1', $("#city_survey").get(0).files[0]);
	data.append('idProof2', $("#city_survey1").get(0).files[0]);
	data.append('idProof3', $("#city_survey2").get(0).files[0]);
	data.append('idProof4', $("#city_survey3").get(0).files[0]);




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
                    filesPath = filesPath + basePath + "occupancyCertificates/" + id + value + ","
                    isFileSelected = true;
                }
            }
            $.ajax({
                url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadDocumentOccupancy.do?id="+id,
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
	
</body>
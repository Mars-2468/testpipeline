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
     size: auto ;
     }
</style>
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
       onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveMobileTower.do');
   }

   form.classList.add('was-validated')
 }, false)
})});

$('input,select,textarea').on('focusout', function() {

var isFileAllowed=true;
if(this.getAttribute("type")=== 'file'){
var name = this.files[0].name;
if((this.files[0].size <5000000) && (name.endsWith('.pdf'))){
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


</head>
<body>


	<form class="needs-validation" novalidate>
		<div class="container-fluid mt-2" style="width: 180vh">
			<div class="printable">
				<h3 class="text-center">Application Form For Mobile Tower
					(मोबाईल टॉवरसाठी अर्ज)</h3>
			</div>

			<h6 style="background-color: #dce2e8; padding: 10px;"
				class="  rounded-2">
				<strong> Applicant Details (अर्जदाराचे तपशील) </strong>
			</h6>
			<div class="row">
				<input type="hidden" name="_token" value="xyz">


				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Applicant Name
							(अर्जदाराचे नाव)<span class="text-danger">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="" placeholder="" name="name"
							value="" pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" required>
						<div class="invalid-feedback">Please Enter Valid Company
							Name.</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Applicant Address
							(अर्जदाराचा पत्ता)<span class="text-danger">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="" placeholder=""
							name="address" value="" required>
						<div class="invalid-feedback">Please Enter Valid Company
							Address.</div>

					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Owner Name
							(मालकाचे नाव)<span class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" name="ownerName" id="" value=""
							pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" required>
						<div class="invalid-feedback">Please Enter Valid Owner Name.
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Owner Address (मालकाचा
							पत्ता)<span class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="Owner_address" placeholder=""
							name="ownerAddress" value="" required>
						<div class="invalid-feedback">Please Enter Valid Owner
							Address.</div>
					</div>
				</div>


				<script>
                        function Display(id) {
                                      $('#full_name').val( $('#first_name').val()+" "+ $('#middle_name').val()+" "+ $('#last_name').val())
                                }
                        </script>




				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label ">Plot/Flat No
							(प्लॉट/फ्लॅट क्र)<span class="text-danger" style="color: red;"">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="" placeholder=""
							name="plotNo" value="" required>
						<div class="invalid-feedback">Please Enter Valid Plot/Flat
							No</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label ">Name of the Area
							(क्षेत्राचे नाव)<span class="text-danger" style="color: red;"">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="" placeholder="" name="area"
							value="" required>
						<div class="invalid-feedback">Please Enter Valid Area</div>
					</div>
				</div>


				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label ">Name of the Street
							(रस्त्याचे नाव)</label> <input type="text" class="form-control"
							style="background-image: none;" id="street_name" placeholder=""
							name="streetName" value="" required>
						<div class="invalid-feedback">Please Enter Valid Name of the
							Street</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label ">House Mauza No. (घर मौजा
							क्र.)<span class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="" placeholder=""
							name="applicantMouza" value="" required>
						<div class="invalid-feedback">Please Enter Valid House Mouza
							No.</div>
					</div>
				</div>





				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Pin Code (पिन कोड)<span
							class="text-danger">*</span></label> <input type="text"
							class="form-control" style="background-image: none;"
							pattern="[0-9]{6}" name="pincode" value="" maxlength="6" required>
						<div class="invalid-feedback">Please Enter Valid Pin Code.</div>

					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label"> Aadhaar No. (आधार क्र.)
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="aadhaarNumber" placeholder=""
							name="aadhaarNo" value="" pattern="[0-9]{12}" maxlength="12">
						<div class="invalid-feedback">Please Enter Valid Aadhaar No.
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">

						<label for="email" class="form-label lbleng"> Email Id (ई
							- मेल आयडी)<span class="text-danger">*</span>
						</label> <input type="email" class="form-control"
							style="background-image: none;" name="email" value="" required>
						<div class="invalid-feedback">Please Enter Valid Email Id.</div>
					</div>
				</div>


				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label"> Mobile No. (मोबाईल क्र.)<span
							class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="txtMobileNumber"
							placeholder="" name="mobileNo" value=""
							pattern="[6-9]{1}[0-9]{9}" maxlength="10" required>
						<div class="invalid-feedback">Please Enter Valid Mobile No.
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="mb-3 mt-3 ">
						<label for="primary_full_address" class="form-label lbleng">Current
							Address Applicant (सध्याचा पत्ता अर्जदार)&nbsp;&nbsp;(Same as
							above (वरील
							प्रमाणे)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="radio" class="form-check-input" name="yes" id="yes"
							onclick="change(this.id)"> Yes
							(होय)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
							type="radio" class="form-check-input" name="yes" id="no"
							onclick="change(this.id)">No (नाही)&nbsp;)<span
							class="text-danger">*</span>
						</label>

						<textarea class="form-control"
							style="background-image: none; background-color: white" rows="2"
							id="currentAddress" name="currentAddress" readonly required></textarea>
						<div class="invalid-feedback">Please Enter Valid Current
							Address.</div>

					</div>
				</div>
				<script>
                        function change()
                        {
                            var isOperated = $("#yes").prop('checked');
                            if(isOperated==true){
                            $("#currentAddress").attr("readonly", false);
                            $("#currentAddress").val($("#Owner_address").val())
                             } else{
                            $("#currentAddress").val(" ")
                             }
                        }

                    </script>


			</div>
			<br>





			<h6 style="background-color: #dce2e8; padding: 10px;"
				class="  rounded-2">
				<strong> Application Form Details (अर्जाचा तपशील)</strong>
			</h6>

			<div class="row">

				<div class="col-md-3">
					<div class="mb-3 mt-4">
						<label for="" class="form-label ">Mouza (मौजा)<span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control" style="background-image: none;"
							id="" placeholder="" name="mouza" value="" required>
						<div class="invalid-feedback">Please Enter Valid Mouza.</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-4">
						<label for="" class="form-label ">Sheet No. (पत्रक क्र.)<span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control" style="background-image: none;"
							id="" placeholder="" name="sheetNo" value="" required>
						<div class="invalid-feedback">Please Enter Valid Sheet No.</div>
					</div>
				</div>


				<div class="col-md-3">
					<div class="mb-3 mt-0">
						<label for="" class="form-label ">City Survey No/Plot No.<br>(सिटी
							सर्व्हे नंबर/प्लॉट क्र.)<span class="text-danger"
							style="color: red;">*</span></label> <input type="text"
							class="form-control" style="background-image: none;" id=""
							placeholder="" name="citySurveyNo" value="" required>
						<div class="invalid-feedback">Please Enter Valid City Land
							Survey No.</div>
					</div>
				</div>



				<div class="col-md-3">
					<div class="mb-3 mt-4">
						<label for="" class="form-label lbleng">NMC Zone No.
							(एनएमसी झोन क्र.)<span class="text-danger" style="color: red;"
							onclick="Zoneno(this.form)">*</span>
						</label> <select class="form-select " style="background-image: none;"
							id="main-dropdown" name="zoneNo" required>
							<option value="1">Zone No.1 - Laxmi Nagar (लक्ष्मी नगर)</option>
                                <option value="2">Zone No.2 - Dharmpeth (धरमपेठ)</option>
                                <option value="3">Zone No.3 - Hanuman Nagar (हनुमान नगर)</option>
                                <option value="4">Zone No.4 - Dhantoli (धंतोली)</option>
                                <option value="5">Zone No.5 - Nehru Nagar (नेहरू नगर)</option>
                                <option value="6">Zone No.6 - Gandhibag (गांधीबाग)</option>
                                <option value="7">Zone No.7 - Satranjipura (सतरंजीपुरा)</option>
                                <option value="8">Zone No.8 - Lakadganj (लकडगंज)</option>
                                <option value="9">Zone No.9 - Aashi Nagar (आशी नगर)</option>
                                <option value="10">Zone No.10 - Mangalwari (मंगळवारी)</option>
						</select>
						<div class="invalid-feedback">Please Enter Valid Zone No.</div>
					</div>
				</div>


				<div class="col-md-3 hospital_row" id="hos">
					<div class="mb-3 mt-4">
						<label for="" class="form-label"> Ward No. (प्रभाग क्र.) <span
							class="text-danger" style="color: red;">*</span></label> <select
							class="form-select " style="background-image: none;"
							id="dependent-dropdown" name="wardNo" disabled required>

							<option value="select-ward" selected="">-Select Ward-</option>
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



				<div class="col-md-3">
					<div class="mb-3 mt-4">
						<label for="" class="form-label ">Municipal House No.
							(महापालिकेचे घर क्र.) <span class="text-danger"
							style="color: red;">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="" placeholder=""
							name="municipalMouza" value="" required>
						<div class="invalid-feedback">Please Enter Valid Municipal
							House No.</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-4">
						<label for="" class="form-label ">UPIN No/Index No. (UPIN
							क्रमांक/इंडेक्स क्र.)<span class="text-danger"
							style="color: red;">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="" placeholder="" name="upin"
							value="" required>
						<div class="invalid-feedback">Please Enter Valid Index No.</div>
					</div>
				</div>



				<div class="col-md-3">
					<div class="mb-3 mt-0">
						<label for="" class="form-label "> Layout /Society Name<br>(लेआउट/सोसायटीचे
							नाव) <span class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control" style="background-image: none;"
							id="" placeholder="" name="societyName" value="" required>
						<div class="invalid-feedback">Please Enter Valid
							Layout/Complex Name.</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label ">Name of the Building
							Owner / Name of the Housing Association (इमारत मालकाचे नाव/
							हाऊसिंग असोसिएशनचे नाव)<span class="text-danger"
							style="color: red;">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="" placeholder=""
							name="buildingOwner" value=""
							pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" required>
						<div class="invalid-feedback">Please Enter Valid Name of the
							Building Owner.</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3" style="margin-top: 63px">
						<label for="" class="form-label ">Site Address (साइट
							पत्ता) <span class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="" placeholder=""
							name="siteAddress" value="" required>
						<div class="invalid-feedback">Please Enter Valid Site
							Address.</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label ">Applicant Mobile Tower
							Company Name / Applicant Name (अर्जदार मोबाईल टॉवर कंपनीचे नाव /
							अर्जदाराचे नाव) <span class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="" placeholder=""
							name="mobileTowerCompanyName" value=""
							pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" required>
						<div class="invalid-feedback">Please Enter Valid Applicant
							Mobile Tower Company Name / Applicant Name</div>
					</div>
				</div>


				<div class="col-md-3">
					<div class="mb-3" style="margin-top: 63px;">
						<label for="" class="form-label lbleng">Tower Type (टॉवर
							प्रकार):<span class="text-danger" style="color: red;">*</span>
						</label> <select class="form-select" style="background-image: none;"
							name="towerType" required>
							<option value="" selected="">-Select Tower Type-</option>
							<option value="Rooftop">Rooftop</option>
							<option value="Ground base">Ground base</option>


						</select>
						<div class="invalid-feedback">Please Select Tower Type.</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label ">Tower's use started date<br>(टॉवरचा
							वापर सुरू होण्याची तारीख) <span class="text-danger"
							style="color: red;">*</span></label> <input type="date"
							class="form-control" style="background-image: none;" id=""
							placeholder="" name="startedDate" value="" required>
						<div class="invalid-feedback">Please Enter Valid Tower’s use
							started date.</div>
					</div>
				</div>
				<div class="col-md-9">
					<div class="mb-3 mt-3">
						<label for="" class="form-label ">Tower’s Category (टॉवरची
							श्रेणी) <span class="text-danger" style="color: red;">*</span>
						</label>

						<div class="d-flex mt-2 border rounded  p-2">
							<div class="form-check ms-3">
								<input type="radio" class="form-check-input" id="radio3"
									name="pob" value="1" required> Building With Occupancy
								certificate (भोगवटा प्रमाणपत्रासह इमारत) <label
									class="form-check-label" for="radio1"></label>
							</div>
							<div class="form-check ms-3">
								<input type="radio" class="form-check-input" id="radio3"
									name="pob" value="2" required>Building Plan approved
								but Occupancy Certificate Not Available (इमारतीचा आराखडा मंजूर
								झाला पण भोगवटा प्रमाणपत्र उपलब्ध नाही) <label
									class="form-check-label" for="radio1"></label>
							</div>

							<div class="form-check ms-3">
								<input type="radio" class="form-check-input" id="radio4"
									name="pob" value="3" required>Building With no sanction
								plan with occupancy certificate (भोगवटा प्रमाणपत्रासह कोणतीही
								मंजुरी योजना नसलेली इमारत)
								<div class="invalid-feedback">Please Select Valid Tower’s
									Category.</div>
								<label class="form-check-label" for="radio1"></label>
							</div>
						</div>


					</div>

				</div>

				<label><strong>Tower’s Area (टॉवरचे क्षेत्र)</strong></label>
				<div class="col-md-3">
					<div class="mb-3 mt-4">
						<label for="" class="form-label ">i)Manora Area (मानोरा
							परिसर) <span class="text-danger" style="color: red;">*</span>
						</label> <input id="Manora_Area" type="number" class="form-control"
							style="background-image: none;" placeholder="Sq.Mtr."
							onchange="totalarea(this.id)" name="manoraArea" value="" required>
						<div class="invalid-feedback">Please Enter Valid Manora Area

						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-0">
						<label for="" class="form-label ">ii)Diesel Generator
							Sector<br>(डिझेल जनरेटर क्षेत्र) <span class="text-danger"
							style="color: red;">*</span>
						</label> <input type="number" class="form-control"
							style="background-image: none;" id="Diesel_Generator"
							placeholder="Sq.Mtr." onchange="totalarea(this.id)"
							name="dieselGeneratorSector" value="" required>
						<div class="invalid-feedback">Please Enter Valid Manora Area

						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-0">
						<label for="" class="form-label ">(iii) Panel Control Room
							Area<br>(पॅनेल नियंत्रण कक्ष क्षेत्र) <span
							class="text-danger" style="color: red;">*</span>
						</label> <input id="Panel_Control" type="number" class="form-control"
							style="background-image: none;" placeholder="Sq.Mtr."
							onchange="totalarea(this.id)" name="panelControlRoomArea"
							value="" required>
						<div class="invalid-feedback">Please Enter Valid Manora Area

						</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-4">
						<label for="" class="form-label ">Total Area (एकूण
							क्षेत्रफळ) <span class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="Total_area"
							placeholder="Sq.Mtr." name="totalArea" value="" required readonly>
						<div class="invalid-feedback">Please Enter Valid Manora Area
						</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3" style="margin-top: 27px">
						<label for="" class="form-label ">Scrutiny Fees (SGST 9% +
							CGST 9%)<br>(छाननी शुल्क) <span class="text-danger"
							style="color: red;">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="Scrutiny_Fees"
							placeholder="Sq.Mtr." name="scrutinyFees" value="" required
							readonly>
						<div class="invalid-feedback">Please Enter Valid Scrutiny
							Fees</div>
					</div>
				</div>


				<div class="col-md-3">
					<div class="mb-3 mt-1">
						<label for="" class="form-label ">Scrutiny Fee +
							permission fee /administrative fee (10,000/-) (छाननी फी + परवानगी
							फी/प्रशासकीय फी (10,000/-)) <span class="text-danger"
							style="color: red;">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="total_Fees"
							placeholder="Sq.Mtr." name="totalFees" value="" required readonly>
						<div class="invalid-feedback">Please Enter Valid Fees</div>
					</div>
				</div>

				<script>
                        function totalarea()
                        {
                            var PC=parseInt($('#Panel_Control').val())
                            var DG=parseInt($('#Diesel_Generator').val())
                            var MA=parseInt($('#Manora_Area').val())
                            var total=PC+DG+MA;
                            $('#Total_area').val(total)
                            var Fees=total*5;
                            var GstFees=((Fees*18)/100)+Fees
                            $('#Scrutiny_Fees').val(GstFees)
                            var totalFees = GstFees + 10000;
                            $('#total_Fees').val(totalFees)
                            
                        }
                </script>


				<div class="row">
					<div class="col-md-3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label ">The existing height of
								the tower<br>(टॉवरची विद्यमान उंची) <span
								class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control"
								style="background-image: none;" id="" placeholder="mtr"
								name="existingHeight" value="" required>
							<div class="invalid-feedback">Please Enter Valid The
								existing height of the tower is.........m.</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label ">Total height of the
								building + tower<br>(इमारतीची एकूण उंची + टॉवर)<span
								class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control"
								style="background-image: none;" id="" placeholder="mtr"
								name="totalHeight" value="" required>
							<div class="invalid-feedback">Please Enter Valid The total
								height of the building + tower is…………………..…….m.</div>
						</div>
					</div>

					<input type="hidden" name="filesPath" id="filesPath" />

					<div class="col-md-3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label">Upload Latitude and
								Longitude image (अक्षांश आणि रेखांश प्रतिमा अपलोड करा)<span
								class="text-danger" style="color: red;">*</span>
							</label> <input type="file" class="form-control"
								style="background-image: none;" id="doc1" placeholder=""
								name="latitudeAndLongitude" required>
						</div>
					</div>

					<a onchange="locat()"></a>


				</div>


			</div>


			<div class="row">


				<h6 class="mt-3">
					<strong> List of Documents (with attachment) (कागदपत्रांची
						यादी (संलग्नकांसह))</strong>
				</h6>

				<div class="alert alert-info mb-0 p-2 ms-2">
					<small><strong>Note: </strong>Upload below files only
						.pdf(Max upto 5 MB) (खालील फाइल .pdf मध्ये अपलोड करा (कमाल ५ MB
						पर्यंत))</small>
				</div>

				<div class="col-md-3">
					<div class="mb-3" style="margin-top: 55px;">
						<label for="" class="form-label"> Ownership Documents
							/Sale deed/ Leasing /Property Card (मालकी दस्तऐवज / विक्री करार /
							लीजिंग / मालमत्ता कार्ड)<span class="text-danger"
							style="color: red;">*</span>
						</label> <input type="file" class="form-control"
							style="background-image: none;" id="doc2" placeholder=""
							name="ownershipDocument" id="upload"
							onchange="readURL(this.value)" required>
						<div class="invalid-feedback">File selected is either
							greater than 5Mb or not of type .pdf.</div>
					</div>



				</div>

				<div class="col-md-3">
					<div class="mb-3" style="margin-top: 32px;">
						<label for="" class="form-label">Building occupancy
							certificate/Building construction permit letter/approval map
							(इमारत भोगवटा प्रमाणपत्र/इमारत बांधकाम परवानगी पत्र/मंजुरी नकाशा)
						</label> <input type="file" class="form-control"
							style="background-image: none;" id="doc3" placeholder=""
							name="buildingOccupancy" required>
						<div class="invalid-feedback">File selected is either
							greater than 5Mb or not of type .pdf.</div>
					</div>
				</div>


				<div class="col-md-3">
					<div class="mb-3" style="margin-top: 32px">
						<label for="" class="form-label">Location Plan Site
							Plan/Block Plan/Proposed Work Map related to Tower (टॉवरशी
							संबंधित लोकेशन प्लॅन साइट प्लॅन/ब्लॉक प्लॅन/प्रस्तावित कामाचा
							नकाशा) <span class="text-danger" style="color: red;">*</span>
						</label> <input type="file" class="form-control"
							style="background-image: none;" id="doc4" placeholder=""
							name="locationPlan" required>
						<div class="invalid-feedback">File selected is either
							greater than 5Mb or not of type .pdf.</div>

					</div>



				</div>
				<div class="col-md-3">
					<div class="mb-3" style="margin-top: 80px;">
						<label for="" class="form-label">Structural Stability
							Certificate of the building (इमारतीचे स्ट्रक्चरल स्थिरता
							प्रमाणपत्र) <span class="text-danger" style="color: red;">*</span>
						</label> <input type="file" class="form-control"
							style="background-image: none;" id="doc5" placeholder=""
							name="structuralStabilityCertificate" required>
						<div class="invalid-feedback">File selected is either
							greater than 5Mb or not of type .pdf.</div>

					</div>



				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-2">
						<label for="" class="form-label">No Objection Certificate
							of more than 70% of the flat holders in case of building having
							more than one flat holder (एकापेक्षा जास्त सदनिकाधारक असलेल्या
							इमारतीच्या बाबतीत ७०% पेक्षा जास्त सदनिकाधारकांचे ना हरकत
							प्रमाणपत्र) </label> <input type="file" class="form-control"
							style="background-image: none;" id="doc6" placeholder=""
							name="noObjectionCertificate" required>
						<div class="invalid-feedback">File selected is either
							greater than 5Mb or not of type .pdf.</div>

					</div>



				</div>
				<div class="col-md-3">
					<div class="mb-3" style="margin-top: 105px">
						<label for="" class="form-label">Updated Municipal Tax
							Receipt (Current Year) (अद्ययावत नगरपालिका कर पावती (चालू वर्ष))</label>
						<input type="file" class="form-control"
							style="background-image: none;" id="doc7" placeholder=""
							name="taxReceipt" required>
						<div class="invalid-feedback">File selected is either
							greater than 5Mb or not of type .pdf.</div>

					</div>



				</div>
				<div class="col-md-3">
					<div class="mb-3" style="margin-top: 57px">
						<label for="" class="form-label">If the land is owned by a
							housing society, a copy of the resolution taken by the society
							(जर जमीन गृहनिर्माण संस्थेच्या मालकीची असेल तर सोसायटीने
							घेतलेल्या ठरावाची प्रत) </label> <input type="file" class="form-control"
							style="background-image: none;" id="doc8" placeholder=""
							name="housingSociety">
						<div class="invalid-feedback">File selected is either
							greater than 5Mb or not of type .pdf.</div>

					</div>



				</div>
				<div class="col-md-3">
					<div class="mb-3" style="margin-top: 80px">
						<label for="" class="form-label"> ARAI Certificate for
							Diesel Generators (DG.) Set (डिझेल जनरेटरसाठी ARAI प्रमाणपत्र
							(DG.) सेट) </label> <input type="file" class="form-control"
							style="background-image: none;" id="doc9" placeholder=""
							name="dieselGenerators" required>
						<div class="invalid-feedback">File selected is either
							greater than 5Mb or not of type .pdf.</div>

					</div>



				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label"> Copy of clearance from
							Fire Safety Department only in case for high rise buildings where
							Fire Clearance is mandatory (फायर सेफ्टी विभागाच्या मंजुरीची प्रत
							फक्त उंच इमारतींच्या बाबतीत जेथे फायर क्लिअरन्स अनिवार्य आहे) </label> <input
							type="file" class="form-control" style="background-image: none;"
							id="doc10" placeholder="" name="fireDept" required>
						<div class="invalid-feedback">File selected is either
							greater than 5Mb or not of type .pdf.</div>

					</div>



				</div>
				<div class="col-md-3">
					<div class="mb-3" style="margin-top: 40px">
						<label for="" class="form-label"> No-encroachment
							certificate for forest protected area from the state environment
							department and forest department (राज्य पर्यावरण विभाग आणि वन
							विभागाकडून वन संरक्षित क्षेत्रासाठी अतिक्रमण नाही प्रमाणपत्र)</label> <input
							type="file" class="form-control" style="background-image: none;"
							id="doc11" placeholder="" name="noEncroachmentCertificate"
							required>
						<div class="invalid-feedback">File selected is either
							greater than 5Mb or not of type .pdf.</div>

					</div>



				</div>
				<div class="col-md-3">
					<div class="mb-3" style="margin-top: 87px">
						<label for="" class="form-label"> Exemption Certificate
							from Director Microwave Project (मायक्रोवेव्ह प्रकल्प
							संचालकांकडून सूट प्रमाणपत्र)</label> <input type="file"
							class="form-control" style="background-image: none;" id="doc12"
							placeholder="" name="exemptionCertificate" required>
						<div class="invalid-feedback">File selected is either
							greater than 5Mb or not of type .pdf.</div>

					</div>



				</div>
				<div class="col-md-3">
					<div class="mb-3" style="margin-top: 110px">
						<label for="" class="form-label"> Acknowledgement of TERM
							Cell (TERM सेलची पोचपावती) <span class="text-danger"
							style="color: red;">*</span>
						</label> <input type="file" class="form-control"
							style="background-image: none;" id="doc13" placeholder=""
							name="certificateOfTermCell" required>
						<div class="invalid-feedback">File selected is either
							greater than 5Mb or not of type .pdf.</div>

					</div>



				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label"> If the building where
							the tower is erected is not owned by the company, then a lease or
							agreement with the person or organization that owns the building
							(ज्या इमारतीत टॉवर उभारण्यात आला आहे ती इमारत कंपनीच्या मालकीची
							नसल्यास, इमारत मालकीची व्यक्ती किंवा संस्थेशी भाडेपट्टी किंवा
							करार) <span class="text-danger" style="color: red;">*</span>
						</label> <input type="file" class="form-control"
							style="background-image: none;" id="doc14" placeholder=""
							name="agreement" required>
						<div class="invalid-feedback">File selected is either
							greater than 5Mb or not of type .pdf.</div>

					</div>



				</div>
				<div class="col-md-3">
					<div class="mb-3" style="margin-top: 87px;">
						<label for="" class="form-label"> Certificate of Standing
							Advisory Committee for Frequency Allocation SACFA (वारंवारता वाटप
							SACFA साठी स्थायी सल्लागार समितीचे प्रमाणपत्र)</label> <input type="file"
							class="form-control" style="background-image: none;" id="doc15"
							placeholder="" name="advisooryCommittee" required>
						<div class="invalid-feedback">File selected is either
							greater than 5Mb or not of type .pdf.</div>

					</div>



				</div>
				<!--                 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 -->
				<div class="col-md-3">
					<div class="mb-3" style="margin-top: 125px">
						<label for="" class="form-label"> Letter of Guarantee
							(Hamipatra)<br>(हमीपत्र): <span class="text-danger"
							style="color: red;">*</span> <a class="fa fa-download"
							onClick="downloadFiles()" style="color: blue;"> </a>
						</label> <input type="file" class="form-control"
							style="background-image: none;" id="doc16" placeholder=""
							name="letterOfGuarantee" required>
						<div class="invalid-feedback">File selected is either
							greater than 5Mb or not of type .pdf.</div>

					</div>
				</div>




				<div class="col-md-3">
					<div class="mb-3" style="margin-top: 85px">
						<label for="" class="form-label"> Registered under BPMS
							Architect / Structural Engineer Name and signature (BPMS
							आर्किटेक्ट / स्ट्रक्चरल इंजिनियर नाव आणि स्वाक्षरी अंतर्गत
							नोंदणीकृत) </label> <input type="file" class="form-control"
							style="background-image: none;" id="doc17" placeholder=""
							name="structuralEngineer" required>
						<div class="invalid-feedback">File selected is either
							greater than 5Mb or not of type .pdf.</div>

					</div>
				</div>


			</div>
			<div class="col-md-12">
				<div class="mb-5 mt-4 ">
					<div class="form-check">
						<input class="form-check-input" type="checkbox" id=""
							name="declaration" value="something" required> <label
							class="form-check-label ms-2"> <strong>Declaration<span
								class="text-danger" style="color: red;">*</span>:-
						</strong>I hereby declare that , all the information provided by me in the
							above application is true. If it found wrong or not related , I
							permit to reject the application.<br>(मी याद्वारे घोषित करतो
							की, वरील अर्जात मी दिलेली सर्व माहिती खरी आहे. जर ते चुकीचे आढळले
							किंवा संबंधित नाही, तर मी अर्ज नाकारण्याची परवानगी देतो.)
						</label>
						<div class="invalid-feedback">Please check the declaration.
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-12 text-start mb-5">
				<div class="text-center">
					<button type="button" class="btn btn-danger btn_sm printMe">
						View and Print</button>
					<button class="btn btn-success btn_sm" type="submit" id="submit"
						onclick="javascript:upload();">Submit</button>
				</div>
			</div>
		</div>

		</div>
	</form>



</body>







<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://code.jquery.com/jquery-3.6.1.js"></script>

<script type="text/javascript">
$('.printMe').on('click', function () {

    window.print();
});
</script>

<script type="text/javascript">


    $.ajaxSetup({
        beforeSend: function () {
            $("#overlay").fadeIn();
            $('body').css({
                'cursor': 'progress'
            });

        },
        complete: function () {
            $("#overlay").fadeOut();
            $('body').css({
                'cursor': 'default'
            });
        }
    });


    </script>
<script>
    function changeddl(obj) {
        if (document.getElementById("iFunction").value > 0) {

            document.getElementById("iOperation").removeAttribute('disabled');
            var text = obj.options[obj.selectedIndex].text;
            var ddl2 = document.querySelectorAll('#iOperation option');
            for (var i = 1; i < ddl2.length; i++) {
                var option = ddl2[i];
                option.style.display = 'none';
                if (text == 'Zone No.1 - Laxmi Nagar (लक्ष्मी नगर)') {
                    if (['Ward No. 36', 'Ward No. 37', 'Ward No. 38'].indexOf(option.text) > -1)
                        option.style.display = 'block'

                }
                if (text == 'Zone No.2 - Dharmpeth (धरमपेठ)') {
                    if (['Ward No. 12', 'Ward No. 13', 'Ward No. 14', 'Ward No. 15'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.3 - Hanuman Nagar (हनुमान नगर)') {
                    if (['Ward No. 29', 'Ward No. 31', 'Ward No. 32', 'Ward No. 34'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.4 - Dhantoli (धंतोली)') {
                    if (['Ward No. 17', 'Ward No. 33', 'Ward No. 35'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.5 - Nehru Nagar (नेहरू नगर)') {
                    if (['Ward No. 26', 'Ward No. 27', 'Ward No.28', 'Ward No. 30'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.6 - Gandhibag (गांधीबाग)') {
                    if (['Ward No. 8', 'Ward No. 18', 'Ward No. 19', 'Ward No. 22'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.7 - Satranjipura (सतरंजीपुरा)') {
                    if (['Ward No. 5', 'Ward No. 20', 'Ward No. 21'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.8 - Lakadganj (लकडगंज)') {
                    if (['Ward No. 4', 'Ward No. 23', 'Ward No. 24', 'Ward No. 25'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.9 - Aashi Nagar (आशी नगर)') {
                    if (['Ward No. 2', 'Ward No. 3', 'Ward No. 6', 'Ward No. 7'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.10 - Mangalwari (मंगळवारी)') {
                    if (['Ward No. 1', 'Ward No. 9', 'Ward No. 10', 'Ward No. 11'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
            }
        }
    }



        
        function upload() {
            console.log("@@upoading@@");
            var url = window.location.href;
    		//var url = 'https://rtsnagpur.egovmars.in'; // The window.location.href property in JavaScript returns the URL of the currently open web page. This property can even be used to update the URL of a web page.
            var basePath = url.split('${contextRoot}')[0] + '${contextRoot}/';
            var filesPath = "";
            var data = new FormData();

            data.append('idProof1', $("#doc1").get(0).files[0]);
            data.append('idProof2', $("#doc2").get(0).files[0]);
            data.append('idProof3', $("#doc3").get(0).files[0]);
            data.append('idProof4', $("#doc4").get(0).files[0]);
            data.append('idProof5', $("#doc5").get(0).files[0]);
            data.append('idProof6', $("#doc6").get(0).files[0]);
            data.append('idProof7', $("#doc7").get(0).files[0]);
            data.append('idProof8', $("#doc8").get(0).files[0]);
            data.append('idProof9', $("#doc9").get(0).files[0]);
            data.append('idProof10', $("#doc10").get(0).files[0]);
            data.append('idProof11', $("#doc11").get(0).files[0]);
            data.append('idProof12', $("#doc12").get(0).files[0]);
            data.append('idProof13', $("#doc13").get(0).files[0]);
            data.append('idProof14', $("#doc14").get(0).files[0]);
            data.append('idProof15', $("#doc15").get(0).files[0]);
            data.append('idProof16', $("#doc16").get(0).files[0]);
            data.append('idProof17', $("#doc17").get(0).files[0]);
            
            var isFileSelected = false

            var array_element = "";
            var file = $('input[type="file"]');
            for (var i = 0; i < file.length; i++) {
    			var array_element = file[i];
    			var element = array_element.value.split("\\");
    			var a = element[element.length-1];
    			const splitName = a.split(".pdf")[0].replace(/[^a-zA-Z0-9]/g, ""); 
    			const value = splitName + ".pdf";
    			 if(value==='' && value===undefined){
    				filesPath = "";
    				isFileSelected = false;
    				break;
                } else {
                    filesPath = filesPath + basePath + "mobileTower/" + i + value + ","
                    isFileSelected = true;
                }
            }
            $.ajax({
                url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadDocumentMobile.do",
                type: 'POST',
                data: data,
                cache: false,
                dataType: 'json',
                processData: false, // Don't process the files
                contentType: false // Set content type to false as jQuery will tell the server its a query string request
            }).done(function (data) {

            });

 		   filesPath = filesPath.substring(0, filesPath.lastIndexOf(","));
			$("#filesPath").val(filesPath);
			console.log(filesPath);

	}
        function downloadFiles() {
        	  var file1Url = "<c:out value="${contextRoot}"/>/pages/citizendocument/LetterOfGuarante.pdf";
        	  var file2Url = "<c:out value="${contextRoot}"/>/pages/citizendocument/हमीपत्र.pdf";
        	  
        	  var file1Name = "LetterOfGuarante.pdf";
        	  var file2Name = "हमीपत्र.pdf";
        	  
        	  var downloadLink1 = document.createElement("a");
        	  downloadLink1.href = file1Url;
        	  downloadLink1.download = file1Name;
        	  document.body.appendChild(downloadLink1);
        	  downloadLink1.click();
        	  document.body.removeChild(downloadLink1);

        	  var downloadLink2 = document.createElement("a");
        	  downloadLink2.href = file2Url;
        	  downloadLink2.download = file2Name;
        	  document.body.appendChild(downloadLink2);
        	  downloadLink2.click();
        	  document.body.removeChild(downloadLink2);
        	}


  </script>

<script>
    $('#main-dropdown').on('change', function() {
        document.getElementById("dependent-dropdown").removeAttribute('disabled');

    var selectedValue = $('#main-dropdown').val();

var options = [];

if (selectedValue === '1') {
    options = ['-Select Ward-','Ward No. 16','Ward No. 36', 'Ward No. 37' , 'Ward No. 38'];
} else if (selectedValue === '2') {
    options = ['-Select Ward-','Ward No. 12', 'Ward No. 13', 'Ward No. 14', 'Ward No. 15'];
} else if (selectedValue === '3') {
    options = ['-Select Ward-','Ward No. 29', 'Ward No. 31', 'Ward No. 32' , 'Ward No. 34'];
}else if (selectedValue === '4') {
    options = ['-Select Ward-','Ward No. 17', 'Ward No. 33', 'Ward No. 35'];
}else if (selectedValue === '5') {
    options = ['-Select Ward-','Ward No. 26', 'Ward No. 27','Ward No. 28','Ward No. 30'];
}else if (selectedValue === '6') {
    options = ['-Select Ward-','Ward No. 8', 'Ward No. 18', 'Ward No. 19' , 'Ward No. 22'];
}else if (selectedValue === '7') {
    options = ['-Select Ward-','Ward No. 5', 'Ward No. 20', 'Ward No. 21'];
}else if (selectedValue === '8') {
    options = ['-Select Ward-','Ward No. 4', 'Ward No. 23', 'Ward No. 24' , 'Ward No. 25'];
}else if (selectedValue === '9') {
    options = ['-Select Ward-','Ward No. 2', 'Ward No. 3', 'Ward No. 6', 'Ward No. 7'];
}else if (selectedValue === '10') {
    options = ['-Select Ward-','Ward No. 1', 'Ward No. 9', 'Ward No. 10' , 'Ward No. 11'];
}else if (selectedValue === 'select-zone') {
    options = ['select-ward'];
}
$('#dependent-dropdown').empty();
for (var i = 0; i < options.length; i++) {
    $('#dependent-dropdown').append('<option value="' + options[i] + '">' + options[i] + '</option>');
}
});
</script>


</html>
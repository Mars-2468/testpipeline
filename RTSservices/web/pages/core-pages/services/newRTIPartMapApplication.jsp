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



</script>

<script src="https://code.jquery.com/jquery-3.6.3.min.js"
	integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
	crossorigin="anonymous"></script>

</head>

<body>
	<form>
		<div class="container-fluid mt-2" style="width: 180vh">
							<div class="printable">
								<h3 class="text-center">Application Form For Part Map (भाग
									नकाशासाठी अर्ज)</h3>
							</div>
							<h6 style="background-color: #dce2e8; padding: 10px;" class="  rounded-2">
								<strong> Applicant Details (अर्जदाराचे तपशील) </strong>
							</h6>
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
										<label for="" class="form-label lbleng">Title (शीर्षक)<span
												class="text-danger">*</span>
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
										</label> <input type="text" class="form-control" style="background-image: none;"
											name="firstName" id="firstname" value="" maxlength="40" pattern="[A-Za-z]+"
											onchange="display(this.id)" required>
										<div class="invalid-feedback">Please Enter Valid First Name.
										</div>
									</div>
								</div>

								<div class="col-md-3">
									<div class="mb-3 mt-3">
										<label for="" class="form-label">Father's Name (वडिलांचे नाव)</label> <input
											type="text" class="form-control" style="background-image: none;"
											id="middlename" placeholder="" name="middleName" value=""
											onchange="display(this.id)">
									</div>
								</div>

								<div class="col-md-3">
									<div class="mb-3 mt-3">
										<label for="" class="form-label lbleng">Surname (आडनाव)<span
												class="text-danger">*</span></label> <input type="text"
											class="form-control" style="background-image: none;"
											onchange="display(this.id)" id="lastname" name="lastName" value=""
											maxlength="80" pattern="[A-Za-z]+" required>
										<div class="invalid-feedback">Please Enter Valid Last Name.</div>
									</div>
								</div>
								<div class="col-md-3">
									<div class="mb-3 mt-3">
										<label for="" class="form-label">Full Name (पूर्ण नाव)</label> <input
											type="text" class="form-control" style="background-image: none;"
											id="full_name" placeholder="" name="fullName" value="" readonly>
										<div class="invalid-feedback">Please Enter Valid Full Name.</div>
									</div>
								</div>

								<script type="text/javascript">
									function display() {
										$('#full_name').val($('#firstname').val() + " " + $('#middlename').val() + " " + $('#lastname').val())

									}
								</script>



								<div class="col-md-3">
									<div class="mb-3 mt-3">
										<label for="" class="form-label">Pin Code (पिन कोड)<span class="text-danger"
												style="color: red;">*</span></label> <input type="text"
											class="form-control" style="background-image: none;" id="" placeholder=""
											name="pinCode" value=""
											onkeypress="return (event.charCode !=6 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))"
											maxlength="6" pattern="^(?!0{6}$)\d{6}$" required>
										<div class="invalid-feedback">Please Enter Valid Pin Code .</div>
									</div>
								</div>
								<div class="col-md-3">
									<div class="mb-3 mt-3">
										<label for="" class="form-label"> Aadhaar No. (आधार क्र.) </label>
										<input type="text" class="form-control" style="background-image: none;"
											id="aadhaarNumber1" placeholder="" name="aadharNo" value=""
											pattern="(?!0{12}$)[0-9]{12}" maxlength="12">
										<div class="invalid-feedback">Please Enter Valid Aadhar no.</div>

									</div>
								</div>
								<div class="col-md-3">
									<div class="mb-3 mt-3">

										<label for="email" class="form-label lbleng"> Email Id
											(ईमेल आयडी)<span class="text-danger" style="color: red;">*</span>
										</label> <input type="email" class="form-control"
											style="background-image: none;" id="email" placeholder="" name="email"
											pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}" value="" required>
										<div class="invalid-feedback">Please Enter Valid Email Id.</div>

									</div>
								</div>
								<div class="col-md-3">
									<div class="mb-3 mt-3">
										<label for="" class="form-label"> Mobile No. (मोबाईल क्र.)<span
												class="text-danger" style="color: red;">*</span>
										</label> <input type="text" class="form-control" style="background-image: none;"
											id="txtMobileNumber" placeholder="" name="mobileNo" value=""
											onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))"
											maxlength="10" required>
										<div class="invalid-feedback">Please Enter Valid Mobile No.</div>

									</div>
								</div>




							<div class="col-md-12">
								<div class="mb-3 mt-3">
									<label for="" class="form-label">Full Address
										(संपूर्ण पत्ता)<span class="text-danger" style="color: red;">*</span> </label>
									<textarea oninput=" validateTextareaaa()" type=" text" maxlength="80"
										class="form-control" style="background-image: none;" id="myTextareaaa"
										placeholder="" name="fullAddress" maxlength="80" required></textarea>
									<div class="invalid-feedback" id="errorFeedbackaa">
										Please Enter Valid Address.
									</div>
								</div>
							</div>

							<script>
								function validateTextareaaa() {
									const textarea = document.getElementById('myTextareaaa');
									const errorFeedback = document.getElementById('errorFeedbackaa');
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
							<br>

							<h6 style="background-color: #dce2e8; padding: 10px;" class="rounded-2">
								<strong>Application Form Details (अर्जाचा तपशील)</strong>
							</h6>
							<div class="row">
								<div class="col-md-3">
									<div class="mb-3" style="margin-top: 16px;">
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

								<div class="col-md-3">
									<div class="mb-3 mt-3">
										<label for="" class="form-label">Khasara No. (खसारा क्र)<span class="text-danger"
												style="color: red;">*</span></label> <input type="text"
											class="form-control" style="background-image: none;" id="" placeholder=""
											name="khasaraNo" value="" required>
										<div class="invalid-feedback">Please Enter Valid Khasara No.
										</div>
									</div>
								</div>

								

								<div class="col-md-3">
									<div class="mb-3 mt-3">
										<label for="" class="form-label">City Survey No (सिटी
											सर्व्हे क्र)
										</label> <input type="text" class="form-control" style="background-image: none;"
											id="" placeholder="" name="citySurveyNo" value="">
										<div class="invalid-feedback">Please Enter Valid City Survey
											No.</div>
									</div>
								</div>



						
						<div class="col-md-3">
					<div class="mb-3" style="margin-top: 16px;">
						<label for="" class="form-label lbleng">Zone No. (झोन
							क्र.)	</label>
							 <select class="form-select " style="background-image: none;"
							id="" name="zoneNo" >
							<option value="" selected="">-Select Zone-</option>
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
							
							<div class="row">


								<h6 class="mt-3">
									<strong> List of Documents (with attachment) (कागदपत्रांची
										यादी (संलग्नकांसह))</strong>
								</h6>

								<div class="alert alert-info mb-0 p-2 ms-2">
									<small><strong>Note: </strong>Upload below files only
							.pdf(Max upto 2 MB) (खाली फक्त .pdf फाइल अपलोड करा (कमाल २ MB
						पर्यंत))</small>
								</div>

								<input type="hidden" name="filesPath" id="filesPath" />


								<div class="col-md-3">
									<div class="mb-3 mt-1">
										<label for="" class="form-label"> City Survey/ 7/12 /Property Card (शहर सर्वेक्षण उतारा/ ७/१२ उतारा /मालमत्ता दस्तऐवज)<span class="text-danger"
												style="color: red;">*</span>
										</label> <input type="file" class="form-control" style="background-image: none;"
											name="survey" id="doc1" placeholder="" accept=".pdf" required>
										<div class="invalid-feedback">File selected is either 
											greater than 2Mb or not of type .pdf.</div>
									</div>
								</div>
								<div class="col-md-3">
									<div class="mb-3" style="margin-top: 52px">
										<label for="" class="form-label"> Khasara Map (खसरा नकाशा)<span
												class="text-danger" style="color: red;">*</span></label> <input
											type="file" class="form-control" style="background-image: none;"
											name="khasaraMap" id="doc2" placeholder="" accept=".pdf" required>
										<div class="invalid-feedback">File selected is either
											greater than 2Mb or not of type .pdf.</div>
									</div>
								</div>

								
<div class="col-md-3">
					<div class="mb-3"  style="margin-top: 27px">
						<label for="" class="form-label">Self Attested Applicant's Id Proof (स्वत: प्रमाणित अर्जदाराचा आयडी पुरावा)<span class="text-danger" style="color: red;">*</span>
						</label> <input type="file" class="form-control"
							style="background-image: none;" id="doc3" placeholder="" accept=".pdf" 
							name="selfDoc" required="true">
						<div class="invalid-feedback ">File selected is either
							greater than 2Mb or not of type .pdf.</div>

					</div>
				</div>

							<div class="col-md-3">
									<div class="mb-3" style="margin-top: 52px">
										<label for="" class="form-label">City Survey Map (शहर
											सर्वेक्षण नकाशा)
										</label> <input type="file" class="form-control" accept=".pdf" style="background-image: none;"
											id="doc4" placeholder="" name="surveyMap">

										<div class="invalid-feedback">File selected is either
											greater than 2Mb or not of type .pdf.</div>
									</div>
								</div>

							</div>

							<div class="col-md-12">
								<div class="mb-5 mt-4">
									<div class="form-check">
										<input class="form-check-input" type="checkbox" id="check1" name="option1"
											value="something" required> <label class="form-check-label ms-2">
											<strong>Declaration (घोषणा)
												<span class="text-danger" style="color: red;">*</span>:-
											</strong>The above mentioned information is true to the best of my
								knowledge and belief.(वर नमूद केलेली माहिती माझ्या माहितीनुसार
								आणि विश्वासानुसार खरी आहे.)
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
										>Submit</button>
								</div>
							</div>
						</div>
					</form>

	</div>
	

</body>
<script type="text/javascript">
$('.printMe').on('click', function () {

    window.print();
});
</script>
<!-- <script type="text/javascript">

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
                      $("#submit").attr("disabled", true);
                      isUploadInProgress = true;
                      upload(function(status) {
                          if (status === true || status === 'true') {
                            onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/savePartMapCertificates.do');
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

           data.append('idProof1', $("#doc1").get(0).files[0]);
            data.append('idProof2', $("#doc2").get(0).files[0]);
            data.append('idProof3', $("#doc3").get(0).files[0]);

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
                   filesPath = filesPath + basePath + "partMap/" + id + value + ","
                   isFileSelected = true;
               }
           }
           $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadDocumentPart.do?id="+id,
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
   
   //new-->
   
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
	                      $("#submit").attr("disabled", true);
	                      isUploadInProgress = true;
	                      upload(function(status) {
	                          if (status === true || status === 'true') {
	                              onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/savePartMapCertificates.do');
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
                  filesPath = filesPath + basePath + "partMap/" + id + value + ","

                  isFileSelected = true;
              }
          }
          $.ajax({
              url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadDocumentPart.do?id="+id,
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
              }
          });

          var a = filesPath.substring(0, filesPath.lastIndexOf(","));
          filesPath = filesPath.replace(/\s/g, "");
          $("#filesPath").val(filesPath);
          console.log(filesPath);

      }
    </script>
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

 <li>1.City Survey/ 7/12 /Property Card (शहर सर्वेक्षण उतारा/ ७/१२ उतारा /मालमत्ता दस्तऐवज)<span class="text-danger"  style="color: red;">*</span></li>
                            <li>2.Khasara Map (खसरा नकाशा)<span class="text-danger"  style="color: red;">*</span> </li>
                            <li>3.Self Attested Applicant's Id Proof (स्वत: प्रमाणित अर्जदाराचा आयडी पुरावा)<span class="text-danger"  style="color: red;">*</span></li>
                            <li>4.City Survey Map (शहर सर्वेक्षण नकाशा)</li>



                           
                        </ul>

                    </div>

                    <!-- dialog buttons -->

                    <div class="modal-footer"><button type="button" class="btn btn-primary">OK</button></div>

                </div>

            </div>

        </div>
</html>
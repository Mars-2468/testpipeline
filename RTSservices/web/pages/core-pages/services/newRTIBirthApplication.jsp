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
     size: auto ;
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
					2 MB(खालील फाइल .pdf मध्ये अपलोड करा..कमाल २ MB पर्यंत)
				</h6>

			</div>

			<!-- dialog body -->

			<div class="modal-body" style="color: green">



				<p style="color: red">

					<strong>List of document to be attached :</strong>

				</p>

				<ul style="color: rgb(3, 125, 76)">



					<li>1.Hospital Certificate (रुग्णालयाचे प्रमाणपत्र)</li>
					<li>2.Father's/Mother's ID Proof(Aadhaar/Pan/Voting Card/T.C/etc) (वडिलांचा/आईचा ओळखपत्र पुरावा (आधार/पॅन/मतदान कार्ड/टी.सी/इ.) प्रमाणपत्र)<span
						class="text-danger" style="color: red;">*</span>
					</li>
					<li>3.Applicant's ID Proof (Aadhar/PAN/Voting Card/T.C./etc)
						(अर्जदाराचा आयडी पुरावा (आधार/पॅन/मतदान कार्ड/टी.सी./इ.)) <span
						class="text-danger" style="color: red;">*</span>
					</li>
					
					<li>4.Certificate issued by Correspondent (ward member)
						(बातमीदाराने जारी केलेले प्रमाणपत्र(वॉर्ड सदस्य))</li>
					<li>5.Attachment regarding Permanent Settelment in India
						(भारतातील कायमस्वरूपी सेटलमेंटबाबत संलग्नक)</li>

				</ul>

			</div>

			<!-- dialog buttons -->

			<div class="modal-footer">
				<button type="button" class="btn btn-primary">OK</button>
			</div>

		</div>

	</div>

</div>
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
                    if (['Dr. S. M. Patil Nursing Home , 70 (डॉ. एस. एम. पाटील नर्सिंग होम, 70)', 'Kalptaru Materntiy & Surgical Nursing Home , 78 (कल्पतरू मातृत्व आणि सर्जिकल नर्सिंग होम , 78)', 'Renuka Maternity & Ent Hospital , 120 (रेणुका मॅटर्निटी अँड एंटी हॉस्पिटल , 120)'].indexOf(option.text) > -1)
                        option.style.display = 'block'

                }
                if (text == 'Zone No.2 - Dharmpeth (धरमपेठ)') {
                    if (['Sengupta Hospital & Research Institute , 3 (सेनगुप्ता हॉस्पिटल अँड रिसर्च इन्स्टिट्यूट , 3)', 'Sanjeevan Maternity & Nursing Home , 42 (संजीवन मॅटर्निटी आणि नर्सिंग होम, 42)', 'Maher Maternity & Nursing Home , 45 (माहेर मॅटर्निटी आणि नर्सिंग होम , 45)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.3 - Hanuman Nagar (वंदनीय राष्ट्रसंत तुकडोजी महाराज)') {
                    if (['Bansod Hospital , 31 (बनसोड हॉस्पिटल , 31)', 'Asha Bhawan Nursing Home , 54 (आशा भवन नर्सिंग होम, 54)', 'Naik Hospital ,8 (नाईक हॉस्पिटल,8)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.4 - Dhantoli (धंतोली)') {
                    if (['Jasleen Hospital , 2 (जसलीन हॉस्पिटल , 2)', 'Ketkar Nursing Home , 23 (केतकर नर्सिंग होम Home , 23)', 'Navjeevan Nursing Home , 29 (नवजीवन नर्सिंग होम, 29)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.5 - Nehru Nagar (नेहरू नगर श्रेत्रिय कार्यालय)') {
                    if (['Ashish Eye Hospital , 105 (आशिष आय हॉस्पिटल , 105)', 'Kurvey Nursing Home , 147 (कुर्वे नर्सिंग होम , 147)', 'S. D. Hospital , 193 (एस.डी. हॉस्पिटल , 193)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.6 - Gandhi Zone Mahal (गांधी झोन ​​महाल)') {
                    if (['Saoji Hospital , 26 (साओजी हॉस्पिटल , 26)', 'Rahimi Nursing Home , 33 (रहीमी नर्सिंग होम,33)', 'Saboo Hospital , 82 (साबू हॉस्पिटल , 82)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.7 - Satranjipura (सतरंजीपुरा)') {
                    if (['Taj Nursing Home , 65 (ताज नर्सिंग होम , 65)', 'Central Hospital , 495 (सेंट्रल हॉस्पिटल , 495)', 'Crystal Nursing Home , 1023 (क्रिस्टल नर्सिंग होम , 1023)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.8 - Lakadganj (लकडगंज)') {
                    if (['Ridhorkar Hospital , 30 (रिधोरकर हॉस्पिटल , 30)', 'Thakkar Nursing Home , 178 (ठक्कर नर्सिंग होम, 178)', 'Arjun Hospital , 194 (अर्जुन हॉस्पिटल , 194)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.9 - Aashi Nagar (आशी नगर)') {
                    if (['Zaveri Nursing Home , 15 (झवेरी नर्सिंग होम , 15)','Ansari Maternity & Nursing Home , 114 (अन्सारी मॅटर्निटी अँड नर्सिंग होम , 114)', 'Khobragade Multispeciality Hospital , 124 (खोब्रागडे मल्टीस्पेशालिटी हॉस्पिटल , 124)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.10 - Mangalwari (मंगळवारी)') {
                    if (['Naidu Hospital , 39 (नायडू हॉस्पिटल , 39)', 'Punshi Hospital , 58 (पुंशी हॉस्पिटल, 58)', 'Janta Maternity Home & Hospital , 91 (जनता मॅटर्निटी होम आणि हॉस्पिटल , 91)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
            }
        }

    }
            
    
</script>
<script>
    function validateInput(event) {
      var input = event.target.value;
      var regex = /^[a-zA-Z\s]*$/;
      var isValid = regex.test(input);
      
      if (!isValid) {
        event.target.value = input.replace(/[^A-Za-z]+/g, '');
      }
    }
  </script>
<script>
          /*           function validateInput1(event) {
                    	  const input = event.target;
                    	  const value = input.value;

                    	  if (value.length > 0 && value[0] === ' ') {
                    	    // Show error message
                    	    input.classList.add('is-invalid');
                    	   
                    	  } else  if(value.length>0 && value[value.length] ==' '){
                    	    // Remove error message
                    	    input.classList.add('is-invalid');
                    	    
                    	  }
                    	} */
                    	function validateInput1(event) {
                    		  const input = event.target;
                    		  const value = input.value.trim(); // Remove leading/trailing spaces

                    		  if (value.length === 0) {
                    		    // Show error message for empty field
                    		    input.classList.add('is-invalid');
                    		   
                    		  } else if (!/^[a-zA-Z0-9\s]+$/.test(value)) {
                    		    // Show error message if input contains non-alphanumeric characters
                    		    input.classList.add('is-invalid');
                    		    
                    		  } else {
                    		    // Remove error message
                    		    input.classList.remove('is-invalid');
                    		   
                    		  }
                    		}

                    		// Get all the input fields
                    		const inputFields = document.getElementsByClassName('name'); // Replace 'your-input-class' with the actual class name you're using for the input fields

                    		// Loop through each input field and attach the event listener
                    		Array.from(inputFields).forEach((input) => {
                    		  input.addEventListener('change', validateInput1);
                    		});


                    </script>
<body>


	<form class="needs-validation" novalidate>
		<div class="container-fluid mt-2" style="width: 180vh">
			<div class="printable">
				<h3 class="text-center">Application Form For Birth Certificate
					(जन्म प्रमाणपत्रासाठी अर्ज)</h3>
			</div>

			<h6 style="background-color: #dce2e8; padding: 10px;"
				class="  rounded-2">
				<strong class="form-label "> Applicant Details (अर्जदाराचे
					तपशील)</strong>

			</h6>
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
			
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Title (शीर्षक) <span
							class="text-danger" style="color: red;">*</span>
						</label> <select class="form-select" style="background-image: none;"
							name="applicantTitle" required>


							<option value="">-Select-</option>
							<option value="Mr (श्री)">Mr (श्री)</option>
							<option value="Mrs (सौ)">Mrs (सौ)</option>
							<option value="Ms (कु)">Ms (कु)</option>
						</select>


						<div class="invalid-feedback">Please Select Valid Title.</div>

					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Name (नाव)<span
							class="text-danger">*</span></label> <input type="text"
							class="form-control name" style="background-image: none;"
							id="first_name" placeholder="" name="applicantFirstName" value=""
							onchange="Display(this.id);" pattern="[A-Za-z]+" maxlength="40"
							required>
						<div class="invalid-feedback">Please Enter Valid Name.</div>

					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Father's Name (वडिलांचे
							नाव)</label> <input type="text" class="form-control name"
							id="middle_name" style="background-image: none;" placeholder=""
							name="applicantMiddleName" value="" pattern="[A-Za-z]+"
							onchange="Display(this.id)">


					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Surname (आडनाव)<span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control name" pattern="[A-Za-z]+"
							style="background-image: none;" name="applicantLastName"
							id="last_name" value="" onchange="Display(this.id)"
							maxlength="80" required>
						<div class="invalid-feedback">Please Enter Valid Surname.</div>

					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label ">Full Name (संपूर्ण नाव)
						</label> <input type="text" class="form-control"
							pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$"
							style="background-image: none;" id="full_name" placeholder=""
							name="applicantFullName" value="" readonly>
					</div>
				</div>


				<script>
                        function Display(id) {
                                      $('#full_name').val( $('#first_name').val()+" "+ $('#middle_name').val()+" "+ $('#last_name').val())
                                }
                        </script>



				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label ">Plot/ Flat
							No.(प्लॉट/फ्लॅट क्र.) <span class="text-danger"
							style="color: red;"">*</span>
						</label> <input type=" number" class="form-control" pattern="^\s*\S.*$"
							style="background-image: none;" id="plot_no" placeholder=""
							name="applicantPlotNo" value="" maxlength="255"
							onchange="change(this.id)" required>
						<div class="invalid-feedback">Please Enter Valid Plot/Flat
							No.</div>

					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label ">Name of the Building
							(इमारतीचे नाव)</label> <input type=" text" class="form-control"
							style="background-image: none;" id="buildingName" placeholder=""
							name="applicantBuildingName" onchange="change(this.id)" value="">
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label ">Name of the Street
							(रस्त्याचे नाव)</label> <input type=" text" class="form-control"
							style="background-image: none;" id="street_name" placeholder=""
							name="applicantStreetName" onchange="change(this.id)" value="">
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label ">Name of the Area
							(क्षेत्राचे नाव)<span class="text-danger" style="color: red;"">*</span>
						</label> <input type=" text" class="form-control"
							style="background-image: none;" id="areaName" placeholder=""
							name="applicantAreaName" value="" maxlength="255"
							pattern="^\s*\S.*$" onchange="change(this.id)" required>
						<div class="invalid-feedback">Please Enter Valid Name of the
							Area.</div>

					</div>
				</div>



				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label ">Near by Landmark (जवळील
							लँडमार्क)</label> <input type=" text" class="form-control"
							style="background-image: none;" id="landmark" placeholder=""
							name="applicantNearbyLandmark" value=""
							onchange="change(this.id)" pattern="^\s*\S.*$">
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label ">City Name (शहराचे नाव)</label> <input
							type=" text" class="form-control" style="background-image: none;"
							id="city" placeholder="" name="applicantcity" value=""
							onchange="change(this.id)" pattern="^\s*\S.*$" >
						<div class="invalid-feedback">Please Enter Valid City Name.
						</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label ">Pin Code (पिन कोड) <span
							class="text-danger">*</span></label> <input type="text"
							class="form-control" style="background-image: none;"
							pattern="[0-9]{6}" name="applicantPinCode" value=""
							onchange="change(this.id)" id="pin_code" maxlength="6" required>
						<div class="invalid-feedback">Please Enter Valid Pin Code.</div>


					</div>

				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-4">
						<label for="" class="form-label "> Aadhaar No. (आधार क्र.)
						</label> <input type="text" class="form-control "
							style="background-image: none;" id="aadhaarNumber1"
							placeholder="" name="aadhaarNo" value="" pattern="[0-9]{12}"
							maxlength="12">
						<div class="invalid-feedback">Please Enter Valid Aadhaar No.
						</div>

					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-4">

						<label for="email" class="form-label "> Email Id (ईमेल
							आयडी )<span class="text-danger">*</span>
						</label> <input type="email" class="form-control "
							style="background-image: none;" name="email" value="" required>
						<div class="invalid-feedback">Please Enter Valid Email Id.</div>

					</div>
				</div>


				<div class="col-md-3">
					<div class="mb-3 mt-4">
						<label for="" class="form-label "> Mobile No. (मोबाईल
							क्र.)<span class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control "
							style="background-image: none;" id="txtMobileNumber"
							placeholder="" name="ph_no" value="" pattern="[6-9]{1}[0-9]{9}"
							maxlength="10" required>
						<div class="invalid-feedback">Please Enter Valid Mobile No.
						</div>

					</div>
				</div>
				<div class="col-md-3">
    <div class="mb-3 mt-4">
        <label for="" class="form-label ">Relationship of Applicant (अर्जदाराचे नाते)<span class="text-danger" 
                style="color: red;">*</span></label>
               
        <select class="form-select" style="background-image: none;" id='relationshipSelect' name="applicantRelationship" required>
            <option value="">-Select-</option>
            <option value="Father (वडील)">Father (वडील)</option>
            <option value="Mother (आई)">Mother (आई)</option>
            <option value="Sister (बहीण)">Sister (बहीण)</option>
            <option value="Brother (भाऊ)">Brother (भाऊ)</option>
            <option value="Cousin (चुलत भावंड)">Cousin (चुलत भावंड)</option>
            <option value="Friend (मित्र/मैत्रिण)">Friend (मित्र/मैत्रिण)</option>
            <option value="Uncle (काका)">Uncle (काका)</option>
            <option value="Aunty (काकी)">Aunty (काकी)</option>
            <option value="Grandfather (आजोबा)">Grandfather (आजोबा)</option>
            <option value="Grandmother (आजी)">Grandmother (आजी)</option>
             <option value="Other (इतर)">Other (इतर)</option>
        </select>
        
        <div class="invalid-feedback">
            Please enter a valid Relationship of Applicant.
        </div>
    </div>
</div>
<script>
$(document).on('change', '#relationshipSelect', function () {
    if ($(this).val() == 'Other (इतर)') {
        $(this).replaceWith($('<input/>', { 'class': 'form-control', 'style': 'background-image: none;', 'type': 'text', 'id': 'otherRelationship', 'name': 'applicantRelationship', 'required': true }));
    } else {
        $('#otherRelationship').remove();
    }
});
</script>
				<div class="col-md-12">
    <div class="mb-3 mt-3">
        <label for="primary_full_address" class="form-label">Address For Correspondence (पत्रव्यवहारासाठी पत्ता)&nbsp;&nbsp;
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
                           
                </div>

				<h6 style="background-color: #dce2e8; padding: 10px;"
					class="  rounded-2">
					<strong class="form-label  "> Application Form Details
						(अर्जाचा तपशील)</strong>

				</h6>

				<div class="row">
<!-- Default Child Name -->
<div class="col-md-3">
						<div class="mb-3 mt-2">
							<label for="" class="form-label ">Has the child's name been fixed?<br>
							(बाळाचे नाव निश्चित केले आहे का?)<span class="text-danger" style="color: red;">*</span>
							</label>

							<div class="d-flex mt-2 border rounded  p-2">
								<div class="form-check ms-3">
									<input type="radio" class="form-check-input" id="radio3"
										name="childNameFixed" value="Yes" required>Yes <label
										class="form-check-label" for="radio1"></label>
								</div>

								<div class="form-check ms-3">
									<input type="radio" class="form-check-input" id="radio5"
										name="childNameFixed" value="No" required>No
									<div class="invalid-feedback">Please Select Valid Option.</div>
									<label class="form-check-label" for="radio1"></label>
								</div>

							</div>
							</div>
							</div>
							<div class="col-md-3 default">
						<div class="mb-3" style="margin-top:42px;">
							<label for="" class="form-label  ">Name of the Child
								(बाळाचे नाव)<span class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control"
								style="background-image: none;" id="default" placeholder=""
								name="childeName" value="BABY" onclick="warning(this);"
								pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" readonly required>
							<div class="invalid-feedback">Please Enter Valid Name of
								Child.</div>

						</div>
					</div>

					<div class="col-md-3 fixed">
						<div class="mb-3 mt-4">
							<label for="" class="form-label  ">Name of the Child
								(बाळाचे नाव)<span class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control"
								style="background-image: none;" id="fixed" placeholder=""
								name="childeName" value="" onclick="warning(this);"
								pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" required>
							<div class="invalid-feedback">Please Enter Valid Name of
								Child.</div>

						</div>
					</div>
<script>
var clicked = false;

function warning(){

	if(clicked){
		return false;
	}else{
		
		alert(" Name will not be change once entered (एकदा प्रविष्ट केल्यानंतर नाव बदलले जाणार नाही)");
		clicked = true;
	}
	

}


</script>



					<div class="col-md-3">
						<div class="mb-3 mt-5">
							<label for="" class="form-label  ">Date of Birth of Child
								(बाळाची जन्मतारीख)<span class="text-danger" style="color: red;">*</span>
							</label> <input type="date" class="form-control"
								style="background-image: none;" id="dob" placeholder=""
								name="dob" value="" required>
							<div class="invalid-feedback">Please Enter Valid Date of
								Birth.</div>

						</div>
					</div>
					<div class="col-md-3">
						<div class="mb-3 mt-5">
							<label for="" class="form-label  ">Gender of Child
								(बाळाचे लिंग)</label> <span class="text-danger" style="color: red;">*</span></label>

							<select class="form-select" style="background-image: none;"
								name="gender" required>
								<option value="">-Select-</option>
								<option value="Male">Male</option>
								<option value="Female">Female</option>
								<option value="Transgender">Transgender</option>
							</select>
							<div class="invalid-feedback">Please Select Valid Gender of
								Child.</div>




						</div>
					</div>



					<div class="col-md-3">
						<div class="mb-3 mt-5">
							<label for="" class="form-label  ">Father's Full Name
								(वडिलांचे पूर्ण नाव) </label> <span class="text-danger"
								style="color: red;">*</span></label> <input type="text"
								class="form-control" style="background-image: none;" id=""
								placeholder="" name="fatherName" value=""
								pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" required>
							<div class="invalid-feedback">Please Enter Valid Father's
								Name.</div>

						</div>
					</div>



					<div class="col-md-3">
						<div class="mb-3" style="margin-top:40px;">
							<label for="" class="form-label  ">Mother's Full Name
								(आईचे पूर्ण नाव) </label> <span class="text-danger" style="color: red;">*</span></label>

							<input type="text" class="form-control"
								style="background-image: none;" id="" placeholder=""
								name="motherName" value=""
								pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" required>
							<div class="invalid-feedback">Please Enter Valid Mother's
								Full Name.</div>

						</div>
					</div>




					<div class="col-md-3">
						<div class="mb-3" style="margin-top:40px;">
							<label for="" class="form-label  ">Blood Group (रक्त गट)</label>

							<select class="form-select" style="background-image: none;"
								name="bloodGroup">
								<option value="">-Select-</option>
								<option value="A+ve">A+ve</option>
								<option value="A-ve">A-ve</option>
								<option value="B+ve">B+ve</option>
								<option value="B-ve">B-ve</option>
								<option value="AB+ve">AB+ve</option>
								<option value="AB-ve">AB-ve</option>
								<option value="O+ve">O+ve</option>
								<option value="O-ve">O-ve</option>

							</select>

						</div>
					</div>


					<div class="col-md-3">
						<div class="mb-3" style="margin-top:40px;">
							<label for="" class="form-label ">Blood Relation (रक्ताचे
								नाते)</label> <select class="form-select"
								style="background-image: none;" name="bloodRelation">
								<option value="">-Select-</option>
								<option value="Parents">Parents</option>
								<option value="Guardian">Guardian</option>

							</select>


						</div>
					</div>
					<div class="col-md-3">
						<div class="mb-3" style="margin-top:40px;">
							<label for="" class="form-label ">Zone No(झोन क्र.)<span
								class="text-danger" style="color: red;" id="zone"
								onclick="Zoneno(this.form)">*</span>
							</label> <select class="form-select " style="background-image: none;"
								id="iFunction" name="zone" onchange="callHospitalList(this)" required>
								<option value="" selected="">-Select Zone-</option>
								<option value="1">Zone No.1 - Laxmi Nagar (लक्ष्मी नगर)</option>
								<option value="2">Zone No.2 - Dharmpeth (धरमपेठ)</option>
								<option value="3">Zone No.3 - Hanuman Nagar (वंदनीय
									राष्ट्रसंत तुकडोजी महाराज)</option>
								<option value="4">Zone No.4 - Dhantoli (धंतोली)</option>
								<option value="5">Zone No.5 - Nehru Nagar (नेहरू नगर
									श्रेत्रिय कार्यालय)</option>
								<option value="6">Zone No.6 - Gandhi Zone Mahal (गांधी
									झोन ​​महाल)</option>
								<option value="7">Zone No.7 - Satranjipura (सतरंजीपुरा)</option>
								<option value="8">Zone No.8 - Lakadganj (लकडगंज)</option>
								<option value="9">Zone No.9 - Aashi Nagar (आशी नगर)</option>
								<option value="10">Zone No.10 - Mangalwari (मंगळवारी)</option>

							</select>

							<div class="invalid-feedback ">Please Enter Valid Zone No.
							</div>

						</div>
					</div>
					<div class="col-md-4">
						<div class="mb-3 mt-3">
							<label for="" class="form-label ">Place Of Birth
								(जन्मस्थान)<span class="text-danger" style="color: red;">*</span>
							</label>

							<div class="d-flex mt-2 border rounded  p-2">
								<div class="form-check ms-3">
									<input type="radio" class="form-check-input" id="radio3"
										name="placeofbirth" value="Home (घर)" required>Home (घर) <label
										class="form-check-label" for="radio1"></label>
								</div>

								<div class="form-check ms-3">
									<input type="radio" class="form-check-input" id="radio4"
										name="placeofbirth" value="Hospital (रुग्णालय)" required>Hospital
									(रुग्णालय) <label class="form-check-label" for="radio1"></label>
								</div>
								<div class="form-check ms-3">
									<input type="radio" class="form-check-input" id="radio5"
										name="placeofbirth" value="Out of India(भारताबाहेर)" required>Out of India
									(भारताबाहेर)
									<div class="invalid-feedback">Please Select Valid Place
										of Birth.</div>
									<label class="form-check-label" for="radio1"></label>
								</div>

							</div>


						</div>

					</div>
					<div class="col-md-3" id="country">
						<div class="mb-3 mt-5">
							<label for="" class="form-label ">Country Name (देशाचे
								नाव)<span class="text-danger" style="color: red;">*</span>
							</label> <select class="form-select " style="background-image: none;"
								id="countryName" name="countryName" required>
								<option value="" selected="">Select a country</option>
								<option value="Afghanistan">Afghanistan</option>
								<option value="Albania">Albania</option>
								<option value="Algeria">Algeria</option>
								<option value="Andorra">Andorra</option>
								<option value="Angola">Angola</option>
								<option value="Anguilla">Anguilla</option>
								<option value="Antarctica">Antarctica</option>
								<option value="Antigua and Barbuda">Antigua and Barbuda</option>
								<option value="Argentina">Argentina</option>
								<option value="Armenia">Armenia</option>
								<option value="Aruba">Aruba</option>
								<option value="Australia">Australia</option>
								<option value="Austria">Austria</option>
								<option value="Azerbaijan">Azerbaijan</option>
								<option value="Bahamas">Bahamas</option>
								<option value="Bahrain">Bahrain</option>
								<option value="Bangladesh">Bangladesh</option>
								<option value="Barbados">Barbados</option>
								<option value="Belarus">Belarus</option>
								<option value="Belgium">Belgium</option>
								<option value="Belize">Belize</option>
								<option value="Benin">Benin</option>
								<option value="Bermuda">Bermuda</option>
								<option value="Bhutan">Bhutan</option>
								<option value="Bolivia">Bolivia</option>
								<option value="Bosnia and Herzegovina">Bosnia and
									Herzegovina</option>
								<option value="Botswana">Botswana</option>
								<option value="Brazil">Brazil</option>
								<option value="British Indian Ocean Territory">British
									Indian Ocean Territory</option>
								<option value="British Virgin Islands">British Virgin
									Islands</option>
								<option value="Brunei">Brunei</option>
								<option value="Bulgaria">Bulgaria</option>
								<option value="Burkina Faso">Burkina Faso</option>
								<option value="Burundi">Burundi</option>
								<option value="Cambodia">Cambodia</option>
								<option value="Cameroon">Cameroon</option>
								<option value="Canada">Canada</option>
								<option value="Cape Verde">Cape Verde</option>
								<option value="Cayman Islands">Cayman Islands</option>
								<option value="Central African Republic">Central
									African Republic</option>
								<option value="Chad">Chad</option>
								<option value="Chile">Chile</option>
								<option value="China">China</option>
								<option value="Christmas Island">Christmas Island</option>
								<option value="Cocos (Keeling) Islands">Cocos (Keeling)
									Islands</option>
								<option value="Colombia">Colombia</option>
								<option value="Comoros">Comoros</option>
								<option value="Cook Islands">Cook Islands</option>
								<option value="Costa Rica">Costa Rica</option>
								<option value="Croatia">Croatia</option>
								<option value="Cuba">Cuba</option>
								<option value="Curaçao">Curaçao</option>
								<option value="Cyprus">Cyprus</option>
								<option value="Czech Republic">Czech Republic</option>
								<option value="Democratic Republic of the Congo">Democratic
									Republic of the Congo</option>
								<option value="Denmark">Denmark</option>
								<option value="Djibouti">Djibouti</option>
								<option value="Dominica">Dominica</option>
								<option value="Dominican Republic">Dominican Republic</option>
								<option value="East Timor">East Timor</option>
								<option value="Ecuador">Ecuador</option>
								<option value="Egypt">Egypt</option>
								<option value="El Salvador">El Salvador</option>
								<option value="Equatorial Guinea">Equatorial Guinea</option>
								<option value="Eritrea">Eritrea</option>
								<option value="Estonia">Estonia</option>
								<option value="Ethiopia">Ethiopia</option>
								<option value="Falkland Islands">Falkland Islands</option>
								<option value="Faroe Islands">Faroe Islands</option>
								<option value="Fiji">Fiji</option>
								<option value="Finland">Finland</option>
								<option value="France">France</option>
								<option value="French Polynesia">French Polynesia</option>
								<option value="Gabon">Gabon</option>
								<option value="Gambia">Gambia</option>
								<option value="Georgia">Georgia</option>
								<option value="Germany">Germany</option>
								<option value="Ghana">Ghana</option>
								<option value="Gibraltar">Gibraltar</option>
								<option value="Greece">Greece</option>
								<option value="Greenland">Greenland</option>
								<option value="Grenada">Grenada</option>
								<option value="Guam">Guam</option>
								<option value="Guatemala">Guatemala</option>
								<option value="Guernsey">Guernsey</option>
								<option value="Guinea">Guinea</option>
								<option value="Guinea-Bissau">Guinea-Bissau</option>
								<option value="Guyana">Guyana</option>
								<option value="Haiti">Haiti</option>
								<option value="Honduras">Honduras</option>
								<option value="Hong Kong">Hong Kong</option>
								<option value="Hungary">Hungary</option>
								<option value="Iceland">Iceland</option>
								<option value="India">India</option>
								<option value="Indonesia">Indonesia</option>
								<option value="Iran">Iran</option>
								<option value="Iraq">Iraq</option>
								<option value="Ireland">Ireland</option>
								<option value="Isle of Man">Isle of Man</option>
								<option value="Israel">Israel</option>
								<option value="Italy">Italy</option>
								<option value="Ivory Coast">Ivory Coast</option>
								<option value="Jamaica">Jamaica</option>
								<option value="Japan">Japan</option>
								<option value="Jersey">Jersey</option>
								<option value="Jordan">Jordan</option>
								<option value="Kazakhstan">Kazakhstan</option>
								<option value="Kenya">Kenya</option>
								<option value="Kiribati">Kiribati</option>
								<option value="Kosovo">Kosovo</option>
								<option value="Kuwait">Kuwait</option>
								<option value="Kyrgyzstan">Kyrgyzstan</option>
								<option value="Laos">Laos</option>
								<option value="Latvia">Latvia</option>
								<option value="Lebanon">Lebanon</option>
								<option value="Lesotho">Lesotho</option>
								<option value="Liberia">Liberia</option>
								<option value="Libya">Libya</option>
								<option value="Liechtenstein">Liechtenstein</option>
								<option value="Lithuania">Lithuania</option>
								<option value="Luxembourg">Luxembourg</option>
								<option value="Macau">Macau</option>
								<option value="Macedonia">Macedonia</option>
								<option value="Madagascar">Madagascar</option>
								<option value="Malawi">Malawi</option>
								<option value="Malaysia">Malaysia</option>
								<option value="Maldives">Maldives</option>
								<option value="Mali">Mali</option>
								<option value="Malta">Malta</option>
								<option value="Marshall Islands">Marshall Islands</option>
								<option value="Mauritania">Mauritania</option>
								<option value="Mauritius">Mauritius</option>
								<option value="Mayotte">Mayotte</option>
								<option value="Mexico">Mexico</option>
								<option value="Micronesia">Micronesia</option>
								<option value="Moldova">Moldova</option>
								<option value="Monaco">Monaco</option>
								<option value="Mongolia">Mongolia</option>
								<option value="Montenegro">Montenegro</option>
								<option value="Montserrat">Montserrat</option>
								<option value="Morocco">Morocco</option>
								<option value="Mozambique">Mozambique</option>
								<option value="Myanmar">Myanmar</option>
								<option value="Namibia">Namibia</option>
								<option value="Nauru">Nauru</option>
								<option value="Nepal">Nepal</option>
								<option value="Netherlands">Netherlands</option>
								<option value="Netherlands Antilles">Netherlands
									Antilles</option>
								<option value="New Caledonia">New Caledonia</option>
								<option value="New Zealand">New Zealand</option>
								<option value="Nicaragua">Nicaragua</option>
								<option value="Niger">Niger</option>
								<option value="Nigeria">Nigeria</option>
								<option value="Niue">Niue</option>
								<option value="North Korea">North Korea</option>
								<option value="Northern Mariana Islands">Northern
									Mariana Islands</option>
								<option value="Norway">Norway</option>
								<option value="Oman">Oman</option>
								<option value="Pakistan">Pakistan</option>
								<option value="Palau">Palau</option>
								<option value="Palestine">Palestine</option>
								<option value="Panama">Panama</option>
								<option value="Papua New Guinea">Papua New Guinea</option>
								<option value="Paraguay">Paraguay</option>
								<option value="Peru">Peru</option>
								<option value="Philippines">Philippines</option>
								<option value="Pitcairn Islands">Pitcairn Islands</option>
								<option value="Poland">Poland</option>
								<option value="Portugal">Portugal</option>
								<option value="Puerto Rico">Puerto Rico</option>
								<option value="Qatar">Qatar</option>
								<option value="Republic of the Congo">Republic of the
									Congo</option>
								<option value="Réunion">Réunion</option>
								<option value="Romania">Romania</option>
								<option value="Russia">Russia</option>
								<option value="Rwanda">Rwanda</option>
								<option value="Saint Barthélemy">Saint Barthélemy</option>
								<option value="Saint Helena">Saint Helena</option>
								<option value="Saint Kitts and Nevis">Saint Kitts and
									Nevis</option>
								<option value="Saint Lucia">Saint Lucia</option>
								<option value="Saint Martin">Saint Martin</option>
								<option value="Saint Pierre and Miquelon">Saint Pierre
									and Miquelon</option>
								<option value="Saint Vincent and the Grenadines">Saint
									Vincent and the Grenadines</option>
								<option value="Samoa">Samoa</option>
								<option value="San Marino">San Marino</option>
								<option value="São Tomé and Príncipe">São Tomé and
									Príncipe</option>
								<option value="Saudi Arabia">Saudi Arabia</option>
								<option value="Senegal">Senegal</option>
								<option value="Serbia">Serbia</option>
								<option value="Seychelles">Seychelles</option>
								<option value="Sierra Leone">Sierra Leone</option>
								<option value="Singapore">Singapore</option>
								<option value="Slovakia">Slovakia</option>
								<option value="Slovenia">Slovenia</option>
								<option value="Solomon Islands">Solomon Islands</option>
								<option value="Somalia">Somalia</option>
								<option value="South Africa">South Africa</option>
								<option value="South Korea">South Korea</option>
								<option value="South Sudan">South Sudan</option>
								<option value="Spain">Spain</option>
								<option value="Sri Lanka">Sri Lanka</option>
								<option value="Sudan">Sudan</option>
								<option value="Suriname">Suriname</option>
								<option value="Svalbard and Jan Mayen">Svalbard and Jan
									Mayen</option>
								<option value="Swaziland">Swaziland</option>
								<option value="Sweden">Sweden</option>
								<option value="Switzerland">Switzerland</option>
								<option value="Syria">Syria</option>
								<option value="Taiwan">Taiwan</option>
								<option value="Tajikistan">Tajikistan</option>
								<option value="Tanzania">Tanzania</option>
								<option value="Thailand">Thailand</option>
								<option value="Togo">Togo</option>
								<option value="Tokelau">Tokelau</option>
								<option value="Tonga">Tonga</option>
								<option value="Trinidad and Tobago">Trinidad and Tobago</option>
								<option value="Tunisia">Tunisia</option>
								<option value="Turkey">Turkey</option>
								<option value="Turkmenistan">Turkmenistan</option>
								<option value="Turks and Caicos Islands">Turks and
									Caicos Islands</option>
								<option value="Tuvalu">Tuvalu</option>
								<option value="U.S. Virgin Islands">U.S. Virgin Islands</option>
								<option value="Uganda">Uganda</option>
								<option value="Ukraine">Ukraine</option>
								<option value="United Arab Emirates">United Arab
									Emirates</option>
								<option value="United Kingdom">United Kingdom</option>
								<option value="United States">United States</option>
								<option value="Uruguay">Uruguay</option>
								<option value="Uzbekistan">Uzbekistan</option>
								<option value="Vanuatu">Vanuatu</option>
								<option value="Vatican City">Vatican City</option>
								<option value="Venezuela">Venezuela</option>
								<option value="Vietnam">Vietnam</option>
								<option value="Wallis and Futuna">Wallis and Futuna</option>
								<option value="Western Sahara">Western Sahara</option>
								<option value="Yemen">Yemen</option>
								<option value="Zambia">Zambia</option>
								<option value="Zimbabwe">Zimbabwe</option>

							</select>
							<div class="invalid-feedback ">Please Enter Valid Country
								Name.</div>

						</div>
					</div>

					<div class="col-md-3 hospital_row" id="hos">
						<div class="mb-3 mt-4">
							<label for="" class="form-label ">Hospital Name and
								Registration No(रुग्णालयाचे नाव आणि नोंदणी क्र.)<span
								class="text-danger" style="color: red;"">*</span>
							</label> <select class="form-select " style="background-image: none;"
								id="iOperation" name="hospitalName" required disabled>
								<option value="" selected="">-Select Hospital-</option>
								


							</select>

							<div class="invalid-feedback ">Please Select Valid Hospital
								Name and Registration No.</div>
						</div>
					</div>

					<div class="col-md-12 homeAddress">
						<div class="mb-3 mt-1">
							<label for="" class="form-label ">Home Address at the
								time of birth (जन्माच्या वेळीचा घर पत्ता) <span
								class="text-danger" style="color: red;"">*</span>
							</label>

							<textarea class="form-control" style="background-image: none;"
								oninput="validateTextarea2()" id="homeAddress" placeholder=""
								name="homeAddress" rows="2" required></textarea>
							<div class="invalid-feedback" id="reasonerror2">Please
								Enter Valid Home address.</div>
						</div>
					</div>

					<script>
function validateTextarea2() {
  const textarea2 = document.getElementById('homeAddress');
  const errorFeedback2 = document.getElementById('reasonerror2');
  const text2 = textarea2.value;

  // Regular expression to check for leading spaces before the first letter
  const regex = /^\s*(\S)/;

  if (regex.test(text2)) {
    textarea2.classList.remove('is-invalid');
    reasonerror2.style.display = 'none';
  } else {
    textarea2.classList.add('is-invalid');
    reasonerror2.style.display = 'block';
  }
}
</script>

					<div class="col-md-12 mb-3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label ">Reason For Certificate
								(प्रमाणपत्राचे कारण) </label>

							<textarea class="form-control" oninput="validateTextarea1()"
								style="background-image: none;" id="reason" placeholder=""
								name="reasonForCertificate" rows="2"></textarea>
							<div class="invalid-feedback" id="reasonerror">Please Enter
								Valid Reason For Certificate.</div>
							<script>
function validateTextarea1() {
  const textarea = document.getElementById('reason');

  const errorFeedback = document.getElementById('reasonerror');

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
						</div>

					</div>
 <div class="mb-4 mt-3">
    <label for="" class="form-label ">Certificates And Fees Details (प्रमाणपत्रे आणि फी तपशील)<span class="text-danger"
            style="color: red;">*</span></label>
<div class=" d-flex mt-2 border rounded p-2" style="height: 180px;">
            <div class="col- mb-3 ms-4">
                <div class="mb-3" style="margin-top: 64px;">



<label for="" class="form-label">Certificate Expected in Days (दिवसात प्रमाणपत्र अपेक्षित आहे)<span
                            class="text-danger" style="color: red;">*</span> </label>
                    <label class="form-check-label" for="">
                    </label><br>
                    <input class="form-check-input" type="radio" value="1" id="same" name="certificateExpectedInDays"
                    onclick="checkSelectitem(id)" required>

                    <label class="form-check-label" for="checkbox">
                        Same Day (त्याच दिवशी)
                    </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input class="form-check-input" type="radio" value="2" id="other" name="certificateExpectedInDays"
                        onclick="checkSelectitem1(id)" required>
                        <div class="invalid-feedback">
                            Please Select One Option
                        </div>
                    <label class="form-check-label" for="checkbox">
                        Till Third Day (तिसऱ्या दिवसापर्यंत)
                    </label>
                </div>
            </div>


            <script>
            function multiplyBy()
            {
            	  const noofcopies = document.getElementById('number');
                  noofcopies.addEventListener('input', function() {
                      const firstChar = this.value.charAt(0);
                      if (firstChar === '0' || firstChar === '-') {
                          document.getElementById('number').value='';
                          this.classList.add('is-invalid');
                      } else {
                          this.classList.remove('is-invalid');
                      }
                  });
              
                var same1=$("#same").prop('checked');
                var other1=$("#other").prop('checked');
                console.log(same1)
                if(same1==true)
                {
                    console.log("lll")
                    $("#fees").val($("#number").val()*100)
                }
                    
                else
                    $("#fees").val($("#number").val()*20)
            }
            function checkSelectitem()
            {
                document.getElementById("number").removeAttribute('readonly');
                $("#fees").val($("#number").val()*100)
            }
            function checkSelectitem1()
            {
                document.getElementById("number").removeAttribute('readonly');
                $("#fees").val($("#number").val()*20)
            }
            
                
            </script>
            
								<div class="col-md-3 mb-3 ms-4">
									<div class="mb-3 ms-3" style="margin-top: 27px;">
										<label for="" class="form-label">No. Of Certificate
											Copies (प्रमाणपत्राच्या प्रतींची संख्या)<span
											class="text-danger" style="color: red;">*</span>
										</label> <input type="text" class="form-control"
											style="background-image: none;" id="number"
											placeholder="Enter Number of Certificate Copies"
											name="noOfCertificateCopies" onchange="validateZero()"
											rows="4"
											oninput="multiplyBy(this.form); 
                       this.value = this.value.replace(/[^0-9]/g, '')"
											;
                        readonly maxlength="2" required></input>
										<div class="invalid-feedback" id="zero-error">Please
											Enter Valid No. of Certificate Copies.</div>
									</div>
									<script>
								
								function validateZero() {
									  const textzero= document.getElementById('number');
									  const errorFeedback = document.getElementById('zero-error');
									  const text = textzero.value;

									 

									  if (textzero.value ==='0') {
				                          document.getElementById('number').value='';
										  textzero.classList.add('is-invalid');
									    errorFeedback.style.display = 'block';
									  } else {
										  textzero.classList.remove('is-invalid');
									    errorFeedback.style.display = 'none';
									  }
									}
								
								</script>
								</div>
								<div class="col-md-4 mb-3 ms-5">
									<div class="mb-3 mt-1">
										<label for="" class="form-label">Fees Applicable (Auto
											calculate as per the basis on Days and No. of Copies) (फी
											लागू (स्वयंचलित नुसार गणना करा दिवस आणि प्रतींच्या संख्येवर
											आधारित))<span class="text-danger" style="color: red;">*</span>
										</label> <input type="number" class="form-control"
											style="background-image: none;" id="fees" placeholder=""
											name="feesApplicable" rows="4" readonly required></input>

									</div>
								</div>
							</div>
						</div>
					</div>


					<div class="row">

						<h6 class="mt-4">
							<strong class="form-label "> List Of Documents (with
								attachment) (कागदपत्रांची यादी (संलग्नकांसह)) </strong>
						</h6>


						<div class="alert alert-info mb-0 p-2 mb-4 ms-2">
							<small class="form-label "><strong class="form-label ">Note(नोंद):
							</strong> Upload below files in .pdf(Max upto 2 MB)(खालील फाइल .pdf मध्ये
								अपलोड करा (कमाल २ MB पर्यंत))</small>

						</div>
						<input type="hidden" name="filesPath" id="filesPath" />
						<div class="row">
							<div class="col-md-3" id="docHos">
								<div class="mb-3" style="margin-top: 62px;">
									<label for="" class="form-label ">Hospital Certificate
										(रुग्णालयाचे प्रमाणपत्र)<span class="text-danger"
										style="color: red;">*</span>
									</label> <input type="file"  accept=".pdf" class="form-control"
										style="background-image: none;" id="doc1" placeholder=""
										name="7/12_file" required>
									<div class="invalid-feedback">File selected is either
										greater than 2Mb or not of type .pdf.</div>

								</div>
							</div>
	<div class="col-md-3" id="indiaResidency">
								<div class="mb-3" style="margin-top: 38px;">
									<label for="" class="form-label "> Attachment regarding
										Permanent Settelment in India (भारतातील कायमस्वरूपी
										सेटलमेंटबाबत संलग्नक)<span class="text-danger"
										style="color: red;">*</span>
									</label> <input type="file" accept=".pdf"  class="form-control"
										style="background-image: none;" id="doc2" placeholder=""
										name="7/12_file" required>
									<div class="invalid-feedback">File selected is either
										greater than 2Mb or not of type .pdf.</div>

								</div>
							</div>

							<div class="col-md-3">
								<div class="mb-3" style="margin-top: -8px">
									<label for="" class="form-label ">Father's/Mother's ID
										Proof(Aadhaar/Pan/Voting Card/T.C/etc) (वडिलांचा/आईचा ओळखपत्र
										पुरावा (आधार/पॅन/मतदान कार्ड/टी.सी/इ.) प्रमाणपत्र)<span
										class="text-danger" style="color: red;">*</span>
									</label> <input type="file" accept=".pdf"  class="form-control"
										style="background-image: none;" id="doc3" placeholder=""
										name="7/12_file" required>
									<div class="invalid-feedback">File selected is either
										greater than 2Mb or not of type .pdf.</div>

								</div>
							</div>

							<div class="col-md-3">
								<div class="mb-3" style="margin-top: 15px">
									<label for="" class="form-label "> Applicant's ID Proof
										(Aadhar/PAN/Voting Card/T.C./etc) (अर्जदाराचा ओळखपत्र पुरावा
										(आधार/पॅन/मतदान कार्ड/टी.सी./इ.))<span class="text-danger"
										style="color: red;">*</span>
									</label> <input type="file" accept=".pdf"  class="form-control"
										style="background-image: none;" id="doc4" placeholder=""
										name="7/12_file" required>
									<div class="invalid-feedback">File selected is either
										greater than 2Mb or not of type .pdf.</div>

								</div>
							</div>

							<!-- <div class="col-md-3">
								<div class="mb-3 mt-3">
									<label for="" class="form-label ">Mother's ID
										Proof(Aadhaar/Pan/Voting Card/T.C/etc) (आईचा ओळखपत्र पुरावा
										(आधार/पॅन/मतदान कार्ड/टी.सी/इ.))<span class="text-danger"
										style="color: red;">*</span>
									</label> <input type="file" accept=".pdf"  class="form-control"
										style="background-image: none;" id="doc5" placeholder=""
										name="7/12_file" required>
									<div class="invalid-feedback">File selected is either
										greater than 2Mb or not of type .pdf.</div>

								</div>
							</div>-->

							<div class="col-md-3" id="doc_1">
								<div class="mb-3" style="margin-top: 40px;">
									<label for="" class="form-label ">Certificate issued by
										Correspondent<br>(ward/Aasha member) (बातमीदाराने जारी केलेले
										प्रमाणपत्र(प्रभाग/आशा सदस्य))
									</label> <input type="file" accept=".pdf" class="form-control"
										style="background-image: none;" id="doc5" placeholder=""
										name="7/12_file">

								</div>
							</div>

						
						</div>
						<div class="col-md-12">
							<div class="mb-3 mt-4">
								<div class="form-check">
									<input class="form-check-input" type="checkbox" id="check1"
										name="declaration" value="something" required> <label
										class="form-check-label mt-0 ms-2 " style="margin-top: -15px;">
										<strong>Declaration(घोषणा)<span class="text-danger"
											style="color: red;">*</span>:-
									</strong>I hereby declare that , all the information provided by me in
										the above application is true. If it found wrong or not
										related , I permit to reject the application.(मी याद्वारे
										घोषित करतो की, माझ्याद्वारे प्रदान केलेली सर्व माहिती वरील
										अर्ज खरा आहे. जर ते चुकीचे आढळले किंवा संबंधित नाही, मी अर्ज
										नाकारण्याची परवानगी देतो.)<br>
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

				</div>
	</form>




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
                                onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/saveRTIBirthApplication.do');
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
                    filesPath = filesPath + basePath + "birthcertificate/" + id + value + ","
                    isFileSelected = true;
                }
            }
            $.ajax({
                url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadDocumentBirth.do?id="+id,
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
    // Get the current date
    var currentDate = new Date().toISOString().split("T")[0];

    // Set the maximum attribute of the input field
    document.getElementById("dob").setAttribute("max", currentDate);
    
  
</script>





	<script>
$('input[type=radio][name=yes]').change(function () {
	if (this.value == '1') {
		
	  
	    
	}  else if (this.value == '2') {
	   
	    $("#Address").prop('required',true);
	   

	}
	});







$(".homeAddress").hide();

$(".hospital_row").hide();
$("#docHos").hide();
$("#indiaResidency").hide();
$("#country").hide();
$("#doc_1").hide();


$('input[type=radio][name=placeofbirth]').change(function () {
if (this.value == 'Home (घर)') {
	$(".homeAddress").show();
	$("#indiaResidency").hide();

    $("#docHos").hide();

    $(".hospital_row").hide();
    
    $("#country").hide();
    $("#doc1").prop('required',false);
    $("#doc2").prop('required',false);
    $("#iOperation").prop('required',false);
    $("#countryName").prop('required',false);
    $("#homeAddress").prop('required',true);
    $("#doc_1").show();

    
} else if (this.value == 'Hospital (रुग्णालय)') {
    $("#docHos").show();
    $(".homeAddress").hide();
    $("#indiaResidency").hide();

    $(".hospital_row").show();
    $("#country").hide();
    $("#iOperation").prop('required',true);
    $("#doc1").prop('required',true);
    $("#homeAddress").prop('required',false);
    $("#countryName").prop('required',false);
    $("#doc2").prop('required',false);
    $("#doc_1").hide();


} else if (this.value == 'Out of India(भारताबाहेर)') {
    $("#docHos").hide();
    $(".homeAddress").hide();
    $("#indiaResidency").show();

    $(".hospital_row").hide();
    $("#country").show();
    $("#doc1").prop('required',false);
    $("#iOperation").prop('required',false);
    $("#homeAddress").prop('required',false);
    $("#doc2").prop('required',true);
    $("#countryName").prop('required',true);
    $("#doc_1").hide();



}
});


$(".post_mortem").hide();
$('input[type=radio][name=dt]').change(function () {
if (this.value == '3') {

    $(".post_mortem").hide();
} else if (this.value == '4') {

    $(".post_mortem").show();
}
});

</script>
	

</body>
</form>
</div>
<script type="text/javascript">
$('.printMe').on('click', function () {

    window.print();
});
</script>
<script>                    
			var strArray = document.getElementsByTagName('textarea');
			if(strArray){             
				for(i=0;i<strArray.length;i++){
					strArray[i].value = Trim(strArray[i].value);
			}
		}
		</script>

<script type="text/javascript">
				if(parent.document.getElementById('divPopup'))
				{
					parent.hideDiv();
					parent.document.location.href="<c:out value='${contextRoot}'/>/login.do";
				}
			</script>

</body>

 <script>
$(".default").hide();
$(".fixed").hide();

$('input[type=radio][name=childNameFixed]').change(function () {
    if (this.value == 'Yes') {
        $(".fixed").show();
        $(".default").hide();
        $("#default").prop('required', false).removeAttr("name");
        $("#fixed").prop('required', true).attr("name", "childeName");

    } else if (this.value == 'No') {
        $(".default").show();
        $(".fixed").hide();
        $("#fixed").prop('required', false).removeAttr("name");
        $("#default").prop('required', true).attr("name", "childeName");
    }
});
</script>

<script>
function callHospitalList() {
    const zoneId = document.getElementById('iFunction').value;
    $.ajax({
        url: "<c:out value='${contextRoot}'/>/mobileapp/getCitizenHospitalList/" + zoneId,
        type: 'GET',
        cache: false,
        dataType: 'json',
        success: function(data) {
            populateDropdown(data.hospitalName);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.error("AJAX Error:", textStatus, errorThrown);
        }
    });
}

function populateDropdown(data) {
	
    document.getElementById("iOperation").removeAttribute('disabled');
    const dropdown = document.getElementById('iOperation');

    dropdown.innerHTML = ''; 	
    const selectOption = document.createElement('option');
    selectOption.value = '';
    selectOption.text = '-Select Hospital-'; 																																										
    dropdown.appendChild(selectOption);

    for (let i = 0; i < data.length; i++) {
        const hospitalName = data[i].hospitals_name;

        const option = document.createElement('option');
        option.value = hospitalName;
        option.text = hospitalName;
        dropdown.appendChild(option);
    }
}


    </script>
</html>

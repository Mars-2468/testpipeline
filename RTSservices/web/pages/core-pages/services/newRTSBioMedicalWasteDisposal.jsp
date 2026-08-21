<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.include file="/pages/core-pages/nmc_user/dashboard/header.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants" />
<jsp:directive.page import="com.mars.common.utils.CommonUtils" />
		<jsp:directive.page import="com.mars.rti.utils.CoreConstants" />



<head>
    <title>Napur Municipal Corporation</title>
    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="csrf-token" content="L1tBXJBCG7Qg3zc8hd8zkv3US8Yq8R7ihDGuzHIc" />
    <script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="jquery-3.6.1.min.js"></script>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
crossorigin="anonymous"></script>
<script src="Vjdog.js"></script>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
 <script type="text/javascript"
	src="<c:out value=" ${contextRoot}" />/scripts/jquery/jquery.ajaxfileupload.js"></script>
	<link rel="stylesheet" href="<c:out value='${contextRoot}'/>/pages/core-pages/nmc_user/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<c:out value='${contextRoot}'/>/pages/core-pages/nmc_user/css/style2.css" /> 
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>
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
form {
    position: relative;
    padding-bottom: 120px; /* Ensure there's space for the contact details */
}

.contact-details {
    position: absolute;
    right: 0px;
    background: #f9f9f9; /* Light background color */
    border: 1px solid #ccc; /* Border */
    border-radius: 8px; /* Rounded corners */
    padding: 20px; /* Padding inside the box */
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Subtle shadow */
    text-align: left; /* Align text to the left */
    max-width: 300px; /* Limit the width */
    font-family: 'Arial', sans-serif; /* Font family */
}

.contact-details p {
    margin: 5px 0; /* Margin between paragraphs */
    font-size: 14px; /* Font size */
    color: #333; /* Text color */
}

.contact-title {
    font-size: 16px; /* Larger font for the title */
    font-weight: bold; /* Bold title */
    color: #007bff; /* Custom color for the title */
}

.contact-details a {
    color: #007bff; /* Link color */
    text-decoration: none; /* Remove underline */
}

.contact-details a:hover {
    text-decoration: underline; /* Underline on hover */
}

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

</head>
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

                            <li>1.Degree Certificate(पदवी प्रमाणपत्र) <span class="text-danger"  style="color: red;">*</span></li>
                            <li>2.Council Registration Certificate(कौन्सिल नोंदणी प्रमाणपत्र) <span class="text-danger"  style="color: red;">*</span> </li>
                            <li>3.Aadhaar Card (आधार कार्ड)<span class="text-danger"  style="color: red;">*</span></li>
                            <li>4.Current year receipt of property tax(मालमत्ता कराची चालू वर्षाची पावती)<span class="text-danger" style="color: red;">*</span> </li>
                            <li>5.Property document or rent agreement (If rented) (मालमत्ता दस्तऐवज किंवा भाडे करार (भाड्याने घेतल्यास))</li> 

                        </ul>

                    </div>

                    <!-- dialog buttons -->

                    <div class="modal-footer"><button type="button" class="btn btn-primary">OK</button></div>

                </div>

            </div>

        </div>

<body>
    <form id="CanDetails" class="needs-validation" novalidate>
	<div class="container-fluid mt-2" style="width: 190vh">
            
            <div class="printable">
                <h3  class="text-center"><strong>Bio Medical Waste Disposal(BMWD) (जैव वैद्यकीय कचरा विल्हेवाट)</strong></h3>
            </div>
            <div class="row align-items-center">

          <h6 style="background-color: #dce2e8; padding: 10px;"
			class="  rounded-2">
			<strong> Applicant Details (अर्जदाराचे तपशील) </strong>
		</h6>
		<div class="row">
			<input type="hidden" name="_token" value="xyz">
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Title (शीर्षक) <span
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
						<label for="" class="form-label lbleng">Name (नाव)<span
							class="text-danger">*</span></label> <input type="text"
							class="form-control" style="background-image: none;"
							id="first_name" placeholder="" name="firstName" value=""
							pattern="[A-Za-z]+" onchange="Display(this.id)" required>
							<div class="invalid-feedback">Please Enter Valid Name.</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Father's Name(वडीलांचे नाव)</label> <input type="text" class="form-control"
							style="background-image: none;" id="middle_name" placeholder=""
							name="middleName" value="" pattern="[A-Za-z]+"
							onchange="Display(this.id)">
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Surname (आडनाव)<span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control" style="background-image: none;"
							name="lastName" id="last_name" value="" pattern="[A-Za-z]+"
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
				</div> <script>
                    function Display(id) {
                                  $('#full_name').val( $('#first_name').val()+" "+ $('#middle_name').val()+" "+ $('#last_name').val())
                            }
                    </script>
          
<div class="col-md-3">
					<div class="mb-3 mt-3">

						<label for="email" class="form-label lbleng"> Email Id (ई
							- मेल आयडी) <span class="text-danger">*</span>
						</label> <input type="email" class="form-control "
							style="background-image: none;" name="email" value="" required>
							<div class="invalid-feedback">Please Enter Valid Email Id.
							</div>
					</div>
				</div>


				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label"> Mobile No. (मोबाईल क्र.)<span
							class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control "
							style="background-image: none;" id="txtMobileNumber"
							placeholder="" name="mobileNumber" value=""
							pattern="[6-9]{1}[0-9]{9}" maxlength="10" required>
							<div class="invalid-feedback">Please Enter Valid Mobile No.
							</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label ">Zone No(झोन क्र.)<span
							class="text-danger" style="color: red;" id="zone"
							onclick="Zoneno(this.form)">*</span>
						</label> <select class="form-select " style="background-image: none;"
							id="iFunction" name="zoneNo" onchange="changeddl(this)" required>
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

						<div class="invalid-feedback ">Please Enter Valid Zone No.</div>

					</div>
				</div>

<div class="col-md-3">
    <div class="mb-3 mt-4">
        <label for="education" class="form-label lbleng">
            Educational Qualification (शैक्षणिक पात्रता)<span class="text-danger" style="color: red;">*</span>
        </label>
        <select class="form-select" id="education" name="education" style="background-image: none;" required onchange="toggleOtherDegree()">
            <option value="">-Select-</option>
            <option value="MBBS">MBBS</option>
            <option value="BAMS">BAMS</option>
            <option value="BHMS">BHMS</option>
            <option value="BPT">BPT</option>
            <option value="BUMS">BUMS</option>
            <option value="BDS">BDS</option>
            <option value="B.Sc. Nursing">B.Sc. Nursing</option>
            <option value="Other">Other</option>
        </select>
        <div class="invalid-feedback">Please Select Valid education.</div>
    </div>
</div>

<div class="col-md-3 other_degree_row" id="otherDegreeRow" style="display: none;">
    <div class="mb-3 mt-4">
        <label for="otherDegree" class="form-label lbleng">
            Other degree (इतर पदवी)
            <span class="text-danger" style="color: red;">*</span>
        </label>
        <input type="text" class="form-control" id="otherDegree" placeholder="" name="otherDegree" value="">
        <div class="invalid-feedback">Please Enter Valid Other degree.</div>
    </div>
</div>

<script>
    function toggleOtherDegree() {
        var educationSelect = document.getElementById('education');
        var otherDegreeRow = document.getElementById('otherDegreeRow');
        var otherDegreeInput = document.getElementById('otherDegree');
        
        if (educationSelect.value === 'Other') {
            otherDegreeRow.style.display = 'block';
            otherDegreeInput.setAttribute('required', 'required');
        } else {
            otherDegreeRow.style.display = 'none';
            otherDegreeInput.removeAttribute('required');
            otherDegreeInput.value = '';
        }
    }
</script>


<div class="col-md-3">

    <div class="mb-3 mt-0">

        <label for="" class="form-label lbleng">Name of Hospital/Clinic/Office (रुग्णालय/क्लिनिक/कार्यालयाचे नाव)<span class="text-danger"
							style="color: red;">*</span> </label>

       
        <input type="text" class="form-control" id="" placeholder="" name="hospitalName"
            value="" style="background-image: none;" required>
             <div class="invalid-feedback">Please Select Valid Name of Hospital.</div>
    </div>

</div>





<div class="col-md-12">

    <div class="mb-3 mt-3">



        <label for="" class="form-label lbleng">Address of Hospital/Clinic (हॉस्पिटल/क्लिनिकचा पत्ता) <span class="text-danger"
							style="color: red;">*</span>
        </label>
        <textarea class="form-control" id="" placeholder="" name="hospitalAddress" value=""  style="background-image: none;" required></textarea>
         <div class="invalid-feedback">Please Select Valid Address of Hospital.</div>
    </div>

</div>






                

        <script>
                        function change()
                        {
                            var isOperated = $("#yes").prop('checked');
                            if(isOperated==true){
                            $("#Address").attr("readonly", false);
                            $("#Address").val($("#plot_no").val()+","+$("#buildingName").val()+","+$("#street_name").val()+","+$("#cityInput").val()+","+$("#landmarkInput").val()+","+$("#pincodeInput").val())
                             } else{
                            $("#Address").val("")
                             }
                        }

                    </script>
      <script>
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
   
                <h6 style="background-color:#dce2e8; padding:10px;" class=" mt-3 rounded-2"><strong> Application Form
                    Details (अर्ज तपशील)</strong></h6>
                    <div class="row">





<div class="col-md-3">

    <div class="mb-3 mt-4">



        <label for="" class="form-label lbleng">Type of Medical Profession(वैद्यकीय व्यवसायाचा प्रकाराचे नाव)<span class="text-danger"
							style="color: red;">*</span> </label>

      

        <select class="form-select" id="medicalProfessionType" name="medicalProfessionType"  style="background-image: none;"required>

            <option value="">-Select-</option>

                                        <option value="Anesthetics">Anesthetics</option>
                                        <option value="Dermatology">Dermatology</option>
                                        <option value="Emergency medicine">Emergency medicine</option>
                                        <option value="General practice">General practice</option>
                                        <option value="Gynecology">Gynecology</option>
                                        <option value="Pediatrics">Pediatrics</option>
                                        <option value="Pathology">Pathology</option>
                                        <option value="Psychiatry">Psychiatry</option>
                                        <option value="Radiology">Radiology</option>
                                        <option value="Surgery">Surgery</option>
                                        <option value="Other">Other</option>
            
        </select>
         <div class="invalid-feedback">Please Select Valid Type of Medical Profession.</div>

    </div>

</div>





<div class="col-md-3">
    <div class="mb-3 mt-4">
        <label for="numberOfBeds" class="form-label lbleng">
            Number of beds available (उपलब्ध खाटांची संख्या)
            <span class="text-danger" style="color: red;">*</span>
        </label>
        <input type="number" class="form-control" style="background-image: none;" id="numberOfBeds" placeholder="" name="numberOfBeds" min="1" max="2000" required>
        <div class="invalid-feedback">
            Please Enter Valid Number of Beds (1-2000).
        </div>
    </div>
</div>

<script>
    document.getElementById('numberOfBeds').addEventListener('change', function() {
        const value = parseInt(this.value, 10);
        if (value < 1 || value > 2000) {
            this.setCustomValidity('Please enter a number between 1 and 2000.');
        } else {
            this.setCustomValidity('');
        }
    });
</script>






<div class="col-md-3">

    <div class="mb-3 mt-4">

        <label for="" class="form-label lbleng">Medical Council Registration No.(मेडिकल कौन्सिलचा नोंदणी क्र.)   <span class="text-danger"
							style="color: red;">*</span></label>

        

        <input type="text" class="form-control" id="" placeholder=""
            name="medicalCouncilRegNumber" value="" style="background-image: none;" required>
                
                        <div class="invalid-feedback ">
                     Please Enter Valid Medical Council Registration No.  
                    </div>
                   
    </div>

</div>




<div class="col-md-3">

    <div class="mb-3 mt-0">



        <label for="" class="form-label lbleng">Full details of other professionals if any (इतर व्यवसाय असल्यास त्यांची संपूर्ण माहिती)</label>

     
        <input type="text" style="background-image: none;"class="form-control" id="" placeholder=""
            name="otherProfessionalsDetails" value="">
         
    </div>

</div>



<div class="col-md-12">

    <div class="mb-3 mt-3">



        <label for="" class="form-label lbleng">Description of Bio Medical Waste Disposal(जैविककचऱ्याचे विवरण) <span class="text-danger"
							style="color: red;">*</span></label>

              <textarea class="form-control" id="" placeholder="" name="biologicalWasteDescription" value=""  style="background-image: none;" required></textarea>
      


        	<div class="invalid-feedback">Please Select Valid Description of Bio Medical Waste Disposal.</div>
    </div>

</div>


<div class="row">



 <h6 style="background-color:white; padding:5px;" class="mt-1 rounded-2"><strong> List of Documents (with
                    attachment) (दस्तऐवजांची यादी (सह संलग्नक))</strong></h6>
            <div class="alert alert-info mb-2 p-2 mb-4">
                <small><strong>Note: </strong> Upload below files only .pdf(Max upto 2
                    MB)(खाली फक्त .pdf फाइल अपलोड करा (कमाल २MB पर्यंत))</small>
            </div>
            <input type="hidden" name="filesPath" id="filesPath" /> 

<div class="col-md-3">
                <div class="mb-3 mt-4">
                    <label for="" class="form-label">Degree Certificate (पदवी प्रमाणपत्र)<span class="text-danger"
                            style="color: red;">*</span>
                    </label>
                    <input type="file" class="form-control waterRequired" style="background-image: none;" name="taxpaidrecipt" id="city_survey" accept=".pdf" required>
                    <div class="invalid-feedback">
                    File selected is either greater than 2Mb or not of type .pdf.
                </div>

                </div>
            </div>

            <div class="col-md-3">
                <div class="mb-0 mt-0">
                    <label for="" class="form-label">Council Registration Certificate (कौन्सिल नोंदणी प्रमाणपत्र)<span class="text-danger"
                            style="color: red;">*</span>
             </label>
                    <input type="file" class="form-control waterRequired" style="background-image: none;" name=sanctionedplanconstruction id="city_survey1" accept=".pdf" required>
                    <div class="invalid-feedback">
                    File selected is either greater than 2Mb or not of type .pdf.
                </div>
                </div>
            </div>

                <div class="col-md-3">
                    <div class="mb-3 mt-4"> 
                        <label for="" class="form-label"> Aadhaar Card(आधार कार्ड)<span class="text-danger"
                            style="color: red;">*</span></label>
                        <input type="file" class="form-control waterRequired" style="background-image: none;" name="buildingPermission" id="city_survey2" accept=".pdf" placeholder="" required>

                            <div class="invalid-feedback">
                                File selected is either greater than 2Mb or not of type .pdf.
                            </div>
                    </div>
                </div>
                 <div class="col-md-3">
                    <div class="mb-3 mt-0"> 
                        <label for="" class="form-label"> Current year receipt of property tax (मालमत्ता कराची चालू वर्षाची पावती)<span class="text-danger">*</span> </label>
                        <input type="file" class="form-control waterRequired" style="background-image: none;" name="buildingPermission" id="city_survey3" accept=".pdf" placeholder="" required>

                            <div class="invalid-feedback">
                                File selected is either greater than 2Mb or not of type .pdf.
                            </div>
                    </div>
                </div>
 <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label"> Property document or rent agreement(If
            rented)(मालमत्ता दस्तऐवज किंवा भाडे करार (भाड्याने
            घेतल्यास))
                        <input type="file" class="form-control waterRequired" style="background-image: none;" name="buildingPermission" id="city_survey4" accept=".pdf" placeholder="">
                            <div class="invalid-feedback">
                                File selected is either greater than 2Mb or not of type .pdf.
                            </div>
                    </div>
                </div>
                
                </div>

                <div class="col-md-12">
                    <div class="mb-5 mt-4">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" id="check11" name="declaration"
                                value="something" required>

                            <label class="form-check-label ms-3 lbleng" style="margin-top: 0px;">
                                <strong>Declaration (घोषणा) <span class="text-danger"
                                    style="color: red;">*</span>:- </strong>The
                                above mentioned information is true to the best of my knowledge and belief.(वर नमूद केलेली माहिती माझ्या माहितीनुसार आणि विश्वासानुसार खरी आहे).
                            </label>
                            <div class="invalid-feedback">
                                Please check the declaration.
                            </div>
                        </div>
                    </div>
                </div>
                 <div class="col-md-12">
                                    <div class="mb-0" style="margin-top:-30px;">
                
                 <div class="contact-details">
        <p class="contact-title"><Strong>Superb Hygienic Disposals</Strong></p>
        <p>Phone: 07122232403</p>
        <p><a href="http://www.superbgroup.in" target="_blank">www.superbgroup.in</a></p>
    </div> 
    </div>
    </div>
                <div class="col-md-12 text-start mb-5">
                    <div class="text-center">
                        <button type="button" class="btn btn-danger btn_sm printMe">
                            View and Print
                        </button>
                             <button class="btn btn-success btn_sm" type="submit" id="submit">Submit</button>
                    
                    </div>
                    
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
                   	        onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveBiologicalWasteDisposal.do');
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

   	 data.append('idProof1', $("#city_survey").get(0).files[0]);
       	data.append('idProof2', $("#city_survey1").get(0).files[0]);
       	data.append('idProof3', $("#city_survey2").get(0).files[0]);
       	data.append('idProof4', $("#city_survey3").get(0).files[0]);
       	data.append('idProof5', $("#city_survey4").get(0).files[0]);

       //	data.append('idProof5', $("#city_survey4").get(0).files[0]);
      // 	data.append('idProof6', $("#city_survey5").get(0).files[0]);
  


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
                    filesPath = filesPath + basePath + "BioMedicalWaste/" + id + value + ","
                    isFileSelected = true;
                }
            }
            $.ajax({
                url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadBiologicalWasteDisposal.do?id="+id,
                type: 'POST',
                data: data,
                cache: false,
                dataType: 'json',
                processData: false,
                contentType: false,
                async: false, 
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
   

    
    
    function downloadFile() {
        var fileUrl = "<c:out value="${contextRoot}"/>/pages/citizendocument/Affidavit.pdf";
        var fileName = "Affidavit.pdf";
        
        var downloadLink = document.createElement("a");
        downloadLink.href = fileUrl;
        downloadLink.download = fileName;
        document.body.appendChild(downloadLink);
        downloadLink.click();
        document.body.removeChild(downloadLink);
    }
    
   
</script>

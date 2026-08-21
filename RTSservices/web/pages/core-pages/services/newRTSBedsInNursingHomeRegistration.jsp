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

<style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
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

                        <h6><strong>Note(नोंद): </strong> Upload below files in .pdf...Max upto 2 MB(खालील फाइल .pdf मध्ये अपलोड करा..कमाल २ MB पर्यंत)</h6>

                    </div>

                    <!-- dialog body -->

                    <div class="modal-body" style="color:green">



                      <p style="color:red">

                        <strong>List of document to be attached :
                        </strong>    
                        </p>

                        <ul style="color:rgb(3, 125, 76)">


<ul style="color: rgb(3, 125, 76)">

                 <li>For Medico Person (मेडिको व्यक्तीसाठी)</li>

					<li>1.Degree Certificate (पदवी प्रमाणपत्र)</li>
					<li>2.Additional Qualification Certificate
						(अतिरिक्त पात्रता प्रमाणपत्र)<span
						class="text-danger" style="color: red;">*</span>
					</li>
					<li>3.M.M.C Certificate
						(M.M.C प्रमाणपत्र) <span
						class="text-danger" style="color: red;">*</span>
					</li>
					<br>
					<li>For Non-Medico Person (नॉन-मेडिको व्यक्तीसाठी)</li>
					<li>1.Aadhaar Card(आधार कार्ड)<span
						class="text-danger" style="color: red;">*</span>
					</li>
					<li>2.PAN Card 
						(पॅन कार्ड)</li>
					<li>3.Appointment Letter
						(नियुक्ती पत्र)</li>

				</ul>
                        </ul>

                    </div>

                    <!-- dialog buttons -->

                    <div class="modal-footer"><button type="button" class="btn btn-primary">OK</button></div>

                </div>

            </div>

        </div>
</head>
<body>

<form class="needs-validation" novalidate>
		<div class="container-fluid mt-2" style="width: 1320px;">
		<div class="printable">
				<h3 class="text-center">Application For Change of Owner / Reduction/Increase in Number of Beds in Nursing Home Registration Certificate. (अतिरिक्त नाव नोंदणीसाठी ,बेड च्या संख्येत कपात /वाढ करण्यासाठी अर्जाचा नमुना) </h3>
			</div>
			
		    <div id="dropdownDiv" style="display: flex; justify-content: center;">
        <div class="col-md-5">
            <div class="mb-3 mt-6">
                <div class="d-flex mt-2 border rounded p-2">
                               &nbsp;&nbsp; <!-- <label for="" class="form-label"> अतिरिक्त नाव नोंदणीसाठी ,बेड च्या संख्येत कपात /वाढ करण्यासाठी अर्जाचा नमुना:</label> -->
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <div class="form-check ms-3">
                        <input type="radio" class="form-check-input" id="radio3" name="myDropdown" value="3" onclick="showForm(),showFormList(this.value)" required>अ) अतिरिक्त नाव नोंदणीसाठी
                        <label class="form-check-label" for="radio1"></label>
                    </div>&nbsp;&nbsp;&nbsp;&nbsp;
                    <div class="form-check ms-3">
                        <input type="radio" class="form-check-input" id="radio4" name="myDropdown" value="4" onclick="showForm(),showFormList(this.value)" required>ब) बेड च्या संख्येत कपात / वाढ 
                        <div class="invalid-feedback">Please select an option.</div>
                        <label class="form-check-label" for="radio1"></label>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <script>
        function showForm() {
            var radio3Checked = document.getElementById("radio3").checked;
            var radio4Checked = document.getElementById("radio4").checked;
            var formDiv = document.getElementById("myForm");
            var formDiv1 = document.getElementById("myForm1");
            var changeFormm = document.getElementById("changeFormm");

    	    var divElement = document.querySelector(".mb-3.nit"); // Selects element with both classes 'mb-3' and 'nit'

            if (radio3Checked) {
            	 formDiv.style.display = "block";
            	 formDiv1.style.display = "none";
            	 changeFormm.style.display="none";
     	    } else if (radio4Checked) {
     	    	  formDiv1.style.display = "block";
     	    	 formDiv.style.display = "none";
     	    	changeFormm.style.display="block";

            } else {
            	  formDiv1.style.display = "none";
      	    	 formDiv.style.display = "none";
      	    	changeFormm.style.display="none";
      	    	 }
        }
        
        function showFormList(id) {

            if (id === "3") {
                $('#myModal1').modal('show');
            } else {
                $('#myModal2').modal('show');
            }

            $('#myModal1 .modal-footer .btn, #myModal2 .modal-footer .btn').on('click', function(e) {
                console.log('button pressed');
                if (id === "3") {
                    $('#myModal1').modal('hide');
                } else {
                    $('#myModal2').modal('hide');
                }
            });
        }
    </script>
    
    
			<h6 style="background-color:#dce2e8; padding:10px;" class="  rounded-2"><strong> Applicant Details (अर्जदाराचे तपशील)</strong></h6>


    <div class="row">
                            <div id="changeFormm" style="display: none;">
      <div class="row">
   <div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Name (नाव)<span class="text-danger">*</span>
						</label> <input type="text" class="form-control" id="name"
							style="background-image: none;" placeholder="" name="name"
							value="" pattern="[A-Za-z]+" maxlength="40" required>
						<div class="invalid-feedback">Please Enter Valid First Name.
						</div>
					</div>
				</div>
        
       <div class="col-md-3">
					<div class="mb-3 mt-3">

						<label for="email" class="form-label lbleng"> Email Id
							(ईमेल आयडी ) <span class="text-danger">*</span>
						</label> <input type="email" class="form-control "
							style="background-image: none;" name="emailId" id="emailId" value="" required>
						<div class="invalid-feedback">Please Enter Valid Email Id.</div>
					</div>
				</div>
				
				
        
     <div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label"> Mobile No.(मोबाईल क्र.)<span
							class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control " id="mobileNo"
							style="background-image: none;" placeholder="" name="mobileNo"
							value="" pattern="[6-9]{1}[0-9]{9}" maxlength="10" required>
						<div class="invalid-feedback">Please Enter Valid Mobile No.
						</div>
					</div>
				</div>
        
        <div class="col-md-12">
					<div class="mb-3 mt-3 ">
						<label for="primary_full_address" class="form-label lbleng">Address
							For Correspondence (पत्रव्यवहारासाठी पत्ता)<span
							class="text-danger">*</span>
						</label>

						<textarea class="form-control " rows="2" id="address"
							style="background-image: none;" name="address" oninput="validateTextarea()" maxlength="80" required></textarea>
						<div class="invalid-feedback" id="errorFeedback">Please Enter Valid Address.</div>

					</div>
				</div>
				</div>
        </div>
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

<div class="col-md-4">
            <div class="mb-3 mt-1">
                <label for="" class="form-label">Nursing Home Registration Number (नर्सिंग होम नोंदणी क्रमांक)<span
								class="text-danger" style="color: red;" id="zone"
								>*</span> </label>
                <input type="text" class="form-control" id="" style="background-image: none;" onkeypress="return isNumber(event)" placeholder="" name="nursingHomeRegNumber"
                    value="" required>
                                         <div class="invalid-feedback">Please Enter valid Home Registration Number</div>			
            </div>
        </div>
        
        
 
    <div class="col-md-3">
						<div class="mb-3 mt-4">
							<label for="" class="form-label ">Zone No(झोन क्र.)<span
								class="text-danger" style="color: red;" id="zone"
								onclick="Zoneno(this.form)">*</span>
							</label> <select class="form-select " style="background-image: none;"
								id="iFunction" name="zoneNo"  required>
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
						<div class="col-md-3">
            <div class="mb-3 mt-3" id="fees">
                <label for="" class="form-label">Fees Applicable (शुल्क लागू)<span
								class="text-danger" style="color: red;" id="zone"
								>*</span>
                </label>
                <input type="text" class="form-control" id="totalFees" style="background-image: none;" placeholder="" name="totalFees"
                    value="" required readonly>
                                                                                 <div class="invalid-feedback">Please Enter valid Fees Applicable</div>			
                    
            </div>
        </div>
						          <div class="row align-items-end">
						
            <div class="row">
        
         <h6 class="mt-4"><strong>Number of beds sanctioned to the hospital (रूग्णालयासाठी मंजूर खाटांची संख्या)</strong></h6>

</div>

        <div class="col-md-3">
            <div class="mb-3 mt-3">
                <label for="" class="form-label">Maternity Patients(प्रसूती रुग्ण)<span
								class="text-danger" style="color: red;" id="zone"
								>*</span> </label>
                <input type="number" class="form-control"  maxlength="3"  style="background-image: none;" placeholder="" name="sanctionedBedMaternity" id="sanctionedBedMaternity"
                    value="" required>
                                                             <div class="invalid-feedback">Please Enter valid Maternity Patients</div>			
                    
            </div>
        </div>

        <div class="col-md-3">
            <div class="mb-3 mt-3">
                <label for="" class="form-label">Other Nursing Patients (इतर नर्सिंग रुग्ण)<span
								class="text-danger" style="color: red;" id="zone"
								>*</span>
                </label>
                <input type="number" class="form-control"   maxlength="3"  id="sanctionedBedOther" style="background-image: none;" placeholder="" name="sanctionedBedOther"
                    value="" required>
                                                                                 <div class="invalid-feedback">Please Enter valid Other Nusrsing Patients</div>			
                    
            </div>
            </div>
            
             

        </div>
        
        
        <script>

        $(document).ready(function() {
            $('#fees').hide();

            function calculateFees() {
                var sanctionedBedMaternity = $('#sanctionedBedMaternity').val(); 
                var sanctionedBedOther = $('#sanctionedBedOther').val();
                var changeBedMaternity = $('#changeBedMaternity').val(); 
                var changeBedOther = $('#changeBedOther').val();
                var totalFees = $('#totalFees').val();
                var flag = false;
                var flag1 = false;
                

                // if flag true then fees addon of 25%
                if ($('#radio3').is(':checked')) {
                	  $('#fees').show();
                	if (sanctionedBedMaternity !== '' && sanctionedBedOther !== '') {
                        totalFees = parseFloat(sanctionedBedMaternity) + parseFloat(sanctionedBedOther);
                        flag1=true;
                    } else {
                        totalFees = 0;
                        flag = false;
                    }
                    if ($('#radio5').is(':checked')) {
                    	if (sanctionedBedMaternity !== '' && sanctionedBedOther !== '') {
                            totalFees = parseFloat(sanctionedBedMaternity) + parseFloat(sanctionedBedOther);
                            flag = true;
                        } else {
                            totalFees = 0;
                            flag = false;
                        }
                       
                    }else if($('#radio6').is(':checked')){
                    	if (sanctionedBedMaternity !== '' && sanctionedBedOther !== '') {
                            totalFees = parseFloat(sanctionedBedMaternity) + parseFloat(sanctionedBedOther);
                            flag = false;
                        } else {
                            totalFees = 0;
                            flag = false;
                        }
                    
                            }
                    
                    
                    }else if ($('#radio4').is(':checked')){
                    	  $('#fees').show();
                    	if (sanctionedBedMaternity !== '' && sanctionedBedOther !== '') {
                            totalFees = parseFloat(changeBedMaternity) + parseFloat(changeBedOther);
                            flag1=true;
                        } else {
                            totalFees = 0;
                            flag = false;
                        }
                    if (changeBedMaternity !== '' && changeBedOther !== '') {
                        totalFees = parseFloat(changeBedMaternity) + parseFloat(changeBedOther);
                        flag=true;
                    } else {
                        totalFees = 0;
                        flag=false;
                    }
                
                } else {
                	  $('#fees').show();
                    flag = false;
                }

                if (flag) {
                	 var fixfees = 5000;
 			        var inputText = totalFees;
 			        var inputDiv = Math.floor(parseInt(inputText) / 5); 
 			        var inputModule = parseFloat(inputText) % 5; 

 			        if(inputModule!=0)
 			            inputDiv += 1;

 			            var mainFees = inputDiv * fixfees;
 			       
                     totalFees = mainFees;
			       
                    totalFees = totalFees + totalFees * 0.25;
                    $('#totalFees').val(totalFees);
                    
                }else if(flag1){
			        var fixfees = 5000;
			        var inputText = totalFees;
			        var inputDiv = Math.floor(parseInt(inputText) / 5); 
			        var inputModule = parseFloat(inputText) % 5; 

			        if(inputModule!=0)
			            inputDiv += 1;

			            var mainFees = inputDiv * fixfees;
			       
                    totalFees = mainFees;
                    $('#totalFees').val(totalFees);
                	
                }else{
                	var defaultfees=0;
                    $('#totalFees').val(defaultfees);

                	
                }
           

                console.log('Total Fees:', totalFees);
            }

            $('#sanctionedBedMaternity, #sanctionedBedOther, #changeBedMaternity, #changeBedOther, #radio3, #radio4, #radio5, #radio6').on('change', calculateFees);
            
        });
        </script>
                    <div id="myForm" style="display: none;">
        
                   
        
        
        	    <div id="dropdownDiv" style="display: flex; justify-content: left;">
        <div class="col-md-12">
            <div class="mb-3 mt-6">
                <div class="d-flex mt-2 border rounded p-2">
                               &nbsp;&nbsp; 
                                    <label for="" class="form-label">Change in Owner/Addition of owner details (मालकामध्ये बदल/मालक तपशील जोडणे)<span class="text-danger" style="color: red;">*</span></label>
                               
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <div class="form-check ms-3">
                        <input type="radio" class="form-check-input" id="radio5" name="myDropdown1" value="5" onclick="showDetails()" required>1) Existing Owner details (विद्यमान मालक तपशील)
                        <label class="form-check-label" for="radio5"></label>
                    </div>&nbsp;&nbsp;&nbsp;&nbsp;
                    <div class="form-check ms-3">
                        <input type="radio" class="form-check-input" id="radio6" name="myDropdown1" value="6" onclick="showDetails()" required>2) Addition of Owner  Details (मालक तपशील जोडणे)
                        <div class="invalid-feedback">Please select an option.</div>
                        <label class="form-check-label" for="radio6"></label>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <script>
    
    
    function showDetails() {
        var radio5Checked = document.getElementById("radio5").checked;
        var radio6Checked = document.getElementById("radio6").checked;
        var formDiv3 = document.getElementById("myForm3");
        var formDiv4 = document.getElementById("myForm4");

	    var divElement = document.querySelector(".mb-3.nit"); // Selects element with both classes 'mb-3' and 'nit'

        if (radio5Checked) {
        	 formDiv3.style.display = "block";
        	 formDiv4.style.display = "none";
 	    } else if (radio6Checked) {
 	    	  formDiv4.style.display = "block";
 	    	 formDiv3.style.display = "none";

        } else {
       	 formDiv3.style.display = "none";
    	 formDiv4.style.display = "none";
    	 }
    }
    
    </script>
                        <div id="myForm3" style="display: none;">
    
     <label for="" class="form-label">Change in Owner Details<span class="text-danger" style="color: red;">*</span></label>

<table id="nursingTable">
    <thead>
        <tr>
            <th>Sr.No</th>
            <th>Name of Nursing Home Owner </th>
            <th>Full Address</th>
            <th>Mobile Number </th>
            <th>Email Id </th>
        </tr>
    </thead>
    <tbody>
        <!-- Initial Row -->
        <tr>
            <td>1</td>
            <td><input type="text" name="changeOwnerName"  onkeydown="return /[a-z ]/i.test(event.key)" required/><div class="invalid-feedback">Please Enter Nursing Home Owner </div></td>
            <td><input type="text" name="changeAddress" required/><div class="invalid-feedback">Please Enter Full Address</div></td>
            <td><input type="text" name="changeMobileNo"  pattern="[6-9]{1}[0-9]{9}" maxlength="10" required/><div class="invalid-feedback">Please Enter Mobile Number</div></td>
                        <td><input type="email" name="changeEmail" required/><div class="invalid-feedback">Please Enter Email Id</div></td>
            
            <td>
                  <button type="button" class="btn btn-add" onclick="addRow(this)">+</button>
                <button type="button" class="btn btn-remove" onclick="removeRow(this)">-</button>
            </td>
        </tr>
    </tbody>
</table>

</div>

                    <div id="myForm4" style="display: none;">


  <label for="" class="form-label">Addition of Owner Details<span class="text-danger" style="color: red;">*</span></label>

<table id="nursingTable1">
    <thead>
        <tr>
            <th>Sr.No</th>
            <th>Name of Nursing Home Owner </th>
            <th>Full Address</th>
            <th>Mobile Number </th>
                        <th>Email Id </th>
            
        </tr>
    </thead>
    <tbody>
        <!-- Initial Row -->
        <tr>
            <td>1</td>
            <td><input type="text" name="additionOwnerName"  onkeydown="return /[a-z ]/i.test(event.key)" required/><div class="invalid-feedback">Please Enter Nursing Home Owner </div></td>
            <td><input type="text" name="additionAddress" required/><div class="invalid-feedback">Please Enter Full Address</div></td>
            <td><input type="text" name="additionMobileNo"  pattern="[6-9]{1}[0-9]{9}" maxlength="10" required/><div class="invalid-feedback">Please Enter Mobile Number</div></td>
                                    <td><input type="email" name="email" required/><div class="invalid-feedback">Please Enter Email Id</div></td>
            
            <td>
                <button type="button" class="btn btn-add-nurse" onclick="addNurseRow(this)">+</button>
                <button type="button" class="btn btn-remove" onclick="removeNurseRow(this)">-</button>
            </td>
        </tr>
    </tbody>
</table>
</div>

</div>
<script>
    function addRow(button) {
        var table = document.getElementById("nursingTable").getElementsByTagName('tbody')[0];
        var newRow = table.rows[0].cloneNode(true);
        var rowCount = table.rows.length + 1;

        newRow.cells[0].innerHTML = rowCount;
        var inputs = newRow.getElementsByTagName('input');
        for (var i = 0; i < inputs.length; i++) {
            inputs[i].value = '';
        }
        
        table.appendChild(newRow);
    }

    function removeRow(button) {
        var row = button.parentNode.parentNode;
        var table = row.parentNode;
        if (table.rows.length > 1) {
            row.parentNode.removeChild(row);
            updateRowNumbers();
        }
    }

    function updateRowNumbers() {
        var table = document.getElementById("nursingTable").getElementsByTagName('tbody')[0];
        for (var i = 0; i < table.rows.length; i++) {
            table.rows[i].cells[0].innerHTML = i + 1;
        }
    }

    function addNurseRow(button) {
        var table = document.getElementById("nursingTable1").getElementsByTagName('tbody')[0];
        var newRow = table.rows[0].cloneNode(true);
        var rowCount = table.rows.length + 1;

        newRow.cells[0].innerHTML = rowCount;
        var inputs = newRow.getElementsByTagName('input');
        for (var i = 0; i < inputs.length; i++) {
            inputs[i].value = '';
        }
        
        table.appendChild(newRow);
    }

    function removeNurseRow(button) {
        var row = button.parentNode.parentNode;
        var table = row.parentNode;
        if (table.rows.length > 1) {
            row.parentNode.removeChild(row);
            updateNurseRowNumbers();
        }
    }

    function updateNurseRowNumbers() {
        var table = document.getElementById("nursingTable1").getElementsByTagName('tbody')[0];
        for (var i = 0; i < table.rows.length; i++) {
            table.rows[i].cells[0].innerHTML = i + 1;
        }
    }
</script>
    </div>
  <div id="myForm1" style="display: none;">
    <div class="row">

    <h6 class="mt-4"><strong>Total Modified Number of Beds (बेडची एकूण सुधारित संख्या)</strong></h6>

        <div class="col-md-3">
            <div class="mb-3 mt-4">
                <label for="" class="form-label">Maternity Patients(प्रसूती रुग्ण)<span
								class="text-danger" style="color: red;" id="zone"
								>*</span></label>
                <input type="number" class="form-control"  style="background-image: none;" placeholder="" name="changeBedMaternity" id="changeBedMaternity"
                    value="" required>
                     <div class="invalid-feedback">Please Enter valid Maternity</div>			
                    
            </div>
        </div>

        <div class="col-md-3">
            <div class="mb-3 mt-4">
                <label for="" class="form-label">Other Nursing Patients (इतर नर्सिंग रुग्ण)<span
								class="text-danger" style="color: red;" id="zone"
								>*</span></label>
                <input type="number" class="form-control"  style="background-image: none;" placeholder=""
                    name="changeBedOther" id="changeBedOther" value="" required>
                                                                                                     <div class="invalid-feedback">Please Enter valid Nusrsing Patients</div>			
                    
            </div>
        </div>

 </div>
 
 	
   
   
   </div>
   
   <div class="col-md-5">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Place where the nursing home is situated (नर्सिंग होम स्थित असलेले ठिकाण)<span class="text-danger">*</span>
						</label> <input type="text" class="form-control" id="place"
							style="background-image: none;" placeholder="" name="place"
							value=""  maxlength="75" required>
						<div class="invalid-feedback">Please Enter Valid Place where the nursing home is situated .
						</div>
					</div>
				</div>
<script>


$(document).ready(function() {
    $("#changeBedMaternity, #changeBedOther").on('input', function() {
        var a = parseInt($("#changeBedMaternity").val());
        var b = parseInt($("#changeB
        if(inputModule!=0)
            inputDiv += 1;

            var mainFees = inputDiv * fixfees;
        edOther").val());
        var c = a + b;

        
        var fixfees = 5000;
        var inputText = c;
        var inputDiv = Math.floor(parseInt(inputText) / 5); 
        var inputModule = parseFloat(inputText) % 5; 

        console.log("Input as integer: ", inputDiv);
        console.log("Main fees: ", mainFees);
    

        $("#fees").val(mainFees);
        
    });
});

</script>
    
    <div class="row align-items-end">


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
            
            
               <p>

                            <b>For Medico Person</b>

                        </p>
                              <div class="row">
                                    <div class="col-md-4">
                                        <div class="mb-3 mt-4">
                                            <label for="" class="form-label">Degree Certificate (पदवी प्रमाणपत्र)<span
								class="text-danger" style="color: red;" id="zone"
								>*</span></label>
                                            <input type="file" class="form-control" style="background-image: none;" id="doc1" placeholder="" name="degree_Certificate"
                                                value="" required>
                                                <div class="invalid-feedback">File selected is either
										greater than 2Mb or not of type .pdf.</div>

								
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="mb-3">
                                            <label for="" class="form-label">Additional Qualification Certificate (अतिरिक्त पात्रता प्रमाणपत्र)<span
								class="text-danger" style="color: red;" id="zone"
								>*</span></label>
                                            <input type="file" class="form-control" style="background-image: none;" id="doc2" placeholder="" name="add_qualification_certi"
                                                value="" required>
                                                <div class="invalid-feedback">File selected is either
										greater than 2Mb or not of type .pdf.</div>

							
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="mb-3 mt-4">
                                            <label for="" class="form-label">M.M.C Certificate (M.M.C प्रमाणपत्र)<span
								class="text-danger" style="color: red;" id="zone"
								>*</span></label>
                                            <input type="file" class="form-control" style="background-image: none;" id="doc3" placeholder="" name="mmc_certificate"
                                                value="" required>
                                                <div class="invalid-feedback">File selected is either
										greater than 2Mb or not of type .pdf.</div>

								</div>
                                        
				</div>
                                  
                                </div>
                                
                                    <p>

                            <b>For Non-Medico Person</b>

                        </p>
                              <div class="row">
                                    <div class="col-md-4">
                                        <div class="mb-3 ">
                                            <label for="" class="form-label">Aadhaar Card (आधार कार्ड)<span
								class="text-danger" style="color: red;" id="zone"
								>*</span></label>
                                            <input type="file" class="form-control" style="background-image: none;" id="doc4" placeholder="" name="adhar_card"
                                                value="" required>
                                                <div class="invalid-feedback">File selected is either
										greater than 2Mb or not of type .pdf.</div>

								</div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="mb-3 ">
                                            <label for="" class="form-label">PAN Card (पॅन कार्ड)<span
								class="text-danger" style="color: red;" id="zone"
								>*</span></label>
                                            <input type="file" class="form-control" style="background-image: none;" id="doc5" placeholder="" name="pan_Card"
                                                value="" required>
                                                <div class="invalid-feedback">File selected is either
										greater than 2Mb or not of type .pdf.</div>

                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="mb-3 ">
                                            <label for="" class="form-label">Appointment Letter (नियुक्ती पत्र)<span
								class="text-danger" style="color: red;" id="zone"
								>*</span></label>
                                            <input type="file" class="form-control" style="background-image: none;" id="doc6" placeholder="" name="appoinment_letter"
                                                value="" required>
                                                <div class="invalid-feedback">File selected is either
										greater than 2Mb or not of type .pdf.</div>

								</div>
                                        </div>
                                

  <div class="col-md-4">
                                        <div class="mb-3 mt-3">
                                            <label for="" class="form-label">Affidavit (प्रतिज्ञापत्र)<span
								class="text-danger" style="color: red;" id="zone"
								>*</span>
								 <a class="fa fa-download"
							onClick="downloadFiles()" style="color: blue;"> </a>
								</label>
                                            <input type="file" class="form-control" style="background-image: none;" id="doc7" placeholder="" name="appoinment_letter"
                                                value="" required>
                                                <div class="invalid-feedback">File selected is either
										greater than 2Mb or not of type .pdf.</div>

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

</body>
<script type="text/javascript">
$('.printMe').on('click', function () {

    window.print();
});
</script>

<script>

function downloadFiles() {
	  var file1Url = "<c:out value="${contextRoot}"/>/pages/citizendocument/Nursing_Home_Affidavit_format.pdf";
	  var file2Url = "<c:out value="${contextRoot}"/>/pages/citizendocument/Hospital_Registration_Declaration_Format.pdf";
	  
	  var file1Name = "Nursing_Home_Affidavit_format.pdf";
	  var file2Name = "Hospital_Registration_Declaration_Format.pdf";
	  
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
$(document).ready(function () {
	 var isUploadInProgress = false;
   $("#submit").click(function (event) {
	   checkCategoryRequired();
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
              	    	 checkCategory();
              	        $("#submit").attr("disabled", true);
                           onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/saveNursingHomeChangesApplication.do');
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
               filesPath = filesPath + basePath + "changeInBeds/" + id + value + ","
               isFileSelected = true;
           }
       }
       $.ajax({
           url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadChangesInBeds.do?id="+id,
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
function checkCategory() {
    if ($('#radio5').is(':checked')) {
    	 $('#radio6').prop('checked', false);
        $('#nursingTable1 tbody').empty();
        $('input[name="additionOwnerName"]').removeAttr('required');
        $('input[name="additionAddress"]').removeAttr('required');
        $('input[name="additionMobileNo"]').removeAttr('required');
        $('input[name="email"]').removeAttr('required');
    } else {
    	 $('#radio5').prop('checked', false);
        $('#nursingTable tbody').empty();
        $('input[name="changeOwnerName"]').removeAttr('required');
        $('input[name="changeAddress"]').removeAttr('required');
        $('input[name="changeMobileNo"]').removeAttr('required');
        $('input[name="changeEmail"]').removeAttr('required');
    }

    if ($('#radio4').is(':checked')) {
    	 $('#radio3').prop('checked', false);
         $('#radio5').prop('checked', false);
         $('#radio6').prop('checked', false);
        $('#nursingTable tbody').empty();
        $('#nursingTable1 tbody').empty();
        //$('#radio3').prop('checked', false);
        $('#radio3').prop('checked', false);
        $('#radio3').removeAttr('required');
        $('#radio5').removeAttr('required');
        $('#radio6').removeAttr('required');
        $('#name').attr('required', true);
        $('#address').attr('required', true);
        $('#emailId').attr('required', true);
        $('#mobileNo').attr('required', true);
        
    } else {
        $('#changeBedMaternity').val('');
        $('#changeBedOther').val('');
        $('#changeBedMaternity').removeAttr('required');
        $('#changeBedOther').removeAttr('required');
        $('#radio4').prop('checked', false);
        $('#radio3').prop('checked', true);
        
       
        
        //new fileds
        $('#name').val('');
        $('#address').val('');
        $('#emailId').val('');
        $('#mobileNo').val('');
        $('#name').removeAttr('required');
        $('#address').removeAttr('required');
        $('#emailId').removeAttr('required');
        $('#mobileNo').removeAttr('required');
    }


}
function checkCategoryRequired() {
    if ($('#radio3').is(':checked')) {
        $('#radio4').prop('checked', false);
        $('#radio5').attr('required', true);
        $('#radio6').attr('required', true);

        if ($('#radio5').is(':checked')) {
            // Conditions for radio5
            $('input[name="changeOwnerName"]').attr('required', true);
            $('input[name="changeAddress"]').attr('required', true);
            $('input[name="changeMobileNo"]').attr('required', true);
            $('input[name="changeEmail"]').attr('required', true);
            $('input[name="additionOwnerName"]').attr('required', false);
            $('input[name="additionAddress"]').attr('required', false);
            $('input[name="additionMobileNo"]').attr('required', false);
            $('input[name="email"]').attr('required', false);
            $('#name').removeAttr('required');
            $('#address').removeAttr('required');
            $('#emailId').removeAttr('required');
            $('#mobileNo').removeAttr('required');
            $('#changeBedMaternity').removeAttr('required');
            $('#changeBedOther').removeAttr('required');
        } else if ($('#radio6').is(':checked')) {
            // Conditions for radio6
            $('input[name="additionOwnerName"]').attr('required', true);
            $('input[name="additionAddress"]').attr('required', true);
            $('input[name="additionMobileNo"]').attr('required', true);
            $('input[name="email"]').attr('required', true);
            $('input[name="changeOwnerName"]').attr('required', false);
            $('input[name="changeAddress"]').attr('required', false);
            $('input[name="changeMobileNo"]').attr('required', false);
            $('input[name="changeEmail"]').attr('required', false);
            $('#name').removeAttr('required');
            $('#address').removeAttr('required');
            $('#emailId').removeAttr('required');
            $('#mobileNo').removeAttr('required');
            $('#changeBedMaternity').removeAttr('required');
            $('#changeBedOther').removeAttr('required');
        
        }

    } else if ($('#radio4').is(':checked')) {
        $('#radio3').prop('checked', false);
        $('#radio5').prop('checked', false);
        $('#radio6').prop('checked', false);
        $('#radio3').attr('required', false);
        $('#radio5').attr('required', false);
        $('#radio6').attr('required', false);
        $('input[name="email"]').attr('required', true);
        $('#name').attr('required', true);
        $('#address').attr('required', true);
        $('#emailId').attr('required', true);
        $('#mobileNo').attr('required', true);
        
        $('input[name="changeOwnerName"]').attr('required', false);
        $('input[name="changeAddress"]').attr('required', false);
        $('input[name="changeMobileNo"]').attr('required', false);
        $('input[name="changeEmail"]').attr('required', false);

        $('input[name="additionOwnerName"]').attr('required', false);
        $('input[name="additionAddress"]').attr('required', false);
        $('input[name="additionMobileNo"]').attr('required', false);
        $('input[name="email"]').attr('required', false);
    } else {
        $('#radio3').attr('required', true);
        $('#radio4').attr('required', true);
        $('#radio5').attr('required', true);
        $('#radio6').attr('required', true);

        //new fileds
        $('#name').val('');
        $('#address').val('');
        $('#emailId').val('');
        $('#mobileNo').val('');
        $('#name').removeAttr('required');
        $('#address').removeAttr('required');
        $('#emailId').removeAttr('required');
        $('#mobileNo').removeAttr('required');
        
        $('input[name="changeOwnerName"]').attr('required', true);
        $('input[name="changeAddress"]').attr('required', true);
        $('input[name="changeMobileNo"]').attr('required', true);
        $('input[name="changeEmail"]').attr('required', true);

        $('input[name="additionOwnerName"]').attr('required', true);
        $('input[name="additionAddress"]').attr('required', true);
        $('input[name="additionMobileNo"]').attr('required', true);
        $('input[name="email"]').attr('required', true);
        
    }
}



</script>


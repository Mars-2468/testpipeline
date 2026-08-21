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

						<input type="hidden" name="filesPath" id="filesPath" />

	<form class="needs-validation" novalidate>
		<div class="container-fluid mt-2" style="width: 1320px;">
			<div class="printable">
				<h3 class="text-center">Application for Renewal for Nursing Home Registration
					(नर्सिंग होम नोंदणीसाठी नूतनीकरणासाठी अर्ज)</h3>
			</div>
			<br>
 <div class="row">
                    
                       <div class="col-md-3">
    <div class="mb-3 mt-0">
    <label for="colony_name" class="form-label">
        Existing Nursing Home Registration No. (विद्यमान नर्सिंग होम अर्ज क्र.)
        <span class="mand_error" style="color: red;">*</span>
    </label>
    <input type="text" class="form-control" id="rnh_id" style="background-image: none;" placeholder="" maxlength="255" onchange="getDetails(this.value)" name="renewalNursingHome"  value="" pattern="^\s*\S.*$" required>
    <div class="invalid-feedback">Please Enter Valid Existing Nursing Home Registration No..</div>
    <br>
    
</div>

</div>

  <script>
    function getDetails(value) {
    	//onchange="getDetails(this.value)"

        var rnh_id = $("#rnh_id").val();

        var a = $(".appeal");
        console.log("Number of elements with class 'appeal':", a.length);

        a.each(function () {
            console.log("Removing required attribute from element:", this);
            $(this).prop("required", false);
        });

        // Send a POST request to the server
        $.ajax({
            type: "POST",
            url: "<c:out value='${contextRoot}'/>/rtsapplication/getnursingApplicationDetails.do?renewalNursingHome="+rnh_id, 
            dataType: "json",
            success: function (data) {
            	 var status = data.status;
            	 var renewal = data.renewal;
            	 var renewal_status = data.renewal_status;
                 if (status==true || status == 'true') {
                  
            	var nhdto = JSON.parse(data.nhdto);
            	var nddto = JSON.parse(data.nddto);
            	var sddto = JSON.parse(data.sddto);
                // Populate input fields with the received data
                $("#rnh_id").prop("readonly", true);
                $("#registrationDate").val(nhdto.registrationDate).trigger("change").focus();
                $("#phone").val(nhdto.phone);
                $("#email").val(nhdto.email);
                $("#name").val(nhdto.name);
                $("#applicantAddress").val(nhdto.applicantAddress);
                $("#techQul").val(nhdto.techQul);
                $("#nationality").val(nhdto.nationality);
                $("#situationOf").val(nhdto.situationOf);
                $("#nameRegNursingHome").val(nhdto.nameRegNursingHome);
                $("#placeOfNStaff").val(nhdto.placeOfNStaff);
                $("#autoCad").val(nhdto.autoCad);
                $("#connectionOfPremises").val(nhdto.connectionOfPremises);
                $("#maternityPatients").val(nhdto.maternityPatients);
                $("#nobedopatient").val(nhdto.noBedOPatient);
                $("#nursingStaffAccommodated").val(nhdto.nursingStaffAccommodated);
                $("#qualifiednurse").val(nhdto.qualifiedNurse).trigger("change");
                $("#qulnursemidwife").val(nhdto.qulnurseMidwife).trigger("change");
                $("#unregistered_medical_practitionar").val(nhdto.unregisteredMedicalPractitionar).trigger("change");
                $("#aliennationality").val(nhdto.alienNationality).trigger("change");
                $('#unregMedUnquilNursingStaff').val(nhdto.unregMedUnquilNursingStaff);
                $("#applicantintereste").val(nhdto.applicantInterestE).trigger("change");
                $("#zoneNo").val(nhdto.zoneNo);
               
                appendingNurseDetials(nddto);
                appendingDoctorDetials(sddto);
                 }else if(status==false || status =='false'){
                	
                	 $("#rnh_id").prop("readonly", false);
                	 $("#rnh_id").val('');
                	 alert("Record not found. Please enter a valid application number!!");
             
                	

                 } /* else if(renewal==false){
                	 
                	 $("#rnh_id").prop("readonly", false);
                	 $("#rnh_id").val('');
                	 alert("Nursinng home renewal is not applicable at this time. Please renew after the completion of license period.");
                	 

                 }else if(renewal_status==false){
                	 $("#rnh_id").prop("readonly", false);
                	 $("#rnh_id").val('');
                	 alert("A renewal has already been applied for. A second renewal cannot be submitted at this time.");
                 }  */
            },
            error: function (xhr) {
            	
            	$("#rnh_id").prop("readonly", false);
            	$("#rnh_id").val('');
                alert("Something Went Wrong!!");
            }
        });
    }
    
    function appendingNurseDetials(dd){
    	var data;
    	if(dd.length>0){
    		data = dd.length;
    	}else{
    		data=dd.length+1;
    	}
    	for (var i = 0; i < dd.length; i++) {
    	    var data = dd[i]; 
    	    
    	    if (i === 0) {
    	        $("#nurseName").val(data.nurseName);
    	        $("#nurseAge").val(data.nurseAge);
    	        $("#nurseEducation").val(data.nurseEducation);
    	        $("#nurseRegNo").val(data.nurseRegNo);
    	       
    	    } else {
    	        var j = i + 1;
    	        addNurseRow();
    	        $("#nurseName" + j).val(data.nurseName);
    	        $("#nurseAge" + j).val(data.nurseAge);
    	        $("#nurseEducation" + j).val(data.nurseEducation);
    	        $("#nurseRegNo" + j).val(data.nurseRegNo);
    	        
    	    }
    	}

    }
    
    function appendingDoctorDetials(dd){
    	var data;
    	if(dd.length>0){
    		data = dd.length;
    	}else{
    		data=dd.length+1;
    	}
    	for (var i = 0; i < dd.length; i++) {
    	    var data = dd[i]; 
    	    
    	    if (i === 0) {
    	        $("#doctorName").val(data.doctorName);
    	        $("#doctorAge").val(data.doctorAge);
    	        $("#doctorEducation").val(data.doctorEducation);
    	        $("#doctorRegNo").val(data.doctorRegNo);
    	      
    	    } else {
    	        var j = i+1;
    	        addRow();
    	        $("#doctorName" + j).val(data.doctorName);
    	        $("#doctorAge" + j).val(data.doctorAge);
    	        $("#doctorEducation" + j).val(data.doctorEducation);
    	        $("#doctorRegNo" + j).val(data.doctorRegNo);
    	       
    	    }
    	}

    }
</script>
   
<div class="row">
    
    <div class="col-md-3">

<div class="mb-1" >

    <label for="" class="form-label"> Date (दिनांक)<span class="text-danger" style="color: red;">*</span></label>

    <input type="date" class="form-control" style="background-image: none;" id="registrationDate"  placeholder="" name="registrationDate" value="" required>
<div class="invalid-feedback">Please Select Valid date.</div>
</div>

</div>

</div>

<div class="row">
    

    <div class="col-md-3">

<div class="mb-3 mt-3">

    <label for="" class="form-label">Mobile No (मोबाईल क्र)<span class="text-danger" style="color: red;">*</span></label>

    <input type="text" class="form-control" style="background-image: none;" id="phone" placeholder="" name="phone" value=""

    onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))"

    maxlength="10" required>
<div class="invalid-feedback">Please Enter Valid MobileNo.</div>
</div>

</div>

</div>

<div class="row">
    
    <div class="mb-3 ">

    <label for="" class="form-label lbleng">Email (ईमेल)<span class="text-danger" style="color: red;">*</span></label>

    <input type="email" class="form-control" style="background-image: none;" id="email" placeholder="" name="email" value="" required>
<div class="invalid-feedback">Please Enter Valid Email.</div>
</div>

</div>
    

    <h6 style="background-color:#dce2e8; padding:10px;" class="  rounded-2"><strong> "Form B" (See rule 4 and 6) Application for Nursing Home Registration under section 5 of the Bombay Nursing homes Registration Act,1949 </strong></h6>

<div class="row">
    <div class="mb-3 ">

    <label for="" class="form-label">1.Full Name of applicant (अर्जदाराचे पूर्ण नाव)<span class="text-danger" style="color: red;">*</span></label>

    <input type="text" class="form-control" style="background-image: none;" id="name" onkeydown="return /[a-z ]/i.test(event.key)" placeholder="" name="name" value="" required>
                <div class="invalid-feedback">Please Enter Valid Full Name.</div>
</div>


</div>

<div class="row">
    
    
    <div class="col-md-12">

<div class="mb-3 mt-0">

    <label for="" class="form-label">2.Full residential address of the applicant(अर्जदाराचा संपूर्ण निवासी पत्ता)<span class="text-danger" style="color: red;">*</span></label>

    <textarea class="form-control" style="background-image: none;" id="applicantAddress" placeholder="" name="applicantAddress" rows="3" required></textarea>
<div class="invalid-feedback">Please Enter Valid Address.</div>
</div>

</div>
     
    </div>


    <div class="row">
        <div class="mb-3 ">

<label for="" class="form-label">3.Technical Qualification if any of the applicant(अर्जदाराची तांत्रिक पात्रता असल्यास)<span class="text-danger" style="color: red;">*</span>   </label>

<input type="text" class="form-control" style="background-image: none;" id="techQul" placeholder="" name="techQul" value="" required>
<div class="invalid-feedback">Please Enter Valid Technical Qualification if any, of the applicant.</div>
</div>
</div>


<div class="row">
   
   <div class="mb-3 ">

   <label for="" class="form-label">4.Nationality of the applicant (अर्जदाराचे राष्ट्रीयत्व)<span class="text-danger" style="color: red;">*</span></label>

   <select class="form-select" style="background-image: none;" name="nationality" id="nationality" required>

       <option value="">-Select-</option>

                                   <option value="Indian (भारतीय)" >Indian (भारतीय)</option>
                                   <option value="NRI (अनिवासी भारतीय)" >NRI (अनिवासी भारतीय)</option>

       
   </select>
<div class="invalid-feedback">Please Select Nationality of the applicant.</div>
</div>
</div>


<div class="row">
    

    <div class="mb-3 ">

    <label for="" class="form-label">5. Situation of the registered or principal office of the company, Society, Association or other body corporate(कंपनी, सोसायटी, असोसिएशन किंवा इतर बॉडी कॉर्पोरेटच्या मुख्य कार्यालयाची नोंदणीकृत स्थिती) <span class="text-danger" style="color: red;">*</span> </label>

    <textarea class="form-control" style="background-image: none;" rows="3" name="situationOf" id="situationOf" required></textarea>
<div class="invalid-feedback">Please Enter Valid Principal office of the company,Society,Association.</div>
</div>


</div>


<div class="row">
    <div class="mb-3 ">

    <label for="" class="form-label">6. Name and Other particulars of the nursing home in respect of which the registration is applied for. (नर्सिंग होमचे नाव आणि इतर तपशील ज्यासाठी नोंदणीसाठी अर्ज केला आहे.) 

           <span class="text-danger" style="color: red;">*</span></label>

    <input type="text" class="form-control" style="background-image: none;" id="nameRegNursingHome" onkeydown="return /[a-z ]/i.test(event.key)" placeholder="" name="nameRegNursingHome" value="" required>
                <div class="invalid-feedback">Please Enter Valid   Name and Other particulars of the Nursing Home in Registration is Applied For Omega Hospitals run by Shembekar Hospital Pvt Ltd
</div>
</div>


</div>





<div class="row">
    <div class="mb-3 ">



    <label for="" class="form-label">7. Place where the nursing  home is situated (नर्सिंग होम जेथे आहे ते ठिकाण)<span class="text-danger" style="color: red;">*</span></label>

    <input type="text" class="form-control" style="background-image: none;" id="placeOfNStaff" placeholder="" name="placeOfNStaff" value="" required>
<div class="invalid-feedback">Please Enter Valid Accommodation location for nursing staff.</div>
</div>


</div>



<!-- <div class="row">
    <div class="mb-3 ">

    <label for="" class="form-label"> 8. Autocad Map Available (ऑटोकॅड नकाशा उपलब्ध)<span class="text-danger" style="color: red;">*</span></label>

    <input type="text" class="form-control" style="background-image: none;" id="autoCad" onkeydown="return /[a-z ]/i.test(event.key)" placeholder="" name="autoCad" value="" required>
                <div class="invalid-feedback">Please Enter Valid Autocad Map Available</div>
</div>


</div> -->




<div class="row">
    <div class="mb-3 ">

    <label for="" class="form-label"> 8. Weather Nursing Home or any Premises Used in Connection there with are used or are to be used for purposes Other then that of carrying an nursing home (नर्सिंग होम किंवा त्यांच्या संबंधात वापरलेली कोणतीही जागा नर्सिंग होमसाठी वापरली जात आहे किंवा वापरली जाणार आहे.)<span class="text-danger" style="color: red;">*</span></label>

    <input type="text" class="form-control" style="background-image: none;" id="connectionOfPremises" onkeydown="return /[a-z ]/i.test(event.key)" placeholder="" name="connectionOfPremises" value="" required>
                <div class="invalid-feedback">Please Enter Valid  Weather Nursing Home or any Premises Used in Connection there with are used for Purpose Other then that of Carrying an Nursing Home</div>
</div>

</div>




<div class="row">
    <div class="mb-3 ">


    <label for="" class="form-label"> 9 (a).No of beds for Maternity Patients (प्रसूती रुग्णांसाठी बेडची संख्या)<span class="text-danger" style="color: red;">*</span> </label>

    <input type="number" class="form-control" style="background-image: none;" id="maternityPatients" placeholder=" " name="maternityPatients" value="" required>
<div class="invalid-feedback">Please Enter Valid maternity patients.</div>

</div>



</div>


<div class="row">
  
    <div class="mb-3 ">

    <label for="" class="form-label">(b). Number of beds for other patients (इतर रुग्णांसाठी बेडची संख्या)<span class="text-danger" style="color: red;">*</span></label>

    <input type="number" class="form-control" style="background-image: none;"  placeholder="" name="noBedOPatient" id="nobedopatient" value="" onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))" required>
<div class="invalid-feedback">Please Enter Valid No Of Beds for other patients</div>
</div>


</div>










<body>

<label for="" class="form-label">10.Names,Ages and Qualification of the Resident or Visiting physicians or Surgeons in the Nursing Home (न्युरिसिंग होममधील निवासी किंवा भेट देणारे डॉक्टर किंवा सर्जन यांची नावे, वय आणि पात्रता)<span class="text-danger" style="color: red;">*</span></label>

<table id="doctorTable">
    <thead>
        <tr>
            <th>S.No</th>
            <th>Visiting Doctor Name</th>
            <th>Age</th>
            <th>Education</th>
            <th>Medical Reg No. & Validity of Certificate </th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <!-- Initial Row -->
        <tr>
            <td>1</td>
            <td><input type="text" name="doctorName" id="doctorName" onkeydown="return /[a-z ]/i.test(event.key)" required/><div class="invalid-feedback">Please Enter Doctor Name</div></td>
            <td><input type="number" name="doctorAge" id="doctorAge" required/><div class="invalid-feedback">Please Enter Age</div></td>
            <td><input type="text" name="doctorEducation" id="doctorEducation" onkeydown="return /[a-z ]/i.test(event.key)" required/><div class="invalid-feedback">Please Enter Education</div></td>
            <td><input type="text" name="doctorRegNo" id="doctorRegNo" required/><div class="invalid-feedback">Please Enter Medical Reg No</div></td>
            <td>
                <button type="button" class="btn btn-add" onclick="addRow(this)">+</button>
                <button type="button" class="btn btn-remove" onclick="removeRow(this)">-</button>
            </td>
        </tr>
    </tbody>
</table>

<label for="" class="form-label">11.Names,Ages and Qualification of the Members of the Nursing Staff in the Nursing Home(नर्सिंग होममधील नर्सिंग स्टाफच्या सदस्यांची नावे, वय आणि पात्रता)<span class="text-danger" style="color: red;">*</span></label>

<table id="nursingTable">
    <thead>
        <tr>
            <th>Sr.No</th>
            <th>Name of Working Nurse</th>
            <th>Age</th>
            <th>ANM/GNM</th>
            <th>Nursing Council Reg No</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <!-- Initial Row -->
        <tr>
            <td>1</td>
    <td><input type="text" name="nurseName" id="nurseName" onkeydown="return /[a-z ]/i.test(event.key)" required/><div class="invalid-feedback">Please Enter Nurse Name</div></td>
            <td><input type="number" name="nurseAge" id="nurseAge"  required/><div class="invalid-feedback">Please Enter Age</div></td>
            <td><input type="text" name="nurseEducation" id="nurseEducation" onkeydown="return /[a-z ]/i.test(event.key)" required/><div class="invalid-feedback">Please Enter Education</div></td>
            <td><input type="text" name="nurseRegNo" id="nurseRegNo" required/><div class="invalid-feedback">Nursing Council Reg No</div></td>
            <td>
                <button type="button" class="btn btn-add-nurse" onclick="addNurseRow(this)">+</button>
                <button type="button" class="btn btn-remove" onclick="removeNurseRow(this)">-</button>
            </td>
        </tr>
    </tbody>
</table>

<script>
function initializeRowIds() {
    var table = document.getElementById("doctorTable").getElementsByTagName('tbody')[0];
    var firstRowInputs = table.rows[0].getElementsByTagName('input');
    for (var i = 0; i < firstRowInputs.length; i++) {
        firstRowInputs[i].id = firstRowInputs[i].id.replace(/\d+$/, '') + 0; // Initialize first row with id ending in 0
    }

    var nurseTable = document.getElementById("nursingTable").getElementsByTagName('tbody')[0];
    var firstNurseRowInputs = nurseTable.rows[0].getElementsByTagName('input');
    for (var i = 0; i < firstNurseRowInputs.length; i++) {
        firstNurseRowInputs[i].id = firstNurseRowInputs[i].id.replace(/\d+$/, '') + 0; // Initialize first row with id ending in 0
    }
}

function addRow(button) {
    var table = document.getElementById("doctorTable").getElementsByTagName('tbody')[0];
    var newRow = table.rows[0].cloneNode(true);
    var rowCount = table.rows.length + 1;

    newRow.cells[0].innerHTML = rowCount;
    var inputs = newRow.getElementsByTagName('input');
    for (var i = 0; i < inputs.length; i++) {
        inputs[i].value = '';
        inputs[i].id = inputs[i].id.replace(/\d+$/, '') + rowCount; // Update id with rowCount starting from 1 for the first added row
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
    var table = document.getElementById("doctorTable").getElementsByTagName('tbody')[0];
    for (var i = 0; i < table.rows.length; i++) {
        table.rows[i].cells[0].innerHTML = i + 1;
        var inputs = table.rows[i].getElementsByTagName('input');
        for (var j = 0; j < inputs.length; j++) {
            inputs[j].id = inputs[j].id.replace(/\d+$/, '') + i; // Update id with the correct row number starting from 0
        }
    }
}

function addNurseRow(button) {
    var table = document.getElementById("nursingTable").getElementsByTagName('tbody')[0];
    var newRow = table.rows[0].cloneNode(true);
    var rowCount = table.rows.length +1;

    newRow.cells[0].innerHTML = rowCount;
    var inputs = newRow.getElementsByTagName('input');
    for (var i = 0; i < inputs.length; i++) {
        inputs[i].value = '';
        inputs[i].id = inputs[i].id.replace(/\d+$/, '') + rowCount; // Update id with rowCount starting from 1 for the first added row
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
    var table = document.getElementById("nursingTable").getElementsByTagName('tbody')[0];
    for (var i = 0; i < table.rows.length; i++) {
        table.rows[i].cells[0].innerHTML = i + 1;
        var inputs = table.rows[i].getElementsByTagName('input');
        for (var j = 0; j < inputs.length; j++) {
            inputs[j].id = inputs[j].id.replace(/\d+$/, '') + i; // Update id with the correct row number starting from 0
        }
    }
}

</script>




<div class="row">
    <div class="mb-3 ">

    <label for="" class="form-label">12.Place Where Nursing Staff is Accommodate (नर्सिंग स्टाफ ला राहण्याची जागा)<span class="text-danger" style="color: red;">*</span></label>

    <input type="text" class="form-control" style="background-image: none;" id="nursingStaffAccommodated" onkeydown="return /[a-z ]/i.test(event.key)" placeholder="" name="nursingStaffAccommodated" value="" required>
                <div class="invalid-feedback">Please Enter Valid  Place Where Nursing Staff is Accommodate.</div>
</div>


</div>



<div class="row">
   
    <div class="mb-3 ">
                    <label for="" class="form-label lbleng">13 (a).Whether the nursing
                        homes is under the supervision of qualified medical practitioner or a qualified nurse ,and if  qualifications (नर्सिंग होम
                        घरे पात्र वैद्यकीय व्यवसायी किंवा पात्र परिचारिका यांच्या देखरेखीखाली आहेत आणि पात्रता असल्यास) <span
                            class="text-danger" style="color: red;">*</span></label>
                    <!--<label for="" class="form-label lblmrt"> झाडाचा प्रकार </label>-->
                    <select class="form-select" style="background-image: none;" name="qualifiedNurse" id="qualifiednurse" required>
                        <option value="">-Select-</option>
                        <option value="Yes">Yes</option>
                        <option value="No">No</option>
                    </select>
                     <div class="invalid-feedback">Please Select Qualifications for supervision.</div>
                </div>
         
</div>
  <div class="col-md-3" id="upload_staff" style="display:none;">
                <div class="mb-3">
                    <label for="" class="form-label">Upload (अपलोड करा)<span class="text-danger" style="color: red;">*</span></label>
                    <input type="file" class="form-control" style="background-image: none;" placeholder="" name="qualifiedNuerseDoc" id="qualifiedNuerseDoc" value="" required>
                    <div class="invalid-feedback">File selected is either
										greater than 2Mb or not of type .pdf.</div>
                </div>
            

</div>


<div class="row">
   
    <div class="mb-3 ">

    <label for="" class="form-label">(b).Proportion of the qualified <br> and unqualified  nurses  on the nursing staff (नर्सिंग कर्मचाऱ्यांवर पात्र आणि अपात्र परिचारिकांचे प्रमाण) <span class="text-danger" style="color: red;">*</span></label>

    <input type="text" class="form-control" style="background-image: none;" id="unregMedUnquilNursingStaff" placeholder="" name="unregMedUnquilNursingStaff" value="" required>
<div class="invalid-feedback">Please Enter Valid Proportion of the qualified and unqualified nurses.</div> 

</div>


</div>

<div class="row">

    <div class="mb-3 ">
                    <label for="" class="form-label">14(a).Whether the nursing home is under the supervision of a qualified nurse midwife and if so, her name age and qualifications (नर्सिंग होम एखाद्या पात्र परिचारिका दाईच्या देखरेखीखाली आहे की नाही आणि तसे असल्यास, तिचे नाव वय आणि पात्रता)<span class="text-danger" style="color: red;">*</span></label>
                      <select class="form-control" style="background-image: none;" id="qulnursemidwife" placeholder="" name="qulnurseMidwife" value="" required>
                        <option value="">-Select-</option>
                        <option value="Yes">Yes</option>
                        <option value="No">No</option>
                    </select>
                     <div class="invalid-feedback">Please Select Whether the nursing home is under the supervision.</div> 
                    
                </div>
            </div>

         
            
            <div class="col-md-3" id="upload_nurse_supervision_file" style="display:none;">
                <div class="mb-3">
                    <label for="" class="form-label">Upload (अपलोड करा)<span class="text-danger" style="color: red;">*</span></label>
                    <input type="file" class="form-control" style="background-image: none;" placeholder="" name="qulnursemidwifedoc" id="qulnursemidwifedocs" value="" required>
                    <div class="invalid-feedback">File selected is either
										greater than 2Mb or not of type .pdf.</div>
                </div>
           
</div>


<div class="row">
    <div class="mb-3 ">
                    <label for="" class="form-label">(b).Whether any unregistered medical practitioner or<br> unqualified midwife is employed for nursing of  patients <br> in the nursing home (नर्सिंग होममध्ये <br> रुग्णांच्या शुश्रुषेसाठी नोंदणीकृत नसलेले वैद्यकीय व्यवसायी किंवा अपात्र दाईची नियुक्ती केली आहे का.) <span class="text-danger" style="color: red;">*</span></label>
                      <select class="form-control" style="background-image: none;" id="unregistered_medical_practitionar" placeholder="" name="unregisteredMedicalPractitionar" value="" required>
                        <option value="">-Select-</option>
                        <option value="Yes">Yes</option>
                        <option value="No">No</option>
                    </select>
                                         <div class="invalid-feedback">Please Select Unregistered medical practitioner .</div> 
                    
                </div>
            </div>

        
            
            <div class="col-md-3" id="upload_unregistered_medical_practitionar_file" style="display:none;">
                <div class="mb-3">
                    <label for="" class="form-label">Upload (अपलोड करा)<span class="text-danger" style="color: red;">*</span></label>
                    <input type="file" class="form-control" style="background-image: none;" placeholder="" name="unregmedunquilnursingDoc" id="unregmedunquilnursingDoc" value="" required>
                    <div class="invalid-feedback">File selected is either
										greater than 2Mb or not of type .pdf.</div>
                </div>
          

</div>


<div class="row">
    <div class="mb-3 ">

    <label for="" class="form-label">15.Whether any person of alien

        nationality is <br> employed in the

        nursing home and if so, his<br>

        name and other particulars (परदेशी राष्ट्रीयत्वाची कोणतीही व्यक्ती नोकरीत आहे की नाही
        नर्सिंग होम आणि असल्यास, त्याचे नाव आणि इतर तपशील) <span class="text-danger" style="color: red;">*</span></label>
        <select class="form-control" style="background-image: none;" id="aliennationality" placeholder="" name="alienNationality" value="" required>
                        <option value="">-Select-</option>
                        <option value="Yes">Yes</option>
                        <option value="No">No</option>
                    </select>
<div class="invalid-feedback">Please Enter Valid Whether any person of alien nationality is employed.</div> 
</div>

</div>

<div class="col-md-3" id="upload_aliennationalitydoc" style="display:none;">
                <div class="mb-3">
                    <label for="" class="form-label">Upload (अपलोड करा)<span class="text-danger" style="color: red;">*</span></label>
                    <input type="file" class="form-control" style="background-image: none;" placeholder="" name="aliennationalitydoc" id="aliennationalitydoc" value="" required>
                    <div class="invalid-feedback">File selected is either
										greater than 2Mb or not of type .pdf.</div>
                </div>
          

</div>

<div class="row">
    <div class="mb-3 ">

    <label for="" class="form-label">16.Whether the applicant is

        interested in any other nursing

        home or business and, if so the

        place where such nursing home

        is situated or where such

        business is conducted (
इतर कोणत्याही नर्सिंगमध्ये स्वारस्य आहे
घर किंवा व्यवसाय आणि, असल्यास
जेथे असे नर्सिंग होम आहे किंवा जेथे असा व्यवसाय केला जातो) <span class="text-danger" style="color: red;">*</span></label>
<select class="form-control" style="background-image: none;" id="applicantintereste" placeholder="" name="applicantInterestE" value="" required>
                        <option value="">-Select-</option>
                        <option value="Yes">Yes</option>
                        <option value="No">No</option>
                    </select>

<div class="invalid-feedback">Please Enter Valid The intersted in other.</div> 

</div>

</div>

<div class="col-md-3" id="upload_applicantinterestedoc" style="display:none;">
                <div class="mb-3">
                    <label for="" class="form-label">Upload (अपलोड करा)<span class="text-danger" style="color: red;">*</span></label>
                    <input type="file" class="form-control" style="background-image: none;" placeholder="" name="applicantinterestedoc" id="applicantinterestedoc" value="" required>
                    <div class="invalid-feedback">File selected is either
										greater than 2Mb or not of type .pdf.</div>
                </div>
          

</div>


<div class="row"> 



    <div class="mb-3 ">
							<label for="" class="form-label ">17.Zone No(झोन क्र.)<span
								class="text-danger" style="color: red;" id="zone"
								onclick="Zoneno(this.form)">*</span>
							</label> <select class="form-select " style="background-image: none;"
								id="zoneNo" name="zoneNo" onchange="callHospitalList(this)" required>
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



<h6 class="mt-4">
							<strong class="form-label "> List Of Documents (with
								attachment) (कागदपत्रांची यादी (संलग्नकांसह)) </strong>
						</h6>


						<div class="alert alert-info mb-0 p-2 mb-4 ms-2">
							<small class="form-label "><strong class="form-label ">Note(नोंद):
							</strong> Upload below files in .pdf(Max upto 2 MB)(खालील फाइल .pdf मध्ये
								अपलोड करा (कमाल २ MB पर्यंत))</small>

						</div>
						<div class="row">
						
            <!--<div class="col-md-3">




 <div class="mb-3 mt-0">

    <label for="" class="form-label"> Self  attested copy of Hospital/Nursing Home Map sanctioned by NMC/NIT (एनएमसी/एनआयटीने मंजूर केलेल्या हॉस्पिटल/नर्सिंग होम नकाशाची स्व-साक्षांकित प्रत)<span class="text-danger" style="color: red;">*</span></label>

    <input type="file" class="form-control" style="background-image: none;" id="doc1" placeholder="" name="certificate_of_medical_file" 

        onchange="readURL(this.value)" accept="application/pdf,application/image , image/jpeg, image/png" required>
<div class="invalid-feedback">File selected is either
                        greater than 2Mb or not of type .pdf.</div>
</div>

</div>   --> 

                <div class="col-md-3">

                <div class="mb-3 mt-0">

                    <label for="" class="form-label"> Autocad maps showing medical facilities with required space reserved for beds in sq.ft. (sq.ft मध्ये बेडसाठी आरक्षित आवश्यक जागेसह वैद्यकीय सुविधा दर्शवणारे ऑटोकॅड नकाशे.)<span class="text-danger" style="color: red;">*</span></label>

                    <input type="file" class="form-control" style="background-image: none;" id="doc2" placeholder="" name="certificate_of_medical_file" 

                        onchange="readURL(this.value)" accept="application/pdf,application/image , image/jpeg, image/png" required>
<div class="invalid-feedback">File selected is either
										greater than 2Mb or not of type .pdf.</div>
                </div>

            </div>   
                <div class="col-md-3">

            <div class="mb-3 mt-5">

<label for="" class="form-label"> Fire NOC/Fire audit of Hospital/Nursing home building. (हॉस्पिटल / नर्सिंग होम इमारतीचे फायर ऑडिट.)*<span class="text-danger" style="color: red;">*</span></label>

<input type="file" class="form-control" style="background-image: none;" id="doc3" placeholder="" name="certificate_of_medical_file" 

    onchange="readURL(this.value)" accept="application/pdf,application/image , image/jpeg, image/png" required>
<div class="invalid-feedback">File selected is either
                    greater than 2Mb or not of type .pdf.</div>
</div>

</div>   



                <div class="col-md-3">

<div class="mb-3 mt-5">

<label for="" class="form-label"> Structual audit of Hospital/Nursing home building. (रुग्णालय/ नर्सिंग होम इमारतीचे स्ट्रक्चरल ऑडिट.)<span class="text-danger" style="color: red;">*</span></label>

<input type="file" class="form-control" style="background-image: none;" id="doc4" placeholder="" name="certificate_of_medical_file" 

    onchange="readURL(this.value)" accept="application/pdf,application/image , image/jpeg, image/png" required>
<div class="invalid-feedback">File selected is either
                    greater than 2Mb or not of type .pdf.</div>
</div>

</div> 

                <div class="col-md-3">

<div class="mb-3" style="margin-top:72px;">

<label for="" class="form-label"> Electrical audit of Hospital/Nursing home building. (हॉस्पिटल / नर्सिंग होम इमारतीचे इलेक्ट्रिकल ऑडिट.)<span class="text-danger" style="color: red;">*</span></label>

<input type="file" class="form-control" style="background-image: none;" id="doc5" placeholder="" name="certificate_of_medical_file" 

    onchange="readURL(this.value)" accept="application/pdf,application/image , image/jpeg, image/png" required>
<div class="invalid-feedback">File selected is either
                    greater than 2Mb or not of type .pdf.</div>
</div>

</div> 


                <div class="col-md-3">

<div class="mb-3 mt-5">

<label for="" class="form-label"> Property tax receipt of place where Hospital/Nursing home is situated. (ज्या ठिकाणी हॉस्पिटल/ नर्सिंग होम आहे त्या ठिकाणची मालमत्ता कर पावती)<span class="text-danger" style="color: red;">*</span></label>

<input type="file" class="form-control" style="background-image: none;" id="doc6" placeholder="" name="certificate_of_medical_file" 

    onchange="readURL(this.value)" accept="application/pdf,application/image , image/jpeg, image/png" required>
<div class="invalid-feedback">File selected is either
                    greater than 2Mb or not of type .pdf.</div>
</div>

</div> 

                <div class="col-md-3">

<div class="mb-3 mt-5"> 

<label for="" class="form-label"> Bio Medical waste registration receipt from authorized agency. (अधिकृत एजन्सीकडून जैव वैद्यकीय कचरा नोंदणीची पावती.)<span class="text-danger" style="color: red;">*</span></label>

<input type="file" class="form-control" style="background-image: none;" id="doc7" placeholder="" name="certificate_of_medical_file" 

    onchange="readURL(this.value)" accept="application/pdf,application/image , image/jpeg, image/png" required>
<div class="invalid-feedback">File selected is either
                    greater than 2Mb or not of type .pdf.</div>
</div>

</div>
                <div class="col-md-3">

<div class="mb-3 mt-0">

<label for="" class="form-label"> Documents of educational qualification of Consultant/Duty Medical Officers as per sr. no. 11 mentioned in application. (सल्लागार/ड्युटी वैद्यकीय अधिकाऱ्यांच्या शैक्षणिक पात्रतेची कागदपत्रे.)<span class="text-danger" style="color: red;">*</span></label>

<input type="file" class="form-control" style="background-image: none;" id="doc8" placeholder="" name="certificate_of_medical_file" 

    onchange="readURL(this.value)" accept="application/pdf,application/image , image/jpeg, image/png" required>
<div class="invalid-feedback">File selected is either
                    greater than 2Mb or not of type .pdf.</div>
</div>

</div>

                <div class="col-md-3">

<div class="mb-3 mt-3">

<label for="" class="form-label"> Nursing Council Registration Certificate of all nursing staff BSC Nursing/GNM/ANM. (सर्व नर्सिंग स्टाफचे नर्सिंग कौन्सिल नोंदणी प्रमाणपत्र BSC नर्सिंग/GNM/ANM.)<span class="text-danger" style="color: red;">*</span></label>

<input type="file" class="form-control" style="background-image: none;" id="doc9" placeholder="" name="certificate_of_medical_file" 

    onchange="readURL(this.value)" accept="application/pdf,application/image , image/jpeg, image/png" required>
<div class="invalid-feedback">File selected is either
                    greater than 2Mb or not of type .pdf.</div>
</div>

</div>
<!-- 

                <div class="col-md-3">

<div class="mb-3 mt-3">

<label for="" class="form-label"> Documents of ownership or tenancy related to Hospital/Nursing home building.(हॉस्पिटल/नर्सिंग होम इमारतीशी संबंधित मालकी किंवा भाडेकराराची कागदपत्रे.)<span class="text-danger" style="color: red;">*</span></label>

<input type="file" class="form-control" style="background-image: none;" id="doc10" placeholder="" name="certificate_of_medical_file" 

    onchange="readURL(this.value)" accept="application/pdf,application/image , image/jpeg, image/png" required>
<div class="invalid-feedback">File selected is either
                    greater than 2Mb or not of type .pdf.</div>
</div>

</div>

                <div class="col-md-3">

<div class="mb-3 mt-3">

<label for="" class="form-label"> List of major medical, surgical & diagnostic equipments & machinaries.(प्रमुख वैद्यकीय, शस्त्रक्रिया आणि निदान उपकरणे आणि यंत्रसामग्रीची यादी.)<span class="text-danger" style="color: red;">*</span></label>

<input type="file" class="form-control" style="background-image: none;" id="doc11" placeholder="" name="certificate_of_medical_file" 

    onchange="readURL(this.value)" accept="application/pdf,application/image , image/jpeg, image/png" required>
<div class="invalid-feedback">File selected is either
                    greater than 2Mb or not of type .pdf.</div>
</div>

</div> -->

                <div class="col-md-3">

<div class="mb-3 mt-0">

<label for="" class="form-label">Concert to establishment from Maharashtra polution Control Board.(महाराष्ट्र प्रदूषण नियंत्रण मंडळाकडून स्थापनेची मैफल.)<span class="text-danger" style="color: red;">*</span></label>

<input type="file" class="form-control" style="background-image: none;" id="doc13" placeholder="" name="certificate_of_medical_file" 

    onchange="readURL(this.value)" accept="application/pdf,application/image , image/jpeg, image/png" required>
<div class="invalid-feedback">File selected is either
                    greater than 2Mb or not of type .pdf.</div>
</div>

</div>

                <div class="col-md-3">

<div class="mb-3 mt-5">

<label for="" class="form-label">Affidavit (प्रतिज्ञापत्र)<span class="text-danger" style="color: red;">*</span>

 <a class="fa fa-download"
							onClick="downloadFiles()" style="color: blue;"> </a>
</label>

<input type="file" class="form-control" style="background-image: none;" id="doc12" placeholder="" name="certificate_of_medical_file" 

    onchange="readURL(this.value)" accept="application/pdf,application/image , image/jpeg, image/png" required>
<div class="invalid-feedback">File selected is either
                    greater than 2Mb or not of type .pdf.</div>
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
                           onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/saveRenewalNursingHome.do');
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

       data.append('idProof1', $("#qualifiedNuerseDoc").get(0).files[0]);
       data.append('idProof2', $("#qulnursemidwifedocs").get(0).files[0]);
       data.append('idProof3', $("#unregmedunquilnursingDoc").get(0).files[0]);
       data.append('idProof4', $("#aliennationalitydoc").get(0).files[0]);
       data.append('idProof5', $("#applicantinterestedoc").get(0).files[0]);
       //data.append('idProof6', $("#doc1").get(0).files[0]);
       data.append('idProof7', $("#doc2").get(0).files[0]);
       data.append('idProof8', $("#doc3").get(0).files[0]);
       data.append('idProof9', $("#doc4").get(0).files[0]);
       data.append('idProof10', $("#doc5").get(0).files[0]);
       data.append('idProof11', $("#doc6").get(0).files[0]);
       data.append('idProof12', $("#doc7").get(0).files[0]);
       data.append('idProof13', $("#doc8").get(0).files[0]);
       data.append('idProof14', $("#doc9").get(0).files[0]);
       //data.append('idProof15', $("#doc10").get(0).files[0]);
       //data.append('idProof16', $("#doc11").get(0).files[0]);
       //data.append('idProof17', $("#doc12").get(0).files[0]);
       data.append('idProof18', $("#doc13").get(0).files[0]);



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
               filesPath = filesPath + basePath + "NursingHome/" + id + value + ","
               isFileSelected = true;
           }
       }
       $.ajax({
           url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadNursingHome.do?id="+id,
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

<script type="text/javascript">
$('.printMe').on('click', function () {

    window.print();
});
</script>


<script type="text/javascript">

    
    $(window).on('load', function(){
                
                
        $('#myModal').modal('show');
        
        $('#myModal .modal-footer .btn').on('click', function(e) {
            console.log('button pressed');              
            // just as an example...
            $('#myModal').modal('hide');                
            // dismiss the dialog
        });
    })
    $("#select_all").click(function(){
                $('.chkall').not(this).prop('checked', this.checked);
            });
</script>




       <script>
        
        
        $(document).ready(function() {
    $('#qualifiednurse').on('change', function() {
        if (this.value == "Yes") {
            $("#qualifiedNuerseDoc").show();
            $("#upload_staff").show();
            $("#qualifiedNuerseDoc").prop('required', true);
        } else if (this.value == "No") {
            $("#qualifiedNuerseDoc").hide();
            $("#upload_staff").hide();
            $("#qualifiedNuerseDoc").prop('required', false);
        }
    });

    $('#qulnursemidwife').on('change', function() {
        if (this.value == "Yes") {
            $("#qulnursemidwifedocs").show();
            $("#upload_nurse_supervision_file").show();
            $("#qulnursemidwifedocs").prop('required', true);
        } else if (this.value == "No") {
            $("#qulnursemidwifedocs").hide();
            $("#upload_nurse_supervision_file").hide();
            $("#qulnursemidwifedocs").prop('required', false);
        }
    });

    $('#unregistered_medical_practitionar').on('change', function() {
        if (this.value == "Yes") {
            $("#unregmedunquilnursingDoc").show();
            $("#upload_unregistered_medical_practitionar_file").show();
            $("#unregmedunquilnursingDoc").prop('required', true);
        } else if (this.value == "No") {
            $("#unregmedunquilnursingDoc").hide();
            $("#upload_unregistered_medical_practitionar_file").hide();
            $("#unregmedunquilnursingDoc").prop('required', false);
        }
    });

    $('#aliennationality').on('change', function() {
        if (this.value == "Yes") {
            $("#aliennationalitydoc").show();
            $("#upload_aliennationalitydoc").show();
            $("#aliennationalitydoc").prop('required', true);
        } else if (this.value == "No") {
            $("#aliennationalitydoc").hide();
            $("#upload_aliennationalitydoc").hide();
            $("#aliennationalitydoc").prop('required', false);
        }
    });

    $('#applicantintereste').on('change', function() {
        if (this.value == "Yes") {
            $("#applicantinterestedoc").show();
            $("#upload_applicantinterestedoc").show();
            $("#applicantinterestedoc").prop('required', true);
        } else if (this.value == "No") {
            $("#applicantinterestedoc").hide();
            $("#upload_applicantinterestedoc").hide();
            $("#applicantinterestedoc").prop('required', false);
        }
    });
});

        </script>


        
    
        <!-- set up the modal to start hidden and fade in and out -->

<style>
label {
	font-weight: 600;
}

h3 {
	font-weight: 500;
}

.modal-content {
    position: relative;
    display: -ms-flexbox;
    display: block;
    -ms-flex-direction: column;
    flex-direction: column;
    width: 900PX;
    pointer-events: auto;
    background-color: #fff;
    background-clip: padding-box;
    border: 1px solid rgba(0,0,0,.2);
    border-radius: 0.3rem;
    outline: 0;
    margin-left:-250px;
    margin-top:50px;
}

.modal-footer{
height: 66px;
}

</style>
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

                         <ul>

<li>1. Autocad maps showing medical facilities with required space reserved for beds in sq.ft. (sq.ft मध्ये बेडसाठी आरक्षित आवश्यक जागेसह वैद्यकीय सुविधा दर्शवणारे ऑटोकॅड नकाशे.)<span class="text-danger" style="color: red;">*</span></li>
<li>2. Fire NOC/Fire audit of Hospital/Nursing home building. (हॉस्पिटल / नर्सिंग होम इमारतीचे फायर ऑडिट.)<span class="text-danger" style="color: red;">*</span></li>
<li>3. Structual audit of Hospital/Nursing home building. (रुग्णालय/ नर्सिंग होम इमारतीचे स्ट्रक्चरल ऑडिट.)<span class="text-danger" style="color: red;">*</span></li>
<li>4. Electrical audit of Hospital/Nursing home building. (हॉस्पिटल / नर्सिंग होम इमारतीचे इलेक्ट्रिकल ऑडिट.)<span class="text-danger" style="color: red;">*</span></li>
<li>5. Property tax receipt of place where Hospital/Nursing home is situated. (ज्या ठिकाणी हॉस्पिटल/ नर्सिंग होम आहे त्या ठिकाणची मालमत्ता कर पावती)<span class="text-danger" style="color: red;">*</span></li>
<li>6. Bio Medical waste registration receipt fromm authorized agency. (अधिकृत एजन्सीकडून जैव वैद्यकीय कचरा नोंदणीची पावती.)<span class="text-danger" style="color: red;">*</span></li>
<li>7. Documents of educational qualification of Consultant/Duty Medical Officers as per sr. no. 11 mentioned in application. (सल्लागार/ड्युटी वैद्यकीय अधिकाऱ्यांच्या शैक्षणिक पात्रतेची कागदपत्रे.)<span class="text-danger" style="color: red;">*</span></li>
<li>8. Nursing Council Registration Certificate of all nursing staff BSC Nursing/GNM/ANM. (सर्व नर्सिंग स्टाफचे नर्सिंग कौन्सिल नोंदणी प्रमाणपत्र BSC नर्सिंग/GNM/ANM.)<span class="text-danger" style="color: red;">*</span></li>
<li>9. Concert to establishment from Maharashtra polution Control Board.(महाराष्ट्र प्रदूषण नियंत्रण मंडळाकडून स्थापनेची मैफल.)<span class="text-danger" style="color: red;">*</span></li>
<li>10. Affidavit (प्रतिज्ञापत्र)<span class="text-danger" style="color: red;">*</span></li>


                    </ul>
                    

                    </div>

                    <!-- dialog buttons -->

                    <div class="modal-footer"><button type="button" class="btn btn-primary">OK</button></div>

                </div>

            </div>

        </div>



        

    </body>
</html>
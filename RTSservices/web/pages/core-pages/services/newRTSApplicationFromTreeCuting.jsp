<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.include file="/pages/core-pages/nmc_user/dashboard/header.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants" />
<jsp:directive.page import="com.mars.common.utils.CommonUtils" />
		<jsp:directive.page import="com.mars.rti.utils.CoreConstants" />



<head>
    <title>Nagpur Municipal Corporation</title>
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
  .note {
    border: 1px solid #ccc;
    background-color: #f9f9f9;
    padding: 10px;
    margin-bottom: 20px;
        font-size: 14px;
            background-color: aliceblue;
  }
  .note-label {
  font-weight: 500;
    color: #333;
    margin-bottom: 5px;
    display: block;
  }
  .note-text {
    color: #333;
    font-style: italic;
  }
  .text-danger {
    color: red;
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

</head>

<body>
    <form id="CanDetails" class="needs-validation" novalidate>
	<div class="container-fluid mt-2" style="width: 180vh">
            
            <div class="printable">
                <h3  class="text-center"><strong>Application For Tree Cutting (वृक्ष तोड परवानगी देणे)</strong></h3>
            </div>
            <div class="row align-items-center">

            <h6 style="background-color:#dce2e8; padding:10px;" class="  rounded-2"><strong> Applicant Details (अर्जदाराचे तपशील) </strong>
            </h6>
            <div class="row">
            <input type="hidden" name="_token" value="xyz">
                       <div class="col-md-3">
                           <div class="mb-3 mt-3">
                               <label for="" class="form-label">Title (शीर्षक) <span class="text-danger" style="color: red;">*</span>
                               </label>
                               <select class="form-select" style="background-image: none;"name="title" required>

                                
                                   <option value="">-Select-</option>
                                                              <option value="श्री." >Mr (श्री)</option>
                                                               <option value="सौ." >Mrs (सौ)</option>
                                                               <option value="कु." >Ms (कु)</option>
                                                       </select>
                                         
                               
                    <div class="invalid-feedback">
                                   Please Select Valid Title.
                               </div>
                    
                           </div>
                       </div>
           
                       <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label">Name (नाव)<span class="text-danger" >*</span></label>
                            <input type="text" class="form-control name" style="background-image: none;" id="first_name" placeholder="" name="firstName" value=""
                             onchange="Display(this.id);"  pattern="[A-Za-z]+"  maxlength="40" required>
                            <div class="invalid-feedback">
                                Please Enter Valid Name.
                            </div>

                        </div>
                    </div>
            
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label">Father's Name (वडिलांचे नाव)</label>
                            <input type="text" class="form-control name" id="middle_name"  style="background-image: none;" placeholder="" name="middlename" value=""
                            pattern="[A-Za-z]+"onchange="Display(this.id)">
                           
                                
                        </div>
                    </div>
            
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label">Surname (आडनाव)<span class="text-danger" style="color: red;">*</span></label>
                           

                            <input type="text" class="form-control name" pattern="[A-Za-z]+"   style="background-image: none;" name="lastname" id="last_name" value=""  onchange="Display(this.id)" maxlength="80" required>
                            <div class="invalid-feedback">
                                Please Enter Valid Surname.

                               

                            </div>

                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Full Name (संपूर्ण नाव) </label>
                           
                            <input type="text" class="form-control"  pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" style="background-image: none;" id="full_name" placeholder="" name="fullName" value="" readonly>
                        </div>
                    </div>


                    <script>
                        function Display(id) {
                                      $('#full_name').val( $('#first_name').val()+" "+ $('#middle_name').val()+" "+ $('#last_name').val())
                                }
                        </script>
        

                
				<div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Plot/ Flat No.(प्लॉट/फ्लॅट क्र.) <span class="text-danger" style="color: red;">*</span></label>
                    <input type=" number" class="form-control" pattern="^\s*\S.*$"  style="background-image: none;" id="plot_no" placeholder="" name="applicantPlotNo" value=""
                                maxlength="255"   onchange="change(this.id)" required>
                                    <div class="invalid-feedback">
                                        Please Enter Valid Plot/Flat No.
                                    </div>

                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Name of the Building (इमारतीचे नाव)</label>
                            <input type=" text" class="form-control" style="background-image: none;" id="buildingName" placeholder=""
                                name="applicantBuildingName" onchange="change(this.id)" value="">
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Name of the Street (रस्त्याचे नाव)<span class="text-danger" style="color: red;">*</span></label>
                    <input type=" text" class="form-control" style="background-image: none;" id="street_name" placeholder="" name="applicantStreetName"
                                   onchange="change(this.id)" value="" required>
                                   <div class="invalid-feedback">
                                Please Enter Valid Street Name.
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Name of the Area (क्षेत्राचे नाव)<span class="text-danger"
                                    style="color: red;"">*</span></label>
                                    
                    <input type=" text" class="form-control" style="background-image: none;" id="areaName" placeholder="" name="areaName" value="" maxlength="255"  pattern="^\s*\S.*$"
                                  onchange="change(this.id)" required>
                                   <div class="invalid-feedback">
                                    Please Enter Valid Name of the Area.
                                </div>
                                
                        </div>
                    </div>

                   

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Near by Landmark (जवळील लँडमार्क)</label>
                           
                            <input type=" text" class="form-control" style="background-image: none;" id="landmark" placeholder="" name="landmark"
                                value="" onchange="change(this.id)" pattern="^\s*\S.*$">
                        </div>
                    </div>
                     <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">City Name (शहराचे नाव)<span class="text-danger"
                                    style="color: red;"">*</span></label>
                           
                            <input type=" text" class="form-control" style="background-image: none;" id="city" placeholder="" name="applicantcity"
                                value="Nagpur" onchange="change(this.id)" pattern="^\s*\S.*$" required>
                                 <div class="invalid-feedback">
                                Please Enter Valid City Name.
                            </div>
                        </div>
                    </div>
                   
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Pin Code (पिन कोड) <span class="text-danger" >*</span></label>
                            

                            <input type="text" class="form-control" style="background-image: none;" pattern="[0-9]{6}" name="pincode" value="" onchange="change(this.id)" id="pin_code"
                                        maxlength="6" required>
                                        <div class="invalid-feedback">
                                Please Enter Valid Pin Code.
                            </div>
                            
                                
                        </div>
                        
                    </div>
                    <div class="col-md-3">
                        <div class="mb-3 mt-4">
                            <label for="" class="form-label "> Aadhaar No. (आधार क्र.)
                            </label>
                           
                            <input type="text" class="form-control " style="background-image: none;" id="aadhaarNumber1" placeholder="" name="aadhaarcard" value=""
                               pattern="[0-9]{12}"
                                maxlength="12" >
                                <div class="invalid-feedback">
                                Please Enter Valid Aadhaar No.
                            </div>

                        </div>
                    </div>
                     <div class="col-md-3">
                            <div class="mb-3 mt-4">
                                
                            <label for="email"  class="form-label "> Email Id (ईमेल आयडी )<span class="text-danger" >*</span> </label>
                            
                            <input type="email" class="form-control " style="background-image: none;" name="email" value="" required>
                            <div class="invalid-feedback">
                                Please Enter Valid Email Id.
                            </div>
                            
                        </div>
                    </div>
                    
                                    
                    <div class="col-md-3">
                        <div class="mb-3 mt-4">
                            <label for="" class="form-label "> Mobile No. (मोबाईल क्र.)<span class="text-danger"
                                    style="color: red;">*</span>
                            </label>
                            
                            <input type="text" class="form-control " style="background-image: none;" id="txtMobileNumber" placeholder="" name="mobileNo" value=""
                            pattern="[6-9]{1}[0-9]{9}"
                                maxlength="10"  required>
                             <div class="invalid-feedback">
                                Please Enter Valid Mobile No.
                            </div>

                        </div>
                    </div>  
                 
                    </div>
    <div class="col-md-12">
    <div class="mb-3 mt-3">
        <label for="primary_full_address" class="form-label">Address For Correspondence (पत्रव्यवहारासाठी पत्ता)&nbsp;&nbsp;(Same as
							above (वरील
							प्रमाणे)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="radio" class="form-check-input" name="yes" id="yes"
							onclick="change(this.id)"> Yes
							(होय)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
							type="radio" class="form-check-input" name="yes" id="no"
							onclick="change(this.id)">No (नाही)&nbsp;)<span class="text-danger">*</span></label>
        <textarea class="form-control" oninput="validateTextarea()" style="background-image: none;"  rows="2" id="Address" name="address" required></textarea>
        <div class="invalid-feedback" id="errorFeedback">
            Please enter a valid address.
        </div>
         </div>
</div><br>

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
   
   
            
        
            
              
                
			

                <h6 style="background-color:#dce2e8; padding:10px;" class=" mt-3 rounded-2"><strong> Application Form
                    Details (अर्ज तपशील)</strong></h6>
<div class="row">

<div class="col-md-3">
					<div class="mb-3 mt-4">
						<label for="" class="form-label lbleng">Zone No. (झोन
							क्र.)<span class="text-danger" style="color: red;">*</span>
						</label> <select class="form-select " style="background-image: none;"
							id="main-dropdown" name="zoneNo" required>
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


				<!-- <div class="col-md-3 hospital_row" id="hos">
					<div class="mb-3 mt-4">
						<label for="" class="form-label"> Ward No. (प्रभाग क्र.) <span
							class="text-danger" style="color: red;">*</span></label> <select
							class="form-select" style="background-image: none;"
							id="dependent-dropdown" name="wardNo" disabled required>

							<option value="" selected="">-Select Ward-</option>
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
<a class="fa fa-download" onClick="downloadFile()" style="color: blue; font-size: medium;">&nbsp;&nbsp;Click here to know your ward.</a>

				</div>-->
				
   <!--  <div class="col-md-3 mt-4">
        <label for="primary_full_address" class="form-label lbleng">Type of Tree (झाडाचा प्रकार)<span class="text-danger">*</span></label>
        <select class="form-select" style="background-image: none;" id="iFunction" name="treeType" onchange="changeddl(this)" required>
            <option value="" selected="">-Select Tree Type-</option>
            <option value="Fruit tree">Fruit Tree</option>
            <option value="Other Tree">Other Tree</option>
  
        </select>
        <div class="invalid-feedback">
            Please select the type of tree.
        </div>
    </div>-->

    <div class="col-md-3">
        <label for="primary_full_address" class="form-label lbleng">Reason For Tree Cutting (वृक्ष तोडण्याचे कारण)<span class="text-danger">*</span></label>
        <select class="form-select" style="background-image: none;" id="iFunction" name="resonetreecuting" onchange="changeddl(this)" required>
            <option value="" selected="">-Select-</option>
            <option value="Cutting Down Dangerous Trees">Cutting Down Dangerous Trees</option>
            <option value="Cutting Down Dried up Trees">Cutting Down Dried up Trees</option>
            <option value="Obstruction to construction Cutting down Tree">Obstruction to construction Cutting down Tree</option>
        </select>
        <div class="invalid-feedback">
            Please select the reason for trimming.
        </div>
    </div>
<div class="col-md-3">
    <div class="mb-3 mt-0">
        <label for="" class="form-label lbleng">Number of tree cutting (वृक्ष तोडण्याची संख्या)<span class="text-danger">*</span></label>
        <input type="text" class="form-control" style="background-image: none;" onchange="noOfTreeCal()" id="noOfTreeCal" placeholder="" name="numberoftreecuting" maxlength="4" pattern="[1-9][0-9]{0,3}" required>
        <div class="invalid-feedback">
            Please Enter a valid Number of Trees.
        </div>
    </div>
</div>




    <!-- <div class="col-md-3">
        <div class="mb-3 mt-0">
            <label for="" class="form-label lbleng">Number of tree cutting (वृक्ष तोडण्याची संख्या)<span class="text-danger">*</span></label>
            <input type="text" class="form-control" style="background-image: none;" onchange="noOfTreeCal()" id="noOfTreeCal" placeholder="" name="numberoftreecuting" required>
             <div class="invalid-feedback">
            Please Enter the Number of Trees.
        </div>
        </div>
    </div>-->
    <div class="col-md-3">
    <div class="mb-3" style="margin-top: 23px;">
        <label for="primary_full_address" class="form-label lbleng">Location of Tree (वृक्षाचे स्थान)<span class="text-danger">*</span></label>
        <select class="form-select" style="background-image: none;" id="locationDropdown" name="locationofTree" onchange="checkForOther()" required>
            <option value="" selected>-Select Location Tree-</option>
            <option value="Within the premises">Within the premises</option>
            <option value="Outside the premises">Outside the premises</option>
            <option value="Along the road side">Along the road side</option>
            <option value="Other">Other</option>
        </select>
        <div class="invalid-feedback">
            Please select the location of tree.
        </div>
    </div>
</div>

<script>
    function checkForOther() {
        var dropdown = document.getElementById("locationDropdown");

        if (dropdown.value === "Other") {
            var inputField = document.createElement("input");
            inputField.type = "text";
            inputField.className = "form-control";
            inputField.placeholder = "Enter other location";
            inputField.name = "locationofTree";
            inputField.required = true;
            inputField.pattern = "^[A-Za-z]+$"; // Pattern to accept letters only
            inputField.style.backgroundImage = "none"; // Set background-image to none
            inputField.id = "otherLocationInput"; // Assign an ID for future reference
            inputField.maxLength = 70; // Set maximum length to 80 characters


            // Replace the select box content with the input field
            dropdown.parentNode.replaceChild(inputField, dropdown);
            inputField.focus();
        }
    }
</script>


    
    <div class="col-md-12">
    <div class="mb-3 mt-3">
        <label for="primary_full_address" class="form-label">Detailed Address Of Tree(वृक्षाचा तपशीलवार पत्ता)<span class="text-danger">*</span></label>
        <textarea class="form-control" oninput="" style="background-image: none;"  rows="2" id="treeAddress" name="treeAddress" required></textarea>
        <div class="invalid-feedback" id="errorFeedback">
            Please enter a valid address.
        </div>
         </div>
</div>
    </div>

<div class="col-md-12">
    <div class="mb-3">
        <label class="form-label">
            Ownership of the Tree (वृक्षाची मालकी)
            <span class="text-danger">*</span>
        </label>

        <div class="mt-2">
            <div class="form-check form-check-inline">
                <input class="form-check-input ownershipType"
                       type="radio"
                       name="ownership"
                       id="ownershipPrivate"
                       value="Private"
                       required>

                <label class="form-check-label" for="ownershipPrivate">
                    Private
                </label>
            </div>

            <div class="form-check form-check-inline">
                <input class="form-check-input ownershipType"
                       type="radio"
                       name="ownership"
                       id="ownershipMunicipal"
                       value="Municipal">

                <label class="form-check-label" for="ownershipMunicipal">
                    Municipal
                </label>
            </div>

            <div class="form-check form-check-inline">
                <input class="form-check-input ownershipType"
                       type="radio"
                       name="ownership"
                       id="ownershipGovernmental"
                       value="Governmental">

                <label class="form-check-label" for="ownershipGovernmental">
                    Governmental
                </label>
            </div>
        </div>
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
                <div class="mb-3" style="margin-top: 25px;">
                    <label for="" class="form-label">Self Attested Applicant's Id Proof (स्वत: प्रमाणित अर्जदाराचा आयडी पुरावा)<span class="text-danger"
                            style="color: red;">*</span>
                    </label>
                    <input type="file" class="form-control waterRequired" style="background-image: none;" name="taxpaidrecipt" id="city_survey" accept=".pdf" required>
                    <div class="invalid-feedback">
                    File selected is either greater than 2Mb or not of type .pdf.
                </div>

                </div>
            </div>

           <!--  <div class="col-md-3">
                <div class="mb-0 mt-0">
                    <label for="" class="form-label">Current Year property tax Paid Receipt(चालू वर्षाचा मालमत्ता कर भरलेली पावती)</label>
                    <input type="file" class="form-control waterRequired" style="background-image: none;" name=aadhaarcard id="city_survey1" accept=".pdf"
                       pattern="[0-9]{12}" maxlength="12" >
                        <div class="invalid-feedback">
                    File selected is either greater than 2Mb or not of type .pdf.
                </div>
                </div>
            </div>-->

          

               <!--  <div class="col-md-3">
                    <div class="mb-3" style="margin-top: 45px;">
                        <label for="" class="form-label"> Building Permission (बांधकाम परवानगी)
                        </label>
                        <input type="file" class="form-control waterRequired" style="background-image: none;" id="city_survey3" accept=".pdf" placeholder="" name="Photographoftree">
                        <div class="invalid-feedback">
                            File selected is either greater than 2Mb or not of type .pdf.
                        </div>
                    </div>
                </div>-->

                <div class="col-md-3">
                    <div class="mb-3" style="margin-top: 48px;"> 
                        <label for="" class="form-label"> Photograph Of Tree (वृक्षाचे छायाचित्र)<span class="text-danger"  style="color: red;">*</span></label>
                        <input type="file" class="form-control waterRequired" style="background-image: none;" name="buildingPermission" id="city_survey2"  accept=".pdf" placeholder="" required>
                        

                            <div class="invalid-feedback">
                                File selected is either greater than 2Mb or not of type .pdf.
                            </div>
                    </div>
                </div>
 <div class="col-md-3">
                    <div class="mb-3" style="margin-top: 24px;">
                        <label for="" class="form-label"> No Objection Certificate (ना हरकत प्रमाणपत्र)<span class="text-danger">*</span> </label>
                        <input type="file" class="form-control waterRequired" style="background-image: none;" name="buildingPermission" id="city_survey3" accept=".pdf" placeholder="" required>
                            <div class="invalid-feedback">
                                File selected is either greater than 2Mb or not of type .pdf.
                            </div>
                    </div>
                </div>
                
               
     <div class="col-md-3">
                    <div class="mb-3" style="margin-top: 24px;">
                        <label for="" class="form-label">Approved Building Plan<span class="text-danger"  style="color: red;">*</span></label>
                        <input type="file" class="form-control waterRequired" style="background-image: none;" name="buildingPlan" id="city_survey5" accept=".pdf" placeholder="" required>
                            <div class="invalid-feedback">
                                File selected is either greater than 2Mb or not of type .pdf.
                            </div>
                    </div>
                </div>
                
                  <div class="col-md-3">
                    <div class="mb-3" style="margin-top: 24px;">
                        <label for="" class="form-label">Property Tax receipt<span class="text-danger"  style="color: red;">*</span></label>
                        <input type="file" class="form-control waterRequired" style="background-image: none;" name="taxReceipt" id="city_survey6" accept=".pdf" placeholder="" required>
                            <div class="invalid-feedback">
                                File selected is either greater than 2Mb or not of type .pdf.
                            </div>
                    </div>
                </div>
                 <div class="col-md-3">
                    <div class="mb-3" style="margin-top: 24px;">
                        <label for="" class="form-label">Property Record<span class="text-danger"  style="color: red;">*</span></label>
                        <input type="file" class="form-control waterRequired" style="background-image: none;" name="propertyRecord" id="city_survey7" accept=".pdf" placeholder="" required>
                            <div class="invalid-feedback">
                                File selected is either greater than 2Mb or not of type .pdf.
                            </div>
                    </div>
                </div>
    <!-- Administrative Approval -->

    <div class="col-lg-3 col-md-6 document-box govtDoc" style="display:none;">
        <div class="mb-3" style="margin-top:24px;">
            <label class="form-label">
                Administrative Approval
                <span class="text-danger">*</span>
            </label>

            <input type="file"
                   class="form-control"
                   name="admApproval"
                   id="city_survey8"
                   accept=".pdf"
                   style="background-image: none;">

            <div class="invalid-feedback">
                File selected is either greater than 2Mb or not of type .pdf.
            </div>
        </div>
    </div>

    <!-- Work Order -->

    <div class="col-lg-3 col-md-6 document-box govtDoc" style="display:none;">
        <div class="mb-3" style="margin-top:24px;">
            <label class="form-label">
                Work Order
                <span class="text-danger">*</span>
            </label>

            <input type="file"
                   class="form-control"
                   name="workOrder"
                   id="city_survey9"
                   accept=".pdf"
                   style="background-image: none;">

            <div class="invalid-feedback">
                File selected is either greater than 2Mb or not of type .pdf.
            </div>
        </div>
    </div>

    <!-- Fund Sanction Letter -->

    <div class="col-lg-3 col-md-6 document-box govtDoc" style="display:none;">
        <div class="mb-3" style="margin-top:24px;">
            <label class="form-label">
                Fund Sanction Letter
                <span class="text-danger">*</span>
            </label>

            <input type="file"
                   class="form-control"
                   name="sanctionLetter"
                   id="city_survey10"
                   accept=".pdf"
                   style="background-image: none;">

            <div class="invalid-feedback">
                File selected is either greater than 2Mb or not of type .pdf.
            </div>
        </div>
    </div>
    


                  <div class="col-md-3">
                <div class="mb-0" style="margin-top: 0px;">
                    <label for="" class="form-label">Sanctioned plan with marking of Tree to be cut (कापल्या जाणाऱ्या वृक्षाच्या चिन्हासह मंजूर आराखडा)
             </label>
                    <input type="file" class="form-control waterRequired" style="background-image: none;" name=sanctionedplanconstruction id="city_survey1" accept=".pdf">
                    <div class="invalid-feedback">
                    File selected is either greater than 2Mb or not of type .pdf.
                </div>
                </div>
            </div>
                
                 <div class="col-md-3">
                    <div class="mb-3" style="margin-top: 24px;">
                        <label for="" class="form-label"> Any Other Supporting document (इतर कोणतेही सहाय्यक दस्तावेज)</label>
                        <input type="file" class="form-control waterRequired" style="background-image: none;" name="buildingPermission" id="city_survey4" accept=".pdf" placeholder="">
                            <div class="invalid-feedback">
                                File selected is either greater than 2Mb or not of type .pdf.
                            </div>
                    </div>
                </div>
                <script>
                function toggleGovernmentDocuments() {

                    var ownership = $("input[name='ownership']:checked").val();

                    if (ownership === "Governmental") {

                        $(".govtDoc").show();

                        $("#city_survey8").prop("required", true);
                        $("#city_survey9").prop("required", true);
                        $("#city_survey10").prop("required", true);

                    } else {

                        $(".govtDoc").hide();

                        $("#city_survey8").prop("required", false).val('');
                        $("#city_survey9").prop("required", false).val('');
                        $("#city_survey10").prop("required", false).val('');
                    }
                }

                $(".ownershipType").change(function () {
                    toggleGovernmentDocuments();
                });

                $(document).ready(function () {
                    toggleGovernmentDocuments();
                });

</script>
                <div class="col-md-12">
                    <div class="mb-5 mt-4">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" id="check11" name="declaration"
                                value="something" required>

                            <label class="form-check-label ms-3 lbleng" style="margin-top: 0px;">
                                <strong>Declaration (घोषणा) <span class="text-danger"
                                    style="color: red;">*</span>:- </strong>The
                                above mentioned information is true to the best of my knowledge and belief.(वर नमूद केलेली माहिती माझ्या माहितीनुसार आणि विश्वासानुसार खरी आहे).
                                <br><br>
                                <!-- <div class="note">
  <label class="note-label"><strong  style="color: red;">Note (नोंद):</strong>
  <span class="note-text">Upon completion of the site inspection, kindly provide a No Objection Certificate (NOC) for the tree cutting process.(साइटची तपासणी पूर्ण झाल्यावर, कृपया वृक्ष तोडण्याच्या प्रक्रियेसाठी ना हरकत प्रमाणपत्र (NOC) प्रदान करा.)</span>
</div>-->
                              
                            </label>
                            <div class="invalid-feedback">
                                Please check the declaration.
                            </div>
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
    <script>
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
                        onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveTreeCuting.do');
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

            data.append('idProof1', $("#city_survey").get(0).files[0]);

            data.append('idProof2', $("#city_survey1").get(0).files[0]);
            
            data.append('idProof3', $("#city_survey2").get(0).files[0]);
        
            data.append('idProof4', $("#city_survey3").get(0).files[0]);
            
            data.append('idProof5', $("#city_survey4").get(0).files[0]);

            data.append('idProof6', $("#city_survey5").get(0).files[0]);


            data.append('idProof7', $("#city_survey6").get(0).files[0]);


            data.append('idProof8', $("#city_survey7").get(0).files[0]);
            data.append('idProof9', $("#city_survey8").get(0).files[0]);
            data.append('idProof10', $("#city_survey9").get(0).files[0]);
            data.append('idProof11', $("#city_survey10").get(0).files[0]);
            

            
         


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
                    filesPath = filesPath + basePath + "TreeCutingApplication/" + id + value + ","
                    isFileSelected = true;
                }
            }
            $.ajax({
                url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadTreeCuting.do?id="+id,
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
            var fileUrl = "<c:out value="${contextRoot}"/>/pages/citizendocument/ZoneWardAndAreaDetails.pdf";
            var fileName = "ZoneWardAndAreaDetails.pdf";
            
            var downloadLink = document.createElement("a");
            downloadLink.href = fileUrl;
            downloadLink.download = fileName;
            document.body.appendChild(downloadLink);
            downloadLink.click();
            document.body.removeChild(downloadLink);
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

<script src="https://code.jquery.com/jquery-3.6.3.min.js"
	integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
	crossorigin="anonymous"></script>

</head>

<body>
	<form>
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


<li>1.Self Attested Applicant's Id Proof (स्वत: प्रमाणित अर्जदाराचा आयडी पुरावा)<span class="text-danger"  style="color: red;">*</span></li>
<li>2.Sanctioned plan with marking of Tree to be cut (कापल्या जाणाऱ्या वृक्षाचे चिन्हासह मंजूर आराखडा)</li>
<li>3.Photograph of tree(वृक्षाचे छायाचित्र)<span class="text-danger"  style="color: red;">*</span></li>
<li>4.No Objection Certificate (ना हरकत प्रमाणपत्र)<span class="text-danger">*</span> </li>

<li>5.Any Other Supporting document (इतर कोणतेही सहाय्यक दस्तावेज)</li>
<li>6.Approved Building Plan</li>
<li>7.Property Tax receipt</li>
<li>8.Property Record<li>
<b>If application comes through Government property, then following documents are required</b>
<li>9.Administrative Approval<li>
<li>10.Work order<li>
<li>11.Fund sanction letter</li>


                        </ul>

                    </div>

                    <!-- dialog buttons -->

                    <div class="modal-footer"><button type="button" class="btn btn-primary">OK</button></div>

                </div>

            </div>

        </div>
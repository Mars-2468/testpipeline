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


</head>

<body>

	<form class="needs-validation" novalidate>
		<div class="container-fluid mt-2" style="width: 180vh">
			<div class="printable">
				<h3 class="text-center">
					 Self  Assessment (स्वयंमुल्यांकन)

				</h3>
			</div>
			<hr class="custom-hr">
           <!-- 
           <h6 style="background-color:#dce2e8; padding:10px;" class="  rounded-2"><strong> Applicant Details </strong>
           </h6>
           <div class="row">
    <input type="hidden" name="_token" value="xyz">
    <div class="col-md-3">
    <div class="mb-3" style="margin-top: 23px;">
        <label for="upinNo" class="form-label lbleng">UPIN No. (UPIN क्र.)<span class="text-danger" style="color: red;">*</span></label>
        <input type="text" class="form-control" style="background-image: none;" id="upinNo" placeholder="" name="upinNo" value="" maxlength="10" required>
        <div class="invalid-feedback">Please Enter Valid UPIN No.</div>
    </div>
</div>
               <div class="col-md-3">
                   <div class="mb-3 mt-3">
                       <label for="" class="form-label lbleng">Title <span class="text-danger" >*</span>
                       </label>
                       
                       <select class="form-select" style="background-image: none;" name="appTitle" required>
                           <option value="">-Select-</option>
                                                      
                            <option value="1" >Mr (श्री)</option>
                            <option value="2" >Mrs (सौ)</option>
                            <option value="3" >Ms (कु)</option>
                                               </select>
                                               <div class="invalid-feedback">
                           Please Select Title.
                       </div>
                   </div>
               </div>
   
               <div class="col-md-3">
                <div class="mb-3 mt-3">
                    <label for="" class="form-label lbleng">First Name(पहिले नाव)<span class="text-danger" >*</span></label>
    
                    <input type="text" class="form-control" style="background-image: none;" id="first_name" placeholder="" name="firstName" value=""
                    pattern="[A-Za-z]+" onchange="Display(this.id)" required>
                    <div class="invalid-feedback">
                        Please Enter Valid First Name.
                    </div>
                </div>
            </div>
    
            <div class="col-md-3">
                <div class="mb-3 mt-3">
                    <label for="" class="form-label lbleng">Middle Name(मधले नाव)</label>
    
                    <input type="text" class="form-control" style="background-image: none;" id="middle_name" placeholder="" name="middleName" value=""
                    pattern="[A-Za-z]+" onchange="Display(this.id)">
                   
                        
                </div>
            </div>
    
            <div class="col-md-3">
                <div class="mb-3 mt-3">
                    <label for="" class="form-label lbleng">Last Name(आडनाव)<span class="text-danger" style="color: red;">*</span></label>
                    <input type="text" class="form-control" style="background-image: none;" name="lastName" id="last_name" value=""  pattern="[A-Za-z]+" onchange="Display(this.id)" required>
                    <div class="invalid-feedback">
                        Please Enter Valid Last Name.
                    </div>
                </div>
            </div>-->
                     <!--   <div class="row">
                                  <div class="row">
				<div class="col-md-3">
    <div class="mb-3 mt-4">
        <label for="upinNo" class="form-label lbleng">UPIN No. (UPIN क्र.)<span class="text-danger upin" style="color: red;">*</span></label>
        <input type="text" class="form-control" style="background-image: none;" id="upinNo" placeholder="" name="upinNo" value="" maxlength="14" required>
        <div class="invalid-feedback">Please Enter Valid UPIN No.</div>
    </div>
</div>

<div class="col-md-3">
    <div class="mb-3 mt-4">
        <label for="indexNo" class="form-label lbleng">Index No. (निर्देशांक क्र.)<span class="text-danger indexNo" style="color: red;">*</span></label>
        <input type="text" class="form-control" style="background-image: none;" id="indexNo" placeholder="" name="indexNo" value="" maxlength="14" required>
        <div class="invalid-feedback">Please Enter Valid Index No.</div>
    </div>
</div>
            <!-- <div class="col-md-3">
                <div class="mb-3 mt-3">
                    <label for="" class="form-label">Name(नाव) </label>
        <input type="text" class="form-control"
							style="background-image: none;" id="first_name" placeholder=""
							name="name" value="" maxlength="40" pattern="^[A-Za-z ]+$"
							readonly required>
                </div>
            </div>
    
         -->


             <!--   <script>
                function Display(id) {
                              $('#full_name').val( $('#first_name').val()+" "+ $('#middle_name').val()+" "+ $('#last_name').val())
                        }
                </script>

 
				<div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Plot/Flat No (प्लॉट/फ्लॅट क्र)<span class="text-danger" style="color: red;"">*</span></label>
                    <input type=" text" class="form-control" pattern="^\s*\S.*$" maxlength="80"style="background-image: none;" id="plot_no" placeholder="" name="plotNo" value=""
                                    required>
                                    <div class="invalid-feedback">
                                        Please Enter Valid Plot/Flat No.
                                    </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Name of the Building (इमारतीचे नाव)</label>
                            <input type=" text" class="form-control" style="background-image: none;" maxlength="80" id="building_name" placeholder=""
                                name="buildingName" value="">
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Name of the Street(रस्त्याचे नाव)</label>
                    <input type=" text" class="form-control" style="background-image: none;" maxlength="80" id="street_name" placeholder="" name="streetName"
                                    value="">
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Name of the Area(क्षेत्राचे नाव) <span class="text-danger"
                                    style="color: red;"">*</span></label>
                    <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" maxlength="80" name="areaName" value=""
                                   required>
                                   <div class="invalid-feedback">
                                    Please Enter Valid Name of the Area.
                                </div>
                        </div>
                    </div>

                   

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Near by Landmark(लँडमार्क जवळ)</label>
                            <input type=" text" class="form-control" maxlength="80" style="background-image: none;" id="landmark" placeholder="" name="landmark"
                                value="">
                        </div>
                    </div>
                    
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label lbleng">Pin Code(पिन कोड) <span class="text-danger" >*</span></label>
                            
                            <input type="text" class="form-control" style="background-image: none;" pattern="^(?!0{6}$)\d{6}$" name="pincode" value=""
                                        maxlength="6" required>
                                        <div class="invalid-feedback">
                                Please Enter Valid Pin Code.
                            </div>
                                
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label"> Aadhaar No.(आधार क्र.)
                            </label>
                            <input type="text" class="form-control " style="background-image: none;" id="aadhaarNumber1" placeholder="" name="aadhaarNo" value=""
                               pattern="(?!0{12}$)[0-9]{12}"
                                maxlength="12">
                                <div class="invalid-feedback">
                                Please Enter Valid Aadhaar No.
                            </div>
                        </div>
                    </div>-->
               <!--       <div class="col-md-3">
                            <div class="mb-3 mt-3">
                                
                            <label for="email"  class="form-label lbleng"> Email Id(
ई - मेल आयडी) <span class="text-danger" >*</span> </label>
<input type="email" class="form-control"
							style="background-image: none;" name="emailid" value="" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}" required>
					
                            <div class="invalid-feedback">
                                Please Enter Valid Email Id.
                            </div>
                        </div>
                    </div>
                     -->
                                    
                   <!--  <div class="col-md-3">
                        <div class="mb-3 mt-4">
                            <label for="" class="form-label"> Mobile No.(मोबाईल क्र.).<span class="text-danger"
                                    style="color: red;">*</span>
                            </label>
                            <input type="text" class="form-control"
							style="background-image: none;" id="txtMobileNumber"
							placeholder="" name="mobileNo" value=""
							pattern="[6-9]{1}[0-9]{9}" maxlength="10" required>
                           
                             <div class="invalid-feedback">
                                Please Enter Valid Mobile No.
                            </div>
                        </div>
                    </div>   -->
                    
        
                              <!--  <div class="col-md-12">
                            <div class="mb-3 mt-3">
                                <label for="" class="form-label ">Address For Correspondence (पत्रव्यवहारासाठी पत्ता)<span class="mand_error" style="color: red;"">*</span></label>
                                <textarea oninput="validateTextarea()" type=" text" maxlength="255" class="form-control"  style="background-image: none;" id="myTextarea" placeholder="" name="correspondenceAddress" value="" rows="2" required></textarea>                           
                                <div class="invalid-feedback" id="errorFeedback">
                                    Please Enter Valid Address.
                                </div>
                            </div>
                        </div>

<script>
function validateTextarea() {
  const textarea = document.getElementById('myTextarea');
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
                <br>

        <h6 style="background-color:#dce2e8; padding:10px;" class=" mt-3 rounded-2"><strong> Application Form Details</strong></h6>
		<div class="row">-->
           <!--  <div class="col-md-3">
            <div class="mb-3 mt-0">
                <label for="" class="form-label"> Name of Property
							Holders/Occupants (मालमत्ताधारक/ भोगवटादारांचे नाव)</label>
                <input type="text" class="form-control"
				  		style="background-image: none;" id="propertyHolderName" name="propertyHolderName" value=""
						 maxlength="255"  readonly>
                 <div class="invalid-feedback">
                     Please Enter Valid input.
                 </div>
            </div>
        </div>
       <div class="col-md-3">
					<div class="mb-3 mt-4">
						<label for="" class="form-label lbleng">Zone No. (झोन
							क्र.)<span class="text-danger" style="color: red;">*</span>
						</label>
						 <input type="text" class="form-control"
				  		style="background-image: none;" class="form-select " style="background-image: none;"
							id="zoneNo" name="zoneNo" required readonly>
						<div class="invalid-feedback">Please Enter Valid Zone No.</div>
					</div>
				</div>



<div class="col-md-3">
    <div class="mb-3" style="margin-top: 23px;">
        <label for="upinNo" class="form-label lbleng">Ward No. (प्रभाग क्र.)<span class="text-danger" style="color: red;">*</span></label>
        <input type="text" class="form-control" style="background-image: none;" id="blockNo" placeholder="" name="blockNo" value="" maxlength="10" required readonly>
        <div class="invalid-feedback">Please Enter Valid Block No.</div>
    </div>
</div>


<div class="col-md-3">
    <div class="mb-3" style="margin-top: 23px;">
        <label for="upinNo" class="form-label lbleng">Ward Name (प्रभाग नाव)<span class="text-danger" style="color: red;">*</span></label>
        <input type="text" class="form-control" style="background-image: none;" id="blockName" placeholder="" name="blockName" value="" maxlength="10" required readonly>
        <div class="invalid-feedback">Please Enter Valid BLock Name.</div>
    </div>
</div>

			<!-- 	<div class="col-md-3 hospital_row" id="hos">
					<div class="mb-3 mt-4">
						<label for="" class="form-label"> Ward No. (प्रभाग क्र.) <span
							class="text-danger" style="color: red;">*</span></label> <select
							class="form-select " style="background-image: none;"
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

				</div>
        -->
          <!--  <div class="col-md-3">
                <div class="mb-3 mt-3">
                    <label for="" class="form-label lbleng">Name of Area(क्षेत्राचे नाव)</label>
                    
                    <input type="text" class="form-control" style="background-image: none;" id="" maxlength="80" placeholder="" name="areaName" value="">
                </div>
            </div>
			<div class="col-md-3">
                <div class="mb-3 mt-3">
                    <label for="" class="form-label lbleng">House No.(घर क्र)<span class="text-danger" style="color: red;" >*</span></label>

                    <input type="text" class="form-control" style="background-image: none;" id="" pattern="^\s*\S.*$" maxlength="80"placeholder="" name="houseNo" value="" required>
                    <div class="invalid-feedback">
                        Please Enter Valid House No.
                    </div>
                </div>
            </div>
			<div class="col-md-3">
                <div class="mb-3 mt-3">
                    <label for="" class="form-label lbleng">Index No.(निर्देशांक क्र.)</label>

                    <input type="text" class="form-control" style="background-image: none;"pattern="^\s*\S.*$" id="" maxlength="80" placeholder="" name="indexNo" value="">
                </div>
            </div>
			
			<div class="col-md-3">
                <div class="mb-3 mt-3">
                    <label for="" class="form-label lbleng">Updated Name(अपडेट केलेले नाव)<span class="text-danger" style="color: red;" >*</span></label>
                    
    
                            <input type="text" class="form-control" style="background-image: none;"pattern="^\s*\S.*$" maxlength="80" name="updatedName" value=""
                            pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" required>
                                <div class="invalid-feedback">
                            Please Enter Valid Updated Name.
                        </div>
                        </div>
                    </div>
                    
			<div class="col-md-3">
                <div class="mb-3 mt-3">
                    <label for="" class="form-label lbleng">UPIN No(UPIN क्र).<span class="text-danger" style="color: red;" >*</span></label>

                    <input type="text" class="form-control" style="background-image: none;"pattern="^\s*\S.*$" id="" maxlength="80"placeholder="" name="upinNo" value="" required>
                    <div class="invalid-feedback">
                        Please Enter Valid UPIN No.
                    </div>
                </div>
            </div>
            <div class="row">

                <h6 style="background-color:white; padding:5px;" class="mt-1 rounded-2"><strong> List of Documents (with
                        attachment) </strong></h6>
                <div class="alert alert-info mb-2 p-2 mb-4">
                    <small><strong>Note: </strong> Upload below files only .pdf(Max upto 2
                        MB)</small>
                </div>-->






<!-- <div class="col-md-3">
    <div class="mb-3" style="margin-top: 23px;">
        <label for="upinNo" class="form-label lbleng">Pin Code (पिन कोड)<span class="text-danger" style="color: red;">*</span></label>
        <input type="text" class="form-control" style="background-image: none;" id="taxPincode" placeholder="" name="taxPincode" value="" maxlength="10" required readonly>
        <div class="invalid-feedback">Please Enter Valid Pin Code.</div>
    </div>
</div>

<div class="col-md-3">
    <div class="mb-3" style="margin-top: 23px;">
        <label for="upinNo" class="form-label lbleng">Pending Dues (प्रलंबित थकबाकी)<span class="text-danger" style="color: red;">*</span></label>
        <input type="text" class="form-control" style="background-image: none;" id="dues" placeholder="" name="duesAmt" value="" maxlength="10" required readonly>
        <div class="invalid-feedback">Please Enter Valid Dues Amount.</div>
    </div>
</div>
<div class="col-md-3">
    <div class="mb-3" style="margin-top: 23px;">
        <label for="upinNo" class="form-label lbleng">Owner Name (मालकाचे नाव)<span class="text-danger" style="color: red;">*</span></label>
        <input type="text" class="form-control" style="background-image: none;" id="ownerName" placeholder="" name="ownerName" value="" maxlength="10" required readonly>
        <div class="invalid-feedback">Please Enter Valid Owner Name.</div>
    </div>
</div>


<div class="col-md-12">
					<div class="mb-3 mt-3 ">
						<label for="primary_full_address" class="form-label lbleng">Address(पत्ता)<span
							class="text-danger">*</span>
						</label>

						<textarea class="form-control " rows="2" id="address"
							style="background-image: none;" name="address"  maxlength="80" required readonly></textarea>
						<div class="invalid-feedback" id="errorFeedback">Please Enter Valid Address.</div>

					</div>
				</div>








<!-- New Fields -->






<!-- <div class="col-md-3">
    <div class="mb-3" style="margin-top: px;">
        <label for="upinNo" class="form-label lbleng">Registered Mobile Number (नोंदणीकृत मोबाईल क्रमांक)<span class="text-danger" style="color: red;">*</span></label>
        <input type="text" class="form-control" style="background-image: none;" id="taxMobileNo" placeholder="" name="taxMobileNo" value="" maxlength="10" required readonly>
        <div class="invalid-feedback">Please Enter Valid Registered Mobile Number.</div>
    </div>
</div>

<div class="col-md-3">
    <div class="mb-3" style="margin-top: 23px;">
        <label for="upinNo" class="form-label lbleng">Arrears in Rs.(थकबाकी रु.)<span class="text-danger" style="color: red;">*</span></label>
        <input type="number" class="form-control" style="background-image: none;" id="areasPending" placeholder="" name="areasPending" value="" maxlength="10" required readonly>
        <div class="invalid-feedback">Please Enter Valid Arrears.</div>
    </div>
</div>


<div class="col-md-3">
    <div class="mb-3" style="margin-top: 23px;">
        <label for="upinNo" class="form-label lbleng">Arrears Status (थकबाकी स्थिती)<span class="text-danger" style="color: red;">*</span></label>
        <input type="text" class="form-control" style="background-image: none;" id="areasPendingStatus" placeholder="" name="areasPendingStatus" value="" maxlength="10" required readonly>
        <div class="invalid-feedback">Please Enter Valid Arrears Status.</div>
    </div>
</div>

<div class="col-md-3" id="payTaxButton">
    <div class="mb-3" style="margin-top: 50px;">
        <a href="https://geocivicnmcapp.nmcptax.com/CitizenServices/CitizenTax/index.html" class="pay-now-button" target="_blank">Pay Your Tax</a>
    </div>
</div>


<!-- new field -->
<!-- </div>
<a class="fa fa-download" onClick="downloadFile()" style="color: blue; font-size: medium;">&nbsp;&nbsp;Click here to know your ward.</a>
				</div>-->



<br>
<!-- END -->
<div class="container">
    <div class="" style="margin-left:330px;">
        <div class="col-md-3">
            <div class="card text-center" style="background-color: #f0f8ff; border: 2px solid #4682b4; border-radius: 10px; padding: 20px; width: 400px; margin-top:20px;">
                <p class="mt-2 mb-0" style="font-family: 'Trebuchet MS', sans-serif; background-color: #e0ffff; border: 2px solid #87ceeb; border-radius: 10px; padding: 20px; font-style: italic;">
                    <i class="fa fa-download" style="color: #4d4dff; font-size: 2em;"></i>&nbsp;&nbsp;&nbsp;&nbsp;Calculate Your Tax
                </p>
                <button class="btn btn-primary mt-3" onClick="downloadFile()" style="background-color: #4d4dff; border-color: #4d4dff;">Download</button>
            </div>
        </div>
    </div>
</div>


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
</script>
			 -->	

		
			<!-- 
			<div class="row">
					<div class="">
											<br>
				
					<strong style="color: red;">Note (नोंद): </strong> Upload below file
						only .pdf(Max upto 2 MB) (खाली फक्त .pdf फाइल अपलोड करा (कमाल २ MB
						पर्यंत))
				</div><input type="hidden" name="filesPath" id="filesPath" />
			<div class="col-md-3">
                <div class="mb-3" style="margin-top:40px;">
                    <label for="" class="form-label lbleng">Applicant's Id Proof(अर्जदाराचा आयडी पुरावा)<span
                            class="text-danger" style="color: red;"  >*</span></label>

                    <input type="file" class="form-control" style="background-image: none;"  id="doc1" placeholder="" name="applicantsIdProof" required>
                    <div class="invalid-feedback">
                        File selected is either greater than 2Mb or not of type .pdf.
                    </div>
                </div>
            </div>
			<div class="col-md-3">
                <div class="mb-3" style="margin-top:40px;">
                    <label for="" class="form-label">Copy of Registered Sale Deed(नोंदणीकृत विक्री कराराची प्रत)<span class="text-danger"
                            style="color: red;">*</span> 
</label>
                    <input type="file" class="form-control" style="background-image: none;"  id="doc2" placeholder=""
                         name="saleDeed" required>
                         <div class="invalid-feedback">
                            File selected is either greater than 2Mb or not of type .pdf.
                        </div>
                        
                </div>
            </div>
			
			<div class="col-md-3">
                <div class="mb-3 mt-3" >
                    <label for="" class="form-label lbleng">Akhiva Patrika of City Land Survey Department(नगर भूमापन विभागाची आखीवा पत्रिका)<span
                            class="text-danger" style="color: red;"  >*</span></label>

                    <input type="file" class="form-control" style="background-image: none;"  id="doc3" placeholder="" name="akhivaPatrika" required>
                    <div class="invalid-feedback">
                        File selected is either greater than 2Mb or not of type .pdf.
                    </div>
                </div>
            </div>
			<div class="col-md-3">
                <div class="mb-3" style="margin-top:40px;">
                    <label for="" class="form-label lbleng">APplicant Id Proof---Self Attested Applicant's Id Proof (स्वत: प्रमाणित अर्जदाराचा आयडी पुरावा)</label>


                    <input type="file" class="form-control" style="background-image: none;"  id="doc4" placeholder="" name="signatureOfapplicant">
                </div>

            </div>
			<div class="col-md-3">
                <div class="mb-3 mt-4">
                    <label for="" class="form-label">Gift Deed, Partition Deed, Inheritance Document, NIT/Nazul/Lease of Municipal Corporation Document(गिफ्ट डीड, पार्टीशन डीड, वारसा दस्तऐवज, एनआयटी/नझुल/महापालिकेचा भाडेपट्टा दस्तऐवज)</label>
                    <input type="file" class="form-control" style="background-image: none;"  name="GiftDeed" id="doc5" placeholder="">
                       
                </div>
            </div>
			</div>

						<hr class="custom-hr">


				<div class="col-md-12">
					<div class="mb-5 mt-4 ">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" id="check11"
								name="declaration" value="something" required> <label
								class="form-check-label ms-3 lbleng" style="margin-top: -1px;">
								<strong>Declaration (घोषणा)<span class="text-danger"
									style="color: red;">*</span>:-
							</strong>The above mentioned information is true to the best of my
								knowledge and belief. (वर नमूद केलेली माहिती माझ्या माहितीनुसार
								आणि विश्वासानुसार खरी आहे).
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
		</div>
	</form>
-->

</div>
	<input type="hidden" name="blockId" id="blockId" value="" />

</form>
</body>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
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
<script src="https://code.jquery.com/jquery-3.6.3.min.js"
	integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
	crossorigin="anonymous"></script>
	<script type="text/javascript">
$('.printMe').on('click', function () {

    window.print();
});
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
               		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/savePropertySelfAssessment.do');
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
            // data.append('idProof4', $("#doc4").get(0).files[0]);
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
                    filesPath = filesPath + basePath + "PropertyTaxSelfAssessment/" + id + value + ","
                    isFileSelected = true;
                }
            }
            $.ajax({
                url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadPropertyTaxSelfAssessment.do?id="+id,
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
                    async: false,
                    success: function (data) {
                    	var status = data.status;
             		    if(status===true || status === 'true'){
                    	$("#upinNo").val(data.ptn);
                    	$("#indexNo").val(data.indexNo);
                    	$("#address").val(data.address);
                    	$("#blockNo").val(data.wardNo);
                    	$("#blockId").val(data.blockNo);
                    	$("#blockName").val(data.blockname);
                    	$("#ownerName").val(data.ownerName);
                    	$("#areasPending").val(data.arreaspending);
                    	$("#areasPendingStatus").val(data.areaspaymentstatus);
                    	$("#dues").val(data.DueAmount);
                    	$("#taxMobileNo").val(data.mobileNo);
                    	$("#taxPincode").val(data.pincode);
                    	$("#propertyHolderName").val(data.occupierName);
                    	$("#zoneNo").val(data.zone);
                    	chkdues(data.DueAmount,data.arreaspending);

                    	//ward();

             		    }else{
                            alert("Record Not Found! Please Enter Valid UPIN No.");
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
    </script>
    <script>

    
    
    function downloadFile() {
        var fileUrl = "<c:out value="${contextRoot}"/>/pages/citizendocument/SelfAssessment_Calculator.xlsx";
        var fileName = "SelfAssessment_Calculator.xlsx";
        var downloadLink = document.createElement("a");
        downloadLink.href = fileUrl;
        downloadLink.download = fileName;
        document.body.appendChild(downloadLink);
        downloadLink.click();
        document.body.removeChild(downloadLink);
    }
</script>
    <script>
$("#payTaxButton").hide();

function chkdues(dues, arreas) {
    if (parseInt(dues) > 0 || parseInt(arreas) > 0) {
        $("#payTaxButton").show();
    } else {
        $("#payTaxButton").hide();
    }
}
</script>
    
</html>
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
<script type="text/javascript">
function Display(id) {
            $('#full_name').val($('#first_name').val() + " " + $('#middle_name').val() + " " + $('#last_name').val())
        }


  
</script>

</head>
<body>

    <form class="needs-validation" novalidate>
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

                        <h6><strong>Note(नोंद): </strong> Upload below files in .pdf...Max upto 5 MB(खालील फाइल .pdf मध्ये अपलोड करा..कमाल ५ MB पर्यंत)</h6>

                    </div>

                    <!-- dialog body -->

                    <div class="modal-body" style="color:green">



                      <p style="color:red">

                        <strong>List of document to be attached :
                        </strong>    
                        </p>

                        <ul style="color:rgb(3, 125, 76)">




  <ul>
 <li>1. Self Attested Applicant's Id Proof (स्वत: प्रमाणित अर्जदाराचा आयडी पुरावा)<span class="text-danger" style="color: red;">*</span></li>
    <li>2. ID Card of Ex-Servicemen /Widows of Ex-Servicemen And Wife (माजी सैनिक / <br>माजी सैनिकाच्या पत्नी/ विधवा यांचे ओळखपत्र)<span class="text-danger" style="color: red;">*</span></li>
    <li>3. Photocopy of Identity Card of Government Recognized Ex-Servicemen Organization or District Sainik Kalyan from the Office.(शासकीय मान्यताप्राप्त माजी सैनिक संघटना किंवा जिल्हा सैनिक कल्याण कार्यालयातुन ओळखपत्राची छायाप्रत)<span class="text-danger" style="color: red;">*</span></li>
    <li>4. Charity Commissioner's Office Registration Certificate(धर्मदाय आयुक्त कार्यालयाचे नोंदणी प्रमाणपत्र)<span class="text-danger" style="color: red;">*</span></li>
    <li>5. Audit Report of Three years preceding the date of application(अर्जाच्या तारखेच्या आधीच्या तीन वर्षांचा लेखापरीक्षण अहवाल)<span class="text-danger" style="color: red;">*</span></li>
<!--     <li>6. Certificate of Surviving from Competent Authority (सक्षम प्राधिकाऱ्याकडून हयात असल्याचे प्रमाणपत्र)<span class="text-danger" style="color: red;">*</span></li>
 -->    <li>6. Any other Supporting document (इतर कोणतेही सहाय्यक दस्तावेज)</li>
</ul>

                        </ul>

                    </div>

                    <!-- dialog buttons -->

                    <div class="modal-footer"><button type="button" class="btn btn-primary">OK</button></div>

                </div>

            </div>

        </div>
		<div class="container-fluid mt-2" style="width: 180vh">
           <div class="printable">
               <h3 class="text-center">Exemption in Tax (कर माफी मिळणे)	</h3>
           </div>
<hr class="custom-hr">

      <!--  <h6 style="background-color:#dce2e8; padding:10px;" class="  rounded-2"><strong> Applicant Details </strong>
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
                       <!--<div class="col-md-3">

                        <div class="col-md-3">
    <div class="mb-3" style="margin-top: 23px;">
        <label for="upinNo" class="form-label lbleng">UPIN No. (UPIN क्र.)<span class="text-danger" style="color: red;">*</span></label>
        <input type="text" class="form-control" style="background-image: none;" id="upinNo" placeholder="" name="upinNo" value="" maxlength="10" required>
        <div class="invalid-feedback">Please Enter Valid UPIN No.</div>
    </div>
</div>
                           <div class="mb-3 mt-3">
                               <label for="" class="form-label lbleng">Title <span class="text-danger" >*</span>
                               </label>
                               
                               <select class="form-select" style="background-image: none;"  name="title" required>
                                   <option value="">-Select-</option>
                                                              
							<option value="Mr.(श्री.)">Mr.(श्री.)</option>
							<option value="Mrs.(सौ.)">Mrs.(सौ.)</option>
							<option value="Ms.(कु.)">Ms.(कु.)</option>
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
                         maxlength="40"   pattern="[A-Za-z]+" onchange="Display(this.id)" required>
                            <div class="invalid-feedback">
                                Please Enter Valid First Name.
                            </div>
                        </div>
                    </div>
            
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label lbleng">Middle Name(मधले नाव)</label>
            
                            <input type="text" class="form-control" style="background-image: none;"  id="middle_name" placeholder="" name="middleName" value=""
                       maxlength="40"     pattern="[A-Za-z]+" onchange="Display(this.id)">
                           
                                
                        </div>
                    </div>
            
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label lbleng">Last Name(आडनाव)<span class="text-danger" style="color: red;">*</span></label>
                            <input type="text" class="form-control" style="background-image: none;"  name="lastName" id="last_name" value=""  maxlength="40" pattern="[A-Za-z]+" onchange="Display(this.id)" required>
                            <div class="invalid-feedback">
                                Please Enter Valid Last Name.
                            </div>
                        </div>
                    </div>-->
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
</div>
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label">Applicant's Name (अर्जदाराचे नाव)<span class="text-danger" >*</span> </label>
                <input type="text" class="form-control"
							style="background-image: none;" id="first_name" placeholder=""
							name="name" value="" maxlength="40" pattern="^[A-Za-z ]+$"
							 required>
                        </div>
                    </div>
            
                  
                        
                        
        

                
				<!-- <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Plot/ Flat No.(प्लॉट/फ्लॅट क्र.) <span class="text-danger" style="color: red;"">*</span></label>
                    <input type=" number" class="form-control" style="background-image: none;" id="plot_no" placeholder="" name="plotNo" value=""
                            pattern="^\s*\S.*$"   maxlength="80"      required>
                                    <div class="invalid-feedback">
                                        Please Enter Valid Plot/Flat No
                                    </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Name of the Building(इमारतीचे नाव) </label>
                            <input type="text" pattern="^\s*\S.*$" class="form-control" style="background-image: none;" maxlength="80"  id="buildingName" placeholder=""
                                name="buildingName" value="">
                        </div>
                    </div>

                    
                              <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Name of the Street(रस्त्याचे नाव) <span class="text-danger" style="color: red;"">*</span></label>
                    <input type="text" class="form-control"  pattern="^\s*\S.*$" style="background-image: none;"maxlength="80"  id="street_name" placeholder="" name="streetName" value=""
                                  required>
                                    <div class="invalid-feedback">
                                        Please Enter Valid Name of the Street
                                    </div>
                        </div>
                    </div>
                   

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Near by Landmark(लँडमार्क जवळ)</label>
                            <input type="text" class="form-control" style="background-image: none;"maxlength="80"  id="landmark" placeholder="" pattern="^\s*\S.*$" name="landmark"
                                value="">
                        </div>
                    </div>
                    
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label lbleng">Pin Code (पिन कोड)<span class="text-danger" >*</span></label>
                            
                            <input type="text" class="form-control" style="background-image: none;"  pattern="^(?!0{6}$)\d{6}$" name="pincode" value=""
                                        maxlength="6" required>
                                        <div class="invalid-feedback">
                                Please Enter Valid Pin Code.
                            </div>
                                
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label"> Aadhaar No.(आधार क्र)
                            </label>
                            <input type="text" class="form-control " style="background-image: none;"  id="aadhaarNumber1" placeholder="" name="aadhaarNo" value=""
                               pattern="(?!0{12}$)[0-9]{12}"
                                maxlength="12">
                                <div class="invalid-feedback">
                                Please Enter Aadhaar No.
                            </div>
                        </div>
                    </div>-->
                     <div class="col-md-3">
                            <div class="mb-3 mt-3">
                                
                            <label for="email"  class="form-label lbleng">Applicant's Mail ID (अर्जदाराचा मेल आयडी)<span class="text-danger" >*</span> </label>
                          <input type="email" class="form-control"
							style="background-image: none;" name="emailid" value="" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}" required>
					  
                            <div class="invalid-feedback">
                                Please Enter Valid Email Id.
                            </div>
                        </div>
                    </div>
                    
                                    
                    <div class="col-md-3">
                        <div class="mb-3" style="margin-top:23px;">
                            <label for="" class="form-label">Applicant's Mobile No.(अर्जदाराचा मोबाईल क्र)<span class="text-danger"
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
                    </div>  
                    
        
  		                <!--   <div class="col-md-12">
                            <div class="mb-3 mt-3">
                                <label for="" class="form-label ">Address For Correspondence (पत्रव्यवहारासाठी पत्ता)<span class="mand_error" style="color: red;"">*</span></label>
                                <textarea oninput="validateTextarea()" type="text" maxlength="255" class="form-control"  style="background-image: none;" id="myTextarea" placeholder="" name="address" value="" rows="2" required></textarea>                           
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
         <h6 style="background-color:#dce2e8; padding:10px;" class="  rounded-2"><strong>Application Form Details 
            </strong>
            
        </h6>


        <div class="row">
        

        <div class="col-md-6">
            <div class="mb-3 mt-3 ">
                <label for="" class="form-label lbleng" > Exemption Regarding (बाबत सूट)
 <span class="text-danger" style="color: red;">*</span> </label>
                <select class="form-select" style="background-image: none;" name="exemptionRegarding" id="exemption_regarding" required>
                    <option value="">-Select-</option>
                    <option value="Ex-Servicemen/Widows of Ex-Servicemen And Dependents of Ex-Servicemen">Ex-Servicemen/Widows of Ex-Servicemen And Dependents of Ex-Servicemen
                    </option>
                    <option value="Charitable Trust / Institutions">Charitable Trust / Institutions
                    </option>
                                       
                </select>
                <div class="invalid-feedback">
                    Please Select Valid Exemption Regarding 
                    </div>
            </div>
        </div>-->
     <div class="col-md-3">
            <div class="mb-3 mt-4">
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
					<div class="mb-3 mt-5">
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
    <div class="mb-3 mt-5">
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






<div class="col-md-3">
    <div class="mb-3" style="margin-top: 23px;">
        <label for="upinNo" class="form-label lbleng">Pin Code (पिन कोड)<span class="text-danger" style="color: red;">*</span></label>
        <input type="text" class="form-control" style="background-image: none;" id="taxPincode" placeholder="" name="taxPincode" value="" maxlength="10" required readonly>
        <div class="invalid-feedback">Please Enter Valid Pincode.</div>
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



<div class="col-md-3">
    <div class="mb-3" style="margin-top: 23px;">
        <label for="upinNo" class="form-label lbleng">Owner Name (मालकाचे नाव)<span class="text-danger" style="color: red;">*</span></label>
        <input type="text" class="form-control" style="background-image: none;" id="ownerName" placeholder="" name="ownerName" value="" maxlength="10" required readonly>
        <div class="invalid-feedback">Please Enter Valid Owner Name.</div>
    </div>
</div>


<div class="col-md-3">
    <div class="mb-3" style="margin-top: px;">
        <label for="upinNo" class="form-label lbleng">Registered Mobile Number (नोंदणीकृत मोबाईल क्रमांक)<span class="text-danger" style="color: red;">*</span></label>
        <input type="text" class="form-control" style="background-image: none;" id="taxMobileNo" placeholder="" name="taxMobileNo" value="" maxlength="10" required>
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


<div class="col-md-3">
    <div class="mb-3" style="margin-top: 23px;">
        <label for="upinNo" class="form-label lbleng">Pending Dues (प्रलंबित थकबाकी)<span class="text-danger" style="color: red;">*</span></label>
        <input type="text" class="form-control" style="background-image: none;" id="dues" placeholder="" name="duesAmt" value="" maxlength="10" required readonly>
        <div class="invalid-feedback">Please Enter Valid Dues Amount.</div>
    </div>
</div>

<div class="col-md-3" id="payTaxButton">
    <div class="mb-3" style="margin-top: 50px;">
        <a href="https://geocivicnmcapp.nmcptax.com/CitizenServices/CitizenTax/index.html" class="pay-now-button" target="_blank">Pay Your Tax</a>
    </div>
</div>

    <div class="col-md-5">
					<div class="mb-3 mt-4">
						<label for="primary_full_address" class="form-label lbleng">Reason(कारण)<span
							class="text-danger">*</span>
						</label>

						<input class="form-control "  id="reason"
							style="background-image: none;" name="reason"  maxlength="70" required   />
						<div class="invalid-feedback" id="errorFeedback">Please Enter Valid Reason.</div>

					</div>
				</div>


<!-- END -->



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
				

<div class="row">
        

        <div class="col-md-6">
            <div class="mb-3 mt-3">
                <label for="" class="form-label lbleng" > Exemption Regarding (कर सूट संबंधित)<span class="text-danger"
                                    style="color: red;">*</span></label>
                <select class="form-select" name="exemptionRegarding" style="background-image: none;" onchange="showForm();" id="exemption_regarding" required>
                    <option value="">-Select-</option>
                    <option value="Ex-Servicemen/Widows of Ex-Servicemen And Dependents of Ex-Servicemen">Ex-Servicemen/Widows of Ex-Servicemen And Dependents of Ex-Servicemen
                    </option>
                    <option value="Charitable Trust / Institutions">Charitable Trust / Institutions
                    </option>
                                       
                </select>
            </div>
        </div>
         <div class="col-md-3" id="b1" >
            <div class="mb-3 mt-3">
                <label for="" class="form-label lbleng">Medal no. (पदक क्र.) </label>
                <input type="text" class="form-control "  placeholder="" style="background-image: none;" name="medalNo" value="">
                    
            </div>
        </div>

        

    

        <div class="col-md-3" id="b2">
            <div class="mb-3 mt-3">
                <label for="" class="form-label lbleng">Army no. (लष्कर क्र.)</label>
                <input type="text" class="form-control "  style="background-image: none;" placeholder="" name="armyNo" value="" >
                    
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
</script> -->


<!-- 
        <div class="col-md-3">
					<div class="mb-3" style="margin-top: 25px;">
						<label for="" class="form-label lbleng">UPIN No. (UPIN
							क्र.)<span
							class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="upinNo" placeholder=""
					 		name="upinNo" value=""  maxlength="10"required>
						<div class="invalid-feedback">Please Enter Valid UPIN No.</div>
					</div>
				</div>
    <div class="col-md-3">
        <div class="mb-3" style="margin-top: 25px;">
            <label for="indexNo" class="form-label lbleng">Index No. (निर्देशांक क्र.)</label> 
            <input type="text" class="form-control" style="background-image: none;" id="indexNo" placeholder="" name="indexNo" value="" maxlength="10">
            <div class="invalid-feedback">Please Enter Valid Index No.</div>
        </div>
    </div>
<script>
    function validateInput(inputId, minLength, maxLength) {
        var input = document.getElementById(inputId);
        var inputValue = input.value;

        var alphanumericRegex = /^[A-Za-z0-9]+$/;

        if (inputValue.trim() === '' || (alphanumericRegex.test(inputValue) && inputValue.length >= minLength && inputValue.length <= maxLength)) {
            input.classList.remove("is-invalid");
        } else {
            input.classList.add("is-invalid");
        }
    }

    var upinNoInput = document.getElementById("upinNo");
    var indexNoInput = document.getElementById("indexNo");

    upinNoInput.addEventListener("blur", function() {
        validateInput("upinNo", 10, 10); 
    });

    indexNoInput.addEventListener("blur", function() {
        validateInput("indexNo", 10, 10); 
    });
</script>-->
				

		</div>
		
			<br>
			<hr class="custom-hr">
			
			<div class="row">
       <!-- 
        <div class="col-md-3">
					<div class="mb-3 ></div> style="margin-top:80px;">
						<label for="" class="form-label lbleng">Index No.
							(निर्देशांक क्र.)<span
							class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control"
						style="background-image: none;" id="" placeholder="" pattern="^\s*\S.*$"
							name="indexNo" value=""  maxlength="80"required>
						
					</div>
				</div>
       
        <div class="col-md-3">
            <div class="mb-3 ">
                <label for="" class="form-label lbleng">UPIN No.(UPIN क्र.)<span class="text-danger" style="color: red;">*</span> </label>
                <input type="text" class="form-control " maxlength="80" pattern="^\s*\S.*$" style="background-image: none;" id="" placeholder="" name="upinNo" value="" required>
                <div class="invalid-feedback">
                        Please Enter Valid UPIN No.
                    </div>   
            </div>
        </div>


        <div class="col-md-3">
            <div class="mb-3 mt-3">
                <label for="primary_middle_name" class="form-label lbleng">Name of the Area(क्षेत्राचे नाव)
                </label>
                <input type="text" class="form-control " style="background-image: none;" id="" placeholder="" name="areaName" pattern="^\s*\S.*$" value="" >
            </div>
        </div>



        <div class="col-md-3" id="b1" >
            <div class="mb-3 mt-3">
                <label for="" class="form-label lbleng">Medal no.(पदक क्र)</label>
                <input type="text" class="form-control " style="background-image: none;" placeholder="" name="medalNo"  pattern="^\s*\S.*$" value="">
                    
            </div>
        </div>

        

    

        <div class="col-md-3" id="b2">
            <div class="mb-3 mt-3">
                <label for="" class="form-label lbleng">Army no.(लष्कर क्र)</label>
                <input type="text" class="form-control " style="background-image: none;" placeholder="" name="armyNo" pattern="^\s*\S.*$" value="" >
                    
            </div>
        </div>

       
        </div>
        
       



            <div class="row">

                <h6 class="mt-4"><strong> List Of Documents(दस्तऐवजांची यादी) (with attachment) </strong></h6>


                <div class="alert alert-info mb-0 p-2 mb-4 ms-2" >
                    <small><strong>Note: </strong> Upload below files only
							.pdf(Max upto 2 MB) (खाली फक्त .pdf फाइल अपलोड करा (कमाल २ MB
						पर्यंत))</small>
                </div>-->
                <div class="">
											<br>
				
					<strong style="color: red;">Note (नोंद): </strong> Upload below file
						only .pdf(Max upto 5 MB) (खाली फक्त .pdf फाइल अपलोड करा (कमाल ५ MB
						पर्यंत))
				</div>
				<br>
				<br>
				<br>
                					<input type="hidden" name="filesPath" id="filesPath" />
                
                
				<div class="col-md-3">
                 <div class="mb-3 mt-4 self">
                    <label for="" class="form-label">Self Attested Applicant's Id Proof (स्वत: प्रमाणित अर्जदाराचा आयडी पुरावा)<span class="text-danger"
                            style="color: red;">*</span> 
</label>
                    <input type="file" class="form-control" style="background-image: none;" id="id" placeholder=""
                         name="applnIdProof" accept=".pdf" required>
                         <div class="invalid-feedback">
                        File selected is either greater than 5Mb or not of type .pdf.
                    </div>
                        
                </div>
            </div>
<!-- <div  class="col-md-3" id="a3">
               <div class="mb-0 " style="margin-top: 45px;">
                        <label for="" class="form-label">Property Tax Payment Receipt(मालमत्ता कर भरणा पावती) </label>
                        <input type="file" class="form-control" style="background-image: none;" id="id1" placeholder=""
                            name="taxReceipt" accept=".pdf">
                            <div class="invalid-feedback">
                        File selected is either greater than 2Mb or not of type .pdf.
                    </div>
                      </div>
                </div> -->
                

                <!-- <div class="col-md-3" id="a2">
                     <div class="mb-3 mt-" style="margin-top: 20px;">
                        <label for="" class="form-label">Certificate of Shourya Medal (Attested Copy)(शौर्य पदकाचे प्रमाणपत्र (साक्षांकित प्रत))

                           </label>
                        <input type="file" class="form-control" style="background-image: none;" id="id2" placeholder=""
                            name="medalCerti" accept=".pdf">
                            <div class="invalid-feedback">
                        File selected is either greater than 2Mb or not of type .pdf.
                    </div>
                                         </div>
                </div> -->
   <!-- <div class="col-md-3" id="a4">
                 <div class="mb-3 mt-" style="margin-top: 19px;">
                    <label for="" class="form-label">First Page of Discharge Book and Copy of Family Statement.(डिस्चार्ज बुकचे पहिले पान आणि कौटुंबिक स्टेटमेंटची प्रत.)<span
                                class="text-danger" style="color: red;">*</span> </label>
                             
                  </label>
                    <input type="file" class="form-control" style="background-image: none;" id="id3" placeholder=""
                        name="dischargeBook" accept=".pdf"
                        required>
                        <div class="invalid-feedback">
                        File selected is either greater than 2Mb or not of type .pdf.
                    </div>
                </div>
            </div>-->

                 <div class="col-md-3" id="a1" >
                    <div class="mb-3">
                        <label for="" class="form-label">ID Card of Ex-Servicemen /Widows of Ex-Servicemen And Wife (माजी सैनिक / <br>माजी सैनिकाच्या पत्नी/ विधवा यांचे ओळखपत्र)
                            <span
                                class="text-danger" style="color: red;">*</span> </label>
                        <input type="file" class="form-control" style="background-image: none;" id="id4"
                            placeholder=""
                            name="exServiceId" accept=".pdf" required>
                            <div class="invalid-feedback">
                        File selected is either greater than 5Mb or not of type .pdf.
                    </div>
                    </div>
                </div>
            
         
            <div  class="col-md-4" id="a5">
                <div class="mb-3" style="margin-top:-23px;">
                    <label for="" class="form-label">Photocopy of Identity Card of Government Recognized Ex-Servicemen Organization or District Sainik Kalyan from the Office.(शासकीय मान्यताप्राप्त माजी सैनिक संघटना किंवा जिल्हा सैनिक कल्याण कार्यालयातील ओळखपत्राची छायाप्रत) 
                 
                        <span class="text-danger"
                            style="color: red;">*</span> </label>
                    <input type="file" class="form-control" style="background-image: none;" id="id5" placeholder=""
                        name="govId" accept=".pdf"
                        required>
                        <div class="invalid-feedback">
                        File selected is either greater than 5Mb or not of type .pdf.
                    </div>
                </div>
            </div>

           <!--  <div class="col-md-3 post_mortem" id="a6">
                <div class="mb-0 " style="margin-top: 65px;">
                    <label for="" class="form-label ">Certificate of survival from local corporator every year(
स्थानिक नगरसेवकाकडून दरवर्षी हयातीचा दाखला)<span class="text-danger" style="color: red;"
                            for="pos">*</span></label>

                    <input type="file" class="form-control" style="background-image: none;" name="survivalCerti" id="id6" placeholder=""
                    accept=".pdf" required>
                        <div class="invalid-feedback">
                        File selected is either greater than 2Mb or not of type .pdf.
                    </div>
                </div>
            </div> -->
       
            <div class="col-md-3" id="a7">
                <div class="mb-3" style="margin-top: 25px;">
                    <label for="" class="form-label">Charity Commissioner's Office Registration Certificate(धर्मदाय आयुक्त कार्यालयाचे नोंदणी प्रमाणपत्र)
 
                 
                        <span class="text-danger"
                            style="color: red;">*</span> </label>
                    <input type="file" class="form-control" style="background-image: none;" id="id7" placeholder=""
                       name="charityCommision" accept=".pdf"
                        required>
                        <div class="invalid-feedback">
                        File selected is either greater than 5Mb or not of type .pdf.
                    </div>
                </div>
            </div>

            <div class="col-md-3" id="a8">
                <div class="mb-3" style="margin-top: 2px;">
                    <label for="" class="form-label">Audit Report of Three years preceding the date of application(अर्जाच्या तारखेच्या आधीच्या तीन वर्षांचा लेखापरीक्षण अहवाल)
                        <span class="text-danger"
                            style="color: red;">*</span> </label>
                    <input type="file" class="form-control" style="background-image: none;" id="id8" name="auditReport" placeholder="" accept=".pdf" required>
                    <div class="invalid-feedback">
                        File selected is either greater than 5Mb or not of type .pdf.
                    </div>
                </div>
            </div>


					<!--  <div class="col-md-3" id="a8">
                <div class="mb-3 surviving">
                    <label for="" class="form-label">Certificate of Surviving from Competent Authority (सक्षम प्राधिकाऱ्याकडून हयात असल्याचे प्रमाणपत्र)
                        <span class="text-danger"
                            style="color: red;">*</span> </label>
                    <input type="file" class="form-control" style="background-image: none;" id="id9" name="auditReport" placeholder="" accept=".pdf" required>
                    <div class="invalid-feedback">
                        File selected is either greater than 5Mb or not of type .pdf.
                    </div>
                </div>
            </div> -->

					<script>
         function showForm() {
        	    var exemptionvalue = document.getElementById("exemption_regarding").value;
        	    var divElement = document.querySelector(".mb-3.surviving");
        	    var divElement2 = document.querySelector(".mb-3.supporting");
        	    var divElement3 = document.querySelector(".mb-3.self");
        	    divElement.classList.add('mt-4');
    	        divElement2.classList.add('mt-5');
        	    if (exemptionvalue === "Ex-Servicemen/Widows of Ex-Servicemen And Dependents of Ex-Servicemen") {
        	        divElement.style.marginTop = "63px";
        	        divElement2.style.marginTop = "88px";
        	        divElement3.classList.add('mt-5');
        	        $("#id4").attr("required", true);
        		    $("#id5").attr("required", true);
        	    } else if (exemptionvalue === "Charitable Trust / Institutions") {
        	        divElement.style.marginTop = "";
        	        divElement2.style.marginTop = "";
        	        divElement2.classList.add('mt-3');
        	        
        	    	$("#id4").attr("required", false);
          	       $("#id5").attr("required", false);
        	    } else {
        	        divElement.classList.add('mt-4');
        	        divElement2.classList.add('mt-5');
        	    }
        	}


         $(document).ready(function() {
     	    var exemptionvalue = document.getElementById("exemption_regarding").value;
        	 if (exemptionvalue === "Ex-Servicemen/Widows of Ex-Servicemen And Dependents of Ex-Servicemen") {
        		 $("#id4").attr("required", true);
        		    $("#id5").attr("required", true);
     	    } else if (exemptionvalue === "Charitable Trust / Institutions") {
     	    	$("#id4").attr("required", false);
     	       $("#id5").attr("required", false);
     	    }
        	});

</script>
            
             <div class="col-md-3" id="a8">
                <div class="mb-3 mt-4 supporting">
                    <label for="" class="form-label">Any other Supporting document (इतर कोणतेही सहाय्यक दस्तावेज)
                        </label>
                    <input type="file" class="form-control" style="background-image: none;" id="id10" name="auditReport" placeholder="" accept=".pdf">
                    <div class="invalid-feedback">
                        File selected is either greater than 5Mb or not of type .pdf.
                    </div>
                </div>
            </div>
            

            

    										<hr class="custom-hr">
    
            


            <div class="col-md-12">
                <div class="mb-3 mt-4">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="check1" name="declaration" value="something"
                            required>

                       <label
								class="form-check-label ms-3 lbleng" style="margin-top: 0px;">
								<strong>Declaration (घोषणा)<span class="text-danger"
									style="color: red;">*</span>:-
							</strong>The above mentioned information is true to the best of my
								knowledge and belief (वर नमूद केलेली माहिती माझ्या माहितीनुसार
								आणि विश्वासानुसार खरी आहे).
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
 >Submit</button>
				</div>
			</div>

            </div>
				<input type="hidden" name="blockId" id="blockId" value="" />
		        <input type="hidden" name="propertyId" id="propertyId" value="" />
				
			
                   </form>
				   </div>
				   </div>
                
</body>
<script type="text/javascript">
$('.printMe').on('click', function () {

    window.print();
});
</script>
<script>
    function a(event) {
        var char = event.which;
        if (char > 31 && char != 32 && (char < 65 || char > 90) && (char < 97 || char > 123)) {
            return false;
        }
    }
</script>


<script>

    $("#a11").hide();
    $("#a22").hide();
    $("#a1").hide();
    $("#a2").hide();
    $("#a3").hide();
    $("#a4").hide();
    $("#a5").hide();
    $("#a6").hide();
    $("#a7").hide();
    $("#a8").hide();
    $("#a9").hide();
    $("#b1").hide();
    $("#b2").hide();

    var tax = jQuery('#exemption_regarding');
    var select = this.value;
	//function showHide(value) {
         
    tax.change(function () {
        if ((this).value == 'Ex-Servicemen/Widows of Ex-Servicemen And Dependents of Ex-Servicemen') {
            $("#a11").show();
    $("#a22").show();
        
    $("#a1").show();
    $("#a2").show();
    $("#a3").show();
     $("#a4").show();
    $("#a5").show();
    $("#a6").show();
	$("#a7").hide();
     $("#a8").hide();
   
    $("#a9").hide();
	$("#b1").show();
    $("#b2").show();

    $("#id4").prop('required',true);
    $("#id5").prop('required',true);
    $("#id").prop('required',true);
    $("#id8").prop('required',false);
    $("#id7").prop('required',false);
		}
		else if (this.value == 'Charitable Trust / Institutions') {
			$("#a11").show();
			$("#a22").show();
			 $("#a7").show();
			$("#a8").show();

     $("#a1").hide();
    $("#a2").hide();
    $("#a3").hide();
     $("#a4").hide();
    $("#a5").hide();
    $("#a6").hide();
    
    $("#a9").hide();
	$("#b1").hide();
    $("#b2").hide();
    
    $("#id8").prop('required',true);
    $("#id7").prop('required',true);
    $("#id").prop('required',true);
    $("#id4").prop('required',false);
    $("#id5").prop('required',false);
		}
		 else {
			$("#a11").show();
			$("#a22").show();
      $("#a9").show();   
    
	$("#a1").hide();
    $("#a2").hide();
    $("#a3").hide();
    $("#a4").hide();
    $("#a5").hide();
    $("#a6").hide();
    $("#a7").hide();
    $("#a8").hide();
	$("#b1").hide();
    $("#b2").hide();
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
                   	upload(function(status) {
                   	    if (status === true || status === 'true') {
               		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveTaxExemption.do');
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

            data.append('idProof1', $("#id").get(0).files[0]);
            //data.append('idProof2', $("#id1").get(0).files[0]);
            //data.append('idProof3', $("#id2").get(0).files[0]);
            //data.append('idProof4', $("#id3").get(0).files[0]);
            data.append('idProof5', $("#id4").get(0).files[0]);
            data.append('idProof6', $("#id5").get(0).files[0]);
            //data.append('idProof5', $("#id6").get(0).files[0]);
            data.append('idProof7', $("#id7").get(0).files[0]);
            data.append('idProof8', $("#id8").get(0).files[0]);
           // data.append('idProof9', $("#id9").get(0).files[0]);
            data.append('idProof10', $("#id10").get(0).files[0]);



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
                    filesPath = filesPath + basePath + "propertyTaxExemption/" + id + value + ","
                    isFileSelected = true;
                }
            }
            $.ajax({
                url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadPropertyTaxExemtion.do?id="+id,
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
                    	 var a = filesPath.substring(0, filesPath.lastIndexOf(","));
                         filesPath = filesPath.replace(/\s/g, "");
                         $("#filesPath").val(filesPath);
                         console.log(filesPath);
                    	callback(status);
                    }
                }
            });

           

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
                    //async: false,
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
                    	$("#propertyId").val(data.propertyId);
                    	chkdues(data.DueAmount,data.arreaspending);
                    	ward();

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
                        	$("#propertyId").val("");
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
                    	$("#propertyId").val("");

                    }
                        
                });
            });
        });
        
        
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


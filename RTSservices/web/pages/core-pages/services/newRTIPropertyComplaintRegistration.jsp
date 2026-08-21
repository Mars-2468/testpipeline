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
 <script type="text/javascript" src="<c:out value=" ${contextRoot}" />/scripts/jquery/jquery.ajaxfileupload.js"></script>
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

<script>

    card_number.addEventListener('keyup',function (e) {
      // console.log(e.keyCode);
      if (e.keyCode !== 8) {
        if (this.value.length === 4 || this.value.length === 9 || this.value.length === 14) {
          this.value = this.value += ' ';
        }
      }
    });
       
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

                        <h6><strong>Note(नोंद): </strong> Upload below files in .pdf...Max upto 2 MB(खालील फाइल .pdf मध्ये अपलोड करा..कमाल २ MB पर्यंत)</h6>

                    </div>

                    <!-- dialog body -->

                    <div class="modal-body" style="color:green">



                      <p style="color:red">

                        <strong>List of document to be attached :
                        </strong>    
                        </p>

                        <ul style="color:rgb(3, 125, 76)">




                                                  
<li>1. Self Attested Applicant's Id Proof (स्वत: प्रमाणित अर्जदाराचा आयडी पुरावा)<span class="text-danger" style="color: red;">*</span></li>
	<li>2. No Dues Certificate (नाहरकत प्रमाणपत्र)<span class="text-danger" style="color: red;">*</span></li>
    <li>3. Copy Of Sale Deed/Award Deed/Partition 
     Deed/Will/Succession Deed/Deed of 
    Surrender/NIT/Nazul/Lease of Municipal Corporation
     Document (विक्री करारनामा/अवार्ड डीड/पार्टीशन  
    डीड/विल/उत्तराधिकार डीड/पार्टिशन  
     डीड/एनआयटी/नझूल/महापालिका दस्तावेजाची लीजची प्रत)
     <li>4. Upload Relevant Document (संबंधित दस्तऐवज अपलोड करा)         <span class="text-danger" style="color: red;">*</span> </li>
    </li>
                        </ul>

                    </div>

                    <!-- dialog buttons -->

                    <div class="modal-footer"><button type="button" class="btn btn-primary">OK</button></div>

                </div>

            </div>

        </div>
		<div class="container-fluid mt-2" style="width: 180vh">
           <div class="printable">
               <h3 class="text-center"> Property Objection Registration  <br>(मालमत्ता आक्षेप नोंदविणे)	</h3>
           </div>
<hr class="custom-hr">

     <!--    <h6 style="background-color:#dce2e8; padding:10px;" class="  rounded-2"><strong> Applicant Details </strong>
        </h6>-->
        <div class="row">
            <input type="hidden" name="_token" value="xyz">
                          
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
                    <label for="" class="form-label lbleng">Applicant's Name (अर्जदाराचे नाव)<span class="text-danger" >*</span></label>
    
                    <input type="text" class="form-control" style="background-image: none;" id="first_name" placeholder="" name="fullName" value="" 
maxlength="40" pattern="^[A-Za-z ]+$"
							  required>                    <div class="invalid-feedback">
                        Please Enter Valid Name.
                    </div>
                </div>
            </div>
    
          <!--   <div class="col-md-3">
                <div class="mb-3 mt-3">
                    <label for="" class="form-label lbleng">Middle Name (मधले नाव)</label>
    
                    <input type="text" class="form-control" style="background-image: none;" id="middle_name" placeholder="" name="middleName" value=""
                    pattern="[A-Za-z]+" onchange="Display(this.id)">
                    <div class="invalid-feedback">
                        Please Enter Valid Last Name.
                    </div>
                        
                </div>
            </div>
    
            <div class="col-md-3">
                <div class="mb-3 mt-3">
                    <label for="" class="form-label lbleng">Last Name (आडनाव)<span class="text-danger" style="color: red;">*</span></label>
                    <input type="text" class="form-control" style="background-image: none;" name="lastName" id="last_name" value=""  pattern="[A-Za-z]+" onchange="Display(this.id)" required>
                    <div class="invalid-feedback">
                        Please Enter Valid Last Name.
                    </div>
                </div>
            </div>
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label">Full Name (पूर्ण नाव)</label>
                
                            <input type="text" class="form-control" style="background-image: none;" id="full_name" placeholder="" name="fullName" value="" readonly>
                        </div>
                    </div>
            
            
                    <script>
                        function Display(id) {
                                      $('#full_name').val( $('#first_name').val()+" "+ $('#middle_name').val()+" "+ $('#last_name').val())
                                }
                        </script>            
        

                
				<div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Plot/ Flat No.(प्लॉट/फ्लॅट क्र) <span class="text-danger" style="color: red;"">*</span></label>
                    <input type=" number" class="form-control" style="background-image: none;" id="plot_no" placeholder="" name="plotNo" value=""
                                    required>
                                    <div class="invalid-feedback">
                                        Please Enter Valid Plot/Flat No.
                                    </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Name of the Building (इमारतीचे नाव)</label>
                            <input type=" text" class="form-control" style="background-image: none;" id="buildingName" placeholder=""
                                name="buildingName" value="">
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Name of the Street (रस्त्याचे नाव )</label>
                    <input type=" text" class="form-control" style="background-image: none;" id="street_name" placeholder="" name="streetName"
                                    value="">
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Name of the Area (क्षेत्राचे नाव)<span class="text-danger"
                                    style="color: red;"">*</span></label>
                    <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="areaName" value=""
                                   required>
                                   <div class="invalid-feedback">
                                    Please Enter Valid Name of the Area.
                                </div>
                        </div>
                    </div>

                   

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Near by Landmark (लँडमार्क जवळ)</label>
                            <input type=" text" class="form-control" style="background-image: none;"  id="landmark" placeholder="" name="landmark"
                                value="">
                        </div>
                 </div>
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label lbleng">Pin Code (िन कोड)<span class="text-danger" >*</span></label>
                            
                            <input type="text" class="form-control" style="background-image: none;" pattern="[0-9]{6}" name="pincode" value=""
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
                            <input type="text" class="form-control " style="background-image: none;" id="aadhaarNumber1" placeholder="" name="adhaarNo" value=""
                               pattern="[0-9]{12}"
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
							style="background-image: none;" name="emailId" value="" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}"  required>
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
                            <input type="text" class="form-control " style="background-image: none;" id="txtMobileNumber" placeholder="" name="mobileNo"  value=""
                            pattern="[6-9]{1}[0-9]{9}"
                                maxlength="10" required>
                             <div class="invalid-feedback">
                                Please Enter Valid Mobile No.
                            </div>
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
                  
                    
        

               <!--  <div class="col-md-12">
                    <div class="mb-3 mt-3 ">
                        <label for="primary_full_address" class="form-label lbleng">Address For Correspondence (पत्रव्यवहारासाठी पत्ता)<span class="text-danger" >*</span></label>
    
                        <textarea class="form-control " style="background-image: none;" rows="2" id="" name="addressForCorrespondence" required></textarea>
                        <div class="invalid-feedback">
                            Please Enter Valid Address.
                        </div>
    
                    </div>
                </div>
         <br>



    


          

        <h6 style="background-color:#dce2e8; padding:10px;" class="  rounded-2"><strong> Applicantion Form  Details (अर्जाचा तपशील)</strong>
        </h6>
        <div class="row ">-->
       <!-- <div class="col-md-3">
            <div class="mb-3 mt-0">
                <label for="" class="form-label"> Name of Property Holders/Occupants (मालमत्ताधारक/ भोगवटादारांचे नाव) </label>
<input type="text" class="form-control"
				  		style="background-image: none;" name="holdersName" value=""
						 maxlength="255" pattern="^[A-Za-z ]+$">                 <div class="invalid-feedback">
                    Please Enter Valid Name of Property Holders/Occupants.
                </div>
            </div>
        </div>-->
                </div>


          <!--  <div class="col-md-3">
                <div class="mb-3 mt-3">
                    <label for="" class="form-label"> House/Plot No.(घर क्र.)<span class="text-danger"
                            style="color: red;">*</span> </label>

                    <input type="text" class="form-control" style="background-image: none;" id="" placeholder="" name="houseNo" value=""
                        required>
                        <div class="invalid-feedback">
                            Please Enter Valid House/Plot No.
                        </div>
                </div>
            </div>-->
            							<div class="row">
            
          				<!-- <div class="col-md-3">
					<div class="mb-3 mt-3">
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


				<div class="col-md-3 hospital_row" id="hos">
					<div class="mb-3 mt-3">
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
    </script>-->
<div class="col-md-3">
    <div class="mb-3 mt-5">
        <label for="indexNo" class="form-label lbleng">Objection Remarks. (आक्षेपाची टिप्पणी)<span class="text-danger" style="color: red;">*</span></label>
        <input type="text" class="form-control" style="background-image: none;" id="objectionRemarks" placeholder="" name="objectionRemarks" value="" maxlength="10" required>
        <div class="invalid-feedback">Please Enter Valid Objection Remarks</div>
    </div>
</div>
<div class="col-md-3">
    <div class="mb-3 mt-2">
        <label for="indexNo" class="form-label lbleng">Built Up Area (निर्मित क्षेत्र.)<span class="text-danger upin" style="color: red;">*</span></label>
        <p id="area1">&nbsp;</p>
        <input type="text" class="form-control" style="background-image: none;" id="builtUpArea" placeholder=""  pattern="^[0-9.]+$" onchange="note();" name="builtUpArea" value="" maxlength="10" required>
        <div class="invalid-feedback">Please Enter Valid BuiltUp Area</div>
    </div>
</div>

<div class="col-md-3">
    <div class="mb-3 mt-2">
        <label for="indexNo" class="form-label lbleng">NTB (नवीन निर्मित क्षेत्र)<span class="text-danger upin" style="color: red;">*</span></label>
        <p id="oldntb1">&nbsp;</p>
        <select class="form-select" id="ntb" style="background-image: none;" onchange="note();" name="ntb" required>
            <option value="" selected>Select NTB </option>
           
        </select>
        <div class="invalid-feedback">Please Enter Valid NTB.</div>
    </div>
</div>

<div class="col-md-3">
    <div class="mb-3 mt-2">
        <label for="factorUsage" class="form-label lbleng">Usage Factor (वापर घटक)<span class="text-danger upin" style="color: red;">*</span></label>
        <p id="oldfactorusage1">&nbsp;</p>
                <select class="form-select" id="factorUsage" style="background-image: none;" onchange="note();" name="factorUsage" required>
        <option value="" selected>Select Usage Factor</option>
        </select>
        <div class="invalid-feedback">Please Enter Valid Factor Usage</div>
    </div>
</div>
<div class="col-md-3">
    <div class="mb-3" style="margin-top: 18px;">
        <label for="ageFactor" class="form-label lbleng">Age Factor (वय कारक)<span class="text-danger upin" style="color: red;">*</span></label>
        <p id="oldagefactor1"> &nbsp;</p>
        <select class="form-select" id="ageFactor" style="background-image: none;" onchange="note();" name="ageFactor" required>
            <option value="" selected>Select Age Factor</option>
           
        </select>
        <div class="invalid-feedback">Please Enter Valid Age Factor</div>
    </div>
</div>


<div class="col-md-3">
					<div class="mb-3" style="margin-top: 55px;">
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
					<div class="mb-3" style="margin-top: 55px;">
						<label for="primary_full_address" class="form-label lbleng">Reason(कारण)<span
							class="text-danger">*</span>
						</label>

						<input class="form-control "  id="reason"
							style="background-image: none;" name="reason"  maxlength="70" required   />
						<div class="invalid-feedback" id="errorFeedback">Please Enter Valid Reason.</div>

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
</script> --><!-- 
     <div class="col-md-3">
                <div class="mb-4 mt-3">
                    <label for="" class="form-label"> UPIN No.(UPIN क्र)<span class="text-danger"
                            style="color: red;">*</span></label>
                    <input type="text" class="form-control " style="background-image: none;"  id="upinNo" placeholder="" name="upinNo" value="" 
                                 required>
                    <div class="invalid-feedback">
                        Please Enter Valid UPIN No.
                    </div>   
                </div>
            </div>
    
            <div class="col-md-3">
                <div class="mb-4 mt-3">
                    <label for="" class="form-label lbleng">Index No.
							(निर्देशांक क्र.)</label> <input type="text" class="form-control"
							style="background-image: none;" id="indexNo" placeholder=""
						maxlength="80"	name="indexNo"  value="" >
						<div class="invalid-feedback">Please Enter Valid Index No.</div>
                </div>
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
</script> -->

           <!--  <div class="col-md-3">
                <div class="mb-3 mt-2">
                    <label for="" class="form-label "> Area of Property (मालमत्तेचे क्षेत्रफळ)<span class="text-danger"
                            style="color: red;">*</span>
                    </label>

                    <input type="text" class="form-control" style="background-image: none;" id="" placeholder="" name="propertyArea" value=""
                        required>
                        <div class="invalid-feedback">
                            Please Enter Valid Area of Property.
                        </div>
                </div>
            </div>


            <div class="col-md-3">
                <div class="mb-3 mt-2">
                    <label for="" class="form-label">Property Type (मालमत्तेचा प्रकार)
                    </label>
                    <select class="form-select" style="background-image: none;" name="propertyType">
                        <option value="">-Select-</option>
                        <option value="1">Open Plot</option>
                        <option value="2">Building</option>
                        
                         
                    </select>
                </div>
            </div>






            

            <div class="col-md-3">
                <div class="mb-3" style="margin:top=10px">
                    <label for="" class="form-label ">Built Up Area of Ground Floor/Construction Area (तळमजला/बांधकाम क्षेत्राचा बिल्ट अप एरिया)
                    </label>

                    <input type="text" class="form-control" style="background-image: none;" id="" placeholder="" name="builtArea" value="">
                        
                </div>
            </div>

                					<input type="hidden" name="filesPath" id="filesPath" />

            
            <div class="col-md-3">
                <div class="mb-3 mt-4">
                    <label for="" class="form-label ">Use of the Building (इमारतीचा वापर)</label>

                    <input type="text" class="form-control" style="background-image: none;" id="" placeholder="" name="buildingUse" value="">
                        
                </div>
            </div>

            <div class="col-md-12">
                <div class="mb-3 mt-2">
                    <label for="" class="form-label">Property Address (मालमत्तेचा पत्ता)<span class="text-danger"
                            style="color: red;">*</span></label>
    
                    <textarea class="form-control " style="background-image: none;" rows="2" name="propertyAddress" required></textarea>
                    <div class="invalid-feedback">
                        Please Enter Valid Property Address.
                    </div>
                </div>
            </div>



           
            

        </div>


        <div class="row">

                <h6 style="background-color:white; padding:10px;" class="mt-3 rounded-2"><strong> List of Documents (with attachment)(दस्तऐवजांची यादी (संलग्नकांसह)) </strong></h6>


            <div class="alert alert-info mb-0 p-2 mb-4 ms-2">
                <small><strong>Note: </strong> Upload Below Files only .pdf(Max upto 2MB) </small>
            </div>-->
   
		<div class="">
					<hr class="custom-hr">
		
											<br>
				
					<strong style="color: red;">Note (नोंद): </strong> Upload below file
						only .pdf(Max upto 2 MB) (खाली फक्त .pdf फाइल अपलोड करा (कमाल २ MB
						पर्यंत))
				</div>
				
				<br>
				<br>
				<br>
				<br>
				<br>
				
				<input type="hidden" name="filesPath" id="filesPath" />
						<div class="row">
			
			<div class="col-md-3">
                <div class="mb-3 " style="margin-top: 95px;">
                    <label for="" class="form-label">Self Attested Applicant's Id Proof (स्वत: प्रमाणित अर्जदाराचा आयडी पुरावा)<span class="text-danger"
                            style="color: red;">*</span> 
</label>
                    <input type="file" class="form-control" style="background-image: none;" id="doc1" placeholder=""
                         name="applicantsIdProof" required>
                         <div class="invalid-feedback">
                            File selected is either greater than 2Mb or not of type .pdf
                        </div>  
                </div>
            </div>
            

            <div class="col-md-3">
                <div class="mb-3 " style="margin-top: 120px;">
                    <label for="" class="form-label">No Dues Certificate (नाहरकत प्रमाणपत्र)<span class="text-danger"
                            style="color: red;">*</span> </label>
                    <input type="file" class="form-control" style="background-image: none;" id="doc2" placeholder=""
                        name="noduesCertificate" required>
                        <div class="invalid-feedback">
                            File selected is either greater than 2Mb or not of type .pdf
                        </div>
                                       </div>
            </div>
            
             
           <!-- <div class="col-md-3">
                <div class="mb-3 " style="margin-top: 95px;">
                    <label for="" class="form-label">Signature of Applicant's (अर्जदाराची स्वाक्षरी)</label>
                    <input type="file" class="form-control" style="background-image: none;" id="doc3" placeholder=""
                        name="applicantSignature" >
                        <div class="invalid-feedback">
                            File selected is either greater than 2Mb or not of type .pdf
                        </div> 
                </div>
            </div>-->
			<div class="col-md-4">
                <div class="mb-1 mt-0">
                    <label for="" class="form-label">Copy Of Sale Deed/Award Deed/Partition 
     Deed/Will/Succession Deed/Deed of 
    Surrender/NIT/Nazul/Lease of Municipal Corporation
     Document (विक्री करारनामा/अवार्ड डीड/पार्टीशन  
    डीड/विल/उत्तराधिकार डीड/पार्टिशन  
     डीड/एनआयटी/नझूल/महापालिका दस्तावेजाची लीजची प्रत)</label>
                    <input type="file" class="form-control" style="background-image: none;" id="doc4" placeholder=""
                         name="partitionDeed" >
                         <div class="invalid-feedback">
                            File selected is either greater than 2Mb or not of type .pdf
                        </div>
                </div>
            </div>
            
            <div class="col-md-4">
                <div class="mb-3 mt-3">
                   <label for="" class="form-label">Upload Relevant Document of Selected (निवडलेल्यांचे संबंधित दस्तऐवज अपलोड करा)
<span id="note" class="text-lightblue" style="font-weight: lighter;"></span>
    <span class="text-danger" style="color: red;">*</span>
</label>

                    <input type="file" class="form-control" style="background-image: none;" id="doc5" placeholder=""
                        name="noduesCertificate" required>
                        <div class="invalid-feedback">
                            File selected is either greater than 2Mb or not of type .pdf
                        </div>
                                       </div>
            </div>
            
            						<hr class="custom-hr">
            
            <div class="col-md-12">
                <div class="mb-5 mt-4 ">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="check11" name="declaration"
                            value="something" required>

                        <label class="form-check-label ms-3 lbleng" style="margin-top: -1px;">
                            <strong>Declaration (घोषणा)<span class="text-danger" style="color: red;">*</span>:- </strong>The
                            above mentioned information is true to the best of my knowledge and belief. (वर नमूद केलेली माहिती माझ्या माहितीनुसार आणि विश्वासानुसार खरी आहे.)
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
					<button class="btn btn-success btn_sm" type="submit" id="submit">
					 Submit
					</button>
				</div>
			</div>
            </div>
        </div>
        <input type="hidden" name="oldntb" id="oldntb" value=""/>
        <input type="hidden" name="oldfactorUsage" id="oldfactorUsage" value=""/>
        <input type="hidden" name="oldageFactor" id="oldageFactor" value=""/>
        <input type="hidden" name="oldbuiltUpArea"id="oldbuiltUpArea"  value=""/>
        
          <input type="hidden" name="oldntbId" id="oldntbId" value=""/>
        <input type="hidden" name="oldfactorUsageId" id="oldfactorUsageId" value=""/>
        <input type="hidden" name="oldageFactorId" id="oldageFactorId" value=""/>
</form>
</body>
<script type="text/javascript">
$('.printMe').on('click', function () {

    window.print();
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
                     onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/savePropertyTaxComplaint.do');
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
            //data.append('idProof3', $("#doc3").get(0).files[0]);
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
                    filesPath = filesPath + basePath + "propertyComplaint/" + id + value + ","
                    isFileSelected = true;
                }
            }
            $.ajax({
                url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadDocumentPropertyComplaint.do?id="+id,
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
                    	/* $("#blockNo").val(data.blockNo);
                    	$("#blockName").val(data.blockname);
                    	$("#ownerName").val(data.ownerName);
                    	$("#areasPending").val(data.arreaspending);
                    	$("#areasPendingStatus").val(data.areaspaymentstatus);
                    	$("#total_demand").val(data.totalDemand);
                    	$("#taxMobileNo").val(data.mobileNo);
                    	$("#taxPincode").val(data.pincode);
                    	$("#propertyHolderName").val(data.occupierName); */
                    	$("#zoneNo").val(data.zone);
                    	         var ptn = $("#upinNo").val();
                    	        $.ajax({
                    	            url: "<c:out value='${contextRoot}'/>/rtsapplication/getPropertyMeasurementDetails.do?upinNo="+ptn,
                    	            method: "POST",
                    	            dataType: "json",
                    	            success: function(response) {
                    	                
                    	                if (response) {
                    	                    
                    	                    var oldageFactor = response.oldageFactor;
                    	                    var oldageFactorId = response.oldageFactorId;
                    	                    var oldntb = response.oldntb;
                    	                    var ntbId = response.oldntbId;
                    	                    var oldBuiltUpArea = response.oldbuiltUpArea;
                    	                    var oldusagefactor = response.oldfactorUsage;
                    	                    var oldusagefactorId = response.oldfactorUsageId;
                    	                    
                    	                    $("#oldntb").val(oldntb);
                    	                    $("#oldntbId").val(ntbId);
                    	                    $("#oldntb1").html("Existing : " + oldntb);

                    	                    
                    	                    $("#oldfactorUsage").val(oldusagefactor);
                    	                    $("#oldfactorUsageId").val(oldusagefactorId);
                    	                    $("#oldfactorusage1").html("Existing : " +oldusagefactor);
                    	                    
                    	                    $("#oldageFactor").val(oldusagefactor);
                    	                    $("#oldageFactorId").val(oldageFactorId);
                    	                    $("#oldagefactor1").html("Existing : " +oldusagefactor);
                    	                    
                    	                    $("#oldbuiltUpArea").val(oldBuiltUpArea);
                    	                    $("#area1").html("Existing : " +oldBuiltUpArea);
                    	                    //DropDownList
                    	                    $.ajax({
                                	            url: "<c:out value='${contextRoot}'/>/rtsapplication/getPropertyNtbList.do",
                                	            method: "POST",
                                	            dataType: "json",
                                	            success: function(response) {
                                	                
                                	                if (response) {
                                	                    
                                	                    var displayName = response.displayName;
                                	                    var Id = response.Id;
                                	                    
                                	                    populateDropdown(displayName,Id)

                                	                    $.ajax({
                                            	            url: "<c:out value='${contextRoot}'/>/rtsapplication/getPropertyAgeFactorList.do",
                                            	            method: "POST",
                                            	            dataType: "json",
                                            	            success: function(response) {
                                            	                
                                            	                if (response) {
                                            	                    
                                            	                    var displayName = response.displayName;
                                            	                    var Id = response.Id;
                                            	                    
                                            	                    populateAgeFactorDropdown(displayName,Id)
                                            	                    $.ajax({
                                                        	            url: "<c:out value='${contextRoot}'/>/rtsapplication/getPropertyUsageFactorList.do",
                                                        	            method: "POST",
                                                        	            dataType: "json",
                                                        	            success: function(response) {
                                                        	                
                                                        	                if (response) {
                                                        	                    
                                                        	                    var displayName = response.displayName;
                                                        	                    var Id = response.Id;
                                                        	                    
                                                        	                    populateUsageFactorDropdown(displayName,Id)

                                                        	                }
                                                        	            },
                                                        	            error: function(xhr, status, error) {
                                                        	                console.error("Error:", error);
                                                        	            }
                                                        	        });
                                            	                }
                                            	            },
                                            	            error: function(xhr, status, error) {
                                            	                console.error("Error:", error);
                                            	            }
                                            	        });
                                	                }
                                	            },
                                	            error: function(xhr, status, error) {
                                	                console.error("Error:", error);
                                	            }
                                	        });
                    	                    
                    	                }
                    	            },
                    	            error: function(xhr, status, error) {
                    	                console.error("Error:", error);
                    	            }
                    	        });

             		    }else{
                            alert("Record Not Found! Please Enter Valid UPIN No.");
             		    	$("#upinNo").val("");
                        	$("#indexNo").val("");
                        	$("#address").val("");
                        	/* $("#address").val("");
                        	$("#blockNo").val("");
                        	$("#blockName").val("");
                        	$("#ownerName").val("");
                        	$("#areasPending").val("");
                        	$("#areasPendingStatus").val("");
                        	$("#total_demand").val("");
                        	$("#taxMobileNo").val("");
                        	$("#taxPincode").val("");
                        	$("#propertyHolderName").val(""); */
                        	$("#zoneNo").val("");
             		    }


                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                        alert("Something went wrong!!");
                    	$("#upinNo").val("");
                    	$("#indexNo").val("");
                    	$("#address").val("");
                    	/* $("#address").val("");
                    	$("#blockNo").val("");
                    	$("#blockName").val("");
                    	$("#ownerName").val("");
                    	$("#areasPending").val("");
                    	$("#areasPendingStatus").val("");
                    	$("#total_demand").val("");
                    	$("#taxMobileNo").val("");
                    	$("#taxPincode").val("");
                    	$("#propertyHolderName").val(""); */
                    	$("#zoneNo").val("");


                    }
                        
                });
            });
        });

           
        function populateDropdown(displayNames,ids) {
            const dropdown = document.getElementById('ntb');

            dropdown.innerHTML = '';
            const selectOption = document.createElement('option');
            selectOption.value = '';
            selectOption.text = '-Select NTB-';
            dropdown.appendChild(selectOption);

            for (let i = 0; i < displayNames.length; i++) {
                const displayName = displayNames[i];
                const id = ids[i];

                const option = document.createElement('option');
                option.value = id;
                option.text = displayName;
                dropdown.appendChild(option);
            }
        }
        
        function populateAgeFactorDropdown(displayNames, ids) {
            const dropdown = document.getElementById('ageFactor');

            dropdown.innerHTML = '';
            const selectOption = document.createElement('option');
            selectOption.value = '';
            selectOption.text = '-Select Age Factor-';
            dropdown.appendChild(selectOption);

            for (let i = 0; i < displayNames.length; i++) {
                const displayName = displayNames[i];
                const id = ids[i];

                const option = document.createElement('option');
                option.value = id;
                option.text = displayName;
                dropdown.appendChild(option);
            }
        }
        
        
        function populateUsageFactorDropdown(displayNames,ids){
            const dropdown = document.getElementById('factorUsage');

            dropdown.innerHTML = '';
            const selectOption = document.createElement('option');
            selectOption.value = '';
            selectOption.text = '-Select Usage Factor-';
            dropdown.appendChild(selectOption);

            for (let i = 0; i < displayNames.length; i++) {
                const displayName = displayNames[i];
                const id = ids[i];

                const option = document.createElement('option');
                option.value = id;
                option.text = displayName;
                dropdown.appendChild(option);
            }
        }
 
        
    </script>
<script>
function note() {
    var resultArray = [];

    var builtUpAreaValue = $("#builtUpArea").val();
    if (builtUpAreaValue !== "") {
        resultArray.push("Built UpArea: "+builtUpAreaValue);
    }

    var ntbValue = $("#ntb option:selected").text();
    var factorUsageValue = $("#factorUsage option:selected").text();
    var ageFactorValue = $("#ageFactor option:selected").text();

    if (ntbValue) {
    	if(ntbValue!='-Select NTB-')
        resultArray.push("NTB: "+ntbValue);
    }
    if (factorUsageValue) {
    	if(factorUsageValue!='-Select Usage Factor-')
        resultArray.push("Usage Factor: "+factorUsageValue);
    }
    if (ageFactorValue) {
    	
    	if(ageFactorValue!='-Select Age Factor-')
        resultArray.push("Age Factor: "+ageFactorValue);
    }

    var result = '/('+resultArray.join(', ')+')';

    $("#note").html(result);
}
</script>

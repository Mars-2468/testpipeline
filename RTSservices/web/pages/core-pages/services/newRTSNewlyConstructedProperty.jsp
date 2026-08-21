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
String fname = (String) session.getAttribute("name");
String email = (String) session.getAttribute("email");
String number = (String) session.getAttribute("mobileNo");
pageContext.setAttribute("UPLOAD_PATH", CoreConstants.UPLOAD_PATH);

///pageContext.setAttribute("statusList", CommonUtils.getStatus());
%>


<style>

input::-webkit-outer-spin-button,
      input::-webkit-inner-spin-button {
        -webkit-appearance: none;
      }
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
            function Display(id) {
                $('#full_name').val($('#first_name').val() + " " + $('#middle_name').val() + " " + $('#last_name').val())
            }
        </script>
</head>

<body>


	<form>
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
<li>1. Copy of Registered Sale Deed (नोंदणीकृत विक्री कराराची प्रत)<span class="text-danger" style="color: red;">*</span></li>
    <li>2. Akhiv Patrika of City Land Survey Department (नगर भूमापन विभागाची आखीव पत्रिका)<span class="text-danger" style="color: red;">*</span></li>
    <li>3. Self Attested Applicant's Id Proof (स्वत: प्रमाणित अर्जदाराचा आयडी पुरावा)<span class="text-danger" style="color: red;">*</span></li>
    <li>4. Regularization Letter (RL) (नियमितीकरण पत्र (RL))</li>
    <li>5. Water Bill (पाणी बिल)</li>
    <li>6. Copy of Electric Bill (इलेक्ट्रिक बिलाची प्रत)<span class="text-danger" style="color: red;">*</span></li>
	
                        </ul>

                    </div>

                    <!-- dialog buttons -->

                    <div class="modal-footer"><button type="button" class="btn btn-primary">OK</button></div>

                </div>

            </div>

        </div>
		<div class="container-fluid mt-2" style="width: 180vh">
			<div class="printable">
				<h3 class="text-center">इमारत पाडण्यात आलेल्या मालमत्तेकरिता अद्यावत मालमत्ता कर आकारणी करणे</h3>
			</div>
			<hr class="custom-hr">
			
			<!-- <h6 style="background-color: #dce2e8; padding: 10px;"
				class="  rounded-2">
				<strong> Applicant Details (अर्जदाराचे तपशील)</strong>
			</h6>
			<div class="row">
				<input type="hidden" name="_token" value="xyz">
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
						<label for="" class="form-label lbleng">First Name (पहिले
							नाव)<span class="text-danger">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="first_name" placeholder=""
							name="firstName" value="" pattern="[A-Za-z]+"
							onchange="Display(this.id)" required>
						<div class="invalid-feedback">Please Enter Valid First Name.
						</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Middle Name (मधले
							नाव)</label> <input type="text" class="form-control"
							style="background-image: none;" id="middle_name" placeholder=""
							name="middleName" value="" pattern="[A-Za-z]+"
							onchange="Display(this.id)">
						<div class="invalid-feedback">Please Enter Valid Middle
							Name.</div>


					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Last Name (आडनाव)<span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control" style="background-image: none;"
							name="lastName" id="last_name" value="" pattern="[A-Za-z]+"
							onchange="Display(this.id)" required>
						<div class="invalid-feedback">Please Enter Valid Last Name.
						</div>
					</div>
				</div>-->
							<div class="row">
				
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
						<label for="" class="form-label">Applicant's Name (अर्जदाराचे नाव)<span class="text-danger">*</span></label>
						<input type="text" class="form-control"
							style="background-image: none;" id="first_name" placeholder=""
							name="fullName" value="" maxlength="40" pattern="^[A-Za-z ]+$"
							 required>
						
					</div>
				</div>

	<div class="col-md-3">
					<div class="mb-3 mt-3">

						<label for="email" class="form-label lbleng">Applicant's Mail ID (अर्जदाराचा मेल आयडी)<span class="text-danger">*</span>
						</label> 
						<input type="email" class="form-control"
							style="background-image: none;" name="email" value="" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}"  required>
					
							<div class="invalid-feedback">Please Enter Valid Email Id.</div>
					</div>
				</div>


				<div class="col-md-3">
					<div class="mb-3 mt-0">
						<label for="" class="form-label">Applicant's Mobile No.(अर्जदाराचा मोबाईल क्र)<span
							class="text-danger" style="color: red;">*</span>
						</label>
						<input type="text" class="form-control"
							style="background-image: none;" id="txtMobileNumber"
							placeholder="" name="mobileNo" value=""
							pattern="[6-9]{1}[0-9]{9}" maxlength="10" required>
					
						
						<div class="invalid-feedback">Please Enter Valid Mobile No.
						</div>
					</div>
					</div>
<div class="col-md-3">
					<div class="mb-3 mt-4">
						<label for="" class="form-label ">House No
							(घर क्र)<span class="text-danger" style="color: red;"">*</span>
						</label> <input type=" number" class="form-control"
							style="background-image: none;" id="houseNo" placeholder=""
							name="houseNo" value="" required readonly>
						<div class="invalid-feedback">Please Enter Valid House
							No.</div>
					</div>
				</div>
				
				
				<div class="col-md-3">
					<div class="mb-3 mt-4">
						<label for="" class="form-label ">Measle Number
							(गोवर क्र)
						</label> <input type=" number" class="form-control"
							style="background-image: none;" id="plot_no" placeholder=""
							name="measleNo" value="" >
						
					</div>
				</div>
				
				
				<div class="col-md-3">
					<div class="mb-3 mt-4">
						<label for="" class="form-label ">Land /Plot No
							(जमीन / भूखंड क्र)<span class="text-danger" style="color: red;"">*</span>
						</label> <input type=" number" class="form-control"
							style="background-image: none;" id="plot_no" placeholder=""
							name="plotNo" value="" required>
						<div class="invalid-feedback">Please Enter Valid Plot/Flat
							No.</div>
					</div>
				</div>

			<!-- 	<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label ">Name of the Building
							(इमारतीचे नाव)</label> <input type=" text" class="form-control"
							style="background-image: none;" id="building_name" placeholder=""
							name="buildingName" value="">
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label ">Name of the Street
							(रस्त्याचे नाव)</label> <input type=" text" class="form-control"
							style="background-image: none;" id="street_name" placeholder=""
							name="streetName" value="">
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label ">Name of the Area
							(क्षेत्राचे नाव)<span class="text-danger" style="color: red;"">*</span>
						</label> <input type=" text" class="form-control"
							style="background-image: none;" id="" placeholder=""
							name="areaName" value="" required>
						<div class="invalid-feedback">Please Enter Valid Name of the
							Area.</div>
					</div>
				</div>



				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label ">Near by Landmark
							(लँडमार्क जवळ)</label> <input type=" text" class="form-control"
							style="background-image: none;" id="landmark" placeholder=""
							name="landmark" value="">
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Pin Code (पिन कोड)<span
							class="text-danger">*</span></label> <input type="text"
							class="form-control" style="background-image: none;"
							pattern="[0-9]{6}" name="pinCode" value="" maxlength="6" required>
						<div class="invalid-feedback">Please Enter Valid Pin Code.</div>

					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label"> Aadhaar No. (आधार क्र.)
						</label> <input type="text" class="form-control "
							style="background-image: none;" id="aadhaarNumber1"
							placeholder="" name="aadhaarNo" value="" pattern="[0-9]{12}"
							maxlength="12">
						<div class="invalid-feedback">Please Enter Valid Aadhaar No.
						</div>
					</div>
				</div>-->
				<div class="col-md-4">
					<div class="mb-3 mt-3">

						<label for="" class="form-label"> Name of Property
							Holders/Occupants (मालमत्ताधारक/ भोगवटादारांचे नाव)	<span
						class="text-danger">*</span></label>
						<input type="text" class="form-control"
				  		style="background-image: none;" name="holdersName" id="propertyHolderName" value=""
						 maxlength="255" pattern="^[A-Za-z ]+$" required readonly> 
						<div class="invalid-feedback">Please Enter Valid Name of
							Property Holders.</div>
					</div>
				</div>
					
						<div class="col-md-12">
				<div class="mb-3 mt-3 ">
					<label for="primary_full_address" class="form-label lbleng">Address
							(पत्ता)<span
						class="text-danger">*</span>
					</label>

					<textarea class="form-control " style="background-image: none;"
						rows="2" id="address" name="propertyAddress" readonly required></textarea>
					<div class="invalid-feedback">Please Enter Valid Address.</div>

				</div>
			</div>
			<br>
					
				</div>


			<!-- </div>
	

			<h6 style="background-color: #dce2e8; padding: 10px;"
				class=" mt-3 rounded-2">
				<strong> Application Form Details (अर्जाचा तपशील)</strong>
			</h6>-->
			<div class="row">


				<!-- <div class="col-md-3">
					<div class="mb-3 mt-4">
						<label for="" class="form-label lbleng">Zone No. (झोन
							क्र.)<span class="text-danger" style="color: red;">*</span>
						</label> <select class="form-select " onchange="callWardList(this)"  style="background-image: none;"
							id="iFunction" name="zoneNo" required>
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
					<div class="mb-3 mt-4">
						<label for="" class="form-label"> Ward No. (प्रभाग क्र.) <span
							class="text-danger" style="color: red;">*</span></label> <select
							class="form-select " style="background-image: none;"
							id="iOperation" name="wardNo" disabled required>

						</select>
						<div class="invalid-feedback">Please Enter Valid Ward No.</div>
					</div>

				</div> -->
				
			
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
        <div class="invalid-feedback">Please Enter Valid Ward No.</div>
    </div>
</div>


<div class="col-md-3">
    <div class="mb-3" style="margin-top: 23px;">
        <label for="upinNo" class="form-label lbleng">Ward Name (प्रभाग नाव)<span class="text-danger" style="color: red;">*</span></label>
        <input type="text" class="form-control" style="background-image: none;" id="blockName" placeholder="" name="blockName" value="" maxlength="10" required readonly>
        <div class="invalid-feedback">Please Enter Valid Ward Name.</div>
    </div>
</div>
			
								
<!-- 								<div class="col-md-3">
						<div class="mb-3" style="margin-top: 23px;">
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
								</div> -->
								
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
        <div class="invalid-feedback">Please Enter Valid Total Demand.</div>
    </div>
</div>

<div class="col-md-3" id="payTaxButton">
    <div class="mb-3" style="margin-top: 50px;">
        <a href="https://geocivicnmcapp.nmcptax.com/CitizenServices/CitizenTax/index.html" class="pay-now-button" target="_blank">Pay Your Tax</a>
    </div>
</div>


				<!-- 	<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Index No.
							(निर्देशांक क्र.)<span class="text-danger" style="color: red;">*</span></label> <input type="text" class="form-control"
							style="background-image: none;" id="" placeholder=""
						maxlength="80"	name="indexNo"  value="" required>
						<div class="invalid-feedback">Please Enter Valid Index No.</div>

					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">UPIN No. (UPIN
							क्र.)<span class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="" placeholder=""
							name="upinNo" value="" required>
						<div class="invalid-feedback">Please Enter Valid UPIN No.</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Property Address
							(मालमत्तेचा पत्ता)<span class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="" placeholder=""
							name="propertyAddress" value="" required>
						<div class="invalid-feedback">Please Enter Valid Property
							Address.</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Area of Property
							(मालमत्तेचे क्षेत्रफळ)<span class="text-danger"
							style="color: red;">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="" placeholder=""
							name="areaOfProperty" value="" required>
						<div class="invalid-feedback">Please Enter Valid Area of
							Property.</div>
					</div>
				</div>

				<div class="row">
					<h6 style="background-color: white; padding: 5px;"
						class="mt-1 rounded-2">
						<strong> List of Documents (with attachment)(कागदपत्रांची
							यादी (संलग्नकांसह))</strong>
					</h6>
					<div class="alert alert-info mb-2 p-2 mb-4 ms-2">
						<small class="form-label "><strong class="form-label ">Note(नोंद):
						</strong> Upload below files in .pdf(Max upto 5 MB)(खालील फाइल .pdf मध्ये
							अपलोड करा (कमाल ५ MB पर्यंत))</small>
					</div>-->

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
					
					<!-- <div class="col-md-3">
					<div class="mb-3" style="margin-top: 23px;">
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
        <div class="mb-3" style="margin-top: 23px;">
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
</script>
				

		</div>-->
			<br>
			<hr class="custom-hr">
			
			<div class="row">

				<!-- <h6 style="background-color: white; padding: 5px;"
					class="mt-1 rounded-2">
					<strong> List of Documents (with attachment) (दस्तऐवजांची
						यादी (सह संलग्नक)) </strong>
				</h6>-->
				
				<div class="">
											<br>
				
					<strong style="color: red;">Note (नोंद): </strong> Upload below file
						only .pdf(Max upto 2 MB) (खाली फक्त .pdf फाइल अपलोड करा (कमाल २ MB
						पर्यंत))
				</div>
					<input type="hidden" name="filesPath" id="filesPath" />
					<div class="col-md-3">
						<div class="mb-3 mt-5">
							<label for="" class="form-label">Copy of Registered Sale Deed (नोंदणीकृत विक्री कराराची प्रत)<span class="text-danger"
								style="color: red;">*</span>
							</label> <input type="file" accept=".pdf" class="form-control"
								style="background-image: none;" id="doc1" name="saleDeed"
								required>
							<div class="invalid-feedback">File selected is either
								greater than 5Mb or not of type pdf.</div>

						</div>
					</div>


					<div class="col-md-3">
						<div class="mb-3 mt-4">
							<label for="" class="form-label lbleng">Akhiv Patrika of City Land Survey Department (नगर भूमापन विभागाची आखीव पत्रिका)<span
								class="text-danger" style="color: red;">*</span>
							</label> <input type="file" accept=".pdf" class="form-control"
								style="background-image: none;" id="doc2" placeholder=""
								name="akhivaPatrika" required>
							<div class="invalid-feedback">File selected is either
								greater than 5Mb or not of type pdf.</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="mb-3 mt-5">
							<label for="" class="form-label lbleng">Self Attested Applicant's Id Proof (स्वत: प्रमाणित अर्जदाराचा आयडी पुरावा)
<span class="text-danger"
								style="color: red;">*</span>
							</label> <input type="file" class="form-control"
								style="background-image: none;" accept=".pdf" id="doc3" placeholder=""
								name="applicantsIdProof" required>
							<div class="invalid-feedback">File selected is either
								greater than 5Mb or not of type .pdf.</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="mb-3 mt-5">
							<label for="" class="form-label lbleng">Regularization Letter (RL) (नियमितीकरण पत्र (RL)) </label> <input type="file"
								class="form-control" style="background-image: none;" accept=".pdf" id="doc4"
								placeholder="" name="rletter">
						</div>
					</div>
					<div class="col-md-3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label lbleng">Water Bill (पाणी बिल)</label> <input type="file" class="form-control"
								style="background-image: none;" id="doc5" accept=".pdf" placeholder=""
								name="waterBill">
						</div>
					</div>
					<div class="col-md-3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label lbleng"> Copy of Electric Bill (इलेक्ट्रिक बिलाची प्रत)<span class="text-danger"
								style="color: red;">*</span>
							</label> <input type="file" class="form-control"
								style="background-image: none;" id="doc6" accept=".pdf" placeholder=""
								name="electricBill" required>
							<div class="invalid-feedback">File selected is either
								greater than 5Mb or not of type .pdf.</div>
						</div>

					</div>
				</div>
										<hr class="custom-hr">
				
				<div class="col-md-12">
					<div class="mb-5 mt-4 ">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" id="check11"
								name="declaration" value="something" required> <label
								class="form-check-label ms-3 lbleng" style="margin-top: 0px;">
								<strong>Declaration (घोषणा) <span class="text-danger"
									style="color: red;">*</span>:-
							</strong>The above mentioned information is true to the best of my
								knowledge and belief. (वर नमूद केलेली माहिती माझ्या
								माहितीनुसार आणि विश्वासानुसार खरी आहे.)
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
		
								<input type="hidden" name="propertyId" id="propertyId" value="" />
		
	</form>
</body>



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
<script src="https://code.jquery.com/jquery-3.6.3.min.js"
	integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
	crossorigin="anonymous"></script>

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
                     onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveNewlyConstructedProperty.do');
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
            data.append('idProof5', $("#doc5").get(0).files[0]);
            data.append('idProof6', $("#doc6").get(0).files[0]);
          


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
                    filesPath = filesPath + basePath + "NewlyConstructedProperty/" + id + value + ","
                    isFileSelected = true;
                }
            }
            $.ajax({
                url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadDocumentNewlyConstructedPropertyApplication.do?id="+id,
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
function callWardList() {
    const zoneId = document.getElementById('iFunction').value;
    $.ajax({
        url: "<c:out value='${contextRoot}'/>/mobileapp/getWardApplication/" + zoneId,
        type: 'GET',
        cache: false,
        dataType: 'json',
        success: function(data) {
            populateDropdown(data.ward);
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
    selectOption.text = '-Select Ward-'; 																																										
    dropdown.appendChild(selectOption);

    for (let i = 0; i < data.length; i++) {
        const wardName = data[i].wardName;
        const wardNo = data[i].wardNo;
        const option = document.createElement('option');
        option.value = wardNo;
        option.text = wardName;
        dropdown.appendChild(option);
    }
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
            	$("#houseNo").val(data.houseNo);
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
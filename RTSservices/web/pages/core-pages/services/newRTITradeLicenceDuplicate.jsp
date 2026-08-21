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
	href="/RTS/pages/core-pages/nmc_user/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/RTS/pages/core-pages/nmc_user/css/style2.css" />
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
<script>
    $(document).ready(function(){
  
  $("#submit").click(function(){
	  

	  $("form:first").addClass("needs-validation");
	  $("form:first").attr("novalidate","");
  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  const forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }else{
  		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveZoneCertificates.do');
      }

      form.classList.add('was-validated')
    }, false)
  })});
  
  $('input,select,textarea').on('focusout', function() {
  
  var isFileAllowed=true;
  if(this.getAttribute("type")=== 'file'){
  var name = this.files[0].name;
  if ((this.files[0].size < 2000000) && (name.endsWith('.pdf'))) {
  isFileAllowed = true;
  }else{
  isFileAllowed = false;
  }
  }

  if(this.checkValidity() && isFileAllowed){
  this.classList.remove('is-invalid')
  this.classList.add('is-valid')
  }else{
  this.classList.remove('is-valid')
  this.classList.add('is-invalid')
  }
});
  
 
  
});


 //fname lname combining
 function Display(id) {
            $('#full_name').val($('#first_name').val() + " " + $('#middle_name').val() + " " + $('#last_name').val())
        }
</script>
</head>
<body>

	<form class="needs-validation" novalidate>
		<div class="container mt-3">
			<div class="printable">
				<h3 class="text-center">
					<strong>Application Form For Trade Licence Duplicate Copy
					</strong>
				</h3>
			</div>
			<h6 style="background-color: #dce2e8; padding: 10px;"
				class="  rounded-2">
				<strong> Applicant Details </strong>
			</h6>
			<div class="row">
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Title <span
							class="text-danger">*</span>
						</label> <select class="form-select" style="background-image: none;"
							name="appTitle" required>
							<option value="">-Select-</option>
							<option value="1">Mr</option>
							<option value="2">Mrs</option>
							<option value="3">Ms</option>
						</select>
						<div class="invalid-feedback">Please Select Valid Title.</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">First Name<span
							class="text-danger">*</span></label> <input type="text"
							class="form-control" style="background-image: none;"
							id="first_name" placeholder="" name="firstName" value=""
						maxlength="40"	pattern="[A-Za-z]+" onchange="Display(this.id)" required>
						<div class="invalid-feedback">Please Enter Valid First Name.
						</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Middle Name</label> <input
							type="text" class="form-control" style="background-image: none;"
							id="middle_name" placeholder="" name="middleName" value=""
							pattern="[A-Za-z]+" onchange="Display(this.id)">


					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Last Name<span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control" style="background-image: none;"
							name="lastName" id="last_name" value=""maxlength="40"	 pattern="[A-Za-z]+"
							onchange="Display(this.id)" required>
						<div class="invalid-feedback">Please Enter Valid Last Name.
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Full Name </label> <input
							type="text" class="form-control" style="background-image: none;"
							id="full_name" placeholder="" name="fullName" value="" readonly>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Pin Code <span
							class="text-danger">*</span></label> <input type="text"
							class="form-control" style="background-image: none;"
							pattern="^(?!0{6}$)\d{6}$" name="pincode" value="" maxlength="6" required>
						<div class="invalid-feedback">Please Enter Valid Pincode.</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label"> Aadhaar No. </label> <input
							type="text" class="form-control" style="background-image: none;"
							id="aadhaarNumber1" placeholder="" name="aadhaarNo" value=""
							pattern="(?!0{12}$)[0-9]{12}" maxlength="12">
						<div class="invalid-feedback">Please Enter Valid Aadhaar No.
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">

						<label for="email" class="form-label lbleng"> Email Id <span
							class="text-danger">*</span>
						</label> <input type="email" class="form-control"
							style="background-image: none;" id="email" placeholder=""
							name="appEmail" pattern "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}" value="" required>
						<div class="invalid-feedback">Please Enter Valid Email Id.</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label"> Mobile No.<span
							class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="txtMobileNumber"
							placeholder="" name="mobileNo" value=""
							pattern="[6-9]{1}[0-9]{9}" maxlength="10" required>
						<div class="invalid-feedback">Please Enter Valid Mobile No.
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="mb-3 mt-3 ">
						<label for="primary_full_address" class="form-label lbleng">Address
							For Correspondence<span class="text-danger">*</span>
						</label>

						<textarea class="form-control" style="background-image: none;"
							rows="2" id="" name="fullAddress"  maxlength="255"required></textarea>
						<div class="invalid-feedback">Please Enter Valid Address.</div>
					</div>
				</div>
				<br>

				<h6 style="background-color: #dce2e8; padding: 10px;"
					class=" mt-3 rounded-2">
					<strong> Application Form Details</strong>
				</h6>
				<div class="row">




					<div class="col-md-3">
						<div class="mb-3" style="margin-top: 40px;">
							<label for="" class="form-label lbleng">Zone No. (झोन
								क्र.)<span class="text-danger" style="color: red;">*</span>
							</label> <select class="form-select " style="background-image: none;"
								id="main-dropdown" name="zoneNo" required>
								<option value="select-zone" selected="">-Select Zone-</option>
								<option value="1">Zone No.1 - Laxmi Nagar (लक्ष्मी नगर)</option>
								<option value="2">Zone No.2 - Dharmpeth (धरमपेठ)</option>
								<option value="3">Zone No.3 - Hanuman Nagar (हनुमान
									नगर)</option>
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
						<div class="mb-3" style="margin-top: 40px;">
							<label for="" class="form-label"> Ward No. (प्रभाग क्र.)
								<span class="text-danger" style="color: red;">*</span>
							</label> <select class="form-select" style="background-image: none;"
								id="dependent-dropdown" name="wardNo" disabled required>

								<option value="select-ward" selected="">-Select Ward-</option>
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

					<div class="col-md-3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label lbleng">Name of Area</label> <input
								type="text" class="form-control" style="background-image: none;"
								id="" placeholder="" name="areaName" maxlength="255"value="">
						</div>
					</div>
					<div class="col-md-3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label lbleng">Trade Licence No<span
								class="text-danger" style="color: red;">*</span></label> <input
								type="text" class="form-control" style="background-image: none;"
								id="" placeholder="" name="TradeLicenceNo" maxlength="20" value="" required>
							<div class="invalid-feedback">Please Enter Valid Trade
								Licence No.</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label lbleng">Updated Trade
								Name </label> <input type="text" class="form-control"
								style="background-image: none;" id="" placeholder=""
								name="UpdatedTradeName "
								pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" value="">

						</div>
					</div>
					<div class="col-md-3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label lbleng">Updated Trade
								Type<span class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control"
								style="background-image: none;" id="" placeholder=""
								name="UpdatedTradeType" value="" required>
							<div class="invalid-feedback">Please Enter Valid Updated
								Trade Type.</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label lbleng">Updated
								Owner/Partner Name <span class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control"
								style="background-image: none;" id="" placeholder=""
								name="UpdatedOwner/PartnerName " value=""
								pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" required>
							<div class="invalid-feedback">Please Enter Valid Updated
								Owner/Partner Name.</div>
						</div>
					</div>


					<div class="col-md-3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label lbleng">Updated Partner
								Count <span class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control"
								style="background-image: none;" id="" placeholder=""
								name="UpdatedOwner/PartnerName " value="" required>
							<div class="invalid-feedback">Please Enter Valid Updated
								the Partner Count.</div>
						</div>
					</div>
					<div class="row">

						<h6 style="background-color: white; padding: 10px;"
							class="mt-3 rounded-2">
							<strong> List of Documents (with attachment) </strong>
						</h6>

						<div class="alert alert-info mb-0 p-2 mb-4">
							<small><strong>Note: </strong> Upload Below Files only
								.pdf.(Max upto 5MB) </small>
						</div>
						<div class="col-md-3">
							<div class="mb-3 mt-3">
								<label for="" class="form-label">NOC for the related
									department issued from the NMC/Department Officer/Govt/Semi
									Govt. Officer<span class="mand_error" style="color: red;">*</span>
								</label> <input type="file" class="form-control"
									style="background-image: none;" id="" placeholder=""
									name="applicantIdProof" required>
								<div class="invalid-feedback">File selected is either
									greater than 5Mb or not of type .pdf.</div>


							</div>
						</div>
						<div class="col-md-3">
							<div class="mb-3 " style="margin-top: 40px;">
								<label for="" class="form-label lbleng">Copy of the
									Former Licence (In case of Renewal the Licence)<span
									class="mand_error" style="color: red;">*</span>
								</label> <input type="file" class="form-control"
									style="background-image: none;" id="" placeholder=""
									name="CopyOfTheFormerLicence " required>
								<div class="invalid-feedback">File selected is either
									greater than 5Mb or not of type .pdf.</div>

							</div>
						</div>

						<div class="col-md-3">
							<div class="mb-3 " style="margin-top: 65px;">
								<label for="" class="form-label lbleng">No Dues
									Certificate for Property Tax</label> <input type="file"
									class="form-control" style="background-image: none;" id=""
									placeholder="" name="NoDuesCertificate">
							</div>
						</div>
						<div class="col-md-3">
							<div class="mb-3" style="margin-top: 65px">
								<label for="" class="form-label lbleng"> Building
									Authorization Document <span class="mand_error"
									style="color: red;">*</span>
								</label> <input type="file" class="form-control"
									style="background-image: none;" id="" placeholder=""
									name=" BuildingAuthorizationDocument " required>
								<div class="invalid-feedback">File selected is either
									greater than 5Mb or not of type .pdf.</div>

							</div>

						</div>
					</div>



					<div class="col-md-12">
						<div class="mb-5 mt-4 ">
							<div class="form-check">
								<input class="form-check-input" type="checkbox" id="check11"
									name="declaration" value="something" required> <label
									class="form-check-label ms-3 lbleng" style="margin-top: -1px;">
									<strong>Declaration <span class="text-danger"
										style="color: red;">*</span>:-
								</strong>The above mentioned information is true to the best of my
									knowledge and belief.
								</label>
								<div class="invalid-feedback">Please check the
									declaration.</div>
							</div>
						</div>
					</div>
					<div class="col-md-12 text-start mb-5">
						<div class="text-center">
							<button type="button" class="btn btn-danger btn_sm printMe">
								<i class="fa-solid fa-print"></i> View and Print
							</button>
							<button class="btn btn-success btn_sm" type="submit" id="submit">
								<i class="fa-solid fa-check"></i> Submit
							</button>
						</div>
					</div>
				</div>
	</form>
</body>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://code.jquery.com/jquery-3.6.1.js"></script>

<script type="text/javascript">
$('.printMe').on('click', function () {

    window.print();
});
</script>

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




<script>
    $('#main-dropdown').on('change', function() {
        document.getElementById("dependent-dropdown").removeAttribute('disabled');

    var selectedValue = $('#main-dropdown').val();

var options = [];

if (selectedValue === '1') {
    options = ['-Select Ward-','Ward No. 16','Ward No. 36', 'Ward No. 37' , 'Ward No. 38'];
} else if (selectedValue === '2') {
    options = ['-Select Ward-','Ward No. 12', 'Ward No. 13', 'Ward No. 14', 'Ward No. 15'];
} else if (selectedValue === '3') {
    options = ['-Select Ward-','Ward No. 29', 'Ward No. 31', 'Ward No. 32' , 'Ward No. 34'];
}else if (selectedValue === '4') {
    options = ['-Select Ward-','Ward No. 17', 'Ward No. 33', 'Ward No. 35'];
}else if (selectedValue === '5') {
    options = ['-Select Ward-','Ward No. 26', 'Ward No. 27','Ward No. 28','Ward No. 30'];
}else if (selectedValue === '6') {
    options = ['-Select Ward-','Ward No. 8', 'Ward No. 18', 'Ward No. 19' , 'Ward No. 22'];
}else if (selectedValue === '7') {
    options = ['-Select Ward-','Ward No. 5', 'Ward No. 20', 'Ward No. 21'];
}else if (selectedValue === '8') {
    options = ['-Select Ward-','Ward No. 4', 'Ward No. 23', 'Ward No. 24' , 'Ward No. 25'];
}else if (selectedValue === '9') {
    options = ['-Select Ward-','Ward No. 2', 'Ward No. 3', 'Ward No. 6', 'Ward No. 7'];
}else if (selectedValue === '10') {
    options = ['-Select Ward-','Ward No. 1', 'Ward No. 9', 'Ward No. 10' , 'Ward No. 11'];
}else if (selectedValue === 'select-zone') {
    options = ['select-ward'];
}
$('#dependent-dropdown').empty();
for (var i = 0; i < options.length; i++) {
    $('#dependent-dropdown').append('<option value="' + options[i] + '">' + options[i] + '</option>');
}
});
</script>


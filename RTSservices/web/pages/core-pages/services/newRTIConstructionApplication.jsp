


<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants" />
<jsp:directive.page import="com.mars.common.utils.CommonUtils" />
<script type="text/javascript"
	src="<c:out value=" ${contextRoot}" />/scripts/jquery/jquery.ajaxfileupload.js"></script>




<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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


</head>
<body>

	<form class="needs-validation" novalidate>
		<div class="container mt-3">
			<div class="printable">
				<h3 class="text-center">
					<strong></strong><strong>Application Form For Contruction
						Of Building Upto 150 SQ.M. </strong>
				</h3>
			</div>

			<h6 style="background-color: #dce2e8; padding: 10px;"
				class="  rounded-2">
				<strong> Applicant Details </strong>
			</h6>
			<div class="row">
				<input type="hidden" name="_token" value="xyz">
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Title <span
							class="text-danger">*</span>
						</label> <select class="form-select" name="title" required>
							<option value="">-Select-</option>
							<option value="1">Mr</option>
							<option value="2">Mrs</option>
							<option value="3">Ms</option>
						</select>
						<div class="invalid-feedback">Please Select Title.</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">First Name<span
							class="text-danger">*</span></label> <input type="text"
							class="form-control" id="first_name" placeholder=""
							name="firstName" value="" pattern="[A-Za-z]+"
							onchange="Display(this.id)" required>
						<div class="invalid-feedback">Please Enter Valid First Name.
						</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Middle Name</label> <input
							type="text" class="form-control" id="middle_name" placeholder=""
							name="middleName" value="" pattern="[A-Za-z]+"
							onchange="Display(this.id)">


					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Last Name<span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control" name="lastName" id="last_name"
							value="" pattern="[A-Za-z]+" onchange="Display(this.id)" required>
						<div class="invalid-feedback">Please Enter Valid Last Name.
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Full Name </label> <input
							type="text" class="form-control" id="full_name" placeholder=""
							name="fullName" value="" readonly>
					</div>
				</div>


				<script>
                        function Display(id) {
                                      $('#full_name').val( $('#first_name').val()+" "+ $('#middle_name').val()+" "+ $('#last_name').val())
                                }
                        </script>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Pin Code <span
							class="text-danger">*</span></label> <input type="text"
							class="form-control" pattern="[0-9]{6}" name="pincode" value=""
							maxlength="6" required>
						<div class="invalid-feedback">Please Enter Valid Pin Code.</div>

					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label"> Aadhaar No. </label> <input
							type="text" class="form-control " id="aadhaarNumber1"
							placeholder="" name="aadhaarNo" value="" pattern="[0-9]{12}"
							maxlength="12">
						<div class="invalid-feedback">Please Enter Aadhaar No.</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">

						<label for="email" class="form-label lbleng"> Email Id <span
							class="text-danger">*</span>
						</label> <input type="email" class="form-control " name="email" value=""
							required>
						<div class="invalid-feedback">Please Enter Valid Email Id.</div>
					</div>
				</div>


				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label"> Mobile No.<span
							class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control " id="txtMobileNumber"
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

						<textarea class="form-control " rows="2" id="" name="address"
							required></textarea>
						<div class="invalid-feedback">Please Enter Valid Address.</div>

					</div>
				</div>

			</div>
			<br>






			<h6 style="background-color: #dce2e8; padding: 10px;"
				class="rounded-2">
				<strong> Application Form Details</strong>
			</h6>
			<div class="row">
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Owner Name<span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control" id="" placeholder=""
							name="ownerName" value="" required="true">
						<div class="invalid-feedback">Please Enter Valid Owner Name.
						</div>

					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Revenue No<span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control" id="" placeholder=""
							name="revenueNo" value="" value="" required>
						<div class="invalid-feedback">Please Enter Valid Revenue No.
						</div>


						</select>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Property Number <span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control" id="" placeholder=""
							name="peropertyNo" value="" required="true">
						<div class="invalid-feedback">Please Enter Valid Property
							Number.</div>

					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Property Usage <span
							class="text-danger" style="color: red;">*</span></label> <select
							class="form-select" name="propertyUsage" required="true">
							<option value="">-Select-</option>
							<option value="1">Residential</option>
							<option value="2">Commercial</option>
							<option value="3">Industrial</option>

						</select>
						<div class="invalid-feedback">Please Select Valid Property
							Usage.</div>

					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label"> Survey No<span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control" id="" placeholder=""
							name="surveyNo" value="" required="true">
						<div class="invalid-feedback">Please Enter Valid Survey No.
						</div>

					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label"> Gat No.</label> <input
							type="text" class="form-control" id="" placeholder=""
							name="gatNo" value="">

					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label"> Khasara No<span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control" id="" placeholder=""
							name="khasaraNo" value="" required="true">
						<div class="invalid-feedback">Please Enter Valid Khasara No.
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label"> Final Plot No<span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control" id="" placeholder=""
							name="finalPlotNo" value="" required="true">
						<div class="invalid-feedback">Please Enter Valid Final Plot
							No.</div>

					</div>
				</div>


				<div class="col-md-12">
					<div class="mb-3 mt-3">
						<label for="" class="form-label"> Property Address <span
							class="text-danger" style="color: red;">*</span></label>
						<textarea class="form-control" rows="2" name="propertyAddress"
							required="true"></textarea>
						<div class="invalid-feedback">Please Enter Valid Property
							Address.</div>

					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-0">
						<label for="" class="form-label">Architect/Licensed
							Engineer/Supervisor (License No.)<span class="text-danger"
							style="color: red;">*</span>
						</label> <input type="text" class="form-control" id="" placeholder=""
							name="licenseNo" value="" required="true">
						<div class="invalid-feedback">Please Enter Valid
							Architect/Licensed Engineer/Supervisor (License No).</div>

					</div>
				</div>


				<div class="col-md-3">
					<div class="mb-3 mt-4">
						<label for="" class="form-label"> Zone No <span
							class="text-danger" style="color: red;">*</span></label> <select
							class="form-select" name="zoneNo" required="true">
							<option value="select-zone" selected="">-Select Zone-</option>
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
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">One Column <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
								<li class="divider"></li>
								<li><a href="#">One more separated link</a></li>
							</ul></li>
						<li class="dropdown">
				</div>


				<div class="col-md-3">

					<div class="mb-3 mt-4">

						<label for="" class="form-label"> Signature Of Owner<span
							class="text-danger" style="color: red;">*</span></label> <input
							type="file" class="form-control" name="sign" id="doc1"
							placeholder="" required>
						<div class="invalid-feedback">File selected is either
							greater than 5Mb or not of type .pdf.</div>
					</div>
				</div>

				<input type="hidden" name="filesPath" id="filesPath" />


				<div class="row">
					<h6 class="mt-3">
						<strong> List of Documents (with attachment) </strong>
					</h6>
					<div class="alert alert-info mb-0 p-2 mb-3 ms-2">
						<small><strong>Note: </strong>Upload below files only
							.pdf(Max upto 5 MB)</small>
					</div>
					<div class="col-md-3">
						<div class="mb-3 mt-4" style="margin-top: 38px;">
							<label for="" class="form-label">Copy of Sanctioned
								Layout Plan <span class="text-danger"><span
									class="text-danger" style="color: red;">*</span>
							</label> <input type="file" class="form-control" id="doc2" placeholder=""
								name="sanctionedLayoutPlan" required="true">
							<div class="invalid-feedback">File selected is either
								greater than 5Mb or not of type .pdf.</div>
						</div>
					</div>


					<div class="col-md-3">
						<div class="mb-3 mt-1">
							<label for="" class="form-label"> Document Showing
								Owernship of Land to be Specified <span class="text-danger"
								style="color: red;">*</span>
							</label> <input type="file" class="form-control" name="ownershipOfLand"
								id="doc3" placeholder="" required="true">
							<div class="invalid-feedback">File selected is either
								greater than 5Mb or not of type .pdf.</div>
						</div>
					</div>


					<div class="col-md-3">
						<div class="mb-3 mt-4">
							<label for="" class="form-label">7/12<span
								class="text-danger" style="color: red;">*</span></label> <input
								type="file" class="form-control" id="doc4" placeholder=""
								name="7/12File" required="true">
							<div class="invalid-feedback">File selected is either
								greater than 5Mb or not of type .pdf.</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="mb-3 mt-4">
							<label for="" class="form-label">Aadhaar Card <span
								class="text-danger" style="color: red;">*</span></label> <input
								type="file" class="form-control" id="doc5" placeholder=""
								name="aadhaarCard" required="true">
							<div class="invalid-feedback">File selected is either
								greater than 5Mb or not of type .pdf.</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label"> Existing Property Tax
								Reciept <span class="text-danger" style="color: red;">*</span>
							</label> <input type="file" class="form-control" id="doc6" placeholder=""
								name="propertyReciept" required="true">
							<div class="invalid-feedback">File selected is either
								greater than 5Mb or not of type .pdf.</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label"> Affidavit <span
								class="text-danger" style="color: red;">*</span></label> <input
								type="file" class="form-control" name="affidavit" id="doc7"
								placeholder="" required="true">
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
								class="form-check-label ms-3 lbleng" style="margin-top: 0px;">
								<strong>Declaration<span class="text-danger"
									style="color: red;">*</span>:-
							</strong>I hereby declare that , all the information provided by me in the
								above application is true. If it found wrong or not related , I
								permit to reject the application.
							</label>
							<div class="invalid-feedback">Please check the declaration.
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-12 text-start mb-5">
					<div class="text-center">
						<button type="button" class="btn btn-danger btn_sm printMe">
							<i class="fa-solid fa-print"></i> View and Print
						</button>
						<button class="btn btn-success btn_sm" type="submit" id="submit"
							onclick="javascript:upload();">
							<i class="fa-solid fa-check"></i> Submit
						</button>
					</div>
				</div>
			</div>
	</form>


	<script type="text/javascript">
$('.printMe').on('click', function () {

    window.print();
});
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
  		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveBuildingCertificates.do');
      }

      form.classList.add('was-validated')
    }, false)
  })});
  
  var isFileAllowed=true;
  if(this.getAttribute("type")=== 'file'){
  var name = this.files[0].name;
  if((this.files[0].size <5000000) && (name.endsWith('.pdf'))){
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
  
 
       function upload() {

    	   var url = window.location.href;
   		//var url = window.location.href;// The window.location.href property in JavaScript returns the URL of the currently open web page. This property can even be used to update the URL of a web page.
   		var basePath = url.split('${contextRoot}')[0] + '${contextRoot}/';
   		var filesPath = "";
   		var data = new FormData();
   		
   		 data.append('idProof1', $("#doc1").get(0).files[0]);
   		data.append('idProof2', $("#doc2").get(0).files[0]);
   		data.append('idProof3', $("#doc3").get(0).files[0]);
   		data.append('idProof3', $("#doc4").get(0).files[0]);
   		data.append('idProof3', $("#doc5").get(0).files[0]);
   		data.append('idProof3', $("#doc6").get(0).files[0]);
   		data.append('idProof3', $("#doc7").get(0).files[0]);
   		
   		var isFileSelected = false
   		
   		
   		var file = $('input[type="file"]');
   		for (var i = 0; i < file.length; i++) {
			var array_element = file[i];
			var element = array_element.value.split("\\");
			var a = element[element.length-1];
			const splitName = a.split(".pdf")[0].replaceAll(/[^a-zA-Z0-9]/g, ""); 
			const value = splitName + ".pdf";
			 if(value==='' && value===undefined){
				filesPath = "";
				isFileSelected = false;
				break;
   			}else{
   				filesPath = filesPath+basePath + "constructionBuilding/"+i+value+","
   				isFileSelected = true;
   			} 
   		}
   			   $.ajax({
   			    url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadDocumentBuilding.do",
   			    type: 'POST',
   			    data: data,
   			    cache: false,
   			    dataType: 'json',
   			    processData: false, // Don't process the files
   			    contentType: false // Set content type to false as jQuery will tell the server its a query string request
   			}).done(function( data ) {
   			   
   			    });   

   			filesPath = filesPath.substring(0, filesPath.lastIndexOf(","));
   			$("#filesPath").val(filesPath);
   			console.log(filesPath);

   	} 

</script>
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
<script src="https:code.jquery.com/jquery-3.6.3.min.js"
	integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
	crossorigin="anonymous"></script>
<link
	href="https:cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https:cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<!-- CSS only -->
<link
	href="https:cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https:ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="jquery-3.6.1.min.js"></script>
<!-- JavaScript Bundle with Popper -->
<script
	src="https:cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<script src="Vjdog.js"></script>
<script src="https:code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript"
	src="<c:out value=" ${contextRoot}" />/scripts/jquery/jquery.ajaxfileupload.js"></script>
<link rel="stylesheet"
	href="<c:out value=" ${contextRoot}" />/pages/core-pages/nmc_user/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<c:out value=" ${contextRoot}" />/pages/core-pages/nmc_user/css/style2.css" />
	

<!-- Include SweetAlert2 CSS and JS files -->
<link rel="stylesheet" href="path/to/sweetalert2.min.css">
<script src="path/to/sweetalert2.all.min.js"></script>
<script
	src="https:cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>
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

<script>
function showCustomAlert(message) {
    // Dynamically create modal elements
    var overlay = $('<div class="custom-alert-overlay"></div>');
    var modal = $('<div class="custom-alert-modal"></div>');
   // var closeBtn = $('<span class="custom-alert-close-btn" onclick="closeCustomAlert()">&times;</span>');
    var content = $('<div id="custom-alert-content"></div>');

    // Append elements to modal
    //modal.append(closeBtn);
    modal.append(content);
    overlay.append(modal);

    // Set content
    content.html(message);

    // Append overlay to body and display
    $('body').append(overlay);
    overlay.fadeIn();
}

function closeCustomAlert() {
    // Remove overlay when closing
    $('.custom-alert-overlay').fadeOut(function() {
        $(this).remove();
    });
}


    $(function () {
        $("#cin").on('change', function (event) {
            var cinValue = this.value;

            if (cinValue.length !== 8) {
                return false;
            }

            // Send a POST request to the server
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/rtsapplication/getChangeInOwnershipApplicationDetails.do?cinNo=" + cinValue,
                dataType: "json",
                async: false,
                success: function (data) {
                    $("#zone").val(data.zone);
                    $("#consName").val(data.consumername);
                    $("#consAddress").val(data.address);
                    $("#meterNo").val(data.meterno);
                    $("#meterTapSize").val(data.meterTapSize);
                    $("#category").val(data.category);
                    $("#balance_arrears").val(data.balance_arrears);
                    $("#cut_off_date").val(data.cut_off_date);
                    $("#contact_no").val(data.contact_no);
                    $("#email_id").val(data.email_id);
	            	$("#esr").val(data.esr);

                    $("#cin").prop('readonly',true);

                    var errorMessage = data.errormsg;
                    if(errorMessage!='' && errorMessage!=undefined){
                        alert(errorMessage);
                        $("#cin").prop('readonly',false);
                        $("#cin").val('');


                    }
                    // Check the balance_arrears and show appropriate alert
                    if (data.balance_arrears > 0) {
                        showCustomAlert("Clear your dues before proceeding with further procedures. <br> Your balance arrears: Rs." + data.balance_arrears + "/- <br> To pay your balance arrears, please use the following secure link: <a href='https://www.ocwindia.com//consumer_corner/' target='_blank'><br><button style='padding: 10px 16px; background-color: darkslategray; color: #fff; border:2px solid #a2bfde; border-radius: 4px; cursor: pointer; font-size: 14px; transition: background-color 0.3s;margin-top: 10px;'>Pay Now</button></a><br><br><button class='btn btn-primary btn_sm' type='button' id='submitBtn' value='Save'><i class='fa-solid fa-check'></i> <a href='<c:out value="${contextRoot}"/>/ws/nmc/dashboard/waterDepartment.do' style='color: ivory;'>Back to home</a></button>");
                    }
                    
                    if (data.email_id === "0") {
                        $("#email_id").val("");                       
                    document.getElementById("email_id").readOnly = false;
                    document.getElementById("email_id").setAttribute("required", "true");
                }

                if (data.contact_no === "0") {
                	$("#contact_no").val("");
                    document.getElementById("contact_no").readOnly = false;
                    document.getElementById("contact_no").setAttribute("required", "true");
                }
                
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    $("#zone").val('');
                    $("#consName").val('');
                    $("#consAddress").val('');
                    $("#meterNo").val('');
                    $("#meterTapSize").val('');
                    $("#category").val('');
                    $("#balance_arrears").val('');
                    $("#cut_off_date").val('');
                    $("#contact_no").val('');
                    $("#email_id").val('');
	            	$("#esr").val('');

                    
                    $("#cin").prop('required',true);
                    $("#zone").prop('required',true);
                    $("#consName").prop('required',true);
                    $("#consAddress").prop('required',true);
                    $("#meterNo").prop('required',true);
                    $("#meterTapSize").prop('required',true);
                    $("#balance_arrears").prop('required',true);
                    $("#cut_off_date").prop('required',true);
                    $("#category").prop('required',true);
                    $("#contact_no").prop('required',true);
                   // $("#email_id").prop('required',true);


                    alert("Record Not Found! Please Enter Valid CAN No.");
                }
            });
        });
    });
</script>

<div class="overlay" id="custom-alert-overlay">
    <div class="modal">
        <span class="close-btn" onclick="closeCustomAlert()">&times;</span>
        <div id="custom-alert-content"></div>
    </div>
</div>

<style>
    /* Overlay */
    .custom-alert-overlay {
        display: none;
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, 0.5);
        align-items: center;
        justify-content: center;
        z-index: 9999;
    }

    /* Modal */
    .custom-alert-modal {
            background-color: aliceblue;
    color: #333;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
    text-align: center;
    font-family: math;
    max-width: 750px;
    margin-left: 420px;
    margin-top: 300px;
    font-size: larger;
}

    /* Close button */
    .custom-alert-close-btn {
        cursor: pointer;
        position: absolute;
        top: 100px;
        right: 100px;
        font-size: 20px;
        color: #333;
    }
</style>

<style>

.prompt {
	background-color: #f2f2f2;
	border: 1px solid black;
	padding: 20px;
	margin: 10px;
}

</style>
<style>

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
<form id="CanDetails" class="needs-validation" novalidate>
	<div class="container-fluid mt-2" style="width: 190vh">

		<div class="printable">
			<h3 class="text-center">
				<strong>Application Form For Change Of Ownership (मालकी हक्कात बदल करणे अर्ज)
					</strong>
			</h3>
		</div>
				<h6 style="background-color: #dce2e8; padding: 10px;"
				class=" mt-3 rounded-2">
				<strong> Application Form Details (अर्ज तपशील)</strong>
			</h6>

	<input type="hidden" name="str" value="<c:out value='${str}'/>">
			<input type="hidden" name="serviceId" value="<c:out value='${serviceId}'/>">
			<input type="hidden" name="fields" value="<c:out value='${fields_aps}'/>">
			<input type="hidden" name="distric" value="<c:out value='${distric}'/>">
			<input type="hidden" name="trackid" value="<c:out value='${trackid}'/>">
			<input type="hidden" name="user" value="<c:out value='${user}'/>">
			<input type="hidden" name="mobile" value="<c:out value='${mobile}'/>">
			<input type="hidden" name="name" value="<c:out value='${name}'/>">




			<div class="row">
			
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">CAN No. (CAN क्र.)<span
							class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control waterRequired"
							style="background-image: none;" id="cin" placeholder=""
							name="CINNo"
							value="${responseData.getData().get(0).getContractAccountNo()}"
							pattern="[0-9]{8}" maxlength="8" required>
						<div class="invalid-feedback">Please Enter Valid CAN No.</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Zone No. (झोन
							क्र.)<span class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control waterRequired "
							style="background-image: none;" id="zone" name="zoneNo"
							value="${responseData.getData().get(0).getZone()}" readonly>

						<div class="invalid-feedback">Please Select Zone No.</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Existing Consumer
							Name (ग्राहकाचे नाव)<span class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control waterRequired"
							style="background-image: none;" id="consName"
							name="existingConsumerName"
							value="${responseData.getData().get(0).getConsumerName()}"
							pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" readonly>
						<div class="invalid-feedback">Please Enter Valid Consumer
							Name.</div>
					</div>
				</div>
			



				<!-- <div class="col-md-3">
					<div class="mb-3" style="margin-top: 26px;">
						<label for="" class="form-label lbleng">Consumer
							No.(ग्राहक क्र.)</label> <input type="text"
							class="form-control waterRequired"
							style="background-image: none;" name="consumerNo"
							pattern="^\s*\S.*$" maxlength="20"
							value="${changeInOwnershipType.consumerNo}">
						<div class="invalid-feedback">Please Enter Valid Consumer No
						</div>
					</div>
				</div>-->
		
				<div class="col-md-3" id="a3">
					<div class="mb-3" style="margin-top: 15px;">
						<label for="" class="form-label lbleng">Meter No. (मीटर
							क्र.)<span class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control waterRequired"
							style="background-image: none;" id="meterNo" name="meterNo"
							value="${responseData.getData().get(0).getMeterNo()}" readonly>
						<div class="invalid-feedback">Please Enter Valid Meter No.</div>
					</div>
				</div>
<!-- new Fields-->
<div class="col-md-3" id="a3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label lbleng">Tap Size in mm.(टॅपचा आकार)<span class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control waterRequired"
								style="background-image: none;" id="meterTapSize" name="tap_size"
								placeholder="Tap Size in mm." value="${responseData.getData().get(0).getTap_size()}" readonly>
							<div class="invalid-feedback">Please Enter Valid Tap Size.</div>
						</div>
					</div>
					<div class="col-md-3" id="a3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label lbleng">Category (श्रेणी)<span class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control waterRequired"
								style="background-image: none;" id="category" name="category"
								value="${responseData.getData().get(0).getCategory()}" readonly>
							<div class="invalid-feedback">Please Enter Valid Category.</div>
						</div>
					</div>
					<div class="col-md-3" id="a3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label lbleng">Balance Arrears (शिल्लक थकबाकी)<span class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control waterRequired"
								style="background-image: none;" id="balance_arrears" name="balance_arrears"
								value="${responseData.getData().get(0).getMeterNo()}" readonly>
							<div class="invalid-feedback">Please Enter Valid Meter No.</div>
						</div>
					</div>
					<div class="col-md-3" id="a3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label lbleng">Cut Off Date (कट ऑफ तारीख)<span class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control waterRequired"
								style="background-image: none;" id="cut_off_date" name="cut_off_date"
								value="${responseData.getData().get(0).getMeterNo()}" readonly>
							<div class="invalid-feedback">Please Enter Valid Meter No.</div>
						</div>
					</div>
						<div class="col-md-3" id="a2">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Consumer Address
							(ग्राहक पत्ता)<span class="text-danger" style="color: red;">*</span>
						</label> 
				<textarea class="form-control " style="background-image: none;" rows="2" id="consAddress" name="consumerAddress" value="" required readonly>${responseData.getData().get(0).getAddress()}</textarea>
						
							<div class="invalid-feedback">Please Enter Valid Consumer
							Address.</div>
					</div>
				</div>
				<div class="col-md-3" id="esistingesr">
				<div class="mb-3" style="margin-top:38px;">
						<label for="" class="form-label lbleng">ESR <span class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control waterRequired"
							style="background-image: none;" id="esr" name="existingEsr"
							value="${responseData.getData().get(0).getCommand_area()}"
							pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" required readonly>
						<div class="invalid-feedback">Please Enter ESR.</div>
					</div>
				</div>
<div class="col-md-3">
				<div class="mb-3" style="margin-top:38px;">

					<label for="email" class="form-label lbleng">
					Consumer Email Id (ग्राहकाचे ई -
						मेल आयडी) <span
							class="text-danger" style="color: red;">*</span>
					</label> <input type="email" class="form-control waterRequired "
						style="background-image: none;" id="email_id" placeholder=""
						name="emailId"
						pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}"
						value="${changeInOwnershipType.emailId}" required readonly>
					<div class="invalid-feedback">Please Enter Valid Email Id.</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="mb-3" style="margin-top:38px;">
					<label for="" class="form-label"> Consumer Mobile No. (ग्राहकाचे मोबाईल क्र.)<span
						class="text-danger" style="color: red;">*</span>
					</label> <input type="text" class="form-control waterRequired "
						style="background-image: none;" id="contact_no"
						placeholder="" name="mobileNo"
						value="${changeInOwnershipType.mobileNo}"
						pattern="[6-9]{1}[0-9]{9}" maxlength="10" readonly required>
					<div class="invalid-feedback">Please Enter Valid Mobile No.</div>
				</div>
			</div>
		
		
			
							<!-- <div class="col-md-3">
					<div class="mb-3 mt-3">


						<label for="" class="form-label lbleng"> Updated Consumer
							Name(Full name) (सुधारित केलेले ग्राहक नाव (संपूर्ण नाव))<span class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control waterRequired"
							style="background-image: none;" id="" placeholder=""
							name="updateConsumerName"
							value="${changeInOwnershipType.updateConsumerName}"
							pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" required>
<div class="invalid-feedback">Please Enter Valid Updated Consumer
							Name(Full name)
					</div>
					</div>
				</div>-->
</div>				<br>
<h6 style="background-color: #dce2e8; padding: 10px;"
			class="  rounded-2">
			<strong> Updated Consumer Details (अद्ययावत ग्राहकाचे तपशील)</strong>
		</h6>
		<div class="row">
			<input type="hidden" name="_token" value="xyz">
			<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label lbleng">Title (शीर्षक)<span
						class="text-danger">*</span>
					</label> <select class="form-select waterRequired"
						style="background-image: none;" name="title" required>
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
						class="text-danger">*</span>
					</label> <input type="text" class="form-control waterRequired"
						style="background-image: none;" id="first_name" placeholder=""
						name="firstName" value="${changeInOwnershipType.firstName}"
						maxlength="40" pattern="[A-Za-z]+" onchange="Display(this.id)"
						required>
					<div class="invalid-feedback">Please Enter Valid Name.</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label lbleng">Father's Name
						(वडिलांचे नाव)</label> <input type="text"
						class="form-control waterRequired" style="background-image: none;"
						id="middle_name" placeholder="" name="middleName"
						value="${changeInOwnershipType.middleName}" pattern="[A-Za-z]+"
						onchange="Display(this.id)">


				</div>
			</div>

			<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label lbleng">Surname (आडनाव)<span
						class="text-danger" style="color: red;">*</span></label> <input
						type="text" class="form-control waterRequired"
						style="background-image: none;" name="lastName" id="last_name"
						value="${changeInOwnershipType.lastName}" pattern="[A-Za-z]+"
						onchange="Display(this.id)" maxlength="80" required>
					<div class="invalid-feedback">Please Enter Valid Surname.</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="mb-3" style="margin-top:38px;">
					<label for="" class="form-label">Full Name (संपूर्ण नाव)</label> <input
						type="text" class="form-control waterRequired"
						style="background-image: none;" id="full_name" placeholder=""
						name="fullName" value="${changeInOwnershipType.fullName}" readonly>
				</div>
			</div>

			<script>
                    function Display(id) {
                                  $('#full_name').val( $('#first_name').val()+" "+ $('#middle_name').val()+" "+ $('#last_name').val())
                            }
                    </script>




			<!-- <div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label lbleng">Plot/Flat No.
						(प्लॉट/फ्लॅट क्र.)<span class="text-danger">*</span>
					</label> <input type="text" class="form-control waterRequired"
						style="background-image: none;" id="plot_no" placeholder=""
						pattern="^\s*\S.*$" onchange="change(this.id)" name="plotNo"
						value="${changeInOwnershipType.plotNo}" maxlength="80" required>
					<div class="invalid-feedback">Please Enter Valid Plot Number.</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label lbleng">Name of Building
						(इमारतीचे नाव)</label> <input type="text"
						class="form-control waterRequired" style="background-image: none;"
						id="buildingName" value="${changeInOwnershipType.buildingName}"
						placeholder="" name="buildingName" maxlength="80"
						onchange="change(this.id)" value="">
					<div class="invalid-feedback">Please Enter Valid Building
						Name.</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label lbleng">Name of the Street
						(रस्त्याचे नाव)<span class="text-danger">*</span>
					</label> <input type="text" class="form-control waterRequired"
						style="background-image: none;" id="street_name" placeholder=""
						pattern="^\s*\S.*$" onchange="change(this.id)" name="streetName"
						maxlength="80" value="${changeInOwnershipType.streetName}"
						required>
					<div class="invalid-feedback">Please Enter Valid Street Name.</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label lbleng">Name of the Area
						(क्षेत्राचे नाव)<span class="text-danger">*</span>
					</label> <input type="text" class="form-control waterRequired"
						pattern="^\s*\S.*$" onchange="change(this.id)"
						style="background-image: none;" id="areaName" placeholder=""
						name="areaName" maxlength="80"
						value="${changeInOwnershipType.areaName}" required>
					<div class="invalid-feedback">Please Enter Valid Area Name.</div>
				</div>
			</div>



			<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label lbleng">Nearby Landmark
						(जवळील लँडमार्क)</label> <input type="text"
						class="form-control waterRequired" style="background-image: none;"
						id="landmark" placeholder="" maxlength="80"
						value="${changeInOwnershipType.landmark}"
						onchange="change(this.id)" name="landmark">
				</div>
			</div>
			<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label ">City Name (शहराचे नाव)<span
						class="text-danger" style="color: red;">*</span></label> <input
						type=" text" class="form-control waterRequired"
						style="background-image: none;" id="city" placeholder=""
						name="applicantcity"
						value="${changeInOwnershipType.applicantcity}"
						onchange="change(this.id)" pattern="^\s*\S.*$" required>
					<div class="invalid-feedback">Please Enter Valid City Name.</div>
				</div>
			</div>


			<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label lbleng">Pin Code (पिन कोड)<span
						class="text-danger">*</span></label> <input type="text"
						class="form-control waterRequired" style="background-image: none;"
						pattern="^(?!0{6}$)\d{6}$" name="pinCode"
						value="${changeInOwnershipType.pinCode}" maxlength="6"
						onchange="change(this.id)" id="pin_code" required>
					<div class="invalid-feedback">Please Enter Valid Pin Code.</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label"> Aadhaar No. (आधार क्र.) </label>
					<input type="text" class="form-control waterRequired "
						style="background-image: none;" id="aadhaarNumber1" placeholder=""
						name="aadharNo" value="${changeInOwnershipType.aadharNo}"
						pattern="(?!0{12}$)[0-9]{12}" maxlength="12">
					<div class="invalid-feedback">Please Enter Valid Aadhaar No.
					</div>
				</div>
			</div>-->
			<div class="col-md-3">
				<div class="mb-3" style="margin-top:38px;">
					<label for="" class="form-label"> Alternate Mobile No. (पर्यायी मोबाईल क्र.)
					</label> <input type="text" class="form-control waterRequired "
						style="background-image: none;" id="contact_no"
						placeholder="" name="alterMobileNo"
						value=""
						pattern="[6-9]{1}[0-9]{9}" maxlength="10">
					<div class="invalid-feedback">Please Enter Valid Mobile No.</div>
				</div>
			</div>
		
			
			<div class="col-md-6">
					<div class="mb-3 mt-3">
						<label for="" class="form-label ">Address For
							Correspondence (पत्रव्यवहारासाठी पत्ता)<span
						class="text-danger">*</span></label>
						<textarea oninput="validateTextarea()" type=" text"
							maxlength="255" class="form-control"
							style="background-image: none;" id="Address" placeholder=""
							name="addressForCorrespondence" value="" rows="2" required></textarea>
					
						
						<div class="invalid-feedback" id="errorFeedback">Please
							Enter Valid Address.</div>
					</div>
				</div>
			<script>
                        function change()
                        {
                            var isOperated = $("#yes").prop('checked');
                            if(isOperated==true){
                            $("#myTextarea").attr("readonly", false);
                            $("#myTextarea").val($("#plot_no").val()+","+$("#buildingName").val()+","+$("#street_name").val()+","+$("#areaName").val()+","+$("#landmark").val()+","+$("#city").val()+","+$("#pin_code").val())
                             } else{
                            $("#myTextarea").val("")
                             }
                        }

                    </script>

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

	

				<!-- <div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Deposit Receipt
							No. (ठेव पावती क्र) </label> <input type="text"
							class="form-control waterRequired"
							style="background-image: none;" name="depositReceiptNo"
							value="${changeInOwnershipType.depositReceiptNo}">

					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-4">
						<label for="" class="form-label">Deposit Receipt Date (जमा
							पावतीची तारीख)</label> <input type="date"
							class="form-control waterRequired"
							style="background-image: none;" id="" placeholder=""
							maxlength="10" value="${waterReconnection.depositReceiptDate}"
							name="depositReceiptDate">
					</div>
				</div>-->

				<script>
    
    var currentDate = new Date().toISOString().split('T')[0];

    
    var depositReceiptDateInput = document.querySelector('input[name="depositReceiptDate"]');
    depositReceiptDateInput.max = currentDate;
</script>
				<!-- <div class="col-md-12">
					<div class="mb-3 mt-3 ">
						<label for="primary_full_address" class="form-label lbleng">Purpose
							For Change In Ownership Type (मालकी प्रकारातील बदलाचा उद्देश) <span
							class="text-danger">*</span>
						</label>

						<textarea class="form-control waterRequired "
							style="background-image: none;" rows="2" id=""
							name="purposeOfOwnership" required> ${changeInOwnershipType.purposeOfOwnership}</textarea>
						<div class="invalid-feedback">Please Enter Valid Purpose Of
							Ownership.</div>
					</div>
				</div>-->

				<div class="row">

					<h6 style="background-color: white; padding: 5px;"
						class="mt-1 rounded-2">
						<strong> List of Documents (with attachment) (दस्तऐवजांची
							यादी (सह संलग्नक)) </strong>
					</h6>
					<div class="alert alert-info mb-2 p-2 mb-4">
						<small><strong>Note: </strong> Upload below files only
							.pdf</small>
					</div>

					<input type="hidden" name="filesPath" id="filesPath" />
					<div class="col-md-3">
						<div class="mb-3" style="margin-top:48px;">
							<label for="" class="form-label"> Self-Attested Applicant's ID Proof
								(स्वयं-साक्षांकित अर्जदाराचा ओळखपत्र पुरावा)<span class="text-danger"
								style="color: red;">*</span>
							</label> <input type="file" class="form-control waterRequired"
								style="background-image: none;" id="doc1" accept=".pdf"
								name="applicantIDProof" required>
							<div class="invalid-feedback">File selected is either
								greater than 2Mb or not of type .pdf.</div>

						</div>
					</div>

					<div class="col-md-3">
						<div class="mb-0" style="margin-top:48px;">
							<label for="" class="form-label">Copy Of Latest Paid Bill (नवीनतम देय बिलाची प्रत)<span class="text-danger" style="color: red;">*</span>
							</label> <input type="file" class="form-control waterRequired"
								style="background-image: none;" id="doc2" accept=".pdf"
								name="copyOfCurrentBill" required>
							<div class="invalid-feedback">File selected is either
								greater than 2Mb or not of type .pdf.</div>
						</div>
					</div>

					<!-- <div class="col-md-3">
						<div class="mb-0 mt-0">
							<label for="" class="form-label">Copy Of Demand Paid
								Receipt (डिमांड पेड पावतीची प्रत) 
							</label> <input type="file" class="form-control waterRequired"
								style="background-image: none;" id="doc3" accept=".pdf"
								name="copyOfDemandPaidReceipt">
							<div class="invalid-feedback">File selected is either
								greater than 2Mb or not of type .pdf.</div>
						</div>
					</div>-->




					<div class="col-md-3">
						<div class="mb-3 mt-0">
							<label for="" class="form-label"> Copy Of Address/Ownership Proof/Tax Receipt/Sale Deed/Gift Deed (पत्त्याची प्रत/मालकीचा पुरावा/कर पावती/विक्री करार/भेटपत्र)<span
								class="text-danger" style="color: red;">*</span>
							</label> <input type="file" class="form-control waterRequired"
								style="background-image: none;" name="ownershipProof" id="doc3"
								accept=".pdf" placeholder="" required="true">
							<div class="invalid-feedback">File selected is either
								greater than 5Mb or not of type .pdf.</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="mb-3" style="margin-top:47px;">

							<label class="form-label lbleng">Any other Supporting document
								(इतर कोणतेही सहाय्यक दस्तऐवज)
							</label> <input type="file" class="form-control waterRequired "
								accept=".pdf" style="background-image: none;" id="doc4"
								placeholder="" name="signatureOfConsumer" >
							<div class="invalid-feedback">File selected is either
								greater than 2Mb or not of type .pdf.</div>
						</div>

					</div>
</div>
</div>
<br>							<div class="form-group">
    <label for="agreementPdf" class="control-label" style="    color: chocolate;
    font-weight: bold;">
        <i class="far fa-file-pdf mr-2"></i> Refer attached PDF: Agreement for Supply of Water.&nbsp;&nbsp;<a class="fa fa-download" onClick="downloadFile()" style="color: blue; font-size: medium;"></a>
        
    </label>
    <div class="d-flex align-items-center">
            <input type="text" class="form-control mr-3" style="font-family: serif;" id="agreementPdf" name="agreementPdf" value="Note: Keep it ready before Site inspection for further processing." readonly>
    </div>
    
</div>
					<div class="col-md-12">
						<div class="mb-5 mt-4 ">
							<div class="form-check">
								<input class="form-check-input" type="checkbox" id="check11"
									name="declaration" value="something" required> <label
									class="form-check-label ms-3 lbleng" style="margin-top: 0px;">
									<strong>Declaration (घोषणा)<span class="text-danger"
										style="color: red;">*</span>:-
								</strong>The above mentioned information is true to the best of my
									knowledge and belief. (वर नमूद केलेली माहिती माझ्या माहितीनुसार
									आणि विश्वासानुसार खरी आहे).
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
							<button class="btn btn-success btn_sm" type="submit" id="submit">Submit</button>

						</div>
					</div>
				</div>
			</div>

<script>
    function downloadFile() {
        var fileUrl = "<c:out value="${contextRoot}"/>/pages/citizendocument/Agreement.pdf";
        var fileName = "Agreement.pdf";
        
        var downloadLink = document.createElement("a");
        downloadLink.href = fileUrl;
        downloadLink.download = fileName;
        document.body.appendChild(downloadLink);
        downloadLink.click();
        document.body.removeChild(downloadLink);
    }
</script>
</form>
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

				<h6>
					<strong>Note(नोंद): </strong> Upload below files in .pdf...(खालील फाइल .pdf मध्ये अपलोड करा.)
				</h6>

			</div>

			<!-- dialog body -->

			<div class="modal-body" style="color: green">



				<p style="color: red">

					<strong>List of document to be attached :</strong>

				</p>

				<ul style="color: rgb(3, 125, 76)">



					<li>1.Self-Attested Applicant's ID Proof (स्वयं-साक्षांकित अर्जदाराचा ओळखपत्र पुरावा)(Max upto 2 MB)<span class="text-danger" style="color: red;">*</span></li>
					<li>2.Copy Of Latest Paid Bill (नवीनतम देय बिलाची प्रत)(Max upto 2 MB)<span class="text-danger" style="color: red;">*</span></li>
					<li>3.Copy Of Address/Ownership Proof/Tax Receipt/Sale Deed/Gift Deed (पत्त्याची प्रत/मालकीचा पुरावा/कर पावती/विक्री करार/भेटपत्र)(Max upto 5 MB)<span class="text-danger" style="color: red;">*</span>	</li>
					<li>4.Any other Supporting document(इतर कोणतेही सहाय्यक दस्तऐवज)(Max upto 2 MB)</li>

				</ul>

			</div>

			<!-- dialog buttons -->

			<div class="modal-footer">
				<button type="button" class="btn btn-primary">OK</button>
			</div>

		</div>

	</div>

</div>


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
                            var maxSize = fileInput.id === 'doc3' ? 5000000 : 2000000; // 5 MB for doc3, 2 MB for others
                           if (!(name.endsWith('.pdf'))) {
                               isFormValid = false;
                               fileInput.classList.remove('is-valid');
                               fileInput.classList.add('is-invalid');
                           } else if (fileInput.files[0].size >= maxSize) {
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
                              onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveChangeInOwnershipType.do'); 
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
           var maxSize = this.id === 'doc3' ? 5000000 : 2000000; 
           if ((this.files[0].size < maxSize) && !(name.endsWith('.pdf'))) {
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
 data.append('idProof5', $("#doc4").get(0).files[0]);
// data.append('idProof6', $("#doc6").get(0).files[0]);

           var isFileSelected = false
           const id = Math.floor(Math.random() * 9000) + 1000;
           var array_element = "";
           var file = $('input[type="file"]');
           for (var i = 0; i < file.length; i++) {
                  array_element = file[i];
                  var element = array_element.value.split("\\");
                  var a = element[element.length-1];
                  const splitName = a.split(".pdf")[0].replaceAll(/[^a-zA-Z0-9]/g, ""); 
                  const value = splitName + ".pdf";
                   if(a==='' || a===undefined){
                      filesPath += "null" + ",";
                       isFileSelected = false;
               } else {
                   filesPath = filesPath + basePath + "ChangeInOwnershipType/" + id + value + ","
                   isFileSelected = true;
               }
           }
          
           $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadChangeInOwnershipType.do?id="+id, 
               type: 'POST',
               data: data,
               cache: false,
               dataType: 'json',
               processData: false,
               contentType: false,
               async: false, // Set to synchronous
               success: function(data) {
                   var status = data.status;
                   if (callback && typeof callback === 'function' && status===true) {
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

           filesPath = filesPath.substring(0, filesPath.lastIndexOf(","));
           filesPath = filesPath.replace(/\s/g, "");
           $("#filesPath").val(filesPath);
           console.log(filesPath);

       }
   </script>
   
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
	<link rel="stylesheet" href="<c:out value=" ${contextRoot}" />/pages/core-pages/nmc_user/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<c:out value=" ${contextRoot}" />/pages/core-pages/nmc_user/css/style2.css" /> 
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


<script>
function showCustomAlert(message) {
    // Dynamically create modal elements
    var overlay = $('<div class="custom-alert-overlay"></div>');
    var modal = $('<div class="custom-alert-modal"></div>');
    //var closeBtn = $('<span class="custom-alert-close-btn" onclick="closeCustomAlert()">&times;</span>');
    var content = $('<div id="custom-alert-content"></div>');

    // Append elements to modal
   // modal.append(closeBtn);
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
                url: "${pageContext.request.contextPath}/rtsapplication/getConnectionInuseDetails.do?cinNo=" + cinValue,
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
label {
	font-weight: 600;
}

h3 {
	font-weight: 500;
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

       <form class="needs-validation" novalidate>
        <div class="container-fluid mt-4" style="width: 190vh">
            
            <div class="printable">
                <h3  class="text-center">Application Form For Change Of Category (ग्राहक प्रकारामध्ये बदल करणे अर्ज)</h3>
            </div>
           
             <h6 style="background-color:#dce2e8; padding:10px;" class=" mt-3 rounded-2"><strong> Application Form
                    Details (अर्ज तपशील)</strong></h6>
                    
                   
            <div class="row">
            	<input type="hidden" name="str" value="<c:out value='${str}'/>">
			<input type="hidden" name="serviceId" value="<c:out value='${serviceId}'/>">
			<input type="hidden" name="fields" value="<c:out value='${fields_aps}'/>">
			<input type="hidden" name="distric" value="<c:out value='${distric}'/>">
			<input type="hidden" name="trackid" value="<c:out value='${trackid}'/>">
			<input type="hidden" name="user" value="<c:out value='${user}'/>">
			<input type="hidden" name="mobile" value="<c:out value='${mobile}'/>">
			<input type="hidden" name="name" value="<c:out value='${name}'/>">
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
					<label for="" class="form-label lbleng">Zone No. (झोन क्र.)<span
						class="text-danger" style="color: red;">*</span>
					</label> <input type="text" class="form-control waterRequired "
						style="background-image: none;" id="zone" name="zoneNo"
						value="${zoneName}" readonly>

					<div class="invalid-feedback">Please Select Zone No.</div>
				</div>
			</div>

              <div class="col-md-3">
				<div class="mb-3 mt-3">
					<label for="" class="form-label lbleng">Consumer Name
						(ग्राहकाचे नाव)<span class="text-danger" style="color: red;">*</span>
					</label> <input type="text" class="form-control waterRequired"
						style="background-image: none;" id="consName" name="consumerName"
						value="${responseData.getData().get(0).getConsumerName()}"
						pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" readonly>
					<div class="invalid-feedback">Please Enter Valid Consumer
						Name.</div>
				</div>
			</div>
             
			
			
             <!--  <div class="col-md-3">
				<div class="mb-3" style="margin-top: 16px;">
					<label for="" class="form-label lbleng">Consumer No.
						(ग्राहक क्र.)</label> <input type="text" class="form-control waterRequired"
					pattern="^\s*\S.*$"		style="background-image: none;" name="consumerNo" value="${waterConnectionUsag.consumerNo}"
					maxlength="20"	>
					<div class="invalid-feedback">Please Enter Valid Consumer No
					</div>
				</div>
			</div> -->
              <div class="col-md-3" id="a3">
				<div class="mb-3" style="margin-top: 16px;">
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
 <div class="col-md-3">
                    <div class="mb-3 mt-3 ">
                        <label for="primary_full_address" class="form-label lbleng">Consumer Address (ग्राहक पत्ता)<span class="text-danger" >*</span></label>

                        <textarea class="form-control " style="background-image: none;" rows="2" id="consAddress" name="consumerAddress" value="" required readonly>${responseData.getData().get(0).getAddress()}</textarea>
                        <div class="invalid-feedback">
                            Please Enter Valid Consumer Address.
                        </div>
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

                        <label for="email" class="form-label lbleng"> Consumer Email Id (ग्राहकाचे ई - मेल आयडी)<span
							class="text-danger" style="color: red;">*</span> </label>
                        <input type="email" class="form-control " style="background-image: none;" id="email_id" placeholder="" name="email" value="${waterConnectionUsag.email}"
                          required readonly>
                            <div class="invalid-feedback">
                                Please Enter Valid Email Id.
                            </div>
                    </div>
                </div>



                <div class="col-md-3">
				<div class="mb-3" style="margin-top:38px;">
                        <label for="" class="form-label"> Consumer Mobile No. (ग्राहकाचे मोबाईल क्र.)<span class="text-danger"
                            style="color: red;">*</span>
                        </label>
                        <input type="text" class="form-control " style="background-image: none;" id="contact_no" placeholder="" name="mobileNo" value="${waterConnectionUsag.mobileNo}"
                        pattern="[6-9]{1}[0-9]{9}"
                        maxlength="10" readonly required>
                     <div class="invalid-feedback">
						Please Enter Valid Mobile No.
					</div>
                    </div>
                    </div>
                 <!--  <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label lbleng">Exiting Category (विद्यमान श्रेणी)<span class="text-danger">*</span> 
                                                </label>

                        <select class="form-select" style="background-image: none;" name="exitingCategory" required>
                                   <option value="">-Select-</option>
                            <option value="R1-Residential">R1-Residential</option>
                            <option value="Slum">Slum</option>
                            <option value="IA (Institutional A)">IA (Institutional A)</option>
                            <option value="IB (Institutional A)">IB (Institutional B)</option>
                                            <option value="C1A (Commercial A)">C1A (Commercial A)</option>
                                            <option value="C1B (Commercial B)">C1B (Commercial B)</option>
                                            <option value="C2 (Commercial 2)">C2 (Commercial 2)</option>
                        
                        </select>
                        <div class="invalid-feedback">
                            Please Select Valid Exiting Category.
                        </div>
                    </div>
                </div> -->
                
                <div class="col-md-3">
				<div class="mb-3" style="margin-top:30px;">
					<label for="" class="form-label"> Alternate Mobile No. (पर्यायी मोबाईल क्र.)
					</label> <input type="text" class="form-control waterRequired "
						style="background-image: none;" id="contact_no"
						placeholder="" name="alterMobileNo"
						value=""
						pattern="[6-9]{1}[0-9]{9}" maxlength="10">
					<div class="invalid-feedback">Please Enter Valid Mobile No.</div>
				</div>
			</div>
                 <div class="col-md-3">
                    <div class="mb-3" style="margin-top:30px;">
                        <label for="" class="form-label lbleng">Proposed Category (प्रस्तावित श्रेणी)<span class="text-danger">*</span> 
                                                </label>
<select id="proposedCategory" class="form-control" style="width: 263px; height: 35px; background-image: none;" name="proposedCategory" required>

									<option value="" selected disabled>--- Select---</option>
									
									<c:forEach var="proposedCategoryType" items="${requestScope.proposedCategoryType}">
										<option value="${proposedCategoryType.categorytypeNameValue}">
											<c:out value="${proposedCategoryType.categorytypeNameValue}" />
										</option>
										</c:forEach>
								</select>
								
								
                        <!-- <select class="form-select" style="background-image: none;" name="proposedCategory" id="waterform" required>
                            <option value="">-Select-</option>
                            <option value="R1-Residential">R1-Residential</option>
                            <option value="Slum">Slum</option>
                            <option value="IA (Institutional A)">IA (Institutional A)</option>
                            <option value="IB (Institutional A)">IB (Institutional B)</option>
                                            <option value="C1A (Commercial A)">C1A (Commercial A)</option>
                                            <option value="C1B (Commercial B)">C1B (Commercial B)</option>
                                            <option value="C2 (Commercial 2)">C2 (Commercial 2)</option>
                        
                        
                        </select>-->
                        <div class="invalid-feedback">
                            Please Select Valid Proposed Category .
                        </div>
                    </div>
                </div>
                
					<div class="col-md-4" id="noResFlatlabel">
    <div class="mb-3" style="margin-top:7px;">
        <label for="" class="form-label"> Total number of Residental Flat/Tenement/Dwelling Unit (निवासी सदनिका/निवासी/निवासी युनिटची एकूण संख्या)<span class="text-danger" style="color: red;" required>*</span></label>
        <input id="noResFlat" type="text" class="form-control" style="background-image: none;" placeholder="" name="totalNumberOfResidentialFlats" value="" required maxlength="3"String pattern = "[1-9][0-9]{0,2}";
>
        <div class="invalid-feedback">
            Please enter a valid total number of Residental Flat/Tenement/Dwelling Unit.
        </div>
    </div>
</div>
					
                </div>
<br>

              <!--   <div class="col-md-3">
                    <div class="mb-3" style="margin-top:16px;">
                        <label for="" class="form-label lbleng">Deposit Receipt No. (ठेव पावती क्र.) </label>

                        <input type="text" class="form-control" style="background-image: none;" name="dreceiptNo" value="${waterConnectionUsag.dreceiptNo}"
                            >
							<div class="invalid-feedback">
                                Please Enter Valid Deposit No.
					</div>
                    </div>
                </div>
          
				<div class="col-md-3">
    <div class="mb-3 mt-3">
        <label for="" class="form-label">Deposit Receipt Date (जमा पावतीची तारीख)</label>
        <input type="date" class="form-control waterRequired" style="background-image: none;" id="" placeholder="" maxlength="10" value="${waterReconnection.depositReceiptDate}" name="receiptDate">
    </div>
</div>

<script>
    
    var currentDate = new Date().toISOString().split('T')[0];

    
    var depositReceiptDateInput = document.querySelector('input[name="depositReceiptDate"]');
    depositReceiptDateInput.max = currentDate;
</script>
                
                <div class="col-md-12">
				<div class="mb-3 mt-3 ">
					<label for="primary_full_address" class="form-label lbleng">Purpose (उद्देश)<span class="text-danger">*</span>
					</label>

					<textarea class="form-control waterRequired "
						style="background-image: none;" rows="2" id=""
						name="purpose" required> ${changeInOwnershipType.purpose}</textarea>
					<div class="invalid-feedback">Please Enter Valid Purpose.</div>
				</div>
			</div>
			
			
            </div>
<hr><hr>
-->
            <!--  <h6 style="background-color:#dce2e8; padding:10px;" class="  rounded-2"><strong> Applicant Details (अर्जदाराचे तपशील)</strong>
            </h6>
            <div class="row">
                <input type="hidden" name="_token" value="xyz">
                <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label lbleng">Title (शीर्षक)<span class="text-danger">*</span> 
                                                </label>

                        <select class="form-select" style="background-image: none;" name="title" required>
                            <option value="">-Select-</option>
                            <option value="Mr.(श्री.)">Mr.(श्री.)</option>
                            <option value="Mrs.(सौ.)">Mrs.(सौ.)</option>
                            <option value="Ms.(कु.)">Ms.(कु.)</option>
                        </select>
                        <div class="invalid-feedback">
                            Please Select Valid Title.
                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label lbleng">Name (नाव)<span class="text-danger" >*</span></label>
        
                        <input type="text" class="form-control" style="background-image: none;" id="first_name" placeholder="" name="firstName" value="${waterConnectionUsag.firstName}"
                        pattern="[A-Za-z]+" onchange="Display(this.id)" maxlength="40"required>
                        <div class="invalid-feedback">
                            Please Enter Valid Name.
                        </div>
                    </div>
                </div>
        
                <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label lbleng">Father's Name (वडिलांचे नाव)</label>
        
                        <input type="text" class="form-control" style="background-image: none;" id="middle_name" placeholder="" name="middleName" value="${waterConnectionUsag.middleName}"
                        pattern="[A-Za-z]+" onchange="Display(this.id)">
                       
                            
                    </div>
                </div>
        
                <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label lbleng">Surname (आडनाव)<span class="text-danger" style="color: red;">*</span></label>
                        <input type="text" class="form-control" style="background-image: none;" name="lastName" id="last_name"  maxlength="80"value="${waterConnectionUsag.lastName}" pattern="[A-Za-z]+" onchange="Display(this.id)" required>
                        <div class="invalid-feedback">
                            Please Enter Valid Surname.
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label">Full Name (संपूर्ण नाव)</label>
            
                        <input type="text" class="form-control" style="background-image: none;" id="full_name" placeholder="" name="fullName" value="${waterConnectionUsag.fullName}" readonly>
                    </div>
                </div>


                <script>
                    function Display(id) {
                                  $('#full_name').val( $('#first_name').val()+" "+ $('#middle_name').val()+" "+ $('#last_name').val())
                            }
                    </script>


                <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label lbleng">Plot/Flat No. (प्लॉट/फ्लॅट क्र.)<span class="text-danger" >*</span></label>

                        <input type="text" class="form-control" pattern="^\s*\S.$"	 maxlength="80" pattern="^\s\S.*$" style="background-image: none;" id="plot_no" 	onchange="change(this.id)" placeholder="" name="plotNo" value="${waterConnectionUsag.plotNo}" required>
                        <div class="invalid-feedback">
                           Please Enter Plot/Flat No.
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label lbleng">Name of Building (इमारतीचे नाव)</label>

                        <input type="text" class="form-control" pattern="^\s*\S.*$" maxlength="80" style="background-image: none;" id="buildingName" placeholder="" onchange="change(this.id)" name="buildingName" value="${waterConnectionUsag.buildingName}">
                        <div class="invalid-feedback">
                            Please Enter Valid Building Name.
                         </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label lbleng">Name of the Street (रस्त्याचे नाव)<span class="text-danger" >*</span></label>

                        <input type="text" class="form-control"  pattern="^\s*\S.*$"maxlength="80" style="background-image: none;" id="street_name" onchange="change(this.id)" placeholder="" name="streetName" value="${waterConnectionUsag.streetName}"
                            required>
                            <div class="invalid-feedback">
                                Please Enter Valid Street Name.
                             </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label lbleng">Name of the Area (क्षेत्राचे नाव)<span class="text-danger" >*</span></label>

                        <input type="text" class="form-control"  pattern="^\s*\S.*$" maxlength="255" style="background-image: none;" id="areaName" placeholder="" maxlength="80" name="areaName" value="${waterConnectionUsag.areaName}" required>
                        <div class="invalid-feedback">
                            Please Enter Valid Area Name.
                         </div>
                    </div>
                </div>



                <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label lbleng">Nearby Landmark (जवळील लँडमार्क)</label>

                        <input type="text" class="form-control" pattern="^\s*\S.*$" maxlength="255"  style="background-image: none;" id="landmark" placeholder="" name="landmark" 	onchange="change(this.id)" value="${waterConnectionUsag.landmark}">
                    </div>
                </div>
              <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">City Name (शहराचे नाव)<span class="text-danger"
                                    style="color: red;">*</span></label>
                           
                            <input type=" text" class="form-control waterRequired" style="background-image: none;" id="city" placeholder="" name="applicantcity"
                                value="${waterConnectionUsag.applicantcity}" onchange="change(this.id)" pattern="^\s*\S.*$"  required>
                                 <div class="invalid-feedback">
                                Please Enter Valid City Name.
                            </div>
                        </div>
                    </div>
              
                <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label lbleng">Pin Code (पिन कोड)<span class="text-danger" >*</span></label>

                        <input type="text" class="form-control" style="background-image: none;" pattern="[0-9]{6}" name="pincode" id="pin_code"	onchange="change(this.id)" value="${waterConnectionUsag.pincode}"
                        maxlength="6" required>
                        <div class="invalid-feedback">
                Please Enter Valid Pin Code.
            </div>
                    </div>
                </div>
				<div class="col-md-3">
                <div class="mb-3 mt-3">
                    <label for="" class="form-label"> Aadhaar No. (आधार क्र.)
                    </label>
                    <input type="text" class="form-control " style="background-image: none;" id="aadhaarNumber1" placeholder="" name="aadhaarNo" value="${waterConnectionUsag.aadhaarNo}"
                    pattern="[0-9]{12}"
                     maxlength="12">
                     <div class="invalid-feedback">
                     Please Enter Valid Aadhaar No.
                 </div>
                </div>
            </div>
                <div class="col-md-3">
                    <div class="mb-3 mt-3">

                        <label for="email" class="form-label lbleng"> Email Id (ई - मेल आयडी)<span class="text-danger" >*</span> </label>
                        <input type="email" class="form-control " style="background-image: none;" id="email" placeholder="" name="email" value="${waterConnectionUsag.email}"
                            required>
                            <div class="invalid-feedback">
                                Please Enter Valid Email Id.
                            </div>
                    </div>
                </div>



                <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label"> Mobile No. (मोबाईल क्र.)<span class="text-danger"
                            style="color: red;">*</span>
                        </label>
                        <input type="text" class="form-control " style="background-image: none;" id="txtMobileNumber" placeholder="" name="mobileNo" value="${waterConnectionUsag.mobileNo}"
                        pattern="[6-9]{1}[0-9]{9}"
                        maxlength="10" required>
                     <div class="invalid-feedback">
						Please Enter Valid Mobile No.
					</div>
                    </div>
                </div>
                <div class="col-md-12">
                            <div class="mb-3 mt-3">
                                <label for="" class="form-label ">Address For Correspondence (पत्रव्यवहारासाठी पत्ता)&nbsp;&nbsp;(Same as
							above (वरील
							प्रमाणे)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="radio" class="form-check-input" name="yes" id="yes"
							onclick="change(this.id)"> Yes
							(होय)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
							type="radio" class="form-check-input" name="yes" id="no"
							onclick="change(this.id)">No (नाही)&nbsp;)<span class="mand_error" style="color: red;">*</span></label>
                             <textarea oninput="validateTextarea()" type=" text"
							maxlength="255" class="form-control"
							style="background-image: none;" id="Address" placeholder=""
							name="address" value="" rows="2" required></textarea>
		   
                                
                                <div class="invalid-feedback" id="errorFeedback">
                                    Please Enter Valid Address.
                                </div>
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
</script>-->
           


            <div class="row">

                <h6 style="background-color:white; padding:5px;" class="mt-1 rounded-2"><strong> List of Documents (with
                    attachment) (दस्तऐवजांची यादी (सह संलग्नक)) </strong></h6>
            <div class="alert alert-info mb-2 p-2 mb-4">
                <small><strong>Note: </strong> Upload below files only .pdf (Max upto 5
                    MB)(खाली फक्त .pdf फाइल अपलोड करा (कमाल 2MB पर्यंत))</small>
            </div>
            					<input type="hidden" name="filesPath" id="filesPath" />
            
            <div class="col-md-3">
                <div class="mb-3 mt-4">
                    <label for="" class="form-label"> Self-Attested Applicant's ID Proof
								(स्वयं-साक्षांकित अर्जदाराचा ओळखपत्र पुरावा)<span class="text-danger"
								style="color: red;">*</span>
                    </label>
                    <input type="file" class="form-control" style="background-image: none;" name="applicantIdProof" accept= ".pdf" id="doc1" required ">
                    <div class="invalid-feedback">
                    File selected is either greater than 2Mb or not of type .pdf.
                </div>

                </div>
            </div>

          <!--   <div class="col-md-3">
                <div class="mb-0" style="margin-top:24px;">
                    <label for="" class="form-label">Copy Of Current Bill (चालू बिलाची प्रत)<span class="text-danger"
                            style="color: red;">*</span></label>
                    <input type="file" class="form-control" style="background-image: none;" name="currentBill"
                        id="doc2" accept= ".pdf" required>
                        <div class="invalid-feedback">
                    File selected is either greater than 2Mb or not of type .pdf.
                </div>
                </div>
            </div>

           <!--  <div class="col-md-3">
                <div class="mb-0 mt-0">
                    <label for="" class="form-label">Copy Of Demand Paid Receipt (मागणी भरलेल्या पावतीची प्रत)
                       </label>
                    <input type="file" class="form-control" style="background-image: none;" name="demandReceipt"  id="doc3"accept= ".pdf">
                    <div class="invalid-feedback">
                    File selected is either greater than 2Mb or not of type .pdf.
                </div>
                </div>
            </div>


               

                <div class="col-md-3">
                    <div class="mb-3 mt-0">
                        <label for="" class="form-label"> Copy Of Address/Ownership Proof (पत्त्याची प्रत/मालकीचा पुरावा)<span class="text-danger"
                            style="color: red;">*</span></label>
                        <input type="file" class="form-control" style="background-image: none;" name="copyOfAddressFile"  id="doc3" accept =".pdf" placeholder=""
                            required="true">
                            <div class="invalid-feedback">
                                File selected is either greater than 2Mb or not of type .pdf.
                            </div>
                    </div>
                </div>-->

                <div class="col-md-3">
                    <div class="mb-3 mt-0">

                        <label class="form-label lbleng">Any other Supporting document for Change in Category (ग्राहक प्रकार बदलासाठी इतर कोणतेही सहाय्यक दस्तऐवज)<span class="text-danger"
								style="color: red;">*</span>
                     </label>
                        <input type="file" class="form-control " style="background-image: none;"  id="doc2" accept =".pdf" placeholder="" name="consumerSign" required>
                    	<div class="invalid-feedback">
                            File selected is either greater than 2Mb or not of type .pdf.
                        </div>
                    </div>

                </div>
                <div class="col-md-12">
                    <div class="mb-5 mt-4 ">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" id="check11" name="declaration"
                                value="something" required>

                            <label class="form-check-label ms-3 lbleng" style="margin-top: 0px;">
                                <strong>Declaration (घोषणा)<span class="text-danger"
                                    style="color: red;">*</span>:- </strong>The
                                above mentioned information is true to the best of my knowledge and belief (वर नमूद केलेली माहिती माझ्या माहितीनुसार आणि विश्वासानुसार खरी आहे).
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
    </form>


<script type="text/javascript">
$('.printMe').on('click', function () {

    window.print();
});
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
<div id="myModal" class="modal fade">

            <div class="modal-dialog">

                <div class="modal-content">

                    <div class="modal-header">

                        <h6><strong>Note(नोंद): </strong> Upload below files in .pdf...Max upto 2 MB(खालील फाइल .pdf मध्ये अपलोड करा..कमाल २ MB पर्यंत)</h6>

                    </div>

                    <!-- dialog body -->

                    <div class="modal-body" style="color:green">



                       <p style="color:red">

                         <strong>List of document to be attached :</strong>   

                        </p>

                        <ul style="color:rgb(3, 125, 76)">



                            <li>1.Self-Attested Applicant's ID Proof
								(स्वयं-साक्षांकित अर्जदाराचा ओळखपत्र पुरावा)<span class="text-danger"
								style="color: red;">*</span></li>
						           <li>2.Any other Supporting document for Change in Category (ग्राहक प्रकार बदलासाठी इतर कोणतेही सहाय्यक दस्तऐवज)<span class="text-danger"
								style="color: red;">*</span></li> 

                        </ul>

                    </div>

                    <!-- dialog buttons -->

                    <div class="modal-footer"><button type="button" class="btn btn-primary">OK</button></div>

                </div>

            </div>

        </div>
 
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
                        onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveWaterConnectionUsage.do');
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
         //   data.append('idProof3', $("#doc3").get(0).files[0]);
          //  data.append('idProof5', $("#doc4").get(0).files[0]);
           // data.append('idProof6', $("#doc6").get(0).files[0]);

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
                    filesPath = filesPath + basePath + "waterConnectionUsage/" + id + value + ","
                    isFileSelected = true;
                }
            }
            $.ajax({
                url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadDocumentWaterConnectionUsage.do?id="+id,
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
            
    </script>
<script>

$("#noResFlatlabel").hide();
$("#noResFlat").prop('required',false);

var water = jQuery('#waterform');
var select = this.value;
(function(){
$(".form-check-input").click(function(event){
var checkout=$(this).is(':checked');
if(x==true){
$(this).find('cal1').show();
}
})
});
water.change(function () {
if ((this).value == 'R1-Residential') {


$("#noResFlatlabel").show();
$("#noResFlat").prop('required',true);

} else{
	$("#noResFlatlabel").hide();
	$("#noResFlat").prop('required',false);
}
});
    </script>
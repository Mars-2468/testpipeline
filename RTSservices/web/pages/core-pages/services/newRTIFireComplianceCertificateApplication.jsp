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
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript"
	src="<c:out value=" ${contextRoot}" />/scripts/jquery/jquery.ajaxfileupload.js">
        </script>
<link rel="stylesheet"
	href="<c:out value='${contextRoot}'/>/pages/core-pages/nmc_user/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<c:out value='${contextRoot}'/>/pages/core-pages/nmc_user/css/style2.css" />
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://code.jquery.com/jquery-3.6.1.js">
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
///pageContext.setAttribute("statusList", CommonUtils.getStatus());%>






</script>

<script src="https://code.jquery.com/jquery-3.6.3.min.js"
	integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
	crossorigin="anonymous"></script>

</head>
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
<body>
	<form>
		<div class="container-fluid mt-2" style="width: 180vh">

			<div class="printable">
				<h3 style="text-align: center;" class=" rounded-2">
					<strong> 2) अंतिम आग संरक्षक मान्यता प्रमाणपत्र (Final
						fire safety approval Certificate) </strong>
				</h3>
			</div>
			<h6 style="background-color: #dce2e8; padding: 10px;"
				class="rounded-2">
				<strong> Applicant Details (अर्जदाराचे तपशील) </strong>
			</h6>
			<div class="row">
				<input type="hidden" name="_token" value="xyz">

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Fire RTS Id
						</label> <input type="text" class="form-control" id="firertsid"
							style="background-image: none;" placeholder=""
							onchange="getFireRtsData()" name="firertsid" value="" >
						<div class="invalid-feedback">Please Enter Valid Fire Rts
							Id.</div>
					</div>
				</div>
				<script
					src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

				<script>
				function getFireRtsData() {
				    alert("ji");
				    var fireRtsId = $("#firertsid").val();

				    $.ajax({
				        type: "POST",
				        url: "${pageContext.request.contextPath}/rtiapplication/getFireRtsDetail.do",
				        data: {
				            firertsid: fireRtsId
				        },
				        dataType: "json",
				        success: function (data) {
				            $('[name="sidemarginalspace"]').val(data.front);
				            $('[name="rear"]').val(data.rear);
				            $('[name="plotarea"]').val(data.plotArea);
				            $('[name="totalbuiltuparea"]').val(data.buildUpArea);
				     
				            
				            if (data.noofInternalStaircase) {
				                var noofInternalStaircase = data.noofInternalStaircase.split(',');
				                var widthInternalStaircaseProvided = data.widthInternalStaircaseProvided.split(',');
				                var srNumber = 1;
				                var tableBody = $('#heightTable tbody');
				                tableBody.empty();
				                noofInternalStaircase.forEach(function(noofInternalStaircaseItem, index) {
				                    var widthInternalStaircaseItem = widthInternalStaircaseProvided[index];
				                    var row = $('<tr><td>' + srNumber + '</td>' +
				                            '<td><input type="text" class="form-control" style="background-image: none;" name="noofInternalStaircase" value="' + noofInternalStaircaseItem + '"></td>' +
				                            '<td><input type="text" class="form-control" style="background-image: none;" name="widthInternalStaircase" value="' + widthInternalStaircaseItem + '"></td></tr>');
				                    tableBody.append(row);
				                    srNumber++;
				                });
				            }
				            
				            
				            if (data.noofExternalStaircase) {
				                var noofExternalStaircase = data.noofExternalStaircase.split(',');
				                var widthExternalStaircaseProvided = data.widthExternalStaircaseProvided.split(',');
				                var srNumber = 1;
				                var tableBody = $('#heightTable1 tbody');
				                tableBody.empty();
				                noofExternalStaircase.forEach(function(noofExternalStaircaseItem, index) {
				                    var widthExternalStaircaseProvidedItem = widthExternalStaircaseProvided[index];
				                    var row = $('<tr><td>' + srNumber + '</td>' +
				                            '<td><input type="text" class="form-control" style="background-image: none;" name="noofExternalStaircase" value="' + noofExternalStaircaseItem + '"></td>' +
				                            '<td><input type="text" class="form-control" style="background-image: none;" name="widthInternalStaircase" value="' + widthExternalStaircaseProvidedItem + '"></td></tr>');
				                    tableBody.append(row);
				                    srNumber++;
				                });
				            }
				            
				            if (data.noofLiftProvided) {
				                var noofLiftProvided = data.noofLiftProvided.split(',');
				                var srNumber = 1;
				                var tableBody = $('#heightTable2 tbody');
				                tableBody.empty();
				                noofLiftProvided.forEach(function(noofLiftProvidedItem, index) {
				                    var row = $('<tr><td>' + srNumber + '</td>' +
				                            '<td><input type="text" class="form-control" style="background-image: none;" name="noofLiftProvided" value="' + noofLiftProvidedItem + '"></td></tr>');
				                    tableBody.append(row);
				                    srNumber++;
				                });
				            }

				            
							},
				        error: function () {
				            // Handle error if AJAX request fails
				            // alert("Error occurred while calculating.");
				        }
				    });
				}


						</script>

			<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Provisional Fire Safety Approval<span
							class="text-danger">*</span>
						</label> <input type="text" class="form-control" id="provisionalFireSafetyApproval"
							style="background-image: none;" placeholder=""  name="provisionalFireSafetyApproval" value="" required>
						<div class="invalid-feedback">Please Enter Valid Provisional Fire Safety Approval</div>
					</div>
				</div>


				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Name of Building Owner<span
							class="text-danger">*</span>
						</label> <input type="text" class="form-control" id="nameofBuildingOwner"
							style="background-image: none;" placeholder="" name="nameofBuildingOwner"
							value=""   required>
						<div class="invalid-feedback">Please Enter Valid Name of Building Owner.</div>
					</div>
				</div>


				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Address of Building</label> <input
							type="text" class="form-control" id="sadressofBuilding"
							style="background-image: none;" placeholder="" name="sadressofBuilding"
							value="" >


					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Type of Building <span
							class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" name="typeofBuilding" id="typeofBuilding"
							 required>
						<div class="invalid-feedback">Please Enter Valid Type of Building.</div>
					</div>
				</div>
				
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Plot area</label> <input
							type="text" class="form-control" id="plotarea"
							style="background-image: none;" placeholder="" name="plotarea"
							value="" readonly>
					</div>
				</div>


				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label class="form-label lbleng">Height of building<span
							class="text-danger">*</span>
						</label> <input class="form-control " rows="2" id="heightofBuilding"
							style="background-image: none;" name="heightofBuilding" required>
						<div class="invalid-feedback">Please Enter Valid Height of Building</div>

					</div>
				</div>
				
				
				
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label class="form-label lbleng">Rear Margin<span
							class="text-danger">*</span>
						</label> <input class="form-control " rows="2" id="rearMargin"
							style="background-image: none;" name="rearMargin" required>
						<div class="invalid-feedback">Please Enter Valid Height of Building</div>

					</div>
				</div>
				
			<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label class="form-label lbleng">Front Margin<span
							class="text-danger">*</span>
						</label> <input class="form-control " rows="2" id="frontMargin"
							style="background-image: none;" name="frontMargin" required>
						<div class="invalid-feedback">Please Enter Valid Height of Building</div>

					</div>
				</div>
				
			<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label class="form-label lbleng">Side1 Margin<span
							class="text-danger">*</span>
						</label> <input class="form-control " rows="2" id="side1Margin"
							style="background-image: none;" name="side1Margin" required>
						<div class="invalid-feedback">Please Enter Valid Height of Building</div>

					</div>
				</div>
				
			 <div class="col-md-3">
					<div class="mb-3 mt-3">
						<label class="form-label lbleng">Side2 Margin<span
							class="text-danger">*</span>
						</label> <input class="form-control " rows="2" id="side2Margin"
							style="background-image: none;" name="side2Margin" required>
						<div class="invalid-feedback">Please Enter Valid Height of Building</div>

					</div>
				</div>
				
				
				
				
	
<div class="table-responsive" style="display: flex; justify-content: space-between;">
    <div style="width: 49%;">
    <label>Number of Internal Staircase Provided</label>
        <table id="heightTable" class="table table-striped table-bordered" style="width: 100%;background-color: #dce2e8;">
            <thead style="background-color: #dce2e8;">
                <tr>
                    <th>Sr Number</th>
                    <th>Width of Internal Staircase</th>
                    <th>From</th> 
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
    <div style="width: 49%;">
        <label>Number of External Staircase Provided</label>
        <table id="heightTable1" class="table table-striped table-bordered" style="width: 100%;background-color: #dce2e8;">
            <thead style="background-color: #dce2e8;">
                <tr>
                    <th>Sr Number</th>
                    <th>Width of External Staircase</th>
                    <th>From</th> 
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
    
</div>
<div class="table-responsive" style="display: flex; justify-content: space-between;">
 <div style="width: 49%;">
        <label>Number of External Staircase Provided</label>
        <table id="heightTable2" class="table table-striped table-bordered" style="width: 100%;background-color: #dce2e8;">
            <thead style="background-color: #dce2e8;">
                <tr>
                    <th>Sr Number</th>
                    <th>Width of External Staircase</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>





				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label class="form-label lbleng"> House Mouza No<span
							class="text-danger">*</span>
						</label> <input class="form-control " rows="2" id="HouseMouzaNo"
							style="background-image: none;" name="housemouzano" required>
						</textarea>
						<div class="invalid-feedback">Please Enter Valid House Mouza
							No</div>

					</div>
				</div>



				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Pin Code <span
							class="text-danger">*</span>
						</label> <input type="text" class="form-control" pattern="[0-9]{6}"
							style="background-image: none;" name="pincode" value=""
							maxlength="6" id="pincode" required>
						<div class="invalid-feedback">Please Enter Valid Pin Code.</div>

					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label class="form-label lbleng"> Landmark<span
							class="text-danger">*</span>
						</label> <input class="form-control " rows="2" id="Landmark"
							style="background-image: none;" name="landmark" required>
						</textarea>
						<div class="invalid-feedback">Please Enter Valid Landmark</div>

					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">

						<label for="email" class="form-label lbleng"> Email Id<span
							class="text-danger">*</span>
						</label> <input type="email" class="form-control "
							style="background-image: none;" name="emailid" value=""
							id="emailid" required>
						<div class="invalid-feedback">Please Enter Valid Email Id.</div>
					</div>
				</div>


				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label"> Mobile No.<span
							class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control " id="mobileno"
							style="background-image: none;" placeholder="" name="mobileno"
							value="" pattern="[6-9]{1}[0-9]{9}" maxlength="10" required>
						<div class="invalid-feedback">Please Enter Valid Mobile No.</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label class="form-label lbleng"> Name of Power of
							Attorney <span class="text-danger">*</span>
						</label> <input class="form-control " rows="2" id="NameofPowerofAttorney"
							style="background-image: none;" name="nameofpowerofattorney"
							required>
						<div class="invalid-feedback">Please Enter Valid Name of
							power of Attorney.</div>

					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="primary_full_address" class="form-label lbleng">
							No.of standby <span class="text-danger">*</span>
						</label> <input class="form-control " rows="2" id="noofstandby"
							style="background-image: none;" name="noofstandby" required>
						<div class="invalid-feedback">Please Enter Valid No.od
							Attorney.</div>

					</div>
				</div>

				<div class="col-md-12">
					<div class="mb-3 mt-3">
						<label for="primary_full_address" class="form-label lbleng">
							Address of Power of Attorney <span class="text-danger">*</span>
						</label>

						<textarea class="form-control " rows="2"
							id="AddressofPowerofAttorney" style="background-image: none;"
							name="addressofpowerofattorney" required></textarea>
						<div class="invalid-feedback">Please Enter Valid Address.</div>

					</div>
				</div>

			</div>
			


						<div class="row">

							<h6 style="background-color: white; padding: 10px;"
								class="mt-3 rounded-2">
								<strong> List of Documents (with attachment) </strong>
							</h6>

							<div class="alert alert-info mb-0 p-2 mb-4">
								<small><strong>Note: </strong> Upload Below Files only
									pdf, .jpg, .jpeg, .bmp etc..(Max upto 5MB) </small>
							</div>

							<input type="hidden" name="filesPath" id="filesPath" />

							<div class="col-md-3">
								<div class="mb-3 mt-3 ">
									<label for="" class="form-label">Fitness certificate
										from licensing agency<span class="mand_error"
										style="color: red;">*</span>
									</label> <input type="file" class="form-control"
										style="background-image: none;" id="doc1" placeholder=""
										name="Fitness_certificate _from_licensing_agency" required>
									<div class="invalid-feedback">File selected is either
										greater than 5Mb or not of type pdf</div>

								</div>
							</div>


							<div class="col-md-3">
								<div class="mb-3 mt-5">
									<label for="" class="form-label">Building Plan,Sections
										and Elevations<span class="mand_error" style="color: red;">*</span>
									</label> <input type="file" class="form-control"
										style="background-image: none;" id="doc2" placeholder=""
										name="detailed_plan" required>
									<div class="invalid-feedback">File selected is either
										greater than 5Mb or not of type pdf</div>

								</div>
							</div>
							<div class="col-md-3">
								<div class="mb-3 mt-4">
									<label for="" class="form-label">Civil Engineer
										certificate of Structural stability</label> <input type="file"
										class="form-control" style="background-image: none;" id="doc3"
										placeholder=""
										name="civil_Engineer_certificate_of_Structural_stability">

								</div>
							</div>

							<div class="col-md-3">
								<div class="mb-3 mt-4">
									<label for="" class="form-label"> Architect certificate
										for fire water tanks<span class="mand_error"
										style="color: red;">*</span>
									</label> <input type="file" class="form-control"
										style="background-image: none;" id="doc4" placeholder=""
										name="architect_certificate_for_fire_water_tanks" required>
									<div class="invalid-feedback">File selected is either
										greater than 5Mb or not of type pdf</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="mb-3 mt-3">
									<label for="" class="form-label"> Electrical inspector
										certificate <span class="mand_error" style="color: red;">*</span>
									</label> <input type="file" class="form-control"
										style="background-image: none;" id="doc5" placeholder=""
										name="electrical_inspector_certificate" required>
									<div class="invalid-feedback">File selected is either
										greater than 5Mb or not of type pdf</div>
								</div>
							</div>

							<div class="col-md-3">
								<div class="mb-3 mt-3">
									<label for="" class="form-label"> Sanctioned building
										plan <span class="mand_error" style="color: red;">*</span>
									</label> <input type="file" class="form-control"
										style="background-image: none;"
										name="sanctioned_building_plan" id="doc6" placeholder=""
										required>
									<div class="invalid-feedback">File selected is either
										greater than 5Mb or not of type pdf</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="mb-3 mt-3">
									<label for="" class="form-label"> License copy of lift<span
										class="mand_error" style="color: red;">*</span>
									</label> <input type="file" class="form-control"
										style="background-image: none;" name="License_copy_of_lift"
										id="doc7" placeholder="" required>
									<div class="invalid-feedback">File selected is either
										greater than 5Mb or not of type pdf</div>
								</div>
							</div>


							<div class="col-md-3">
								<div class="mb-3 mt-3">
									<label for="" class="form-label"> Signature <span
										class="mand_error" style="color: red;">*</span></label> <input
										type="file" class="form-control"
										style="background-image: none;" name="Signature" id="doc8"
										placeholder="" required>
									<div class="invalid-feedback">File selected is either
										greater than 5Mb or not of type pdf</div>
								</div>
							</div>
						</div>



						<div class="col-md-12">
							<div class="mb-5 mt-4 ">
								<div class="form-check">
									<input class="form-check-input" type="checkbox" id="check11"
										name="declaration" value="something" required> <label
										class="form-check-label ms-3 lbleng" style="margin-top: 0px;">
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
									View and Print</button>
								<button class="btn btn-success btn_sm" type="submit" id="submit"
									onclick="javascript:upload();">Submit</button>
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



    function permitnoo(permitno) {
        document.getElementById('permitno').innerText = permitno.value;
    }

    function reciptno(pname2) {
        document.getElementById('receiptno').innerText = pname2.value;
    }
    function letterno(pname3) {
        document.getElementById('letterno').innerText = pname3.value;
    }
    function date1(date11) {
        document.getElementById('date1').innerText = date11.value;
    }
    function date2(date12) {
        document.getElementById('date2').innerText = date12.value;
    }
    function date3(date13) {
        document.getElementById('date3').innerText = date13.value;
    }
</script>

<script type="text/javascript">
    $(document).ready(function () {

        $("#submit").click(function () {


            $("form:first").addClass("needs-validation");
            $("form:first").attr("novalidate", "");
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            const forms = document.querySelectorAll('.needs-validation')

            // Loop over them and prevent submission
            Array.from(forms).forEach(form => {
                form.addEventListener('submit', event => {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    } else {
                        onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveFireComplianceCertificates.do');
                    }

                    form.classList.add('was-validated')
                }, false)
            })
        });

        $('input,select,textarea').on('focusout', function () {

            var isFileAllowed = true;
            if (this.getAttribute("type") === 'file') {
                var name = this.files[0].name;
                if ((this.files[0].size < 5000000) && (name.endsWith('.pdf'))) {
                    isFileAllowed = true;
                } else {
                    isFileAllowed = false;
                }
            }

            if (this.checkValidity() && isFileAllowed) {
                this.classList.remove('is-invalid')
                this.classList.add('is-valid')
            } else {
                this.classList.remove('is-valid')
                this.classList.add('is-invalid')
            }
        });
    });
    
    
    
    function upload() {
        console.log("@@upoading@@");
        var url = window.location.href;
		//var url = 'https://rtsnagpur.egovmars.in'; // The window.location.href property in JavaScript returns the URL of the currently open web page. This property can even be used to update the URL of a web page.
        var basePath = url.split('${contextRoot}')[0] + '${contextRoot}/';
        var filesPath = "";
        var data = new FormData();

        data.append('idProof1', $("#doc1").get(0).files[0]);
        data.append('idProof2', $("#doc2").get(0).files[0]);
        data.append('idProof3', $("#doc3").get(0).files[0]);
        data.append('idProof4', $("#doc4").get(0).files[0]);
        data.append('idProof5', $("#doc5").get(0).files[0]);
        data.append('idProof6', $("#doc6").get(0).files[0]);
        data.append('idProof7', $("#doc7").get(0).files[0]);
        data.append('idProof8', $("#doc8").get(0).files[0]);
        var isFileSelected = false

        var array_element = "";
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
            } else {
                filesPath = filesPath + basePath + "firecompliancecertificate/" + i + value + ","
                isFileSelected = true;
            }
        }
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadDocumentFirecomplianceCertificate.do",
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false, // Don't process the files
            contentType: false // Set content type to false as jQuery will tell the server its a query string request
        }).done(function (data) {

        });

        var a = filesPath.substring(0, filesPath.lastIndexOf(","));
        filesPath = filesPath.replace(/\s/g, "");
        $("#filesPath").val(filesPath);
        console.log(filesPath);

    }
</script>
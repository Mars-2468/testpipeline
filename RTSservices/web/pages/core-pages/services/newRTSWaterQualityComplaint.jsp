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
	href="<c:out value='${contextRoot}'/>/pages/core-pages/nmc_user/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<c:out value='${contextRoot}'/>/pages/core-pages/nmc_user/css/style2.css" />
<script
	src="https:cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>
<%
pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
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
                url: "${pageContext.request.contextPath}/rtsapplication/getWaterQualityComaplaintDetails.do?cinNo=" + cinValue,
                dataType: "json",
                async: false,
                success: function (data) {
                	$("#existing").val(data.zone);
	            	$("#esr").val(data.esr);
	            	$("#cn").val(data.consumername);
	            	$("#ca").val(data.address);
	            	$("#mn").val(data.meterno);
	            	$("#meterTapSize").val(data.meterTapSize);
	            	$("#category").val(data.category);
	            	$("#balance_arrears").val(data.balance_arrears);
	            	$("#cut_off_date").val(data.cut_off_date);
	            	 $("#contact_no").val(data.contact_no);
	                    $("#email_id").val(data.email_id);
               
                    $("#cin").prop('readonly',true);

	            	 var errorMessage = data.errormsg;
	                    if(errorMessage!='' && errorMessage!=undefined){
	                        alert(errorMessage);
	                        $("#cin").prop('readonly',false);

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
                	$("#existing").val('');
	            	$("#esr").val('');
	            	$("#cn").val('');
	            	$("#ca").val('');
	            	$("#mn").val('');
	            	$("#meterTapSize").val('');
	            	$("#category").val('');
	            	$("#balance_arrears").val('');
	            	$("#cut_off_date").val('');
	            	 $("#contact_no").val('');
	                    $("#email_id").val('');
	            	   
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

<script type="text/javascript">
  
function Display(id) {
            $('#full_name').val($('#first_name').val() + " " + $('#middle_name').val() + " " + $('#last_name').val())
        }
        

       
</script>

</head>

<body>
	<form id="CanDetails" class="needs-validation" novalidate>
		<div class="container-fluid mt-2" style="width: 190vh">
			<input type="hidden" name="_token" value="xyz">
			<div class="printable">
				<h3 class="text-center">
					<strong>Application Form For Complaint Against Water Quality (पाण्याची गुणवत्ता तक्रार अर्ज)</strong>
				</h3>
			</div>
			
			<h6 style="background-color: #dce2e8; padding: 10px;"
				class="  rounded-2">
				<strong> Application Form Details (अर्जाचा तपशील)</strong>
			</h6>
			<!-- <br> -->

			<div class="row">

				<!-- <div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label ">Consumer (ग्राहक) <span
							class="text-danger" style="color: red;">*</span></label>

						<div class="d-flex mt-2 border rounded  p-2">
							<div class="form-check ms-3">
								<input type="radio" class="form-check-input" id="radio3"
									name="consumer" value="true" required>Anonymous
								Consumer (अनामिक ग्राहक) <label class="form-check-label"
									for="radio1"></label>
							</div>

							<div class="form-check ms-3">
								<input type="radio" class="form-check-input" id="radio4"
									name="consumer" value="false" required>Existing
								Consumer (विद्यमान ग्राहक)
								<div class="invalid-feedback">Please Select Valid
									Consumer.</div>
								<label class="form-check-label" for="radio1"></label>
							</div>
						</div>


					</div>

				</div>

				<script>
    $(document).ready(function() {
        $("#cin").prop("required", false);
        $("#canNumber").hide();
        $("#radio4").click(function() {
            $("#cin").prop("required", true);
            $("#canNumber").show();
    	    $("#main-dropdown").prop("required", false);
    	    $("#dependent-dropdown").prop("required", false);

            
        });
        
        $("#radio3").click(function() {
    	    $("#main-dropdown").prop("required", true);
    	    $("#dependent-dropdown").prop("required", true);
            $("#cin").prop("required", false);
            $("#canNumber").hide();
            $("#cin").val('');
           
        });
    });


</script>-->
				<div class="col-md-3" id="canNumber">

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


				<!-- <div class="col-md-3" id="zone">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Zone No. (झोन
							क्र.)<span class="text-danger" style="color: red;">*</span>
						</label> <select class="form-select waterRequired "
							style="background-image: none;" id="main-dropdown" name="zoneNo"
							required>
 <option value="" selected="">-Select Zone-</option>
                                <option value="1">Zone No.1 - Laxmi Nagar (लक्ष्मी नगर)</option>
                                <option value="2">Zone No.2 - Dharmpeth (धरमपेठ)</option>
                                <option value="3">Zone No.3 - Hanuman Nagar (वंदनीय राष्ट्रसंत तुकडोजी महाराज)</option>
                                <option value="4">Zone No.4 - Dhantoli (धंतोली)</option>
                                <option value="5">Zone No.5 - Nehru Nagar (नेहरू नगर श्रेत्रिय कार्यालय)</option>
                                <option value="6">Zone No.6 - Gandhi Zone Mahal (गांधी झोन ​​महाल)</option>
                                <option value="7">Zone No.7 - Satranjipura (सतरंजीपुरा)</option>
                                <option value="8">Zone No.8 - Lakadganj (लकडगंज)</option>
                                <option value="9">Zone No.9 - Aashi Nagar (आशी नगर)</option>
                                <option value="10">Zone No.10 - Mangalwari (मंगळवारी)</option>
            							<option value="other" style="display: none">other</option>

						</select>
						<div class="invalid-feedback">Please Select Zone No.</div>
					</div>
				</div>-->

				<div class="col-md-3" id="existingZone">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Zone No. (झोन
							क्र.)</label> <input type="text" class="form-control waterRequired"
							style="background-image: none;" id="existing" placeholder=""
							name="zoneNo" value="${zoneName}" required readonly>
						<div class="invalid-feedback">Please Enter Valid Zone No.
							</div>
					</div>
				</div>

				<div class="col-md-3" id="esistingesr">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">ESR <span class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control waterRequired"
							style="background-image: none;" id="esr" name="existingEsr"
							value="${responseData.getData().get(0).getCommand_area()}"
							pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" required readonly>
						<div class="invalid-feedback">Please Enter ESR.</div>
					</div>
				</div>

				<!-- <div class="col-md-3" id="esrdropdown">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">ESR<span
							class="text-danger" style="color: red;">*</span>
						</label> <select class="form-select " style="background-image: none;"
							id="dependent-dropdown" name="esr" disabled required>

							<option value="" selected="">-Select ESR-</option>
							<option value="50">GAYATRINAGAR EXISTING ESR</option>
							<option value="44">JAITALA PROPOSED ESR</option>
							<option value="49">KHAMLA EXISTING ESR</option>
							<option value="48">LAXMINAGAR NEW ESR</option>
							<option value="47">LAXMINAGAR OLD ESR</option>
							<option value="46">PRATAP NAGAR PROPOSED ESR</option>
							<option value="57">TAKLISEEM EXISTING ESR - I</option>
							<option value="62">TRIMURTY NAGAR ESR</option>


							<option value="40">DABHA WADI EXISTING ESR</option>
							<option value="66">DHARAMPETH DEMO ZONE</option>
							<option value="17">DHANTOLI EXISTING ESR</option>
							<option value="34">G.H.BUILDI</option>
							<option value="51">SEMINARY HILLS EXISTING ESR</option>
							<option value="61">SEMINARY HILLS ESR</option>
							<option value="T41">TEKDI WADI EXISTING ESR</option>

							<option value="68">CHICHBHUVAN NIT PROPOSED ESR</option>
							<option value="58">CHINCHBHUVAN EXISTING ESR</option>
							<option value="25">HUDKESHWAR EXISTING ESR</option>
							<option value="65">NALANDANAGAR PROPOSED ESR</option>
							<option value="24">OMKARNAGAR EXISTING ESR</option>
							<option value="45">OMKARNAGAR PROPOSED ESR</option>
							<option value="64">SHRINAGAR PROPOSED ESR</option>


							<option value="59">HANUMANAGAR PROPOSED ESR</option>
							<option value="13">RESHIMBAGH EXISTING ESR</option>
							<option value="22">WANJARI NAGAR EXISTING ESR -I</option>
							<option value="10">WANJARI NAGAR EXISTING ESR-II</option>


							<option value="27">DIGHORI EXISTING ESR</option>
							<option value="60">KHARABI ESR</option>
							<option value="01">NANDANVAN EXT ESR</option>
							<option value="39">NANDANVAN PROPOSED ESR - I</option>
							<option value="06">NANDANVAN PROPOSED ESR II</option>
							<option value="23">SAKKARDARA EXISTING ESR I & II</option>
							<option value="26">SAKKARDARA PROPOSED ESR</option>


							<option value="11">KILLAMAHAL EXISTING ESR</option>
							<option value="16">SITABUILDI FORT-II</option>
							<option value="12">SITABURDI FORT-I</option>
							<option value="20">Godrej Anandam ESR</option>

							<option value="14">BASTARWARI PROP ESR I(PART-I)</option>
							<option value="07">BASTARWARI PROP ESR-II (PART A)</option>
							<option value="15">BASTARWARI PROP ESR-II (PART-B)</option>
							<option value="08">BORIAPURA 600 MM FEEDERMAIN</option>
							<option value="09">BORIAPURA EXISTING ESR</option>
							<option value="35">G.H.VAHANTHIKANA</option>
							<option value="03">SHANTINAGAR PROPOSED ESR</option>
							<option value="38">WANJRI EXISTING ESR</option>
							<option value="67">KALAMNA NIT ESR</option>

							<option value="29">BHANDEWADI PROPOSED ESR</option>
							<option value="04">BHARATWADI (DESHPANDE LAYOUT)
								EXISTING ESR</option>
							<option value="30">KALAMANA MINIMATA EXISTING ESR</option>
							<option value="18">LAKADGANJ EXT ESR-I</option>
							<option value="19">LAKADGANJ EXISTING ESR II</option>
							<option value="56">PARDI ROAD PROPOSED ESR - II</option>
							<option value="55">PARDI ROAD PROPOSED ESR I</option>
							<option value="28">SUBHANNAGAR EXISTING ESR</option>

							<option value="05">BEZANBAGH EXISTING ESR</option>
							<option value="02">BINAKI EXISTING ESR</option>
							<option value="43">BINAKI PROPOSED ESR - II</option>
							<option value="42">BINAKI PROPOSED ESR I</option>
							<option value="53">INDORA PRAPOSED ESR I</option>
							<option value="54">INDORA PROPOSED ESR - II</option>
							<option value="32">JARIPATKA EXISTING ESR</option>
							<option value="33">NARA EXISTING ESR</option>
							<option value="31">NARI EXISTING ESR</option>
							<option value="52">UPPALWADI(WANJRA)1 PROP ESR</option>
							<option value="69">NARA NIT PROPOSED ESR</option>

							<option value="37">GH-RAJ NAGAR</option>
							<option value="21">GITTIKHADAN EXISTING ESR (RAMDEO
								BABA)</option>
							<option value="63">GODHANI-GOREWADA PROPOSED ESR</option>
							<option value="G36">Governour House Sadar</option>

						</select>

						<div class="invalid-feedback">Please Select ESR</div>
					</div>
				</div>


				<script src="https://code.jquery.com/jquery-3.6.3.min.js"
					integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
					crossorigin="anonymous"></script>
				<script>
    $('#main-dropdown').on('change', function() {
        document.getElementById("dependent-dropdown").removeAttribute('disabled');

    var selectedValue = $('#main-dropdown').val();

var options = [];


if (selectedValue === '1') {
    options = ['-Select ESR-','GAYATRINAGAR EXISTING ESR','JAITALA PROPOSED ESR', 'KHAMLA EXISTING ESR' , 'LAXMINAGAR NEW ESR','LAXMINAGAR OLD ESR','PRATAP NAGAR PROPOSED ESR','TAKLISEEM EXISTING ESR - I','TRIMURTY NAGAR ESR'];
} else if (selectedValue === '2') {
    options = ['-Select ESR-','DABHA WADI EXISTING ESR', 'DHARAMPETH DEMO ZONE', 'DHANTOLI EXISTING ESR', 'G.H.BUILDI','SEMINARY HILLS EXISTING ESR','SEMINARY HILLS ESR','TEKDI WADI EXISTING ESR'];
} else if (selectedValue === '3') {
    options = ['-Select ESR-','CHICHBHUVAN  NIT PROPOSED ESR', 'CHINCHBHUVAN EXISTING ESR', 'HUDKESHWAR EXISTING ESR' , 'NALANDANAGAR PROPOSED ESR','OMKARNAGAR EXISTING ESR','OMKARNAGAR PROPOSED ESR','SHRINAGAR PROPOSED ESR'];
}else if (selectedValue === '4') {
    options = ['-Select ESR-','HANUMANAGAR PROPOSED ESR', 'RESHIMBAGH EXISTING ESR', 'WANJARI NAGAR EXISTING ESR -I','WANJARI NAGAR EXISTING ESR-II'];
}else if (selectedValue === '5') {
    options = ['-Select ESR-','DIGHORI EXISTING ESR', 'KHARABI ESR','NANDANVAN EXT ESR','NANDANVAN PROPOSED ESR - I','NANDANVAN PROPOSED ESR II','SAKKARDARA EXISTING ESR I & II','SAKKARDARA PROPOSED ESR'];
}else if (selectedValue === '6') {
    options = ['-Select ESR-','KILLAMAHAL EXISTING ESR', 'SITABUILDI FORT-II', 'SITABURDI FORT-I' , 'Godrej Anandam ESR'];
}else if (selectedValue === '7') {
    options = ['-Select ESR-','BASTARWARI PROP ESR I(PART-I)', 'BASTARWARI PROP ESR-II (PART A)', 'BASTARWARI PROP ESR-II (PART-B)','BORIAPURA 600 MM FEEDERMAIN','BORIAPURA EXISTING ESR','G.H.VAHANTHIKANA','SHANTINAGAR PROPOSED ESR','WANJRI EXISTING ESR','KALAMNA NIT ESR'];
}else if (selectedValue === '8') {
    options = ['-Select ESR-','BHANDEWADI PROPOSED ESR', 'BHARATWADI (DESHPANDE LAYOUT) EXISTING ESR', 'KALAMANA MINIMATA EXISTING ESR' , 'LAKADGANJ EXT ESR-I','LAKADGANJ EXISTING ESR II','PARDI ROAD PROPOSED ESR - II','PARDI ROAD PROPOSED ESR I','SUBHANNAGAR EXISTING ESR'];
}else if (selectedValue === '9') {
    options = ['-Select ESR-','BEZANBAGH EXISTING ESR', 'BINAKI EXISTING ESR', 'BINAKI PROPOSED ESR - II', 'BINAKI PROPOSED ESR I','INDORA PRAPOSED ESR I','INDORA PROPOSED ESR - II','JARIPATKA EXISTING ESR','NARA EXISTING ESR','NARI EXISTING ESR','UPPALWADI(WANJRA)1 PROP ESR','NARA NIT PROPOSED ESR'];
}else if (selectedValue === '10') {
    options = ['-Select ESR-','GH-RAJ NAGAR', 'GITTIKHADAN EXISTING ESR (RAMDEO BABA)', 'GODHANI-GOREWADA PROPOSED ESR' , 'Governour House Sadar'];
}else if (selectedValue === '') {
    options = ['-Select ESR-'];
}
$('#dependent-dropdown').empty();
for (var i = 0; i < options.length; i++) {
    $('#dependent-dropdown').append('<option value="' + (options[i] === '-Select ESR-' ? '' : options[i]) + '">' + options[i] + '</option>');
}
});




	
</script>-->
<!-- new Fields-->
<div class="col-md-3" id="tapsize">
						<div class="mb-3 mt-3">
							<label for="" class="form-label lbleng">Tap Size(टॅपचा आकार)<span class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control waterRequired"
								style="background-image: none;" id="meterTapSize" name="tap_size"
								placeholder="Tap Size in mm." value="${responseData.getData().get(0).getTap_size()}" readonly>
							<div class="invalid-feedback">Please Enter Valid Tap Size.</div>
						</div>
					</div>
					<div class="col-md-3" id="cat">
						<div class="mb-3 mt-3">
							<label for="" class="form-label lbleng">Category (श्रेणी)<span class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control waterRequired"
								style="background-image: none;" id="category" name="category"
								value="${responseData.getData().get(0).getCategory()}" readonly>
							<div class="invalid-feedback">Please Enter Valid Category.</div>
						</div>
					</div>
					<div class="col-md-3" id="arrears">
						<div class="mb-3 mt-3">
							<label for="" class="form-label lbleng">Balance Arrears (शिल्लक थकबाकी)<span class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control waterRequired"
								style="background-image: none;" id="balance_arrears" name="balance_arrears"
								value="${responseData.getData().get(0).getMeterNo()}" readonly>
							<div class="invalid-feedback">Please Enter Valid Balance Arrears.</div>
						</div>
					</div>
					<div class="col-md-3" id="cuttoff">
						<div class="mb-3 mt-3">
							<label for="" class="form-label lbleng">Cut Off Date (कट ऑफ तारीख)<span class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control waterRequired"
								style="background-image: none;" id="cut_off_date" name="cut_off_date"
								value="${responseData.getData().get(0).getMeterNo()}" readonly>
							<div class="invalid-feedback">Please Enter Valid Cut Off Date.</div>
						</div>
					</div>


				<div class="col-md-3" id="consName">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Consumer Name
							(ग्राहकाचे नाव)<span class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control waterRequired"
							style="background-image: none;" id="cn" name="consumerName"
							value="${responseData.getData().get(0).getConsumerName()}"
							pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" required readonly>
						<div class="invalid-feedback">Please Enter Consumer Name.</div>
					</div>
				</div>
				
				<!-- <div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Consumer No.
							(ग्राहक क्र.)						</label> <input type="text" class="form-control waterRequired"
						pattern="^\s*\S.*$"	style="background-image: none;" name="consumerNo"
							value="${waterQualityComplaint.consumerNo}"maxlength="20" >
						<div class="invalid-feedback">Please Enter Valid Consumer No
						</div>
					</div>
				</div>-->
				<div class="col-md-3" id="meterNo">
					<div class="mb-3" style="margin-top:38px;">
						<label for="" class="form-label lbleng">Meter No. (मीटर
							क्र.)<span class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control waterRequired"
							style="background-image: none;" id="mn" name="meterNo"
							value="${responseData.getData().get(0).getMeterNo()}" required
							readonly>
						<div class="invalid-feedback">Please Enter Valid Meter No.</div>
					</div>
				</div>

				<!-- <div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Deposit Receipt
							No. (ठेव पावती क्र.)
						</label> <input type="text" class="form-control waterRequired"
							style="background-image: none;" id="" placeholder=""
							value="${waterQualityComplaint.dreceiptNo}" name="dreceiptNo"
							value="">
					</div>
				</div>
				<div class="col-md-3">
    <div class="mb-3 mt-3">
        <label for="" class="form-label">Deposit Receipt Date (जमा पावतीची तारीख)</label>
        <input type="date" class="form-control waterRequired" style="background-image: none;" id="" placeholder="" maxlength="10" value="${waterReconnection.depositReceiptDate}" name="receiptDate">
    </div>
</div>-->
	<div class="col-md-3">
					<div class="mb-3" style="margin-top:38px;">

						<label for="email" class="form-label lbleng"> Consumer Email Id (ग्राहकाचे ई
							- मेल आयडी)<span
							class="text-danger" style="color: red;">*</span>
						</label> <input type="email" class="form-control waterRequired"
							style="background-image: none;" id="email_id" placeholder=""
							name="email" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}" value="${waterQualityComplaint.email}" required readonly>
						<div class="invalid-feedback">Please Enter Valid Email Id.</div>
					</div>
				</div>



				<div class="col-md-3">
					<div class="mb-3" style="margin-top:38px;">
						<label for="" class="form-label"> Consumer Mobile No. (ग्राहकाचे मोबाईल क्र.)<span
							class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control waterRequired"
							style="background-image: none;" id="contact_no"
							placeholder="" name="mobileNo"
							value="${waterQualityComplaint.mobileNo}"
							pattern="[6-9]{1}[0-9]{9}" maxlength="10" readonly required>
						<div class="invalid-feedback">Please Enter Valid Mobile
							Number.</div>
					</div>
				</div>
<script>
    
    var currentDate = new Date().toISOString().split('T')[0];

    
    var depositReceiptDateInput = document.querySelector('input[name="depositReceiptDate"]');
    depositReceiptDateInput.max = currentDate;
</script>
<div class="col-md-3" id="consAddress">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Consumer Address
							(ग्राहक पत्ता)<span class="text-danger" style="color: red;">*</span>
						</label>
						<textarea class="form-control waterRequired "
							style="background-image: none;" rows="2" id="ca"
							name="exitingAddress" readonly>
						${responseData.getData().get(0).getAddress()}</textarea>
						 
						
						<div class="invalid-feedback">Please Enter Valid Consumer
							Address.</div>
					</div>
				</div>

				<div class="col-md-12">
					<div class="mb-3 mt-3 ">
						<label for="primary_full_address" class="form-label lbleng">Problem
							Description (समस्येचे वर्णन)<span class="text-danger">*</span>
						</label>

						<textarea class="form-control " style="background-image: none;"
							rows="2" id="" name="problem" required></textarea>
						<div class="invalid-feedback">Please Enter Valid Purpose Of
							Illegal Water Connection</div>
					</div>
				</div>
			</div>
			<br>
			<h6 style="background-color: #dce2e8; padding: 10px;"
				class="rounded-2">
				<strong> Complainant Details (तक्रारदार तपशील) </strong>
			</h6>
			<div class="row">

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Title (शीर्षक)<span
							class="text-danger" required>*</span>
						</label> <select class="form-control waterRequired"
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
						<label for="" class="form-label lbleng"> Name (नाव)<span class="text-danger">*</span>
						</label> <input type="text" class="form-control waterRequired"
							style="background-image: none;" id="first_name" placeholder=""
							name="firstName" value="${waterQualityComplaint.firstName}"
						maxlength="40"	pattern="[A-Za-z]+" onchange="Display(this.id)" required>
						<div class="invalid-feedback">Please Enter Valid Name.
						</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Father's Name (वडिलांचे नाव)
							</label> <input type="text" class="form-control waterRequired"
							style="background-image: none;" id="middle_name" placeholder=""
							name="middleName" value="${waterQualityComplaint.middleName}"
							pattern="[A-Za-z]+" onchange="Display(this.id)">


					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Surname (आडनाव)<span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control waterRequired"
							style="background-image: none;" name="lastName" id="last_name"
							value="${waterQualityComplaint.lastName}" maxlength="80"pattern="[A-Za-z]+"
							onchange="Display(this.id)" required>
						<div class="invalid-feedback">Please Enter Valid Surname.
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3" style="margin-top:38px;">
						<label for="" class="form-label">Full Name (संपूर्ण नाव)</label> <input
							type="text" class="form-control waterRequired"
							style="background-image: none;" id="full_name" placeholder=""
							name="fullName" value="${waterQualityComplaint.fullName}"
							readonly>
					</div>
				</div>





				<!-- <div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Plot/Flat No
							(प्लॉट/फ्लॅट क्र)<span class="text-danger">*</span>
						</label> <input type="text" class="form-control waterRequired"
						pattern="^\s*\S.*$"	style="background-image: none;" id="plot_no" onchange="change(this.id)" placeholder=""
							name="plotNo" maxlength="255" value="${waterQualityComplaint.plotNo}" required>
						<div class="invalid-feedback">Please Enter Valid Plot
							Number.</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Name of Building
							(इमारतीचे नाव)</label> <input type="text"
							class="form-control waterRequired"
							style="background-image: none;" id="buildingName" onchange="change(this.id)" placeholder=""
							name="buildingName"maxlength="80" value="${waterQualityComplaint.buildingName}">
						<div class="invalid-feedback">Please Enter Valid Building
							Name.</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Name of the Street
							(रस्त्याचे नाव)<span class="text-danger">*</span>
						</label> <input type="text" class="form-control waterRequired"
						pattern="^\s*\S.*$"	style="background-image: none;" id="street_name" onchange="change(this.id)" placeholder=""
							name="streetName"maxlength="80" value="${waterQualityComplaint.streetName}"
							required>
						<div class="invalid-feedback">Please Enter Valid Street
							Name.</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Name of the Area
							(क्षेत्राचे नाव)<span class="text-danger">*</span>
						</label> <input type="text" class="form-control waterRequired"
						pattern="^\s*\S.*$"	style="background-image: none;" id="areaName" onchange="change(this.id)" placeholder=""
							name="areaName"maxlength="80" value="${waterQualityComplaint.areaName}"
							required>
						<div class="invalid-feedback">Please Enter Valid Area Name.
						</div>
					</div>
				</div>


				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Nearby Landmark
							(जवळील लँडमार्क)</label> <input type="text"
							class="form-control waterRequired"
							style="background-image: none;" id="landmark" onchange="change(this.id)" placeholder=""
							name="landmark" maxlength="80"value="${waterQualityComplaint.landmark}">
					</div>
				</div>
   <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">City Name (शहराचे नाव)<span class="text-danger"
                                    style="color: red;">*</span></label>
                           
                            <input type=" text" class="form-control waterRequired" style="background-image: none;" id="city" placeholder="" name="applicantcity"
                                value="${waterQualityComplaint.applicantcity}" onchange="change(this.id)" pattern="^\s*\S.*$"  required>
                                 <div class="invalid-feedback">
                                Please Enter Valid City Name.
                            </div>
                        </div>
                    </div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Pin Code (पिन कोड)<span
							class="text-danger">*</span></label> <input type="text"
							class="form-control waterRequired"
							style="background-image: none;" pattern="^(?!0{6}$)\d{6}$" name="pinCode" id="pin_code" onchange="change(this.id)"
							value="${waterQualityComplaint.pinCode}" maxlength="6" required>
						<div class="invalid-feedback">Please Enter Valid Pincode.</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label"> Aadhaar No. (आधार क्र.)</label>
						<input type="text" class="form-control waterRequired"
							style="background-image: none;" id="aadhaarNumber1"
							placeholder="" name="aadhaarNo"
							value="${waterQualityComplaint.aadhaarNo}" pattern="(?!0{12}$)[0-9]{12}"
							maxlength="12">
						<div class="invalid-feedback">Please Enter Valid Aadhaar
							Number.</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">

						<label for="email" class="form-label lbleng"> Consumer Email Id (ई
							- मेल आयडी)<span class="text-danger">*</span>
						</label> <input type="email" class="form-control waterRequired"
							style="background-image: none;" id="email" placeholder=""
							name="email" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}" value="${waterQualityComplaint.email}" required>
						<div class="invalid-feedback">Please Enter Valid Email Id.</div>
					</div>
				</div>



				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label"> Consumer Mobile No. (मोबाईल क्र.)<span
							class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control waterRequired"
							style="background-image: none;" id="txtMobileNumber"
							placeholder="" name="mobileNo"
							value="${waterQualityComplaint.mobileNo}"
							pattern="[6-9]{1}[0-9]{9}" maxlength="10" required>
						<div class="invalid-feedback">Please Enter Valid Mobile
							Number.</div>
					</div>
				</div>-->
				<div class="col-md-9">
                            <div class="mb-3 mt-3">
                                <label for="" class="form-label ">Address For Correspondence (पत्रव्यवहारासाठी पत्ता)<span class="mand_error" style="color: red;">*</span></label>
                               <textarea oninput="validateTextarea()" type=" text"
							maxlength="255" class="form-control"
							style="background-image: none;" id="Address" placeholder=""
							name="fullAddress" value="" rows="2" required></textarea>
					
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
</script>





			<div class="row">

				<!-- <h6 style="background-color: white; padding: 5px;"
					class="mt-1 rounded-2">
					<strong> List of Documents (with attachment) (दस्तऐवजांची
							यादी (सह संलग्नक))</strong>
				</h6>
				<div class="alert alert-info mb-2 p-2 ms-2 mb-4">
					<small><strong>Note: </strong> Upload below files only
							.pdf(Max upto 2 MB) (खाली फक्त .pdf फाइल अपलोड करा (कमाल २ MB
						पर्यंत))</small>
				</div>
				<input type="hidden" name="filesPath" id="filesPath" />

				<div class="col-md-3">
					<div class="mb-3 mt-0">
						<label for="" class="form-label"> Applicant's ID Proof
							(अर्जदाराचा ओळखपत्र पुरावा)<span class="text-danger"
							style="color: red;">*</span>
						</label> <input type="file" class="form-control waterRequired"
							style="background-image: none;" accept=".pdf" id="doc1" name="applicantIdProof"
							value="" required>
						<div class="invalid-feedback">File selected is either
							greater than 2Mb or not of type pdf.</div>

					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-0" style="margin-top: 25px">
						<label for="" class="form-label">Copy Of Current Bill
							(चालू बिलाची प्रत)<span class="text-danger" style="color: red;">*</span>
						</label> <input type="file" class="form-control waterRequired"
							style="background-image: none;" accept=".pdf" id="doc2" name="currentBill"
							value="" required>
						<div class="invalid-feedback">File selected is either
							greater than 2Mb or not of type pdf.</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-0 mt-0">
						<label for="" class="form-label">Copy Of Demand Paid
							Receipt (डिमांड पेड पावतीची प्रत) <span class="text-danger"
							style="color: red;">*</span>
						</label> <input type="file" class="form-control waterRequired"
							style="background-image: none;" accept=".pdf" id="doc3" name="demandReceipt"
							value="" required>
						<div class="invalid-feedback">File selected is either
							greater than 2Mb or not of type pdf.</div>
					</div>
				</div>


			
				<div class="col-md-3">
					<div class="mb-3 mt-0">
						<label for="" class="form-label"> Copy Of
							Address/Ownership Proof (पत्त्याची प्रत/मालकीचा पुरावा)<span
							class="text-danger" style="color: red;">*</span>
						</label> <input type="file" class="form-control waterRequired"
							style="background-image: none;" name="copyOfAddressFile"
							id="doc5" placeholder="" value="" accept=".pdf" required="true">
						<div class="invalid-feedback">File selected is either
							greater than 2Mb or not of type pdf.</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">

						<label class="form-label lbleng">Signature Of Consumer
							(ग्राहकाची स्वाक्षरी)<span class="text-danger"
							style="color: red;">*</span>
						</label> <input type="file" class="form-control waterRequired"
							style="background-image: none;" accept=".pdf" id="doc6" placeholder="" value=""
							name="consumerSign" required>
						<div class="invalid-feedback">File selected is either
							greater than 2Mb or not of type pdf.</div>
					</div>

				</div>-->
				<div class="col-md-12">
					<div class="mb-5 mt-4 ">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" id="check11"
								name="declaration" value="something" required> <label
								class="form-check-label ms-3 lbleng" style="margin-top: 0px;">
								<strong>Declaration (घोषणा) <span class="text-danger" required>*</span>:-
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
						<button class="btn btn-success btn_sm" type="submit" id="submits"
							>Submit</button>
					</div>
				</div>


			</div>
		</div>


		</div>
		</div>
	</form>
</body>
<!-- <script>
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


                    <div class="modal-body" style="color:green">



                       <p style="color:red">

                         <strong>List of document to be attached :</strong>   

                        </p>

                        <ul style="color:rgb(3, 125, 76)">



                            <li>1.Applicant's ID Proof
							(अर्जदाराचा ओळखपत्र पुरावा)<span class="text-danger"  style="color: red;">*</span></li>
                            <li>2.Copy Of Current Bill
							(चालू बिलाची प्रत)<span class="text-danger"  style="color: red;">*</span> </li>
                            <li>3.Copy Of Demand Paid
							Receipt (डिमांड पेड पावतीची प्रत)<span class="text-danger"  style="color: red;">*</span></li>
                            <li>4.Copy Of
							Address/Ownership Proof (पत्त्याची प्रत/मालकीचा पुरावा)<span class="text-danger" style="color: red;">*</span> </li>
                            <li>5.Signature Of Consumer
							(ग्राहकाची स्वाक्षरी)<span class="text-danger" style="color: red;">*</span></li> 

                        </ul>

                    </div>


                    <div class="modal-footer"><button type="button" class="btn btn-primary">OK</button></div>

                </div>

            </div>

        </div>-->

<script type="text/javascript">
$('.printMe').on('click', function () {

    window.print();
});
</script>




	<script type="text/javascript">
	
	$(document).ready(function () {
     	 var isUploadInProgress = false;

        $("#submits").click(function (event) {
        	
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
           	        $("#submits").attr("disabled", true);
                   	isUploadInProgress = true;
                   	upload(function(status) {
                   	    if (status === true || status === 'true') {
               		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveWaterQualityComplaint.do');
                   	    } else {
                   	        $("#submits").attr("disabled", false);
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


           // data.append('idProof1', $("#doc1").get(0).files[0]);
           // data.append('idProof2', $("#doc2").get(0).files[0]);
           // data.append('idProof3', $("#doc3").get(0).files[0]);
           // data.append('idProof5', $("#doc5").get(0).files[0]);
           //data.append('idProof6', $("#doc6").get(0).files[0]);



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
                    filesPath = filesPath + basePath + "WaterQualityComplaint/" + id + value + ","
                    isFileSelected = true;
                }
            }
            $.ajax({
                url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadWaterQualityComplaint.do?id="+id,
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
</html>





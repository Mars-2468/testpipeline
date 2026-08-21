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
	href="/RTS/pages/core-pages/nmc_user/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/RTS/pages/core-pages/nmc_user/css/style2.css" />
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

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
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
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
	<style>
    /* Apply max-height and overflow to make the dropdown scrollable */
    #styled-select select {
        max-height: 150px; /* Adjust as needed */
        overflow-y: auto;
    }
    
    /* Ensure the dropdown options also handle long text */
    #styled-select option {
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }

   
    #tradeLicense option {
        max-width: 250px; /* Set a fixed maximum width for the options */
        white-space: nowrap; /* Prevent text from wrapping */
        overflow: hidden; /* Hide overflow text */
        text-overflow: ellipsis; /* Show ellipsis (...) for overflow text */
    }

    /* For better compatibility, you can also apply the styles within a span */
    .fixed-width-option {
        max-width: 200px; /* Adjust the width as needed */
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
}

</style>

<script>
 function Display(id) {
            $('#full_name').val($('#first_name').val() + " " + $('#middle_name').val() + " " + $('#last_name').val())
        }


</script>

</head>
<body>

	<form class="needs-validation" novalidate>
		<div class="container-fluid mt-2" style="width: 190vh">
			<div class="printable">
				<h3 class="text-center">Application Form For Trade License
					Transfer (व्यापार परवाना हस्तांतरणासाठी अर्ज)</h3>
			</div>
			<h6 style="background-color: #dce2e8; padding: 10px;"
				class="  rounded-2">
				<strong> Applicant Details (अर्जदाराचे तपशील)</strong>
			</h6>
                      <div class="row" style="display: flex; width: 100%; margin-bottom: 0.786rem; height: 80px;">
                          <div class="col-md-3" style="width: 25% !important;">
						<label for="" class="form-label lbleng">Title (शीर्षक)<span
							class="text-danger">*</span>
						</label> <select class="form-select" style="background-image: none;"
							name="title" required>
							<option value="">-Select-</option>
							<option value="Mr.(श्री.)">Mr.(श्री.)</option>
							<option value="Mrs.(सौ.)">Mrs.(सौ.)</option>
							<option value="Ms. (कु.)">Ms.(कु.)</option>
						</select>
						<div class="invalid-feedback">Please Select Valid Title.</div>
					</div>

                          <div class="col-md-3" style="width: 25% !important;">
						<label for="" class="form-label lbleng">Name (नाव)<span class="text-danger">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="first_name" placeholder=""
						maxlength="40"	name="firstName" value="" pattern="[A-Za-z]+"
							onchange="Display(this.id)" required>
						<div class="invalid-feedback">Please Enter Valid Name.
						</div>
					</div>

                          <div class="col-md-3" style="width: 25% !important;">
						<label for="" class="form-label lbleng">Father's Name (वडिलांचे नाव)
							</label> <input type="text" class="form-control"
							style="background-image: none;" id="middle_name" placeholder=""
					maxlength="40"		name="middleName" value="" pattern="[A-Za-z]+"
							onchange="Display(this.id)">


					</div>

                          <div class="col-md-3" style="width: 25% !important;">
						<label for="" class="form-label lbleng">Surname (आडनाव)<span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control" style="background-image: none;"
							name="lastName" id="last_name" value="" pattern="[A-Za-z]+"maxlength="40"
							onchange="Display(this.id)" required>
						<div class="invalid-feedback">Please Enter Valid Surname.
						</div>
					</div>
				</div>
                      <div class="row" style="display: flex; width: 100%; margin-bottom: 0.786rem; height: 80px;">
				
                          <div class="col-md-3" style="width: 25% !important;">
						<label for="" class="form-label">Full Name (संपूर्ण नाव)</label> <input
							type="text" class="form-control" style="background-image: none;"
							id="full_name" placeholder="" name="fullName" value="" readonly>
					</div>
				


                          <div class="col-md-3" style="width: 25% !important;">
                        <label for="" class="form-label lbleng">Pin Code (पिन कोड)<span class="text-danger" >*</span></label>

                        <input type="text" class="form-control" style="background-image: none;"  pattern="^(?!0{6}$)\d{6}$" name="pinCode" value=""
                        maxlength="6" required>
                        <div class="invalid-feedback">
                Please Enter Valid Pincode.
            </div>
                    </div>
                          <div class="col-md-3" style="width: 25% !important;">
						<label for="" class="form-label"> Aadhaar No.(आधार क्र.) </label>
						<input type="text" class="form-control"
							style="background-image: none;" id="aadhaarNumber1"
							placeholder="" name="aadhaarNo" value="" pattern="(?!0{12}$)[0-9]{12}"
							maxlength="12">
						<div class="invalid-feedback">Please Enter Valid Aadhaar No.
						</div>
					</div>
                          <div class="col-md-3" style="width: 25% !important;">

						<label for="email" class="form-label lbleng"> Email Id (ई
							- मेल आयडी)<span class="text-danger">*</span>
						</label> <input type="email" class="form-control"
							style="background-image: none;" id="email" placeholder=""
							name="email" value="" pattern ="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}" required>
						<div class="invalid-feedback">Please Enter Valid Email Id.</div>
					</div>
				</div>
                      <div class="row" style="display: flex; width: 100%; margin-bottom: 0.786rem; height: 80px;">

                          <div class="col-md-3" style="width: 25% !important;">
						<label style="height: 40px !important;" for="" class="form-label"> Mobile No.(मोबाईल क्र.)<span
							class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control"
							style="background-image: none;" id="txtMobileNumber"
							placeholder="" name="mobileNo" value=""
							pattern="[6-9]{1}[0-9]{9}" maxlength="10" required>
						<div class="invalid-feedback">Please Enter Valid Mobile No.
						</div>
					</div>
		
				
                          <div class="col-md-3" style="width: 25% !important;">
                                <label style="height: 40px !important;" for="" class="form-label ">Address For Correspondence (पत्रव्यवहारासाठी पत्ता)<span class="mand_error" style="color: red;"">*</span></label>
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
				
				
				
				
				
				
				
				
				
				<br>

				<h6 style="background-color: #dce2e8; padding: 10px;"
					class=" mt-3 rounded-2">
					<strong> Application Form Details (अर्जाचा तपशील)</strong>
				</h6>
                      <div class="row" style="display: flex; width: 100%; margin-bottom: 0.786rem; height: 100px !important;">

                          <div class="col-md-3" style="width: 25% !important;">
						<label style="height: 40px !important;" for="" class="form-label lbleng">Zone No. (झोन
							क्र.)<span class="text-danger" style="color: red;">*</span>
						</label> 
						<select class="form-select " style="background-image: none;"
							id="main-dropdown" name="zoneNo" required>
							<option value="" selected>-Select Zone-</option>
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

                          <div class="col-md-3 hospital_row" style="width: 25% !important;"  id="hos">

						<label style="height: 40px !important;" for="" class="form-label"> Ward No. (प्रभाग क्र.) <span
							class="text-danger" style="color: red;">*</span></label> <select
							class="form-select" style="background-image: none;"
							id="dependent-dropdown" name="wardNo" disabled required>

							<option value="" selected>-Select Ward-</option>
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
                          <div class="col-md-3" style="width: 25% !important;">
							<label style="height: 40px !important;" for="" class="form-label lbleng">Name of the Area
								(क्षेत्राचे नाव)</label> <input type="text" class="form-control"
								style="background-image: none;" id="" placeholder=""
								name="nameOfArea" pattern="^\s*\S.*$" maxlength="100" value="">
						</div>
					
                          <div class="col-md-3" style="width: 25% !important;">
							<label style="height: 40px !important;" for="" class="form-label lbleng">Trade License
								No.(व्यापार परवाना क्र.)<span class="text-danger"
								style="color: red;">*</span>
							</label> <input type="text" class="form-control"
								style="background-image: none;" id="" placeholder=""
								name="tradeLicenseNo"pattern="^\s*\S.*$" value=""maxlength="100" required>
							<div class="invalid-feedback">Please Enter Valid Trade
								License No.</div>
						</div>
					</div>
                      <div class="row" style="display: flex; width: 100%; margin-bottom: 0.786rem; height: 80px; ">
                          <div class="col-md-3" style="width: 25% !important;">
							<label style="height: 40px !important;" for="" class="form-label lbleng">Updated Trade
								Name (अद्यतनित व्यापार नाव)</label> <input type="text"
								class="form-control" style="background-image: none;" id=""
						pattern="^\s*\S.*$"		placeholder=""maxlength="100" name="updatedTradeName" value="">

						</div>
	                          <div class="col-md-3" style="width: 25% !important;" id="styled-select">
	
      <label style="height: 40px !important;" for="tradeLicense" class="form-label lbleng">
    Updated Trade Type (अद्यतनित व्यापार प्रकार)<span class="text-danger" style="color: red;">*</span></label>
    

<select id="tradeLicense" class="form-control" name="updatedTradeType" style="background-image: none;" required>
    <option value="" selected disabled>--- Select ---</option>
    <c:forEach var="tradeTypes" items="${requestScope.tradeTypes}">
        <option class="fixed-width-option" value="${tradeTypes.trade_name}" 
            title="${tradeTypes.trade_name}" data-fee="${tradeTypes.trade_typefees}">
            <c:out value="${tradeTypes.trade_name}" />
        </option>
    </c:forEach>
    <option value="other" data-fee="1000">Other (इतर)</option> <!-- Other option added -->
    <input type="text" class="form-control mt-2 d-none" id="otherTradeType" style="background-image: none;" name="updatedTradeType" 
       placeholder="Enter other trade type" maxlength="50" /> <!-- Hidden input for other trade type -->
    
</select>
<div class="invalid-feedback">Please Enter Valid Updated Trade Type.</div>
</div>
<div class="col-md-3" style="width: 25% !important;">
    <label style="height: 40px !important;" for="fees" class="form-label lbleng">
        Fees Applicable (शुल्क लागू)<span class="text-danger" style="color: red;">*</span>  </label>
     
   
    <input type="text" class="form-control" id="fees" name="feesApplicable" required readonly>
    <div class="invalid-feedback">Please Enter Valid Fees.</div>
</div>

<script>
document.addEventListener('DOMContentLoaded', () => {
    const maxLength = 50; // Maximum number of characters to display
    const tradeLicenseSelect = document.querySelector('#tradeLicense');
    const options = tradeLicenseSelect.querySelectorAll('option');
    const feesInput = document.querySelector('#fees'); // Selector for the fees input field
    const otherTradeTypeInput = document.querySelector('#otherTradeType'); // Selector for the other trade type input

    // Truncate long option texts
    options.forEach(option => {
        if (option.textContent.length > maxLength) {
            option.textContent = option.textContent.slice(0, maxLength) + '...';
        }
    });

    // Handle change event on the select element
    tradeLicenseSelect.addEventListener('change', function() {
        const selectedOption = tradeLicenseSelect.options[tradeLicenseSelect.selectedIndex];
        const fee = selectedOption.getAttribute('data-fee');
        
        if (selectedOption.value === 'other') {
            otherTradeTypeInput.classList.remove('d-none'); // Show the other trade type input
            otherTradeTypeInput.required = true; // Make the input required
            feesInput.value = '1000'; // Set fee to 1000 for "Other"
        } else {
            otherTradeTypeInput.classList.add('d-none'); // Hide the other trade type input
            otherTradeTypeInput.required = false; // Remove required attribute
            feesInput.value = fee || ''; // Set the fee value or clear if not available
        }
    });
});
</script>
					
                         <div class="col-md-3" style="width: 25% !important;">
    <label style="height: 40px !important;" for="partnerCount" class="form-label lbleng">
        Updated Partner Count (अद्यतनित भागीदार संख्या) <span class="text-danger" style="color: red;">*</span> 
    </label>
    <input 
        type="number" 
        class="form-control" 
        id="partnerCount" 
        name="updatedPartnerCount" 
        min="1" 
        max="9" 
        style="background-image: none;" 
        placeholder="" 
        value="" 
        required 
        oninput="generatePartnerFields(this)">
    <div class="invalid-feedback">
        Please Enter Valid Updated Partner Count.
    </div>
</div>
</div>
<br>
<div class="row" style="display: flex; width: 100%; margin-bottom: 0.786rem; max-height: 100% !important; margin-top: 15px !important;">
   
   <!-- Table to display dynamically generated partner name input fields -->
    <table class="table mt-2">
        <thead>
            <tr>
                <th scope="col">Partners</th>
                <th scope="col">Updated Owner/Partner Name (अद्यतनित केलेले मालक/भागीदाराचे नाव)</th>
            </tr>
        </thead>
        <tbody id="partnerFieldsContainer">
            <!-- Partner fields will be generated here -->
        </tbody>
    </table>
</div>

<script>
    function generatePartnerFields(input) {
        const partnerCount = parseInt(input.value);
        const partnerFieldsContainer = document.getElementById('partnerFieldsContainer');

        // Clear existing fields
        partnerFieldsContainer.innerHTML = '';

        // Validate partner count is within range
        if (isNaN(partnerCount) || partnerCount < 1 || partnerCount > 9) {
            return;
        }

        // Generate new input fields based on the count
        for (let i = 1; i <= partnerCount; i++) {
            const row = document.createElement('tr');

            // Column for partner number with sequence
            const numberCell = document.createElement('td');
            numberCell.textContent = `Partner ${i}`+[i];
            row.appendChild(numberCell);

            // Column for partner name input
            const nameCell = document.createElement('td');
            const inputField = document.createElement('input');
            inputField.type = 'text';
            inputField.style = 'background-image: none; width: 350px;';
            inputField.className = 'form-control';
            inputField.name = `updatedOwnerName${i}`;
            inputField.placeholder = `Enter Updated Owner/Partner Name ${i}`+[i];
            inputField.pattern = '^([A-Za-z]{0,})([A-Za-z]{1,}\\s?)+$';
            inputField.maxLength = 100;
            inputField.required = true;

            nameCell.appendChild(inputField);
            row.appendChild(nameCell);

            // Append the row to the table body
            partnerFieldsContainer.appendChild(row);
        }
    }
</script>
					<!-- <div class="row">
						<div class="col-md-3">
						<div class="mb-3 mt-4">
							<label for="" class="form-label lbleng">Updated
								Owner/Partner Name (अद्यतनित केलेले मालक/भागीदाराचे नाव)<span
								class="text-danger" style="color: red;">*</span>
							</label> <input type="text" class="form-control"
								style="background-image: none;" id="" placeholder=""
								name="updatedOwnerName" value=""
								pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" maxlength="100" required>
							<div class="invalid-feedback">Please Enter Valid Updated
								Owner/Partner Name .</div>
						</div>
					</div>


				
</div>-->

<script>
    function validateInputLength(input) {
        if (input.value.length > parseInt(input.getAttribute('maxlength'))) {
            input.value = input.value.slice(0, parseInt(input.getAttribute('maxlength')));
        }
    }
</script>

                      <div class="row" style="display: flex; width: 100%; margin-bottom: 0.786rem; height: 80px;">

						<h6 style="background-color: white; padding: 5px;"
							class="mt-1 rounded-2 ms-2">
							<strong> List of Documents (with attachment)
								(कागदपत्रांची यादी (संलग्नकांसह))</strong>
						</h6>
						<div class="alert alert-info mb-3 p-2 mb-5 ms-2">
							<small><strong>Note (नोंद): </strong> Upload below files
								only .pdf(Max upto 2 MB) (खाली फक्त .pdf फाइल अपलोड करा (कमाल
								२ MB पर्यंत)</small>

						</div>
						<input type="hidden" name="filesPath" id="filesPath" />
                        <div class="col-md-3"  >
								  <label style="height: 62px !important;" for="" class="form-label">
								   <!-- NOC for the related department issued from the NMC/Department Officer/Govt/Semi Govt. Officer 
								   (NMC/ विभाग अधिकारी/शासकीय/निमशासकीय अधिकारी कडून जारी केलेल्या संबंधित विभागासाठी NOC)-->
								     NOC for the related department issued from the NMC Department Officer (निम् शासकीय अधिकाऱ्यांनी जारी केलेले NOC.)
                        <span class="text-danger"
                            style="color: red;">*</span>
                    </label><input type="file" class="form-control"
									style="background-image: none;" id="doc1"
									name="nocForRelatedDepartment" accept=".pdf" required>
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>

							</div>
                            <div class="col-md-3"  >
								<label style="height: 60px !important;" for="" class="form-label"> 
								Building Authorization Document (इमारत अधिकृतता दस्तऐवज) </label> <input type="file"
									class="form-control" style="background-image: none;" id="doc2"
									placeholder="" accept=".pdf" name="buildingAuthorizationDocument">
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>
							</div>

                      
                         

                          <div class="col-md-3">
								<label style="height: 60px !important;" for="" class="form-label">
								Copy of the Former License (पूर्वीच्या परवान्याची प्रत)<span class="text-danger"
									style="color: red;">*</span>
								</label> <input type="file" class="form-control"
									style="background-image: none;" accept=".pdf" id="doc3"
									name="copyOfFormerLicense" required>
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>
							</div>

                          <div class="col-md-3" >
								<label style="height: 60px !important;" for="" class="form-label">
								No Dues Certificate for Property Tax (मालमत्ता करासाठी ना हरकत प्रमाणपत्र)<span
									class="text-danger" style="color: red;">*</span>
								</label> <input type="file" class="form-control"
									style="background-image: none;" accept=".pdf" id="doc4"
									name="propertyTaxNoDue" required>
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>
							</div>


                         
							  <!-- <div class="col-md-3" style="width: 25% !important;">
								<label for="" class="form-label"> Trade License Certificate(व्यापार परवाना प्रमाणपत्र)</label> <input type="file"
									class="form-control" style="background-image: none;" id="doc5"
									placeholder="" accept=".pdf" name="licensecertificate">
								<div class="invalid-feedback">File selected is either
									greater than 2Mb or not of type .pdf.</div>
							</div>-->
							 
						<div class="col-md-12" style="margin-top: 15px !important;">
							<div class="mb-5 mt-3">
								<div class="form-check">
									<input class="form-check-input" type="checkbox" id="check11"
										name="declaration" value="something" required> <label
										class="form-check-label ms-3 lbleng" style="margin-top: -1px;">
										<strong>Declaration (घोषणा)<span class="text-danger"
											style="color: red;">*</span>:-
									</strong>The above mentioned information is true to the best of my
										knowledge and belief (वर नमूद केलेली माहिती माझ्या माहितीनुसार
										आणि विश्वासानुसार खरी आहे).
									</label>
									<div class="invalid-feedback">Please check the
										declaration.</div>
								</div>
							</div>
						</div>
						<div class="col-md-12 text-start mb-5" style="margin-top: -15px;">

							<div class="text-center">
								<button type="button" class="btn btn-danger btn_sm printMe">
									View and Print</button>
								<button class="btn btn-success btn_sm" type="submit" id="submit"
									>Submit</button>
							</div>
						</div>
					</div>
	</form>


</body>
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

                        <strong>List of document to be attached :
                        </strong>    
                        </p>

                        <ul style="color:rgb(3, 125, 76)">




                            <li>1.NOC for the related department issued from the NMC Department Officer (निम् शासकीय अधिकाऱ्यांनी जारी केलेले NOC.)<span class="text-danger"  style="color: red;">*</span> </li>
                            <li>2.No Dues Certificate for Property Tax (मालमत्ता करासाठी ना हरकत प्रमाणपत्र) <span class="text-danger"  style="color: red;">*</span></li>
                            <li>3.Building Authorization Document (इमारत अधिकृतता दस्तऐवज)</li> 
							<li>4.Copy of the Former License (पूर्वीच्या परवान्याची प्रत)<span class="text-danger"  style="color: red;">*</span></li>
                        </ul>

                    </div>

                    <!-- dialog buttons -->

                    <div class="modal-footer"><button type="button" class="btn btn-primary">OK</button></div>

                </div>

            </div>

        </div>

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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>


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
  		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveTradeLicenseTransferCertificates.do');
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
//data.append('idProof5', $("#doc5").get(0).files[0]);

      


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
        filesPath = filesPath + basePath + "tradeLicenseTransfer/" + id + value + ","
        isFileSelected = true;
    }
}
            var a = filesPath.substring(0, filesPath.lastIndexOf(","));
            filesPath = filesPath.replace(/\s/g, "");
            $("#filesPath").val(filesPath);
            console.log(filesPath);
            $.ajax({
                url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadDocumentTradeLicenseTransfer.do?id="+id,
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

           

        }
    </script>


</html>
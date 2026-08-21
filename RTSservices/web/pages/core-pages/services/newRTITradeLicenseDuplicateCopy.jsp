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
	<link rel="stylesheet" href="/RTS/pages/core-pages/nmc_user/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/RTS/pages/core-pages/nmc_user/css/style2.css" /> 
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
       input::-webkit-outer-spin-button,
      input::-webkit-inner-spin-button {
        -webkit-appearance: none;
        margin: 0;
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
  		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveTradeLiCenseDuplicateCopy.do');
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
          <div class="container-fluid mt-2" style="width: 180vh">
           <div class="printable">
               <h3 class="text-center">Application Form For Trade License Duplicate Copy (व्यापार परवाना दुय्यम प्रत करण्यासाठी अर्ज)						
	
            </h3>
           </div>
           <h6 style="background-color:#dce2e8; padding:10px;" class="  rounded-2"><strong> Applicant Details (अर्जदाराचे तपशील)</strong>
           </h6>
           <div class="row">
           <div class="col-md-3">
            <div class="mb-3 mt-3">
                <label for="" class="form-label lbleng">Title (शीर्षक) <span class="text-danger">*</span> 
                                        </label>

                <select class="form-select" style="background-image: none;" name="title" required>
                     <option value="">-Select-</option>
                            <option value="1" >Mr (श्री)</option>
                            <option value="2" >Mrs (सौ)</option>
                            <option value="3" >Ms (कु)</option>
                </select>
                <div class="invalid-feedback">
                    Please Select Valid Title.
                </div>
            </div>
        </div>

        <div class="col-md-3">
            <div class="mb-3 mt-3">
                <label for="" class="form-label lbleng">Name (नाव)<span class="text-danger">*</span></label>

                <input type="text" class="form-control"  style="background-image: none;"id="first_name" placeholder="" name="firstName"
                 maxlength="40"   value="" pattern="[A-Za-z]+" onchange="Display(this.id)" required>
                <div class="invalid-feedback">
                    Please Enter Valid Name.
                </div>
            </div>
        </div>

        <div class="col-md-3">
            <div class="mb-3 mt-3">
                <label for="" class="form-label lbleng">Father's Name (वडिलांचे नाव)</label>

                <input type="text" class="form-control"  style="background-image: none;"id="middle_name" placeholder="" name="middleName"
                 maxlength="40"   value="" pattern="[A-Za-z]+" onchange="Display(this.id)">


            </div>
        </div>

        <div class="col-md-3">
            <div class="mb-3 mt-3">
                <label for="" class="form-label lbleng">Surname (आडनाव)<span class="text-danger"
                        style="color: red;">*</span></label>
                <input type="text" class="form-control"  style="background-image: none;"name="lastName" id="last_name" value=""
                 maxlength="40"   pattern="[A-Za-z]+" onchange="Display(this.id)" required>
                <div class="invalid-feedback">
                    Please Enter Valid Surname.
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="mb-3 mt-3">
                <label for="" class="form-label">Full Name (संपूर्ण नाव)</label>

                <input type="text" class="form-control"  style="background-image: none;"id="full_name" placeholder="" name="fullName" value=""
                    readonly>
            </div>
        </div>
    
        <div class="col-md-3">
            <div class="mb-3 mt-3">
                <label for="" class="form-label lbleng">Pin Code (पिन कोड)<span class="text-danger" >*</span></label>

                <input type="text" class="form-control"  style="background-image: none;"pattern="^(?!0{6}$)\d{6}$" name="pinCode" value=""
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
            <input type="text" class="form-control"  style="background-image: none;" id="aadhaarNumber1" placeholder="" name="aadhaarNo" value=""
            pattern="(?!0{12}$)[0-9]{12}"
             maxlength="12" >
             <div class="invalid-feedback">
             Please Enter Valid Aadhaar No.
         </div>
        </div>
    </div>
        <div class="col-md-3">
            <div class="mb-3 mt-3">

                <label for="email" class="form-label lbleng"> Email Id (ईमेल आयडी )<span class="text-danger" >*</span> </label>
                <input type="email" class="form-control"  style="background-image: none;" id="email" placeholder="" name="emailID" value=""pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}"
                    required>
                    <div class="invalid-feedback">
                        Please Enter Valid Email Id.
                    </div>
            </div>
        </div>

        <div class="col-md-3">
            <div class="mb-3 mt-3">
                <label for="" class="form-label"> Mobile No.(मोबाईल क्र.)<span class="text-danger"
                    style="color: red;">*</span>
                </label>
                <input type="text" class="form-control"  style="background-image: none;" id="txtMobileNumber" placeholder="" name="mobileNumber" value=""
                pattern="[6-9]{1}[0-9]{9}"
                maxlength="10" required>
             <div class="invalid-feedback">
                Please Enter Valid Mobile No.
            </div>
            </div>
        </div>
                   <div class="col-md-12">
                            <div class="mb-3 mt-3">
                                <label for="" class="form-label ">Address For Correspondence (पत्रव्यवहारासाठी पत्ता)<span class="mand_error" style="color: red;"">*</span></label>
                                <textarea oninput="validateTextarea()" type=" text" maxlength="255" class="form-control"  style="background-image: none;" id="myTextarea" placeholder="" name="adressForCorrespondence" value="" rows="2" required></textarea>                           
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

                <h6 style="background-color:#dce2e8; padding:10px;" class=" mt-3 rounded-2"><strong>Application Form Details (अर्जाचा तपशील)</strong></h6>
                <div class="row">
                        
                    <div class="col-md-3">
					<div class="mb-3 mt-4" style="margin-top: 40px;">
						<label for="" class="form-label lbleng">Zone No. (झोन
							क्र.)<span class="text-danger" style="color: red;">*</span>
						</label> <select class="form-select " style="background-image: none;"
							id="main-dropdown" name="zoneNo" required>
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
            
						</select>


						<div class="invalid-feedback">Please Enter Valid Zone No.</div>
					</div>
				</div>

                       <div class="col-md-3 hospital_row" id="hos">
					<div class="mb-3 mt-4" style="margin-top: 40px;">
						<label for="" class="form-label"> Ward No. (प्रभाग क्र.) <span
							class="text-danger" style="color: red;">*</span></label> <select
							class="form-select" style="background-image: none;"
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
                            <div class="mb-3 mt-4">
                                <label for="" class="form-label lbleng">Name of Area (क्षेत्राचे नाव)</label>
                                
                                <input type="text" class="form-control"  style="background-image: none;"id="" placeholder="" name="nameOfArea"maxlength="255" value=""  >
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="mb-3 mt-4">
                                <label for="" class="form-label lbleng">Trade Licence No.(व्यापार परवाना क्र.)<span class="text-danger" style="color: red;" >*</span></label>
            
                                <input type="text" class="form-control"  style="background-image: none;"id="" placeholder="" name="tradeLicenceNo"pattern="^\s*\S.*$"  value="" required>
                                <div class="invalid-feedback">
                                    Please Enter Valid Trade Licence No.
                                </div>
                            </div>
                        </div>    
                        <div class="col-md-3">
                            <div class="mb-3 mt=3" style="margin-top: 17px">
                                <label for="" class="form-label lbleng">Updated Trade Name (अद्ययावत व्यापाराचे नाव)</label>
            
                                <input type="text" class="form-control"  style="background-image: none;"id=""pattern="^\s*\S.*$"  placeholder="" name="updateTradeName" pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" value="">
                                
                            </div>
                        </div>
                       <div class="col-md-3" id="styled-select">
    <div class="mb-3 mt-3">
        <label for="" class="form-label lbleng">
            Updated Trade Type (अद्यतनित व्यापार
            प्रकार)<span class="text-danger" style="color: red;">*</span>
        </label>
        <select class="form-select" style="background-image: none;" id="trade" name="updatedTradeType" onchange="tradeLicense(this.id)" required>
            <option value="-Select Trade-" style="font-size: smaller;" selected="">-Select
                Trade-</option>
            <option style="font-size: smaller;" svalue="All kinds of metal and work business (सर्व प्रकारच्या धातूचा औत कामाचा व्यवसाय )">All kinds of metal and work business (सर्व प्रकारच्या धातूचा औत कामाचा व्यवसाय )
            </option>
            <option style="font-size: smaller;" value="Yarn dyeing business (सुत कापड रंगविण्याचा व्यवसाय)</">Yarn dyeing
                business (सुत कापड रंगविण्याचा व्यवसाय)</option>
            <option style="font-size: smaller;" value="Preparation and packing of spices (मसाल्याचे पदार्थ तयार करणे व पॅकिंग करणे)">Preparation and packing of spices (मसाल्याचे पदार्थ तयार करणे व पॅकिंग करणे)
            </option>
            <option style="font-size: smaller;" value="Assembly and Manufacturing of electronic goods (इलेक्ट्रॉनिक वस्तूची जुळवणी व उत्पादन)">Assembly and Manufacturing of electronic goods (इलेक्ट्रॉनिक वस्तूची जुळवणी व
                उत्पादन)</option>
            <option style="font-size: smaller;" value="Electro Plating (इलेकट्रो प्लेटिंग)">Electro Plating (इलेकट्रो प्लेटिंग)</option>
            <option style="font-size: smaller;" value="Making bricks and mortar (विटा व कौले तयार करणे)">Making bricks and
                mortar (विटा व कौले तयार करणे)</option>
            <option style="font-size: smaller;" value="Making goods from waste clothes (वेस्ट कापडापासून वस्तू तयार करणे)">Making goods from waste clothes (वेस्ट कापडापासून वस्तू तयार करणे)</option>
            <option style="font-size: smaller;" value="Coal and coal, manufacturing of coal products,  its sale and firewood (कोळसा व दगडी कोळसा ,कोळशाच्या वस्तू तयार करणे ,त्याची विक्री व जळाऊ लाकूड)">Coal and coal, manufacturing of coal products, its sale and firewood (कोळसा व
                दगडी कोळसा ,कोळशाच्या वस्तू तयार करणे ,त्याची विक्री व जळाऊ लाकूड)</option>
            <option style="font-size: smaller;" value="Manufacturing of cement and cement products (सिमेंट व सिमेंट वस्तू तयार करणे)">Manufacturing of cement and cement products (सिमेंट व सिमेंट वस्तू तयार करणे)
            </option>
            <option style="font-size: smaller;" value="Asphalt and Manufacturing of asphalt products (डांबर व डांबरापासून वस्तू तयार करणे)">Asphalt and Manufacturing of asphalt products (डांबर व डांबरापासून वस्तू तयार
                करणे)</option>
            <option style="font-size: smaller;" value="Manufacturing of dynamite and their storage (डायनामाइट साठविणे व त्यापासून वस्तू तयार करणे)">Manufacturing of dynamite and their storage (डायनामाइट साठविणे व त्यापासून वस्तू
                तयार करणे)</option>
            <option style="font-size: smaller;" value="Ornamental liquor and Manufacturing of articles thereof (शोभेची दारू व त्यापासून वस्तू तयार करणे)">Ornamental liquor and Manufacturing of articles thereof (शोभेची दारू व त्यापासून
                वस्तू तयार करणे)</option>
            <option style="font-size: smaller;" value="Preparation of lime and Manufacturing of products from Plaster of Paris (चुना तयार करणे व प्लास्टर ऑफ पॅरिस पासून वस्तू तयार करणे)">Preparation of lime and Manufacturing of products from Plaster of Paris (चुना
                तयार करणे व प्लास्टर ऑफ पॅरिस पासून वस्तू तयार करणे)</option>
            <option style="font-size: smaller;" value="Manufacturing, storage and sale of boxes of sticks (काड्यांच्या पेट्या तयार करणे ,साठा व विक्री)">Manufacturing, storage and sale of boxes of sticks (काड्यांच्या पेट्या तयार करणे
                ,साठा व विक्री)</option>
            <option style="font-size: smaller;" value="Manufacturing, storage and sale of paper and paper products (कागद व कागदापासून वस्तू तयार करणे, साठा व विक्री)">Manufacturing, storage and sale of paper and paper products (कागद व कागदापासून
                वस्तू तयार करणे, साठा व विक्री)</option>
            <option style="font-size: smaller;" value="Manufacturing of rubber and rubber products (रबर व रबर वस्तूचे उत्पादन)">Manufacturing of rubber and rubber products (रबर व रबर वस्तूचे उत्पादन)</option>
            <option style="font-size: smaller;" value="Stock, Manufacturing and sale of Bidi, Bidi leaves, Tapkar, Cigarettes (बिडी ,बिडीची पाने ,तपकार ,सिग्रेट यांचा साठा ,उत्पादन व विक्री)">Stock, Manufacturing and sale of Bidi, Bidi leaves, Tapkar, Cigarettes (बिडी
                ,बिडीची पाने ,तपकार ,सिग्रेट यांचा साठा ,उत्पादन व विक्री)</option>
            <option style="font-size: smaller;" value="Stock, Manufacturing and sale of soap, liquid soap, washing powder (साबण ,द्रवरूप साबण , धुण्याची पावडर यांचा साठा ,उत्पादन व विक्री)">Stock, Manufacturing and sale of soap, liquid soap, washing powder (साबण
                ,द्रवरूप साबण , धुण्याची पावडर यांचा साठा ,उत्पादन व विक्री)</option>
            <option style="font-size: smaller;" value="Cleaning of cotton, Manufacturing of goods from cotton (Cotton not exceeding Rs. 200 kg stored in residential premises) (कापूस साफ करणे , कापसापासून वस्तूची निर्मिती करणे (निवासी जागेत रु. २०० किलो पेक्षा जास्त कापूस साठवता येणार नाही))">Cleaning of cotton, Manufacturing of goods from cotton (Cotton not exceeding Rs.
                200 kg stored in residential premises) (कापूस साफ करणे , कापसापासून वस्तूची
                निर्मिती करणे (निवासी जागेत रु. २०० किलो पेक्षा जास्त कापूस साठवता येणार नाही))
            </option>
            <option style="font-size: smaller;" value="Making an kunku(Vermelion) (कुंकू तयार करणे)">Making an kunku(Vermelion)
                (कुंकू तयार करणे)</option>
            <option style="font-size: smaller;" value="Manufacturing of Aluminium goods, their production and sale as well as Manufacturing, storage and sale of metals and articles thereof (जर्मनच्या वस्तू तयार करणे त्यांचे उत्पादन व विक्री तसेच धातू व त्यापासून उत्पादित वस्तूची निर्मिती साठा व विक्री)">Manufacturing of Aluminium goods, their production and sale as well as
                Manufacturing, storage and sale of metals and articles thereof (जर्मनच्या वस्तू
                तयार करणे त्यांचे उत्पादन व विक्री तसेच धातू व त्यापासून उत्पादित वस्तूची
                निर्मिती साठा व विक्री)</option>
            <option style="font-size: smaller;" value="Aluminium, Tarman, Silver, Hindoly Steel etc. Sale of metal, production of stone from quarry, mechanical fragmentation, mechanical cutting and polishing of stone (अॅल्युमिनियम, तरमन, सिल्वर ,हिंडोलीयं स्टील इ. धातूची विक्री करणे, खाणीतून दगडाचे उत्पादन करणे ,यंत्राचे साहाय्याने खंडीकरण करणे ,यांत्रिक शक्तीने दगडाची कटाई व पोलिश करणे)">Aluminium, Tarman, Silver, Hindoly Steel etc. Sale of metal, production of stone
                from quarry, mechanical fragmentation, mechanical cutting and polishing of stone
                (अॅल्युमिनियम, तरमन, सिल्वर ,हिंडोलीयं स्टील इ. धातूची विक्री करणे, खाणीतून
                दगडाचे उत्पादन करणे ,यंत्राचे साहाय्याने खंडीकरण करणे ,यांत्रिक शक्तीने दगडाची
                कटाई व पोलिश करणे)</option>
            <option style="font-size: smaller;" value="Silver, gold, precious metals business (चांदी ,सोने,मौल्यवान धातू)">Silver, gold, precious metals business (चांदी ,सोने,मौल्यवान धातू)</option>
            <option style="font-size: smaller;" value="1 to 9 labours Businesses registered under the Labor Factories Act (१ ते ९ कामगार फॅक्टरी ऍक्ट प्रमाणे नोंदणी झालेले व्यवसाय)">1 to 9 labours Businesses registered under the Labor Factories Act (१ ते ९
                कामगार फॅक्टरी ऍक्ट प्रमाणे नोंदणी झालेले व्यवसाय)</option>
            <option style="font-size: smaller;" value="10 to 20 labours Businesses registered under the Labor Factories Act (१० ते २० कामगार)">10 to 20 labours Businesses registered under the Labor Factories Act (१० ते २०
                कामगार)</option>
            <option style="font-size: smaller;" value="21 to 100 labours Businesses registered under the Labor Factories Act (२१ ते १०० कामगार)">21 to 100 labours Businesses registered under the Labor Factories Act (२१ ते १००
                कामगार)</option>
            <option style="font-size: smaller;" value="१०१ ते 500 labours Businesses registered under the Labor Factories Act (101 to Rs. 500 (Rs.Five Hundred only) workers)">१०१ ते 500 labours Businesses registered under the Labor Factories Act (101 to
                Rs. 500 (Rs.Five Hundred only) workers)</option>
            <option style="font-size: smaller;" value="Workers above 501 (Occupations not registered under Factories Act as well as occupations related to foodstuff) (५०१ त्या पुढील कामगार (फॅक्टरी ऍक्ट खाली नोंदणी न झालेले व्यवसाय तसेच अन्नपदार्थ संबंधीचे व्यवसाय ))">Workers above 501 (Occupations not registered under Factories Act as well as
                occupations related to foodstuff) (५०१ त्या पुढील कामगार (फॅक्टरी ऍक्ट खाली
                नोंदणी न झालेले व्यवसाय तसेच अन्नपदार्थ संबंधीचे व्यवसाय ))</option>
            <option style="font-size: smaller;" value="Preparation, storage and sale of milk, butter and products thereof apart from domestic consumption (घरगुती वापरा व्यतिरिक्त दूध ,लोणी व त्यापासून पदार्थ तयार करणे ,साठा व विक्री)">Preparation, storage and sale of milk, butter and products thereof apart from
                domestic consumption (घरगुती वापरा व्यतिरिक्त दूध ,लोणी व त्यापासून पदार्थ तयार
                करणे ,साठा व विक्री)</option>
            <option value="Processing and canning of fruits and vegetables (फळे व भाजीपाला यावर प्रक्रिया करून डबा बंद करणे)">Processing and canning of fruits and vegetables (फळे व भाजीपाला यावर प्रक्रिया
                करून डबा बंद करणे)</option>
            <option value="Flour Mill, Rice Grinding Mill, Groundnut Oil machine, Chili grinding mill, Kadvakuti and Wet Pulses Grinding (पीठ गिरणी ,तांदूळ दळन्याची गिरणी ,शेंगदाणे तेलघाणी ,मिरची कांडप ,कडवाकुटी व ओल्या डाळी दळणे)">Flour Mill, Rice Grinding Mill, Groundnut Oil machine, Chili grinding mill,
                Kadvakuti and Wet Pulses Grinding (पीठ गिरणी ,तांदूळ दळन्याची गिरणी ,शेंगदाणे
                तेलघाणी ,मिरची कांडप ,कडवाकुटी व ओल्या डाळी दळणे)</option>
            <option value="Bakery &Preparation bakery products (बेकरी व बेकरीचे पदार्थ तयार करणे)">Bakery &Preparation bakery products (बेकरी व बेकरीचे पदार्थ तयार करणे)</option>
            <option value="Dining hall and mess/canteen business (डायनिंग हॉल व जेवणावळीचा व्यवसाय)">Dining hall and mess/canteen business (डायनिंग हॉल व जेवणावळीचा व्यवसाय)
            </option>
            <option value="Co-Co Chocolate, Preparation of sweets and other products from sugar, Sugar and granulated sugar (को-को चॉकलेट,साखरेपासून मिठाई व इतर पदार्थ तयार करणे ,साखर व खडी साखर)">Co-Co Chocolate, Preparation of sweets and other products from sugar, Sugar and
                granulated sugar (को-को चॉकलेट,साखरेपासून मिठाई व इतर पदार्थ तयार करणे ,साखर व
                खडी साखर)</option>
            <option value="Juice bars and sugarcane bars (रस बार व उसाची गुन्हाळी)">Juice bars
                and sugarcane bars (रस बार व उसाची गुन्हाळी)</option>
            <option value="Ice Manifacturing (बर्फ निर्मिती)">Ice Manifacturing (बर्फ निर्मिती)
            </option>
            <option value="Textiles and textile Manufacturing goods handloom and powerloom (कापड व कापड उत्पादित वस्तू हातमाग व वीजमाग)">Textiles and textile Manufacturing goods handloom and powerloom (कापड व कापड
                उत्पादित वस्तू हातमाग व वीजमाग)</option>
            <option value="Textile shops (कापडाची दुकाने)">Textile shops (कापडाची दुकाने)
            </option>
            <option value="Tailoring, making and selling readymate garments (शिलाई काम ,रेडिमेट गारमेंट्स तयार करणे व विक्री करणे)">Tailoring, making and selling readymate garments (शिलाई काम ,रेडिमेट गारमेंट्स
                तयार करणे व विक्री करणे)</option>
            <option value="Mattress factories (गादी कारखाने)">Mattress factories (गादी कारखाने)
            </option>
            <option value="Dyeing the yarn (सुताला रंग देणे)">Dyeing the yarn (सुताला रंग देणे)
            </option>
            <option value="Printing on cloth (कापडावर छपाई)">Printing on cloth (कापडावर छपाई)
            </option>
            <option value="Stocking and selling of all types of textile, sackcloth, caste, jute (कापडनिर्मिती ,गोणपाट ,जाते,ताग सर्व प्रकारचे वार्दाने यांचा साठा व विक्री)">Stocking and selling of all types of textile, sackcloth, caste, jute
                (कापडनिर्मिती ,गोणपाट ,जाते,ताग सर्व प्रकारचे वार्दाने यांचा साठा व विक्री)
            </option>
            <option value="Manufacturing of wood and wood products Wooden furniture (लाकूड व लाकूड उत्पादित वस्तू लाकडी फर्निचर तयार करणे)">Manufacturing of wood and wood products Wooden furniture (लाकूड व लाकूड उत्पादित
                वस्तू लाकडी फर्निचर तयार करणे)</option>
            <option value="Manufacturing of Doors, Windows, Frames, Bamboo Stock, Timber Stock and Sale (दरवाजे ,खिडक्या ,फ्रेम्स तयार करणे ,बांबू साठा ,इमारती लाकूड साठा व विक्री)">Manufacturing of Doors, Windows, Frames, Bamboo Stock, Timber Stock and Sale
                (दरवाजे ,खिडक्या ,फ्रेम्स तयार करणे ,बांबू साठा ,इमारती लाकूड साठा व विक्री)
            </option>
            <option value="Making wooden boxes (लाकडी खोके तयार करणे)">Making wooden boxes
                (लाकडी खोके तयार करणे)</option>
            <option value="Manufacturing of wooden toys, printing and publishing and Manufacturing of paper goods (लाकडी खेळणी तयार करणे ,मुद्रण व प्रकाशन व कागदाच्या वस्तू तयार करणे)">Manufacturing of wooden toys, printing and publishing and Manufacturing of paper
                goods (लाकडी खेळणी तयार करणे ,मुद्रण व प्रकाशन व कागदाच्या वस्तू तयार करणे)
            </option>
            <option value="Printing Press, Photo Studio (प्रिंटिंग प्रेस ,फोटो स्टुडिओ)">Printing Press, Photo Studio (प्रिंटिंग प्रेस ,फोटो स्टुडिओ)</option>
            <option value="Paper and paper products, notebooks, books, binding work, envelopes, pamphlets, gifts and presentations (कागद व कागदापासून वस्तू तयार करणे ,वह्या ,पुस्तके ,बाइंडिंग वर्क लिफाफे पत्रिका गिफ्ट व प्रेझेंटेशन)">Paper and paper products, notebooks, books, binding work, envelopes, pamphlets,
                gifts and presentations (कागद व कागदापासून वस्तू तयार करणे ,वह्या ,पुस्तके
                ,बाइंडिंग वर्क लिफाफे पत्रिका गिफ्ट व प्रेझेंटेशन)</option>
            <option value="Newspaper printing and publishing (वर्तमानपत्र मुद्रण व प्रकाशन)">Newspaper printing and publishing (वर्तमानपत्र मुद्रण व प्रकाशन)</option>
            <option value="Book binding and paper cutting (बुक बाइंडिंग व पेपर कटिंग)">Book
                binding and paper cutting (बुक बाइंडिंग व पेपर कटिंग)</option>
            <option value="Manufacturing of leather and leather goods,Stock and Sales (चामडे व चामड्याच्या वस्तू तयार करणे ,साठा व विक्री)">Manufacturing of leather and leather goods,Stock and Sales (चामडे व चामड्याच्या
                वस्तू तयार करणे ,साठा व विक्री)</option>
            <option value="Leather making, selling and stocking of leather goods (चामडे कमविणे ,चामड्याच्या वस्तू विक्री व साठा)">Leather making, selling and stocking of leather goods (चामडे कमविणे ,चामड्याच्या
                वस्तू विक्री व साठा)</option>
            <option value="Manufacturing and sale of rubber and plastic articles, rubber and plastic (रबरच्या व प्लास्टिकच्या वस्तू ,रबर व प्लास्टिक तयार करणे व त्याची विक्री करणे)">Manufacturing and sale of rubber and plastic articles, rubber and plastic
                (रबरच्या व प्लास्टिकच्या वस्तू ,रबर व प्लास्टिक तयार करणे व त्याची विक्री करणे)
            </option>
            <option value="Retrending and Vulcanizing works (रिट्रेंडिंग व व्हॅकलनायझिंगची कामे)">Retrending and Vulcanizing works (रिट्रेंडिंग व व्हॅकलनायझिंगची कामे)</option>
            <option value="Cement stock, sales and production (सिमेंट साठा, विक्री व उत्पादन)">Cement stock, sales and production (सिमेंट साठा, विक्री व उत्पादन)</option>
            <option value="Making of Clay, Plaster of Paris, Cement Statues and Statues (मातीचे, प्लास्टर ऑफ पॅरीसचे, सिमेंटचे पुतळे व मुर्ती तयार करणे)">Making of Clay, Plaster of Paris, Cement Statues and Statues (मातीचे, प्लास्टर
                ऑफ पॅरीसचे, सिमेंटचे पुतळे व मुर्ती तयार करणे)</option>
            <option value="Stock and sale of lime (चुना साठा व विक्री)">Stock and sale of lime
                (चुना साठा व विक्री)</option>
            <option value="Manufacturing, stock and sale of non-metallic mineral goods, metal furniture, stationary goods (नॉन मेटॅलीक खनिज वस्तु, धातुचे फर्निचर, स्थिर वस्तु यांची निर्मिती साठा व विक्री)">Manufacturing, stock and sale of non-metallic mineral goods, metal furniture,
                stationary goods (नॉन मेटॅलीक खनिज वस्तु, धातुचे फर्निचर, स्थिर वस्तु यांची
                निर्मिती साठा व विक्री)</option>
            <option value="Plating, polishing, sharpening, welding and fabrication of metals, fabrication of gratings and windows (धातुंना मुलामा देणे, चकाकी आणणे, धार करणे, वेल्डींग अँड फेब्रीकेशन, लोखंडी जाळ्या व खिडक्या तयार करणे)">Plating, polishing, sharpening, welding and fabrication of metals, fabrication
                of gratings and windows (धातुंना मुलामा देणे, चकाकी आणणे, धार करणे, वेल्डींग अँड
                फेब्रीकेशन, लोखंडी जाळ्या व खिडक्या तयार करणे)</option>
            <option value="Manufacturing, selling and stocking as well as repairing and selling electronic goods (इलेक्ट्रानिक वस्तु निर्मिती विक्री व साठा तसेच त्यांची दुरुस्ती व विक्री करणे)">Manufacturing, selling and stocking as well as repairing and selling electronic
                goods (इलेक्ट्रानिक वस्तु निर्मिती विक्री व साठा तसेच त्यांची दुरुस्ती व विक्री
                करणे)</option>
            <option value="Repair and sale of electrical appliances, radio, TV, fridge, fans etc (विजेची उपकरणे, रेडिओ, टि.व्ही, फ्रिज, पंखे इत्यादीची दुरुस्ती व विक्री)">Repair and sale of electrical appliances, radio, TV, fridge, fans etc (विजेची
                उपकरणे, रेडिओ, टि.व्ही, फ्रिज, पंखे इत्यादीची दुरुस्ती व विक्री)</option>
            <option value="Means of transport eg. Goods train, Handcart etc. Manufacturing, repair and sale of goods (वाहतुकीची साधन उदा. मालगाडी, हातगाडी इ. वस्तुची निर्मिती, दुरुस्ती व विक्री)">Means of transport eg. Goods train, Handcart etc. Manufacturing, repair and sale
                of goods (वाहतुकीची साधन उदा. मालगाडी, हातगाडी इ. वस्तुची निर्मिती, दुरुस्ती व
                विक्री)</option>
            <option value="Battery charging and repair (बॅटरी प्रभरण व दुरुस्ती)">Battery
                charging and repair (बॅटरी प्रभरण व दुरुस्ती)</option>
            <option value="Maintenance Sales and Repair of Cars, Motorcycles, Spray Print (मोटारी, मोटार सायकल यांची देखभाल विक्री व दुरुस्ती, स्प्रे प्रिंट)">Maintenance Sales and Repair of Cars, Motorcycles, Spray Print (मोटारी, मोटार
                सायकल यांची देखभाल विक्री व दुरुस्ती, स्प्रे प्रिंट)</option>
            <option value="Repair, sale and rental of bicycles, cycle rickshaws.Manufacturing, repair, maintenance and sale of goods other than those listed above (सायकली, सायकल रिक्षा यांची दुरुस्ती विक्री व भाड्याने देणे, वरील यादी शिवाय इतर वस्तुंची निर्मिती, दुरुस्ती देखभाल विक्री)">Repair, sale and rental of bicycles, cycle rickshaws.Manufacturing, repair,
                maintenance and sale of goods other than those listed above (सायकली, सायकल
                रिक्षा यांची दुरुस्ती विक्री व भाड्याने देणे, वरील यादी शिवाय इतर वस्तुंची
                निर्मिती, दुरुस्ती देखभाल विक्री)</option>
            <option value="Clock repair and sales (घड्याळ दुरुस्ती व विक्री)">Clock repair and
                sales (घड्याळ दुरुस्ती व विक्री)</option>
            <option value="Manufacturing, repair and sale of sports and exercise equipment (क्रिडा व व्यायाम साधनांची निर्मिती, दुरुस्ती व विक्री)">Manufacturing, repair and sale of sports and exercise equipment (क्रिडा व
                व्यायाम साधनांची निर्मिती, दुरुस्ती व विक्री)</option>
            <option value="Musical instrument making and repair (वाद्य निर्मिती व दुरुस्ती)">Musical instrument making and repair (वाद्य निर्मिती व दुरुस्ती)</option>
            <option value="All types of general stores (सर्व प्रकारचे जनरल स्टोअर्स)">All types
                of general stores (सर्व प्रकारचे जनरल स्टोअर्स)</option>
            <option value="Manufacturing, repair and sale of household items such as locks, stoves, sewing machines etc (कुलपे, स्टो, शिवणयंत्रे इत्यादी घरघुती वस्तुंची निर्मिती, दुरुस्ती व विक्री)">Manufacturing, repair and sale of household items such as locks, stoves, sewing
                machines etc (कुलपे, स्टो, शिवणयंत्रे इत्यादी घरघुती वस्तुंची निर्मिती, दुरुस्ती
                व विक्री)</option>
            <option value="Sale and repair of glasses (चष्म्याची विक्री व दुरुस्ती)">Sale and
                repair of glasses (चष्म्याची विक्री व दुरुस्ती)</option>
            <option value="Laundry business (लाँड्री व्यवसाय)">Laundry business (लाँड्री
                व्यवसाय)</option>
            <option value="Laboratory, Repair and Sale of Photographic Equipment (प्रयोग शाळा, फोटोग्राफीक समानाची दुरुस्ती व विक्री)">Laboratory, Repair and Sale of Photographic Equipment (प्रयोग शाळा, फोटोग्राफीक
                समानाची दुरुस्ती व विक्री)</option>
            <option value="Xerox Machine Repair & Sales, Computer Repair & Sales (झेरॉक्स मशिन दुरुस्ती व विक्री कॉम्प्युटर दुरुस्ती व विक्री)">Xerox Machine Repair &Sales, Computer Repair &Sales (झेरॉक्स मशिन दुरुस्ती व
                विक्री कॉम्प्युटर दुरुस्ती व विक्री)</option>
            <option value="All kinds of poultry farms (सर्व प्रकारचे कुकुटपालन)">All kinds of
                poultry farms (सर्व प्रकारचे कुकुटपालन)</option>
            <option value="Conducting classes of embroidery, sewing etc (भरतकाम, शिवणकाम इत्यादी वर्ग चालविणे)">Conducting classes of embroidery, sewing etc (भरतकाम, शिवणकाम इत्यादी वर्ग
                चालविणे)</option>
            <option value="Conducting all types of private classes (except academic) (सर्व प्रकारचे खाजगी वर्ग चालविणे (शैक्षणिक वगळता व्यावसायीक))">Conducting all types of private classes (except academic) (सर्व प्रकारचे खाजगी
                वर्ग चालविणे (शैक्षणिक वगळता व्यावसायीक))</option>
            <option value="To carry out carpentry business by mechanical means (कडबाकुटृी व्यवसाय यांत्रिक पध्दतीने करणे)">To carry out carpentry business by mechanical means (कडबाकुटृी व्यवसाय यांत्रिक
                पध्दतीने करणे)</option>
            <option value="Hairdresser, beauty parlour (केश कर्तनालय, ब्युटी पार्लर)">Hairdresser, beauty parlour (केश कर्तनालय, ब्युटी पार्लर)</option>
            <option value="Business of Lodging and Boarding (लॉजिंग बोर्डींगचा व्यवसाय)">Business of Lodging and Boarding (लॉजिंग बोर्डींगचा व्यवसाय)</option>
            <option value="PCO and STD Run the booth (पी.सी.ओ. व एस.टी.डी. बुथ चालविणे)">PCO and
                STD Run the booth (पी.सी.ओ. व एस.टी.डी. बुथ चालविणे)</option>
            <option value="Conducting Cable Operating Business Main Distributor (केबल ऑपरेटींगचा व्यवसाय चालविणे मुख्य वितरक)">Conducting Cable Operating Business Main Distributor (केबल ऑपरेटींगचा व्यवसाय
                चालविणे मुख्य वितरक)</option>
            <option value="Sub distributor carrying on the business of cable operating (केबल ऑपरेटींगचा व्यवसाय चालविणे उप वितरक)">Sub distributor carrying on the business of cable operating (केबल ऑपरेटींगचा
                व्यवसाय चालविणे उप वितरक)</option>
            <option value="Video shooting business (व्हिडीओ श्युटींगचा व्यवसाय)">Video shooting
                business (व्हिडीओ श्युटींगचा व्यवसाय)</option>
            <option value="Storage and sale of foodgrains and sale and storage of oilseeds (अन्नधान्य साठा व विक्री तसेच तेलबिया विक्री व साठा)">Storage and sale of foodgrains and sale and storage of oilseeds (अन्नधान्य साठा
                व विक्री तसेच तेलबिया विक्री व साठा)</option>
            <option value="Newspapers, Libraries, Book Depots, Magazines, Magazines, Junk Sales and Stocks (वृत्तपत्रे, वाचनालये, बुकडेपो, नियतकालीके, मासिके, रद्दी विक्री व साठा)">Newspapers, Libraries, Book Depots, Magazines, Magazines, Junk Sales and Stocks
                (वृत्तपत्रे, वाचनालये, बुकडेपो, नियतकालीके, मासिके, रद्दी विक्री व साठा)
            </option>
            <option value="Breeding centers (बिछायत केंद्रे)">Breeding centers (बिछायत केंद्रे)
            </option>
            <option value="Private Postal Service, Courier Service, Angadia Service (खाजगी टपाल सर्विस, कुरीयर सर्विस, आंगडीया सेवा)">Private Postal Service, Courier Service, Angadia Service (खाजगी टपाल सर्विस,
                कुरीयर सर्विस, आंगडीया सेवा)</option>
            <option value="Manufacturing, storage and sale of all types of beverages, sale of all types of aerated beverages (सर्व प्रकारचे पेय तयार करणे, साठा करणे व विक्री करणे, सर्व प्रकारचे वायु मिश्रीत पेयांची विक्री)">Manufacturing, storage and sale of all types of beverages, sale of all types of
                aerated beverages (सर्व प्रकारचे पेय तयार करणे, साठा करणे व विक्री करणे, सर्व
                प्रकारचे वायु मिश्रीत पेयांची विक्री)</option>
            <option value="Private Medical Services And Related laboratory (INDOOR) (खाजगी वैद्यकीय सेवा व त्या संबंधीच्या प्रयोग शाळा (इनडोअर))">Private Medical Services And Related laboratory (INDOOR) (खाजगी वैद्यकीय सेवा व
                त्या संबंधीच्या प्रयोग शाळा (इनडोअर))</option>
            <option value="Alcohol production (wineries) (मद्यार्क उत्पादन (वाईनरीज))">Alcohol
                production (wineries) (मद्यार्क उत्पादन (वाईनरीज))</option>
            <option value="Stock and sale of compound fertilizers, pesticides (मिश्र खते, जंतुनाशके यांचा साठा व विक्री)">Stock and sale of compound fertilizers, pesticides (मिश्र खते, जंतुनाशके यांचा
                साठा व विक्री)</option>
            <option value="Stock and sale of potable and denatured (poisoned) spirits (अपेय व डिसेचर्ड (विषकृत) स्पिरीट साठा व विक्री)">Stock and sale of potable and denatured (poisoned) spirits (अपेय व डिसेचर्ड
                (विषकृत) स्पिरीट साठा व विक्री)</option>
            <option value="Acid stock and sale (ॲसीड साठा व विक्री)">Acid stock and sale (ॲसीड
                साठा व विक्री)</option>
            <option value="Chemicals and All Kinds of Medicine Stock and Sale (Medical) (केमिकल्स व सर्व प्रकारची औषधी साठा व विक्री (मेडिकल))">Chemicals and All Kinds of Medicine Stock and Sale (Medical) (केमिकल्स व सर्व
                प्रकारची औषधी साठा व विक्री (मेडिकल))</option>
            <option value="Stocking and sale of animal feed (जनावराचे खाद्य साठा व विक्री)">Stocking and sale of animal feed (जनावराचे खाद्य साठा व विक्री)</option>
            <option value="Old idle scrap stocks and sales (जुने निकामी स्क्रॅप साठा व विक्री)">Old idle scrap stocks and sales (जुने निकामी स्क्रॅप साठा व विक्री)</option>
            <option value="Selling or offering for sale fur, whether or not for human consumption (no public place or public road shall be used for the purpose) (मानवी आहारासाठी असो किंवा नसो फरीने विकण्याचा किंवा विक्रीसाठी मांडण्याचा (प्रयोजनासाठी कोणत्याही सार्वजनिक जागेचा किंवा सार्वजनिक रस्त्याचा उपयोग करता येणार नाही))">Selling or offering for sale fur, whether or not for human consumption (no
                public place or public road shall be used for the purpose) (मानवी आहारासाठी असो
                किंवा नसो फरीने विकण्याचा किंवा विक्रीसाठी मांडण्याचा (प्रयोजनासाठी कोणत्याही
                सार्वजनिक जागेचा किंवा सार्वजनिक रस्त्याचा उपयोग करता येणार नाही))</option>
            <option value="Petrol and Diesel Pump Stock and Sale (as defined in the Petroleum Act, 1934)(पेट्रोल व डिझेल पंप साठा व विक्री (पेट्रोलियम अधि. 1934 मध्ये व्याख्या केल्याप्रमाणे))">Petrol and Diesel Pump Stock and Sale (as defined in the Petroleum Act,
                1934)(पेट्रोल व डिझेल पंप साठा व विक्री (पेट्रोलियम अधि. 1934 मध्ये व्याख्या
                केल्याप्रमाणे))</option>
            <option style="font-size: smaller;" value="Stock and sale of industrial grasses (औद्यागिक घासलेट साठा व विक्री)">Stock and sale of industrial grasses (औद्यागिक घासलेट साठा व विक्री)</option>
            <option style="font-size: smaller;" value="Sale of chiller for household use (घरघुती वापरासाठी चिल्लर घासलेट विक्री)">Sale of chiller for household use (घरघुती वापरासाठी चिल्लर घासलेट विक्री)
            </option>
            <option style="font-size: smaller;" value="Lubricating and oil storage and grease storage (लुब्रीकेटींग व ऑईल साठा व ग्रिस साठा)">Lubricating and oil storage and grease storage (लुब्रीकेटींग व ऑईल साठा व ग्रिस
                साठा)</option>
            <option style="font-size: smaller;" value="Crude oil reserves (क्रुड ऑईल साठा)">Crude oil reserves (क्रुड ऑईल साठा)</option>
            <option style="font-size: smaller;" value="Liquefied Gas Cylinder Stock and Sales and LPG Gas Supply Agency (द्रवरुप गॅस सिलेंडर साठा व विक्री व एलपीजी गॅस पुरवठा एजन्सी)">Liquefied Gas Cylinder Stock and Sales and LPG Gas Supply Agency (द्रवरुप गॅस
                सिलेंडर साठा व विक्री व एलपीजी गॅस पुरवठा एजन्सी)</option>
            <option style="font-size: smaller;" value="All types of wax (सर्व प्रकारचे मोम (मेण))">All types of wax (सर्व
                प्रकारचे मोम (मेण))</option>
            <option style="font-size: smaller;" value=">Preparation of camphor stock and sale (कापूर तयार करणे साठा व विक्री)">Preparation of camphor stock and sale (कापूर तयार करणे साठा व विक्री)</option>
            <option style="font-size: smaller;" value="Turpentine, Color Varnish, Paint Stock and Sale (टर्पेंटाईन, रंग वॉर्निश, पेंट साठा व विक्री)">Turpentine, Color Varnish, Paint Stock and Sale (टर्पेंटाईन, रंग वॉर्निश, पेंट
                साठा व विक्री)</option>
            <option style="font-size: smaller;" value=">Film stock (चलचित्रपट साठा)">Film stock
                (चलचित्रपट साठा)</option>
            <option style="font-size: smaller;" value="Fire Box Stock and Sale (आगपेटी साठा व विक्री)">Fire Box Stock and Sale
                (आगपेटी साठा व विक्री)</option>
            <option style="font-size: smaller;" value="Ice, ice candy, ice cream sales and stock (बर्फ, आईस कॅन्डी, आईसक्रीम विक्री व साठा)">Ice, ice candy, ice cream sales and stock (बर्फ, आईस कॅन्डी, आईसक्रीम विक्री व
                साठा)</option>
            <option style="font-size: smaller;" value="All occupations other than those not covered above (वर समाविष्ट नसलेल्या व्यवसायाव्यतिरिक्त इतर सर्व व्यवसाय)">All occupations other than those not covered above (वर समाविष्ट नसलेल्या
                व्यवसायाव्यतिरिक्त इतर सर्व व्यवसाय)</option>
            <option style="font-size: smaller;" value="Coconut rope (नारळाची दोरी)">Coconut rope
                (नारळाची दोरी)</option>
            <option style="font-size: smaller;" value="grass (गवत)">grass (गवत)</option>
            <option style="font-size: smaller;" value="weed (तणस)">weed (तणस)</option>
            <option style="font-size: smaller;" value="Sandal wood/powder (चंदनाचे लाकुड/पावडर)">Sandal wood/powder (चंदनाचे
                लाकुड/पावडर)</option>
            <option style="font-size: smaller;" value="Animal horns and bones (जनावराची शिंगे व हाडे)">Animal horns and bones
                (जनावराची शिंगे व हाडे)</option>
            <option style="font-size: smaller;" value="Office of Freight Business (Transport) (माल वाहतुक व्यवसाय कार्यालय (ट्रांसपोर्ट))">Office of Freight Business (Transport) (माल वाहतुक व्यवसाय कार्यालय
                (ट्रांसपोर्ट))</option>
            <option style="font-size: smaller;" value="Private Godown (खाजगी गोडाऊन)">Private
                Godown (खाजगी गोडाऊन)</option>
            <option style="font-size: smaller;" value="All Kinds of Textile Sales (Chiller) (सर्व प्रकारचे कापड विक्री (चिल्लर))">All Kinds of Textile Sales (Chiller) (सर्व प्रकारचे कापड विक्री (चिल्लर))
            </option>
            <option style="font-size: smaller;" value="Cement and iron roofing sheets (सिमेंट व लोखंडाचे छताचे पत्रे)">Cement
                and iron roofing sheets (सिमेंट व लोखंडाचे छताचे पत्रे)</option>
            <option style="font-size: smaller;" value="Granite/Marble Stone, Tiles, Marble Dealers (ग्रेनाईट/संगमरवरी दगड, टाईल्स, मार्बल विक्रेते)">Granite/Marble Stone, Tiles, Marble Dealers (ग्रेनाईट/संगमरवरी दगड, टाईल्स,
                मार्बल विक्रेते)</option>
            <option style="font-size: smaller;" value="Processing bones and hides into powder (wet/dry) (हाडे व चामडे यांच्यावर प्रक्रिया करुन पावडर तयार करणे (ओली/सुखी))">Processing bones and hides into powder (wet/dry) (हाडे व चामडे यांच्यावर
                प्रक्रिया करुन पावडर तयार करणे (ओली/सुखी))</option>
            <option style="font-size: smaller;" value="Departmental store (डिपर्टमेंटल स्टोअर)">Departmental store (डिपर्टमेंटल स्टोअर)</option>
            <option style="font-size: smaller;" value="Lathe machine, polishing machine (लेथ मशिन, पॉलिश मशिन)">Lathe machine,
                polishing machine (लेथ मशिन, पॉलिश मशिन)</option>
            <option style="font-size: smaller;" value="Taxis, cars, buses, trucks Contractual vehicles used for carrying goods or passengers (टॅक्सी, कार, बस, ट्रक करारावर आधारीत वाहने माल वाहतुक किंवा प्रवासी वाहुन नेण्याकरीता वापरात येणा)">Taxis, cars, buses, trucks Contractual vehicles used for carrying goods or
                passengers (टॅक्सी, कार, बस, ट्रक करारावर आधारीत वाहने माल वाहतुक किंवा प्रवासी
                वाहुन नेण्याकरीता वापरात येणा)</option>
            <option style="font-size: smaller;" value="Photo Color Lab Coaching Classes (Academic) (फोटो कलर लॅब कोचिंग क्लासेस (शैक्षणिक))">Photo Color Lab Coaching Classes (Academic) (फोटो कलर लॅब कोचिंग क्लासेस
                (शैक्षणिक))</option>
            <option style="font-size: smaller;" value="Coaching Class (Academic) (कोचिंग क्लास (शैक्षणिक))">Coaching Class
                (Academic) (कोचिंग क्लास (शैक्षणिक))</option>
            <option style="font-size: smaller;" value="Video games (व्हिडीओ गेम्स)">Video games
                (व्हिडीओ गेम्स)</option>
            <option style="font-size: smaller;" value="Cinema house (सिनेमा गृह)">Cinema house
                (सिनेमा गृह)</option>
            <option style="font-size: smaller;" value="Theater house (नाट्य गृह)">Theater house
                (नाट्य गृह)</option>
            <option style="font-size: smaller;" value="Marriage office (मंगल कार्यालय)">Marriage
                office (मंगल कार्यालय)</option>
            <option style="font-size: smaller;" value="Social Hall (सामाजिक सभागृह)">Social Hall
                (सामाजिक सभागृह)</option>
            <option style="font-size: smaller;" value="Lawns to be used for wedding parties (लग्न पार्टिसाठी वापरण्याचे लॉन्स)">Lawns to be used for wedding parties (लग्न पार्टिसाठी वापरण्याचे लॉन्स)</option>
            <option style="font-size: smaller;" value="Agricultural Service Centre (कृषी सेवा केंद्र)">Agricultural Service
                Centre (कृषी सेवा केंद्र)</option>
            <option style="font-size: smaller;" value="Mutton/Chicken seller (मटण/ चिकन विक्रेता)">Mutton/Chicken seller (मटण/
                चिकन विक्रेता)</option>
            <option style="font-size: smaller;" value="Dry Fish Seller (सुखी मासोळी विक्रेता)">Dry Fish Seller (सुखी मासोळी विक्रेता)</option>
            <option style="font-size: smaller;" value="Manufacturing and sale of articles from china clay (चिनीमाती पासून वस्तू तयार व विक्री करणे)">Manufacturing and sale of articles from china clay (चिनीमाती पासून वस्तू तयार व
                विक्री करणे)</option>
            <option style="font-size: smaller;" value="grocery Wholesale seller (किराणा ठोक विक्रेते)">grocery Wholesale seller
                (किराणा ठोक विक्रेते)</option>
            <option style="font-size: smaller;" value="Grocery retail seller (किराणा चिल्लर विक्रेते)">Grocery retail seller
                (किराणा चिल्लर विक्रेते)</option>
            <option style="font-size: smaller;" value="Obstrected shopkeepers and commission agents (अडत दुकानदार व कमिशन एजन्ट)">Obstrected shopkeepers and commission agents (अडत दुकानदार व कमिशन एजन्ट)
            </option>
            <option style="font-size: smaller;" value="Book Sellers/ Magazine Centre (बुक सेलर्स/ मॅगझीन सेंटर)">Book Sellers/
                Magazine Centre (बुक सेलर्स/ मॅगझीन सेंटर)</option>
            <option style="font-size: smaller;" value="Tea and coffee Wholesale seller (चहा आणि कॉफी ठोक विक्रेते)">Tea and
                coffee Wholesale seller (चहा आणि कॉफी ठोक विक्रेते)</option>
            <option style="font-size: smaller;" value="Tea and coffee retail seller (चहा आणि कॉफी चिल्लर विक्रेते)">Tea and
                coffee retail seller (चहा आणि कॉफी चिल्लर विक्रेते)</option>
            <option style="font-size: smaller;" value="Selling Vegetables (Shops / Ota) (भाजीपाला विक्री ( दुकाने/ ओटे))">Selling Vegetables (Shops / Ota) (भाजीपाला विक्री ( दुकाने/ ओटे))</option>
            <option style="font-size: smaller;" value="Fruits (including coconut) Wholesale seller (फळे ( समाविष्ट नारळ ) ठोक विक्रेते)">Fruits (including coconut) Wholesale seller (फळे ( समाविष्ट नारळ ) ठोक विक्रेते)
            </option>
            <option style="font-size: smaller;" value="Fruits (including coconut) retail seller (फळे ( समाविष्ट नारळ ) चिल्लर विक्रेते)">Fruits (including coconut) retail seller (फळे ( समाविष्ट नारळ ) चिल्लर विक्रेते)
            </option>
            <option style="font-size: smaller;" value="Onions, dry chillies, garlic, potatoes Wholesale seller (कांदे, सुकी मिरची, लसूण, आलु ठोक विक्रेते)">Onions, dry chillies, garlic, potatoes Wholesale seller (कांदे, सुकी मिरची,
                लसूण, आलु ठोक विक्रेते)</option>
            <option style="font-size: smaller;" value="Onions, dry chillies, garlic, potatoes retail seller (कांदे, सुकी मिरची, लसूण, आलु चिल्लर विक्रेते)">Onions, dry chillies, garlic, potatoes retail seller (कांदे, सुकी मिरची, लसूण,
                आलु चिल्लर विक्रेते)</option>
            <option style="font-size: smaller;" value="Jaggery sugar Wholesale seller (गुळ साखर ठोक विक्रेते)">Jaggery sugar
                Wholesale seller (गुळ साखर ठोक विक्रेते)</option>
            <option style="font-size: smaller;" value="Hardware Wholesale seller (हार्डवेअर ठोक विक्रेते)">Hardware Wholesale
                seller (हार्डवेअर ठोक विक्रेते)</option>
            <option style="font-size: smaller;" value="Hardware retail seller (हार्डवेअर चिल्लर विक्रेते)">Hardware retail
                seller (हार्डवेअर चिल्लर विक्रेते)</option>
            <option style="font-size: smaller;" value="Egg Wholesale seller (अंडे ठोक विक्रेते)">Egg Wholesale seller (अंडे ठोक
                विक्रेते)</option>
            <option style="font-size: smaller;" value="Hosiery Goods Wholesale seller (होजियरी गुड्स ठोक विक्रेते)">Hosiery
                Goods Wholesale seller (होजियरी गुड्स ठोक विक्रेते)</option>
            <option style="font-size: smaller;" value="Hosiery Goods retail seller (होजियरी गुड्स चिल्लर विक्रेते)">Hosiery
                Goods retail seller (होजियरी गुड्स चिल्लर विक्रेते)</option>
            <option style="font-size: smaller;" value="Automobile shop (ऑटोमोबाईल चे दुकान)">Automobile shop (ऑटोमोबाईल चे दुकान)</option>
            <option style="font-size: smaller;" value="Tobacco Wholesale seller (तंबाखू ठोक विक्रेते)">Tobacco Wholesale seller
                (तंबाखू ठोक विक्रेते)</option>
            <option style="font-size: smaller;" value="Tobacco retail seller (तंबाखू चिल्लर विक्रेते)">Tobacco retail seller
                (तंबाखू चिल्लर विक्रेते)</option>
            <option style="font-size: smaller;" value="Plastic items retail seller (प्लास्टिक वस्तू चिल्लर विक्रेते)">Plastic
                items retail seller (प्लास्टिक वस्तू चिल्लर विक्रेते)</option>
            <option style="font-size: smaller;" value="Manufacturing and sale of clay artwork (मातीच्या कलाकृती वस्तू तयार व विक्री (Earthen Post))">Manufacturing and sale of clay artwork (मातीच्या कलाकृती वस्तू तयार व विक्री
                (Earthen Post))</option>
            <option style="font-size: smaller;" value="Sale by carving on metal or wood (Engraving) (धातू अथवा लाकडावर नक्षीकाम करून विक्री (Engraving))">Sale by carving on metal or wood (Engraving) (धातू अथवा लाकडावर नक्षीकाम करून
                विक्री (Engraving))</option>
            <option style="font-size: smaller;" value="Photo framing (फोटो फ्रेमिंग)">Photo
                framing (फोटो फ्रेमिंग)</option>
            <option style="font-size: smaller;" value="Flower shop (फुलाचे दुकान)">Flower shop
                (फुलाचे दुकान)</option>
            <option style="font-size: smaller;" value="All types of machinery sales and service (सर्व प्रकारच्या मशिनरी विक्री व सेवा)">All types of machinery sales and service (सर्व प्रकारच्या मशिनरी विक्री व सेवा)
            </option>
            <option style="font-size: smaller;" value="Money Landers registered (सावकारी ( Money Landers) नोंदणीकृत)">Money
                Landers registered (सावकारी ( Money Landers) नोंदणीकृत)</option>
            <option style="font-size: smaller;" value="Money Exchange (चलन बदलविणे ( Money Exchange))">Money Exchange (चलन
                बदलविणे ( Money Exchange))</option>
            <option style="font-size: smaller;" value="Sanitary Fitting Goods (सेनेटरी फिटिंग गुड्स)">Sanitary Fitting Goods
                (सेनेटरी फिटिंग गुड्स)</option>
            <option style="font-size: smaller;" value="Glassware shop (काचेच्या वस्तूचे दुकान)">Glassware shop (काचेच्या वस्तूचे दुकान)</option>
            <option style="font-size: smaller;" value="Registered Co-operative Societies (नोंदणीकृत सहकारी संस्था)">Registered
                Co-operative Societies (नोंदणीकृत सहकारी संस्था)</option>
            <option style="font-size: smaller;" value="Two wheeler Garage (गॅरेज टू व्हीलर)">Two
                wheeler Garage (गॅरेज टू व्हीलर)</option>
            <option style="font-size: smaller;" value="Three wheeler Garage (गॅरेजथ्री व्हीलर)">Three wheeler Garage (गॅरेजथ्री व्हीलर)</option>
            <option style="font-size: smaller;" value="Bank / LIC (बँक/ एल. आय. सी)">Bank / LIC
                (बँक/ एल. आय. सी)</option>
            <option style="font-size: smaller;" value="Credit Society (पतसंस्था)">Credit Society
                (पतसंस्था)</option>
            <option style="font-size: smaller;" value="Antique shop (जुन्या वापलेल्या वास्तूचे दुकान)">Antique shop (जुन्या
                वापलेल्या वास्तूचे दुकान)</option>
            <option style="font-size: smaller;" value="Housing Finance Institutions / Chit Funds and All Kinds of Lending Institutions (हाऊसिंग फायनान्स संस्था/ चिट फंड व सर्व प्रकारचे कर्ज देणारी संस्था)">Housing Finance Institutions / Chit Funds and All Kinds of Lending Institutions
                (हाऊसिंग फायनान्स संस्था/ चिट फंड व सर्व प्रकारचे कर्ज देणारी संस्था)</option>
            <option style="font-size: smaller;" value="awkers (फेरीवाले)">Hawkers (फेरीवाले)
            </option>
            <option style="font-size: smaller;" value="Nursery / Plant seller (नर्सरी/ रोपविक्री)">Nursery / Plant seller
                (नर्सरी/ रोपविक्री)</option>
            <option style="font-size: smaller;" value="Allopathic, Homeopathy, Ayurvedic Dispensary (ऍलोपॅथिक, होमिओपॅथी, आयुर्वेदिक डिस्पेन्सरी)">Allopathic, Homeopathy, Ayurvedic Dispensary (ऍलोपॅथिक, होमिओपॅथी, आयुर्वेदिक
                डिस्पेन्सरी)</option>
            <option style="font-size: smaller;" value="Radiologist (रेडियोलॉजिस्ट)">Radiologist
                (रेडियोलॉजिस्ट)</option>
            <option style="font-size: smaller;" value="Pathological laboratories (पॅथालॉजिकल लॅबोरेटरीज)">Pathological
                laboratories (पॅथालॉजिकल लॅबोरेटरीज)</option>
            <option style="font-size: smaller;" value="Electric Decoration, Sound Service (इलेक्ट्रिक डेकोरेशन, साउंड सर्विस)">Electric Decoration, Sound Service (इलेक्ट्रिक डेकोरेशन, साउंड सर्विस)</option>
            <option style="font-size: smaller;" value="Video, CD library (व्हिडिओ, सी डी लायब्ररी)">Video, CD library (व्हिडिओ,
                सी डी लायब्ररी)</option>
            <option style="font-size: smaller;" value="Old book Seller (जुने पुस्तक विक्रेते)">Old book Seller (जुने पुस्तक विक्रेते)</option>
            <option style="font-size: smaller;" value="Super market(सुपर मार्केट)">Super
                market(सुपर मार्केट)</option>
            <option style="font-size: smaller;" value="Brokers/ All Kinds of Brokers (ब्रोकर्स/ सर्व प्रकारचे ब्रोकर्स ( संपत्ती अडत))">Brokers/ All Kinds of Brokers (ब्रोकर्स/ सर्व प्रकारचे ब्रोकर्स ( संपत्ती अडत))
            </option>
            <option style="font-size: smaller;" value="Old automatic vehicles and repair(जुनी स्वयंचलित वाहने व दुरुस्ती)">Old
                automatic vehicles and repair(जुनी स्वयंचलित वाहने व दुरुस्ती)</option>
            <option style="font-size: smaller;" value="Toy sellers (खेळणी विक्रेते)">Toy sellers
                (खेळणी विक्रेते)</option>
            <option style="font-size: smaller;" value="Airline/ Railway Booking, Luxury Buses Booking, Office (विमान वाहतूक/ रेल्वे बुकिंग, लक्झरी बसेसचे बुकिंग, कायार्लय)">Airline/ Railway Booking, Luxury Buses Booking, Office (विमान वाहतूक/ रेल्वे
                बुकिंग, लक्झरी बसेसचे बुकिंग, कायार्लय)</option>
            <option style="font-size: smaller;" value="Seller of shoes (जोडे/ चपलांचे विक्रेते)">Seller of shoes (जोडे/ चपलांचे
                विक्रेते)</option>
            <option style="font-size: smaller;" value="Wholesaler of country liquor(देशी दारूचे ठोक विक्रेते)">Wholesaler of
                country liquor(देशी दारूचे ठोक विक्रेते)</option>
            <option style="font-size: smaller;" value="Wholesaler of foreign liquor (विदेशी दारूचे ठोक विक्रेते)">Wholesaler of
                foreign liquor (विदेशी दारूचे ठोक विक्रेते)</option>
            <option style="font-size: smaller;" value="Retailer of country liquor (देशी दारूचे चिल्लर विक्रेते)">Retailer of
                country liquor (देशी दारूचे चिल्लर विक्रेते)</option>
            <option style="font-size: smaller;" value="Retailer of foreign liquor (विदेशी दारूचे चिल्लर विक्रेते)">Retailer of
                foreign liquor (विदेशी दारूचे चिल्लर विक्रेते)</option>
            <option style="font-size: smaller;" value="Mold Making / Rubber Stamp / Die Making (साचे तयार करणे/ रबर स्टॅम्प/ डाई बनविणे)">Mold Making / Rubber Stamp / Die Making (साचे तयार करणे/ रबर स्टॅम्प/ डाई
                बनविणे)</option>
            <option style="font-size: smaller;" value="To sell cloth or other goods by putting up an exhibition every day (प्रति दिवस प्रदर्शनी लावून कापड किंवा अन्य वस्तू विक्री करणे)">To sell cloth or other goods by putting up an exhibition every day (प्रति दिवस
                प्रदर्शनी लावून कापड किंवा अन्य वस्तू विक्री करणे)</option>
            <option style="font-size: smaller;" value="By Setting up shops (small box shops selling different items) (दुकाने लावून (छोटे खोकी दुकाने वेगवेगळ्या वस्तू विक्री))">By Setting up shops (small box shops selling different items) (दुकाने लावून
                (छोटे खोकी दुकाने वेगवेगळ्या वस्तू विक्री))</option>
            <option style="font-size: smaller;" value="Milk shops and milk products (दुध विक्रीचे दुकान व दुधजन्य पदार्थ)">Milk
                shops and milk products (दुध विक्रीचे दुकान व दुधजन्य पदार्थ)</option>
            <option style="font-size: smaller;" value="Wholesaler of utensil (भांडे विक्रते ठोक व्यवसायीक)">Wholesaler of
                utensil (भांडे विक्रते ठोक व्यवसायीक)</option>
            <option style="font-size: smaller;" value="Retailer of utensil (भांडे विक्रते चिल्लर व्यवसायीक)">Retailer of utensil
                (भांडे विक्रते चिल्लर व्यवसायीक)</option>
            <option style="font-size: smaller;" value="Selling/remolding old tire tubes (जुने टायर टयूब विक्री/ रिमोल्डींग करणे)">Selling/remolding old tire tubes (जुने टायर टयूब विक्री/ रिमोल्डींग करणे)
            </option>
            <option value="Florist (Flower Showroom) (फ्लोरीस्ट (फुलाचे शोरूम))">Florist (Flower
                Showroom)(फ्लोरीस्ट (फुलाचे शोरूम)) </option>
            <option value="Video Pull Parlour (व्हिडीओ पुल  पार्लर )">Video Pull Parlour
                (व्हिडीओ पुल पार्लर )</option>
            <option value="Fish aquariums (फीश एक्वेरियम्स)">Fish aquariums (फीश एक्वेरियम्स)
            </option>
            <option value="Wet Bridge (Dharamkata) (वेट ब्रिज (धर्मकाटा))">Wet Bridge
                (Dharamkata) (वेट ब्रिज (धर्मकाटा)) </option>
            <option value="Big store selling audio/video cassettes (ऑडीओ / व्हिडीओ कॅसेट विक्री मोठे दुकान)">Big store selling audio/video cassettes (ऑडीओ / व्हिडीओ कॅसेट विक्री मोठे दुकान)
            </option>
            <option value="Small shop selling audio/video cassettes (ऑडीओ / व्हिडीओ कॅसेट विक्री छोटे दुकान)">Small shop selling audio/video cassettes (ऑडीओ / व्हिडीओ कॅसेट विक्री छोटे
                दुकान) </option>
            <option value="Selling  of registered imported items  (Customs Goods Sales Centre) (नोंदणीकृत आयात केलेली वस्तू विक्री (कस्टम माल विक्री केन्द्र))">Selling of registered imported items (Customs Goods Sales Centre) (नोंदणीकृत
                आयात केलेली वस्तू विक्री (कस्टम माल विक्री केन्द्र)) </option>
            <option value="Supervisors/Architects (सुपरवायझर्स/आर्किटेक्ट)">Supervisors/Architects (सुपरवायझर्स/आर्किटेक्ट) </option>
            <option value="Share Broker/Stock Exchange/Share Consultancy (शेअर ब्रोकर्स/स्टाप इक्स्चेंज /शेअर कन्सल्टंसी)">Share Broker/Stock Exchange/Share Consultancy (शेअर ब्रोकर्स/स्टाप इक्स्चेंज
                /शेअर कन्सल्टंसी) </option>
            <option value="Supply of building materials (excluding ballast, sand, gravel, mud, bricks, cement and iron) (इमारतीचे लागणारे साहित्य पुरवठा करणे (गिट्टी, रेती, खडी, मुरुम, विटा, सिमेंट व लोहा सोडून))">Supply of building materials (excluding ballast, sand, gravel, mud, bricks,
                cement and iron) (इमारतीचे लागणारे साहित्य पुरवठा करणे (गिट्टी, रेती, खडी,
                मुरुम, विटा, सिमेंट व लोहा सोडून))</option>
            <option value="Dubbing Editing Studio (डबिंग एडिटिंग स्टूडियो)">Dubbing Editing
                Studio (डबिंग एडिटिंग स्टूडियो) </option>
            <option value="Snookers and Billiards Parlour (स्नुकर्स अॅंड बिलीयर्ड्स पार्लर)">Snookers and Billiards Parlour (स्नुकर्स अॅंड बिलीयर्ड्स पार्लर)</option>
            <option value="Band Party (बॅड पार्टी)">Band Party (बॅड पार्टी) </option>
            <option value="Lottery sales (लॉटरी विक्री)">Lottery sales (लॉटरी विक्री) </option>
            <option value="A shop selling of  bags/purses (बॅग/पर्स विक्रीचे दुकान)">A shop
                selling of bags/purses (बॅग/पर्स विक्रीचे दुकान) </option>
            <option value="Internet/Cyber Cafe (इंटरनेट/सायबर कॅफे)">Internet/Cyber Cafe
                (इंटरनेट/सायबर कॅफे) </option>
            <option value="Saw machine (आरा मशीन)">Saw machine (आरा मशीन) </option>
            <option value="Iron wholesale (लोखंड ठोक)">Iron wholesale (लोखंड ठोक) </option>
            <option value="Iron Retail (लोखंड चिल्लर)">Iron Retail (लोखंड चिल्लर) </option>
            <option value="Builders (बिल्डर्स)">Builders (बिल्डर्स) </option>
            <option value="Cloth business wholesalers (कापड व्यवसाय ठोक विक्रेते)">Cloth
                business wholesalers (कापड व्यवसाय ठोक विक्रेते) </option>
            <option value="All types of small scale industries (सर्व प्रकारचे लघु उद्योग)">All
                types of small scale industries (सर्व प्रकारचे लघु उद्योग)</option>
            <option value="Electrical Contractor (इलेक्ट्रीक कॉन्ट्रॅक्टर)">Electrical
                Contractor (इलेक्ट्रीक कॉन्ट्रॅक्टर) </option>
            <option value="LIC Agent Franchise Collection Center (एल.आय.सी. एजंट फ्रेंचाईजी कलेक्शन सेंटर)">LIC Agent Franchise Collection Center (एल.आय.सी. एजंट फ्रेंचाईजी कलेक्शन सेंटर)
            </option>
            <option value="Mobile Fee Franchise Collection Center (इंजिनीयर्स)">Engineers
                (इंजिनीयर्स) </option>
            <option value="Dogs, Animals, Birds, Sale (Pet Shop) (कुत्रे, प्राणी, पक्षी, विक्री (पेट शॉप))">Dogs, Animals, Birds, Sale (Pet Shop) (कुत्रे, प्राणी, पक्षी, विक्री (पेट शॉप))
            </option>
            <option value="Repair of automatic  four wheeler vehicles (चार चाकी स्वयंचलित वाहने दुरुस्ती)">Repair of automatic four wheeler vehicles (चार चाकी स्वयंचलित वाहने दुरुस्ती)
            </option>
            <option value="Selling of  new tires (नविन टायर विक्री)">Selling of new tires (नविन
                टायर विक्री)</option>
            <option value="Cosmetics (Agency) (सोंदर्य प्रसाधने (एजन्सी))">Cosmetics (Agency)
                (सोंदर्य प्रसाधने (एजन्सी)) </option>
            <option value="Cosmetics (Retail) (सोंदर्य प्रसाधने (चिल्लर))">Cosmetics (Retail)
                (सोंदर्य प्रसाधने (चिल्लर)) </option>
            <option value="Electrical Goods  wholesale (इलेक्ट्रीक गुड्स ठोक)">Electrical Goods
                wholesale (इलेक्ट्रीक गुड्स ठोक) </option>
            <option value="Edible Oil Sales (wholesale) (खाद्य तेल विक्री (ठोक))">Edible Oil
                Sales (wholesale) (खाद्य तेल विक्री (ठोक)) </option>
            <option value="Edible Oil Sales(Retail) (खाद्य तेल विक्री (चिल्लर))">Edible Oil
                Sales(Retail) (खाद्य तेल विक्री (चिल्लर)) </option>
            <option value="Water filter and packaged water sellers (वॉटर फिल्टर व पॅकबंद पाणी विक्रेते)">Water filter and packaged water sellers (वॉटर फिल्टर व पॅकबंद पाणी विक्रेते)
            </option>
            <option value="Driving School  (ड्रायव्हिंग शाळा (स्कुल))">Driving School
                (ड्रायव्हिंग शाळा (स्कुल)) </option>
            <option value="Ayurvedic herbs (आयुर्वेदीक जडीबुटी)">Ayurvedic herbs (आयुर्वेदीक
                जडीबुटी) </option>
            <option value="Sale of Gun ammo weapon (बंदूक बारुद शस्त्र विक्री)">Sale of Gun ammo
                weapon (बंदूक बारुद शस्त्र विक्री) </option>
            <option value="Manufacturing and sale of glossine board and steel letters (ग्लोसाईन बोर्ड व स्टील अक्षरे बनविणे व विक्री)">Manufacturing and sale of glossine board and steel letters (ग्लोसाईन बोर्ड व
                स्टील अक्षरे बनविणे व विक्री) </option>
            <option value="Scientific Equipment and Sales (वैज्ञानीक उपकरणे व विक्री)">Scientific Equipment and Sales (वैज्ञानीक उपकरणे व विक्री) </option>
            <option value="Shoes, Sandal  Small Shop (250 Sq.ft.) (जोडे चप्पल लहान दुकान (250 चौ. फुट जागेत))">Shoes, Sandal Small Shop (250 Sq.ft.) (जोडे चप्पल लहान दुकान (250 चौ. फुट
                जागेत))</option>
            <option value="Boring industry (बोरींग उद्योग)">Boring industry (बोरींग उद्योग)
            </option>
            <option value="Grain, stationery and other items to Government and Semi-Government offices through Multi-Purpose Register Institute (बहूउद्देशिय रजिस्टर संस्थाद्वारे शासकीय व निमशासकीय कार्यालयांना धान्य स्टेशनरी व इतर वस्तू)">Grain, stationery and other items to Government and Semi-Government offices
                through Multi-Purpose Register Institute (बहूउद्देशिय रजिस्टर संस्थाद्वारे
                शासकीय व निमशासकीय कार्यालयांना धान्य स्टेशनरी व इतर वस्तू) </option>
            <option value="Wholesale of Foam Coir Sales (Foam Mattress & Related Products Sales) (फोम क्वायर विक्री ठोक (फोम गादी व संबंधित वस्तू विक्री))">Wholesale of Foam Coir Sales (Foam Mattress &Related Products Sales) (फोम
                क्वायर विक्री ठोक (फोम गादी व संबंधित वस्तू विक्री)) </option>
            <option value="Foam Coir Sales and Retail (फोम क्वायर विक्री व चिल्लर)">Foam Coir
                Sales and Retail (फोम क्वायर विक्री व चिल्लर) </option>
            <option value="Wholesale of Old Bardana Sale  (जुना बारदाना विक्री ठोक)">Wholesale
                of Old Bardana Sale (जुना बारदाना विक्री ठोक) </option>
            <option value="Old Bardana Sale and retail (जुना बारदाना विक्री व चिल्लर)">Old
                Bardana Sale and retail (जुना बारदाना विक्री व चिल्लर) </option>
            <option value="Wholesale grain sales (grain) (ठोक अनाज विक्री (धान्य))">Wholesale
                grain sales (grain) (ठोक अनाज विक्री (धान्य)) </option>
            <option value="Computer training class (संगणक प्रशिक्षण वर्ग)">Computer training
                class (संगणक प्रशिक्षण वर्ग) </option>
            <option value="Mobile tower (मोबाईल टॉवर)">Mobile tower (मोबाईल टॉवर) </option>
            <option value="P.U.C. Center (पी.यु.सी. सेंटर)">P.U.C. Center (पी.यु.सी. सेंटर)
            </option>
            <option value="Advertising hoarding agency (जहिराती (अॅडव्हरटायझींग) होडींग एजन्सी)">Advertising hoarding agency (जहिराती (अॅडव्हरटायझींग) होडींग एजन्सी)</option>
            <option value="Flex Printing Shop (फ्लेक्स प्रिंटिग शॉप)">Flex Printing Shop
                (फ्लेक्स प्रिंटिग शॉप) </option>
            <option value="Sale of Mobile Recharge and Vouchers  (मोबाईल रिचार्ज व्हाऊचर्स विक्री)">Sale of Mobile Recharge and Vouchers (मोबाईल रिचार्ज व्हाऊचर्स विक्री) </option>
            <option value="Computer Graphics (कॉम्प्युटर ग्राफिक्स)">Computer Graphics
                (कॉम्प्युटर ग्राफिक्स)</option>
            <option value="Beer shop (बियर शॉपी)">Beer shop (बियर शॉपी) </option>
            <option value="Beer Bar and Restaurant (बियर बार अॅंड रेस्टॉरेंट)">Beer Bar and
                Restaurant (बियर बार अॅंड रेस्टॉरेंट) </option>
            <option value="Four Wheeler Showroom (फोर व्हिलर शोरुम)">Four Wheeler Showroom (फोर
                व्हिलर शोरुम) </option>
            <option value="Two Wheeler Showroom (टु व्हिलर शोरुम)">Two Wheeler Showroom (टु
                व्हिलर शोरुम) </option>
            <option value="cotton pinjai reche (कापूस पिंजाई रेचे)">cotton pinjai reche (कापूस
                पिंजाई रेचे) </option>
            <option value="Tarpaulin sales (ताडपत्री विक्री)">Tarpaulin sales (ताडपत्री विक्री)
            </option>
            <option value="Sale of Super market wholesale (सुपर मार्केट होलसेल विक्री)">Sale of
                Super market wholesale (सुपर मार्केट होलसेल विक्री)</option>
            <option value="Tea, coffee, milk, hotel (चहा, कॉफी, दुध, हॉटेल)">Tea, coffee, milk,
                hotel (चहा, कॉफी, दुध, हॉटेल) </option>
            <option value="Gym (Spa) (व्यायाम शाळा (जिम) (स्पा))">Gym (Spa) (व्यायाम शाळा (जिम)
                (स्पा)) </option>
            <option value="Sale of Puffed Rice/ Futane  (मुरमुरे /फुटाणे विक्री)">Sale of Puffed
                Rice/ Futane (मुरमुरे /फुटाणे विक्री) </option>
            <option value="Puffed Rice  /Pohe factories (मुरमुरे /पोहे कारखाने)">Puffed Rice
                /Pohe factories (मुरमुरे /पोहे कारखाने) </option>
            <option value="Birthday Hall (बर्थ डे हॉल)">Birthday Hall (बर्थ डे हॉल) </option>
            <option value="Star Hotel (स्टार हॉटेल)">Star Hotel (स्टार हॉटेल) </option>
            <option value="Star Hotel (स्टार हॉटेल)">Star Hotel (स्टार हॉटेल) </option>
            <option value="Star Hotel (स्टार हॉटेल)">Star Hotel (स्टार हॉटेल) </option>
            <option value="Star Hotel (स्टार हॉटेल)">Star Hotel (स्टार हॉटेल) </option>
            <option value="Star Hotel (स्टार हॉटेल)">Star Hotel (स्टार हॉटेल) </option>
            <option value="Hotel with Lodging / Boarding (हॉटेल विथ लॉजिंग / बोर्डिग)">Hotel
                with Lodging / Boarding (हॉटेल विथ लॉजिंग / बोर्डिग) </option>
            <option value="Hospital (दवाखाना (हॉस्पीटल))">Hospital (दवाखाना (हॉस्पीटल))
            </option>
            <option value="Sutikagriha (Maternity Home) (सुतिकागृह (मॅटर्निटी होम))">Sutikagriha
                (Maternity Home) (सुतिकागृह (मॅटर्निटी होम)) </option>
        </select>    
         <div class="invalid-feedback">Please Enter Valid Updated Trade Type.
        </div>
    </div>
</div>

                        <div class="col-md-3">
                            <div class="mb-3 mt-3">
                                <label for="" class="form-label lbleng">Updated Owner/Partner Name (सुधारित केलेले मालक/भागीदार संख्या)<span class="text-danger"
                                        style="color: red;">*</span></label>
            
                                <input type="text" class="form-control"  style="background-image: none;"id="" placeholder="" name="updatedOwnerName" value=""pattern="^\s*\S.*$"  pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" required>
                              <div class="invalid-feedback">
        Please Enter Valid Updated Owner/Partner Name.
    </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                         <div class="mb-3 mt-3">
                             <label for="" class="form-label lbleng">Updated Partner Count (अद्यतनित भागीदार संख्या)<span class="text-danger" style="color: red;">*</span></label>
    <input type="number" class="form-control" maxlength="3" style="background-image: none;" id="" pattern="^\s*\S.*$" placeholder="" name="updatedPartnerCount" value="" required oninput="validateInputLength(this)">
    <div class="invalid-feedback">
        Please Enter Valid Updated Partner Count.
    </div>
</div>

<script>
    function validateInputLength(input) {
        if (input.value.length > parseInt(input.getAttribute('maxlength'))) {
            input.value = input.value.slice(0, parseInt(input.getAttribute('maxlength')));
        }
    }
</script>








                        </div>
                      
                         <div class="col-md-3">
                            <div class="mb-3 mt-3">
                                <label for="" class="form-label lbleng">Fees Applicable (शुल्क लागू) </label>
            
                                <input type="text" value ="100" class="form-control" style="background-image: none;" id="" placeholder="" name="feesApplicable" readonly>
                            </div>
                        </div>
            
            <div class="row">
			
               <h6 style="background-color:white; padding:10px;" class="mt-3 rounded-2">	<strong> List of Documents (with attachment)(कागदपत्रांची यादी (संलग्नकांसह))</strong>
			</h6>
			<div class="alert alert-info mb-2 p-2 mb-4 ms-2">
                <small class="form-label "><strong class="form-label ">Note(नोंद): </strong> Upload below files in .pdf(Max upto 2 MB)(खालील फाइल .pdf मध्ये अपलोड करा (कमाल 2 MB पर्यंत))</small>
			</div>
			            <input type="hidden" name="filesPath" id="filesPath" />
			
			<div class="col-md-3">
                <div class="mb-3 mt-0">
								<label for="" class="form-label">NOC for the related department issued from the NMC/Department Officer/Govt/Semi Govt. Officer (NMC/ विभाग अधिकारी/शासकीय/निमशासकीय अधिकारी कडून जारी केलेल्या संबंधित विभागासाठी NOC)<span class="mand_error" style="color: red;">*</span>
</label>
                    <input type="file" class="form-control"  style="background-image: none;" id="doc1" placeholder=""
                         name="nocForRelatedDepartment" required>
                         <div class="invalid-feedback">
                            File selected is either greater than 2Mb or not of type .pdf.
                        </div>
                        
                        
                </div>
            </div>
            <div class="col-md-3">
                <div class="mb-3 " style="margin-top: 71px;">
<label for="" class="form-label lbleng">Copy of the
									Former Licence (In case of Renewal the Licence)(पूर्वीच्या परवान्याची प्रत (परवाना नूतनीकरणाच्या बाबतीत))<span                            class="mand_error" style="color: red;"  >*</span></label>

                    <input type="file" class="form-control"  style="background-image: none;" id="doc2" placeholder="" name="copyOfFormerLicence" required>
                    <div class="invalid-feedback">
                        File selected is either greater than 2Mb or not of type .pdf.
                    </div>
                    
                </div>
            </div>

            <div class="col-md-3">
                <div class="mb-3 "style="margin-top: 71px;">
                    <label for="" class="form-label lbleng">No Dues
									Certificate for Property Tax(मालमत्ता करासाठी ना हरकत प्रमाणपत्र)</label>

                    <input type="file" class="form-control"  style="background-image: none;" id="doc3" placeholder="" name="propertyTaxNoDue" >
                </div>
            </div>
			<div class="col-md-3">
                <div class="mb-3"style="margin-top: 94px">
                    <label for="" class="form-label lbleng"> Building Authorization Document (इमारत अधिकृतता दस्तऐवज)<span
                            class="mand_error" style="color: red;"  >*</span></label>


                    <input type="file" class="form-control"  style="background-image: none;" id="doc4" placeholder="" name="buildingAuthorizationDocument" required >
                    <div class="invalid-feedback">
                        File selected is either greater than 2Mb or not of type .pdf.
                    </div>
                    
                </div>

            </div>
			</div>
			


            <div class="col-md-12">
                <div class="mb-5 mt-4 ">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="check11" name="declaration"
                            value="something" required>

                        <label class="form-check-label ms-3 lbleng" style="margin-top: -1px;">
                            <strong>Declaration (घोषणा)<span class="text-danger" style="color: red;">*</span>:- </strong>The
                            above mentioned information is true to the best of my knowledge and belief.
                             (वर नमूद केलेली माहिती माझ्या माहितीनुसार आणि विश्वासानुसार खरी आहे.)
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
					   <button class="btn btn-success btn_sm" type="submit" id="submit" onclick="javascript:upload();">
                         Submit
                    </button>
				</div>
			</div>
        </div>
</form>
	</body>
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




                            <li>1.NOC for the related department issued from the NMC/Department Officer/Govt/Semi Govt. Officer (NMC/ विभाग अधिकारी/शासकीय/निमशासकीय अधिकारी कडून जारी केलेल्या संबंधित विभागासाठी NOC)<span class="text-danger"  style="color: red;">*</span> </li>
                            <li>2.No Dues Certificate for Property Tax (मालमत्ता करासाठी ना हरकत प्रमाणपत्र)</li>
                            <li>3.Building Authorization Document (इमारत अधिकृतता दस्तऐवज)<span class="text-danger"  style="color: red;">*</span></li> 
<li>4.Copy of the Former Licence (In case of Renewal the Licence)(पूर्वीच्या परवान्याची प्रत (परवाना नूतनीकरणाच्या बाबतीत))<span
                            class="mand_error" style="color: red;"  >*</span></li>
                        </ul>

                    </div>

                    <!-- dialog buttons -->

                    <div class="modal-footer"><button type="button" class="btn btn-primary">OK</button></div>

                </div>

            </div>

        </div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>

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
    

function upload() {
    console.log("@@upoading@@");
    var url = window.location.href;// The window.location.href property in JavaScript returns the URL of the currently open web page. This property can even be used to update the URL of a web page.
    var basePath = '${pageContext.getAttribute("UPLOAD_PATH")}';
    var filesPath = "";
    var data = new FormData();

    data.append('idProof1', $("#doc1").get(0).files[0]);
    data.append('idProof2', $("#doc2").get(0).files[0]);
    data.append('idProof3', $("#doc3").get(0).files[0]);
    data.append('idProof4', $("#doc4").get(0).files[0]);
   
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
            filesPath = filesPath + basePath + "tradeLicenseDuplicateCopy/" + i + value + ","
            isFileSelected = true;
        }
    }
    $.ajax({
        url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadDocumentTradeLicenseDuplicateCopy.do",
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
       </html>

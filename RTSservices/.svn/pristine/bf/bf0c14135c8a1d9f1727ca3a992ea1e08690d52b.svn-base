<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.include file="/pages/core-pages/nmc_user/dashboard/header.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants" />
<jsp:directive.page import="com.mars.common.utils.CommonUtils" />



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

<script type="text/javascript">
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
  if((this.files[0].size <2000000) && (name.endsWith('.pdf'))){  isFileAllowed = true;
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
function Display(id) {
            $('#full_name').val($('#first_name').val() + " " + $('#middle_name').val() + " " + $('#last_name').val())
        }

     
</script>

</head>
<body>

    <form class="needs-validation" novalidate>
      <div class="container mt-3">
           <div class="printable">
               <h3 class="text-center"><strong></strong><strong>Application Form For the Tax Exemption For Non-Residential Property(
अनिवासी मालमत्तेसाठी कर सवलतीसाठी अर्जाचा नमुना)	
            </strong>	</h3>
           </div>

        <h6 style="background-color:#dce2e8; padding:10px;" class="  rounded-2"><strong> Applicant Details </strong>
        </h6>
        <div class="row">
            <input type="hidden" name="_token" value="xyz">
            <div class="col-md-3">
                 <div class="mb-3 mt-3">
                     <label for="" class="form-label"> UPIN No(UPIN क्र).<span class="text-danger"
                             style="color: red;">*</span></label>
                     <input type="text" class="form-control "   pattern="^\s*\S.*$" maxlength="80"  style="background-image: none;" id="" placeholder="" name="upinNum" value="" required>
                     <div class="invalid-feedback">
                         Please Enter Valid UPIN No.
                     </div>   
                 </div>
             </div>
                       <div class="col-md-3">
                           <div class="mb-3 mt-3">
                               <label for="" class="form-label lbleng">Title <span class="text-danger" >*</span>
                               </label>
                               
                               <select class="form-select" style="background-image: none;" name="appTitle" required>
                                   <option value="">-Select-</option>
                                  
							<option value="1">Mr (श्री)</option>
							<option value="2">Mrs (सौ)</option>
							<option value="3">Ms (कु)</option>
                                                       </select>
                                                       <div class="invalid-feedback">
                                   Please Select Title.
                               </div>
                           </div>
                       </div>
           
                       <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label lbleng">First Name(पहिले नाव<span class="text-danger" >*</span></label>
            
                            <input type="text" class="form-control" style="background-image: none;" id="first_name" placeholder="" name="firstName" value=""
                            pattern="[A-Za-z]+" onchange="Display(this.id)" required>
                            <div class="invalid-feedback">
                                Please Enter Valid First Name.
                            </div>
                        </div>
                    </div>
            
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label lbleng">Middle Name(मधले नाव</label>
            
                            <input type="text" class="form-control" style="background-image: none;" id="middle_name" placeholder="" name="middleName" value=""
                            pattern="[A-Za-z]+" onchange="Display(this.id)">
                           
                                
                        </div>
                    </div>
            
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label lbleng">Last Name(आडनाव<span class="text-danger" style="color: red;">*</span></label>
                            <input type="text" class="form-control" style="background-image: none;" name="lastname" id="last_name" value=""  pattern="[A-Za-z]+" onchange="Display(this.id)" required>
                            <div class="invalid-feedback">
                                Please Enter Valid Last Name.
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label">Full Name (
पूर्ण नाव)</label>
                
                            <input type="text" class="form-control" style="background-image: none;" id="full_name" placeholder="" name="fullName" value="" readonly>
                        </div>
                    </div>
            
            
                             
        

                
				<div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Plot/ Flat No(प्लॉट/फ्लॅट क्र) <span class="text-danger" style="color: red;"">*</span></label>
                    <input type=" text "pattern="^\s*\S.*$" maxlength="80" class="form-control" style="background-image: none;" id="plot_no" placeholder="" name="plotNo" value=""
                                    required>
                                    <div class="invalid-feedback">
                                        Please Enter Valid Plot/Flat No
                                    </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Name of the Building </label>
                            <input type=" text" class="form-control"  maxlength ="80"style="background-image: none;" id="buildingName" placeholder=""
                                name="building_name" value="">
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Name of the Street</label>
                    <input type=" text" class="form-control" style="background-image: none;" id="street_name" placeholder="" name="streetName"
                    "pattern="^\s*\S.*$" maxlength="80"        value="">
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Name of the Area <span class="text-danger"
                                    style="color: red;"">*</span></label>
                    <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="areaName" value=""
                    "pattern="^\s*\S.*$" maxlength="80"         required>
                                   <div class="invalid-feedback">
                                    Please Enter Valid Name of the Area.
                                </div>
                        </div>
                    </div>

                   

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Near by Landmark</label>
                            <input type=" text" class="form-control" style="background-image: none;" id="landmark" placeholder="" name="landMark"
                                value="">
                        </div>
                    </div>
                    
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label lbleng">Pin Code <span class="text-danger" >*</span></label>
                            
                            <input type="text" class="form-control" style="background-image: none;" pattern="^(?!0{6}$)\d{6}$" name="pinCode" value=""
                                        maxlength="6" required>
                                        <div class="invalid-feedback">
                                Please Enter Valid Pin Code.
                            </div>
                                
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label"> Aadhaar No.
                            </label>
                            <input type="text" class="form-control " style="background-image: none;" id="aadhaarNumber1" placeholder="" name="AadhaarNo" value=""
                               pattern="(?!0{12}$)[0-9]{12}"
                                maxlength="12">
                                <div class="invalid-feedback">
                                Please Enter Aadhaar No.
                            </div>
                        </div>
                    </div>
                     <div class="col-md-3">
                            <div class="mb-3 mt-3">
                                
                            <label for="email"  class="form-label lbleng"> Email Id <span class="text-danger" >*</span> </label>
                            <input type="email" class="form-control " style="background-image: none;" name="email"pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}" value="" required>
                            <div class="invalid-feedback">
                                Please Enter Valid Email Id.
                            </div>
                        </div>
                    </div>
                    
                                    
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label"> Mobile No.<span class="text-danger"
                                    style="color: red;">*</span>
                            </label>
                            <input type="text" class="form-control " style="background-image: none;" id="txtMobileNumber" placeholder="" name="TxtMobileNumber" value=""
                            pattern="[6-9]{1}[0-9]{9}"
                                maxlength="10" required>
                             <div class="invalid-feedback">
                                Please Enter Valid Mobile No.
                            </div>
                        </div>
                    </div>  
                    
        
                </div>
                <div class="col-md-12">
                            <div class="mb-3 mt-3">
                                <label for="" class="form-label ">Address For Correspondence (पत्रव्यवहारासाठी पत्ता)<span class="mand_error" style="color: red;"">*</span></label>
                                <textarea oninput="validateTextarea()" type=" text" maxlength="255" class="form-control"  style="background-image: none;" id="myTextarea" placeholder="" name="correspondenceAddress" value="" rows="2" required></textarea>                           
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
         <h6 style="background-color:#dce2e8; padding:10px;" class="  rounded-2"><strong> Applicantion Form  Details </strong>
         </h6>
         <div class="row ">
         <div class="col-md-3">
             <div class="mb-3 mt-3">
                 <label for="" class="form-label"> Name of Property Holders/Occupants(मालमत्ताधारक/ भोगवटादारांचे नाव<span class="text-danger"
                             style="color: red;">*</span> </label>
                  <input type="text" class="form-control" style="background-image: none;" maxlength="255" pattern="^\s*\S.*$" id=""  name="holdersName" class="alphabet"  pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$"  required>
                  <div class="invalid-feedback">
                     Please Enter Valid Name of Property Holders/Occupants.
                 </div>
             </div>
         </div>
 
 
            
             <div class="col-md-3">
                 <div class="mb-3 mt-3">
                     <label for="" class="form-label lbleng">Zone No.(
झोन क्र.<span class="text-danger"
                             style="color: red;">*</span> </label>
     
                     <select class="form-select" style="background-image: none;" id="iFunction" name="zoneNo" onchange="changeddl(this)" required>
                         <option value="" selected="">-Select Zone-</option>
                         <option value="1">Zone No.1 - Laxmi Nagar</option>
                         <option value="2">Zone No.2 - Dharmpeth</option>
                         <option value="3">Zone No.3 - Hanuman Nagar</option>
                         <option value="4">Zone No.4 - Dhantoli</option>
                         <option value="5">Zone No.5 - Nehru Nagar</option>
                         <option value="6">Zone No.6 - Gandhibag</option>
                         <option value="7">Zone No.7 - Satranjipura</option>
                         <option value="8">Zone No.8 - Lakadganj</option>
                         <option value="9">Zone No.9 - Aashi Nagar</option>
                         <option value="10">Zone No.10 - Mangalwari</option>
     
                     </select>
                     <div class="invalid-feedback">
                     Please Enter Valid Zone No.
                 </div>
                 </div>
             </div>
     
                  
                 <div class="col-md-3 hospital_row" id="hos">
                         <div class="mb-3 mt-3">
                             <label for="" class="form-label"> Ward No.(
प्रभाग क्र.)
                                  <span class="text-danger" style="color: red;">*</span></label>
                             <select class="form-select" style="background-image: none;" id="iOperation" name="wardNo" disabled required>
                                 <option value="-1" selected="">-Select Ward-</option>
                                 <option value="1_21">Ward No. 16</option>
                                 <option value="1_22">Ward No. 36</option>
                                 <option value="1_22">Ward No. 37</option>
                                 <option value="1_22">Ward No. 38</option>
     
     
                                 <option value="2_21">Ward No. 12</option>
                                 <option value="2_21">Ward No. 13</option>
                                 <option value="2_21">Ward No. 14</option>
                                 <option value="2_21">Ward No. 15</option>
     
     
                                 <option value="3_21">Ward No. 29</option>
                                 <option value="3_21">Ward No. 31</option>
                                 <option value="3_21">Ward No. 32</option>
                                 <option value="3_21">Ward No. 34</option>
     
     
                                 <option value="4_21">Ward No. 17</option>
                                 <option value="4_21">Ward No. 33</option>
                                 <option value="4_21">Ward No. 35</option>
     
                                 <option value="5_21">Ward No. 26</option>
                                 <option value="5_21">Ward No. 27</option>
                                 <option value="5_21">Ward No. 28</option>
                                 <option value="5_21">Ward No. 30</option>
     
     
                                 <option value="6_21">Ward No. 8</option>
                                 <option value="6_21">Ward No. 18</option>
                                 <option value="6_21">Ward No. 19</option>
                                 <option value="6_21">Ward No. 22</option>
     
     
                                 <option value="7_21">Ward No. 5</option>
                                 <option value="7_21">Ward No. 20</option>
                                 <option value="7_21">Ward No. 21</option>
     
                                 <option value="8_21">Ward No. 4</option>
                                 <option value="8_21">Ward No. 23</option>
                                 <option value="8_21">Ward No. 24</option>
                                 <option value="8_21">Ward No. 25</option>
     
     
                                 <option value="9_21">Ward No. 2</option>
                                 <option value="9_21">Ward No. 3</option>
                                 <option value="9_21">Ward No. 6</option>
                                 <option value="9_21">Ward No. 7</option>
     
     
                                 <option value="10_21">Ward No. 1</option>
                                 <option value="10_21">Ward No. 9</option>
                                 <option value="10_21">Ward No. 10</option>
                                 <option value="10_21">Ward No. 11</option>
     
     
                             </select>
                             <div class="invalid-feedback">
                                 Please Enter Valid Ward No.
                             </div>
                         </div>
                         
                 </div>    
               
                <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label"> House No.(घर क्र.)<span class="text-danger"
                              style="color: red;">*</span> </label>
    
                        <input type="text" class="form-control" style="background-image: none;" id="" placeholder="" name="houseNumber" value=""
                        pattern="^\s*\S.*$" maxlength="80"       required>
                            <div class="invalid-feedback">
                                Please Enter Valid House No.
                            </div>
                    </div>
                </div>
             <div class="col-md-3">
                 <div class="mb-3 mt-3">
                     <label for="" class="form-label"> Index No.(निर्देशांक क्र.)
                     </label>
                     <input type="text" class="form-control " style="background-image: none;" id="" placeholder=""  maxlength="80"   name="indexNum" value="">
                         
                 </div>
             </div>
             

    
            

        
            <div class="row">
			
                <h6 style="background-color:white; padding:10px;" class="mt-3 rounded-2"><strong> List of Documents (with attachment) </strong></h6>
                
                <div class="alert alert-info mb-0 p-2 mb-4">
                <small><strong>Note: </strong> Upload Below Files only .pdf(Max upto 2MB) </small>
                </div>
			<div class="col-md-3">
                <div class="mb-3 mt-3">
                    <label for="" class="form-label">APplicant Id Proof---Self Attested Applicant's Id Proof (स्वत: प्रमाणित अर्जदाराचा आयडी पुरावा) <span class="text-danger"
                            style="color: red;">*</span> 
</label>
                    <input type="file" class="form-control" style="background-image: none;" id="" placeholder=""
                         name="applicantsIdProof" required>
                         <div class="invalid-feedback">
                            File selected is either greater than 2Mb or not of type .pdf.
                        </div> 
                </div>
            </div>
            <div class="col-md-3">
                <div class="mb-3 mt-3">
                    <label for="" class="form-label lbleng">Property Tax Payment Receipt(मालमत्ता कर भरणा पावती)</label>

                    <input type="file" class="form-control" style="background-image: none;" id="" placeholder="" name="propertytaxReceipt" >
                    <div class="invalid-feedback">
                        File selected is either greater than 2Mb or not of type .pdf.
                    </div>
                </div>
            </div>

            
			<div class="col-md-3">
                <div class="mb-3 mt-3">
                    <label for="" class="form-label lbleng"> Copy of Electric Bill(इलेक्ट्रिक बिलाची प्रत<span
                            class="text-danger" style="color: red;"  >*</span></label>


                    <input type="file" class="form-control" style="background-image: none;" id="" placeholder="" name="electricBill" required >
                    <div class="invalid-feedback">
                        File selected is either greater than 2Mb or not of type .pdf.
                    </div>
            </div>

            </div>
			</div>
			<div class="col-md-12">
                <div class="mb-5 mt-4 ">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="check11" name="Declaration"
                            value="something" required>

                        <label class="form-check-label ms-3 lbleng" style="margin-top: 0px;">
                            <strong>Declaration <span class="text-danger" style="color: red;">*</span>:- </strong>The
                            above mentioned information is true to the best of my knowledge and belief.
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
						<i class="fa-solid fa-print"></i> View and Print
					</button>
					<button class="btn btn-success btn_sm" type="submit" id="submit">
						<i class="fa-solid fa-check"></i> Submit
					</button>
				</div>
			</div>
            

         </div>
        </div>
</form>
</body>
	
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
        function changeddl(obj) {
            if (document.getElementById("iFunction").value > 0) {

                document.getElementById("iOperation").removeAttribute('disabled');
                var text = obj.options[obj.selectedIndex].text;
                var ddl2 = document.querySelectorAll('#iOperation option');
                for (var i = 1; i < ddl2.length; i++) {
                    var option = ddl2[i];
                    option.style.display = 'none';
                    if (text == 'Zone No.1 - Laxmi Nagar') {
                        if (['Ward No. 36', 'Ward No. 37', 'Ward No. 38'].indexOf(option.text) > -1)
                            option.style.display = 'block'

                    }
                    if (text == 'Zone No.2 - Dharmpeth') {
                        if (['Ward No. 12', 'Ward No. 13', 'Ward No. 14', 'Ward No. 15'].indexOf(option.text) > -1)
                            option.style.display = 'block'
                    }
                    if (text == 'Zone No.3 - Hanuman Nagar') {
                        if (['Ward No. 29', 'Ward No. 31', 'Ward No. 32', 'Ward No. 34'].indexOf(option.text) > -1)
                            option.style.display = 'block'
                    }
                    if (text == 'Zone No.4 - Dhantoli') {
                        if (['Ward No. 17', 'Ward No. 33', 'Ward No. 35'].indexOf(option.text) > -1)
                            option.style.display = 'block'
                    }
                    if (text == 'Zone No.5 - Nehru Nagar') {
                        if (['Ward No. 26', 'Ward No. 27', 'Ward No.28', 'Ward No. 30'].indexOf(option.text) > -1)
                            option.style.display = 'block'
                    }
                    if (text == 'Zone No.6 - Gandhibag') {
                        if (['Ward No. 8', 'Ward No. 18', 'Ward No. 19', 'Ward No. 22'].indexOf(option.text) > -1)
                            option.style.display = 'block'
                    }
                    if (text == 'Zone No.7 - Satranjipura') {
                        if (['Ward No. 5', 'Ward No. 20', 'Ward No. 21'].indexOf(option.text) > -1)
                            option.style.display = 'block'
                    }
                    if (text == 'Zone No.8 - Lakadganj') {
                        if (['Ward No. 4', 'Ward No. 23', 'Ward No. 24', 'Ward No. 25'].indexOf(option.text) > -1)
                            option.style.display = 'block'
                    }
                    if (text == 'Zone No.9 - Aashi Nagar') {
                        if (['Ward No. 2', 'Ward No. 3', 'Ward No. 6', 'Ward No. 7'].indexOf(option.text) > -1)
                            option.style.display = 'block'
                    }
                    if (text == 'Zone No.10 - Mangalwari') {
                        if (['Ward No. 1', 'Ward No. 9', 'Ward No. 10', 'Ward No. 11'].indexOf(option.text) > -1)
                            option.style.display = 'block'
                    }
                }
            }

        }
        
        

  </script>
  

	
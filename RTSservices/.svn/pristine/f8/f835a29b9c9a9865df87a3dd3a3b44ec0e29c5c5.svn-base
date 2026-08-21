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

<script src="https://code.jquery.com/jquery-3.6.3.min.js"
	integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
	crossorigin="anonymous"></script>

</head>

<body>
	<form>
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




                            <li>1.NOC From Police Department (पोलिस विभागाकडून एनओसी)<span class="text-danger"  style="color: red;">*</span></li>
                            <li>2.NOC From Traffic Department (वाहतूक विभागाकडून एनओसी)<span class="text-danger"  style="color: red;">*</span> </li>
                            <li>3.NOC From Fire Department (अग्निशमन विभागाकडून एनओसी)<span class="text-danger"  style="color: red;">*</span></li>

                        </ul>

                    </div>

                    <!-- dialog buttons -->

                    <div class="modal-footer"><button type="button" class="btn btn-primary">OK</button></div>

                </div>

            </div>

        </div>
		<div class="container-fluid mt-2" style="width: 180vh">

			<div class="printable">
				<h3 class="text-center">Application Form For Mandap Permission
					(मंडप परवानगीसाठी अर्ज)</h3>
			</div>
			<h6 style="background-color: #dce2e8; padding: 10px;"
				class="rounded-2">
				<strong> Applicant Details (अर्जदाराचे तपशील) </strong>
			</h6>
			<div class="row">
				<input type="hidden" name="_token" value="xyz">
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label" style="background-image:none;" >Title
							(शीर्षक)<span class="text-danger">*</span>
						</label> <select class="form-select" name="title"
							style="background-image: none;" required>
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
						<label for="" class="form-label lbleng">Name (नाव)<span class="text-danger">*</span>
						</label> <input type="text" class="form-control" id="first_name"
							style="background-image: none;" placeholder="" name="firstName"
							value="" pattern="[A-Za-z]+" onchange="Display(this.id)" maxlength="40" required>
						<div class="invalid-feedback">Please Enter Valid First Name.
						</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Father's Name (वडिलांचे नाव)</label> <input type="text" class="form-control" id="middle_name"
							style="background-image: none;" placeholder="" name="middleName"
							value="" pattern="[A-Za-z]+" onchange="Display(this.id)">


					</div>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Surname (आडनाव)<span
							class="text-danger" style="color: red;">*</span></label> <input
							type="text" class="form-control" style="background-image: none;"
							name="lastName" id="last_name" value="" maxlength="80" pattern="[A-Za-z]+"
							onchange="Display(this.id)" required>
						<div class="invalid-feedback">Please Enter Valid Last Name.
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Full Name (पूर्ण नाव)</label> <input
							type="text" class="form-control" id="full_name"
							style="background-image: none;" placeholder="" name="fullName"
							value="" readonly>
					</div>
				</div>

				<script>
                    function Display(id) {
                        $('#full_name').val($('#first_name').val() + " " + $('#middle_name').val() + " " + $('#last_name').val())
                    }
                </script>


				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label lbleng">Pin Code (पिन कोड)<span
							class="text-danger">*</span></label> <input type="text"
							class="form-control" pattern="[0-9]{6}"
							style="background-image: none;" name="pinCode" value=""
							maxlength="6" required>
						<div class="invalid-feedback">Please Enter Valid Pin Code.</div>

					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label"> Aadhaar No.(आधार क्र.) </label>
						<input type="text" class="form-control " id="aadhaarNumber1"
							style="background-image: none;" placeholder="" name="aadharNo"
							value="" pattern="[0-9]{12}" maxlength="12">

					</div>
				</div>
				<div class="col-md-3">
					<div class="mb-3 mt-3">

						<label for="email" class="form-label lbleng"> Email Id
							(ईमेल आयडी ) <span class="text-danger">*</span>
						</label> <input type="email" class="form-control "
							style="background-image: none;" name="email" value="" required>
						<div class="invalid-feedback">Please Enter Valid Email Id.</div>
					</div>
				</div>


				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label"> Mobile No.(मोबाईल क्र.)<span
							class="text-danger" style="color: red;">*</span>
						</label> <input type="text" class="form-control " id="txtMobileNumber"
							style="background-image: none;" placeholder="" name="mobileNo"
							value="" pattern="[6-9]{1}[0-9]{9}" maxlength="10" required>
						<div class="invalid-feedback">Please Enter Valid Mobile No.
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="mb-3 mt-3 ">
						<label for="primary_full_address" class="form-label lbleng">Address
							For Correspondence (पत्रव्यवहारासाठी पत्ता)<span
							class="text-danger">*</span>
						</label>

						<textarea class="form-control " rows="2" id="Address"
							style="background-image: none;" name="address" oninput="validateTextarea()" maxlength="80" required></textarea>
						<div class="invalid-feedback" id="errorFeedback">Please Enter Valid Address.</div>

					</div>
				</div>
				      <script>
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

			</div>
			<br>











			<h6 style="background-color: #dce2e8; padding: 10px;"
				class="rounded-2">
				<strong>Pavilion/Event Details (मंडप/कार्यक्रमाचे तपशील)</strong>
			</h6>
			<div class="row">

				<div class="col-md-3">
					<div class="mb-3" style="margin-top: 25px;">
						<label for="" class="form-label lbleng">Zone No. (झोन
							क्र.)<span class="text-danger" style="color: red;">*</span>
						</label> <select class="form-select " style="background-image: none;"
							id="main-dropdown" name="zoneNo" required>
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
					<div class="mb-3" style="margin-top: 25px;">
						<label for="" class="form-label"> Ward No. (प्रभाग क्र.) <span
							class="text-danger" style="color: red;">*</span></label> <select
							class="form-select" style="background-image: none;"
							id="dependent-dropdown" name="wardNo" disabled required>

							<option value="" selected="">-Select Ward-</option>
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
<a class="fa fa-download" onClick="downloadFile()" style="color: blue; font-size: medium;">&nbsp;&nbsp;Click here to know your ward.</a>
				</div>

				<div class="col-md-3">
					<div class="mb-3 mt-4">
						<label for="" class="form-label lbleng purposes">Purpose
							(उद्देश)<span class="text-danger" style="color: red;">*</span>
						</label> <select class="form-select" style="background-image: none;"
							id="iFunctio" onchange="exh(this.id)" name="purpose" required>
							<option value="" selected="">-Select-</option>
							<option value="Weddings and Receptions (विवाहसोहळा आणि रिसेप्शन)">Weddings
								and Receptions (विवाहसोहळा आणि रिसेप्शन)</option>
							<option value="Exhibitions (प्रदर्शने)">Exhibitions
								(प्रदर्शने)</option>
							<option
								value="Circus,Experimental performances & Other purposes (सर्कस, प्रायोगिक कामगिरी आणि इतर हेतू)">Circus,Experimental
								performances & Other purposes (सर्कस, प्रायोगिक कामगिरी आणि इतर
								हेतू)</option>
							<option
								value="Religious & Cultural events (धार्मिक आणि सांस्कृतिक कार्यक्रम)">Religious
								& Cultural events (धार्मिक आणि सांस्कृतिक कार्यक्रम)</option>
						</select>
						<div class="invalid-feedback">Please Select Purpose.</div>
					</div>
				</div>

				<script>
                    var WeddingsReceptions=0;
                    $(document).ready(function () {
                        
                    $("#exhibitions").hide();
                    });
                function exh()
                    {
                        var getvalue = $("#iFunctio").val();                      
                        if(getvalue=="Exhibitions (प्रदर्शने)")
                            $("#exhibitions").show();
                        else
                            $("#exhibitions").hide();

                        if(getvalue=="Weddings and Receptions (विवाहसोहळा आणि रिसेप्शन)"){
                            WeddingsReceptions=720;
                           
        
                        var length1=$("#length").val()
                        var breadth1=$("#breadth").val()
                        totalsize= length1 * breadth1;                              
                        $("#TotalSize").val(totalsize);
                        
                        

                        // let decimal = Math.trunc( number );
                        Total=totalsize/100;   //2 
                        if(!(0==(totalsize%100))){
                            decimal = Math.trunc( Total );
                            if(decimal==0)
                                decimal=1;
                            else
                                decimal=decimal+1;
                        }
                        else
                        {
                            decimal=Total;
                        }
                        totalfee=WeddingsReceptions*decimal;
                        $("#Fees").val(totalfee); 
                        
                        }
                            
                        else if(getvalue=="Circus,Experimental performances & Other purposes (सर्कस, प्रायोगिक कामगिरी आणि इतर हेतू)")
                        {
                            WeddingsReceptions=40;


                        var length1=$("#length").val()
                        var breadth1=$("#breadth").val()
                        totalsize= length1 * breadth1;                              
                        $("#TotalSize").val(totalsize);
                        
                        

                        // let decimal = Math.trunc( number );
                        Total=totalsize/100;   //2 
                        if(!(0==(totalsize%100))){
                            decimal = Math.trunc( Total );
                            if(decimal==0)
                                decimal=1;
                            else
                                decimal=decimal+1;
                        }
                        else
                        {
                            decimal=Total;
                        }
                        totalfee=WeddingsReceptions*decimal;
                        $("#Fees").val(totalfee); 
                        
                            
                        }
                           
                        else if(getvalue=="Religious & Cultural events (धार्मिक आणि सांस्कृतिक कार्यक्रम)")
                        {
                            WeddingsReceptions=15;


                            var length1=$("#length").val()
                        var breadth1=$("#breadth").val()
                        totalsize= length1 * breadth1;                              
                        $("#TotalSize").val(totalsize);
                        
                        

                        // let decimal = Math.trunc( number );
                        Total=totalsize/100;   //2 
                        if(!(0==(totalsize%100))){
                            decimal = Math.trunc( Total );
                            if(decimal==0)
                                decimal=1;
                            else
                                decimal=decimal+1;
                        }
                        else
                        {
                            decimal=Total;
                        }
                        totalfee=WeddingsReceptions*decimal;
                        $("#Fees").val(totalfee); 
                        
                            
                        }                           
                        else
                        {
                            WeddingsReceptions=0;
                             
                        } 


                        
                    }

                    var totalsize=0;
                    var totalfee=0;
                    var Total=0;
                    var decimal=0;

                    function multiplyBy()
                    {
                        
                        var length1=$("#length").val()
                        var breadth1=$("#breadth").val()
                        totalsize= length1 * breadth1;                              
                        $("#TotalSize").val(totalsize);
                        
                        

                        // let decimal = Math.trunc( number );
                        Total=totalsize/100;   //2 
                        if(!(0==(totalsize%100))){
                            decimal = Math.trunc( Total );
                            if(decimal==0)
                                decimal=1;
                            else
                                decimal=decimal+1;
                        }
                        else
                        {
                            decimal=Total;
                        }
                        totalfee=WeddingsReceptions*decimal;
                        $("#Fees").val(totalfee); 
                        
                    }

                    function  Commercial1 ()
                    {
                        console.log("bye1")
                        WeddingsReceptions=145;
                        var length1=$("#length").val()
                        var breadth1=$("#breadth").val()
                        totalsize= length1 * breadth1;                              
                        $("#TotalSize").val(totalsize);
                        
                        

                        // let decimal = Math.trunc( number );
                        Total=totalsize/100;   //2 
                        if(!(0==(totalsize%100))){
                            decimal = Math.trunc( Total );
                            if(decimal==0)
                                decimal=1;
                            else
                                decimal=decimal+1;
                        }
                        else
                        {
                            decimal=Total;
                        }
                        totalfee=WeddingsReceptions*decimal;
                        $("#Fees").val(totalfee); 
                        
                    }
                    function Charitable1 ()
                    {
                        console.log("bye2")
                        WeddingsReceptions=75;
                        var length1=$("#length").val()
                        var breadth1=$("#breadth").val()
                        totalsize= length1 * breadth1;                              
                        $("#TotalSize").val(totalsize);
                        
                        

                        // let decimal = Math.trunc( number );
                        Total=totalsize/100;   //2 
                        if(!(0==(totalsize%100))){
                            decimal = Math.trunc( Total );
                            if(decimal==0)
                                decimal=1;
                            else
                                decimal=decimal+1;
                        }
                        else
                        {
                            decimal=Total;
                        }
                        totalfee=WeddingsReceptions*decimal;
                        $("#Fees").val(totalfee); 
                        
                    }

                    function  Government1()
                    {
                        console.log("bye3")
                        WeddingsReceptions=40;
                        var length1=$("#length").val()
                        var breadth1=$("#breadth").val()
                        totalsize= length1 * breadth1;                              
                        $("#TotalSize").val(totalsize);
                        
                        

                        // let decimal = Math.trunc( number );
                        Total=totalsize/100;   //2 
                        if(!(0==(totalsize%100))){
                            decimal = Math.trunc( Total );
                            if(decimal==0)
                                decimal=1;
                            else
                                decimal=decimal+1;
                        }
                        else
                        {
                            decimal=Total;
                        }
                        totalfee=WeddingsReceptions*decimal;
                        $("#Fees").val(totalfee); 
                        
                    }



                    
                   
                            
                    </script>



				<div class="col-md-3">
					<div class="mb-3 mt-0">
						<label for="" class="form-label">Date of Event/Program
							(कार्यक्रम/कार्यक्रमाची तारीख)<span class="text-danger"
							style="color: red;">*</span>
						</label> <input type="date" class="form-control"
							style="background-image: none;" id="" placeholder=""
							name="eventDate" value="" required>
						<div class="invalid-feedback">Please Enter Valid Date of
							Event.</div>
					</div>
				</div>

				<div class="col-md-6" id="exhibitions">
					<div class="mb-2 mt-2">
						<label for="" class="form-label ">Exhibitions (प्रदर्शने)<span
							class="mand_error" style="color: red;">*</span></label>

						<div class="d-flex mt-2 border rounded  p-2">
							<div class="form-check ms-3 mt-4">
								<input type="radio" class="form-check-input" id="Commercial"
									onclick="Commercial1(this.id)" name="exhibitions" value="1">Commercial/Industrial
								(व्यावसायिक/औद्योगिक)

							</div>

							<div class="form-check ms-3 mt-4">
								<input type="radio" class="form-check-input" id="Charitable"
									onclick="Charitable1(this.id)" name="exhibitions" value="2">Charitable
								Institutions (सेवाभावी संस्था)

							</div>

							<div class="form-check ms-3 mt-4">
								<input type="radio" class="form-check-input" id="Government"
									onclick="Government1(this.id)" name="exhibitions" value="3">Government/
								Semi-Government Institutions & Corporations (सरकारी/निमशासकीय
								संस्था आणि महामंडळे) <label class="form-check-label"
									for="radio1"></label>
								<div class="invalid-feedback ">Please Select Exhibitions.
								</div>
							</div>
						</div>
					</div>
					<label id="pob-error" class="error" for="pob"></label>
				</div>



				<div class="col-md-6">

					<div class="mb-2 mt-3">
						<label for="" class="form-label "> Duration of Pavilion
							(मंडपचा कालावधी)<span class="text-danger" style="color: red;"">*</span>
						</label>
						<div class=" d-flex border rounded " style="height: 95px;">
							<div class="col-md-5 ms-4">
								<div class="mb-3 mt-2">
									<label for="" class="form-label ">From Date (या
										तारखेपासून)<span class="text-danger" style="color: red;">*</span>
									</label> <input type="date" class="form-control" id=""
										style="background-image: none;" placeholder=""
										name="pavilionStartDate" value="" required>
									<div class="invalid-feedback">Please Enter Valid From
										Date.</div>
								</div>
							</div>
							<div class="col-md-5" style="margin-left: 38px;">
								<div class="mb-3 mt-2">
									<label for="" class="form-label ">To Date (या
										तारीखेपर्यंत)<span class="text-danger" style="color: red;">*</span>
									</label> <input type="date" class="form-control" id=""
										style="background-image: none;" placeholder=""
										name="pavilionEndDate" value="" required>
									<div class="invalid-feedback">Please Enter Valid To Date.
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-12">
					<div class="mb-3 mt-3">
						<label for="" class="form-label">Reason for Pavilion
							(मंडपाचे कारण)<span class="text-danger" style="color: red;">*</span>
						</label>
						<textarea class="form-control " rows="2" id="Address1"
							name="reasonForCertificate"  oninput="validateTextarea1()"style="background-image: none;"
							required></textarea>
						<div class="invalid-feedback" id="errorFeedback1">Please Enter Valid Reason for
							Pavilion.</div>
					</div>
									      <script>
function validateTextarea1() {
  const textareareason = document.getElementById('Address1');
  const errorFeedbackreason = document.getElementById('errorFeedback1');
  const textreason = textareareason.value;

  // Regular expression to check for leading spaces before the first letter
  const regex = /^\s*(\S)/;

  if (regex.test(textreason)) {
	  textareareason.classList.remove('is-invalid');
	  errorFeedbackreason.style.display = 'none';
  } else {
	 textareareason.classList.add('is-invalid');
	 errorFeedbackreason.style.display = 'block';
  }
}
</script>
				</div>
				<div class="col-md-5">

					<div class="mb-2 mt-3">
						<label for="" class="form-label ">Area/Size of Pavilion
							(मंडपचे क्षेत्रफळ/आकार)<span class="text-danger"
							style="color: red;"">*</span>
						</label>
						<div class=" d-flex border rounded " style="height: 95px;">

							<div class="col-md-5 ms-4">
								<div class="mb-3 mt-2">
									<label for="" class="form-label"> Length (लांबी)<span
										class="text-danger" style="color: red;">*</span>
									</label> <input type="number" min="0" class="form-control" id="length"
										style="background-image: none;" placeholder="mtr"
										name="pavilionLength" rows="4"
										onchange="multiplyBy(this.form)" required></input>
									<div class="invalid-feedback">Please Enter Valid Length.
									</div>
								</div>
							</div>

							<div class="col-md-5" style="margin-left: 38px;">
								<div class="mb-3 mt-2">
									<label for="" class="form-label"> Breadth (रुंदी)<span
										class="text-danger" style="color: red;">*</span>
									</label> <input type="number"  min="0" class="form-control" id="breadth"
										style="background-image: none;" placeholder="mtr"
										name="pavilionBreadth" rows="4"
										onchange="multiplyBy(this.form)" required></input>
									<div class="invalid-feedback">Please Enter Valid Breadth.
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>





				<div class="col-md-6">
					<div class="mb-2 mt-3">
						<label for="" class="form-label ">Fees Details excluding other charges (इतर शुल्क वगळून फी तपशील) <span
							class="text-danger" style="color: red;"">*</span></label>
						<div class=" d-flex border rounded " style="height: 95px;">

							<div class="col-md-5 ms-4">
								<div class="mb-3 mt-2">
									<label for="" class="form-label">Total Size (एकूण आकार)<span
										class="text-danger" style="color: red;">*</span>
									</label> <input type="text" class="form-control" id="TotalSize"
										style="background-image: none;" placeholder="sq.mtr"
										name="totalSize" rows="4" oninput="multiplyBy(this.form)"
										required readonly></input>
									<div class="invalid-feedback">Please Enter Valid Size.</div>
								</div>
							</div>

							<div class="col-md-5" style="margin-left: 38px;">
								<div class="mb-3 mt-2">
									<label for="" class="form-label">Fees Applicable(शुल्क
										लागू)<span class="text-danger" style="color: red;">*</span>
									</label> <input type="text" class="form-control" id="Fees"
										style="background-image: none;" placeholder="mtr" name="fees"
										rows="4" oninput="multiplyBy(this.form)" required readonly></input>
									<div class="invalid-feedback">Please Enter Valid Fees.</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="row">

					<h6 style="background-color: white; padding: 5px;"
						class="mt-1 rounded-2 ms-2">
						<strong> List Of Documents (with attachment)(कागदपत्रांची
							यादी (संलग्नकांसह)) </strong>
					</h6>
					<div class="alert alert-info mb-2 p-2 ms-2 mb-4">
						<small><strong>Note: </strong>  Upload below files only
							.pdf(Max upto 2 MB) (खाली फक्त .pdf फाइल अपलोड करा (कमाल २ MB
						पर्यंत))</small>
					</div>
					<input type="hidden" name="filesPath" id="filesPath" />
					<div class="col-md-3">
						<div class="mb-3 mt-3" style="margin-top: 38px;">
							<label for="" class="form-label">NOC From Police
								Department (पोलिस विभागाकडून एनओसी)<span class="text-danger"
								style="color: red;">*</span>
							</label> <input type="file" class="form-control" id="doc1"
								style="background-image: none;" accept=".pdf" name="policeDepartment" required>
							<div class="invalid-feedback">File selected is either
								greater than 2Mb or not of type .pdf.</div>

						</div>
					</div>
					<div class="col-md-3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label">NOC From Traffic
								Department (वाहतूक विभागाकडून एनओसी)<span class="text-danger"
								style="color: red;">*</span>
							</label> <input type="file" class="form-control" id="doc2"
								style="background-image: none;" accept=".pdf" name="trafficDepartment"
								required>
							<div class="invalid-feedback">File selected is either
								greater than 2Mb or not of type .pdf.</div>

						</div>
					</div>
					<div class="col-md-3">
						<div class="mb-3 mt-3">
							<label for="" class="form-label">NOC From Fire Department
								(अग्निशमन विभागाकडून एनओसी)<span class="text-danger"
								style="color: red;">*</span>
							</label> <input type="file" class="form-control"
								style="background-image: none;" accept=".pdf" id="doc3" name="fireDepartment"
								required>
							<div class="invalid-feedback">File selected is either
								greater than 2Mb or not of type .pdf.</div>

						</div>
					</div>
					<div class="col-md-12">
						<div class="mb-5 mt-4 ">
							<div class="form-check">
								<input class="form-check-input" type="checkbox" id="check11"
									name="declaration" value="something" required> <label
									class="form-check-label ms-3 " style="margin-top: -1px;">
									<strong>Declaration (घोषणा)<span class="text-danger"
										style="color: red;">*</span>:-
								</strong>The above mentioned information is true to the best of my
									knowledge and belief(वर नमूद केलेली माहिती माझ्या माहितीनुसार
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
							<button class="btn btn-success btn_sm" type="submit" id="submit"
								>Submit</button>
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
                     onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveMandapCertificates.do');
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
                    filesPath = filesPath + basePath + "mandapPermission/" + id + value + ","
                    isFileSelected = true;
                }
            }
            $.ajax({
                url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadDocumentMandap.do?id="+id,
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

    
    
    function downloadFile() {
        var fileUrl = "<c:out value="${contextRoot}"/>/pages/citizendocument/ZoneWardAndAreaDetails.pdf";
        var fileName = "ZoneWardAndAreaDetails.pdf";
        
        var downloadLink = document.createElement("a");
        downloadLink.href = fileUrl;
        downloadLink.download = fileName;
        document.body.appendChild(downloadLink);
        downloadLink.click();
        document.body.removeChild(downloadLink);
    }
</script>
    
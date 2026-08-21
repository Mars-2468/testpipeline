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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
   
<script>




    
    

function Address(form) {
    if (form.yes.checked) {
        document.getElementById("address").readOnly = true;
        document.getElementById("address").value = document.getElementById("current").value
        console.log(form.permanent_address.value);

    } else if (form.no.checked) {
        document.getElementById("address").readOnly = false;
        document.getElementById("address").value = " ";
    }
}


// function getSelectItem(id) {
//     for (var i = 1; i <= 2; i++) {
//         document.getElementById(i).checked = false;
//     }
//     document.getElementById(id).checked = true;
// }

// function checkSelectitem(id) {
//     for (var i = 3; i <= 4; i++) {
//         document.getElementById(i).checked = false;
//     }
//     document.getElementById(id).checked = true;
// }

// function multiplyBy(form) {
//     if (form.same.checked) {

//         document.getElementById("fees").value = document.getElementById("number").value * 100;

//     } else if (form.other.checked) {

//         document.getElementById("fees").value = document.getElementById("number").value * 20;
//     }
// }

// function FeesCal(form) {
//     if (form.same.checked) {
//         document.getElementById("number").removeAttribute('readonly');
//         document.getElementById("fees").value = document.getElementById("number").value * 100;

//     } else if (form.other.checked) {
//         document.getElementById("number").removeAttribute('readonly');
//         document.getElementById("fees").value = document.getElementById("number").value * 20;

//     }
// }


    function changeddl(obj) {
        if (document.getElementById("iFunction").value > 0) {

            document.getElementById("cOperation").removeAttribute('disabled');
            document.getElementById("iOperation").removeAttribute('disabled');

            var text = obj.options[obj.selectedIndex].text;
            var ddl2 = document.querySelectorAll('#iOperation option');
            var ddl1 = document.querySelectorAll('#cOperation option');
            for (var i = 1; i < ddl1.length; i++) {
                var option = ddl1[i];
                option.style.display = 'none';
                if (text == 'Zone No.1 - Laxmi Nagar (लक्ष्मी नगर)') {
                    if (['Sahakar Nagar (सहकार नगर)', 'Jaytala Ghat (जयताळा घाट)', 'Shivangaon Ghat (शिवणगाव घाट)','Other (इतर)'].indexOf(option.text) > -1)
                        option.style.display = 'block'

                }
                if (text == 'Zone No.2 - Dharmpeth (धरमपेठ)') {
                    if (['Ambazari (अंबाझरी)', 'Friends Colony Borgaon Ghat (फ्रेंड्स कॉलनी बोरगाव घाट)','Other (इतर)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.3 - Hanuman Nagar (वंदनीय राष्ट्रसंत तुकडोजी महाराज)') {
                    if (['Manewada Ghat(मानेवाडा घाट)', 'Sufia Qabrastan (सुफिया कब्रस्तान)','Other (इतर)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.4 - Dhantoli (धंतोली)') {
                    if (['Mokshadham (मोक्षधाम)','Other (इतर)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.5 - Nehru Nagar (नेहरू नगर श्रेत्रिय कार्यालय)') {
                    if (['Dighori Ghat (दिघोरी घाट)', 'Wathoda Ghat (वाठोडा घाट)', 'Hasanbag Qabrastan (हसनबाग कब्रस्तान)','Tajabad Qabrastan (ताजाबाद कब्रस्तान)','Other (इतर)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.6 - Gandhi Zone Mahal (गांधी झोन ​​महाल)') {
                    if (['Gangabai Ghat (गंगाबाई घाट)', 'Mominpura Qabrastan (मोमीनपुरा कब्रस्तान)','Other (इतर)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.7 - Satranjipura (सतरंजीपुरा)') {
                    if (['Shantinagar Ghat (शांतीनगर घाट)', 'Gosawi Ghat (गोसावी घाट)', 'Mehandibag Bohra Qabrastan (मेहंदीबाग बोहरा कब्रस्तान)','Other (इतर)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.8 - Lakadganj (लकडगंज)') {
                    if (['Pardi Ghat (पारडी घाट)', 'Bhandara Road Qabrastan (भंडारा रोड कब्रस्तान)','Other (इतर)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.9 - Aashi Nagar (आशी नगर)') {
                    if (['Barse Ghat (बारसे घाट)','Vaishali Nagar Nirwan Ghat (वैशाली नगर निर्वाण घाट)','Nari Ghat (नारी घाट)', 'Nara Ghat (नारा घाट)','Taj Nagar Qabrastan Teka (ताज नगर कब्रस्तान टेका)','Pilinadi Qabrastan (पिलिनादी कब्रस्तान)','Muslim Qabrastan Kamgarnagar (मुस्लिम कब्रस्तान कामगारनगर)','Other (इतर)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.10 - Mangalwari (मंगळवारी)') {
                    if (['Mankapur Ghat (मानकापूर घाट)', 'Muslim Qabrastan Jaripatka (मुस्लिम कब्रस्तान जरीपटका)', 'Jaripatka Christan Ghat (जरीपटका क्रिस्‍टन घाट)','Parsi Ghat (पारशी घाट)','Gorewada Ghat (गोरेवाडा घाट)','Other (इतर)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
            }
            for (var i = 1; i < ddl2.length; i++) {
                var option = ddl2[i];
                option.style.display = 'none';
                if (text == 'Zone No.1 - Laxmi Nagar (लक्ष्मी नगर)') {
                    if (['Dr. S. M. Patil Nursing Home , 70 (डॉ. एस. एम. पाटील नर्सिंग होम, 70)', 'Kalptaru Materntiy & Surgical Nursing Home , 78 (कल्पतरू मातृत्व आणि सर्जिकल नर्सिंग होम , 78)', 'Renuka Maternity & Ent Hospital , 120 (रेणुका मॅटर्निटी अँड एंटी हॉस्पिटल , 120)'].indexOf(option.text) > -1)
                        option.style.display = 'block'

                }
                if (text == 'Zone No.2 - Dharmpeth (धरमपेठ)') {
                    if (['Sengupta Hospital & Research Institute , 3 (सेनगुप्ता हॉस्पिटल अँड रिसर्च इन्स्टिट्यूट , 3)', 'Sanjeevan Maternity & Nursing Home , 42 (संजीवन मॅटर्निटी आणि नर्सिंग होम, 42)', 'Maher Maternity & Nursing Home , 45 (माहेर मॅटर्निटी आणि नर्सिंग होम , 45)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.3 - Hanuman Nagar (वंदनीय राष्ट्रसंत तुकडोजी महाराज)') {
                    if (['Bansod Hospital , 31 (बनसोड हॉस्पिटल , 31)', 'Asha Bhawan Nursing Home , 54 (आशा भवन नर्सिंग होम, 54)', 'Naik Hospital ,8 (नाईक हॉस्पिटल,8)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.4 - Dhantoli (धंतोली)') {
                    if (['Jasleen Hospital , 2 (जसलीन हॉस्पिटल , 2)', 'Ketkar Nursing Home , 23 (केतकर नर्सिंग होम Home , 23)', 'Navjeevan Nursing Home , 29 (नवजीवन नर्सिंग होम, 29)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.5 - Nehru Nagar (नेहरू नगर श्रेत्रिय कार्यालय)') {
                    if (['Ashish Eye Hospital , 105 (आशिष आय हॉस्पिटल , 105)', 'Kurvey Nursing Home , 147 (कुर्वे नर्सिंग होम , 147)', 'S. D. Hospital , 193 (एस.डी. हॉस्पिटल , 193)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.6 - Gandhi Zone Mahal (गांधी झोन ​​महाल)') {
                    if (['Saoji Hospital , 26 (साओजी हॉस्पिटल , 26)', 'Rahimi Nursing Home , 33 (रहीमी नर्सिंग होम,33)', 'Saboo Hospital , 82 (साबू हॉस्पिटल , 82)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.7 - Satranjipura (सतरंजीपुरा)') {
                    if (['Taj Nursing Home , 65 (ताज नर्सिंग होम , 65)', 'Central Hospital , 495 (सेंट्रल हॉस्पिटल , 495)', 'Crystal Nursing Home , 1023 (क्रिस्टल नर्सिंग होम , 1023)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.8 - Lakadganj (लकडगंज)') {
                    if (['Ridhorkar Hospital , 30 (रिधोरकर हॉस्पिटल , 30)', 'Thakkar Nursing Home , 178 (ठक्कर नर्सिंग होम, 178)', 'Arjun Hospital , 194 (अर्जुन हॉस्पिटल , 194)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.9 - Aashi Nagar (आशी नगर)') {
                    if (['Zaveri Nursing Home , 15 (झवेरी नर्सिंग होम , 15)','Ansari Maternity & Nursing Home , 114 (अन्सारी मॅटर्निटी अँड नर्सिंग होम , 114)', 'Khobragade Multispeciality Hospital , 124 (खोब्रागडे मल्टीस्पेशालिटी हॉस्पिटल , 124)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
                if (text == 'Zone No.10 - Mangalwari (मंगळवारी)') {
                    if (['Naidu Hospital , 39 (नायडू हॉस्पिटल , 39)', 'Punshi Hospital , 58 (पुंशी हॉस्पिटल, 58)', 'Janta Maternity Home & Hospital , 91 (जनता मॅटर्निटी होम आणि हॉस्पिटल , 91)'].indexOf(option.text) > -1)
                        option.style.display = 'block'
                }
            }
        }

    }
            
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




                            <li>1.Hospital Certificate (रुग्णालयाचे प्रमाणपत्र)</li>
                            <li>2.Deceased ID Proof (Aadhar/PAN/Voting Card/T.C./etc)(मृत व्यक्तीचा ओळखपत्र पुरावा (आधार/पॅन/मतदान कार्ड/टी.सी./इ.))<span class="text-danger"  style="color: red;">*</span> </li>
                            <li>3.Applicant's ID Proof (Aadhar/PAN/Voting Card/T.C./etc) (अर्जदाराचा ओळखपत्र पुरावा (आधार/पॅन/मतदान कार्ड/टी.सी./इ.)) <span class="text-danger"  style="color: red;">*</span></li>
                            <li>4.Crematoriums Certificate (स्मशानभूमीचे प्रमाणपत्र)<span class="text-danger" style="color: red;">*</span> </li>
                            <li>5.Certificate issued by Correspondent<br>(ward member)(बातमीदाराने जारी केलेले प्रमाणपत्र(वॉर्ड सदस्य))</li> 

                        </ul>

                    </div>

                    <!-- dialog buttons -->

                    <div class="modal-footer"><button type="button" class="btn btn-primary">OK</button></div>

                </div>

            </div>

        </div>
<body>
   
    <form name="BirthForm" action="" id="BirthForm">
   <div class="container-fluid mt-2" style="width: 180vh">
           <div class="printable">
               <h3 class="text-center">Application Form For Death Certificate (मृत्यू प्रमाणपत्रासाठी अर्ज)</h3>
           </div>

        <h6 style="background-color:#dce2e8; padding:10px;" class="  rounded-2"><strong  class="form-label "> Applicant Details (अर्जदाराचे तपशील) </strong></h6>
        <div class="row">
            <input type="hidden" name="_token" value="xyz">
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
                               <label for="" class="form-label ">Title (शीर्षक)<span class="text-danger" >*</span>
                               </label>
                              
                               <select class="form-select " style="background-image: none;" name="applicantTitle" required>


                                   <option value="">-Select-</option>
                                                               <option value="Mr (श्री)" >Mr (श्री)</option>
                                                               <option value="Mrs (सौ)" >Mrs (सौ)</option>
                                                               <option value="Ms (कु)" >Ms (कु)</option>
                                                       </select>
                                                       <div class="invalid-feedback ">
                                   Please Select Valid Title.
                               </div>
                               
                   
                           </div>
                       </div>
           
                       <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label name " >Name (नाव)<span class="text-danger" >*</span></label>
                           
                            <input type="text" class="form-control" style="background-image: none;" id="first_name" placeholder="" name="applicantFirstName" value=""
                            pattern="[A-Za-z]+" onchange="Display(this.id)" 
                             maxlength="40" required>
                            <div class="invalid-feedback ">
                                Please Enter Valid First Name.
                            </div>
                                                    </div>
                    </div>
            
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label name ">Father's Name (वडिलांचे नाव)</label>
                            <input type="text" class="form-control" style="background-image: none;"  id="middle_name" placeholder="" name="applicantMiddleName" value=""
                            pattern="[A-Za-z]+" onchange="Display(this.id)"   >
                           
                                
                        </div>
                    </div>
            
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label name ">Surname (आडनाव)<span class="text-danger" style="color: red;">*</span></label>
                            <input type="text" class="form-control name"  style="background-image: none;" name="applicantLastName" id="last_name" value=""  pattern="[A-Za-z]+" onchange="Display(this.id)" maxlength="80" required>
                            <div class="invalid-feedback ">
                                Please Enter Valid Last Name.

                               

                            </div>

                        </div>
                    </div>
                    <script>
                    function validateInput1(event) {
                    	  const input = event.target;
                    	  const value = input.value;

                    	  if (value.length > 0 && value[0] === ' ') {
                    	    // Show error message
                    	    this.classList.add('is-invalid');
                    	   
                    	  } else {
                    	    // Remove error message
                    	    input.classList.remove('is-invalid');
                    	    
                    	  }
                    	}

                    	// Get all the input fields
                    	const inputFields = document.getElementsByClassName('name'); // Replace 'your-input-class' with the actual class name you're using for the input fields

                    	// Loop through each input field and attach the event listener
                    	Array.from(inputFields).forEach((input) => {
                    	  input.addEventListener('input', validateInput1);
                    	});

                    </script>
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Full Name (संपूर्ण नाव) </label>
                           
                            <input type="text" class="form-control"  style="background-image: none;"
                             id="full_name" placeholder="" name="applicantFullName" value="" readonly required>
                        </div>
                    </div>
  <script>
    function validateInput(event) {
      var input = event.target.value;
      var regex = /^[a-zA-Z\s]*$/;
      var isValid = regex.test(input);
      
      if (!isValid) {
        event.target.value = input.replace(/[^A-Za-z]+/g, '');
      }
    }
  </script>

                    <script>
                        function Display(id) {
                                      $('#full_name').val( $('#first_name').val()+" "+ $('#middle_name').val()+" "+ $('#last_name').val())
                                }
                        </script>
        

                
				<div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Plot/ Flat No.(प्लॉट/फ्लॅट क्र.) <span class="text-danger" style="color: red;">*</span></label>
                    <input type="text" class="form-control" style="background-image: none;" pattern="^\s*\S.*$"   id="plot_no" placeholder="" name="applicantPlotNo" value=""
                                   maxlength="255" onchange="change(this.id)"   required>
                                    <div class="invalid-feedback ">
                                        Please Enter Valid Plot/Flat No.
                                    </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Name of the Building (इमारतीचे नाव)</label>
                            
                            <input type="text" class="form-control" style="background-image: none;"  id="buildingName" placeholder=""
                                name="applicantBuildingName" value=""  pattern="^\s*\S.*$" onchange="change(this.id)" >
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Name of the Street (रस्त्याचे नाव)</label>
                           
                    <input type="text" class="form-control" style="background-image: none;" id="street_name" placeholder="" name="applicantStreetName"
                                     maxlength="255" value=""  pattern="^\s*\S.*$" onchange="change(this.id)"  >
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Name of the Area (क्षेत्राचे नाव) <span class="text-danger"
                                    style="color: red;"">*</span></label>
                                    <input type="text" class="form-control" style="background-image: none;" id="areaName" placeholder="" name="applicantAreaName" value=""
                                    maxlength="255"  pattern="^\s*\S.*$" onchange="change(this.id)"  required>
                                   <div class="invalid-feedback ">
                                    Please Enter Valid Name of the Area.
                                </div>
                        </div>
                    </div>

                   

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Near by Landmark (जवळील लँडमार्क)</label>
                            <input type=" text" class="form-control" style="background-image: none;"  id="landmark" placeholder="" name="applicantNearbyLandmark"
                                value="" pattern="^\s*\S.*$" onchange="change(this.id)" >
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">City Name (शहराचे नाव) </label>
                                    <input type=" text" class="form-control" style="background-image: none;" id="city" placeholder="" name="cityName" value=""
                                    maxlength="255"  pattern="^\s*\S.*$" onchange="change(this.id)">
                                   <div class="invalid-feedback ">
                                    Please Enter Valid Name of City.
                                </div>
                        </div>
                    </div>
                    
                   
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">Pin Code (पिन कोड)<span class="text-danger" >*</span></label>
                            <input type="text" class="form-control" style="background-image: none;" id="pin_code" name="applicantPinCode" value=""
                                         maxlength="6" pattern="[0-9]{6}" onchange="change(this.id)"  required>
                                        <div class="invalid-feedback ">
                                Please Enter Valid Pin Code.
                            </div>
                                                           
                        </div>
                    </div>
                    <div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label "> Aadhaar No. (आधार क्र.)
						</label> <input type="text" class="form-control "
							style="background-image: none;" id="aadhaarNumber1"
							placeholder="" name="aadhaarNo" value="" pattern="[0-9]{12}"
							maxlength="12">
						<div class="invalid-feedback">Please Enter Valid Aadhaar No.
						</div>

					</div>
				</div>
                    
                     <div class="col-md-3">
                            <div class="mb-3 mt-3">
                                
                            <label for="email"  class="form-label "> Email Id (ईमेल आयडी)<span class="text-danger" >*</span> </label>
                           
                            <input type="email" class="form-control " style="background-image: none;" name="email" value="" required>
                            <div class="invalid-feedback ">
                                Please Enter Valid Email Id.
                            </div>
                           
                        </div>
                    </div>
                    
                                    
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label "> Mobile No.(मोबाईल क्र.)<span class="text-danger"
                                    style="color: red;">*</span>
                            </label>
                           
                            <input type="text" class="form-control " style="background-image: none;"  id="txtMobileNumber" placeholder="" name="ph_no" value=""
                            pattern="[6-9]{1}[0-9]{9}"
                                maxlength="10"  required>
                             <div class="invalid-feedback ">
                                Please Enter Valid Mobile No.
                            </div>
                                                   </div>
                    </div>  
<div class="col-md-3">
    <div class="mb-3" style="margin-top:-6px;">
        <label for="" class="form-label ">Relationship of Applicant (अर्जदाराचे नाते)<span class="text-danger" 
                style="color: red;">*</span></label>
               
        <select class="form-select" style="background-image: none;" id='relationshipSelect' name="applicantRelationship" required>
            <option value="">-Select-</option>
      <option value="Father (वडील)">Father (वडील)</option>
            <option value="Mother (आई)">Mother (आई)</option>
            <option value="Sister (बहीण)">Sister (बहीण)</option>
            <option value="Brother (भाऊ)">Brother (भाऊ)</option>
            <option value="Cousin (चुलत भावंड)">Cousin (चुलत भावंड)</option>
            <option value="Friend (मित्र/मैत्रिण)">Friend (मित्र/मैत्रिण)</option>
            <option value="Uncle (काका)">Uncle (काका)</option>
            <option value="Aunty (काकी)">Aunty (काकी)</option>
            <option value="Grandfather (आजोबा)">Grandfather (आजोबा)</option>
            <option value="Grandmother (आजी)">Grandmother (आजी)</option>
            <option value="Other (इतर)">Other (इतर)</option>
        </select>
        
        <div class="invalid-feedback">
            Please enter a valid Relationship of Applicant.
        </div>
    </div>
</div>
<script>
$(document).on('change', '#relationshipSelect', function () {
    if ($(this).val() == 'Other (इतर)') {
        $(this).replaceWith($('<input/>', { 'class': 'form-control', 'style': 'background-image: none;', 'type': 'text', 'id': 'otherRelationship', 'name': 'applicantRelationship', 'required': true }));
    } else {
        $('#otherRelationship').remove();
    }
});
</script>
<div class="col-md-12">
    <div class="mb-3 mt-3">
        <label for="primary_full_address" class="form-label">Address For Correspondence (पत्रव्यवहारासाठी पत्ता)&nbsp;&nbsp;
            (Same as above (वरील प्रमाणे)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" class="form-check-input" name="yes" id="yes" value="1" onclick="change()"> Yes (होय)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" class="form-check-input" name="yes" id="no" value="2" onclick="change()"> No (नाही)&nbsp;)<span class="text-danger">*</span></label>

        <textarea class="form-control" oninput="validateTextarea()" style="background-image: none;" rows="2" id="Address" name="address" required></textarea>
        <div class="invalid-feedback" id="errorFeedback">
            Please Enter Valid Address.
        </div>
    </div>
</div>

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
                           
                </div>
         <br>
            <h6 style="background-color:#dce2e8; padding:10px;" class="  rounded-2"><strong class="form-label "> Application Form
                    Details (अर्जाचा तपशील)</strong></h6>

            <div class="row">
                <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label ">Name of Deceased (मृत व्यक्तीचे नाव)<span class="text-danger" 
                                style="color: red;">*</span></label>
                        <input type="text" class="form-control" style="background-image: none;" id="" placeholder="" name="nameOfDeceased"  onclick="warning(this);" value=""
                        pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$"  required>
                            <div class="invalid-feedback ">
                                Please Enter Valid Name of Deceased.
                            </div>
                                               </div>
                </div>

<script>
var clicked = false;

function warning(){

	if(clicked){
		return false;
	}else{
		
		alert(" Name will not be change once entered (एकदा प्रविष्ट केल्यानंतर नाव बदलले जाणार नाही)");
		clicked = true;
	}
	

}


</script>
                <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label ">Deceased's Gender (मृत व्यक्तीचे लिंग)<span class="text-danger" 
                                style="color: red;">*</span></label>
                                

                        <select class="form-select " style="background-image: none;" name="gender" required>
                            <option value="">-Select-</option>
                            <option value="Male (पुरुष)">Male (पुरुष)</option>
                            <option value="Female (स्त्री)">Female (स्त्री)</option>
                            <option value="Transgender (ट्रान्सजेंडर)">Transgender (ट्रान्सजेंडर)</option>

                        </select>
                        
                        
                        <div class="invalid-feedback ">
                            Please Select Valid Deceased's Gender.
                        </div>
                        

                    </div>
                </div>
              <div class="col-md-3">
    <div class="mb-3 mt-3">
        <label for="" class="form-label">Age of Deceased (मृत व्यक्तीचे वय)<span class="text-danger" style="color: red;">*</span></label>

        <input type="text" class="form-control" style="background-image: none;" id="infantAge" placeholder="Age in Years" name="infantAge" 
            value="" oninput="validateAge(this)" maxlength="2" required>

        <div class="invalid-feedback">
            Please enter a valid age of the deceased.
        </div>
    </div>
</div>

<script>
    function validateAge(input) {
        var age = input.value;

        // Allow only digits and prevent leading zeros
        if (/^\d+$/.test(age)) {
            // Convert to integer to remove leading zeros
            var ageInt = parseInt(age, 10);

            // Check if the age is greater than 0
            if (ageInt > 0) {
                // Valid age
                input.setCustomValidity('');
            } else {
                // Invalid age (0 or negative)
                input.setCustomValidity('Age must be greater than 0.');
            }
        } else {
            // Non-digit characters are not allowed
            input.setCustomValidity('Please enter a valid number.');
        }
    }
</script>


                <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label ">Father's Name (वडिलांचे नाव)<span class="text-danger" 
                                style="color: red;">*</span></label>
                                
                        <input type="text" class="form-control" style="background-image: none;" id="" placeholder="" name="fatherName" value=""
                        pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$"   maxlength="80"required>
                            <div class="invalid-feedback ">
                                Please Enter Valid Father's Name. 
                            </div>  
                           
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label ">Grandfather's Name (आजोबांचे नाव)</label>
                        
                        <input type="text" class="form-control" style="background-image: none;" id="" placeholder="" name="grandfatherName"    pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$" value="">
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label ">Mother's Name (आईचे नाव)<span class="text-danger" 
                                style="color: red;">*</span></label>
                                                       <input type="text" class="form-control" style="background-image: none;" id="" placeholder="" name="motherName" value=""
                                                       pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$"   maxlength="80"required>
                            <div class="invalid-feedback ">
                                Please Enter Valid Mother's Name. 
                            </div>
                                                </div>

                </div>

                <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label ">Husband/Wife's Name (पती/पत्नीचे नाव)</label>
                        <input type="text" class="form-control" style="background-image: none;" id="" placeholder="" name="wifeName" value=""    pattern="^([A-Za-z]{0,})([A-Za-z]{1,}\s?)+$"  maxlength="80">
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label ">Date of Death (मृत्यूची तारीख)<span class="text-danger" 
                                style="color: red;">*</span></label>
                               <input type="date" class="form-control" style="background-image: none;"  id="dob" placeholder="" name="dateOfDeath" value=""
                             required>
                            <div class="invalid-feedback ">
                                Please Enter Valid Date of Death. 
                            </div>
                           </div>
                </div>

                <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label ">Place of Death (मृत्यूचे ठिकाण)<span class="text-danger" 
                                style="color: red;">*</span></label>
                        <div class="d-flex mt-2 border rounded  p-2">
                            <div class="form-check ms-3">
                                <input type="radio" class="form-check-input" id="radio3" name="placeOfDeath" value="1"
                                    required>
                                <label class="form-check-label " for="radio1">Home (घर)</label>
                                
                            </div>

                            <div class="form-check ms-3">
                                <input type="radio" class="form-check-input" id="radio4" name="placeOfDeath" value="2"
                                    required>
                                    
                                <label class="form-check-label " for="radio1">Hospital (रुग्णालय)</label>
                                <div class="invalid-feedback ">
                                        Please Select Valid Place of Death. 
                                    </div>
                            </div>
                            
                        </div>
                        <label id="placeOfDeath-error" class="error" for="placeOfDeath"></label>
                        
                    </div>
                </div>
                 
                <div class="col-md-3">
                    <div class="mb-3" style="margin-top: 53px">
                        <label for="" class="form-label ">Zone No(झोन क्र.)<span class="text-danger"
                                style="color: red;" id="zone"
                                onclick="Zoneno(this.form)">*</span> </label>
                        
                        <select class="form-select " style="background-image: none;" id="iFunction" name="zone" onchange="callHospitalList(this);changeddl(this)" required>
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
                        
                        <div class="invalid-feedback ">
                        Please Enter Valid Zone No.
                    </div>
                   
                    </div>
                </div>
                
                <div class="col-md-3 hospital_row" id="hos">
                    <div class="mb-3"  style="margin-top: 29px">
                        <label for="" class="form-label ">Hospital Name and Registration No(रुग्णालयाचे नाव आणि नोंदणी क्र.)<span class="text-danger" 
                                style="color: red;">*</span> </label>
                        
                        <select class="form-select " style="background-image: none;" id="iOperation" name="hospitalName" required disabled  >
                            <option value="" selected="">-Select Hospital-</option>
                            
                            
                        </select>
                        
                        <div class="invalid-feedback ">
                            Please Select Valid Name of Crematoriums.Hospital Name and Registration No.
                        </div>
                        

                    </div>
                </div>
                
                 <div class="col-md-3">
                    <div class="mb-3"  style="margin-top: 30px">
                        <label for="" class="form-label ">Name of Crematoriums (स्मशानभूमींची नावे)<span class="text-danger" 
                                style="color: red;">*</span> </label>
                        
                        <select class="form-select " style="background-image: none;" id="cOperation" name="nameofCrematorium" required disabled>
                            <option value="">-Select-</option>
                            <option value="Sahkar Nagar Ghat">Sahakar Nagar (सहकार नगर)</option>
                            <option value="Jaytala Ghat">Jaytala Ghat (जयताळा घाट)</option>
                            <option value="Shivangaon Ghat">Shivangaon Ghat (शिवणगाव घाट)</option>
                                                       
                            <option value="Ambazari">Ambazari (अंबाझरी)</option>
                            <option value="Friends Colony Borgaon Ghat">Friends Colony Borgaon Ghat (फ्रेंड्स कॉलनी बोरगाव घाट)</option>
                            
                            <option value="Manewada Ghat">Manewada Ghat(मानेवाडा घाट)</option>
                            <option value="Sufia Qabrastan">Sufia Qabrastan (सुफिया कब्रस्तान)</option>
                            
                            <option value="Mokshadham">Mokshadham (मोक्षधाम)</option>
                            
                            <option value="Dighori Ghat">Dighori Ghat (दिघोरी घाट)</option>
                            <option value="Wathoda Ghat">Wathoda Ghat (वाठोडा घाट)</option>
                            <option value="Hasanbag Qabrastan">Hasanbag Qabrastan (हसनबाग कब्रस्तान)</option>
                            <option value="Tajabad Qabrastan">Tajabad Qabrastan (ताजाबाद कब्रस्तान)</option>
                            
                            <option value="Gangabai Ghat">Gangabai Ghat (गंगाबाई घाट)</option>
                            <option value="Mominpura Qabrastan"> Mominpura Qabrastan (मोमीनपुरा कब्रस्तान)</option>
                            
                             <option value="Shantinagar Ghat">Shantinagar Ghat (शांतीनगर घाट)</option>
                            <option value="Gosawi Ghat"> Gosawi Ghat (गोसावी घाट)</option>
                           <option value="Mehandibag Bohra Qabrastan"> Mehandibag Bohra Qabrastan (मेहंदीबाग बोहरा कब्रस्तान)</option>
                            
                             <option value="Pardi Ghat"> Pardi Ghat (पारडी घाट)</option>
                           <option value="Bhandara Road Qabrastan"> Bhandara Road Qabrastan (भंडारा रोड कब्रस्तान)</option>
                            
                            <option value="Barse Ghat">Barse Ghat (बारसे घाट)</option>
                            <option value="Vaishali Nagar Nirwan Ghat"> Vaishali Nagar Nirwan Ghat (वैशाली नगर निर्वाण घाट)</option>
                            <option value="Nari Ghat">Nari Ghat (नारी घाट)</option>
                             <option value="Nara Ghat">Nara Ghat (नारा घाट)</option>
                              <option value="Taj Nagar Qabrastan Teka">Taj Nagar Qabrastan Teka (ताज नगर कब्रस्तान टेका)</option>
                               <option value="Pilinadi Qabrastan">Pilinadi Qabrastan (पिलिनादी कब्रस्तान)</option>
                               <option value="Muslim Qabrastan Kamgarnagar">Muslim Qabrastan Kamgarnagar (मुस्लिम कब्रस्तान कामगारनगर)</option>
                            
                            
                            <option value="Mankapur Ghat">Mankapur Ghat (मानकापूर घाट)</option>
                            <option value="Muslim Qabrastan Jaripatka">Muslim Qabrastan Jaripatka (मुस्लिम कब्रस्तान जरीपटका)</option>
                           <option value="Jaripatka Christan Ghat">Jaripatka Christan Ghat (जरीपटका क्रिस्‍टन घाट)</option>
                            <option value="Parsi Ghat">Parsi Ghat (पारशी घाट)</option>
							<option value="Gorewada Ghat">Gorewada Ghat (गोरेवाडा घाट)</option>
                            
                       <option value="10">Other (इतर)</option>
                            
                        </select>
                        
                        <div class="invalid-feedback ">
                            Please Select Valid Name of Crematoriums.
                        </div>
                        

                    </div>
                </div>
                <script>
                function changeddl(obj) {
                    if (document.getElementById("iFunction").value > 0) {

                        document.getElementById("cOperation").removeAttribute('disabled');
                        document.getElementById("iOperation").removeAttribute('disabled');

                        var text = obj.options[obj.selectedIndex].text;
                        var ddl2 = document.querySelectorAll('#iOperation option');
                        var ddl1 = document.querySelectorAll('#cOperation option');
                        for (var i = 1; i < ddl1.length; i++) {
                            var option = ddl1[i];
                            option.style.display = 'none';
                            if (text == 'Zone No.1 - Laxmi Nagar (लक्ष्मी नगर)') {
                                if (['Sahakar Nagar (सहकार नगर)', 'Jaytala Ghat (जयताळा घाट)', 'Shivangaon Ghat (शिवणगाव घाट)','Other (इतर)'].indexOf(option.text) > -1)
                                    option.style.display = 'block'

                            }
                            if (text == 'Zone No.2 - Dharmpeth (धरमपेठ)') {
                                if (['Ambazari (अंबाझरी)', 'Friends Colony Borgaon Ghat (फ्रेंड्स कॉलनी बोरगाव घाट)','Other (इतर)'].indexOf(option.text) > -1)
                                    option.style.display = 'block'
                            }
                            if (text == 'Zone No.3 - Hanuman Nagar (वंदनीय राष्ट्रसंत तुकडोजी महाराज)') {
                                if (['Manewada Ghat(मानेवाडा घाट)', 'Sufia Qabrastan (सुफिया कब्रस्तान)','Other (इतर)'].indexOf(option.text) > -1)
                                    option.style.display = 'block'
                            }
                            if (text == 'Zone No.4 - Dhantoli (धंतोली)') {
                                if (['Mokshadham (मोक्षधाम)','Other (इतर)'].indexOf(option.text) > -1)
                                    option.style.display = 'block'
                            }
                            if (text == 'Zone No.5 - Nehru Nagar (नेहरू नगर श्रेत्रिय कार्यालय)') {
                                if (['Dighori Ghat (दिघोरी घाट)', 'Wathoda Ghat (वाठोडा घाट)', 'Hasanbag Qabrastan (हसनबाग कब्रस्तान)','Tajabad Qabrastan (ताजाबाद कब्रस्तान)','Other (इतर)'].indexOf(option.text) > -1)
                                    option.style.display = 'block'
                            }
                            if (text == 'Zone No.6 - Gandhi Zone Mahal (गांधी झोन ​​महाल)') {
                                if (['Gangabai Ghat (गंगाबाई घाट)', 'Mominpura Qabrastan (मोमीनपुरा कब्रस्तान)','Other (इतर)'].indexOf(option.text) > -1)
                                    option.style.display = 'block'
                            }
                            if (text == 'Zone No.7 - Satranjipura (सतरंजीपुरा)') {
                                if (['Shantinagar Ghat (शांतीनगर घाट)', 'Gosawi Ghat (गोसावी घाट)', 'Mehandibag Bohra Qabrastan (मेहंदीबाग बोहरा कब्रस्तान)','Other (इतर)'].indexOf(option.text) > -1)
                                    option.style.display = 'block'
                            }
                            if (text == 'Zone No.8 - Lakadganj (लकडगंज)') {
                                if (['Pardi Ghat (पारडी घाट)', 'Bhandara Road Qabrastan (भंडारा रोड कब्रस्तान)','Other (इतर)'].indexOf(option.text) > -1)
                                    option.style.display = 'block'
                            }
                            if (text == 'Zone No.9 - Aashi Nagar (आशी नगर)') {
                                if (['Barse Ghat (बारसे घाट)','Vaishali Nagar Nirwan Ghat (वैशाली नगर निर्वाण घाट)','Nari Ghat (नारी घाट)', 'Nara Ghat (नारा घाट)','Taj Nagar Qabrastan Teka (ताज नगर कब्रस्तान टेका)','Pilinadi Qabrastan (पिलिनादी कब्रस्तान)','Muslim Qabrastan Kamgarnagar (मुस्लिम कब्रस्तान कामगारनगर)','Other (इतर)'].indexOf(option.text) > -1)
                                    option.style.display = 'block'
                            }
                            if (text == 'Zone No.10 - Mangalwari (मंगळवारी)') {
                                if (['Mankapur Ghat (मानकापूर घाट)', 'Muslim Qabrastan Jaripatka (मुस्लिम कब्रस्तान जरीपटका)', 'Jaripatka Christan Ghat (जरीपटका क्रिस्‍टन घाट)','Parsi Ghat (पारशी घाट)','Gorewada Ghat (गोरेवाडा घाट)','Other (इतर)'].indexOf(option.text) > -1)
                                    option.style.display = 'block'
                            }
                        }
                        for (var i = 1; i < ddl2.length; i++) {
                            var option = ddl2[i];
                            option.style.display = 'none';
                            if (text == 'Zone No.1 - Laxmi Nagar (लक्ष्मी नगर)') {
                                if (['Dr. S. M. Patil Nursing Home , 70 (डॉ. एस. एम. पाटील नर्सिंग होम, 70)', 'Kalptaru Materntiy & Surgical Nursing Home , 78 (कल्पतरू मातृत्व आणि सर्जिकल नर्सिंग होम , 78)', 'Renuka Maternity & Ent Hospital , 120 (रेणुका मॅटर्निटी अँड एंटी हॉस्पिटल , 120)'].indexOf(option.text) > -1)
                                    option.style.display = 'block'

                            }
                            if (text == 'Zone No.2 - Dharmpeth (धरमपेठ)') {
                                if (['Sengupta Hospital & Research Institute , 3 (सेनगुप्ता हॉस्पिटल अँड रिसर्च इन्स्टिट्यूट , 3)', 'Sanjeevan Maternity & Nursing Home , 42 (संजीवन मॅटर्निटी आणि नर्सिंग होम, 42)', 'Maher Maternity & Nursing Home , 45 (माहेर मॅटर्निटी आणि नर्सिंग होम , 45)'].indexOf(option.text) > -1)
                                    option.style.display = 'block'
                            }
                            if (text == 'Zone No.3 - Hanuman Nagar (वंदनीय राष्ट्रसंत तुकडोजी महाराज)') {
                                if (['Bansod Hospital , 31 (बनसोड हॉस्पिटल , 31)', 'Asha Bhawan Nursing Home , 54 (आशा भवन नर्सिंग होम, 54)', 'Naik Hospital ,8 (नाईक हॉस्पिटल,8)'].indexOf(option.text) > -1)
                                    option.style.display = 'block'
                            }
                            if (text == 'Zone No.4 - Dhantoli (धंतोली)') {
                                if (['Jasleen Hospital , 2 (जसलीन हॉस्पिटल , 2)', 'Ketkar Nursing Home , 23 (केतकर नर्सिंग होम Home , 23)', 'Navjeevan Nursing Home , 29 (नवजीवन नर्सिंग होम, 29)'].indexOf(option.text) > -1)
                                    option.style.display = 'block'
                            }
                            if (text == 'Zone No.5 - Nehru Nagar (नेहरू नगर श्रेत्रिय कार्यालय)') {
                                if (['Ashish Eye Hospital , 105 (आशिष आय हॉस्पिटल , 105)', 'Kurvey Nursing Home , 147 (कुर्वे नर्सिंग होम , 147)', 'S. D. Hospital , 193 (एस.डी. हॉस्पिटल , 193)'].indexOf(option.text) > -1)
                                    option.style.display = 'block'
                            }
                            if (text == 'Zone No.6 - Gandhi Zone Mahal (गांधी झोन ​​महाल)') {
                                if (['Saoji Hospital , 26 (साओजी हॉस्पिटल , 26)', 'Rahimi Nursing Home , 33 (रहीमी नर्सिंग होम,33)', 'Saboo Hospital , 82 (साबू हॉस्पिटल , 82)'].indexOf(option.text) > -1)
                                    option.style.display = 'block'
                            }
                            if (text == 'Zone No.7 - Satranjipura (सतरंजीपुरा)') {
                                if (['Taj Nursing Home , 65 (ताज नर्सिंग होम , 65)', 'Central Hospital , 495 (सेंट्रल हॉस्पिटल , 495)', 'Crystal Nursing Home , 1023 (क्रिस्टल नर्सिंग होम , 1023)'].indexOf(option.text) > -1)
                                    option.style.display = 'block'
                            }
                            if (text == 'Zone No.8 - Lakadganj (लकडगंज)') {
                                if (['Ridhorkar Hospital , 30 (रिधोरकर हॉस्पिटल , 30)', 'Thakkar Nursing Home , 178 (ठक्कर नर्सिंग होम, 178)', 'Arjun Hospital , 194 (अर्जुन हॉस्पिटल , 194)'].indexOf(option.text) > -1)
                                    option.style.display = 'block'
                            }
                            if (text == 'Zone No.9 - Aashi Nagar (आशी नगर)') {
                                if (['Zaveri Nursing Home , 15 (झवेरी नर्सिंग होम , 15)','Ansari Maternity & Nursing Home , 114 (अन्सारी मॅटर्निटी अँड नर्सिंग होम , 114)', 'Khobragade Multispeciality Hospital , 124 (खोब्रागडे मल्टीस्पेशालिटी हॉस्पिटल , 124)'].indexOf(option.text) > -1)
                                    option.style.display = 'block'
                            }
                            if (text == 'Zone No.10 - Mangalwari (मंगळवारी)') {
                                if (['Naidu Hospital , 39 (नायडू हॉस्पिटल , 39)', 'Punshi Hospital , 58 (पुंशी हॉस्पिटल, 58)', 'Janta Maternity Home & Hospital , 91 (जनता मॅटर्निटी होम आणि हॉस्पिटल , 91)'].indexOf(option.text) > -1)
                                    option.style.display = 'block'
                            }
                        }
                    }

                }
                        
                
                </script>
                
                <div class="col-md-3">

                    <div class="mb-30" style="margin-top: 53px">

                        <label for="" class="form-label ">Reason of Death (मृत्यूचे कारण)</label>

                        <input type="text" class="form-control" style="background-image: none;" id="deathReason" placeholder="" name="reasonOfDeath" value=""
                           oninput="validateTextarea1()">
                            <div class="invalid-feedback" id="errorFeedback">
                                Please Enter Valid Reason of Death.
                            </div>
                                           <script>
function validateTextarea1() {
  const textarea = document.getElementById('deathReason');
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
</script> </div>
         
                         
                </div>



                <div class="col-md-3">
                    <div class="mb-2 mt-3 ">
                        <label for="" class=" form-label "> Death Type (मृत्यू प्रकार)<span class=" text-danger" style="color: red;">
                        *</span></label>
                       
                        <div class="d-flex mt-2 border rounded  p-2">
                            <div class="form-check ms-3">
                                <input type="radio" class="form-check-input" id="radio5" name="deathType" value="Natural"
                                    required>
                                <label class="form-check-label " for="radio1">Natural (नैसर्गिक)</label>
                               </div>

                            <div class="form-check ms-3">
                                <input type="radio" class="form-check-input" id="radio6" name="deathType" value="Accidental"
                                    required>

                                <label class="form-check-label " for="radio1">Accidental (अपघाती)</label>
                               
                                <div class="invalid-feedback ">
                                        Please Select Valid Death Type.
                                    </div>  

                            </div>
                        </div>
                    </div>
                </div>
                
                <!-- Body Donated -->
                  <div class="col-md-3">
                    <div class="mb-2 mt-3 ">
                        <label for="" class=" form-label "> Is body Donated? (शरीर दान केले आहे का?)<span class=" text-danger" style="color: red;">
                        *</span></label>
                       
                        <div class="d-flex mt-2 border rounded  p-2">
                            <div class="form-check ms-3">
                                <input type="radio" class="form-check-input" id="radio5" name="bodyDonated" value="Yes"
                                    required>
                                <label class="form-check-label " for="radio1">Yes (होय)</label>
                               </div>

                            <div class="form-check ms-3">
                                <input type="radio" class="form-check-input" id="radio6" name="bodyDonated" value="No"
                                    required>

                                <label class="form-check-label " for="radio1">No (नाही)</label>
                               
                                <div class="invalid-feedback ">
                                        Please Select Valid Option.
                                    </div>  

                            </div>
                        </div>
                    </div>
                </div>
<div class="col-md-6 deathHomeAddress">

                    <div class="mb-30" style="margin-top: 30px">

                        <label for="" class="form-label "> Detail Address Of Death Place (मृत्यूच्या ठिकाणाचा तपशीलवार पत्ता)<span class="text-danger" 
                                style="color: red;" style="color: red;">*</span></label>

                        <textarea type="text" class="form-control" style="background-image: none;" id="Address2" placeholder="" name="deathHomeAddress" value="" rows="2"
                           oninput="validateTextarea2()" required></textarea>
                            <div class="invalid-feedback " id="errorFeedback">
                                Please Enter Valid Detail Address Of Death Place.
                            </div>
                            </div>
                            </div>
                <div class="col-md-12 mb-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label ">Reason For Certificate (प्रमाणपत्राचे कारण)</label>
                               
                        <textarea class="form-control" style="background-image: none;" id="reason" placeholder="" name="reasonForCertificate" rows="2"></textarea>
                            <div class="invalid-feedback">
                                Please Enter Valid Reason For Certificate.
                            </div>
                                    </div>                      <script>
            const textarea = document.getElementById('reason');
            textarea.addEventListener('input', function() {
                const firstChar = this.value.charAt(0);
                if (firstChar === ' ') {
                    this.classList.add('is-invalid');
                } else {
                    this.classList.remove('is-invalid');
                }
            });
        </script>

               <script>
            const textarea = document.getElementById('Address2');
            textarea.addEventListener('input', function() {
                const firstChar = this.value.charAt(0);
                if (firstChar === ' ') {
                    this.classList.add('is-invalid');
                } else {
                    this.classList.remove('is-invalid');
                }
            });
        </script>     
                </div>
                <div class="mb-4 mt-3">
    <label for="" class="form-label ">Certificates And Fees Details (प्रमाणपत्रे आणि फी तपशील)<span class="text-danger"
            style="color: red;">*</span></label>
<div class=" d-flex mt-2 border rounded p-2" style="height: 180px;">
            <div class="col- mb-3 ms-4">
                <div class="mb-3" style="margin-top: 64px;">



<label for="" class="form-label">Certificate Expected in Days (दिवसात प्रमाणपत्र अपेक्षित आहे)<span
                            class="text-danger" style="color: red;">*</span> </label>
                    <label class="form-check-label" for="">
                    </label><br>
                    <input class="form-check-input" type="radio" value="1" id="same" name="certificateExpectedInDays"
                    onclick="checkSelectitem(id)" required>

                    <label class="form-check-label" for="checkbox">
                        Same Day (त्याच दिवशी)
                    </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input class="form-check-input" type="radio" value="2" id="other" name="certificateExpectedInDays"
                        onclick="checkSelectitem1(id)" required>
                        <div class="invalid-feedback">
                            Please Select One Option
                        </div>
                    <label class="form-check-label" for="checkbox">
                        Till Third Day (तिसऱ्या दिवसापर्यंत)
                    </label>
                </div>
            </div>


            <script>
            function multiplyBy()
            {
            	  const noofcopies = document.getElementById('number');
                  noofcopies.addEventListener('input', function() {
                      const firstChar = this.value.charAt(0);
                      if (firstChar === '0' || firstChar === '-') {
                          document.getElementById('number').value='';
                          this.classList.add('is-invalid');
                      } else {
                          this.classList.remove('is-invalid');
                      }
                  });
              
                var same1=$("#same").prop('checked');
                var other1=$("#other").prop('checked');
                console.log(same1)
                if(same1==true)
                {
                    console.log("lll")
                    $("#fees").val($("#number").val()*100)
                }
                    
                else
                    $("#fees").val($("#number").val()*20)
            }
            function checkSelectitem()
            {
                document.getElementById("number").removeAttribute('readonly');
                $("#fees").val($("#number").val()*100)
            }
            function checkSelectitem1()
            {
                document.getElementById("number").removeAttribute('readonly');
                $("#fees").val($("#number").val()*20)
            }
            
                
            </script>
            
								<div class="col-md-3 mb-3 ms-4">
									<div class="mb-3 ms-3" style="margin-top: 27px;">
										<label for="" class="form-label">No. Of Certificate
											Copies (प्रमाणपत्राच्या प्रतींची संख्या)<span
											class="text-danger" style="color: red;">*</span>
										</label> <input type="text" class="form-control"
											style="background-image: none;" id="number"
											placeholder="Enter Number of Certificate Copies"
											name="noOfCertificateCopies" onchange="validateZero()"
											rows="4"
											oninput="multiplyBy(this.form); 
                       this.value = this.value.replace(/[^0-9]/g, '')"
											;
                        readonly maxlength="2" required></input>
										<div class="invalid-feedback" id="zero-error">Please
											Enter Valid No. of Certificate Copies.</div>
									</div>
									<script>
								
								function validateZero() {
									  const textzero= document.getElementById('number');
									  const errorFeedback = document.getElementById('zero-error');
									  const text = textzero.value;

									 

									  if (textzero.value ==='0') {
				                          document.getElementById('number').value='';
										  textzero.classList.add('is-invalid');
									    errorFeedback.style.display = 'block';
									  } else {
										  textzero.classList.remove('is-invalid');
									    errorFeedback.style.display = 'none';
									  }
									}
								
								</script>
								</div>
								<div class="col-md-4 mb-3 ms-5">
									<div class="mb-3 mt-1">
										<label for="" class="form-label">Fees Applicable (Auto
											calculate as per the basis on Days and No. of Copies) (फी
											लागू (स्वयंचलित नुसार गणना करा दिवस आणि प्रतींच्या संख्येवर
											आधारित))<span class="text-danger" style="color: red;">*</span>
										</label> <input type="number" class="form-control"
											style="background-image: none;" id="fees" placeholder=""
											name="feesApplicable" rows="4" readonly required></input>

									</div>
								</div>
							</div>
						</div>
					</div>
                

             <input type="hidden" name="filesPath" id="filesPath" />	

        <div class="row">

            <h6 class="mt-4"><strong class="form-label "> List Of Documents (with attachment)(कागदपत्रांची यादी (संलग्नकांसह)) </strong></h6>

            <div class="alert alert-info mb-0 p-2 mb-4 ms-2">
                <small class="form-label "><strong class="form-label ">Note(नोंद): </strong> Upload below files in .pdf(Max upto 2 MB)(खालील फाइल .pdf मध्ये अपलोड करा (कमाल २ MB पर्यंत))</small>
                
            </div>
            </div>
                    <div class="row">
            

            <div class="col-md-3 hospitalCertificate">
                <div class="mb-3 mt-5">
                    <label for="" class="form-label ">Hospital Certificate (रुग्णालयाचे प्रमाणपत्र)<span class="text-danger" 
                            style="color: red;">*</span> </label>
                       
                    <input type="file" accept=".pdf" class="form-control" style="background-image: none;" id="hospital_certificate" placeholder=""
                         name="hospitalFilePdf"
                        required>
                        <div class="invalid-feedback ">
                            File selected is either greater than 2Mb or not of type .pdf.
                        </div>
                        
                </div>
            </div>


          <div class="col-md-3">
                <div class="mb-3 mt-0">
                    <label for="" class="form-label ">Deceased ID Proof (Aadhar/PAN/Voting Card/T.C./etc)(मृत व्यक्तीचा ओळखपत्र पुरावा (आधार/पॅन/मतदान कार्ड/टी.सी./इ.))<span
                            class="text-danger"  style="color: red;">*</span> </label>

                    <input type="file" accept=".pdf" class="form-control" style="background-image: none;" id="deceased_id"
                        placeholder=""
                        name="deceasedIdProofPdf" required>
                        <div class="invalid-feedback ">
                            File selected is either greater than 2Mb or not of type .pdf.
                        </div>
                        
                </div>
            </div>

            <div class="col-md-3">
                <div class="mb-3 mt-0">
                    <label for="" class="form-label "> Applicant's ID Proof (Aadhar/PAN/Voting Card/T.C./etc) (अर्जदाराचा ओळखपत्र पुरावा (आधार/पॅन/मतदान कार्ड/टी.सी./इ.))<span
                            class="text-danger"  style="color: red;">*</span> </label>


                    <input type="file" accept=".pdf" class="form-control" style="background-image: none;" id="applicant_id" placeholder=""
                        name="applicantIdPdf"
                        required>
                        <div class="invalid-feedback ">
                            File selected is either greater than 2Mb or not of type .pdf.
                        </div>
                       
                </div>
            </div>

            <div class="col-md-3 crematoriums_certificate">
                <div class="mb-3 mt-5">
                    <label for="" class="form-label crematoriums_certificate">Crematorium Certificate (स्मशानभूमीचे प्रमाणपत्र)<span class="text-danger" 
                            style="color: red;">*</span> </label>
                            
                    <input type="file" accept=".pdf" class="form-control" style="background-image: none;" id="crematoriums_certificate" placeholder=""
                         name="cermationFilePdf"
                        required>
                        <div class="invalid-feedback ">
                            File selected is either greater than 2Mb or not of type .pdf.
                        </div>
                        
                </div>
            </div>
            <div class="col-md-3 bodyDonate_certificate">
                <div class="mb-3 mt-5">
                    <label for="" class="form-label ">Body Donate Certificate (शरीर दान प्रमाणपत्र)<span class="text-danger" 
                            style="color: red;">*</span> </label>
                            
                    <input type="file" accept=".pdf" class="form-control" style="background-image: none;" id="bodyDonate_certificate" placeholder=""
                         name="bodyDonatePdf"
                        required>
                        <div class="invalid-feedback ">
                            File selected is either greater than 2Mb or not of type .pdf.
                        </div>
                        
                </div>
            </div>
        <div class="col-md-3" id="doc_1">
            <div class="mb-3 mt-4">
                <label for="" class="form-label ">Certificate issued by Correspondent<br>(ward/Aasha member)(बातमीदाराने जारी केलेले प्रमाणपत्र(प्रभाग/आशा सदस्य))</label>
                
</label>
                <input type="file" accept=".pdf" class="form-control" style="background-image: none;" id="correspondent_certificate" placeholder=""
                     name="certiCorrespondentPdf">

            </div>
        </div>
        </div>
        <div class="col-md-12">
            <div class="mb-3 mt-4">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="check1" name="declaration" value="something"
                        required>

                    <label class="form-check-label mt-0 ms-2 " style="margin-top: -15px;">
                        <strong>Declaration (घोषणा)<span class="text-danger" style="color: red;">*</span>:- </strong>I hereby declare that , all the information provided by me in
                        the above application is true. If it found wrong or not related ,
                        I permit to reject the application.(मी याद्वारे घोषित करतो की, माझ्याद्वारे प्रदान केलेली सर्व माहिती
                        वरील अर्ज खरा आहे. जर ते चुकीचे आढळले किंवा संबंधित नाही,
                        मी अर्ज नाकारण्याची परवानगी देतो.)<br>
                    </label>
                   
                    <div class="invalid-feedback ">
                Please check the declaration.
            </div>
           
                </div>
            </div>
        </div>
        <div class="col-md-12 text-start mb-5 ">
				<div class="text-center">
					<button type="button" class="btn btn-danger btn_sm printMe">
						 View and Print
                        
					</button>
					<button class="btn btn-success btn_sm" type="submit" id="submit">Submit</button>
				</div>
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
    // Get the current date
    var currentDate = new Date().toISOString().split("T")[0];

    // Set the maximum attribute of the input field
    document.getElementById("dob").setAttribute("max", currentDate);
    
  
</script>
         

        
        
       <script>

       $('input[type=radio][name=yes]').change(function () {
    		if (this.value == '1') {
    			
    		  
    		    
    		}  else if (this.value == '2') {
    		   
    		    $("#Address").prop('required',true);
    		   

    		}
    		});
       
  

       
       $(".deathHomeAddress").hide();
       $(".hospitalCertificate").hide();
      
        $(".hospital_row").hide();
        $("#doc_1").hide();

        $('input[type=radio][name=placeOfDeath]').change(function () {
            if (this.value == '1') {
                $(".deathHomeAddress").show();
                $(".hospitalCertificate").hide();
                $("#hospital_certificate").prop('required',false);
                $("#Address2").prop('required',true);
                $("#iOperation").prop('required',false);
                $(".hospital_row").hide();
                $("#doc_1").show();

            } else if (this.value == '2') {
                $(".deathHomeAddress").hide();
                $(".hospitalCertificate").show();
                $("#Address2").prop('required',false);
                $(".hospital_row").show();
                $("#iOperation").prop('required',true);
                $("#hospital_certificate").prop('required',true);
                $("#doc_1").hide();

            }
            
        });


        $(".post_mortem").hide();
        $('input[type=radio][name=dt]').change(function () {
            if (this.value == '3') {

                $(".post_mortem").hide();
            } else if (this.value == '4') {

                $(".post_mortem").show();
            }
        });
        

    </script>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>



</body>


			</form>
		</div>                                                                     
		<script>                    
			var strArray = document.getElementsByTagName('textarea');
			if(strArray){             
				for(i=0;i<strArray.length;i++){
					strArray[i].value = Trim(strArray[i].value);
			}
		}
		</script>
		
			<script type="text/javascript">
				if(parent.document.getElementById('divPopup'))
				{
					parent.hideDiv();
					parent.document.location.href="<c:out value='${contextRoot}'/>/login.do";
				}
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
                      isUploadInProgress = true;
                      upload(function(status) {
                      
                          if (status === true || status === 'true') {
                              $("#submit").attr("disabled", true);
                              onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/saveDeathCertificate.do');
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

           data.append('idProof1', $("#hospital_certificate").get(0).files[0]);
   		data.append('idProof2', $("#deceased_id").get(0).files[0]);
   		data.append('idProof3', $("#applicant_id").get(0).files[0]);
   		data.append('idProof4', $("#crematoriums_certificate").get(0).files[0]);
   		
   		data.append('idProof5', $("#bodyDonate_certificate").get(0).files[0]);
   		data.append('idProof6', $("#correspondent_certificate").get(0).files[0]);






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
                   filesPath = filesPath + basePath + "deathCertificates/" + id + value + ","
                   isFileSelected = true;
               }
           }
           var a = filesPath.substring(0, filesPath.lastIndexOf(","));
           filesPath = filesPath.replace(/\s/g, "");
           $("#filesPath").val(filesPath);
           console.log(filesPath);

           $.ajax({
                url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadDocumentDeath.do?id="+id,
               type: 'POST',
               data: data,
               cache: false,
               dataType: 'json',
               processData: false,
               contentType: false,
               async: false, // Set to synchronous
               success: function(data) {
                   var status = data.status;
                   if (callback && typeof callback === 'function' && status==true) {
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

          
       }
   </script>


   
   
  
		
	</body>
	<script>
function callHospitalList() {
    const zoneId = document.getElementById('iFunction').value;
    $.ajax({
        url: "<c:out value='${contextRoot}'/>/mobileapp/getCitizenHospitalList/" + zoneId,
        type: 'GET',
        cache: false,
        dataType: 'json',
        success: function(data) {
            populateDropdown(data.hospitalName);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.error("AJAX Error:", textStatus, errorThrown);
        }
    });
}

function populateDropdown(data) {
    document.getElementById("iOperation").removeAttribute('disabled');
    const dropdown = document.getElementById('iOperation');

    dropdown.innerHTML = ''; 
    const selectOption = document.createElement('option');
    selectOption.value = '';
    selectOption.text = '-Select Hospital-'; 
    dropdown.appendChild(selectOption);

    for (let i = 0; i < data.length; i++) {
        const hospitalName = data[i].hospitals_name;

        const option = document.createElement('option');
        option.value = hospitalName;
        option.text = hospitalName;
        dropdown.appendChild(option);
    }
}


    </script>
    <script>
$(".bodyDonate_certificate").hide();
$(".crematoriums_certificate").hide();

 $('input[type=radio][name=bodyDonated]').change(function () {
                if (this.value == 'Yes') {
                    $(".bodyDonate_certificate").show();
                    $(".crematoriums_certificate").hide();

                    $("#crematoriums_certificate").prop('required',false);
                    $("#bodyDonate_certificate").prop('required',true);
                   
                } else if (this.value == 'No') {
                	  $(".crematoriums_certificate").show();
                	  $(".bodyDonate_certificate").hide();

                      $("#crematoriums_certificate").prop('required',true);
                      $("#bodyDonate_certificate").prop('required',false);
                }
        });

</script>
</html>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file="/pages/common/include.jsp" />


<html lang="en">
<head>
  <meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Toilet Cleaning System</title>
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
<script>
  document.addEventListener("DOMContentLoaded", function() {
    const today = new Date();
    const formattedDate = today.toISOString().split('T')[0]; // yyyy-mm-dd
    document.getElementById("currentDate").value = formattedDate;
  });
</script>

  <!-- Custom CSS -->
  <style>
  @import url('https://fonts.googleapis.com/css2?family=Google+Sans&display=swap');
   
    body {
      background-color: #f8f9fa;
      font-family: Google Sans, sans-serif !important; 
    }

.star {
        cursor: pointer;
        font-size: 24px; /* Increase the size of stars */
        color: black; /* Default color */
    }
    .filled {
        color: gold; /* Filled star color */
    }
    .error-message {
        color: red;
    }
    .container-fluid {
    position: relative;
    z-index: 2;
    padding-top: 10px;
    padding-bottom: 10px;
    box-sizing: border-box; 
}
body {
    margin: 0;
    padding: 0;
    background-image: url('/Garden/images/garden_background.jpg');
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    height: 100%;
    position: relative; /* Ensure the body acts as the positioning context for absolutely positioned elements */
}

body::before {
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
background: linear-gradient(rgba(0, 0, 0, 0.85), rgba(0, 0, 0, 0.85));
    z-index: 2; /* Ensure the overlay is below the content */
}
  .image-container img {

    width: 1000px;
    height: 400px; /* Adjust the height as needed */
    border-radius: 10px;
    box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
}

    .form-control[readonly] {
      background-color: #f8f5f5;
    }
    .form-container {
      background-color: #f8f9fa;
      border-radius: 10px;
      padding: 20px;
      box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
    margin-top: 5px;
        }
    .form-container h2 {
        
      color: #333;
      text-align: center;
      margin-bottom: 20px;
      text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
      font-family: initial;

    }
    .form-group label {
      font-weight: bold;
      color: darkcyan;
      text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.1);
      font-family: initial;

    }
    .form-control {

      border-radius: 5px;
      border: 1px solid #f8f5f5;
      box-shadow: inset 1px 1px 2px rgba(0, 0, 0, 0.1);
    }
    .btn-primary {
      
  background-color: black;
  border: none;
  border-radius: 5px;
  margin-top: 20px;
 
  marker-mid: revert-layer;
    }
    .btn-primary:hover {
      background-color: #0056b3;
    }
    
    .cropped-image {
    max-width: 100%; /* Set maximum width to 100% of the container */
    height: auto; /* Allow the height to adjust automatically */
    object-fit: cover; /* Crop the image to cover the container while maintaining aspect ratio */
}
.flex-container {
    display: flex;
    
}

@media only screen and (min-width: 768px) {

.image-container img {
    width: 1000px;
    /* height: 559px; */
    border-radius: 10px;
    box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
    margin-top: 25%;
}
}

@media only screen and (max-width: 600px) {
  .custom-switch .custom-control-label::after {
    top: calc(0.25rem + 2px);
    left: calc(-2.25rem + 7px);
    width: calc(1rem - 4px);
    height: calc(1rem - 4px);
    background-color: #adb5bd;
    border-radius: 0.5rem;
    transition: background-color .15s ease-in-out, border-color .15s ease-in-out, box-shadow .15s ease-in-out, -webkit-transform .15s ease-in-out;
    transition: transform .15s ease-in-out, background-color .15s ease-in-out, border-color .15s ease-in-out, box-shadow .15s ease-in-out;
    transition: transform .15s ease-in-out, background-color .15s ease-in-out, border-color .15s ease-in-out, box-shadow .15s ease-in-out, -webkit-transform .15s ease-in-out;
}
 .custom-switch .custom-control-label::before {
    left: -34px;
    width: 35px;
    pointer-events: all;
    border-radius: 0.6rem;
    height: 20px;
    top: 2px;
    
}


}
.flex-container {
    display: flex;
    align-items: center; /* Align items vertically */
}

.flex-item {
    margin-right: 10px; /* Adjust spacing between label and switch */
}

.custom-switch {
    flex-grow: 1; /* Allow switch button to grow and fill available space */
    text-align: right; /* Align switch button to the right */
}

  </style>
  <style>
  #overlay {
    position: fixed;
    top: 0;
    z-index: 1200;
    width: 100%;
    height: 100%;
    display: none;
    background: rgba(0, 0, 0, 0.6); /* Semi-transparent black background */
}

.cv-spinner {
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
}

.spinner {
    width: 30px;
    height: 30px;
    border: 8px solid #ddd;
    border-top: 8px solid #2e93e6;
    border-radius: 50%;
    animation: sp-anime 0.8s infinite linear;
}



@keyframes sp-anime {
    100% { 
        transform: rotate(360deg); /* Full rotation of the spinner */
    }
}
  
  </style>
<style>
  .image-container {
    position: relative;
    width: 100%;
  }

  .cropped-image {
    width: 100%;
    height: auto;
    display: block;
  }

  .overlay-text {
    position: absolute;
    bottom: 0;
    background: rgba(0, 0, 0, 0.6);
    color: white;
    width: 100%;
    padding: 10px;
    font-size: 16px;
    font-weight: 500;
  }
</style>

<script>
  document.addEventListener("DOMContentLoaded", function () {
    const zoneDropdown = document.getElementById("zoneName");
    const dateInput = document.getElementById("currentDate");
    const longitudeInput = document.getElementById("longitude");
    const latitudeInput = document.getElementById("latitude");

    function updateOverlay() {
      document.getElementById("selectedZone").textContent = "Zone: " + (zoneDropdown.value || "None");
      document.getElementById("selectedDate").textContent = "Date Of Cleaning: " + (dateInput.value || "None");
      document.getElementById("selectedLongitude").textContent = "Longitude: " + (longitudeInput.value || "None");
      document.getElementById("selectedLatitude").textContent = "Latitude: " + (latitudeInput.value || "None");
    }

    zoneDropdown.addEventListener("change", updateOverlay);
    longitudeInput.addEventListener("input", updateOverlay);
    latitudeInput.addEventListener("input", updateOverlay);

    const today = new Date().toISOString().split("T")[0];
    dateInput.value = today;
    updateOverlay();
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
				<h6> <strong>Note : </strong> Upload listed files only .jpg, .jpeg, .png(Max upto 5 MB)</h6>				
			</div>

			<!-- dialog body -->
			<div class="modal-body" style="color: green">

				<p style="color: red">
					<strong>List of documents to be attached :</strong>
				</p>

				<ul style="color: rgb(3, 125, 76)">
					<li>1.Photo Before Cleaning</li>
					<li>2.Photo During Cleaning</li>
				</ul>

			</div>

			<!-- dialog buttons -->

			<div class="modal-footer">
				<button type="button" class="btn btn-primary">OK</button>
			</div>
		</div>

	</div>

</div>
</head>
<body>

	<form class="needs-validation" novalidate>
 <div id="overlay">
        <div class="cv-spinner">
            <span class="spinner"></span>
        </div>
    </div>
<div class="container-fluid">
 <div class="row justify-content-center">
     <div class="col-md-6">
      <div class="image-container">
<img src="<c:out value="${contextRoot}"/>/images/ToiletCleaning.jpg" class="img-fluid cropped-image" alt="Toilet Image">
<div class="overlay-text" id="overlayText">
<label>Location :</label>
    <div id="selectedZone"> Zone: None</div>
    <div id="selectedDate">Date Of Cleaning: None</div>
    <div id="selectedLongitude">Longitude: None</div>
    <div id="selectedLatitude">Latitude: None</div>
  </div>
      </div>
    </div>
    <div class="col-md-6">
      <div class="form-container">
        <div>
        <h2>Application Form For Toilet Cleaning System
        </h2>
        </div>
        <hr>
        <!-- Zone Dropdown -->
         <div class="form-group">
            <label>Zone Name<span class="text-danger" style="color: red;">*</span></label>
			<select class="form-select" name="zoneName" id="zoneName" style="background-image: none" required>
  				<option value="">-Select Zone-</option>
				<option value="Zone No.1 - Laxmi Nagar">Zone No.1 - Laxmi Nagar (लक्ष्मी नगर)</option>
				<option value="Zone No.2 - Dharmpeth">Zone No.2 - Dharmpeth (धरमपेठ)</option>
				<option value="Zone No.3 - Hanuman Nagar">Zone No.3 - Hanuman Nagar (हनुमान नगर)</option>
				<option value="Zone No.4 - Dhantoli">Zone No.4 - Dhantoli (धंतोली)</option>
				<option value="Zone No.5 - Nehru Nagar">Zone No.5 - Nehru Nagar (नेहरू नगर)</option>
				<option value="Zone No.6 - Gandhi Zone Mahal">Zone No.6 - Gandhi Zone Mahal (गांधी झोन ​​महाल)</option>
				<option value="Zone No.7 - Satranjipura">Zone No.7 - Satranjipura (सतरंजीपुरा)</option>
				<option value="Zone No.8 - Lakadganj">Zone No.8 - Lakadganj (लकडगंज)</option>
				<option value="Zone No.9 - Aashi Nagar">Zone No.9 - Aashi Nagar (आशी नगर)</option>
				<option value="Zone No.10 - Mangalwari">Zone No.10 - Mangalwari (मंगळवारी)</option>
			</select>
			<div class="invalid-feedback">Please select a valid zone.</div>
		</div>

<!-- Unit Dropdown -->
        <div class="form-group">
            <label>Blocks Number Units<span class="text-danger" style="color: red;">*</span></label>
      		<select class="form-select"  id="blockUnit" name="blockUnit" style="background-image: none" required>
  			<option value="">-Select Unit-</option>
		   </select>
		   <div class="invalid-feedback">Please select a valid block number units.</div>
		 </div>

<!-- Block Number Dropdown -->
 	<div class="form-group">
         <label>Block Number<span class="text-danger" style="color: red;">*</span></label>           
		<select class="form-select" id="blockNo" name="blockNo" style="background-image: none" required>
  		<option value="">-Select Block Number-</option>
		</select>
		<div class="invalid-feedback">Please select a valid block number units.</div>
	</div>
<script>
  const zoneData = {
    "Zone No.1 - Laxmi Nagar": {
        "New Zone Office": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
        "Laxminagar Zone Office": ["25", "26", "27", "28", "29", "30", "31", "32", "33"],
        "MANEWADA GHAT": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
        "SIDHESHWARI": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
        "JANKI NAGAR NMC SCHOOL": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
        "LUVKUSH NAGAR": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
        "NARENDRA NAGAR FIRE STATION": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
        "SHANKAR NAGAR HOSPITAL": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
        "SAHAKAR NAGAR GHAT": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
        "SAWARKAR GARDEN NEAR BJP OFFICE": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
        "VIVEKANAND NMC SCHOOL": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
        "INDORE STADIUM SAI MANDIR, WARDHA ROAD": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
        "ABHYANKAR NAGAR GARDEN": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
        "SHANKAR NAGAR GARDEN": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
        "AMBAZARI GHAT": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
        "EKATMATA NAGAR": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"]
      },
  "Zone No.2 - Dharmpeth": {
      "MORE MEMORIAL HOSPIAL SAMOR": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
      "TRAFFIC GARDEN": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
      "TILAK NAGAR": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
      "AAMDAR NIWAS": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
      "DHARMPETH ZONE 2": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
      "ZONE 2 OUTSIDE": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
      "SHIVAJI GARDEN": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
      "SUDAM NAGRI": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
      "FUTALA": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
      "ASHA BALWADI HAJARIPAHAD": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
      "AIRFORCE NEAR WALL": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
      "FREINDS COLONY": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
      "KOLPURA": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
      "GITTIKHADAN CHOWK": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
      "GANDHI PANTHELA NEAR KOLPURA": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
      "RAMGIRI BASTI": ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
      
      "GITTIKHADAN MARATHI PRATHMIK SCHOOL": ["271"],
      "MAKARDOKARA HINDI UCCHA PRATHMIK SCHOOL": ["272"],
      "HAJARIPAHAD MARATHI UCCHA PRATHMIK SCHOOL": ["273"],
      "SHIVAJI NAGAR DABHA": ["274"],
      "DABHA UCCHA PRATHMIK SCHOOL": ["275"],
      "PRIYADARSHANI UCCHA PRATHMIK SCHOOL": ["276"],
      "VALMIKI NAGAR HINDI MADHYAMIK SCHOOL": ["277"],
      "GANDHI NAGAR HINDI PRATHMIK SCHOOL": ["278"],
      "DADAJI DHUNIWALE UCCHA PRATHMIK SCHOOL": ["279"],
      "BORGAON HINDI UCCHA PRATHMIK SCHOOL": ["280"],
      "POLICE LINE TAKRI MARATHI PRATHMIK SCHOOL": ["281"],
      "R.B.G.G. HINDI PRATHMIK SCHOOL": ["282"],
      "UPPALWADI": ["286"],
      "GARIB NAWAB URDU HIGHER PRIMARY & SECONDARY SCHOOL": ["287"],
      "G.M. BANATWALA URDU SCHOOL": ["288"],
      "AZAD URDU SCHOOL": ["289"],
      "M.A.K. URDU SCHOOL": ["290"]
    },
  "Zone No.3 - Hanuman Nagar": {
	  "TAX OFFICE CHANDAN NAGAR": ["44"],
	    "HANUMAN NAGAR ZONE OFFICE": ["45"],
	    "DURGA NAGAR SCHOOL": ["46"],
	    "LAL BAHADUR SHASTRI SCHOOL": ["48"],
	    "HANUMAN NAGAR GARDEN": ["48"],
	    "BAIDYANATH WORK SHOP": ["49"],
	    "CAPLA BASTI": ["50"],
	    "IMAMWADA POLICE STATION": ["51"],
	    "GUJARWADI": ["52"],
	    "KUNDANLAL VACHNALAY": ["53"],
	    "INDIRA NAGAR COLONY": ["54"],
	    "WORKER BUILDING URINAL": ["56"],
	    "WORKER BUILDING": ["56"],
	    "CHANA TOLI": ["57"],
	    "NATIONAL ZENDA": ["60"],
	    "PATJAL CHIKU": ["60"],
	    "DAWKI MOHALLA": ["60"],
	    "BANVAIK BUILDING": ["63"],
	    "VINOD TAYWADE CHYA GHARA JAWAL": ["63"],
	    "JAYANTI MAIDAN": ["63"]
  },
  "Zone No.4 - Dhantoli": {
	  "TAKIYA DHOBI LINE": ["69"],
	    "MORBHAVAN BUS STOP": ["70"],
	    "NAVIBASTI PACHMADI CHOWK": ["71"],
	    "MUTTON MARKET GADDIGODAM": ["72"],
	    "PRAJAPATI BOUDHVIHAR": ["73"],
	    "RAINBASERA MOHAN NAGAR": ["74"],
	    "BHOLA PAN MANDIR COTTON MARKET": ["75"],
	    "KALPANA WINW SHOP COTTON MARKET": ["76"],
	    "OM SAI KRUPA PAN PALACE COTTON MARKET": ["66"],
	    "SATYAM SALES CORPORATION COTTON MARKET": ["77"],
	    "GURUNANAK KIRANA COTTON MARKET": ["78"],
	    "NARAYAN EGG COTTON MARKET": ["79"],
	    "NATHANI COOLER COTTON MARKET": ["80"],
	    "SEHAGAL ELECTRICS COTTON MARKET": ["81"],
	    "EDUCATION TEACHING CENTER": ["82"],
	    "AAPALE ELECTRIC COTTON MARKET": ["83"],
	    "OPPOSITE ATIKRAMAN OFFICE HALL": ["84"],
	    "REHDATI SECTION COTTON MARKET": ["85"],
	    "NEW GANDHIBAGH ZONE OFFICE": ["91"],
	    "MANGPURA BOUDHA VIHAR": ["88"],
	    "NEAR ZANZOTE HOUSE MANGPURA": ["92"],
	    "MODEL MILL CHAL": ["93"],
	    "GEETA MANDIR": ["94"],
	    "MOKSHDHAM GHAT": ["95"],
	    "MOKSHDHAM GHAT NEAR SHIVAJI MANDIR": ["96"],
	    "DHANTOLI ZONE OFFICE 4": ["97"],
	    "LOHAPUL SHANI MANDIR": ["98"],
	    "RBI CHOWK": ["99"],
	    "TEMPLE BAZAR BABAN POPKIN": ["100"],
	    "SUJATA LODGE TEMPLE MARKET": ["101"],
	    "APNA TEMPLE BAZAR": ["102"],
	    "TEMPLE BAZAR MUTTON MARKET": ["103"],
	    "TEMPLE BAZAR FOOT MARKET": ["104"],
	    "NETAJI FULL MARKET NEAR GANESH MANDIR": ["105"],
	    "NETAJI MARKET OCCUPATION SANKUL": ["106"],
	    "SANGAM CHAL NEAR DHANI MANI HOUSE": ["107"],
	    "RAMDASPETH DAGADI CHAL": ["108"],
	    "SANGAM CHAL BASTI": ["109"],
	    "SANGAM CHAL BEHIND YASHWANT STADIUM": ["110"],
	    "YASHWANT STADIUM NALI KE PASS": ["111"]
  },
  "Zone No.5 - Nehru Nagar": {
	  "DIGHORI DAHAN GHAT": ["117"],
	    "SAKKARDARA FIR OFFICE": ["118"],
	    "WATHODA DAHAN GHAT": ["119"],
	    "SAKKARDARA PULAKHALI": ["120"],
	    "DATTATRAY NAGAR GARDEN": ["121"],
	    "MAHAVIR GARDEN": ["122"],
	    "BHAGAT COLONY GARDEN": ["123"],
	    "ADAMSHAH SCHOOL": ["124"],
	    "NEHRU NAGAR ZONE OFFICE 5": ["125"],
	    "NEHRU NAGAR GARDEN": ["126"],
	    "AYODHYA NAGAR TELEPHONE EXCHANGE": ["127"],
	    "BIDIPETH SCHOOL": ["128"],
	    "TAJ URDU SCHOOL": ["129"],
	    "RAJA BAL HINDI & MARATHI HIGHER PRIMARY SCHOOL": ["130"],
	    "CHITNVIS NAGAR GARDEN": ["131"],
	    "PRAGATI COLONY GARDEN": ["132"],
	    "WATHODA SCHOOL": ["133"],
	    "DARSHAN COLONY GARDEN": ["134"],
	    "NEW NANDANVAN SCHOOL": ["135"],
	    "HASANBAGH URDU SCHOOL": ["136"],
	    "RAJU GANDHI GARDEN": ["137"],
	    "JUNI SHUKRAVARI": ["138"],
	    "RESHIMBAGH GARDEN": ["139"]
  },
  "Zone No.6 - Gandhi Zone Mahal": {
	  "BARSENAGAR URINAL": ["144"],
	    "BARSENAGAR": ["145"],
	    "SANDESH LIBRARY BASRE NAGAR": ["146"],
	    "JYOTI NAGAR KHADAN": ["147"],
	    "RAHEMAN HOTEL JAWAL MOMINPURA": ["148"],
	    "HAJI ABDUL URDU SCHOOL": ["149"],
	    "ANSAR NAGAR SAMAJ BHAVAN": ["150"],
	    "MOMINPURA KABRASTHAN ROAD URINAL": ["151"],
	    "MOMINPURA KABRASTHAN": ["152"],
	    "BHANKHEDA BOUDHA VIHAR": ["153"],
	    "HANSAPURI HINDI SCHOOL": ["154"],
	    "INSIDE GANDHIBAGH GARDEN": ["155"],
	    "KALI MATA MANDIR": ["156"],
	    "MEDICINE MARKET": ["157"],
	    "C.A. ROAD GANDHIBAGH": ["158"],
	    "CHIKNIS PARK": ["159"],
	    "GANJIPETH KHANTE BHAVAN": ["160"],
	    "GANJIPETH DURGAMATA MANDIR": ["161"],
	    "GANJIPETH URDU SCHOOL": ["162"],
	    "BHALDARPURA": ["163"],
	    "NAKA NO. 13 OFFICE": ["164"]
  },
  "Zone No.7 - Satranjipura": {
	  "BARTAN OLI": ["168"],
	    "MASKASATH": ["169"],
	    "NEHRU PUTLA": ["170"],
	    "ANAAJ BAZAR": ["171"],
	    "CHITTESHWAR HINDI NMC SCHOOL": ["172"],
	    "SATRANJIPURA WATER TANK": ["173"],
	    "SATRANJIPURA ZONE": ["174"],
	    "LIBRARY": ["175"],
	    "MEHNDIBAGH CORNER POWER HOUSE": ["176"],
	    "NIT KINKHEDE LAYOUT": ["177"],
	    "PREMNAGAR CHOWK": ["178"],
	    "PREMNAGAR GAJANAN TEMPLE": ["179"],
	    "PREMNAGAR AJAY DALAL": ["180"],
	    "SHANTINAGAR GARDEN": ["181"],
	    "SHANTI NAGAR POLICE STATION": ["182"],
	    "SHANTI NAGAR NMC SCHOOL": ["183"],
	    "SHANTI NAGAR BAMGDE PLOT": ["184"],
	    "TULSI NAGAR GARDEN": ["185"],
	    "NANAK GARDEN SHANTI NAGAR": ["186"],
	    "SHANTI NAGAR DAHAN GHAT": ["187"],
	    "SHANTI NAGAR WATER TANK": ["188"],
	    "DAHI BAZAR": ["189"],
	    "NAIK TALAV GARDEN": ["190"],
	    "NAIK TALAV": ["191"],
	    "LADPURA LIBRARY": ["192"],
	    "180 SEET TANDAPETH BANGLADESH": ["193"]
  },
  "Zone No.8 - Lakadganj": {
	  "KALYANESHWAR MANDIR": ["198"],
	    "CITY POST OFFICE": ["199"],
	    "SARAFA BAZAR": ["200"],
	    "GHAS BAZAR": ["201"],
	    "LAKADGANJ ZONE OFFICE": ["202"],
	    "MOCHIPURA GARDEN": ["203"],
	    "MINIMATA NAGAR NMC SCHOOL": ["204"],
	    "MINI MATA NAGAR": ["205"],
	    "MAHARANI LAXMIBAI NMC SCHOOL": ["206"],
	    "PARDI POLICE STATION": ["207"],
	    "NAVIN NAGAR NMC SCHOOL": ["208"],
	    "PUNAPUR GHAT": ["209"],
	    "AADIWASI PRAKASH NAGAR RTO": ["210"],
	    "SANT KABIR NAGAR NMC SCHOOL": ["211"],
	    "RAJIV GANDHI NAGAR SLUM": ["212"],
	    "GAJANAN MANDIR": ["213"],
	    "MALDHAKKA ROAD 2 KALAMANA": ["214"],
	    "MALDHAKKA ROAD 1 KALAMANA": ["215"],
	    "NAMDEV NAGAR GARDEN": ["216"],
	    "SANJAY NAGAR NMC SCHOOL": ["217"]
	  },
  "Zone No.9 - Aashi Nagar": {
	  "GURU NANAK GARDEN": ["222"],
	    "RAM MANOHAR LOHIYA LIBRARY": ["223"],
	    "ASHINAGAR ZONE OFFICE": ["224"],
	    "SIDDHARTH NAGAR LIBRARY": ["225"],
	    "PANCHSHEEL NAGAR LIBRARY": ["226"],
	    "ANAND KAUSHLYA NAGAR": ["227"],
	    "SUGAT NAGAR FIRE OFFICE": ["228"],
	    "SAMATA NAGAR": ["229"],
	    "NARA GHAT SHIV MANDIR": ["230"],
	    "NARA GHAT": ["231"],
	    "PATANKASHI LINE INDORA": ["232"],
	    "MAYA NAGAR": ["233"],
	    "INDORA CHOWK BHIM SENA OFFICE": ["234"],
	    "SMARAK 10 PULIYA": ["235"],
	    "BANSOD MOHHALA": ["236"],
	    "JYOTI NAGAR": ["237"],
	    "BHOSLEWADI ARA MACHINE": ["238"],
	    "BHOSALE WADI": ["239"],
	    "AWALE BABU CHOWK GARDEN": ["240"],
	    "GHASARIPUR": ["241"],
	    "BAJIRAO SAKHARE LIBRARY AWALE BABU CHOWK": ["242"]
	  },
  "Zone No.10 - Mangalwari": {
	  "SINDHU SOCIETY JARIPATKA": ["247"],
	    "CHAWLA CHOWK JARIPATKA": ["248"],
	    "ARYA MANDIR JARIPATKA": ["249"],
	    "JANTA KULPI JARIPATKA": ["250"],
	    "SINDHU BALAUDYAN GARDEN JARIPATKA": ["251"],
	    "JUNA JARIPATKA MATA TEMPLE": ["252"],
	    "KRISHNADHAM BOX COOLER": ["253"],
	    "MANKAPUR GHAT": ["254"],
	    "DORE LAY OUT": ["255"],
	    "GANGANAGAR": ["256"],
	    "DURGA NAGAR CANTONMENT CHOWK": ["257"],
	    "SHITLAMATA TEMPLE SADAR": ["258"],
	    "KASTURBA LIBRARY SADAR": ["259"],
	    "NMC HOSPITAL SADAR": ["260"],
	    "JB COMPLEX MAGALWARI SADAR": ["261"],
	    "NEAR GOVT. POLY COLLEGE": ["262"],
	    "MESHRAM GARDEN MANGALWARI": ["263"],
	    "AMBEDKAR CHOWK INDORA": ["264"]
	  }
  };

  document.getElementById('zoneName').addEventListener('change', function () {
    const zone = this.value;
    const unitSelect = document.getElementById('blockUnit');
    const blockNoSelect = document.getElementById('blockNo');

    unitSelect.innerHTML = '<option value="">-Select Unit-</option>';
    blockNoSelect.innerHTML = '<option value="">-Select Block Number-</option>';

    if (zoneData[zone]) {
      const units = zoneData[zone];
      for (let unit in units) {
        const opt = document.createElement("option");
        opt.value = unit;
        opt.text = unit;
        unitSelect.appendChild(opt);
      }
    }
  });

  document.getElementById('blockUnit').addEventListener('change', function () {
    const zone = document.getElementById('zoneName').value;
    const unit = this.value;
    const blockNoSelect = document.getElementById('blockNo');

    blockNoSelect.innerHTML = '<option value="">-Select Block Number-</option>';

    if (zoneData[zone] && zoneData[zone][unit]) {
      zoneData[zone][unit].forEach(block => {
        const opt = document.createElement("option");
        opt.value = block;
        opt.text = block;
        blockNoSelect.appendChild(opt);
      });
    }
  });
</script>

          
          <div class="form-group">
            <label>Date Of Cleaning<span class="text-danger" style="color: red;">*</span></label>
			<input type="text" class="form-control" id="currentDate" name="currentDate" style="background-image: none" readonly>
			<div class="invalid-feedback">Please Enter Valid Longitude.</div>			
          </div>
          
          <div class="form-group">
            <label>Google Location (Longitude)(गूगल स्थान (Longitude))<span class="text-danger" style="color: red;">*</span> </label>
            <input type="text" class="form-control name" style="background-image: none;" name="longitude" id="longitude"
							value="" onchange="Display(this.id)" maxlength="80" required>
			<div class="invalid-feedback">Please Enter Valid Longitude.</div>
          </div>
          
          <div class="form-group">
            <label>Google Location(Latitude)(गूगल स्थान (Latitude))<span class="text-danger" style="color: red;">*</span></label>
            <input type="text" class="form-control name me-4"
								style="background-image: none;" name="latitude" id="latitude"
								value="" onchange="Display(this.id)" maxlength="80" required>
			<div class="invalid-feedback">Please Enter Valid Latitude.</div>
			<input type="button" class="btn btn-primary btn_sm" value="Precise Location" onclick="getPreciseLocation();">
	      </div>
	      
	      <div class="alert alert-info mb-0 p-2 mb-4 ms-2 row"
				style="background-color: #dce2e8 !important; width: 100% !important; margin-left: -1px !important;">
				<small class="form-label "><strong class="form-label "
					style="font-weight: 900; font-size: 15px !important;"><b>Document
							Attachment List</b> </strong> <br>Note: Upload listed files only .jpg,
					.jpeg, .png (Max upto 5 MB)</small>

			</div>
			
		  <input type="hidden" name="filesPath" id="filesPath" />
		   <div class="form-group">
               <label for="" class="form-label " style="font-weight: normal;">Photo Before Cleaning<span class="text-danger" style="color: red;">*</span></label>
				<input type="file" class="form-control"	style="background-image: none;" id="doc1" placeholder="" name="photoBeforeCleaning" required>
				<div class="invalid-feedback">File selected is either greater than 5Mb or not of type .jpg.</div>
          </div>
          
           <div class="form-group">
            <label for="" class="form-label " style="font-weight: normal;">Photo During Cleaning<span class="text-danger" style="color: red;">*</span></label> 
            <input type="file" class="form-control" style="background-image: none;" id="doc2" placeholder="" name="photoDuringCleaning" required>
			<div class="invalid-feedback">File selected is either greater than 5Mb or not of type .jpg.</div>
          </div>
          
           <div  style="margin-top: 20px !important; text-align: center;" >
	   <button type="button" class="btn btn-primary btn_sm printMe"> View and Print</button>
	   <button class="btn btn-success btn_sm" type="submit" id="submit">Submit</button>
		</div>
          
         
          
        </div>          

         
      </div>
	
    </div>
  </div>
</form>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

	
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
                        var validExtensions = ['.jpg', '.jpeg', '.png'];
                        var isValidFileType = validExtensions.some(ext => name.toLowerCase().endsWith(ext));

                        // Validate file type and size
                        if (!isValidFileType) {
                            isFormValid = false;
                            fileInput.classList.remove('is-valid');
                            fileInput.classList.add('is-invalid');
                        } else if (fileInput.files[0].size >= 5000000) {
                            isFormValid = false;
                            fileInput.classList.remove('is-valid');
                            fileInput.classList.add('is-invalid');
                        } else {
                            fileInput.classList.remove('is-invalid');
                            fileInput.classList.add('is-valid');
                        }
                    }
                });

                // Prevent form submission if invalid
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
                            onPageSubmit("<c:out value='${contextRoot}'/>/rtiapplication/saveStatueCleaning.do");
                        } 					
                        isUploadInProgress = false; 
                    });
                }

                form.classList.add('was-validated');
            }, false);
        });
    });

    $('input[type="file"],input,select').on('focusout', function () {
        var isFileAllowed = true;
        if (this.getAttribute("type") === 'file') {
            var name = this.files[0]?.name || '';
            var validExtensions = ['.jpg', '.jpeg', '.png'];
            var isValidFileType = validExtensions.some(ext => name.toLowerCase().endsWith(ext));

            if ((this.files[0]?.size < 5000000) && !isValidFileType) {
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

    // Append files to FormData
  for (var i = 1; i <= 3; i++) {
    var fileInput = $("#doc" + i).get(0).files[0];
    if (fileInput) {
        if (i == 1)
            data.append('beforeCleaning', fileInput);
        else if (i == 2)
            data.append('duringCleaning', fileInput);
      
    }
}


    const id = Math.floor(Math.random() * 9000) + 1000;
    
    // Create file paths for logging
    var file = $('input[type="file"]');
    for (var i = 0; i < file.length; i++) {
        var array_element = file[i];
        var element = array_element.value.split("\\");
        var a = element[element.length - 1];

        if (a !== '' && a !== undefined) {
            // Extract filename and extension
            var parts = a.split('.');
            var extension = parts.pop().toLowerCase(); // Convert extension to lowercase
            var fileName = parts.join('.').replace(/[^a-zA-Z0-9]/g, ""); // Remove special characters

            // Construct final file name
            var finalFileName = fileName + "." + extension;
            filesPath += basePath + "statuecleaning/" + id + finalFileName + ",";
        }
    }
    
   



    // AJAX call to upload files
    $.ajax({
        url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadStatueCleaning.do?id="+id,
        type: 'POST',
        data: data,
        cache: false,
        dataType: 'json',
        processData: false,
        contentType: false,
        async: false, // Set to synchronous
        success: function(data) {
            var status = data.status;
            if (callback && typeof callback === 'function' && status == true) {
                callback(status);
            } else if (status === false) {
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

    // Clean up file paths for logging
    var a = filesPath.substring(0, filesPath.lastIndexOf(","));
    filesPath = filesPath.replace(/\s/g, "");
    $("#filesPath").val(filesPath);
    //console.log(filesPath);
}

    </script>
  
  
   <script>
    document.querySelectorAll('.file-input').forEach(input => {
        input.addEventListener('change', function() {
            validateFile(this);
        });
    });

    function validateFile(input) {
        const file = input.files[0];
        const validExtensions = ['jpg', 'jpeg','png'];

        if (file) {
            const fileSizeLimit = 5000000; // 5MB
            const fileName = file.name;
            const fileExtension = fileName.split('.').pop().toLowerCase();
            
            // Validate file type and size
            if (file.size > fileSizeLimit || !validExtensions.includes(fileExtension)) {
                input.classList.add('is-invalid');
                input.classList.remove('is-valid');
            } else {
                input.classList.remove('is-invalid');
                input.classList.add('is-valid');
            }
        }
    }
    
    
    const statuesData = {
    		  lakadganj: [
    		    'Indira Gandhi Putla - Shanti Nagar',
    		    'Jawaharlal Nehru Putla - Maskasath',
    		    'Mahatma Gandhi Putla - Satranjipura Itwari',
    			'Babasaheb Ambedkar Putla - Chapru Nagar',
    		    'Babasaheb Ambedkar Putla - Lakadganj Police Station',
    		    'Shahid Stambh - Itwari',
    		    'Subhash Putla - Telephone Exchange Chowk',
    		    'Sant Jagnade Maharaj Putla - Jagnade Chowk',
    		    'Bhagat Singh Putla - Shahid Chowk',
    		    'Bharat Mata Stambh - Shanti Nagar Ghat',
    			'Darodkar Stambh - Darodkar Chowk',
    			'Rajendra Prasad Putla - telephone Exchange',
    			'Stambh - Juni Mangalwari, Gujri Chowk'
    		  ],
    		  sugat_nagar: [
    				'Babasaheb Ambedkar Putla - Kapil Nagar Polic Station',
    				'Babasaheb Ambedkar Putla - yadav Nagar Bhim Chowk',
    				'Babasaheb Ambedkar Putla - Vinoba Bhave Nagar',
    				'Babasaheb Ambedkar Putla - Laal Godown Chowk',
    				'Babasaheb Ambedkar Putla - Indora Chowk',
    				'Babasaheb Ambedkar Putla - Barse Chowk',
    				'Babasaheb Ambedkar Putla - Bhim Chowk Jaripatka',
    				'Birsa muda Putla - Rani Durgawati Chowk',
    				'Rani Virangan Durgawati Devi - Rani Durgawati Chowk',
    				'Mahatna Gandhi Chowk  - Vinoba Bhave Nagar',
    				'Gautamm Budha Putla -Laal Godown Chowk',
    				'Gautamm Budha Putla - Barse Nagar',
    				'Dr. bari Rajabhau Khobragade Putla',
    				'Aaavle babu Putla',
    				'Vijay Stambh',
    				'shahid Smarak - 10 no. puliya Chowk'
    		  ],
    		  narendra_nagar: [
    		    'Gayakwad Putla - Deekshabhumi Chowk',
    		    'Anna Bhau Sathe Putla',
    			'Rajiv gandhi Putla',
    			'Yashwant Rao Chavhan Putla',
    			'Dr. Babasaheb Ambedkar Putla - Trisharan Chowk',
    			'Gautam Buddha Putla Trisharan Chowk' 
    		  ],  
    		  sakkardar: [
    		    'Baseshwar putla - Dattatrey Nagar',
    			'Dr. BabaSaheb Ambedkar Putla - Bollywood center Oint',
    			'indira gandhi Putla - Bollywood center point',
    			'Chimasaheb bhosale Putla - Chota tajbhagh',
    			'Mahatma Gandhi Putla',
    			'Raghuji maharaj Putla - Sakkardara',
    			'mahatama Gandhi Putla  - Juni Sukrwari',
    			'Annabhau Sathe Putla - Reshimbagh',
    			'Sant Tukdoji Maharaj Putla - Tukdoji Chowk',
    			'Telchitr Chattrapati Shivaji Maharaj - Mahakalkar Sabhagruh Dattatrey Nagar'
    		  ],
    		  ganjiipeth: [
    		    'Rashtrapita Mahatma Gandhi Putla - Gandhi Chowk',
    			'Amar Shahid krushna kakde - Meyo hospital',
    			'padmashree SHyamraavji Hhupta - Dosar Bhavan Chowk',
    			'Nirala - Nirali Bhavan Chowk',
    			'Shree Agrasen Maharaj - Agrasen Chowk',
    			'Amar Shahid Kavarraam Favara Chowk C. A. Road',
    			'Swa. Ra. Ba. Kumbhare gandhibagh bagicha',
    			'Rashtrpati Mahatma Gandhi - Chittaroli Chowk',
    			'pandit bachraj vyas 0 Badkas Chowk',
    			'Tyagmurti Punmchand Ranka Mahal',
    			'Morbhau Abhyankar - Mahal',
    			'Bhausahab Surve - Mahal',
    			'Shahid ShankarMahale -Zenda Chowk',
    			'Chattrapati Shivaji Maharaj - Mahal Gandhi Gate',
    			'Lokmanya Tilak - Gandhi Sagar Lake',
    			'Bari Rambhau Raikar Chitnis Park',
    			'Savitribai Phule Gandhisagar Dattamandir',
    			'Hutatma Smarak Gandhisagar Dattamandir',
    			'Bharat Mata Puutla - Bharat Mata Chowk',
    			'Hutatma Smarak Golibar Chowk',
    			'Nanga Putla',
    			'Sane Guruji Putla - gandjhi Sgar Putla',
    			'Dr. babaSaheb Ambedkar Putla - Bhankheda Timki',
    			'bharat Mata Putla - Rajwada palace',
    			'Subhash Chandra Bose Putla - Sevasadan Chowk CA road',
    			'maharana Pratap Putla - Gitanjali talkies'
    		  ],
    		  civil: [
    		    'Gond Raje baktbuland Shah -Vidhan Bhavan Chowk',
    			'bari Sheshrao Wankhede - Hirwadi NMC Ngapur',
    			'shri. dadasaheb kannamvar - Vidhan bhavan Chowk',
    			'Mahatma Gandhi Putla - Vidhan Bhawan Chowk',
    			'vasantrao Naik - Vidhan Bhawan Chowk',
    			'Dr. babSaheb Ambedkar Putla -Sanvidhan Chowk',
    			'kasturchand Daga Putla -LIC Chowk',
    			'Jatinram barve Putla - Zero Mile',
    			'Saat Putla - Freedom Park, Morris College T - point',
    			'mahatma Gandhi Putla - variety Chowk',
    			'Rani Lakshmi bai Putla - Jhansi rani Chowk',
    			'Sonapati bapat Putla - University Library',
    			'Punjabroa Deshmukh Putla - Krushi Vidyapeeth Maharajj bagh',
    			'dr. babasaheb Ambedkar Putlla - Dharampeth Buddha Vihar',
    			'Bobde Kaayde Pandit - Akashwani Chowk',
    			'C k Naidu Putla VCA Ground',
    			'NPK Sabde -Saraf Chamber',
    			'mahatma gandhi Putla  - Gandhi  Chowk',
    			'Sakharam Pant meshram - Sadar',
    			'Saadhu vasvani - NIT Building',
    			'Birsa Mundas -Futala lake',
    			'Zero mile -Zero Mile Chowk',
    			'Gowari Smarak -Zero Mile Chowk',
    			'Garud Chowk - GPO'
    		  ],
    		  trimurti_nagar: [
    				'Chattrapati Shivaji Maharaj Putla - Sambhaji Chowk',
    			'Bajiprabhu Deshpande Putla - Nagpur',
    			'Lahuji Salve Putla - Ambazari garden',
    			'Swami Vivekanand Putla - Ambazari Overflow',
    			'Moreshwar Abhyankar Putla - Abhyankar Nagar',
    			'Jamnalal bajaj Putla - Bajaj Nagar CHowk',
    			'Dr. BabaSaheb Ambedkar Putla  - Mate Chowk',
    			'Maharana Pratap Putla - Pratap Nagar Chowk',
    			'Chattrapati Shivaji Maharaj Putla - Swavlambi Nagar Chowk',
    			'Mahatma Gandhi Putla - Subhash Nagar Chowk',
    			'Statue of Lal Bahadur Shastri - Laxmi Bhavan Chowk',
    			'Statue of Swatantryaveer Savarkar - Shankar Nagar Chowk'
    		  ],
    		  kalmana: [
    		    'Dr. Babasaheb Ambedkar Putla - Pardi bajaar Chowk',
    		'Dr. Babasaheb Ambedkar Putla - Meena Mata Nagar'
    		  ],
    		  cotton_market: [
    				'Swa. Jadhav Putla , baalbhavan Gandhi Sagar Garden',
    			'Savitribai phule Putla, Hutatma Smarka, Balbhavan, Gandhisangar Garden',
    			'Rashtrsant Tukdoji Putla, Agyraam Devi, SubhashRoad',
    			'mhatma Jyotiba Phule Putla, Cotton Market Chowk',
    			'Savitribai phule Putla, Cotton Market Chowk',
    			'Shahid Smarak - Cotton Market Chowk',
    			'Sant TulsiDas Putla, manas Chowk, Lohapul',
    			'Rastrpita Mahatma Gandhi Putla, - Variety Chowk',
    			'Netaji Subhash Chandra Bose Putla - manas Chowk',
    			'Dr. Muje Putla , Bank of Maharashtra, Sitabuldi',
    			'Swa, Narayan Uikey Putla, Anand talkies, Sitabuldi'
    		  ]
    		};

    function updateStatuesList() {
      const fireStationSelect = document.getElementById('fireStationName');
      const statuesSelect = document.getElementById('statueList');
 
      statuesSelect.innerHTML = '';
      const selectedFireStation = fireStationSelect.value;
      const statuesList = statuesData[selectedFireStation];
      const placeholderOption = document.createElement('option');
      placeholderOption.text = '--Select Statue--';
      statuesSelect.add(placeholderOption);

      // Add each statue as an option
      statuesList.forEach(statue => {
        const option = document.createElement('option');
        option.value = statue;
        option.text = statue;
        statuesSelect.add(option);
      });
    }
  
    function getPreciseLocation(){
    	if(navigator.geolocation){
    		navigator.geolocation.getCurrentPosition(showExactPostion)
    		}
    	else{
    		x.innerHTML="Geo Location is not supported"
    			}
    	
    }
    function showExactPostion(position){
    	var latitudeInput = document.getElementById('latitude');
        var longitudeInput = document.getElementById('longitude');

        latitudeInput.value = position.coords.latitude;
        longitudeInput.value = position.coords.longitude;
    	
    }
    
    $('.printMe').on('click', function () {

        window.print();
    });
 
</script>

</body>
</html>
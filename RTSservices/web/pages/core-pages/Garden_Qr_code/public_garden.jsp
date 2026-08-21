<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file="/pages/common/include.jsp" />
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Park Information</title>
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <!-- Custom CSS -->
  <style>
  @import url('https://fonts.googleapis.com/css2?family=Google+Sans&display=swap');
   
    body {
      background-color: #f8f9fa;
      font-family: Google Sans, sans-serif !important; 
    }
    .container {
    position: relative; /* Ensure the container is positioned relative to the body */
    z-index: 2; /* Ensure the container is above the overlay */
}
body {
    margin: 0;
    padding: 0;
    background-image: url('/RTS/images/garden_background.jpg');
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
    background-color: rgba(0, 0, 0, 0.5); /* Black with 50% opacity */
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
  </style>
</head>
<body>
<form>
<div class="container">
  <div class="row">
    <div class="col-md-6">
      <div class="image-container">
<img src="<c:out value="${contextRoot}"/>/images/${gd.image_name}" class="img-fluid cropped-image" alt="Park Image">
      </div>
    </div>
    <div class="col-md-6">
      <div class="form-container">
        <div>
        <h2>Park Information</h2>
        </div>
        <hr>
        <form>
          <div class="form-group">
            <label for="parkName">Name of the park</label>
            <input type="text" class="form-control" id="parkname" name="parkname" value="${gd.parkname}" readonly>
          </div>
          <div class="form-group">
            <label for="ownership">Ownership</label>
            <input type="text" class="form-control" id="ownership" name="ownership" value="${gd.ownership}" readonly>
          </div>
          <div class="form-group">
            <label for="area">Area</label>
            <input type="text" class="form-control" id="area" id="area" name="area" value="${gd.area}" readonly>
          </div>
          <div class="form-group">
            <label for="agency">Name of Agency</label>
            <input type="text" class="form-control" id="agency" name="agency" value="${gd.agency}" readonly>
          </div>
          <div class="form-group">
            <label for="mobile">Mobile No.</label>
            <input type="tel" class="form-control" id="mobile" name="mobile" value="${gd.mobile}" readonly>
          </div>
          <div class="form-group">
            <label for="authority">Name and Telephone No. of Park Authority</label>
            <input type="text" class="form-control" id="authority" name="authority" value="${gd.authority}" readonly>
          </div>
          <div class="form-group">
            <label for="feedback">Feedback</label>
            <textarea class="form-control" id="feedback" name="feedback" rows="3"></textarea>
          </div>
         
          <div class="form-group">
            <label for="complaint">To register a complaint:</label>
           

<a href="https://nmcnagpur.gov.in/grievance/complaint_form.php" target="_blank" class="form-control" style="color: blue;">&#128279;nmcnagpur.gov.in/grievance</a>
          </div>
<button type="submit" id="submitButton" class="btn btn-primary">Submit</button>        </form>
      </div>
    </div>
  </div>
</div>
</form>


<script>

$(document).ready(function() {
    $('form').submit(function(event) {
        var feedback = $('#feedback').val();
        
        if (feedback.trim() === '') {
            event.preventDefault();
            
            alert("Please enter feedback!!");
        }else{
            onPageSubmit('<c:out value="${contextRoot}"/>/garden/saveGardenFeedback.do');
        }
    });
});

</script>

</body>
</html>

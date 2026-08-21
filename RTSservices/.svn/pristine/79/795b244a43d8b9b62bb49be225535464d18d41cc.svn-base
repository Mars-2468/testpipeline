<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file="/pages/common/include.jsp" />
<html lang="en">
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Feedback Success</title>
<style>
  
body {
    margin: 0;
    padding: 0;
    background-image: url('/RTS/images/garden_background.jpg');
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    min-height: 92vh; /* Ensure body takes up at least the viewport height */
    position: relative; /* Ensure the body acts as the positioning context for absolutely positioned elements */
    overflow-y: auto; /* Enable vertical scrolling when content exceeds viewport height */
}

body::before {
    content: "";
    position: fixed; /* Fix the overlay to the viewport */
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5); /* Black with 50% opacity */
    z-index: 1; /* Ensure the overlay is below other elements */
}

.container {
    position: absolute; /* Position the container relative to the body */
    top: 45%; /* Align the top of the container to the middle of the viewport */
    left: 50%; /* Align the left of the container to the middle of the viewport */
    transform: translate(-50%, -50%); /* Center the container horizontally and vertically */
    max-width: 100%; /* Ensure the container doesn't exceed the viewport width */
    width: 465px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    background-color: white;
    z-index: 2; /* Ensure the container is above the overlay */
}

    .success-message {
        font-size: 18px;
        color: green;
        text-align: center;
        margin-top: 20px;
    }

    .success-message p {
        margin-bottom: 10px;
    }
    
   
    
    @media (min-width: 576px) {
    .container {
        width: 80%; /* Adjust container width for larger screens */
    }
</style>
</head>
<body>
<div class="container">
    <div id="successMessage" class="success-message">
    
        <p>Thank you for your feedback!</p>
        <p>Your feedback has been saved successfully. We appreciate your input and will take it into consideration.</p>
    </div>
</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Video Guide</title>
    <style>
        /* Full-screen center alignment */
        html, body {
            height: 100%;
            margin: 0;
            overflow: hidden; /* Prevents scrollbars */
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            background-color: #f8f9fa;
        }
        
        h2 {
            margin-bottom: 15px;
        }

        video {
            width: 95vw;  /* Increased width (95% of viewport width) */
            max-height: 90vh; /* Ensures it fits within screen height */
            border: 5px solid #007bff;
            border-radius: 10px;
            box-shadow: 5px 5px 15px rgba(0, 0, 0, 0.2);
        }
    </style>
</head>
<body>
    <h2>Video Guide for Filling the Form</h2>
    <video controls autoplay>
        <source src="${pageContext.request.contextPath}/images/MarriageFormFill.mp4" type="video/mp4">
        Your browser does not support the video tag.
    </video>
</body>
</html>

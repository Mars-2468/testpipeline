<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SMS Status</title>
    <link rel="stylesheet" href="styles.css">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f8f9fa;
        }

        .container {
            background-color: #ffffff;
            padding: 50px;
            border-radius: 12px;
            box-shadow: 0 6px 10px rgba(0, 0, 0, 0.15);
            max-width: 600px;
            width: 100%;
            text-align: center;
        }

        #statusContainer {
            padding: 30px;
            border-radius: 8px;
        }

        .success {
            background-color: #e6ffcc;
            color: #4CAF50;
            border: 2px solid #4CAF50;
        }

        .error {
            background-color: #ffe6e6;
            color: #cc0000;
            border: 2px solid #cc0000;
        }

        #statusContainer p {
            font-size: 1.8em; /* Main message font size */
            font-weight: bold;
            margin: 0 0 10px 0;
        }

        .message {
            font-size: 1.2em;
            color: #666666;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <c:choose>
            <c:when test="${not empty param.name && not empty param.mobileNo}">
                <div id="statusContainer" class="success">
                    <p>SMS sent successfully!</p>
                    <p class="message">Dear ${param.name}, your SMS was sent to mobile number ${param.mobileNo}.</p>
                </div>
            </c:when>
            <c:otherwise>
                <div id="statusContainer" class="error">
                    <p>SMS failed to send.</p>
                    <p class="message">Please check the details and try again.</p>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>

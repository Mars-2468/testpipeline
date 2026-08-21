<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>QR Code Preview</title>
</head>
<body>

<% String qrCodeBase64 = (String) request.getAttribute("qrCodeBase64"); %>
<% String downloadLink = (String) request.getAttribute("downloadLink"); %>

<h2>QR Code Preview</h2>

<% if (qrCodeBase64 != null) { %>
    <img src="<%= qrCodeBase64 %>" alt="QR Code" width="150" height="150">
    <br><br>
    <a href="<%= downloadLink %>">Download PDF with QR</a>
<% } else { %>
    <p style="color: red;">Error generating QR Code. Please try again.</p>
<% } %>

</body>
</html>

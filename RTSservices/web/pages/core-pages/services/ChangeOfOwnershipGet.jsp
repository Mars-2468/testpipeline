<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
	<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
</head>
<style>
input[type=text]{
width: 500px;
height: 50px;
}
</style>
<body>

<div class="container" style="margin-top: 50px;">
<h1><strong>Water Details</strong></h1><hr>
Status:<br><input type="text"  value="${responseData.status}" required><br><br>
MSG:<br><input type="text"  value="${responseData.msg}" required><br><br>
Type:<br><input type="text" value="${responseData.getData().get(0).getType()}" required><br><br>
ContractAccountNo:<br><input type="text"  value="${responseData.getData().get(0).getContractAccountNo()}" required><br><br>
ConsumerName:<br><input type="text" value="${responseData.getData().get(0).getContractAccountNo()}" required><br><br>
Address:<br><input type="text"  value="${responseData.getData().get(0).getAddress()}" required><br><br>
MeterNo:<br><input type="text"  value="${responseData.getData().get(0).getMeterNo()}" required><br><br>
Zone:<br><input type="text"  value="${responseData.getData().get(0).getZone()}" required><br><br>
</div>
</body>
</html>
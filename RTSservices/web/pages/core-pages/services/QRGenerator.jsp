<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="/pages/common/include.jsp" />
<!DOCTYPE html>
<html>
<head>
    <title>QR Code Generation</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script>
        function validateForm() {
            let fileInput = document.getElementById("file");
            let appNumber = document.getElementById("appNumber").value.trim();
            
            if (appNumber === "") {
                alert("Application Number is required.");
                return false;
            }

            let file = fileInput.files[0];
            if (!file) {
                alert("Please select a PDF file.");
                return false;
            }

            let fileType = file.type;
            if (fileType !== "application/pdf") {
                alert("Only PDF files are allowed.");
                return false;
            }

            let fileSize = file.size / 1024 / 1024; // Convert to MB
            if (fileSize > 10) {
                alert("File size must be 10MB or less.");
                return false;
            }

            return true;
        }

        function search() {
            if (!validateForm()) return; // Validate before submitting
            
            let fileInput = document.getElementById("file");
            let appNumber = document.getElementById("appNumber").value;

            let formData = new FormData();
            formData.append("applicationNumber", appNumber);
            formData.append("file", fileInput.files[0]);

            let actionUrl = "<c:out value='${contextRoot}'/>/rtsapplication/generateQR.do";
            
            let xhr = new XMLHttpRequest();
            xhr.open("POST", actionUrl, true);
            xhr.onload = function () {
                if (xhr.status === 200) {
                    document.body.innerHTML = xhr.responseText; // Replace content with server response
                } else {
                    alert("QR Generation failed. Please try again.");
                }
            };
            xhr.send(formData);
        }
    </script>
    <style>
        body { background-color: #f8f9fa; }
        .container {
            max-width: 500px;
            background: white;
            padding: 30px;
            margin-top: 50px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        .btn-upload { background: #28a745; color: white; }
    </style>
</head>
<body>
    <div class="container">
        <h4 class="text-center">Upload PDF to Generate QR Code</h4>
        <div class="mb-3">
            <label class="form-label">Application Number:</label>
            <input type="text" id="appNumber" name="applicationNumber" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Select PDF:</label>
            <input type="file" id="file" name="file" class="form-control" accept="application/pdf" required>
        </div>
        <div class="text-center">
            <button type="button" onclick="search()" class="btn btn-upload">Generate QR</button>
        </div>
    </div>
</body>
</html>


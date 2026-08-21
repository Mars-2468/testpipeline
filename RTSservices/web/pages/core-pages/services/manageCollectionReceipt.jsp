 <jsp:directive.include file="/pages/common/include.jsp" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Collection Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f9f9f9;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        .message {
            color: green;
            font-size: 1.2em;
            margin-bottom: 20px;
        }

        .download-button {
            display: inline-block;
            padding: 10px 20px;
            font-size: 1em;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            cursor: pointer;
        }

        .download-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="message">
            Your collection is successful!
        </div>
        
<input type="hidden" name="collectionId" value="${requestScope.collectionId}">
<button onclick="downloadRecepit()" class="download-button">
	Download Receipt
</button>
    </div>
</body>
<script>
	function downloadRecepit()
	{
	       onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/printRecieptDownload11.do');
	}
</script>
</html>

    
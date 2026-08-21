<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page	import="com.mars.common.utils.Constants" />
<jsp:directive.page	import="com.mars.common.utils.CommonUtils" />

<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	pageContext.setAttribute("SESSION_TOKEN_KEY",
			Constants.SESSION_TOKEN_KEY);
	pageContext.setAttribute("STATUS_NO_LABEL",
			Constants.STATUS_NO_LABEL);
	pageContext.setAttribute("STATUS_YES_LABEL",
			Constants.STATUS_YES_LABEL);
	pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
	pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
	///pageContext.setAttribute("statusList", CommonUtils.getStatus());
%>

<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
    <table>
        <tr>
            <td>
                <div class="form-group">
                    <label for="messageLabel">Ganesh Summary Excel:</label>
                </div>
            </td>
            <td>
                <div class="form-group">
                    <button class="btn btn-primary" onclick="ganeshSummary('ganeshSummaryReport.do')">Report</button>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div class="form-group">
                    <label for="messageLabel">Ganesh Visarjan Excel:</label>
                </div>
            </td>
            <td>
                <div class="form-group">
                    <button class="btn btn-primary" onclick="ganeshSummary('ganeshVisarjan.do')">Report</button>
                </div>
            </td>
        </tr>
    </table>
    
    
    <script>     
    	function ganeshSummary(url) {

    		/* document.getElementById('rtiApplicationRefId').value = id; */
    		
    		alert("Certificate has been generated successfully.");
    		
    		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/'+url);

    	}
    </script>
</body>

    
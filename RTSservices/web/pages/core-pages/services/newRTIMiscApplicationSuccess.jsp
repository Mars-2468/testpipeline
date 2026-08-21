<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants" />
<jsp:directive.page import="com.mars.common.utils.CommonUtils" />

<%
    pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
    pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
    pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
    pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
    pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
    pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
%>

<!-- CSS Dependencies -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
    body {
        background-color: #f4f6f9;
        font-family: 'Segoe UI', sans-serif;
    }

    .success-card {
        max-width: 600px;
        width: 100%;
        background: white;
        border-radius: 12px;
        padding: 30px;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        text-align: center;
        margin: auto;
    }

    .success-icon {
        font-size: 60px;
        color: #28a745;
        margin-bottom: 10px;
    }

    .success-title {
        color: #28a745;
        font-weight: 600;
        font-size: 26px;
        margin-bottom: 15px;
    }

    .application-info {
        font-size: 18px;
        margin-bottom: 8px;
        color: #333;
    }

    .ref-text {
        font-size: 15px;
        color: #777;
        margin-bottom: 25px;
    }

    .btn-group-custom .btn {
        min-width: 220px;
        margin: 5px;
        font-size: 15px;
    }

    .btn-download-eng {
        background-color: #007bff;
        color: white;
    }

    .btn-download-mar {
        background-color: #ffc107;
        color: #212529;
    }

    .btn-home {
        background-color: #28a745;
        color: white;
    }
</style>

<!-- HTML Body -->
<body>
    <div class="container d-flex justify-content-center align-items-center" style="min-height: 90vh;">
        <div class="success-card">
            
            <!-- Success Icon -->
            <div class="success-icon">
                <i class="fa fa-check-circle"></i>
            </div>

            <!-- Heading -->
            <div class="success-title">Submitted Successfully</div>

            <!-- Application Info -->
            <div class="application-info">
                Your receipt number is:
                <strong>
                    <c:if test="${miscNo != null}">
                        <c:out value="${miscNo}" />
                    </c:if>
                </strong>
            </div>

            <!-- Reference Message -->
            <div class="ref-text">Please use this application number for further reference.</div>

           
            <div class="btn-group-custom">
                <button type="button" class="btn btn-download-eng" onclick="downloadReceipt()">
                    <i class="fa fa-download"></i> Download Receipt
                 </button>
            </div>
         
                     

            <div class="mt-4">
                <button class="btn btn-home" type="button" onclick="save();">
                    <i class="fa fa-home"></i> Back to Home
                </button>
            </div>
        </div>
    </div>
</body>

<!-- JavaScript -->
<script type="text/javascript">
    function save() {
        onPageSubmit('<c:out value="${contextRoot}" />/rtsapplication/miscForm.do');
    }

  
    function downloadReceipt() {
        var miscNo = '${miscNo}';
        var actionUrl = '';

            actionUrl = '<c:out value="${contextRoot}" />/rtiapplication/miscReport.do';
       

        var form = document.createElement('form');
        form.method = 'POST';
        form.action = actionUrl;
        form.target = '_blank';
        form.style.display = 'none';

        var input = document.createElement('input');
        input.type = 'hidden';
        input.name = 'miscNo';
        input.value = miscNo;

        form.appendChild(input);
        document.body.appendChild(form);
        form.submit();

        setTimeout(function () {
            document.body.removeChild(form);
        }, 1000);
    }
</script>

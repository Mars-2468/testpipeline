<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <c:if test="${not empty error}">
        <p style="color: red">${error}</p>
    </c:if>
    <div class="container">
        <h1 class="mt-5">Enter Application ID</h1>
        <form id="applicationForm" class="needs-validation" novalidate>
            <div class="form-group">
                <label for="applicationId">Application ID</label>
                <input type="text" class="form-control" id="applicationId" name="applicationId" required>
                <div class="invalid-feedback">Please enter an application ID.</div>
            </div>
            <button type="submit" onclick="search()" class="btn btn-primary">Go</button>
        </form>
    </div>

   <script>
<c:if test="${requestScope.rtiApplication.workFlowStatus==3}">
					

					<td colspan="4" align="center">
    <a class="btn btn-primary"
       style="min-height: 30px; min-width: 80px; color: white; border: none;"
       onclick="resendDemandPayment('${marriageCertificate.fullName}', '${marriageCertificate.mobileNumber}', '${marriageCertificate.rtiapplrefno}', '${marriageCertificate.email}')">
       Resend demand
    </a>
</td>
</c:if>/

<script>
    function resendDemandPayment(name, mobileNo, applnNo, email) {
        // Use URL-encoded parameters in GET request
        const contextRoot = '<c:out value="${contextRoot}"/>';
        const url = contextRoot + '/rtiApplication/resendMarriagePayment.do'
            + '?name=' + encodeURIComponent(name)
            + '&mobileNo=' + encodeURIComponent(mobileNo)
            + '&applnNo=' + encodeURIComponent(applnNo)
            + '&email=' + encodeURIComponent(email);

        fetch(url)
            .then(response => {
                if (response.ok) {
                    alert('Payment link has been resent successfully.');
                } else {
                    alert('Failed to resend payment link.');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('Error occurred while resending payment link.');
            });
    }
    
    (function() {
        'use strict';
      
            var forms = document.getElementsByClassName('needs-validation');
            var validation = Array.prototype.filter.call(forms, function(form) {
                form.addEventListener('submit', function(event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    } else {
                        event.preventDefault(); // Prevent default form submission
                    }
                    form.classList.add('was-validated');
                }, false);
            });
      
    })();
    function search()
    {
        onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/goForSaveCollection.do');

    }
</script>
</body>
</html>
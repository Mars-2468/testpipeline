<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:directive.include file="/pages/common/include.jsp" />
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Application ID Entry</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
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

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

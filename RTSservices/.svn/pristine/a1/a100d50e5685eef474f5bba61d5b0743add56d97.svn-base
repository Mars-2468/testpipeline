<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants" />
<jsp:directive.page import="com.mars.common.utils.CommonUtils" />
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript"
	src="<c:out value=" ${contextRoot}" />/scripts/jquery/jquery.ajaxfileupload.js"></script>

<%
pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
String contextPath = request.getContextPath();
String url = contextPath + "/pages/core-pages/nmc_user/";
String name=(String)session.getAttribute("name"); 


%>
<meta charset="UTF-8">
  
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Nagpur Municipal Corporation</title>
  
  <link rel="icon" href="img/favicon.ico" type="image/x-icon">
  
  <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@200;400&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  
  <!-- Bootstrap core CSS -->
 <link rel="stylesheet" href="<%=url%>css/bootstrap.min.css">
  
 
<style>
  body {
    font-family: 'Roboto', sans-serif;
  }
</style>

<script>
  $(document).ready(function () {
    // Add smooth scrolling to your page links
    $('a[href^="#"]').on('click', function (event) {
      var target = $($(this).attr('href'));

      if (target.length) {
        event.preventDefault();
        $('html, body').animate({
          scrollTop: target.offset().top
        }, 1000);
      }
    });
  });
</script>

<style>
@keyframes fadeIn {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}

.card {
  animation: fadeIn 0.5s;
}

  body {
    font-family: 'Source Sans Pro', sans-serif;
  }

  .breadcrumb {
    transition: background-color 0.3s ease-in-out;
  }

  .breadcrumb:hover {
    background-color: #f8f9fa;
  }

  .dropdown-menu {
    animation: fadeInDown 0.5s;
  }

.card {
  transition: transform 0.2s ease-in-out, opacity 0.2s ease-in-out;
  animation: fadeInDown 0.4s ease-in-out; 
  
}
.element-to-animate {
    will-change: transform, opacity;
}

.card:hover {
  transform: scale(1.01) translate(-1px); 
  opacity: 1;
}
#xyz {
        background-image: url("<%= url %>img/dashbackground.jpg");
        background-size: cover; 
        background-repeat: no-repeat; 
        background-position: center; 
    }
</style>
       
    <script>
     
        function getRTIApplicationDetails(){
            onPageSubmit('<c:out value="${contextRoot}"/>/ws/nmc/dashboard/getApplicationDetails.do');
       
         } 
           
        </script>
        <script>
    	window.onload = function() {

    var errors = "${requestScope.errors}";

    if (errors.trim() !== "") {
        alert("Record Not Found.Please Enter Valid Application Number!");
    }
    	}
</script>
  
</head>
<body id="home" class="bg-grey">
<div class="container-fluid">
    <div class="row p-2 border bg-blue d-flex align-items-center" id="xyz">
        <div class="col-md-1">
            <img src="<%=url%>img/nagpur.png" class="img-fluid">
        </div>

        <div class="col-md-10"> <!-- Modified column width to 10 -->
            <h3 class="m-0" style="color:white;align-content: end;font-size:22;">नागपूर महानगरपालिका, नागपूर</h3>
            <h3 class="m-0" style="color:white;font-size:22;">Right to Services</h3>
        </div>
            	    	<div class="col-md-1"><img src="<%= url%>img/g21.png" class="img-fluid"></div>
    </div>

            
         
        
      
   
    
 
     
       
		<div class="container-fluid mt-4" style="width: 180vh">
                                            <h3 class="text-center"><strong>RTS Application Status</strong></h3>
                                            <hr>
                
                    
                    <div class="row">
                    <div valign="top" id="SetFormHeight">
                        <form name="BirthForm" action="" id="BirthForm">
                        <div class="row">
                            <div class="col-md-3">
                            <div class="mb-3 mt-3">
                                <label for="" class="form-label">Application ID<span
                                    class="mand_error" style="color: red;">*</span>
                                </label> 
                                <input type="text" class="form-control" id="" placeholder=""
                                    name="rtiApplnNumber" value="${requestScope.applicationNumber}" onkeypress="return a(event)"
                                    onkeyup="Display(form)" required>
                            </div>
                            </div>
                            <div class="col-md-2">
                             <div class="mb-3" style="margin-top: 45px;">
                            <button class="btn btn-warning btn_sm" type="submit" id="submit" onclick="getRTIApplicationDetails()">
                               Get Application
                            </button>
                                </div>
                            </div>
                        </div>
                    </div>
                        </form>

                        
        
        <div class="col-md-12 mt-4">
            <div class="table">
            <table class="table table-bordered table-hover mb-0">
                <thead>
                    <tr style="background-color:#0c55c0d6;color:white">
                    <th scope="col" style="width:50%;">Names</th>
                    <th scope="col">Data</th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                    <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Name Of Applicant" /></span>
                    </td>                    
                    <td>
                        <c:out value="${rtiApplication.applicantName}"/>

                    </td>
                    
                    </tr>
                    <tr>
                    
                    <td><span class="ClsLabel" style="font-size:14px"><fmt:message key="Applicant No" /></span>
                        </td>
                    <td>
                        <c:out value="${rtiApplication.rtiApplnNumber}"/>
                    </td>
                    
                    </tr>
                    <tr>
                    
                    <td><span class="ClsLabel" style="font-size:14px"><fmt:message key="Mobile No. Of Applicant" /></span>
                    </td>
                    <td>
                        <c:out value="${rtiApplication.phoneNumber}"/>
                    </td>
                    
                    </tr>
                    <%-- <tr>
                    
                    <td><span class="ClsLabel" style="font-size:14px"><fmt:message key="Ward Name" /></span>
                    </td>
                    <td>
                        <c:out value="${rtiApplication.inWardNumber}"/>
                    </td>
                    
                    </tr> --%>
                    <%-- <tr>
                    
                    <td><span class="ClsLabel" style="font-size:14px"><fmt:message key="Name Of Officer" /></span>
                    </td>
                    <td><c:out value=""/></td>
                    
                    </tr> --%>
                    <tr>
                    
                    <td><span class="ClsLabel" style="font-size:14px"><fmt:message key="Application Status (Completed/Under Process/Rejected)" /></span>
                       </td>
                    <td class="value">
                        <c:choose>
					<c:when test="${rtiApplication.workFlowStatus==0}">
						Form Submitted
					</c:when>
					<c:when test="${rtiApplication.workFlowStatus==3}">
						Under Process
					</c:when>
					<c:when test="${rtiApplication.workFlowStatus==1}">
						Completed
					</c:when>
					<c:when test="${rtiApplication.workFlowStatus==2}">
					
                     <c:choose>
                        <c:when test="${rtiApplication.applicationCost==0.0}">
                             In Progress
                        </c:when>
                        <c:otherwise>
                            Citizen Payment Completed
                        </c:otherwise>
                     </c:choose>
					</c:when>
					
					<c:when test="${rtiApplication.workFlowStatus==5}">
						Rejected
					</c:when>
				</c:choose>
                    </td>
                    
                    </tr>
                                         
                            					
                            					                      <c:if test="${not empty ganeshPermission.policeNoc}">
                    
                    <tr>
                        <td><span class="ClsLabel" style="font-size:14px"><fmt:message key="Police NOC" /></span>
                        </td>
                        <td>
                            <c:set var="doc" value="${fn:split(ganeshPermission.policeNoc, ',')}" />      
                  <%--  <a class="btn btn-success" type="button" target="_blank" href="<c:out value="${doc[0]}"/>"><span>Download</span></a> --%>
                  <a  class="btn btn-success"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[0]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                        </td>
                    </tr>
                            					</c:if>
                            					
                            					                      <c:if test="${not empty ganeshPermission.trafficNoc}">
                    
                    <tr>
                        <td><span class="ClsLabel" style="font-size:14px"><fmt:message key="Traffic NOC" /></span>
                        </td>
                        <td>
                            <c:set var="doc" value="${fn:split(ganeshPermission.trafficNoc, ',')}" />      
                  <%--  <a class="btn btn-success" type="button" target="_blank" href="<c:out value="${doc[0]}"/>"><span>Download</span></a> --%>
                  <a  class="btn btn-success"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[0]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                        </td>
                    </tr>
                            					</c:if>
                            					
                            					                      <c:if test="${not empty ganeshPermission.fireNoc}">
                    
                    <tr>
                        <td><span class="ClsLabel" style="font-size:14px"><fmt:message key="Fire NOC" /></span>
                        </td>
                        <td>
                            <c:set var="doc" value="${fn:split(ganeshPermission.fireNoc, ',')}" />      
                  <%--  <a class="btn btn-success" type="button" target="_blank" href="<c:out value="${doc[0]}"/>"><span>Download</span></a> --%>
                  <a  class="btn btn-success"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[0]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                        </td>
                    </tr>
                            					</c:if>
                            					
                            					
                            					
                            					   <c:if test="${not empty rtiApplication.zoneMap}">
                    
                    <tr>
                        <td><span class="ClsLabel" style="font-size:14px"><fmt:message key="Zone Map" /></span>
                        </td>
                        <td>
                            <c:set var="doc" value="${fn:split(rtiApplication.zoneMap, ',')}" />      
                  <%--  <a class="btn btn-success" type="button" target="_blank" href="<c:out value="${doc[0]}"/>"><span>Download</span></a> --%>
                  <a  class="btn btn-success"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[0]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                        </td>
                    </tr>
                            					</c:if>
                            					<c:if test="${not empty rtiApplication.plantationletter}">
                    
                    <tr>
                        <td><span class="ClsLabel" style="font-size:14px"><fmt:message key="Plantation Letter" /></span>
                        </td>
                        <td>
                            <c:set var="doc" value="${fn:split(rtiApplication.plantationletter, ',')}" />      
            <%--        <a class="btn btn-success" type="button" target="_blank" href="<c:out value="${doc[0]}"/>"><span>Download</span></a> --%>
            <a  class="btn btn-success"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[0]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                        </td>
                    </tr>
                            					</c:if>
                    
                    
                              <c:if test="${not empty rtiApplication.demandletter}">
                    
                    <tr>
                        <td><span class="ClsLabel" style="font-size:14px"><fmt:message key="Demand Bill Receipt" /></span>
                        </td>
                        <td>
                            <c:set var="doc" value="${fn:split(rtiApplication.demandletter, ',')}" />      
<%--                    <a class="btn btn-success" type="button" target="_blank" href="<c:out value="${doc[0]}"/>"><span>Download</span></a>--%> 
<a  class="btn btn-success"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[0]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>                       </td>
                    </tr>
                            					</c:if>
                            					
                            					
                            					
                            					
                            					
                            					   <c:if test="${requestScope.rtiApplication.workFlowStatus==1}">
                    
                    <tr>
                        <td><span class="ClsLabel" style="font-size:14px"><fmt:message key="PDF file" /></span>
                        </td>
                        <td>
                            <c:set var="doc" value="${fn:split(rtiApplication.pdfFilesSavedPath, ',')}" />      
<%--                    <a class="btn btn-success" type="button" target="_blank" href="<c:out value="${doc[0]}"/>"><span>Download</span></a>
 --%>                   	<a  class="btn btn-success"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[0]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                        </td>
                    </tr>
                            					</c:if>
                                  
                              <c:if test="${not empty rtiApplication.workflowComments}">
                                
                                  
                                  <tr>
                    
                    <td><span class="ClsLabel" style="font-size:14px"><fmt:message key="Remark" /></span>
                        </td>
                    <td>
                        <c:out value="${rtiApplication.workflowComments}"/>
                    </td>
                    
                    </tr>
                    </c:if>
                    
                    
                              <c:if test="${not empty rtiApplication.rejectionletter}">
                    
                    <tr>
                        <td><span class="ClsLabel" style="font-size:14px"><fmt:message key="Rejection Letter" /></span>
                        </td>
                        <td>
                            <c:set var="doc" value="${fn:split(rtiApplication.rejectionletter, ',')}" />      
<%--                    <a class="btn btn-success" type="button" target="_blank" href="<c:out value="${doc[0]}"/>"><span>Download</span></a>
 --%>                   <a  class="btn btn-success"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[0]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                        </td>
                    </tr>
                            					</c:if>
    <tr>
    <td><span class="ClsLabel" style="font-size:14px">Download PDF</span></td>
    
    <td>
        
               <c:if test="${not empty rtiApplication.rtiApplnNumber}">
           
           <div>
    <p>Click below to view and download your application details:</p>
    <a href="<%= request.getContextPath() %>/rtiapplication/generateApplicationPdf.do?rtiApplicationId=${rtiApplication.rtiApplicationId}&serviceId=${rtiApplication.rtiserviceid}" 
       target="_blank" onclick="downloadPDF(event, this)">View & Download Application PDF <img src="<%=url%>img/pdf.png" alt="PDF Icon" style="width: 40px; height: 40px;"></a>
</div>
</c:if>
													
    </td>
</tr>
                            					
                    <tr>
                                      
                </tbody>
                </table>
            </div>

        </div>
    
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://code.jquery.com/jquery-3.6.1.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>

<script src="https://kit.fontawesome.com/b99e675b6e.js"></script>



<script type="text/javascript">
'use strict ';

$(".lblmrt").hide();

$(".profile .icon_wrap").on('click', function() {
    $(this).parent().toggleClass("active");
    $(".notifications").removeClass("active");
});

$(".notifications .icon_wrap").on('click', function() {
    $(this).parent().toggleClass("active");
    $(".profile").removeClass("active");
});

$(".show_all .link").on('click', function() {
    $(".notifications").removeClass("active");
    $(".popup").show();
});

$(".close, .shadow").on('click', function() {
    $(".popup").hide();
});

$.ajaxSetup({
    headers: {
        'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
    },
    beforeSend: function() {
        // removeInputValidationErros();
        $("#overlay").fadeIn();
        $('body').css({
            'cursor': 'progress'
        });


        // TODO encrypt before send
    },
    dataFilter: function(retData, json) {
        // TODO decrypt response data before processing further
        return retData;
    },
    complete: function() {
        $("#overlay").fadeOut();
        $('body').css({
            'cursor': 'default'
        });
        //  renewToken();
    }
});

$('input[type=radio][name=balance]').on('change', function() {
    if (this.value == '1') {
        $(".lbleng").show();
        $(".lblmrt").hide();
    } else if (this.value == '2') {

        $(".lbleng").hide();
        $(".lblmrt").show();
    }
});

$('.printMe').on('click', function() {

    window.print();
});

function removeInputValidationErros() {
    $('.input-error').remove();
    $('input').removeClass('invalid');
}

function showFormValidationErrors(formname, jqXHR) {
    removeInputValidationErros();
    for (const [key, value] of Object.entries(jqXHR.responseJSON.errors)) {
        $('form[name=' + formname + '] input[name=' + key + ']').addClass('invalid');
        $('form[name=' + formname + '] input[name=' + key + ']').after(
            '<span class=" text-danger input-error" role="alert">' + value + '</span>');
        $('form[name=' + formname + '] textarea[name=' + key + ']').addClass(
            'invalid');
        $('form[name=' + formname + '] textarea[name=' + key + ']').after(
            '<span class=" text-danger input-error" role="alert">' + value + '</span>');
        $('form[name=' + formname + '] select[name=' + key + ']').addClass('invalid');
        $('form[name=' + formname + '] select[name=' + key + ']').after(
            '<span class=" text-danger input-error" role="alert">' + value + '</span>');
        

        $('#err' + key).after(
            '<span class="text-danger input-error" role="alert">' + value +
            '</span>');
    }
}

$(window).on('load', function(){
            
            
    $('#myModal').modal('show');
    
    $('#myModal .modal-footer .btn').on('click', function(e) {
        console.log('button pressed');              
        // just as an example...
        $('#myModal').modal('hide');                
        // dismiss the dialog
    });
})

function docDownload(filesPath) {
	    var encodedFilePath = encodeURIComponent(filesPath);

	    var encodedFilesPath = btoa(encodedFilePath); 

	    window.open('<c:out value="${contextRoot}"/>/rtsApplication/getPdf.do?fp=' + encodedFilesPath, '_blank');
	}
	
function downloads(id, url) {
	document.getElementById('rtiApplicationRefId').value = id;

	alert("Certificate has been generated successfully.");

	onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/generateApplicationPdf.do');

}


</script>


<script>
function downloadPDF(event, link) {
    event.preventDefault();
    const downloadUrl = link.href;

    // Open PDF in a new tab
    window.open(downloadUrl, '_blank');

    // Trigger download
    const anchor = document.createElement('a');
    anchor.href = downloadUrl;
    anchor.download = 'ApplicationDetails.pdf'; // Specify the desired file name
    anchor.click();
}
</script>
</body>
</html>
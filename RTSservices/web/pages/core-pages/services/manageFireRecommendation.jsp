<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mars.common.utils.CommonUtils"%>
<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

                            <% pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
                                pageContext.setAttribute("DATE_TIME_DB_FORMAT", Constants.DATE_TIME_DB_FORMAT);
                                pageContext.setAttribute("DATE_TIME_FORMAT", WorkflowConstants.WORKFLOW_DATE_FORMAT);
                                pageContext.setAttribute("WORKFLOW_PRIORITY", WorkflowConstants.WORKFLOW_PRIORITY);
                                pageContext.setAttribute("WORKFLOW_PRIORITY_LOW",
                                WorkflowConstants.WORKFLOW_PRIORITY_LOW);
                                pageContext.setAttribute("WORKFLOW_PRIORITY_LOW_LABEL",
                                WorkflowConstants.WORKFLOW_PRIORITY_LOW_LABEL);
                                pageContext.setAttribute("WORKFLOW_PRIORITY_MEDIUM",
                                WorkflowConstants.WORKFLOW_PRIORITY_MEDIUM);
                                pageContext.setAttribute("WORKFLOW_PRIORITY_MEDIUM_LABEL",
                                WorkflowConstants.WORKFLOW_PRIORITY_MEDIUM_LABEL);
                                pageContext.setAttribute("WORKFLOW_PRIORITY_HIGH",
                                WorkflowConstants.WORKFLOW_PRIORITY_HIGH);
                                pageContext.setAttribute("WORKFLOW_PRIORITY_HIGH_LABEL",
                                WorkflowConstants.WORKFLOW_PRIORITY_HIGH_LABEL);
                                pageContext.setAttribute("WORKFLOW_PROCESSDESCRIPTION",
                                WorkflowConstants.WORKFLOW_PROCESSDESCRIPTION);
                                pageContext.setAttribute("WORKFLOW_TRANSITION", WorkflowConstants.WORKFLOW_TRANSITION);
                                pageContext.setAttribute("WORKFLOW_NAME", WorkflowConstants.WORKFLOW_NAME);
                                pageContext.setAttribute("WORKFLOW_ACTION", WorkflowConstants.WORKFLOW_ACTION);
                                pageContext.setAttribute("WORKFLOW_ACTION_COMPLETE_TASK",
                                WorkflowConstants.WORKFLOW_ACTION_COMPLETE_TASK);
                                pageContext.setAttribute("WORKFLOW_ACTION_CREATE_PROCESS",
                                WorkflowConstants.WORKFLOW_ACTION_CREATE_PROCESS); pageContext.setAttribute("TAKE_TASK",
                                WorkflowConstants.WORKFLOW_ACTION_TAKE_TASK); pageContext.setAttribute("KILL_JOB",
                                WorkflowConstants.WORKFLOW_ACTION_KILL_JOB); pageContext.setAttribute("END_JOB",
                                WorkflowConstants.WORKFLOW_ACTION_KILL_JOB);
                                pageContext.setAttribute("WORKFLOW_TRANSISTION",
                                WorkflowConstants.WORKFLOW_TRANSISTION); pageContext.setAttribute("WORKFLOW_ENTITYNAME",
                                WorkflowConstants.WORKFLOW_ENTITYNAME); pageContext.setAttribute("WORKFLOW_ENTITYID",
                                WorkflowConstants.WORKFLOW_ENTITYID); pageContext.setAttribute("WORKFLOW_JOB_ID",
                                WorkflowConstants.WORKFLOW_JOB_ID); pageContext.setAttribute("WORKFLOW_TASK_ID",
                                WorkflowConstants.WORKFLOW_TASK_ID); pageContext.setAttribute("WORKFLOW_COMMENTS",
                                WorkflowConstants.WORKFLOW_COMMENTS); pageContext.setAttribute("WORKFLOW_DUE_DATE",
                                WorkflowConstants.WORKFLOW_DUE_DATE); pageContext.setAttribute("APPL_STATUS_CLOSED",
                                CoreConstants.APPL_STATUS_CLOSED); pageContext.setAttribute("APPL_STATUS_NEW",
                                CoreConstants.APPL_STATUS_NEW); pageContext.setAttribute("APPL_STATUS_PARKED",
                                CoreConstants.APPL_STATUS_PARKED); pageContext.setAttribute("APPL_STATUS_APPROVED",
                                CoreConstants.APPL_STATUS_APPROVED);
                                pageContext.setAttribute("APPL_STATUS_VERIFICATION",
                                CoreConstants.APPL_STATUS_VERIFICATION); pageContext.setAttribute("APPL_STATUS_CREATE",
                                CoreConstants.APPL_STATUS_CREATE); pageContext.setAttribute("APPLICATION_STATUS_LIST",
                                CommonUtils.getApplicationStatusList());
                                pageContext.setAttribute("LABEL_RADIO_COMMERICAL",
                                CoreConstants.LABEL_RADIO_COMMERICAL);
                                pageContext.setAttribute("LABEL_RADIO_CHARITABLE",
                                CoreConstants.LABEL_RADIO_CHARITABLE);
                                pageContext.setAttribute("LABEL_RADIO_GOVERNMENT",
                                CoreConstants.LABEL_RADIO_GOVERNMENT); pageContext.setAttribute("RADIO_COMMERICAL",
                                CoreConstants.RADIO_COMMERICAL); pageContext.setAttribute("RADIO_CHARITABLE",
                                CoreConstants.RADIO_CHARITABLE); pageContext.setAttribute("RADIO_GOVERNMENT",
                                CoreConstants.RADIO_GOVERNMENT); %>


                                <script type="text/javascript" src="<c:out value=" ${contextRoot}" />
                                /scripts/jquery/jquery.ajaxfileupload.js"></script>
                                <script
                                    src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
                                <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
                                <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
                                <script type="text/javascript">
                                    function editRTIApplicationdog() {
                                        //document.getElementById('rtiApplicationId').value = id;
                                        onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editFireRecommendation.do');
                                    }

                                    function saveMandapCertificates() {

                                        onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveFireRecommendationLatter.do');
                                    }

                                    function rtiApplicationSearch() {
                                        onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/listRTIApplicationReports.do');
                                    }

                                    function viewNoting() {
                                        onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/viewNoting.do');
                                    }

                                    function viewDrafts() {
                                        //document.getElementById('manageRTIApplicationId').value=id;
                                        onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/viewDrafts.do');
                                    }

                                    function downloadRTIApplicationList() {
                                        //document.getElementById('manageRTIApplicationId').value=id;
                                        onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/downloadRTIApplicationList.do');
                                    }

                                    function listRTIApplicationReports() {
                                        onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/listRTIApplicationReports.do');
                                    }

                                    function sendEmail() {
                                        //document.getElementById('manageRTIApplicationId').value=id;
                                        document.getElementById('actionTaken').value = 'email';
                                        onPageSubmit('<c:out value="${contextRoot}"/>/emailsms/emailSMS.do');
                                    }

                                    function sendSMS() {
                                        //document.getElementById('manageRTIApplicationId').value=id;
                                        document.getElementById('actionTaken').value = 'sms';
                                        onPageSubmit('<c:out value="${contextRoot}"/>/emailsms/emailSMS.do');
                                    }

                                    function download(id, url) {

                                        document.getElementById('rtiApplicationRefId').value = id;

                                        alert("Certificate has been generated successfully.");

                                        onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/' + url);

                                    }
                                </script>
                                <style type="text/css">
                                    input[type=text] {
                                        height: 35px;
                                        font-size: 15px;
                                    }

                                    .ClsButton {
                                        background-color: rgb(66, 124, 212);
                                        border: none;
                                        border-radius: 5px;
                                        min-height: 30px;
                                        min-width: 120px;

                                    }

                                    .ClsButton:hover {
                                        background: rgb(83, 83, 212);
                                        color: white;
                                    }

                                    a {
                                        text-decoration: none !important;

                                    }
                                </style>
                                <style>
    /* Define custom styles for the table */
    .custom-table {
        width: 100%;
        border-collapse: collapse;
        border: 1px solid #ccc;
    }

    .custom-table th, .custom-table td {
        padding: 10px;
        text-align: center;
        border: 1px solid #ccc;
    }

    /* Define styles for even and odd rows */
    .custom-table tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    .custom-table tr:nth-child(odd) {
        background-color: #ffffff;
    }

    /* Header row styles */
    .custom-table th {
        background-color: #007BFF;
        color: white;
    }
</style>

<style>
.fire-docs-table {
    width: 100%;
    border-collapse: collapse;
    border: 1px solid #d9e2ec;
    border-radius: 8px;
    overflow: hidden;
    background: #fff;
    margin-top: 8px;
}

.fire-docs-table tr {
    border-bottom: 1px solid #edf2f7;
}

.fire-docs-table tr:last-child {
    border-bottom: none;
}

.fire-docs-table td {
    padding: 12px 16px;
    font-size: 14px;
    color: #2d3748;
    vertical-align: middle;
    line-height: 1.45;
}

.fire-docs-table td:first-child {
    width: 65%;
    font-weight: 600;
    color: #1f2d3d;
}

.fire-docs-table td:last-child {
    width: 35%;
    text-align: center;
}

.fire-docs-table .ClsLabel {
    font-size: 14px !important;
    font-weight: 600;
    color: #243447;
}

.fire-docs-table .ClsButton,
.fire-docs-table .bg-button,
.fire-docs-table .action {
    display: inline-block;
    min-width: 105px;
    padding: 8px 16px;
    font-size: 14px;
    font-weight: 600;
    color: #fff !important;
    text-decoration: none;
    text-align: center;
    border: none;
    border-radius: 6px;
    background: linear-gradient(180deg, #3f8de8, #1f6fcb);
    box-shadow: 0 2px 6px rgba(31, 111, 203, 0.2);
    transition: all 0.2s ease;
    cursor: pointer;
    vertical-align: middle;
}

.fire-docs-table .ClsButton:hover,
.fire-docs-table .bg-button:hover,
.fire-docs-table .action:hover {
    background: linear-gradient(180deg, #2f7fda, #155fb8);
    box-shadow: 0 3px 8px rgba(31, 111, 203, 0.3);
}

.fire-docs-table input[type="file"] {
    width: 220px;
    max-width: 100%;
    font-size: 13px;
    padding: 5px 8px;
    border: 1px solid #cbd5e0;
    border-radius: 6px;
    background: #fff;
    color: #2d3748;
    vertical-align: middle;
}

/* upload rows - full width layout */
.fire-docs-table tr td[colspan="2"] {
    padding: 14px 16px;
}

.fire-docs-table tr td[colspan="2"] input[type="file"] {
    margin-right: 12px;
}

.fire-docs-table tr td[colspan="2"] .bg-button {
    min-width: 100px;
}


.fire-docs-table tr.spacer td {
    padding: 0 !important;
    height: 4px !important;
    line-height: 0 !important;
    font-size: 0 !important;
    border: none !important;
    background: transparent !important;
}
/* heading */
.fire-docs-heading {
    background: #dce2e8;
    padding: 10px 14px;
    border-left: 4px solid #2f80ed;
    border-radius: 6px;
    color: #1f2d3d;
    font-size: 15px;
    font-weight: 700;
    margin-bottom: 8px;
}

/* mobile */
@media (max-width: 768px) {
    .fire-docs-table,
    .fire-docs-table tbody,
    .fire-docs-table tr,
    .fire-docs-table td {
        display: block;
        width: 100%;
    }

 
    .fire-docs-table td {
    padding: 10px;
    vertical-align: middle;
}

    .fire-docs-table td:first-child,
    .fire-docs-table td:last-child {
        width: 100%;
    }

    .fire-docs-table input[type="file"] {
        width: 100%;
        margin-bottom: 8px;
        margin-right: 0;
    }

    .fire-docs-table td[colspan="2"] input[type="file"] + .bg-button {
        margin-left: 0;
        margin-top: 6px;
    }
}

</style>

                                <div class="mainHdr">
                                    <h3 style="font-size: 18px; font-weight: bold;">

                                        <fmt:message key="Temporary Fire NOC" />
                                        :
                                        <c:if test="${requestScope.rtiApplication != null}">
                                            <c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
                                        </c:if>

										<!-- <button onclick="editDeprtmentPage()">Edit the Application</button>-->			
                                    </h3>
                                                                    <input type="hidden" name="fireRecommendationRtsId" value="${requestScope.rtiApplication.rtiApplnNumber}"/>
                                    
                                </div>
                                <script>
                                	function editDeprtmentPage()
                                	{
                                		onPageSubmit('${contextRoot}/rtsapplication/newRtsFirerecomendationEditable.do');
                                	}
                                </script>
                                
                             <!--  <div style="vertical-align: top;" id="SetFormHeight">
<div class="container">
    <div class="row justify-content-center">
      <div class="col-md-12">    
        <div class="card">
          <div class="card-body">
           <div class="center-label" style="background-color: #e6f4c6;width: 30%;margin-left: 35%;">
              <label for="selectBox" style="margin-left: 5px;margin-top: 3px;">Fire Stations Section</label>
            </div>
            <div class="row">
              <div class="col">
                <div class="form-group">
                  <label for="selectBox">Fire Stations<span class="text-danger" style="color: red;">*</span></label>
  <select onmouseover="enableSelectForDepartment()" value="${fireRecommendation.fireDepartmentWiseLogin}" style="background-image: none;" class="form-control" name="fireDepartmentWiseLogin" id="fireDepartmentWiseLogin" required>
  <c:choose>
    <c:when test="${requestScope.workflowStatus eq 0}">
      <option value="${fireRecommendation.fireDepartmentWiseLogin}" selected>
        <c:out value="${fireRecommendation.fireDepartmentWiseLogin}"/>
      </option>
      <c:forEach var="fireDepartmentWiseLogin" items="${requestScope.fireDepartmentWiseLogin}">
        <option value="${fireDepartmentWiseLogin.fireDepartmentWiseLoginId}">
          <c:out value="${fireDepartmentWiseLogin.fireDepartmentWiseLoginName}"/>
        </option>
      </c:forEach>
    </c:when>
    <c:otherwise>
      <option value="${fireRecommendation.fireDepartmentWiseLogin}" selected>
        <c:out value="${fireRecommendation.fireDepartmentWiseLogin}"/>
      </option>
    </c:otherwise>
  </c:choose>
</select>


                </div>
              </div>
              
              <div class="col">
                <div class="form-group">
                  <label for="inputBox">Input Box<span class="text-danger" style="color: red;">*</span></label>
			<select onmouseover="enableSelectForSubDepartment()" value="${fireRecommendation.fireSubDepartmentWiseLogin}"  style="background-image: none;" class="form-control" name="fireSubDepartmentWiseLogin" id="fireSubDepartmentWiseLogin" required>
   
   <c:choose>
    <c:when test="${requestScope.workflowStatus eq 0}">
      <option value="${fireRecommendation.fireSubDepartmentWiseLogin}" selected>
        <c:out value="${fireRecommendation.fireSubDepartmentWiseLogin}"/>
      </option>     
    <c:forEach var="fireSubDepartmentWiseLogin" items="${requestScope.fireSubDepartmentWiseLogin}">
        <option value="${fireSubDepartmentWiseLogin.fireSubDepartmentWiseLoginId}">
            <c:out value="${fireSubDepartmentWiseLogin.fireSubDepartmentWiseLoginName}"/>
        </option>
    </c:forEach>
    </c:when>
    <c:otherwise>
    <option value="${fireRecommendation.fireSubDepartmentWiseLogin}" selected>
        <c:out value="${fireRecommendation.fireSubDepartmentWiseLogin}"/>
      </option>
    </c:otherwise>
    </c:choose>
</select>                
</div>
              </div>
            </div>
         <c:choose>
    <c:when test="${requestScope.workflowStatus eq 0}">
        <div style="margin-left: 500px">
            <button class="ClsButton clsButtonUpload" id="submit" onclick="editRTIApplication('${requestScope.rtiRefId}');">Submit</button>
        </div>
    </c:when>
</c:choose>



          </div>
        </div>
      </div>
    </div>
  </div>-->
 <script>


 function editRTIApplication(id) {
     document.getElementById('rtiApplicationRefId').value = id;
     onPageSubmit('${contextRoot}/rtsapplication/updateDepartment.do');
 }
  
 function enableSelectForDepartment() {
     document.getElementById("fireDepartmentWiseLogin").removeAttribute("disabled");
     document.getElementById("submit").removeAttribute("disabled");

	    var selectElement = document.getElementById("fireDepartmentWiseLogin");
	    var options = selectElement.getElementsByTagName("option");
	    for (var i = 0; i < options.length; i++) {
	      options[i].removeAttribute("disabled");
	    }
	  }
 function enableSelectForSubDepartment() {
     document.getElementById("fireSubDepartmentWiseLogin").removeAttribute("disabled");
     document.getElementById("submit").removeAttribute("disabled");

	    var selectElement = document.getElementById("fireSubDepartmentWiseLogin");
	    var options = selectElement.getElementsByTagName("option");
	    for (var i = 0; i < options.length; i++) {
	      options[i].removeAttribute("disabled");
	    }
	  }
  </script>
  
    <input type="hidden" name="id" value="${fireRecommendation.fireRecommendationId}">
    <table width="100%" border="0" cellpadding="2" cellspacing="2" class="container">
                                           <tr>
    <td colspan="4">    
        <h6 style="background-color:#dce2e8; padding:10px;" class="rounded-2"><strong> 
        						Applicant details for Building Construction 
        
        </strong>
        </h6>
    </td>
</tr>
                                        <tr>

                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Title(शीर्षक): " />
                                                </span></td>
                                            <td>
                                            <input type="text" class="form-control" style="width: 270px"
value="<c:choose>
           <c:when test='${fireRecommendation.title == "1"}'>Mr</c:when>
           <c:when test='${fireRecommendation.title == "2"}'>Mrs</c:when>
           <c:when test='${fireRecommendation.title == "3"}'>Ms</c:when>
           <c:otherwise></c:otherwise>
       </c:choose>" />
                                
                                                    </td>

                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="label.mandap.firstname" />:
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.firstName}" />" /></td>
                                        </tr>
                                        <tr>
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="label.mandap.middlename" />:
                                                </span><span class="ClsRequiredFields"></span></td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.middleName}" />" />
                                            </td>

                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="label.mandap.lastname" />:
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.lastName}" />" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="label.mandap.fullname" />:
                                                </span><span class="ClsRequiredFields"></span>
                                            </td>
                                            <td>
                                                <input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.fullName}" />" />
                                            </td>
                                            
                                          

                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Mobile Number(मोबाईल नंबर)" />
                                                </span>: </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.mobileNo}" />" /></td>



                                        </tr>
                                        <tr>
                                          
                                             <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Email (ईमेल)" />:
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.appEmail}" />" /></td>
                                            
                                            
                                             <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Street Name(रस्त्याचे नाव)" />
                                                </span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.streetName}" />" />
                                            </td>
                                            
                                            
                                        </tr>
                                        <tr>
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="House Number (घर क्रमांक)" />
                                                </span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.houseNo}" />" />
                                            </td>
                                            
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Pin Code(पिन कोड)" />
                                                </span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.pinCode}" />" />
                                            </td>

                                            
                                        </tr>
                                        <tr>

                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Land Mark (लँडमार्क)" />:
                                                </span></td>
                                                
                                                   <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.landmark}" />" /></td>



                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Plot Number प्लॉट नंबर" />:
                                                </span><span class="ClsRequiredFields"></span>
                                            </td>
                                            <td>
                                                <input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.plotNumber}" />" />
                                            </td>
                                        </tr>
                                        <tr>
                                          <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Survey Nubmer (सर्व्हे नंबर)" />:
                                                </span></td>
                                            <td><input class="form-control" style="width: 270px" id="ownerAddress"
                                                    maxlength="200" value="${fireRecommendation.surveyNo}">
                                            </td>
                                            
                                         <%--    <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Name Of Power Attorney(पॉवर अॅटर्नीचे नाव)" />:
                                                </span></td>
                                            <td><input class="form-control" style="width: 270px" id="ownerAddress"
                                                    maxlength="200" value="${fireRecommendation.nameOfPowerAttorney}">
                                            </td> --%>
                                            

                                          <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Sheet No (शिट क्रमांक)" />:
                                                </span></td>
                                            <td><input class="form-control" style="width: 270px" id="ownerAddress"
                                                    maxlength="200" value="${fireRecommendation.sheetNo}">
                                            </td>
                                                                                    </tr>
                                            <tr>
                                              <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Khasara No (खसरा क्रमांक)" />:
                                                </span></td>
                                            <td><input class="form-control" style="width: 270px" id="ownerAddress"
                                                    maxlength="200" value="${fireRecommendation.khasaraNo}">
                                            </td>
                                            
                                        
                                        
                                        
                                        <!-- 
                                             <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="No Standby(स्टँडबाय नाही)" />:
                                                </span></td>
                                            <td><input class="form-control" style="width: 270px" id="ownerAddress"
                                                    maxlength="200" value="${fireRecommendation.noStandby}">
                                            </td>-->
                                            
                                        

                                           


                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Address of Owner" />:
                                                </span><span class="ClsRequiredFields"></span></td>
                                            <td><textarea class="form-control" style="width: 270px" id="ownerAddress"
                                                    maxlength="200" rows="2"
                                                    name="ownerAddress">${fireRecommendation.addressOfPowerAttorney}</textarea>

                                            </td>
                                            
                                            
                                        </tr>
                                        
                                        <tr>
    <td colspan="4">    
        <h6 style="background-color:#dce2e8; padding:10px;" class="rounded-2">
						<strong> Architecture Details for Building Constructions </strong>
        </h6>
    </td>
</tr>

                                        
                                     
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Title(शीर्षक): " />
                                                </span></td>
                                            <td>
                                                         <input type="text" class="form-control" style="width: 270px"
value="<c:choose>
           <c:when test='${fireRecommendation.titleArchitecture == "1"}'>Mr</c:when>
           <c:when test='${fireRecommendation.titleArchitecture == "2"}'>Mrs</c:when>
           <c:when test='${fireRecommendation.titleArchitecture == "3"}'>Ms</c:when>
           <c:otherwise></c:otherwise>
       </c:choose>" />
                          </td>                  
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="label.mandap.firstname" />:
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.firstNameArchitecture}" />" /></td>
                                        </tr>
                                        <tr>
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="label.mandap.middlename" />:
                                                </span><span class="ClsRequiredFields"></span></td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.middleNameArchitecture}" />" />
                                            </td>

                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="label.mandap.lastname" />:
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.lastNameArchitecture}" />" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="label.mandap.fullname" />:
                                                </span><span class="ClsRequiredFields"></span>
                                            </td>
                                            <td>
                                                <input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.fullNameArchitecture}" />" />
                                            </td>
                                            
                                          

                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Mobile Number(मोबाईल नंबर)" />
                                                </span>: </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.mobileNoArchitecture}" />" /></td>



                                        </tr>
                                        <tr>
                                          
                                             <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Email (ईमेल)" />:
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.appEmailArchitecture}" />" /></td>
                                                   
                                                    <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Architect Licence Number (वास्तुकार परवानगी क्रमांक)" />:
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.architectLicenceNumber}" />" /></td>
                                                   
                                                   </tr>
                                                    <tr>
    <td colspan="4">    
        <h6 style="background-color:#dce2e8; padding:10px;" class="rounded-2"><strong> Application Form Details
        </strong>
        </h6>
    </td>
</tr>
                    <tr> 
                                                      <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Name of Building Owner" />:
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.nameofBuildingOwner}" />" /></td>
                                            
                                            

                                        
                                        
                                             <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Address of Building" />:
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.addressofbuilding}" />" /></td>
                                        </tr>
                                         
                                                               <tr>
                                             <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="zone(झोन)" />
                                                </span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.zoneNO}" />" /></td>

                                           <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Ward No(प्रभाग क्र.)" />
                                                </span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.wardNo}" />" /></td>
                                        </tr>
                                        
                                        

                                        <tr>
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Height Of Building(इमारतीची उंची)" /></span>:
                                            </td>
                                            <td>
                                            <input type="text" class="form-control" style="width: 270px"
value="<c:choose>
    <c:when test='${fireRecommendation.typeOfHeight == 1}'>Building up to 45 m</c:when>
    <c:when test='${fireRecommendation.typeOfHeight == 2}'>Building above 45 m</c:when>
    <c:otherwise></c:otherwise>
</c:choose>" />
                                          </td>

                                              <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Floors(मजले)" /></span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.floors}" />" />
                                            </td>
                                        </tr>

                                        <tr>



                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Type Of Building(इमारतीचा प्रकार)" />
                                                </span>:
                                            </td>
                                            <td>
                                          <input type="text" class="form-control" style="width: 270px"
value="<c:choose>
    <c:when test='${fireRecommendation.typeOfBuilding == 1}'>Residential Building</c:when>
    <c:when test='${fireRecommendation.typeOfBuilding == 2}'>Institutional Building</c:when>
    <c:when test='${fireRecommendation.typeOfBuilding == 3}'>Commercial Building</c:when>
    <c:when test='${fireRecommendation.typeOfBuilding == 4}'>Industrial Building</c:when>
    <c:when test='${fireRecommendation.typeOfBuilding == 5}'>Mix Occupancy</c:when>
    <c:otherwise></c:otherwise>
</c:choose>" /></td>
                                            
                                             <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Sub Type Of Building(इमारतीचा प्रकार)" />
                                                </span>:
                                            </td>
                                            <td>
                                          <input type="text" class="form-control" style="width: 270px"
value="<c:choose>
    <c:when test='${fireRecommendation.subTypeOfBuilding == 1}'>Lodging Boarding</c:when>
    <c:when test='${fireRecommendation.subTypeOfBuilding == 2}'>Dormitories</c:when>
    <c:when test='${fireRecommendation.subTypeOfBuilding == 3}'>Multi-level Car Parking</c:when>
    <c:when test='${fireRecommendation.subTypeOfBuilding == 4}'>Apartment / Multifamily Dwelling</c:when>
    <c:when test='${fireRecommendation.subTypeOfBuilding == 5}'>Mechanized Automated Car Parking</c:when>
    <c:when test='${fireRecommendation.subTypeOfBuilding == 6}'>School, College</c:when>
    <c:when test='${fireRecommendation.subTypeOfBuilding == 7}'>University</c:when>
    <c:when test='${fireRecommendation.subTypeOfBuilding == 8}'>Hospital</c:when>
    <c:when test='${fireRecommendation.subTypeOfBuilding == 9}'>Nursing Home</c:when>
    <c:when test='${fireRecommendation.subTypeOfBuilding == 10}'>Assembly (Marriage Hall, Theatre, etc)</c:when>
    <c:when test='${fireRecommendation.subTypeOfBuilding == 11}'>Business (Office, IT, Library)</c:when>
    <c:when test='${fireRecommendation.subTypeOfBuilding == 12}'>Mercantile (Shops, Mall)</c:when>
    <c:when test='${fireRecommendation.subTypeOfBuilding == 13}'>Hotels (Starred)</c:when>
    <c:when test='${fireRecommendation.subTypeOfBuilding == 14}'>Storage (Warehouse, Cold Storage)</c:when>
    <c:when test='${fireRecommendation.subTypeOfBuilding == 15}'>Industrial (Hazard)</c:when>
    <c:when test='${fireRecommendation.subTypeOfBuilding == 16}'>Hazardous (Petrol Pump, LPG)</c:when>
    <c:otherwise></c:otherwise>
</c:choose>" />
</td>
              <tr>                              
                                              <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Height of
									Building&nbsp(इमारतीची उंची-mtr)" />
                                                </span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.hightOfBuilding}" />" />
                                            </td>
    <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="
FireFighting System as per N.B.C&nbsp(N.B.C नुसार अग्निशमन यंत्रणा)
									" />
                                                </span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.fireFightingSystemNBC}" />" />
                                            </td>


                                       

                                        </tr>
                                        <tr>
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Type Of Construction(बांधकामाचा प्रकार)" />
                                                </span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
value="<c:choose>
    <c:when test='${fireRecommendation.typeOfConstruction == 1}'>
        (आर. सी. सी) / RCC
    </c:when>
    <c:when test='${fireRecommendation.typeOfConstruction == 2}'>
        इतर पक्के / (Other Constructed)
    </c:when>
    <c:when test='${fireRecommendation.typeOfConstruction == 3}'>
        अर्ध पक्के / (Partially Constructed)
    </c:when>
    <c:when test='${fireRecommendation.typeOfConstruction == 4}'>
        कच्चे / (Temporary)
    </c:when>
    <c:otherwise></c:otherwise>
</c:choose>" />
</td>


                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Total Plot Area(एकूण भूखंड क्षेत्रफळ)" />:
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.totalPlotArea}" />" />
                                            </td>

                                        </tr>

                                        <tr>
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Build Up Area(क्षेत्र तयार करा)" />
                                                </span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.buildUpArea}" />" /></td>



                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Super Build Up Area(सुपर बिल्ड एरिया)" />:
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.superBuildarea}" />" />
                                            </td>

                                        </tr>

                                        <tr>
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Number Of Building(इमारतींची संख्या)" />
                                                </span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.numberOfBuilding}" />" />
                                            </td>


                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Number Of Wings(विंग्स ची संख्या)" />:
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.numOfWings}" />" /></td>
                                        </tr>
                                        <tr>
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Present Position of Building&nbsp(इमारतीची वर्तमान स्थिती)" />
                                                </span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
value="<c:choose>
    <c:when test='${fireRecommendation.presentPosition == 1}'>Proposed</c:when>
    <c:when test='${fireRecommendation.presentPosition == 2}'>Existing</c:when>
    <c:otherwise></c:otherwise>
</c:choose>" /> </td>



                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Front Margin Width(फ्रंट मार्जिन रुंदी)" />:
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.frontMarginWidth}" />" />
                                            </td>
                                        </tr>

                                        <tr>
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Real Margin(रिअल मार्जिन)" />
                                                </span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.realMargin}" />" /></td>


                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Side Margine1(साइड मार्जिन1)" />:
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.sideMargine}" />" /></td>

                                        </tr>
                                        <tr>
                                         <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Side Margine2(साइड मार्जिन2)" />:
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.sideMargineTwo}" />" /></td>
                                        
                                        
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Width Of Entrance(प्रवेशद्वाराची रुंदी)" />
                                                </span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.widthOfEntrance}" />" />
                                            </td>


      										<!--  <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Number StandBy(नंबर स्टँडबाय)" />
                                                </span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.numStandBy}" />"
                                                /></td>-->

                                        </tr>

                                        
                                      
                                        <tr>         
                                        
                                         <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Proposed site of A.C
									Plant&nbsp(A.C प्लांटची प्रस्तावित जागा)" />
                                                </span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.acPlant}" />" />
                                            </td>
                                                                                   
                                                    

                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Area Of Basement(तळघराचे क्षेत्रफळ)" />
                                                </span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.areaOfBasement}" />" />
                                            </td>

                                        </tr>

                                        <tr>
                                        
                                               <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Capacity Of Under Ground Tank(अंडर ग्राउंड टँकची क्षमता)" />
                                                </span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.capacityOfUnderGroundTank}" />" />
                                            </td>
                                            
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Capacity OF Over Head Tank(ओव्हर हेड टँकची क्षमता)" />
                                                </span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.capacityOFOverHeadTank}" />" />
                                            </td>
                                           

                                           

                                        </tr>
                                        <tr>
                                        
                                         <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Location Of Transfer Room(हस्तांतरण कक्षाचे ठिकाण)" />
                                                </span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.locationOfTransferRoom}" />" />
                                            </td>
                                             <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Number of Exposure Hazard [As per sanctioned plan] : East" />
                                                </span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.east}" />" />
                                            </td>
                                            </tr>
                                            <tr>
                                              <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Number of Exposure Hazard [As per sanctioned plan] : West" />
                                                </span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.west}" />" />
                                            </td>
                                              <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Number of Exposure Hazard [As per sanctioned plan] : South" />
                                                </span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.south}" />" />
                                            </td>
                                            </tr>
                                            <tr>
                                              <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Number of Exposure Hazard [As per sanctioned plan]  : North" />
                                                </span>:
                                            </td>
                                            <td><input type="text" class="form-control" style="width: 270px"
                                                    value="<c:out value=" ${fireRecommendation.north}" />" />
                                            </td>
                                            
                                            
                                                    <c:choose>
    <c:when test="${fireRecommendation.electricPump == 1}">
     <td><span class="ClsLabel" style="font-size: 14px">
                <fmt:message key="Electric Pump Capacity(विद्युत पंप क्षमता)" />:
            </span></td>
         <td><input type="text" class="form-control" style="width: 270px"
                value="<c:out value="${fireRecommendation.electricPumpCapacity}" />" /></td>
        
    </c:when>
    <c:otherwise>
       <td><span class="ClsLabel" style="font-size: 14px">
                <fmt:message key="Electric Pump(विद्युत पंप)" />:
            </span></td>
        <td><input type="text" class="form-control" style="width: 270px"
                value="<c:out value="No" />" /></td>
    </c:otherwise>
</c:choose>

                                           

                                         

                                        </tr>
                                        <tr>
          <c:choose>
    <c:when test="${fireRecommendation.dieselPump == 1}">
     <td><span class="ClsLabel" style="font-size: 14px">
                <fmt:message key="Diesel Pump Capacity(डिझेल पंप क्षमता)" />:
            </span></td>
         <td><input type="text" class="form-control" style="width: 270px"
                value="<c:out value="${fireRecommendation.dieselPumpCapacity}" />" /></td>
        
    </c:when>
    <c:otherwise>
       <td><span class="ClsLabel" style="font-size: 14px">
                <fmt:message key="Diesel Pump(डिझेल पंप)" />:
            </span></td>
        <td><input type="text" class="form-control" style="width: 270px"
                value="<c:out value="No" />" /></td>
    </c:otherwise>
</c:choose>

   <c:choose>
    <c:when test="${fireRecommendation.jockyPump == 1}">
     <td><span class="ClsLabel" style="font-size: 14px">
                <fmt:message key="Jocky Pump Capacity(जॉकी पंप क्षमता)" />:
            </span></td>
         <td><input type="text" class="form-control" style="width: 270px"
                value="<c:out value="${fireRecommendation.jockyPumpCapacity}" />" /></td>
        
    </c:when>
    <c:otherwise>
       <td><span class="ClsLabel" style="font-size: 14px">
                <fmt:message key="Jocky Pump(जॉकी पंप)" />:
            </span></td>
        <td><input type="text" class="form-control" style="width: 270px"
                value="<c:out value="No" />" /></td>
    </c:otherwise>
</c:choose>

                                         
                                        </tr>
                                        <tr>
                                        
                                        <c:choose>
    <c:when test="${fireRecommendation.boosterPump == 1}">
     <td><span class="ClsLabel" style="font-size: 14px">
                <fmt:message key="Booster Pump Capacity(बूस्टर पंप क्षमता)" />:
            </span></td>
         <td><input type="text" class="form-control" style="width: 270px"
                value="<c:out value="${fireRecommendation.boosterPumpCapacity}" />" /></td>
        
    </c:when>
    <c:otherwise>
       <td><span class="ClsLabel" style="font-size: 14px">
                <fmt:message key="Booster Pump(बूस्टर पंप)" />:
            </span></td>
        <td><input type="text" class="form-control" style="width: 270px"
                value="<c:out value="No" />" /></td>
    </c:otherwise>
</c:choose>
                                          

                                        </tr>
                                         <tr>
                                              <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Fire Stations" />
                                                </span>:
                                            </td>
                                            <td>
<c:choose>
    <c:when test="${fireRecommendation.fireDepartmentWiseLogin == 1}">
        <input type="text" class="form-control" style="width: 270px" value="Civil Fire Station" />
    </c:when>
    <c:when test="${fireRecommendation.fireDepartmentWiseLogin == 2}">
        <input type="text" class="form-control" value="Cotton Market" />
    </c:when>
    <c:when test="${fireRecommendation.fireDepartmentWiseLogin == 3}">
        <input type="text" class="form-control" value="Ganjipeth" />
    </c:when>
    <c:when test="${fireRecommendation.fireDepartmentWiseLogin == 4}">
        <input type="text" class="form-control" value="Lakadganj" />
    </c:when>
    <c:when test="${fireRecommendation.fireDepartmentWiseLogin == 5}">
        <input type="text" class="form-control" value="Sakkardara" />
    </c:when>
    <c:when test="${fireRecommendation.fireDepartmentWiseLogin == 6}">
        <input type="text" class="form-control" value="Kalamna" />
    </c:when>
    <c:when test="${fireRecommendation.fireDepartmentWiseLogin == 7}">
        <input type="text" class="form-control" value="Sugat Nagar" />
    </c:when>
    <c:when test="${fireRecommendation.fireDepartmentWiseLogin == 8}">
        <input type="text" class="form-control" value="Narendra Nagar" />
    </c:when>
    <c:when test="${fireRecommendation.fireDepartmentWiseLogin == 9}">
        <input type="text" class="form-control" value="Trimurti Nagar" />
    </c:when>
    <c:when test="${fireRecommendation.fireDepartmentWiseLogin == 10}">
        <input type="text" class="form-control" value="Wathoda Fire Station" />
    </c:when>
    <c:otherwise>
        <input type="text" class="form-control" value="" />
    </c:otherwise>
</c:choose>
</td>
                                              <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Category" />
                                                </span>:
                                            </td>
                                            <td>
<c:choose>
    <c:when test="${fireRecommendation.fireSubDepartmentWiseLogin == 1}">
        <input type="text" class="form-control"
        value="Below 24m in height and built up area less than 500 sqm at any floor" />
    </c:when>
    <c:when test="${fireRecommendation.fireSubDepartmentWiseLogin == 2}">
        <input type="text" class="form-control"
        value="Below 24m in height and built up area above 500 sqm at any floor" />
    </c:when>
    <c:when test="${fireRecommendation.fireSubDepartmentWiseLogin == 3}">
        <input type="text" class="form-control"
        value="All Special Buildings above 24m in height" />
    </c:when>
    <c:otherwise>
        <input type="text" class="form-control" value="" />
    </c:otherwise>
</c:choose>
</td>
                                            </tr>
                                        <tr>
                                        
                                           
                                           <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Number of Lift(लिफ्टची संख्या)" />:
                                                </span></td>
                                            
   <td>
<table class="custom-table">
    <thead>
        <tr>
            <th>Number Of Lift(लिफ्टची संख्या)</th>
            <th>Type Of Lift(लिफ्टचा प्रकार)</th>
        </tr>
    </thead>
    <tbody>
        <c:set var="typeOfLift" value="${fn:split(fireRecommendation.typeOfLift, ',')}" />
        <c:set var="typeOfLiftSize" value="${fn:length(typeOfLift)}" />
        <c:forEach var="typeOfLiftValues" items="${typeOfLift}" varStatus="loop">
            <c:choose>
                <c:when test="${loop.index == 0}">
                    <tr>
                        <td rowspan="${typeOfLiftSize}" style="text-align: center;">${fireRecommendation.numberOfExternal}</td>
                        <td>${loop.index + 1}.&nbsp${typeOfLiftValues}</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td>${loop.index + 1}.&nbsp${typeOfLiftValues}</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tbody>
</table>

   </td>

 <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Number of External/Emergency Staircase Provided (प्रदान केलेल्या बाह्य/ आपत्कालीन जिन्याची संख्या )" />
                                                </span>:
                                            </td>
                                            
   <td>
<table class="custom-table">
    <thead>
        <tr>
            <th >Number of External Staircase(बाह्य जिन्याची संख्या)</th>
            <th >Width of Staircase (जिन्याची रुंदी)</th>
        </tr>
    </thead>
    <tbody>
        <c:set var="numberOfExternal" value="${fn:split(fireRecommendation.widthOfExternal, ',')}" />
        <c:set var="numberOfExternalValuesSize" value="${fn:length(numberOfExternal)}" />
        <c:forEach var="numberOfExternalValues" items="${numberOfExternal}" varStatus="loop">
            <tr>
                <c:choose>
                    <c:when test="${loop.index == 0}">
                        <td rowspan="${numberOfExternalValuesSize}">${fireRecommendation.numberOfExternal}</td>
                    </c:when>
                   
                </c:choose>
                <td>${loop.index+1}.&nbsp${numberOfExternalValues}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

   </td>
   
                                            
                                           

                                        </tr>
                                        
                                      <tr>
                                       <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Number of Internal/Emergency Staircase Provided (प्रदान केलेल्या बाह्य/ आपत्कालीन जिन्याची संख्या )" />
                                                </span>:
                                            </td>
                                        <td>
<table class="custom-table">
    <thead>
        <tr>
            <th >Number of Internal Staircase(अंतर्गत जिन्यांची संख्या)</th>
            <th >Width of Staircase (जिन्याची रुंदी)</th>
        </tr>
    </thead>
    <tbody>
    
        <c:set var="numberOfInternal" value="${fn:split(fireRecommendation.widthInternalStaircaseProvided, ',')}" />
        <c:set var="numberOfInternalValuesSize" value="${fn:length(numInternalStaircaseProvided)}" />
        <c:forEach var="numberOfInternalValues" items="${numberOfInternal}" varStatus="loop">
            <tr>
                <c:choose>
                    <c:when test="${loop.index == 0}">
                        <td rowspan="${numberOfInternalValuesSize}">${fireRecommendation.numberOfExternal}</td>
                    </c:when>
                   
                </c:choose>
                <td>${loop.index+1}.&nbsp${numberOfInternalValues}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

   </td>
   
  
   			
 <!--   <td><span class="ClsLabel" style="font-size: 14px">
                                                    <fmt:message key="Total Fees Structure" />
                                                </span>:
                                            </td>
                                        
  <td>
   <table class="custom-table">
   	<thead>
   		<tr>
   			 <th>Fees Name</th>
   			 <th>Amount</th>
   		</tr>
   	</thead>
   	<tbody>
   	
   		<tr>
   			<td>Total Fees</td>
   			<td>${fireRecommendation.totalFeess}</td>
   		</tr>
   		<tr>
   			<td>2% Scrutiny Fees on Above Total:</td>
   			<td>${fireRecommendation.scrutinyFeesOnAboveTotal}</td>
   		</tr>
   	</tbody>
   </table>
   
   </td>
   </tr>-->
   </tr>
   </table>
  <tr>
    <td>
        <span class="ClsLabel" style="font-size: 14px">
            <fmt:message key="Total Fees Structure" />
        </span>:
    </td>
</tr>

<tr>
    <td>

        <table class="custom-table" border="1" width="100%">

            <thead>
                <tr>
                    <th>Fees Name</th>
                    <th>Amount</th>

                 <c:if test="${requestScope.rtiApplication.workFlowStatus == 0}">
                        <th>Modify Amount (+/-)</th>

                    </c:if>

                    <th>Remarks</th>
                </tr>
            </thead>

            <tbody>

                <!-- ================= TOTAL FEES ================= -->
                <tr>

                    <td>

                        <c:choose>

                            <c:when test="${empty fireRecommendation.updatedTotalFees}">
                                Total Fees
                            </c:when>

                            <c:otherwise>
                                Updated Total Fees
                            </c:otherwise>

                        </c:choose>

                    </td>

                    <td>

                        <input type="text"
                               id="totalFees"
                               value="${not empty fireRecommendation.updatedTotalFees
                                        ? fireRecommendation.updatedTotalFees
                                        : fireRecommendation.totalFeess}"
                               readonly="readonly" />

                    </td>

                    <td>-</td>
                    <td>-</td>

                </tr>


                <!-- ================= SCRUTINY FEES ================= -->
                <tr>

                    <td>
                        2% Scrutiny Fees on Above Total
                    </td>

                    <td>

                        <input type="text"
                               id="scrutinyFees"
                               value="${not empty fireRecommendation.updatedScrutinyFees
                                        ? fireRecommendation.updatedScrutinyFees
                                        : fireRecommendation.scrutinyFeesOnAboveTotal}"
                               readonly="readonly" />

                    </td>


                    <!-- MODIFY TOTAL FEES ONLY -->
                   <c:if test="${requestScope.rtiApplication.workFlowStatus == 0}">
                        <td>

                            <select id="feeAction"
                                    onchange="updateFees()">

                                <option value="">Select</option>

                                <option value="increase">
                                    Increase
                                </option>

                                <option value="decrease">
                                    Decrease
                                </option>

                            </select>


                            <input type="number"
                                   id="modifyAmount"
                                   min="0"
                                   step="0.01"
                                   placeholder="Enter Amount"
                                   onkeyup="updateFees()" />

                        </td>

                    </c:if>


                    <!-- REMARKS -->
                    <td>

                        <textarea id="remarks"
                                  rows="2"
                                  cols="25"
                                  placeholder="Enter remarks">${fireRecommendation.remarkforL2}</textarea>

                    </td>

                </tr>


                <!-- ================= UPDATED TOTAL ================= -->
               <c:if test="${requestScope.rtiApplication.workFlowStatus == 0}">
                    <tr>

                        <td>
                            <b>Updated Total Fees</b>
                        </td>

                        <td>

                            <input type="text"
                                   id="updatedTotalFees"
                                   readonly="readonly" />

                        </td>

                        <td colspan="2"></td>

                    </tr>

                </c:if>

            </tbody>

        </table>


        <!-- ================= HIDDEN VALUES ================= -->

        <input type="hidden"
               id="fireId"
               value="${fireRecommendation.fireRecommendationId}" />

        <input type="hidden"
               id="rtiApplnId"
               name="rtiApplnId"
               value="${fireRecommendation.rti_ref_id}" />

    </td>
</tr>


<!-- ================= SAVE BUTTON ================= -->

<c:if test="${requestScope.rtiApplication.workFlowStatus == 0}">
    <tr>

        <td colspan="2" align="center">

            <input type="button"
                   value="Save Updated Fees"
                   class="btn btn-primary"
                   onclick="saveUpdatedFees()" />

        </td>

    </tr>

</c:if>


<script type="text/javascript">


/* =========================================================
   INITIALIZE UPDATED TOTAL
   ========================================================= */

window.onload = function () {

    var totalFeesElement =
        document.getElementById("totalFees");

    var updatedTotalFeesElement =
        document.getElementById("updatedTotalFees");


    if (totalFeesElement && updatedTotalFeesElement) {

        updatedTotalFeesElement.value =
            parseFloat(totalFeesElement.value || 0).toFixed(2);
    }

};


/* =========================================================
   UPDATE TOTAL FEES ONLY
   ========================================================= */

function updateFees() {

    var totalFeesElement =
        document.getElementById("totalFees");

    var modifyAmountElement =
        document.getElementById("modifyAmount");

    var feeActionElement =
        document.getElementById("feeAction");

    var updatedTotalFeesElement =
        document.getElementById("updatedTotalFees");


    var totalFees =
        parseFloat(totalFeesElement.value) || 0;

    var modifyAmount =
        parseFloat(modifyAmountElement.value) || 0;

    var action =
        feeActionElement.value;


    var updatedTotal =
        totalFees;


    /* =====================================================
       NO ACTION / NO AMOUNT
       ===================================================== */

    if (action === "" || modifyAmount <= 0) {

        updatedTotalFeesElement.value =
            totalFees.toFixed(2);

        return;
    }


    /* =====================================================
       INCREASE
       ===================================================== */

    if (action === "increase") {

        updatedTotal =
            totalFees + modifyAmount;
    }


    /* =====================================================
       DECREASE
       ===================================================== */

    else if (action === "decrease") {

        /*
         * Total Fees should not become
         * zero or negative
         */

        if ((totalFees - modifyAmount) <= 0) {

            alert("Total Fees cannot be zero or negative");

            modifyAmountElement.value = "";

            updatedTotalFeesElement.value =
                totalFees.toFixed(2);

            return;
        }


        updatedTotal =
            totalFees - modifyAmount;
    }


    /* =====================================================
       SET UPDATED TOTAL
       ===================================================== */

    updatedTotalFeesElement.value =
        updatedTotal.toFixed(2);

}


/* =========================================================
   SAVE UPDATED FEES
   ========================================================= */

function saveUpdatedFees() {

    var fireId =
        document.getElementById("fireId").value;

    var rtiApplnId =
        document.getElementById("rtiApplnId").value;

    var remarks =
        document.getElementById("remarks").value;

    var updatedTotalFees =
        document.getElementById("updatedTotalFees").value;


    /* =====================================================
       VALIDATION
       ===================================================== */

    if (remarks.trim() === "") {

        alert("Please enter remarks");

        document.getElementById("remarks").focus();

        return false;
    }


    if (updatedTotalFees === "") {

        alert("Please update fees first");

        return false;
    }


    /* =====================================================
       CREATE DYNAMIC FORM
       ===================================================== */

    var form =
        document.createElement("form");

    form.method = "POST";

    form.action =
        "${pageContext.request.contextPath}/rtsapplication/saveUpdatedFees.do";


    /* =====================================================
       FIRE ID
       ===================================================== */

    var hiddenFireId =
        document.createElement("input");

    hiddenFireId.type = "hidden";

    hiddenFireId.name = "fireId";

    hiddenFireId.value = fireId;

    form.appendChild(hiddenFireId);


    /* =====================================================
       RTI APPLICATION ID
       ===================================================== */

    var hiddenRtiApplnId =
        document.createElement("input");

    hiddenRtiApplnId.type = "hidden";

    hiddenRtiApplnId.name = "rtiApplnId";

    hiddenRtiApplnId.value = rtiApplnId;

    form.appendChild(hiddenRtiApplnId);


    /* =====================================================
       REMARKS
       ===================================================== */

    var hiddenRemarks =
        document.createElement("input");

    hiddenRemarks.type = "hidden";

    hiddenRemarks.name = "remarks";

    hiddenRemarks.value = remarks;

    form.appendChild(hiddenRemarks);


    /* =====================================================
       UPDATED TOTAL FEES
       ===================================================== */

    var hiddenTotal =
        document.createElement("input");

    hiddenTotal.type = "hidden";

    hiddenTotal.name = "updatedTotalFees";

    hiddenTotal.value = updatedTotalFees;

    form.appendChild(hiddenTotal);


    /* =====================================================
       SUBMIT
       ===================================================== */

    document.body.appendChild(form);

    form.submit();

}

</script>
                                        
  

<table class="custom-table">
    <thead>
        <tr>
                        <th>Categories</th>
            <th>Type of Floor</th>
            <th>Residential)</th>
                        <th>Institutional</th>
            
                        <th>Commercial</th>
            
            <th>Industrial</th>
            <th>Total Fees(₹)</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="fireDetail" items="${requestScope.fireDetails}">
<tr>
<td>
<c:choose>
    <c:when test="${fireDetail.floorName == 1}">Total Parking Area</c:when>
    <c:when test="${fireDetail.floorName == 2}">Basement Built-up Area</c:when>
    <c:when test="${fireDetail.floorName == 3}">Floor-wise Built-up Area</c:when>
    <c:otherwise></c:otherwise>
</c:choose>
</td>    
<td>
<c:choose>
    <c:when test="${fireDetail.fireFloorTypes == 1}">Basement</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 2}">Stilt level</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 3}">Basement 1</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 4}">Basement 2</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 5}">Basement 3</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 6}">Ground Floor</c:when>

    <c:when test="${fireDetail.fireFloorTypes == 7}">1st Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 8}">2nd Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 9}">3rd Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 10}">4th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 11}">5th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 12}">6th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 13}">7th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 14}">8th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 15}">9th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 16}">10th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 17}">11th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 18}">12th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 19}">13th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 20}">14th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 21}">15th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 22}">16th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 23}">17th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 24}">18th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 25}">19th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 26}">20th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 27}">21st Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 28}">22nd Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 29}">23rd Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 30}">24th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 31}">25th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 32}">26th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 33}">27th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 34}">28th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 35}">29th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 36}">30th Floor</c:when>

    <c:when test="${fireDetail.fireFloorTypes == 37}">Basement</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 38}">Stilt level</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 39}">Basement 1</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 40}">Basement 2</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 41}">Basement 3</c:when>
    
    <c:when test="${fireDetail.fireFloorTypes == 42}">31th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 43}">32th Floor</c:when>
    <c:when test="${fireDetail.fireFloorTypes == 44}">33th Floor</c:when>
        <c:when test="${fireDetail.fireFloorTypes == 45}">34th Floor</c:when>
        <c:when test="${fireDetail.fireFloorTypes == 46}">35th Floor</c:when>
            <c:when test="${fireDetail.fireFloorTypes == 47}">Terrace</c:when>
        
    

    <c:otherwise></c:otherwise>
</c:choose>
</td>
    <td>${fireDetail.residArea}</td>
    <td>${fireDetail.primumAr}</td>
    <td>${fireDetail.commArea}</td>
    <td>${fireDetail.otherUse}</td>
    <td>${fireDetail.rowWiseTotal}</td>
</tr>
        </c:forEach>
    </tbody>
</table>




                                  

                                    <!--   <table>
                                      
                                                                                        <c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
                                                <tr>
                                                    <td colspan="6" align="center">
                                                        <a target="_blank" href="" id="genCerBtn">

                                                            <button class="ClsButton clsButtonUpload"
                                                                onclick="download(${fireRecommendation.rti_ref_id},'mandapCertificateReport.do')">GENERATE
                                                                CERTIFICATE</button>
                                                             <button class="ClsButton clsButtonUpload"
                                                                onclick="download1(${fireRecommendation.rti_ref_id});return false;">APPLY
                                                                DSC</button>

                                                        </a>

                                                    </td>
                                                </tr>
                                            </c:if>




                                    </table>-->
                                   
                                   <h6 class="fire-docs-heading rounded-2">
    <strong>List of Documents (Attachment) For Provisional fire safety approval Certificate</strong>
</h6>

<table width="100%" border="1" cellpadding="2" cellspacing="2" class="container fire-docs-table">
        

     <tr>
    <td>
      &nbsp
    </td>
    </tr>
    <tr>
        <td >
            <span class="ClsLabel" style="font-size: 14px;">
                <fmt:message key="Form P Certificate" />:
            </span>
        </td>
        <td style="text-align: center">
            <c:set var="doc" value="${fn:split(rtiApplication.pdfUploadFromPortal, ',')}" />
            <a class="ClsButton" type="button" target="_blank" onclick="docDownload('${doc[0]}');" >
   <span class="download" style="align-items: center;color:white;">Download</span>
            </a>
        </td>
    </tr>
    <tr>
    <td>
      &nbsp
    </td>
    </tr>
    <tr>
        <td>
            <span class="ClsLabel" style="font-size: 14px">
                <fmt:message key="NMC Tax Receipt Current Year " />:
            </span>
        </td>
        <td style="text-align: center">
            <a class="ClsButton" type="button" target="_blank" onclick="docDownload('${doc[1]}');" >
   <span class="download" style="align-items: center;color:white;">Download</span>
            </a>
        </td>
    </tr>
     <tr>
    <td>
      &nbsp
    </td>
    </tr>
    <tr>
        <td>
            <span class="ClsLabel" style="font-size: 14px">
                <fmt:message key="Covering Letter of Sanctioning Authority" />:
            </span>
        </td>
        <td style="text-align: center">
            <a class="ClsButton" type="button" target="_blank" onclick="docDownload('${doc[2]}');" >
   <span class="download" style="align-items: center;color:white;">Download</span>
            </a>
        </td>
    </tr>
    <tr>
        <td>
            <span class="ClsLabel" style="font-size: 14px">
                <fmt:message key="Tentative Approval Fire Designing Proposed/Existing Building Plan" />:
            </span>
        </td>
        <td style="text-align: center">
            <a class="ClsButton" type="button" target="_blank" onclick="docDownload('${doc[3]}');" >
   <span class="download" style="align-items: center;color:white;">Download</span>
            </a>
        </td>
    </tr>
    </table>
   <table width="100%" border="1" cellpadding="2" cellspacing="2" class="container fire-docs-table">

    <!-- 🔹 SCRUTINY REPORT -->
    <tr>
        <td>
            <span style="font-size: 14px">
                <fmt:message key="Scrutiny Report" />:
            </span>
        </td>

        <c:choose>
            <c:when test="${empty fireRecommendation.scrutinyReport 
                   or fireRecommendation.scrutinyReport == 'null'
                   or fn:trim(fireRecommendation.scrutinyReport) == ''}">
            
                <c:if test="${requestScope.rtiApplication.workFlowStatus==0}">
                    <td>
                        <input type="file" id="scrutinydoc" accept="application/pdf" style="width:220px"/>

                        <a class="btn btn-primary"
                           style="color:white"
                           onclick="uploadFireDoc('scrutinydoc',1,'Scrutiny Report')">
                            Upload
                        </a>
                    </td>
                </c:if>
            </c:when>

            <c:otherwise>
                <td style="text-align:center">
                    <a class="btn btn-success"
                       style="color:white"
                       onclick="docDownload('${fireRecommendation.scrutinyReport}')">
                        Download
                    </a>
                    
                     <c:if test="${requestScope.rtiApplication.workFlowStatus != 1 and requestScope.rtiApplication.workFlowStatus != 5}">
                    <br/><br/>
                    <input type="file" id="scrutinydocReupload" accept="application/pdf" style="width:220px"/>
                    <a class="btn btn-warning" style="color:white"
                       onclick="uploadFireDoc('scrutinydocReupload',1,'Scrutiny Report')">Re-upload</a>
                </c:if>
                </td>
            </c:otherwise>
        </c:choose>
    </tr>


    <!-- 🔹 INSPECTION REPORT -->
    <tr>
        <td>
            <span style="font-size: 14px">
                <fmt:message key="Inspection Report" />:
            </span>
        </td>

        <c:choose>
                        <c:when test="${empty fireRecommendation.inspectionReport 
                   or fireRecommendation.inspectionReport == 'null'
                   or fn:trim(fireRecommendation.inspectionReport) == ''}">
                <c:if test="${requestScope.rtiApplication.workFlowStatus==0}">
                    <td>
                        <input type="file" id="inspectiondoc" accept="application/pdf" style="width:220px"/>

                        <a class="btn btn-primary"
                           style="color:white"
                           onclick="uploadFireDoc('inspectiondoc',2,'Inspection Report')">
                            Upload
                        </a>
                    </td>
                </c:if>
            </c:when>

            <c:otherwise>
                <td style="text-align:center">
                    <a class="btn btn-success"
                       style="color:white"
                       onclick="docDownload('${fireRecommendation.inspectionReport}')">
                        Download
                    </a>
                       <c:if test="${requestScope.rtiApplication.workFlowStatus != 1 and requestScope.rtiApplication.workFlowStatus != 5}">
                    <br/><br/>
                    <input type="file" id="inspectiondocReupload" accept="application/pdf" style="width:220px"/>
                    <a class="btn btn-warning" style="color:white"
                       onclick="uploadFireDoc('inspectiondocReupload',2,'Inspection Report')">Re-upload</a>
                </c:if>
                </td>
            </c:otherwise>
        </c:choose>
    </tr>


    <!-- 🔹 CFO NOC -->
    <tr>
        <td>
            <span style="font-size: 14px">
                <fmt:message key="CFO NOC" />:
            </span>
        </td>

        <c:choose>
             <c:when test="${empty fireRecommendation.cfoNoc 
                   or fireRecommendation.cfoNoc == 'null'
                   or fn:trim(fireRecommendation.cfoNoc) == ''}">
                <c:if test="${requestScope.rtiApplication.workFlowStatus==0}">
                    <td>
                        <input type="file" id="cfoNocdoc" accept="application/pdf" style="width:220px"/>

                        <a class="btn btn-primary"
                           style="color:white"
                           onclick="uploadFireDoc('cfoNocdoc',3,'CFO NOC')">
                            Upload
                        </a>
                    </td>
                </c:if>
            </c:when>

            <c:otherwise>
                <td style="text-align:center">
                    <a class="btn btn-success"
                       style="color:white"
                       onclick="docDownload('${fireRecommendation.cfoNoc}')">
                        Download
                    </a>
                      <c:if test="${requestScope.rtiApplication.workFlowStatus != 1 and requestScope.rtiApplication.workFlowStatus != 5}">
                    <br/><br/>
                    <input type="file" id="cfoNocdocReupload" accept="application/pdf" style="width:220px"/>
                    <a class="btn btn-warning" style="color:white"
                       onclick="uploadFireDoc('cfoNocdocReupload',3,'CFO NOC')">Re-upload</a>
                </c:if>
                </td>
            </c:otherwise>
        </c:choose>
    </tr>
        <!-- 🔹 FIRE NOC -->

            
    <c:if test="${requestScope.forLogin eq 'L2' and not requestScope.isZoneUser}">
      <tr>
        <td>
            <span style="font-size: 14px">
                <fmt:message key="FIRE NOC" />:
            </span>
        </td>

        <c:choose>
             <c:when test="${empty fireRecommendation.fireNoc 
                   or fireRecommendation.fireNoc == 'null'
                   or fn:trim(fireRecommendation.fireNoc) == ''}">

                    <td>
                        <input type="file" id="fireNocdoc" accept="application/pdf" style="width:220px"/>

                        <a class="btn btn-primary"
                           style="color:white"
                           onclick="uploadDoc('fireNocdoc',1,'FIRE NOC')">
                            Upload
                        </a>
                    </td>
            </c:when>

            <c:otherwise>
                <td style="text-align:center">
                    <a class="btn btn-success"
                       style="color:white"
                       onclick="docDownload('${fireRecommendation.fireNoc}')">
                        Download
                    </a>
                      <c:if test="${requestScope.rtiApplication.workFlowStatus != 1 and requestScope.rtiApplication.workFlowStatus != 5}">
                    <br/><br/>
                    <input type="file" id="fireNocdocReupload" accept="application/pdf" style="width:220px"/>
                    <a class="btn btn-warning" style="color:white"
                       onclick="uploadDoc('fireNocdocReupload',1,'FIRE NOC')">Re-upload</a>
                </c:if>
                </td>
            </c:otherwise>
        </c:choose>
    </tr>
      <tr>
        <td>
            <span style="font-size: 14px">
                <fmt:message key="Building Plan/Map" />:
            </span>
        </td>

        <c:choose>
             <c:when test="${empty fireRecommendation.buildingPlanMap 
                   or fireRecommendation.buildingPlanMap == 'null'
                   or fn:trim(fireRecommendation.buildingPlanMap) == ''}">

                                <td>
                        <input type="file" id="buildingPlanMapdoc" accept="application/pdf" style="width:220px"/>

                        <a class="btn btn-primary"
                           style="color:white"
                           onclick="uploadDoc('buildingPlanMapdoc',2,'Building Plan Map')">
                            Upload
                        </a>
                    </td>
            </c:when>

            <c:otherwise>
                <td style="text-align:center">
                    <a class="btn btn-success"
                       style="color:white"
                       onclick="docDownload('${fireRecommendation.buildingPlanMap}')">
                        Download
                    </a>
                     <c:if test="${requestScope.rtiApplication.workFlowStatus != 1 and requestScope.rtiApplication.workFlowStatus != 5}">
                    <br/><br/>
                    <input type="file" id="buildingPlanMapdocReupload" accept="application/pdf" style="width:220px"/>
                    <a class="btn btn-warning" style="color:white"
                       onclick="uploadDoc('buildingPlanMapdocReupload',2,'Building Plan Map')">Re-upload</a>
                </c:if>
                </td>
            </c:otherwise>
        </c:choose>
    </tr>
 <tr>
    <td>
        <span style="font-size: 14px">
            <fmt:message key="L1 Remark" />:
        </span>
    </td>

    <td>
        <textarea class="form-control" rows="3" readonly>
${fireRecommendation.remarkforL2}
        </textarea>
    </td>
</tr>
</c:if>
	<c:if test="${requestScope.rtiApplication.workFlowStatus==3}">
					
<tr>
					<td colspan="4" align="center">
    <a class="btn btn-primary"
       style="min-height: 30px; min-width: 80px; color: white; border: none;"
       onclick="resendDemandPayment('${fireRecommendation.fullName}', '${fireRecommendation.mobileNo}', '${fireRecommendation.rtiapplrefno}', '${fireRecommendation.appEmail}')">
       Resend demand
    </a>
</td>

</tr>
<script>
    function resendDemandPayment(name, mobileNo, applnNo, email) {
        // Use URL-encoded parameters in GET request
        const contextRoot = '<c:out value="${contextRoot}"/>';
        const url = contextRoot + '/rtiApplication/resendPayment.do'
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
</script>

			</c:if>
</table>
 <table width="100%" border="0" cellpadding="2" cellspacing="2" class="container">

                                        <tr>
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    Current Status:</span></td>
                                            <td style="width: 230px; height: 30px"><span class="ClsLabel"
                                                    style="font-size: 14px">
                                                    <c:if test="${requestScope.rtiApplication.workFlowStatus==0}">
                                                        Citizen Form Submitted and scrutiny fee paid.
                                                    </c:if>
                                                    <c:if test="${requestScope.rtiApplication.workFlowStatus==3}">
                                                        Citizen Payment Pending.
                                                    </c:if>
                                                    <c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
                                                        Citizen Payment Completed
                                                    </c:if>
                                                    <c:if test="${requestScope.rtiApplication.workFlowStatus==1}">
                                                        Completed and File Uploaded for Citizen
                                                    </c:if>
                                                    <c:if test="${requestScope.rtiApplication.workFlowStatus==5}">
                                                        Rejected
                                                    </c:if>
                                                </span></td>


                                           

                                                    <c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
                                                        <td><span class="ClsLabel" style="font-size:14px">FIRE NOC:
                                                                 </span> </td>
															<%@include file="/pages/common-pages/dms/fileUpload.jsp" %>
                                                                
                                                    </c:if>
                                        </tr>

                                    </table>

                                    <br>
                                    <input type="hidden" id="WORKFLOW_ACTION" name="WORKFLOW_ACTION"/>
 	<input type="hidden"
		name="<c:out value="${pageScope.WORKFLOW_ENTITYID}"/>"
		id="<c:out value="${pageScope.WORKFLOW_ENTITYID}"/>"
		value="<c:out value="${requestScope.WORKFLOW_ENTITYID}"/>" />                               </div>
<input type="hidden" id="rtiApplicationRefIds" name="rtiApplicationRefIds" value="${fireRecommendation.rti_ref_id}" />
<input type="hidden" class="ClsTextbox" id="mandapPermissionId" style="width:180px" name="mandapPermissionId" value="<c:out value="${fireRecommendation.fireRecommendationId}" />" />
 <input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId" value="" />
  
    <c:if test="${requestScope.forLogin eq 'L2' 
    and !requestScope.isZoneUser
    and not empty fireRecommendation.cfoNoc 
    and not empty fireRecommendation.inspectionReport 
    and not empty fireRecommendation.scrutinyReport}">
    
    <%@include file="/pages/workflow/taskInclude.jsp"%>
</c:if>

<!--<c:if test="${requestScope.forLogin eq 'L1' or requestScope.isZoneUser}">
</c:if>-->
<c:if test="${(requestScope.forLogin eq 'L1' or requestScope.isZoneUser) and 
requestScope.rtiApplication.workFlowStatus==0  and empty fireRecommendation.remarkforL2}">
<input type="hidden" id="WORKFLOW_TRANSISTION" name="WORKFLOW_TRANSISTION"/>
    <div class="card mt-3" id="workflowDetailsBox">
        <div class="card-header bg-primary text-white">
            <b>Workflow Details</b>
        </div>

        <div class="card-body" id="commentsDisable">

            <!-- Remark Field -->
            <div class="form-group mb-3">
                <label for="WORKFLOW_COMMENTS"><b>Remark</b></label>
                <textarea id="WORKFLOW_COMMENTS" name="WORKFLOW_COMMENTS"
                          class="form-control" rows="3"
                          placeholder="Enter your remark here..."></textarea>
            </div>

           
            <!-- Buttons -->
            <div class="d-flex gap-2 mt-3">

                <!-- Send Remark -->
                <button type="button" id="sendRemarkBtn"
                        class="btn btn-warning"
                        onclick="sendRemarkToCitizen()">
                    Send Remark to Citizen
                </button>

                <!-- Send to L2 -->
                <button type="button" id="sendToL2Btn"
                        class="btn btn-success"
                        onclick="sendToL2()">
                    Send to L2
                </button>

                <!-- Reject -->
                <button type="button" id="RejectCreateWorkflow"
                        class="btn btn-danger" name="RejectCreateWorkflow"
                        onclick="javascript:killCurrentWorkflow(this.form);">
                        <!-- onclick="rejectApplication()">-->
                    Reject Application
                </button>

        
            </div>

        </div>
    </div>

</c:if>
       

                                    <script>
                                       // function saveEntity() {
                                       //   onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/createFireRecommendationWork.do');
                                       // }
                                                                           </script>

                                                                            <script>

                                        function saveEntity() {
    var url = '<c:out value="${contextRoot}"/>/rtiapplication/createFireRecommendationWork.do';

    // Create a new form element
    var form = document.createElement('form');
    form.setAttribute('method', 'post');
    form.setAttribute('action', url);

    // Append the existing form fields to the new form
    var existingForm = document.forms[0];
    for (var i = 0; i < existingForm.elements.length; i++) {
        var element = existingForm.elements[i];
        if (element.name) {
            var clone = element.cloneNode(true);
            form.appendChild(clone);
        }
    }

    // Append the new form to the document body and submit it
    document.body.appendChild(form);
    form.submit();
}

                                    </script>
               <script>
function uploadFireDoc(inputId, appType, label) {

    var fileInput = document.getElementById(inputId);
    var file = fileInput.files[0];

    if (!file) {
        alert("Please select file");
        return;
    }

    var fileName = file.name.toLowerCase();

    // ✅ Only PDF
    if (!fileName.endsWith(".pdf")) {
        alert("Only PDF files are allowed");
        return;
    }

    // ✅ Double extension check
    if (fileName.substring(0, fileName.lastIndexOf(".")).includes(".")) {
        alert("Invalid file name (double extension not allowed)");
        return;
    }

    // ✅ Size check (2MB)
    if (file.size > 5 * 1024 * 1024) {
        alert("File size must be less than 5MB");
        return;
    }

    // ✅ UID
    var uid = document.getElementById("mandapPermissionId").value.trim();

    if (!uid) {
        alert("Invalid ID");
        return;
    }

    var data = new FormData();
    data.append("file", file);

    // ✅ AJAX call
    $.ajax({
        url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadsManageFire.do?appType=" 
                + appType + "&UID=" + encodeURIComponent(uid),

        type: "POST",
        data: data,
        processData: false,
        contentType: false,

        success: function (res) {
            if (res.status === true || res.status === "true") {
                alert(label + " uploaded successfully");
                location.reload();
            } else {
                alert(res.message || "Upload failed");
            }
        },

        error: function () {
            alert("Server error occurred");
        }
    });
}
</script>

               <script>
function uploadDoc(inputId, appType, label) {

    var fileInput = document.getElementById(inputId);
    var file = fileInput.files[0];

    if (!file) {
        alert("Please select file");
        return;
    }

    var fileName = file.name.toLowerCase();

    // ✅ Only PDF
    if (!fileName.endsWith(".pdf")) {
        alert("Only PDF files are allowed");
        return;
    }

    // ✅ Double extension check
    if (fileName.substring(0, fileName.lastIndexOf(".")).includes(".")) {
        alert("Invalid file name (double extension not allowed)");
        return;
    }

    // ✅ Size check (2MB)
    if (file.size > 10 * 1024 * 1024) {
        alert("File size must be less than 10MB");
        return;
    }

    // ✅ UID
    var uid = document.getElementById("mandapPermissionId").value.trim();

    if (!uid) {
        alert("Invalid ID");
        return;
    }

    var data = new FormData();
    data.append("file", file);

    // ✅ AJAX call
    $.ajax({
        url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadsManageFireService.do?appType=" 
                + appType + "&UID=" + encodeURIComponent(uid),

        type: "POST",
        data: data,
        processData: false,
        contentType: false,

        success: function (res) {
            if (res.status === true || res.status === "true") {
                alert(label + " uploaded successfully");
                location.reload();
            } else {
                alert(res.message || "Upload failed");
            }
        },

        error: function () {
            alert("Server error occurred");
        }
    });
}
</script>
<script>
function docDownload(path) {
	    var encodedFilePath = encodeURIComponent(path);

	    var encodedFilesPath = btoa(encodedFilePath); 

	    window.open('<c:out value="${contextRoot}"/>/rtsApplication/getPdf.do?fp=' + encodedFilesPath, '_blank');
	}

</script>
<script>
$(document).ready(function () {

    var workflowStatus = "${requestScope.rtiApplication.workFlowStatus}".trim();
    var forLogin = "${requestScope.forLogin}".trim();
    var isZoneUser = "${requestScope.isZoneUser}" === 'true';
    var hasCfoNoc = "${not empty fireRecommendation.cfoNoc}" === 'true';
    var hasInspectionReport = "${not empty fireRecommendation.inspectionReport}" === 'true';
    var hasScrutinyReport = "${not empty fireRecommendation.scrutinyReport}" === 'true';
    var hasRemark = "${not empty fireRecommendation.remarkforL2}" === 'true';

    var tabElement = document.getElementsByClassName("tab")[0];

    function setTabMessage(message, color) {
        if (tabElement) {
            tabElement.innerHTML = '<span style="color:' + color + '">' + message + '</span>';
        }
    }

     if (
    	    workflowStatus === '0' &&
    	    (forLogin === 'L1' || forLogin === 'L2') &&
            isZoneUser &&
    	    hasCfoNoc &&
    	    hasInspectionReport &&
    	    hasScrutinyReport &&
    	    hasRemark
    	) {

    	    setTabMessage("Verification completed and application sent to L2.", "green");

    	    $('#commentsDisable *').prop('disabled', true).hide();
    	    $('#CreateWorkflow').prop('disabled', true).hide();
    	    $('#RejectCreateWorkflow').prop('disabled', true).hide();
    	    $('#WORKFLOW_COMMENTS').prop('disabled', true).hide();
    	    $('#idProof').prop('disabled', true).hide();

    	}
     else if (
     	    workflowStatus === '0' &&
     	    forLogin === 'L1' &&
            ! isZoneUser &&
     	    hasCfoNoc &&
     	    hasInspectionReport &&
     	    hasScrutinyReport &&
     	   hasRemark
     	) {

     	    setTabMessage("Verification completed and application sent to L2.", "green");

     	    $('#commentsDisable *').prop('disabled', true).hide();
     	    $('#CreateWorkflow').prop('disabled', true).hide();
     	    $('#RejectCreateWorkflow').prop('disabled', true).hide();
     	    $('#WORKFLOW_COMMENTS').prop('disabled', true).hide();
     	    $('#idProof').prop('disabled', true).hide();

     	}
    // else if (workflowStatus === '0' && (forLogin === 'L1' || isZoneUser) &&
    //		    (!hasCfoNoc || !hasInspectionReport || !hasScrutinyReport)) {
     //   setTabMessage("If the documents or details are not correct, you can reject the application.", "red");
//add button sent remark to citizen
//send to L2 button 
     //   $('#commentsDisable *').prop('disabled', true);
     //   $('#CreateWorkflow').prop('disabled', true).hide();
      //  $('#RejectCreateWorkflow').prop('disabled', false);
     //   $('#WORKFLOW_COMMENTS').prop('disabled', false);
     //   $('#idProof').prop('disabled', false);

   // } 
    else if ((workflowStatus === '2' || workflowStatus === '3') && (forLogin === 'L1' || isZoneUser )) {

        setTabMessage("Verification completed and application sent to L2.", "green");

        $('#commentsDisable *').prop('disabled', true).hide();
        $('#CreateWorkflow').prop('disabled', true).hide();
        $('#RejectCreateWorkflow').prop('disabled', true).hide();
        $('#WORKFLOW_COMMENTS').prop('disabled', true).hide();
        $('#idProof').prop('disabled', true).hide();

    } 
   
 
    else if (workflowStatus === '5') {

        setTabMessage("Application has been Rejected", "red");

        $('#commentsDisable *').prop('disabled', true);
        $('#CreateWorkflow').prop('disabled', true).hide();
        $('#RejectCreateWorkflow').prop('disabled', true);
        $('#WORKFLOW_COMMENTS').prop('disabled', true);
    }

});
</script>
<script>
function killCurrentWorkflow(frm) {

    if (checkMandatoryDetailed(new Array('WORKFLOW_COMMENTS'), new Array('Description'))) {

        if (confirm("Do you really want to Discard the current WorkFlow ?")) {

            var actionField = document.getElementById('WORKFLOW_ACTION');

            if (actionField) {
                actionField.value = 'KILL_JOB';
            } else {
                console.error("WORKFLOW_ACTION field not found");
                return false;
            }

            saveEntity();
        } else {
            return false;
        }

    } else {
        return false;
    }
}
	
function sendRemarkToCitizen() {
    var remark = $('#WORKFLOW_COMMENTS').val().trim();

    if (remark === "") {
        alert("Please enter remark before sending to citizen");
        $('#WORKFLOW_COMMENTS').focus();
        return false;
    }

    if (confirm("Send remark to citizen?")) {
        $('#WORKFLOW_TRANSISTION').val('Send-Remark'); // 👈 important
       // disableControlsByJquery(false);
        saveEntity();
    }
}

function sendToL2() {
    var remark = $('#WORKFLOW_COMMENTS').val().trim();

    var hasCfoNoc = ${not empty fireRecommendation.cfoNoc};
    var hasInspectionReport = ${not empty fireRecommendation.inspectionReport};
    var hasScrutinyReport = ${not empty fireRecommendation.scrutinyReport};
    if (remark === "") {
        alert("Please enter remark before sending to L2");
        $('#WORKFLOW_COMMENTS').focus();
        return false;
    }

    if (!hasCfoNoc || !hasInspectionReport || !hasScrutinyReport) {
        alert("All documents are mandatory:\n- CFO NOC\n- Inspection Report\n- Scrutiny Report");
        return false;
    }

    if (confirm("Send application to L2?")) {
        $('#WORKFLOW_TRANSISTION').val('Forward-To-L2'); // 👈 important
       // disableControlsByJquery(false);
        saveEntity();
    }
}
</script>
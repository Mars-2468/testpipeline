<%@page import="com.mars.common.utils.CommonUtils"%>
<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	pageContext.setAttribute("DATE_TIME_DB_FORMAT", Constants.DATE_TIME_DB_FORMAT);

	pageContext.setAttribute("DATE_TIME_FORMAT", WorkflowConstants.WORKFLOW_DATE_FORMAT);
	
	//gender
		 pageContext.setAttribute("LABEL_CHILD_GENDER_MALE", CoreConstants.LABEL_CHILD_GENDER_MALE);
	    pageContext.setAttribute("LABEL_CHILD_GENDER_FEMALE", CoreConstants.LABEL_CHILD_GENDER_FEMALE);
	    pageContext.setAttribute("LABEL_CHILD_GENDER_TRANSGENDER", CoreConstants.LABEL_CHILD_GENDER_TRANSGENDER); 
	   
	    pageContext.setAttribute("CHILD_GENDER_MALE",  CoreConstants.CHILD_GENDER_MALE);
	    pageContext.setAttribute("CHILD_GENDER_FEMALE",  CoreConstants.CHILD_GENDER_FEMALE);
	    pageContext.setAttribute("CHILD_GENDER_TRANSGENDER",  CoreConstants.CHILD_GENDER_TRANSGENDER);
		//hospital
		 pageContext.setAttribute("LABEL_HOSPITAL_NAME_KAMAL", CoreConstants.LABEL_HOSPITAL_NAME_KAMAL);
	    pageContext.setAttribute("LABEL_HOSPITAL_NAME_AIMS", CoreConstants.LABEL_HOSPITAL_NAME_AIMS);
	    pageContext.setAttribute("LABEL_HOSPITAL_NAME_SETH", CoreConstants.LABEL_HOSPITAL_NAME_SETH);
	    pageContext.setAttribute("LABEL_HOSPITAL_NAME_APEX", CoreConstants.LABEL_HOSPITAL_NAME_APEX);
	   
	    pageContext.setAttribute("HOSPITAL_NAME_KAMAL",  CoreConstants.HOSPITAL_NAME_KAMAL);
	    pageContext.setAttribute("HOSPITAL_NAME_AIMS",  CoreConstants.HOSPITAL_NAME_AIMS);
	    pageContext.setAttribute("HOSPITAL_NAME_SETH",  CoreConstants.HOSPITAL_NAME_SETH);
	    pageContext.setAttribute("HOSPITAL_NAME_APEX",  CoreConstants.HOSPITAL_NAME_APEX);
	    
	    //reason of death
	     pageContext.setAttribute("LABEL_REASON_DEATH_FEVER", CoreConstants.LABEL_REASON_DEATH_FEVER);
	    pageContext.setAttribute("LABEL_REASON_DEATH_CANCER", CoreConstants.LABEL_REASON_DEATH_CANCER);
	    pageContext.setAttribute("LABEL_REASON_DEATH_HEART", CoreConstants.LABEL_REASON_DEATH_HEART);
	    pageContext.setAttribute("LABEL_REASON_DEATH_STROKE", CoreConstants.LABEL_REASON_DEATH_STROKE);
	    pageContext.setAttribute("LABEL_REASON_DEATH_LOWER", CoreConstants.LABEL_REASON_DEATH_LOWER);
	    pageContext.setAttribute("LABEL_REASON_DEATH_TUBE", CoreConstants.LABEL_REASON_DEATH_TUBE);
	    pageContext.setAttribute("LABEL_REASON_DEATH_ROAD", CoreConstants.LABEL_REASON_DEATH_ROAD);
	    pageContext.setAttribute("LABEL_REASON_DEATH_OTHER", CoreConstants.LABEL_REASON_DEATH_OTHER);
	    
	    pageContext.setAttribute("REASON_DEATH_FEVER",  CoreConstants.REASON_DEATH_FEVER);
	    pageContext.setAttribute("REASON_DEATH_CANCER",  CoreConstants.REASON_DEATH_CANCER);
	    pageContext.setAttribute("REASON_DEATH_HEART",  CoreConstants.REASON_DEATH_HEART);
	    pageContext.setAttribute("REASON_DEATH_STROKE",  CoreConstants.REASON_DEATH_STROKE);
	    pageContext.setAttribute("REASON_DEATH_LOWER",  CoreConstants.REASON_DEATH_LOWER);
	    pageContext.setAttribute("REASON_DEATH_TUBE",  CoreConstants.REASON_DEATH_TUBE);
	    pageContext.setAttribute("REASON_DEATH_ROAD",  CoreConstants.REASON_DEATH_ROAD);
	    pageContext.setAttribute("REASON_DEATH_OTHER",  CoreConstants.REASON_DEATH_OTHER);
	    
	    //name of NAME_OF_CREMATORIUM
	     pageContext.setAttribute("LABEL_NAME_OF_CREMATORIUM", CoreConstants.LABEL_NAME_OF_CREMATORIUM);
	    
	    pageContext.setAttribute("NAME_OF_CREMATORIUM",  CoreConstants.NAME_OF_CREMATORIUM);
	    
	    
	    //zone
	    pageContext.setAttribute("LABEL_ZONE_NUMBER_ONE", CoreConstants.LABEL_ZONE_NUMBER_ONE);
	    pageContext.setAttribute("LABEL_ZONE_NUMBER_TWO", CoreConstants.LABEL_ZONE_NUMBER_TWO);
	    pageContext.setAttribute("LABEL_ZONE_NUMBER_THREE", CoreConstants.LABEL_ZONE_NUMBER_THREE);
	    pageContext.setAttribute("LABEL_ZONE_NUMBER_FOUR", CoreConstants.LABEL_ZONE_NUMBER_FOUR);
	    pageContext.setAttribute("LABEL_ZONE_NUMBER_FIVE", CoreConstants.LABEL_ZONE_NUMBER_FIVE);
	    pageContext.setAttribute("LABEL_ZONE_NUMBER_SIX", CoreConstants.LABEL_ZONE_NUMBER_SIX);
	    pageContext.setAttribute("LABEL_ZONE_NUMBER_SEVEN", CoreConstants.LABEL_ZONE_NUMBER_SEVEN);
	    pageContext.setAttribute("LABEL_ZONE_NUMBER_EIGHT", CoreConstants.LABEL_ZONE_NUMBER_EIGHT);
	    pageContext.setAttribute("LABEL_ZONE_NUMBER_NINE", CoreConstants.LABEL_ZONE_NUMBER_NINE);
	    pageContext.setAttribute("LABEL_ZONE_NUMBER_TEN", CoreConstants.LABEL_ZONE_NUMBER_TEN);
	    pageContext.setAttribute("LABEL_ZONE_NUMBER_ELEV", CoreConstants.LABEL_ZONE_NUMBER_ELEV);
	    pageContext.setAttribute("LABEL_ZONE_NUMBER_TWEL", CoreConstants.LABEL_ZONE_NUMBER_TWEL);
	    
	    pageContext.setAttribute("ZONE_NUMBER_ONE", CoreConstants.ZONE_NUMBER_ONE);
	    pageContext.setAttribute("ZONE_NUMBER_TWO", CoreConstants.ZONE_NUMBER_TWO);
	    pageContext.setAttribute("ZONE_NUMBER_THREE", CoreConstants.ZONE_NUMBER_THREE);
	    pageContext.setAttribute("ZONE_NUMBER_FOUR", CoreConstants.ZONE_NUMBER_FOUR);
	    pageContext.setAttribute("ZONE_NUMBER_FIVE", CoreConstants.ZONE_NUMBER_FIVE);
	    pageContext.setAttribute("ZONE_NUMBER_SIX", CoreConstants.ZONE_NUMBER_SIX);
	    pageContext.setAttribute("ZONE_NUMBER_SEVEN", CoreConstants.ZONE_NUMBER_SEVEN);
	    pageContext.setAttribute("ZONE_NUMBER_EIGHT", CoreConstants.ZONE_NUMBER_EIGHT);
	    pageContext.setAttribute("ZONE_NUMBER_NINE", CoreConstants.ZONE_NUMBER_NINE);
	    pageContext.setAttribute("ZONE_NUMBER_TEN", CoreConstants.ZONE_NUMBER_TEN);
	    pageContext.setAttribute("ZONE_NUMBER_ELEV", CoreConstants.ZONE_NUMBER_ELEV);
	    pageContext.setAttribute("ZONE_NUMBER_TWEL", CoreConstants.ZONE_NUMBER_TWEL);
	    
	    //place of death
		 pageContext.setAttribute("LABEL_PLACE_OF_DEATH_HOME", CoreConstants.LABEL_PLACE_OF_DEATH_HOME);
	    pageContext.setAttribute("LABEL_PLACE_OF_DEATH_HOSPITAL", CoreConstants.LABEL_PLACE_OF_DEATH_HOSPITAL);
	    
	    pageContext.setAttribute("PLACE_OF_DEATH_HOME", CoreConstants.PLACE_OF_DEATH_HOME);
	    pageContext.setAttribute("PLACE_OF_DEATH_HOSPITAL", CoreConstants.PLACE_OF_DEATH_HOSPITAL);
	    
	
	pageContext.setAttribute("WORKFLOW_PRIORITY", WorkflowConstants.WORKFLOW_PRIORITY);
	pageContext.setAttribute("WORKFLOW_PRIORITY_LOW", WorkflowConstants.WORKFLOW_PRIORITY_LOW);
	pageContext.setAttribute("WORKFLOW_PRIORITY_LOW_LABEL", WorkflowConstants.WORKFLOW_PRIORITY_LOW_LABEL);
	pageContext.setAttribute("WORKFLOW_PRIORITY_MEDIUM", WorkflowConstants.WORKFLOW_PRIORITY_MEDIUM);
	pageContext.setAttribute("WORKFLOW_PRIORITY_MEDIUM_LABEL", WorkflowConstants.WORKFLOW_PRIORITY_MEDIUM_LABEL);
	pageContext.setAttribute("WORKFLOW_PRIORITY_HIGH", WorkflowConstants.WORKFLOW_PRIORITY_HIGH);
	pageContext.setAttribute("WORKFLOW_PRIORITY_HIGH_LABEL", WorkflowConstants.WORKFLOW_PRIORITY_HIGH_LABEL);
	pageContext.setAttribute("WORKFLOW_PROCESSDESCRIPTION", WorkflowConstants.WORKFLOW_PROCESSDESCRIPTION);
	pageContext.setAttribute("WORKFLOW_TRANSITION", WorkflowConstants.WORKFLOW_TRANSITION);
	pageContext.setAttribute("WORKFLOW_NAME", WorkflowConstants.WORKFLOW_NAME);
	pageContext.setAttribute("WORKFLOW_ACTION", WorkflowConstants.WORKFLOW_ACTION);
	pageContext.setAttribute("WORKFLOW_ACTION_COMPLETE_TASK", WorkflowConstants.WORKFLOW_ACTION_COMPLETE_TASK);
	pageContext.setAttribute("WORKFLOW_ACTION_CREATE_PROCESS", WorkflowConstants.WORKFLOW_ACTION_CREATE_PROCESS);
	pageContext.setAttribute("TAKE_TASK", WorkflowConstants.WORKFLOW_ACTION_TAKE_TASK);
	pageContext.setAttribute("KILL_JOB", WorkflowConstants.WORKFLOW_ACTION_KILL_JOB);
	pageContext.setAttribute("END_JOB", WorkflowConstants.WORKFLOW_ACTION_KILL_JOB);
	pageContext.setAttribute("WORKFLOW_TRANSISTION", WorkflowConstants.WORKFLOW_TRANSISTION);
	pageContext.setAttribute("WORKFLOW_ENTITYNAME", WorkflowConstants.WORKFLOW_ENTITYNAME);
	pageContext.setAttribute("WORKFLOW_ENTITYID", WorkflowConstants.WORKFLOW_ENTITYID);
	pageContext.setAttribute("WORKFLOW_JOB_ID", WorkflowConstants.WORKFLOW_JOB_ID);
	pageContext.setAttribute("WORKFLOW_TASK_ID", WorkflowConstants.WORKFLOW_TASK_ID);
	pageContext.setAttribute("WORKFLOW_COMMENTS", WorkflowConstants.WORKFLOW_COMMENTS);
	pageContext.setAttribute("WORKFLOW_DUE_DATE", WorkflowConstants.WORKFLOW_DUE_DATE);
	
	
	pageContext.setAttribute("APPL_STATUS_CLOSED", CoreConstants.APPL_STATUS_CLOSED);
	pageContext.setAttribute("APPL_STATUS_NEW", CoreConstants.APPL_STATUS_NEW);
	pageContext.setAttribute("APPL_STATUS_PARKED", CoreConstants.APPL_STATUS_PARKED);	
	pageContext.setAttribute("APPL_STATUS_APPROVED", CoreConstants.APPL_STATUS_APPROVED);
	pageContext.setAttribute("APPL_STATUS_VERIFICATION", CoreConstants.APPL_STATUS_VERIFICATION);
	pageContext.setAttribute("APPL_STATUS_CREATE", CoreConstants.APPL_STATUS_CREATE);
	
	   pageContext.setAttribute("LABEL_RADIO_SAME_DAY",  CoreConstants.LABEL_RADIO_SAME_DAY);
	    pageContext.setAttribute("LABEL_RADIO_TILL_THIRD_DAY",  CoreConstants.LABEL_RADIO_TILL_THIRD_DAY);
	    
	    pageContext.setAttribute("RADIO_SAME_DAY",  CoreConstants.LABEL_RADIO_HOME);
	    pageContext.setAttribute("RADIO_TILL_THIRD_DAY",  CoreConstants.RADIO_TILL_THIRD_DAY);
	
	pageContext.setAttribute("APPLICATION_STATUS_LIST", CommonUtils.getApplicationStatusList());
%>
<script type="text/javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery.ajaxfileupload.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script> 
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script type="text/javascript">

function editRTIApplication() {
	//document.getElementById('rtiApplicationId').value = id;
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editRTIApplication.do');
}

function saveDeathRegistration(){
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/saveDeathRegistrationCertificate.do');
}

function rtiApplicationSearch() { 
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/listRTIApplicationReports.do');
}

function viewNoting() { 
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/viewNoting.do');
} 

function viewDrafts(){
	//document.getElementById('manageRTIApplicationId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/viewDrafts.do');
}

function downloadRTIApplicationList(){
	//document.getElementById('manageRTIApplicationId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/downloadRTIApplicationList.do');
}


function listRTIApplicationReports()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/listRTIApplicationReports.do');	
}

function sendEmail()
{
	//document.getElementById('manageRTIApplicationId').value=id;
	document.getElementById('actionTaken').value='email'; 
	onPageSubmit('<c:out value="${contextRoot}"/>/emailsms/emailSMS.do');
}

function sendSMS()
{
	//document.getElementById('manageRTIApplicationId').value=id;
	document.getElementById('actionTaken').value='sms';
	onPageSubmit('<c:out value="${contextRoot}"/>/emailsms/emailSMS.do'); 
}
	
</script>


<style type="text/css">
input[type="text"], textarea {
	background-color: #e9ecef;
	width: 290px;
	box-sizing: border-box;
	border: 1px solid #c8c8c8;
	box-shadow: 0 0 2px #c8c8c8;
	border-radius: 5px;
	color: #333;
}

.ClsSelect {
	background-color: white;
	width: 200px;
	box-sizing: border-box;
	border: 1px solid #c8c8c8;
	box-shadow: 0 0 2px #c8c8c8;
	border-radius: 5px;
	color: #333;
}

.imagefile.downloadFile:hover {
	background-color: #008CBA;
	color: white;
	transition: background-color 0.3s;
}

.mainHdr {
	background-color: white;
}

.form {
	background-color: white;
	background-image: url("D:\nmmc_RTS1\RTI\web\images\flag-bg.jpg");
	background-position: right center;
}

.ClsLabel {
	font-style: normal;
	font-family: inherit;
	font-size: 10px;
	font-weight: 520 !important;
}
</style>

<style type="text/css">
input[type=text] {
	height: 35px;
	font-size: 15px;
}

a {
	text-decoration: none !important;
}

.action {
	width: 100px;
	height: 32px;
}

.generateaction {
	width: 155px;
	height: 32px;
}



.download {
	font-size: 13px;
}
</style>


<div class="mainHdr">
	<h3 style="height: 30px; font-size: 15px; color: #01293d">
		
				<fmt:message key="Application form for Death Certificate"/> :				
			<c:if test="${requestScope.rtiApplication != null}"> 				
				<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
				</c:if>	
			
	</h3>
</div>
<div valign="top" id="SetFormHeight">
<input type="hidden" name="id"
		value="${deathCertificate.death_registration_id}">
       <c:set var="doc"
		value="${fn:split(rtiApplication.pdfUploadFromPortal, ',')}" />
        <table width="100%" border="0" cellpadding="2" cellspacing="2"
                class="dataForm">
         
                <tr>
                 <td >
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Title (शीर्षक)" />:</span>
                             &nbsp;
                        </td>
                      <td colspan="2">
                          <input type="text" class="form-control" style="width:270px" id=applicantTitle maxlength="30" name="applicantTitle" value="<c:out value="${deathCertificate.applicantTitle}"/>"/>
                      </td>
                      <td >
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Name (नाव)" />:</span>
                             &nbsp;
                        </td>
                      <td colspan="2">
                          <input  type="text" class="form-control" style="width:270px" id=applicantFirstName maxlength="30" name="applicantFirstName" value="<c:out value="${deathCertificate.applicantFirstName}"/>"/>
                      </td>
                </tr>
                  
                  
                <tr>
                
                  <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Father's Name (वडिलांचे नाव)" />:</span>
                             &nbsp;
                        </td>
                      <td colspan="2">
                          <input type="text" class="form-control" style="width:270px" id=applicantMiddleName maxlength="30" name="applicantMiddleName" value="<c:out value="${deathCertificate.applicantMiddleName}"/>"/>
                      </td>
                      
                      <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Surname  (आडनाव)" />:</span>
                             &nbsp;
                        </td>
                      <td colspan="2">
                          <input type="text" class="form-control" style="width:270px" id=applicantLastName maxlength="30" name="applicantLastName" value="<c:out value="${deathCertificate.applicantLastName}"/>"/>
                      </td>
                </tr>


                <tr>
                  <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Full Name (संपूर्ण नाव)" />:</span>
                             &nbsp;
                        </td>
                      <td colspan="2">
                          <input type="text" class="form-control" style="width:270px" id=applicantFullName maxlength="30" name="applicantFullName" value="<c:out value="${deathCertificate.applicantFullName}"/>"/>
                      </td>
                      <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Aadhaar No.(आधार क्र.)" />:</span>
                             &nbsp;
                        </td>
                        <td colspan="2">
                                <input type="text" class="form-control" style="width:270px" id="applicantPlotNo" maxlength="30" name="applicantPlotNo" value="<c:out value="${deathCertificate.aadhaarNo}"/>"/>
                        </td>


                </tr>


                       <tr>
                        <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Plot/Flat No (प्लॉट/फ्लॅट क्र.)" />:</span>
                             &nbsp;
                        </td>
                        <td colspan="2">
                                <input type="text" class="form-control" style="width:270px" id="applicantPlotNo" maxlength="30" name="applicantPlotNo" value="<c:out value="${deathCertificate.applicantPlotNo}"/>"/>
                        </td>
                        <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Name of the Building (इमारतीचे नाव)"/>:</span>
                             &nbsp;
                        </td>
                        <td colspan="2">
                                <input type="text" class="form-control" style="width:270px" id="applicantBuildingName" maxlength="30" name="applicantBuildingName" value="<c:out value="${deathCertificate.applicantBuildingName}"/>"/>
                        </td>
                        </tr>
                        <tr>
                         <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Name of the Street (रस्त्याचे नाव)"/>:</span>
                             &nbsp;
                        </td>
                        <td colspan="2">
                                <input type="text" class="form-control" style="width:270px" id="applicantStreetName" maxlength="30" name="applicantStreetName" value="<c:out value="${deathCertificate.applicantStreetName}"/>"/>
                        </td>
                        

                         <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Name of the Area (क्षेत्राचे नाव)"/>:</span>
                             &nbsp;
                        </td>
                        <td colspan="2">
                                <input type="text" class="form-control" style="width:270px" id="applicantAreaName" maxlength="30" name="applicantAreaName" value="<c:out value="${deathCertificate.applicantAreaName}"/>"/>
                        </td>
                                                </tr>
                        <tr>
                         <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Near by Landmark (जवळील लँडमार्क)"/>:</span>
                             &nbsp;
                        </td>
                        <td colspan="2">
                                <input type="text" class="form-control" style="width:270px" id="applicantNearbyLandmark" maxlength="30" name="applicantNearbyLandmark" value="<c:out value="${deathCertificate.applicantNearbyLandmark}"/>"/>
                        </td>
                        
                       
                          <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="City Name (शहराचे नाव) "/>:</span>
                             &nbsp;
                        </td>
                        
                        <td colspan="2">
                                <input type="text" class="form-control" style="width:270px" id="cityName" maxlength="30" name="cityName" value="<c:out value="${deathCertificate.cityName}"/>"/>
                        </td>
                                                </tr>
                        <tr>
                         <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Pin Code (पिन कोड)"/>:</span>
                             &nbsp;
                        </td>
                        <td colspan="2">
                                <input type="text" class="form-control" style="width:270px" id="applicantPinCode" maxlength="30" name="applicantPinCode" value="<c:out value="${deathCertificate.applicantPinCode}"/>"/>
                        </td>
                     
                       <td>
                             <span class="ClsLabel" style="font-size:14px"><fmt:message key="Mobile Number (मोबाईल क्र.)" />:</span>
                        
                        </td>
                        <td colspan="2">
                         
                            <input type="text" class="form-control" style="width:270px" id="ph_no" maxlength="30" name="ph_no" value="<c:out value="${deathCertificate.ph_no}"/>"/>
                        </td>
						  </tr>
                    <tr>
						<td>
                                 <span class="ClsLabel" style="font-size:14px"><fmt:message key="Email Id (ईमेल आयडी)" /></span><span class="ClsRequiredFields"></span>
                            </td>
                            <td colspan="2">
                            <input type="text" class="form-control" style="width:270px" id="email" maxlength="30" name="email" value="<c:out value="${deathCertificate.email}"/>"/>
                            </td>
                            
                        <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Relationship of Applicant (अर्जदाराचा संबंध)"/>:</span>
                             &nbsp;
                        </td>
                        <td colspan="2">
                                <input type="text" class="form-control" style="width:270px" id="applicantRelationship" maxlength="30" name="applicantRelationship" value="<c:out value="${deathCertificate.applicantRelationship}"/>"/>
                        </td>
                         </tr>
                    <tr>  

                        <td>
                          <span class="ClsLabel" style="font-size:14px"><fmt:message key="Address For Correspondence (पत्रव्यवहारासाठी पत्ता) " />:</span><span class="ClsRequiredFields"></span>
                        </td>
                       <td colspan="2">
                            
                           <textarea class="form-control" style="width:270px" id="address" maxlength="30" name="address">${deathCertificate.address}</textarea>
                        
                        </td>
                      
                          <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Name of Deceased (मृत व्यक्तीचे नाव)"/>:</span>
                             &nbsp;
                        </td>
                        <td colspan="2">
                                <input type="text" class="form-control" style="width:270px" id="nameOfDeceased" maxlength="30" name="nameOfDeceased" value="<c:out value="${deathCertificate.nameOfDeceased}"/>"/>
                        </td>
                          </tr>
                    <tr>
                         <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Deceased's Gender (मृत व्यक्तीचे लिंग)"/>:</span>
                             &nbsp;
                        </td>
                        <td colspan="2">
                                <input type="text" class="form-control" style="width:270px" id="gender" maxlength="30" name="gender" value="<c:out value="${deathCertificate.gender}"/>"/>
                        </td>
                      
                          <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Age of Deceased (मृत व्यक्तीचे वय)"/>:</span>
                             &nbsp;
                        </td>
                        <td colspan="2">
                                <input type="text" class="form-control" style="width:270px" id="infantAge" maxlength="30" name="infantAge" value="<c:out value="${deathCertificate.infantAge}"/>"/>
                        </td>
                          </tr>
                    <tr>
                         <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Father's Name (वडिलांचे नाव)"/>:</span>
                             &nbsp;
                        </td>
                        
                        
                        
                        <td colspan="2">
                                <input type="text" class="form-control" style="width:270px" id="fatherName" maxlength="30" name="fatherName" value="<c:out value="${deathCertificate.fatherName}"/>"/>
                        </td>
                      
                       
                          <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Grandfather's Name (आजोबांचे नाव)"/>:</span>
                             &nbsp;
                        </td>
                        <td colspan="2">
                                <input type="text" class="form-control" style="width:270px" id="grandfatherName" maxlength="30" name="grandfatherName" value="<c:out value="${deathCertificate.grandfatherName}"/>"/>
                        </td>
                          </tr>
                    <tr>
                         <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Mother's Name (आईचे नाव)"/>:</span>
                             &nbsp;
                        </td>
                        <td colspan="2">
                                <input type="text" class="form-control" style="width:270px" id="motherName" maxlength="30" name="motherName" value="<c:out value="${deathCertificate.motherName}"/>"/>
                        </td>
                     
                       
                          <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Husband/Wife's Name (पती/पत्नीचे नाव)"/>:</span>
                             &nbsp;
                        </td>
                        <td colspan="2">
                                <input type="text" class="form-control" style="width:270px" id="wifeName" maxlength="30" name="wifeName" value="<c:out value="${deathCertificate.wifeName}"/>"/>
                        </td>
                          </tr>
                    <tr>
                         <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Date of Death (मृत्यूची तारीख)"/>:</span>
                             &nbsp;
                        </td>
                        <td colspan="2">
                                <input type="text" class="form-control" style="width:270px" id="dateOfDeath" maxlength="30" name="dateOfDeath" value="<c:out value="${deathCertificate.dateOfDeath}"/>"/>
                        </td>
                       
                           <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Place of Death (मृत्यूचे ठिकाण)" />:</span>:
                        </td>
			
				<td colspan="2">
				
                             <input type="radio" id="placeOfDeath" name="placeOfDeath" value="1"
				${deathCertificate.placeOfDeath=='1'?'checked':''}>
				<label for="radio3">Home</label><br>
				 <input type="radio" id="placeOfDeath" name="placeOfDeath"
				value="2"
				${deathCertificate.placeOfDeath=='2'?'checked':''}>
				<label for="radio4">Hospital</label><br></td>
				</tr>
                    <tr>
				                      <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Zone No(झोन क्र.)" />:</span>
                        </td>
                           <td colspan="2">
                             <%--  <select name="zone" id="zone" class="ClsSelect">
										<option value=""> <--- Select User ---> </option>
												<c:forEach var="zone" items="${requestScope.zonelist}">
												 	<c:choose>
														<c:when test="${birthRegistration.zone==zone.zoneId}">
															<option value="${zone.zoneId}" selected="selected">
																<c:out value="${zone.name}" /> 
													</option>
														</c:when>
														<c:otherwise>
															<option value="${zone.zoneId}">
															<c:out value="${zone.name}" /> 
															</option>
														</c:otherwise>
														</c:choose>
												</c:forEach>
                    </select> --%>
                         <input type="text" class="form-control" id="zone" style="width:270px" maxlength="30" name="zone" value="<c:out value="${deathCertificate.zone}"/>"/>			               
			              </td> 
                       
                           
                 

    <td>  <span class="ClsLabel" style="font-size:14px"><fmt:message key="Hospital Name and Registration No(रुग्णालयाचे नाव आणि नोंदणी क्र.)" />:</span>:
                        </td>
                           <td colspan="2">
                          <%-- <select name="hospitalName" id="hospitalName" class="ClsSelect">
												<option value=""> <--- Select User ---> </option>
												<c:forEach var="hospital" items="${requestScope.hospitallist}">
												 	<c:choose>
														<c:when test="${deathRegistration.hospitalName==hospital.hospitalId}">
															<option value="${hospital.hospitalId}" selected="selected">
																<c:out value="${hospital.name}" /> 
															</option>
														</c:when>
														<c:otherwise>
															<option value="${hospital.hospitalId}">
																<c:out value="${hospital.name}" /> 
															</option>
														</c:otherwise>
														</c:choose>
														
														
												</c:forEach>
											</select> --%>
                         <input type="text" class="form-control" id="hospitalName" style="width:270px" maxlength="30" name="hospitalName" value="<c:out value="${deathCertificate.hospitalName}"/>"/>			               
			              </td> 
			              </tr>
                    <tr>
                         <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Name of Crematorium (स्मशानभूमींची नावे)" />:</span>
                        </td>
                           <td colspan="2">
			  			<%--<select name="nameofCrematorium" id="nameofCrematorium" class="ClsSelect">
												<option value=""> <--- Select User ---> </option>
												<c:forEach var="crematorium" items="${requestScope.crematoriumlist}">
												 	<c:choose>
														<c:when test="${deathCertificate.nameofCrematorium==crematorium.crematoriumId}">
															<option value="${crematorium.crematoriumId}" selected="selected">
																<c:out value="${crematorium.name}" /> 
															</option>
														</c:when>
														<c:otherwise>
															<option value="${crematorium.crematoriumId}">
																<c:out value="${crematorium.name}" /> 
															</option>
														</c:otherwise>
														</c:choose>
														
														
												</c:forEach>
											</select>  --%>
                         <input type="text" class="form-control" id="nameofCrematorium" style="width:270px" maxlength="30" name="nameofCrematorium" value="<c:out value="${deathCertificate.nameofCrematorium}"/>"/>			               
			              </td> 
  
  

                    <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Reason of Death (मृत्यूचे कारण)" />:</span>
                        </td>	  
				    
                                <td colspan="2">
                           <textarea class="form-control" style="width:270px" id="address" maxlength="30" name="address">${deathCertificate.reasonOfDeath}</textarea>
                                
                           </td> 
                           </tr>
                    <tr>
  <td>
                          <span class="ClsLabel" style="font-size:14px"><fmt:message key="Death Type (मृत्यू प्रकार)" /><span class="ClsRequiredFields"></span>:</span>
                     </td>
                     
                           <td colspan="2">
                             <input type="radio" id="deathType" name="deathType" value="Natural"
				${deathCertificate.deathType=='Natural'?'checked':''}>
				<label for="Natural">Natural</label><br>
				 <input type="radio" id="deathType" name="deathType"
				value="Accidental"
				${deathCertificate.deathType=='Accidental'?'checked':''}>
				<label for="Accidental">Accidental</label><br></td>
      

        <td>
                        <span class="ClsLabel" style="font-size:14px"><fmt:message key="Reason For Certificate (प्रमाणपत्राचे कारण)" /><span class="ClsRequiredFields"></span>:</span>
                      </td>
                      <td colspan="5">
                       <textarea class="form-control" style="width:270px" id="address" maxlength="30" name="address">${deathCertificate.reasonForCertificate}</textarea>
                      
                        
                      </td>
                      
                      </tr>
                      <tr>
                       <td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Is body Donated? (शरीर दान केले आहे का?)"/>:</span>
                             &nbsp;
                        </td>
                        <td colspan="2">
                                <input type="text" class="form-control" style="width:270px" id="bodyDonated" maxlength="30" name="bodyDonated" value="<c:out value="${deathCertificate.bodyDonated}"/>"/>
                        </td>
                      </tr>

                      <tr>
                          <td colspan="7">
                        <span class="ClsLabel" style="font-size:14px"><fmt:message key="Certificates And Fees Details (प्रमाणपत्रे आणि फी तपशील)" /><span class="ClsRequiredFields"></span>:</span>
                        </td>
                        </tr>
                        <tr>
                         <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="Certificate Expected In Days (दिवसात प्रमाणपत्र अपेक्षित आहे)" />:</span>
                        </td>
                          <td colspan="2">
				
                             <input type="radio" id="certificateExpectedInDays" name="certificateExpectedInDays" value="certificateExpectedInDays"
				${deathCertificate.certificateExpectedInDays=='1'?'checked':''}>
				<label for="sameDay">Same Day</label><br>
				 <input type="radio" id="certificateExpectedInDays" name="certificateExpectedInDays"
				value="certificateExpectedInDays"
				${deathCertificate.certificateExpectedInDays=='2'?'checked':''}>
				<label for="tillThirdDay">Till Third Day</label><br></td>
				
				
				
				
				    <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="No Of Certificate Copies (प्रमाणपत्राच्या प्रतींची संख्या)" />:</span>
                        </td>
                          <td colspan="2">
                            <input type="text" class="form-control" id="noOfCertificateCopies" maxlength="10" name="noOfCertificateCopies" value="<c:out value="${deathCertificate.noOfCertificateCopies}"/>"/>
                          </td>
                      </tr>
                      <tr>
                      <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="Fees Applicable (फी लागू)" />:</span>
                        </td>
                           <td colspan="5">
                            <input type="text" class="form-control" id="feesApplicable" maxlength="10"  style="width:270px;" name="feesApplicable" value="<c:out value="${deathCertificate.feesApplicable}"/>"/>
                          </td>
                      </tr>
                       <tr>
                           <td colspan="">
     <span class="ClsLabel" style="font-size:14px"> Current Status: (वर्तमान स्थिती)</span></td>
                           <td colspan="2">
    <span class="ClsLabel" style="font-size:14px;color:forestgreen;">
     <c:if test="${requestScope.rtiApplication.workFlowStatus==0}">
						Citizen Form Submitted. 
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
					</c:if></span>
     </td>      
     <td><span class="ClsLabel" style="font-size:14px">Certificate Upload: (प्रमाणपत्र अपलोड करा) </span> </td>
<td>
                      
			<input type="file" class="imagefile" name="idProof" id="idProof" style="width: 220px" />
			</td>
                   <td>   
                      <c:if test="${ empty requestScope.rtiApplication.pdfFilesSavedPath}">   
               
       <a class="bg-button btn btn-primary bd-highlight" style="color:white" id="birthupload" type="button" target="_blank" onclick="birthupload(${deathCertificate.rti_ref_id}); return false;"><span class="download" style="align-items: center">Upload</span></a>

               
                </c:if>
              <c:if test="${ not empty requestScope.rtiApplication.pdfFilesSavedPath}">
              
              						
						                           <a class="bg-button btn btn-success bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${requestScope.rtiApplication.pdfFilesSavedPath}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
               </c:if>
             
                
                </td>     </tr>
                     <tr>
                     <td colspan="6"
										style="background-color: white; background-color: #c5ddfe;"><span
										class="ClsLabel"
										style="height: 37px; padding: 7px 10px 11px; font-size: 17px; color: #01293d; font-style: italic;"><fmt:message
												key="List of Documents (Attachment) (कागदपत्रांची यादी (संलग्नकांसह))" />:</span></td>
                        
                  
		
              <c:if test="${doc[0] != 'null'}">
			<tr>
				<td colspan="4.0"><span class="ClsLabel"
					style="font-size: 14px"><fmt:message
							key="Hospital Certificate (रुग्णालयाचे प्रमाणपत्र)" />:</span> <c:if
						test="${requestScope.downloadCount>0}">
						<a target="_blank"
							href="<c:out value="${requestScope.downloadPath[0]}"/>"
							id="download1">
					</c:if> <c:if test="${requestScope.downloadCount==0}">
						<a target="_blank" href="http://175.101.6.10:8085/RTS/UploadDoc/">
					</c:if></td>
				<td style="text-align: center" colspan="3.5"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[0]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>
			</tr>
		</c:if>     
                                 <c:if test="${doc[1] != 'null'}">
                   
                    <tr>  <td colspan="4.0">
                    <span class="ClsLabel" style="font-size:14px"><fmt:message key="Deceased ID Proof (Aadhar/PAN/Voting Card/T.C./etc)(मृत व्यक्तीचा ओळखपत्र पुरावा (आधार/पॅन/मतदान कार्ड/टी.सी./इ.))" />:</span>
                    
                               <c:if test="${requestScope.downloadCount>0}">
                    <a target="_blank" href="<c:out value="${requestScope.downloadPath[1]}"/>" id="download1"> 
                    </c:if>
                    <c:if test="${requestScope.downloadCount==0}">
                    <a target="_blank" href="http://175.101.6.10:8085/RTS/UploadDoc/Hospital.pdf">
                    </c:if></td><td style="text-align: center" colspan="3.5">
<a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[1]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>                </tr> </c:if>
                                <c:if test="${doc[2] != 'null'}">
                  
                  <tr>
                     <td colspan="4.0">
                    <span class="ClsLabel" style="font-size:14px"><fmt:message key="Applicant's ID Proof (Aadhar/PAN/Voting Card/T.C./etc) (अर्जदाराचा ओळखपत्र पुरावा (आधार/पॅन/मतदान कार्ड/टी.सी./इ.))" />:</span>
                    <c:if test="${requestScope.downloadCount>0}">
                    <a target="_blank" href="<c:out value="${requestScope.downloadPath[2]}"/>" id="download2"> 
                    </c:if>
                    <c:if test="${requestScope.downloadCount==0}">
                    <a target="_blank" href="http://175.101.6.10:8085/RTS/UploadDoc/Hospital.pdf">
                    </c:if></td><td style="text-align: center" colspan="3.5">
<a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[2]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>                    
                      </td></tr></c:if>
                                    <c:if test="${doc[3] != 'null'}">
                      
                      <tr><td colspan="4.0">     
                     
                    <span class="ClsLabel" style="font-size:14px"><fmt:message key="Crematoriums Certificate (स्मशानभूमीचे प्रमाणपत्र)" />:</span>
                     <c:if test="${requestScope.downloadCount>0}">
                    <a target="_blank" href="<c:out value="${requestScope.downloadPath[3]}"/>" id="download3"> 
                    </c:if>
                    <c:if test="${requestScope.downloadCount==0}">
                    <a target="_blank" href="http://175.101.6.10:8085/RTS/UploadDoc/Hospital.pdf">
                    </c:if></td><td  style="text-align: center"colspan="3.5">
<a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[3]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>                             
                             </td></tr></c:if>
                             <!-- Body Donated -->
                             <c:if test="${doc[4] != 'null'}">
                             
                             <tr>
                             <td colspan="4.0">
                             
                             <span class="ClsLabel" style="font-size:14px"><fmt:message key="Body Donate Certificate (शरीर दान प्रमाणपत्र)" />:</span>
                     <c:if test="${requestScope.downloadCount>0}">
                    <a target="_blank" href="<c:out value="${requestScope.downloadPath[4]}"/>" id="download4"> 
                    </c:if>
                    <c:if test="${requestScope.downloadCount==0}">
                    <a target="_blank" href="http://175.101.6.10:8085/RTS/UploadDoc/Hospital.pdf">
                    </c:if></td><td  style="text-align: center"colspan="3.5">
<a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[4]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>                           
                     </td>
                     
                     
                     </tr>
                    		</c:if>
                             
                                                 		<c:if test="${doc[5] != 'null'}">
                             
                             <tr>
                             <td colspan="4.0">
                             
                             <span class="ClsLabel" style="font-size:14px"><fmt:message key="Certificate issued by Correspondent
(ward member)(बातमीदाराने जारी केलेले प्रमाणपत्र(वॉर्ड सदस्य))" />:</span>
                     <c:if test="${requestScope.downloadCount>0}">
                    <a target="_blank" href="<c:out value="${requestScope.downloadPath[5]}"/>" id="download4"> 
                    </c:if>
                    <c:if test="${requestScope.downloadCount==0}">
                    <a target="_blank" href="http://175.101.6.10:8085/RTS/UploadDoc/Hospital.pdf">
                    </c:if></td><td  style="text-align: center"colspan="3.5">
<a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[5]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>                          
                     </td>
                     
                     
                     </tr>
                    		</c:if>
                    
    
        <tr>
            <td colspan="6" style="padding-top:5px">
                <img src="../images/Transpx.gif" height="15px" />
            </td>
        </tr>
        <tr>
           <!--  <td colspan="6" style="padding-top:5px">
                <img src="../images/Transpx.gif" height="15px" />
            </td> -->
             
        </tr>
        <%--  <tr>
            <td colspan="6" align="center">
                           <input type="button" class="ClsButton" id="save" name="save" value="Save"
                       onclick="javascript:saveDeathRegistration(this.form);" tabindex="31">
                       <input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>"
							onclick="javascript:clearFields('SearchTable');searchRTIApplication()" />
							 </td>
							 </tr> --%>
                    </table>
                     
                       <input type="hidden" class="ClsTextbox_mr" style="width:180px" id="death_registration_id" maxlength="12" name="death_registration_id" value="<c:out value="${deathCertificate.death_registration_id}"/>" />
                     <input type="hidden" class="ClsTextbox_mr" style="width:180px" id="rtiApplicationRefId" maxlength="12" name="rtiApplicationRefId" value="<c:out value="${requestScope.rtiApplication.rtiApplicationId}"/>" />
        	<input type="hidden" id="rtiApplicationRefIds" name="rtiApplicationRefIds" value="${deathCertificate.rti_ref_id}" />
        <input type="hidden" id="responseData" name="responseData"
								value="" />

     <%@include file="/pages/workflow/taskInclude.jsp"%>
</div>

<script type="text/javascript">
function saveEntity()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/createDeathCertificateWork.do');
}

function birthupload(id) {
	  
	    var data = new FormData();
	   var idProofFileInput = $("#idProof");
	 	 
	 	if (idProofFileInput.val() === '') {
	 	    alert("Please select the document!!");
	 	    return false;
	 	}
	    alert("Are you sure you want to Upload Certificate?");
	    
	  document.getElementById('rtiApplicationRefIds').value = id;

	if (idProofFileInput.length > 0 && idProofFileInput.get(0).files.length > 0) {
	    data.append('idProof1', idProofFileInput.get(0).files[0]);

	   
	} else {
	    console.error("No file selected");
	}

  var apptype=2;
	  $.ajax({
		  url: "<c:out value='${contextRoot}'/>/mobileapp/rtsapplication/getHealthDSC.do?id="+apptype,
		 type: 'POST',
     data: data,
     cache: false,
      dataType: 'xml',
     processData: false,
     contentType: false,
     async: false, 
	        success: function(response) {

	        	 console.log(response);
		     
		       
		            var status = $(response).find("fileName").text();
		            console.log("Status"+status);
		       
		     
		        $.ajax({
			        url: "http://127.0.0.1:1620",
			        type: 'POST',
			        data: status,
			     
			        processData: false, // Don't process the files
			        contentType: 'application/xml', // Set content type to false as jQuery will tell the server its a query string request
			     
				      
				      
			       
			        success: function(status) {
				       
			            console.log("Successd"+status);
			         
			            document.getElementById('responseData').value = status;
			            console.log("After @@@"+status);
			      	  //onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveBirthCertificate.do');
			      	 $.ajax({
	                    url: '<c:out value="${contextRoot}"/>/rtsapplication/saveDeathUpload.do?refId='+id,
	                    type: 'POST',
	                   async: false, 
	                   data: {
	 			        	status : status
	 			        	
	 			        },
	                   
	                	  success: function(data, textStatus, jqXHR) {
	                		    console.log("Data:", data);

	                		    var parsedData = JSON.parse(data);
	                		    var finalstatus = parsedData.status;

	                		    console.log("finalstatus:", finalstatus);

	                		    if (finalstatus === true) {
	                		        alert("Upload has been done successfully!");
	                		        window.location.reload(); 
	                		    } else {
	                		        alert("Upload has been failed!!");
	                		    }
	                		},
	                    error: function (xhr) {
      	        		    alert("Upload has been failed !");
	                        console.log(xhr.responseText);
	                    }
	                });
	            },
			        error: function(xhr) {
			        	  alert("failed POST");
			        	  console.log("failed"+status);
			            console.log(xhr.responseText);
			        }
			    });
		        
	         
		      /*    } else {
			            console.log("No <fileName> elements found ");
			          }
			        } else {
			          console.log("No <request> elements found in XML");
			        }*/
			        
		    
	    },
	        error: function(xhr) {
	        	  alert("failed GET");
	            console.log(xhr.responseText);
	        }
	    });

	
	  
	//  onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/'+url);
return false;

	}


	function docDownload(filesPath) {
 	    var encodedFilePath = encodeURIComponent(filesPath);

 	    var encodedFilesPath = btoa(encodedFilePath); 

 	    window.open('<c:out value="${contextRoot}"/>/rtsApplication/getPdf.do?fp=' + encodedFilesPath, '_blank');
 	}
</script>


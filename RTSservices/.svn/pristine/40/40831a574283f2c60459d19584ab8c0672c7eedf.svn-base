<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mars.common.utils.CommonUtils"%>
<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:directive.include file="/pages/common/include.jsp" />
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="com.mars.common.utils.SessionUser"%>
<%@ page import="com.mars.common.model.User"%>
<jsp:directive.include file="/pages/common/include.jsp" />

<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	pageContext.setAttribute("DATE_TIME_DB_FORMAT", Constants.DATE_TIME_DB_FORMAT);

	pageContext.setAttribute("DATE_TIME_FORMAT", WorkflowConstants.WORKFLOW_DATE_FORMAT);
    
    pageContext.setAttribute("STATUS_YES_LABEL", CoreConstants.STATUS_YES_LABEL);
    pageContext.setAttribute("STATUS_NO_LABEL", CoreConstants.STATUS_NO_LABEL);
    
    pageContext.setAttribute("STATUS_YES",  CoreConstants.STATUS_YES);
    pageContext.setAttribute("STATUS_NO",  CoreConstants.STATUS_NO);
	
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
	
	pageContext.setAttribute("APPLICATION_STATUS_LIST", CommonUtils.getApplicationStatusList());
%>
<%
HttpSession session1 = request.getSession();
SessionUser sessionUser = (SessionUser) session1.getAttribute("SessionUser");
Long userId = sessionUser.getUserId();
request.setAttribute("userId", userId);
%>

<script type="text/javascript"
	src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery.ajaxfileupload.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>



<script type="text/javascript">
function editRTIApplication() {
	//document.getElementById('rtiApplicationId').value = id;
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editNurshingHome.do');
} 


function saveNursingHome() {
	
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/saveNursingHome.do');
} 

	

function getOutwardNumber() {
	  var outwardNumber = document.getElementById("outwardNo").value;
	  if (outwardNumber != "") {
	    alert("outward number is already generated , The current outward number is " + outwardNumber);
	    event.preventDefault();
	    return false;
	  }
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/generateoutwardNoNursing.do');
	
	}

function downloads(id,url) {

	document.getElementById('rtiApplicationRefId').value = id;
	
	alert("Certificate has been generated successfully.");
	
	onPageSubmit('<c:out value="${contextRoot}"/>/rtsApplicationReport/'+url);

}
</script>

<style type="text/css">
input[type="text"],
textarea {
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

 .ClsLabel{
 font-style:normal;
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


.action{
width:100px;
height:32px;

}

.generateaction{
width:155px;
height:32px;
}

#table1{
 padding: 7px;
    font-size: 11px;
    width: 100%;
}

#table2{
 padding: 5px;
    font-size: 11px;
    width: 100%;
}

.download{
font-size:13px;
}

/* CSS for table and cells */
.dataForm {
    width: 100%; /* Set the table width to 100% */
    table-layout: fixed; /* Ensure the table doesn't exceed 100% */
    border-collapse: collapse;
}


</style>
<div class="mainHdr">
	<h3 style="
    height: 30px;
        font-size: 15px;color:#01293d">

		<fmt:message key="Nursing Home Registration" />
		<c:if test="${requestScope.rtiApplication != null}">
			<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
		</c:if>

	</h3>
</div>
<div class="form" valign="top" id="SetFormHeight">
	<input type="hidden" name="id"
		value="${nursingHomes.nursinghomesregId}">
		
		<table id="form"  width="100%" colspan="" border="0" cellpadding="2"
		cellspacing="2" class="dataForm" id="data">
					                    <c:set var="doc" value="${fn:split(rtiApplication.pdfUploadFromPortal, ',')}" />
		
		<tr>
		

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Date (दिनांक)" />:</span></td>
			<td><input type="text" class="ClsTextbox" style="width: 180px"
				id="title" maxlength="50" name="title"
				value="<c:out value="${nursingHomes.registrationDate}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Mobile No (मोबाईल क्र)" />:</span><span class="ClsRequiredFields"></span>
			</td>
			
			<td><input type="text" class="ClsTextbox" style="width: 180px"
				id="title" maxlength="50" name="title"
				value="<c:out value="${nursingHomes.phone}"/>" /></td>
		</tr>



        <tr>
		

        <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
                    key="Email (ईमेल)" />:</span></td>
        <td><input type="text" class="ClsTextbox" style="width: 180px"
            id="title" maxlength="50" name="title"
            value="<c:out value="${nursingHomes.email}"/>" /></td>

    </tr>
		

	
  <tr>
			<td colspan="4" style="background-color:  #fcfdfe;"><span
				class="ClsLabel"
				style="height: 37px; font-size: 17px; color: #01293d;font-style: italic;"><fmt:message
						key="Form B (See rule 4 and 6) Application for Nursing Home Registration under section 5 of the Bombay Nursing homes Registration Act,1949 " /></span>
		</tr>
  <tr>
		

        <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
                    key="Full Name of applicant (अर्जदाराचे पूर्ण नाव)" />:</span></td>
        <td><input type="text" class="ClsTextbox" style="width: 180px"
            id="title" maxlength="50" name="title"
            value="<c:out value="${nursingHomes.name}"/>" /></td>

        <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
                    key="Full residential address of the applicant(अर्जदाराचा संपूर्ण निवासी पत्ता)" />:</span><span class="ClsRequiredFields"></span>
        </td>
        
        <td><input type="text" class="ClsTextbox" style="width: 180px"
            id="title" maxlength="50" name="title"
            value="<c:out value="${nursingHomes.applicantAddress}"/>" /></td>
    </tr>

    <tr>
		

        <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
                    key="Technical Qualification if any of the applicant(अर्जदाराची तांत्रिक पात्रता असल्यास)" />:</span></td>
        <td><input type="text" class="ClsTextbox" style="width: 180px"
            id="title" maxlength="50" name="title"
            value="<c:out value="${nursingHomes.techQul}"/>" /></td>

        <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
                    key="Nationality of the applicant (अर्जदाराचे राष्ट्रीयत्व)" />:</span><span class="ClsRequiredFields"></span>
        </td>
        
        <td><input type="text" class="ClsTextbox" style="width: 180px"
            id="title" maxlength="50" name="title"
            value="<c:out value="${nursingHomes.nationality}"/>" /></td>
    </tr>


    <tr>
		

        <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
                    key="Situation of the registered or principal office of the company, Society, Association or other body corporate(कंपनी, सोसायटी, असोसिएशन किंवा इतर बॉडी कॉर्पोरेटच्या मुख्य कार्यालयाची नोंदणीकृत स्थिती)" />:</span></td>
        <td><input type="text" class="ClsTextbox" style="width: 180px"
            id="title" maxlength="50" name="title"
            value="<c:out value="${nursingHomes.situationOf}"/>" /></td>

        <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
                    key="Name and Other particulars of the nursing home in respect of which the registration is applied for. (नर्सिंग होमचे नाव आणि इतर तपशील ज्यासाठी नोंदणीसाठी अर्ज केला आहे.)" />:</span><span class="ClsRequiredFields"></span>
        </td>
        
        <td><input type="text" class="ClsTextbox" style="width: 180px"
            id="title" maxlength="50" name="title"
            value="<c:out value="${nursingHomes.nameRegNursingHome}"/>" /></td>
    </tr>



    <tr>
		

        <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
                    key="Place where the nursing  home is situated (नर्सिंग होम जेथे आहे ते ठिकाण)" />:</span></td>
        <td><input type="text" class="ClsTextbox" style="width: 180px"
            id="title" maxlength="50" name="title"
            value="<c:out value="${nursingHomes.placeOfNStaff}"/>" /></td>

      <%--   <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
                    key="Autocad Map Available (ऑटोकॅड नकाशा उपलब्ध)" />:</span><span class="ClsRequiredFields"></span>
        </td>
        
        <td><input type="text" class="ClsTextbox" style="width: 180px"
            id="title" maxlength="50" name="title"
            value="<c:out value="${nursingHomes.autoCad}"/>" /></td> --%>
    </tr>


    <tr>
		

        <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
                    key="Weather Nursing Home or any Premises Used in Connection there with are used or are to be used for purposes Other then that of carrying an nursing home (नर्सिंग होम किंवा त्यांच्या संबंधात वापरलेली कोणतीही जागा नर्सिंग होमसाठी वापरली जात आहे किंवा वापरली जाणार आहे.)" />:</span></td>
        <td><input type="text" class="ClsTextbox" style="width: 180px"
            id="title" maxlength="50" name="title"
            value="<c:out value="${nursingHomes.connectionOfPremises}"/>" /></td>

        <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
                    key="No of beds for Maternity Patients (प्रसूती रुग्णांसाठी बेडची संख्या)" />:</span><span class="ClsRequiredFields"></span>
        </td>
        
        <td><input type="text" class="ClsTextbox" style="width: 180px"
            id="title" maxlength="50" name="title"
            value="<c:out value="${nursingHomes.maternityPatients}"/>" /></td>
    </tr>


    <tr>
		

        <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
                    key="Number of beds for other patients (इतर रुग्णांसाठी बेडची संख्या)" />:</span></td>
        <td><input type="text" class="ClsTextbox" style="width: 180px"
            id="title" maxlength="50" name="title"
            value="<c:out value="${nursingHomes.noBedOPatient}"/>" /></td>
    </tr>
    
    <tr>
			<td colspan="4" style="background-color:  #fcfdfe;"><span
				class="ClsLabel"
				style="height: 37px; font-size: 17px; color: #01293d;font-style: italic;"><fmt:message
						key="Names,Ages and Qualification of the Resident or Visiting physicians or Surgeons in the Nursing Home (न्युरिसिंग होममधील निवासी किंवा भेट देणारे डॉक्टर किंवा सर्जन यांची नावे, वय आणि पात्रता)" />:</span>
		</tr>
		<tr>

			<table colspan="" border="0" cellpadding="2" cellspacing="2"
				id="table1" class="" >
				<tr class="ClsTRHeaderList">
					<td><span class="ClsLabel"><fmt:message key="Sno" /> </span></td>
					<td><span class="ClsLabel"><fmt:message key="Visiting Doctor Name" />
					</span></td>
					<td><span class="ClsLabel"><fmt:message
								key="Age" /> </span>
					</td>
					<td><span class="ClsLabel"><fmt:message key="Education" />
					</span></td>
					<td><span class="ClsLabel"><fmt:message key="Medical Reg No" />
					</span></td>
					
				</tr>
				
				<c:forEach var="surgeonsDetailsList" items="${requestScope.doctorDetailsList}"
					varStatus="iCount">
					
					<tr class="ClsTRContentListWhite">
						<td><c:out value="${iCount.index+1}" /></td>

						<td>${surgeonsDetailsList.doctorName}</td>
						<td>${surgeonsDetailsList.doctorAge}</td>
						<td>${surgeonsDetailsList.doctorEducation}</td>
						<td>${surgeonsDetailsList.doctorRegNo}</td>

						
						
					</tr>
				</c:forEach>

				</tr>




         
		 <tr>
			<td colspan="5" style="background-color: #fcfdfe;"><span
				class="ClsLabel"
				style="height: 37px; font-size: 17px; color: #01293d;font-style: italic;"><fmt:message
						key="Names,Ages and Qualification of the Members of the Nursing Staff in the Nusring Home(नर्सिंग होममधील नर्सिंग स्टाफच्या सदस्यांची नावे, वय आणि पात्रता)" />:</span>
		</tr>
		<tr>

			
				<tr class="ClsTRHeaderList">
					<td><span class="ClsLabel"><fmt:message key="Sno" /> </span></td>
					<td><span class="ClsLabel"><fmt:message key="Name of Working Nurse" />
					</span></td>
					<td><span class="ClsLabel"><fmt:message
								key="Age" /> </span> 
					</td>
					<td><span class="ClsLabel"><fmt:message key="ANM/GNM" />
					</span> </td>
					<td><span class="ClsLabel"><fmt:message key="Nursing Council Reg No" />
					</span></td>
					
				</tr>
				
				<c:forEach var="nurseDetailsList" items="${requestScope.nurseDetailsList}"
					varStatus="iCount">
					
					<tr class="ClsTRContentListWhite">
						<td><c:out value="${iCount.index+1}" /></td>

						<td>${nurseDetailsList.nurseName}</td>
						<td>${nurseDetailsList.nurseAge}</td>
						<td>${nurseDetailsList.nurseEducation}</td>
						<td>${nurseDetailsList.nurseRegNo}</td>

						
						
					</tr>
				</c:forEach>
				 
</table>
				 
		
<!-- 		<div style="width: 100%; background-color: white;border-left: 1px solid lightgray; border-right: 1px solid lightgray; margin-top: -7px ">
 -->		
<table id="form"       
		cellspacing="2" class="dataForm" id="data"   border="0"  style="border-collapse: collapse;background-color: white;width: 100%;" 
								>
<tr>
<td ><span class="ClsLabel" style="font-size: 14px">
        <fmt:message
                    key="Place Where Nursing Staff is Accomdated (ज्या ठिकाणी नर्सिंग स्टाफला सामावून घेतले जाते)" />:</span></td>
        <td style="border: 1px solid lightgray; padding: 8px; text-align: left;"><input type="text" class="ClsTextbox" style="width: 180px"
            id="title" maxlength="50" name="title"
            value="<c:out value="${nursingHomes.nursingStaffAccommodated}"/>" /></td>

        <td style="border: 1px solid lightgray; padding: 8px; text-align: left;"><span class="ClsLabel" style="font-size: 14px; width: 400px" ><fmt:message
                    key="Whether the nursing
                        homes is under the supervision of qualified medical practitioner or a qualified nurse ,and if  qualifications (नर्सिंग असो
                        घरे पात्र वैद्यकीय व्यवसायी किंवा पात्र परिचारिका यांच्या देखरेखीखाली आहेत आणि पात्रता असल्यास)" />:</span><span class="ClsRequiredFields"></span>
        </td>
        
        <td style="border: 1px solid lightgray; padding: 8px; text-align: left;"><input type="text" class="ClsTextbox" style="width: 180px"
            id="title" maxlength="50" name="title"
            value="<c:out value="${nursingHomes.qualifiedNurse}"/>" />     <c:if test="${doc[0] != 'null'}">

<a class="bg-button btn btn-primary bd-highlight action" style="margin-top: 60px; margin-left: -150px"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[0]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
	</c:if></td>
     
</tr>
<tr style="border: 1px solid lightgray; padding: 8px; text-align: left;"> <td style="border: 1px solid lightgray; padding: 8px; text-align: left;"><span class="ClsLabel" style="font-size: 14px"><fmt:message
                    key="Proportion of the qualified <br> and unqualified  nurses  on the nursing staff (नर्सिंग कर्मचाऱ्यांवर पात्र आणि अपात्र परिचारिकांचे प्रमाण)" />:</span></td>
        <td style="border: 1px solid lightgray; padding: 8px; text-align: left;"><input type="text" class="ClsTextbox" style="width: 180px"
            id="title" maxlength="50" name="title"
            value="<c:out value="${nursingHomes.unregMedUnquilNursingStaff}"/>" /></td>

        <td style="border: 1px solid lightgray; padding: 8px; text-align: left;"><span class="ClsLabel" style="font-size: 14px"><fmt:message
                    key="Whether the nursing home is under the supervision of a qualified nurse midwife and if so, her name age and qualifications (नर्सिंग होम एखाद्या पात्र परिचारिका दाईच्या देखरेखीखाली आहे की नाही आणि तसे असल्यास, तिचे नाव वय आणि पात्रता)" />:</span><span class="ClsRequiredFields"></span>
        </td>
        
        <td style="border: 1px solid lightgray; padding: 8px; text-align: left;"><input type="text" class="ClsTextbox" style="width: 180px"
            id="title" maxlength="50" name="title"
            value="<c:out value="${nursingHomes.qulnurseMidwife}"/>" /> <c:if test="${doc[1] != 'null'}">

<a class="bg-button btn btn-primary bd-highlight action" style="margin-top: 60px; margin-left: -150px"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[1]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
	</c:if></td>
           </tr>
	<tr>
	
	 <td style="border: 1px solid lightgray; padding: 8px; text-align: left;"><span class="ClsLabel" style="font-size: 14px"><fmt:message
                    key="Whether any unregistered medical practitioner or<br> unqualified midwife is employed for nursing of  patients <br> in the nursing home (नर्सिंग होममध्ये <br> रुग्णांच्या शुश्रुषेसाठी नोंदणीकृत नसलेले वैद्यकीय व्यवसायी किंवा अपात्र दाईची नियुक्ती केली आहे का.)" />:</span></td>
        <td style="border: 1px solid lightgray; padding: 8px; text-align: left;"><input type="text" class="ClsTextbox" style="width: 180px"
            id="title" maxlength="50" name="title"
            value="<c:out value="${nursingHomes.unregisteredMedicalPractitionar}"/>" /> 
            <c:if test="${doc[2] != 'null'}">

<a class="bg-button btn btn-primary bd-highlight action" style="margin-top: 60px; margin-left: -150px"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[2]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
            
	</c:if></td>

<td style="border: 1px solid lightgray; padding: 8px; text-align: left;"><span class="ClsLabel" style="font-size: 14px"><fmt:message
                    key="Whether any person of alien

nationality is <br> employed in the

nursing home and if so, his<br>

name and other particulars (परदेशी राष्ट्रीयत्वाची कोणतीही व्यक्ती नोकरीत आहे की नाही
नर्सिंग होम आणि असल्यास, त्याचे नाव आणि इतर तपशील) " />:</span><span class="ClsRequiredFields"></span>
        </td>
        
        <td style="border: 1px solid lightgray; padding: 8px; text-align: left;"><input type="text" class="ClsTextbox" style="width: 180px"
            id="title" maxlength="50" name="title"
            value="<c:out value="${nursingHomes.alienNationality}"/>" />        
            
            <c:if test="${doc[3] != 'null'}">

<a class="bg-button btn btn-primary bd-highlight action" style="margin-top: 60px; margin-left: -150px"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[3]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
	</c:if>
            
            
                     </td>

            
            </tr>
	<tr>
	
	 <td style="border: 1px solid lightgray; padding: 8px; text-align: left;"><span class="ClsLabel" style="font-size: 14px"><fmt:message
                    key="Whether the applicant is

interested in any other nursing

home or business and, if so the

place where such nursing home

is situated or where such

business is conducted (अर्जदारास
इतर कोणत्याही नर्सिंगमध्ये स्वारस्य आहे
घर किंवा व्यवसाय आणि, असल्यास
जेथे असे नर्सिंग होम आहे किंवा जेथे असा व्यवसाय केला जातो)" />:</span></td>
        <td style="border: 1px solid lightgray; padding: 8px; text-align: left;"><input type="text" class="ClsTextbox" style="width: 180px"
            id="title" maxlength="50" name="title"
            value="<c:out value="${nursingHomes.applicantInterestE}"/>" />
            
                <c:if test="${doc[4] != 'null'}">

<a class="bg-button btn btn-primary bd-highlight action" style="margin-top: 60px; margin-left: -150px"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[4]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
	</c:if>
            </td>
            
            <td style="border: 1px solid lightgray; padding: 8px; text-align: left;"><span class="ClsLabel" style="font-size: 14px"><fmt:message
                    key="Zone No(झोन क्र.) " />:</span><span class="ClsRequiredFields"></span>
        </td>
        
        <td style="border: 1px solid lightgray; padding: 8px; text-align: left;"><input type="text" class="ClsTextbox" style="width: 180px"
            id="title" maxlength="50" name="title"
            value="<c:out value="${nursingHomes.zoneNo}"/>" />  

            </td>
            
	</tr>
	<tr>
	 <td style="border: 1px solid lightgray; padding: 8px; text-align: left;"><span class="ClsLabel" style="font-size: 14px"><fmt:message
                    key="Fees Applicable (शुल्क लागू)" />:</span><span class="ClsRequiredFields"></span>
        </td>
        
        <td style="border: 1px solid lightgray; padding: 8px; text-align: left;"><input type="text" class="ClsTextbox" style="width: 180px"
            id="title" maxlength="50" name="title"
            value="<c:out value="${nursingHomes.fees}"/>" /></td>
                    <c:if test="${not empty nursingHomes.renewalNursingHome}">
            
             <td style="border: 1px solid lightgray; padding: 8px; text-align: left;"><span class="ClsLabel" style="font-size: 14px"><fmt:message
                    key="Existing Nursing Home Registration No." />:</span><span class="ClsRequiredFields"></span>
        </td>
         
        
        <td style="border: 1px solid lightgray; padding: 8px; text-align: left;"><input type="text" class="ClsTextbox" style="width: 180px"
            id="title" maxlength="50" name="title"
            value="<c:out value="${nursingHomes.renewalNursingHome}"/>" /> 
            </td>
            </c:if>
	</tr>

								<c:if test="${requestScope.rtiApplication.workFlowStatus==2}">

									<tr>
										<td colspan="4" align="center"><a
											class="bg-button btn btn-success bd-highlight generateaction"
											id="genCerBtn" style="color: white"
											onclick="downloads('${nursingHomes.rtiRefId}', 'nurisngRegistration.do');"
											type="button" target="_blank"> <span class="download"
												style="display: flex; align-items: center;">Generate
													Certificate</span>
										</a> <a class="bg-button btn btn-success bd-highlight action"
											style="color: white" id="dsc" type="button" target="_blank"
											onclick="download1(${nursingHomes.rtiRefId});return false;"><span
												class="download" style="align-items: center">Apply
													DSC</span></a></td>


									</tr>
								</c:if>

								<tr>
										 <td><span class="ClsLabel" style="font-size:14px"> Current Status:</span></td>
     <td> <span class="ClsLabel" style="font-size:14px;color:forestgreen;"> <c:if
												test="${requestScope.rtiApplication.workFlowStatus==0}">
						Citizen Form Submitted. 
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==3}">
						Citizen Payment Pending. 
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
						Citizen Payment Completed
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==1}">
						Completed and File Uploaded for Citizen
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==5}">
						Rejected
					</c:if></span></td>


									<%--  <td colspan="6" align="center">
                   	<c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
                      <a target="_blank" href="" id="genCerBtn">
                      
                      <button name="rtiApplicationRefId" class="ClsButton clsButtonUpload" onclick="download(${zoneCertificates.rti_ref_id},'zoneCertificateReport.do')">GENERATE CERTIFICATE</button>
                     </a>
                 
	   </td>  --%>

</tr>
<tr>
									<c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
										<td colspan="2" style="border: 1px solid lightgray; padding: 8px; text-align: left;"><span class="ClsLabel" style="font-size: 14px">Certificate
												Upload: </span></td>
									<%@include file="/pages/common-pages/dms/fileUpload.jsp"%>
																		</c:if>
									
								</tr>

		
		
	
	
	
		<tr>
			<table width="100%"   cellpadding="2" cellspacing="2"
								class="container"  style="border-left: 1px solid lightgray; border-right: 1px solid lightgray;">
			
			<td colspan="4" style="background-color: white;background-color: #c5ddfe;"><span class="ClsLabel"
				style="display: inline-block;
    height: 40px;
    padding: 7px 10px 11px;
       font-size: 17px;color:#01293d;font-style: italic;"><fmt:message
						key="List of Documents (Attachment) For Nursing Home" />:</span></td>
						</table>
							</div>
						
						<div style="width: 100%; background-color: white;border-left: 1px solid lightgray; border-right: 1px solid lightgray;  margin-top: -7px">
						<br>
		
		<table id="form"  width="100%"    
		cellspacing="2" class="dataForm" id="data"   border="0"  style="border-collapse: collapse; background-color: white;width: 98.75%;margin-left: 8px;margin-right: 8px;margin-top: 5px; margin-bottom: 5px " >
		<tr><c:if test="${doc[5] != 'null'}">

				<td style="border: 1px solid lightgray; padding: 8px; text-align: left"><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Self  attested copy of Hospital/Nursing Home Map sanctioned by NMC/NIT (एनएमसी/एनआयटीने मंजूर केलेल्या हॉस्पिटल/नर्सिंग होम नकाशाची स्व-साक्षांकित प्रत)" />:</span>
				 </td>
				 <td style="border: 1px solid lightgray; padding: 8px; text-align: left"> <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[5]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>
				
			</c:if>
			
			<c:if test="${doc[6] != 'null'}">

				<td style="border: 1px solid lightgray; padding: 8px; text-align: left" ><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Autocad maps showing medical facilities with required space reserved for beds in sq.ft. (sq.ft मध्ये बेडसाठी आरक्षित आवश्यक जागेसह वैद्यकीय सुविधा दर्शवणारे ऑटोकॅड नकाशे.)" />:</span>
				</td>
				<td style="border: 1px solid lightgray; padding: 8px; text-align: left">
				<a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[6]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
				</td>
				 
			</c:if> 
			
			
			</tr>
		<tr> 
		 <c:if test="${doc[7] != 'null'}">

<td style="border: 1px solid lightgray; padding: 8px; text-align: left" ><span class="ClsLabel" style="font-size: 14px"><fmt:message
            key="Fire audit of Hospital/Nursing home building. (हॉस्पिटल / नर्सिंग होम इमारतीचे फायर ऑडिट.)" />:</span>
            
            
</td>
<td style="border: 1px solid lightgray; padding: 8px; text-align: left"><a class="bg-button btn btn-primary bd-highlight action"
type="button"
target="_blank"
onclick="docDownload('${doc[7]}');">
<span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

</c:if>
		

<c:if test="${doc[8] != 'null'}">

<td  style="border: 1px solid lightgray; padding: 8px; text-align: left"><span class="ClsLabel" style="font-size: 14px"><fmt:message
            key="Structual audit of Hospital/Nursing home building. (रुग्णालय/ नर्सिंग होम इमारतीचे स्ट्रक्चरल ऑडिट.)" />:</span>
            
</td>
<td style="border: 1px solid lightgray; padding: 8px; text-align: left"><a class="bg-button btn btn-primary bd-highlight action"
type="button"
target="_blank"
onclick="docDownload('${doc[8]}');">
<span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

</c:if>

		</tr>
		<tr> <c:if test="${doc[9] != 'null'}">

<td style="border: 1px solid lightgray; padding: 8px; text-align: left"><span class="ClsLabel" style="font-size: 14px"><fmt:message
            key="Electrical audit of Hospital/Nursing home building. (हॉस्पिटल / नर्सिंग होम इमारतीचे इलेक्ट्रिकल ऑडिट.)" />:</span>
            

</td>
<td style="border: 1px solid lightgray; padding: 8px; text-align: left">
            <a class="bg-button btn btn-primary bd-highlight action"
type="button"
target="_blank"
onclick="docDownload('${doc[9]}');">
<span class="download" style="align-items: center;color:white;">Download</span>
</a>
</td>

</c:if>
<c:if test="${doc[10] != 'null'}">

<td style="border: 1px solid lightgray; padding: 8px; text-align: left"><span class="ClsLabel" style="font-size: 14px"><fmt:message
            key="Property tax receipt of place where Hospital/Nursing home is situated. (ज्या ठिकाणी हॉस्पिटल/ नर्सिंग होम आहे त्या ठिकाणची मालमत्ता कर पावती)" />:</span>
            
           
</td>
<td style="border: 1px solid lightgray; padding: 8px; text-align: left">  <a class="bg-button btn btn-primary bd-highlight action"
type="button"
target="_blank"
onclick="docDownload('${doc[10]}');">
<span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

</c:if></tr>
		 
		<tr> 
		<c:if test="${doc[11] != 'null'}">

<td style="border: 1px solid lightgray; padding: 8px; text-align: left"><span class="ClsLabel" style="font-size: 14px"><fmt:message
            key="Bio Medical waste registration receipt from authorized agency. (अधिकृत एजन्सीकडून जैव वैद्यकीय कचरा नोंदणीची पावती.)" />:</span>
           
</td>
<td style="border: 1px solid lightgray; padding: 8px; text-align: left">  <a class="bg-button btn btn-primary bd-highlight action"
type="button"
target="_blank"
onclick="docDownload('${doc[11]}');">
<span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

</c:if>
<c:if test="${doc[12] != 'null'}">

<td style="border: 1px solid lightgray; padding: 8px; text-align: left"><span class="ClsLabel" style="font-size: 14px"><fmt:message
            key="Documents of educational qualification of Consultant/Duty Medical Officers as per sr. no. 11 mentioned in application. (sr नुसार सल्लागार/ड्युटी वैद्यकीय अधिकाऱ्यांच्या शैक्षणिक पात्रतेची कागदपत्रे. नाही अर्जात 11 चा उल्लेख आहे.)" />:</span>

</td>
<td style="border: 1px solid lightgray; padding: 8px; text-align: left"><a class="bg-button btn btn-primary bd-highlight action"
type="button"
target="_blank"
onclick="docDownload('${doc[12]}');">
<span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

</c:if>
 
</tr>
<tr>
<c:if test="${doc[13] != 'null'}">

<td style="border: 1px solid lightgray; padding: 8px; text-align: left"><span class="ClsLabel" style="font-size: 14px"><fmt:message
            key="Nursing Council Registration Certificate of all nursing staff BSC Nursing/GNM/ANM. (सर्व नर्सिंग स्टाफचे नर्सिंग कौन्सिल नोंदणी प्रमाणपत्र BSC नर्सिंग/GNM/ANM.)" />:</span>

</td>
<td style="border: 1px solid lightgray; padding: 8px; text-align: left"><a class="bg-button btn btn-primary bd-highlight action"
type="button"
target="_blank"
onclick="docDownload('${doc[13]}');">
<span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

</c:if>
<c:if test="${doc[14] != 'null'}">

<td style="border: 1px solid lightgray; padding: 8px; text-align: left"><span class="ClsLabel" style="font-size: 14px"><fmt:message
            key="Documents of ownership or tenancy related to Hospital/Nursing home building.(हॉस्पिटल/नर्सिंग होम इमारतीशी संबंधित मालकी किंवा भाडेकराराची कागदपत्रे.)" />:</span>
</td>
<td style="border: 1px solid lightgray; padding: 8px; text-align: left"><a class="bg-button btn btn-primary bd-highlight action"
type="button"
target="_blank"
onclick="docDownload('${doc[14]}');">
<span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

</c:if>

</tr>
<tr>
<c:if test="${doc[15] != 'null'}">

<td style="border: 1px solid lightgray; padding: 8px; text-align: left"><span class="ClsLabel" style="font-size: 14px"><fmt:message
            key="List of major medical, surgical & diagnostic equipments & machinaries.(प्रमुख वैद्यकीय, शस्त्रक्रिया आणि निदान उपकरणे आणि यंत्रसामग्रीची यादी.)" />:</span>
</td>
<td style="border: 1px solid lightgray; padding: 8px; text-align: left"><a class="bg-button btn btn-primary bd-highlight action"
type="button"
target="_blank"
onclick="docDownload('${doc[15]}');">
<span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

</c:if>
<c:if test="${doc[16] != 'null'}">

<td style="border: 1px solid lightgray; padding: 8px; text-align: left"><span class="ClsLabel" style="font-size: 14px"><fmt:message
            key="Nursing home having hundred or more than hundred beds have provision of dedicated pressure Swing Absorption(PSA) of Vaccum Swing Absorption (VSA) technology oxygen supply plant.(शंभर किंवा शंभरहून अधिक बेड असलेल्या नर्सिंग होममध्ये व्हॅक्यूम स्विंग ऍब्सॉप्शन (VSA) तंत्रज्ञान ऑक्सिजन पुरवठा संयंत्राच्या समर्पित प्रेशर स्विंग ऍब्सॉप्टिन (PSA) ची तरतूद आहे.)" />:</span>
</td>
<td style="border: 1px solid lightgray; padding: 8px; text-align: left"><a class="bg-button btn btn-primary bd-highlight action"
type="button"
target="_blank"
onclick="docDownload('${doc[16]}');">
<span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

</c:if>
</tr>
<tr>
<c:if test="${doc[16] != 'null'}">

<td style="border: 1px solid lightgray; padding: 8px; text-align: left"><span class="ClsLabel" style="font-size: 14px"><fmt:message
            key="Concert to establishment from Maharashtra polution Control Board.(महाराष्ट्र प्रदूषण नियंत्रण मंडळाकडून स्थापनेची मैफल.)" />:</span>

</td>
<td style="border: 1px solid lightgray; padding: 8px; text-align: left"><a class="bg-button btn btn-primary bd-highlight action"
type="button"
target="_blank"
onclick="docDownload('${doc[16]}');">
<span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

</c:if>

<c:if test="${doc[17] != 'null'}">

<td style="border: 1px solid lightgray; padding: 8px; text-align: left"><span class="ClsLabel" style="font-size: 14px"><fmt:message
            key="Affidavit (प्रतिज्ञापत्र)" />:</span>

</td>
<td style="border: 1px solid lightgray; padding: 8px; text-align: left"><a class="bg-button btn btn-primary bd-highlight action"
type="button"
target="_blank"
onclick="docDownload('${doc[17]}');">
<span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

</c:if>
</tr>
		

		 

		
		 
			
			

            

           
































		 	<table colspan="" border="0" cellpadding="2" cellspacing="2"
				id="table1" class="">
				<tr>
				
    
    <c:choose>
                <c:when test="${empty nursingHomes.mhoRemark and requestScope.forLogin eq 'L3' and not empty nursingHomes.hqdoc}">
        <td>
        <span class="ClsLabel" style="font-size: 14px; width: 400px;"><fmt:message key="Remark for Approval HQ Report  (मंजुरीसाठी टीप HQ अहवाल)" />:</span>
    </td>
            <td style="text-align: center;">
            <textarea class="form-control" style="width: 310px;margin-left: 182px;"
					id="approvalRemark" maxlength="200" name="approvalRemark" rows="2">${nursingHomes.mhoRemark}</textarea></td>
            
               
        </c:when>
        <c:when test="${not empty nursingHomes.mhoRemark}">
        <td>
        <span class="ClsLabel" style="font-size: 14px; width: 400px;"><fmt:message key="Remark for Approval HQ Report  (मंजुरीसाठी टीप HQ अहवाल)" />:</span>
    </td>
            <td style="text-align: center;">
               <textarea class="form-control" style="width: 310px;margin-left: 182px;"
					id="approvalRemark" maxlength="200" name="approvalRemark" rows="2" readonly>${nursingHomes.mhoRemark}</textarea></td>
            
        </c:when>
        <c:otherwise>
        </c:otherwise>
    </c:choose>
</tr>



<c:if test="${requestScope.rtiApplication.workFlowStatus!=5}">
<tr>
				
    
    <c:choose>
                <c:when test="${empty nursingHomes.hQRemark and requestScope.forLogin eq 'L3' and not empty nursingHomes.hqdoc and not empty nursingHomes.zmodoc}">
        <td>
        <span class="ClsLabel" style="font-size: 14px; width: 400px;"><fmt:message key="Remark for Approval ZMO Report (मंजुरीसाठी टीप ZMO अहवाल)" />:</span>
    </td>
            <td style="text-align: center;">1
            <textarea class="form-control" style="width: 310px;margin-left: 182px;"
					id="approvalRemark1" maxlength="200" name="approvalRemark1" rows="2">${nursingHomes.hQRemark}</textarea></td>
            
               
        </c:when>
        <c:when test="${not empty nursingHomes.hQRemark}">
        <td>
        <span class="ClsLabel" style="font-size: 14px; width: 400px;"><fmt:message key="Remark for Approval ZMO Report (मंजुरीसाठी टीप ZMO अहवाल)" />:</span>
    </td>
            <td style="text-align: center;">
               <textarea class="form-control" style="width: 310px;margin-left: 182px;"
					id="approvalRemark1" maxlength="200" name="approvalRemark1" rows="2" readonly>${nursingHomes.hQRemark}</textarea></td>
            
        </c:when>
        <c:otherwise>
        </c:otherwise>
    </c:choose>
</tr>




			<tr>
			<td colspan="10" style="background-color: white;background-color: #c5ddfe;"><span class="ClsLabel"
				style="
    height: 27px;
    padding: 7px 10px 11px;
       font-size: 17px;color:#01293d;font-style: italic;"><fmt:message
						key="Reports (अहवाल)" />:</span></td>
			</tr>
			<tr>
				<td colspan="3.5"><span class="ClsLabel"
					style="font-size: 14px;"><fmt:message
							key="HQ Report (
HQ अहवाल)" />:</span> 
				<td style="text-align: center" colspan="3.5">
					<input type="file" class="imagefile" name="idProof" id="hquploadfile" style="width: 220px" />
			</td>
                   <td>   
                      <c:if test="${ empty nursingHomes.hqdoc}">   
               
                <a class="bg-button btn btn-primary bd-highlight" style="color:white" id="hqupload" type="button" target="_blank" onclick="javascript:hqUpload(this);"><span
							class="download" style="align-items: center">Upload</span></a>
               
                </c:if>
              <c:if test="${ not empty nursingHomes.hqdoc}">
              
             
							<a class="bg-button btn btn-success bd-highlight action"
type="button"
target="_blank"
onclick="docDownload('${nursingHomes.hqdoc}');">
<span class="download" style="align-items: center;color:white;">Download</span>
</a>
               </c:if>
</td>


			</tr>
			
			
			<tr>
				<td colspan="3.5"><span class="ClsLabel"
					style="font-size: 14px"><fmt:message
							key="ZMO Report (
ZMO अहवाल)" />:</span> 
				<td style="text-align: center" colspan="3.5">
					<input type="file" class="imagefile" name="idProof" id="zmouploadfile" style="width: 220px" />
			</td>
                   <td>   
                      <c:if test="${ empty nursingHomes.zmodoc}">   
               
                <a class="bg-button btn btn-primary bd-highlight" style="color:white" id="zmoupload" type="button" target="_blank" onclick="javascript:zmoUpload(this);"><span
							class="download" style="align-items: center">Upload</span></a>
               
                </c:if>
              <c:if test="${ not empty nursingHomes.zmodoc}">
       
              
              				<a class="bg-button btn btn-success bd-highlight action"
type="button"
target="_blank"
onclick="docDownload('${nursingHomes.zmodoc}');">
<span class="download" style="align-items: center;color:white;">Download</span>
</a>
               </c:if>
</td>


			</tr>
		
			<c:if test="${requestScope.forLogin eq 'L3'}"		>

	<tr>
    <td colspan="4" align="center">
        <input type="button"
               class="btn btn-primary"
               style="min-height: 30px; min-width: 80px; color: white; border: none; outline: #28a745;margin-left:50px;"
               id="savefees" name="savefees"
               value="<fmt:message key="Save"/>"
               onclick="javascript:saveFees(this.form);"
              >
    </td>
</tr>
</c:if>
		</c:if>
			</table>
</table>
		
		</div>
		
      </table>
   </div>

<input type="hidden" class="ClsTextbox" id="nursinghomesregId"
	style="width: 180px" name="nursinghomesregId"
	value="<c:out value="${nursingHomes.nursinghomesregId}"/>" />
<input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId"
	value="" />
<input type="hidden" id="rtiApplicationRefIds"
	name="rtiApplicationRefIds" value="${nursingHomes.rtiRefId}" />
	<input type="hidden" id="responseData" name="responseData"
								value="" />
<%@include file="/pages/workflow/taskInclude.jsp"%>

<script type="text/javascript">
function saveEntity()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/createNursingHome.do');
}


function saveFees() {
    var approvalRemark = $('#approvalRemark').val();
    var approvalRemark1 = $('#approvalRemark1').val();
	var mhoRemark='${nursingHomes.mhoRemark}';
    if (approvalRemark !== '') {
 
	    if(mhoRemark!==""){
	    	if(approvalRemark1 === ''){
	    	
	    		alert("Please enter remarks!!.");
	            return false;
	    	}
	    }
      if (confirm('Are you sure you want to save?')) {

        onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveMhoRemark.do');
        } else {
            return false;
        }
    } else {
        alert("Please enter remarks!!.");
        return false;
    }
}

</script>

    
    	<script type="text/javascript">
    function hqUpload() {
        console.log("@@upoading@@");

        var data = new FormData();
        var idProofFile = $("#hquploadfile").get(0).files[0];
        if (!idProofFile) {
            alert("Please upload the Report.");
            return;
        }
        var fileName = idProofFile.name;
        var fileExtension = fileName.split('.').pop().toLowerCase();

        if (fileExtension !== 'pdf') {
            alert("Please select a valid PDF file.");
            return;
        }
        data.append('idProof1', $("#hquploadfile").get(0).files[0]);

        var appType = 2;
        var uid1 = document.getElementById('nursinghomesregId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadnursingdoc.do?appType=" + appType + "&UID=" + uid1,
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false,
            contentType: false,
            async: false,
            success: function(data, textStatus, jqXHR) {
                var status = data.status;
                if (status === true) {
                    alert("Upload has been done successfully!");
                    window.location.reload();
                } else {
                    alert("Upload has been failed!");
                }
            }
        });
    }
</script>
<script type="text/javascript">
    function zmoUpload() {
        console.log("@@upoading@@");
        var data = new FormData();
        var idProofFile = $("#zmouploadfile").get(0).files[0];
        if (!idProofFile) {
            alert("Please upload the Report.");
            return;
        }
        var fileName = idProofFile.name;
        var fileExtension = fileName.split('.').pop().toLowerCase();
        if (fileExtension !== 'pdf') {
            alert("Please select a PDF file.");
            return;
        }
        data.append('idProof1', $("#zmouploadfile").get(0).files[0]);
        var appType = 3;
        var uid1 = document.getElementById('nursinghomesregId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadnursingdoc.do?appType=" + appType + "&UID=" + uid1,
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false,
            contentType: false,
            async: false,
            success: function(data, textStatus, jqXHR) {
                var status = data.status;
                if (status === true) {
                    alert("Upload has been done successfully!");
                    window.location.reload();
                } else {
                    alert("Upload has been failed!");
                }
            }
        });
    }

    
    $(document).ready(function() {
    	var hqdoc = '${nursingHomes.hqdoc}';
    	var zmodoc = '${nursingHomes.zmodoc}';
    	var mhoRemark='${nursingHomes.mhoRemark}';
    	var hQRemark='${nursingHomes.hQRemark}';
    	var userId = <%= request.getAttribute("userId") %>;
    	var executeSecondIf = true; // Initialize the variable
    	var forLogin = '${requestScope.forLogin}';
	    var workflowStatus="${requestScope.rtiApplication.workFlowStatus}";


	    if(workflowStatus!=='5'){
    	if(mhoRemark!=='' && hQRemark!==''){
    		$('#savefees').hide();

    	}else{
    		$('#approvalRemark').prop('disabled',false);
    		$('#approvalRemark1').prop('disabled',false);
    	    if((hqdoc!=="" && mhoRemark==="") || (zmodoc!=="" && hQRemark==="")) {
    		$('#savefees').prop('disabled',false);
    		}else{
    			$('#savefees').hide();
    		}

    	}
    	if (hqdoc && hqdoc.trim() !== "" && mhoRemark!=='') {
    	    $("#hquploadfile").prop('disabled', true);
    	} else if(forLogin==='L1'  && mhoRemark!==''){
    	    $("#hquploadfile").prop('disabled', false);
    	}else{
    	    $("#hquploadfile").prop('disabled', true);

    	
    	}

    	if (zmodoc && zmodoc.trim() !== "" && mhoRemark!=='') {
    	    $("#zmouploadfile").prop('disabled', true);
    	} else if(forLogin==='L2' && (hqdoc &&hqdoc.trim() !== "" && mhoRemark !=='')){
    	    $("#zmouploadfile").prop('disabled', false);
    	}else{
    	    $("#zmouploadfile").prop('disabled', true);

    	}

        if((hqdoc!=="" || hQRemark==="") && forLogin==='L3'){
    	    var elements = document.getElementsByClassName("tab")[0];

    	    if((hqdoc!=="" && mhoRemark==="") || (zmodoc!=="" && hQRemark==="")) {
    	    	 elements.innerHTML = "You don't have permission to send demand, but you can reject the application.".fontcolor("red");
    	    	    $('#commentsDisable *').attr('disabled', false);
    	    	    $('#CreateWorkflow').attr('disabled', true);
    	    	    $('#RejectCreateWorkflow').attr('disabled', false);
    	    	    $('#WORKFLOW_COMMENTS').attr('disabled', false);
    	    	    $('#genCerBtn').hide();
    	    	    $('#dsc').hide();
    	    	    $('#commentsDisable *').addClass("not-active");
    	    	    $('#descriptionDisabled *').attr('disabled', true);
    	    	    $('#descriptionDisabled *').addClass("not-active");
    	    	    $('#uuid').removeAttr('disabled');
    	    	    $('.mainHdr a').attr("onclick", "javascript:void(0)");

    	    	    <c:forEach var="taskTransitionName" items="${WORKFLOW_TRANSISTIONS}" varStatus="iCount">
    	    	        document.getElementById('workflow_tras_${taskTransitionName}').setAttribute("onclick", "javascript:void(0);");
    	    	        document.getElementById('workflow_tras_${taskTransitionName}').removeAttribute("style");
    	    	    </c:forEach>

    	    	    document.getElementById('KillWorkflow').setAttribute("onclick", "javascript:void(0);");
    	    	    document.getElementById('KillWorkflow').removeAttribute("style");
    	    	    $('#savefees').hide();
    	    }
    	   
    	}


        if (forLogin == 'L4' && (hqdoc==='' || zmodoc==='') ) {
            $("#hquploadfile").prop('disabled', true);
            if(mhoRemark!=='' && hqdoc &&hqdoc.trim() !== ""){
            $("#zmouploadfile").prop('disabled', false);
            }
            $("#hqupload").prop('disabled', true);
            $("#zmoupload").prop('disabled', false);
            $("#hqupload").attr('disabled', true);
            var elements = document.getElementsByClassName("tab")[0];
            if(hqdoc!=='' && mhoRemark!==""){
    			elements.innerHTML = "Please upload ZMO report".fontcolor("green");

            }else{
    			elements.innerHTML = "You don't have Permission".fontcolor("red");

            }
	    	$('#commentsDisable *').attr('disabled', true);
	    	$('#CreateWorkflow').attr('disabled', true);
	    	$('#RejectCreateWorkflow').attr('disabled', true);
	    	$('#WORKFLOW_COMMENTS').attr('disabled', true);

			$('#genCerBtn').hide();
			$('#dsc').hide();
			$('#commentsDisable *').addClass("not-active");
			$('#descriptionDisabled *').attr('disabled', true);
			$('#descriptionDisabled *').addClass("not-active");
			$('#uuid').removeAttr('disabled');
			//$('#SetFormHeight a').attr("onclick","javascript:void(0)");
			$('.mainHdr a').attr("onclick","javascript:void(0)");
			<c:forEach var="taskTransitionName" items="${WORKFLOW_TRANSISTIONS}" varStatus="iCount">
				document.getElementById('workflow_tras_${taskTransitionName}').setAttribute("onclick","javascript:void(0);");
				document.getElementById('workflow_tras_${taskTransitionName}').removeAttribute("style");
			</c:forEach>
			//Disable the Discard Workflow icon also if the task is not owned
			document.getElementById('KillWorkflow').setAttribute("onclick","javascript:void(0);");
			document.getElementById('KillWorkflow').removeAttribute("style");
			$('#savefees').hide();


        } else if (forLogin == 'L1' && (hqdoc==='' || zmodoc==='')) {
        	 //if(mhoRemark!==''){
                 $("#hquploadfile").prop('disabled', false);
                 //}
            $("#zmouploadfile").prop('disabled', true);
            $("#hqupload").prop('disabled', false);
            $("#zmoupload").prop('disabled', true);
            $("#zmoupload").attr('disabled', true);
            var elements = document.getElementsByClassName("tab")[0];
     	   
            if(hqdoc!=="" && hQRemark!==""){
            	 elements.innerHTML = "Currently, you don't have permission to send demand.".fontcolor("red");
           	    $('#commentsDisable *').attr('disabled', true);
           	    $('#CreateWorkflow').attr('disabled', true);
           	    $('#RejectCreateWorkflow').attr('disabled', true);
           	    $('#WORKFLOW_COMMENTS').attr('disabled', true);
            }else  if((hqdoc===''|| zmodoc==='') && hQRemark!=='' ){
            	    elements.innerHTML = "Currently, you don't have permission to send demand, but you can reject the application.".fontcolor("red");
              	    $('#commentsDisable *').attr('disabled', false);
              	    $('#CreateWorkflow').attr('disabled', true);
              	    $('#RejectCreateWorkflow').attr('disabled', false);
              	    $('#WORKFLOW_COMMENTS').attr('disabled', false);
            }else if((hqdoc===''|| zmodoc!=='')){
            	 elements.innerHTML = "Currently, you don't have permission to send demand, but you can reject the application.".fontcolor("red");
           	    $('#commentsDisable *').attr('disabled', false);
           	    $('#CreateWorkflow').attr('disabled', true);
           	    $('#RejectCreateWorkflow').attr('disabled', false);
           	    $('#WORKFLOW_COMMENTS').attr('disabled', false);
            }else{
            	elements.innerHTML = "Currently, you don't have permission to send demand.".fontcolor("red");
           	    $('#commentsDisable *').attr('disabled', true);
           	    $('#CreateWorkflow').attr('disabled', true);
           	    $('#RejectCreateWorkflow').attr('disabled', true);
           	    $('#WORKFLOW_COMMENTS').attr('disabled', true);
            }
     	    $('#genCerBtn').hide();
     	    $('#dsc').hide();
     	    $('#commentsDisable *').addClass("not-active");
     	    $('#descriptionDisabled *').attr('disabled', true);
     	    $('#descriptionDisabled *').addClass("not-active");
     	    $('#uuid').removeAttr('disabled');
     	    $('.mainHdr a').attr("onclick", "javascript:void(0)");

     	    <c:forEach var="taskTransitionName" items="${WORKFLOW_TRANSISTIONS}" varStatus="iCount">
     	        document.getElementById('workflow_tras_${taskTransitionName}').setAttribute("onclick", "javascript:void(0);");
     	        document.getElementById('workflow_tras_${taskTransitionName}').removeAttribute("style");
     	    </c:forEach>

     	    document.getElementById('KillWorkflow').setAttribute("onclick", "javascript:void(0);");
     	    document.getElementById('KillWorkflow').removeAttribute("style");

        } 
        
        
       
      	
      	if ((forLogin==='L3') && workflowStatus!=='1') {
      		var elements = document.getElementsByClassName("tab")[0];
			elements.innerHTML = "You don't have Permission".fontcolor("red");
  		    $('#commentsDisable *').attr('disabled', true);
  		    $('#CreateWorkflow').attr('disabled', true);
  		    $('#RejectCreateWorkflow').attr('disabled', true);
  		    $('#WORKFLOW_COMMENTS').attr('disabled', true);
  		    $('#mHORemark').attr('readonly',true);
			$('#genCerBtn').hide();
			$('#dsc').hide();
			$('#commentsDisable *').addClass("not-active");
			$('#descriptionDisabled *').attr('disabled', true);
			$('#descriptionDisabled *').addClass("not-active");
			//$('#SetFormHeight a').attr("onclick","javascript:void(0)");
			$('.mainHdr a').attr("onclick","javascript:void(0)");
			<c:forEach var="taskTransitionName" items="${WORKFLOW_TRANSISTIONS}" varStatus="iCount">
				document.getElementById('workflow_tras_${taskTransitionName}').setAttribute("onclick","javascript:void(0);");
				document.getElementById('workflow_tras_${taskTransitionName}').removeAttribute("style");
			</c:forEach>
			//Disable the Discard Workflow icon also if the task is not owned
			document.getElementById('KillWorkflow').setAttribute("onclick","javascript:void(0);");
			document.getElementById('KillWorkflow').removeAttribute("style");
			$('#savefees').hide();

      		
      	}
      	
      	if(forLogin==='L1' && hQRemark===""){
      		var elements = document.getElementsByClassName("tab")[0];
        	elements.innerHTML = "Currently, you don't have permission to send demand.".fontcolor("red");
  		    $('#commentsDisable *').attr('disabled', true);
  		    $('#CreateWorkflow').attr('disabled', true);
  		    $('#RejectCreateWorkflow').attr('disabled', true);
  		    $('#WORKFLOW_COMMENTS').attr('disabled', true);
  		    $('#mHORemark').attr('readonly',true);

  		  $('#genCerBtn').hide();
			$('#dsc').hide();
			$('#commentsDisable *').addClass("not-active");
			$('#descriptionDisabled *').attr('disabled', true);
			$('#descriptionDisabled *').addClass("not-active");
			//$('#SetFormHeight a').attr("onclick","javascript:void(0)");
			$('.mainHdr a').attr("onclick","javascript:void(0)");
			<c:forEach var="taskTransitionName" items="${WORKFLOW_TRANSISTIONS}" varStatus="iCount">
				document.getElementById('workflow_tras_${taskTransitionName}').setAttribute("onclick","javascript:void(0);");
				document.getElementById('workflow_tras_${taskTransitionName}').removeAttribute("style");
			</c:forEach>
			//Disable the Discard Workflow icon also if the task is not owned
			document.getElementById('KillWorkflow').setAttribute("onclick","javascript:void(0);");
			document.getElementById('KillWorkflow').removeAttribute("style");
      	}

        if(hqdoc!=="" && hQRemark!=="" && forLogin==='L3' && workflowStatus!=='1' ){
        	var elements = document.getElementsByClassName("tab")[0];
			elements.innerHTML = "You don't have Permission".fontcolor("red");
  		    $('#commentsDisable *').attr('disabled', true);
  		    $('#CreateWorkflow').attr('disabled', true);
  		    $('#RejectCreateWorkflow').attr('disabled', true);
  		    $('#WORKFLOW_COMMENTS').attr('disabled', true);
  		    $('#mHORemark').attr('readonly',true);
  		  $('#genCerBtn').hide();
			$('#dsc').hide();
			$('#commentsDisable *').addClass("not-active");
			$('#descriptionDisabled *').attr('disabled', true);
			$('#descriptionDisabled *').addClass("not-active");
			//$('#SetFormHeight a').attr("onclick","javascript:void(0)");
			$('.mainHdr a').attr("onclick","javascript:void(0)");
			<c:forEach var="taskTransitionName" items="${WORKFLOW_TRANSISTIONS}" varStatus="iCount">
				document.getElementById('workflow_tras_${taskTransitionName}').setAttribute("onclick","javascript:void(0);");
				document.getElementById('workflow_tras_${taskTransitionName}').removeAttribute("style");
			</c:forEach>
			//Disable the Discard Workflow icon also if the task is not owned
			document.getElementById('KillWorkflow').setAttribute("onclick","javascript:void(0);");
			document.getElementById('KillWorkflow').removeAttribute("style");
        }
        
        if(hqdoc!=="" && zmodoc!=="" && forLogin==='L4' && workflowStatus!=='1' ){
        	var elements = document.getElementsByClassName("tab")[0];
			elements.innerHTML = "You don't have Permission".fontcolor("red");
  		    $('#commentsDisable *').attr('disabled', true);
  		    $('#CreateWorkflow').attr('disabled', true);
  		    $('#RejectCreateWorkflow').attr('disabled', true);
  		    $('#WORKFLOW_COMMENTS').attr('disabled', true);
  		    $('#mHORemark').attr('readonly',true);
  		  $('#genCerBtn').hide();
			$('#dsc').hide();
			$('#commentsDisable *').addClass("not-active");
			$('#descriptionDisabled *').attr('disabled', true);
			$('#descriptionDisabled *').addClass("not-active");
			//$('#SetFormHeight a').attr("onclick","javascript:void(0)");
			$('.mainHdr a').attr("onclick","javascript:void(0)");
			<c:forEach var="taskTransitionName" items="${WORKFLOW_TRANSISTIONS}" varStatus="iCount">
				document.getElementById('workflow_tras_${taskTransitionName}').setAttribute("onclick","javascript:void(0);");
				document.getElementById('workflow_tras_${taskTransitionName}').removeAttribute("style");
			</c:forEach>
			//Disable the Discard Workflow icon also if the task is not owned
			document.getElementById('KillWorkflow').setAttribute("onclick","javascript:void(0);");
			document.getElementById('KillWorkflow').removeAttribute("style");
        }
        
	    }else{
	    	 var elements = document.getElementsByClassName("tab")[0];
			    elements.innerHTML = "Application has been Rejected".fontcolor("red");
			    $('#commentsDisable *').attr('disabled', true);
		       $('#CreateWorkflow').attr('disabled', true);
		       $('#CreateWorkflow').attr('disabled', true);
		       $('#RejectCreateWorkflow').attr('disabled', true);
		       $('#WORKFLOW_COMMENTS').attr('disabled', true);
	    }
    });

 	function docDownload(filesPath) {
 	    var encodedFilePath = encodeURIComponent(filesPath);

 	    var encodedFilesPath = btoa(encodedFilePath); 

 	    window.open('<c:out value="${contextRoot}"/>/rtsApplication/getPdf.do?fp=' + encodedFilesPath, '_blank');
 	}
    
</script>


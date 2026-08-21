<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mars.common.utils.CommonUtils"%>
<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="com.mars.common.utils.SessionUser"%>
<%@ page import="com.mars.common.model.User"%>
<jsp:directive.include file="/pages/common/include.jsp" />

<%
pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("DATE_TIME_DB_FORMAT", Constants.DATE_TIME_DB_FORMAT);

pageContext.setAttribute("DATE_TIME_FORMAT", WorkflowConstants.WORKFLOW_DATE_FORMAT);
//birth
pageContext.setAttribute("LABEL_HOSPITAL_NAME_YASH", CoreConstants.LABEL_HOSPITAL_NAME_YASH);
pageContext.setAttribute("LABEL_HOSPITAL_NAME_MEDI", CoreConstants.LABEL_HOSPITAL_NAME_MEDI);

pageContext.setAttribute("HOSPITAL_NAME_YASH", CoreConstants.HOSPITAL_NAME_YASH);
pageContext.setAttribute("HOSPITAL_NAME_MEDI", CoreConstants.HOSPITAL_NAME_MEDI);

pageContext.setAttribute("LABEL_CHILD_GENDER_MALE", CoreConstants.LABEL_CHILD_GENDER_MALE);
pageContext.setAttribute("LABEL_CHILD_GENDER_FEMALE", CoreConstants.LABEL_CHILD_GENDER_FEMALE);
pageContext.setAttribute("LABEL_CHILD_GENDER_TRANSGENDER", CoreConstants.LABEL_CHILD_GENDER_TRANSGENDER);

pageContext.setAttribute("CHILD_GENDER_MALE", CoreConstants.CHILD_GENDER_MALE);
pageContext.setAttribute("CHILD_GENDER_FEMALE", CoreConstants.CHILD_GENDER_FEMALE);
pageContext.setAttribute("CHILD_GENDER_TRANSGENDER", CoreConstants.CHILD_GENDER_TRANSGENDER);

pageContext.setAttribute("LABEL_ZONE_NUMBER_HARS", CoreConstants.LABEL_ZONE_NUMBER_HARS);
pageContext.setAttribute("LABEL_ZONE_NUMBER_EKTA", CoreConstants.LABEL_ZONE_NUMBER_EKTA);

pageContext.setAttribute("ZONE_NUMBER_HARS", CoreConstants.ZONE_NUMBER_HARS);
pageContext.setAttribute("ZONE_NUMBER_EKTA", CoreConstants.ZONE_NUMBER_EKTA);

pageContext.setAttribute("STATUS_YES_LABEL", CoreConstants.STATUS_YES_LABEL);
pageContext.setAttribute("STATUS_NO_LABEL", CoreConstants.STATUS_NO_LABEL);

pageContext.setAttribute("STATUS_YES", CoreConstants.STATUS_YES);
pageContext.setAttribute("STATUS_NO", CoreConstants.STATUS_NO);

pageContext.setAttribute("LABEL_BLOOD_GROUP_ONE", CoreConstants.LABEL_BLOOD_GROUP_ONE);
pageContext.setAttribute("LABEL_BLOOD_GROUP_TWO", CoreConstants.LABEL_BLOOD_GROUP_TWO);
pageContext.setAttribute("LABEL_BLOOD_GROUP_THREE", CoreConstants.LABEL_BLOOD_GROUP_THREE);
pageContext.setAttribute("LABEL_BLOOD_GROUP_FOUR", CoreConstants.LABEL_BLOOD_GROUP_FOUR);
pageContext.setAttribute("LABEL_BLOOD_GROUP_FIVE", CoreConstants.LABEL_BLOOD_GROUP_FIVE);
pageContext.setAttribute("LABEL_BLOOD_GROUP_SIX", CoreConstants.LABEL_BLOOD_GROUP_SIX);
pageContext.setAttribute("LABEL_BLOOD_GROUP_SEVEN", CoreConstants.LABEL_BLOOD_GROUP_SEVEN);
pageContext.setAttribute("LABEL_BLOOD_GROUP_EIGHT", CoreConstants.LABEL_BLOOD_GROUP_EIGHT);

pageContext.setAttribute("BLOOD_GROUP_ONE", CoreConstants.BLOOD_GROUP_ONE);
pageContext.setAttribute("BLOOD_GROUP_TWO", CoreConstants.BLOOD_GROUP_TWO);
pageContext.setAttribute("BLOOD_GROUP_THREE", CoreConstants.BLOOD_GROUP_THREE);
pageContext.setAttribute("BLOOD_GROUP_FOUR", CoreConstants.BLOOD_GROUP_FOUR);
pageContext.setAttribute("BLOOD_GROUP_FIVE", CoreConstants.BLOOD_GROUP_FIVE);
pageContext.setAttribute("BLOOD_GROUP_SIX", CoreConstants.BLOOD_GROUP_SIX);
pageContext.setAttribute("BLOOD_GROUP_SEVEN", CoreConstants.BLOOD_GROUP_SEVEN);
pageContext.setAttribute("BLOOD_GROUP_EIGHT", CoreConstants.BLOOD_GROUP_EIGHT);

pageContext.setAttribute("LABEL_RADIO_HOME", CoreConstants.LABEL_RADIO_HOME);
pageContext.setAttribute("LABEL_RADIO_HOSPITAL", CoreConstants.LABEL_RADIO_HOSPITAL);

pageContext.setAttribute("RADIO_HOME", CoreConstants.RADIO_HOME);
pageContext.setAttribute("RADIO_HOSPITAL", CoreConstants.RADIO_HOSPITAL);

pageContext.setAttribute("BLOOD_RELATION_ONE", CoreConstants.BLOOD_RELATION_ONE);
pageContext.setAttribute("BLOOD_RELATION_TWO", CoreConstants.BLOOD_RELATION_TWO);

pageContext.setAttribute("LABEL_BLOOD_RELATION_ONE", CoreConstants.LABEL_BLOOD_RELATION_ONE);
pageContext.setAttribute("LABEL_BLOOD_RELATION_TWO", CoreConstants.LABEL_BLOOD_RELATION_TWO);

pageContext.setAttribute("LABEL_RADIO_SAME_DAY", CoreConstants.LABEL_RADIO_SAME_DAY);
pageContext.setAttribute("LABEL_RADIO_TILL_THIRD_DAY", CoreConstants.LABEL_RADIO_TILL_THIRD_DAY);

pageContext.setAttribute("RADIO_SAME_DAY", CoreConstants.LABEL_RADIO_HOME);
pageContext.setAttribute("RADIO_TILL_THIRD_DAY", CoreConstants.RADIO_TILL_THIRD_DAY);

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
</style>


<div class="mainHdr">
	<h3 style="
    height: 30px;
        font-size: 15px;color:#01293d">

		<fmt:message key="Property Objection Registration" />
		:
		<c:if test="${requestScope.rtiApplication != null}">
			<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
		</c:if>

	</h3>
</div>
<div valign="top" id="SetFormHeight">
	<input type="hidden" name="id"
		value="${propertyTaxAssessment.propertyComplaintRegistrationID}">
	<c:set var="doc"
		value="${fn:split(rtiApplication.pdfUploadFromPortal, ',')}" />
	<table width="100%" border="0" cellpadding="2" cellspacing="2">
		<tr>
		<tr>

			

<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="tax.label.applicantName" />:</span></td>
			<td colspan="2">

					<input type="text" class="form-control" style="width: 200px"
						id="applicantLastName" maxlength="50" name="applicantLastName"
						value="<c:out value="${propertyTaxAssessment.fullName}"/>" disabled/>
			

			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="tax.label.applicantMobileNo" />:</span></td>
			<td colspan="2">
					<input type="text" class="form-control" style="width: 200px"
						id="ph_no" maxlength="50" name="ph_no"
						value="<c:out value="${propertyTaxAssessment.mobileNo}"/>" disabled/>
				</td>
</tr><tr>
			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="tax.label.appllicantEmaailId" /></span><span class="ClsRequiredFields"></span></td>
			<td colspan="2">
					<input type="text" class="form-control" id="email"
						style="width: 280px" name="email"
						value="<c:out value="${propertyTaxAssessment.emailId}"/>" disabled/>
				</td>
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Address(पत्ता)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control" style="width: 280px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${propertyTaxAssessment.address}"/>" disabled/></td>
				
		</tr>
		<!--<tr>
		
			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Zone No. (झोन
							क्र.)" /></span><span class="ClsRequiredFields">:</span>
			</td>
			<td colspan="2">
					<input type="text" class="form-control" style="width: 200px"
						id="fatherName" maxlength="45" tabindex="4" name="fatherName"
						value="<c:out value="${propertyTaxAssessment.zoneNo}"/>" disabled/>
				</td>

		

			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Ward No. (प्रभाग क्र.)" />:</span></td>
			<td colspan="2">

					<input type="text" class="form-control" style="width: 200px"
						id="childeName" maxlength="45" tabindex="3" name="childeName"
						value="<c:out value="${propertyTaxAssessment.wardNo}"/>" disabled/>
			</td>
</tr>-->
		
			<tr>

			
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key=" UPIN No.(UPIN क्र)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control" style="width: 200px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${propertyTaxAssessment.upinNo}"/>" disabled/></td>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Index No.
							(निर्देशांक क्र.)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control" style="width: 200px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${propertyTaxAssessment.indexNo}"/>" disabled/></td>






			
		</tr>
		
		
		<tr>

			

<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Objection Remarks. (आपत्तीचे टिप्पणी)" />:</span></td>
			<td colspan="2">

					<input type="text" class="form-control" style="width: 200px"
						id="applicantLastName" maxlength="50" name="applicantLastName"
						value="<c:out value="${propertyTaxAssessment.objectionRemarks}"/>" disabled/>
			

			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Existing BuiltUp Area (विद्यमान बिल्टअप क्षेत्र)" />:</span></td>
			<td colspan="2">
					<input type="text" class="form-control" style="width: 200px"
						id="ph_no" maxlength="50" name="ph_no"
						value="<c:out value="${propertyTaxAssessment.oldbuiltUpArea}"/>" disabled/>
				</td>
</tr>

<tr>

		<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="New BuiltUp Area (नवीन बिल्टअप क्षेत्र)" />:</span></td>
			<td colspan="2">
					<input type="text" class="form-control" style="width: 200px"
						id="ph_no" maxlength="50" name="ph_no"
						value="<c:out value="${propertyTaxAssessment.builtUpArea}"/>" disabled/>
				</td>		

<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Existing NTB (विद्यमान NTB)" />:</span></td>
			<td colspan="2">

					<input type="text" class="form-control" style="width: 200px"
						id="applicantLastName" maxlength="50" name="applicantLastName"
						value="<c:out value="${propertyTaxAssessment.oldntb}"/>" disabled/>
			

			
</tr>




<tr>

			
			
<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="New NTB (नवीन NTB)" />:</span></td>
			<td colspan="2">

				
						<select class="form-select" id="ntb"  style=" width: 200px; background-image: none;" name="ntb" required>
    <c:choose>
        <c:when test="${empty propertyTaxAssessment.ntb}">
            <option value="" selected>-Select NTB-</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.ntb eq '367'}">
            <option value="367" selected>New: Class C</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.ntb eq '366'}">
            <option value="366" selected>New: Class D</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.ntb eq '365'}">
            <option value="365" selected>New: Class B</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.ntb eq '364'}">
            <option value="364" selected>New: Class A</option>
        </c:when>
        <c:otherwise>
            <option value="" selected>-Select NTB-</option>
        </c:otherwise>
    </c:choose>
</select>
						
			
			
			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Existing Usage Factor (विद्यमान वापर घटक)" />:</span></td>
			<td colspan="2">
					<input type="text" class="form-control" style="width: 200px"
						id="ph_no" maxlength="50" name="ph_no"
						value="<c:out value="${propertyTaxAssessment.oldfactorUsage}"/>" disabled/>
				</td>
				
				</tr>
				<tr>
				
				
				<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="New Usage Factor(नवीन वापर घटक)" />:</span></td>
			<td colspan="2">
						
						<select class="form-select" style="width: 200px; background-image: none;" id="usageFactor" style="background-image: none;" required>
    <c:choose>
        <c:when test="${empty propertyTaxAssessment.factorUsage}">
            <option value="" selected>-Select Usage Factor-</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '363'}">
            <option value="363" selected>New: C12 Ghat</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '362'}">
            <option value="362" selected>New: C11 Weight bridge</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '361'}">
            <option value="361" selected>New: C10 Building for formers implements or products</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '360'}">
            <option value="360" selected>New: C9 Advocate, tax consultant offices</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '359'}">
            <option value="359" selected>New: C8 Hostels, canteen</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '358'}">
            <option value="358" selected>New: C7 Amusement park / garden</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '357'}">
            <option value="357" selected>New: C6 Playground / stadium and adjoining buildings (Without ticket)</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '356'}">
            <option value="356" selected></option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '355'}">
            <option value="355" selected>New: C4 Educational institution (Govt. Grant)</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '354'}">
            <option value="354" selected></option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '353'}">
            <option value="353" selected>New: C2 Residential / vacant buildings</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '352'}">
            <option value="352" selected>New: C1 Open Plots</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '351'}">
            <option value="351" selected>New: B1 Others</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '350'}">
            <option value="350" selected>New: A21 Special Car parking Buildings</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '349'}">
            <option value="349" selected>New: A20 Hotels with Lodging and Sitting Arrangement</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '348'}">
            <option value="348" selected>New: A19 Lodging Houses</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '347'}">
            <option value="347" selected>New: A18 Air Conditions or well-decorated offices or shops</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '346'}">
            <option value="346" selected>New: A17 Club House for Members only</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '345'}">
            <option value="345" selected>New: A16 Tuition Classes</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '344'}">
            <option value="344" selected>New: A15 Towers</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '343'}">
            <option value="343" selected>New: A14 Advertisement Boards</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '342'}">
            <option value="342" selected>New: A13 Super Specialty Hospitals</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '341'}">
            <option value="341" selected>New: A12 Bedded Hospitals</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '340'}">
            <option value="340" selected>New: A11 Private Health Club, Gymnasiums</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '339'}">
            <option value="339" selected>New: A10 Petrol Pumps, Diesel, Gas Pumps</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '338'}">
            <option value="338" selected>New: A9 Bank, Scheduled Bank, Financial Institutes</option>
        </c:when>
         <c:when test="${propertyTaxAssessment.factorUsage eq '335'}">
            <option value="335" selected>New: A8 Cinema Hall/ Theater/Drama Hall</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '334'}">
            <option value="334" selected>New: A7 Swimming tank and attached building with entry fee or membership</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '333'}">
            <option value="333" selected>New: A6 Multiplex</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '332'}">
            <option value="332" selected>New: A5 Malls</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '331'}">
            <option value="331" selected>New: A4 ATM Money changing center</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '330'}">
            <option value="330" selected>New: A3 Restaurant Bar and Starred Hotels</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '329'}">
            <option value="329" selected>New: A2 Marriage Hall, Party Hall</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.factorUsage eq '328'}">
            <option value="328" selected>New: A1 Airport buildings</option>
        </c:when>
        <c:otherwise>
            <option value="" selected>-Select Usage Factor-</option>
        </c:otherwise>
    </c:choose>
</select>
				</td>
				
				
				

<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Existing Age Factor (विद्यमान वय घटक)" />:</span></td>
			<td colspan="2">

					<input type="text" class="form-control" style="width: 200px"
						id="applicantLastName" maxlength="50" name="applicantLastName"
						value="<c:out value="${propertyTaxAssessment.oldageFactor}"/>" disabled/>
			

			
</tr>

		
			<tr>
			
			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="New Age Factor (नवीन वय घटक)" />:</span></td>
			<td colspan="2">
				
						
						
						<select class="form-control" style="width: 200px" class="form-select is-valid" id="ageFactor" style="background-image: none;" required>
    <c:choose>
        <c:when test="${empty propertyTaxAssessment.ageFactor}">
            <option value="" selected>-Select Age Factor-</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.ageFactor eq '379'}">
            <option value="379" selected>New: Class C</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.ageFactor eq '374'}">
            <option value="374" selected>New: G: Above 60 Years</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.ageFactor eq '373'}">
            <option value="373" selected>New: F: 51-60 Years</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.ageFactor eq '372'}">
            <option value="372" selected>New: E: 41-50 Years</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.ageFactor eq '371'}">
            <option value="371" selected>New: D: 31-40 Years</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.ageFactor eq '370'}">
            <option value="370" selected>New: C: 21-30 Years</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.ageFactor eq '369'}">
            <option value="369" selected>New: B: 11-20 Years</option>
        </c:when>
        <c:when test="${propertyTaxAssessment.ageFactor eq '368'}">
            <option value="368" selected>New: A: 00-10 Years</option>
        </c:when>
        <c:otherwise>
            <option value="" selected>-Select Age Factor-</option>
        </c:otherwise>
    </c:choose>
</select>
						
						
						

<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Reason(कारण)" />:</span></td>
			<td colspan="2">
					<input type="text" class="form-control" style="width: 200px"
						id="ph_no" maxlength="50" name="ph_no"
						value="<c:out value="${propertyTaxAssessment.reason}"/>" disabled/>
				</td>
				
				<tr>
					<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Zone No. (झोन
							क्र.)" /></span><span class="ClsRequiredFields">:</span>
			</td>
			<td colspan="2">
					<input type="text" class="form-control" style="width: 200px"
						id="fatherName" maxlength="45" tabindex="4" name="fatherName"
						value="<c:out value="${propertyTaxAssessment.zoneNo}"/>" disabled/>
				</td>
				
				
				<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Applicable Fees(लागू शुल्क)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				style="width: 200px" id="feesApplicable" maxlength="45" tabindex="3"
				name="fees"
				value="<c:out value="${rtiApplication.applicationCost}"/>"
				disabled /></td>
				
				</tr>
				
				</tr>
	
		<%--  <c:if test="${requestScope.rtiApplication.workFlowStatus==3 ||requestScope.rtiApplication.workFlowStatus==2 || requestScope.rtiApplication.workFlowStatus==1}">
     <tr >
              <td><span class="ClsLabel" id="payment" style="font-size:14px">Payment Receipt Upload: </span> </td>
                <td>
                      
			<input type="file" class="imagefile" name="paymentReceiptidProof" id="paymentReceiptidProof" style="width: 220px" />

			</td>
                   <td>   
                      <c:if test="${ empty propertyTaxAssessment.paymentReceipt}">   
               
                <a class="bg-button btn btn-primary bd-highlight" style="color:white" id="paymentReceiptdocupload" type="button" target="_blank" onclick="paymentReceiptupload(${propertyTaxAssessment.rti_ref_id}); return false;"><span
							class="download" style="align-items: center">Upload</span></a>
               
                </c:if>
              <c:if test="${ not empty propertyTaxAssessment.paymentReceipt}">
              
               <a class="bg-button btn btn-success bd-highlight action" style="color:white" id="paymentReceiptdownload"  class="imagefile" type="button" target="_blank" href="<c:out value="${propertyTaxAssessment.paymentReceipt}"/>"><span
							class="download" style="align-items: center">Download</span></a>
               </c:if>

</td>
</tr>
</c:if> --%>
		
		
	<%--	<tr>
			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px">
					Current Status:</span></td>
			<td style="width: 230px; height: 30px"><span class="ClsLabel"
				style="font-size: 14px"><c:if
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
					
			<td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Birth Place" />:</span>
                        </td>
                         <td> <span class="ClsLabel" style="font-size:14px"><fmt:message key="Remark" />:</span></td>
                        <td >
                            
                                <input type="text" class="ClsTextbox_mr" style="width:180px" id="Remark" maxlength="12" name="Remark" value=""  />
                            
                        </td>
                         --%>
                         	<%-- <td colspan=""><span class="ClsLabel" style="font-size: 14px">Certificate
					Upload: </span></td>
			<td><input type="file" class="imagefile" name="idProof"
				id="idProof" style="width: 220px" /></td>
				
			<td><c:if
					test="${ empty requestScope.rtiApplication.pdfFilesSavedPath}">

					<a class="bg-button btn btn-primary bd-highlight"
						style="color: white" id="birthupload" type="button"
						target="_blank"
						onclick="birthupload(${propertyTaxAssessment.rti_ref_id}); return false;"><span
						class="download" style="align-items: center">Upload</span></a>


				</c:if> <c:if
					test="${ not empty requestScope.rtiApplication.pdfFilesSavedPath}">

					<a class="bg-button btn btn-success bd-highlight action"
						style="color: white" id="birthdownload" class="imagefile"
						type="button" target="_blank"
						href="<c:out value="${requestScope.rtiApplication.pdfFilesSavedPath}"/>"><span
						class="download" style="align-items: center">Download</span></a>
				</c:if></td>
				</tr> --%>
					<tr>
			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px">
					Current Status:</span></td>
			<td style="width: 230px; height: 30px"><span class="ClsLabel" style="font-size:14px;color:forestgreen;"><c:if
						test="${requestScope.rtiApplication.workFlowStatus==0}">
						Citizen Form Submitted. 
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==3}">
						Citizen Payment Pending. 
					</c:if>
<c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
						Citizen Payment Completed. 
					</c:if>
					 <c:if test="${requestScope.rtiApplication.workFlowStatus==1}">
						Completed and File Uploaded for Citizen
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==5}">
						Rejected
					</c:if></span></td>

		     
<%-- <c:if
					test="${ empty requestScope.rtiApplication.pdfFilesSavedPath}">
		 	<td colspan=""><span class="ClsLabel" style="font-size: 14px">Certificate
					Upload: </span></td>
			<td><input type="file" class="imagefile" name="idProof"
				id="idProof" style="width: 220px" /></td>
			<td> 
					<a class="bg-button btn btn-primary bd-highlight"
						style="color: white" id="birthupload" type="button"
						target="_blank"
						onclick="birthupload(${partitionOfProperty.rti_ref_id}); return false;"><span
						class="download" style="align-items: center">Upload</span></a>


				 
				</c:if> --%>
				<td>
		
                 <c:if test="${not empty requestScope.rtiApplication.pdfFilesSavedPath}">
					<a class="bg-button btn btn-success bd-highlight action"
						style="color: white" id="birthdownload" class="imagefile"
						type="button" target="_blank"
						href="<c:out value="${requestScope.rtiApplication.pdfFilesSavedPath}"/>"><span
						class="download" style="align-items: center">Download</span></a>
						</c:if>
				</td>
				</tr>
		
		</tr>
		
		</table>
	<table width="100%" border="0" cellpadding="2" cellspacing="2">

		<tr>
		
						
						       <td colspan="6" style="background-color: white;background-color: #c5ddfe;"><span class="ClsLabel"
				style="
    height: 37px;
    padding: 7px 10px 11px;
       font-size: 17px;color:#01293d;font-style: italic;"><fmt:message
						key="List of Documents (Attachment) दस्तऐवजांची यादी (संलग्नक)" />:</span></td>
		</tr>




	<c:if test="${doc[0] != 'null'}">
			<tr>
				<td colspan="3.5"><span class="ClsLabel"
					style="font-size: 14px"><fmt:message
														key="Self Attested Applicant's Id Proof (स्वत: प्रमाणित अर्जदाराचा आयडी पुरावा)" />:</span> 

					
				<td style="text-align: center" colspan="3.5"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[0]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>
			</tr>
		</c:if>
		
		
		<c:if test="${doc[1] != 'null'}">
			<tr>
				<td colspan="3.5"><span class="ClsLabel"
					style="font-size: 14px"><fmt:message
							key="No Dues Certificate (नाहरकत प्रमाणपत्र)" />:</span> 
				<td style="text-align: center" colspan="3.5"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[1]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>
			</tr>
		</c:if>
		
		<c:if test="${doc[2] != 'null'}">
			<tr>
				<td colspan="3.5"><span class="ClsLabel"
					style="font-size: 14px"><fmt:message
							key="Copy Of Sale Deed/Award Deed/Partition 
     Deed/Will/Succession Deed/Deed of 
    Surrender/NIT/Nazul/Lease of Municipal Corporation
     Document (विक्री करारनामा/अवार्ड डीड/पार्टीशन  
    डीड/विल/उत्तराधिकार डीड/पार्टिशन  
     डीड/एनआयटी/नझूल/महापालिका दस्तावेजाची लीजची प्रत)" />:</span> 
				<td style="text-align: center" colspan="3.5"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[2]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>
			</tr>
		</c:if>
		
		<c:if test="${doc[3] != 'null'}">
			<tr>
				<td colspan="3.5"><span class="ClsLabel"
					style="font-size: 14px"><fmt:message
							key="Upload Relevant Document (संबंधित दस्तऐवज अपलोड करा)" />:</span> 
				<td style="text-align: center" colspan="3.5"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[3]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>
			</tr>
		</c:if>
	</table>

	<input type="hidden" class="ClsTextbox_mr" style="width: 200px"
		id="propertyAssessmentID" maxlength="12" name="propertyAssessmentID"
		value="<c:out value="${propertyTaxAssessment.propertyComplaintRegistrationID}"/>" /> 

			  <input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId" value="" />
			  			  <input type="hidden" id="rtiApplicationRefIds" name="rtiApplicationRefIds" value="${propertyTaxAssessment.rti_ref_id}" />
			  
<%-- <c:if test="${propertyTaxAssessment.fees == 0.0}">
<tr>

<td colspan="4" align="center"><input type="button"
				class="btn btn-primary"
				style="min-height: 30px; min-width: 80px; color: white; border: none; outline: #28a745;"
				id="savefees" name="savefees"
				value="<fmt:message key="common.button.save"/>"
				onclick="javascript:saveFees(this.form);">
</td>
</tr>
</c:if> --%>
</table>
	 <%@include file="/pages/workflow/taskInclude.jsp"%>

</div>
</div>

<script type="text/javascript">
	function saveEntity() {
		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/createPropertyTaxComplaint.do');
	}
	
	
	function saveFees(){
		var refId= $('#propertyAssessmentID').val();
		if($('#feesApplicable').val().trim() >0){
		if(confirm("Are you sure you want to save Fees!!")){
		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/savePropertyTaxComplaintFees.do?id='+refId);
		}else{
			return false;
		}
		}else{
			alert("Please enter the fees");
			return false;
		}

	}
	
	$(document).ready(function() {
		  var feeId = $('#feesApplicable').val();
		    $("#feesApplicable").prop('disabled',false);
		    $("#savefees").prop('disabled',false);
			  var feeId = $('#feesApplicable').val();
		    if(feeId==='0.0'){
				  var elements = document.getElementsByClassName("tab")[0];
					elements.innerHTML = "Please save the Fees".fontcolor("red");
					document.getElementById("feesApplicable").style.backgroundColor = "white";
			    	$('#commentsDisable *').attr('disabled', true);
			    	$('#CreateWorkflow').attr('disabled', true);
			    	$('#RejectCreateWorkflow').attr('disabled', true);
			    	$('#WORKFLOW_COMMENTS').attr('disabled', true);
			  }
		});
/* 	$(document).ready(function() {
		  var feeId = $('#feesApplicable').val();
		  if (feeId >0) {
		    $("#feesApplicable").prop('disabled', true);
		    $("#savefees").prop('disabled',true);

		  }
		  
		
		}); */
	
	$(document).ready(function() {
		  var receipt = "${propertyTaxAssessment.paymentReceipt}";
		  if (receipt =='') {
			  $("#birthupload").attr("disabled", "disabled");
			  $("#idProof").prop('disabled',true);

		  }else{
			  
			  $("#paymentReceiptidProof").prop('disabled',true);

		  }
		  
		
		});
	
	
	</script> 
	
	
	<script type="text/javascript">
	
	function birthupload(id) {
		  
 	    var data = new FormData();
 	   var idProofFileInput = $("#idProof");
 	  
 		if (receipt === '') {
 	 	    alert("Please upload the payment receipt!!");
 	 	    return false;
 	 	}
 		
 	 	if (idProofFileInput.val() === '') {
 	 	    alert("Please select the document!!");
 	 	    return false;
 	 	}
 	    alert("Are you sure you want to Upload Certificate?");
 	    
 	  document.getElementById('rtiApplicationRefIds').value=id;
 	 

 	if (idProofFileInput.length > 0 && idProofFileInput.get(0).files.length > 0) {
 	    data.append('idProof1', idProofFileInput.get(0).files[0]);

 	   
 	} else {
 	    console.error("No file selected");
 	}

 	 var apptype=10;
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
 	                    url: '<c:out value="${contextRoot}"/>/rtsapplication/savePropertyTaxUpload.do?refId='+id,
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

 	function paymentReceiptupload(id) {
 		// $('#SetFormHeight *').removeAttr('disabled');
 		document.getElementById("rtiApplicationRefIds").value=id;
 		
 		 
 		    $f1 = $("#paymentReceiptidProof");
 		    
 		    var data = new FormData();
 		    if($f1.val()){
 		    	if(confirm("Are you sure you want to Upload Certificate?")){
 		    	if($f1.get(0).files.length>0){
 				    for(i=0;i<$f1.get(0).files.length;i++){
 				    	data.append('idProof', $f1.get(0).files[i]);
 						    }
 					    }
 		    	}else{
		        	   return false;
 		    	}
 		           }else{
 		        	   alert("Please select valid document!!");
 		        	   return false;
 		           }
 		 
 		    var propertyId=8;		
 		    $.ajax({
 		        url: "<c:out value='${contextRoot}'/>/rtsapplication/savePropertyPaymentReceiptupload.do?id="+id+"&propertyId="+propertyId,
 		        type: 'POST',
 		        data: data,
 		        cache: false,
 		        dataType: 'json',
 		        processData: false, // Don't process the files
 		        contentType: false, // Set content type to false as jQuery will tell the server its a query string request
 		        async: false,
 		        success: function(data, textStatus, jqXHR)
 		        { 
 		        	 var status = data.status;
 		        
 		        	 if(status===true){
 		        		    alert("Upload has been done successfully!");
 		        		    window.location.reload(); 
 		        		    }else{
 		        		    alert("Upload has been failed !");
 		        	 }
 		        },
 		        error: function(jqXHR, textStatus, errorThrown)
 		        {
 		            // Handle errors here
 		            
 		            console.log('ERRORS: ' + textStatus);
 		            // STOP LOADING SPINNER
 		        }
 		    });
 		   	    	 
 		  
 		    
 		  }
 	
 /* 	$(document).ready(function() {
 	    var paymentReceipt = '${propertyTaxMutation.paymentReceipt}';
 	  


 	    if (paymentReceipt !== "") {
 			$('#paymentReceiptidProof').attr('disabled', true);
 	    } else {
 			$('#paymentReceiptidProof').attr('disabled', false);
 	    }
 	    
 	    
 	}); */

	function docDownload(filesPath) {
 	    var encodedFilePath = encodeURIComponent(filesPath);

 	    var encodedFilesPath = btoa(encodedFilePath); 

 	    window.open('<c:out value="${contextRoot}"/>/rtsApplication/getPdf.do?fp=' + encodedFilesPath, '_blank');
 	}
</script>
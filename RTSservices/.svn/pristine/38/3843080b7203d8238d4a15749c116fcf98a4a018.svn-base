<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants,com.mars.common.utils.CommonUtils,com.mars.rti.utils.CoreConstants"/>

<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY",Constants.SESSION_TOKEN_KEY);
pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);


pageContext.setAttribute("LABEL_RADIO_MALE", CoreConstants.LABEL_RADIO_MALE);
pageContext.setAttribute("LABEL_RADIO_FEMALE", CoreConstants.LABEL_RADIO_FEMALE);
pageContext.setAttribute("RADIO_MALE", CoreConstants.RADIO_MALE);
pageContext.setAttribute("RADIO_FEMALE", CoreConstants.RADIO_FEMALE);

pageContext.setAttribute("LABEL_RADIO_LITERATE", CoreConstants.LABEL_RADIO_LITERATE);
pageContext.setAttribute("LABEL_RADIO_ILLITERATE", CoreConstants.LABEL_RADIO_ILLITERATE);
pageContext.setAttribute("RADIO_LITERATE", CoreConstants.RADIO_LITERATE);
pageContext.setAttribute("RADIO_ILLITERATE", CoreConstants.RADIO_ILLITERATE);
pageContext.setAttribute("FEE_TYPE_RTI_APPLICATION", CoreConstants.FEE_TYPE_RTI_APPLICATION);
%>

<script type="text/javascript">

function getFeeDetails(){
	var createdDate = document.getElementById("createdDate").value;
	var numberOfCopies =document.getElementById("numberOfCopies").value;
	
	if(createdDate.length > 0)
	{
		getFeeAmount(createdDate,numberOfCopies);
	}
}
function getFeeAmount(createdDate,numberOfCopies){

	if (createdDate != null && numberOfCopies > 0){
		CommonServiceDWR.getCertificateFeeAmount(createdDate,numberOfCopies,setFeeAmountList);
	}
}

function setFeeAmountList(data)
{
	document.getElementById("amountOfAllCopies").value=data.amount;
	if(data.feeMasterId !=0){
		document.getElementById("feeMasterId").value=data.feeMasterId;
	}else{
		displayError("Fee Details could not be fetched for selected dates. Make sure that Fee Master is defined properly.");
	}
}
</script>

<div class="mainHdr">
	<h3> 
		<c:choose>
			<c:when test="${rtiApplication.rtiApplicationId==0}">
				<fmt:message key="rtiApplication.manage.pagetitle.new"/>
			</c:when>
			<c:otherwise>	
				<fmt:message key="rtiapplication.manage.pagetitle.edit"/>
			</c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top" id="SetFormHeight">
<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
	<tr>
		<td colspan="2">
			<spring:bind path="rtiApplication.rtiApplicationId">
			<input type="hidden" id="rtiApplicationId" name="rtiApplicationId" value="<c:out value="${rtiApplication.rtiApplicationId}"/>" />
			</spring:bind>
		</td>
	</tr>
		 
	
	<c:if test="${rtiApplication.rtiApplicationId!=0}">
		<tr>
			<td >
				<span class="ClsLabel"><fmt:message key="rtiApplication.label.applicationnnumber" />: </span>
			</td>
			<td>				
				<spring:bind path="rtiApplication.rtiApplnNumber">
					<input type="text" readonly="readonly" class="ClsTextbox" style="background:#f1f1f1; width:170px;border:none;" id="rtiApplnNumber"   
						name="rtiApplnNumber" value="<c:out value="${rtiApplication.rtiApplnNumber}"/>" />
				</spring:bind>	 
			</td>
		</tr>
	</c:if> 
	 
	<tr>
		<td >
			<span class="ClsLabel"> Related InWard Number </span><span class="ClsRequiredFields">*</span></td>
		<td>
			  <input type="text" class="ClsTextbox"  id="inWardNumber" name="inWardNumber" value="${rtiApplication.inWardNumber}" />
		</td>
		<td >
			<span class="ClsLabel">Registration Date</span><span class="ClsRequiredFields">*</span></td>
		<td>
			 <input type="text" class="ClsTextboxDate" readonly="readonly"  id="registrationDate" name="registrationDate"  value="${rtiApplication.registrationDate}" />
		</td>
	</tr> 
	<tr>
		<td >
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.department"/></span><span class="ClsRequiredFields">*</span></td>
		<td>
			<select name="applicationDepartmentId" id="applicationDepartmentId" class="ClsTextbox"  style="width:300px">
			<option value=""> <--- Select ---> </option>
				<c:forEach var="department" items="${requestScope.departmentList}">
				<c:choose>
					<c:when test="${rtiApplication.applicationDepartment.departmentId==department.departmentId}">
						<option value="${department.departmentId}" selected="selected">
						<c:out value="${department.name}"/>
						</option>
					</c:when>
					<c:otherwise>
						<option value="${department.departmentId}">
						<c:out value="${department.name}"/>
						</option>
					</c:otherwise>
				</c:choose>
				</c:forEach>
			</select>
		</td>
		<td >
			<span class="ClsLabel"> Receiving Mode</span><span class="ClsRequiredFields">*</span></td>
		<td>
			<spring:bind path="receivedModeId">
				<select class="ClsSelect" name="receivedModeId" id="receivedModeId" >
					<option value=""><--- Select ---></option>
						<c:forEach var="receivedMode" items="${requestScope.receivedMode}">
							<c:choose>
								<c:when
									test="${fileCreation.receivedMode.receivedModeId==fileReceivedMode.receivedModeId}">
									<option value="${receivedMode.receivedModeId}" selected="selected">
										<c:out value="${receivedMode.receivedModeName}" /></option>
								</c:when>
								<c:otherwise>
									<option value="${receivedMode.receivedModeId}">${receivedMode.receivedModeName}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select>
			</spring:bind>
		</td>
	</tr>
	<tr>
		<td >
			<span class="ClsLabel"> Received Date </span><span class="ClsRequiredFields">*</span></td>
		<td>
			<input type="text" class="ClsTextboxDate" readonly="readonly"  id="receivedDate" name="receivedDate"  value="${rtiApplication.receivedDate}" />
		</td>
		<td >
			<span class="ClsLabel"> Received Reference No.</span></td>
		<td>
			 <input type="text" class="ClsTextbox"  id="receivedRefNo" name="receivedRefNo" value="${rtiApplication.receivedRefNo}" />
		</td>
	</tr>
	<tr>
		<td>
			<span class="ClsLabel">Subject of Application</span><span class="ClsRequiredFields">*</span></td>
		<td>
			<spring:bind path="rtiApplication.subject">
				<textarea class="ClsTextbox" id="subject"   cols="40" rows="4" name="subject">
					<c:out value="${rtiApplication.subject}" /></textarea>
			</spring:bind>
		</td>
		<td>
			<span class="ClsLabel">Specific Details of Information Required</span><span class="ClsRequiredFields">*</span></td>
		<td>
			<spring:bind path="rtiApplication.subject">
				<textarea class="ClsTextbox" id="subject"   cols="40" rows="4" name="subject">
					<c:out value="${rtiApplication.subject}" /></textarea>
			</spring:bind>
		</td>
	</tr>
	
	
	<tr>
		<td colspan="4" class="ClsTitle">
			<br/>
			  Application Fee Details
			<hr/>
		</td>
	</tr> 
		
	<tr>
		<td>
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.costOfAppln"/></span></td>
		<td>
			<spring:bind path="rtiApplication.applicationCost">
				<input type="text" class="ClsTextbox" id="applicationCost" name="applicationCost" maxlength="16" readonly="readonly" style="border:none;" 
				 value="<c:out value="${rtiApplication.applicationCost}"/>" />
			</spring:bind>
		</td>
		<td>
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.numberOfCopies"/></span><span class="ClsRequiredFields">*</span>
		</td>
		<td>
			<spring:bind path="rtiApplication.numberOfCopies">
				<input type="text" class="ClsTextbox"  id="numberOfCopies" name="numberOfCopies" maxlength="10" onblur="javascript:getFeeDetails();"  
				value="<c:out value="${rtiApplication.numberOfCopies}"/>" <c:if test="${rtiApplication.numberOfCopies > 0}">readonly="readonly"</c:if> />
			</spring:bind>
		</td>
	</tr> 
	
	<tr>
		<td>
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.amount"/></span></td>
		<td>
			<spring:bind path="rtiApplication.amountOfAllCopies">
				<input type="text" class="ClsTextbox" id="amountOfAllCopies" name="amountOfAllCopies" maxlength="16" readonly="readonly" style="border:none;" 
				 value="<c:out value="${rtiApplication.amountOfAllCopies}"/>" />
			</spring:bind>
		</td>
		<td>
			<span class="ClsLabel">Is Application Fee Paid</span></td>
		<td>
			 <input type="checkbox" id="iSFeePaid"  name="iSFeePaid"  /> 
		</td>
	</tr>
	
	
	
	
	<tr>
		<td colspan="4" class="ClsTitle">
			<br/>
			  Personal  Details
			<hr/>
		</td>
	</tr> 
	
	<tr>
		<td >
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.name"/></span><span class="ClsRequiredFields">*</span>
		</td>
		<td>
			<spring:bind path="rtiApplication.name">
			<input type="text" class="ClsTextbox" id="name" maxlength="45"   placeholder="Enter Name" name="name" 
				value="<c:out value="${rtiApplication.name}"/>" />
			</spring:bind>
		</td>
		<td >
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.gender" />:</span>
		</td>
		<td >
			<spring:bind path="rtiApplication.gender">
				<input type="radio" id="gender<c:out value="${pageScope.LABEL_RADIO_MALE}"/>" name="gender" value="<c:out value="${pageScope.RADIO_MALE}"/>" />
				<label for="gender<c:out value="${pageScope.LABEL_RADIO_MALE}"/>" ><c:out value="${pageScope.LABEL_RADIO_MALE}" /></label>
				<input type="radio" id="gender<c:out value="${pageScope.LABEL_RADIO_FEMALE}"/>" name="gender" value="<c:out value="${pageScope.RADIO_FEMALE}"/>" />
				<label for="gender<c:out value="${pageScope.LABEL_RADIO_FEMALE}"/>" ><c:out value="${pageScope.LABEL_RADIO_FEMALE}" /></label>
			</spring:bind>
		</td>
	</tr>
	<tr>
		<td >
			<span class="ClsLabel">BPL(Below Poverty Line)</span><span class="ClsRequiredFields">*</span>
		</td>
		<td colspan="3">
			<spring:bind path="rtiApplication.bpl">
				<input type="checkbox" id="bpl"  name="bpl"   /> 
			</spring:bind>
			
			<spring:bind path="rtiApplication.bplCardNumber">
				<input type="text" class="ClsTextbox" id="bplCardNumber" maxlength="45"  placeholder="BPL Card Number" name="bplCardNumber" 
					value="<c:out value="${rtiApplication.bplNumber}"/>" />
			</spring:bind>			
		</td>		 
	</tr>
	 
		
	<tr>
		<td>
			<span class="ClsLabel">Address Line 1</span></td>
		<td>
			<spring:bind path="rtiApplication.addressLine1">
				<input  type="text" class="ClsTextbox" id="addressLine1"   name="addressLine1" value="${rtiApplication.addressLine1}">
			</spring:bind>
		</td>
		<td>
			<span class="ClsLabel">Address Line 2</span></td>
		<td>
			<spring:bind path="rtiApplication.addressLine2">
				<input  type="text" class="ClsTextbox" id="addressLine2"   name="addressLine2" value="${rtiApplication.addressLine2}">
			</spring:bind>
		</td>
	</tr>
	
	
	<tr>
	
		<td >
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.state"/></span><span class="ClsRequiredFields">*</span>
		</td>
		<td>
			<spring:bind path="rtiApplication.state">
			<input type="text" class="ClsTextbox" id="state" maxlength="45" name="state"  style="width:300px" value="<c:out value="${rtiApplication.state}"/>" />
			</spring:bind>
		</td>
	    <td >
			<span class="ClsLabel">District</span><span class="ClsRequiredFields">*</span>
		</td>
		<td>
			<spring:bind path="rtiApplication.district">
			<input type="text" class="ClsTextbox" id="district"  name="district"   placeholder="District"  
				value="<c:out value="${rtiApplication.district}"/>" />
			</spring:bind>
		</td>
		
	</tr>
	
	<tr>
	
		<td >
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.pincode"/></span><span class="ClsRequiredFields">*</span>
		</td>
		<td>
			<spring:bind path="rtiApplication.pincode">
			<input type="text" class="ClsTextbox" id="pincode" maxlength="6" name="pincode"  style="width:300px" placeholder="Enter Pincode"  
				value="<c:out value="${rtiApplication.pincode}"/>" />
			</spring:bind>
		</td>
	    <td >
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.phoneNumber"/></span> 
		</td>
		<td>
			<spring:bind path="rtiApplication.phoneNumber">
			<input type="text" class="ClsTextbox" id="phoneNumber" maxlength="10"  style="width:300px" name="phoneNumber" placeholder="XXXXXXXXXX" 
				value="<c:out value="${rtiApplication.phoneNumber}"/>" />
			</spring:bind>
		</td>
		
	</tr>
  
	
	<tr>
		<td >
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.mobileNumber"/></span><span class="ClsRequiredFields">*</span>
		</td>
		<td>
			<spring:bind path="rtiApplication.mobileNumber">
			<input type="text" class="ClsTextbox" id="mobileNumber" maxlength="10"   style="width:300px" name="mobileNumber" placeholder="XXXXXXXXXX" 
				value="<c:out value="${rtiApplication.mobileNumber}"/>" />
			</spring:bind>
		</td>
		<td >
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.email"/></span><span class="ClsRequiredFields">*</span>
		</td>
		<td>
			<spring:bind path="rtiApplication.email">
			<input type="text" class="ClsTextbox" id="email" name="email"style="width:300px" maxlength="45" placeholder="e.g user@gmail.com" 
				value="<c:out value="${rtiApplication.email}"/>" />
			</spring:bind>
		</td>
	</tr>
	
	 
	
	
	
	<%-- <tr>
		<td><span class="ClsLabel"><fmt:message	key="feeMaster.manage.label.status" /></span></td>
		<td>
			<select name="status" id="status" class="validate[required] ClsSelect" style="width:150px">
				<option value=""> <-- Select Status --> </option>
					<c:forEach items="${pageScope.statusList}" var="statusList"> 
						<option value="${statusList[0]}" <c:if test="${feeMaster.status == statusList[0]}">selected = "selected" </c:if>>
							<c:out value="${statusList[1]}" />
						</option>
					</c:forEach>
			</select> 
		</td>
	</tr> --%>


	<tr><td  colspan="2" style="padding-top:5px"></td></tr>
	<tr><td></td>
	
		<td>
			<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveRTIApplication(this.form);">
			<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls(),setInputControls();">
			<c:if test="${rtiApplication.rtiApplicationId!=0}">
				<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deleteRTIApplication(this.form);">
			</c:if>
		</td>
		
	</tr>
		</table>

	<!-- DMS Documents Attachments Include Start -->
	<c:if test="${rtiApplication.rtiApplicationId != 0}">
		<%@include file="/pages/common-pages/dms/manageDmsAttachments.jsp"%>
	</c:if>
	<!-- DMS Documents Attachments Include End -->
	</br></br>
	<%-- <%@include file="/pages/workflow/taskInclude.jsp"%> --%>

	
	<%--RTI Application forward Actions page--%>
	<c:if test="${rtiApplication.rtiApplicationId != 0}">
 		<%@include file="/pages/core-pages/rtiapplication/applicationForwardingActions.jsp"%>
 	</c:if>

</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/>
<input type="hidden" id="feeMasterId" name="feeMasterId" value="<c:out value="${rtiApplication.feeMaster.feeMasterId}"/>" />
<input type="hidden" id="tenancyId" name="tenancyId" value=" " />

<script type="text/javascript">

function saveEntity()
{
	saveRTIApplication(document.forms[0]);
}

function saveRTIApplication(frm)
{
	var arrRequiredElements=new Array('name','pincode','state','phoneNumber','mobileNumber','email','createdDate');
	var arrRequiredElementsMessages=new Array('<fmt:message key="rtiApplication.manage.label.name"/>',
			'<fmt:message key="rtiApplication.manage.label.pincode"/>',
			'<fmt:message key="rtiApplication.manage.label.state"/>',
			'<fmt:message key="rtiApplication.manage.label.phoneNumber"/>',
			'<fmt:message key="rtiApplication.manage.label.mobileNumber"/>',
			'<fmt:message key="rtiApplication.manage.label.email"/>',
			'<fmt:message key="rtiApplication.manage.label.createdDate"/>');
	if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages)){
		if(isAlphaSpace(new Array('name'),new Array('<fmt:message key="rtiApplication.manage.label.name"/>'))){		
			if(checkChildNumericDetailed(new Array('pincode'),new Array('<fmt:message key="rtiApplication.manage.label.pincode"/>'))){		
				if(isAlphaSpace(new Array('state'),new Array('<fmt:message key="rtiApplication.manage.label.state"/>'))){		
					if(checkChildNumericDetailed(new Array('phoneNumber'),new Array('<fmt:message key="rtiApplication.manage.label.phoneNumber"/>'))){		
						if(checkChildNumericDetailed(new Array('mobileNumber'),new Array('<fmt:message key="rtiApplication.manage.label.mobileNumber"/>'))){		
							//if(isValidEmail(new Array('email'),new Array('<fmt:message key="rtiApplication.manage.label.email"/>'))){		
							//if(isValidDate(new Array('createdDate'),new Array('<fmt:message key="rtiApplication.manage.label.createdDate"/>'))){		
										navigate(frm,'<c:out value="${contextRoot}"/>/rtiapplication/saveRTIApplication.do');	
									}
								//}.
							//}
						}
					}
				}
			}
		} 
	}


function deleteRTIApplication(id)
{
	if(confirmDelete()){
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/deleteRTIApplication.do');
	}
}

function setInputControls()
{
	// Setting the Gender value
	<c:if test="${rtiApplication.gender == pageScope.RADIO_MALE}">
		document.getElementById('gender<c:out value="${pageScope.LABEL_RADIO_MALE}"/>').checked="checked";
	</c:if>
	<c:if test="${rtiApplication.gender == pageScope.RADIO_FEMALE}">
		document.getElementById('gender<c:out value="${pageScope.LABEL_RADIO_FEMALE}"/>').checked="checked";
	</c:if>

}

setInputControls();
</script>
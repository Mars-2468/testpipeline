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


pageContext.setAttribute("APPL_STATUS_NEW",CoreConstants.APPL_STATUS_NEW);
pageContext.setAttribute("APPL_ACCEPT_LEVEL",CoreConstants.APPL_ACCEPT_LEVEL);
pageContext.setAttribute("APPL_VERIFICATION_LEVEL",CoreConstants.APPL_VERIFICATION_LEVEL);
pageContext.setAttribute("APPL_APPROVAL_LEVEL",CoreConstants.APPL_APPROVAL_LEVEL);
pageContext.setAttribute("APPL_CLOSE_LEVEL",CoreConstants.APPL_CLOSE_LEVEL);

pageContext.setAttribute("PAY_MODE_LIST",CommonUtils.getPaymentModes());
pageContext.setAttribute("CASH_LABEL",CoreConstants.CASH_LABEL);
pageContext.setAttribute("CHEQUE_LABEL",CoreConstants.CHEQUE_LABEL);
pageContext.setAttribute("DEMAND_DRAFT_LABEL",CoreConstants.DEMAND_DRAFT_LABEL);
pageContext.setAttribute("RTGS_LABEL",CoreConstants.RTGS_LABEL);
pageContext.setAttribute("CHALLAN_LABEL",CoreConstants.CHALLAN_LABEL);

pageContext.setAttribute("APPL_STATUS_DISCARDED",CoreConstants.APPL_STATUS_DISCARDED);

%>
 <script>

 function getFeeDetails(){
 	var createdDate = document.getElementById("registrationDate").value;
 	var numberOfCopies =document.getElementById("numberOfCopies").value;
 	
 	var feeCategory;
 	if(document.getElementById("bpl").checked==true){
 		 feeCategory=1;
 	}else{
 		 feeCategory=0;
 	}
 	
 	
 	if(createdDate.length > 0 )
 	{
 		getFeeAmount(createdDate,numberOfCopies,feeCategory);
 	}
 }
 function getFeeAmount(createdDate,numberOfCopies,feeCategory){
 	if (createdDate != null ){
 		CommonServiceDWR.getCertificateFeeAmount(createdDate,numberOfCopies,feeCategory,setFeeAmountList);
 	}
 }

 function setFeeAmountList(data)
 {//alert(123);
 	if(data.feeMasterId !=0){ 		
 		if(document.getElementById("numberOfCopies").value<=data.maxNoOfCopy){
 			
 			document.getElementById("feeMasterId").value=data.feeMasterId; 
 			document.getElementById("applicationCost").value=data.amount;
 			document.getElementById("amountPerCopy").value=data.amountPerCopy;
 			document.getElementById("postalCharges").value=data.postalCharges;
 			document.getElementById("amountOfAllCopies").value=(data.amount+data.postalCharges+(data.amountPerCopy)*document.getElementById("numberOfCopies").value);			
 			
 		}else{
 			document.getElementById("feeMasterId").value='';
 			document.getElementById("amountOfAllCopies").value=0.0;
 			document.getElementById("applicationCost").value=0.0;
 			document.getElementById("amountPerCopy").value=0.0;
 			document.getElementById("postalCharges").value=0.0;
 			displayError("Number of copies should be less than or equal to "+data.maxNoOfCopy);
 		}
 	}else{
 		document.getElementById("feeMasterId").value='';
 		document.getElementById("amountOfAllCopies").value=0.0;
 		document.getElementById("applicationCost").value=0.0;
 		document.getElementById("amountPerCopy").value=0.0;
 		document.getElementById("postalCharges").value=0.0;
 		displayError("Fee Details could not be fetched for selected dates. Make sure that Fee Master is defined properly.");
 	}
 }
 
 window.onload = showOrHideCardNumber;

 function showOrHideCardNumber(){
 	
 	if(document.getElementById("bpl").checked==true){
 		document.getElementById("bplCardNumber").style.display="";
 	}else{
 		document.getElementById("bplCardNumber").style.display="none";
 	}
 	
 }

 </script>
 


<script>
//alert('${requestScope.workFlowTask.name}');

	function editRtiApplicationAccept(id) { 
		document.getElementById('manageRTIApplicationAppealId').value = id;
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationVerification/editRTIApplicationAction.do');
	}

	function editRtiApplicationVerification(id) {
		//alert(id);
		document.getElementById('manageRTIApplicationAppealId').value=id;
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationVerification/editRTIApplicationAction.do');
	}
	
	function editRtiApplicationApproval(id) {
		//alert(id+' --- ');
		document.getElementById('manageRTIApplicationAppealId').value=id;
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationVerification/editRTIApplicationAction.do');
	}	
	
	function editRtiApplicationClose(id) {
		//alert(id+' --- ');
		document.getElementById('manageRTIApplicationAppealId').value=id;
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationVerification/editRTIApplicationAction.do');
	}
	
	function sendEmail(id)
	{
		document.getElementById('manageRTIApplicationAppealId').value=id;
		document.getElementById('actionTaken').value='email'; 
		onPageSubmit('<c:out value="${contextRoot}"/>/emailsms/emailSMS.do');
	}
	
	function sendSMS(id)
	{
		document.getElementById('manageRTIApplicationAppealId').value=id;
		document.getElementById('actionTaken').value='sms';
		onPageSubmit('<c:out value="${contextRoot}"/>/emailsms/emailSMS.do'); 
	}
		
	function createLetter(id){
		document.getElementById('manageRTIApplicationId').value=id;
		onPageSubmit('<c:out value="${contextRoot}"/>/draft/editDraft.do');
	}
	
	function activateParkedRTIApplication(id){
		document.getElementById('manageRTIApplicationAppealId').value=id;
		document.getElementById('actionTaken').value='unPark';
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editRTIApplicationPark.do');
	}
	
	function parkRTIApplication(id){
		document.getElementById('manageRTIApplicationAppealId').value=id;
		document.getElementById('actionTaken').value='park';
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editRTIApplicationPark.do');
	}
	
	
</script>
<input type="hidden" id="manageRTIApplicationId" name="manageRTIApplicationId" value="${rtiApplication.rtiApplicationId}" />
<input type="hidden" id="actionTaken" name="actionTaken"/> 

<spring:bind path="rtiApplication.rtiApplicationId">
	<input type="hidden" id="rtiApplicationId" name="rtiApplicationId" value="<c:out value="${rtiApplication.rtiApplicationId}"/>" />
</spring:bind>
<spring:bind path="rtiApplication.createdDate">
	<input type="hidden" id="createdDate" name="createdDate" value="<c:out value="${rtiApplication.createdDate}"/>" />
</spring:bind>
 
  <c:if test="${ empty rtiApplication.isApplicationParked || rtiApplication.isApplicationParked == 0 }">
  
		<c:if test="${IS_MY_TASK eq true && requestScope.workFlowTask.name eq pageScope.APPL_ACCEPT_LEVEL}">
			<script>
				editRtiApplicationAccept('${rtiApplication.rtiApplicationId}');  
			</script>
		</c:if>
		<c:if test="${IS_MY_TASK eq true && requestScope.workFlowTask.name eq pageScope.APPL_VERIFICATION_LEVEL}">
			<script>
			    editRtiApplicationVerification('${rtiApplication.rtiApplicationId}');  
			</script>
		</c:if>
		<c:if test="${IS_MY_TASK eq true && requestScope.workFlowTask.name eq pageScope.APPL_APPROVAL_LEVEL}">
			<script>
				editRtiApplicationApproval('${rtiApplication.rtiApplicationId}');  
			</script>
		</c:if>
		<c:if test="${IS_MY_TASK eq true && requestScope.workFlowTask.name eq pageScope.APPL_CLOSE_LEVEL}">
			<script>
				editRtiApplicationClose('${rtiApplication.rtiApplicationId}');  
			</script>
		</c:if>
   </c:if>
	<c:if test="${sessionScope.park eq 'unPark'}">
		<script>
			activateParkedRTIApplication('${rtiApplication.rtiApplicationId}')
		</script>
	</c:if>	 
 
<div class="mainHdr">
	<h3> 
		<c:choose>
			<c:when test="${rtiApplication.rtiApplicationId==0}">
				<fmt:message key="rtiApplication.manage.pagetitle.new"/>
			</c:when>
			<c:otherwise>	
				<fmt:message key="rtiapplication.manage.pagetitle.edit"/> 
				<c:if test="${rtiApplication.isApplicationParked eq 1 }">
					- Application Is Parked
  				</c:if>
			</c:otherwise>
		</c:choose> 
	</h3>
</div>
<div id="actionMenuId" style="background-color: #ffffff">		 
			<c:if test="${rtiApplication.rtiApplicationId!=0}">					
				<button type="button" class="btn btn-primary btn-xs" onclick="sendEmail('${rtiApplication.rtiApplicationId}')"  >Send eMail</button>
				<button type="button" class="btn btn-primary btn-xs" onclick="sendSMS('${rtiApplication.rtiApplicationId}')" >Send SMS</button>
				<button type="button" class="btn btn-primary btn-xs" onclick="createLetter('${rtiApplication.rtiApplicationId}')"  >Create Draft</button>
				
				<c:if test="${rtiApplication.finalStatus ne  'Closed' && rtiApplication.finalStatus ne pageScope.APPL_STATUS_DISCARDED}">
					 <c:choose>
						<c:when test="${not empty rtiApplication.isApplicationParked &&  rtiApplication.isApplicationParked == 1}">
							<button type="button" class="btn btn-primary btn-xs" onclick="activateParkedRTIApplication('${rtiApplication.rtiApplicationId}')"  >Activate  Application</button>	
						</c:when>
						<c:otherwise>
							<button type="button" class="btn btn-primary btn-xs" onclick="parkRTIApplication('${rtiApplication.rtiApplicationId}')"  >Park Application</button>						
						</c:otherwise>
					</c:choose>		 			
				</c:if>
				
				<%-- 	<button type="button" class="btn btn-primary btn-xs"  onclick="generateDraft('${rtiApplication.rtiApplicationId}')"  >Create Draft</button> 
			  	<c:if test="${fileCreation.finalStatus eq pageScope.APPL_STATUS_CLOSED}">
					<button type="button" class="btn btn-primary btn-xs" onclick="dispatch('${rtiApplication.rtiApplicationId}')"  >Dispatch</button> 
				</c:if> --%>
				
				<hr>
						 
			</c:if>			 
</div>

<div valign="top" id="SetFormHeight">
<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
	<tr>
		<td colspan="2">
			
		</td>
	</tr>
		 
	
	<c:if test="${rtiApplicationAppeal.rtiApplication.rtiApplicationId!=0}"> 
			<input type="hidden" readonly="readonly"  id="rtiApplicationId"   
				name="rtiApplicationId" value="<c:out value="${rtiApplicationAppeal.rtiApplication.rtiApplicationId}"/>" />				 
	</c:if> 
	 
	<tr>
		<td>
			<span class="ClsLabel"> RTI Application Reference No.</span></td>
		<td>
		   <c:choose>
		    <c:when test="${not empty rtiApplicationAppeal.rtiApplicationRefNo}">
		    	<spring:bind path="rtiApplicationAppeal.rtiApplicationRefNo">
					 <input type="text" class="ClsTextbox" readonly="readonly" id="rtiApplicationRefNo"  name="rtiApplicationRefNo" value="${rtiApplicationAppeal.rtiApplicationRefNo}" />
				</spring:bind>
		    </c:when>
		    <c:otherwise>
		    	<spring:bind path="rtiApplicationAppeal.rtiApplicationRefNo">
				 	 <input type="text" class="ClsTextbox"  id="rtiApplicationRefNo"  name="rtiApplicationRefNo" value="${rtiApplicationAppeal.rtiApplicationRefNo}" />
				</spring:bind>
		    </c:otherwise>
		   </c:choose>
			
		</td>
		
		<td >
			<span class="ClsLabel"> Related Inward Number </span><span class="ClsRequiredFields">*</span></td>
		<td>
			<spring:bind path="rtiApplicationAppeal.inWardNumber">
			  	<input type="text" class="ClsTextbox"  id="inWardNumber" name="inWardNumber" value="${rtiApplicationAppeal.inWardNumber}" />
			 </spring:bind>
		</td>		
	</tr>
	 
	<tr>		
		<td>
			<span class="ClsLabel"> Received Date </span><span class="ClsRequiredFields">*</span></td>
		<td>
			<spring:bind path="rtiApplication.receivedDate">
				<input type="text" class="ClsTextboxDate" readonly="readonly"  id="receivedDate" name="receivedDate"  value="${rtiApplication.receivedDate}" />
			</spring:bind>
		</td>	
		
		<td >
			<span class="ClsLabel">System Entry Date</span><span class="ClsRequiredFields">*</span></td>
		<td>
			<spring:bind path="rtiApplicationAppeal.registrationDate">
				 <input type="text" class="ClsTextboxDate" readonly="readonly"  id="registrationDate" name="registrationDate" onchange="javascript:getFeeDetails();"  value="${rtiApplicationAppeal.registrationDate}"  />
			</spring:bind>
		</td>
	</tr> 
	
	<tr>
		<td >
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.department"/></span><span class="ClsRequiredFields">*</span></td>
		<td>
			<input type="text"   class="ClsTextboxDate" readonly="readonly"  id="departmentName" name="departmentName"   />
			<%-- <select name="applicationDepartmentId" id="applicationDepartmentId" class="ClsTextbox"  style="width:300px">
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
			</select> --%>
		</td>
		<td >
			<span class="ClsLabel"> Receiving Mode</span><span class="ClsRequiredFields">*</span></td>
		<td> 
				<select class="ClsSelect" name="receivedModeId" id="receivedModeId" >
					<option value=""><--- Select ---></option>
						<c:forEach var="receivedMode" items="${requestScope.receivedModeList}">
							<c:choose>
								<c:when
									test="${rtiApplication.receivedMode.receivedModeId==receivedMode.receivedModeId}">
									<option value="${receivedMode.receivedModeId}" selected="selected">
										<c:out value="${receivedMode.receivedModeName}" /></option>
								</c:when>
								<c:otherwise>
									<option value="${receivedMode.receivedModeId}">${receivedMode.receivedModeName}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select> 
		</td>
	</tr> 
	<tr>
		<td>
			<span class="ClsLabel">Subject of Application</span><span class="ClsRequiredFields">*</span></td>
		<td>
			<spring:bind path="rtiApplicationAppeal.subject">
				<textarea class="ClsTextbox" id="subject"   cols="40" rows="4" name="subject"><c:out value="${rtiApplicationAppeal.subject}" /></textarea>
			</spring:bind>
		</td>
		<td>
			<span class="ClsLabel">Specific Details of Information Required</span><span class="ClsRequiredFields">*</span></td>
		<td>
			<spring:bind path="rtiApplicationAppeal.informationRequired">
				<textarea class="ClsTextbox" id="informationRequired"   cols="40" rows="4" name="informationRequired"> <c:out value="${rtiApplicationAppeal.informationRequired}" /></textarea>
			</spring:bind>
		</td>
	</tr>
	
	
	
	
	
	
	<tr>
		<td colspan="4" class="ClsTitle">
			<br/>
			  Applicant  Details
			<hr/>
		</td>
	</tr> 
	
	<tr>
		<td >
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.name"/></span><span class="ClsRequiredFields">*</span>
		</td>
		<td> 
			<input type="text" readonly="readonly" class="ClsTextbox" id="applicantName" maxlength="45"   value="${rtiApplicationAppeal.rtiApplication.addressLine1}" name="applicantName"  /> 
		</td>
		<td >
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.gender" />:</span>
		</td>
		<td >
		 	<input type="text" readonly="readonly" class="ClsTextbox" id="gender" maxlength="45"   name="gender"  /> 
		</td>
	</tr>
	<tr>
		<td>
			<span class="ClsLabel">BPL(Below Poverty Line)</span><span class="ClsRequiredFields">*</span>
		</td>
		<td colspan="3">			
			 <input type="text" readonly="readonly" class="ClsTextbox" id="bplNumber" maxlength="45"   name="gender"  /> 
		</td>		 
	</tr>
	 
		
	<tr>
		<td>
			<span class="ClsLabel">Address Line 1</span></td>
		<td> 
			 <input  type="text" class="ClsTextbox" id="addressLine1" readonly="readonly"  name="addressLine1" value="${rtiApplicationAppeal.rtiApplication.addressLine1}">			 
		</td>
		<td>
			<span class="ClsLabel">Address Line 2</span></td>
		<td> 
			<input  type="text" class="ClsTextbox" id="addressLine2"  readonly="readonly"  name="addressLine2" value="${rtiApplicationAppeal.rtiApplication.addressLine2}">			 
		</td>
	</tr>
	
	
	<tr>
	
		<td >
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.state"/></span><span class="ClsRequiredFields">*</span>
		</td>
		<td> 
			<input type="text" class="ClsTextbox" id="state"  name="state"  readonly="readonly" style="width:300px" value="<c:out value="${rtiApplicationAppeal.rtiApplication.state}"/>" />
			 </td>
	    <td >
			<span class="ClsLabel">District</span><span class="ClsRequiredFields">*</span>
		</td>
		<td> 
			<input type="text" class="ClsTextbox" id="district" readonly="readonly" name="district"     value="${rtiApplicationAppeal.rtiApplication.district}" /> 
		</td>
		
	</tr>
	
	<tr>
	
		<td >
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.pincode"/></span><span class="ClsRequiredFields">*</span>
		</td>
		<td> 
			<input type="text" class="ClsTextbox" id="pincode"  name="pincode"  readonly="readonly"   value="${rtiApplicationAppeal.rtiApplication.pincode}" /> 
		</td>
	    <td >
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.phoneNumber"/></span> 
		</td>
		<td> 
			<input type="text" class="ClsTextbox" id="phoneNumber"   name="phoneNumber"  value="${rtiApplicationAppeal.rtiApplication.phoneNumber}" /> 
		</td>
		
	</tr>
  
	
	<tr>
		<td >
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.mobileNumber"/></span><span class="ClsRequiredFields">*</span>
		</td>
		<td> 
			<input type="text" class="ClsTextbox" id="mobileNumber"  name="mobileNumber"  value="${rtiApplicationAppeal.rtiApplication.mobileNumber}" /> 
		</td>
		<td >
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.email"/></span><span class="ClsRequiredFields">*</span>
		</td>
		<td> 
			<input type="text" class="ClsTextbox" id="email" name="email"  value="${rtiApplicationAppeal.rtiApplication.email}" /> 
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
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.numberOfCopies"/></span><span class="ClsRequiredFields">*</span>
		</td>
		<td>
			<spring:bind path="rtiApplicationAppeal.numberOfCopies">
				<input type="text" class="ClsTextbox"  id="numberOfCopies" name="numberOfCopies" maxlength="10" onblur="javascript:getFeeDetails();"  
				 value="${rtiApplicationAppeal.numberOfCopies}"  />
			</spring:bind>
		</td>
		<td>
			<span class="ClsLabel">Amount Per Copy</span></td>
		<td>
			 <spring:bind path="rtiApplicationAppeal..amountPerCopy">
				<input type="text" class="ClsTextbox" id="amountPerCopy" name="amountPerCopy" maxlength="2"  readonly="readonly"  value="${rtiApplicationAppeal..amountPerCopy}"  />
			</spring:bind>
		</td>
	</tr> 
	
	<tr>		
		<td>
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.costOfAppln"/></span></td>
		<td>		    
			<spring:bind path="rtiApplicationAppeal..applicationCost">
				<input type="text" class="ClsTextbox" id="applicationCost" name="applicationCost" maxlength="16" readonly="readonly" style="border:none;" 
				 value="<c:out value="${rtiApplicationAppeal..applicationCost}"/>" />
			</spring:bind>
			<%-- <input type="hidden"  id="feeMasterId" name="feeMasterId"  readonly="readonly"  value="${rtiApplication.feeMaster.feeMasterId}" /> --%>
		</td>
		<td>
			<span class="ClsLabel">Postal Charges  </span></td>
		<td>
			 <spring:bind path="rtiApplicationAppeal..postalCharges">
				<input type="text" class="ClsTextbox" id="postalCharges" name="postalCharges"" maxlength="16" readonly="readonly" style="border:none;" 
				 value="${rtiApplicationAppeal.postalCharges}" />
			 </spring:bind>
		</td>		
	</tr>
	<tr>	 
		<td>
			<span class="ClsLabel">Total <fmt:message key="rtiApplication.manage.label.amount"/></span></td>
		<td>
			 
			<input type="text" class="ClsTextbox" id="amountOfAllCopies" name="amountOfAllCopies" maxlength="16" readonly="readonly" style="border:none;" 
			 value="${totalAmount}" />
			 
		</td>		
	</tr>
	<tr> 
		<td>
			<span class="ClsLabel">Fee Paid</span></td>
		<td> 
			 	<input type="checkbox" id="iSFeePaidVal"  name="iSFeePaidVal"  <c:if test="${rtiApplicationAppeal.iSFeePaid == 1}">checked="checked"</c:if> onclick="showPayMode()" /> 
 		</td>
 		
 		<td>
			<div class="ClsLabel" id="payModeLabel">Select Paymnet Mode</div></td>
		<td>  
			<div id="payModeLabelVal">
				<select id="paymentMode" name="paymentMode" style="width:150px;" onchange="enablePaymentDetails();">			
					<option value=""> <-- Select -->  </option>			
				    <c:forEach var="paymentMode" items="${pageScope.PAY_MODE_LIST}" varStatus="paymentModeIndex">
				               <option value="${paymentMode}" <c:if test="${rtiApplication.collection.paymentMode==paymentMode}">selected="selected"</c:if>>
				                    ${paymentMode} 
				               </option>
					</c:forEach>				
				</select> 
			</div>
 		</td>
	</tr>
	
	<tr> 
		<td colspan="4">
			<div id="payModeDetails">
				<input type="hidden"  id="collectionId"  readonly="readonly"  name="collectionId" value="${rtiApplicationAppeal.collection.collectionId}" />
				<table  cellpadding="2" cellspacing="2" width="100%" class="dataForm" > 
					<tr>
						<td><span class="ClsLabel" >Receipt Number</span></td>	
						<td>
							<input type="text" class="ClsTextbox" id="receiptNumber"  maxlength="15"    name="receiptNumber" value="${rtiApplicationAppeal.collection.receiptNumber}" />	
						</td>
						<td><span class="ClsLabel" >Receipt Date</span></td>	
						<td> <input type="text" class="ClsTextboxDate" id="receiptDate"  maxlength="10" readonly="readonly" name="receiptDate" value="${rtiApplicationAppeal.collection.receiptDate}" />	 </td>	 
					</tr>
					<tr id="chequeDetails">
						<td><span class="ClsLabel" id="chqDD_No_lbl">Cheque Number</span><span class="ClsRequiredFields">*</span></td>	
						<td>
							<input type="text" class="ClsTextbox" id="chequeDDRTGSNumber"   name="chequeDDRTGSNumber" value="${rtiApplicationAppeal.collection.chequeDDRTGSNumber}" />	
						</td>					
						<td><span class="ClsLabel" id="chqDD_Date_lbl">Cheque Date</span><span class="ClsRequiredFields">*</span></td> 
						 <td>
							<input type="text" class="ClsTextboxDate" id="chequeDDRTGSDate"  maxlength="10" readonly="readonly" name="chequeDDRTGSDate" value="${rtiApplicationAppeal.collection.chequeDDRTGSDate}" />
						</td>
					</tr>
					<tr id="bankDetails"> 
						<td><span class="ClsLabel">Bank Name<span class="ClsRequiredFields">*</span></span></td>
						<td>
							<input type="text" class="ClsTextbox"  name="bankName" id="bankName" maxlength="50"  value="${rtiApplicationAppeal.collection.bankName}" />
						</td>
						<td><span class="ClsLabel">Branch Name<span class="ClsRequiredFields">*</span></span></td>	
						<td>
							<input type="text" class="ClsTextbox"  name="branchName" maxlength="50"  id="branchName"  value="${rtiApplicationAppeal.collection.branchName}" />
						</td>
					</tr>
					<tr> 
						<td><span class="ClsLabel"  id="chqDD_Amount_lbl">Amount<span class="ClsRequiredFields">*</span></span></td>
						<td colspan="3">
							<input type="text" class="ClsTextbox"  name="amountPaid" id="amountPaid" maxlength="5"  value="${rtiApplicationAppeal.collection.amountPaid}" />
						</td>						
					</tr>
				</table>
			</div>			
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
			<%-- <c:if test="${rtiApplication.rtiApplicationId!=0}">
				<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deleteRTIApplication(this.form);">
			</c:if> --%>
		</td>
		
	</tr>
	</table>

	 
	
	 <div id="isParked">
		<c:if test="${not empty rtiApplicationAppeal && rtiApplicationAppeal.rtiApplicationAppealId != 0 && not empty rtiApplicationAppeal.rtiApplicationDetails }">			 
			<%@include file="/pages/core-pages/rtiapplication/listRTIApplicationVerificationDetails.jsp"%>	 
		</c:if>
			<br/>
		<c:if test="${not empty rtiApplicationAppeal && rtiApplicationAppeal.rtiApplicationAppealId != 0 }">
			<%@include file="/pages/common-pages/dms/manageDmsAttachments.jsp"%>
		</c:if> 
		<c:if test="${not empty rtiApplicationAppeal && rtiApplicationAppeal.rtiApplicationAppealId != 0  }"> 
			<%@include file="/pages/workflow/taskIncludeRTIApplicationAction.jsp"%>
		</c:if>
	</div>
	 
	 <input  type="hidden" id="isAssignedToOther" name="isAssignedToOther" value="0" >
	 
</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/>
<input type="hidden" id="feeMasterId" name="feeMasterId" value="<c:out value="${rtiApplicationAppeal.feeMaster.feeMasterId}"/>" />
 
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/>
<input type="hidden" id="tenancyId" name="tenancyId" value="${rtiApplicationAppeal.tenancy.tenancyId}"  />


<input type="hidden" name="isAccepted" id="isAccepted" value="False">
<input type="hidden" id="uuid" name="uuid" value="" />

<input type="hidden"
	name="<c:out value="${pageScope.WORKFLOW_TRANSISTION}"/>"
	id="<c:out value="${pageScope.WORKFLOW_TRANSISTION}"/>" value="citizen" />
<input type="hidden"
	name="<c:out value="${pageScope.WORKFLOW_COMMENTS}"/>"
	id="<c:out value="${pageScope.WORKFLOW_COMMENTS}"/>"
	value="created by citizen" />

<input type="hidden"
	name="<c:out value="${pageScope.WORKFLOW_ACTION}"/>"
	id="<c:out value="${pageScope.WORKFLOW_ACTION}"/>" value="" />

<%-- <input type="hidden"
	name="<c:out value="${pageScope.WORKFLOW_DUE_DATE}"/>"
	id="<c:out value="${pageScope.WORKFLOW_DUE_DATE}"/>" value="${workflowDueDate}" /> --%>		

<input type="hidden" name="<c:out value="${pageScope.WORKFLOW_NAME}"/>"
	id="<c:out value="${pageScope.WORKFLOW_NAME}"/>"
	value="<c:out value="${requestScope.WORKFLOW_NAME}"/>" />

<input type="hidden"
	name="<c:out value="${pageScope.WORKFLOW_ENTITYNAME}"/>"
	id="<c:out value="${pageScope.WORKFLOW_ENTITYNAME}"/>"
	value="<c:out value="${requestScope.WORKFLOW_ENTITYNAME}"/>" />

<input type="hidden"
	name="<c:out value="${pageScope.WORKFLOW_ENTITYID}"/>"
	id="<c:out value="${pageScope.WORKFLOW_ENTITYID}"/>"
	value="<c:out value="${requestScope.WORKFLOW_ENTITYID}"/>" />

<input type="hidden"
	name="<c:out value="${pageScope.WORKFLOW_JOB_ID}" />"
	id="<c:out value="${pageScope.WORKFLOW_JOB_ID}"/>"
	value="<c:out value="${requestScope.WORKFLOW_JOB_ID}"/>" />

<input type="hidden"
	name="<c:out value="${pageScope.WORKFLOW_TASK_ID}"/>"
	id="<c:out value="${pageScope.WORKFLOW_TASK_ID}"/>"
	value="<c:out value="${requestScope.WORKFLOW_TASK_ID}"/>" />



<c:if test="${(not empty rtiApplicationAppeal.isApplicationParked && rtiApplicationAppeal.isApplicationParked == 1 ) || (rtiApplicationAppeal.finalStatus eq pageScope.APPL_STATUS_DISCARDED) }">
	<script>
		disableControlsByJquery(true);  
		 $('#SetFormHeight *').attr('disabled', true);
		 $("#isParked").children().prop('disabled', true);
		 $("#SetFormHeight").children().prop('disabled', true);
		  
		 
		$('.mainHdr a').attr("onclick","javascript:void(0)");
		<c:forEach var="taskTransitionName" items="${WORKFLOW_TRANSISTIONS}" varStatus="iCount">
			document.getElementById('workflow_tras_${taskTransitionName}').setAttribute("onclick","javascript:void(0);");
			document.getElementById('workflow_tras_${taskTransitionName}').removeAttribute("style");
		</c:forEach>
		//Disable the Discard Workflow icon also if the task is not owned
		document.getElementById('KillWorkflow').setAttribute("onclick","javascript:void(0);");
		document.getElementById('KillWorkflow').removeAttribute("style");	 
	</script>
</c:if>

<script type="text/javascript">

function saveEntity()
{
	saveRTIApplication(document.forms[0]);
}

function saveRTIApplication(frm)
{
	
	//navigate(frm,'<c:out value="${contextRoot}"/>/rtiapplication/saveRTIApplication.do');
	 var arrRequiredElements=new Array('inWardNumber','registrationDate','applicationDepartmentId','receivedModeId','receivedDate','subject','informationRequired','applicantName','state','district','pincode','mobileNumber','email','numberOfCopies');
		var arrRequiredElementsMessages=new Array('Related InWard Number',
				'Registration Date',
				'<fmt:message key="rtiApplication.manage.label.department"/>',
				'Received Mode',
				'Received Date',
				'Subject of Application',
				'Specific Details of Information Required',
				'<fmt:message key="rtiApplication.manage.label.name"/>',
				'<fmt:message key="rtiApplication.manage.label.state"/>',
				'District',
				'<fmt:message key="rtiApplication.manage.label.pincode"/>',
				'<fmt:message key="rtiApplication.manage.label.mobileNumber"/>',
				'<fmt:message key="rtiApplication.manage.label.email"/>',
				'<fmt:message key="rtiApplication.manage.label.numberOfCopies"/>');
		if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages)){
			if(isAlphaSpace(new Array('applicantName'),new Array('<fmt:message key="rtiApplication.manage.label.name"/>'))){		
				if(checkChildNumericDetailed(new Array('pincode'),new Array('<fmt:message key="rtiApplication.manage.label.pincode"/>'))){		
					if(isAlphaSpace(new Array('state'),new Array('<fmt:message key="rtiApplication.manage.label.state"/>'))){	
						if(isAlphaSpace(new Array('district'),new Array('District'))){	
						//if(checkChildNumericDetailed(new Array('phoneNumber'),new Array('<fmt:message key="rtiApplication.manage.label.phoneNumber"/>'))){		
							if(checkChildNumericDetailed(new Array('mobileNumber'),new Array('<fmt:message key="rtiApplication.manage.label.mobileNumber"/>'))){		
								//if(isValidEmail(new Array('email'),new Array('<fmt:message key="rtiApplication.manage.label.email"/>'))){		
								//if(isValidDate(new Array('registrationDate'),new Array('Registration Date'))){		
									
									if(document.getElementById("bpl").checked==true){										
										if(checkMandatoryDetailed(new Array('bplCardNumber'),new Array('BPL Card Number'))){
											if(validateFeePaid()){
												//navigate(frm,'<c:out value="${contextRoot}"/>/rtiapplication/saveRTIApplication.do');
											}
										}
									}else{										
										if(validateFeePaid()){
											///navigate(frm,'<c:out value="${contextRoot}"/>/rtiapplication/saveRTIApplication.do')
										}									
									}
										
									
							//}
						}
					}
				}
			} 
					}
				}

 }

 

function showPayMode(){
	if(document.getElementById("iSFeePaidVal").checked==true){
		$('#payModeLabel').show();
		$('#payModeLabelVal').show();
		$('#payModeDetails').show();
 	}else{
 		$('#payModeLabel').hide();
 		$('#payModeLabelVal').hide();
 		$('#payModeDetails').hide();
 	}	 
}

function validateFeePaid()
{
	var isFeePaid = document.getElementById("iSFeePaidVal");
	if(isFeePaid.checked==true){
		 var paymentMode = document.getElementById("paymentMode").value;
		 if(paymentMode == ''){
			 displayError("Please Select Paymnet Mode");
			 return false;
		 }
		 if(paymentMode == '${pageScope.CASH_LABEL}'){
			
		 }else {
			 
			var  chequeDDRTGSNumber = document.getElementById("chequeDDRTGSNumber").value;
			var chequeDDRTGSDate = document.getElementById("chequeDDRTGSDate").value;
			var bankName = document.getElementById("bankName").value;
			var branchName = document.getElementById("branchName").value;
			var amountPaid =  document.getElementById("amountPaid").value;
			 if(paymentMode== '${pageScope.CHEQUE_LABEL}' || paymentMode== '${pageScope.DEMAND_DRAFT_LABEL}' || paymentMode== '${pageScope.CHALLAN_LABEL}'){  
					
			 	if(paymentMode==   '${pageScope.CHEQUE_LABEL}'){
					if(chequeDDRTGSNumber == ''){
						displayError("Please Enter Cheque Number.");
						return false;
					}else if(chequeDDRTGSNumber.length != 6){
						displayError("Cheque Number Should be 6 digit ");
						return false;
					}
					else if(chequeDDRTGSDate == '' ){
						displayError("Please Enter Cheque Date ");
						return false;
					}else if(bankName == '' ){
						displayError("Please Enter Bank Name ");
						return false;
					}else if(branchName == '' ){
						displayError("Please Enter Branch Name ");
						return false;
					} else if(amountPaid == '' ){
						displayError("Please Cheque Amount ");
						return false;
					}				
				}else if(paymentMode==   '${pageScope.CHALLAN_LABEL}'){
					if(chequeDDRTGSNumber == ''){
						displayError("Please Enter Challan Number.");
						return false;
					} 
					else if(chequeDDRTGSDate == '' ){
						displayError("Please Enter Challan Date ");
						return false;
					}else if(bankName == '' ){
						displayError("Please Enter Bank Name ");
						return false;
					}else if(branchName == '' ){
						displayError("Please Enter Branch Name ");
						return false;
					}else if(amountPaid == '' ){
						displayError("Please Challan Amount ");
						return false;
					}	
				}else{ 
					if(chequeDDRTGSNumber == ''){
						displayError("Please Enter DD Number.");
						return false;
					} else if(chequeDDRTGSDate == '' ){
						displayError("Please Enter DD Date ");
						return false;
					}else if(bankName == '' ){
						displayError("Please Enter Bank Name ");
						return false;
					}else if(branchName == '' ){
						displayError("Please Enter Branch Name ");
						return false;
					}else if(amountPaid == '' ){
						displayError("Please DD Amount ");
						return false;
					}						
				}						
			 }else if(paymentMode== '${pageScope.RTGS_LABEL}'){   
				 if(chequeDDRTGSNumber == ''){
						displayError("Please Enter RTGS  Number.");
						return false;
					} else if(chequeDDRTGSDate == '' ){
						displayError("Please Enter RTGS Date ");
						return false;
					}else if(bankName == '' ){
						displayError("Please Enter Bank Name ");
						return false;
					}else if(amountPaid == '' ){
						displayError("Please RTGS Amount ");
						return false;
					}	
			 }
		 }
	}	
	return true;
}
function enablePaymentDetails(){
 	var paymentMode = document.getElementById("paymentMode").value;	
	//$('#payModeLabel').hide();
	//$('#payModeLabelVal').hide();
	$('#payModeDetails').hide();		  	
	//document.getElementById("receiptNumber").value="";
	//document.getElementById("chequeDDRTGSNumber").value="";
	//document.getElementById("chequeDDRTGSDate").value="";
	//document.getElementById("bankName").value="";
	//document.getElementById("branchName").value=""; 
	
	if(paymentMode == '${pageScope.CASH_LABEL}'){
		$('#payModeDetails').show();	
		$('#chequeDetails').hide();	
		$('#bankDetails').hide();
		$('#chqDD_Amount_lbl').text('Paid Amount ');	
	}else{		
		
		if(paymentMode== '${pageScope.CHEQUE_LABEL}' || paymentMode== '${pageScope.DEMAND_DRAFT_LABEL}'){ 
			$('#payModeDetails').show();	
			$('#chequeDetails').show();	
			$('#bankDetails').show();
			
			if(paymentMode ==   '${pageScope.CHEQUE_LABEL}'){			
				$('#chqDD_No_lbl').text('Cheque Number ');
				$('#chqDD_Date_lbl').text('Cheque Date ');
				$('#chqDD_Amount_lbl').text('Cheque Amount ');				
			}else if(paymentMode == '${pageScope.CHALLAN_LABEL}'){
				$('#chqDD_No_lbl').text('Challan Number ');
				$('#chqDD_Date_lbl').text('Challan Date ');
				$('#chqDD_Amount_lbl').text('Challan Amount ');	
			}
			else{
				$('#chqDD_No_lbl').text('DD Number ');
				$('#chqDD_Date_lbl').text('DD Date ');
				$('#chqDD_Amount_lbl').text('DD Amount ');	
			}			
		}else if(paymentMode == '${pageScope.RTGS_LABEL}'){   
			$('#payModeDetails').show();	
			$('#chequeDetails').show();	
			$('#bankDetails').show();
			$('#chqDD_No_lbl').text('Transaction Number ');
			$('#chqDD_Date_lbl').text('Transaction Date ');
			$('#chqDD_Amount_lbl').text('RTGS Amount ');				
		}		
	} 		
}

setInputControls();
showPayMode();
enablePaymentDetails();
</script>
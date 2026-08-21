<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm" id="SearchTable" >
    <tr>
    <td colspan="4"><br></td>
    </tr>
    
    <tr class="ClsLabel">
		<td> Computer Number   </td>
		<td > ${rtiApplication.rtiApplicationId}   </td>
		<td > RTI Application Number </td>
		<td > ${rtiApplication.rtiApplnNumber} </td>
	</tr>
 	
	<tr>
		<td >
			<span class="ClsLabel"> Related InWard Number </span> </td>
		<td>${rtiApplication.inWardNumber}" </td>
		<td >
			<span class="ClsLabel">Registration Date</span><span class="ClsRequiredFields">*</span></td>
		<td> ${rtiApplication.registrationDate} </td>
	</tr> 
	
	<tr>
		<td >
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.department"/></span></td>
		<td>
			 ${rtiApplication.applicationDepartment.name}
		</td>
		<td >
			<span class="ClsLabel"> Receiving Mode</span><span class="ClsRequiredFields">*</span></td>
		<td>
			 rtiApplication.receivedMode.receivedModeName} 
		</td>
	</tr>
	<tr>
		<td >
			<span class="ClsLabel"> Received Date </span><span class="ClsRequiredFields">*</span></td>
		<td>
			 ${rtiApplication.receivedDate} 
		</td>
		<%-- <td >
			<span class="ClsLabel"> Received Reference No.</span></td>
		<td>
			 ${rtiApplication.receivedRefNo}
		</td> --%>
	</tr>
	<tr>
		<td>
			<span class="ClsLabel">Subject of Application</span><span class="ClsRequiredFields">*</span></td>
		<td>
			 ${rtiApplication.subject} 
		</td>
		<td>
			<span class="ClsLabel">Specific Details of Information Required</span><span class="ClsRequiredFields">*</span></td>
		<td>
			 ${rtiApplication.subject} 
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
			 ${rtiApplication.applicationCost} 
		</td>
		<td>
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.numberOfCopies"/></span><span class="ClsRequiredFields">*</span>
		</td>
		<td>
			 ${rtiApplication.numberOfCopies} 
		</td>
	</tr> 
	
	<tr>
		<td>
			<span class="ClsLabel">Amount Per Copy</span></td>
		<td>
			${rtiApplication.amountPerCopy}   
		</td>
		<td>
			<span class="ClsLabel">Amount Of All Copies</span></td>
		<td>
			 ${rtiApplication.amountPerCopy * rtiApplication.numberOfCopies}
		</td>
	</tr>
	
	<tr> 
		<td>
			<span class="ClsLabel">Is Application Fee Paid</span></td>
		<td>
			 <c:if test="${iSFeePaid == 1 }">
			 	Yes
			 </c:if>
			 <c:if test="${iSFeePaid == 0 }">
			 	No
			 </c:if>
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
		<td>
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.name"/></span><span class="ClsRequiredFields">*</span>
		</td>
		<td>
			 ${rtiApplication.applicantName} 
		</td>
		<td >
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.gender" />:</span>
		</td>
		<td >
			<c:if test="${rtiApplication.gender == 1} ">
				Male
			</c:if>
			 <c:if test="${rtiApplication.gender == 0} ">
				Female
			</c:if>
			
		</td>
	</tr>
	<tr>
		<td >
			<span class="ClsLabel">BPL(Below Poverty Line)</span><span class="ClsRequiredFields">*</span>
		</td>
		<td colspan="3">		   
		    <c:if test="${rtiApplication.bpl == 1 }">
				<span style="padding-left: 20px" >Yes</span>
			</c:if>
		</td>
			
		<c:if test="${rtiApplication.bpl == 1 }">
			<td >
				<span class="ClsLabel">BPL Card Number</span><span class="ClsRequiredFields">*</span>
			</td>
			<td colspan="3">
					<span style="padding-left: 20px" > ${rtiApplication.bplCardNumber}</span>			
			</td>
		</c:if>	
			 
	</tr>
	 
		
	<tr>
		<td>
			<span class="ClsLabel">Address Line 1</span></td>
		<td>
			 ${rtiApplication.addressLine1} 
		</td>
		<td>
			<span class="ClsLabel">Address Line 2</span></td>
		<td>
			 ${rtiApplication.addressLine2} 
		</td>
	</tr>
	
	
	<tr>
	
		<td >
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.state"/></span><span class="ClsRequiredFields">*</span>
		</td>
		<td> ${rtiApplication.state}
		</td>
	    <td >
			<span class="ClsLabel">District</span><span class="ClsRequiredFields">*</span>
		</td>
		<td>
			 ${rtiApplication.district} 
		</td>
		
	</tr>
	
	<tr>
	
		<td >
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.pincode"/></span><span class="ClsRequiredFields">*</span>
		</td>
		<td>
			 ${rtiApplication.pincode} 
		</td>
	    <td >
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.phoneNumber"/></span> 
		</td>
		<td>
			 ${rtiApplication.phoneNumber} 
		</td>
		
	</tr>
  
	
	<tr>
		<td >
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.mobileNumber"/></span><span class="ClsRequiredFields">*</span>
		</td>
		<td>
			 ${rtiApplication.mobileNumber}  
		</td>
		<td >
			<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.email"/></span><span class="ClsRequiredFields">*</span>
		</td>
		<td> ${rtiApplication.email} 
		</td>
	</tr>
	
    
			 
			 
</table>

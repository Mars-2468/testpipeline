<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.rti.utils.CoreConstants"%> 
<jsp:directive.include file="/pages/common/include.jsp" /> 
<%@include file="/pages/common/includeTransliterateJS.jsp"%>
<%@ taglib prefix="crt" uri="http://java.sun.com/jstl/core_rt" %>

 
<%
pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT); 
pageContext.setAttribute("SESSION_TOKEN_KEY",	Constants.SESSION_TOKEN_KEY);
pageContext.setAttribute("DELIVERY_MODE_FIELD_TEXT",	Constants.DELIVERY_MODE_FIELD_TEXT);
pageContext.setAttribute("DELIVERY_MODE_FIELD_TEXT_AREA",	Constants.DELIVERY_MODE_FIELD_TEXT_AREA);
pageContext.setAttribute("DELIVERY_MODE_DATA_TYPE_NUMBER",	Constants.DELIVERY_MODE_DATA_TYPE_NUMBER);


%>
  
  <!--   <meta charset="utf-8">   -->
    
    <link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/scripts/docs/css/site.css" > </link>  
    <link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/scripts/docs/richtext.min.css" ></link>   
	<script type="text/javascript" src="<c:out value="${contextRoot}"/>/scripts/docs/jquery.richtext.js"></script>    
     
    <script defer src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
 
 
<div class="mainHdr">
	<h3>
		Create Letter
	</h3>
</div> 
 
<div valign="top" id="SetFormHeight" style="height: 100%"> 
	<c:if test="${not empty draft && draft.draftId >0 }">
	<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
	 
		<tr>
			<!-- <td>
				 <span class="ClsLabel">				 	 
				 	 <input type="radio" id="generate" name="sentStatus" value="0" onclick="setSaveButton('0')"> Generate  
					 <input type="radio" id="sent" name="sentStatus" value="1" style="padding-left: 20px" onclick="setSaveButton('1')"> Generate and Sent					   
				 </span>
			</td> -->
			 
			<td><span class="ClsLabel">	  Draft Number: ${draft.draftNumber} </span> </td>	
			 		
		</tr>	
	</table>
	</c:if>	 
	<div id="generateAndSent" style="width: 100%">

		<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
		
		    <tr>	
				<td> <span class="ClsLabel">Draft Type</span> <span class="ClsRequiredFields">*</span> : 
				
					<select class="ClsSelect" name="draftType" id=draftType >
						<option value=""><--- Select ---></option> 
						<option value="1">Acknowledgement</option> 
						<option value="2">Info Letter</option> 	
						<option value="3">Final Dispatch</option> 																 
					</select>
					
					 <%-- <select class="ClsSelect" name="receivedModeId" id="receivedModeId" >
						<option value=""><--- Select ---></option>
							<c:forEach var="letterType" items="${requestScope.letterTypeList}">
								<c:choose>
									<c:when
										test="${rtiApplication.letterType.letterTypeId==letterType.letterTypeId}">
										<option value="${letterType.receivedModeId}" selected="selected">
											<c:out value="${letterType.letterName}" /></option>
									</c:when>
									<c:otherwise>
										<option value="${letterType.letterTypeId}">${letterType.letterName}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select>  --%>
				
				</td>			 			
			</tr> 
			
			<tr>	
				<td> <span class="ClsLabel">Select Draft/Letter Dispatch Mode</span> <span class="ClsRequiredFields">*</span> </td>			 			
			</tr> 
			<c:forEach items="${deliveryModeList}" var="draftMode" >
				<c:choose>
					<c:when test="${draftMode.deliveryModeName eq 'email' || draftMode.deliveryModeName eq 'E Mail' || draftMode.deliveryModeName eq 'E-Mail'  }">
						<tr>
							<td> 
								<span class="ClsLabel">
								    <input type="checkbox" id="email" name="email" value="email"  > E-Mail					
								</span>  
								<div style="width: 70%; float: right; display: none;" id="viewEmailMode"  >
									<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
										<tr>	 
											 <td width="16%"> <span class="ClsLabel">To</span> </td>
											 <td> 
												<input type="text" class="ClsTextboxEmail" id="to"  maxlength="100"   name="to" />	
											 </td>
										</tr>
										<tr>	 
											 <td width="16%"> <span class="ClsLabel">CC</span> </td>
											 <td> 
												<input type="text" class="ClsTextboxEmail" id="cc"  maxlength="100"   name="cc" />	
											 </td>
										</tr>
										<tr>	 
											 <td width="16%"> <span class="ClsLabel">Subject</span> </td>
											 <td> 
												<input type="text" class="ClsTextboxEmail" id="subject"  maxlength="150"   name="subject" />	
											 </td>
										</tr>
										<tr>	 
											 <td width="16%"> <span class="ClsLabel">Content</span> </td>
											 <td> 
												<textarea rows="7" class="ClsTextAreaEmail" id="content"   name="content" /></textarea>	
											 </td>
										</tr>
									</table>
									<hr>	
								</div>	
							</td>
						</tr>	
						<tr>
							<td>
							  <hr>  	
							</td>
						</tr>
					</c:when>
					<c:when test="${draftMode.deliveryModeName eq 'sms' ||  draftMode.deliveryModeName eq 'SMS'}">
						<tr>
							<td> 
								<span class="ClsLabel">
								    <input type="checkbox" id="sms" name="sms" value="sms" > SMS	 				
								</span>  
								<div style="width: 70%; float: right; display: none;" id="viewSmsMode"  >
									<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm"> 
										<tr>	 
											 <td width="16%"> <span class="ClsLabel">Mobile Number</span> </td>
											 <td> 
												<input type="text" class="ClsTextboxEmail" id="mobileNumber"  maxlength="10"   name="mobileNumber" />	
											 </td>
										</tr>
										<tr>	 
											 <td width="16%"> <span class="ClsLabel">Text</span> </td>
											 <td> 
												<textarea rows="5" class="ClsTextAreaEmail" id="textMessage"   name="textMessage" /></textarea>	
											 </td>
										</tr>
									</table>
									<hr>	
								</div>	
							</td>
						</tr>	
						<tr>
							<td>
							  <hr>  	
							</td>
						</tr>
					</c:when>
					<c:when test="${draftMode.deliveryModeName eq 'post' || draftMode.deliveryModeName eq 'Post' }">
						<tr>
							<td> 
								<span class="ClsLabel">
								    <input type="checkbox" id="post" name="post" value="post"   > Post					
								</span>  
								<div style="width: 70%; float: right; display: none;"  id="viewPostMode"  >
									<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm">  
										<tr>	 
											 <td width="16%"> <span class="ClsLabel">Address</span> </td>
											 <td> 
												<textarea rows="5"  class="ClsTextAreaEmail" id="postalAddress"   name="postalAddress" /></textarea>	
											 </td>
										</tr>
									</table>								
								</div>	
							</td>
						</tr>
						<tr>
							<td>
							  <hr>  	
							</td>
						</tr>	
					</c:when>
				</c:choose>		
			</c:forEach>
			
			
			
			<%-- <c:forEach items="${deliveryModeList}" var="draftMode" >				
				<tr>
					<td> 
						<span class="ClsLabel">
						    <input type="checkbox" id="draftModeName${draftMode.deliveryModeId}" name="draftModeName" value="${draftMode.deliveryModeId}" 
						    	onclick="viewCommunicationFields('${draftMode.deliveryModeId}')">
							  	${draftMode.deliveryModeName}						
						</span>  						
						
						<div style="width: 70%; float: right; display: none;" id="viewCommunicationFields${draftMode.deliveryModeId}"  >				 
						
							<c:set var="isRequiredFields" value="" />
							<c:set var="isLongFields" value="" />
							<c:set var="isLongFieldNames" value="" />
							 
							<c:forEach items="${draftMode.deliveryModeFields}" var="draftModeFields" >	
								
								
							    <input type="hidden" id="${draftModeFields.deliveryModeFieldsId}" maxlength="70"  
							        name="fieldsId${draftMode.deliveryModeId}" value="${draftModeFields.deliveryModeFieldsId}" />	
								<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
									<tr>	 
										 <td width="16%"> <span class="ClsLabel">${draftModeFields.fieldName}</span> 
										    <input type="hidden" id="fieldsLbl${draftModeFields.deliveryModeFieldsId}"
														 maxlength="70"   name="fieldsLbl${draftMode.deliveryModeId}" value="${draftModeFields.fieldName}"  />
											<c:if test="${draftModeFields.fieldRequired == 1}"> 											
												<span class="ClsRequiredFields">*</span> 		
												
												<c:choose>
													<c:when test="${isRequiredFields eq ''}"> 
														<c:set var="isRequiredFields" value="fields${draftModeFields.deliveryModeFieldsId}" />			
													</c:when>
													<c:otherwise> 														
														<c:set var="isRequiredFields" value="${isRequiredFields},fields${draftModeFields.deliveryModeFieldsId}" />	
													</c:otherwise>
												</c:choose>																					
											</c:if>										
										 </td>				
										 <td>
										    <c:choose>
												<c:when test="${draftModeFields.fieldDataType eq pageScope.DELIVERY_MODE_DATA_TYPE_NUMBER}">
													<c:choose>
														<c:when test="${isLongFields eq ''}">
															<c:set var="isLongFields" value="fields${draftModeFields.deliveryModeFieldsId}" /> 
															<c:set var="isLongFieldNames" value="${draftModeFields.fieldName}" />	
														</c:when>
														<c:otherwise> 
															
															<c:set var="isLongFields" value="${isLongFields},fields${draftModeFields.deliveryModeFieldsId}" />
								 							<c:set var="isLongFieldNames" value="${isLongFieldNames},${draftModeFields.fieldName}" />	
														</c:otherwise>
													</c:choose>
												</c:when>
											</c:choose> 
											
											 
										    <c:choose>	
											 	<c:when test="${draftModeFields.fieldType eq  pageScope.DELIVERY_MODE_FIELD_TEXT}">																		 
													<input type="text" class="ClsTextboxEmail" id="fields${draftModeFields.deliveryModeFieldsId}"
														 maxlength="70"   name="fields${draftMode.deliveryModeId}"   />		
												</c:when>textArea	
												<c:when test="${draftModeFields.fieldType eq  pageScope.DELIVERY_MODE_FIELD_TEXT_AREA}">									   														 
													<textarea rows="10" cols="40" class="ClsTextAreaEmail" id="fields${draftModeFields.deliveryModeFieldsId}"   
														name="fields${draftMode.deliveryModeId}" /></textarea>														
												</c:when>																						
											</c:choose>																		 			
										 </td>				
									</tr>   
								</table>
								
							</c:forEach>
							<input type="hidden" id="isRequiredFields${draftMode.deliveryModeId}" name="isRequiredFields${draftMode.deliveryModeId}"
							    value="${isRequiredFields}">
							 <input type="hidden" id="isLongFields${draftMode.deliveryModeId}" name="isLongFields${draftMode.deliveryModeId}"
							    value="${isLongFields}">
							 <input type="hidden" id="isLongFieldNames${draftMode.deliveryModeId}" name="isLongFieldNames${draftMode.deliveryModeId}"
							    value="${isLongFieldNames}"> 							
						</div>											
					</td>		 	
				</tr> 
				<tr>
					<td>
						<hr>
					</td>
				</tr>
			</c:forEach> --%>  		    
		</table>
	</div> 
	<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm" align="center" style="height: 300px">
		<tr>
			<td>
			<div class="page-wrapper box-content" style="padding: 5px;width: 98%">	
			   <textarea class="content" name="createDraft" id="createDraft">${draft.draftContent}</textarea>
			</div>
			</td>
		</tr>
		<tr>
			<td>
				<!-- <input type="button"  style="vertical-align:bottom;" class="ClsButton" id="generateAck" name="generateAck" value="Generate Acknowledgement" onclick="javascript:setSaveButton('0', this.form);">
	   -->
	 			<input type="button"  style="vertical-align:bottom;" class="ClsButton" id="saveDraft" name="saveDraft" value="Save Draft" onclick="javascript:draftSaveButton('0', this.form);">
	 			<input type="button"  style="vertical-align:bottom;" class="ClsButton" id="sentDraft" name="sentDraft" value="Send Draft" onclick="javascript:draftSaveButton('1', this.form);">
	 
		
			</td>
		</tr>
	</table> 
	
		 
</div> 
  	    
  	     
	<spring:bind path="draft.draftContent">
	 	<input type="hidden" id="draftContent" name="draftContent">  
	 </spring:bind>
	 	
	<input type="hidden" id="sentOrGenerateOnly" name="sentOrGenerateOnly">  
	<input type="hidden" id="manageRTIApplicationId" name="manageRTIApplicationId" value="${manageRTIApplicationId}"> 
	<c:if test="${not empty draft && draft.draftId >0 }">
		<spring:bind path="draft.draftId">
			<input type="hidden" id="draftId" name="draftId">   
		</spring:bind>
	</c:if> 	
	<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/>
 		
	
<script>
    $(document).ready(function() {
        $('.content').richText();
        
        if($("#email").prop('checked') == true){
        	document.getElementById('viewEmailMode').style.display='block'; 
        }
		if($("#sms").prop('checked') == true){
			document.getElementById('viewSmsMode').style.display='block'; 
        }
		if($("#post").prop('checked') == true){
			document.getElementById('viewPostMode').style.display='block'; 
        }
		
		
		$("#email").click(function() { 
			if($("#email").prop('checked') == true){
				document.getElementById('viewEmailMode').style.display='block'; 
	        }else{
	        	document.getElementById('viewEmailMode').style.display='none'; 
	        } 
        }); 
		
		$("#sms").click(function() { 
			if($("#sms").prop('checked') == true){
				document.getElementById('viewSmsMode').style.display='block'; 
	        }else{
	        	document.getElementById('viewSmsMode').style.display='none'; 
	        } 
        }); 
		
		$("#post").click(function() { 
			if($("#post").prop('checked') == true){
				document.getElementById('viewPostMode').style.display='block'; 
	        }else{
	        	document.getElementById('viewPostMode').style.display='none'; 
	        } 
        }); 
		
    });
    
   
    
     function viewCommunicationFields(checkedId){
    	var isModeChecked = document.getElementById('draftModeName'+checkedId);
    	if(isModeChecked.checked){
    		document.getElementById('viewCommunicationFields'+checkedId).style.display='block'
    	}else{
    		document.getElementById('viewCommunicationFields'+checkedId).style.display='none'
    	}
    }
     
   
    
    function draftSaveButton( saveButtonId, frm)
    {
    	if(saveButtonId == '0'){
    		document.getElementById("sentOrGenerateOnly").value=0 ;
    		createDraft(frm);
    	}else if(saveButtonId == '1'){
    		document.getElementById("sentOrGenerateOnly").value=1 ;
    		createAndSendDraft(frm);
    	}else{
    		document.getElementById("sentOrGenerateOnly").value=saveButtonId ;
    		return false;
    	}
    	
    }
    
    function createDraft(frm){
		var draftText = document.getElementsByClassName("richText-editor")[0].innerHTML;  		
    	if(draftText == null || draftText =='' || draftText == '<br/>' || draftText == '<br>'   ){
    		alert('Please Enter the Draft Detail');
    		return false;
    	}   	 
    	document.getElementById("draftContent").value= draftText;
    	navigate(frm,'<c:out value="${contextRoot}"/>/draft/saveDraft.do');  
    }
    
    function createAndSendDraft(frm){    	
    	var eMailChecked = document.getElementsById('email');
    	var smsChecked = document.getElementsById('sms');
    	var postChecked = document.getElementsById('post');
    	if (eMailChecked[i].checked) {
    		var validEmail=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    		var to = document.getElementsById('to').value; 
    		var cc = document.getElementsById('cc').value; 
    	 	var subject = document.getElementsById('subject').value;
    	 	var content = document.getElementsById('contect').value;
    	 	if(to==''){
    	 		alert('Please Enter  Email Id - To');
    	 		return false;
    	 	}
    	 	if(!(to.match(validEmail))){
    	 		alert('Please Enter Valid Email Id - To ');
    	 		return false;
    	 	}
    	 	if(!(cc.match(validEmail))){
    	 		alert('Please Enter Valid Email Id - CC');
    	 		return false;
    	 	}
    	 	if(subject==''){
    	 		alert('Please Enter  Email  Subject');
    	 		return false;
    	 	}
    	 	if(content==''){
    	 		alert('Please Enter  Email  Content');
    	 		return false;
    	 	}
    	}
    	if (smsChecked[i].checked) {    		 
    		var mobileNumber = document.getElementsById('mobileNumber').value; 
    		var textMessage = document.getElementsById('textMessage').value;    			 
    		if(mobileNumber=='' || mobileNumber.length!=10){
    	 		alert('Please Enter  Valid 10 digit Mobile Number');
    	 		return false;
    	 	}
    		if(!isNumberArray(new Array('mobileNumber'), new Array('Please enter Valid Mobile Number')))
   			{
   				return false;
   			}    		
    	 	if(textMessage==''){
    	 		alert('Please Enter Message');
    	 		return false;
    	 	}    	 	
    	}
    	if (postChecked[i].checked) {    		 
    		var postalAddress = document.getElementsById('postalAddress').value;  			 
    		if(postalAddress==''){
    	 		alert('Please Enter  Valid Postal Address');
    	 		return false;
    	 	}
    	}	
    	
    	var draftText = document.getElementsByClassName("richText-editor")[0].innerHTML;  		
    	if(draftText == null || draftText =='' || draftText == '<br/>' || draftText == '<br>'   ){
    		alert('Please Enter the Draft Detail');
    		return false;
    	}   	 
    	document.getElementById("draftContent").value= draftText;
    	//navigate(frm,'<c:out value="${contextRoot}"/>/draft/saveDraft.do');  
    	 
    }
    
    
    
    /* function createAndSendDraft(frm){  	
		 
		var communicationModesChecked = document.getElementsByName('draftModeName');			 
	  	for (var i=0; i<communicationModesChecked.length; i++) { 
	  		//alert(i);alert(communicationModesChecked[i].checked);
	    	 if (communicationModesChecked[i].checked) {
	    		 var communicationModesCkeckedValues = communicationModesChecked[i].value
	    		
	    		 //Check is Required Fileds
	    		 var requiredMode=  document.getElementById('isRequiredFields'+communicationModesCkeckedValues).value;  	    		 
	    		 var arrElements= requiredMode.split(',');  
	    		 if(requiredMode!=null && requiredMode!=''){
		    		 if(checkMandatoryMsg(arrElements, "Please fill all the required fields which are marked with asterix (*)")) { 	    			
		    		 } else{
		    			 return false;
		    		 }
	    		 }
	    		 //Check is Long Fields
	    		 var isLongFields = document.getElementById('isLongFields'+communicationModesCkeckedValues).value; 
    			 var isLongFieldNames = document.getElementById('isLongFieldNames'+communicationModesCkeckedValues).value;     			 
    			 var arrIsLongFields = isLongFields.split(',');  
    			 var arrIsLongFieldsMsg = isLongFieldNames.split(','); 
    			 if(isLongFields !=null && isLongFields!=''){
	    			 if(isNumberArray(arrIsLongFields,arrIsLongFieldsMsg)){
	    				 
	    			 }else{
		    			 return false;
		    		 }	  
    			 }
	    	 }
	  	} 		
    	var draftText = document.getElementsByClassName("richText-editor")[0].innerHTML;  		
    	if(draftText == null || draftText =='' || draftText == '<br/>' || draftText == '<br>'   ){
    		alert('Please Enter the Draft Detail');
    		return false;
    	}   	 
    	document.getElementById("draftContent").value= draftText;
    	navigate(frm,'<c:out value="${contextRoot}"/>/draft/saveDraft.do');  		
    } */
 
	
    
   
</script>	

 
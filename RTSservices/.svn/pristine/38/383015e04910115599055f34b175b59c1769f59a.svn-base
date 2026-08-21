<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.rti.utils.CoreConstants"%> 
<jsp:directive.include file="/pages/common/include.jsp" /> 
<%@include file="/pages/common/includeTransliterateJS.jsp"%>
<%@ taglib prefix="crt" uri="http://java.sun.com/jstl/core_rt" %>

 
<%
pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT); 
pageContext.setAttribute("SESSION_TOKEN_KEY",	Constants.SESSION_TOKEN_KEY);


%>
  
  <!--   <meta charset="utf-8">   -->
    
    <link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/scripts/docs/css/site.css" > </link>  
    <link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/scripts/docs/richtext.min.css" ></link>   
	<script type="text/javascript" src="<c:out value="${contextRoot}"/>/scripts/docs/jquery.richtext.js"></script>
    
     
    <script defer src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
 
 
<div class="mainHdr">
	<h3>
		 Draft Details
	</h3>
</div> 
 
 
 
<div valign="top" id="SetFormHeight">   
	<div id="SearchDivId" class="ClsSearch">
		<div class="ClsSearchTitle">
			<img src="<c:out value="${contextRoot}"/>/images/closed.gif" id="searchToggleImage" onclick="javascript:ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>')" />
			File Details<br>
		</div>
				
		<%@include file="/pages/core-pages/rtiapplication/rtiApplicationDetails.jsp"%>
		
		<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
		</script>
	</div>

	<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
	 
		<tr> 			 
			<td><span class="ClsLabel"> Draft Number:</span>  </td>
			<td>${draft.draftNumber} </td>
			<td><span class="ClsLabel">Application Number:</span> </td>	
			<td> ${draft.rtiApplication.rtiApplnNumber} </td>
			<td><span class="ClsLabel">	Computer Number: </span> </td>
			<td> ${draft.rtiApplication.rtiApplicationId} </td>							 		
		</tr>
		<tr> 			 
			<td><span class="ClsLabel"> Draft Created Date:</span>  </td>
			<td>${draft.creationDate} </td>
			<td><span class="ClsLabel">Draft Sent Date:</span> </td>	
			<td> ${draft.sentDate} </td>	
			
			<td><span class="ClsLabel">Draft Status</span> </td>	
			<td> 
				<c:choose>
					 <c:when test="${draft.sentStatus==0 }"> 
					 	Draft Created but Not Sent
					 </c:when>
					 <c:when test="${draft.sentStatus==1 }">
					 	Draft Created and Sent
					 </c:when>	
					 <c:when test="${draft.sentStatus==2 }">
					 	Draft Discarted
					 </c:when>					 
				</c:choose>
				
			</td>
											 		
		</tr>
		<tr> 			 
			<td><span class="ClsLabel"> Created By:</span>  </td>
			<td>${draft.createdByUser.firstName} ${draft.createdByUser.lastName} </td>
			<td><span class="ClsLabel">Sent By:</span> </td>	
			<td> ${draft.sentByUser.firstName} ${draft.sentByUser.lastName}</td>									 		
		</tr>			
	</table> 
	<hr>
	<div style="width: 100%">
		<div style="width: 45%;float: left;">
			<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm">		 
			 	<tr> 
					<td>
					 	<span class="ClsLabel">Draft Type</span>  : 					 			
						<select class="ClsSelect" name="draftType" id=draftType >
							<option value=""><--- Select ---></option> 
							<c:forEach var="draftType" items="${draftTypeList}">
								<c:choose>
									<c:when test="${draft.draftType.draftTypeId==draftType.draftTypeId}">
										<option value="${draftType.draftTypeId}" selected="selected">
											<c:out value="${draftType.draftTypeName}" /></option>
									</c:when>
									<c:otherwise>
										<option value="${draftType.draftTypeId}">${draftType.draftTypeName}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>																 
						</select>		
					</td>			 			
					  			 			
				</tr> 
				
				<tr>	
					<td> <span class="ClsLblTitle">Draft Dispatch Mode:</span>   </td>			 			
				</tr> 
				<c:set var="emailMode" value="0" />
				<c:set var="smsMode" value="0" />
				<c:set var="postMode" value="0" />
				<c:forEach items="${draft.draftsSentThroughList}" var="draftSentThrough" >					
					<c:choose>
							<c:when test="${draftSentThrough.deliveryMode.deliveryModeName eq 'email' || draftSentThrough.deliveryMode.deliveryModeName eq 'E Mail' || draftSentThrough.deliveryMode.deliveryModeName eq 'E-Mail'  }">
								<tr>
									<td> 
										<c:set var="emailMode" value="1" />
										<input type="hidden" id="emailModeId" name="emailModeId" value="${draftSentThrough.draftSentThroughId}" style="display: none;"/>
										<span class="ClsLabel">
										    <input type="checkbox" id="email" name="draftModeNameEmail" value="${draftSentThrough.deliveryMode.deliveryModeId}" <c:if test="${not empty draftSentThrough.draftSentThroughDetailsList}">checked="checked" </c:if>  > E-Mail					
										</span>  
										
										<div style="width: 100%; display: none;" id="viewEmailMode"  >
										<br>
											<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
												<c:forEach items="${draftSentThrough.draftSentThroughDetailsList}" var="draftSentThroughDetails">
													<c:choose>
														<c:when test="${draftSentThroughDetails.draftFieldName eq 'To'}">
															<tr>	 
																 <td width="20%"> <span class="ClsLabel">To</span> </td>
																 <td> 
																 	<input type="hidden" id="emailToId" name="emailToId" value="${draftSentThroughDetails.draftSentThroughDetailsId}" style="display: none;"/>
																	<input type="text" class="ClsTextboxEmail" value="${draftSentThroughDetails.draftFieldValue}" style="width: 96%" id="to"  maxlength="100" name="to" />	
																 </td>
															</tr>
														</c:when> 
														<c:when test="${draftSentThroughDetails.draftFieldName eq 'CC'}">									
															<tr>	 
																 <td width="20%"> <span class="ClsLabel">CC</span> </td>
																 <td> 
																 	<input type="hidden" id="emailCcId" name="emailCcId" value="${draftSentThroughDetails.draftSentThroughDetailsId}" style="display: none;" />
																	<input type="text" class="ClsTextboxEmail" value="${draftSentThroughDetails.draftFieldValue}" style="width: 96%" id="cc"  maxlength="100"   name="cc" />	
																 </td>
															</tr>
														</c:when> 
														<c:when test="${draftSentThroughDetails.draftFieldName eq 'Subject'}">
															<tr>	 
																 <td width="20%"> <span class="ClsLabel">Subject</span> </td>
																 <td> 
																 	<input type="hidden" id="emailSubjectId" name="emailSubjectId" value="${draftSentThroughDetails.draftSentThroughDetailsId}" style="display: none;" />
																	<input type="text" class="ClsTextboxEmail" value="${draftSentThroughDetails.draftFieldValue}" style="width: 96%" id="subject"  maxlength="150"   name="subject" />	
																 </td>
															</tr>
														</c:when> 
														<c:when test="${draftSentThroughDetails.draftFieldName eq 'Content'}">
															<tr>	 
																 <td width="20%"> <span class="ClsLabel">Content</span> </td>
																 <td> 
																	 <input type="hidden" id="emailContentId" name="emailContentId" value="${draftSentThroughDetails.draftSentThroughDetailsId}" style="display: none;" />
																	 <textarea rows="10" class="ClsTextAreaEmail"  style="width: 96%; height:auto" id="content"   name="content" />${draftSentThroughDetails.draftFieldValue}</textarea>	
																 </td>
															</tr>
														</c:when>
													</c:choose>		
												</c:forEach>
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
							<c:when test="${draftSentThrough.deliveryMode.deliveryModeName eq 'sms' ||  draftSentThrough.deliveryMode.deliveryModeName eq 'SMS'}">
								<tr>
									<td> 
										<c:set var="smsMode" value="1" />	
										<input type="hidden" id="smsModeId" name="smsModeId" value="${draftSentThrough.draftSentThroughId}" style="display: none;"/>									
										<span class="ClsLabel">
										    <input type="checkbox" id="sms" name="draftModeNameSMS" value="${draftSentThrough.deliveryMode.deliveryModeId}" <c:if test="${not empty draftSentThrough.draftSentThroughDetailsList}">checked="checked" </c:if> > SMS	 				
										</span>  
										<div style="width: 100%;  display: none;" id="viewSmsMode"  >
											<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm"> 
											
												<c:forEach items="${draftSentThrough.draftSentThroughDetailsList}" var="draftSentThroughDetails">
													<c:choose>
														<c:when test="${draftSentThroughDetails.draftFieldName eq 'Mobile Number'}"> 
															<tr>	 
																 <td width="02%"> <span class="ClsLabel">Mobile Number</span> </td>
																 <td> 
																 	<input type="hidden" id="mobileNumberId" name="mobileNumberId" value="${draftSentThroughDetails.draftSentThroughDetailsId}" style="display: none;" />
																	<input type="text" class="ClsTextboxEmail" value="${draftSentThroughDetails.draftFieldValue}" style="width: 96%" id="mobileNumber"  maxlength="10"   name="mobileNumber" />	
																 </td>
															</tr>
														</c:when> 
														<c:when test="${draftSentThroughDetails.draftFieldName eq 'Text Message'}">
															<tr>	 
																 <td width="20%"> <span class="ClsLabel">Text</span> </td>
																 <td> 
																 	<input type="hidden" id="textMessageId" name="textMessageId" value="${draftSentThroughDetails.draftSentThroughDetailsId}" style="display: none;" />
																	<textarea rows="7" class="ClsTextAreaEmail"  style="width: 96%; height:auto" id="textMessage"   name="textMessage" />${draftSentThroughDetails.draftFieldValue}</textarea>	
																 </td>
															</tr>
														</c:when>
													</c:choose>
												</c:forEach>
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
							<c:when test="${draftSentThrough.deliveryMode.deliveryModeName eq 'post' || draftSentThrough.deliveryMode.deliveryModeName eq 'Post' }">
								<tr>
									<td> 
										<c:set var="postMode" value="1" />
										<input type="hidden" id="postModeId" name="postModeId" value="${draftSentThrough.draftSentThroughId}" style="display: none;"/>
										<span class="ClsLabel">
										    <input type="checkbox" id="post" name="draftModeNamePost" value="${draftSentThrough.deliveryMode.deliveryModeId}" <c:if test="${not empty draftSentThrough.draftSentThroughDetailsList}">checked="checked" </c:if> > Post					
										</span>  
										<div style="width: 100%; display: none;"  id="viewPostMode"  >
											<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm"> 
												 <c:forEach items="${draftSentThrough.draftSentThroughDetailsList}" var="draftSentThroughDetails">
													<tr>	 
														 <td width="20%"> <span class="ClsLabel">Address</span> </td>
														 <td> 
														 	<input type="hidden" id="postalAddressId" name="postalAddressId" value="${draftSentThroughDetails.draftSentThroughDetailsId}" style="display: none;" />
															<textarea rows="10"  class="ClsTextAreaEmail"  style="width: 96%; height:auto" id="postalAddress"   name="postalAddress" />${draftSentThroughDetails.draftFieldValue}</textarea>	
														 </td>
													</tr>
												</c:forEach>	
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
					<c:forEach items="${deliveryModeList}" var="draftMode" >
					<c:choose>
						<c:when test="${(draftMode.deliveryModeName eq 'email' || draftMode.deliveryModeName eq 'E Mail' || draftMode.deliveryModeName eq 'E-Mail') && emailMode == 0}">
							<tr>
								<td> 
									<span class="ClsLabel">
									    <input type="checkbox" id="email" name="draftModeNameEmail" value="${draftMode.deliveryModeId}"  > E-Mail					
									</span>  
									
									<div style="width: 100%; display: none;" id="viewEmailMode"  >
									<br>
										<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
											<tr>	 
												 <td width="20%"> <span class="ClsLabel">To</span> <span class="ClsRequiredFields">*</span> </td>
												 <td> 
													<input type="text" class="ClsTextboxEmail" style="width: 96%" id="to"  maxlength="100" name="to" />	
												 </td>
											</tr>
											<tr>	 
												 <td width="20%"> <span class="ClsLabel">CC</span> </td>
												 <td> 
													<input type="text" class="ClsTextboxEmail"  style="width: 96%" id="cc"  maxlength="100"   name="cc" />	
												 </td>
											</tr>
											<tr>	 
												 <td width="20%"> <span class="ClsLabel">Subject</span> <span class="ClsRequiredFields">*</span> </td>
												 <td> 
													<input type="text" class="ClsTextboxEmail"  style="width: 96%" id="subject"  maxlength="150"   name="subject" />	
												 </td>
											</tr>
											<tr>	 
												 <td width="20%"> <span class="ClsLabel">Content</span> <span class="ClsRequiredFields">*</span> </td>
												 <td> 
													<textarea rows="10" class="ClsTextAreaEmail"  style="width: 96%; height:auto" id="content"   name="content" /></textarea>	
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
						<c:when test="${(draftMode.deliveryModeName eq 'sms' ||  draftMode.deliveryModeName eq 'SMS') && smsMode == 0}">
							<tr>
								<td> 
									<span class="ClsLabel">
									    <input type="checkbox" id="sms" name="draftModeNameSMS" value="${draftMode.deliveryModeId}" > SMS	 				
									</span>  
									<div style="width: 100%;  display: none;" id="viewSmsMode"  >
										<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm"> 
											<tr>	 
												 <td width="02%"> <span class="ClsLabel">Mobile Number</span> <span class="ClsRequiredFields">*</span> </td>
												 <td> 
													<input type="text" class="ClsTextboxEmail"  style="width: 96%" id="mobileNumber"  maxlength="10"   name="mobileNumber" />	
												 </td>
											</tr>
											<tr>	 
												 <td width="20%"> <span class="ClsLabel">Text</span> <span class="ClsRequiredFields">*</span> </td>
												 <td> 
													<textarea rows="7" class="ClsTextAreaEmail"  style="width: 96%; height:auto" id="textMessage"   name="textMessage" /></textarea>	
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
						<c:when test="${(draftMode.deliveryModeName eq 'post' || draftMode.deliveryModeName eq 'Post') && postMode == 0 }">
							<tr>
								<td> 
									<span class="ClsLabel">
									    <input type="checkbox" id="post" name="draftModeNamePost" value="${draftMode.deliveryModeId}"  > Post					
									</span>  
									<div style="width: 100%; display: none;"  id="viewPostMode"  >
										<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm">  
											<tr>	 
												 <td width="20%"> <span class="ClsLabel">Address</span><span class="ClsRequiredFields">*</span>  </td>
												 <td> 
													<textarea rows="10"  class="ClsTextAreaEmail"  style="width: 96%; height:auto" id="postalAddress"   name="postalAddress" /></textarea>	
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
			</table>
		</div>		 
		<div style="float: right;width: 55%">	
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
						<c:if test="${draft.sentStatus==0 }">
				 			<input type="button"  style="vertical-align:bottom;" class="ClsButton" id="saveDraft" name="saveDraft" value="Save Draft" onclick="javascript:draftSaveButton('0', this.form);">
				 			<input type="button"  style="vertical-align:bottom;" class="ClsButton" id="sentDraft" name="sentDraft" value="Send Draft" onclick="javascript:draftSaveButton('1', this.form);">
			 			</c:if>
			 		</td>
				</tr>
			</table> 
		</div> 			
	</div>
	
	<input type="hidden" id="draftContent" name="draftContent">  
	<input type="hidden" id="sentOrGenerateOnly" name="sentOrGenerateOnly" >  
	<input type="hidden" id="manageRTIApplicationId" name="manageRTIApplicationId" value="${manageRTIApplicationId}"> 
	<c:if test="${not empty draft && draft.draftId >0 }"> 
		<input type="hidden" id="draftId" name="draftId" value="${draft.draftId}">
		<input type="hidden" id="draftNumber" name="draftNumber" value="${draft.draftNumber}">  	 
		<input type="hidden" id="creationDate" name="creationDate" value="${draft.creationDate}">
	</c:if> 	
	<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/>
		 
</div> 
  	    
  	     

		
<script>
    $(document).ready(function() {
        $('.content').richText();        
        $('.richText-editor').css("height","550px");
        $('.main').css("height","auto");
        
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
    
   
    
    /*  function viewCommunicationFields(checkedId){
    	var isModeChecked = document.getElementById('draftModeName'+checkedId);
    	if(isModeChecked.checked){
    		document.getElementById('viewCommunicationFields'+checkedId).style.display='block'
    	}else{
    		document.getElementById('viewCommunicationFields'+checkedId).style.display='none'
    	}
    }
      */
   
    
    function draftSaveButton( saveButtonId, frm)
    {
    	var draftType = document.getElementById("draftType").value;
    	if(draftType == null || draftType == ''){
    		alert('Please Select Draft Type');
    		return false;
    	}
    	if(saveButtonId == '0'){
    		document.getElementById("sentOrGenerateOnly").value=0 ;
    		createDraft(frm);
    	}else if(saveButtonId == '1'){
    		document.getElementById("sentOrGenerateOnly").value=1 ;
    		createAndSendDraft(frm);
    	}else{ 
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
    	var eMailChecked = document.getElementById('email');
    	var smsChecked = document.getElementById('sms');
    	var postChecked = document.getElementById('post');
    	if (eMailChecked.checked) {
    		var validEmail=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    		var to = document.getElementById('to').value; 
    		var cc = document.getElementById('cc').value; 
    	 	var subject = document.getElementById('subject').value;
    	 	var content = document.getElementById('content').value;
    	 	if(to==''){
    	 		alert('Please Enter  Email Id - To');
    	 		return false;
    	 	}
    	 	if(!(to.match(validEmail))){
    	 		alert('Please Enter Valid Email Id - To ');
    	 		return false;
    	 	}
    	 	if(cc!='' && !(cc.match(validEmail))){
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
    	if (smsChecked.checked) {    		 
    		var mobileNumber = document.getElementById('mobileNumber').value; 
    		var textMessage = document.getElementById('textMessage').value;    			 
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
    	if (postChecked.checked) {    		 
    		var postalAddress = document.getElementById('postalAddress').value;  			 
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
    	navigate(frm,'<c:out value="${contextRoot}"/>/draft/saveDraft.do');  
    	 
    }
    
 </script>	

 
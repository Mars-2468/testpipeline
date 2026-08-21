<%-- <jsp:directive.page import="com.mars.common.utils.Constants" />
<jsp:directive.page import="com.mars.common.utils.Constants,com.mars.RTI.utils.CoreConstants"/> --%>

<%@page import="com.mars.rti.utils.CoreConstants"%>
<%pageContext.setAttribute("RTI_STATUS_PENDING", CoreConstants.RTI_STATUS_PENDING);%>
<%pageContext.setAttribute("RTI_STATUS_ACTIVE", CoreConstants.RTI_STATUS_ACTIVE);%>
<%pageContext.setAttribute("RTI_STATUS_FORWARD", CoreConstants.RTI_STATUS_FORWARD);%>
<%pageContext.setAttribute("RTI_STATUS_REJECT", CoreConstants.RTI_STATUS_REJECT);%>
<%pageContext.setAttribute("RTI_STATUS_VERIFIED", CoreConstants.RTI_STATUS_VERIFIED);%>
<%pageContext.setAttribute("RTI_STATUS_ACCEPTED", CoreConstants.RTI_STATUS_ACCEPTED);%>

 <div valign="middle" id="dialogFolderNoting" style="display:none">
		<iframe align="top" name="dialogFolderNotingPopup" id="dialogFolderNotingPopup"
			src="<c:out value="${contextRoot}"/>/pages/common/dummy.jsp"
			height="500" width="1020" marginheight="0" marginwidth="0"
			scrolling="auto" frameborder="0" noresize="noresize"></iframe>
 </div>
 
 <div valign="middle" id="dialogFolderNotingEdit" style="display:none">
		<iframe align="top" name="dialogFolderNotingEditPopup" id="dialogFolderNotingEditPopup"
			src="<c:out value="${contextRoot}"/>/pages/common/dummy.jsp"
			height="500" width="1020" marginheight="0" marginwidth="0"
			scrolling="auto" frameborder="0" noresize="noresize"></iframe>
 </div>
 
 <script>
 $(function() {
		document.getElementById("dialogFolderNoting").style.display='';
		$("#dialogFolderNoting").dialog({
			bgiframe: true,
			autoOpen: false,
			height: 540,
			resizable:false,
			width:1040,
			modal: false
		});
		
		document.getElementById("dialogFolderNotingEdit").style.display='';
		$("#dialogFolderNotingEdit").dialog({
			bgiframe: true,
			autoOpen: false,
			height: 540,
			resizable:false,
			width:1040,
			modal: false
		});
		
	});
 
 
	
	function openNotingBox(){
		
		 
		$('.error').css('display','none');
		try{ 
			document.getElementById('dialogFolderNotingPopup').src='<c:out value="${contextRoot}"/>/rtiapplication/notingSaveEditor.do';
		  
		$('#dialogFolderNoting').dialog( "option", "title", 'Add Noting' );
		$('#dialogFolderNoting').dialog('open');
		 
		}catch(e){
		alert(e);
		}
	}
	
	function closeDialogNoting(message)
	{	 
		displaySuccessMsg(message)
		$('#dialogFolderNoting').dialog('close');
		scroll(0,0); 
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editRTIApplication.do'); 	
	}
	
	function editNoting(){ 
		
		$('.error').css('display','none');
		try{ 
			document.getElementById('dialogFolderNotingEditPopup').src='<c:out value="${contextRoot}"/>/rtiapplication/notingUpdateEditor.do';
		  
		$('#dialogFolderNotingEdit').dialog( "option", "title", 'Edit Noting' );
		$('#dialogFolderNotingEdit').dialog('open');
		 
		}catch(e){
		alert(e);
		}
	}

 </script>


<div valign="top" id="SetFormHeight2" >    	
	<table width="99%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
		<tr>
			<td >
					<%@include file="/pages/workflow/taskIncludeRTIApplicationAction.jsp"%>						
			</td>									
		</tr>
	</table>
</div>

<div valign="top" id="SetFormHeight1" style="width: 100% ; min-height: 210px">
    <div style="width: 49%; float: left;">
		
		<table width="99%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
			<tr>
				<td>
					<span class="ClsLabel">File</span>	
					<div style="border: 2px solid navy; background-color: lighgray;height: 635px; vertical-align: top;"><!-- 
						<iframe src="/RTI/images/srs.pdf" width="100%" height="100%" frameborder="0">Documents not Found</iframe> -->
						<iframe id="dmsUPloadedContent" src=""  width="100%" height="100%" frameborder="0">Documents not Found</iframe>						
					</div>			
				</td>					
			</tr>			
		</table>
	</div>
	<div style="width: 49%; float: right;">	
		<table width="99%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
			<tr>
				<td>
				  <input type="button" value="Add Noting"  style="vertical-align:bottom;" class="ClsButton" onclick="openNotingBox()"> 
		
				</td>					
			</tr>
			<tr>
				<td style="vertical-align: top;">
				   <div style="border: 2px solid navy; background-color: azure;height: 580px; vertical-align: top; overflow: scroll;">	
				        <c:remove var="notingsData" scope="session"/>	
				        <c:remove var="notingsId" scope="session"/>			     
						<c:forEach var="notings" items="${requestScope.rtiApplication.rtiApplicationNoting}" varStatus="sequenceNum">	
							<br/>					
														
							<div style="margin: 5px 0px 5px 3px"> 
								<span style="font-style: italic;color: green;font-weight: bold" >Note #${(sequenceNum.index)+1}</span>								 
								 <c:if test="${notings.notingUser.userId == user.userId && totalNotingCount == ((sequenceNum.index)+1)}">
								  	<a href="#" onclick="editNoting()"> 
								  		<span style="padding-left: 20px; font-weight: bold;">Edit </span>
								  	</a>
								  	<c:set var = "notingsData" scope = "session" value = "${notings.noting}"/>
								  	<c:set var = "notingsId" scope = "session" value = "${notings.rtiApplicationNotingId}"/>
								 </c:if>
								<br/><br/>
									${notings.noting}
							</div>
							<div style="width: 100%; font-weight: bold;padding: 2px 0 7px 0; ">							
								<div style="width: 47%;float: left;padding-left: 5px;">
									${notings.notingDate}
								</div>
								<div style="width: 47%;float: right;padding-left: 5px;">
								 	${notings.notingUser.firstName} ${notings.notingUser.lastName}
								</div>
								
							</div>
							<br>	
							<hr style="border: 1px  dashed #999999; ">					
						</c:forEach>
					</div>
				</td>	
			</tr>
		</table>
	</div>	
	<br/>
		<table width="99%" border="0" cellpadding="2" cellspacing="2" class="dataForm"> 
	
			<tr>
				<td >
					<%@include file="/pages/common-pages/dms/manageDmsAttachments.jsp"%>
				</td>									
			</tr>
	
			
			<tr>
				<td >						
						<%@include file="/pages/core-pages/rtiapplication/listRTIApplicationVerificationDetails.jsp"%>			
				</td>									
			</tr>
			
		</table> DMS and Details Section
</div>
	
	 		
	<input type="hidden" id="rtiApplicationDetailsId" name="rtiApplicationDetailsId" value="${rtiApplicationDetails.rtiApplicationDetailsId}" />
	<input type="hidden" id="rtiApplicationDetailsWF_Level" name="rtiApplicationDetailsWF_Level" value="${rtiApplicationDetails.workflowLevel}" />
	<input  type="hidden" id="isAssignedToOther" name="isAssignedToOther" value="0" >	
			
 

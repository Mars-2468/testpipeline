<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_UPLOAD_TOKEN_KEY", Constants.SESSION_UPLOAD_TOKEN_KEY);
%>

<style>
.ClsTextboxEmail {
	color: #000;
	font: 11px Helvetica, Arial, sans-serif;
	margin-right: 5px;
	padding: 4px;
	float:left;
	/* min-width: 180px;*/	
	width: 230px;
	height:18px;
	
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	-ms-border-radius: 5px;
	-o-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;
	-moz-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;
	-ms-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;
	-o-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;
	box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;
	-webkit-transition: all 0.5s ease;
	-moz-transition: all 0.5s ease;
	-ms-transition: all 0.5s ease;
	-o-transition: all 0.5s ease;
	transition: all 0.5s ease;	
	border: 1px solid #c8c8c8;
	-webkit-appearance: none; /* gets rid of default appearance in Webkit browsers*/
    -moz-appearance: none; /* Get rid of default appearance for older Firefox browsers */
   	-ms-appearance: none; /* get rid of default appearance for IE8, 9 and 10*/
    position:relative; 
}
</style>

 <script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery.ajaxfileupload.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	<%-- alert("uploadPath : <c:out value="${sessionScope.selectedFolderPath}"/> uploadType  : <c:out value="${sessionScope.uploadType}"/> "+
				"entityId :<c:out value="${sessionScope.entityId}"/>"+
			"entityName: <c:out value="${sessionScope.entityName}"/> workspace  :<c:out value="${sessionScope.workspace}"/>"+
			"documentMasterId : <c:out value="${sessionScope.documentMasterId}"/> dmsDocumentCheckListId  : <c:out value="${sessionScope.dmsDocumentCheckListId}"/>"+ 
			"jsessionid : <c:out value="${requestScope.sessionId}"/> " +
			" _synchronizerUploadToken :"+"<%=session.getAttribute(Constants.SESSION_UPLOAD_TOKEN_KEY)%>"); --%>
	
	$('input[type="file"]').ajaxfileupload({
			'params':{'jcr:keywords':'','jcr:comments':'','jcr:isPrivate':'','jcr:marsType':'',"uploadPath":"<c:out value="${sessionScope.selectedFolderPath}"/>",
						"uploadType":"<c:out value="${sessionScope.uploadType}"/>","entityId":"<c:out value="${sessionScope.entityId}"/>",
						"entityName":"<c:out value="${sessionScope.entityName}"/>",'workspace':"<c:out value="${sessionScope.workspace}"/>",
						'documentMasterId':"<c:out value="${sessionScope.documentMasterId}"/>",'dmsDocumentCheckListId':"<c:out value="${sessionScope.dmsDocumentCheckListId}"/>", 
						"jsessionid" : "<c:out value="${requestScope.sessionId}"/>", '_synchronizerUploadToken':"<%=session.getAttribute(Constants.SESSION_UPLOAD_TOKEN_KEY)%>"},
		 	'action' : "<c:out value="${contextRoot}"/>/dmsdocument/uploadFile.do",
			 'onComplete' : function(response) {
			$('#upload').hide();
			$('#message').show();
			
			var statusVal = JSON.stringify(response.status);

			if(statusVal == "false")
			{
				$("#message").html("<font color='red'>"+ JSON.stringify(response.message) +" </font>");
			}	
			if(statusVal == "true")
			{
				//$("#message").html("<font color='green'>"+ JSON.stringify(response.message) +" </font>");
				$("#message").html( parent.closeDialog(JSON.stringify(response.message)) );
			}			
		},
		
		'onStart' : function() {
			$('#upload').show();
			$('#message').hide();
		}
	});
});
</script>

<div valign="top"  id="SetFormHeight">
<table cellpadding="2" cellspacing="2" width="90%" align="center" class="dataForm">
		<%-- <tr valign="top">
				<td width="25%">
					<span class="ClsLabel"><fmt:message key="dms.manage.label.FilePrivacy" /></span><span class="ClsRequiredFields">*</span>
				</td>
				<td>
					<input type="radio" name="fileTypeStatus" value="Public" checked="checked"> Public
					<input type="radio" name="fileTypeStatus" value="Private"> Private
				</td>
			</tr> --%>
			<%-- <tr valign="top">
				<td width="25%">
					<span class="ClsLabel"><fmt:message key="dms.manage.label.Keyword" /></span><span class="ClsRequiredFields">*</span>
				</td>
				<td>
				<textarea maxlength="50" rows="5" cols="40" name="filekeyword" id="filekeyword"></textarea>
				</td>
			</tr> --%>
			<tr valign="top">
				<td colspan="2">
					 
				</td>
				 
			</tr>
			<tr valign="top">
				<td width="25%">
					<div style="visibility: hidden;">
					 	<textarea  name="filekeyword" id="filekeyword">${sessionScope.entityId}</textarea> 
				 	</div>
					<span class="ClsLabel"><fmt:message key="dms.manage.label.DocumentType" /></span><span class="ClsRequiredFields">*</span>
					
				</td>
				<td>
				 	<div style="visibility: hidden;"> 
					 	<textarea   name="comments" id="comments">${sessionScope.entityId}</textarea> 
				 	</div>
				 	<input type="text" name="documentType" id="documentType" class="ClsTextbox">
				 	
					<%-- <select name="documentType" id="documentType" style="width: 250px">						
						 <c:forEach var="documentType" items="${sessionScope.documentTypeList}">
							 <option value="${sessionScope.entityName}" selected="selected">  
							 	${sessionScope.entityName} 
							</option>
						</c:forEach>						
					</select> --%>
				</td>
			</tr>
			<%-- <tr valign="top">
				<td width="25%">
					<span class="ClsLabel"><fmt:message key="dms.manage.label.Comments" /></span><span class="ClsRequiredFields">*</span>
				</td>
				<td>
				<textarea maxlength="100" rows="5" cols="40" name="comments" id="comments"></textarea>
				</td>
			</tr> --%>
			<tr valign="middle">
				  <td >
				<span class="ClsLabel"><fmt:message key="dms.manage.label.FileUpload" /></span>							
				</td> 
				<td>						
					<div id="message"></div>
					<div id="upload" style="display: none;">Uploading..</div> 								
							<label for="file" class="ClsButton" style="margin-right:5px;height: 20px;">Upload </label> 
							<input type="file" id="file" name="file" />													
							<!-- <span id="spanButtonPlaceHolder"><input id="btnSubmitDummy" type="button" value="Upload" disabled="disabled" style="margin-left: 2px; height: 22px; font-size: 8pt;" /></span> -->
							<!-- <input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();" style="margin-left: 2px; height: 24px;" >
							 --><!-- <input id="btnCancel1" class="ClsButton" type="button" value="Cancel Uploads" onclick="cancelQueue(upload1);" disabled="disabled" style="margin-left: 2px; height: 24px;" /> -->
					
					
					<div style="visibility: hidden;"> 
					 	<input type="radio" name="fileTypeStatus" value="Public" checked="checked"> Public
						<input type="radio" name="fileTypeStatus" value="Private"> Private
				 	</div>
					
					</td>
				
			</tr>
			
			<tr>
			<td colspan="4">
			<span class="ClsLabel"> Note : </span> Max file size allowed is 10 MB. Allowed file types are : *.jpg;*.png;*.pdf;
			
			</td>
			</tr>
		</table>
		
	
			 <div style="display:none">Uploaded Files</div>
			 <div id="uploadedFiles"></div>
	
	</div>
<input type="hidden" id="uploadPath" name="uploadPath" value="<c:out value="${requestScope.uploadPath}"/>"/>
<input type="hidden" id="entityId" name="entityId" value="<c:out value="${requestScope.entityId}"/>"/>
<input type="hidden" id="entityName" name="entityName" value="<c:out value="${requestScope.entityName}"/>"/>
<input type="hidden" id="uploadType" name="uploadType" value="<c:out value="${requestScope.uploadType}"/>"/>
<input type="hidden" id="workspace" name="workspace" value="<c:out value="${requestScope.workspace}"/>"/>
<input type="hidden" id="sessionId" name="sessionId" value="<c:out value="${requestScope.sessionId}"/>"/>

<input type="hidden" name="${pageScope.SESSION_UPLOAD_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_UPLOAD_TOKEN_KEY)%>" />
<!-- DMS Documents Checklist Attachments code Start-->

	
	<%-- <script	src="<c:out value="${contextRoot}"/>/dwr/interface/dmsDocumentCheckList.js"></script> --%>
	<%-- <script src="<c:out value="${contextRoot}"/>/dwr/interface/property.js"></script> --%>
	<script	src="<c:out value="${contextRoot}"/>/scripts/dmsutils.js"></script>	
	<jsp:directive.page import="com.mars.common.utils.Constants" />
	<%
	 	pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
	%>
	<%
	   if(!request.getAttribute("javax.servlet.forward.request_uri").toString().contains("/login")){
		if(request.getHeader("referer")==null || (request.getHeader("referer")!=null) && 
				((request.getHeader("referer").indexOf(request.getServerName()) == -1) && (!request.getHeader("referer").equals("http://ssotest.rajasthan.gov.in/apps")))){
	        response.sendRedirect("pages/common/exception.jsp");
	      	return;		
		}   
	}   
%>
	<input type="hidden" id="uuid" name="uuid" value=""/>
		
	<script type="text/javascript">
		
		$(function() {
			document.getElementById("dialogFolder").style.display='';
			$("#dialogFolder").dialog({
				bgiframe: true,
				autoOpen: false,
				height: 410,
				resizable:false,
				width:580,
				modal: false
			
			});
		});
		
		/* document.getElementById('span_upload_files').style.display='none'; */
		function openUploadFile(dmsDocumentCheckListId,documentMasterId,dmsDocumentType){
			
			//$('.error').css('display','none');
			try{
			var  selectedDocumentType = '<c:out value="${requestScope.DMS_ENTITY_NAME}"/>_DOC';
			if(dmsDocumentType != null && dmsDocumentType.length > 0)
				
				selectedDocumentType = dmsDocumentType;
		/* 	document.getElementById('managePopupFolder').src='<c:out value="${contextRoot}"/>/dmsdocumentchecklist/manageFileUpload.do?'
																+'workspace=<c:out value="${requestScope.DMS_WORKSPACE_NAME}" />'
																+'&selectedFolderPath=<c:out value="${requestScope.DMS_FOLDER_PATH}" />'
																+'&entityName=<c:out value="${requestScope.DMS_ENTITY_NAME}" />'
																+'&entityId=<c:out value="${requestScope.DMS_ENTITY_ID}" />'
																+'&selectedDocumentType='+selectedDocumentType
																+'&uploadType=<c:out value="${requestScope.DMS_UPLOAD_TYPE}" />'
																+'&documentMasterId='+documentMasterId
		   														+'&dmsDocumentCheckListId='+dmsDocumentCheckListId; */
			
/* 			$('#dialogFolder').dialog( "option", "title", 'File Upload for Folder : <c:out value="${requestScope.DMS_FOLDER_PATH}" />' );
 */		
        /*    document.getElementById('managePopupFolder').src='http://localhost:8080/FTS/dmsdocument/manageFileUpload.do?workspace=Property&selectedFolderPath=/WARD_430/PROP_ASSESSMENT/NEW_ASSESSMENT_1092640&entityName=PROP_ASSESSMENT_NEW&entityId=1092640&selectedDocumentType=PROP_ASSESSMENT_NEW_DOC&uploadType='; 
            */
       	document.getElementById('managePopupFolder').src='<c:out value="${contextRoot}"/>/dmsdocument/manageFileUpload.do';
		 
           $('#dialogFolder').dialog( "option", "title", 'File Upload for Folder' );
			$('#dialogFolder').dialog('open');
	
			}catch(e){
			alert(e);
			}
		}
	
	
		function closeDialog(message)
		{	
			displaySuccessMsg(message);
			$('#dialogFolder').dialog('close');
			scroll(0,0);
			
			property.getDocumentCheckListByEntity('<c:out value="${requestScope.DMS_ENTITY_NAME}" />','<c:out value="${requestScope.DMS_ENTITY_ID}" />',updateDmsDockCheckList);
			}
		
	</script>
	
	<div valign="middle" id="dialogFolder" style="display:none">
		<iframe align="top" name="managePopupFolder" id="managePopupFolder"
			src="<c:out value="${contextRoot}"/>/pages/common/dummy.jsp"
			height="370" width="550" marginheight="0" marginwidth="0"
			scrolling="auto" frameborder="0" noresize="noresize"></iframe>
	</div>

	<div>
		<table id="dmsDocsCheckListTableId" border="1" cellpadding="2" cellspacing="2" width="100%" class="dataGrid">
			<thead>
			<tr><td colspan="6">
				<span class="ClsSubmenuTitle" id="span_upload_files" style="display:block">
					<fmt:message key="dmsattachment.manage.label.checklist.heading" /> 
				</span>	
			</td></tr>			
			<tr>
				<td><span class="ClsLabel"><fmt:message key="common.manage.label.sNo" /></span></td>
				<td><span class="ClsLabel"><fmt:message key="dmsattachment.manage.label.document"/></span></td>
				<td style="align:center;width: 75px;"><span class="ClsLabel"><fmt:message key="dmsattachment.manage.label.status"/></td>
				<td><span class="ClsLabel"><fmt:message key="dmsattachment.manage.label.fileName" /> </span></td>
				<td style="align:center;width: 50px;"><span class="ClsLabel"><fmt:message key="dmsattachment.manage.label.uploaddate"/></td>
				<td style="width: 75px">
					<span class="ClsLabel"><fmt:message key="dmsattachment.manage.label.operations" /> </span>
				</td>						
			</tr>
			</thead>
			<tbody id="dmsDocsCheckListBodyId">	
			<%-- <c:if test="${not empty documentMasterList}">
				<c:forEach var="documentMaster" items="${documentMasterList}" varStatus="iCount">
					<tr>
						<td>
							<c:out value="${iCount.index+1}"/>
						</td>
						<td>
							<c:out value="${documentMaster.description}"/>
							<c:if test="${documentMaster.mandatory == 1}">
								<span class="ClsRequiredFields">*</span>
								<input type="hidden" id="documentMasterDesc" name="documentMasterDesc" 
								value="<c:out value="${documentMaster.description}"/>" />
								<input type="hidden" id="docDmsUuid" name="docDmsUuid" 
								value="<c:out value="${documentMaster.dmsUuid}"/>" />								
							</c:if>
						</td>
						<td>
							<c:choose>
								<c:when test="${documentMaster.checked == true}">
									<img src="<c:out value="${contextRoot}"/>/images/Green_Check.gif" alt="Document Uplaoded"/>
								</c:when>
								<c:otherwise>
									<img src="<c:out value="${contextRoot}"/>/images/Ico_Delete.gif" alt="Document Not Uploaded"/>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:out value="${documentMaster.fileName}"/>
						</td>						
						<td>
							<c:out value="${documentMaster.uploadedDate}"/>
						</td>
						<td nowrap="nowrap">
							<c:choose>
								<c:when test="${documentMaster.dmsUuid == null  }">
								<span class="ClsSubmenuTitle" id="span_upload_files" style="display:block">
									<a href="#" onclick="javascript:openUploadFile('<c:out value="${documentMaster.dmsDocumentCheckListId}"/>','<c:out value="${documentMaster.documentMasterId}"/>','<c:out value="${documentMaster.dmsDocumentType}"/>');" >Upload File</a>
								</span>	
								</c:when>
								<c:otherwise>
									 
									<a href="#" onclick="javascript:downloadDmsDocument('<c:out value="${documentMaster.dmsUuid}"/>');" alt="File Download"/>
										<img src="<c:out value="${contextRoot}"/>/images/file_download.png" alt="File Download"/>
									</a> 
									&nbsp;&nbsp;&nbsp;
									<a href="#" onclick="javascript:deleteDmsDocumentCheckList('<c:out value="${documentMaster.dmsUuid}"/>',<c:out value="${documentMaster.dmsDocumentCheckListId}"/>);" alt="File Delete">
										<img src="<c:out value="${contextRoot}"/>/images/file_delete.png" alt="File Delete"/>
									</a>	
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</c:if>	
		 --%>
		 
		 <c:choose>
					<c:when test="${not empty requestScope.dmsDocumentsList}">
						<c:forEach var="dmsDocument" items="${requestScope.dmsDocumentsList}" varStatus="iCount">
							<tr>
								<td>
									<c:out value="${iCount.index+1}" />
								</td>
								<td>
									<c:out value="${dmsDocument.fileName}"/>
								</td>
								<td>
									<c:out value="${dmsDocument.dmsDocumentType}"/>
								</td>
								<td>
									<c:out value="${dmsDocument.uploadedDate}"/>
								</td>
								<td nowrap="nowrap">
									&nbsp;&nbsp;
									<%-- <a href="#" onclick="javascript:downloadDmsDocument('${dmsDocument.dmsUuid} ');" alt="File Download" >
										<img src="${contextRoot}/images/file_download.png" alt="Download"/>
									</a>  --%>
									
									<a  href="#"    onclick="javascript:downloadDmsDocument('<c:out value="${dmsDocument.dmsUuid}"/>');" alt="File Download">
										<img src="<c:out value="${contextRoot}"/>/images/file_download.png" alt="File Download"/>
					                </a> 
									 
									<%-- <a href="#" onclick="javascript:showDmsDocument('<c:out value="${dmsDocument.dmsUuid}"/>');" alt="File View"/>
										<img src="<c:out value="${contextRoot}"/>/images/Ico_Print.gif" alt="File View"/>  --%>
									
									 <a href="#" onclick="javascript:viewUploadedFile('<c:out value="${dmsDocument.dmsUuid}"/>');" alt="File View" >
										<img src="<c:out value="${contextRoot}"/>/images/Ico_Print.gif" alt="File View"/>	
									 </a>
									
									<c:if test="${pageScope.APPL_STATUS_NEW eq fileCreation.finalStatus}">
										<a href="#" onclick="javascript:deleteDmsDocument('<c:out value="${dmsDocument.dmsUuid}"/>',<c:out value="${dmsDocument.dmsDocumentId}"/>);" alt="File Delete">
											<img src="<c:out value="${contextRoot}"/>/images/file_delete.png" alt="File Delete"/>
										</a>		
									 </c:if>								
								</td>
							</tr>
							<c:if test="${iCount.index == 0}">
								<input type="hidden" id="viewFirstUploadedFile" name="viewFirstUploadedFile" value="${dmsDocument.dmsUuid}" >
							</c:if>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr><td colspan=5  class="clsNoRecords" align="center">
							<fmt:message key="list.label.norecords"/>
						</td></tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>" />
	</div>

<input type="hidden" name="selectedDocs" id="selectedDocs" value="">

<!-- DMS Documents Checklist Attachments code End-->	

	<!-- DMS Documents Attachments code Start-->
	<%-- <script	src="<c:out value="${contextRoot}"/>/dwr/interface/dmsDocument.js"></script> --%>
	<script	src="<c:out value="${contextRoot}"/>/scripts/dmsutils.js"></script>	
	<%-- <script src="<c:out value="${contextRoot}"/>/dwr/interface/property.js"></script> --%>
	<jsp:directive.page import="com.mars.common.utils.Constants" />
	<%
	 	pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
		
	%>
	<input type="hidden" id="uuid" name="uuid" value="0"/>
	<script type="text/javascript">
		
		$(function() {
			document.getElementById("dialogFolder").style.display='';
			$("#dialogFolder").dialog({
				bgiframe: true,
				autoOpen: false,
				height: 300,
				resizable:false,
				width:600,
				modal: false
			});
		});
		
		function openUploadFile(){
			
			$('.error').css('display','none');
			try{
				var  selectedDocumentType = '<c:out value="${requestScope.DMS_ENTITY_NAME}"/>_DOC';
			 /* document.getElementById('managePopupFolder').src='<c:out value="${contextRoot}"/>/dmsdocument/manageFileUpload.do?'
																+'workspace=<c:out value="${requestScope.DMS_WORKSPACE_NAME}" />'
																+'&selectedFolderPath=<c:out value="${requestScope.DMS_FOLDER_PATH}" />'
																+'&entityName=<c:out value="${requestScope.DMS_ENTITY_NAME}" />'
																+'&entityId=<c:out value="${requestScope.DMS_ENTITY_ID}" />'
																+'&selectedDocumentType='+selectedDocumentType
																+'&uploadType=<c:out value="${requestScope.DMS_UPLOAD_TYPE}" />';  */
				document.getElementById('managePopupFolder').src='<c:out value="${contextRoot}"/>/dmsdocument/manageFileUpload.do';
			  
			$('#dialogFolder').dialog( "option", "title", 'Upload File' );
			$('#dialogFolder').dialog('open');
			
			//$("#dialogFolder").dialog().dialog("option", "title", "Upload File");			
			//$("#dialogFolder").dialog().dialog("open");
			}catch(e){
			alert(e);
			}
		}
	
	
		function closeDialog(message)
		{	
			//displayError(message);
			displaySuccessMsg(message)
			$('#dialogFolder').dialog('close');
			scroll(0,0);
			//document.getElementById('fileCreationId').value=id; 
			onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editRTIApplication.do'); 
			
			//CommonServiceDWR.getDocumentMastersByEntity('<c:out value="${requestScope.DMS_ENTITY_NAME}" />','<c:out value="${requestScope.DMS_ENTITY_ID}" />',updateDmsDocsList);
 		}
		
		
		/* function openUploadFile(dmsDocumentCheckListId,documentMasterId,dmsDocumentType){
			
			$('.error').css('display','none');
			try{
			var  selectedDocumentType = '<c:out value="${requestScope.DMS_ENTITY_NAME}"/>';
			if(dmsDocumentType != null && dmsDocumentType.length > 0)
				selectedDocumentType = dmsDocumentType;
			
			document.getElementById('managePopupFolder').src='<c:out value="${contextRoot}"/>/dmsdocumentchecklist/manageFileUpload.do?'
																+'workspace=<c:out value="${requestScope.DMS_WORKSPACE_NAME}" />'
																+'&selectedFolderPath=<c:out value="${requestScope.DMS_FOLDER_PATH}" />'
																+'&entityName=<c:out value="${requestScope.DMS_ENTITY_NAME}" />'
																+'&entityId=<c:out value="${requestScope.DMS_ENTITY_ID}" />'
																+'&selectedDocumentType='+selectedDocumentType
																+'&uploadType=<c:out value="${requestScope.DMS_UPLOAD_TYPE}" />';
															
			
			$('#dialogFolder').dialog( "option", "title", 'File Upload for Folder : <c:out value="${requestScope.DMS_FOLDER_PATH}" />' );
			
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
			
			CommonServiceDWR.getDocumentMastersByEntity('<c:out value="${requestScope.DMS_ENTITY_NAME}" />','<c:out value="${requestScope.DMS_ENTITY_ID}" />',updateDmsDocsList);
			
				
		
		}
		 */
		
		
	</script>
	
	<div valign="middle" id="dialogFolder" style="display:none">
		<iframe align="top" name="managePopupFolder" id="managePopupFolder"
			src="<c:out value="${contextRoot}"/>/pages/common/dummy.jsp"
			height="245" width="575" marginheight="0" marginwidth="0"
			scrolling="auto" frameborder="0" noresize="noresize"></iframe>
	</div>
	
	<div valign="middle" id="dialogFolderShow" style="display:none">
		<iframe align="top" name="managePopupFolderShow" id="managePopupFolderShow"
			src="<c:out value="${contextRoot}"/>/pages/common/dummy.jsp"
			height="540" width="890" marginheight="0" marginwidth="0"
			scrolling="auto" frameborder="0" noresize="noresize"></iframe>
	</div>
	
	<div>
		<table cellpadding="0" cellspacing="1" class="dataGrid" style="width: 98%">
			<tr><td>
				<c:if test="${ (empty fileCreation.isFileParked || fileCreation.isFileParked == 0) && fileCreation.finalStatus ne 'Closed' }">
					<span class="ClsSubmenuTitle" id="span_upload_files" style="display:block">
						<fmt:message key="dmsattachment.manage.label.heading" /> &nbsp;&nbsp;&nbsp;
						<a href="#" onclick="javascript:openUploadFile();">Upload File</a>
					</span>	
				</c:if>
			</td></tr>
		</table>
	</div>
	<div>
		<table id="dmsDocsCheckListTableId" border="1" cellpadding="0" cellspacing="1" class="dataGrid" style="width: 100%">
			<thead>
				<tr>
					<td width="2%">
						<span class="ClsLabel"><fmt:message	key="dmsattachment.manage.label.sno" /> </span>
					</td>
					<td width="30%">
						<span class="ClsLabel"><fmt:message key="dmsattachment.manage.label.fileName" /> </span>
					</td>
					<td width="40%"><span class="ClsLabel"><fmt:message key="dms.manage.label.DocumentType"/></td>
					<td width="8%"><span class="ClsLabel"><fmt:message key="dmsattachment.manage.label.uploaddate"/></td>
					<td width="8%">
						<span class="ClsLabel"><fmt:message key="dmsattachment.manage.label.operations" /> </span>
					</td>	
				</tr>
			</thead>
			<tbody id="dmsDocsBodyId">	
				<c:choose>
					<c:when test="${not empty requestScope.dmsDocumentsList}">
						<input type="hidden" id="viewFirstUploadedFile" name="viewFirstUploadedFile" value="1" >
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
									
								<%-- 	<a  href="#"    onclick="javascript:downloadDmsDocument('<c:out value="${dmsDocument.dmsUuid}"/>');" alt="File Download">
										<img src="<c:out value="${contextRoot}"/>/images/file_download.png" alt="File Download"/>
					                </a>  --%>
									 <c:if test="${ empty fileCreation.isFileParked || fileCreation.isFileParked == 0 }">
										 <c:choose>
											 <c:when test ="${IS_MY_TASK eq true}">										   
												<a href="#" onclick="javascript:viewUploadedFile('<c:out value="${dmsDocument.dmsUuid}"/>');" alt="File View" >
													<img src="<c:out value="${contextRoot}"/>/images/Ico_Print.gif" alt="File View"/>	
											 	</a>										 
											 </c:when>
											 <c:otherwise>
											    <%-- <a  href="#"    onclick="javascript:downloadDmsDocument('<c:out value="${dmsDocument.dmsUuid}"/>');" alt="File Download">
													<img src="<c:out value="${contextRoot}"/>/images/file_download.png" alt="File Download"/>
						               			 </a> --%>
						               			 
												<%-- <a href="#" onclick="javascript:showDmsDocument('<c:out value="${dmsDocument.dmsUuid}"/>');" alt="File View">
													<img src="<c:out value="${contextRoot}"/>/images/Ico_Print.gif" alt="File View"/>
												</a> --%>
												
												<a href="#" onclick="javascript:showDmsDocumentOnPopup('<c:out value="${dmsDocument.dmsUuid}"/>');" alt="File View">
													<img src="<c:out value="${contextRoot}"/>/images/Ico_Print.gif" alt="File View"/>
												</a>
											 </c:otherwise>
										 </c:choose>
									 </c:if>
									<%-- <a href="#" onclick="javascript:showDmsDocument('<c:out value="${dmsDocument.dmsUuid}"/>');" alt="File View"/>
										<img src="<c:out value="${contextRoot}"/>/images/Ico_Print.gif" alt="File View"/>  --%>
									
									<%--  <a href="#" onclick="javascript:viewUploadedFile('<c:out value="${dmsDocument.dmsUuid}"/>');" alt="File View" >
										<img src="<c:out value="${contextRoot}"/>/images/Ico_Print.gif" alt="File View"/>	
									 </a> --%>
									
									 <%-- <c:if test="${pageScope.APPL_STATUS_NEW eq fileCreation.finalStatus}">
										<a href="#" onclick="javascript:deleteDmsDocument('<c:out value="${dmsDocument.dmsUuid}"/>',<c:out value="${dmsDocument.dmsDocumentId}"/>);" alt="File Delete">
											<img src="<c:out value="${contextRoot}"/>/images/file_delete.png" alt="File Delete"/>
										</a>		
									 </c:if> --%>								
								</td>
							</tr> 
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr><td colspan=5  class="clsNoRecords" align="center">
						    <input type="hidden" id="viewFirstUploadedFile" name="viewFirstUploadedFile" value="" >
							<fmt:message key="list.label.norecords"/>
						</td></tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
			<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>" />
	</div>
	
	<!-- DMS Documents Attachments code End-->
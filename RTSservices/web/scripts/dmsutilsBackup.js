function updateDmsDocsList(data) {
	dwr.util.removeAllRows("dmsDocsBodyId");
	var arrContents = [];
	var sno = 0;
	if (data != null && data.length > 0) {
		dwr.util.addRows("dmsDocsBodyId", data, [function (dmsDocument) {
			sno = sno+1; 
			return ""+sno;
		}, function (dmsDocument) {
			return dmsDocument.fileName;
		}, function(dmsDocument) {
			return dmsDocument.dmsDocumentType;			
		}, function(dmsDocument) {
			return dmsDocument.uploadedDate;			
		}, function (dmsDocument) {
			var opr = "<a href='#' onclick=\"javascript:downloadDmsDocument('" + dmsDocument.dmsUuid + "');\" title=\"File Download\"/><img src=\"" + getContextRoot() + "/images/file_download.png\" alt=\"File Download\"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick=\"javascript:deleteDmsDocument('" + dmsDocument.dmsUuid + "','" + dmsDocument.dmsDocumentId + "');\" title=\"Delete File\"/><img src=\"" + getContextRoot() + "/images/file_delete.png\" alt=\"Delete File\"/></a>";
			return opr;
		}], {escapeHtml:false});
	}
}

function updateDmsDockCheckList(data) {
	dwr.util.removeAllRows("dmsDocsCheckListBodyId");
	var arrContents = [];
	var sno = 0;
	if (data != null && data.length > 0) {
		dwr.util.addRows("dmsDocsCheckListBodyId", data, [function (documentMaster) {
			sno = sno+1; 
			return ""+sno;
		}, function (documentMaster) {
			var docDesc = documentMaster.description;
			if(documentMaster.mandatory == 1)
				docDesc = docDesc + "<span class=\"ClsRequiredFields\">*</span>";
			
			return docDesc;
		},function(documentMaster) {
			var availableOpr = "<img src=\""+getContextRoot()+"/images/Green_Check.gif\" alt=\"Document Uplaoded\"/>";
			var notAvailableOpr = "<img src=\""+getContextRoot()+"/images/Ico_Delete.gif\" alt=\"Document Not Uploaded\"/>";
			if(documentMaster.dmsDocumentCheckListId > 0)
				return availableOpr;
			else
				return notAvailableOpr;			
		},function(documentMaster) {
			return documentMaster.fileName;			
		},function(documentMaster) {
			return documentMaster.uploadedDate;			
		},function (documentMaster) {
			var editOpr = "<a href='#' onclick=\"javascript:downloadDmsDocument('" + documentMaster.dmsUuid + "');\" title=\"File Download\"/><img src=\"" + getContextRoot() + "/images/file_download.png\" alt=\"File Download\"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick=\"javascript:deleteDmsDocumentCheckList('" + documentMaster.dmsUuid + "','" + documentMaster.dmsDocumentCheckListId + "');\" title=\"Delete File\"/><img src=\"" + getContextRoot() + "/images/file_delete.png\" alt=\"Delete File\"/></a>";
			var newOpr="<span class=\"ClsSubmenuTitle\" id=\"span_upload_files\" style=\"display:block\"><a href='#' onclick=\"javascript:openUploadFile('"+documentMaster.documentMasterId+"','"+documentMaster.dmsDocumentType+"');\"/>Upload File</a></span>";
			
			if(documentMaster.dmsDocumentCheckListId > 0)
				return editOpr;
			else
				return newOpr;
		}], {escapeHtml:false});
	}
}

function deleteDmsDocument(uuid, dmsDocumentId) {
	$(".error").css("display", "none");
	if (confirm("Are you sure you wish to delete this file?")) {
		dmsDocument.deleteFileDocument(uuid, dmsDocumentId, messageData);
	}
}

function deleteDmsDocumentCheckList(uuid, dmsDocumentCheckListId) {
	$(".error").css("display", "none");
	if (confirm("Are you sure you wish to delete this file?")) {
		dmsDocumentCheckList.deleteFileDocument(uuid, dmsDocumentCheckListId, messageData);
	}
}

function messageData() {
	closeDialog("File Deleted Successfully");
}


function downloadDmsDocument(dmsUuid) {
	document.getElementById('uuid').value=dmsUuid;
	onPageSubmit(contextRoot + '/fileupload/downloadFile.do');
}



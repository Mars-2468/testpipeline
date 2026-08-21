function updateDmsDocsList(data) {
	dwr.util.removeAllRows("dmsDocsBodyId");
	var arrContents = [];
	var sno = 0;
	if (data != null && data.length > 0) {
		dwr.util.addRows("dmsDocsBodyId", data, [function (dmsDocumentMaster) {
			sno = sno+1; 
			return ""+sno;
		}, function (dmsDocumentMaster) {
			return dmsDocumentMaster.fileName;
		}, function(dmsDocumentMaster) {
			return dmsDocumentMaster.dmsDocumentType;			
		}, function(dmsDocumentMaster) {
			return dmsDocumentMaster.uploadedDate;			
		}, function (dmsDocumentMaster) {
			var opr = "<a href='#' onclick=\"javascript:downloadDmsDocument('" + dmsDocumentMaster.dmsUuid + "');\" title=\"File Download\"/><img src=\"" + getContextRoot() + "/images/file_download.png\" alt=\"File Download\"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick=\"javascript:showDmsDocument('" + dmsDocumentMaster.dmsUuid + "');\" title=\"File Download\"/><img src=\"" + getContextRoot() + "/images/Ico_Print.gif\" alt=\"File Download\"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick=\"javascript:deleteDmsDocument('" + dmsDocumentMaster.dmsUuid + "','" + dmsDocumentMaster.dmsDocumentId + "');\" title=\"Delete File\"/><img src=\"" + getContextRoot() + "/images/file_delete.png\" alt=\"Delete File\"/></a>";
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
			var editOpr = "<a href='#' onclick=\"javascript:downloadDmsDocument('" + documentMaster.dmsUuid + "');\" title=\"File Download\"/><img src=\"" + getContextRoot() + "/images/file_download.png\" alt=\"File Download\"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick=\"javascript:showDmsDocument('" + documentMaster.dmsUuid + "');\" title=\"File Download\"/><img src=\"" + getContextRoot() + "/images/Ico_Print.gif\" alt=\"File Download\"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick=\"javascript:deleteDmsDocumentCheckList('" + documentMaster.dmsUuid + "','" + documentMaster.dmsDocumentCheckListId + "');\" title=\"Delete File\"/><img src=\"" + getContextRoot() + "/images/file_delete.png\" alt=\"Delete File\"/></a>";
			
			var newOpr="<span class=\"ClsSubmenuTitle\" id=\"span_upload_files\" style=\"display:block\"><a href='#' onclick=\"javascript:openUploadFile('"+documentMaster.dmsDocumentCheckListId +"','"+ documentMaster.documentMasterId+"','"+documentMaster.dmsDocumentType+"');\"/>Upload File</a></span>";
			
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
	CommonServiceDWR.deleteFileDocument(uuid, dmsDocumentId, messageData);
	}
}

function deleteDmsDocumentCheckList(uuid, dmsDocumentCheckListId) {
	$(".error").css("display", "none");
	if (confirm("Are you sure you wish to delete this file?")) {
		CommonServiceDWR.deleteCheckListFileDocument(uuid, dmsDocumentCheckListId, messageData);
		
	}
}

function messageData() {
	closeDialog("File Deleted Successfully");
}


function downloadDmsDocument(dmsUuid) {
	//alert(dmsUuid);
	alert('Are you sure you download this file');
	document.getElementById('uuid').value=dmsUuid;
	if(dmsUuid != null){
	onPageSubmit(contextRoot + '/fileupload/downloadFile.do');
	}
}

function downloadDmsDocumentCitizen(dmsUuid) {
	//alert(dmsUuid);
	if(dmsUuid != null && dmsUuid !=''){
	alert('Are you sure you download this file');
	document.getElementById('uuid').value=dmsUuid;
	onPageSubmit(contextRoot + '/fileupload/downloadFile.do');
}
else{
	alert('Department is Not Issued License Certificate');
    return false;
}
}

function showDmsDocument(dmsUuid) {
	
	//alert('Are you sure you download this file');
	//onPageSubmit(contextRoot + '/fileupload/showFile.do');
	
	$('.error').css('display','none');
	var  selectedDocumentType = "";
	try{
		
		var dmsid=document.getElementById('uuid').value=dmsUuid;
		document.getElementById('managePopupFolder').src=contextRoot+"/fileupload/showFile.do?uuid="+dmsid;
		//'/fileupload/showFile.do?uuid='+dmsUuid;
	 	//$('#dialogFolder').dialog( "option", "title", 'Upload File' );
	     $("#dialogFolder").dialog({
	    	 title : "Showing Document..",
	    	 buttons :[{
					text : '',
					click: function() {
						downloadDmsDocument(dmsUuid);
			           /*  $( this ).dialog( "close" );*/
			         }
				}]
	    	 
	     });
	     $('#dialogFolder').dialog('open');
	   
	 	}catch(e){
	 	alert(e);
	 	}	
}

function showDmsDocumentOnPopup(dmsUuid) {
	
	//alert(dmsUuid);
	//onPageSubmit(contextRoot + '/fileupload/showFile.do');
	
	$('.error').css('display','none');
	var  selectedDocumentType = "";
	try{
		
		var dmsid=document.getElementById('uuid').value=dmsUuid;
		document.getElementById('managePopupFolderShow').src=contextRoot+"/fileupload/showFile.do?uuid="+dmsid;
		//'/fileupload/showFile.do?uuid='+dmsUuid;
	 	//$('#dialogFolder').dialog( "option", "title", 'Upload File' );
	     $("#dialogFolderShow").dialog({
	    	 title : "Showing Document..",
	    	 bgiframe: true,
			 autoOpen: false,
		 	 height: 550,
		 	 resizable:false,
			 width:900,
			 modal: false,
	    	 buttons :[{
					text : '',
					click: function() {
						downloadDmsDocument(dmsUuid);			            
			         }
				}]
	    	 
	     });
	     $('#dialogFolderShow').dialog('open');
	   
	 	}catch(e){
	 	alert(e);
	 	}	
}


$(function() {
	document.getElementById("dialogFolder").style.display='';
	$("#dialogFolder").dialog({
		bgiframe: true,
		autoOpen: false,
		height: 500,
		resizable:true,
		width:1000,
		modal: true
		
	});
	
	document.getElementById("dialogFolderShow").style.display='';
	$("#dialogFolderShow").dialog({
		bgiframe: true,
		autoOpen: false,
		height: 500,
		resizable:true,
		width:1000,
		modal: true
		
	});
	
	
	
	
});

function updateDmsDocsListCitizen(data) {
	dwr.util.removeAllRows("dmsDocsBodyId");
	var arrContents = [];
	var sno = 0;
	if (data != null && data.length > 0) {
		dwr.util.addRows("dmsDocsBodyId", data, [function (dmsDocumentMaster) {
			sno = sno+1; 
			return ""+sno;
		}, function (dmsDocumentMaster) {
			return dmsDocumentMaster.fileName;
		}, function(dmsDocumentMaster) {
			return dmsDocumentMaster.dmsDocumentType;			
		}, function(dmsDocumentMaster) {
			return dmsDocumentMaster.uploadedDate;			
		}, function (dmsDocumentMaster) {
			var opr = "<a href='#' onclick=\"javascript:downloadDmsDocument('" + dmsDocumentMaster.dmsUuid + "');\" title=\"File Download\"/><img src=\"" + getContextRoot() + "/images/file_download.png\" alt=\"File Download\"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick=\"javascript:deleteDmsDocument('" + dmsDocumentMaster.dmsUuid + "','" + dmsDocumentMaster.dmsDocumentId + "');\" title=\"Delete File\"/><img src=\"" + getContextRoot() + "/images/file_delete.png\" alt=\"Delete File\"/></a>";
			return opr;
		}], {escapeHtml:false});
		$('#uploadlink').attr("onclick", "javascript:void(0)");
	}else{
		$('#uploadlink').attr("onclick", "javascript:openUploadFile()");	
	}
}



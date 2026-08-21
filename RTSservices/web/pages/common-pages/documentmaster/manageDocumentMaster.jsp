<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants"/>
<jsp:directive.page import="com.mars.common.utils.CommonUtils"/>
<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	pageContext.setAttribute("SESSION_TOKEN_KEY",Constants.SESSION_TOKEN_KEY);
	
  	pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
    pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
    pageContext.setAttribute("STATUS_YES_LABEL",Constants.STATUS_YES_LABEL);
    pageContext.setAttribute("STATUS_NO_LABEL",Constants.STATUS_NO_LABEL);
    
    pageContext.setAttribute("DOCUMENT_TYPE_GENERAL", Constants.DOCUMENT_TYPE_GENERAL);
    pageContext.setAttribute("DOCUMENT_TYPE_FIELD_VERIFICATION", Constants.DOCUMENT_TYPE_FIELD_VERIFICATION);
    pageContext.setAttribute("DOCUMENT_TYPE_GENERAL_LABEL",Constants.DOCUMENT_TYPE_GENERAL_LABEL);
    pageContext.setAttribute("DOCUMENT_TYPE_FIELD_VERIFICATION_LABEL",Constants.DOCUMENT_TYPE_FIELD_VERIFICATION_LABEL);
    pageContext.setAttribute("getInputTypes", CommonUtils.getInputTypes());
%>
<div class="mainHdr">
	<h3> 
		<c:choose>
			<c:when test="${documentMaster.documentMasterId==0}"><fmt:message key="documentMaster.manage.pagetitle.new" /></c:when>
			<c:otherwise><fmt:message key="documentMaster.manage.pagetitle.edit" /></c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top" id="SetFormHeight">
<table border="0" cellpadding="2" cellspacing="2" class="dataForm">
<tr>
<td colspan="2">
<spring:bind path="documentMaster.documentMasterId">
<input type="hidden" id="documentMasterId" name="documentMasterId" value="<c:out value="${documentMaster.documentMasterId}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="documentMaster.manage.label.description"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="documentMaster.description">
<input style="width: 300px" type="text" class="ClsTextbox" id="description" maxlength="255" name="description" value="<c:out value="${documentMaster.description}"/>" />
</spring:bind>
</td>
<td>
<spring:bind path="documentMaster.status">
<input type="hidden" id="status" maxlength="1" name="status" value="<c:out value="${documentMaster.status}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="documentMaster.manage.label.stage"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="documentMaster.stage.stageId">
<select name="stageId" id="stageId" class="ClsTextbox" style="width:300px;">
<option value=""> <--- Select ---> </option>
<c:forEach var="stage" items="${requestScope.stageList}">
<c:choose>
<c:when test="${documentMaster.stage.stageId==stage.stageId}">
<option value="${stage.stageId}" selected="selected">
<c:out value="${stage.description}"/>
</option>
</c:when>
<c:otherwise>
<option value="${stage.stageId}">
<c:out value="${stage.description}"/>
</option>
</c:otherwise>
</c:choose>
</c:forEach>
</select>
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="documentMaster.manage.label.mandatory"/></span></td>
<td>
<spring:bind path="documentMaster.mandatory">
<input type="radio"	id="mandatory<c:out value="${pageScope.STATUS_YES_LABEL}"/>"
				name="mandatory" value="<c:out value="${pageScope.STATUS_YES}"/>" />
			<c:out value="${pageScope.STATUS_YES_LABEL}" />
			<input type="radio"
				id="mandatory<c:out value="${pageScope.STATUS_NO_LABEL}"/>"
				name="mandatory" value="<c:out value="${pageScope.STATUS_NO}"/>" checked="checked" />
			<c:out value="${pageScope.STATUS_NO_LABEL}" />
			<c:if test="${documentMaster.mandatory == pageScope.STATUS_YES}">
				<script>
							document.getElementById('mandatory<c:out value="${pageScope.STATUS_YES_LABEL}"/>').checked= "checked" ;
						</script>
			</c:if>
			<c:if test="${documentMaster.mandatory == pageScope.STATUS_NO}">
				<script>
							document.getElementById('mandatory<c:out value="${pageScope.STATUS_NO_LABEL}"/>').checked= "checked" ;
						</script>
			</c:if>
</spring:bind>
</td>
</tr>
<tr>
<td><span class="ClsLabel"><fmt:message key="documentMaster.manage.label.documentType"/></span></td>
<td>
<input type="radio" id="documentType<c:out value="${pageScope.DOCUMENT_TYPE_GENERAL_LABEL}"/>" onchange="getChangeType();" name="documentType" value="<c:out value="${pageScope.DOCUMENT_TYPE_GENERAL}"/>" <c:if test="${documentMaster.documentType==pageScope.DOCUMENT_TYPE_GENERAL}">checked="checked"</c:if> /><c:out value="${pageScope.DOCUMENT_TYPE_GENERAL_LABEL}"/>
<input type="radio" id="documentType<c:out value="${pageScope.DOCUMENT_TYPE_FIELD_VERIFICATION_LABEL}"/>" onchange="getChangeType();" name="documentType" value="<c:out value="${pageScope.DOCUMENT_TYPE_FIELD_VERIFICATION}"/>" <c:if test="${documentMaster.documentType==pageScope.DOCUMENT_TYPE_FIELD_VERIFICATION}">checked="checked"</c:if> /><c:out value="${pageScope.DOCUMENT_TYPE_FIELD_VERIFICATION_LABEL}"/>
</td>
</tr>
<tr id="rowInputType">
<td><span class="ClsLabel"><fmt:message key="documentMaster.manage.label.inputType"/></span><span class="ClsRequiredFields">*</span></td>
<td><select id="inputType" name="inputType" style="width:100px;">
			<option value=""><- Select -></option>
            <c:forEach var="inputType" items="${pageScope.getInputTypes}" varStatus="inputTypeIndex">
                 <option value="<c:out value="${inputTypeIndex.index}"/>" <c:if test="${documentMaster.inputType==inputTypeIndex.index}">selected="selected"</c:if>>
                   <c:out value="${inputType}" />
                 </option>
		</c:forEach>
</select>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="dmsattachment.manage.label.dmsdoctype"/></span></td>
<td>
<spring:bind path="documentMaster.dmsDocumentType">
<input type="text" style="width: 300px" class="ClsTextbox" id="dmsDocumentType" maxlength="50" name="dmsDocumentType" value="<c:out value="${documentMaster.dmsDocumentType}"/>" />
</spring:bind>
</td>
</tr>
<tr><td  colspan="2" style="padding-top:5px"></td></tr>
<tr><td></td>
<td>
<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveDocumentMaster(this.form);">
<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
<c:if test="${documentMaster.documentMasterId!=0}">
<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deleteDocumentMaster(this.form);">
</c:if>
</tr>
</table>
</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/><script type="text/javascript">
function saveDocumentMaster(frm)
{
	var arrRequiredElements=new Array('description','stageId');
	var arrRequiredElementsMessages=new Array('<fmt:message key="documentMaster.manage.label.description"/>',
											  '<fmt:message key="documentMaster.manage.label.stage"/>');
	if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages))
		{	
		if(validateInputType()){
		/* if(isAlphaNumericSpecial(new Array('description'),new Array('<fmt:message key="documentMaster.manage.label.description"/>'), '. -_/()'))
			{ */	
			if(isAlphaUndrsc(new Array('description'),new Array('<fmt:message key="documentMaster.manage.label.description"/>'))){		

			navigate(frm,'<c:out value="${contextRoot}"/>/documentmaster/saveDocumentMaster.do');
			//}
		}
		}
		}
}
</script><script type="text/javascript">
function deleteDocumentMaster(id)
{
if(confirmDelete()){
	onPageSubmit('<c:out value="${contextRoot}"/>/documentmaster/deleteDocumentMaster.do');
}
}

function getChangeType(){
	 var documentType = document.getElementsByName("documentType");	

	 	if(documentType[0].checked){		
		 document.getElementById("rowInputType").style.display='none';
		 document.getElementById("inputType").disabled=true;		 		
		
	 	 }else if(documentType[1].checked){
	 		 document.getElementById("rowInputType").style.display='table-row';
			 document.getElementById("inputType").disabled=false;				 	
		}		
}

function validateInputType(){
	 var documentType = document.getElementsByName("documentType");	

	 	 if(documentType[1].checked){	 		
			 if(checkMandatoryDetailed(new Array('inputType'),
					 new Array('<fmt:message key="documentMaster.manage.label.inputType"/>'))){
				 return true;
				 }
			 return false;
		}	
	 	return true;
}

getChangeType();
</script>
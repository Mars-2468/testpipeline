<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>
<%
	    pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
%>
<style>
   .branch{
      display: none;
   }
 </style>
 <div class="mainHdr">
	<h3> 
		<c:choose>
			<c:when test="${role.roleId==0}"><fmt:message key="role.manage.pagetitle.new" /></c:when>
			<c:otherwise><fmt:message key="role.manage.pagetitle.edit" /></c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top"  id="SetFormHeight">
	<table border="0" cellpadding="1" cellspacing="1" width="98%" class="dataForm">
		<tr>
			<td colspan="2">
				<spring:bind path="role.roleId">
					<input type="hidden" id="roleId" name="roleId" value="<c:out value="${role.roleId}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
<!----> 			<td colspan="4"> 
 				 <td width="100px">
				<span class="ClsLabel"><fmt:message key="role.label.role_name" />:</span><span class="ClsRequiredFields">*</span></td>
				<td>
				<spring:bind path="role.role_name">
				<input type="text" class="ClsTextbox" id="role_name" maxlength="50" size="30" name="role_name" value="<c:out value="${role.role_name}"/>"
					<c:if test="${role.roleId!=0}"> </c:if>/>
				</spring:bind>
			</td> 
		</tr>

		<tr>
			<td colspan="4" style="padding-top:5px" height="10px"></td>
		</tr>
		<%-- <tr>
			<td colspan="2" align="center">
				<input type="button" class="ClsButton" id="save" name="save" value="<fmt:message key="common.button.save"/>" onclick="javascript:saveRole(this.form);">
				<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearContorls();">
				<c:if test="${role.roleId!=0}">
					<input type="button" class="ClsButton" id="delete" name="delete" value="<fmt:message key="common.button.delete"/>" onclick="javascript:deleteRole(this.form);">
				</c:if>
			</td>
		</tr>--%>
		<!-- Start of +/- DIv -->
		<tr>
			<td colspan="4">
				<p>
					<span class="ClsLabel"> <fmt:message key="role.manage.label.permissions" />: </span>
					<br />
					<br />
				</p>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<table border="0" cellpadding="1" cellspacing="1" width="100%">
					<tr>
						<td valign="top" width="25%" wrap>
							<c:if test="${not empty requestScope.permissionGroupList1}">
								<a href="javascript:expandOrCollapseChildren('groupTreeId1','expand');">Expand All </a> &nbsp;&nbsp;&nbsp;
								<a href="javascript:expandOrCollapseChildren('groupTreeId1','collapse');">Collpase All </a>
								<BR>
								<div id="groupTreeId1">
									<c:forEach var="permissionGroup" items="${requestScope.permissionGroupList1}" varStatus="gCount">
										<c:if test="${not empty permissionGroup.permissionSet}">
											<img src="<c:out value="${contextRoot}"/>/images/closed.gif" border="0" id="permissionGroupImage1<c:out value="${gCount.index+1}"/>"
												onClick="showChildren('permissionBranch1<c:out value="${gCount.index+1}"/>');changeImage('<c:out value="${contextRoot}"/>','permissionGroupImage1<c:out value="${gCount.index+1}"/>')">
											<c:choose>
												<c:when test="${permissionGroup.checked == true}">
													<input type="checkBox" name="permissionGroupCheck1<c:out value="${gCount.index+1}"/>" id="permissionGroupCheck1<c:out value="${gCount.index+1}"/>"
														onclick="ToggleAllById('permissionGroupCheck1<c:out value="${gCount.index+1}"/>','permissionCheck1<c:out value="${gCount.index+1}"/>');" checked />
													<c:out value="${permissionGroup.name}" />
												</c:when>
												<c:otherwise>
													<input type="checkBox" name="permissionGroupCheck1<c:out value="${gCount.index+1}"/>" id="permissionGroupCheck1<c:out value="${gCount.index+1}"/>"
														onclick="ToggleAllById('permissionGroupCheck1<c:out value="${gCount.index+1}"/>','permissionCheck1<c:out value="${gCount.index+1}"/>');" />
													<c:out value="${permissionGroup.name}" />
													<sup>
														#
													</sup>
												</c:otherwise>
											</c:choose>
											<br>
											<span class="branch" id="permissionBranch1<c:out value="${gCount.index+1}"/>" style="display : none;padding-left:35px"> 
											<c:forEach var="permission" items="${permissionGroup.permissionSet}">
												<input type="hidden" id="role.rolePermissionSet.rolePermissionId" name="role.rolePermissionSet.rolePermissionId" value="<c:out value="${permission.assignedRolePermissionId}"/>" />
												<input type="hidden" id="role.rolePermissionSet.permission" name="role.rolePermissionSet.permission" value="<c:out value="${permission.permissionId}"/>" />
												<c:choose>
													<c:when test="${permission.assignedRolePermissionId > 0}">
														<input type="checkBox" name="permissionCheck" id="permissionCheck1<c:out value="${gCount.index+1}"/>" value="<c:out value="${permission.permissionId}"/>"
															onclick="ToggleById('permissionCheck1<c:out value="${gCount.index+1}"/>','permissionGroupCheck1<c:out value="${gCount.index+1}"/>');" checked />
													</c:when>
													<c:otherwise>
														<input type="checkBox" name="permissionCheck" id="permissionCheck1<c:out value="${gCount.index+1}"/>" value="<c:out value="${permission.permissionId}"/>"
															onclick="ToggleById('permissionCheck1<c:out value="${gCount.index+1}"/>','permissionGroupCheck1<c:out value="${gCount.index+1}"/>');" />
													</c:otherwise>
												</c:choose>
												<c:out value="${permission.linkName}" />
												<br>
											</c:forEach> </span>
										</c:if>
									</c:forEach>
								</div>
							</c:if>
						</td>
						<td valign="top" width="25%" wrap>
							<c:if test="${not empty requestScope.permissionGroupList2}">
								<a href="javascript:expandOrCollapseChildren('groupTreeId2','expand');">Expand All </a> &nbsp;&nbsp;&nbsp;
								<a href="javascript:expandOrCollapseChildren('groupTreeId2','collapse');">Collpase All </a>
								<BR>
								<div id="groupTreeId2">
									<c:forEach var="permissionGroup" items="${requestScope.permissionGroupList2}" varStatus="gCount">
										<c:if test="${not empty permissionGroup.permissionSet}">
											<img src="<c:out value="${contextRoot}"/>/images/closed.gif" border="0" id="permissionGroupImage2<c:out value="${gCount.index+1}"/>"
												onClick="showChildren('permissionBranch2<c:out value="${gCount.index+1}"/>');changeImage('<c:out value="${contextRoot}"/>','permissionGroupImage2<c:out value="${gCount.index+1}"/>')">
											<c:choose>
												<c:when test="${permissionGroup.checked == true}">
													<input type="checkBox" name="permissionGroupCheck2<c:out value="${gCount.index+1}"/>" id="permissionGroupCheck2<c:out value="${gCount.index+1}"/>"
														onclick="ToggleAllById('permissionGroupCheck2<c:out value="${gCount.index+1}"/>','permissionCheck2<c:out value="${gCount.index+1}"/>');" checked />
													<c:out value="${permissionGroup.name}" />
												</c:when>
												<c:otherwise>
													<input type="checkBox" name="permissionGroupCheck2<c:out value="${gCount.index+1}"/>" id="permissionGroupCheck2<c:out value="${gCount.index+1}"/>"
														onclick="ToggleAllById('permissionGroupCheck2<c:out value="${gCount.index+1}"/>','permissionCheck2<c:out value="${gCount.index+1}"/>');" />
													<c:out value="${permissionGroup.name}" />
													<sup>
														#
													</sup>
												</c:otherwise>
											</c:choose>

											<br>
											<span class="branch" id="permissionBranch2<c:out value="${gCount.index+1}"/>" style="display : none;padding-left:35px"> 
											<c:forEach var="permission" items="${permissionGroup.permissionSet}">
												<input type="hidden" id="role.rolePermissionSet.rolePermissionId" name="role.rolePermissionSet.rolePermissionId" value="<c:out value="${permission.assignedRolePermissionId}"/>" />
												<input type="hidden" id="role.rolePermissionSet.permission" name="role.rolePermissionSet.permission" value="<c:out value="${permission.permissionId}"/>" />
												<c:choose>
													<c:when test="${permission.assignedRolePermissionId > 0}">
														<input type="checkBox" name="permissionCheck" id="permissionCheck2<c:out value="${gCount.index+1}"/>" value="<c:out value="${permission.permissionId}"/>"
															onclick="ToggleById('permissionCheck2<c:out value="${gCount.index+1}"/>','permissionGroupCheck2<c:out value="${gCount.index+1}"/>');" checked />
													</c:when>
													<c:otherwise>
														<input type="checkBox" name="permissionCheck" id="permissionCheck2<c:out value="${gCount.index+1}"/>" value="<c:out value="${permission.permissionId}"/>"
															onclick="ToggleById('permissionCheck2<c:out value="${gCount.index+1}"/>','permissionGroupCheck2<c:out value="${gCount.index+1}"/>');" />
													</c:otherwise>
												</c:choose>
												<c:out value="${permission.linkName}" />
												<br>
											</c:forEach> </span>
										</c:if>
									</c:forEach>
								</div>
							</c:if>
						</td>

						<td valign="top" width="25%" wrap>
							<c:if test="${not empty requestScope.permissionGroupList3}">
								<a href="javascript:expandOrCollapseChildren('groupTreeId3','expand');">Expand All </a> &nbsp;&nbsp;&nbsp;
								<a href="javascript:expandOrCollapseChildren('groupTreeId3','collapse');">Collpase All </a>
								<BR>
								<div id="groupTreeId3">
										<c:forEach var="permissionGroup" items="${requestScope.permissionGroupList3}" varStatus="gCount">
											<c:if test="${not empty permissionGroup.permissionSet}">
												<img src="<c:out value="${contextRoot}"/>/images/closed.gif" border="0" id="permissionGroupImage3<c:out value="${gCount.index+1}"/>"
													onClick="showChildren('permissionBranch3<c:out value="${gCount.index+1}"/>');changeImage('<c:out value="${contextRoot}"/>','permissionGroupImage3<c:out value="${gCount.index+1}"/>')">
												<c:choose>
													<c:when test="${permissionGroup.checked == true}">
														<input type="checkBox" name="permissionGroupCheck3<c:out value="${gCount.index+1}"/>" id="permissionGroupCheck3<c:out value="${gCount.index+1}"/>"
															onclick="ToggleAllById('permissionGroupCheck3<c:out value="${gCount.index+1}"/>','permissionCheck3<c:out value="${gCount.index+1}"/>');" checked />
														<c:out value="${permissionGroup.name}" />
													</c:when>
													<c:otherwise>
														<input type="checkBox" name="permissionGroupCheck3<c:out value="${gCount.index+1}"/>" id="permissionGroupCheck3<c:out value="${gCount.index+1}"/>"
															onclick="ToggleAllById('permissionGroupCheck3<c:out value="${gCount.index+1}"/>','permissionCheck3<c:out value="${gCount.index+1}"/>');" />
														<c:out value="${permissionGroup.name}" />
														<sup>
															#
														</sup>
													</c:otherwise>
												</c:choose>
												<br>
												<span class="branch" id="permissionBranch3<c:out value="${gCount.index+1}"/>" style="display : none;padding-left:35px"> 
												<c:forEach var="permission" items="${permissionGroup.permissionSet}">
													<input type="hidden" id="role.rolePermissionSet.rolePermissionId" name="role.rolePermissionSet.rolePermissionId" value="<c:out value="${permission.assignedRolePermissionId}"/>" />
													<input type="hidden" id="role.rolePermissionSet.permission" name="role.rolePermissionSet.permission" value="<c:out value="${permission.permissionId}"/>" />
													<c:choose>
														<c:when test="${permission.assignedRolePermissionId > 0}">
															<input type="checkBox" name="permissionCheck" id="permissionCheck3<c:out value="${gCount.index+1}"/>" value="<c:out value="${permission.permissionId}"/>"
																onclick="ToggleById('permissionCheck3<c:out value="${gCount.index+1}"/>','permissionGroupCheck3<c:out value="${gCount.index+1}"/>');" checked />
														</c:when>
														<c:otherwise>
															<input type="checkBox" name="permissionCheck" id="permissionCheck3<c:out value="${gCount.index+1}"/>" value="<c:out value="${permission.permissionId}"/>"
																onclick="ToggleById('permissionCheck3<c:out value="${gCount.index+1}"/>','permissionGroupCheck3<c:out value="${gCount.index+1}"/>');" />
														</c:otherwise>
													</c:choose>
													<c:out value="${permission.linkName}" />
													<br>
												</c:forEach> </span>
											</c:if>
										</c:forEach>
								</div>
							</c:if>
						</td>

						<td valign="top" width="25%" wrap>
							<c:if test="${not empty requestScope.permissionGroupList4}">
								<a href="javascript:expandOrCollapseChildren('groupTreeId4','expand');">Expand All </a> &nbsp;&nbsp;&nbsp;
								<a href="javascript:expandOrCollapseChildren('groupTreeId4','collapse');">Collpase All </a>
								<BR>
								<div id="groupTreeId4">
									<c:forEach var="permissionGroup" items="${requestScope.permissionGroupList4}" varStatus="gCount">
										<c:if test="${not empty permissionGroup.permissionSet}">
											<img src="<c:out value="${contextRoot}"/>/images/closed.gif" border="0" id="permissionGroupImage4<c:out value="${gCount.index+1}"/>"
												onClick="showChildren('permissionBranch4<c:out value="${gCount.index+1}"/>');changeImage('<c:out value="${contextRoot}"/>','permissionGroupImage4<c:out value="${gCount.index+1}"/>')">
											<c:choose>
												<c:when test="${permissionGroup.checked == true}">
													<input type="checkBox" name="permissionGroupCheck4<c:out value="${gCount.index+1}"/>" id="permissionGroupCheck4<c:out value="${gCount.index+1}"/>"
														onclick="ToggleAllById('permissionGroupCheck4<c:out value="${gCount.index+1}"/>','permissionCheck4<c:out value="${gCount.index+1}"/>');" checked />
													<c:out value="${permissionGroup.name}" />
												</c:when>
												<c:otherwise>
													<input type="checkBox" name="permissionGroupCheck4<c:out value="${gCount.index+1}"/>" id="permissionGroupCheck4<c:out value="${gCount.index+1}"/>"
														onclick="ToggleAllById('permissionGroupCheck4<c:out value="${gCount.index+1}"/>','permissionCheck4<c:out value="${gCount.index+1}"/>');" />
													<c:out value="${permissionGroup.name}" />
													<sup>
														#
													</sup>
												</c:otherwise>
											</c:choose>

											<br>
											<span class="branch" id="permissionBranch4<c:out value="${gCount.index+1}"/>" style="display : none;padding-left:35px"> 
											<c:forEach var="permission"	items="${permissionGroup.permissionSet}">
												<input type="hidden" id="role.rolePermissionSet.rolePermissionId" name="role.rolePermissionSet.rolePermissionId" value="<c:out value="${permission.assignedRolePermissionId}"/>" />
												<input type="hidden" id="role.rolePermissionSet.permission" name="role.rolePermissionSet.permission" value="<c:out value="${permission.permissionId}"/>" />
												<c:choose>
													<c:when test="${permission.assignedRolePermissionId > 0}">
														<input type="checkBox" name="permissionCheck" checked id="permissionCheck4<c:out value="${gCount.index+1}"/>" value="<c:out value="${permission.permissionId}"/>"
															onclick="ToggleById('permissionCheck4<c:out value="${gCount.index+1}"/>','permissionGroupCheck4<c:out value="${gCount.index+1}"/>');" />
													</c:when>
													<c:otherwise>
														<input type="checkBox" name="permissionCheck" id="permissionCheck4<c:out value="${gCount.index+1}"/>" value="<c:out value="${permission.permissionId}"/>"
															onclick="ToggleById('permissionCheck4<c:out value="${gCount.index+1}"/>','permissionGroupCheck4<c:out value="${gCount.index+1}"/>');" />
													</c:otherwise>
												</c:choose>
												<c:out value="${permission.linkName}" />
												<br>
											</c:forEach> </span>
										</c:if>
									</c:forEach>
								</div>
							</c:if>
						</td>
					</tr>
				</table>
			</td>
		</tr>

		<!-- End of +/- DIv -->
		<tr>
			<td colspan="4" style="padding-top:5px" height="10px"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" class="ClsButton" id="save" name="save" value="<fmt:message key="common.button.save"/>" onclick="javascript:saveRole(this.form);">
				<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearContorls();">
				<c:if test="${role.roleId!=0}">
					<input type="button" class="ClsButton" id="delete" name="delete" value="<fmt:message key="common.button.delete"/>" onclick="javascript:deleteRole(this.form);">
				</c:if>
			</td>
		</tr>
	</table>
	<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>" />
</div>
<input type="hidden" name="addPermissionIds" id="addPermissionIds" value="">

<script type="text/javascript">
function saveRole(frm)
{
	document.getElementById('idMsgBox').style.display='none';
	var arrElements=new Array('role_name');
	var arrElementNames=new Array('<fmt:message key="role.label.role_name"/>');
	var alphaArrayElements = new Array('role_name');
	var msgArrayElements = new Array('<fmt:message key="role.label.role_name"/>');

	if(checkMandatoryDetailed(arrElements,arrElementNames)) {
		if(isAlphanum(alphaArrayElements,msgArrayElements)) {
			if(isAlphaSpace(new Array('role_name'),new Array('<fmt:message key="role.label.role_name"/>'))){		

			document.getElementById('addPermissionIds').value=getSelectedValue('permissionCheck');
			navigate(frm,'<c:out value="${contextRoot}"/>/role/saveRole.do');
		}
		}	
	}
}

function deleteRole(id)
{
	if(confirmDelete()){
		onPageSubmit('<c:out value="${contextRoot}"/>/role/deleteRole.do');
	}
}

function expandOrCollapseChildren(groupId,status)
{
	if(document.getElementById(groupId))
	{
		var spantags=document.getElementById(groupId).getElementsByTagName("span");
		for (var i=0; i < spantags.length; i++)
		{
			if(status=='expand')
			{
				spantags[i].style.display="block";
			}
			else if (status=='collapse')
			{
				spantags[i].style.display="none";
			}
		}
		var imgtags=document.getElementById(groupId).getElementsByTagName("img");
		for (var j=0; j<imgtags.length; j++)
		{
			if(status=='expand')
			{
				imgtags[j].src="<c:out value="${contextRoot}"/>/images/open.gif";	
			}
			else if (status=='collapse')
			{
				imgtags[j].src="<c:out value="${contextRoot}"/>/images/closed.gif";
			}
		}
	}
}

</script>

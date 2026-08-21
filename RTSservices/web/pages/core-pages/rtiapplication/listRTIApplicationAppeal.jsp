<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page
	import="com.mars.common.utils.Constants" /><jsp:directive.page
	import="com.mars.common.utils.CommonUtils" />

<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	pageContext.setAttribute("SESSION_TOKEN_KEY",
			Constants.SESSION_TOKEN_KEY);
	pageContext.setAttribute("STATUS_NO_LABEL",
			Constants.STATUS_NO_LABEL);
	pageContext.setAttribute("STATUS_YES_LABEL",
			Constants.STATUS_YES_LABEL);
	pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
	pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
	///pageContext.setAttribute("statusList", CommonUtils.getStatus());
%>

<script type="text/javascript">
	function editRTIApplication(id) {
		document.getElementById('rtiApplicationId').value = id;
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editRTIApplication.do');
	}
	function searchRTIApplication() {
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplicationAppeal/listRTIApplicationAppeal.do');
	}
</script>

<div class="mainHdr">
	<h3>
		<a
			href="<c:out value="${contextRoot}"/>/rtiapplicationAppeal/applyRTIApplicationAppeal.do">
			Appeal
		</a> 
		<fmt:message key="rtiApplication.manage.pagetitle.appeal" /> 
	</h3>
</div>
<div valign="top" id="SetFormHeight">

	<div id="SearchDivId" class="ClsSearch">
		<div class="ClsSearchTitle">
			<img src="<c:out value="${contextRoot}"/>/images/closed.gif"
				id="searchToggleImage"
				onclick="javascript:ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>')" />
			<fmt:message key="search.label.heading" />
		</div>
		<table id="SearchTable" class="searchForm" style="display: none;">
			<tr>
				<td><fmt:message key="rtiApplication.list.label.rtiApplnNumber" />
				</td>
				<td><input type="text" class="ClsTextbox"
					id="searchrtiApplnNumber" maxlength="45" style="width: 150px"
					name="searchrtiApplnNumber"
					value="<c:out value="${SearchOptions.searchrtiApplnNumber}"/>" /> &nbsp;
				</td>

				<td><span class="ClsLabel"><fmt:message
							key="rtiApplication.manage.label.department" /></span><span
					class="ClsRequiredFields"></span></td>
				<td><select name="searchDepartmentId" id="searchDepartmentId">
						<option value=""><--- Select ---></option>
						<c:forEach var="department" items="${requestScope.departmentList}">
							<c:choose>
								<c:when
									test="${SearchOptions.searchdepartment==department.departmentId}">
									<option value="${department.departmentId}" selected="selected">
										<c:out value="${department.name}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${department.departmentId}">
										<c:out value="${department.name}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select></td>
			</tr>
			<tr>

				<td><span class="ClsLabel"><fmt:message
							key="rtiApplication.manage.label.appdate.between" /> </span></td>
				<td><input type="text" class="ClsTextboxDate" id="fromDate"
					maxlength="10" name="fromDate"
					value="<c:out value="${SearchOptions.fromDate}"/>" /> <span
					class="ClsLabel">-</span> <input type="text" class="ClsTextboxDate"
					id="toDate" maxlength="10" name="toDate"
					value="<c:out value="${SearchOptions.toDate}"/>" /></td>
			</tr>

			<tr>
				<td colspan="4">
					<input type="submit" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchRTIApplication()" /> &nbsp;
					
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>"
							onclick="javascript:clearFields('SearchTable');searchRTIApplication()" />
				</td>
			</tr>

		</table>
		<c:if test="${SearchOptions.searchParamSet == true}">
			<script>
				ToggleSearch('SearchTable', 'searchToggleImage',
						'<c:out value="${contextRoot}"/>');
			</script>
		</c:if>
	</div>

	<table cellpadding="0" cellspacing="1" width="98%" class="dataGrid">
		<thead>
			<tr>
				<td onclick="javascript:resort('upper(rtiApplnNumber)');"
					style="cursor: pointer" wrap><fmt:message
						key="rtiApplication.list.label.rtiApplnNumber" /> <span
					id="upper(rtiApplnNumber)"></span>
				</td>
				<td onclick="javascript:resort('upper(createdDate)');"
					style="cursor: pointer" wrap><fmt:message
						key="rtiApplication.manage.label.createdDate" /> <span
					id="upper(createdDate)"></span>
				</td>
				<td onclick="javascript:resort('upper(name)');"
					style="cursor: pointer" wrap><fmt:message
						key="rtiApplication.manage.label.name" /> <span
					id="upper(name)"></span>
				</td>
				<td onclick="javascript:resort('gender');"
					style="cursor: pointer" wrap><fmt:message
						key="rtiApplication.manage.label.gender" /> <span
					id="gender"></span>
				</td>
			</tr>
		</thead>
		<tbody>
			<c:set var="hasRows" value="false" />
			<c:forEach var="rtiApplnList"
				items="${requestScope.rtiApplicationList}" varStatus="rowNumber">
				<c:set var="hasRows" value="true" />
				<tr>
					<td><a title="<fmt:message key="list.link.EditOrViewLink"/>"
						href="javascript:editRTIApplication('${rtiApplnList.rtiApplicationId}');">
							<c:out value="${rtiApplnList.rtiApplnNumber}" />
					</a></td>
					<td><c:out value="${rtiApplnList.registrationDate}" /></td>
					<td><c:out value="${rtiApplnList.applicantName}" /></td>
					<td><c:out value="${rtiApplnList.gender}" /></td>
				</tr>
			</c:forEach>

			<c:if test="${hasRows == false}">
				<tr>
					<td colspan=4 class="clsNoRecords" align="center"><fmt:message
							key="list.label.norecords" /></td>
				</tr>
			</c:if>
		</tbody>

		<tfoot>
			<tr>
				<td colspan="4"><c:if test="${requestScope.rtiApplicationList != null && requestScope.totalCount>0}">
						<span><%@include file="/pages/common/pagination.jsp"%></span>
					</c:if></td>
			</tr>
		</tfoot>
	</table>
<input type="hidden" id="rtiApplicationId" name="rtiApplicationId" value="" /> 
<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>"/> 
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" />
	<script type="text/javascript">
		insert_image('${contextRoot}');
	</script>
</div>

<script type="text/javascript">
$(document).ready(function() { 
    $('.main').css("height","auto");
});
</script>
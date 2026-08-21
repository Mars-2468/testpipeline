 
<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page
        import="com.mars.common.utils.Constants,com.mars.common.utils.CommonUtils" />
<jsp:directive.page
        import="com.mars.common.utils.Constants,com.mars.common.utils.CommonUtils,com.mars.rti.utils.CoreConstants" />
<%@include file="/pages/common/includeTransliterateJS.jsp"%>
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

        pageContext.setAttribute("LABEL_RADIO_FEE_CATEGORY_BPL",
                        CoreConstants.LABEL_RADIO_FEE_CATEGORY_BPL);
        pageContext.setAttribute("LABEL_RADIO_FEE_CATEGORY_NON_BPL",
                        CoreConstants.LABEL_RADIO_FEE_CATEGORY_NON_BPL);
        pageContext.setAttribute("FEE_CATEGORY_BPL",
                        CoreConstants.FEE_CATEGORY_BPL);
        pageContext.setAttribute("FEE_CATEGORY_NON_BPL",
                        CoreConstants.FEE_CATEGORY_NON_BPL);

        /* pageContext.setAttribute("statusList", CommonUtils.getStatus()); */
%>


<script>

</script>


<div class="mainHdr">
        <h3>
                <c:choose>
                        <c:when test="${feeMaster.feeMasterId==0}">
                                <fmt:message key="feeMaster.manage.pagetitle.new" />
                        </c:when>
                        <c:otherwise>
                                <fmt:message key="feeMaster.manage.pagetitle.edit" />
                        </c:otherwise>
                </c:choose>
        </h3>
</div>
<div valign="top" id="SetFormHeight">
        <table width="98%" border="0" cellpadding="2" cellspacing="2"
                class="dataForm">
                <tr>
                        <td colspan="2"><spring:bind path="feeMaster.feeMasterId">
                                        <input type="hidden" id="feeMasterId" name="feeMasterId"
                                                value="<c:out value="${feeMaster.feeMasterId}"/>" />
                                </spring:bind>
                                
                                
                                <spring:bind path="feeMaster.name">
                                        <input type="hidden"  id="name" maxlength="45"
                                                name="name" value="<c:out value="${feeMaster.name}"/>" />
                                </spring:bind>
                                </td>
                </tr>

                <%-- <tr>
                        <td width="300px"><span class="ClsLabel"><fmt:message
                                                key="feeMaster.manage.label.name" /></span><span
                                class="ClsRequiredFields">*</span></td>
                        <td><spring:bind path="feeMaster.name">
                                        <input type="text" class="ClsTextbox" id="name" maxlength="45"
                                                name="name" value="<c:out value="${feeMaster.name}"/>" />
                                </spring:bind></td>

                </tr> --%>
                <tr>

                        <td><span class="ClsLabel"><fmt:message
                                                key="rtiApplication.manage.label.category" />:</span><span
                                class="ClsRequiredFields">*</span></td>
                        <td><spring:bind path="feeMaster.category">
                                        <input type="radio"
                                                id="category<c:out value="${pageScope.LABEL_RADIO_FEE_CATEGORY_BPL}"/>"
                                                name="category"
                                                value="<c:out value="${pageScope.FEE_CATEGORY_BPL}"/>"
                                                <c:if test="${feeMaster.category eq pageScope.FEE_CATEGORY_BPL}">checked="checked"</c:if> />
                                        <label
                                                for="category<c:out value="${pageScope.LABEL_RADIO_FEE_CATEGORY_BPL}"/>"><c:out
                                                        value="${pageScope.LABEL_RADIO_FEE_CATEGORY_BPL}" /></label>
                                        <input type="radio"
                                                id="category<c:out value="${pageScope.LABEL_RADIO_FEE_CATEGORY_NON_BPL}"/>"
                                                name="category"
                                                value="<c:out value="${pageScope.FEE_CATEGORY_NON_BPL}"/>"
                                                <c:if test="${feeMaster.category eq pageScope.FEE_CATEGORY_NON_BPL}">checked="checked"</c:if> />
                                        <label
                                                for="category<c:out value="${pageScope.LABEL_RADIO_FEE_CATEGORY_NON_BPL}"/>"><c:out
                                                        value="${pageScope.LABEL_RADIO_FEE_CATEGORY_NON_BPL}" /></label>
                                </spring:bind></td>


                </tr>

                <tr>
                        <td><span class="ClsLabel"><fmt:message
                                                key="feeMaster.manage.label.fromDate" /></span><span
                                class="ClsRequiredFields">*</span></td>
                        <td><spring:bind path="feeMaster.fromDate">
                                        <input type="text" class="ClsTextboxDate" id="fromDate"
                                                maxlength="10" name="fromDate" tabindex="1"
                                                value="<c:out value="${feeMaster.fromDate}"/>" style="width: 70px"
                                                readonly="readonly" />
                                </spring:bind></td>
                </tr>
                <tr>
                        <td><span class="ClsLabel"><fmt:message
                                                key="feeMaster.manage.label.toDate" /></span><span
                                class="ClsRequiredFields">*</span></td>
                        <td><spring:bind path="feeMaster.toDate">
                                        <input type="text" class="ClsTextboxDate" id="toDate"
                                                maxlength="10" name="toDate" tabindex="1"
                                                value="<c:out value="${feeMaster.toDate}"/>" style="width: 70px"
                                                readonly="readonly" />
                                </spring:bind></td>
                </tr>



                <tr>
                        <td><span class="ClsLabel"><fmt:message
                                                key="feeMaster.manage.label.amount" /></span><span
                                class="ClsRequiredFields">*</span></td>
                        <td><spring:bind path="feeMaster.amount">
                                        <input type="text" class="ClsTextbox" id="amount" maxlength="4"
                                                name="amount" value="<c:out value="${feeMaster.amount}"/>" />
                                </spring:bind></td>
                </tr>
                <tr>
                        <td><span class="ClsLabel"><fmt:message
                                                key="feeMaster.manage.label.amountPerCopy" /></span><span
                                class="ClsRequiredFields">*</span></td>
                        <td><spring:bind path="feeMaster.amountPerCopy">
                                        <input type="text" class="ClsTextbox" id="amountPerCopy"
                                                maxlength="4" name="amountPerCopy"
                                                value="<c:out value="${feeMaster.amountPerCopy}"/>" />
                                </spring:bind></td>
                </tr>
                <tr>
                        <td><span class="ClsLabel"><fmt:message
                                                key="feeMaster.manage.label.maxNoOfCopy" /></span><span
                                class="ClsRequiredFields">*</span></td>
                        <td><spring:bind path="feeMaster.maxNoOfCopy">
                                        <input type="text" class="ClsTextbox" id="maxNoOfCopy"
                                                maxlength="1" name="maxNoOfCopy"
                                                value="<c:out value="${feeMaster.maxNoOfCopy}"/>" />
                                </spring:bind></td>
                </tr>
                 <tr>
                        <td><span class="ClsLabel"><fmt:message
                                                key="feeMaster.manage.label.postalCharges" /></span><span
                                class="ClsRequiredFields">*</span></td>
                        <td><spring:bind path="feeMaster.postalCharges">
                                        <input type="text" class="ClsTextbox" id="postalCharges"
                                                maxlength="4" name="postalCharges"
                                                value="<c:out value="${feeMaster.postalCharges}"/>" />
                                </spring:bind></td>
                </tr>
                

<tr>
                <td><span class="ClsLabel"><fmt:message        key="feeMaster.manage.label.status" /></span></td>
                <td>
                        <select name="status" id="status" class="ClsTextbox" style="width:150px">
                                <option value=""> -- Select Status -- </option>
                                <option value="1" <c:if test="${feeMaster.status eq 1}">selected="selected"</c:if>>Active</option>
                                <option value="0" <c:if test="${feeMaster.status eq 0}">selected="selected"</c:if>>InActive </option>
                                        
                        </select> 
                </td>
        </tr>

                <tr>
                        <td><span class="ClsLabel"><fmt:message
                                                key="feeMaster.manage.label.description" /></span></td>
                        <td><spring:bind path="feeMaster.description">
                                        <textarea class="ClsTextbox" id="description" cols="30" rows="4"
                                                name="description"><c:out
                                                        value="${feeMaster.description}" /></textarea>
                                </spring:bind></td>
                </tr>

                


                <tr>
                        <td colspan="2" style="padding-top: 5px"></td>
                </tr>
                <tr>
                        <td></td>
                        <td><input type="button" class="ClsButton" id="save" name="save"
                                value="Save" onclick="javascript:saveFeeMaster(this.form);">
                                <input type="button" class="ClsButton" id="clear" name="clear"
                                value="Clear" onclick="javascript:clearContorls();"> <c:if
                                        test="${feeMaster.feeMasterId!=0}">
                                        <!-- <input type="button" class="ClsButton" id="delete" name="delete"
                                                value="Delete" onclick="javascript:deleteFeeMaster(this.form);"> -->
                                </c:if></td>
                </tr>

        </table>

</div>







<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}"
        value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>" />


<script type="text/javascript">
        function saveFeeMaster(frm) {
        	
        	if(document.document.getElementById('name').value == '') {
        		document.document.getElementById('name').value = 'Between '+document.document.getElementById('fromDate').value +' And '+document.document.getElementById('toDate').value;
        	 }
                var arrRequiredElements=new Array('name','fromDate','toDate','amount','postalCharges');
                var arrRequiredElementsMessages=new Array('<fmt:message key="feeMaster.manage.label.name"/>',
                                '<fmt:message key="feeMaster.manage.label.fromDate"/>',
                                '<fmt:message key="feeType.manage.label.toDate"/>',
                                '<fmt:message key="feeType.manage.label.amount"/>','Postal Charges'
                                );
                if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages)){
                        if(checkChildFloatDetails(new Array('amount'),new Array('<fmt:message key="feeMaster.manage.label.amount"/>'))){        
                                                navigate(frm,'<c:out value="${contextRoot}"/>/feemaster/saveFeeMaster.do');                
                    }
                } 

        }/* 
        function deleteFeeMaster(id) {
                if (confirmDelete()) {
                        onPageSubmit('<c:out value="${contextRoot}"/>/feemaster/deleteFeeMaster.do');
                } */
        }
</script>


<%@page import="com.mars.common.utils.CommonUtils"%>
<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>

<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	pageContext.setAttribute("DATE_TIME_DB_FORMAT", Constants.DATE_TIME_DB_FORMAT);

	pageContext.setAttribute("DATE_TIME_FORMAT", WorkflowConstants.WORKFLOW_DATE_FORMAT);
	
	
	  pageContext.setAttribute("LABEL_NUR_SELECT", CoreConstants.LABEL_NUR_SELECT);
	    pageContext.setAttribute("LABEL_NUR_NATIONALITY", CoreConstants.LABEL_NUR_NATIONALITY);
	    
	    pageContext.setAttribute("NUR_SELECT",  CoreConstants.NUR_SELECT);
	    pageContext.setAttribute("NUR_NATIONALITY",  CoreConstants.NUR_NATIONALITY);
    
    pageContext.setAttribute("STATUS_YES_LABEL", CoreConstants.STATUS_YES_LABEL);
    pageContext.setAttribute("STATUS_NO_LABEL", CoreConstants.STATUS_NO_LABEL);
    
    pageContext.setAttribute("STATUS_YES",  CoreConstants.STATUS_YES);
    pageContext.setAttribute("STATUS_NO",  CoreConstants.STATUS_NO);
	
	pageContext.setAttribute("WORKFLOW_PRIORITY", WorkflowConstants.WORKFLOW_PRIORITY);
	pageContext.setAttribute("WORKFLOW_PRIORITY_LOW", WorkflowConstants.WORKFLOW_PRIORITY_LOW);
	pageContext.setAttribute("WORKFLOW_PRIORITY_LOW_LABEL", WorkflowConstants.WORKFLOW_PRIORITY_LOW_LABEL);
	pageContext.setAttribute("WORKFLOW_PRIORITY_MEDIUM", WorkflowConstants.WORKFLOW_PRIORITY_MEDIUM);
	pageContext.setAttribute("WORKFLOW_PRIORITY_MEDIUM_LABEL", WorkflowConstants.WORKFLOW_PRIORITY_MEDIUM_LABEL);
	pageContext.setAttribute("WORKFLOW_PRIORITY_HIGH", WorkflowConstants.WORKFLOW_PRIORITY_HIGH);
	pageContext.setAttribute("WORKFLOW_PRIORITY_HIGH_LABEL", WorkflowConstants.WORKFLOW_PRIORITY_HIGH_LABEL);
	pageContext.setAttribute("WORKFLOW_PROCESSDESCRIPTION", WorkflowConstants.WORKFLOW_PROCESSDESCRIPTION);
	pageContext.setAttribute("WORKFLOW_TRANSITION", WorkflowConstants.WORKFLOW_TRANSITION);
	pageContext.setAttribute("WORKFLOW_NAME", WorkflowConstants.WORKFLOW_NAME);
	pageContext.setAttribute("WORKFLOW_ACTION", WorkflowConstants.WORKFLOW_ACTION);
	pageContext.setAttribute("WORKFLOW_ACTION_COMPLETE_TASK", WorkflowConstants.WORKFLOW_ACTION_COMPLETE_TASK);
	pageContext.setAttribute("WORKFLOW_ACTION_CREATE_PROCESS", WorkflowConstants.WORKFLOW_ACTION_CREATE_PROCESS);
	pageContext.setAttribute("TAKE_TASK", WorkflowConstants.WORKFLOW_ACTION_TAKE_TASK);
	pageContext.setAttribute("KILL_JOB", WorkflowConstants.WORKFLOW_ACTION_KILL_JOB);
	pageContext.setAttribute("END_JOB", WorkflowConstants.WORKFLOW_ACTION_KILL_JOB);
	pageContext.setAttribute("WORKFLOW_TRANSISTION", WorkflowConstants.WORKFLOW_TRANSISTION);
	pageContext.setAttribute("WORKFLOW_ENTITYNAME", WorkflowConstants.WORKFLOW_ENTITYNAME);
	pageContext.setAttribute("WORKFLOW_ENTITYID", WorkflowConstants.WORKFLOW_ENTITYID);
	pageContext.setAttribute("WORKFLOW_JOB_ID", WorkflowConstants.WORKFLOW_JOB_ID);
	pageContext.setAttribute("WORKFLOW_TASK_ID", WorkflowConstants.WORKFLOW_TASK_ID);
	pageContext.setAttribute("WORKFLOW_COMMENTS", WorkflowConstants.WORKFLOW_COMMENTS);
	pageContext.setAttribute("WORKFLOW_DUE_DATE", WorkflowConstants.WORKFLOW_DUE_DATE);
	
	
	pageContext.setAttribute("APPL_STATUS_CLOSED", CoreConstants.APPL_STATUS_CLOSED);
	pageContext.setAttribute("APPL_STATUS_NEW", CoreConstants.APPL_STATUS_NEW);
	pageContext.setAttribute("APPL_STATUS_PARKED", CoreConstants.APPL_STATUS_PARKED);	
	pageContext.setAttribute("APPL_STATUS_APPROVED", CoreConstants.APPL_STATUS_APPROVED);
	pageContext.setAttribute("APPL_STATUS_VERIFICATION", CoreConstants.APPL_STATUS_VERIFICATION);
	pageContext.setAttribute("APPL_STATUS_CREATE", CoreConstants.APPL_STATUS_CREATE);
	
	pageContext.setAttribute("APPLICATION_STATUS_LIST", CommonUtils.getApplicationStatusList());
%>


<script type="text/javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery.ajaxfileupload.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script> 
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>



<script type="text/javascript">
function editRTIApplication() {
	//document.getElementById('rtiApplicationId').value = id;
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editRTIApplication.do');
} 


function saveNursingHome() {
	
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/saveNursingHome.do');
} 

	




</script>
<style type="text/css">
input[type=text] 
{ 
  width: 290px;
  
  
  box-sizing: border-box;
  border: 1px solid black;
  box-shadow: 0 0 5px;
  border-radius: 30px;
}
</style>
<div class="mainHdr">
	<h3> 
		
				<fmt:message key="Nursing Home Registration"/> 				
				<c:if test="${requestScope.rtiApplication != null}"> 				
				<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
				</c:if>
			
	</h3>
</div>
<div valign="top" id="SetFormHeight">
        <table width="98%" border="0" cellpadding="2" cellspacing="2"               class="dataForm">
                <tr>

                    <tr>

                      <td style="white-space: nowrap;">
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Full Name of Applicant " />:</span>
                        </td>
                        
                        <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="First Name" />:</span><span class="ClsRequiredFields"></span>
                        </td>
                        <td>
                        </tr><tr>
                        <td><spring:bind path="nursingHomes.fullname">
                           
                                <input type="text" class="ClsTextbox" style="width:180px" id="fullname" maxlength="50" name="fullname" value="<c:out value="${nursingHomes.fullname}"/>" />
                          </spring:bind>
                        </td>
                      <td>
                            <spring:bind path="nursingHomes.firstname">
                                <input type="text" class="ClsTextbox" style="width:170px" id="firstname" maxlength="30" name="firstname" value="<c:out value="${nursingHomes.firstname}"/>" />
                         </spring:bind>
                        </td>
                    </tr>
                    <tr>
                     <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="Middle Name" />:</span><span class="ClsRequiredFields"></span>
                        </td>
                       
                         <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="Last Name" />:</span><span class="ClsRequiredFields"></span>
                        </td>
                        </tr>
                        <tr>
                         <td>
                            <spring:bind path="nursingHomes.middlename">
                                <input type="text" class="ClsTextbox" style="width:170px" id="middlename" maxlength="30" name="middlename" value="<c:out value="${nursingHomes.middlename}"/>" />
                         </spring:bind>
                        </td>
                        <td>
                           <spring:bind path="nursingHomes.lastname">
                                <input type="text" class="ClsTextbox" style="width:170px" id="lastname" maxlength="30" name="lastname" value="<c:out value="${nursingHomes.lastname}"/>" />
                         </spring:bind>
                        </td>
                      </tr>
                       <tr>
                        <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="Plot/ Flat No" />:</span><span class="ClsRequiredFields"></span>
                        </td>
                        
                        
                         <td style="white-space: nowrap;">
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="Name of the Building" />:</span><span class="ClsRequiredFields"></span>
                        </td>
                        
                        </tr><tr>
                        <td>
                            <spring:bind path="nursingHomes.plot">
                                <input type="text" class="ClsTextbox" style="width:170px" id="plot" maxlength="30" name="plot" value="<c:out value="${nursingHomes.plot}"/>" />
                         </spring:bind>
                        </td>
                        <td>
                           <spring:bind path="nursingHomes.building">
                              <textarea class="ClsTextbox" style="width:170px" id="building" maxlength="30" name="building">${nursingHomes.building}</textarea>
                               
                         </spring:bind>
                        </td>
                        </tr>
                        <tr>
                        
                       <td style="white-space: nowrap;">
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="Name of the street" />:</span><span class="ClsRequiredFields"></span>
                        </td>
                       
                        
                         <td style="white-space: nowrap;">
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="Name of the area" />:</span><span class="ClsRequiredFields"></span>
                        </td>
                        </tr>
                        <tr>
                         <td>
                           <spring:bind path="nursingHomes.street">
                             <textarea class="ClsTextbox" style="width:170px" id="street" maxlength="30" name="street">${nursingHomes.street}</textarea>
                                
                         </spring:bind>
                        </td>
                        <td>
                           <spring:bind path="nursingHomes.area">
                               <textarea class="ClsTextbox" style="width:170px" id="area" maxlength="30" name="area">${nursingHomes.area}</textarea>
                         </spring:bind>
                        </td>
                        
                        </tr>
                        <tr>
                        <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="Pin Code" />:</span><span class="ClsRequiredFields"></span>
                        </td>
                        
                        
                        <td style="white-space: nowrap;">
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="Nearby landmark" />:</span><span class="ClsRequiredFields"></span>
                        </td>
                        </tr><tr>
                        <td>
                           <spring:bind path="nursingHomes.pin">
                                <input type="text" class="ClsTextbox" style="width:170px" id="pin" maxlength="30" name="pin" value="<c:out value="${nursingHomes.pin}"/>" />
                         </spring:bind>
                        </td>
                        <td>
                            <spring:bind path="nursingHomes.landmark">
                               <textarea class="ClsTextbox" style="width:170px" id="landmark" maxlength="30" name="landmark">${nursingHomes.landmark}</textarea>
                         </spring:bind>
                        </td>
                        
                        </tr>
                        <tr>
                         <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="Google location" />:</span><span class="ClsRequiredFields"></span>
                        </td>
                       
                        
                        <td style="white-space: nowrap;">
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="City Survey/ Gut Number" />:</span><span class="ClsRequiredFields"></span>
                        </td>
                        </tr><tr>
                         <td>
                            <spring:bind path="nursingHomes.glocation">
                                <input type="text" class="ClsTextbox" style="width:170px" id="glocation" maxlength="30" name="glocation" value="<c:out value="${nursingHomes.glocation}"/>" />
                         </spring:bind>
                        </td>
                        <td>
                            <spring:bind path="nursingHomes.city">
                                <input type="text" class="ClsTextbox" style="width:170px" id="city" maxlength="30" name="city" value="<c:out value="${nursingHomes.city}"/>" />
                         </spring:bind>
                        </td>
                      
                        </tr>
                        
                        <tr>
                        
                          <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="Mobile Number" />:</span>
                        </td>
                       
                        
                      <td style="white-space: nowrap;">
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="Technical Qualification if any, of the applicant." />:</span>
                        </td>
                        </tr><tr>
                        
                         <td><spring:bind path="nursingHomes.phone">
                            <input type="text" class="ClsTextbox" style="width:180px" id="phone" maxlength="50" name="phone" value="<c:out value="${nursingHomes.phone}"/>" />
                           </spring:bind> &nbsp;
                        </td>
                        <td><spring:bind path="nursingHomes.techqul">
                            <input type="text" class="ClsTextbox" style="width:180px" id="techqul" maxlength="50" name="techqul" value="<c:out value="${nursingHomes.techqul}"/>" />
                           </spring:bind> &nbsp;
                        </td>
                        
                        
                        
                        </tr>
                      
                      <tr>
                         <td style="white-space: nowrap;">
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Nationality of the applicant" />:</span>
                        </td>
                         
                        <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="Place where the nursing home is situated & Address" />:</span>
                        </td>
                        </tr><tr>
                         <td>
                            <spring:bind path="nursingHomes.nationality">
                       
						 <select name="nationality" id="nationality" style="width:180px" tabindex="25" onchange="">
                                    <option value="<c:out value="${pageScope.NUR_SELECT}"/>"
                                        "<c:if test="${nursingHomes.nationality == pageScope.NUR_SELECT}">" selected="selected"</c:if>>
                                        <c:out value="${pageScope.LABEL_NUR_SELECT}"/>
                                    </option>
						 <option value="<c:out value="${pageScope.NUR_NATIONALITY}"/>"
                                        "<c:if test="${nursingHomes.nationality == pageScope.NUR_NATIONALITY}">" selected="selected"</c:if>>
                                        <c:out value="${pageScope.LABEL_NUR_NATIONALITY}"/>
                                    </option>
				
                                </select>
                            </spring:bind>
                        </td>
                      
                        <td><spring:bind path="nursingHomes.nursingplace">
                           <textarea class="ClsTextbox" style="width:170px" id="nursingplace" maxlength="30" name="nursingplace">${nursingHomes.nursingplace}</textarea>
                                
                         </spring:bind>
                        </td>
                        </tr>
                        
                        <tr>
                          <td>
                          
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="Situation of the registered of principal office of the company, Society, Association or other body corporate." />:</span>
                        </td>
                         
                     
                        <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="Name and other particulars of the nursing home in respect of which the registration is applied for." />:</span>
                        </td>
                        </tr>
                        <tr>
                         <td>
                            <spring:bind path="nursingHomes.situation">
                            <textarea class="ClsTextbox" style="width:170px" id="situation" maxlength="30" name="situation">${nursingHomes.situation}</textarea>
                                
                         </spring:bind>
                        </td>
                      
                        <td>
                            <spring:bind path="nursingHomes.nameofother">
                            
                            
                             <textarea class="ClsTextbox" style="width:170px" id="nameofother" maxlength="30" name="nameofother">${nursingHomes.nameofother}</textarea>
                               
                                
                         </spring:bind>
                        </td>
                        
                          
                      </tr>
                      <tr>
                    <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="Brief description of the construction size and equipment of the nursing home or any premises used in connection there with as detailed below." />:</span>
                        </td>
                      
                        
                         <td>
                               <span class="ClsLabel" style="font-size:14px"><fmt:message key="Floor Space of ward rooms provided for patients giving number of beds." /></span><span class="ClsRequiredFields"></span>
                            </td>
                            
                           </tr><tr> 
                            <td>
                            <spring:bind path="nursingHomes.briefdesc">
                            
                             <textarea class="ClsTextbox" style="width:170px" id="briefdesc" maxlength="30" name="briefdesc">${nursingHomes.briefdesc}</textarea>
                               
                         </spring:bind>
                        </td>
                            <td>
                            <spring:bind path="nursingHomes.floorspace">
                           <textarea class="ClsTextbox" style="width:170px" id="floorspace" maxlength="30" name="floorspace">${nursingHomes.floorspace}</textarea>
                          </spring:bind>  &nbsp;
                            </td>
                        
                        </tr>
                        <tr>
                        <td>
                               <span class="ClsLabel" style="font-size:14px"><fmt:message key="Arrangement made for Medical check –up and immunization of the employee." /></span><span class="ClsRequiredFields"></span>
                            </td>
                            
                        
                        <td>
                               <span class="ClsLabel" style="font-size:14px"><fmt:message key="Floor space for kitchen servant’s room and other rooms giving details of user and area of each room." /></span><span class="ClsRequiredFields"></span>
                            </td>
                             </tr><tr>
                            <td>
                            <spring:bind path="nursingHomes.arrangemedimmu">
                           <textarea class="ClsTextbox" style="width:170px" id="arrangemedimmu" maxlength="30" name="arrangemedimmu">${nursingHomes.arrangemedimmu}</textarea>
                          </spring:bind>  &nbsp;
                            </td>
                       
                            <td><spring:bind path="nursingHomes.floorspaceofrooms">
                           <textarea class="ClsTextbox" style="width:170px" id="floorspaceofrooms" maxlength="30" name="floorspaceofrooms">${nursingHomes.floorspaceofrooms}</textarea>
                          </spring:bind>  &nbsp;
                            </td>
                        </tr>
                        <tr>
                         <td>
                               <span class="ClsLabel" style="font-size:14px"><fmt:message key="Details of arrangements made for sanitary convenience for patients and employees giving their numbers." /></span><span class="ClsRequiredFields"></span>
                            </td>
                            
                        <td>
                               <span class="ClsLabel" style="font-size:14px"><fmt:message key="Details of arrangements made for storage and service of food." /></span><span class="ClsRequiredFields"></span>
                            </td>
                            
                           
                            
                            
                            
                            </tr><tr> <td>
                            <spring:bind path="nursingHomes.convdetailsofemp">
                          <textarea class="ClsTextbox" style="width:170px" id="convdetailsofemp" maxlength="30" name="convdetailsofemp">${nursingHomes.convdetailsofemp}</textarea>
                           </spring:bind> &nbsp;
                            </td>
                        
                            <td>
                            <spring:bind path="nursingHomes.detailsstoragefood">
                           <textarea class="ClsTextbox" style="width:170px" id="detailsstoragefood" maxlength="30" name="detailsstoragefood">${nursingHomes.detailsstoragefood}</textarea>
                          </spring:bind>  &nbsp;
                            </td>
                        
                        </tr>
                        <tr>
                        <td>
                               <span class="ClsLabel" style="font-size:14px"><fmt:message key="Equipment Available & in use" /></span><span class="ClsRequiredFields"></span>
                            </td>
                           
                        
                        
                         <td>
                               <span class="ClsLabel" style="font-size:14px"><fmt:message key="Whether the nursing home or any premises used in connect on their which are used or are to be used for purposes other than that of carrying on a nursing home." /></span><span class="ClsRequiredFields"></span>
                            </td>
                            </tr><tr>
                             <td>
                            <spring:bind path="nursingHomes.equipment">
                           <input type="text" class="ClsTextbox" style="width:260px" id="equipment" maxlength="50" name="equipment" value="<c:out value="${nursingHomes.equipment}"/>" />
                          </spring:bind>  &nbsp;
                            </td>
                            
                            
                            <td>
                            <spring:bind path="nursingHomes.carryingnursinghome">
                           <input type="text" class="ClsTextbox" style="width:260px" id="phNo" maxlength="50" name="phNo" value="<c:out value="${nursingHomes.carryingnursinghome}"/>" />
                          </spring:bind>  &nbsp;
                            </td>
                            
                        </tr>
                        <tr>
                         <td>
                               <span class="ClsLabel" style="font-size:14px"><fmt:message key="Number of beds for maternity Patients" /></span><span class="ClsRequiredFields"></span>
                            </td>
                            
                        
                        <td>
                               <span class="ClsLabel" style="font-size:14px"><fmt:message key="Number of beds or other patients" /></span><span class="ClsRequiredFields"></span>
                            </td>
                            </tr><tr>
                            
                            
                            <td>
                            <spring:bind path="nursingHomes.nobedmpatient">
                           <input type="text" class="ClsTextbox" style="width:260px" id="nobedmpatient" maxlength="50" name="nobedmpatient" value="<c:out value="${nursingHomes.nobedmpatient}"/>" />
                          </spring:bind>  &nbsp;
                            </td>
                            
                            
                            
                            <td>
                            <spring:bind path="nursingHomes.nobedopatient">
                           <input type="text" class="ClsTextbox" style="width:260px" id="nobedopatient" maxlength="50" name="nobedopatient" value="<c:out value="${nursingHomes.nobedopatient}"/>" />
                           </spring:bind> &nbsp;
                            </td>
                        </tr>
                        
                          <tr>
                         <td>
                               <span class="ClsLabel" style="font-size:14px"><fmt:message key="Names, Ages and qualification of the member of the nursing staff in the nursing home." /></span><span class="ClsRequiredFields"></span>
                            </td>
                            
                        
                        <td>
                               <span class="ClsLabel" style="font-size:14px"><fmt:message key="Place where the nursing staff accommodated." /></span><span class="ClsRequiredFields"></span>
                            </td>
                            
                            </tr><tr>
                            
                            <td>
                           <spring:bind path="nursingHomes.pdetailsnuringemp">
                           <input type="text" class="ClsTextbox" style="width:260px" id="pdetailsnuringemp" maxlength="50" name="pdetailsnuringemp" value="<c:out value="${nursingHomes.pdetailsnuringemp}"/>" />
                           </spring:bind> &nbsp;
                            </td>
                            <td>
                            <spring:bind path="nursingHomes.placeofnstaff">
                           <input type="text" class="ClsTextbox" style="width:260px" id="placeofnstaff" maxlength="50" name="placeofnstaff" value="<c:out value="${nursingHomes.placeofnstaff}"/>" />
                        </spring:bind>    &nbsp;
                            </td>
                        </tr>
                        
                           <tr>
                         <td>
                               <span class="ClsLabel" style="font-size:14px"><fmt:message key="Names, Ages and qualification of the resident or visiting physicians or surgeon in the nursing home." /></span><span class="ClsRequiredFields"></span>
                            </td>
                           
                        
                        <td>
                               <span class="ClsLabel" style="font-size:14px"><fmt:message key="Whether the nursing homes is under the supervision of qualified medical practitioner or a qualified nurse ,and if qualifications ." /></span><span class="ClsRequiredFields"></span>
                            </td>
                            
                            </tr>
                            <tr>
                             <td>
                            
                            <spring:bind path="nursingHomes.pdetailsnuringdoc">
                           <input type="text" class="ClsTextbox" style="width:260px" id="pdetailsnuringdoc" maxlength="50" name="pdetailsnuringdoc" value="<c:out value="${nursingHomes.pdetailsnuringdoc}"/>" />
                           </spring:bind> &nbsp;
                            </td>
                            <td>
                            
                            
                            <spring:bind path="nursingHomes.qualification">
                           <input type="text" class="ClsTextbox" style="width:260px" id="qualification" maxlength="50" name="qualification" value="<c:out value="${nursingHomes.qualification}"/>" />
                         </spring:bind>   &nbsp;
                            </td>
                        </tr>
                        
                             <tr>
                         <td>
                               <span class="ClsLabel" style="font-size:14px"><fmt:message key="Proportion of the qualified and unqualified nurses on the nursing staff." /></span><span class="ClsRequiredFields"></span>
                            </td>
                           
                        
                        <td>
                               <span class="ClsLabel" style="font-size:14px"><fmt:message key="Whether the nursing home is under the supervision of a qualified nurse midwife and if so, her name age and qualifications." /></span><span class="ClsRequiredFields"></span>
                            </td>
                            </tr><tr>
                             <td>
                            <spring:bind path="nursingHomes.qualifiednurse">
                           <input type="text" class="ClsTextbox" style="width:260px" id="qualifiednurse" maxlength="50" name="qualifiednurse" value="<c:out value="${nursingHomes.qualifiednurse}"/>" />
                           </spring:bind> &nbsp;
                            </td>
                            <td>
                            <spring:bind path="nursingHomes.qulnursemidwife">
                            
                            <input type="text" class="ClsTextbox" style="width:260px" id="phNo" maxlength="50" name="phNo" value="<c:out value="${nursingHomes.qulnursemidwife}"/>" />
                            </spring:bind> &nbsp;
                            </td>
                        </tr>
                        
                           <tr>
                         <td>
                               <span class="ClsLabel" style="font-size:14px"><fmt:message key="Whether any unregistered medical practitioner or unqualified midwife is employed for nursing of patients in the nursing home." /></span><span class="ClsRequiredFields"></span>
                            </td>
                            
                        
                        <td>
                               <span class="ClsLabel" style="font-size:14px"><fmt:message key="Whether any person of alien nationality is employed in the nursing home and if so, his name and other particulars." /></span><span class="ClsRequiredFields"></span>
                            </td>
                            
                            <td>
                            </tr>
                            <tr>
                            <td>
                            <spring:bind path="nursingHomes.qulnursemidwife">
                           <input type="text" class="ClsTextbox" style="width:260px" id="qulnursemidwife" maxlength="50" name="qulnursemidwife" value="<c:out value="${nursingHomes.qulnursemidwife}"/>" />
                           </spring:bind> &nbsp;
                            </td>
                            <td>
                            
                            <spring:bind path="nursingHomes.unregmedunquilnursing">
                           <input type="text" class="ClsTextbox" style="width:260px" id="unregmedunquilnursing" maxlength="50" name="unregmedunquilnursing" value="<c:out value="${nursingHomes.unregmedunquilnursing}"/>" />
                           </spring:bind> &nbsp;
                            </td>
                            
                            
                            
                           
                        </tr>
                        
                          <tr>
                         <td>
                               <span class="ClsLabel" style="font-size:14px"><fmt:message key="Whether the applicant is interested in any other nursing home or business and, if so the place where such nursing home is situated or where such business is conducted." /></span><span class="ClsRequiredFields"></span>
                            </td>
                           
                        
                         <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="No.and date o expiry of the certificate of registration." />:</span>
                        </td>
                        </tr><tr>
                         <td>
                            <spring:bind path="nursingHomes.applicantintereste">
                           <input type="text" class="ClsTextbox" style="width:260px" id="applicantintereste" maxlength="50" name="applicantintereste" value="<c:out value="${nursingHomes.applicantintereste}"/>" />
                          </spring:bind>  &nbsp;
                            </td>
                       <td>
                       <spring:bind path="nursingHomes.noandexpdate">
                                 <input type="text" class="ClsTextboxDate" id="noandexpdate" style="width:270px" maxlength="30" name="noandexpdate" value="<c:out value="${nursingHomes.noandexpdate}"/>"/>
                            </spring:bind></td>
                         
                        </tr>
                        <tr>
                         <td>
                               <span class="ClsLabel" style="font-size:14px"><fmt:message key="Whether the nursing home or any premises used in connect on their which are used or are to be used for purposes other than that of carrying on a nursing home. *." /></span><span class="ClsRequiredFields"></span>
                            </td>
                             <td>
                               <span class="ClsLabel" style="font-size:14px"><fmt:message key="Fees charged to patients." /></span><span class="ClsRequiredFields"></span>
                            </td></tr><tr>
                            <td>
                            
                            <spring:bind path="nursingHomes.carryingnursinghome">
                           <input type="text" class="ClsTextbox" style="width:260px" id="carryingnursinghome" maxlength="50" name="carryingnursinghome" value="<c:out value="${nursingHomes.carryingnursinghome}"/>" />
                           </spring:bind> &nbsp;
                           </td><td>
                           <spring:bind path="nursingHomes.feecharged">
                           <input type="text" class="ClsTextbox" style="width:180px" id="feecharged" maxlength="50" name="feecharged" value="<c:out value="${nursingHomes.feecharged}"/>" />
                           </spring:bind> &nbsp;
                            </td></tr>
		<tr>
     <td><span class="ClsLabel" style="font-size:14px"> Current Status:</span></td>
     <td> <span class="ClsLabel" style="font-size:14px">
     <c:if test="${requestScope.rtiApplication.workFlowStatus==0}">
						Citizen Form Submitted. 
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==3}">
						Citizen Payment Pending. 
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
						Citizen Payment Completed
					</c:if>
											
					<c:if test="${requestScope.rtiApplication.workFlowStatus==1}">
						Completed and File Uploaded for Citizen
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==5}">
						Rejected
					</c:if></span>
     </td>      
		  <td><span class="ClsLabel" style="font-size:14px">Certificate Upload: </span> </td>
     <%@include file="/pages/common-pages/dms/fileUpload.jsp"%>    
		</tr>
		
		                            
       	<%-- <tr>
			<td colspan="6" style="padding-top: 5px"><img
				src="../images/Transpx.gif" height="15px" /></td>
		</tr>
		
		<tr>
			<td colspan="6" align="center"><input type="button"
				class="ClsButton" id="save" name="save" value="Save"
				onclick="javascript:savemTPRegistrationCertificate(this.form);"
				tabindex="31"> <input type="button" class="ClsButton"
				id="clear" name="clear"
				value="<fmt:message key="common.button.clear"/>"
				onclick="javascript:clearFields('SearchTable');searchRTIApplication()" />--%>
	

	<input type="hidden" class="ClsTextbox_mr" style="width: 180px"id="nursinghomesregId" maxlength="12" name="nursinghomesregId"value="<c:out value="${nursingHomes.nursinghomesregId}"/>" />
  <input type="hidden" class="ClsTextbox_mr" style="width:180px" id="rtiApplicationRefId" maxlength="12" name="rtiApplicationRefId" value="<c:out value="${requestScope.rtiApplication.rtiApplicationId}"/>" />
	
<input type="hidden" class="ClsTextbox" style="width:180px" id="rtiapplrefno" maxlength="12" name="rtiapplrefno" value="<c:out value="${nursingHomes.rtiapplrefno}"/>" />
                       
        

      </table>
   </div>
    

     <%@include file="/pages/workflow/taskInclude.jsp"%>
</div>

<script type="text/javascript">
function saveEntity()
{
	saveNursingHome(this.form);
}


</script>


<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@page import="com.mars.common.utils.CommonUtils" %>
        <%@page import="com.mars.rti.utils.CoreConstants" %>
            <%@include file="/pages/common/include.jsp" %>
                <%@page import="com.mars.common.utils.Constants" %>
                    <%@page import="com.mars.workflow.utils.WorkflowConstants" %>
                        <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
                            <jsp:directive.include file="/pages/common/include.jsp" />

                            <% pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
                                pageContext.setAttribute("DATE_TIME_DB_FORMAT", Constants.DATE_TIME_DB_FORMAT);
                                pageContext.setAttribute("DATE_TIME_FORMAT", WorkflowConstants.WORKFLOW_DATE_FORMAT);
                                pageContext.setAttribute("WORKFLOW_PRIORITY", WorkflowConstants.WORKFLOW_PRIORITY);
                                pageContext.setAttribute("WORKFLOW_PRIORITY_LOW",
                                WorkflowConstants.WORKFLOW_PRIORITY_LOW);
                                pageContext.setAttribute("WORKFLOW_PRIORITY_LOW_LABEL",
                                WorkflowConstants.WORKFLOW_PRIORITY_LOW_LABEL);
                                pageContext.setAttribute("WORKFLOW_PRIORITY_MEDIUM",
                                WorkflowConstants.WORKFLOW_PRIORITY_MEDIUM);
                                pageContext.setAttribute("WORKFLOW_PRIORITY_MEDIUM_LABEL",
                                WorkflowConstants.WORKFLOW_PRIORITY_MEDIUM_LABEL);
                                pageContext.setAttribute("WORKFLOW_PRIORITY_HIGH",
                                WorkflowConstants.WORKFLOW_PRIORITY_HIGH);
                                pageContext.setAttribute("WORKFLOW_PRIORITY_HIGH_LABEL",
                                WorkflowConstants.WORKFLOW_PRIORITY_HIGH_LABEL);
                                pageContext.setAttribute("WORKFLOW_PROCESSDESCRIPTION",
                                WorkflowConstants.WORKFLOW_PROCESSDESCRIPTION);
                                pageContext.setAttribute("WORKFLOW_TRANSITION", WorkflowConstants.WORKFLOW_TRANSITION);
                                pageContext.setAttribute("WORKFLOW_NAME", WorkflowConstants.WORKFLOW_NAME);
                                pageContext.setAttribute("WORKFLOW_ACTION", WorkflowConstants.WORKFLOW_ACTION);
                                pageContext.setAttribute("WORKFLOW_ACTION_COMPLETE_TASK",
                                WorkflowConstants.WORKFLOW_ACTION_COMPLETE_TASK);
                                pageContext.setAttribute("WORKFLOW_ACTION_CREATE_PROCESS",
                                WorkflowConstants.WORKFLOW_ACTION_CREATE_PROCESS); pageContext.setAttribute("TAKE_TASK",
                                WorkflowConstants.WORKFLOW_ACTION_TAKE_TASK); pageContext.setAttribute("KILL_JOB",
                                WorkflowConstants.WORKFLOW_ACTION_KILL_JOB); pageContext.setAttribute("END_JOB",
                                WorkflowConstants.WORKFLOW_ACTION_KILL_JOB);
                                pageContext.setAttribute("WORKFLOW_TRANSISTION",
                                WorkflowConstants.WORKFLOW_TRANSISTION); pageContext.setAttribute("WORKFLOW_ENTITYNAME",
                                WorkflowConstants.WORKFLOW_ENTITYNAME); pageContext.setAttribute("WORKFLOW_ENTITYID",
                                WorkflowConstants.WORKFLOW_ENTITYID); pageContext.setAttribute("WORKFLOW_JOB_ID",
                                WorkflowConstants.WORKFLOW_JOB_ID); pageContext.setAttribute("WORKFLOW_TASK_ID",
                                WorkflowConstants.WORKFLOW_TASK_ID); pageContext.setAttribute("WORKFLOW_COMMENTS",
                                WorkflowConstants.WORKFLOW_COMMENTS); pageContext.setAttribute("WORKFLOW_DUE_DATE",
                                WorkflowConstants.WORKFLOW_DUE_DATE); pageContext.setAttribute("APPL_STATUS_CLOSED",
                                CoreConstants.APPL_STATUS_CLOSED); pageContext.setAttribute("APPL_STATUS_NEW",
                                CoreConstants.APPL_STATUS_NEW); pageContext.setAttribute("APPL_STATUS_PARKED",
                                CoreConstants.APPL_STATUS_PARKED); pageContext.setAttribute("APPL_STATUS_APPROVED",
                                CoreConstants.APPL_STATUS_APPROVED);
                                pageContext.setAttribute("APPL_STATUS_VERIFICATION",
                                CoreConstants.APPL_STATUS_VERIFICATION); pageContext.setAttribute("APPL_STATUS_CREATE",
                                CoreConstants.APPL_STATUS_CREATE); pageContext.setAttribute("APPLICATION_STATUS_LIST",
                                CommonUtils.getApplicationStatusList());
                                pageContext.setAttribute("LABEL_RADIO_COMMERICAL",
                                CoreConstants.LABEL_RADIO_COMMERICAL);
                                pageContext.setAttribute("LABEL_RADIO_CHARITABLE",
                                CoreConstants.LABEL_RADIO_CHARITABLE);
                                pageContext.setAttribute("LABEL_RADIO_GOVERNMENT",
                                CoreConstants.LABEL_RADIO_GOVERNMENT); pageContext.setAttribute("RADIO_COMMERICAL",
                                CoreConstants.RADIO_COMMERICAL); pageContext.setAttribute("RADIO_CHARITABLE",
                                CoreConstants.RADIO_CHARITABLE); pageContext.setAttribute("RADIO_GOVERNMENT",
                                CoreConstants.RADIO_GOVERNMENT); %>


                                <script type="text/javascript" src="<c:out value=" ${contextRoot}" />
                                /scripts/jquery/jquery.ajaxfileupload.js"></script>
                                <script
                                    src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
                                <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
                                <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
                                <script type="text/javascript">
                                    function editRTIApplicationdog() {
                                        //document.getElementById('rtiApplicationId').value = id;
                                        onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editRTIManagePermission.do');
                                    }

                                    function saveMandapCertificates() {

                                        onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/saveMandapCertificates.do');
                                    }

                                    function rtiApplicationSearch() {
                                        onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/listRTIApplicationReports.do');
                                    }

                                    function viewNoting() {
                                        onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/viewNoting.do');
                                    }

                                    function viewDrafts() {
                                        //document.getElementById('manageRTIApplicationId').value=id;
                                        onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/viewDrafts.do');
                                    }

                                    function downloadRTIApplicationList() {
                                        //document.getElementById('manageRTIApplicationId').value=id;
                                        onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/downloadRTIApplicationList.do');
                                    }

                                    function listRTIApplicationReports() {
                                        onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/listRTIApplicationReports.do');
                                    }

                                    function sendEmail() {
                                        //document.getElementById('manageRTIApplicationId').value=id;
                                        document.getElementById('actionTaken').value = 'email';
                                        onPageSubmit('<c:out value="${contextRoot}"/>/emailsms/emailSMS.do');
                                    }

                                    function sendSMS() {
                                        //document.getElementById('manageRTIApplicationId').value=id;
                                        document.getElementById('actionTaken').value = 'sms';
                                        onPageSubmit('<c:out value="${contextRoot}"/>/emailsms/emailSMS.do');
                                    }

                                    function download(id, url) {

                                        document.getElementById('rtiApplicationRefId').value = id;

                                        alert("Certificate has been generated successfully.");

                                        onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/' + url);

                                    }
                                </script>
                                <style type="text/css">
                                    input[type=text] {
                                        height: 35px;
                                        font-size: 15px;
                                    }

                                    .ClsButton {
                                        background-color: rgb(66, 124, 212);
                                        border: none;
                                        border-radius: 5px;
                                        min-height: 30px;
                                        min-width: 120px;

                                    }

                                    .ClsButton:hover {
                                        background: rgb(83, 83, 212);
                                        color: white;
                                    }

                                    a {
                                        text-decoration: none !important;

                                    }
                                </style>
                                <div class="container">
                                    <h3 style="font-size: 18px; font-weight: bold;">

                                       Final Fire NOC :
                                        <c:if test="${requestScope.rtiApplication != null}">
                                            <c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
                                        </c:if>
                                    </h3>
                                </div>
                                <div align="top" id="SetFormHeight">
                                    <input type="hidden" name="id" value="${fireComplianceCertificate.firecompliancecertificateid}">
                                    <h6 style="background-color: #dce2e8; padding: 10px;"
						class="  rounded-2">
						<strong> Applicant Details </strong>
					</h6>
                                    <table width="100%" border="0" cellpadding="2" cellspacing="2" class="container">
                                        <tr>
                                        <tr>
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                   First Name :
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.firstName}" /></td>

                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    Middle Name :
                                                </span><span class="ClsRequiredFields"></span></td>
                                            <td><input type="text" class="form-control" style="width: 180px"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.middleName}" /></td>
                                        </tr>
                                        
										<tr>				
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                   Last Name :
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.lastName}" /></td>

                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    Full Name :
                                                </span><span class="ClsRequiredFields"></span></td>
                                            <td><input type="text" class="form-control" style="width: 180px"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.fullName}" /></td>
                                        </tr>
                                        
                                        <tr>				
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                   Plot/ Flat No :
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.plotno}" /></td>

                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    City Survey No :
                                                </span><span class="ClsRequiredFields"></span></td>
                                            <td><input type="text" class="form-control" style="width: 180px"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.citysurveyno}" /></td>
                                        </tr>
                                        
                                        <tr>				
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                   Name of the Street :
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.strretname}" /></td>

                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    House Mouza No :
                                                </span><span class="ClsRequiredFields"></span></td>
                                            <td><input type="text" class="form-control" style="width: 180px"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.housemouzano}" /></td>
                                        </tr>
                                        
                                        <tr>				
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                   Pin Code :
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.pincode}" /></td>

                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    Landmark :
                                                </span><span class="ClsRequiredFields"></span></td>
                                            <td><input type="text" class="form-control" style="width: 180px"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.landmark}" /></td>
                                        </tr>
                                        
                                        <tr>				
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                   Email Id :
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.emailid}" /></td>

                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    Mobile No :
                                                </span><span class="ClsRequiredFields"></span></td>
                                            <td><input type="text" class="form-control" style="width: 180px"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.mobileno}" /></td>
                                        </tr>
                                        
                                        <tr>				
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                   Name of Power of Attorney  :
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.nameofpowerofattorney}" /></td>

                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    No.of standby :
                                                </span><span class="ClsRequiredFields"></span></td>
                                            <td><input type="text" class="form-control" style="width: 180px"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.noofstandby}" /></td>
                                        </tr>
                                        
                                        <tr>				
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                   Address of Power of Attorney  :
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.addressofpowerofattorney}" /></td>

                                        </tr>
                                    </table>
                                    <h6 style="background-color: #dce2e8; padding: 10px;"
						class="  rounded-2">
						
						<strong> Application Form Details</strong>
					</h6>
					<h6><strong>To,</strong> <br> <strong>Chief Fire Officer</strong>
					<br> <strong>N.M.C. Nagpur.</strong> <br> Sir,<br>
					Kindly issue compliance certificate to the building sanction vide
					building permit No. <strong> <h7 >${fireComplianceCertificate.permitno}</h7>
					</strong> .date. <strong> <h7>${fireComplianceCertificate.permitnodate}</h7>
					</strong> & fire recommendation letter No. <strong> <h7>${fireComplianceCertificate.firerecommendationno}</h7>
					</strong>. date <strong> <h7>${fireComplianceCertificate.firerecommendationnodate}</h7>
					</strong>. I have paid the necessary fees applicable having receipt No.<strong>
						<h7>${fireComplianceCertificate.receiptno}</h7>
					</strong>.dated.<strong> <h7>${fireComplianceCertificate.receiptnodate}</h7>
					</strong> I have enclosed all the necessary documents & certificates. The
					other building details are as under.</h6>
					                                    <table width="100%" border="0" cellpadding="2" cellspacing="2" class="container">
                                        <tr>
                                        <tr>
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                   Name of Building :
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.buildingname}" /></td>

                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    Address of Building :
                                                </span><span class="ClsRequiredFields"></span></td>
                                            <td><input type="text" class="form-control" style="width: 180px"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.addressbuilding}" /></td>
                                        </tr>
                                        
										<tr>				
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                   Name & Address of Building /promoter :
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.nameaddresspromoter}" /></td>

                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    Name & Address of Building/Promoter/Owner/Occupiers of individual flats :
                                                </span><span class="ClsRequiredFields"></span></td>
                                            <td><input type="text" class="form-control" style="width: 180px"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.nameaddressowner}" /></td>
                                        </tr>
                                        
                                        <tr>				
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                   Type of occupancy  :
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.typeofoccupancy}" /></td>

                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    Plot area :
                                                </span><span class="ClsRequiredFields"></span></td>
                                            <td><input type="text" class="form-control" style="width: 180px"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.plotarea}" /></td>
                                        </tr>
                                        
                                        <tr>				
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                   Total Built up area :
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.totalbuiltuparea}" /></td>

                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    Height of building :
                                                </span><span class="ClsRequiredFields"></span></td>
                                            <td><input type="text" class="form-control" style="width: 180px"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.heightofbuilding}" /></td>
                                        </tr>
                                        
                                        			<th colspan="16" style="font-size: 17px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Side marginal space
                                        			</th>                             
                                        <tr>				
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                   Front :
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.front}" /></td>

                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    Rear :
                                                </span><span class="ClsRequiredFields"></span></td>
                                            <td><input type="text" class="form-control" style="width: 180px"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.rear}" /></td>
                                        </tr>
                                        
                                        <tr>				
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                   Side 1 :
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.side1}" /></td>

                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    Side 2 :
                                                </span><span class="ClsRequiredFields"></span></td>
                                            <td><input type="text" class="form-control" style="width: 180px"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.side2}" /></td>
                                        </tr>
                                        <tr><td><td></tr>
                                        <tr>				
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                   Width of approach road to the building premises :
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.widthofapproach}" /></td>

                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    Width of entrance gate :
                                                </span><span class="ClsRequiredFields"></span></td>
                                            <td><input type="text" class="form-control" style="width: 180px"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.widthofentrance}" /></td>
                                        </tr>
                                        
                                        <tr>				
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                   Vertical clearance of entrance gate :
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.verticalclearance}" /></td>
                                                      
												<td><span class="ClsLabel" style="font-size: 14px">
                                                   		Vertical clearance of entrance gate :
                                                	</span>
                                                </td>
                                            	<td>	<input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.dateofsanctioning}" /></td>
                                       </tr>
                                       
                                        <tr>				
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                   Vertical clearance of entrance gate :
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.verticalclearance}" /></td>
                                                      
												<td><span class="ClsLabel" style="font-size: 14px">
                                                   		Whether completion certificate has been obtain for this building from the competent authority ? If yes, please attaché the copy of the same : :
                                                	</span>
                                                </td>
                                            	<td>	<input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.dateofsanctioning}" /></td>
                                       </tr>
                                       
                                       <tr>				
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                            Whether occupancy certificate has been obtain for this building from the competent authority ? If yes, please attaché the copy of the same:
                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.occupancy}" /></td>
                                                      
												<td><span class="ClsLabel" style="font-size: 14px">
												Number of basements :
                                                	</span>
                                                </td>
                                            	<td>	<input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.numberofbasements}" /></td>
                                       </tr>
                                       
                                       
                                       <tr>				
                                            <td><span class="ClsLabel" style="font-size: 14px">
												Number of floors(including ground floor):                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.numberoffloors}" /></td>
                                                      
												<td><span class="ClsLabel" style="font-size: 14px">
												Area of basement :
                                                	</span>
                                                </td>
                                            	<td>	<input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.areaofbasement}" /></td>
                                       </tr>
                                       
                                       <tr>				
                                            <td><span class="ClsLabel" style="font-size: 14px">
												Covered area of typical floor :                                                </span></td>
                                            <td><input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.coveredarea}" /></td>
                                                      
												<td><span class="ClsLabel" style="font-size: 14px">
												Compass direction in relation to the building :
                                                	</span>
                                                </td>
                                            	<td>	<input type="text" class="form-control" style="width: 180px;"
                                                      maxlength="50" name="ownerName" value="${fireComplianceCertificate.basementextends}" /></td>
                                       </tr>
                                       <th colspan="16" style="font-size: 17px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Exposure hazards(Please give Details)
                                        			</th> 
                                          <tr>				
                                            <td><span class="ClsLabel" style="font-size: 14px">
												Covered area of typical floor :  </span></td>
                                               <td></td>
												<td><span class="ClsLabel" style="font-size: 14px">
												If basement extends beyond the building line, : please indicate the load bearing strength of the roof of basement :
                                                	</span>
                                                </td>
                                          </tr>			  
                                        			
                                       
                                       
                                       
                                           
                                                                                
                                        
                                        <tr>
                                            <c:if test="${not empty mandapPermission.exhibitions}">

                                                <td>
                                                    <span class="ClsLabel" style="font-size:14px">
                                                        <fmt:message key="label.mandap.exhibitions" />:
                                                    </span>
                                                </td>
                                                <td>
                                                    <input type="radio" id="Commercial<c:out value="
                                                        ${pageScope.LABEL_RADIO_COMMERICAL}" />" name="exhibitions"
                                                    value="1" <c:if test="${mandapPermission.exhibitions==1}">
                                                        checked="checked"</c:if> />
                                                    <c:out value="Commercial" />
                                                    <input type="radio" id="Charitable<c:out value="
                                                        ${pageScope.LABEL_RADIO_CHARITABLE}" />" name="exhibitions"
                                                    value="2" <c:if test="${mandapPermission.exhibitions==2}">
                                                        checked="checked"</c:if> />
                                                    <c:out value="Charitable" />
                                                    <input type="radio" id="Government<c:out value="
                                                        ${pageScope.LABEL_RADIO_GOVERNMENT}" />" name="exhibitions"
                                                    value="3" <c:if test="${mandapPermission.exhibitions==3}">
                                                        checked="checked"</c:if> />
                                                    <c:out value="Government" />
                                                </td>

                                            </c:if>
                                        </tr>

                                        <%-- <tr>
                                            <td colspan="5">
                                                <span class="ClsLabel" style="font-size:14px">
                                                    <fmt:message key="label.mandap.fees" />:
                                                </span>
                                            </td>
                                            </tr> --%>

                                            <c:if test="${requestScope.rtiApplication.workFlowStatus==2}">

                                                <tr>
                                                    <td colspan="6" align="center">
                                                        <a target="_blank" href="" id="genCerBtn">

                                                            <button class="ClsButton clsButtonUpload"
                                                                onclick="download(${mandapPermission.rti_ref_id},'mandapCertificateReport.do')">GENERATE
                                                                CERTIFICATE</button>

                                                        </a>

                                                    </td>
                                                </tr>
                                            </c:if>




                                    </table>
					
					
                                    <table width="100%" border="0" cellpadding="2" cellspacing="2" class="container">

                                        <tr>
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    Current Status:</span></td>
                                            <td style="width: 230px; height: 30px"><span class="ClsLabel"
                                                    style="font-size: 14px">
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
                                                    </c:if>
                                                </span></td>


                                            <%-- <td colspan="6" align="center">
                                                <c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
                                                    <a target="_blank" href="" id="genCerBtn">

                                                        <button name="rtiApplicationRefId"
                                                            class="ClsButton clsButtonUpload"
                                                            onclick="download(${zoneCertificates.rti_ref_id},'zoneCertificateReport.do')">GENERATE
                                                            CERTIFICATE</button>
                                                    </a>

                                                    </td> --%>


                                                    <c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
                                                        <td><span class="ClsLabel" style="font-size:14px">Certificate
                                                                Upload: </span> </td>
                                                    </c:if>
                                                    <%@include file="/pages/common-pages/dms/fileUpload.jsp" %>
                                        </tr>

                                        <!--      <tr>
            <td colspan="6" style="padding-top:5px">
                <img src="../images/Transpx.gif" height="15px" />
            </td>
        </tr> -->


                                        <%-- <tr>
                                            <td colspan="6" align="center"><input type="button" class="ClsButton"
                                                    id="save" name="save" value="Save"
                                                    onclick="javascript:savemTPRegistrationCertificate(this.form);"
                                                    tabindex="31"> <input type="button" class="ClsButton" id="clear"
                                                    name="clear" value="<fmt:message key=" common.button.clear" />"
                                                onclick="javascript:clearFields('SearchTable');searchRTIApplication()"
                                                />




                                                <input type="hidden" class="ClsTextbox" style="width:180px"
                                                    id="rtiapplrefno" maxlength="12" name="rtiapplrefno"
                                                    value="<c:out value=" ${zoneCertificates.rtiapplrefno}" />" />

                                                <input type="hidden" class="ClsTextbox_mr" style="width:180px"
                                                    id="rti_ref_id" maxlength="12" name="rti_ref_id"
                                                    value="<c:out value=" ${zoneCertificates.rti_ref_id}" />" />
                                                --%>

                                    </table>
                                    <table width="100%" border="0" cellpadding="2" cellspacing="2" class="container">
                                        <tr>
                                            <td colspan="4"><span class="ClsLabel"
                                                    style="font-size: 15px; font-weight: bold;">
                                                    List of Documents (Attachment)For Fire Compliance Certificate :
                                                </span></td>
                                        </tr>
                                        <tr>
                                            <td style="width: 600px; height: 30px"><span class="ClsLabel"
                                                    style="font-size: 14px;">
                                                    Fitness certificate from licensing agency :
                                                </span></td>

                                            <td style="text-align: center">
                                                <c:set var="doc"
                                                    value="${fn:split(rtiApplication.pdfUploadFromPortal, ',')}" />
                                                <a class="ClsButton" type="button" target="_blank" href="<c:out value="
                                                    ${doc[0]}" />"><span style="align-items: center">Download</span></a>
                                            </td>

                                        <tr>
                                        <tr>
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    Building Plan,Sections and Elevations :
                                                </span></td>
                                            <td style="text-align: center"> <a class="ClsButton" type="button"
                                                    target="_blank" href="<c:out value=" ${doc[1]}" />"><span
                                                    style="align-items: center">Download</span></a>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    Civil Engineer certificate of Structural stability :
                                                </span></td>
                                            <td style="text-align: center"> <a class="ClsButton" type="button"
                                                    target="_blank" href="<c:out value=" ${doc[2]}" />"><span
                                                    style="align-items: center">Download</span></a>
                                            </td>
										</tr>
										
										                                        <tr>
                                            <td style="width: 600px; height: 30px"><span class="ClsLabel"
                                                    style="font-size: 14px;">
                                                    Architect certificate for fire water tanks :
                                                </span></td>

                                            <td style="text-align: center">
                                                <c:set var="doc"
                                                    value="${fn:split(rtiApplication.pdfUploadFromPortal, ',')}" />
                                                <a class="ClsButton" type="button" target="_blank" href="<c:out value="
                                                    ${doc[3]}" />"><span style="align-items: center">Download</span></a>
                                            </td>

                                        <tr>
                                        <tr>
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    Electrical inspector certificate :
                                                </span></td>
                                            <td style="text-align: center"> <a class="ClsButton" type="button"
                                                    target="_blank" href="<c:out value=" ${doc[4]}" />"><span
                                                    style="align-items: center">Download</span></a>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    Sanctioned building plan :
                                                </span></td>
                                            <td style="text-align: center"> <a class="ClsButton" type="button"
                                                    target="_blank" href="<c:out value=" ${doc[5]}" />"><span
                                                    style="align-items: center">Download</span></a>
                                            </td>
										</tr>
										                                        <tr>
                                            <td style="width: 600px; height: 30px"><span class="ClsLabel"
                                                    style="font-size: 14px;">
                                                    License copy of lift :
                                                </span></td>

                                            <td style="text-align: center">
                                                <c:set var="doc"
                                                    value="${fn:split(rtiApplication.pdfUploadFromPortal, ',')}" />
                                                <a class="ClsButton" type="button" target="_blank" href="<c:out value="
                                                    ${doc[6]}" />"><span style="align-items: center">Download</span></a>
                                            </td>

                                        <tr>
                                        <tr>
                                            <td><span class="ClsLabel" style="font-size: 14px">
                                                    Signature :
                                                </span></td>
                                            <td style="text-align: center"> <a class="ClsButton" type="button"
                                                    target="_blank" href="<c:out value=" ${doc[7]}" />"><span
                                                    style="align-items: center">Download</span></a>
                                            </td>

                                        </tr>
                                    </table>
                                    <br>
                                </div>

                                <input type="hidden" class="ClsTextbox" id="mandapPermissionId" style="width:180px"
                                    name="mandapPermissionId" value="<c:out value="
                                    ${mandapPermission.mandapPermissionId}" />" />
                                <input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId" value="" />
                                <%@include file="/pages/workflow/taskInclude.jsp" %>

                                    <script type="text/javascript">
                                        function saveEntity() {
                                            onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/createFireComplianceCertificate.do');
                                        }
                                    </script>
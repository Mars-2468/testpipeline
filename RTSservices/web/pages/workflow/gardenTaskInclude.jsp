<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>
<%
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
%>
<style type="text/css">
	/*
	  Replace the default icon on the "approve" and "others" workflow
	  action buttons (question mark, etc.) with a green tick. Reject
	  keeps its own red X - only positive/forward actions change here.
	  Scoped to #workflowDiv so it doesn't affect icons elsewhere on the
	  page.
	*/
	#workflowDiv .status.approveOn,
	#workflowDiv .status.approveOff,
	#workflowDiv .status.othersOn,
	#workflowDiv .status.othersOff,
	#workflowDiv .status.reverifyOn,
	#workflowDiv .status.reverifyOff {
		background-image: url("data:image/svg+xml;utf8,<svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 24 24'><circle cx='12' cy='12' r='11' fill='%2328a745'/><path d='M7 12.5l3.2 3.2L17 9' fill='none' stroke='white' stroke-width='2.2' stroke-linecap='round' stroke-linejoin='round'/></svg>") !important;
		background-repeat: no-repeat !important;
		background-position: center center !important;
		background-size: contain !important;
	}
</style>
<script type="text/javascript">
	
	function wfSetHidden(fieldName, val) {
		var el = null;
		if (fieldName) {
			el = document.getElementById(fieldName);
			if (!el) {
				var els = document.getElementsByName(fieldName);
				if (els && els.length) el = els[0];
			}
		}
		if (!el) {
			console.error('[workflow] Hidden field "' + fieldName + '" not found on page — cannot set action. ' +
				'Check for duplicate inclusion of the workflow fragment, or an empty id/name render.');
			alert('This action could not be completed: a required page field ("' + (fieldName || '(blank id)') +
				'") was not found. Please reload the page and try again. If this keeps happening, note the exact button you clicked and report it.');
			return false;
		}
		el.value = val;
		return true;
	}

	

	function wfWireUp() {
		try {
			$('.mainHdr a').attr("href","javascript:void(0)");
			<c:choose>
				<c:when test="${not empty IS_MY_TASK and IS_MY_TASK==false}">
					disableControlsByJquery(true);
					$('#SetFormHeight a').attr("onclick","javascript:void(0)");
					$('.mainHdr a').attr("onclick","javascript:void(0)");
					<c:forEach var="taskTransitionName" items="${WORKFLOW_TRANSISTIONS}" varStatus="iCount">
						var btn${iCount.index} = document.getElementById('workflow_tras_${taskTransitionName}');
						if (btn${iCount.index}) { btn${iCount.index}.setAttribute("onclick","javascript:void(0);"); btn${iCount.index}.removeAttribute("style"); }
					</c:forEach>
					var killBtn = document.getElementById('KillWorkflow');
					if (killBtn) { killBtn.setAttribute("onclick","javascript:void(0);"); killBtn.removeAttribute("style"); }
				</c:when>
				<c:when test="${not empty IS_MY_TASK and IS_MY_TASK==true}">
					disableControlsByJquery(true);
					$('#workflowDiv *').removeAttr('disabled');
				</c:when>
				<c:when test="${not empty PROCESS_ENDED and PROCESS_ENDED == true}">
					disableControlsByJquery(true);
					$('#SetFormHeight a').attr("onclick","javascript:void(0)");
					$('.mainHdr a').attr("onclick","javascript:void(0)");
				</c:when>
			</c:choose>

			
			mergeRoutingButtons('L1Approve', 'Send-For-Approval', 'Forward Application');

		} catch (e) { if (window.console && console.warn) { console.warn('workflow wire-up skipped:', e); } }
	}
	if (window.jQuery) { jQuery(wfWireUp); }
	else if (window.addEventListener) { window.addEventListener('load', wfWireUp); }
	else if (window.attachEvent) { window.attachEvent('onload', wfWireUp); }


function mergeRoutingButtons(transitionA, transitionB, label) {
    var btnA = document.getElementById('workflow_tras_' + transitionA);
    var btnB = document.getElementById('workflow_tras_' + transitionB);

    if (!btnA || !btnB) {
        return; // current task doesn't offer this routing choice - nothing to merge
    }
    if (document.getElementById('workflow_tras_ForwardApplication')) {
        return; // already merged (e.g. wfWireUp ran more than once)
    }

    var wrapperA = btnA.closest('.statusOption');
    var wrapperB = btnB.closest('.statusOption');
    if (wrapperA) wrapperA.style.display = 'none';
    if (wrapperB) wrapperB.style.display = 'none';

    var combined = document.createElement('div');
    combined.className = 'statusOption';
    combined.innerHTML =
        '<div class="status approveOn" title="' + label + '" ' +
             'id="workflow_tras_ForwardApplication" ' +
             'onclick="javascript:forwardL1Decision();" ' +
             'style="cursor:pointer"></div>' + label;

    var anchor = wrapperB || wrapperA || btnB || btnA;
    anchor.parentNode.insertBefore(combined, anchor.nextSibling);
}


function forwardL1Decision() {

    var heritageEl    = document.getElementById('heritageInput');
    var nonHeritageEl = document.getElementById('nonHeritageInput');

    var heritage    = heritageEl    ? parseInt(heritageEl.value, 10)    : NaN;
    var nonHeritage = nonHeritageEl ? parseInt(nonHeritageEl.value, 10) : NaN;
    heritage    = isNaN(heritage)    ? 0 : heritage;
    nonHeritage = isNaN(nonHeritage) ? 0 : nonHeritage;
    var total = heritage + nonHeritage;

    if (total === 0) {
        alert("Please complete the Tree Inspection Details before forwarding this application.");
        return false;
    }

    var required = (heritage > 0 || total >= 24) ? 'Send-For-Approval' : 'L1Approve';

    var message = (required === 'Send-For-Approval')
        ? "This application has " + heritage + " heritage tree(s) and " + total + " tree(s) in total.\n\n"
          + "It will be forwarded directly to the Tree Authority (L4) for approval, skipping L2/L3 verification.\n\nContinue?"
        : "This application has " + total + " non-heritage tree(s) (no heritage trees, under 24 total).\n\n"
          + "It will follow the standard workflow: L2 Verification -> L3 Verification -> L2 Final Process.\n\nContinue?";

    if (!confirm(message)) {
        return false;
    }

    completeTask(required);
}
</script>
<script type="text/javascript">
disableControlsByJquery(true);
$('#workflowDiv *').removeAttr('disabled');
function reassignWorkflowTask(frm)
{
	var touser = document.getElementById('toUserName').value;
	
	var taskid= document.getElementById('taskId').value;
	document.getElementById("selectedTaskIds").value = taskid;
	if(touser != null && touser !=''){
		navigate(frm,'<c:out value="${contextRoot}"/>/reassignworkflowLicense/reassignWorkflowTaskLicense.do');
	}
	else{
		alert('Please Select the Re-Assign to User');
	    return false;
	}
	
}

	function disableEnableControls(obj) {
		if(obj.checked) {
			disableControlsByJquery(false);
		} else {
			disableControlsByJquery(true);
			$('#workflowDiv *').removeAttr('disabled');
		}
	}

 function disableControlsByJquery(blnStatus) {
	    if (!blnStatus) {
	        $('#SetFormHeight *').removeAttr('disabled');
	        $('#SetFormHeight a').removeClass("not-active");
	    } else {
			$('#SetFormHeight *').attr('disabled', true);
			$('#SetFormHeight a').addClass("not-active");
	    }

		$('.downloadFile1').removeAttr('disabled');
		 $('.downloadFile1').removeClass("not-active");
		 $('.downloadFile3').removeAttr('disabled');
		 $('.downloadFile3').removeClass("not-active");


			$('.downloadFile').removeAttr('disabled');
			 $('.downloadFile').removeClass("not-active");
			 $('.downloadFile2').removeAttr('disabled');
			 $('.downloadFile2').removeClass("not-active");   
	} 
	
	function killCurrentWorkflow( frm ) {
	 if(checkMandatoryDetailed(new Array('${WORKFLOW_COMMENTS}'),new Array('Description')))
	 {
		
		if(confirm(" Do you really want to Discard the current WorkFlow ? ")){
			document.getElementById('<c:out value="${pageScope.WORKFLOW_ACTION}"/>').value='<c:out value="${pageScope.KILL_JOB}"/>';
			disableControlsByJquery(false);
			saveEntity();
		} else {
			return false;
		}
	 }else return false;
	}

	function createWorkflow( frm ) {

	    // --- NEW: L1 must save tree inspection details, upload the Pachanama
	    //          Report ("Plantation" upload - see uploadPlantation()), and
	    //          save the Tree Inspection Remarks BEFORE creating the workflow.
	    var treesSaved = '${empty requestScope.treestype ? "" : "1"}';
	    var pachanama   = '${treeCuting.pachanamaletter}';
	    var treeRemark  = '${treeCuting.treeRemark}';

	    if (!treesSaved || treesSaved === '') {
	        alert("Please save the Tree Inspection Details before creating the workflow.");
	        return false;
	    }
	    if (!pachanama || pachanama.trim() === '') {
	        alert("Please upload the Pachanama Report before creating the workflow.");
	        return false;
	    }
	    if (!treeRemark || treeRemark.trim() === '') {
	        alert("Please enter and save the Tree Inspection Remarks before creating the workflow.");
	        return false;
	    }
	    // -------------------------------------------------------------------

	  if(checkMandatoryDetailed(new Array('${WORKFLOW_COMMENTS}'),new Array('Task Description')))
	  {
		if(confirm(" Do you really want to Create WorkFlow ? ")){
			document.getElementById('<c:out value="${pageScope.WORKFLOW_ACTION}"/>').value='<c:out value="${pageScope.WORKFLOW_ACTION_CREATE_PROCESS}"/>';
			if(checkMandatoryDocs()){
				disableControlsByJquery(false);
				saveEntity();
			}

		} else {
			return false;
		}
	  }else return false;
	}
	

		function killWorkflow( frm ) {
			  if(checkMandatoryDetailed(new Array('${WORKFLOW_COMMENTS}'),new Array('Task Description')))
			  {
				if(confirm(" Do you really want to Create WorkFlow ? ")){
					if(checkMandatoryDocs()){
						disableControlsByJquery(false);
						rejectWorkflow();
					}

				} else {
					return false;
				}
			  }else return false;
			}
	
	function completeTaskDoc(transistionName) {
	if(checkMandatoryDetailed(new Array('idProof'),new Array('File Upload')))
	{
	
		completeTask(transistionName);
	}else return false;	
	}
	// =============================================================================
	// PATCH for /pages/workflow/gardenTaskInclude.jsp
	// Replace the existing completeTask(transistionName) function with this one.
	// Everything else in the file is unchanged.
	// =============================================================================

	function completeTask(transistionName) {

	    // --- L3 auto-routing -----------------------------------------------
	    // The Tree Officer (L3) screen renders two transition buttons:
	    //   "Send-For-Verification" -> L2 Final Process
	    //   "Send-For-Approval"     -> L4 Approval
	    // Rather than let the officer choose freely, we resolve the correct
	    // one from the heritage / non-heritage tree counts already on the
	    // page (heritageInput / nonHeritageInput), and silently correct the
	    // transition name before it's submitted - whichever of the two
	    // buttons was clicked.
	    if (transistionName === 'L1Approve' || transistionName === 'Send-For-Approval') {
	        var resolved = resolveL1Transition(transistionName);
	        if (resolved === false) {
	            return false; // resolveL1Transition already showed the reason
	        }
	        transistionName = resolved;
	    }
	    // ---------------------------------------------------------------------

	    // Check certificate upload only for Close-Application
	    if (transistionName === 'Close-Application') {
	        var value = '${requestScope.rtiApplication.pdfFilesSavedPath}';

	        if (!value || value.trim() === '') {
	            alert("Please Upload the Certificate!!");
	            return false;
	        }
	    }
	    if (transistionName === 'send-demand') {
	        var feesSaved = '${treeCuting.totalFeesWithGST}';
	        if (!feesSaved || feesSaved.trim() === '') {
	            alert("Please save the Fees (with GST) before sending the demand.");
	            return false;
	        }
	    }

	    if (checkMandatoryDetailed(new Array('${WORKFLOW_COMMENTS}'), new Array('Remarks'))) {

	        document.getElementById('<c:out value="${pageScope.WORKFLOW_ACTION}"/>').value =
	            '<c:out value="${pageScope.WORKFLOW_ACTION_COMPLETE_TASK}"/>';

	        document.getElementById('<c:out value="${pageScope.WORKFLOW_TRANSISTION}"/>').value =
	            transistionName;

	        disableControlsByJquery(false);
	        saveEntity();

	    } else {
	        return false;
	    }
	}

	// New helper - only used by the L1 branch above.
	function resolveL1Transition(clicked) {

	    var heritageEl    = document.getElementById('heritageInput');
	    var nonHeritageEl = document.getElementById('nonHeritageInput');

	    var heritage    = heritageEl    ? parseInt(heritageEl.value, 10)    : NaN;
	    var nonHeritage = nonHeritageEl ? parseInt(nonHeritageEl.value, 10) : NaN;

	    heritage    = isNaN(heritage)    ? 0 : heritage;
	    nonHeritage = isNaN(nonHeritage) ? 0 : nonHeritage;

	    var total = heritage + nonHeritage;

	    if (total === 0) {
	        alert("Please complete the Tree Inspection Details before forwarding this application.");
	        return false;
	    }

	    var required = (heritage > 0 || total >= 24) ? 'Send-For-Approval' : 'L1Approve';

	    if (required !== clicked) {
	        alert(
	            "Routing corrected.\n\n" +
	            "Heritage trees: " + heritage + "\n" +
	            "Total trees: " + total + "\n\n" +
	            "This application will be forwarded to " +
	            (required === 'Send-For-Approval'
	                ? "the Tree Authority (L4) for approval."
	                : "L2 for further process.")
	        );
	    }

	    return required;
	}
	
	function rejectTask(transistionName) {
		 var deptValue = '${requestScope.rtiApplication.department}';
		    if (deptValue === 'WATER-DEPARTMENT') {
		        alert("You don't have permission to reject the application!!");
		    	return false;
		    }else if(checkMandatoryDetailed(new Array('${WORKFLOW_COMMENTS}'),new Array('Remarks')))
	{
		document.getElementById('<c:out value="${pageScope.WORKFLOW_ACTION}"/>').value='<c:out value="${pageScope.WORKFLOW_ACTION_COMPLETE_TASK}"/>';
		document.getElementById('<c:out value="${pageScope.WORKFLOW_TRANSISTION}"/>').value=transistionName;
		alert("inside reject");
		disableControlsByJquery(false);
		saveEntity();
	}else return false;
	}
	
	
	function rejectTask(transistionName) {
		 var deptValue = '${requestScope.rtiApplication.department}';
		    if (deptValue === 'WATER-DEPARTMENT') {
		        alert("You don't have permission to reject the application!!");
		    	return false;
		    }else if(checkMandatoryDetailed(new Array('${WORKFLOW_COMMENTS}'),new Array('Remarks')))
	{
		document.getElementById('<c:out value="${pageScope.WORKFLOW_ACTION}"/>').value='<c:out value="${pageScope.WORKFLOW_ACTION_COMPLETE_TASK}"/>';
		document.getElementById('<c:out value="${pageScope.WORKFLOW_TRANSISTION}"/>').value=transistionName;
		disableControlsByJquery(false);
		saveEntity();
	}else return false;
	}	
	$('.mainHdr a').attr("href","javascript:void(0)");
	
	//$('#SetFormHeight a').attr("href","javascript:void(0)");
	
<c:choose>
    <c:when test="${not empty IS_MY_TASK and IS_MY_TASK==true and (empty PROCESS_ENDED or PROCESS_ENDED==false)}">
        disableControlsByJquery(true);
        $('#workflowDiv *').removeAttr('disabled');
        $('#dmsDocsCheckListTableId *').removeAttr('disabled');
        $('#uuid').removeAttr('disabled');
        $('.downloadFile').attr('disabled');
        $('.downloadFile2').attr('disabled');
        $('.downloadFile1').removeAttr('disabled');
        $('.downloadFile1').removeClass("not-active");
        $('.downloadFile3').removeAttr('disabled');
        $('.downloadFile3').removeClass("not-active");
        <c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
            $('#idProof').removeAttr('disabled');
            $('.clsButtonUpload').removeAttr('disabled');
        </c:if>
    </c:when>

    <c:otherwise>
        <%-- Fail-closed: not explicitly "my task" -> everything actionable is disabled --%>
        disableControlsByJquery(true);
        $('#commentsDisable *').attr('disabled', true);
        $('#genCerBtn').hide();
        $('#dsc').hide();
        $('#commentsDisable *').addClass("not-active");
        $('#descriptionDisabled *').attr('disabled', true);
        $('#descriptionDisabled *').addClass("not-active");
        $('#uuid').removeAttr('disabled');
        $('.mainHdr a').attr("onclick","javascript:void(0)");

        <c:forEach var="taskTransitionName" items="${WORKFLOW_TRANSISTIONS}" varStatus="iCount">
            var btn${iCount.index} = document.getElementById('workflow_tras_${taskTransitionName}');
            if (btn${iCount.index}) {
                btn${iCount.index}.setAttribute("onclick","javascript:void(0);");
                btn${iCount.index}.removeAttribute("style");
            }
        </c:forEach>

        var killBtn = document.getElementById('KillWorkflow');
        if (killBtn) {
            killBtn.setAttribute("onclick","javascript:void(0);");
            killBtn.removeAttribute("style");
        }

        $('#birthupload').attr('disabled', true);
        $('#birthdownload').attr('disabled', true);
        $('#zonemapdocupload').attr('disabled', true);
        $('#zonemapdownload').attr('disabled', true);
        $('#zoneMapidProof').attr('disabled', true);
        $('#paymentReceiptidProof').attr('disabled', true);
        $('#paymentReceiptdocupload').attr('disabled', true);
        $('#paymentReceiptdownload').attr('disabled', true);
    </c:otherwise>
</c:choose>

		
		 $('.downloadFile1').removeAttr('disabled');
		 $('.downloadFile1').removeClass("not-active");
		 $('.downloadFile3').removeAttr('disabled');
		 $('.downloadFile3').removeClass("not-active");

		 $('.downloadFile').removeAttr('disabled');
		 $('.downloadFile').removeClass("not-active");

		 $('.downloadFile3').removeAttr('disabled');
		 $('.downloadFile3').removeClass("not-active");
		 $('#download1').removeAttr('disabled');
		 $('#download2').removeAttr('disabled');
		 $('#download3').removeAttr('disabled');
		 $('#download4').removeAttr('disabled');
		 $('#download11').removeAttr('disabled');
		 $('#download22').removeAttr('disabled');
		 $('#download33').removeAttr('disabled');
		 $('#download44').removeAttr('disabled');
		 $('#uploadCer').removeAttr('disabled');
		 $('#uploadCerBtn1').removeAttr('disabled');
		 $('#uploadCerBtn2').removeAttr('disabled');
		 $('#uploadCerBtn3').removeAttr('disabled');
		 $('#uploadCerBtn').removeAttr('disabled');
		 $('#birthupload').removeAttr('disabled');
		 $('#birthdownload').removeAttr('disabled');
		 $('#zonemapdocupload').removeAttr('disabled');
		 $('#zonemapdownload').removeAttr('disabled');
		 $('#zoneMapidProof').removeAttr('disabled');
	     $('#paymentReceiptidProof').removeAttr('disabled');
	     $('#paymentReceiptdocupload').removeAttr('disabled');
	     $('#paymentReceiptdownload').removeAttr('disabled');

		 var rejected = '${requestScope.rtiApplication.workFlowStatus}';


if(rejected==5){
	
	 var elements = document.getElementsByClassName("tab")[0];
	    elements.innerHTML = "Application has been Rejected".fontcolor("red");
        $('#commentsDisable *').attr('disabled', true);
        $('#CreateWorkflow').attr('disabled', true);
        $('#RejectCreateWorkflow').attr('disabled', true);
        $('#WORKFLOW_COMMENTS').attr('disabled', true);
}

</script>

<c:if test="${workflowRequired eq 'true'}">
	<div class="workflowBox" id="workflowDiv">

		<!--
		  FIX: these hidden inputs used to live AFTER the closing </div> of
		  #workflowDiv, as siblings. If anything (saveEntity(), an AJAX
		  refresh, etc.) re-renders/replaces #workflowDiv's contents without
		  also touching what's outside it, these fields can end up missing
		  from the DOM entirely on a later task/level — exactly the
		  "Hidden field WORKFLOW_ACTION not found" failure. Moving them
		  inside #workflowDiv means they are regenerated every single time
		  this container is rendered, whether that's a full page load or a
		  partial refresh of just this div.
		-->
		<input type="hidden"
			name="<c:out value="${pageScope.WORKFLOW_ACTION}"/>"
			id="<c:out value="${pageScope.WORKFLOW_ACTION}"/>" value="" />

		<input type="hidden"
			name="<c:out value="${pageScope.WORKFLOW_TRANSISTION}"/>"
			id="<c:out value="${pageScope.WORKFLOW_TRANSISTION}"/>" value="" />

		<input type="hidden" name="<c:out value="${pageScope.WORKFLOW_NAME}"/>"
			id="<c:out value="${pageScope.WORKFLOW_NAME}"/>"
			value="<c:out value="${requestScope.WORKFLOW_NAME}"/>" />

		<input type="hidden"
			name="<c:out value="${pageScope.WORKFLOW_ENTITYNAME}"/>"
			id="<c:out value="${pageScope.WORKFLOW_ENTITYNAME}"/>"
			value="<c:out value="${requestScope.WORKFLOW_ENTITYNAME}"/>" />

		<input type="hidden"
			name="<c:out value="${pageScope.WORKFLOW_ENTITYID}"/>"
			id="<c:out value="${pageScope.WORKFLOW_ENTITYID}"/>"
			value="<c:out value="${requestScope.WORKFLOW_ENTITYID}"/>" />

		<input type="hidden"
			name="<c:out value="${pageScope.WORKFLOW_JOB_ID}"/>"
			id="<c:out value="${pageScope.WORKFLOW_JOB_ID}"/>"
			value="<c:out value="${requestScope.WORKFLOW_JOB_ID}"/>" />

		<input type="hidden"
			name="<c:out value="${pageScope.WORKFLOW_TASK_ID}"/>"
			id="<c:out value="${pageScope.WORKFLOW_TASK_ID}"/>"
			value="<c:out value="${requestScope.WORKFLOW_TASK_ID}"/>" />

		<div
			style="background-color:#e6e6e6; height:40px; padding:5px 10px 8px;">
			<span class="ClsTitle">Workflow Details</span>
				<c:if test="${requestScope.taskAssigne == '1'}">

				<span class="ClsTitle"
					style="float: right; font-size:10px;padding-bottom:5px;margin-top: 4px;">Edit
					Data</span>
				<span style="float: right;margin-top: 8px;"><input type="checkbox"
						id="workflowEdit" name="workflowEdit"
						onchange="disableEnableControls(this)" class="clsText" /> </span>
						<script>
						 window.onload = function() {
						       document.getElementById("workflowEdit").removeAttribute("disabled");;
						    };
    </script>
						</c:if>
			
		</div>

		<c:choose>
			<c:when test="${not empty nmmcWorkflowInstance.id}">
				<div style="padding:10px">
					<h3 class="tab">
						${requestScope.WORKFLOW_COMMENTS}
					</h3>
					<c:if test="${not empty PROCESS_ENDED and PROCESS_ENDED==false}">
						<div class="formBox">
							<table class="formTable" width="99%" border="0"
								style="float:left; margin-right:15px;">
								<tr>
									<td class="clsLabel">
										Priority
									</td>
									<td class="clsInput" colspan="3">
										<input type="radio" name="${pageScope.WORKFLOW_PRIORITY}"
											value="<c:out value="${pageScope.WORKFLOW_PRIORITY_LOW}"/>">
										<label for="low">
											<c:out value="${pageScope.WORKFLOW_PRIORITY_LOW_LABEL}" />
										</label>
										<input type="radio" name="${pageScope.WORKFLOW_PRIORITY}"
											value="<c:out value="${pageScope.WORKFLOW_PRIORITY_MEDIUM}"/>"
											checked>
										<label for="medium">
											<c:out value="${pageScope.WORKFLOW_PRIORITY_MEDIUM_LABEL}" />
										</label>
										<input type="radio" name="${pageScope.WORKFLOW_PRIORITY}"
											value="<c:out value="${pageScope.WORKFLOW_PRIORITY_HIGH}"/>">
										<label for="high">
											<c:out value="${pageScope.WORKFLOW_PRIORITY_HIGH_LABEL}" />
										</label>
									</td>
								</tr>
								<tr>
									<td class="clsLabel">
										Description
									</td>
									<td class="clsInput">
										<textarea style="width:300px;" id="${WORKFLOW_COMMENTS}" maxlength="1000"
											name="${WORKFLOW_COMMENTS}"></textarea>
									</td>
								</tr>

								<tr>
									<td class="clsLabel">
										Action
									</td>
									<td class="clsInput" colspan="3">
										<c:set var="workflowButton" value="On"></c:set>
										<c:if test="${not empty IS_MY_TASK and IS_MY_TASK==false}">
											<c:set var="workflowButton" value="Off"></c:set>
										</c:if>
										<c:forEach var="taskTransitionName"
											items="${WORKFLOW_TRANSISTIONS}" varStatus="iCount">
											<c:choose>
					
<c:when
test="${
taskTransitionName eq 'Accept'
or taskTransitionName eq 'Approve'
or taskTransitionName eq 'L1Approve'
or taskTransitionName eq 'L2Approve'
or taskTransitionName eq 'L3ForwardToL2'
or taskTransitionName eq 'L3ForwardToL4'
or taskTransitionName eq 'L4Approve'

or taskTransitionName eq 'approve'
or taskTransitionName eq 'Forward'
or taskTransitionName eq 'Forward To L2'
or taskTransitionName eq 'Forward To L4'
or taskTransitionName eq 'Certificate Issued'
or taskTransitionName eq 'Complete'
or taskTransitionName eq 'Update Status and Forward'
or taskTransitionName eq 'Scrutiny'
or taskTransitionName eq 'Issue LOI'
}">
													<div class="statusOption">
														<div class="status approve${workflowButton}"
															title="${taskTransitionName}"
															id="workflow_tras_${taskTransitionName}"
															onclick="javascript:completeTask('${taskTransitionName}')"
															style="cursor:pointer"></div>
														<c:out value="${taskTransitionName}" />
													</div>
												</c:when>
												<c:when
													test="${taskTransitionName eq 'reverify' or taskTransitionName eq 'Reverify' or taskTransitionName eq 'Re-verify' or taskTransitionName eq 're-verify' or taskTransitionName eq 'Re-Verify'}">
													<div class="statusOption">
														<div class="status reverify${workflowButton}"
															id="workflow_tras_${taskTransitionName}"
															title="${taskTransitionName}"
															onclick="javascript:completeTask('${taskTransitionName}')"
															style="cursor:pointer"></div>
														<c:out value="${taskTransitionName}" />
													</div>
												</c:when>
												<c:when
													test="${taskTransitionName eq 'Reject' or taskTransitionName eq 'reject'}">
													<div class="statusOption">
														<div class="status reject${workflowButton}"
															id="workflow_tras_${taskTransitionName}"
															title="${taskTransitionName}"
															onclick="javascript:completeTask('${taskTransitionName}')"
															style="cursor:pointer"></div>
														<c:out value="${taskTransitionName}" />
													</div>
												</c:when>
												<c:otherwise>
													<div class="statusOption">
														<div class="status others${workflowButton}"
															id="workflow_tras_${taskTransitionName}"
															title="${taskTransitionName}"
															onclick="javascript:completeTask('${taskTransitionName}')"
															style="cursor:pointer"></div>
														<c:out value="${taskTransitionName}" />
													</div>
												</c:otherwise>
											</c:choose>
										</c:forEach>

										<!--<div class="statusOption">
											<div class="status reject${workflowButton}"
												title="Discard Workflow" id="KillWorkflow"
												onclick="javascript:killCurrentWorkflow(this.form)"
												style="cursor:pointer"></div>
											Discard Workflow
										</div>-->
									</td>
								</tr>
							</table>
						</div>
					</c:if>
					<table border="0" width="100%" class="dataGrid" style="table-layout: fixed">
						<thead>
							<tr class="ClsTRHeaderList">
								<td>
									Task Id
								</td>
								<td>
									Action
								</td>
								<td>
									User Name
								</td>
								<!-- ><td>
									Name
								</td>
								<td>
									Level
								</td>-->
								<td>
									Start Date
								</td>
								<td>
									End Date
								</td>
								<td>
									Comments
								</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="listTaskHistory"
								items="${requestScope.TASK_HISTORY}">
								<c:forEach var="taskHistory" items="${listTaskHistory}">
									<tr>
										<td>
											<c:out value="${taskHistory.taskId}" />
										</td>
										<td>
											<c:out value="${taskHistory.outcome}" />
										</td>
										<td>
											<c:out value="${taskHistory.assignee}" />
										</td>
										   <!-- <td>
        <c:out value="${taskHistory.name}" />
    </td>

    <td>
        <c:out value="${taskHistory.level}" />
        -
        <c:out value="${taskHistory.assigneePlaceHolder}" />
    </td>-->
										<td>
											<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss"
												value="${taskHistory.createTime}" />
										</td>
										<td>
											<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss"
												value="${taskHistory.endTime}" />
										</td>
										<td style="word-wrap: break-word;">
											<c:out value="${taskHistory.comments}" />
										</td>
									</tr>
								</c:forEach>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</c:when>

			<c:otherwise>
				<div style="padding:10px">
					<h3 class="tab">
						Create Workflow
					</h3>
					<table class="formTable" border="0" width="40%">
						<tr>
							<td class="ClsLabel">
								Task Description
							</td>
							<td>
								&nbsp;
								<textarea style="width:300px;" id="${WORKFLOW_COMMENTS}" maxlength="1000"
										name="${WORKFLOW_COMMENTS}" style="width:300px;"></textarea>									
							</td>
						</tr>
						<tr>
							<td class="ClsLabel"></td>
							<td>
								<input type="button" name="CreateWorkflow" id="CreateWorkflow"
									value="Create Workflow"
									onclick="javascript:createWorkflow(this.form);"
									class="ClsButton" />
							</td>
						</tr>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

</c:if>

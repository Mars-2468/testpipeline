<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mars.common.utils.CommonUtils"%>
<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:directive.include file="/pages/common/include.jsp" />

<%
pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("DATE_TIME_DB_FORMAT", Constants.DATE_TIME_DB_FORMAT);

pageContext.setAttribute("DATE_TIME_FORMAT", WorkflowConstants.WORKFLOW_DATE_FORMAT);

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

pageContext.setAttribute("LABEL_RADIO_NEWTRADELICENCE",  CoreConstants.LABEL_RADIO_NEWTRADELICENCE);
pageContext.setAttribute("LABEL_RADIO_RENEWALTRADELICENCE",  CoreConstants.LABEL_RADIO_RENEWALTRADELICENCE);


pageContext.setAttribute("RADIO_NEWTRADELICENCE",  CoreConstants.RADIO_NEWTRADELICENCE);
pageContext.setAttribute("RADIO_RENEWALTRADELICENCE",  CoreConstants.RADIO_RENEWALTRADELICENCE); 

%>


<script type="text/javascript"
	src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery.ajaxfileupload.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script type="text/javascript">
	
	function saveNOCOfTradeCertificates() {

		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/saveNOCOfTradeCertificates.do');
	}

	function rtiApplicationSearch() {
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/listRTIApplicationReports.do');
	}

	function viewNoting() {
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/viewNoting.do');
	}

	function downloadRTIApplicationList(){
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

	function downloads(id,url) {

		document.getElementById('rtiApplicationRefId').value = id;
		
		alert("Certificate has been generated successfully.");
		
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/'+url);

	}
</script>
<style type="text/css">
input[type=text] {
	height: 35px;
	font-size: 15px;
}

.ClsButton {
	background-color:  rgb(66, 124, 212);
	border: none;
	border-radius: 5px;
	min-height: 30px;
	min-width: 120px;
	
}

 .ClsButton:hover {
	background: rgb(83, 83, 212);
	 color:white;
}
a {
  text-decoration: none !important;
 
}

</style>

<div class="container">
	<h3 style="font-size: 18px; font-weight: bold;">

		<fmt:message key="Application Form For Miscellaneous Receipt" />
		
		<%-- <c:if test="${requestScope.rtiApplication != null}">
			<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
		</c:if> --%>


	</h3>
</div>
<div valign="top" id="SetFormHeight">
	<%-- <input type="hidden" name="id"
		value="${nocTrade.nocTradeId}"> --%>
	<table width="100%" border="0" cellpadding="2" cellspacing="2"
		class="container">
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Date" />:</span></td>
			<td><input type="date" class="form-control"
				style="width: 300px;" id="date" name="date" value="" /></td>
				
				
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Phone" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 300px;" id="phone" maxlength="12" name="phone"
				value="" /></td>
		</tr>


		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Zone" />:</span><span class="ClsRequiredFields"></span></td>
			<!-- <td><input type="text" class="form-control" style="width: 300px"
				id="zone" maxlength="50" name="zone" value="" /></td> -->
				
				<td>
					<select class="form-control" style="width: 300px" id="zone" name="zone">
                        <option value="">--Select--</option>
                        <option value="Laxmi Nagar">Zone No.1 - Laxmi Nagar (लक्ष्मी नगर)</option>
					<option value="Dharmpeth">Zone No.2 - Dharmpeth (धरमपेठ)</option>
					<option value="Hanuman Nagar">Zone No.3 - Hanuman Nagar (हनुमान नगर)</option>
					<option value="Dhantoli">Zone No.4 - Dhantoli (धंतोली)</option>
					<option value="Nehru Nagar">Zone No.5 - Nehru Nagar (नेहरू नगर)</option>
					<option value="Gandhibag">Zone No.6 - Gandhibag (गांधीबाग)</option>
					<option value="Satranjipura">Zone No.7 - Satranjipura (सतरंजीपुरा)</option>
					<option value="Lakadganj">Zone No.8 - Lakadganj (लकडगंज)</option>
					<option value="Aashi Nagar">Zone No.9 - Aashi Nagar (आशी नगर)</option>
					<option value="Mangalwari">Zone No.10 - Mangalwari (मंगळवारी)</option>
					
				</td>


			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Ward " />:</span></td>
			<!-- <td><input type="text" class="form-control"
				style="width: 300px;" id="ward" name="ward" value="" /></td> -->
			<td><select class="form-control" style="width: 300px" id="ward" name="ward" disabled>
					<option value="">--Select Ward--</option>
			</select></td>
		</tr>
		


		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Department" />:</span><span class="ClsRequiredFields"></span></td>
			<td><input type="text" class="form-control" style="width: 300px" id="departmentName" name="department" value="" /></td>


			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Purpose" />:</span></td>
			<td>
			<!-- <textarea class="form-control" style="width: 300px;"
					id="purpose" name="purpose" rows="2"></textarea>-->
					
		 <select id="purpose" class="form-control" style="width: 300px; background-image: none;" name="purpose" required>
            <option value="" selected disabled>--- Select---</option>
            <c:forEach var="misPurposeWithAmount" items="${requestScope.misPurposeWithAmount}">
                <option value="${misPurposeWithAmount.purpose}"
                        data-fee="${misPurposeWithAmount.amount}">
                    <c:out value="${misPurposeWithAmount.purpose}" />
                </option>
            </c:forEach>
        </select>
					
					</td>
		</tr>


		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Received From" />:</span><span class="ClsRequiredFields"> </span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="receivedFrom" name="receivedFrom" value="" /></td>
				

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Amount" />:</span></td>
			<td>
			 <input type="text" class="form-control" style="width: 300px"
            id="amount" name="amount" pattern="[0-9]+(\.[0-9]+)?"
            value="" />
            
			<!-- <input type="text" class="form-control" style="width: 300px"
				id="amount" name="amount" pattern="[0-9]+"
				value="" />--></td>
		</tr>


		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Address" />:</span></td>
			<td><textarea class="form-control" style="width: 300px;"
					id="address" name="address" rows="2"></textarea></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Payment Mode" /></span><span class="ClsRequiredFields"></span>: </td>
			<!-- <td><input type="text" class="form-control" style="width: 300px"
				id="paymentMode" name="paymentMode" value="" /></td> -->
				<td>
                    <select class="form-control" style="width: 300px" id="paymentMode" name="paymentMode">
                        <option value="">--Select--</option>
                        <option value="Cash">Cash</option>
                        <option value="Cheque">Cheque</option>
                        <option value="Online">Online</option>
                    </select>
		</tr>


		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Received By" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="receivedBy" maxlength="50" name="receivedBy" value="" /></td>
					
		</tr>

		<tr>
			<td colspan="4" align="center" style="padding-top: 20px;"><input
				type="button" class="ClsButton" id= "submit" value="Submit" /> &nbsp;&nbsp;&nbsp;</td>
		</tr>


	</table>
	
	
</div>
<script type="text/javascript">
$(document).ready(function () {
    var isSubmitInProgress = false;

    $("#submit").click(function (event) {
        event.preventDefault();

        if (isSubmitInProgress) {
            return false;
        }

        // Gather values
        var date = $("#date").val();
        var phone = $("#phone").val();
        var zone = $("#zone").val();
        var ward = $("#ward").val();
        var department = $("#departmentName").val();
        var purpose = $("#purpose").val();
        var receivedFrom = $("#receivedFrom").val();
        var amount = $("#amount").val();
        var address = $("#address").val();
        var paymentMode = $("#paymentMode").val();
        var receivedBy = $("#receivedBy").val();

        // Validation
        if (!date || !zone || !ward || !department || !receivedFrom || !amount || !paymentMode) {
            alert("Please fill all required fields.");
            return false;
        }

        var requestData = {
            date: date,
            phone: phone,
            zone: zone,
            ward: ward,
            department: department,
            purpose: purpose,
            receivedFrom: receivedFrom,
            amount: amount,
            address: address,
            paymentMode: paymentMode,
            receivedBy: receivedBy
        };

        isSubmitInProgress = true;
        $("#submit").prop("disabled", true);

        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/saveMiscApplication.do",
            type: "POST",
            data: requestData,
            success: function (response) {
                if (response === "ERROR") {
                    alert("Error while saving application");
                    return;
                }
                window.location.href = response;
            },           
          
            error: function () {
                alert("Failed to submit application. Please try again.");
            },
            complete: function () {
                $("#submit").prop("disabled", false);
                isSubmitInProgress = false;
            }
        });
    });
});
</script>



<script>
$(document).ready(function() {
    $('#zone').on('change', function() {
        var zone = $(this).val();
        var $ward = $('#ward');
        $ward.prop('disabled', false);
        $ward.empty();

        var options = [];

        if (zone === 'Laxmi Nagar') {
            options = ['Ward No. 16', 'Ward No. 36', 'Ward No. 37', 'Ward No. 38'];
        } else if (zone === 'Dharmpeth') {
            options = ['Ward No. 12', 'Ward No. 13', 'Ward No. 14', 'Ward No. 15'];
        } else if (zone === 'Hanuman Nagar') {
            options = ['Ward No. 29', 'Ward No. 31', 'Ward No. 32', 'Ward No. 34'];
        } else if (zone === 'Dhantoli') {
            options = ['Ward No. 17', 'Ward No. 33', 'Ward No. 35'];
        } else if (zone === 'Nehru Nagar') {
            options = ['Ward No. 26', 'Ward No. 27', 'Ward No. 28', 'Ward No. 30'];
        } else if (zone === 'Gandhibag') {
            options = ['Ward No. 8', 'Ward No. 18', 'Ward No. 19', 'Ward No. 22'];
        } else if (zone === 'Satranjipura') {
            options = ['Ward No. 5', 'Ward No. 20', 'Ward No. 21'];
        } else if (zone === 'Lakadganj') {
            options = ['Ward No. 4', 'Ward No. 23', 'Ward No. 24', 'Ward No. 25'];
        } else if (zone === 'Aashi Nagar') {
            options = ['Ward No. 2', 'Ward No. 3', 'Ward No. 6', 'Ward No. 7'];
        } else if (zone === 'Mangalwari') {
            options = ['Ward No. 1', 'Ward No. 9', 'Ward No. 10', 'Ward No. 11'];
        }

        // Default option
        $ward.append('<option value="">--Select Ward--</option>');

        // Add dynamic ward options
        $.each(options, function(index, value) {
            $ward.append('<option value="' + value + '">' + value + '</option>');
        });
    });
});
</script>
<script>
document.getElementById("purpose").addEventListener("change", function() {
    let selected = this.options[this.selectedIndex];
    let fee = selected.getAttribute("data-fee");
    let fineInput = document.getElementById("amount");
    console.log("Selected fee:", fee); // Debugging: Remove in production

    if (fee && fee !== "0") {
        fineInput.value = fee;
    } else {
        fineInput.value = "";
    }
});
</script>




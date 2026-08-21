<%@ include file="/pages/common/include.jsp"%>

<script>
	disableEnterKeyForTextBox();
	var strArray = document.getElementsByTagName('textarea');
	if(strArray){
		for(i=0;i<strArray.length;i++){
			strArray[i].value = Trim(strArray[i].value);
		}
	}
	
</script>

<table width="99%" >
	<tr>
		<td id="idErrorBox" valign="middle">
			<div class="copyright">
				NMC
				<BR>
				Copyright Â© 2023 @NMC . All Rights Reserved.
			</div>				
		</td>
		<td>
			<div class="maintainedBy">
				<!-- maintained By Mars Telecom Systems -->
			</div>
		</td>
	</tr>
</table>

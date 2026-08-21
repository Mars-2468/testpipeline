<div>
	<span class="ClsLabel">
		<a title="Open GIS Map" href="javascript:openGISMap();" style="cursor: pointer;"> Open GIS Map</a>
	</span>
			
	<div valign="middle" id="dialogGIS" style="display:none">
		<iframe align="top" name="manageGISMap" id="manageGISMap"
			src="<c:out value="${contextRoot}"/>/pages/common/dummy.jsp"
			height="760" width="1000" marginheight="0" marginwidth="0"
			scrolling="auto" frameborder="0" noresize="noresize">
	
		</iframe>
	</div>
	
</div>
<script type="text/javascript" src="<c:out value="${contextRoot}"/>/scripts/gis/jsonStringify.js"></script>
<script type="text/javascript">
var jsGISId = '';
var jsGISData = '';

$(function() {
	document.getElementById("dialogGIS").style.display='';
	$("#dialogGIS").dialog({
		bgiframe: true,
		autoOpen: false,
		height: 768,
		resizable:true,
		width:1024,
		modal: false
	
	});
});

function openGISMap(){

	document.getElementById('manageGISMap').src = '<c:out value="${contextRoot}"/>/pages/common-pages/gis/manageGISMap.jsp';
	$('.error').css('display','none');
	try{
	$('#dialogGIS').dialog( "option", "title", 'GIS Map' );
	
	$('#dialogGIS').dialog('open');

	$('#dialogGIS' ).bind( "dialogbeforeclose", function(event, ui) {
		if(Trim(jsGISId).length > 0 && document.getElementById('gisId') != null)
			document.getElementById('gisId').value = jsGISId;

		if(Trim(jsGISData).length > 0 && document.getElementById('gisData') != null)
			document.getElementById('gisData').value = jsGISData;
	});	
	
	}catch(e){
	alert(e);
	}
}

function closeDialog(message)
{	
	displayError(message);
	$('#dialogGIS').dialog('close');
	scroll(0,0);
	
	if(Trim(jsGISId).length > 0 && document.getElementById('gisId') != null)
		document.getElementById('gisId').value = jsGISId;

	if(Trim(jsGISData).length > 0 && document.getElementById('gisData') != null)
		document.getElementById('gisData').value = jsGISData;
}
</script>
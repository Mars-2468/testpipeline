<jsp:directive.include file="/pages/common/include.jsp"/>
<jsp:directive.page import="com.mars.common.utils.Constants" />
<jsp:directive.include file="/pages/common/includeJS.jsp" />
<!--
<script type="text/javascript">

$(document).ready(function(){
	 var docHeight = $(document).height();
	 var winHeight = $(window).height();
	 
	 var footerHeight = $(".footer").height();
	 var headerHeight = $(".header").height();
	 
	 if(winHeight >= docHeight){			 
		 var diff =  winHeight - headerHeight - (3 * footerHeight) - 20;
		 $(".main").height(diff);			 
	 }
});


$(function() 
{
	document.getElementById("dialog").style.display='block';
	$("#dialog").dialog({
			autoOpen: false,
			height: 550,
			resizable:false,
			width:700,
			modal: false
	});
});

$(function() {
	$("#tabs").tabs({
		ajaxOptions: {
			error: function(xhr, status, index, anchor) {
				$(anchor.hash).html("Couldn't load this tab. We'll try to fix this as soon as possible. If this wouldn't be a demo.");
			}
		},
		load: function(event, ui) {
	        $('li.a', ui.panel).click(function() {
	            $(ui.panel).load(this.href);
	            return false;
	        });
	    }
	});
});	

<c:if test="${not empty requestScope.defaultTabIndex and requestScope.defaultTabIndex>0}">
$(document).ready(function(){
    $('#tabs').tabs('select', ${requestScope.defaultTabIndex});
});
</c:if>

</script>
-->
<div valign="middle" id="dialog" style="display:none" title="Edit Details">
	<iframe align="top" name="managePopup" id="managePopup" src="<c:out value="${contextRoot}"/>/pages/common/dummy.jsp" height="510" width="670" marginheight="0" marginwidth="0" scrolling="auto"
		frameborder="0" noresize="noresize"></iframe>
</div>

<!--[if lte IE 7]>
<script>
function ativaOptionsDisabled(){
    var sels = document.getElementsByTagName('select');
    for(var i=0; i < sels.length; i++){
        sels[i].onclick= function(){
            if(this.options[this.selectedIndex].disabled){
                if(this.options.length<=1){
                    this.selectedIndex = -1;
                }else if(this.selectedIndex < this.options.length - 1){
                    this.selectedIndex=0;
                }else{
                    this.selectedIndex= this.selectedIndex-1;
                }
            }
        }
        if(sels[i].options[sels[i].selectedIndex].disabled){
            sels[i].onclick();
        }    
        for(var j=0; j < sels[i].options.length; j++){
            if(sels[i].options[j].disabled){
                sels[i].options[j].style.color = '#CCC';
            }
        }
    }
}
window.attachEvent("onload", ativaOptionsDisabled)
</script>
<![endif]-->

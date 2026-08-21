var isMobile = navigator.userAgent.match(/(iPhone)|(iPod)|(android)|(webOS)/i);
	if(isMobile){
		console.log('mobile');
		var _body = document.getElementsByTagName("BODY")[0];		
		_body.removeAttribute("class", "desktop");
		_body.setAttribute("class", "mobile");		
}

//$(document).ready(function(){
//    jQuery(window).scroll( function() { 
//		var _scroll = jQuery(window).scrollTop();
//		var offset = $("#first-feature").offset();
//		var top = offset.top;
//		
//		if (_scroll > top ){	
//			console.log("shpw");		
//			jQuery(".mobile .mob-schedule-btn").addClass('show-btn');
//		}else{
//			jQuery(".mobile .mob-schedule-btn").removeClass('show-btn');
//			console.log("hide");
//		}	
//	});	
//});



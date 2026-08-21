    <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <!--  <script src="<c:out value="${contextRoot}"/>/dwr/interface/dictionary.js"></script> -->
    <script type="text/javascript">
     google.load("language", "1");
	 var from_lang = "en";
	 var to_lang = "mr";
	 function transliterateText(id) {
			var content = Trim(document.getElementById(id).value).toUpperCase();
			var dictionaryConetent = "";
			dictionary.getValue(content,function(data) {dictionaryConetent = data;

				if(dictionaryConetent.length > 0){
					document.getElementById(id+"_"+to_lang).value = dictionaryConetent;
				}else {
					if(content.split(" ").length <=5)
					{
						google.language.transliterate(content.split(" "), from_lang, to_lang, function(result) {
						  if (!result.error) {
							content ="";
							if (result.transliterations && result.transliterations.length > 0 &&
								result.transliterations[0].transliteratedWords.length > 0) {
								for(i=0;i<result.transliterations.length;i++)
									content= content + result.transliterations[i].transliteratedWords[0]+" ";
								content  = Trim(replaceAll(content,"undefined","")); 
								document.getElementById(id+"_"+to_lang).value = content;
							}
						  } 
						});
					} else { 
						 //This function is called when the Input string has more than 5 words in it. and also not found in Dictionary
						transliterateLongText(id,content);
					}
				}
				
			});
	}

	 
	 function transliterateLongText(id,content ) {
		 //This function is called when the Input string has more than 5 words in it.
		 document.getElementById(id+"_"+to_lang).value ="";
			var contArr = content.split(" "); 
			var contentPart="";
			var transContent="";
			for(var j=1;j<=contArr.length;j++){
				contentPart = Trim(contentPart + " " + Trim(contArr[j-1]) ); 
				if(contentPart.length > 0 && (j % 5 == 0 || j==contArr.length)){ 
					google.language.transliterate(contentPart.split(" "), from_lang, to_lang, function(result) {
						  var transContentPart= "";
						  if (!result.error) {
							  transContentPart ="";
							if (result.transliterations && result.transliterations.length > 0 &&
								result.transliterations[0].transliteratedWords.length > 0) {
								for(var i=0;i<result.transliterations.length;i++)
									transContentPart= transContentPart + result.transliterations[i].transliteratedWords[0]+" ";
								transContentPart  = Trim(replaceAll(transContentPart,"undefined","")); 
								//transContent  =  Trim(transContent + " " + transContentPart ); 
								document.getElementById(id+"_"+to_lang).value = Trim(document.getElementById(id+"_"+to_lang).value + " " + transContentPart); 
							}
						  } 
					});
					contentPart = "";
				}
			}
	 }
		
	 function transliterateDate(id) {
			var content = Trim(document.getElementById(id).value);
			content  = Trim(replaceAll(content,"/","-")); 
			google.language.transliterate(content.split(" "), from_lang, to_lang, function(result) {
			  if (!result.error) {
				content ="";
				if (result.transliterations && result.transliterations.length > 0 &&
					result.transliterations[0].transliteratedWords.length > 0) {
					for(i=0;i<result.transliterations.length;i++)
						content= content + result.transliterations[i].transliteratedWords[0]+" ";
					content  = Trim(replaceAll(content,"-","/")); 
					document.getElementById(id+"_"+to_lang).value = content;
				}
			  } 
			});
		}

	 //Added on March 8 2011	
	 
	 function setOtherLangSelect(id) {
		document.getElementById(id+"_"+to_lang).value=document.getElementById(id).value;
	}	

	 function setEnglishSelect(id) {
		var engId = id.substring(0,id.length-3);
		document.getElementById(engId).value=document.getElementById(id).value;
	}

//Added on MARCH 10 2011 
	 function changeOtherLangRadio(id) {
		 document.getElementById(id+"_"+to_lang).checked = "checked";
	}

	 function changeEnglishRadio(id) {
		 var engId=id.substring(0,id.length-3);
		 document.getElementById(engId).checked = "checked";
	}

</script>
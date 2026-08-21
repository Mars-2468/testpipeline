<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.include file="/pages/core-pages/nmc_user/dashboard/header.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants" />
<jsp:directive.page import="com.mars.common.utils.CommonUtils" />

 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>Document</title>
 </head>

 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js" rel="stylesheet"
 integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
 <link href=" https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" rel="stylesheet"
 integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
 <%
pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
String fname = (String) session.getAttribute("name");
String email = (String) session.getAttribute("email");
String number = (String) session.getAttribute("mobileNo");


//pageContext.setAttribute("statusList", CommonUtils.getStatus());
%>
<style>


    body{
     background-color:#545454;
     font-family: "Poppins", sans-serif;
     font-weight: 300;
    }

    .container{
     height: 100vh;
    }

    .card{

     width: 380px;
     border: none;
     border-radius: 15px;
     padding: 8px;
     background-color: rgb(246, 231, 214);
     position: relative;
     height: 420px;
    }

    .upper{

     height: 100px;

    }

    .upper img{

     width: 100%;
     border-top-left-radius: 10px;
     border-top-right-radius: 10px;
     

    }

    .user{
     position: center;
    }
    
    .name{
    text-align: center;
     /* position: center; */
         font-weight: bold;
     
    }

    .profile img{

     
     height: 130px;
     width: 130px;
     margin-top:-20px;
     margin-left: 120px;

    
    }
    .mainbox{
    
     margin-top: -550px;
    
     margin-left: 560px;

    }

    .profile{

    
     top:-50px;
     left: 98%;
     height: 120px;
     width: 120px;

     

    }

    .follow{

     border-radius: 15px;
     padding-left: 20px;
     padding-right: 20px;
     height: 35px;
    }

    .stats span{

     font-size: 29px;
    }</style>

 <body>
    <div class="mainbox"  style="align-items: center;">
             
        <div class="card">

         <div class="upper">

           <img src="<c:out value="${contextRoot}"/>/pages/core-pages/nmc_user/img/background.jpg" class="img-fluid">
           
         </div>

         <div class="user text-center">

           <div class="profile">

             <img src="<c:out value="${contextRoot}"/>/pages/core-pages/nmc_user/img/profileImg.png" >
             
           </div>

         </div>
<br>

         <div class="name">

           <h2 class="mb-0"><%=fname%></h2>
           <br>
           <span class="text-muted d-block mb-2" style="font-size: 130%;"><%=email%></span>
           <span class="text-muted d-block mb-2" style="font-size: 130%;"><%=number%></span>




             
           </div>
           
         </div>
          
        </div>

      </div>
    </body>

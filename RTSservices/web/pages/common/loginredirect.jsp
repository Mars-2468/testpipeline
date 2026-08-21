<%@ include file="include.jsp" %>
<%@ page import="javax.servlet.http.HttpSession"%>

<%
HttpSession session1 = request.getSession();
   Object dept = session1.getAttribute("deptLogin");
  
   if(dept != null){
       // Uncomment the following for Non-CAS (Non-SSO) setup
       if("deptLogin".equals(dept)){
           response.sendRedirect("login.do");
           session1.removeAttribute("deptLogin");
       } else {
           response.sendRedirect("ws/user/login.do");
       }
   }else{
       response.sendRedirect("ws/user/login.do");

   }
   // Uncomment the following for CAS (SSO) setup
   // response.sendRedirect("user/listUser.do");
%>




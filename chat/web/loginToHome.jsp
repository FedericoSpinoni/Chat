<%-- 
    Document   : loginToHome
    Created on : 30-mar-2018, 15.07.05
    Author     : mike
--%>

<%@page import="com.model.login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="login" scope="page" class="com.model.login" /> 

<%
String name= request.getParameter("inputUsername");
String pass= request.getParameter("inputPassword");
login l= new login();
if(l.verifyLogin(name, pass) == true)
    response.sendRedirect("home.jsp");
else 
    out.print("Error");
%>
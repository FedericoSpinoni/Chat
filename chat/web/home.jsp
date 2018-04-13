<%-- 
    Document   : home
    Created on : 13-apr-2018, 9.48.48
    Author     : mike
--%>

<%@page import="com.model.homeServlet"%>
<%@page import="java.util.List"%>
<%@page import="com.model.session"%>
<%@page import="com.entity.Chat"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>Chat</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/loginServlet" method="POST">
	<div class="wrapper">
		<div class="container-user">
			<div class="profile">
				
			</div>
			<div class="contacts">
				<div class="contact">Person</div>
				<%
                                    homeServlet h= null;
                                    h.getContact();
                                %>
			</div>
		</div>
		<div class="container-chat">
			<div class="person">

			</div>
			<div class="chat">
				<label class="message sender">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis magna massa, dapibus vitae rutrum semper, aliquam vel dolor. Nulla vel viverra ligula, quis eleifend augue. Phasellus fermentum felis ac maximus gravida. Etiam id urna at tellus posuere suscipit. In eget bibendum velit, eget porta orci. Cras et efficitur augue. Fusce turpis purus, ultrices ac venenatis mattis, congue nec sapien. Duis lectus diam, vehicula id elementum ac, molestie et dolor. Nullam vitae quam et odio tempor tempor eget non odio. Phasellus varius mollis sem ac ultrices.</label>
				<label class="message receiver">Oila</label>
				<label class="message sender">Ciao</label>
				<label class="message receiver">Oila</label>
				<label class="message receiver">Oila</label>
				<label class="message receiver">Oila</label>
				<label class="message receiver">Oila</label>
				<label class="message receiver">Oila</label>
				<label class="message receiver">Oila</label>
			</div>
                    
			<div class="send">

			</div>
		</div>
            </div>
        </form>
    </body>
</html> 
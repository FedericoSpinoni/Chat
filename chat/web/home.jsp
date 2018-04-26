<%-- 
    Document   : home
    Created on : 13-apr-2018, 9.48.48
    Author     : mike
--%>

<%@page import="com.model.chatServlet"%>
<%@page import="com.entity.User"%>
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
    
    <div>
        
    </div>
	<div class="wrapper">
		<div class="container-user">
			<div class="profile">
                            <img src="img/profile.jpg" class="img-profile"><br>
                            <%User u = (User)session.getAttribute("currentLogged");%>
                            <p>Welcome <%= u.getUsername() + " @" + u.getID() %></p>
			</div>
			<div class="search">
				<div class="search-container">
                                    <form action="" method="post">
                                        <button type="submit"><img src="img/search.png" class="img-search"></button>
					<input type="text" class="search-text">
                                    </form>
				</div>
			</div>
                    
                    <form action="${pageContext.request.contextPath}/showMessageServlet" method="post">
			<div class="contacts-container">
                                <div class="contacts">
                                    <%
                                        List<Chat> list = (List<Chat>)session.getAttribute("chatList");
                                        for (Chat c : list)
                                        {
                                    %>
                                    <button class="contact" value="<%= c.getId_receiver() %>">
                                            <img src="img/profile.jpg" class="img-contact">
                                            <p><%= c.getId_receiver() %></p>
				    </button>
                                    <%
                                        }
                                    %>
				</div>
			</div>
                    </form>
                                        
		</div>
		<div class="container-chat">
			<div class="person">
				<img src="img/profile.jpg" class="img-profile">
			</div>
			<div class="chat">
                            <!--<script>
                                $(document).on("click", "#somebutton", function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
                                $.get("someservlet", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                                $("#somediv").text(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
                                    });
                                });
                            </script>-->
				<div class="message">
					<div class=" sender">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis magna massa, dapibus vitae rutrum semper, aliquam vel dolor. Nulla vel viverra ligula, quis eleifend augue. Phasellus fermentum felis ac maximus gravida. Etiam id urna at tellus posuere suscipit. In eget bibendum velit, eget porta orci. Cras et efficitur augue. Fusce turpis purus, ultrices ac venenatis mattis, congue nec sapien. Duis lectus diam, vehicula id elementum ac, molestie et dolor. Nullam vitae quam et odio tempor tempor eget non odio. Phasellus varius mollis sem ac ultrices.</div>
				</div>
                            <div class="message">
					<div class=" sender">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis magna massa, dapibus vitae rutrum semper, aliquam vel dolor. Nulla vel viverra ligula, quis eleifend augue. Phasellus fermentum felis ac maximus gravida. Etiam id urna at tellus posuere suscipit. In eget bibendum velit, eget porta orci. Cras et efficitur augue. Fusce turpis purus, ultrices ac venenatis mattis, congue nec sapien. Duis lectus diam, vehicula id elementum ac, molestie et dolor. Nullam vitae quam et odio tempor tempor eget non odio. Phasellus varius mollis sem ac ultrices.</div>
				</div>
                            <div class="message">
					<div class=" sender">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis magna massa, dapibus vitae rutrum semper, aliquam vel dolor. Nulla vel viverra ligula, quis eleifend augue. Phasellus fermentum felis ac maximus gravida. Etiam id urna at tellus posuere suscipit. In eget bibendum velit, eget porta orci. Cras et efficitur augue. Fusce turpis purus, ultrices ac venenatis mattis, congue nec sapien. Duis lectus diam, vehicula id elementum ac, molestie et dolor. Nullam vitae quam et odio tempor tempor eget non odio. Phasellus varius mollis sem ac ultrices.</div>
				</div>
                            <div class="message">
					<div class=" sender">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis magna massa, dapibus vitae rutrum semper, aliquam vel dolor. Nulla vel viverra ligula, quis eleifend augue. Phasellus fermentum felis ac maximus gravida. Etiam id urna at tellus posuere suscipit. In eget bibendum velit, eget porta orci. Cras et efficitur augue. Fusce turpis purus, ultrices ac venenatis mattis, congue nec sapien. Duis lectus diam, vehicula id elementum ac, molestie et dolor. Nullam vitae quam et odio tempor tempor eget non odio. Phasellus varius mollis sem ac ultrices.</div>
				</div>
				<div class="message">
					<div class=" receiver">Oila</div>
				</div>								
			</div>
                    
			<div class="send">
				<div class="text-message-container">
					<input type="text" name="text-message" class="text-message">
					<button type="submit" class="send-message"><img src="img/send1.png" class="img-send"></button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
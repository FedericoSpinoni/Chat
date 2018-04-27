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
	<link rel="stylesheet" type="text/css" href="css/style.css?v=1">
	<title>Chat</title>
</head>
<body>
    
    <div>
        
    </div>
	<div class="wrapper">
		<div class="container-user">
			<div class="profile">
                            <img src="img/profile.jpg" class="img-profile">
                            <%User u = (User)session.getAttribute("currentLogged");%>
                            <p><%= "@" + u.getUsername() %></p>
			</div>
			<div class="search">
				<div class="search-container">
                                    <form action="" method="post">
                                        <button type="submit" class="search-button"><img src="img/search.png" class="img-search"></button>
					<input type="text" class="search-text">
                                    </form>
				</div>
			</div>
                    
                    <form action="${pageContext.request.contextPath}/showMessageServlet" method="post">
			<div class="contacts-container">
                                <div class="contacts">
                                    <%
                                        
                                        List<Chat> list = (List<Chat>)session.getAttribute("chatList");
                                        List<User> listUser = (List<User>)session.getAttribute("listUsername");
                                        for (Chat c : list) {
                                            for (User t : listUser) {
                                                if (c.getId_receiver() == t.getID()) { 
                                    %>
                                    
                                        <button class="contact" name ="contact-selected" value="<%=t.getID()%>">
                                            <img src="img/profile.jpg" class="img-contact">
                                            <p >@<%=t.getUsername() %> <%=t.getID()%></p>
				    </button>
                                    <input name="value_contact" value="<%=t.getID()%>" hidden="true">
                                    
                                    <%
                                                }
                                            }
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
                        <div>${message}</div>		
                        </div>
		</div>
	</div>
</body>
</html>
<%-- 
    Document   : home
    Created on : 13-apr-2018, 9.48.48
    Author     : mike
--%>

<%@page import="com.entity.Message"%>
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
                        
                       <!-- <form  method="post" name="searchForm" id="searchForm" enctype="multipart/form-data"> -->
                       <form action="${pageContext.request.contextPath}/addFriends" method="post">
                            <div class="search">
                                    <div class="search-container">
                                            <button type="submit" class="search-button"><img src="img/search.png" class="img-search"></button>
                                            <input type="text" name="searching" id="searching" class="search-text">
                                    </div>
                            </div>
                        </form>
                   
                   
                       <form  method="post" id="selectChatForm" enctype="multipart/form-data">
                     
                            
                           <div class="contacts-container" name="thisdiv" id="thisdiv">
                                    <div class="contacts">
                                        <%

                                            List<Chat> list = (List<Chat>)session.getAttribute("chatList");
                                            List<User> listUser = (List<User>)session.getAttribute("listUsername");
                                            for (Chat c : list) {
                                                for (User t : listUser) {
                                                    if (c.getId_receiver() == t.getID() && c.getId_message()==1)  { 
                                        %>

                                        <button class="contact" name ="contact-selected" value="<%=t.getID()%>" onclick="selectChat();">
                                                <img src="img/profile.jpg" class="img-contact">
                                                <p >@<%=t.getUsername() %> <%=t.getID()%></p>
                                        </button>
                                       

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
             <!--   <form  method="post" id="messageForm" enctype="multipart/form-data">    -->
             <form action="${pageContext.request.contextPath}/messageServlet" method="post">
                    <div class="chat">
                        
                    </div>

                    <div class="send">
                <div class="text-message-container">
                    <input type="text" name="testMessage" class="text-message" id="toSend">
                    <button type="submit" class="send-message" ><img src="img/send1.png" class="img-send"></button>
                </div>
            </div>
                  </form>   
		</div>
           
	</div>


<script type="text/javascript" >
 /*
 function addMessage(){
          if(window.XMLHttpRequest) { 
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST","messageServlet",true);
    var formData = new FormData(document.getElementById('messageForm'));
    xhttp.send(formData);
    }
    $.ajax({
        url: "",
        type:"POST",
        contentType:'application/json; charset=utf-8',
        success: function(response){
            var chat = JSON.parse();
            alert(chat.messagge[1]);
        }
    });
 }
 
 
  /*  function addMessage(){
        $.ajax({

            url : "/messageServlet.java",
            type: "POST",
            dataType : 'json',
            error : function() {

                alert("Error Occured");
            },
            success : function(data) {
                var receivedData = [];

                $.each(data.jsonArray, function(index) {
                    $.each(data.jsonArray[index], function(key, value) {
                        var point = [];

                            point.push(key);
                            point.push(value);
                            receivedData.push(point);

                        }); 
                });

            }
        });
    }
    function addMessage(){
  if(window.XMLHttpRequest) { 
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange=function() {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var myArr = JSON.parse(xhttp.responseText);
          }
    }
    xhttp.open("POST","messageServlet",true);
    var formData = new FormData(document.getElementById('messageForm'));
    xhttp.send(formData);
  }
  else console.log('not working');
}

function printMessage(){
    $.getJSON("messageServlet", function(result){
            $.each(result, function(i, field){
                $("div").append(field + " ");
            });
        });
    }  
        /*
    $.getJSON('messageServlet', function(data) {
    var table = $('<table>').appendTo($('#data'));
    $.each(data, function(i, Message) {
        var row = $('<tr>').appendTo(table);
        $('<td>').text(Message.getMessage()).appendTo(row);
    });
});
}*/

function addFriend(e){
    var userName = $('#searching').val();
    console.log("ADD FRIEND Started" + userName);
   $.ajax({
            url:"addFriends",
            method:"POST",
            data:{"searching" : userName},
            success: function(response){
                $('#thisdiv').load(document.URL +  ' #thisdiv');
                console.log("username");
                console.log(response);
    }
       });
}

</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</body>
</html>
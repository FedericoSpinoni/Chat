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
                        
                        <form  method="post" id="searchForm" enctype="multipart/form-data"> 
                            <div class="search">
                                    <div class="search-container">
                                            <button type="submit" class="search-button"><img src="img/search.png" class="img-search"></button>
                                            <input type="text" class="search-text" onclick="addFriend();">
                                    </div>
                            </div>
                        </form>
                   
                   
                        <form  method="post" id="selectChatForm" enctype="multipart/form-data">
                            
                            <div class="contacts-container">
                                    <div class="contacts">
                                        <%

                                            List<Chat> list = (List<Chat>)session.getAttribute("chatList");
                                            List<User> listUser = (List<User>)session.getAttribute("listUsername");
                                            for (Chat c : list) {
                                                for (User t : listUser) {
                                                    if (c.getId_receiver() == t.getID()) { 
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
                <form  method="post" id="messageForm" enctype="multipart/form-data">     
                    <div class="chat">
                        <div class="thisdiv" id="thisdiv">
                        </div>
                        
                    </div>

                    <div class="send">
                <div class="text-message-container">
                    <input type="text" name="testMessage" class="text-message" id="toSend">
                    <button type="submit" class="send-message" onclick="addMessage();" ><img src="img/send1.png" class="img-send"></button>
                </div>
            </div>
                  </form>   
		</div>
           
	</div>
</body>

<script type="text/javascript" >
 
 function addMessage(){
          if(window.XMLHttpRequest) { 
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST","messageServlet",true);
    var formData = new FormData(document.getElementById('messageForm'));
    xhttp.send(formData);
    }
    $.ajax({
        url: "/home/mike/Scrivania/Repository/Chat/chat/src/java/com/model/messageServlet.java",
        type:"POST",
        contentType:'application/json; charset=utf-8',
        success: function(response){
            var chat = JSON.parse();
            alert(chat.messagge[1]);
        }
    });
 }
 
 function selectChat()
 {
    if(window.XMLHttpRequest) { 
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST","messageServlet",true);
    var formData = new FormData(document.getElementById('messageForm'));
    xhttp.send(formData);
    }
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
    /*function addMessage(){
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


/*function addMessage(){
    $.post('messageServlet', function(responseJson){
       var $table = $("<table>").appendTo($("#somediv"));
        $.each(responseJson, function(index, rmessage) {    // Iterate over the JSON array.
            $("<tr>").appendTo($table)                     // Create HTML <tr> element, set its text content with currently iterated item and append it to the <table>.
                .append($("<td>").text(rmessage.message))        // Create HTML <td> element, set its text content with id of currently iterated product and append it to the <tr>.
         });
        
    });
}
*/
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

function addFriend(){
  if(window.XMLHttpRequest) { //Assuming you're not on one of the old IEs.
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange=function() {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var myArr = JSON.parse(xhttp.responseText);
            console.log(myArr);
            addToTable(myArr); // function to add data to table.

        }
    }
    xhttp.open("POST","addFriend",true);
    var formData = new FormData(document.getElementById('searchForm'));
    xhttp.send(formData);
  }
  else console.log('not working');
}

function selectChat(){
  if(window.XMLHttpRequest) { //Assuming you're not on one of the old IEs.
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange=function() {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var myArr = JSON.parse(xhttp.responseText);
            console.log(myArr);
            addToTable(myArr); // function to add data to table.

        }
    }
    xhttp.open("POST","showMessageServlet",true);
    var formData = new FormData(document.getElementById('selectChatForm'));
    xhttp.send(formData);
  }
  else console.log('not working');
}
</script>
</html>
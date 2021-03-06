<%-- 
    Document   : index
    Created on : 26-mar-2018, 17.48.42
    Author     : mike
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/login.css">
    <title>Login</title>
</head>

<body>
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <table class="table">
            <tbody>
                <tr class="container-logo">
                    <td>
                        <img class="logo" src="img/abchat_orizzontale.png">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="text" name="username" class="font" placeholder="Username">
                    </td>
                </tr>
                <tr>
                    <td>
                        <br>
                        <input type="password" name="password" class="font" placeholder="Password">
                    </td>
                </tr>
                <tr>
                    <td>
                        <br>
                        <input type="submit" name="submit" class="button" value="LOGIN">
                    </td>
                </tr>
                    <td>
                        <br>
                        <a href="register.jsp">Register</a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <br>
                        <label class="container">Remember me
                            <input type="checkbox" class="checkmark">
                            <input type="checkbox">
                            <span class="checkmark"></span>
                        </label>
                    </td>
                </tr>
            </tbody>
        </table>
        
    </form>
        <br>
        
</body>

</html>
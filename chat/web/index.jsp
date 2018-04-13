<%-- 
    Document   : index
    Created on : 26-mar-2018, 17.48.42
    Author     : mike
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <!-- INIZIO CORPO DELLA PAGINA -->
        <div class="container">
            <!-- CONTENITORE CHE DEFINISCE I MARGINI DELLA PAGINA -->
            <div class="col-12">
                <!-- DEFINIZIONE DELLA RIGA 1 -->
                <div class="row" style="margin-top: 5%;">
                    <div class="col-4"></div>
                    <div class="col-4">
                        <h2><p class="text-center font-italic"><sup>AB</sup><sub>Chat</sub></p></h2>
                    </div>
                    <div class="col-4"></div>
                </div>
                <!-- CHIUSURA RIGA 1 -->
                <div class="col-12">
                <div class="row">
                        <div class="col-2"></div>
                        <div class="col-8">
                            
                            <form action="${pageContext.request.contextPath}/loginServlet" method="POST">
                        <div class="form-group">
                          <label for="exampleInput">Username</label>
                          <input type="user" class="form-control" name="user"  placeholder="Enter username">
                          <small id="userHelp" class="form-text text-muted">Input your personal username, not your mail friend!</small>
                        </div>
                        <div class="form-group">
                          <label for="exampleInputPassword1">Password</label>
                          <input type="password" class="form-control" name="pass" placeholder="Password">
                          <small id="passHelp" class="form-text text-muted">I think it's like password1234 or ******</small>
                        </div>
                        <div class="form-check">
                          <input type="checkbox" class="form-check-input" id="exampleCheck1">
                          <label class="form-check-label" for="exampleCheck1">Check me out</label>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>

                      </form>
                          </div>
                        <div class="col-2"></div>
                    </div>
                </div>
            </div>
            <!-- CHIUSURA DELLA COLONNA CHE DEFINISCE I MARGINI -->
        </div>
        <!-- FINE CORPO DELLA PAGINA --> 
    </body>
</html>

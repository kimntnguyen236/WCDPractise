<%-- 
    Document   : login
    Created on : Mar 19, 2021, 11:13:13 AM
    Author     : sinhtm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Form</h1>
        <form action="j_security_check" method="Post">
            <input type="text" name="j_username" placeholder="Enter username..."/>
            <input type="password" name="j_password" placeholder="Enter password..."/>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>

<%-- 
    Document   : login
    Created on : Mar 19, 2021, 11:11:51 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Log in form</h1>
        <form action="j_security_check" method="POST">
            <input type="text" name="j_username" placeholder="Enter user name.....">
            <input type="password" name="j_password" placeholder="Enter user passowrd....."><!-- comment -->
            <input type="submit" value="Sign in">
        </form>
    </body>
</html>

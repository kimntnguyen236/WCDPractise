<%-- 
    Document   : Login
    Created on : Mar 20, 2021, 12:46:25 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login Employee</h1>
        <form action="EplServlet" method="post">
            <div>
                <div><input type="text" name="txtname" placeholder="Enter your ID" /></div>
                <div><input type="text" name="txtPass" placeholder="Enter your password" /></div>
                <div><input type="submit" name="action" value="LogIn"/></div>
            </div>
        </form>
    </body>
</html>

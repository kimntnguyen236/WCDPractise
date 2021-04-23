<%-- 
    Document   : login
    Created on : Mar 21, 2021, 12:35:43 PM
    Author     : ThienKim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <hr/>
        <!-- URL rewriting -->
        <h1>Login Page</h1>
        <form action="LoginServlet">
            <input type="text" name="txtID" placeholder="Enter your id ...."/>
            <input type="password" name="txtPass" placeholder="Enter your password ...."/>
            <input type="submit" value="Sign in" name="action"/>
        </form>
        <hr/>
    </body>
</html>

<%-- 
    Document   : login
    Created on : Mar 15, 2021, 11:10:23 AM
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
        <h1>Login Page</h1>
        <form action="EmployeesServlet" method="POST">
        <div>
            <input type="text" name="txtID" placeholder="Enter id..."/><br/><br/><!-- comment -->
            <input type="password" name="txtPass" placeholder="Enter pass..."/><br/><br/>
            <input type="submit" name="action" value="Login"/><br/><br/>
        </div>
        </form>
    </body>
</html>

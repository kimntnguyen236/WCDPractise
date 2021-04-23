<%-- 
    Document   : insert
    Created on : Mar 19, 2021, 12:10:21 PM
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
        <h1>Create new Contact</h1>
        <form action="ContactServlet" method="Post">
            <input type="text" name="txtFN" placeholder="Enter first name..."/>
            <input type="text" name="txtLN" placeholder="Enter last name..."/>
            <input type="text" name="txtPhone" placeholder="Enter phone..."/>
            <input type="submit" name="action" value="Create"/>
        </form>
    </body>
</html>

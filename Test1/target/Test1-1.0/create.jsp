<%-- 
    Document   : create
    Created on : Mar 21, 2021, 10:07:53 AM
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
        <form action="ContactServlet" method="POST">
            <input type="text" name="txtname" placeholder="Enter your name..."><br><!-- comment -->
            <input type="text" name="txtmail" placeholder="Enter your mail..."><br>
            
            <input type="submit" name="action" value="create"><br>
        </form>
    </body>
</html>

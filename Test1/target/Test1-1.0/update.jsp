<%-- 
    Document   : update
    Created on : Mar 21, 2021, 10:42:33 AM
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
           <input type="text" name="txtid" value="${item.getContactid()}" readonly="readonly"/></br>
           <input type="text" name="txtname" value="${item.getContactname()}"/><br><!-- comment -->
           <input type="text" name="txtmail" value="${item.getEmail()}"/><br>
            
            <input type="submit" name="action" value="update"><br>
        </form>
    </body>
</html>

<%-- 
    Document   : login
    Created on : Mar 12, 2021, 11:25:36 AM
    Author     : vomin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>D E L E T E</h1>
        <form action="NewsServlet">
            <div>
                <label>Enter ID :</label>
                <input type="text" name="txtID" placeholder="Enter any ID ..."/><br/><br/>
                <input type="submit" name="action" value="Delete"/>
            </div>
        </form>
    </body>
</html>

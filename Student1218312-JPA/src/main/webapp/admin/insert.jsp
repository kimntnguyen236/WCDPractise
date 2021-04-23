<%-- 
    Document   : insert
    Created on : Mar 22, 2021, 8:29:25 AM
    Author     : ThienKim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create new</title>
    </head>
    <body
        <h1>Create new Book</h1>
        <form action="../BookServlet" method="post">
            <div>
                <div><input type="text" name="txtID" placeholder="Enter ID" required="" /></div>
            </div>
            <div>
                <div><input type="text" name="txtNAME" placeholder="Enter a Title" required="" /></div>
            </div>
            <div>
                <div><input type="number" name="txtPrice" placeholder="Enter a Price " required/></div>
            </div>
            <div>
                <div><input type="text" name="txtPublisher" placeholder="Enter Publisher" required /></div>
            </div>
            <div>
                <div><input type="submit" name="action" value="Create" /></div>
                <div><input type="reset" name="action" value="Reset" /></div>
            </div>
        </form>
    </body>
</html>


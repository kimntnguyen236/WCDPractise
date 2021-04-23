<%-- 
    Document   : login
    Created on : Mar 12, 2021, 11:34:56 AM
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
        <h1 style="color: aqua">L O G I N  P A G E</h1>
        <form action="LoginServlet" method="POST">
            <div>
                <div>
                    <input type="text" name="txtID" placeholder="Enter your ID ..."/>
                </div><br/>
                <div>
                    <input type="password" name="txtPass" placeholder="Enter your Password ..."/>
                </div><br/><br/>
                <div>
                    <input type="submit" value="Login" name="action"/>
                </div>
            </div>
        </form>
    </body>
</html>

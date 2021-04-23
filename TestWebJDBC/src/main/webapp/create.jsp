<%-- 
    Document   : create
    Created on : Mar 20, 2021, 1:54:45 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
    </head>
    <body>
        <h3>Create new employee</h3>
        <form action="EplServlet" method="post">
                      <div>
                <div><input type="text" name="txtID" placeholder="Enter ID" required="khong" /></div>
            </div>
            <div>
                <div><input type="text" name="txtNAME" placeholder="Enter a name" required="" /></div>
            </div>
            <div>
                <div><input type="text" name="txtDEPARTMENT" placeholder="Enter a Deparment " required/></div>
            </div>
            <div>
                <div><input type="number" name="txtSALARY" placeholder="Enter Salary" required /></div>
            </div>
            <div>
                <div><input type="submit" name="action" value="Create" /></div>
            </div>
        </form>
    </body>
</html>

<%-- 
    Document   : create
    Created on : Mar 3, 2021, 11:09:07 AM
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
        <h1>Create Countries</h1>
        <form action="LoginServlet">
            <div>
                <div>
                    <input type="text" name="txtID" placeholder="Enter your ID ..."/>
                </div><br/>
                <div>
                    <input type="text" name="txtPASS" placeholder="Enter your Pass ..."/>
                </div><br/>
                <div>
                    <input type="text" name="txtNAME" placeholder="Enter your Name ..."/>
                </div><br/>
                <div>
                    <input type="text" name="txtSALARY" placeholder="Enter Salary ..."/>
                </div><br/><br/>
<!--                <div>
                    <input type="text" name="txtROLE" placeholder="Enter Role ..."/>
                </div><br/><br/>-->
                <div>
                    <input type="submit" name="action" value="Create"/>
                </div>
            </div>
        </form>
    </body>
</html>

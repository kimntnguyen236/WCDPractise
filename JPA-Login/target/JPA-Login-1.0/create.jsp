<%-- 
    Document   : create
    Created on : Mar 21, 2021, 12:34:57 PM
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
        <h1>Create New</h1>
        <form action="LoginServlet" method="POST">
            <div>
                <div>
                    <input type="text" name="txtID" placeholder="Enter id ...."/>
                </div> <br/>
                <div>
                    <input type="text" name="txtPassword" placeholder="Enter password ...."/>
                </div> <br/>
                <div>
                    <input type="text" name="txtName" placeholder="Enter name ...."/>
                </div> <br/>
                <div>
                    <input type="text" name="txtRole" placeholder="Enter role ...." value="0"/>
                </div> <br/>
                <div>
                    <input type="text" name="txtSalary" placeholder="Enter salary ...."/>
                </div> <br/>
                <div>
                    <input type="submit" name="action" value="Create"/>
                </div> <br/>
            </div>
        </form>
    </body>
</html>

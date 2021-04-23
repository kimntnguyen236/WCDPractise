<%-- 
    Document   : create
    Created on : Mar 21, 2021, 4:21:50 PM
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
        <form action="EmployeesServlet" method="POST">
            <div>
                <div>
                    <input type="text" name="txtID" placeholder="Enter id ..."/>
                </div> <br/>
                <div>
                    <input type="text" name="txtName" placeholder="Enter name ..."/>
                </div> <br/>
                <div>
                    <input type="password" name="txtPass" placeholder="Enter password ..."/>
                </div> <br/>
                <div>
                    <input type="text" name="txtSalary" placeholder="Enter salary ..."/>
                </div> <br/>
                <div>
                    <input type="submit" value="Create" name="action"/>
                </div>
            </div>
        </form>
    </body>
</html>

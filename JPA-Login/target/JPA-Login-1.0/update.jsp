<%-- 
    Document   : update
    Created on : Mar 21, 2021, 12:35:38 PM
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
        <h1>Update</h1>
        <form action="LoginServlet" method="POST">
            <div>
                <div>
                    <label>ID: </label>
                    <input type="text" name="txtID" value="${l.getId()}" readonly="true"/>
                </div> <br/>
                <div>
                    <label>Password: </label>
                    <input type="password" name="txtPass" value="${l.getPassword()}" readonly="true"/>
                </div> <br/>
                <div>
                    <label>Name: </label>
                    <input type="text" name="txtName" value="${l.getName()}" placeholder="Enter the name..."/>
                </div> <br/>
                <div>
                    <label>Role:  </label>
                    <input type="text" name="txtRole" value="${l.getRole()}" readonly="true"/>
                </div> <br/>
                <div>
                    <label>Salary: </label>
                    <input type="text" name="txtSalary" value="${l.getSalary()}" placeholder="Enter salary..."/>
                </div> <br/>
                <div>
                    <input type="submit" name="action" value="UpdateLogin"/>
                </div> <br/>
            </div>
        </form>
        <a href="LoginServlet">Back to list</a>
    </body>
</html>

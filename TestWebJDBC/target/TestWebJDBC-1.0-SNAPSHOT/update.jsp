<%-- 
    Document   : update
    Created on : Mar 20, 2021, 9:35:40 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
        <h1>Update Employee:</h1>
        <form action="EplServlet" method="post">
            <label>Employee ID:</label></br>
            <input type="text" name="txtID" value="${e.getEmployeeCode()}"/></br>
            <label>Employee Name:</label></br>
            <input type="text" name="txtName" value="${e.getEmployeename()}"/></br>
            <label>Department:</label></br>
            <input type="text" name="txtDepartment" value="${e.getDepartment()}"/></br>
            <label>Salary:</label></br>
            <input type="number" name="txtSalary" value="${e.getSalary()}"/></br><!-- comment -->
            <input type="submit" name="action" value="UpdateEmployee"/>
        </form>
    </body>
</html>

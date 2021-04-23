<%-- 
    Document   : Show
    Created on : Mar 20, 2021, 12:16:42 PM
    Author     : lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show</title>
    </head>
    <body>
        <h2>List Employee</h2>
        <h4><a href="create.jsp">Create new Employee</a></h4></br>
        
        <form action="EplServlet" method="get">
            <input type="text" name="txtsearch" placeholder="Enter key want search"/>
            <input type="submit" name="action" value="Search"/>
        </form></br>
        <form action="EplServlet" method="get">
            <div>
                <table border="1">
                    <tr>
                        <th>Employee ID</th>
                        <th>Employee Name</th>
                        <th>Department</th>
                        <th>Salary</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${list}" var="x">
                        <tr>
                            <td>${x.getEmployeeCode()}</td>
                            <td>${x.getEmployeename()}</td>
                            <td>${x.getDepartment()}</td>
                            <td>${x.getSalary()}</td>
                            <td>
                                <form action="EplServlet" method="post">
                                    <input type="txet" style="display:none" name="txtID" value="${x.getEmployeeCode()}"/>
                                    <input type="submit" name="action" value="Delete" />
                                    <input type="submit" name="action" value="Update" />
                                </form>
                            </td>
                        </tr>
                        
                    </c:forEach>
                </table>
                
            </div>
            <input type="submit" name="action" value="DisplayAll"/>
        </form>
    </body>
</html>

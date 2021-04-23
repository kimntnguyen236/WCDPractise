<%-- 
    Document   : show
    Created on : Mar 15, 2021, 11:13:25 AM
    Author     : ThienKim
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="create.jsp" >Create New</a>
        <h1>Employees List</h1>
        <form action="EmployeesServlet" method="GET">
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Salary</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td><c:out value="${item.getId()}"/></td>
                        <td><c:out value="${item.getName()}"/></td>
                        <td><c:out value="${item.getSalary()}"/></td>
                        <td>
                            <a href="EmployeesServlet?action=Delete&id=${item.getId()}">Delete</a>
                            <a href="EmployeesServlet?action=Details&id=${item.getId()}">Details</a>
                            <a href="EmployeesServlet?action=Update&id=${item.getId()}">Update</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>

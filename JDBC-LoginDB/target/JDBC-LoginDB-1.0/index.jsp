<%-- 
    Document   : show
    Created on : Mar 15, 2021, 11:12:28 AM
    Author     : vomin
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
        <h1>E M P L O Y E E  L I S T</h1>
        <a href="create.jsp">Create new</a>
        <hr/>
        <form action="LoginServlet" method="GET">
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Pass</th>
                    <th>Name</th>
                    <th>Salary</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td><c:out value="${item.getId()}"/></td>
                        <td><c:out value="${item.getPassword()}"/></td>
                        <td><c:out value="${item.getName()}"/></td>
                        <td><c:out value="${item.getSalary()}"/></td>
                        <td>
                            <a href="LoginServlet?action=delete&id=${item.getId()}">Delete || </a>
                            <a href="LoginServlet?action=details&id=${item.getId()}">Details || </a>
                            <a href="LoginServlet?action=getupdate&id=${item.getId()}">Update || </a>
<!--                            <a href="LoginServlet?action=SetPass&id=${item.getId()}">Reset Password</a>-->                           
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>

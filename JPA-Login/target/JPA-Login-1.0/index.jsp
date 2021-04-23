<%-- 
    Document   : index
    Created on : Mar 21, 2021, 12:34:29 PM
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
        <h3>List</h3>
        <form action="LoginServlet">
            <div>
                <input  type="text" name="uname" placeholder="Search by name..."/>
                <input type="submit" name="action" value="Search"/>
            </div>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Salary</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td> <c:out value="${item.getId()}"/></td>
                        <td><c:out value="${item.getName()}"/></td>
                        <td><c:out value="${item.getSalary()}"/></td>
                        <td>
                            <a href="LoginServlet?action=Delete&id=${item.getId()}">Delete</a>
                            <a href="LoginServlet?action=Details&id=${item.getId()}">Details</a>
                            <a href="LoginServlet?action=Update&id=${item.getId()}">Update</a> 
                            <!--name="ID" value="${item.getId()}"--> 
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>

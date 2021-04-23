<%-- 
    Document   : index
    Created on : Mar 19, 2021, 11:10:04 AM
    Author     : Administrator
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
        <h1>Index</h1>
        <form action="ContactServlet" method="GET">
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td><c:out value="${item.getContactid()}"/></td>
                        <td><c:out value="${item.getContactname()}"/></td><!-- comment -->
                        <td><c:out value="${item.getEmail()}"/></td>
                        <td>
                            <a href="ContactServlet?action=getupdate&id=${item.getContactid()}">Update</a>
                            <a href="ContactServlet?action=delete&id=${item.getContactid()}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%@include file="header.html" %>
    <body>
     
    <center>
            <br/>
        <%
            String uid = request.getSession().getAttribute("uid").toString();
        %>
        <h2 style="color: red">Welcome to <%=uid%></h2>
        <hr/>
        
        <a href="create.jsp" >Create New</a>
        <h3>Account List</h3>
        <form action="AccountServlet">
            <table border="1">
                <tr>
                    <th> Account ID </th>
                    <th> Name </th>
                    <th> Salary </th>
                    <th> Action </th>
                </tr>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td> <c:out value="${item.getId()}"/></td>
                        <td><c:out value="${item.getName()}"/></td>
                        <td><c:out value="${item.getSalary()}"/></td>
                        <td>
                            <a href="AccountServlet?action=delete&id=${item.getId()}">Delete</a>
                            <a href="AccountServlet?action=details&id=${item.getId()}">Details</a>
                            <a href="AccountServlet?action=update&id=${item.getId()}">Update</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </center>
</body>
<%@include file="footer.html" %>
</html>

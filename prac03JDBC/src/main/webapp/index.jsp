

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
                <c:forEach items="${list}" var="c">
                    <tr>
                        <td> <c:out value="${c.getId()}"/></td>
                        <td><c:out value="${c.getName()}"/></td>
                        <td><c:out value="${c.getSalary()}"/></td>
                        <td>
                            <a href="AccountServlet?action=delete&id=${c.getId()}">Delete</a>
                            <a href="AccountServlet?action=details&id=${c.getId()}">Details</a>
                            <a href="AccountServlet?action=getupdate&id=${c.getId()}">Update</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
        <hr/>
        <div>
                <input  type="text" name="uname" placeholder="Search by user name..."/>
                <input type="submit" name="action" value="Search"/>
            </div>
        <hr/>
    </center>
</body>
<%@include file="footer.html" %>
</html>

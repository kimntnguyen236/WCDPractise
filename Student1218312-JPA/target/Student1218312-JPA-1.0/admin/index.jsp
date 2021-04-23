<%-- 
    Document   : index
    Created on : Mar 22, 2021, 8:29:15 AM
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
        <h1>Show Book</h1>

        <form action="BookServlet" method="get">
            <table border="1">
                <tr>
                    <th>Book Code</th>
                    <th>Title</th>
                    <th>Price</th>
                    <th>Publisher</th>

                </tr>
                <c:forEach items="${list}" var="x">
                    <tr>
                        <td>${x.getBookCode()}</td>
                        <td><c:out value="${x.getTitle()}" /> </td>
                        <td><c:out value="${x.getPrice()}" /> </td>
                        <td><c:out value="${x.getPublisher()}" /> </td>
                    </tr>
                </c:forEach>
            </table></br></br>

        </form>
        <h3> <a href="admin/menu.jsp">Go to menu</a></h3>
    </body>
</html>

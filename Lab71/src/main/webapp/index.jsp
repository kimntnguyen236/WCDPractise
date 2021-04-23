<%-- 
    Document   : indẽ
    Created on : Mar 15, 2021, 8:39:02 AM
    Author     : vomin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
                <form action="NewsServlet" method="GET">
            <div>
                <input type="text" name="uname" placeholder="Search by name .."/>
                <input type="submit" name="action" value="Search"/>
            </div><br/>
            <table border="1">
                <tr>
                    <th>User ID</th>
                    <th>Title</th>
                    <th>Content</th>
                </tr>
                <c:forEach items="${list}" var="lst">
                    <tr>
                        <td><c:out value="${lst.getId()}"/></td>
                        <td><c:out value="${lst.getTitle()}"/></td>
                        <td><c:out value="${lst.getContent()}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>

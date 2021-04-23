<%-- 
    Document   : details
    Created on : Mar 21, 2021, 12:35:19 PM
    Author     : ThienKim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Details</h1>
        <form action="LoginServlet" method="GET">
            <div>
                <div>
                    <label>ID: </label>
                    <input type="text" value="${l.getId()}" readonly="true"/>
                </div> <br/>
                <div>
                    <label>Name: </label>
                    <input type="text" value="${l.getName()}" readonly="true"/>
                </div> <br/>
                <div>
                    <label>Salary: </label>
                    <input type="text" value="${l.getSalary()}" readonly="true"/>
                </div> <br/>
            </div>
        </form>
        <a href="LoginServlet">Back to list</a>
    </body>
</html>

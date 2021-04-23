

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Account Details</h1>
        <form action="AccountServlet" method="GET">
            <div>
                <div>
                    <label>Acc ID: </label>
                    <input type="text" value="${c.getId()}" readonly="true"/>
                </div> <br/><!-- comment -->
                <div>
                    <label> Name: </label>
                    <input type="text" value="${c.getName()}" readonly="true"/>
                </div> <br/>
                <div>
                    <label>Salary: </label>
                    <input type="text" value="${c.getSalary()}" readonly="true"/>
                </div> <br/>
               
            </div>
        </form>
        <a href="AccountServlet">Back</a>
    </body>
</html>

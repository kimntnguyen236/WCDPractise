<%-- 
    Document   : details
    Created on : Mar 8, 2021, 11:35:11 AM
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
        <h1>Course Details</h1>
        <form action="LoginServlet" method="GET">
            <div>
                <div>
                    <label>ID: </label>
                    <input type="text" value="${c.getId()}" readonly="true"/>
                </div> <br/><!-- comment -->
                <div>
                    <label>Pass: </label>
                    <input type="text" value="${c.getPassword()}" readonly="true"/>
                </div> <br/>
                <div>
                    <label>Name: </label>
                    <input type="text" value="${c.getName()}" readonly="true"/>
                </div> <br/>
                <div>
                    <label>Salary:  </label>
                    <input type="text" value="${c.getSalary()}" readonly="true"/>
                </div> <br/>
                <div>
                    <label>Role:  </label>
                    <input type="text" value="${c.getRole()}" readonly="true"/>
                </div> <br/>
            </div>
        </form>
        <a href="LoginServlet">Back</a>
    </body>
</html>

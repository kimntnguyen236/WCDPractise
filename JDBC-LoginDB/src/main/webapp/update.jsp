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
        <form action="LoginServlet" method="POST">
            <div>
                <div>
                    <label> ID: </label>
                    <input type="text" name="txtID" value="${c.getId()}" readonly="true"/>
                </div> <br/><!-- comment -->
                <div>
                    <label>Pass: </label>
                    <input type="text" name="txtNAME" value="${c.getPassword()}" placeholder="Enter the course name..."/>
                </div> <br/>
                <div>
                    <label>Name: </label>
                    <input type="text" name="txtDURATION" value="${c.getName()}" placeholder="Enter duration..."/>
                </div> <br/>
                <div>
                    <label>Salary:  </label>
                    <input type="text" name="txtFEE" value="${c.getSalary()}" placeholder="Enter fee..."/>
                </div> <br/>
                <div>
                    <label>Role:  </label>
                    <input type="text" name="txtFEE" value="${c.getRole()}" readonly="true"/>
                </div> <br/>
                <div>
                    <input type="submit" name="action" value="update"/>
                </div> <br/>
            </div>
        </form>
        <a href="LoginServlet">Back</a>
    </body>
</html>

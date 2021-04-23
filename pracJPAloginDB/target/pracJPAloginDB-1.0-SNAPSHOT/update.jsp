

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Account Update</h1>
        <form action="AccountServlet" method="POST">
            <div>
                <div>
                    <label>Account ID: </label>
                    <input type="text" name="txtID" value="${c.getId()}" readonly="true"/>
                </div> <br/><!-- comment -->
                <div>
                    <label> Password:  </label>
                    <input type="password" name="txtPass" value="${c.getPassword()}" readonly="true"/>
                </div> <br/>
                <div>
                    <label> Name: </label>
                    <input type="text" name="txtName" value="${c.getName()}" readonly="true"/>
                </div> <br/>
                <div>
                    <label> Salary: </label>
                    <input type="text" name="txtSalary" value="${c.getSalary()}" placeholder="Enter new salary..."/>
                </div> <br/>
               
                <div>
                    <input type="submit" name="action" value="UpdateAccount"/>
                </div> <br/>
            </div>
        </form>
        <a href="AccountServlet">Back</a>
    </body>
</html>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit Account</h1>
        <form action="AccountServlet" method="POST">
            <div>
                <div>
                    <label>Account ID: </label>
                    <input type="text" name="txtID" value="${c.getId()}" readonly="true"/>
                </div> <br/>
                <div>
                    <label> Password:  </label>
                    <input type="password" name="txtPass" value="${c.getPassword()}" placeholder="Enter new password..."/>
                </div> <br/>
                <div>
                    <label> Name: </label>
                    <input type="text" name="txtName" value="${c.getName()}" placeholder="Enter Name ..."/>
                </div> <br/>
                <div>
                    <label> Salary: </label>
                    <input type="text" name="txtSalary" value="${c.getSalary()}" placeholder="Enter salary..."/>
                </div> <br/>
               <div>
                    <label> Role: </label>
                    <input  type="text" value="${c.getRole()}"/>
                </div> <br/>
                <div>
                    <input type="submit" name="action" value="update"/>
                </div> <br/>
            </div>
        </form>
        <a href="AccountServlet">Back</a>
    </body>
</html>

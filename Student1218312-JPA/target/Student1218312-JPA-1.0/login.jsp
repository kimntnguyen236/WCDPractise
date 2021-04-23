<%-- 
    Document   : login
    Created on : Mar 22, 2021, 9:27:13 AM
    Author     : ThienKim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <body bgcolor = "#ffffff">
      
      <form method = "POST" action ="j_security_check">
         <table border = "0">
            <tr>
               <td>Login</td>
               <td><input type = "text" name="j_username"></td>
            </tr>
            <tr>
               <td>Password</td>
               <td><input type = "password" name="j_password"></td>
            </tr>
         </table>
         <input type = "submit" value = "Login!">
         
      </form>
      
   </body>
</html>
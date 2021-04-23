/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.jdbc.models;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author ThienKim
 */
public class EmployeesDAO {
    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public EmployeesDAO() {
        setConn();
    }

    private Connection setConn() {
        String url = "jdbc:sqlserver://localhost:1433;database=Sem04DB";
        String user = "sa";
        String password = "123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmployeesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public List<Employees> findAll() {
        List<Employees> list = new ArrayList<>();
        String sql = "SELECT * FROM Employees WHERE role=0";
        try {
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Employees employee = new Employees();
                employee.setId(rs.getString("id"));
                employee.setName(rs.getString("name"));
                employee.setPassword(rs.getString("password"));
                employee.setSalary(rs.getInt("salary"));
                employee.setRole(rs.getBoolean("role"));

                list.add(employee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
public void delete(String id)
    {   
        try {
            String sql = "DELETE FROM Employees WHERE id=?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

public int addEmployee(Employees emp) {
        int status = 0;
        String query = "INSERT INTO Employees VALUES(?,?,?,?,?)";
        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, emp.getId());
            pstmt.setString(2, emp.getName());
            pstmt.setString(3, emp.getPassword());
            pstmt.setInt(4, emp.getSalary());
            pstmt.setBoolean(5, false);
            status = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
}

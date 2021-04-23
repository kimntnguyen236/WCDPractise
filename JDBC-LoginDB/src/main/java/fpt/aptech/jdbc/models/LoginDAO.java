/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.jdbc.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vomin
 */
public class LoginDAO {

    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public LoginDAO() {
        setConn();
    }

    private Connection setConn() {
        String url = "jdbc:sqlserver://localhost:1433;database=WCD";
        String user = "sa";
        String password = "123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public boolean checkLogin(String id, String password) {
        try {
            String sql = "SELECT * FROM login WHERE id=? AND password=?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Login> findAll() {
        List<Login> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM login";
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Login lg = new Login();
                lg.setId(rs.getString("id"));
                lg.setName(rs.getString("name"));
                lg.setPassword(rs.getString("password"));
                lg.setSalary(rs.getInt("salary"));

                list.add(lg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int addNew(Login login) {
        int status = 0;
        String query = "INSERT INTO login VALUES(?,?,?,?,?)";
        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, login.getId());
            pstmt.setString(2, login.getPassword());
            pstmt.setString(3, login.getName());
            pstmt.setFloat(4, login.getSalary());
            pstmt.setBoolean(5, false);
            status = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public void resetPass(String id) {
        try {
            String sql = "UPDATE login SET password='Password' WHERE id=?";
            pstmt = connection.prepareStatement(sql);
            //rs = pstmt.executeQuery();
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String id) {
        try {
            String sql = "DELETE FROM login WHERE id=?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Login details(String cid) {
//
//        int count = 0;
//
//        while (rs.next()) {
//            String id = rs.getString(0);
//            String name = rs.getString(1);
//            String pass = rs.getString(2);
//            float salary = rs.getFloat(3);
//            boolean role = rs.getBoolean(4);
//
//            String output = "User #%d: %s - %s - %s - %s - %s";
//            System.out.println(String.format(output, ++count, id ,name, pass, salary, role));
//        }
//        return null;
//    }
//}
//        --------------------------------
//        Login lg = new Login();
//
//        try {
//            String sql = "SELECT * FROM login WHERE id=?";
//            pstmt = connection.prepareStatement(sql);
//            pstmt.setString(1, cid);
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                
//                lg.setId(rs.getString(1));
//                lg.setPassword(rs.getString(2));
//                lg.setName(rs.getString(3));
//                lg.setSalary(rs.getInt(4));
//                lg.setRole(false);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return lg;
//        -----------------------------
        try {
            String sql = "SELECT * FROM login WHERE id=?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, cid);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Login getUpdate(String cid) {
        Login country = new Login();
        String query = "Select * from login where id = ?";
        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, cid);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                country.setId(rs.getString("id"));
                country.setPassword(rs.getString("password"));
                country.setName(rs.getString("name"));
                country.setSalary(rs.getInt("salary"));
                country.setRole(rs.getBoolean("role"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return country;
    }

    public int updateContact(Login contact) {
        int result = 1;
        String query = "update login SET password = ?,name = ?, salary = ?,role =? where id = ?";

        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, contact.getPassword());
            pstmt.setString(2, contact.getName());
            pstmt.setDouble(3, contact.getSalary());
            pstmt.setBoolean(4, false);
            pstmt.setString(5, contact.getId());
            pstmt.executeUpdate();
            result = 0;
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
//
//    public int update(Login login) {
//        int r = -1;
//        try {
//            //2. tao doi tuong statement chua linh update SQL
//            String sql = "UPDATE login SET id=?, password=?,name=?,salary=?,role=? WHERE id=?";
//            pstmt = connection.prepareStatement(sql);
//
//            //3. set gia tri cho cac tham so ? trong linh update    
//            pstmt.setString(1, login.getId());
//            pstmt.setString(2, login.getPassword());
//            pstmt.setString(3, login.getName());
//            pstmt.setFloat(4, login.getSalary());
//            pstmt.setBoolean(5, false);
//
//            //4. thuc hinh linh update SQL
//            r = pstmt.executeUpdate();
//
//            //5. dong cac resources
//            pstmt.close();
//            connection.close();
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//        return r;
//    }



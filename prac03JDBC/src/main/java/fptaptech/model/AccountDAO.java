/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fptaptech.model;

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
 * @author BuuBuu
 */
public class AccountDAO {

    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public AccountDAO() {
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
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public int addAccount(Account account) {
        int status = 0;
        String query = "INSERT INTO Account VALUES(?,?,?,?,?)";
        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, account.getId());
            pstmt.setString(2, account.getPassword());
            pstmt.setString(3, account.getName());
            pstmt.setDouble(4, account.getSalary());
            pstmt.setBoolean(5, false);
            status = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public List<Account> findAll() {
        List<Account> listCountries = new ArrayList<Account>();
        String query = "SELECT * FROM Account";
        try {
            pstmt = connection.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Account country = new Account();
                country.setId(rs.getString("id"));
                country.setPassword(rs.getString("password"));
                country.setName(rs.getString("name"));
                country.setSalary(rs.getDouble("salary"));
                country.setRole(rs.getBoolean("role"));

                listCountries.add(country);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCountries;
    }

    public Account findOne(String id) {
        Account account = new Account();
        String query = "SELECT * FROM Account WHERE id=?";
        try {
            pstmt = connection.prepareStatement(query);

            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {

                account.setId(rs.getString("id"));
                account.setPassword(rs.getString("password"));
                account.setName(rs.getString("name"));
                account.setSalary(rs.getDouble("salary"));
                account.setRole(rs.getBoolean("role"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
    }

    public List<Account> findByName(String uname) {
        List<Account> listaccount = new ArrayList<>();
        String query = "SELECT * FROM Account WHERE uname=?";
        try {
            pstmt = connection.prepareStatement(query);

            pstmt.setString(2, uname);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getString(1));
                account.setPassword(rs.getString(2));
                account.setName(rs.getString(3));
                account.setSalary(rs.getDouble(4));
                account.setRole(rs.getBoolean(5));

                listaccount.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaccount;

    }
    
//     public Account getUpdate(String id) {
//        Account country = new Account();
//        String query = "Select * from Account where id = ?";
//        try {
//            pstmt = connection.prepareStatement(query);
//            pstmt.setString(1, id);
//            rs = pstmt.executeQuery();
//            if (rs.next()) {
//               country.setId(rs.getString("id"));
//                country.setPassword(rs.getString("password"));
//                country.setName(rs.getString("name"));
//                country.setSalary(rs.getDouble("salary"));
//                country.setRole(rs.getBoolean("role"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return country;
//    }

    public Account getUpdate(String aid) {
        Account country = new Account();
        String query = "Select * from Account where id = ?";
        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, aid);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                country.setId(rs.getString("id"));
                country.setPassword(rs.getString("password"));
                country.setName(rs.getString("name"));
                country.setSalary(rs.getDouble("password"));
                country.setRole(rs.getBoolean("role"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return country;
    }
    
    public int updateAccount(Account contact) {
        int result = -1;
        String query = "update Account SET  password = ?,name = ?, salary=?, role=? where id = ?";

        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, contact.getPassword());
            pstmt.setString(2, contact.getName());
            pstmt.setDouble(3, contact.getSalary());
            pstmt.setBoolean(4,false);
            pstmt.executeUpdate();
//            result = 0;
//            return result;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    

    public int deleteAccount(String aid) {
        try {
            String sql = "DELETE FROM Account WHERE id=?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, aid);
            int i = pstmt.executeUpdate();
            if (i != 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public boolean checkLogin(String id, String pass) {
        String query = "SELECT * FROM Account WHERE id=? And password=? ";
        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, pass);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}

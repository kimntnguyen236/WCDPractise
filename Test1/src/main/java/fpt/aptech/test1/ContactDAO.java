/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.test1;

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
 * @author ThienKim
 */
public class ContactDAO {
    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public ContactDAO() {
        setConnect();
    }

    private Connection setConnect() {
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=WCD";
            String user = "sa";
            String password = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return connection;
    }

    public List<Contact> findAll() {
        List<Contact> listCountries = new ArrayList<Contact>();
        String query = "Select * from Contact";
        try {
            pstmt = connection.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Contact country = new Contact();
                country.setContactid(rs.getInt("contactid"));
                country.setContactname(rs.getString("contactname"));
                country.setEmail(rs.getString("email"));
                listCountries.add(country);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCountries;
    }

    public int addContact(Contact contact) {
        int result = 1;
        String query = "insert into Contact values(?,?)";

        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, contact.getContactname());
            pstmt.setString(2, contact.getEmail());
            pstmt.executeUpdate();
            result = 0;
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Contact getUpdate(int contactid) {
        Contact country = new Contact();
        String query = "Select * from Contact where contactid = ?";
        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, contactid);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                country.setContactid(rs.getInt("contactid"));
                country.setContactname(rs.getString("contactname"));
                country.setEmail(rs.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return country;
    }

    public int updateContact(Contact contact) {
        int result = 1;
        String query = "update Contact SET contactname = ?, email = ? where contactid = ?";

        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, contact.getContactname());
            pstmt.setString(2, contact.getEmail());
            pstmt.setInt(3, contact.getContactid());
            pstmt.executeUpdate();
            result = 0;
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public int deleteContact(int id){
        int result = 0;
        String query = "delete from Contact where contactid = ?";
        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }
}

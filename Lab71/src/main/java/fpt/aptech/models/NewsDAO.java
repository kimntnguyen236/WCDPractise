/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.models;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vomin
 */
public class NewsDAO {

    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public NewsDAO() {
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
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public boolean delete(int id)
    {   
        News object = new News();
        try {
            String sql ="SELECT * FROM News WHERE id=? ";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if(rs.next() == false)
            {
                return false;
            }
            else{
                String sqlDelete ="DELETE  FROM News WHERE id=? ";
                pstmt = connection.prepareStatement(sqlDelete);
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(News.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}

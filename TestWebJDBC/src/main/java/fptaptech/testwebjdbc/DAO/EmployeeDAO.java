package fptaptech.testwebjdbc.DAO;

import fptaptech.testwebjdbc.Models.Employee;
import fptaptech.testwebjdbc.Models.tbUser;
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
 * @author
 */
public class EmployeeDAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public EmployeeDAO() {
        setconnect();
    }

    public Connection setconnect() {
        String query = "jdbc:sqlserver://localhost:1433;database=MavenDB";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(query, "sa", "123");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public List<Employee> getEmlpoyee() {
        List<Employee> list = new ArrayList<>();
        String query = "SELECT * FROM Employee";
        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Employee em = new Employee();
                em.setEmployeeCode(rs.getString(1));
                em.setEmployeename(rs.getString(2));
                em.setDepartment(rs.getString(3));
                em.setSalary(rs.getDouble(4));
                list.add(em);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public tbUser checklogin(String name) {
        tbUser user = new tbUser();
        String sql = "select *from tbUser where UserName=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                user.setUserID(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setPassword(rs.getString(3));
            }else{
                return  null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }



    public void insertEmployee(Employee em) {
        String query = "INSERT INTO Employee\n"
                + "VALUES (?,?,?,?);";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, em.getEmployeeCode());
            ps.setString(2, em.getEmployeename());
            ps.setString(3, em.getDepartment());
            ps.setDouble(4, em.getSalary());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean CheckIDExited(String id) {
        Employee em = new Employee();
        String sql = "SELECT *FROM Employee where EmployeeCode=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Employee findOne(String id) {
        Employee em = new Employee();
        String query = "SELECT *FROM Employee where EmployeeCode=?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                em.setEmployeeCode(rs.getString(1));
                em.setEmployeename(rs.getString(2));
                em.setDepartment(rs.getString(3));
                em.setSalary(rs.getDouble(4));
            }
            else {
            return new Employee();
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return em;
    }

    public void updateEmployee(Employee em) {
        String query = "UPDATE Employee\n"
                + "SET  Employeename = ?,"
                + " Department=?,"
                + "salary=?\n"
                + "WHERE EmployeeCode=?;";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, em.getEmployeename());
            ps.setString(2, em.getDepartment());
            ps.setDouble(3, em.getSalary());
            ps.setString(4, em.getEmployeeCode());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteEmployee(String id) {
        String sql = "DELETE FROM Employee WHERE EmployeeCode=?;";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Employee> searchEmployee(String ename) {
        List<Employee> list = new ArrayList<Employee>();
        String sql = "SELECT * FROM Employee WHERE Employeename like ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + ename + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Employee em = new Employee();
                em.setEmployeeCode(rs.getString(1));
                em.setEmployeename(rs.getString(2));
                em.setDepartment(rs.getString(3));
                em.setSalary(rs.getDouble(4));
                list.add(em);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}

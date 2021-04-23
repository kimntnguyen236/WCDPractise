/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import fptaptech.testwebjdbc.DAO.EmployeeDAO;
import fptaptech.testwebjdbc.Models.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lenovo
 */
public class EplServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            EmployeeDAO dao = new EmployeeDAO();
            String action = request.getParameter("action");
            if (action == null) {
                request.setAttribute("list", dao.getEmlpoyee());
                request.getRequestDispatcher("Show.jsp").forward(request, response);
            } else if (action.equals("Create")) {
                Employee em = new Employee();
                em.setEmployeeCode(request.getParameter("txtID"));
                em.setEmployeename(request.getParameter("txtNAME"));
                em.setDepartment(request.getParameter("txtDEPARTMENT"));
                em.setSalary(Double.parseDouble(request.getParameter("txtSALARY")));
                String ids = request.getParameter("txtID");
                if (dao.findOne(ids)!=null) {
                    request.getRequestDispatcher("create.jsp").include(request, response);
                    out.println("<h5 style=\"color: red\">ID already exist</h5>");
                } else {
                    dao.insertEmployee(em);
                    response.sendRedirect("EplServlet");
                }
            } else if (action.endsWith("Update")) {
                String eid = request.getParameter("txtID");
                request.setAttribute("e", dao.findOne(eid));
                request.getRequestDispatcher("update.jsp").forward(request, response);
            } else if (action.equals("UpdateEmployee")) {
                Employee em = new Employee();
                em.setEmployeeCode(request.getParameter("txtID"));
                em.setEmployeename(request.getParameter("txtName"));
                em.setDepartment(request.getParameter("txtDepartment"));
                em.setSalary(Double.parseDouble(request.getParameter("txtSalary")));
                dao.updateEmployee(em);
                response.sendRedirect("EplServlet");
            } else if (action.equals("Delete")) {
                String eid = request.getParameter("txtID");
                dao.deleteEmployee(eid);
                response.sendRedirect("EplServlet");
            } else if (action.equals("Search")) {
                String esearch = request.getParameter("txtsearch");
                request.setAttribute("list", dao.searchEmployee(esearch));
                request.getRequestDispatcher("Show.jsp").forward(request, response);
            } else if (action.equals("LogIn")) {
                String uname = request.getParameter("txtname");
                String upas = request.getParameter("txtPass");
                if (dao.checklogin(uname)!=null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("us", dao.checklogin(uname).getUserName());
                    response.sendRedirect("EplServlet");
                }else{
                     out.println("<h5 style=\"color: red\">Invalid password or UserName</h5>");
                request.getRequestDispatcher("Login.jsp").include(request, response);
                }
            }

        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

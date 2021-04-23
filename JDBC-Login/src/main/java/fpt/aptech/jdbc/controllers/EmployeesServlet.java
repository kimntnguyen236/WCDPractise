/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.jdbc.controllers;

import fpt.aptech.jdbc.models.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ThienKim
 */
public class EmployeesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String eid = request.getParameter("txtID");
            String epass = request.getParameter("txtPass");
            String action = request.getParameter("action");
            EmployeesDAO dao = new EmployeesDAO();
            if (action == null) {
                List<Employees> list = dao.findAll();
                request.setAttribute("list", list);
//                response.sendRedirect("EmployeeServlet");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else if (action.equals("Login")) {
                if (eid.equals("") && epass.equals("") || epass.equals("") || eid.equals("")) {
                    response.sendRedirect("error.html");
                } else {
                    response.sendRedirect("EmployeesServlet");
                }
            } else if (action.equals("Delete")) {
                String cid = request.getParameter("id"); // id lấy từ index.jsp chỗ delete=id....
                dao.delete(cid);
//                request.getRequestDispatcher("index.jsp").forward(request, response);
                response.sendRedirect("EmployeesServlet");
            } else if (action.equals("Create")) {
                String id = request.getParameter("txtID");
                String name = request.getParameter("txtName");
                String pass = request.getParameter("txtPass");
                int salary = Integer.parseInt("txtSalary");
                Employees emp = new Employees();
                emp.setId(id);
                emp.setName(name);
                emp.setPassword(pass);
                emp.setSalary(salary);
                emp.setRole(false);
                int status = dao.addEmployee(emp);
                if (status > 0) {
                    response.sendRedirect("EmployeesServlet");
                } else {
                    request.getRequestDispatcher("create.jsp").include(request, response);
                    out.println("<h2>Sai roi leu leu ^__^</h2>");
                }
            } else {

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

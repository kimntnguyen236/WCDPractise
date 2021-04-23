/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.jdbc.controllers;

import fpt.aptech.jdbc.models.Login;
import fpt.aptech.jdbc.models.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vomin
 */
public class LoginServlet extends HttpServlet {

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
            String eid = request.getParameter("txtID");
            String epass = request.getParameter("txtPass");
            String action = request.getParameter("action");
            LoginDAO dao = new LoginDAO();
            if (action == null) {
                List<Login> list = dao.findAll();
                request.setAttribute("list", list);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else if (action.equals("Login")) {
                if (dao.checkLogin(eid, epass) == true) {
                    response.sendRedirect("LoginServlet");
                } else {
                    response.sendRedirect("error.html");
                }
            } else if (action.equals("Create")) {
                String id = request.getParameter("txtID");
                String pass = request.getParameter("txtPASS");
                String name = request.getParameter("txtNAME");
                int salary = Integer.parseInt(request.getParameter("txtSALARY"));
                Login lg = new Login();
                lg.setId(id);
                lg.setPassword(pass);
                lg.setName(name);
                lg.setSalary(salary);
                lg.setRole(false);
                int status = dao.addNew(lg);
                if (status > 0) {
                    response.sendRedirect("LoginServlet");
                } else {
                    request.getRequestDispatcher("create.jsp").include(request, response);
                    out.println("<h2>Create new fail, again ^__^</h2>");
                }
            } else if (action.equals("SetPass")) {
                String id = request.getParameter("id");
                dao.resetPass(eid);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else if (action.equals("delete")) {
                String cid = request.getParameter("id"); // id lấy từ index.jsp chỗ delete=id....
                dao.delete(cid);
//                request.getRequestDispatcher("index.jsp").forward(request, response);
                response.sendRedirect("LoginServlet");
            } else if (action.equals("details")) {
                String cid = request.getParameter("id");
                Login c = dao.details(cid);
                request.setAttribute("c", c);
                request.getRequestDispatcher("details.jsp").forward(request, response);
            } else if (action.equals("getupdate")) {
                String id = request.getParameter("id");
                Login item = dao.getUpdate(id);
                request.setAttribute("item", item);
                request.getRequestDispatcher("update.jsp").forward(request, response);
            } else if (action.equals("update")) {
                String pass = request.getParameter("txtPass");
                String name = request.getParameter("txtName");
                int salary = Integer.parseInt(request.getParameter("txtSalary"));
                boolean role = Boolean.parseBoolean(request.getParameter("txtRole"));
                String id = request.getParameter("txtID");
                Login contact = new Login();
                
                contact.setPassword(pass);
                contact.setName(name);
                contact.setSalary(salary);
                contact.setRole(role);
                contact.setId(id);
                dao.updateContact(contact);
                response.sendRedirect("LoginServlet");
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

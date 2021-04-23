/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.controllers;

import fpt.aptech.models.*;
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
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            LoginDAO dao = new LoginDAO();
            String action = request.getParameter("action");
            if (action == null) {
              
                request.setAttribute("list", dao.findAll());
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } 
            else if (action.equals("Search")) {
                String keyword = request.getParameter("uname"); // đặt trong phần search
                List<Login> list = dao.findByName(keyword);
                request.setAttribute("list", list);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } 
            else if (action.equals("Create")) {
                Login login = new Login();
                String id = request.getParameter("txtID");
                String password = request.getParameter("txtPassword");
                String name = request.getParameter("txtName");
                boolean role = Boolean.parseBoolean(request.getParameter("txtRole"));
                double salary = Double.parseDouble(request.getParameter("txtSalary"));
                
               login.setId(id);
               login.setPassword(password);
               login.setName(name);
               login.setRole(role);
               login.setSalary(salary);
               dao.addLogin(login);
               response.sendRedirect("LoginServlet");
            } else if (action.equals("Details")) {
                String lid = request.getParameter("id");
                Login l = dao.findOne(lid);
                request.setAttribute("l", l);
                request.getRequestDispatcher("details.jsp").forward(request, response);
            } else if (action.equals("Delete")) {
                String lid = request.getParameter("id");
                dao.deleteLogin(lid);
                response.sendRedirect("LoginServlet");
            } else if (action.equals("Update")) {
                // Update Page 
                String lid = request.getParameter("id");
                request.setAttribute("l", dao.findOne(lid));
                request.getRequestDispatcher("update.jsp").forward(request, response);
            } else if (action.equals("UpdateLogin")) {
                String lid = request.getParameter("txtID");
                String lpass = request.getParameter("txtPass");
                String lname = request.getParameter("txtName");
                boolean lrole = Boolean.parseBoolean(request.getParameter("txtRole"));
                double lsalary = Double.parseDouble(request.getParameter("txtSalary"));
                Login login = new Login();
                login.setId(lid);
                login.setPassword(lpass);
                login.setName(lname);
                login.setRole(lrole);
                login.setSalary(lsalary);
                dao.updateLogin(login);
                response.sendRedirect("LoginServlet");
            } 
            else if (action.equals("Sign in")) {
                String uid = request.getParameter("txtID");
                String upass = request.getParameter("txtPass");
                if (uid.equals("Aptech") && upass.equals("123")  ) {
                    response.sendRedirect("LoginServlet");
                    
                } else {
                   request.getRequestDispatcher("error.html").forward(request, response);
                }
            } 
            else{
                //do nothing
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

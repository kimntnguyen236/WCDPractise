/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fptaptech.controller;

import fptaptech.model.Account;
import fptaptech.model.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author BuuBuu
 */
public class AccountServlet extends HttpServlet {

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
      
            /* TODO output your page here. You may use following sample code. */
            try ( PrintWriter out = response.getWriter()) {
            String eid = request.getParameter("txtID");
            String epass = request.getParameter("txtPass");
            String action = request.getParameter("action");
            AccountDAO dao = new AccountDAO();
            if (action == null) {
                List<Account> list = dao.findAll();
                request.setAttribute("list", list);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
//            else if (action.equals("Sign in")) {
//                if (dao.checkLogin(eid, epass) == true) {
//                    response.sendRedirect("index.jsp");
//
//                } else {
//                    response.sendRedirect("error.html");
//
//                }
//            }
            else if (action.equals("Sign in")) {
                String uid = request.getParameter("txtID");
                String upass = request.getParameter("txtPass");
                if (dao.checkLogin(uid, upass) == true) {
                    HttpSession session = request.getSession();
                    session.setAttribute("uid", uid);
                    response.sendRedirect("AccountServlet");
                } else {
                    request.getRequestDispatcher("error.html").forward(request, response);
                }
            } 
            else if (action.equals("Create")) {
                String id = request.getParameter("txtID");
                String pass = request.getParameter("txtPass");
                String name= request.getParameter("txtName");
                double salary=Double.parseDouble(request.getParameter("txtSalary"));
                boolean role= Boolean.FALSE;

                Account account = new Account();
                account.setId(id);
                account.setPassword(pass);
                account.setName(name);
                account.setSalary(salary);
                account.setRole(role);

                dao.addAccount(account);
                response.sendRedirect("AccountServlet");
            } else if (action.equals("getupdate")) {
               String cid = request.getParameter("id");
                Account c = dao.getUpdate(cid);
                request.setAttribute("c", c);               
                request.getRequestDispatcher("update.jsp").forward(request, response); 
            } else if (action.equals("update")) {
                String id = request.getParameter("txtID");
                String pass = request.getParameter("txtPass");
                String name= request.getParameter("txtName");
                double salary=Double.parseDouble(request.getParameter("txtSalary"));
                boolean role= Boolean.FALSE;
                Account account = new Account();
                account.setId(id);
                account.setPassword(pass);
                account.setName(name);
                account.setSalary(salary);
                account.setRole(role);
                dao.updateAccount(account);
                response.sendRedirect("AccountServlet");
            } else if(action.equals("delete")){
                String id = request.getParameter("id");
               dao.deleteAccount(id);
               response.sendRedirect("AccountServlet");
            }
            else if (action.equals("details")) {
                String cid = request.getParameter("id");
                Account c = dao.findOne(cid);
                request.setAttribute("c", c);
                request.getRequestDispatcher("details.jsp").forward(request, response);
            }
            else if (action.equals("Search")) {
                String keyword = request.getParameter("uname"); // đặt trong phần search
                List<Account> list = dao.findByName(keyword);
                request.setAttribute("list", list);
                request.getRequestDispatcher("index.jsp").forward(request, response);
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

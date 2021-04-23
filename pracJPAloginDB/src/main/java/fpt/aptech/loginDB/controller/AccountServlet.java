/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.loginDB.controller;

import fpt.aptech.loginDB.model.Account;
import fpt.aptech.loginDB.model.AccountDAO;
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            AccountDAO dao = new AccountDAO();
            String action = request.getParameter("action");
            if (action == null) {
//                run();
                List<Account> list = dao.findAll();
                request.setAttribute("list", list);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else if (action.equals("Create")) {
                Account account = new Account();
                String id = request.getParameter("txtID");
                String password= request.getParameter("txtPass");
                String name = request.getParameter("txtName");
                double salary = Integer.parseInt(request.getParameter("txtSalary"));
            
                // gọi hàm dựng 4 tham số : Course (tạo hàm dựng 4 tham số) -> gọi ra
                account.setId(id);
                account.setPassword(password);
                account.setName(name);
                account.setSalary(salary);
                dao.addAccount(account);
                response.sendRedirect("AccountServlet");
            } else if (action.equals("delete")) {
                String cid = request.getParameter("id"); // id lấy từ index.jsp chỗ delete=id....
                dao.deleteAccount(cid);
//                request.getRequestDispatcher("index.jsp").forward(request, response);
                response.sendRedirect("AccountServlet");
            } else if (action.equals("details")) {
                String cid = request.getParameter("id");
                Account c = dao.findOne(cid);
                request.setAttribute("c", c);
                request.getRequestDispatcher("details.jsp").forward(request, response);
            }
            else if(action.equals("update"))
            {   
                //update page
                String cid = request.getParameter("id");
                //String cid = request.getParameter("txtID");
                request.setAttribute("c", dao.findOne(cid)); //do bien ra jsp
                request.getRequestDispatcher("update.jsp").forward(request, response); // phai gui ca request lan response
            }
            else if(action.equals("UpdateAccount"))
            {   
               String cid = request.getParameter("txtID");
               String cpass=request.getParameter("txtPass");
               String cname = request.getParameter("txtName");
               double csalary  = Integer.parseInt(request.getParameter("txtSalary"));
              
               Account c = new Account();
               c.setId(cid);
               c.setPassword(cpass);
               c.setName(cname);
               c.setSalary(csalary);
               dao.updateAccount(c);
               response.sendRedirect("AccountServlet");
            }else if (action.equals("Sign in")) {
                String uid = request.getParameter("txtID");
                String upass = request.getParameter("txtPass");
                if (dao.Login(uid, upass) != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("uid", uid);
                    response.sendRedirect("AccountServlet");
                } else {
                    request.getRequestDispatcher("error.html").forward(request, response);
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

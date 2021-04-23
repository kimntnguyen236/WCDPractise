/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.student1218312.jpa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;

/**
 *
 * @author ThienKim
 */
public class BookServlet extends HttpServlet {

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
            String action = request.getParameter("action");
            BookDAO dao = new BookDAO();
            if(action==null||action.equals("Reset")){
                   request.setAttribute("list", dao.findAll()); //do bien ra jsp
            request.getRequestDispatcher("admin/index.jsp").forward(request, response);
            }
             else if (action.equals("Create")) {
                String cid = request.getParameter("txtID");
                String cname = request.getParameter("txtNAME");
                String cdepar = request.getParameter("txtPublisher");
                int cslary = Integer.parseInt(request.getParameter("txtPrice"));
                Book c = new Book();
                if (dao.findOne(cid) != null) {
//                    out.println("<h5 style=\"color: red\">ID already exist</h5>");
//                    request.getRequestDispatcher("insert.jsp").include(request, response);
request.getRequestDispatcher("error.jsp").include(request, response);
                } else {
                    c.setBookCode(cid);
                    c.setTitle(cname);
                    c.setPrice(cslary);
                    c.setPublisher(cdepar);
                    dao.addBook(c);
                    response.sendRedirect("BookServlet");
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

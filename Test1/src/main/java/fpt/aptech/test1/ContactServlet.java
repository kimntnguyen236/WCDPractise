/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.test1;

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
public class ContactServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            ContactDAO dao = new ContactDAO();
            String action = request.getParameter("action");
            if (action == null) {
                List<Contact> list = dao.findAll();
                request.setAttribute("list", list);
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
            } else if (action.equals("create")) {
                String name = request.getParameter("txtname");
                String mail = request.getParameter("txtmail");

                Contact contact = new Contact();
                contact.setContactname(name);
                contact.setEmail(mail);

                dao.addContact(contact);
                response.sendRedirect("ContactServlet");
            } else if (action.equals("getupdate")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Contact item = dao.getUpdate(id);
                request.setAttribute("item", item);
                request.getRequestDispatcher("update.jsp").forward(request, response);
            } else if (action.equals("update")) {
                String name = request.getParameter("txtname");
                String mail = request.getParameter("txtmail");
                int id = Integer.parseInt(request.getParameter("txtid"));
                Contact contact = new Contact();
                
                contact.setContactname(name);
                contact.setEmail(mail);
                contact.setContactid(id);
                dao.updateContact(contact);
                response.sendRedirect("ContactServlet");
            } else if(action.equals("delete")){
                int id = Integer.parseInt(request.getParameter("id"));
               dao.deleteContact(id);
               response.sendRedirect("ContactServlet");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.Chat;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author mike
 */
@WebServlet(name = "chatServlet", urlPatterns = {"/chatServlet"})
public class chatServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            SessionFactory factory = session.getSessionFactory();
            Session s = factory.openSession(); // creo una sessione e la avvio
            
            
            
            List<Chat> chats = s.createQuery("FROM Chat").list(); //leggo la lista di users dalla tabella e la inserisco in una lista
            for (Chat c : chats) { //scorro la lista di utenti letti
                out.println("<div class=\"contact\">" + c.getId_receiver() + "<img src=\"img/profile.jpg\" class=\"img-contact\"></div>");
            }
        }
    }
 }

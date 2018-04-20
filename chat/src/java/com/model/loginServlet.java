/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean found = false;
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        SessionFactory factory = session.getSessionFactory();
        Session s = factory.openSession(); // creo una sessione e la avvio

        List<User> users = s.createQuery("FROM User").list(); //leggo la lista di users dalla tabella e la inserisco in una lista
        for (User u : users) { //scorro la lista di utenti letti
            System.out.println(u.getUsername());
            System.out.println(u.getPassword());

            /*if(username.compareTo(u.getUsername()) == 0)
                if(password.compareTo(u.getPassword()) == 0)
                    resp.sendRedirect("home.jsp");
             */
            if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                RequestDispatcher rd = req.getRequestDispatcher("chatServlet");
                rd.forward(req, resp);
            }
        }
        if (found == true) {
            resp.sendRedirect("index.jsp");
        }
    }

}

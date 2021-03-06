/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.User;
import java.io.IOException;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author mike
 */
@WebServlet(name = "registerServlet", urlPatterns = {"/registerServlet"})

public class registerServlet extends HttpServlet {

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
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
               
        SessionFactory factory = session.getSessionFactory();
        Session s = factory.openSession(); // creo una sessione e la avvio
        
        List<User> users= s.createQuery("FROM User").list();
        for(User u : users){
            if(username.equals(u.getUsername())){
                out.println("Error, already exist!");
                resp.sendRedirect("index.jsp");
            }
        }
        HttpSession oldSession= req.getSession(false);
        if(oldSession != null)
            oldSession.invalidate();
        HttpSession currentSession = req.getSession();
        currentSession.setAttribute("user", username);
        currentSession.setAttribute("pass", password);
        
        if(username.equals(null) || password.equals(null))
        {
            resp.sendRedirect("index.jsp");
        } 
        else {
          User us= new User();

        us.setUsername(username);
        us.setPassword(password);
        s.beginTransaction();
        s.save(us);
        s.getTransaction().commit();
        s.close();
        factory.close();
            resp.sendRedirect("index.jsp");
        }
        
    }
     
   }

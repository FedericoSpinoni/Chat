/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author mike
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         boolean found= false;
        String username = req.getParameter("user");
        String password = req.getParameter("pass");
        System.out.println(username + " " + password);
        
        SessionFactory factory = session.getSessionFactory();
        Session s = factory.openSession(); // creo una sessione e la avvio
        System.out.println("ok");
           
         List<User> users= s.createQuery("FROM User").list(); //leggo la lista di users dalla tabella e la inserisco in una lista
         for(User u : users){ //scorro la lista di utenti letti
            System.out.println(u.getUsername());
            System.out.println(u.getPassword());
            
            /*if(username.compareTo(u.getUsername()) == 0)
                if(password.compareTo(u.getPassword()) == 0)
                    resp.sendRedirect("home.jsp");*/
            if(username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                found= true;
            }
         }
       if(found == true)
           resp.sendRedirect("home.jsp");
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.User;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        String username = req.getParameter("username");
        String password = req.getParameter("password");
 
        SessionFactory factory = session.getSessionFactory();
        Session s = factory.openSession(); // creo una sessione e la avvio
        
         List<User> users= s.createQuery("FROM User").list(); //leggo la lista di users dalla tabella e la inserisco in una lista
         for(User u : users){ //scorro la lista di utenti letti

            if(username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                
                HttpSession oldSession= req.getSession(false);
                if(oldSession != null)
                    oldSession.invalidate();
                HttpSession currentSession = req.getSession();
                currentSession.setAttribute("id", u.getID());
                currentSession.setAttribute("user", username);
                currentSession.setAttribute("pass", password);
                
                RequestDispatcher rd = req.getRequestDispatcher("chatServlet");
                rd.forward(req,resp);
            }
         }
           resp.sendRedirect("index.jsp");
    }
}

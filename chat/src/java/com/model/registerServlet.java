/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
@WebServlet(name = "registerServlet", urlPatterns = {"/registerServlet"})
public class registerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); 
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
               
        SessionFactory factory = session.getSessionFactory();
        Session s = factory.openSession(); // creo una sessione e la avvio
        List<User> users= s.createQuery("FROM User").list();
        for(User u : users){
            if(username.equals(u.getUsername())){
                out.println("Error, already exist!");
                RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
                rd.forward(req,resp);
            }
        }
        User us= new User();
        us.setUsername(username);
        us.setPassword(password);
        s.beginTransaction();
        s.save(us);
        s.getTransaction().commit();
        s.close();
        factory.close();
        RequestDispatcher rd2 = req.getRequestDispatcher("home.jsp");
        rd2.forward(req,resp);
        
        
    }
        
    
   }

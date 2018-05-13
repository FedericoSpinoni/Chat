/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.Chat;
import com.entity.User;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
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
@WebServlet(name = "addFriends", urlPatterns = {"/addFriends"})
public class addFriends extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String username = req.getParameter("searching");
        
        SessionFactory factory = session.getSessionFactory();
        Session s = factory.openSession(); // creo una sessione e la avvio
        
        HttpSession currentSession = req.getSession();
        
        List<User> users= s.createQuery("FROM User").list(); //leggo la lista di users dalla tabella e la inserisco in una lista
        for ( User u : users)
        {
            if(u.getUsername().equals(username))
            {
                Chat c= new Chat();
                c.setId_message(1);
                c.setId_receiver(u.getID());
                c.setId_sender((int) currentSession.getAttribute("id"));
                s.beginTransaction();
                s.save(c);
                s.getTransaction().commit();               
            }
        }
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Gson g= new Gson();
        List<Chat> chats= s.createQuery("From Chat").list();
        
        String temp= g.toJson(chats.get(chats.size()-1));
        
        resp.getWriter().write(temp);      
        s.close();
        factory.close();
    }
    
    
}

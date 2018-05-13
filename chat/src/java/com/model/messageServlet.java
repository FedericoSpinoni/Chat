/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.Chat;
import com.entity.Message;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "messageServlet", urlPatterns = {"/messageServlet"})
@MultipartConfig
public class messageServlet extends HttpServlet {

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
        
        String msg = req.getParameter("testMessage");
        int receiver = 6;
        
        SessionFactory factory = session.getSessionFactory();
        Session s = factory.openSession(); // creo una sessione e la avvio

        HttpSession currentSession = req.getSession();
        int myId =  (int) currentSession.getAttribute("id");
          
        Message m = new Message();        
        m.setMessage(msg);
        s.beginTransaction();
        s.save(m);
        s.getTransaction().commit();
        
        List<Message> messages2 = s.createQuery("FROM Message").list();
        Chat c = new Chat();
        c.setId_receiver(receiver);
        c.setId_sender(myId);
        Message tempMess= messages2.get(messages2.size()-1);
        c.setId_message(tempMess.getID());
        s.beginTransaction();
        s.save(c);
        s.getTransaction().commit();
          
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Gson g= new Gson();
        String temp = g.toJson(messages2);
        resp.getWriter().write(temp);      
        s.close();
        factory.close();

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.Chat;
import com.entity.Message;
import java.io.IOException;
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
@WebServlet(name = "messageServlet", urlPatterns = {"/messageServlet"})
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
        super.doPost(req, resp);
        String msg = req.getParameter("text-message");
        String receiver = req.getParameter("id_receiver");

        SessionFactory factory = session.getSessionFactory();
        Session s = factory.openSession(); // creo una sessione e la avvio

        HttpSession currentSession = req.getSession();
        String myId = (String) currentSession.getAttribute("id");
        
        List<Message> messages = s.createQuery("FROM Message").list();
       
        Message m = messages.get(messages.size());
        
        m.setMessage(msg);
        s.beginTransaction();
        s.save(m);
        s.getTransaction().commit();
        
        Chat c = new Chat();
        //c.setId_receiver(receiver);
        //c.setId_sender(myId);
        //c.setId_message(0); -> far scorrere i messaggi per ottenere l'ID dell'ultimo
        //s.beginTransaction();
        //s.save(c);
        //s.getTransaction().commit();
        
        
        s.close();
        factory.close();

    }

}

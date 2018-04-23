/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.Chat;
import com.entity.Message;
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
@WebServlet(name = "showMessageServlet", urlPatterns = {"/showMessageServlet"})
public class showMessageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idChat = req.getParameter("id_chat");
        
        SessionFactory factory = session.getSessionFactory();
        Session s = factory.openSession(); // creo una sessione e la avvio
        
        HttpSession currentSession = req.getSession();
        String myId = (String) currentSession.getAttribute("id");
        
        List<Chat> chats = s.createQuery("FROM Chat WHERE  id_sender=" + myId + "id_receiver=" + idChat).list(); //leggo la lista di users dalla tabella e la inserisco in una lista
        List<Message> msg = s.createQuery("FROM Message").list();

            for(Chat c : chats){
                        
                for (Message m : msg)
                {
                    if(m.getID() == c.getId_receiver() ){
                 // stampare messaggio trovato a schermo
                    }
                }    
            }      
        }    
 }

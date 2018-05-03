/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.Chat;
import com.entity.Message;
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
@WebServlet(name = "showMessageServlet", urlPatterns = {"/showMessageServlet"})
public class showMessageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idChat = req.getParameter("value_contact");
        
        List<Message> m2 = null;
        
        SessionFactory factory = session.getSessionFactory();
        Session s = factory.openSession(); // creo una sessione e la avvio
        
        HttpSession currentSession = req.getSession();
        User myId = (User) currentSession.getAttribute("currentLogged");     
        
        String sss = String.valueOf(myId.getID());
        System.out.println(sss + " " + idChat );
        List<Chat> chats = s.createQuery("FROM Chat WHERE  (id_sender=" + sss + " AND id_receiver=" + idChat + ") OR (id_sender=" + idChat + " AND id_receiver=" + sss +")").list(); //leggo la lista di users dalla tabella e la inserisco in una lista
        List<Message> m = s.createQuery("FROM Message").list();
       
        for (Chat c : chats)
        {
            for (Message tempMess : m)
            {
                
                if(c.getId_message() == tempMess.getID())
                {                   
                        Message e = new Message();
                        e.setMessage(tempMess.getMessage());
                        e.setId_receiver(c.getId_receiver()); //ho settato nel messaggio l'ip di chi riceve in modo che quando lo passa alla pagina jsp sappia dove posizionarlo
                        m2.add(e);
                }
            }
        }
        
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Gson g= new Gson();
        String temp = g.toJson(m2);
        resp.getWriter().write(temp);
        factory.close();
        }  
  
 }

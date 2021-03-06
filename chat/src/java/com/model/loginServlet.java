package com.model;

import com.entity.Chat;
import com.entity.User;
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
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         boolean found= false;
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        User us = new User();
        us.setUsername(username);
        us.setPassword(password);
        
        SessionFactory factory = session.getSessionFactory();
        Session s = factory.openSession(); 
        
        
        HttpSession oldSession= req.getSession(false);
        if(oldSession != null)
        oldSession.invalidate();
        
         List<User> users= s.createQuery("FROM User").list(); //leggo la lista di users dalla tabella e la inserisco in una lista
         for(User u : users){ //scorro la lista di utenti letti

            if(username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                
                us.setID(u.getID());
                
                HttpSession currentSession = req.getSession();
                currentSession.setAttribute("currentLogged", us);
                currentSession.setAttribute("id", u.getID());
               
                List<Chat> chats = s.createQuery("FROM Chat WHERE id_sender="+u.getID()).list();
                currentSession.setAttribute("chatList", chats);
                currentSession.setAttribute("listUsername", users);
                
                found = true;
                resp.sendRedirect("home.jsp");
            }
         }
         if (found == false)
         {
             resp.sendRedirect("index.jsp");
         }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.Chat;
import com.entity.Message;
import com.entity.User;
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
        
        
        SessionFactory factory = session.getSessionFactory();
        Session s = factory.openSession(); // creo una sessione e la avvio
        
        HttpSession currentSession = req.getSession();
        User myId = (User) currentSession.getAttribute("currentLogged");     
        
        String sss = String.valueOf(myId.getID());
        System.out.println(sss + " " + idChat );
       List<Chat> chats = s.createQuery("FROM Chat WHERE  (id_sender=" + sss + " AND id_receiver=" + idChat + ") OR (id_sender=" + idChat + " AND id_receiver=" + sss +")").list(); //leggo la lista di users dalla tabella e la inserisco in una lista
       
       PrintWriter out = resp.getWriter();
         for (Chat c : chats){
            if(c.getId_sender() == myId.getID()){
                out.println("<div class=\"message\">");
                out.println("<div class=\" sender\">" + c.getTextMessage() + "</div>");
                out.println("</div>");                        
                }
                else {        
                    out.println("<div class=\"message\">");
                    out.println("<div class=\" receiver\">" + c.getTextMessage()+"</div>");                    
                    out.println("</div>");               	
                     }
            }
        req.setAttribute("message", out); // This will be available as ${message}
        req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
       

            /*
        <div class="chat"> 
                             <% 
                                 String s = (String)session.getAttribute("state");
                                 if ( s.equals("true"))
                                 {
                                User u2 = (User)session.getAttribute("currentLogged");
                                List<Chat> messages = (List<Chat>)session.getAttribute("listMessages");
                                for (Chat c : messages)
                                {
                                    if(c.getId_sender() == u2.getID()){
                                        %>
                                        <div class="message">
                                            <div class=" sender"><%=c.getTextMessage() %></div>
                                        </div>
                                        <%
                                     }
                                    else {
                                    %>
                                    <div class="message">
                                        <div class=" receiver"><%=c.getTextMessage() %></div>
                                    </div>	
                                    <% }
                                }
                                }
                            %>		
                        </div>

            */    
            //currentSession.setAttribute("state", "true");
            //currentSession.setAttribute("listMessages", chats);
            factory.close();
        }  
  
 }

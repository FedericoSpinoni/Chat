/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.Chat;
import com.entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
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
@WebServlet(name = "homeServlet", urlPatterns = {"/homeServlet"})
public class homeServlet extends HttpServlet {

    public homeServlet() {
    }
    
    
 
    public void getContact(){
        /*
            Brainstorming su come sistemare servlet e jsp
        
            Deve essere dato ad ogni div componente i contatti laterali un proprio Id (che verrà dato in automatico da un contatore), dopodichè 
            si dovrà leggere l'id della chat selezionata e richiamare il getMessages() (da un form magari, rendendo tutte le chat bottoni che passano
            il proprio ID).
        
            Da vedere: 
                - come stampare in jsp i dati presi dal DB 
                - come organizzare le chat 
                - come funzionano le Session factory? come faccio a prendere le mie chat se non so il mio Id nel DB?
        
            
        */
     SessionFactory factory = session.getSessionFactory();
     Session s = factory.openSession(); // creo una sessione e la avvio
      List<Chat> chats= s.createQuery("FROM Chat").list(); //leggo la lista di users dalla tabella e la inserisco in una lista
         for(Chat c : chats){ //scorro la lista di utenti letti
            out.println("<div class=\"contact\">"+c.getId_receiver()+"</div>");
         }
    }
    
    public void getMessages()
    {}

}

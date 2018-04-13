/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.Chat;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author mike
 */
public class chatPage {
    
    public void createChat()
    {
        //N.B. --> E' ancora da inserire il meotodo per ricavare chi fa il login per mostrare determinate Chat
        SessionFactory factory= session.getSessionFactory();
        Session s = factory.openSession(); // creo una sessione e la avvio
        
         try {  
            List<Chat> chats= s.createQuery("FROM chat").list(); //leggo la lista di users dalla tabella e la inserisco in una lista
            for(Chat c : chats){ //scorro la lista di utenti letti

               System.out.print("User: " + c.getID());    // questo stamperà tutte le Chat nella pagina jsp
            }
        }
        catch(HibernateException e)
        {
            System.out.println("Error");
        }
         
        finally 
        {
            factory.close(); 
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;


import com.entity.user;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author mike
 */
public class login {
   
    
    public boolean verifyLogin(String usr, String psw)
    {
        SessionFactory factory= session.getSessionFactory();
        Session s = factory.openSession(); // creo una sessione e la avvio
        
         try {  
         List<user> users= s.createQuery("FROM user").list(); //leggo la lista di users dalla tabella e la inserisco in una lista
         for(user u : users){ //scorro la lista di utenti letti
             
            System.out.print("User: " + u.getUsername());
            System.out.print("Pass" + u.getPassword());  
            if(usr.equals(u.getUsername()) && psw.equals(u.getPassword())) //controllo che username e password corrispondano
                return true; //ritorna esito positivo al tentativo di connessione
         }

      } catch (HibernateException e) 
      {
             System.out.println("Error");
      } 
         finally 
         {
         factory.close(); 
      }
        return false;
    }
}

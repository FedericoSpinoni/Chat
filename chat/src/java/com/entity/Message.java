/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mike
 */
@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_receiver;
    private int ID;
    private String message;

    /**
     * Return an id
     *
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Set an id
     *
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Return a message
     *
     * @return the Message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set a message
     *
     * @param message the Message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the id_receiver
     */
    public int getId_receiver() {
        return id_receiver;
    }

    /**
     * @param id_receiver the id_receiver to set
     */
    public void setId_receiver(int id_receiver) {
        this.id_receiver = id_receiver;
    }

}

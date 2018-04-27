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
@Table(name = "chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    private int id_sender;
    private int id_receiver;
    private int id_message;
    private String textMessage;

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
     * Return an id_sender
     *
     * @return the id_sender
     */
    public int getId_sender() {
        return id_sender;
    }

    /**
     * Set an id_sender
     *
     * @param id_sender the id_sender to set
     */
    public void setId_sender(int id_sender) {
        this.id_sender = id_sender;
    }

    /**
     * return an id_receiver
     *
     * @return the id_receiver
     */
    public int getId_receiver() {
        return id_receiver;
    }

    /**
     * Set an id_receiver
     *
     * @param id_receiver the id_receiver to set
     */
    public void setId_receiver(int id_receiver) {
        this.id_receiver = id_receiver;
    }

    /**
     * Return an id_message
     *
     * @return the id_message
     */
    public int getId_message() {
        return id_message;
    }

    /**
     * Set an id_message
     *
     * @param id_message the id_message to set
     */
    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    /**
     * @return the message
     */
    public String getTextMessage() {
        return textMessage;
    }

    /**
     * @param message the message to set
     */
    public void setTextMessage(String message) {
        this.textMessage = message;
    }

}

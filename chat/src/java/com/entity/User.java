/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
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
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    private String username;
    private String password;

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
     * Return a username
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set a username
     *
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Return a password
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set a password
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}

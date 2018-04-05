/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mike
 */
public class userTest {
    
    public userTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getID method, of class user.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        user instance = new user();
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setID method, of class user.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        int ID = 0;
        user instance = new user();
        instance.setID(ID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class user.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        user instance = new user();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class user.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        user instance = new user();
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class user.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        user instance = new user();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class user.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        user instance = new user();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class user.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        user instance = new user();
        String expResult = "";
        String result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class user.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "";
        user instance = new user();
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

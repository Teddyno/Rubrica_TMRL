/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.rubrica_tmrl;

import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author diducc
 */
public class RubricaTest {

    /**
     * Test of start method, of class Rubrica.
     */
    @Test
    public void testStart() throws Exception {
        System.out.println("start");
        Stage stage = null;
        Rubrica instance = new Rubrica();
        instance.start(stage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Rubrica.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Rubrica.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFileDefault method, of class Rubrica.
     */
    @Test
    public void testGetFileDefault() {
        System.out.println("getFileDefault");
        String expResult = "";
        String result = Rubrica.getFileDefault();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFileDefault method, of class Rubrica.
     */
    @Test
    public void testSetFileDefault() {
        System.out.println("setFileDefault");
        String filePathDefault = "";
        Rubrica.setFileDefault(filePathDefault);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

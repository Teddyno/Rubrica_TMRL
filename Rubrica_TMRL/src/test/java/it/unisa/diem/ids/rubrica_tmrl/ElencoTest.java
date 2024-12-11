/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.rubrica_tmrl;

import javafx.collections.ObservableList;
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
public class ElencoTest {
 
    /**
     * Test of getContatti method, of class Elenco.
     */
    @Test
    public void testGetContatti() {
        System.out.println("getContatti");
        Elenco instance = null;
        ObservableList<Contatto> expResult = null;
        ObservableList<Contatto> result = instance.getContatti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addContatto method, of class Elenco.
     */
    @Test
    public void testAddContatto() {
        System.out.println("addContatto");
        Contatto contatto = null;
        Elenco instance = null;
        instance.addContatto(contatto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeContatto method, of class Elenco.
     */
    @Test
    public void testRemoveContatto() {
        System.out.println("removeContatto");
        Contatto contatto = null;
        Elenco instance = null;
        instance.removeContatto(contatto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifyContatto method, of class Elenco.
     */
    @Test
    public void testModifyContatto() {
        System.out.println("modifyContatto");
        int id = 0;
        Contatto contatto = null;
        Elenco instance = null;
        instance.modifyContatto(id, contatto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sort method, of class Elenco.
     */
    @Test
    public void testSort() {
        System.out.println("sort");
        Elenco instance = null;
        instance.sort();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

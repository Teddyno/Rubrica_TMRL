/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.rubrica_tmrl;

import javafx.collections.FXCollections;
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

        Elenco instance = new Elenco("");
        ObservableList<Contatto> expResult = FXCollections.observableArrayList();

        ObservableList<Contatto> result = instance.getContatti();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of addContatto method, of class Elenco.
     */
    @Test
    public void testAddContatto() {
        System.out.println("addContatto");
        Contatto expContatto = new Contatto("Piero","voli");
        Elenco instance = new Elenco("");
        instance.addContatto(expContatto);
        
        assertTrue(instance.getContatti().contains(expContatto));
    }

    /**
     * Test of removeContatto method, of class Elenco.
     */
    @Test
    public void testRemoveContatto() {
        System.out.println("removeContatto");
        Contatto expContatto = new Contatto("Piero","Pierino");
        Elenco instance = new Elenco("");
        
        instance.addContatto(expContatto);
        
        instance.removeContatto(expContatto);
        
        assertFalse(instance.getContatti().contains(expContatto));
    }

    /**
     * Test of modifyContatto method, of class Elenco.
     */
    @Test
    public void testModifyContatto() {
        System.out.println("modifyContatto");
        
        Contatto contattoOld = new Contatto("Giovanni","Todisco");
        Contatto contattoNew = new Contatto("Giovanni","Ruocco");
        Elenco instance = new Elenco("");
        
        instance.getContatti().add(contattoOld);
        int index = instance.getContatti().indexOf(contattoOld);
        
        instance.modifyContatto(index, contattoNew);
        
        Contatto result = instance.getContatti().get(0);
        assertEquals(contattoNew, result);
    }

    /**
     * Test of sort method, of class Elenco.
     */
    @Test
    public void testSort() {
        System.out.println("sort");
        
        Contatto contatto1 = new Contatto("Giovanni","Todisco");
        Contatto contatto2 = new Contatto("Giovanni","Ruocco");
        Contatto contatto3 = new Contatto("Giovanni","Alemanno");
        Elenco instance = new Elenco("");
        instance.getContatti().add(contatto1);
        instance.getContatti().add(contatto2);
        instance.getContatti().add(contatto3);
        
        instance.sort();
        
        Contatto result1 = instance.getContatti().get(0);
        Contatto result2 = instance.getContatti().get(1);
        Contatto result3 = instance.getContatti().get(2);
        
        assertEquals(contatto3, result1);
        assertEquals(contatto2, result2);
        assertEquals(contatto1, result3);
    }
    
}

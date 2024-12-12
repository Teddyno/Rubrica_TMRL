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
public class PreferitiTest {

    /**
     * Test of setPreferiti method, of class Preferiti.
     */
    @Test
    public void testSetPreferiti() {
        System.out.println("setPreferiti");
        Elenco elenco = new Elenco("");
        Preferiti instance = new Preferiti(elenco);
        
        Contatto contatto = new Contatto("Giovanni","Todisco");
        contatto.setPreferiti(true);
        elenco.getContatti().add(contatto);
       
        instance.updatePreferiti();
        
        Contatto result = instance.getContattiPreferiti().get(0);
        
        assertEquals(contatto, result);

    }

    /**
     * Test of removePreferiti method, of class Preferiti.
     */
    @Test
    public void testRemovePreferiti() {
        System.out.println("removePreferiti");
        Contatto contatto = new Contatto("Giovanni","Todisco");
        Preferiti instance = new Preferiti(new Elenco(""));
        instance.getContattiPreferiti().add(contatto);
        
        instance.removePreferiti(contatto);
        
        assertFalse(instance.getContattiPreferiti().contains(contatto));
 
    }

    /**
     * Test of modifyPreferiti method, of class Preferiti.
     */
    @Test
    public void testModifyPreferiti() {
        System.out.println("modifyPreferiti");
        
        Contatto contattoOld = new Contatto("Giovanni","Todisco");
        Contatto contattoNew = new Contatto("Giovanni","Ruocco");
        Preferiti instance = new Preferiti(new Elenco(""));
        instance.getContattiPreferiti().add(contattoOld);
        
        instance.modifyPreferiti(contattoOld, contattoNew);
        
        Contatto result = instance.getContattiPreferiti().get(0);
        assertEquals(contattoNew, result);
    }

    /**
     * Test of getContattiPreferiti method, of class Preferiti.
     */
    @Test
    public void testGetContattiPreferiti() {
        System.out.println("getContattiPreferiti");
        
        Preferiti instance = new Preferiti(new Elenco(""));
        ObservableList<Contatto> expResult = FXCollections.observableArrayList();

        ObservableList<Contatto> result = instance.getContattiPreferiti();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of sort method, of class Preferiti.
     */
    @Test
    public void testSort() {
        System.out.println("sort");
        
        Contatto contatto1 = new Contatto("Giovanni","Todisco");
        Contatto contatto2 = new Contatto("Giovanni","Ruocco");
        Contatto contatto3 = new Contatto("Giovanni","Alemanno");
        Preferiti instance = new Preferiti(new Elenco(""));
        instance.getContattiPreferiti().add(contatto1);
        instance.getContattiPreferiti().add(contatto2);
        instance.getContattiPreferiti().add(contatto3);
        
        instance.sort();
        
        Contatto result1 = instance.getContattiPreferiti().get(0);
        Contatto result2 = instance.getContattiPreferiti().get(1);
        Contatto result3 = instance.getContattiPreferiti().get(2);
        
        assertEquals(contatto3, result1);
        assertEquals(contatto2, result2);
        assertEquals(contatto1, result3);
    }
    
    
}

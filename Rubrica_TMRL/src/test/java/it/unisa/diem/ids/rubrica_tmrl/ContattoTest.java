/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.rubrica_tmrl;

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
public class ContattoTest {
    
    /**
     * Test of getNome method, of class Contatto.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Contatto instance = new Contatto("Giovanni","Todisco");
        String expResult = "Giovanni";
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCognome method, of class Contatto.
     */
    @Test
    public void testGetCognome() {
        System.out.println("getCognome");
        Contatto instance = new Contatto();
        String expResult = null;
        String result = instance.getCognome();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNome method, of class Contatto.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "Piero";
        Contatto instance = new Contatto();
        instance.setNome(nome);
        String result = instance.getNome();
        assertEquals(nome, result);
    }

    /**
     * Test of setCognome method, of class Contatto.
     */
    @Test
    public void testSetCognome() {
        System.out.println("setCognome");
        String cognome = "Paolini";
        Contatto instance = new Contatto();
        instance.setCognome(cognome);
        String result = instance.getCognome();
        assertEquals(cognome, result);

    }

    /**
     * Test of addEmail method, of class Contatto.
     */
    @Test
    public void testAddEmail() {
        System.out.println("addEmail");
        String email = "piero.nivo@gmail.com";
        Contatto instance = new Contatto();
        instance.addEmail(email);
        int index = 0;
        String emailResult = instance.getEmail(index);
        assertEquals(email, emailResult);
    }

    /**
     * Test of addNumTel method, of class Contatto.
     */
    @Test
    public void testAddNumTel() {
        System.out.println("addNumTel");
        String numTel = "3336754690";
        Contatto instance = new Contatto();
        instance.addNumTel(numTel);
        int index = 0;
        String numTelresult = instance.getNumTel(index);
        assertEquals(numTel, numTelresult);
    }

    /**
     * Test of getSizeEmail method, of class Contatto.
     */
    @Test
    public void testGetSizeEmail() {
        System.out.println("getSizeEmail");
        Contatto instance = new Contatto();
        int expResult = 0;
        int result = instance.getSizeEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSizeNumTel method, of class Contatto.
     */
    @Test
    public void testGetSizeNumTel() {
        System.out.println("getSizeNumTel");
        Contatto instance = new Contatto();
        instance.addNumTel("3336754690");
        int expResult = 1;
        int result = instance.getSizeNumTel();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class Contatto.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Contatto instance = new Contatto();
        String email = "piero.nivo@gmail.com";
        instance.addEmail(email);
        int index = 0;
        String result = instance.getEmail(index);
        assertEquals(email, result);
    }

    /**
     * Test of getNumTel method, of class Contatto.
     */
    @Test
    public void testGetNumTel() {
        System.out.println("getNumTel");
        Contatto instance = new Contatto();
        String expResult = "3336754690";
        instance.addNumTel(expResult);
        int index = 0;
        String result = instance.getNumTel(index);
        assertEquals(expResult, result);

    }
    
}

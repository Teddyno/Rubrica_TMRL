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
public class GestioneIOTest {

    /**
     * Test of caricaVCF method, of class GestioneIO.
     */
    @Test
    public void testCaricaVCF() {
        System.out.println("caricaVCF");
        String filePath = "";
        ObservableList<Contatto> contatti = null;
        GestioneIO.caricaVCF(filePath, contatti);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvaVCF method, of class GestioneIO.
     */
    @Test
    public void testSalvaVCF() {
        System.out.println("salvaVCF");
        String filePath = "";
        ObservableList<Contatto> contatti = null;
        GestioneIO.salvaVCF(filePath, contatti);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

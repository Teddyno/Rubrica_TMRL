/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.rubrica_tmrl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author alext
 */
public class GestioneIO {
    
    private String nomeCompleto;
    private String nome;
    private String cognome;
    private String numTel;
    private String email;
    
    public static ObservableList<Contatto> initContatti(String fileDefault) {
       
        ObservableList<Contatto> contatti = FXCollections.observableArrayList();/*
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Contatto contact = null;
            // ciao
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("BEGIN:VCARD")) {
                    
                } else if (line.startsWith("FN:") && contact != null) {
                    nomeCompleto= line.substring(3).trim();
                    String[] campi = nomeCompleto.split(" ", 2);
                    nome = campi[0];
                    cognome = campi[1];
                } else if (line.startsWith("TEL:") && contact != null) {
                    numTel = line.substring(19).trim();
                } else if (line.startsWith("EMAIL:") && contact != null) {
                    email = line.substring(14).trim();
                } else if (line.startsWith("END:VCARD") && contact != null) {
                    Contatto contatto = new Contatto(nome,cognome,numTel,email);
                    contacts.add(contact);
                }
            }
        } catch (IOException e) {
            System.err.println("Errore durante il caricamento dei contatti" );
        }*/
        return contatti;
    }
    
}

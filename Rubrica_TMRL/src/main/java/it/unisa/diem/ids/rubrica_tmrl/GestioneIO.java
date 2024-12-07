/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.rubrica_tmrl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author alext
 */
public class GestioneIO {
   
    public static void initContatti(String fileDefault,ObservableList<Contatto> contatti) {
       
        String nomeCompleto = null;
        String nome = null;
        String cognome = null;
        String numTel = null;
        String email = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileDefault))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("BEGIN:VCARD")) {
                } else if (line.startsWith("FN;")) {
                    nomeCompleto= line.substring(17).trim();
                    String[] campi = nomeCompleto.split(" ", 2);
                    nome = campi[0];
                    cognome = campi[1];
                } else if (line.startsWith("EMAIL;")) {
                    email = line.substring(39).trim();
                } else if (line.startsWith("TEL;")) {
                    numTel = line.substring(14).trim();
                } else if (line.startsWith("END:VCARD")) {
                    Contatto contatto = new Contatto(nome,cognome,numTel,email);
                    contatti.add(contatto);
                }
            }
        } catch (IOException e) {
            System.err.println("Errore durante il caricamento dei contatti" );
        }
    }
    
    /*
    public static void salvaCSV(String nomefile) throws IOException{

        //il blocco try con le risorse, se c'è un eccezione fa di base il close del pw
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(nomefile)))){

            pw.println("NOME;COGNOME;CODICE FISCALE;MATRICOLA;VOTO MEDIO");

                pw.append("Bestione");
                pw.append(";");
                pw.append("Bestione");
                pw.append(";");
                pw.append("Bestione");
                pw.append(";");
                pw.append("Bestione");
                pw.append(";");
                pw.append("Bestione"); //l'append si aspetta dei caratteri, quindi dobbiamo concatenarlo con una stringa vuota
                pw.append("\n");

        
        } catch(IOException e){
        }
    }
    */

}

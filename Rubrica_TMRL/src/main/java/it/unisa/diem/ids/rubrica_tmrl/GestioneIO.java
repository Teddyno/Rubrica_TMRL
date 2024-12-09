/**
 * @file GestioneIO.java
 * @brief Classe per la gestione Import/Output
 * 
 * @author TMRL
 * @version 1.0
 */
package it.unisa.diem.ids.rubrica_tmrl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @brief Classe Gestione Import/Output
 */
public class GestioneIO {
   
    /**
     * @brief Importa contatti
     * 
     * Inizializza l'elenco dei contatti andando a leggere i dati 
     * di essi dal file default .vcf 
     * 
     * @param[in] fileDefault indirizzo del file di default della rubrica
     * @param[in] contatti collezione contenente i contatti dell'elenco
     */
    public static void importaVCF(String fileDefault,ObservableList<Contatto> contatti) {
       
        String nomeCompleto= null;
        String nome= null;
        String cognome= null;
        String numTel1= null;
        String numTel2= null;
        String numTel3= null;
        String email1= null;
        String email2= null;
        String email3= null;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileDefault))) {
            String line;

            while ((line = reader.readLine()) != null) {
                Contatto contatto = new Contatto(); 

                if (line.startsWith("BEGIN:VCARD")) {
                } else if (line.startsWith("FN;")) {
                    nomeCompleto= line.substring(17).trim();                    // Estrae una sottostringa a partire dall'indice 17 (compreso) fino alla fine della stringa.
                                                                                // .trim Rimuove gli spazi bianchi
                    String[] campi = nomeCompleto.split(" ", 2);
                    nome = campi[0];
                    cognome = campi[1];
                    
                } else if (line.startsWith("EMAIL;")) {
                    if(email1 == null){
                        email1 = line.substring(39).trim();
                    } else if (email2 == null){
                        email2 = line.substring(39).trim();
                    } else if (email3 == null){
                        email3 = line.substring(39).trim();
                    }  
                } else if (line.startsWith("TEL;")) {
                    if(numTel1 == null){
                        numTel1 = line.substring(14).trim();
                    } else if (numTel2 == null){
                        numTel2 = line.substring(14).trim();
                    } else if (numTel3 == null){
                        numTel3 = line.substring(14).trim();
                    }  
                } else if (line.startsWith("END:VCARD")) {
                    
                    contatto.setNome(nome);
                    contatto.setCognome(cognome);
                    if(email1 != null){
                        contatto.addEmail(email1);
                        email1= null;
                    }
                    if (email2 != null){
                        contatto.addEmail(email2);
                        email2 = null;
                    }
                    if (email3 != null){
                        contatto.addEmail(email3);
                        email3 = null;
                    }
                    if(numTel1 != null){
                        contatto.addNumTel(numTel1);
                        numTel1 = null;
                    }
                    if (numTel2 != null){
                        contatto.addNumTel(numTel2);
                        numTel2 = null;
                    }
                    if (numTel3 != null){
                        contatto.addNumTel(numTel3);
                        numTel3 = null;
                    }
                    contatti.add(contatto);
                }
                
                
            }
        } catch (IOException e) {
            System.err.println("Errore durante il caricamento dei contatti" );
        }
    }
    
    /**
     * @brief Salva elenco nel file
     * 
     * Scrive l'elenco dei contatti all'interno del file di default,
     * seguendo il formato .vcf
     * 
     * @param[in] fileDefault indirizzo del file di default della rubrica
     * @param[in] contatti collezione contenente i contatti dell'elenco
     */
    public static void salvaVCF(String fileDefault,ObservableList<Contatto> contatti) {
       
        //il blocco try con le risorse, se c'è un eccezione fa di base il close del pw
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileDefault)))){

            Iterator<Contatto> i = contatti.iterator();
            
            while(i.hasNext()){
                
                Contatto c = i.next();
                
                pw.println("BEGIN:VCARD");
                pw.println("VERSION:3.0");
                pw.println("FN;CHARSET=UTF-8:"+c.getNome()+" "+c.getCognome());
                pw.println("N;CHARSET=UTF-8:"+c.getCognome()+";"+c.getNome());
                for(int j=0;j<c.getSizeEmail();j++){
                    pw.println("EMAIL;CHARSET=UTF-8;type=HOME,INTERNET:"+c.getEmail(j));
                }
                for(int j=0;j<c.getSizeNumTel();j++){
                    pw.println("TEL;TYPE=CELL:"+c.getNumTel(j));; 
                }
                pw.println("END:VCARD");

            }
        
        } catch(IOException e){
        }
    }

}

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
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * @brief Classe Gestione Import/Output
 */
public class GestioneIO {
    
    /**
     * @brief collegamento ad Elenco
     */
    private Elenco elenco;  
    
    /**
     * @brief Costruttore GestioneIO
     * 
     * @param[in] elenco riferimento alla classe elenco
     */
    public GestioneIO(Elenco elenco){
        this.elenco = elenco;
    }
   
    /**
     * @brief Inizializza l'elenco dei contatti andando a leggere i dati 
     * dei contatti dal file default .vcf 
     * 
     * @param[in] filePath Indirizzo del file di default della rubrica
     * @param[in] contatti ObservableList contenente i contatti dell'elenco
     */
    public static void caricaVCF(String filePath,ObservableList<Contatto> contatti) {
       
        String nomeCompleto;
        String nome= null;
        String cognome= null;
        String numTel1= null;
        String numTel2= null;
        String numTel3= null;
        String email1= null;
        String email2= null;
        String email3= null;
        String preferiti = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
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
                } else if (line.startsWith("NOTE;")) {
                    preferiti = line.substring(29).trim();
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
                    if("true".equals(preferiti)){
                        contatto.setPreferiti(true);
                    }
                    contatti.add(contatto);
                }
            }
        } catch (IOException e) {
        }
    }
    
    /**
     * @brief Scrive l'elenco dei contatti all'interno del file di default,
     * seguendo il formato .vcf
     * 
     * @param[in] filePath Indirizzo del file di default della rubrica
     * @param[in] contatti ObservableList contenente i contatti dell'elenco
     */
    public static void salvaVCF(String filePath,ObservableList<Contatto> contatti) {
        
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filePath)))){

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
                if(c.isPreferiti()){
                    pw.println("NOTE;CHARSET=UTF-8:Preferiti=true");
                } else {
                    pw.println("NOTE;CHARSET=UTF-8:Preferiti=false");
                }
                pw.println("END:VCARD");

            }
        
        } catch(IOException e){
        }
    }
    
    /**
     * @brief Gestisce l'import dei dati da un file .vcf
     * 
     * @param[in] filePathDefault Indirizzo del file di default della rubrica
     * @param[in] elenco Elenco dei contatti
     */
    public static void handleImport(String filePathDefault, Elenco elenco){ 
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new ExtensionFilter("VCF", "*.vcf"));
        fileChooser.setTitle("Scegli file Vcard");
        File file = fileChooser.showOpenDialog(new Stage());
        
        if(file != null){
            caricaVCF(file.getPath(), elenco.getContatti());
            elenco.sort();
            salvaVCF(Rubrica.filePathDefault,elenco.getContatti());
        }
        
    }

    /**
     * @brief Gestisce l'export dei dati in un file .vcf
     * 
     * @param[in] filePathDefault Indirizzo del file di default della rubrica
     * @param[in] elenco Elenco dei contatti
     */
    public static void handleExport(String filePathDefault, Elenco elenco){
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new ExtensionFilter("VCF", "*.vcf"));
        fileChooser.setTitle("Scegli file Vcard");
        File file = fileChooser.showSaveDialog(new Stage());
        if(file == null) return;
        
        salvaVCF(file.getPath(),elenco.getContatti());
  
    }

}

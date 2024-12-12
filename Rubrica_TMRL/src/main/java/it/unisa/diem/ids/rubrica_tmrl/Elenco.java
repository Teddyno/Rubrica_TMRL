/**
 * @file Elenco.java
 * @brief Classe gestione Elenco
 * 
 * @author TMRL
 * @version 1.0
 */
package it.unisa.diem.ids.rubrica_tmrl;

import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @brief Classe Elenco dei contatti
 */
public class Elenco {
    
    /**
    * @brief Collegamento alla gestione Import/Export
    */
    private GestioneIO io;
    
    /**
    * @brief Lista Osservabile dei contatti
    */
    private ObservableList<Contatto> contatti;
    
    /**
    * @brief Indirizzo di default del file .vcf
    */
    private String filePathDefault;

    /**
     * @brief Costruttore Elenco
     * 
     * @param[in] filePathDefault indirizzo file di default, persistenza dei dati
     * 
     * @see initElenco();
     */
    public Elenco(String filePathDefault) {
        this.filePathDefault = filePathDefault;
        this.contatti = FXCollections.observableArrayList();
        this.io = new GestioneIO(this);
        
        initElenco();
    }
    
    /**
     * @brief 
     */
    private void initElenco(){
        io.caricaVCF(filePathDefault,contatti);
    }
    
    /**
     * @brief Restituisce la lista osservabile dei contatti
     * 
     * @return ObservableList dei contatti 
     */
    public ObservableList<Contatto> getContatti() {
        return contatti;
    }
    
    /**
     * @brief Aggiunge un contatto alla lista
     * 
     * @param[in] contatto Contatto con i suoi dati
     * 
     * @see sort()
     */
    public void addContatto(Contatto contatto){
        
        contatti.add(contatto);
        
        sort();
        
        io.salvaVCF(filePathDefault,contatti);
    }
    
    /**
     * @brief Rimuove un contatto alla lista
     * 
     * @param[in] contatto Contatto con i suoi dati
     */
    public void removeContatto(Contatto contatto){
        
        contatti.remove(contatto);
        
        io.salvaVCF(filePathDefault,contatti);
    }
    
    /**
     * @brief Modifica il contatto corrispondente a un ID
     * 
     * @param[in] id Identificatore del contatto
     * @param[in] contatto Contatto con i suoi dati
     * 
     */
    public void modifyContatto(int id,Contatto contatto){
        
        contatti.set(id,contatto);
        
        sort();
        io.salvaVCF(filePathDefault,contatti);
    }
    
    /**
     * @brief Ordinamento della lista
     */
    public void sort(){
        Collections.sort(contatti, (c1, c2)->{
            String nomeCompleto1 = (c1.getCognome() + " " + c1.getNome()).trim();
            String nomeCompleto2 = (c2.getCognome() + " " + c2.getNome()).trim();
            return nomeCompleto1.compareToIgnoreCase(nomeCompleto2);
        });
    }
    
}

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
 * @brief Classe Elenco contatti
 */
public class Elenco {
    
    private GestioneIO io;
    private ObservableList<Contatto> contatti;
    private String filePathDefault;

    /**
     * @brief costruttore Elenco
     * 
     * Inizializza la collezione contenente i contatti
     * 
     * @param filePathDefault indirizzo file di default, persistenza dei dati
     */
    public Elenco(String filePathDefault) {
        this.filePathDefault = filePathDefault;
        this.contatti = FXCollections.observableArrayList();
        this.io = new GestioneIO(this);
        
        initElenco();
    }
    
    private void initElenco(){
        io.caricaVCF(filePathDefault,contatti);
    }
    
    /**
     * @brief get lista contatti
     * 
     * @return ObservableList del contatti 
     */
    public ObservableList<Contatto> getContatti() {
        return contatti;
    }
    
    public void addContatto(Contatto contatto){
        
        contatti.add(contatto);
        
        sort();
        
        io.salvaVCF(filePathDefault,contatti);
    }
    
    public void removeContatto(Contatto contatto){
        
        contatti.remove(contatto);
        
        io.salvaVCF(filePathDefault,contatti);
    }
    
    public void modifyContatto(int id,Contatto contatto){
        
        contatti.set(id,contatto);
        
        io.salvaVCF(filePathDefault,contatti);
    }
    
    public void sort(){
        Collections.sort(contatti, (c1, c2)->{
            String nomeCompleto1 = (c1.getCognome() + " " + c1.getNome());
            String nomeCompleto2 = (c2.getCognome() + " " + c2.getNome());
            return nomeCompleto1.compareToIgnoreCase(nomeCompleto2);
        });
    }
    
}

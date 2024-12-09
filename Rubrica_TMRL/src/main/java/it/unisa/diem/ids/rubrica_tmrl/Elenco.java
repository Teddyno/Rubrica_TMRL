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
    
    private ObservableList<Contatto> contatti;

    /**
     * @brief costruttore Elenco
     * 
     * Inizializza la collezione contenente i contatti
     */
    public Elenco() {
        contatti = FXCollections.observableArrayList();
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
        
        GestioneIO.salvaVCF(Rubrica.fileDefault,contatti);
    }
    
    public void removeContatto(Contatto contatto){
        
        contatti.remove(contatto);
        
        GestioneIO.salvaVCF(Rubrica.fileDefault,contatti);
    }
    
    public void sort(){
        Collections.sort(contatti, (c1, c2)->{
            String nomeCompleto1 = (c1.getCognome() + " " + c1.getNome());
            String nomeCompleto2 = (c2.getCognome() + " " + c2.getNome());
            return nomeCompleto1.compareToIgnoreCase(nomeCompleto2);
        });
    }
    
}

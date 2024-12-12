

package it.unisa.diem.ids.rubrica_tmrl;

import java.util.Collections;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @brief Classe per la gestione dei preferiti
 */
public class Preferiti {
    
    /**
     * @brief Collegamento all'elenco dei contatti
     */
    private Elenco elenco;
    
    /**
     * @brief Lista Osservabile dei contatti preferiti
     */
    private ObservableList<Contatto> contattiPreferiti;

    /**
     * @brief Costruttore contatti preferiti
     * 
     * @param[in] elenco elenco dei contatti
     * 
     * @see setPreferiti()
     */
    public Preferiti(Elenco elenco) {
        this.contattiPreferiti = FXCollections.observableArrayList();
        this.elenco = elenco;
        
        setPreferiti();
        
    }
    
    /**
     * @brief Imposta la lista di preferiti
     * 
     * @see sort()
     */
    public void setPreferiti(){
       
        
        Iterator<Contatto> i =  elenco.getContatti().iterator();
            
            while(i.hasNext()){
                
                Contatto c = i.next();
                
                if(!contattiPreferiti.contains(c) && c.isPreferiti()){
                    contattiPreferiti.add(c);
                }
                
                if(contattiPreferiti.contains(c) && !c.isPreferiti()){
                    contattiPreferiti.remove(c);
                }
                
                if(contattiPreferiti.contains(c) && !elenco.getContatti().contains(c)){
                    contattiPreferiti.remove(c);    
                }
            }
            sort();
    }
    
    /**
     * @brief Rimuove un contatto alla lista dei preferiti
     * 
     * @param[in] contatto Contatto con i suoi dati
     */
    public void removePreferiti(Contatto contatto){
        contattiPreferiti.remove(contatto);
    }
    
    /**
     * @brief Modifica un contatto nella lista
     * 
     * @param[in] contattoOld Contatto da modificare
     * @param[in] contattoOld Contatto modificato
     */
    public void modifyPreferiti(Contatto contattoOld,Contatto contattoNew){
        
        int index = contattiPreferiti.indexOf(contattoOld);
        
        contattiPreferiti.set(index,contattoNew);
    }
    
    /**
     * @brief Ritorna la ObservableList dei contatti preferiti
     * 
     * @return ObservableList dei contatti preferiti
     */
    public ObservableList<Contatto> getContattiPreferiti() {
        return contattiPreferiti;
    }
    
    /**
     * @brief Ordinamento della lista
     * 
     * @return ordinamento dei contatti
     */
    public void sort(){
        Collections.sort(contattiPreferiti, (c1, c2)->{
            String nomeCompleto1 = (c1.getCognome() + " " + c1.getNome()).trim();
            String nomeCompleto2 = (c2.getCognome() + " " + c2.getNome()).trim();
            return nomeCompleto1.compareToIgnoreCase(nomeCompleto2);
        });
    }
}

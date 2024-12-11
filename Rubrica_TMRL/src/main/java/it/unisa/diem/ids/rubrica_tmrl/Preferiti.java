

package it.unisa.diem.ids.rubrica_tmrl;

import java.util.Collections;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Preferiti {
    
    private Elenco elenco;
    private ObservableList<Contatto> contattiPreferiti;


    public Preferiti(Elenco elenco) {
        this.contattiPreferiti = FXCollections.observableArrayList();
        this.elenco = elenco;
        
        setPreferiti();
        
    }
    
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
    
    public void removePreferiti(Contatto contatto){
        contattiPreferiti.remove(contatto);
    }
    
    public ObservableList<Contatto> getContattiPreferiti() {
        return contattiPreferiti;
    }
    
    public void sort(){
        Collections.sort(contattiPreferiti, (c1, c2)->{
            String nomeCompleto1 = (c1.getCognome() + " " + c1.getNome()).trim();
            String nomeCompleto2 = (c2.getCognome() + " " + c2.getNome()).trim();
            return nomeCompleto1.compareToIgnoreCase(nomeCompleto2);
        });
    }
}

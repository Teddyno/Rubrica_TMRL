

package it.unisa.diem.ids.rubrica_tmrl;

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
    }
    
    public void removePreferiti(Contatto contatto){
        contattiPreferiti.remove(contatto);
    }
    
    public ObservableList<Contatto> getContattiPreferiti() {
        return contattiPreferiti;
    }
}

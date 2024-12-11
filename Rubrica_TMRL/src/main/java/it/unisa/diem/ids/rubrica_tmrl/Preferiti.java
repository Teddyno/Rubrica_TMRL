

package it.unisa.diem.ids.rubrica_tmrl;

import javafx.collections.ObservableList;


public class Preferiti {
    
    private ObservableList<Contatto> contattiPref;
    private String filePathDefault;

    public Preferiti(ObservableList<Contatto> contattiPref, String filePathDefault) {
        this.contattiPref = contattiPref;
        this.filePathDefault = filePathDefault;
    }
    
    
}

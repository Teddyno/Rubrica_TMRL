/**
 * @file Contatto.java
 * @brief Classe Contatto
 * 
 * @author TMRL
 * @version 1.0
 */

package it.unisa.diem.ids.rubrica_tmrl;

import java.util.ArrayList;
import java.util.List;

/**
 * @brief Classe Contatto
 */
public class Contatto {
    private String nome;
    private String cognome;

    List<String> email;
    List<String> numTel;
    
    private boolean preferiti;
    
    public Contatto() {
        this.preferiti = false;
        email = new ArrayList<>();
        numTel = new ArrayList<>();
    }
    
    /**
     * @brief costruttore Contatto
     * 
     * @param nome nome del contatto
     * @param cognome cognome del contatto
     * @param numTel numero di telefono del contatto
     * @param email email del contatto
     */
    public Contatto(String nome, String cognome) {
        this.preferiti = false;
        this.nome = nome;
        this.cognome = cognome;
        email = new ArrayList<>();
        numTel = new ArrayList<>();
        
    }

    /**
     * @brief get nome contatto
     * 
     * @return nome del contatto
     */
    public String getNome() {
        return nome;
    }

    /**
     * @brief get cognome contatto
     * 
     * @return cognome del contatto
     */
    public String getCognome() {
        return cognome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @brief get email contatto
     * 
     * @return email del contatto
     */
    public void addEmail(String email) {
        this.email.add(email);
    }
    
    /**
     * @brief get numTel contatto
     * 
     * @return numTel del contatto
     */
    public void addNumTel(String numTel) {
        this.numTel.add(numTel);
    }

    public int getSizeEmail(){
        return email.size();
    }
    
    public int getSizeNumTel(){
        return numTel.size();
    }
    
    public String getEmail(int index){
        return email.get(index);
    }
    
    public String getNumTel(int index){
        return numTel.get(index);
    }

    public boolean isPreferiti() {
        return preferiti;
    }

    public void setPreferiti(boolean preferiti) {
        this.preferiti = preferiti;
    }
    
}
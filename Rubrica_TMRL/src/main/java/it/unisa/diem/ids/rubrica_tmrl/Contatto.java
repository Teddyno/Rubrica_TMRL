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
 * @brief Classe Contatto dove vengono definiti i dati del contatto
 */
public class Contatto {
    
    /**
     * @brief Nome del contatto
     */
    private String nome;
    
    /**
     * @brief Cognome del contatto
     */
    private String cognome;
    
    /**
     * @brief Lista contenente le email del contatto
     */
    List<String> email;
    
    /**
     * @brief Lista contenente i numeri di telefono del contatto
     */
    List<String> numTel;
    
    /**
     * @brief Booleano per scegliere se un contatto fa parte della lista 
     * preferiti oppure no
     */
    private boolean preferiti;
    
    /**
     * @brief Costruttore contatto senza parametri
     */
    public Contatto() {
        this.preferiti = false;
        email = new ArrayList<>();
        numTel = new ArrayList<>();
    }
    
    /**
     * @brief Costruttore Contatto
     * 
     * @param[in] nome nome del contatto
     * @param[in] cognome cognome del contatto
     */
    public Contatto(String nome, String cognome) {
        this.preferiti = false;
        this.nome = nome;
        this.cognome = cognome;
        email = new ArrayList<>();
        numTel = new ArrayList<>();
        
    }

    /**
     * @brief Restituisce il nome del contatto
     * 
     * @return nome del contatto
     */
    public String getNome() {
        return nome;
    }

    /**
     * @brief Restituisce il cognome del contatto
     * 
     * @return cognome del contatto
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @brief Imposta il nome del contatto
     * 
     * @param[in] nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @brief Imposta il cognome del contatto
     * 
     * @param[in] cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @brief aggiunge un'email alla lista
     * 
     * @param[in] email
     */
    public void addEmail(String email) {
        this.email.add(email);
    }
    
    /**
     * @brief aggiunge un numero telefonico alla lista
     * 
     * @param[in] numTel
     */
    public void addNumTel(String numTel) {
        this.numTel.add(numTel);
    }

    /**
     * @brief Restituisce il numero di email
     * 
     * @return numero di email
     */
    public int getSizeEmail(){
        return email.size();
    }
    
    /**
     * @brief Restituisce il numero di numeri telefonici
     * 
     * @return numero di numeri telefonici
     */
    public int getSizeNumTel(){
        return numTel.size();
    }
    
    /**
     * @brief Restituisce l'email del contatto
     * 
     * @param[in] index indice dell'email
     * 
     * @return email corrispondente a quell'index
     */
    public String getEmail(int index){
        return email.get(index);
    }
    
    /**
     * @brief Restituisce il numero telefonico del contatto
     * 
     * @param[in] index indice del numero telefonico
     * 
     * @return numero telefonico corrispondente a quell'index
     */
    public String getNumTel(int index){
        return numTel.get(index);
    }

    /**
     * @brief Indica se il contatto è stato aggiunto o no alla lista dei preferiti
     * 
     * @return True se il contatto appartiene alla lista dei preferiti
     * False altrimenti
     */
    public boolean isPreferiti() {
        return preferiti;
    }

    /**
     * @brief Imposta la lista dei preferiti
     * 
     * @param[in] preferiti booleano che indica se il contatto
     * appartiene alla lista dei preferiti
     */
    public void setPreferiti(boolean preferiti) {
        this.preferiti = preferiti;
    }
    
}
/**
 * @file Contatto.java
 * @brief Classe Contatto
 * 
 * @author TMRL
 * @version 1.0
 */

package it.unisa.diem.ids.rubrica_tmrl;

/**
 * @brief Classe Contatto
 */
public class Contatto {
    private String nome;
    private String cognome;
    private String numTel;
    private String email;

    /**
     * @brief costruttore Contatto
     * 
     * @param nome nome del contatto
     * @param cognome cognome del contatto
     * @param numTel numero di telefono del contatto
     * @param email email del contatto
     */
    public Contatto(String nome, String cognome, String numTel, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.numTel = numTel;
        this.email = email;
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

    /**
     * @brief get numTel contatto
     * 
     * @return numTel del contatto
     */
    public String getNumTel() {
        return numTel;
    }

    /**
     * @brief get email contatto
     * 
     * @return email del contatto
     */
    public String getEmail() {
        return email;
    }
    
}
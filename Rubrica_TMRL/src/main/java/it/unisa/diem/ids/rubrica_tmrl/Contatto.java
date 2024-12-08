package it.unisa.diem.ids.rubrica_tmrl;

/**
 *
 * @author diducc
 */
public class Contatto {
    private String nome;
    private String cognome;
    private String NumTel;
    private String email;

    public Contatto(String nome, String cognome, String numeroTelefonico, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.NumTel = NumTel;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNumTel() {
        return NumTel;
    }

    public String getEmail() {
        return email;
    }
    
}
package it.unisa.diem.ids.rubrica_tmrl;

/**
 *
 * @author diducc
 */
public class Contatto {
    private String nome;
    private String cognome;
    private String numeroTelefonico;
    private String email;

    public Contatto(String nome, String cognome, String numeroTelefonico, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.numeroTelefonico = numeroTelefonico;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public String getEmail() {
        return email;
    }
    
}

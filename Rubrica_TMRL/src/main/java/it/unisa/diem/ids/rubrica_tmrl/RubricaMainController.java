/**
 * @file RubricaMainController.java
 * @brief Classe controller scena principale
 * 
 * @author TMRL
 * @version 1.0
 */
package it.unisa.diem.ids.rubrica_tmrl;

import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * @brief Classe RubricaController
 */
public class RubricaMainController implements Initializable {
    @FXML
    private AnchorPane pane;                                                    // AnchorPane " Principale"
    
    @FXML
    private TextField barraDiRicerca;
    
    @FXML
    private Button btnHome;                                                     // Button Home in HBox all'interno dell' AnchorPane "Principale"
    
    @FXML
    private TableView<Contatto> cntTable;                                       // Tabella contatti in VBox all'interno dell' AnchorPane "Principale"
        @FXML
        private TableColumn<Contatto, String> cntClmNome;                           // Tabella contatti (colonna)
    
    private Elenco e;
        
    /**********  AnchorPane HOMEPAGE  ***********/
    @FXML
    private AnchorPane homePane;                                                // AnchorPane HOMEPAGE
    @FXML
    private Button btnaddcontatto;                                              // Button "Aggiungi Contatto" nell'anchorPane "Home Page"
  
    /**********  *******************  ***********/
    
    /**********  AnchorPane MODIFICA CONTATTO  *************/
    @FXML
    private AnchorPane modificaContattoPane;                                    // AnchorPane "Modifica Contatto"
    @FXML
    private TextField modNomeField;                                             // Box/TextField nell'anchor Pane "Modifica Contatto" per modificare il Nome del Contatto
    @FXML
    private TextField modCognomeField;                                          // Box/TextField nell'anchor Pane "Modifica Contatto" per modificare il Cognome del Contatto
    @FXML
    private TextField modNumeroTre;                                             // Box/TextField nell'anchor Pane "Modifica Contatto" per modificare il Terzo Numero del Contatto
    @FXML
    private TextField modNumeroDue;                                             // Box/TextField nell'anchor Pane "Modifica Contatto" per modificare il secondo Numero del Contatto
    @FXML
    private TextField modNumeroUno;                                             // Box/TextField nell'anchor Pane "Modifica Contatto" per modificare il primo Numero del Contatto
    @FXML
    private TextField modEmailTre;                                              // Box/TextField nell'anchor Pane "Modifica Contatto" per modificare la Terzo Email del Contatto
    @FXML
    private TextField modEmailDue;                                              // Box/TextField nell'anchor Pane "Modifica Contatto" per modificare la seconda Email del Contatto
    @FXML
    private TextField modEmailUno;                                              // Box/TextField nell'anchor Pane "Modifica Contatto" per modificare la prima Email del Contatto
    /**********  *****************************  *************/
            
    /**********   AnchorPane VISUALIZZA CONTATTO  ***********/
    @FXML
    private AnchorPane contattoPane;                                            // AnchorPane "VISUALIZZA CONTATTO"                                    
    @FXML
    private Label datilbl;                                                      // Label per visualizzare il NOME e Cognome del contatto nell'AnchorPane per visualizzare il contatto
    @FXML
    private Button rimuovibtn;                                                  // Button "Rimuovi" nell'AnchorPane per visualizzare il contatto
    @FXML
    private Button modificaBtn;                                                 // Button "Conferma Modifiche" nell'anchorPane "Nome Contatto"
    @FXML
    private Label numeroUnoLbl;                                                 // Label nell'anchor Pane "Visualizza Contatto" per visualizzare il primo Numero del Contatto
    @FXML
    private Label numeroDueLbl;                                                 // Label nell'anchor Pane "Visualizza Contatto" per visualizzare il secondo Numero del Contatto
    @FXML
    private Label numeroTreLbl;                                                 // Label nell'anchor Pane "Visualizza Contatto" per visualizzare il Terzo Numero del Contatto
    @FXML
    private Label emailUnoLbl;                                                  // Label  nell'anchor Pane "Visualizza Contatto" per visualizzare la prima email del Contatto
    @FXML
    private Label emailDueLbl;                                                  // Label  nell'anchor Pane "Visualizza Contatto" per visualizzare la seconda email del Contatto
    @FXML
    private Label emailTreLbl;                                                  // Label  nell'anchor Pane "Visualizza Contatto" per visualizzare la terza email del Contatto
    /********** ********************************  ***********/
    
   
    /**********   AnchorPane Aggiungi CONTATTO  ***********/
    @FXML
    private AnchorPane addcontattopane;                                         // Pane per aggiungere contatti 
    @FXML
    private TextField nomeField;                                                // Box per il nome del contatto
    @FXML
    private TextField numeroTre;                                                // Box per il terzo numero telefonico del contatto
    @FXML
    private TextField cognomeField;                                             // Box per il Cognome del contatto
    @FXML
    private TextField numeroUno;                                                // Box per il Primo numero telefonico del contatto
    @FXML
    private TextField numeroDue;                                                // Box per il Secondo numero telefonico del contatto
    @FXML
    private TextField emailUno;                                                 // Box per la prima mail del contatto
    @FXML
    private TextField emailDue;                                                 // Box per la seconda mail del contatto
    @FXML
    private TextField emailTre;                                                 // Box per la terza mail del contatto
    @FXML
    private Button submitBtn;                                                   // Button "Aggiungi" dell'anchorPane "Nuovo Contatto" 
    @FXML
    private Button gruppiBtn;
    @FXML
    private Button submitModifiche;
    @FXML
    private Button importBtn;
    @FXML
    private Button exportBtn;
    @FXML
    private Label infoNumLbl;
    @FXML
    private Label infoEmailLbl;

    /**********   ***************************  ***********/
    
    /**
     * @brief Inizializza il programma
     * 
     * Inizializza l'elenco, carica i contatti dal file e crea/setta la tabella dei contatti
     * 
     * @param[in] url 
     * @param[in] rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        e = new Elenco();

        cntClmNome.setCellValueFactory(s -> { 
            return new SimpleStringProperty((s.getValue().getCognome().isEmpty() ? "" : s.getValue().getCognome() + " ") + s.getValue().getNome()) ;
        });
        
        cntTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    showDetails(newValue);
                });

        GestioneIO.importaVCF(Rubrica.fileDefault,e.getContatti());
        
        cntTable.setItems(e.getContatti());
    }    

    
    /**
     * @brief Gestione barra di ricerca
     * 
     * Questo metodo va a collegare l'input della barra di ricerca
     * con la tabella dei contatti, andando a far visualizzare in essa 
     * i contatti che corrispondono all'input dell'utente
     * 
     * @pre numero di contatti maggiore di 0
     * @post tabella dei contatti aggiornata con i contatti richiesti
     * 
     * @param[in] event evento scaturito dal click di un pulsante 
     */
    @FXML
    private void cerca(ActionEvent event) {
        
        //DA SISTEMARE (LA PRIMA VOLTA CHE SI CERCA IL CONTATTO NON FUNZIONA)
        
        FilteredList<Contatto> cerca = new FilteredList<>(e.getContatti(), e->true);   // e->true ti manda tutti i contatti, e->false non ti manda nulla
        
        barraDiRicerca.textProperty().addListener((observable, oldValue, newValue) ->{
            cerca.setPredicate(cnt->{                                           // setPredicate definisce il filtro da applicare agli elementi della lista
                if(newValue == null || newValue.isEmpty())
                    return true;
                String filtro = newValue.toLowerCase();                            // testo inserito nella barra di ricerca
                if(cnt.getNome().toLowerCase().contains(filtro))
                    return true;
                else if(cnt.getCognome().toLowerCase().contains(filtro))           // toLowerCase() utilizzata per convertire tutte le lettere di una stringa in caratteri minuscoli
                    return true;
                return false;
            });
        });
        
        barraDiRicerca.setOnKeyPressed(e->{
        cntTable.getSelectionModel().clearSelection();                      // ogni volta che l'utente preme un tasto nella casella di ricerca la selezione della tablewiew viene cancellata
        });
            
        SortedList<Contatto> ordina = new SortedList<>(cerca);
        ordina.comparatorProperty().bind(cntTable.comparatorProperty());        // comparatorProperty() è utilizzato nelle SortedList per determinare l'ordine di ordinamento degli elementi
                                                                                // .bind() è usato per creare una nuova funzione con un contesto (this) specificato.
        cntTable.setItems(ordina);                                              // .setItems() per impostare gli elementi di ordina in cntTable
    }
    

    /**
     * @brief Switch tra le varie interfacce
     * 
     * In seguito al click di un pulsante, si cambia l'interfaccia visiva 
     * in base al pulsante cliccato
     * 
     * @param[in] event evento scaturito dal click di un pulsante 
     */
    @FXML
    private void switchPane(ActionEvent event) {
        if(event.getSource() == btnaddcontatto){
            addcontattopane.setVisible(true); 
            homePane.setVisible(false);
            modificaContattoPane.setVisible(false);
            contattoPane.setVisible(false);
        }
       
        else if(event.getSource() == submitBtn){
            addcontattopane.setVisible(false); 
            homePane.setVisible(false);
            modificaContattoPane.setVisible(false);
            contattoPane.setVisible(true);
        }
        
        else if(event.getSource() == modificaBtn){
            addcontattopane.setVisible(false); 
            homePane.setVisible(false);
            modificaContattoPane.setVisible(true);
            contattoPane.setVisible(false);
        }   
        
        else{ //btnHome
            addcontattopane.setVisible(false); 
            homePane.setVisible(true);
            modificaContattoPane.setVisible(false);
            contattoPane.setVisible(false);
            //per eliminare il problema della selezione della tabella(se aggiungi contatto, poi home e poi di nuovo il contatto, dovrebbe restare home)
            //però non mi piace come posizionamento, commenta per notare il problema
            cntTable.getSelectionModel().clearSelection();
        }
    }
    
    /**
     * @brief Controlla validità Input
     * 
     * @return True se gli input dell'utente sono validi
     */
    private boolean isValido(Contatto contatto){
        
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        String numTelPattern = "^\\+?\\d{10,15}$";
        
        if((contatto.getNome().isEmpty()) && (contatto.getCognome().isEmpty())) return false;
        
        for(int i=0;i<contatto.getSizeNumTel();i++){
            if(i == 0 && !Pattern.matches(numTelPattern, contatto.getNumTel(0))) return false; 
            else if(i == 1 && !Pattern.matches(numTelPattern, contatto.getNumTel(1))) return false; 
            else if(i == 2 && !Pattern.matches(numTelPattern, contatto.getNumTel(2))) return false;
        }
        
        for(int i=0;i<contatto.getSizeEmail();i++){
            if(i == 0 && !Pattern.matches(emailPattern, contatto.getEmail(0))) return false;
            else if(i == 1 && !Pattern.matches(emailPattern, contatto.getEmail(1))) return false;
            else if(i == 2 && !Pattern.matches(emailPattern, contatto.getEmail(2))) return false;
        }
        
        return true;  
    }
    
     /**
     * @brief Controlla validità Input Email
     * 
     * Verifica l'email con il pattern
     * 
     * @return True se l'email passata è valida
     */
    private static boolean isValidEmail(String email) {

        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";


        if (email == null) {
            return false;
        }

        // 
        return Pattern.compile(emailRegex).matcher(email).matches();
    }
    /**
     * @brief Controlla validità Input Email
     * 
     * Controllo di null o stringa vuota
     * Verifica se il numero rispetta il pattern
     * 
     * @return True se il numero passato è valido
     */
    private static boolean isValidNumTel(String NumTel) {
  
        if (NumTel == null || NumTel.isEmpty()) {
            return false;
        }

        String phoneRegex = "^\\+?\\d{10,15}$";

        return NumTel.matches(phoneRegex);
    }
    
    /**
     * @brief Ordina l'elenco
     * 
     * Imposta l'elenco in ordine alfabetico 
     */
    private void ordinamento(){
        Collections.sort(e.getContatti(), (c1, c2)->{
            String nomeCompleto1 = (c1.getCognome() + " " + c1.getNome());
            String nomeCompleto2 = (c2.getCognome() + " "  + c2.getNome());
            return nomeCompleto1.trim().compareToIgnoreCase(nomeCompleto2.trim());
        });
    }


    /**
     * @brief Aggiungi contatto all'elenco
     * 
     * @pre il contatto da aggiungere è valido
     * 
     * Aggiunge il contatto all'elenco, richiama i metodi : ordinamento e pulisci 
     * e salva il nuovo contatto nel file VCF
     * 
     * @param[in] event evento scaturito dal click di un pulsante 
     * 
     * @see pulisci()
     * @see ordinamento()
     */
    @FXML
    private void aggiungiContatto(ActionEvent event) {      
        
        
        Contatto nuovoContatto = new Contatto(nomeField.getText(), cognomeField.getText());
        if(!emailUno.getText().equals("")){
            nuovoContatto.addEmail(emailUno.getText());
        }
        if(!emailDue.getText().equals("")){
            nuovoContatto.addEmail(emailDue.getText());
        }
        if(!emailTre.getText().equals("")){
            nuovoContatto.addEmail(emailTre.getText());
        }
        if(!numeroUno.getText().equals("")){
            nuovoContatto.addNumTel(numeroUno.getText());
        }
        if(!numeroDue.getText().equals("")){
            nuovoContatto.addNumTel(numeroDue.getText());
        }
        if(!numeroTre.getText().equals("")){
            nuovoContatto.addNumTel(numeroTre.getText());
        }
        
        if(!isValido(nuovoContatto)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Dati non validi");
            alert.setHeaderText("Inserisci almeno uno tra Nome e Cognome");
            alert.showAndWait();
            return;
        }
        
        e.addContatto(nuovoContatto);
        
        ordinamento();
        
        switchPane(event); //ritorno in home
        cntTable.getSelectionModel().select(nuovoContatto);
        
        pulisci();
    }
    
    /**
     * @brief Pulisce i TextField
     * 
     */
    private void pulisci(){
        nomeField.clear();
        cognomeField.clear();
        numeroUno.clear();
        numeroDue.clear();
        numeroTre.clear();
        emailUno.clear();
        emailDue.clear();
        emailTre.clear();
    }
    
    private void pulisciContatto(){
        datilbl.setText("");
        numeroUnoLbl.setText("");
        numeroDueLbl.setText("");
        numeroTreLbl.setText("");
        emailUnoLbl.setText("");
        emailDueLbl.setText("");
        emailTreLbl.setText("");
    }
    
    private void pulisciMod(){
        modNomeField.clear();
        modCognomeField.clear();
        modNumeroUno.clear();
        modNumeroDue.clear();
        modNumeroTre.clear();
        modEmailUno.clear();
        modEmailDue.clear();
        modEmailTre.clear();
    }

    /**
     * @brief Imposta i dati del contatto nell'interfaccia
     * 
     * @param[in] cnt contatto da visualizzare 
     */
    private void showDetails(Contatto cnt) {
        pulisciContatto();
        
        datilbl.setText(cnt.getCognome() + " " + cnt.getNome());
        
        for(int i=0;i<cnt.getSizeNumTel();i++){
            if(i == 0){
                numeroUnoLbl.setText(cnt.getNumTel(0));
            } else if(i == 1){
                numeroDueLbl.setText(cnt.getNumTel(1));
            } else if(i == 2){
                numeroTreLbl.setText(cnt.getNumTel(2));
            }
        }
        
        for(int i=0;i<cnt.getSizeEmail();i++){
            if(i == 0){
                emailUnoLbl.setText(cnt.getEmail(0));
            } else if(i == 1){
                emailDueLbl.setText(cnt.getEmail(1));
            } else if(i == 2){
                emailTreLbl.setText(cnt.getEmail(2));
            }
        }

        //per visualizzare il pane del contatto e disattivare quello della home
        // da implementare nello switchPane ??
        addcontattopane.setVisible(false); 
        homePane.setVisible(false);
        modificaContattoPane.setVisible(false);
        contattoPane.setVisible(true);
    }

    /**
     * @brief Rimuove un contatto dall'elenco
     * 
     * Preleva il contatto selezionato, richiede la conferma della rimozione
     * in caso affermativo rimuove il contatto dall'elenco e salva l'elenco
     * aggiornato nel file
     * 
     * @param[in] event evento scaturito dal click di un pulsante 
     */
    @FXML
    private void rimuoviContatto(ActionEvent event) {
        
        Contatto contattoSel = cntTable.getSelectionModel().getSelectedItem();
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conferma Rimozione");
        alert.setHeaderText("Stai per rimuovere un contatto");
        alert.setContentText("Sei sicuro di voler eliminare " + contattoSel.getCognome() + " " + contattoSel.getNome() + "?");
        
        alert.showAndWait().ifPresent(response -> {
            if(response == ButtonType.OK){
                e.removeContatto(contattoSel);
            }
            if(e.getContatti().isEmpty()){
                switchPane(event);
            }
        });

    }
    
    /**
     * @brief Imposta Interfaccia modifica
     * 
     * Cambia l'interfaccia in quella per la modifica e 
     * imposta i textfield con i dati modificabili
     * 
     * @param[in] event evento scaturito dal click di un pulsante 
     */
    @FXML
    private void modificaPane(ActionEvent event) { 
        switchPane(event);

        pulisciMod();
        
        Contatto contattoSel = cntTable.getSelectionModel().getSelectedItem();
        
        
        modNomeField.setText(contattoSel.getNome());
        modCognomeField.setText(contattoSel.getCognome());
        
        
        for(int i=0;i<contattoSel.getSizeNumTel();i++){
            if(i == 0){
                modNumeroUno.setText(contattoSel.getNumTel(0));
            } else if(i == 1){
                modNumeroDue.setText(contattoSel.getNumTel(1));
            } else if(i == 2){
                modNumeroTre.setText(contattoSel.getNumTel(2));
            }
        }
        
        for(int i=0;i<contattoSel.getSizeEmail();i++){
            if(i == 0){
                modEmailUno.setText(contattoSel.getEmail(0));
            } else if(i == 1){
                modEmailDue.setText(contattoSel.getEmail(1));
            } else if(i == 2){
                modEmailTre.setText(contattoSel.getEmail(2));
            }
        }
        
        
    }

    /**
     * @brief modifica del contatto
     * 
     * preleva contatto da modificare, richiede conferma modifica
     * cambia i dati modificati nell'elenco e salva i dati aggiornati nel file
     * richiama infine metodo ordinamento
     * 
     * @param[in] event evento scaturito dal click di un pulsante 
     * 
     * @see ordinamento()
     */
    @FXML
    private void modificaContatto(ActionEvent event) {
        int contattoSelID = cntTable.getSelectionModel().getSelectedIndex();
        
        Contatto modContatto = new Contatto(modNomeField.getText(), modCognomeField.getText());
 
        if(!modEmailUno.getText().equals("")){
            modContatto.addEmail(modEmailUno.getText());
        }
        if(!modEmailDue.getText().equals("")){
            modContatto.addEmail(modEmailDue.getText());
        }
        if(!modEmailTre.getText().equals("")){
            modContatto.addEmail(modEmailTre.getText());
        }
        if(!modNumeroUno.getText().equals("")){
            modContatto.addNumTel(modNumeroUno.getText());
        }
        if(!modNumeroDue.getText().equals("")){
            modContatto.addNumTel(modNumeroDue.getText());
        }
        if(!modNumeroTre.getText().equals("")){
            modContatto.addNumTel(modNumeroTre.getText());
        }
        
        if(!isValido(modContatto)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Dati non validi");
            alert.setHeaderText("Numero di Telefono o Email non validi");
            alert.showAndWait();
            return;
        }
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conferma Modifiche");
        alert.setHeaderText("Stai per modificare un contatto");
        alert.setContentText("Sei sicuro di voler modificare questo contatto?");
        
        alert.showAndWait().ifPresent(response -> {
            if(response == ButtonType.OK){                                      // se l'utente conferma le modifiche
                e.getContatti().set(contattoSelID, modContatto);
                cntTable.getSelectionModel().select(modContatto);
                ordinamento();
                GestioneIO.salvaVCF(Rubrica.fileDefault,e.getContatti());
            }
            else{
                addcontattopane.setVisible(false); 
                homePane.setVisible(false);
                modificaContattoPane.setVisible(true);
                contattoPane.setVisible(false);
            }
            
        });
        
    }
    
    
    @FXML
    private void handleImport(ActionEvent event){
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new ExtensionFilter("VCF", "*.vcf"));
        fileChooser.setTitle("Scegli file Vcard");
        File file = fileChooser.showOpenDialog(new Stage());
        
        GestioneIO.importaVCF(file.getPath(), e.getContatti());
        ordinamento();
        GestioneIO.salvaVCF(Rubrica.fileDefault,e.getContatti());   
    }
    
    @FXML
    private void handleExport(ActionEvent event){
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new ExtensionFilter("VCF", "*.vcf"));
        fileChooser.setTitle("Scegli file Vcard");
        File file = fileChooser.showSaveDialog(new Stage());
        
        GestioneIO.salvaVCF(file.getPath(),e.getContatti());
  
    }
    
}

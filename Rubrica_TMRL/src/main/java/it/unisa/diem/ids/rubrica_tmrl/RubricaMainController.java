/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.rubrica_tmrl;

import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

/*
 * FXML Controller class
 *
 * @author diducc
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
    
    private ObservableList<Contatto> contatti;
        
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
    private Button sumbitModifiche;                                             // Button "Conferma Modifiche" nell'anchorPane "Modifica Contatto"
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
    private Button predefinitoBtn;

    /**********   ***************************  ***********/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        contatti = FXCollections.observableArrayList();

        cntClmNome.setCellValueFactory(s -> { 
            return new SimpleStringProperty(s.getValue().getCognome() + " " + s.getValue().getNome());
        });
        
        cntTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    showDetails(newValue);
                });
        
        GestioneIO.initContatti(Rubrica.fileDefault,contatti);
        
        cntTable.setItems(contatti);
    }    

    @FXML
    private void cerca(ActionEvent event) {
        
        //DA SISTEMARE (LA PRIMA VOLTA CHE SI CERCA IL CONTATTO NON FUNZIONA)
        
        FilteredList<Contatto> cerca = new FilteredList<>(contatti, e->true);   // e->true ti manda tutti i contatti, e->false non ti manda nulla
        
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
    
    private boolean isValido(){
        return !(nomeField.getText().isEmpty() && cognomeField.getText().isEmpty());  // controlla se i campi sono vuoti in aggiungi contatto
    }

    @FXML
    private void aggiungiContatto(ActionEvent event) {
        
        if(!isValido()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Dati Mancanti");
            alert.setHeaderText("Devi inserire almeno uno tra Nome e Cognome");
            alert.showAndWait();
            return;
        }
        
        Contatto nuovoContatto = new Contatto(nomeField.getText(), cognomeField.getText(), numeroUno.getText(), emailUno.getText());
        contatti.add(nuovoContatto);
        
        ordinamento();
        
        switchPane(event); //ritorno in home
        cntTable.getSelectionModel().select(nuovoContatto);
        
        pulisci();
    }
    
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

    private void showDetails(Contatto cnt) {
        datilbl.setText(cnt.getCognome() + " " + cnt.getNome());
        numeroUnoLbl.setText(cnt.getNumeroTelefonico());
        numeroDueLbl.setText(cnt.getNumeroTelefonico());
        numeroTreLbl.setText(cnt.getNumeroTelefonico());
        emailUnoLbl.setText(cnt.getEmail());
        emailDueLbl.setText(cnt.getEmail());
        emailTreLbl.setText(cnt.getEmail());

        //per visualizzare il pane del contatto e disattivare quello della home
        // da implementare nello switchPane ??
        addcontattopane.setVisible(false); 
        homePane.setVisible(false);
        modificaContattoPane.setVisible(false);
        contattoPane.setVisible(true);
    }

    @FXML
    private void rimuoviContatto(ActionEvent event) {
        
        Contatto contattoSel = cntTable.getSelectionModel().getSelectedItem();
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conferma Rimozione");
        alert.setHeaderText("Stai per rimuovere un contatto");
        alert.setContentText("Sei sicuro di voler eliminare " + contattoSel.getCognome() + " " + contattoSel.getNome() + "?");
        
        alert.showAndWait().ifPresent(response -> {
            if(response == ButtonType.OK)
                contatti.remove(contattoSel);
            
            if(contatti.isEmpty()){
                switchPane(event);
            }
        });

    }
    

    @FXML
    private void modificaPane(ActionEvent event) { 
        switchPane(event);

        Contatto contattoSel = cntTable.getSelectionModel().getSelectedItem();
        modNomeField.setText(contattoSel.getNome());
        modCognomeField.setText(contattoSel.getCognome());
        
    }

    @FXML
    private void modificaContatto(ActionEvent event) {
        int contattoSelID = cntTable.getSelectionModel().getSelectedIndex();
        Contatto modContatto = new Contatto(modNomeField.getText(), modCognomeField.getText(), modNumeroUno.getText(), modEmailUno.getText());
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conferma Modifiche");
        alert.setHeaderText("Stai per modificare un contatto");
        alert.setContentText("Sei sicuro di voler modificare in: " + modContatto.getCognome() + " " + modContatto.getNome() + "?");
        
        alert.showAndWait().ifPresent(response -> {
            if(response == ButtonType.OK){
                contatti.set(contattoSelID, modContatto);
                cntTable.getSelectionModel().select(modContatto);
            }
            else{
                addcontattopane.setVisible(false); 
                homePane.setVisible(false);
                modificaContattoPane.setVisible(true);
                contattoPane.setVisible(false);
            }
            
        });
        ordinamento();
    }
    
    private void ordinamento(){
        Collections.sort(contatti, (c1, c2)->{
            String nomeCompleto1 = (c1.getCognome() + " " + c1.getNome());
            String nomeCompleto2 = (c2.getCognome() + " " + c2.getNome());
            return nomeCompleto1.compareToIgnoreCase(nomeCompleto2);
        });
    }

    @FXML
    private void aggiungiPredefiniti(ActionEvent event) {               
        
        //METODO DA TOGLIERE. SERVE SOLO PER COMODITÀ NEI TEST (CREA IN AUTOMATICO 4 CONTATTI)
        
        Contatto contatto1 = new Contatto("Mario", "Rossi", "1234567890", "mario.rossi@example.com");
        Contatto contatto2 = new Contatto("Luigi", "Verdi", "1234567890", "luigi.verdi@example.com");
        Contatto contatto3 = new Contatto("Anna", "Bianchi", "1234567890", "anna.bianchi@example.com");
        Contatto contatto4 = new Contatto("Sara", "Neri", "1234567890", "sara.neri@example.com");

        contatti.addAll(contatto1, contatto2, contatto3, contatto4);
        ordinamento();
    }
}
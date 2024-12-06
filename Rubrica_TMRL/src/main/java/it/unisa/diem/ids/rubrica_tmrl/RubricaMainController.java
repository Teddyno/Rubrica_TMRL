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
    private TextField barradiricerca;                                           // Barra di ricerca
    @FXML
    private Button btnaddcontatto;                                              // Bottone aggingi contatto
    @FXML
    private AnchorPane addcontattopane;                                         // Pane per aggiungere contatti
    @FXML
    private TextField nomeField;                                                // Box per il nome del cpntatto
    @FXML
    private TextField numeroTre;                                                // Box per il terzo numero telefonico del contatto
    @FXML
    private TextField cognomeField;                                             // Box per il Cognome del contatto
    @FXML
    private TextField numeroUno;                                                // Box per il Primo numero telefonico del contatto
    @FXML
    private TextField numeroDue;                                                // Box per il Secondo numero telefonico del contatto
    @FXML
    private TextField emailTre;                                                 // Box per la terza mail del contatto
    @FXML
    private TextField emailDue;                                                 // Box per la seconda mail del contatto
    @FXML
    private TextField emailUno;                                                 // Box per la prima mail del contatto
    @FXML
    private Button submitBtn;
    @FXML
    private TableView<Contatto> cntTable;
        @FXML
        private TableColumn<Contatto, String> cntClmNome;
    @FXML
    private Button homeBtn;
    @FXML
    private AnchorPane homePane;
    @FXML
    private Label datilbl;
    @FXML
    private Button rimuovibtn;
    @FXML
    private TextField modNomeField;
    @FXML
    private TextField modEmailTre;
    @FXML
    private TextField modNumeroTre;
    @FXML
    private TextField modCognomeField;
    @FXML
    private TextField modNumeroUno;
    @FXML
    private TextField modNumeroDue;
    @FXML
    private TextField modEmailDue;
    @FXML
    private TextField modEmailUno;
    @FXML
    private Button modificaBtn;
    @FXML
    private AnchorPane modificaContattoPane;
    @FXML
    private Button sumbitModifiche;
    
    
    
    private ObservableList<Contatto> contatti;
    @FXML
    private Label numeroUnoLbl;
    @FXML
    private Label numeroDueLbl;
    @FXML
    private Label numeroTreLbl;
    @FXML
    private Label emailUnoLbl;
    @FXML
    private Label emailFueLbl;
    @FXML
    private Label emailTreLbl;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        contatti = FXCollections.observableArrayList();
        
        cntClmNome.setCellValueFactory(s -> { return new SimpleStringProperty(s.getValue().getNome() + " " + s.getValue().getCognome());});
        
        
        cntTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    showDetails(newValue);
                });
        
        cntTable.setItems(contatti);
    }    

    @FXML
    private void cerca(ActionEvent event) {
            
    }

    @FXML
    private void switchForm(ActionEvent event) {
        if(event.getSource() == btnaddcontatto){
            addcontattopane.setVisible(true); 
            homePane.setVisible(false);
            modificaContattoPane.setVisible(false);
        }
        
        else if(event.getSource() == homeBtn){
            addcontattopane.setVisible(false); 
            homePane.setVisible(true);
            modificaContattoPane.setVisible(false);
        }
        
        else{
            addcontattopane.setVisible(false); 
            homePane.setVisible(false);
            modificaContattoPane.setVisible(false);
        }
    }

    @FXML
    private void aggiungiContatto(ActionEvent event) {
        
        String nome = nomeField.getText();
        String cognome = cognomeField.getText();
        if(nome.isEmpty() && cognome.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Dati Mancanti");
            alert.setHeaderText("Devi inserire almeno uno tra Nome e Cognome");
            alert.showAndWait();
            return;
        }
        Contatto nuovoContatto = new Contatto(nomeField.getText(), cognomeField.getText(), numeroUno.getText(), emailUno.getText());
        contatti.add(nuovoContatto);
        
        ordinamento();
        
        if(event.getSource() == submitBtn){
            addcontattopane.setVisible(false); 
            homePane.setVisible(true);
            modificaContattoPane.setVisible(false);
        }
        
        if (!contatti.isEmpty()) {
        cntTable.getSelectionModel().select(nuovoContatto);
        }
        
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
        datilbl.setText(cnt.getNome() + " " + cnt.getCognome());
        numeroUnoLbl.setText(cnt.getNumeroTelefonico());
        emailUnoLbl.setText(cnt.getEmail());
    }

    @FXML
    private void rimuoviContatto(ActionEvent event) {
        
        Contatto contattoSel = cntTable.getSelectionModel().getSelectedItem();
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conferma Rimozione");
        alert.setHeaderText("Stai per rimuovere un contatto");
        alert.setContentText("Sei sicuro di voler eliminare " + contattoSel.getNome() + " " + contattoSel.getCognome() + "?");
        
        alert.showAndWait().ifPresent(response -> {
            if(response == ButtonType.OK)
                contatti.remove(contattoSel);
            
            if(contatti.isEmpty()){
                addcontattopane.setVisible(true); 
                homePane.setVisible(false);
                modificaContattoPane.setVisible(false);
            }
        });

    }
    

    @FXML
    private void modificaContatto(ActionEvent event) {
        Contatto contattoSel = cntTable.getSelectionModel().getSelectedItem();
        
        if(event.getSource() == modificaBtn){
            addcontattopane.setVisible(false); 
            homePane.setVisible(false);
            modificaContattoPane.setVisible(true);
        }   
        
        int contattoSelID = cntTable.getSelectionModel().getSelectedIndex();
        modNomeField.setText(contattoSel.getNome());
        modCognomeField.setText(contattoSel.getCognome());
        
    }

    @FXML
    private void setModificaContatto(ActionEvent event) {
        
        //possibilmente una volta cliccato su annulla riporta sulla pagina delle modifiche e non sul contatto non modificato
        
        int contattoSelID = cntTable.getSelectionModel().getSelectedIndex();
        Contatto modContatto = new Contatto(modNomeField.getText(), modCognomeField.getText(), modNumeroUno.getText(), modEmailUno.getText());
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conferma Modifiche");
        alert.setHeaderText("Stai per modificare un contatto");
        alert.setContentText("Sei sicuro di voler modificare in: " + modContatto.getNome() + " " + modContatto.getCognome() + "?");
        
        alert.showAndWait().ifPresent(response -> {
            contatti.set(contattoSelID, modContatto);

            addcontattopane.setVisible(false); 
            homePane.setVisible(true);
            modificaContattoPane.setVisible(false);

            cntTable.getSelectionModel().select(modContatto);
            ordinamento();
        });
    }
    
    private void ordinamento(){
        Collections.sort(contatti, (c1, c2)->{
            String nomeCompleto1 = (c1.getNome() + " " + c1.getCognome());
            String nomeCompleto2 = (c2.getNome() + " " + c2.getCognome());
            return nomeCompleto1.compareTo(nomeCompleto2);
        });
    }
    
}

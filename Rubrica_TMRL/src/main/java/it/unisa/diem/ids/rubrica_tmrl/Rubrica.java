/**
 * @file Rubrica.java
 * @brief Classe iniziale per la rubrica, carica la scena
 * 
 * @author TMRL
 * @version 1.0
 */
package it.unisa.diem.ids.rubrica_tmrl;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @brief Classe Rubrica
 */
public class Rubrica extends Application {
    
    public static String fileDefault; ///< l'indirizzo di default del file .vcf
    
    
    /**
     * @brief start della scena
     * 
     * @param stage scena principale
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        
        fileDefault = "Rubrica.vcf";
        
        Parent root = FXMLLoader.load(getClass().getResource("RubricaMain.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @brief classe main
     * 
     * @param args 
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

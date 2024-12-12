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
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * @brief Classe Rubrica
 */
public class Rubrica extends Application {
    
    /**
     * @brief Indirizzo di default del file .vcf
     */
    public static String filePathDefault;
    
    /**
     * @brief Start della scena
     * 
     * @param stage Scena principale
     * 
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        
        
        filePathDefault = "src/main/resources/it/unisa/diem/ids/rubrica_tmrl/Rubrica.vcf";
        
        Parent root = FXMLLoader.load(getClass().getResource("RubricaMain.fxml"));
        
        stage.getIcons().add(new Image(getClass().getResourceAsStream("icona.png")));

        
        /*Image icona = new Image("src/main/resources/it/unisa/diem/ids/rubrica_tmrl/icona.png");
        stage.getIcons().add(icona);*/
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @brief Classe main
     * 
     * @param[in] args 
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

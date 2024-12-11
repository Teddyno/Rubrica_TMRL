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
    
    public static String filePathDefault; ///< l'indirizzo di default del file .vcf
    
    /**
     * @brief start della scena
     * 
     * @param stage scena principale
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        
        
        filePathDefault = "src/main/resources/it/unisa/diem/ids/rubrica_tmrl/Rubrica.vcf";
        
        Parent root = FXMLLoader.load(getClass().getResource("RubricaMain.fxml"));
        
        /*Image icona = new Image("src/main/resources/it/unisa/diem/ids/rubrica_tmrl/icona.png");
        stage.getIcons().add(icona);*/
        
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
    
    /**
     * @brief get Indirizzo file default
     * 
     * @return L'indirizzo del file di default per la persistenza dei dati
     */
    public static String getFileDefault() {
        return filePathDefault;
    }

    /**
     * @brief Set Indirizzo file default
     * 
     */
    public static void setFileDefault(String filePathDefault) {
        Rubrica.filePathDefault = filePathDefault;
    }
    
}

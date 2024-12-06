/*
 * prova commit PC_angela
 * 
 * and open the template in the editor.
 */
package it.unisa.diem.ids.rubrica_tmrl;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author diducc
 */
public class Rubrica extends Application {
    
    public static String fileDefault;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        fileDefault = "Rubrica.vcf";
        
        Parent root = FXMLLoader.load(getClass().getResource("RubricaMain.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

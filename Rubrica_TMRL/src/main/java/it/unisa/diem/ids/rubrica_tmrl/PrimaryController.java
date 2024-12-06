package it.unisa.diem.ids.rubrica_tmrl;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        Rubrica.setRoot("secondary");
    }
}

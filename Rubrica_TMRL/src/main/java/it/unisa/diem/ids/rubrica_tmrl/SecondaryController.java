package it.unisa.diem.ids.rubrica_tmrl;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        Rubrica.setRoot("primary");
    }
}
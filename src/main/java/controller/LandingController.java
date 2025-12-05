package controller;

import javafx.fxml.FXML;
import application.Main;

public class LandingController {

    @FXML
    private void openRegister() throws Exception {
        Main.changeScene("/view/Register.fxml");
    }
}

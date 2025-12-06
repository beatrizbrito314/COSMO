package controller;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import application.Main;


public class MensagemController {
@FXML private Label mensagem;


@FXML
private void voltar() throws Exception {
Main.changeScene("/view/Home.fxml");
}
}


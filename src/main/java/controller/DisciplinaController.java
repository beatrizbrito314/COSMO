package controller;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class DisciplinaController {
@FXML private TextField nomeDisciplina;
@FXML private Button salvarBtn;
@FXML private Label statusLabel;


@FXML
private void salvar() {
statusLabel.setText("Salvo com sucesso");
}
}
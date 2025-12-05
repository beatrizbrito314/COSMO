package controller;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Navigation {

    public static void goTo(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(Navigation.class.getResource(path));
            Scene scene = new Scene(loader.load());

            // pega o stage do Main, que SEMPRE está inicializado
            Stage stage = Main.getStage();

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

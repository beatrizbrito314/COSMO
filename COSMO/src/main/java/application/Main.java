package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends javafx.application.Application {

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        changeScene("/view/Landing.fxml");
        stage.setTitle("Cosmo");
        stage.show();
    }

    public static void changeScene(String fxml) {
    	
        try {
            //Salva o tamanho atual da janela
            double width = stage.getWidth();
            double height = stage.getHeight();

            FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxml));

            if (loader.getLocation() == null) {
                System.out.println("ERRO: FXML não encontrado: " + fxml);
                return;
            }

            Scene scene = new Scene(loader.load());

            String css = Main.class.getResource("/style/estilos.css").toExternalForm();
            scene.getStylesheets().add(css);

            stage.setScene(scene);

            stage.setWidth(width);
            stage.setHeight(height);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar: " + fxml);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getStage() {
        return stage;
    }
}



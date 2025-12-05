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
        changeScene("/view/Landing.fxml"); // caminho do FXML no resources
        stage.setTitle("Cosmo");
        stage.show();
    }

    public static void changeScene(String fxml) {
        try {
            // Carrega o FXML
            FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxml));

            if (loader.getLocation() == null) {
                System.out.println("ERRO: FXML não encontrado: " + fxml);
                return;
            }

            Scene scene = new Scene(loader.load());

            // 🔥 CARREGAR O CSS DA PASTA /style
            String css = Main.class.getResource("/style/estilos.css").toExternalForm();
            scene.getStylesheets().add(css);

            stage.setScene(scene);

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


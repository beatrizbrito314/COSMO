package controller;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import application.Main; 

public class NavbarController {

    @FXML
    private HBox homeBtn;

    @FXML
    private HBox featuresBtn;

    @FXML
    private HBox aboutBtn;

    @FXML
    private HBox contactBtn;

    //Fazendo o redirecionamento
    private final String HOME_VIEW = "/view/Landing.fxml"; 
    private final String FEATURES_VIEW = "/view/Home.fxml"; //Mudar aqui quando a página tiver pronta
    private final String ABOUT_VIEW = "/view/Sobre.fxml";
    private final String CONTACT_VIEW = "/view/Contato.fxml";

    public void initialize() {

        //Atribuindo ações aos botões da navbar
        setNavAction(homeBtn, "home", HOME_VIEW);
        setNavAction(featuresBtn, "features", FEATURES_VIEW);
        setNavAction(aboutBtn, "about", ABOUT_VIEW);
        setNavAction(contactBtn, "contact", CONTACT_VIEW);
    }

    private void setNavAction(HBox btn, String name, String fxmlPath) {
        btn.setOnMouseClicked(e -> {
            try {
            	
                Main.changeScene(fxmlPath); 
               
                setActive(btn); 
            } catch (Exception ex) {
                System.err.println("Erro ao carregar a cena: " + fxmlPath);
                ex.printStackTrace();
            }
        });
    }

    private void setActive(HBox activeBtn) {
        homeBtn.getStyleClass().remove("nav-item-active");
        featuresBtn.getStyleClass().remove("nav-item-active");
        aboutBtn.getStyleClass().remove("nav-item-active");
        contactBtn.getStyleClass().remove("nav-item-active");

        activeBtn.getStyleClass().add("nav-item-active");
    }
}

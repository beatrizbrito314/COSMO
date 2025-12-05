package controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SobreController {

    // ImageViews da equipe
    @FXML
    private ImageView fotoSarah;

    @FXML
    private ImageView fotoBia;

    @FXML
    public void initialize() {
    	
        //Vou carregar as fts por aqui que lá no fxml tá dando problema
        try {
            fotoSarah.setImage(new Image(getClass().getResourceAsStream("/images/Astro1.png")));
            fotoBia.setImage(new Image(getClass().getResourceAsStream("/images/Astro2.png")));
        } catch (Exception e) {
            System.err.println("Erro ao carregar imagens da equipe: " + e.getMessage());
        }
    }
}



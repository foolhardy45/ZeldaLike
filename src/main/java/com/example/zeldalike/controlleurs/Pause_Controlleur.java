package com.example.zeldalike.controlleurs;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.Environnement;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.TilePane;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class Pause_Controlleur implements Initializable {

    @FXML
    private TilePane inventaire_aff;
    private Environnement env;
    private final Set<String> pressedKeys = new HashSet<>();





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inventaire_aff.setOnKeyPressed(this::onKeyPressed);
    }

    private void onKeyPressed(KeyEvent event) {
        pressedKeys.add(event.getCode().toString());
        handlekeypressed();
    }

    private void handlekeypressed() {
        boolean movingUp = pressedKeys.contains("UP");
        boolean quitter = pressedKeys.contains("P");
        System.out.println("citron");

        if (quitter) {
            pressedKeys.remove("P");
            reprendre();
        }
    }


    public void reprendre(){
        System.out.println("reprendre");
        Main.stg.setScene(Main.jeu);
        Main.stg.show();

    }
}

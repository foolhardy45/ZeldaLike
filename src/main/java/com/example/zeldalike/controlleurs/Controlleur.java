package com.example.zeldalike.controlleurs;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.Terrain;
import com.example.zeldalike.vues.TerrrainVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controlleur implements Initializable {
    Terrain T;
    private Timeline gameLoop;

    @FXML
    TilePane terrain_affichage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Terrain terrain = new Terrain();
        TerrrainVue terrrainVue = new TerrrainVue();

        terrain_affichage.getChildren().add(terrrainVue.creeMap(terrain.getMap()));
    }

    void initAnimation(){
        gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.017),(ev ->{

        })
        );
        gameLoop.getKeyFrames().add(kf);
    }
}

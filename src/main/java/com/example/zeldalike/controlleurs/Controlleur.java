package com.example.zeldalike.controlleurs;

import com.example.zeldalike.modele.Environnement;
import com.example.zeldalike.modele.Joueur;
import com.example.zeldalike.modele.Terrain;
import com.example.zeldalike.vues.JoueurVue;
import com.example.zeldalike.vues.TerrrainVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controlleur implements Initializable {

    @FXML
    TilePane terrain_affichage;
    private Terrain T;
    private JoueurVue joueurVue;
    private Joueur j;
    private Environnement env;
    private Timeline gameLoop;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.env = new Environnement(240,320);
        Terrain terrain = new Terrain();
        TerrrainVue terrrainVue = new TerrrainVue();
        j = this.env.getJ1();


        terrain_affichage.getChildren().add(terrrainVue.creeMap(terrain.getMap()));
        initAnimation();
        gameLoop.play();
        joueurVue = new JoueurVue(this.env.getJ1());
        this.terrain_affichage.getChildren().add(joueurVue.getR());


    }
    @FXML
    public void touchePressed(KeyEvent touche){
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

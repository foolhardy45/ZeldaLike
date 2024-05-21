package com.example.zeldalike.controlleurs;

import com.example.zeldalike.modele.*;
import com.example.zeldalike.vues.JoueurVue;
import com.example.zeldalike.vues.TerrrainVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controlleur implements Initializable {

    @FXML
    private TilePane terrain_affichage;
    @FXML
    private Pane carte_interaction;



    private JoueurVue joueurVue;
    private Environnement env;
    private Timeline gameLoop;
    private int temps_gameloop;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.env = new Environnement(832, 768);
        TerrrainVue terrrainVue = new TerrrainVue(terrain_affichage, this.env.getTerrain());
        terrain_affichage.setOnKeyPressed(this::onKeyPressed);
        terrain_affichage.setFocusTraversable(true);
        terrrainVue.creeMap();
        joueurVue = new JoueurVue(this.env.getJ1());

         carte_interaction.getChildren().add(joueurVue.getMac());

         //AJOUT DU CITRON DANS LE JEU
        MonObservateurEnnemis observateurlisteennemi = new MonObservateurEnnemis(carte_interaction);
        this.env.getEnnemis().addListener(observateurlisteennemi);
        Citron ennemipuissant = new Citron(new Position(320,320), this.env);
        this.env.ajouterEnnemis(ennemipuissant);



        terrain_affichage.requestFocus();

        initAnimation();
        gameLoop.play();
    }

    private void onKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
                this.env.getJ1().moveUp();
                break;
            case DOWN:
                this.env.getJ1().moveDown();
                break;
            case LEFT:
                this.env.getJ1().moveLeft();
                break;
            case RIGHT:
                this.env.getJ1().moveRight();
                break;
            default:
                break;
        }
    }

    void initAnimation() {
        gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        temps_gameloop = 0;

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.017),
                (ev -> {
                //drawGame();
                    //TEST BOUGER CITRON
                if (temps_gameloop%100 == 0){
                    System.out.println("temps+100");


                } else if (temps_gameloop%5 == 0) {
                    Random a = new Random();
                    for (Ennemis ennemi : this.env.getEnnemis()){
                        if (a.nextInt()< 500){
                            System.out.println("NEW KITCHEN GUN");
                            ennemi.moveLeft();
                        }
                    }
                }
                temps_gameloop++;


                })
        );
        gameLoop.getKeyFrames().add(kf);
    }



    /*private void drawGame() {
        joueurVue.update();
    }*/


}
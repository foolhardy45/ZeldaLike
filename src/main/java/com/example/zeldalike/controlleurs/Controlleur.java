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
import java.util.HashSet;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;

public class Controlleur implements Initializable {

    @FXML
    private TilePane terrain_affichage;
    @FXML
    private Pane carte_interaction;


    private long lastTime;
    private JoueurVue joueurVue;
    private Environnement env;
    private Timeline gameLoop;
    private int temps_gameloop;
    private final Set<String> pressedKeys = new HashSet<>();




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.env = new Environnement(832, 768);
        TerrrainVue terrrainVue = new TerrrainVue(terrain_affichage, this.env.getTerrain());
        terrain_affichage.setOnKeyPressed(this::onKeyPressed);
        terrain_affichage.setOnKeyReleased(this::onKeyReleased);
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
        pressedKeys.add(event.getCode().toString());
        System.out.println("je suis dans onKeyPressed");
        handleMovement();

    }

    private void onKeyReleased(KeyEvent event) {
        pressedKeys.remove(event.getCode().toString());
        System.out.println("je suis dans onKeyReleased");
        this.env.getJ1().ajouterDirection(5);

        //handleMovement();
    }

    private void handleMovement() {
        boolean movingUp = pressedKeys.contains("UP");
        boolean movingDown = pressedKeys.contains("DOWN");
        boolean movingLeft = pressedKeys.contains("LEFT");
        boolean movingRight = pressedKeys.contains("RIGHT");

        if (movingRight && movingLeft ||movingDown && movingUp){
            this.env.getJ1().ajouterDirection(5);
        } else if (movingUp && movingRight) {
            this.env.getJ1().ajouterDirection(9);
        } else if (movingUp && movingLeft) {
            this.env.getJ1().ajouterDirection(7);
        }  else if (movingDown && movingLeft) {
            this.env.getJ1().ajouterDirection(1);
        } else if (movingDown && movingRight) {
            this.env.getJ1().ajouterDirection(3);
        } else if (movingUp){
            this.env.getJ1().ajouterDirection(8);
        } else if (movingRight) {
            this.env.getJ1().ajouterDirection(6);
        } else if (movingDown) {
            this.env.getJ1().ajouterDirection(2);
        } else if (movingLeft) {
            this.env.getJ1().ajouterDirection(4);
        }



        /*if (movingUp) {
            System.out.println("haut");
            this.env.getJ1().moveUp(deltaTime);
        }
        if (movingDown) {
            System.out.println("bas");
            this.env.getJ1().moveDown(deltaTime);
        }
        if (movingLeft) {
            System.out.println("gauche");
            this.env.getJ1().moveLeft(deltaTime);
        }
        if (movingRight) {
            System.out.println("droite");
            this.env.getJ1().moveRight(deltaTime);
        }*/


    }

    private void initAnimation() {
        gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        temps_gameloop = 0;
        lastTime = System.currentTimeMillis();

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.017),
                ev -> {
                    long currentTime = System.currentTimeMillis();
                    long deltaTime = currentTime - lastTime;
                    lastTime = currentTime;

                    //handleMovement(deltaTime);

                    this.env.unTour();


                    //TEST BOUGER CITRON
                    for (Ennemis ennemi : this.env.getEnnemis()) {
                       //ennemi.deplacementAleatoire(deltaTime);
                    }
                    temps_gameloop++;

                }
        );

        gameLoop.getKeyFrames().add(kf);
    }



    /*private void drawGame() {
        joueurVue.update();
    }*/


}
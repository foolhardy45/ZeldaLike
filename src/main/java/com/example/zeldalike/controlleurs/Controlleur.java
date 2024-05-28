package com.example.zeldalike.controlleurs;

import com.example.zeldalike.modele.*;
import com.example.zeldalike.vues.JoueurVue;
import com.example.zeldalike.vues.TerrrainVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

import javafx.util.Duration;

import java.net.URL;
import java.util.HashSet;

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

         this.env.getJ1().directionProperty().addListener(((observable, oldValue, newValue) -> {
             switch ((int) newValue){
                 case 8:
                     this.joueurVue.getMac().setImage(this.joueurVue.getSpriteUp());
                     break;
                 case 2:
                     this.joueurVue.getMac().setImage(this.joueurVue.getSpriteDown());
                     break;
                 case 4:
                     this.joueurVue.getMac().setImage(this.joueurVue.getSpriteLeft());
                     break;
                 case 6:
                     this.joueurVue.getMac().setImage(this.joueurVue.getSpriteRight());
                     break;
             }
         }));


        MonObservateurEnnemis observateurlisteennemi = new MonObservateurEnnemis(carte_interaction);
        this.env.getEnnemis().addListener(observateurlisteennemi);
        Citron ennemipuissant = new Citron(new Position(320,320), this.env);
        this.env.ajouterEnnemis(ennemipuissant);

        this.env.getJ1().getSac().ajoutInventaire(new PotionVitale(new Position(5,5)));
        this.env.getJ1().getSac().ajoutInventaire(new PotionVitale(new Position(5,5)));

        System.out.println(this.env.getJ1().getSac().toString());



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
        handleMovement();

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
                    lastTime = currentTime;

                    handleMovement();

                    this.env.unTour();

                    //TEST BOUGER CITRON
                    /*for (Ennemis ennemi : this.env.getEnnemis()) {
                       //ennemi.deplacementAleatoire(deltaTime);
                    }*/
                    temps_gameloop++;

                }
        );

        gameLoop.getKeyFrames().add(kf);
    }
}
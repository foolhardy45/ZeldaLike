package com.example.zeldalike.controlleurs;

import com.example.zeldalike.modele.*;
import com.example.zeldalike.Main;
import com.example.zeldalike.modele.*;
import com.example.zeldalike.vues.InventaireVue;
import com.example.zeldalike.vues.JoueurVue;
import com.example.zeldalike.vues.TerrrainVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import static com.example.zeldalike.Main.main;
import static com.example.zeldalike.Main.stg;

public class Controlleur implements Initializable {

    private final Set<String> pressedKeys = new HashSet<>();
    @FXML
    private HBox info_joueur;
    @FXML
    private HBox coeurBox;
    @FXML
    private Label nbArgent;
    @FXML
    private TilePane terrain_affichage;

    @FXML
    private TilePane inventairepane;
    @FXML
    private TilePane inventaireobjets;
    private InventaireVue inv;

    @FXML
    private Pane carte_interaction;
    private long lastTime;
    private JoueurVue joueurVue;
    private Environnement env;
    private Timeline gameLoop;
    private int temps_gameloop;
    private boolean cooldown = true;
    private boolean inventaire_ouvert = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.env = new Environnement(2048, 4096);
        TerrrainVue terrrainVue = new TerrrainVue(terrain_affichage, this.env.getTerrain(), this.env.getJ1());
        terrain_affichage.setOnKeyPressed(this::onKeyPressed);
        terrain_affichage.setOnKeyReleased(this::onKeyReleased);
        terrain_affichage.setFocusTraversable(true);
        terrrainVue.creeMap();
        joueurVue = new JoueurVue(this.env.getJ1(), this.env.getJ1().getArme());

        coeurBox.getChildren().add(joueurVue.getCoeurN1());
        coeurBox.getChildren().add(joueurVue.getCoeurN2());
        coeurBox.getChildren().add(joueurVue.getCoeurN3());

        // Lier la propriété argent avec le texte du Label
        nbArgent.textProperty().bind(env.getJ1().argentProperty().asString());

        carte_interaction.getChildren().add(joueurVue.getMac());
        carte_interaction.getChildren().add(joueurVue.getArmeView());

        this.env.getJ1().directionProperty().addListener(((observable, oldValue, newValue) -> {
            switch ((int) newValue) {
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
        Citron ennemipuissant = new Citron(new Position(320, 320), this.env);
        this.env.ajouterEnnemis(ennemipuissant);
        BusinessMan man = new BusinessMan(new Position(640,640), this.env);
        this.env.ajouterEnnemis(man);
        MonObservateurObjet observateurlisteobjet = new MonObservateurObjet(carte_interaction);
        this.env.getObjet().addListener(observateurlisteobjet);
        Position PP1 = new Position(310, 310);
        PotionVitale p1 = new PotionVitale(PP1);
        this.env.ajouterObjet(p1);
        this.env.ajouterObjet(new PotionVitale(new Position(510, 510)));

        //this.env.getJ1().getSac().ajoutInventaire(new PotionVitale(new Position(5, 5)));
        //this.env.getJ1().getSac().ajoutInventaire(new PotionVitale(new Position(5, 5)));
        this.env.getJ1().getSac().ajoutInventaire(new Cle(new Position(0,0)));
        //this.inventairepane.setVisible(false);
        this.inv = new InventaireVue(inventairepane, inventaireobjets, env.getJ1().getSac());


        System.out.println(this.env.getJ1().getSac().toString());


        terrain_affichage.requestFocus();

        initAnimation();
        gameLoop.play();
    }

    private void onKeyPressed(KeyEvent event) {
        pressedKeys.add(event.getCode().toString());
        handleMovement();
    }

    private void onKeyReleased(KeyEvent event) {
        pressedKeys.remove(event.getCode().toString());
        this.env.getJ1().ajouterDirection(5);
        handleMovement();
    }


    private void handleMovement() {
        boolean movingUp = pressedKeys.contains("UP");
        boolean movingDown = pressedKeys.contains("DOWN");
        boolean movingLeft = pressedKeys.contains("LEFT");
        boolean movingRight = pressedKeys.contains("RIGHT");
        boolean interact = pressedKeys.contains("E");
        boolean attaque = pressedKeys.contains("X");
        boolean inventaire = pressedKeys.contains("A");

        if (this.env.getJ1().isFaitUnAttaque()) {
        }
        if (movingRight && movingLeft || movingDown && movingUp) {
            this.env.getJ1().ajouterDirection(5);
        } else if (movingUp && movingRight) {
            this.env.getJ1().ajouterDirection(9);
        } else if (movingUp && movingLeft) {
            this.env.getJ1().ajouterDirection(7);
        } else if (movingDown && movingLeft) {
            this.env.getJ1().ajouterDirection(1);
        } else if (movingDown && movingRight) {
            this.env.getJ1().ajouterDirection(3);
        } else if (movingUp) {
            this.env.getJ1().ajouterDirection(8);
        } else if (movingRight) {
            this.env.getJ1().ajouterDirection(6);
        } else if (movingDown) {
            this.env.getJ1().ajouterDirection(2);
        } else if (movingLeft) {
            this.env.getJ1().ajouterDirection(4);
        }
        if (attaque && cooldown) {
            this.env.getJ1().ajouterDirection(5);
            this.joueurVue.afficherArmeView();
            this.env.getJ1().attaquer();
            cooldown = false;
        } else if (interact) {
            this.env.getJ1().setInteraction(true);
        } else if (inventaire) {
            pressedKeys.remove("A");
            //lanceMenuPause();
            inventaire_ouvert = this.inv.ouvrirInventaire();
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

                    if (!inventaire_ouvert){
                        this.env.unTour();

                        if (this.joueurVue.isVisible()) {
                            if (temps_gameloop % 30 == 0) {
                                this.joueurVue.getArmeView().setVisible(false);
                                cooldown = true;
                            }
                        }
                    if (this.joueurVue.isVisible()) { // Si le joueur fait une attaque alors pendant qu"elle que seconde l'arme s'affichera
                        if (temps_gameloop % 30 == 0) {
                            this.joueurVue.getArmeView().setVisible(false);
                            cooldown = true;
                        }
                    }
                    }
                    temps_gameloop++;
                }
        );

        gameLoop.getKeyFrames().add(kf);
    }
}

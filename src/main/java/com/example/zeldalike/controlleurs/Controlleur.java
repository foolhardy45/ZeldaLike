package com.example.zeldalike.controlleurs;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.Citron;
import com.example.zeldalike.modele.Environnement;
import com.example.zeldalike.modele.Position;
import com.example.zeldalike.modele.PotionVitale;
import com.example.zeldalike.vues.JoueurVue;
import com.example.zeldalike.vues.TerrrainVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
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
    private TilePane terrain_affichage;
    @FXML
    private Pane carte_interaction;
    private long lastTime;
    private JoueurVue joueurVue;
    private Environnement env;
    private Timeline gameLoop;
    private int temps_gameloop;
    private boolean cooldown = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.env = new Environnement(832, 768);
        TerrrainVue terrrainVue = new TerrrainVue(terrain_affichage, this.env.getTerrain());
        terrain_affichage.setOnKeyPressed(this::onKeyPressed);
        terrain_affichage.setOnKeyReleased(this::onKeyReleased);
        terrain_affichage.setFocusTraversable(true);
        terrrainVue.creeMap();
        joueurVue = new JoueurVue(this.env.getJ1(), this.env.getJ1().getArme());

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
        MonObservateurObjet observateurlisteobjet = new MonObservateurObjet(carte_interaction);
        this.env.getObjet().addListener(observateurlisteobjet);
        Position PP1 = new Position(310, 310);
        PotionVitale p1 = new PotionVitale(PP1);
        this.env.ajouterObjet(p1);

        this.env.getJ1().getSac().ajoutInventaire(new PotionVitale(new Position(5, 5)));
        this.env.getJ1().getSac().ajoutInventaire(new PotionVitale(new Position(5, 5)));

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
            this.joueurVue.afficherArmeView();
            this.env.getJ1().attaquer();
            cooldown = false;
        } else if (interact) {
            this.env.getJ1().setInteraction(true);
        } else if (inventaire){
            pressedKeys.remove("A");
            lanceMenuPause();
        }

    }

    private void lanceMenuPause(){
        System.out.println("menu pause");
        Main.stg.setScene(Main.pause);
        Main.stg.show();
        /*while (!Main.stg.getScene().equals(Main.jeu)) {
            try {
                Main.stg.getOwner().wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
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
                    lastTime = currentTime;

                    this.env.unTour();

                    if (this.joueurVue.isVisible()) {
                        if (temps_gameloop % 30 == 0) {
                            this.joueurVue.getArmeView().setVisible(false);
                            cooldown = true;
                        }
                    }
                    temps_gameloop++;
                }
        );

        gameLoop.getKeyFrames().add(kf);
    }
}

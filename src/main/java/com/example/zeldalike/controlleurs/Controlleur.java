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
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controlleur implements Initializable {

    @FXML
    private TilePane terrain_affichage;
    @FXML
    private Pane carte_interaction;



    private JoueurVue joueurVue;
    private Environnement env;
    private Timeline gameLoop;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.env = new Environnement(832, 768);
        Terrain terrain = new Terrain();
        TerrrainVue terrrainVue = new TerrrainVue();
        terrain_affichage.setOnKeyPressed(this::onKeyPressed);
        terrain_affichage.setFocusTraversable(true);

        joueurVue = new JoueurVue(this.env.getJ1());

        terrain_affichage.getChildren().add(terrrainVue.creeMap(terrain.getMap()));

        //carte_interaction.getChildren().add(joueurVue.getR());
        carte_interaction.getChildren().add(joueurVue.getMac());



        terrain_affichage.requestFocus();

        initAnimation();
        gameLoop.play();
    }

    private void onKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
                System.out.println("on");
                this.joueurVue.getJ().moveUp();
                System.out.println(this.env.getJ1().getP().getX() + "" + this.env.getJ1().getP().getY());;
                break;
            case DOWN:
                this.joueurVue.getJ().moveDown();
                break;
            case LEFT:
                this.joueurVue.getJ().moveLeft();
                break;
            case RIGHT:
                this.joueurVue.getJ().moveRight();
                break;
            default:
                break;
        }
    }

    void initAnimation() {
        gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.017), (ev) -> {
            //drawGame();
            this.env.encoreSurJeu(this.env.getJ1());

        });
        gameLoop.getKeyFrames().add(kf);
    }



    /*private void drawGame() {
        joueurVue.update();
    }*/


}
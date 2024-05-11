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
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controlleur implements Initializable {

    @FXML
    TilePane terrain_affichage;
    private Terrain T;
    private Scene scene;
    private JoueurVue joueurVue;
    private Joueur j;
    private Environnement env;
    private Timeline gameLoop;
    private Stage stage;





    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.env = new Environnement(320,420);
        Terrain terrain = new Terrain();
        TerrrainVue terrrainVue = new TerrrainVue();
        terrain_affichage.setOnKeyPressed(this::onKeyPresse);
        terrain_affichage.setFocusTraversable(true);

        joueurVue = new JoueurVue(this.env.getJ1(),terrain_affichage);
        joueurVue.ajouterAuTilePane();
        j = this.env.getJ1();

        terrain_affichage.getChildren().add(terrrainVue.creeMap(terrain.getMap()));

        initAnimation();
        gameLoop.play();
    }

    private void onKeyPresse(KeyEvent event){
        switch(event.getCode()){
            case UP:
                System.out.println("on");
                j.moveUp();
                break;
            case DOWN:
                j.moveDown();
                break;
            case LEFT:
                j.moveLeft();
                break;
            case RIGHT:
                j.moveRight();
                break;
            default:
                break;
        }
    }



    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void  setScene (Scene scene){
        this.scene = scene;
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

    private void updateGame(){
        //this.onKeyPresse();
    }

    private void drawGame(){
        //joueurVue.update;
    }
}

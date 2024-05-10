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
import javafx.scene.input.KeyCode;
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
        this.env = new Environnement(600,600);
        Terrain terrain = new Terrain();
        TerrrainVue terrrainVue = new TerrrainVue();
        joueurVue = new JoueurVue(this.env.getJ1());
        j = this.env.getJ1();


        terrain_affichage.getChildren().add(terrrainVue.creeMap(terrain.getMap()));
        initAnimation();
        gameLoop.play();
        this.terrain_affichage.getChildren().add(joueurVue.getR());

    }

    public void moveUp(){
        System.out.println("move up");

    }
    public void moveDown(){
        System.out.println("move Down");
        this.joueurVue.getR().relocate(this.joueurVue.getR().getLayoutX(),this.joueurVue.getR().getLayoutY()+5);
    }
    public void moveLeft(){
        System.out.println("move Left");
        this.joueurVue.getR().relocate(this.joueurVue.getR().getLayoutX()-5,this.joueurVue.getR().getLayoutY());
    }
    public void moveRight(){
        System.out.println("move Right");
        this.joueurVue.getR().relocate(this.joueurVue.getR().getLayoutX()+5,this.joueurVue.getR().getLayoutY());
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

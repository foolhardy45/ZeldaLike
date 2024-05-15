package com.example.zeldalike.vues;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.Terrain;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class TerrrainVue {
    private  TilePane affichage;
    private Terrain terrrain;

    public TerrrainVue(TilePane affichage, Terrain terrrain) {
        this.affichage = affichage;
        this.terrrain = terrrain;
    }

    public void creeMap() {


        Image eau = new Image(String.valueOf(Main.class.getResource("images/eau.png")));
        Image trou = new Image(String.valueOf(Main.class.getResource("images/trou.png")));
        Image terre = new Image(String.valueOf(Main.class.getResource("images/terre.png")));
        this.affichage.setPrefColumns(24); //TAILLE DU TERRAIN EN LARGEUR
        for (int i = 0; i < this.terrrain.tailleTerrain(); i++) {
            switch (this.terrrain.codeCaseI(i)){

                case 1: affichage.getChildren().add(new ImageView(eau));
                break;

                case 2: affichage.getChildren().add(new ImageView(terre));
                break;

                case 3: affichage.getChildren().add(new ImageView(trou));
                break;
            }
        }

    }
}


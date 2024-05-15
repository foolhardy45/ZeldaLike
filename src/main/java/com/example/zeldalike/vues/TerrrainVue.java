package com.example.zeldalike.vues;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.Terrain;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class TerrrainVue {
    private final TilePane map;
    private Terrain terrrain; // TODO terminer

    public TerrrainVue(TilePane map) {
        this.map = map;
    }

    public void creeMap(int[] tab) {


        Image eau = new Image(String.valueOf(Main.class.getResource("images/eau.png")));
        Image trou = new Image(String.valueOf(Main.class.getResource("images/trou.png")));
        Image terre = new Image(String.valueOf(Main.class.getResource("images/terre.png")));
        this.map.setPrefColumns(24); //TAILLE DU TERRAIN EN LARGEUR
        for (int i = 0; i < tab.length; i++) {
            switch (tab[i]){

                case 1: map.getChildren().add(new ImageView(eau));
                break;

                case 2: map.getChildren().add(new ImageView(terre));
                break;

                case 3: map.getChildren().add(new ImageView(trou));
                break;
            }
        }

    }
}


package com.example.zeldalike.vues;

import com.example.zeldalike.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.util.Random;

public class TerrrainVue {
    private final TilePane map;

    public TerrrainVue() {
        this.map = new TilePane();
    }

    public TilePane creeMap(int[] tab) {


        Image eau = new Image(String.valueOf(Main.class.getResource("images/eau2.png")));
        Image trou = new Image(String.valueOf(Main.class.getResource("images/trou2.png")));
        Image terre = new Image(String.valueOf(Main.class.getResource("images/terre2.png")));
        Image eau2 = new Image(String.valueOf(Main.class.getResource("images/eau3.png")));
        Image terre2 = new Image(String.valueOf(Main.class.getResource("images/terre3.png")));
        Random random = new Random(67890);
        int diftuiles;
        this.map.setPrefColumns(24); //TAILLE DU TERRAIN EN LARGEUR
        for (int i = 0; i < tab.length; i++) {
            diftuiles = random.nextInt();
            switch (tab[i]){

                case 1:if (diftuiles < 4096) {
                    map.getChildren().add(new ImageView(eau));
                    } else {
                    map.getChildren().add(new ImageView(eau2));
                    }
                break;

                case 2: if (diftuiles < 4096) {
                    map.getChildren().add(new ImageView(terre));
                } else {
                    map.getChildren().add(new ImageView(terre2));
                }
                break;

                case 3: map.getChildren().add(new ImageView(trou));
                break;
            }
        }

        return map;
    }
}


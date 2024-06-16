package com.example.zeldalike.vues;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.Joueur;
import com.example.zeldalike.modele.Terrain;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

import java.util.Random;

public class TerrrainVue {
    private final TilePane affichage;
    private final Pane affichageElement;
    private final Terrain terrrain;

    public TerrrainVue(TilePane affichage, Pane affichageElement, Terrain terrrain, Joueur mac) {
        this.affichage = affichage;
        this.affichageElement = affichageElement;
        this.terrrain = terrrain;

        final int zoneTemp = 32;
        final int decalageX = 2048;
        final int decalageY = 1224;

        mac.getP().xProperty().addListener((obs, old, n) -> {
            if ((int) n % decalageX > decalageX - zoneTemp) {
                affichageElement.setTranslateX(affichageElement.getTranslateX() - decalageX);
                mac.getP().setX(mac.getP().getX() + 2 * zoneTemp);
            } else if ((int) n > decalageX && (int) n % decalageX < zoneTemp) {
                affichageElement.setTranslateX(affichageElement.getTranslateX() + decalageX);
                mac.getP().setX(mac.getP().getX() - 2 * zoneTemp);
            }
        });
        mac.getP().yProperty().addListener((obs, old, n) -> {
            if ((int) n % decalageY > decalageY - 5) {
                affichageElement.setTranslateY(affichageElement.getTranslateY() - decalageY);
                mac.getP().setY(mac.getP().getY() + 2 * zoneTemp);
            } else if ((int) n > decalageY && (int) n % decalageY < 5) {
                affichageElement.setTranslateY(affichageElement.getTranslateY() + decalageY);
                mac.getP().setY(mac.getP().getY() - 2 * zoneTemp);
            }
        });
    }

    public void creeMap() {


        Image eau = new Image(String.valueOf(Main.class.getResource("images/terrain/eau2.png")));
        Image trou = new Image(String.valueOf(Main.class.getResource("images/terrain/trou2.png")));
        Image terre = new Image(String.valueOf(Main.class.getResource("images/terrain/terre2.png")));
        Image eau2 = new Image(String.valueOf(Main.class.getResource("images/terrain/eau3.png")));
        Image terre2 = new Image(String.valueOf(Main.class.getResource("images/terrain/terre3.png")));
        Random random = new Random(67890);
        this.affichage.setPrefColumns(this.terrrain.getTailleLargeur());
        int diftuiles;
        for (int i = 0; i < this.terrrain.tailleTerrain(); i++) {
            diftuiles = random.nextInt();
            switch (this.terrrain.codeCaseI(i)) {
                case 1:
                    if (diftuiles < 4096) {
                        affichage.getChildren().add(new ImageView(eau));
                    } else {
                        affichage.getChildren().add(new ImageView(eau2));
                    }
                    break;

                case 2:
                    if (diftuiles < 4096) {
                        affichage.getChildren().add(new ImageView(terre));
                    } else {
                        affichage.getChildren().add(new ImageView(terre2));
                    }
                    break;

                case 3:
                    affichage.getChildren().add(new ImageView(trou));
                    break;
            }
        }

    }

}


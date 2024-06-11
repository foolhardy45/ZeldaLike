package com.example.zeldalike.vues;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.Joueur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CoeurVue {
    private final ImageView coeurN1;
    private final ImageView coeurN2;
    private final ImageView coeurN3;

    private final Image coeur0;
    private final Image coeur1;
    private final Image coeur2;
    private final Image coeur3;
    private final Image coeur4;

    private final Joueur joueur;

    public CoeurVue(Joueur joueur){
        this.joueur = joueur;

        coeur0 = new Image(String.valueOf(Main.class.getResource("images/coeurs/coeur0.png")));
        coeur1 = new Image(String.valueOf(Main.class.getResource("images/coeurs/coeur1.png")));
        coeur2 = new Image(String.valueOf(Main.class.getResource("images/coeurs/coeur2.png")));
        coeur3 = new Image(String.valueOf(Main.class.getResource("images/coeurs/coeur3.png")));
        coeur4 = new Image(String.valueOf(Main.class.getResource("images/coeurs/coeur4.png")));

        coeurN1 = new ImageView();
        coeurN2 = new ImageView(coeur4);
        coeurN3 = new ImageView(coeur4);

        joueur.hpProperty().addListener((observable, oldValue, newValue) -> updateHeartImage());
        updateHeartImage();
    }

    private void updateHeartImage() {
        int hp = joueur.getHp();
        switch (hp) {
            case 12 -> {
                coeurN1.setImage(coeur4);
                coeurN2.setImage(coeur4);
                coeurN3.setImage(coeur4);
            }
            case 11 -> {
                coeurN1.setImage(coeur4);
                coeurN2.setImage(coeur4);
                coeurN3.setImage(coeur3);
            }
            case 10 -> {
                coeurN1.setImage(coeur4);
                coeurN2.setImage(coeur4);
                coeurN3.setImage(coeur2);
            }
            case 9 -> {
                coeurN1.setImage(coeur4);
                coeurN2.setImage(coeur4);
                coeurN3.setImage(coeur1);
            }
            case 8 -> {
                coeurN1.setImage(coeur4);
                coeurN2.setImage(coeur4);
                coeurN3.setImage(coeur0);
            }
            case 7 -> {
                coeurN1.setImage(coeur4);
                coeurN2.setImage(coeur3);
                coeurN3.setImage(coeur0);
            }
            case 6 -> {
                coeurN1.setImage(coeur4);
                coeurN2.setImage(coeur2);
                coeurN3.setImage(coeur0);
            }
            case 5 -> {
                coeurN1.setImage(coeur4);
                coeurN2.setImage(coeur1);
                coeurN3.setImage(coeur0);
            }
            case 4 -> {
                coeurN1.setImage(coeur4);
                coeurN2.setImage(coeur0);
                coeurN3.setImage(coeur0);
            }
            case 3 -> {
                coeurN1.setImage(coeur3);
                coeurN2.setImage(coeur0);
                coeurN3.setImage(coeur0);
            }
            case 2 -> {
                coeurN1.setImage(coeur2);
                coeurN2.setImage(coeur0);
                coeurN3.setImage(coeur0);
            }
            case 1 -> {
                coeurN1.setImage(coeur1);
                coeurN2.setImage(coeur0);
                coeurN3.setImage(coeur0);
            }
            case 0 -> {
                coeurN1.setImage(coeur0);
                coeurN2.setImage(coeur0);
                coeurN3.setImage(coeur0);
            }
        }
    }

    public ImageView getCoeurN1() {
        return coeurN1;
    }

    public ImageView getCoeurN2() {
        return coeurN2;
    }

    public ImageView getCoeurN3() {
        return coeurN3;
    }
}

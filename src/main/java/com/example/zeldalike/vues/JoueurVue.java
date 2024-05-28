package com.example.zeldalike.vues;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.Joueur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.TilePane;

import javax.swing.*;

public class JoueurVue extends JPanel {
    private Joueur j;
    private Circle r;
    private ImageView mac;
    private Image spriteUp;
    private Image spriteDown;
    private Image spriteLeft;
    private Image spriteRight;



    public JoueurVue(Joueur j) {
        this.j = j;
        //this.r = new Circle(6);
        //r.setFill(Color.RED);
        //r.translateXProperty().bind(j.getP().xProperty());
        //r.translateYProperty().bind(j.getP().yProperty());
        spriteUp = new Image(String.valueOf(Main.class.getResource("images/gressif_haut.png")));
        spriteDown = new Image(String.valueOf(Main.class.getResource("images/gressif_bas.png")));
        spriteLeft = new Image(String.valueOf(Main.class.getResource("images/gressif_gauche.png")));
        spriteRight = new Image(String.valueOf(Main.class.getResource("images/gressif_droite.png")));


        Image gressif_neutral = new Image(String.valueOf(Main.class.getResource("images/gressif_bas.png")));
        this.mac = new ImageView(gressif_neutral);

        mac.translateXProperty().bind(j.getP().xProperty());
        mac.translateYProperty().bind(j.getP().yProperty());


        System.out.println("cercle et joueur créer");
    }

    // Méthode pour mettre à jour le sprite en fonction de la direction
    public void updateSprite(int direction) {
        switch (direction) {
            case 8:
                mac.setImage(spriteUp);
                break;
            case 2:
                mac.setImage(spriteDown);
                break;
            case 4:
                mac.setImage(spriteLeft);
                break;
            case 6:
                mac.setImage(spriteRight);
                break;
        }
    }

    /*public Circle getR() {
        return r;
    }*/

    public ImageView getMac() {
        return mac;
    }

    public ImageView setMac(ImageView mac) {
        this.mac = mac;
        return mac;
    }

}
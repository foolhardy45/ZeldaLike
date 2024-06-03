package com.example.zeldalike.vues;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.Arme;
import com.example.zeldalike.modele.Joueur;
import com.example.zeldalike.modele.Poing;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;

public class JoueurVue extends JPanel {
    private boolean visible;
    private final Joueur j;
    private final Arme a;
    private final ImageView mac;
    private ImageView armeView;
    private final Image spriteUp;
    private final Image spriteDown;
    private final Image spriteLeft;
    private final Image spriteRight;
    private final Image poing;


    public JoueurVue(Joueur j, Arme a) {
        this.j = j;
        this.a = a;
        this.visible = true;
        //sprite du joueur
        spriteUp = new Image(String.valueOf(Main.class.getResource("images/gressif_haut.png")));
        spriteDown = new Image(String.valueOf(Main.class.getResource("images/gressif_bas.png")));
        spriteLeft = new Image(String.valueOf(Main.class.getResource("images/gressif_gauche.png")));
        spriteRight = new Image(String.valueOf(Main.class.getResource("images/gressif_droite.png")));

        //sprite des armes
        poing = new Image(String.valueOf(Main.class.getResource("images/poinGressif.png")));

        //Image par defaut du joueur
        Image gressif_neutral = new Image(String.valueOf(Main.class.getResource("images/gressif_bas.png")));

        this.armeView = new ImageView();
        this.mac = new ImageView(gressif_neutral);

        //armeView.setVisible(true);

        //position du joueur
        mac.translateXProperty().bind(j.getP().xProperty());
        mac.translateYProperty().bind(j.getP().yProperty());
        armeView.translateXProperty().bind(mac.translateXProperty());
        armeView.translateYProperty().bind(mac.translateYProperty());

    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    public void afficherArmeView() {
        if (this.j.getArme() instanceof Poing) {
           this.armeView.setImage(poing);
        }
        armeView.setVisible(true);

    }


    public Image getSpriteUp() {
        return spriteUp;
    }

    public Image getSpriteDown() {
        return spriteDown;
    }

    public Image getSpriteLeft() {
        return spriteLeft;
    }

    public Image getSpriteRight() {
        return spriteRight;
    }

    public ImageView getMac() {
        return mac;
    }

    public ImageView getArmeView() {
        return armeView;
    }

}
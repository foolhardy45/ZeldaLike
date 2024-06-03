package com.example.zeldalike.vues;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.Arme;
import com.example.zeldalike.modele.Joueur;
import com.example.zeldalike.modele.Poing;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;

public class JoueurVue extends JPanel {
    private Joueur j;
    private Arme a;
    private ImageView mac;
    private ImageView armeView;
    private Image spriteUp;
    private Image spriteDown;
    private Image spriteLeft;
    private Image spriteRight;
    private Image poing;



    public JoueurVue(Joueur j, Arme a) {
        this.j = j;
        this.a = a;
        //sprite du joueur
        spriteUp = new Image(String.valueOf(Main.class.getResource("images/gressif_haut.png")));
        spriteDown = new Image(String.valueOf(Main.class.getResource("images/gressif_bas.png")));
        spriteLeft = new Image(String.valueOf(Main.class.getResource("images/gressif_gauche.png")));
        spriteRight = new Image(String.valueOf(Main.class.getResource("images/gressif_droite.png")));

        //sprite des armes
        poing = new Image(String.valueOf(Main.class.getResource("images/poinGressif.png")));

        //Image par defaut du joueur
        Image gressif_neutral = new Image(String.valueOf(Main.class.getResource("images/gressif_bas.png")));

        //Image par defaut de l'arme



        this.mac = new ImageView(gressif_neutral);
        this.armeView = new ImageView();
        //armeView.setVisible(false);

        //position du joueur
        mac.translateXProperty().bind(j.getP().xProperty());
        mac.translateYProperty().bind(j.getP().yProperty());

    }

    public void afficherArmeView(){
        if (this.j.getArme() == null) {
            System.out.println("tu n'a pas d'arme");

        }else {
            if (this.j.getArme() instanceof Poing) {
                armeView = new ImageView(poing);
            }
            armeView.setVisible(true);
            armeView.setX(this.j.getP().getX());
            armeView.setY(this.j.getP().getY());

            }

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

    public ImageView setMac(ImageView mac) {
        this.mac = mac;
        return mac;
    }

    public ImageView getArmeView(){
        return armeView;
    }

}
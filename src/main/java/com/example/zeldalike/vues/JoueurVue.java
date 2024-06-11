package com.example.zeldalike.vues;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.Arme.Arme;
import com.example.zeldalike.modele.Joueur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;

public class JoueurVue extends JPanel {
    private boolean visible;
    private final Joueur joueur;
    private final Arme arme;
    private final ImageView mac;

    // Sprite joueur sans arme
    private final Image spriteUp;
    private final Image spriteDown;
    private final Image spriteLeft;
    private final Image spriteRight;

    //Sprite avec arme
    private Image spriteGunUp;
    private Image spriteGunDown;
    private Image spriteGunLeft;
    private Image spriteGunRight;

    private final CoeurVue coeurVue;
    private final ArmeVue armeView;

    public JoueurVue(Joueur joueur, Arme arme) {
        this.joueur = joueur;
        this.arme = arme;
        this.visible = true;

        spriteUp = new Image(String.valueOf(Main.class.getResource("images/gressif_simple/gressif_haut.png")));
        spriteDown = new Image(String.valueOf(Main.class.getResource("images/gressif_simple/gressif_bas.png")));
        spriteLeft = new Image(String.valueOf(Main.class.getResource("images/gressif_simple/gressif_gauche.png")));
        spriteRight = new Image(String.valueOf(Main.class.getResource("images/gressif_simple/gressif_droite.png")));

        spriteGunUp = new Image(String.valueOf(Main.class.getResource("images/gressifgun/gressifGun_Haut.png")));
        spriteGunDown = new Image(String.valueOf(Main.class.getResource("images/gressifgun/GressifGun_Bas.png")));
        spriteGunLeft = new Image(String.valueOf(Main.class.getResource("images/gressifgun/gressifGun_Gauche.png")));
        spriteGunRight = new Image(String.valueOf(Main.class.getResource("images/gressifgun/GressifGun_Droite.png")));

        Image gressif_neutral = new Image(String.valueOf(Main.class.getResource("images/gressif_simple/gressif_bas.png")));

        this.mac = new ImageView(gressif_neutral);

        this.coeurVue = new CoeurVue(joueur);
        this.armeView = new ArmeVue(joueur, arme);

        mac.translateXProperty().bind(joueur.getP().xProperty());
        mac.translateYProperty().bind(joueur.getP().yProperty());
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    public void afficherArmeView() {
        armeView.afficherarmeVue(mac);
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

    public Image getSpriteGunUp() {
        return spriteGunUp;
    }

    public Image getSpriteGunDown() {
        return spriteGunDown;
    }

    public Image getSpriteGunLeft() {
        return spriteGunLeft;
    }

    public Image getSpriteGunRight() {
        return spriteGunRight;
    }

    public ImageView getMac() {
        return mac;
    }

    public ImageView getArmeView() {
        return armeView.getArmeVue();
    }

    public ImageView getCoeurN1() {
        return coeurVue.getCoeurN1();
    }

    public ImageView getCoeurN2() {
        return coeurVue.getCoeurN2();
    }

    public ImageView getCoeurN3() {
        return coeurVue.getCoeurN3();
    }
}
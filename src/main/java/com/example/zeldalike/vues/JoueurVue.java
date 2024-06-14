package com.example.zeldalike.vues;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.Arme.Arme;
import com.example.zeldalike.modele.Joueur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;

public class JoueurVue extends JPanel {
    private boolean visible;
    private final Joueur j;
    private final Arme a;
    private final ImageView mac;
    private ImageView armeView;
    private ImageView coeurN1;
    private ImageView coeurN2;
    private ImageView coeurN3;
    private final Image spriteUp;
    private final Image spriteDown;
    private final Image spriteLeft;
    private final Image spriteRight;
    private final Image poingDroit;
    private Image poingGauche;
    private Image poingHaut;
    private Image poingBas;
    private Image coeur0;
    private Image coeur1;
    private Image coeur2;
    private Image coeur3;
    private Image coeur4;
    


    public JoueurVue(Joueur j, Arme a) {
        this.j = j;
        this.a = a;
        this.visible = true;
        //sprite du joueur
        spriteUp = new Image(String.valueOf(Main.class.getResource("images/gressif_simple/gressif_haut.png")));
        spriteDown = new Image(String.valueOf(Main.class.getResource("images/gressif_simple/gressif_bas.png")));
        spriteLeft = new Image(String.valueOf(Main.class.getResource("images/gressif_simple/gressif_gauche.png")));
        spriteRight = new Image(String.valueOf(Main.class.getResource("images/gressif_simple/gressif_droite.png")));

        //sprite des armes
        poingDroit = new Image(String.valueOf(Main.class.getResource("images/gressif_simple/poinGressifDroite.png")));
        poingGauche = new Image(String.valueOf(Main.class.getResource("images/gressif_simple/poinGressifGauche.png")));
        poingHaut = new Image(String.valueOf(Main.class.getResource("images/gressif_simple/poinGressifHaut.png")));
        poingBas = new Image(String.valueOf(Main.class.getResource("images/gressif_simple/poinGressifBas.png")));

        coeur0 = new Image(String.valueOf(Main.class.getResource("images/coeurs/coeur0.png")));
        coeur1 = new Image(String.valueOf(Main.class.getResource("images/coeurs/coeur1.png")));
        coeur2 = new Image(String.valueOf(Main.class.getResource("images/coeurs/coeur2.png")));
        coeur3 = new Image(String.valueOf(Main.class.getResource("images/coeurs/coeur3.png")));
        coeur4 = new Image(String.valueOf(Main.class.getResource("images/coeurs/coeur4.png")));

        //Image par defaut du joueur
        Image gressif_neutral = new Image(String.valueOf(Main.class.getResource("images/gressif_simple/gressif_bas.png")));

        this.armeView = new ImageView();
        this.mac = new ImageView(gressif_neutral);
        this.coeurN1 = new ImageView(coeur4);
        this.coeurN2 = new ImageView(coeur4);
        this.coeurN3 = new ImageView(coeur4);

        //armeView.setVisible(true);

        //position du joueur

        j.getP().xProperty().addListener((obs,old,n)->{
            mac.setTranslateX((int)n % 4096);
        });
        j.getP().yProperty().addListener((obs,old,n)->{
            mac.setTranslateY((int)n % 2048);
        });
        j.hpProperty().addListener((observable, oldValue, newValue) -> updateHeartImage());
        updateHeartImage();


    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    public void afficherArmeView() {
        Image arme = null;
        if(this.mac.getImage().equals(spriteUp)) {
            armeView.setImage(poingHaut);
            armeView.setVisible(true);
            armeView.setX(this.j.getP().xProperty().get());
            armeView.setY(this.j.getP().yProperty().get() - 32);

        }else if(this.mac.getImage().equals(spriteDown)) {
            armeView.setImage(poingBas);
            armeView.setVisible(true);
            armeView.setX(this.j.getP().xProperty().get() );
            armeView.setY(this.j.getP().yProperty().get() + 32);
        } else if (this.mac.getImage().equals(spriteLeft)) {
            armeView.setImage(poingGauche);
            armeView.setVisible(true);
            armeView.setX(this.j.getP().xProperty().get()-32);
            armeView.setY(this.j.getP().yProperty().get() );
        } else if (this.mac.getImage().equals(spriteRight)) {
            armeView.setImage(poingDroit);
            armeView.setVisible(true);
            armeView.setX(this.j.getP().xProperty().get()+32);
            armeView.setY(this.j.getP().yProperty().get() );
        }


    }
    private void updateHeartImage() {
        int hp = j.getHp();
        switch (hp){
            case 12 ->{ coeurN1.setImage(coeur4);
                coeurN2.setImage(coeur4);
                coeurN3.setImage(coeur4);
            }
            case 11 ->{coeurN1.setImage(coeur4);
                coeurN2.setImage(coeur4);
                coeurN3.setImage(coeur3);}
            case 10 ->{coeurN1.setImage(coeur4);
                coeurN2.setImage(coeur4);
                coeurN3.setImage(coeur2);}
            case 9 ->{coeurN1.setImage(coeur4);
                coeurN2.setImage(coeur4);
                coeurN3.setImage(coeur1);}
            case 8 ->{coeurN1.setImage(coeur4);
                coeurN2.setImage(coeur4);
                coeurN3.setImage(coeur0);}
            case 7 ->{coeurN1.setImage(coeur4);
                coeurN2.setImage(coeur3);
                coeurN3.setImage(coeur0);}
            case 6 ->{ coeurN1.setImage(coeur4);
                coeurN2.setImage(coeur2);
                coeurN3.setImage(coeur0);}
            case 5 ->{ coeurN1.setImage(coeur4);
                coeurN2.setImage(coeur1);
                coeurN3.setImage(coeur0);}
            case 4 ->{coeurN1.setImage(coeur4);
                coeurN2.setImage(coeur0);
                coeurN3.setImage(coeur0);}
            case 3 ->{coeurN1.setImage(coeur3);
                coeurN2.setImage(coeur0);
                coeurN3.setImage(coeur0);}
            case 2 ->{ coeurN1.setImage(coeur2);
                coeurN2.setImage(coeur0);
                coeurN3.setImage(coeur0);}
            case 1 ->{coeurN1.setImage(coeur1);
                coeurN2.setImage(coeur0);
                coeurN3.setImage(coeur0);}
            case 0 ->{coeurN1.setImage(coeur0);
                coeurN2.setImage(coeur0);
                coeurN3.setImage(coeur0);}

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

    public ImageView getArmeView() {
        return armeView;
    }
    public ImageView getCoeurN1(){return coeurN1;}
    public ImageView getCoeurN2(){return coeurN2;}
    public ImageView getCoeurN3(){return coeurN3;}

}
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

public class JoueurVue {
    private Joueur j;
    private Circle r;
    private ImageView mac;


    public JoueurVue(Joueur j) {
        this.j = j;
        //this.r = new Circle(6);
        //r.setFill(Color.RED);
        //r.translateXProperty().bind(j.getP().xProperty());
        //r.translateYProperty().bind(j.getP().yProperty());
        Image gressif = new Image(String.valueOf(Main.class.getResource("images/gressif_mouvement0.png")));
        this.mac = new ImageView(gressif);
        mac.translateXProperty().bind(j.getP().xProperty());
        mac.translateYProperty().bind(j.getP().yProperty());


        System.out.println("cercle et joueur créer");
    }



    public Circle getR() {
        return r;
    }

    public Joueur getJ() {
        return j;
    }

    public ImageView getMac() {
        return mac;
    }

    /*public void update() {
        r.setCenterX(getJ().getP().getX());
        r.setCenterY(getJ().getP().getY());
    }*/
}
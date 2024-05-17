package com.example.zeldalike.vues;

import com.example.zeldalike.modele.Joueur;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.TilePane;

public class JoueurVue {
    private Joueur j;
    private Circle r;


    public JoueurVue(Joueur j) {
        this.j = j;
        this.r = new Circle(6);
        r.setFill(Color.RED);
        r.translateXProperty().bind(j.getP().xProperty());
        r.translateYProperty().bind(j.getP().yProperty());
        System.out.println("cercle et joueur créer");
    }



    public Circle getR() {
        return r;
    }


    /*public void update() {
        r.setCenterX(getJ().getP().getX());
        r.setCenterY(getJ().getP().getY());
    }*/
}
package com.example.zeldalike.vues;

import com.example.zeldalike.modele.Joueur;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class JoueurVue {
        private Joueur j;
        private Circle r;
        private TilePane tilePane;

        public JoueurVue(Joueur j, TilePane tilePane){
            this.j = j;
            this.r = new Circle(10);
            this.tilePane = tilePane;
            r.setFill(Color.RED);
           r.centerXProperty().bind(j.getP().xProperty());
           r.centerYProperty().bind(j.getP().yProperty());
            System.out.println("cercle et joueur créer");
        }
    public void ajouterAuTilePane() {
        tilePane.getChildren().add(r);
    }

    public Circle getR() {
        return r;
    }

    public Joueur getJ() {
        return j;
    }

}

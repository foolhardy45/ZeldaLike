package com.example.zeldalike.vues;

import com.example.zeldalike.modele.Joueur;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class JoueurVue {
        private Joueur j;
        private Circle r;

        public JoueurVue(Joueur j){
            this.j = j;
            this.r = new Circle(3);
            r.setFill(Color.RED);
            r.setTranslateX(j.getX());
            r.setTranslateY(j.getY());
            System.out.println("cercle et joueur créer");
        }

    public Circle getR() {
        return r;
    }
}

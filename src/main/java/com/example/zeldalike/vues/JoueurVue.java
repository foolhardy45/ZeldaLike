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
            this.r = new Circle(50);
            this.tilePane = tilePane;
            r.setFill(Color.RED);
            r.setTranslateX(j.getP().getX());
            r.setTranslateY(j.getP().getY());
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
    // Méthode pour déplacer le cercle vers le haut
    public void deplacerHaut(double deltaY) {
        r.setCenterY(r.getCenterY() - deltaY);
    }

    // Méthode pour déplacer le cercle vers le bas
    public void deplacerBas(double deltaY) {
        r.setCenterY(r.getCenterY() + deltaY);
    }

    // Méthode pour déplacer le cercle vers la gauche
    public void deplacerGauche(double deltaX) {
        r.setCenterX(r.getCenterX() - deltaX);
    }

    // Méthode pour déplacer le cercle vers la droite
    public void deplacerDroite(double deltaX) {
        r.setCenterX(r.getCenterX() + deltaX);
    }
}

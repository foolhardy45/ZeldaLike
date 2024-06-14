package com.example.zeldalike.modele;

public class PotionVitale extends ObjetRecuperables {

    private final int pouvoir = 2; //soin 2 coeurs

    public PotionVitale(Position p) {
        super(p);
    }

    public PotionVitale(){
        super();
    }

    public boolean collisionJoueur(Joueur j) {
        return false;
    }
}

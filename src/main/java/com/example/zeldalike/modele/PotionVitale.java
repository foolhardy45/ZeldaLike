package com.example.zeldalike.modele;

public class PotionVitale extends ObjetRecuperables {

    private int pouvoir = 2; //soin 2 coeurs

    public PotionVitale(Position p){
        super(p, 1);
    }
    public boolean collisionJoueur(Joueur j){
        return false;
    }
}

package com.example.zeldalike.modele;

public class Citron extends Ennemis {

    public Citron(Position p, Environnement env) {
        super(8, 0, 1, p, env, env.getTerrain(), 6);

    }

    public void personnageTouche(Personnage p) {
        //System.out.println("Personnage Touché - Citron");


    }

    @Override
    public void compétence() {

    }
}

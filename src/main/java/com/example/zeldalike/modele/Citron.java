package com.example.zeldalike.modele;

public class Citron extends Ennemis {

    public Citron(Position p, Environnement env){
        super(700, 25,1,p, env,env.getTerrain(), 6);

    }

    public void personnageTouche(Personnage p) {
        //System.out.println("Personnage Touché - Citron");


    }
}

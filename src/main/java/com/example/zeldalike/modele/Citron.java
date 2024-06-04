package com.example.zeldalike.modele;

public class Citron extends Ennemis {

    public Citron(Position p, Environnement env){
        super(700, 2,1,p, env,env.getTerrain(), 4);

    }

    public void personnageTouche(Personnage p) {
        //System.out.println("Personnage Touché - Citron");


    }
}

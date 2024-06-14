package com.example.zeldalike.modele;

public class BusinessMan extends Ennemis {

    public BusinessMan(Position p, Environnement env){
        super(2500, 3,2,p,31, env,env.getTerrain(), 10);

    }

    public void personnageTouche(Personnage p) {
        //System.out.println("Personnage Touché - BusinessMan");


    }
}

package com.example.zeldalike.modele;

public class Citron extends Ennemis{

    public Citron(Position p, Environnement env){
        super(700, 25,35,p, env,env.getTerrain());
    }

    public void personnageTouche(){
        System.out.println("Personnage Touché - Citron");
    }
}

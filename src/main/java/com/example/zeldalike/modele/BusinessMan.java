package com.example.zeldalike.modele;

public class BusinessMan extends Ennemis {

    public BusinessMan(Position p, Environnement env) {
        super(40, 3, 2, p, env, env.getTerrain(), 10);

    }

    public void personnageTouche(Personnage p) {
        //System.out.println("Personnage Touché - BusinessMan");
    }

    @Override
    public void compétence() {

    }

    @Override
    public void désacCompétence() {

    }
}

package com.example.zeldalike.modele;

public class ProjectileBoss extends Ennemis {


    public ProjectileBoss(Position p, Environnement env){
        super(1, 0,2,p, 64, env, env.getTerrain(), 0 );

    }

    @Override
    public void deplacementBFS() {
        this.move();
    }

    @Override
    public int getHp() {
        return 1;
    }

    public void personnageTouche(Personnage p) {
        //enlever pv au personnage sauf si boss
    }

    //todo : les faire avancer sans collisions, puis disparaitre à la limite de l'écran.
}

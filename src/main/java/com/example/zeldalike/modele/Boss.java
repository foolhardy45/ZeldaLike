package com.example.zeldalike.modele;

public abstract class Boss extends Ennemis{
    private int phase;
    private int action;

    public Boss(int hp, int def, int vitesse, Position p, Environnement env, int detection){
        super(hp, def, vitesse, p,63, env, env.getTerrain(), detection);
        this.phase = 1;
        action = 0;
    }

    @Override
    public void deplacementBFS(){
        action = action%150;
        if (action == 0){
            System.out.println("Action now");
            faireuneattaque();
        }
        action++;
        super.deplacementBFS();
    }


    public void changeDePhase(){
        this.phase++;
    }

    public void faireuneattaque(){

    }
}

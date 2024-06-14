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
            faireuneattaque();
        }
        action++;
        super.deplacementBFS();
    }


    public void changeDePhase(){
        this.phase++;
    }

    public int getPhase() {
        return phase;
    }

    public void verifiephase(){
        if (this.getHp()<40){
            changeDePhase();
        }
    }

    public abstract void faireuneattaque();
}

package com.example.zeldalike.modele;

public abstract class Boss extends Ennemis{
    private int phase;
    private int action;


    public Boss(int hp, int def, int vitesse, Position p, Environnement env, int detection){
        super(hp, def, vitesse, p, env, env.getTerrain(), detection);
        this.phase = 1;
        action = 0;
    }

    @Override
    public void agir(){
        action = action%150;
        if (action == 0){
            faireuneattaque();
        }
        action++;
        super.deplacementBFS();
    }

    //todo : creation d'une liste de projectile de boss
    //todo : pour chaque projectile de la liste, les faire avancer ici (ne plus les considérer comme des ennemis)



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

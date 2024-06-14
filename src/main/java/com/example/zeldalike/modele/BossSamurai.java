package com.example.zeldalike.modele;

public class BossSamurai extends Boss{
    public BossSamurai(Position p, Environnement env){
        super(20, 0, 0, p, env, 10);
    }


    @Override
    public void personnageTouche(Personnage p) {

    }
}

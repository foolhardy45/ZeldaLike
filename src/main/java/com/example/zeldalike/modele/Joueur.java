package com.example.zeldalike.modele;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Joueur extends Personnage {
    private Queue<Character> déplacement;
    private Inventaire sac;

    public Joueur(int hp, int def, Position p, Environnement env, Terrain terrain) {
        super(hp, def, 4, p, env,terrain);
        this.sac = new Inventaire();
    }

    @Override
    public void personnageTouche(Personnage p) {
        System.out.println("Personnage Touché - Joueur");
        if (p instanceof Ennemis){
            System.out.println(" ayyyyyyyaaaaaaaa");
            this.attaquer(p);
        }
    }


    public Inventaire getSac() {
        return sac;
    }
}

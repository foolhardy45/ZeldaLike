package com.example.zeldalike.modele;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Joueur extends Personnage {
    private Queue<Character> déplacement;
    private HashMap<ObjetRecuperables, Integer> inventaire;

    public Joueur(int hp, int def, Position p, Environnement env, Terrain terrain) {
        super(hp, def, 200, p, env,terrain);
        this.déplacement = new LinkedList<>();
    }

    @Override
    public void personnageTouche(Personnage p) {
        System.out.println("Personnage Touché - Joueur");
    }

    public boolean verifieObjetPresent(ObjetRecuperables obj){
        boolean present = false;
        for (ObjetRecuperables o: this.inventaire.keySet()){
            if (o.memeID(obj)){
                present = true;
            }
        }
        return present;
    }
}

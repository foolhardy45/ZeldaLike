package com.example.zeldalike.modele;

import java.util.LinkedList;
import java.util.Queue;

public class Joueur extends Personnage {
    private Queue<Character> déplacement;

    public Joueur(int hp, int def, Position p, Environnement env) {
        super(hp, def, 200, p, env);
        this.déplacement = new LinkedList<>();
    }

    public void personnageTouche(){
        System.out.println("Personnage Touché - Joueur");
    }

    public void afficheDeplacement() {
        for (Character c : déplacement) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

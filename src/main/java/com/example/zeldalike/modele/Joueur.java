package com.example.zeldalike.modele;

import java.util.LinkedList;
import java.util.Queue;

public class Joueur extends Personnage {
    private Queue<Character> déplacement;

    public Joueur(int hp, int def, Position p, Environnement env) {
        super(hp, def, 200, p, env);
        this.déplacement = new LinkedList<>();
    }

    public void ajouterCharacter(Character character) {
        déplacement.add(character);
    }

    public void afficheDeplacement() {
        for (Character c : déplacement) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    /*public void faireUnDeplacement(long deltaTime) {
        // Consomme les déplacements un par un
        Character c = déplacement.poll();
        if (c != null) {
            switch (c) {
                case 'h':
                    this.moveUp(deltaTime);
                    break;
                case 'b':
                    this.moveDown(deltaTime);
                    break;
                case 'g':
                    this.moveLeft(deltaTime);
                    break;
                case 'd':
                    this.moveRight(deltaTime);
                    break;
            }
        }
    }*/
}
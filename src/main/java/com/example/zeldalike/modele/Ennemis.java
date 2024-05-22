package com.example.zeldalike.modele;

import java.util.Random;

public class Ennemis extends Personnage{
    private static int id = 0;
    private String idEnnemi;
    public Ennemis(int hp, int def, int vitesse,Position p,Environnement env) {
        super(hp, def, vitesse, p,env);
        id++;
        this.idEnnemi = "E"+id;
    }

    public static int getId() {
        return id;
    }

    public String getIdEnnemi() {
        return idEnnemi;
    }

    public void deplacementAleatoire(long deltaTime){
        Random quelleDirection = new Random();
        int t = quelleDirection.nextInt(400);
        if (t < 100){
            moveUp(deltaTime);
        } else if (t < 200){
            moveLeft(deltaTime);
        } else if (t < 300) {
            moveDown(deltaTime);
        } else {
            moveRight(deltaTime);
        }
    }
}

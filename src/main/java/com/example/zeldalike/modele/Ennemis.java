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

    public void deplacementAleatoire(){
        Random quelleDirection = new Random();
        int t = quelleDirection.nextInt(400);
        System.out.println(t);
        if (t < 100){
            moveUp();
        } else if (t < 200){
            moveLeft();
        } else if (t < 300) {
            moveDown();
        } else {
            moveRight();
        }
    }
}

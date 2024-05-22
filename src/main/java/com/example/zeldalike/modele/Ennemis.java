package com.example.zeldalike.modele;

import java.util.Random;

public abstract class Ennemis extends Personnage{
    private static int id = 0;
    private String idEnnemi;
    private int direction;
    public Ennemis(int hp, int def, int vitesse,Position p,Environnement env) {
        super(hp, def, vitesse, p,env);
        id++;
        this.idEnnemi = "E"+id;
        this.direction = 0; // 0 = haut, 1 = gauche, 2 = bas, 3 = droite
    }

    public static int getId() {
        return id;
    }

    public String getIdEnnemi() {
        return idEnnemi;
    }

    public void deplacementAleatoire(){
        Random quelleDirection = new Random();
        int t = quelleDirection.nextInt(500);
        if (t < 50) {
            t = quelleDirection.nextInt(400);
            if (t < 100) {
                this.direction = 0;
            } else if (t < 200) {
                this.direction = 1;
            } else if (t < 300) {
                this.direction = 2;
            } else {
                this.direction = 3;
            }
        }
        switch (this.direction){
            case 0 : moveUp(); break;
            case 1 : moveLeft(); break;
            case 2 : moveDown(); break;
            case 3 : moveRight(); break;
        }
    }
}

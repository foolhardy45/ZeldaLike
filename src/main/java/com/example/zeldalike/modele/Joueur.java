package com.example.zeldalike.modele;

public class Joueur extends Personnage{
    public Joueur(int hp, int def, int vitesse,Position p,Environnement env) {
        super(hp, def, vitesse,p, env);
    }
    public void moveUp(){
        System.out.println("move up");
    }
    public void moveDown(){
        System.out.println("move Down");

    }
    public void moveLeft(){
        System.out.println("move Left");

    }
    public void moveRight(){
        System.out.println("move Right");

    }
}

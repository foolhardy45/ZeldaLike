package com.example.zeldalike.modele;

public class Joueur extends Personnage{
    public Joueur(int hp, int def, int vitesse,Position p,Environnement env) {
        super(hp, def, vitesse,p, env);
    }
    public void moveUp(){
        System.out.println("move up");
        this.getP().setY(this.getP().getY()+5);
    }
    public void moveDown(){
        System.out.println("move Down");
        this.getP().setY(this.getP().getY()-5);

    }
    public void moveLeft(){
        System.out.println("move Left");
        this.getP().setX(this.getP().getX()-5);

    }
    public void moveRight(){
        System.out.println("move Right");
        this.getP().setX(this.getP().getX()+5);

    }
}

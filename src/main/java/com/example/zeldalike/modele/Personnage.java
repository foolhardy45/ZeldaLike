package com.example.zeldalike.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Personnage {
    private int hp;
    private int def;
    private int vitesse;
    private Position p;
    private Environnement env;


    public Personnage(int hp, int def, int vitesse, Position p, Environnement env) {
        this.hp = hp;
        this.def = def;
        this.vitesse = vitesse;
        this.p = p;
        this.env = env;
    }

    public Position getP() {
        return p;
    }

    public void setP(Position p) {
        this.p = p;
    }

    public Environnement getEnv() {
        return env;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }
    public abstract void personnageTouche();

    public boolean encoreSurEnvY(int nouvellePosY) {
        if (nouvellePosY < 0 || nouvellePosY > this.env.getHeight()) {
            return false;
        }
        return true;
    }

    public boolean encoreSurEnvX(int nouvellePosX) {
        if (nouvellePosX < 0 || nouvellePosX > this.env.getWidth()) {
            return false;
        }
        return true;
    }

    public void moveUp(long deltaTime) {
        double nouvellePosY = this.getP().getY() - (this.getVitesse() * (deltaTime / 1000.0));

        int newY = (int) Math.round(nouvellePosY);
        if (encoreSurEnvY(newY)) {
            this.getP().setY(newY);
        }
    }

    public void moveDown(long deltaTime) {
        double nouvellePosY = this.getP().getY() + (this.getVitesse() * (deltaTime / 1000.0));
        System.out.println(nouvellePosY);
        int newY = (int) Math.round(nouvellePosY);
        System.out.println(newY);
        if (encoreSurEnvY(newY)) {
            this.getP().setY(newY);
        }
    }

    public void moveLeft(long deltaTime) {
        double nouvellePosX = this.getP().getX() - (this.getVitesse() * (deltaTime / 1000.0));
        int newX = (int) Math.round(nouvellePosX);
        if (encoreSurEnvX(newX)) {
            System.out.println("mouvement");
            this.getP().setX(newX);
        }
    }

    public void moveRight(long deltaTime) {
        double nouvellePosX = this.getP().getX() + (this.getVitesse() * (deltaTime / 1000.0));
        int newX = (int) Math.round(nouvellePosX);
        if (encoreSurEnvX(newX)) {
            this.getP().setX(newX);
        }
    }
    //todo: interaction entre deux personnages (collision)
    /* Recupere les coordonnees d'un personnage et teste  s'il le touche
    *  Si oui, appliquer une fonction speciale de chaque personnage pour réagir
    *  Si non, ne rien faire
    * */

    public boolean verificationCollision(Personnage perso){
        boolean touche = false;
        //verification touché droite
        if (this.p.collisionEntreSprites(perso.getP())){
            this.personnageTouche();
            perso.personnageTouche();
            touche = true;
        }
        //verification touché gauche
        //verification touché haut
        //verification touché bas
        return touche;
    }
}



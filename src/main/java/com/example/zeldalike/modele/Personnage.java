package com.example.zeldalike.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import javax.crypto.KEMSpi;
import java.awt.event.KeyEvent;

public abstract class Personnage  {
    private int hp;
    private int def;
    private int vitesse;
    private Position p;
    private Environnement env;
    private Terrain terrain;
    private int hitbox;
    private IntegerProperty direction;



    public Personnage(int hp, int def, int vitesse, Position p, Environnement env, Terrain terrain) {
        this.hp = hp;
        this.def = def;
        this.vitesse = vitesse;
        this.p = p;
        this.env = env;
        this.terrain = terrain;
        this.hitbox =31;
        this.direction = new SimpleIntegerProperty();
    }

    public int getDirection() {
        return direction.get();
    }

    public void ajouterDirection(int direction) {
        this.direction.set(direction);
    }

    public IntegerProperty directionProperty() {
        return direction;
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
    public abstract void personnageTouche(Personnage p);

    public void  move(long deltaTime) {
        if(this.getDirection() ==  1){
            moveDown(deltaTime);
            moveLeft(deltaTime);
        }else if(this.getDirection() == 2){
            moveDown(deltaTime);
        }else if(this.getDirection() == 3){
            moveDown(deltaTime);
            moveRight(deltaTime);
        } else if (this.getDirection() == 4) {
            moveLeft(deltaTime);
        }else if(this.getDirection() == 5){

        }else if(this.getDirection() == 6){
            moveRight(deltaTime);
        }else if(this.getDirection() == 7){
            moveUp(deltaTime);
            moveLeft(deltaTime);
        }else if(this.getDirection() == 8){
            moveUp(deltaTime);
        } else if(this.getDirection() == 9) {
            moveUp(deltaTime);
            moveRight(deltaTime);

        }
    }


    private void moveUp(long deltaTime){
        double nouvellePosY = this.getP().getY() - this.getVitesse();//(this.getVitesse() *(deltaTime/1000.0));
        int newY = (int) Math.round(nouvellePosY);
        int PosX = this.getP().getX();
        if (this.terrain.estDansTerrain(PosX, newY) && terrain.estAutorisé(PosX+1,newY+hitbox)&& terrain.estAutorisé(PosX+hitbox,newY+hitbox)) {
            this.getP().setY(newY);
        }
    }


    private void moveDown(long deltaTime) {
        double nouvellePosY = this.getP().getY() + this.getVitesse();//(this.getVitesse()*(deltaTime/1000.0));
        int newY = (int) Math.round(nouvellePosY);
        System.out.println(nouvellePosY);
        System.out.println(newY);
        int PosX = this.getP().getX();
        if (this.terrain.estDansTerrain(PosX, newY) && terrain.estAutorisé(PosX+1,newY+hitbox) && terrain.estAutorisé(PosX+hitbox,newY+hitbox)) {
            this.getP().setY(newY);
        }
    }

    private void moveLeft(long deltaTime) {
        double nouvellePosX = this.getP().getX() - this.getVitesse();//(this.getVitesse()*(deltaTime/1000.0));
        int newX = (int) Math.round(nouvellePosX);
        int PosY = this.getP().getY();
        if (this.terrain.estDansTerrain(newX, PosY) && this.terrain.estAutorisé(newX, PosY+hitbox)) {
            this.getP().setX(newX);
        }
    }

    private void moveRight(long deltaTime) {
        double nouvellePosX = this.getP().getX() + this.getVitesse();//(this.getVitesse() *(deltaTime/1000.0));
        int newX = (int) Math.round(nouvellePosX);
        int PosY = this.getP().getY();
        System.out.println(this.getVitesse());
        if (this.terrain.estDansTerrain(newX, PosY) && this.terrain.estAutorisé(newX+ hitbox, PosY+hitbox)) {
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
            this.personnageTouche(perso);
            perso.personnageTouche(this);
            touche = true;
        }
        return touche;
    }

    /*public void projection (Personnage perso,long deltaTime){
        switch (this.direction){
            case 'N' :
                if(this.terrain.estDansTerrain(perso.getP().getX(), perso.getP().getY()+ vitesse)) {
                    perso.getP().setY(this.getP().getY() + vitesse);
                }
            break;
            case 'S' : perso.getP().setY(this.getP().getY() - vitesse);
                break;
            case 'O' : perso.getP().setX(this.getP().getX() - vitesse);
                break;
            case 'E' : perso.getP().setX(this.getP().getX() + vitesse);
                break;
        }
    }*/
}



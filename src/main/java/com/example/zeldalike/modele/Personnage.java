package com.example.zeldalike.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

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
    private Arme arme;



    public Personnage(int hp, int def, int vitesse, Position p, Environnement env, Terrain terrain) {
        this.hp = hp;
        this.def = def;
        this.vitesse = vitesse;
        this.arme = new Poing(10000);
        this.p = p;
        this.env = env;
        this.terrain = terrain;
        this.hitbox =31;
        this.direction = new SimpleIntegerProperty();
    }

    public Arme getArme() {
        return arme;
    }

    public int getDirection() {
        return direction.get();
    }

    public void ajouterDirection(int direction) {
        this.direction.set(direction);
    }


    public void attaquer(Personnage p) {
        if (enVie() && p.enVie()) {
            int degats = this.getArme().getAttaque();
            if (p.getDef() < degats) {
                degats -= p.getDef();
            } else {
                degats = 0;
            }
            p.setHp(p.getHp() - degats);
            System.out.println("Dégâts infligés: " + degats);
        } else {
            System.out.println("T'es mort, le gâté !");
        }
    }


    /*public void recoitDegats(int degats){
        this.hp -= degats - this.getDef();
        if (!this.enVie()){
            this.hp = 0;
        }
    }*/

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
   

    public void  move() {
        if(this.getDirection() ==  1){
            moveDown( );
            moveLeft( );
        }else if(this.getDirection() == 2){
            moveDown( );
        }else if(this.getDirection() == 3){
            moveDown( );
            moveRight( );
        } else if (this.getDirection() == 4) {
            moveLeft( );
        }else if(this.getDirection() == 5){

        }else if(this.getDirection() == 6){
            moveRight( );
        }else if(this.getDirection() == 7){
            moveUp( );
            moveLeft( );
        }else if(this.getDirection() == 8){
            moveUp( );
        } else if(this.getDirection() == 9) {
            moveUp( );
            moveRight( );
        }

    }


    private void moveUp( ){
        double nouvellePosY = this.getP().getY() - this.getVitesse();
        int newY = (int) Math.round(nouvellePosY);
        int PosX = this.getP().getX();
        if (this.terrain.estDansTerrain(PosX, newY) && terrain.estAutorisé(PosX+1,newY+hitbox)&& terrain.estAutorisé(PosX+hitbox,newY+hitbox)) {
            this.getP().setY(newY);
        }
    }


    private void moveDown(  ) {
        double nouvellePosY = this.getP().getY() + this.getVitesse();
        int newY = (int) Math.round(nouvellePosY);
        System.out.println(nouvellePosY);
        System.out.println(newY);
        int PosX = this.getP().getX();
        if (this.terrain.estDansTerrain(PosX, newY) && terrain.estAutorisé(PosX+1,newY+hitbox) && terrain.estAutorisé(PosX+hitbox,newY+hitbox)) {
            this.getP().setY(newY);
        }
    }

    private void moveLeft(  ) {
        double nouvellePosX = this.getP().getX() - this.getVitesse();
        int newX = (int) Math.round(nouvellePosX);
        int PosY = this.getP().getY();
        if (this.terrain.estDansTerrain(newX, PosY) && this.terrain.estAutorisé(newX, PosY+hitbox)) {
            this.getP().setX(newX);
        }
    }

    private void moveRight(  ) {
        double nouvellePosX = this.getP().getX() + this.getVitesse();
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
    
    public boolean enVie(){
        return this.hp >0;
    }
    
    public abstract void personnageTouche(Personnage p);
    
}



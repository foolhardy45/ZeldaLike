package com.example.zeldalike.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Personnage  {
    private int hp;
    private int def;
    private int vitesse;
   private Position p;
    private Environnement env;
    private Terrain terrain;



    public Personnage(int hp, int def, int vitesse, Position p, Environnement env, Terrain terrain) {
        this.hp = hp;
        this.def = def;
        this.vitesse = vitesse;
        this.p = p;
        this.env = env;
        this.terrain = terrain;
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
    public boolean collisionGauche (int PosX,int PosY) {
        if (terrain.codeCaseI((this.env.getWidth()*(PosY/32)+(PosX))/32)!=2){
            return false;
        }
        return true;
    }
    public boolean collisionDroite (int PosX,int PosY) {
        if (terrain.codeCaseI((this.env.getWidth()*(PosY/32)+(PosX)+31)/32)!=2){
            return false;
        }
        return true;
    }
    public boolean collisionHaut (int PosX,int PosY) {
        if (terrain.codeCaseI((this.env.getWidth()*(PosX/32)+(PosY))/32)!=2){
            return false;
        }
        return true;
    }
    public boolean collisionBas (int PosX,int PosY) {
        if (terrain.codeCaseI((this.env.getWidth()*(PosY)+31)/32+(PosX)/32)!=2){
            return false;
        }
        return true;
    }


    public void moveUp(){
        int nouvellePosY = this.getP().getY() - vitesse;
        int PosX = this.getP().getY();
        if (encoreSurEnvY(nouvellePosY)/*&&collisionHaut(PosX+31, nouvellePosY)*/) {
            System.out.println("move Down");
            this.getP().setY(nouvellePosY);
        } else {
            System.out.println("stop");
        }
    }


    public void moveDown() {
        int nouvellePosY = this.getP().getY() + vitesse;
        int PosX = this.getP().getX();
        if (encoreSurEnvY(nouvellePosY)&&collisionBas(PosX+31, nouvellePosY)) {
            System.out.println("move Down");
            this.getP().setY(nouvellePosY);
        } else {
            System.out.println("stop");
        }
    }

    public void moveLeft() {
        int nouvellePosX = this.getP().getX() - vitesse;
        int PosY = this.getP().getY();
        if (encoreSurEnvX(nouvellePosX)&&collisionGauche(nouvellePosX,PosY+31)) {
            System.out.println("move Left");
            this.getP().setX(nouvellePosX);
        } else {
            System.out.println("stop");
        }
    }

    public void moveRight() {
        int nouvellePosX = this.getP().getX() + vitesse;
        int PosY = this.getP().getY();
        if (encoreSurEnvX(nouvellePosX)&&collisionDroite(nouvellePosX,PosY+31)) {
            System.out.println("move Right");
            this.getP().setX(nouvellePosX);
        } else {
            System.out.println("stop");
            System.out.println(nouvellePosX);
        }
    }

}

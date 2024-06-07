package com.example.zeldalike.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.awt.*;

public abstract class Personnage {
    private IntegerProperty hp;
    private int def;
    private int vitesse;
    private Position p;
    private final Environnement env;
    private final Terrain terrain;
    private final int hitbox;
    private final IntegerProperty direction;


    public Personnage(int hp, int def, int vitesse,int atk, Position p, Environnement env, Terrain terrain) {
        this.hp = new SimpleIntegerProperty(hp);
        this.def = def;
        this.vitesse = vitesse;
        this.p = p;
        this.env = env;
        this.terrain = terrain;
        this.hitbox = 31;
        this.direction = new SimpleIntegerProperty();
    }



    public int getHitbox() {
        return hitbox;
    }

    public int getDirection() {
        return direction.get();
    }

    public void ajouterDirection(int direction) {
        this.direction.set(direction);
    }

    public int distanceEntreDeuxPersonnages(Personnage p1, Personnage p2) {
        int super_x = (p1.getP().getX() - p2.getP().getX()) * (p1.getP().getX() - p2.getP().getX());
        int super_y = (p1.getP().getY() - p2.getP().getY()) * (p1.getP().getY() - p2.getP().getY());
        return (int) Math.sqrt(super_x + super_y);
    }

    public void repousserPersonnages(Personnage p1, Personnage p2) {
        int dx = p1.getP().getX() - p2.getP().getX();
        int dy = p1.getP().getY() - p2.getP().getY();
        int distance = p1.distanceEntreDeuxPersonnages(p1,p2);
        if (distance == 0) return;

        int repulsionForce = 12;
        int repulsionX = (dx / distance) * repulsionForce;
        int repulsionY = (dy / distance) * repulsionForce;

        boolean p1CanMove =
                terrain.estAutorisé(p1.getP().getX() + repulsionX, p1.getP().getY() + repulsionY) &&
                        terrain.estAutorisé(p1.getP().getX() + p1.getHitbox() + repulsionX, p1.getP().getY() + repulsionY) &&
                        terrain.estAutorisé(p1.getP().getX() + repulsionX, p1.getP().getY()+ p1.getHitbox() + repulsionY) &&
                        terrain.estAutorisé(p1.getP().getX()+ p1.getHitbox() + repulsionX, p1.getP().getY() +p1.getHitbox()+ repulsionY);
        boolean p2CanMove =
                terrain.estAutorisé(p2.getP().getX() - repulsionX, p2.getP().getY() - repulsionY) &&
                        terrain.estAutorisé(p2.getP().getX()+ p2.getHitbox()-repulsionX,p2.getP().getY() - repulsionY ) &&
                        terrain.estAutorisé(p2.getP().getX()-repulsionX,p2.getP().getY()+ p2.getHitbox() - repulsionY ) &&
                        terrain.estAutorisé(p2.getP().getX()+p2.getHitbox()-repulsionX,p2.getP().getY() + p2.getHitbox()-repulsionY);


        if (p1CanMove && p2CanMove) {
            p1.moveDe(repulsionX, repulsionY);
            p2.moveDe(-repulsionX, -repulsionY);
        } else if (p1CanMove) {
            p1.moveDe(repulsionX, repulsionY);
        } else if (p2CanMove) {
            p2.moveDe(-repulsionX, -repulsionY);
        }
    }

    public IntegerProperty directionProperty() {
        return direction;
    }

    public void setValeurDirection(int d) {
        this.direction.set(d);
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
        return hp.get();
    }

    public void setHp(int hp) {
        this.hp.set(hp);
    }

    public IntegerProperty hpProperty() {
        return hp;
    }

    public int getDef() {
        return def;
    }


    public int getVitesse() {
        return vitesse;
    }


    public void move() {
        switch (this.getDirection()) {
            case 1:
                moveDown();
                moveLeft();
                break;
            case 2:
                moveDown();
                break;
            case 3:
                moveDown();
                moveRight();
                break;
            case 4:
                moveLeft();
                break;
            case 5:
                break;
            case 6:
                moveRight();
                break;
            case 7:
                moveUp();
                moveLeft();
                break;
            case 8:
                moveUp();
                break;
            case 9:
                moveUp();
                moveRight();
                break;
        }
    }

    private void moveUp() {
        double nouvellePosY = this.getP().getY() - this.getVitesse();
        int newY = (int) Math.round(nouvellePosY);
        int PosX = this.getP().getX();
        if (this.terrain.estDansTerrain(PosX, newY) && terrain.estAutorisé(PosX + 1, newY + hitbox) && terrain.estAutorisé(PosX + hitbox, newY + hitbox)) {
            this.getP().setY(newY);
        }
    }

    private void moveDown() {
        double nouvellePosY = this.getP().getY() + this.getVitesse();
        int newY = (int) Math.round(nouvellePosY);
        int PosX = this.getP().getX();
        if (this.terrain.estDansTerrain(PosX, newY) && terrain.estAutorisé(PosX + 1, newY + hitbox) && terrain.estAutorisé(PosX + hitbox, newY + hitbox)) {
            this.getP().setY(newY);
        }
    }

    private void moveLeft() {
        double nouvellePosX = this.getP().getX() - this.getVitesse();
        int newX = (int) Math.round(nouvellePosX);
        int PosY = this.getP().getY();
        if (this.terrain.estDansTerrain(newX, PosY) && this.terrain.estAutorisé(newX, PosY + hitbox)) {
            this.getP().setX(newX);
        }
    }

    private void moveRight() {
        double nouvellePosX = this.getP().getX() + this.getVitesse();
        int newX = (int) Math.round(nouvellePosX);
        int PosY = this.getP().getY();
        if (this.terrain.estDansTerrain(newX, PosY) && this.terrain.estAutorisé(newX + hitbox, PosY + hitbox)) {
            this.getP().setX(newX);
        }
    }

    public boolean collidesWith(Personnage other) {
        return this.getBounds().intersects(other.getBounds());
    }

    private Rectangle getBounds() {
        return new Rectangle(this.getP().getX(), this.getP().getY(), this.getWidth(), this.getHeight());
    }

    public void moveDe(int dx, int dy) {
        this.getP().setX(this.getP().getX() + dx);
        this.getP().setY(this.getP().getY() + dy);
    }

    private int getWidth() {
        return 32;
    }

    private int getHeight() {
        return 32;
    }

    public boolean verificationCollision(Personnage perso) {
        boolean touche = false;
        if (this.p.collisionEntreSprites(perso.getP())) {
            this.personnageTouche(perso);
            perso.personnageTouche(this);
            touche = true;
        }
        return touche;
    }

    public boolean enVie() {
        return this.getHp() > 0;
    }
    
    public abstract void personnageTouche(Personnage p);
}

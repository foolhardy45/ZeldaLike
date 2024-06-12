package com.example.zeldalike.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Personnage {
    private int hp;
    private int def;
    private int vitesse;
    private Position p;
    private final Environnement env;
    private final Terrain terrain;
    private final int hitbox;
    private final IntegerProperty direction;
    private Arme arme;


    public Personnage(int hp, int def, int vitesse, Position p, int hitbox, Environnement env, Terrain terrain) {
        this.hp = hp;
        this.def = def;
        this.vitesse = vitesse;
        this.p = p;
        this.env = env;
        this.arme = new Poing();
        this.terrain = terrain;
        this.hitbox = 31;
        this.direction = new SimpleIntegerProperty();

    }

    public Arme getArme() {
        return arme;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }

    public int getDirection() {
        return direction.get();
    }

    public void ajouterDirection(int direction) {
        this.direction.set(direction);
    }


    public void frapper(Personnage p) {
        if (enVie() && p.enVie()) {
            int degats = this.arme.getAttaque();
            if (p.getDef() < degats) {
                degats -= p.getDef();
            } else {
                degats = 0;
            }
            p.setHp(p.getHp() - degats);
            System.out.println("Dégâts infligés: " + degats);
        }
    }

    public int distanceEntreDeuxPersonnages(Personnage p1, Personnage p2) {
        int super_x;
        int super_y;
        int distance;

        super_x = (p1.getP().getX() - p2.getP().getX()) * (p1.getP().getX() - p2.getP().getX());
        super_y = (p1.getP().getY() - p2.getP().getY()) * (p1.getP().getY() - p2.getP().getY());

        distance = (int) Math.sqrt(super_x + super_y);


        return distance;
    }


    public IntegerProperty directionProperty() {
        return direction;
    }
    public void setValeurDirection(int d){this.direction.set(d);}

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
    //todo: interaction entre deux personnages (collision)
    /* Recupere les coordonnees d'un personnage et teste  s'il le touche
     *  Si oui, appliquer une fonction speciale de chaque personnage pour réagir
     *  Si non, ne rien faire
     * */

    public boolean verificationCollision(Personnage perso) {
        boolean touche = false;
        //verification touché droite
        if (this.p.collisionEntreSprites(perso.getP())) {
            this.personnageTouche(perso);
            perso.personnageTouche(this);
            touche = true;
        }
        return touche;
    }

    public int getHitbox(){
        return this.hitbox;
    }

    public boolean enVie() {
        return this.hp > 0;
    }

    public abstract void personnageTouche(Personnage p);

}



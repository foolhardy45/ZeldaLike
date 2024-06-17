package com.example.zeldalike.modele.Arme.gun;

import com.example.zeldalike.modele.Joueur;
import com.example.zeldalike.modele.ObjetRecuperables;
import com.example.zeldalike.modele.Personnage;
import com.example.zeldalike.modele.Position;

import java.awt.*;

public class Munition extends ObjetRecuperables {
    private static int id = 0;
    private int degats;
    private int vitesse;
    private String idMunition;
    private Joueur j;
    private int direction;


    public Munition(Position position, Joueur j, int direction) {
        super(position);
        this.j = j;
        this.degats = 4;
        this.vitesse = 8;
        id++;
        this.idMunition = "E" + id;
        this.direction = direction;
    }

    public Munition(Position position) {
        super(position);
        this.degats = 4;
        this.vitesse = 10;
        id++;
        this.idMunition = "E" + id;
        this.direction = 0;
        this.j = null;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Joueur getJ() {
        return j;
    }

    public int getDegats() {
        return degats;
    }


    private Rectangle getBouds() {
        return new Rectangle(this.getP().getX(), this.getP().getY(), 32, 32);
    }

    public boolean collidesWith(Personnage other) {
        return this.getBouds().intersects(other.getBounds());
    }


    public void move() {
        switch (this.direction) {
            case 1:
                this.getP().setX(this.getP().getX() - vitesse);
                this.getP().setY(this.getP().getY() + vitesse);
                break;
            case 2:
                this.getP().setY(this.getP().getY() + vitesse);
                break;
            case 3:
                this.getP().setX(this.getP().getX() + vitesse);
                this.getP().setY(this.getP().getY() + vitesse);
                break;
            case 4:
                this.getP().setX(this.getP().getX() - vitesse);
                break;
            case 5:
                break;
            case 6:
                this.getP().setX(this.getP().getX() + vitesse);
                break;
            case 7:
                this.getP().setX(this.getP().getX() - vitesse);
                this.getP().setY(this.getP().getY() - vitesse);
                break;
            case 8:
                this.getP().setY(this.getP().getY() - vitesse);
                break;
            case 9:
                this.getP().setX(this.getP().getX() + vitesse);
                this.getP().setY(this.getP().getY() - vitesse);
                break;
        }
    }


}

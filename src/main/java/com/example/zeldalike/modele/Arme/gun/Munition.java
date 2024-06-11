package com.example.zeldalike.modele.Arme.gun;

import com.example.zeldalike.modele.ObjetRecuperables;
import com.example.zeldalike.modele.Parametre;
import com.example.zeldalike.modele.Position;

public class Munition extends ObjetRecuperables {
    private int degats;
    private int vitesse;
    private int direction;
    private static int id = 0;
    private  String idMunition;

    public Munition(Position position, int direction) {
        super(position);
        this.degats = 4;
        this.direction = direction;
        this.vitesse = 2;
        id++;
        this.idMunition = "E" + id;
    }

    public int getDirection() {
        return direction;
    }

    public int getDegats() {
        return degats;
    }
    public void move(){
        switch (direction){
            case 1:
                this.getP().setY(getP().getY() + vitesse);
                getP().setX(getP().getX() - vitesse);
                break;
            case 2:
                getP().setY(getP().getY() + vitesse);
                break;
            case 3:
                getP().setY(getP().getY() + vitesse);
                getP().setX(getP().getX() + vitesse);
                break;
            case 4:
                getP().setX(getP().getX() - vitesse);
                break;
            case 5:
                break;
            case 6:
                getP().setX(getP().getX() + vitesse);
                break;
            case 7:
                getP().setY(getP().getY() - vitesse);
                getP().setX(getP().getX() - vitesse);
                break;
            case 8:
                getP().setY(getP().getY() - vitesse);
                break;
            case 9:
                getP().setY(getP().getY() - vitesse);
                getP().setX(getP().getX() + vitesse);
                break;
        }
    }

}

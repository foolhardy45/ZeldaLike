package com.example.zeldalike.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Personnage  {
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
    public void moveUp() {
        if (this.verifieDeplacementPossible(0,-5)) {
            System.out.println("move up");
            this.getP().setY(this.getP().getY() - 5);
        }
    }

    public void moveDown() {
        if (this.verifieDeplacementPossible(0,5)) {
            System.out.println("move Down");
            this.getP().setY(this.getP().getY() + 5);
        }
    }

    public void moveLeft() {
        if (this.verifieDeplacementPossible(-5,0)) {
            System.out.println("move Left");
            this.getP().setX(this.getP().getX() - 5);
        }
    }

    public void moveRight() {
        if (this.verifieDeplacementPossible(5,0)) {
            System.out.println("move Right");
            this.getP().setX(this.getP().getX() + 5);
        }
    }

    public boolean verifieDeplacementPossible(int valeurx, int valeury){
        boolean deplacementpossible = this.env.encoreSurleJeu(this.p);
        Position ptest = new Position(this.p.getX()+valeurx, this.p.getY()+valeury);
        deplacementpossible = deplacementpossible && this.env.encoreSurleJeu(ptest);
        return deplacementpossible;
    }

}

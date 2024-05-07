package com.example.zeldalike.modele;

public class Personnage {
    int hp;
    int def;
    int vitesse;

    public Personnage(int hp, int def, int vitesse) {
        this.hp = hp;
        this.def = def;
        this.vitesse = vitesse;
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



}

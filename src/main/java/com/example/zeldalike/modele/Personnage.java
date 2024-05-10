package com.example.zeldalike.modele;

public abstract class Personnage  {
    private int hp;
    private int def;
    private int vitesse;
    private int x;
    private int y;
    private Environnement env;



    public Personnage(int hp, int def, int vitesse, int x, int y,Environnement env) {
        this.hp = hp;
        this.def = def;
        this.vitesse = vitesse;
        this.x = x;
        this.y = y;
        this.env = env;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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

}

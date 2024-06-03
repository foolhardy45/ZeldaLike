package com.example.zeldalike.modele;

public abstract class Arme {
    private int attaque;

    public Arme(int attaque) {
        this.attaque = attaque;

    }

    public int  getAttaque() {
    return this.attaque;
    }

}

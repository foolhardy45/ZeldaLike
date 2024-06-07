package com.example.zeldalike.modele;

public class Gun extends Arme{
    private Munition[] nombreDeBalle;
    public Gun(int attaque,Munition [] nombreDeBalle, Joueur j) {
        super(attaque, j);
        this.nombreDeBalle = nombreDeBalle;
    }

    @Override
    public void faireUneAttaque() {

    }
}

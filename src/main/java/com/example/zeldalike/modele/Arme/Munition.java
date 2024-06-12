package com.example.zeldalike.modele.Arme;

public class Munition {
    private int degats;
    private int vitesse;
    private static int id = 0;
    private  String idMunition;

    public Munition() {
        this.degats = 4;
        this.vitesse = 2;
        id++;
        this.idMunition = "E" + id;
    }

    public int getDegats() {
        return degats;
    }

}

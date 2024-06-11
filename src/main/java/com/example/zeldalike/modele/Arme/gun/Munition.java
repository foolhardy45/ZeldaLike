package com.example.zeldalike.modele.Arme.gun;

import com.example.zeldalike.modele.ObjetRecuperables;
import com.example.zeldalike.modele.Position;

public class Munition extends ObjetRecuperables {
    private int degats;
    private int vitesse;
    private static int id = 0;
    private  String idMunition;

    public Munition(Position p) {
        super(p);
        this.degats = 4;
        this.vitesse = 2;
        id++;
        this.idMunition = "E" + id;
    }

    public int getDegats() {
        return degats;
    }

}

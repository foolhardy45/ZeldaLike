package com.example.zeldalike.modele.Arme.gun;

import com.example.zeldalike.modele.Arme.Arme;
import com.example.zeldalike.modele.Joueur;
import com.example.zeldalike.modele.Position;
import com.sun.management.UnixOperatingSystemMXBean;

import java.util.ArrayList;
import java.util.List;

public class Gun extends Arme {
private List<Munition> projectilles = new ArrayList<>();
    public Gun(Joueur j) {
        super(5, j);
    }



    @Override
    public void faireUneAttaque() {
        if (!this.getJoueur().getMunitions().isEmpty()){
            Position currentPosition = new Position(this.getJoueur().getP().getX(), this.getJoueur().getP().getY());
            Munition munition = new Munition(currentPosition,this.getJoueur().positionPre);
            projectilles.add(munition);
            this.getJoueur().retirerMunition(munition);

        }

    }

}

package com.example.zeldalike.modele.Arme;

import com.example.zeldalike.modele.Joueur;
import com.example.zeldalike.modele.Personnage;

import java.util.ArrayList;

public class Poing extends Arme {
    public Poing(Joueur joueur) {
        super(30, joueur);
    }


    @Override
    public void faireUneAttaque() {
        ArrayList<Personnage> ennemisProche = this.toucherPersonnage();
        for (Personnage personnage : ennemisProche) {
            hit(personnage);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Poing";
    }
}

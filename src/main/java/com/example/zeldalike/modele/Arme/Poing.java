package com.example.zeldalike.modele.Arme;

import com.example.zeldalike.modele.Joueur;
import com.example.zeldalike.modele.Personnage;

public class Poing extends Arme {
    public Poing(Joueur joueur) {
        super(5, joueur);
    }


    @Override
    public void faireUneAttaque() {
        Personnage ennemisProche = this.toucherPersonnage();
        if (ennemisProche != null) {
            hit(ennemisProche);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Poing";
    }
}

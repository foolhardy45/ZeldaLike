package com.example.zeldalike.modele;

public class Poing extends Arme {
    public Poing(Joueur joueur) {
        super(5,joueur);
    }


    @Override
    public void faireUneAttaque() {
        Personnage ennemisProche = this.getJoueur().getEnnemiProche();
        if (ennemisProche != null) {
            hit(ennemisProche);

        }
    }


}

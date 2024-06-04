package com.example.zeldalike.modele;

import com.example.zeldalike.vues.ObjetVue;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import com.example.zeldalike.vues.JoueurVue;

public class Joueur extends Personnage {
    private Queue<Character> déplacement;
    private boolean interaction;
    private Inventaire sac;

    public void setInteraction(boolean interaction) {
        this.interaction = interaction;
    }

    public Joueur(int hp, int def, Position p, Environnement env, Terrain terrain) {
        super(hp, def, 4, p, env, terrain);
        this.sac = new Inventaire();

    }


    @Override
    public void personnageTouche(Personnage p) {
        //System.out.println("Personnage Touché - Joueur");
        if (p instanceof Ennemis) {
            //System.out.println(" ayyyyyyyaaaaaaaa");
            this.frapper(p);
        }
    }


    public void attaquer() {
        Personnage ennemi = this.getEnnemiProche();
        if (ennemi != null) {
            frapper(ennemi);
        }
    }

    public Personnage getEnnemiProche() {
        Personnage ennemiProche = null;
        int distanceMin = 38;

        for (Personnage ennemi : this.getEnv().getEnnemis()) {
            if (ennemi.enVie()) {
                int distance = distanceEntreDeuxPersonnages(this, ennemi);
                if (distance < distanceMin) {
                    System.out.println("il est a " + distance);
                    distanceMin = distance;
                    ennemiProche = ennemi;
                }
            }
        }

        return ennemiProche;
    }
    public void interact (){
        ObjetRecuperables objet=null;
        if (this.interaction) {
            for (ObjetRecuperables o : this.getEnv().getObjet()) {
                if (this.getP().collisionEntreSprites(o.getP())||this.getP().surSprites(o.getP())) {
                    objet=o;
                }
            }
            if (objet instanceof PotionVitale || objet instanceof cle){
                this.getSac().ajoutInventaire(objet);
                this.getEnv().sortirObjet(objet);
            }
            interaction=false;
        }
    }



    public Inventaire getSac() {
        return sac;
    }
}

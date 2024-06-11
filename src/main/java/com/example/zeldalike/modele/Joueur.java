package com.example.zeldalike.modele;

import com.example.zeldalike.modele.Arme.Arme;
import com.example.zeldalike.modele.Arme.Poing;
import com.example.zeldalike.modele.Arme.gun.Gun;
import com.example.zeldalike.modele.Arme.gun.Munition;

import java.util.ArrayList;
import java.util.Queue;

public class Joueur extends Personnage {
    private Queue<Character> déplacement;
    private boolean interaction;
    private Inventaire sac;
    private Arme arme;
    private boolean faitUneAttaque = false;
    private ArrayList<Munition> munitions;

    public void setInteraction(boolean interaction) {
        this.interaction = interaction;
    }

    public Joueur(int def, Position p, Environnement env, Terrain terrain) {
        super(2, def, 4, p, env, terrain);
        this.sac = new Inventaire();
        this.arme = new Gun(this);
        this.munitions = new ArrayList<>();

    }

    public void changerArme(Arme a){
        this.arme = a;
    }

    public ArrayList<Munition> getMunitions() {
        return munitions;
    }
    public void ajouterMunition(Munition m) {
        munitions.add(m);
    }
    public void retirerMunition(Munition m) {
        munitions.remove(m);
    }

    public Arme getArme() {
        return arme;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }


    public boolean isFaitUnAttaque() {
        return faitUneAttaque;
    }

    public void setFaitUnAttaque(boolean faitUnAttaque) {
        this.faitUneAttaque = faitUnAttaque;
    }

    @Override
    public void personnageTouche(Personnage p) {
        //System.out.println("Personnage Touché - Joueur");
        if (p instanceof Ennemis) {
            //System.out.println(" ayyyyyyyaaaaaaaa");
        }
    }

    public void attaquer() {
        this.getArme().faireUneAttaque();
    }

    public Personnage getEnnemiProche() {
        Personnage ennemiProche = null;
        int distanceMin = 50;

        for (Personnage ennemi : this.getEnv().getEnnemis()) {
            if (ennemi.enVie()) {
                int distance = distanceEntreDeuxPersonnages(this, ennemi);
                if(ennemi instanceof Ennemis) {
                    if (distance < distanceMin) {

                        System.out.println("il est a " + distance);
                        distanceMin = distance;
                        ennemiProche = ennemi;
                    }
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
            if (objet instanceof PotionVitale || objet instanceof Cle){
                this.getSac().ajoutInventaire(objet);
            }
            if (objet instanceof Munition) {
                this.ajouterMunition((Munition) objet);
            }
            this.getEnv().sortirObjet(objet);
            interaction=false;
        }
    }

    public void updateProjectiles(){
        for (Munition munition : munitions){
            munition.move();
        }
        munitions.removeIf(munition -> !this.getTerrain().estDansTerrain(munition.getP().getX(), munition.getP().getY()));
    }



    public Inventaire getSac() {
        return sac;
    }
}

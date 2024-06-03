package com.example.zeldalike.modele;

import com.example.zeldalike.vues.JoueurVue;

public class Joueur extends Personnage {
    private Inventaire sac;
    private JoueurVue joueurVue;

    public Joueur(int hp, int def, Position p, Environnement env, Terrain terrain) {
        super(hp, def, 4, p, env,terrain);
        this.sac = new Inventaire();
        this.joueurVue = new JoueurVue(this,this.getArme());

    }



    @Override
    public void personnageTouche(Personnage p) {
        //System.out.println("Personnage Touché - Joueur");
        if (p instanceof Ennemis){
            //System.out.println(" ayyyyyyyaaaaaaaa");
            this.frapper(p);
        }
    }



    public void attaquer(){
        this.joueurVue.afficherArmeView();
        Personnage ennemi = this.getEnnemiProche();
        if (ennemi != null){
            frapper(ennemi);
        }
    }

    public Personnage getEnnemiProche() {
        Personnage ennemiProche = null;
        int distanceMin = 38;

        for (Personnage ennemi : this.getEnv().getEnnemis()) {
            if (ennemi.enVie()) {
                int distance = distanceEntreDeuxPersonnages(this,ennemi);
                if (distance < distanceMin) {
                    System.out.println("il est a "+ distance);
                    distanceMin = distance;
                    ennemiProche = ennemi;
                }
            }
        }

        return ennemiProche;
    }



    public Inventaire getSac() {
        return sac;
    }
}

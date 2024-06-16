package com.example.zeldalike.modele.Arme.gun;

import com.example.zeldalike.modele.Arme.Arme;
import com.example.zeldalike.modele.Joueur;
import com.example.zeldalike.modele.Position;

import java.util.ArrayList;

public class Gun extends Arme {
    private ArrayList<Munition> listemunitions;

    public Gun(Joueur j) {
        super(50, j);
        this.listemunitions = new ArrayList<Munition>();
    }

   /* public boolean aMuni(){
        return munitions > 0;
    }

    public void retirerMuni(){
        if (aMuni()){
            munitions--;
        }
    }

    public int getMunitions(){
        return munitions;
    }

    public void setMunitions(int munitions){
        this.munitions = munitions;
    }
*/

    public ArrayList<Munition> getListeMunitions() {
        return listemunitions;
    }

    public void setListeMunitions(ArrayList<Munition> listemunitions) {
        this.listemunitions = listemunitions;
    }

    public void ajouterMunition(Munition munition) {
        this.listemunitions.add(munition);
    }

    @Override
    public void faireUneAttaque() {
        if (!this.listemunitions.isEmpty()) {
            // Récupère la première munition de la liste
            System.out.println(this.listemunitions);
            Munition mune = this.listemunitions.getFirst();


            // Met à jour la position de la munition
            mune.setP(new Position(this.getJoueur().getP().getX(), this.getJoueur().getP().getY()));
            // Met à jour la direction de la munition
            mune.setDirection(this.getJoueur().getPositionPre());

            // Ajoute la munition à la liste de munitions du joueur seulement si elle n'y est pas déjà
            if (!this.getJoueur().getMunitionObservableList().contains(mune)) {
                this.getJoueur().getMunitionObservableList().add(mune);

            } else {

            }

            // Retire la munition de la liste originale
            this.listemunitions.remove(mune);
            //retire la munition du sac
            this.getJoueur().getSac().retireInventaire(mune);

        } else {
            System.out.println("tu n'as aucune balle");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "GUN";
    }
}

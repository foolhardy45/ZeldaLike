package com.example.zeldalike.modele.Arme.gun;

import com.example.zeldalike.modele.Arme.Arme;
import com.example.zeldalike.modele.Joueur;
import com.example.zeldalike.modele.Position;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Gun extends Arme {
    private ObservableList<Munition> munitionObservableList;

    public Gun(Joueur j) {
        super(5, j);
        this.munitionObservableList = FXCollections.observableArrayList();
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

    public ObservableList<Munition> getMunitionObservableList() {
        return munitionObservableList;
    }

    public void ajouterMunition(Munition munition) {
        this.munitionObservableList.add(munition);
    }

    @Override
    public void faireUneAttaque() {
        if (!this.munitionObservableList.isEmpty()) {
            // Récupère la première munition de la liste
            Munition mune = this.munitionObservableList.get(0);


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
            this.munitionObservableList.remove(mune);
            //retire la munition du sac
            this.getJoueur().getSac().retireInventaire(mune);

        } else {
            System.out.println("tu n'as aucune balle");
        }
    }


}

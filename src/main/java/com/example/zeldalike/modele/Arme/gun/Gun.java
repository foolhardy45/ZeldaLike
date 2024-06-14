package com.example.zeldalike.modele.Arme.gun;

import com.example.zeldalike.modele.Arme.Arme;
import com.example.zeldalike.modele.Joueur;
import com.example.zeldalike.modele.Position;
import com.sun.management.UnixOperatingSystemMXBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void faireUneAttaque() {
        if (!this.munitionObservableList.isEmpty()) {
            // Récupère la première munition de la liste
            Munition mune = this.munitionObservableList.getFirst();
            System.out.println("Préparation à tirer la munition : " + mune);

            // Met à jour la position de la munition
            mune.setP(new Position(this.getJoueur().getP().getX(), this.getJoueur().getP().getY()));
            // Met à jour la direction de la munition
            mune.setDirection(this.getJoueur().getPositionPre());

            // Ajoute la munition à la liste de munitions du joueur seulement si elle n'y est pas déjà
            if (!this.getJoueur().getMunitionObservableList().contains(mune)) {
                this.getJoueur().getMunitionObservableList().add(mune);
                System.out.println("Munition ajoutée à la liste du joueur : " + mune);
            } else {
                System.out.println("Munition déjà présente dans la liste du joueur : " + mune);
            }

            // Retire la munition de la liste originale
            this.munitionObservableList.removeFirst();
            System.out.println("Munition retirée de la liste des munitions disponibles : " + mune);
        } else {
            System.out.println("tu n'as aucune balle");
        }
    }


}

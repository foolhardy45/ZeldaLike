package com.example.zeldalike.algos;

import com.example.zeldalike.modele.Environnement;
import com.example.zeldalike.modele.Joueur;
import com.example.zeldalike.modele.Terrain;

public class CarteBFS {

    private int[] carte;
    private Joueur j;
    private int largeur;

    public static int passageinterdit = 64;

    public CarteBFS(Terrain t, Joueur j){
        this.j = j;
        this.carte = new int[t.tailleTerrain()];
        this.largeur = t.getTailleLargeur();
        for (int i = 0; i < this.carte.length; i++) {
            if (t.codeCaseI(i) == 2){
                this.carte[i] = 0;
            }
            else {
                this.carte[i] = passageinterdit;
            }
        }
    }

    public void rapportposition(){

    }

    @Override
    public String toString() {
        String texte = "";
        for (int i = 0; i < this.carte.length; i++) {
            texte += " " + this.carte[i] + ",";
            if (i % this.largeur == 0){
                texte += "\n";
            }
        }
        return texte;
    }
}

package com.example.zeldalike.algos;

import com.example.zeldalike.modele.Environnement;
import com.example.zeldalike.modele.Joueur;

public class CarteBFS {

    private int[] carte;
    private Joueur j;

    public CarteBFS(Environnement env){
        this.j =  env.getJ1();
        this.carte = new int[env.getTerrain().tailleTerrain()];
        for (int i = 0; i < env.getTerrain().tailleTerrain(); i++) {
            if (env.getTerrain().codeCaseI(i) == 2){
                this.carte[i] = 0;
                System.out.print(" 0,");
            }
            else {
                this.carte[i] = -1;
                System.out.print(" -1,");
            }
            if (i % env.getTerrain().getTailleLargeur() == 0){
                System.out.println();
            }
        }
    }
}

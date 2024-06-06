package com.example.zeldalike.algos;

import com.example.zeldalike.modele.Environnement;
import com.example.zeldalike.modele.Joueur;
import com.example.zeldalike.modele.Terrain;

import java.util.ArrayList;
import java.util.LinkedList;

public class CarteBFS {

    private int[] carte;
    private Joueur j;
    private int largeur;
    private int distancemax;
    private Terrain t;
    private static int passageinterdit = 64;

    public CarteBFS(Terrain t, Joueur j){
        this.j = j;
        this.t = t;
        this.carte = new int[t.tailleTerrain()];
        this.distancemax = 9;
        this.largeur = t.getTailleLargeur();
        reinitCarte();
    }

    public void reinitCarte(){
        for (int i = 0; i < this.carte.length; i++) {
            if (t.codeCaseI(i) == 2){
                this.carte[i] = distancemax+1;
            }
            else {
                this.carte[i] = passageinterdit;
            }
        }
    }

    public void miseAJourCarte(){


        int x = this.j.getP().getX()+this.j.getHitbox();
        int y = this.j.getP().getY()+this.j.getHitbox();
        int tailletuile = this.j.getEnv().getTerrain().getTailleTuile();
        reinitCarte();
        LinkedList<Integer> marques = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();

        //this.carte[t.getIndiceCaseSousPosition(x,y)] = 0;
        marques.addFirst(t.getIndiceCaseSousPosition(x,y));
        int actuel;

        int distance = 0;
        while (distance < distancemax){
            while (!marques.isEmpty()) {
                temp.add(marques.pollLast());
            }
            while(!temp.isEmpty()) {
                actuel = temp.pollLast();
                this.carte[actuel] = distance;
                for (int indice : t.getIndicesAdjacentsAvecIndice(actuel)) {
                    if (!marques.contains(indice) && !temp.contains(indice) && this.carte[indice] > distance && this.carte[indice] != passageinterdit) {
                        marques.addFirst(indice);
                    }
                }
            }
            distance++;
        }
    }

    public int getValeurCaseI(int i){
            return this.carte[i];
    }

    @Override
    public String toString() {
        String texte = "";
        for (int i = 0; i < this.carte.length; i++) {
            texte +=" ";
            if (this.carte[i]<10){
                texte+= "0";
            }
            texte += this.carte[i] + ",";
            if ((i+1) % this.largeur == 0){
                texte += "\n";
            }
        }
        return texte;
    }


    public int indiceMinimumVal(int indiceposition){
        ArrayList<Integer> adj = this.j.getEnv().getTerrain().getIndicesAdjacentsAvecIndice(indiceposition);
        int indicepluspetit = -1;
        if (!adj.isEmpty()) {
            int minimum = this.carte[adj.get(0)];
            indicepluspetit = adj.get(0);
            for (int i=1 ; i<adj.size() ; i++){
                if (minimum > this.carte[adj.get(i)]){
                    minimum = this.carte[adj.get(i)];
                    indicepluspetit = adj.get(i);
                }
            }
        }
        return indicepluspetit;
    }
}
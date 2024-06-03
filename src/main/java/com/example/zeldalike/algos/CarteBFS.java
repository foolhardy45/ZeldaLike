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
        this.distancemax = 10;
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


        int x = this.j.getP().getX();
        int y = this.j.getP().getY();
        int tailletuile = this.j.getEnv().getTerrain().getTailleTuile();
        reinitCarte();
        LinkedList<Integer> marques = new LinkedList<>();

        this.carte[t.getIndiceCaseSousPosition(x,y)] = 0;
        marques.addFirst(t.getIndiceCaseSousPosition(x,y));
        int actuel;

        int distance = 1;
        while (distance < distancemax && !marques.isEmpty()){
            actuel = marques.pollLast();
            for (int indice : t.getIndicesAdjacentsAvecIndice(actuel)){
                if (this.carte[indice] < passageinterdit && !marques.contains(indice)){
                    marques.addFirst(indice);
                    this.carte[indice] = distance;
                }
            }
            distance++;
            /*//4 diagonales
            if (t.estAutorisé(x+(distance*tailletuile),y+(distance*tailletuile))){ // en bas à droite
                System.out.println("A1");
                this.carte[t.getIndiceCaseSousPosition(x+(distance*tailletuile),y+(distance*tailletuile))] = distance;

            }if (t.estAutorisé(x-(distance*tailletuile),y+(distance*tailletuile))){ // en bas à gauche
                System.out.println("A2");
                this.carte[t.getIndiceCaseSousPosition(x-(distance*tailletuile),y+(distance*tailletuile))] = distance;
            }
            if (t.estAutorisé(x-(distance*tailletuile),y-(distance*tailletuile))){ // en haut à gauche
                System.out.println("A3");
                this.carte[t.getIndiceCaseSousPosition(x-(distance*tailletuile),y-(distance*tailletuile))] = distance;
            }
            if (t.estAutorisé(x+(distance*tailletuile),y-(distance*tailletuile))){ // en haut à droite
                System.out.println("A4");
                this.carte[t.getIndiceCaseSousPosition(x+(distance*tailletuile),y-(distance*tailletuile))] = distance;
            }
            System.out.println("génial");

            //4 directions
            for (int i=0; i<distance*2-1;i++)
                if (t.estAutorisé(x+(distance*tailletuile), y+tailletuile*(distance-i-1) )){ // à droite
                    this.carte[t.getIndiceCaseSousPosition(x+(distance*tailletuile), y+tailletuile*(distance-i-1))] = distance;

                }
             */
        }
        System.out.println(this);
        System.out.println("super");
    }

    @Override
    public String toString() {
        String texte = "";
        for (int i = 0; i < this.carte.length; i++) {
            texte += " " + this.carte[i] + ",";
            if ((i+1) % this.largeur == 0){
                texte += "\n";
            }
        }
        return texte;
    }
}
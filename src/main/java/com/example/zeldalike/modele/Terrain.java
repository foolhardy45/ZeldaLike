package com.example.zeldalike.modele;

import java.util.ArrayList;

public class Terrain {
    private int[] carte_terrain;
    private int tailleLargeur;
    private int tailleTuile;
    private int tailleHauteur;

    public Terrain() {
         this.carte_terrain = new int[]{
                2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2,
                1, 1, 1, 1, 2, 2, 1, 1, 2, 2, 3, 3, 3, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2,
                2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 2, 3, 3, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2,
                2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 3, 3, 3, 2, 2, 2, 3, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 3, 3, 2, 2, 2, 2, 3, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2,
                2, 2, 2, 3, 3, 3, 3, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2,
                2, 2, 2, 2, 3, 3, 3, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2,
                2, 2, 2, 2, 3, 3, 3, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2,
                2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 3, 3, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2,
                3, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2,
                3, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2,
                3, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2,
                3, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2,
                3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2};

        this.tailleLargeur = 24;
        this.tailleTuile = 32;
        this.tailleHauteur = 26;
    }


    public int tailleTerrain(){
        return this.carte_terrain.length;
    }

    public int codeCaseI(int i){
        return this.carte_terrain[i];
    }

    /*
    Retourne true si la tuile sur laquelle est le point (x,y) est une tuile sur laquelle on a le droit de marcher.
     */
    public boolean estAutorisé(int x, int y) {
        if (estDansTerrain(x, y)) {
            return codeCaseI(getIndiceCaseSousPosition(x, y)) == 2;
        }
        return false;
    }

    public boolean estAutoriséIndice(int indice){
        if (estDansTerrainIndice(indice)){
            return codeCaseI(indice) == 2;
        }
        return false;
    }

    public boolean estDansTerrain(int x, int y) {
        return (x >= 0 && x < tailleLargeur * tailleTuile) && (y >= 0 && y < tailleHauteur * tailleTuile);
    }

    public boolean estDansTerrainIndice(int indice){
        return indice>=0 && indice < this.carte_terrain.length;
    }

    public int getIndiceCaseSousPosition(int x, int y){
        return (x / tailleTuile + (y / tailleTuile) * (tailleLargeur));
    }

    public int getTailleLargeur() {
        return tailleLargeur;
    }

    public int getTailleTuile(){
        return tailleTuile;
    }

    public ArrayList<Integer> getIndicesAdjacent(int x, int y){
        ArrayList<Integer> adjacents = new ArrayList<>();

        if (estDansTerrain(x, y)){
            if (estDansTerrain(x+tailleTuile,y)){
                adjacents.add(getIndiceCaseSousPosition(x+tailleTuile,y));
                System.out.println(6);
            }
            if (estDansTerrain(x+tailleTuile, y+tailleTuile)){
                adjacents.add(getIndiceCaseSousPosition(x+tailleTuile,y+tailleTuile));
                System.out.println(3);
            }
            if (estDansTerrain(x+tailleTuile, y-tailleTuile)){
                adjacents.add(getIndiceCaseSousPosition(x+tailleTuile,y-tailleTuile));
                System.out.println(9);
            }
            if (estDansTerrain(x, y-tailleTuile)){
                adjacents.add(getIndiceCaseSousPosition(x,y-tailleTuile));
                System.out.println(8);
            }
            if (estDansTerrain(x, y+tailleTuile)){
                adjacents.add(getIndiceCaseSousPosition(x,y+tailleTuile));
                System.out.println(2);
            }
            if (estDansTerrain(x-tailleTuile, y-tailleTuile)){
                adjacents.add(getIndiceCaseSousPosition(x-tailleTuile,y-tailleTuile));
                System.out.println(7);
            }
            if (estDansTerrain(x-tailleTuile, y)){
                adjacents.add(getIndiceCaseSousPosition(x-tailleTuile,y));
                System.out.println(4);
            }
            if (estDansTerrain(x-tailleTuile, y+tailleTuile)){
                adjacents.add(getIndiceCaseSousPosition(x-tailleTuile,y+tailleTuile));
                System.out.println(1);
            }
        }

        return adjacents;
    }

    public ArrayList<Integer> getIndicesAdjacentsAutorises(int x, int y){
        ArrayList<Integer> adjacents = getIndicesAdjacent(x, y);
        ArrayList<Integer> adjacentsautorises = new ArrayList<>();
        for (int i : adjacents){
            if (!estAutoriséIndice(i)){
                adjacentsautorises.add(i);
            }
        }
        return adjacentsautorises;
    }

    public ArrayList<Integer> getIndicesAdjacentsAvecIndice(int indice){
        return getIndicesAdjacent((indice % this.tailleLargeur)*this.tailleTuile, (indice / this.tailleLargeur )*tailleTuile);
    }
}

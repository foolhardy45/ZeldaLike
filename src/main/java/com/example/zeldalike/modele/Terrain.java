package com.example.zeldalike.modele;

public class Terrain {
    private int[] carte_terrain;
    private int tailleLargeur;

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
        return true; //TODO
    }

    public boolean estDansTerrain(int x, int y) {
        return true;
    }

    public int getTailleLargeur() {
        return tailleLargeur;
    }
}

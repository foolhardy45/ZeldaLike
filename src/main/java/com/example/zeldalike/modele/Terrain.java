package com.example.zeldalike.modele;

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

    public boolean estDansTerrain(int x, int y) {
        return (x >= 0 && x < tailleLargeur * tailleTuile) && (y >= 0 && y < tailleHauteur * tailleTuile);
    }

    public int getIndiceCaseSousPosition(int x, int y){
        return (x / tailleTuile + (y / tailleTuile) * tailleLargeur);
    }

    public int getTailleLargeur() {
        return tailleLargeur;
    }

    public int getTailleTuile(){
        return tailleTuile;
    }
}

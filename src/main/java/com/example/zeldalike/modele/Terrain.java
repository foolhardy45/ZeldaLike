package com.example.zeldalike.modele;

public class Terrain {
    int[] map;

    public Terrain() {
        this.map = new int[]{
                1, 1, 1, 1, 1,
                2, 2, 1, 1, 3,
                2, 2, 1, 1, 3,
                1, 1, 1, 1, 1,
                1, 1, 1, 1, 1};
    }

    public int[] getMap() {
        return map;
    }
}

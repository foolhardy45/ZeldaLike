package com.example.zeldalike.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {
    private Joueur j1;
    private ObservableList<Ennemis> ennemis;
    private int height;
    private  int width;
    private Terrain terrain;
    private   int deltaTime;

    public Environnement( int height, int width) {
        Position p = new Position(0,0);
        this.j1 = new Joueur(1,1,p,this);
        this.ennemis = FXCollections.observableArrayList();
        this.height = height;
        this.width = width;
        this.terrain = new Terrain();
        this.deltaTime = 0;
    }

    public Joueur getJ1() {
        return j1;
    }
    public void ajouterEnnemis(Ennemis ennemis) {
        this.ennemis.add(ennemis);
    }

    public ObservableList<Ennemis> getEnnemis() {
        return ennemis;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Terrain getTerrain() {
        return terrain;
    }
    public void unTour(){
        //this.getJ1().faireUnDeplacement(deltaTime);
        deltaTime++;
    }
}
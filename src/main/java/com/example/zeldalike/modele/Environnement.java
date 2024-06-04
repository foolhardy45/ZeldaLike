package com.example.zeldalike.modele;

import com.example.zeldalike.algos.CarteBFS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {
    private Joueur j1;
    private ObservableList<Ennemis> ennemis;
    private int height;
    private int width;
    private Terrain terrain;
    private CarteBFS bfs_joueur;
    private int deltaTime;


    public Environnement( int height, int width) {
        Position p = new Position(0,0);
        this.terrain = new Terrain();
        this.j1 = new Joueur(10,0,p,this,terrain);
        this.bfs_joueur = new CarteBFS(this.terrain, this.j1);
        this.ennemis = FXCollections.observableArrayList();
        this.height = height;
        this.width = width;
        this.deltaTime = 0;
    }

    public Joueur getJ1() {
        return j1;
    }
    public CarteBFS getBfs_joueur(){
        return bfs_joueur;
    }
    public void ajouterEnnemis(Ennemis ennemis) {
        this.ennemis.add(ennemis);
    }

    public void sortirEnnemis(Ennemis ennemis) {
        this.ennemis.remove(ennemis);
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
        this.getJ1().move();
        this.bfs_joueur.miseAJourCarte();
        if(!ennemis.isEmpty()) {
            for (int i = 0; i < ennemis.size(); i++) {
                ennemis.get(i).deplacementBFS();
                if (ennemis.get(i).verificationCollision(this.getJ1())) {
                    //ennemis.projection(this.getJ1(),deltaTime);
                }
                if (!ennemis.get(i).enVie()) {
                    sortirEnnemis(ennemis.get(i));
                }
            }
        }
        deltaTime++;
    }
}
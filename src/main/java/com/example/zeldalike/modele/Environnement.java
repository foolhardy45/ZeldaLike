package com.example.zeldalike.modele;

import com.example.zeldalike.algos.CarteBFS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {
    private static int cooldown = 0;
    private Joueur j1;
    private ObservableList<Ennemis> ennemis;
    private ObservableList<ObjetRecuperables> objet;
    private int height;
    private int width;
    private Terrain terrain;
    private CarteBFS bfs_joueur;

    public Environnement(int height, int width) {
        Position p = new Position(96, 65);
        this.terrain = new Terrain();
        this.j1 = new Joueur(12, p, this, terrain);
        this.bfs_joueur = new CarteBFS(this.terrain, this.j1);
        this.ennemis = FXCollections.observableArrayList();
        this.objet = FXCollections.observableArrayList();
        this.height = height;
        this.width = width;

    }

    public Joueur getJ1() {
        return j1;
    }

    public CarteBFS getBfs_joueur() {
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

    public void ajouterObjet(ObjetRecuperables objet) {
        this.objet.add(objet);
        System.out.println("la");
    }

    public void sortirObjet(ObjetRecuperables objet) {
        this.objet.remove(objet);
    }

    public ObservableList<ObjetRecuperables> getObjet() {
        return objet;
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

    public void verifierCollisions() {
        for (int i = 0; i < ennemis.size(); i++) {
            if (ennemis.get(i).collidesWith(j1)) {
                ennemis.get(i).repousserPersonnages(j1, ennemis.get(i));
            }
        }
    }


    public void unTour() {
        this.getJ1().move();
        this.bfs_joueur.miseAJourCarte();
        this.getJ1().interact();
        this.getJ1().updateProjectiles();
        System.out.println(this.getJ1().getP().getX());
        System.out.println(this.getJ1().getP().getY());

        if (!ennemis.isEmpty()) {
            for (int i = 0; i < ennemis.size(); i++) {
                ennemis.get(i).agir();
                ennemis.get(i).compétence();
                if (!ennemis.get(i).enVie()) {
                    ennemis.get(i).désacCompétence();
                    ennemis.get(i).dropObjet();
                    sortirEnnemis(ennemis.get(i));
                }
            }
        }
        verifierCollisions();
        cooldown++;

    }
}

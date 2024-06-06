package com.example.zeldalike.modele;

import com.example.zeldalike.algos.CarteBFS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {
    private Joueur j1;
    private ObservableList<Ennemis> ennemis;
    private ObservableList<ObjetRecuperables> objet;
    private int height;
    private int width;
    private Terrain terrain;
    private CarteBFS bfs_joueur;
    private int deltaTime;

    public Environnement(int height, int width) {
        Position p = new Position(0, 0);
        this.terrain = new Terrain();
        this.j1 = new Joueur(10, 0, p, this, terrain);
        this.bfs_joueur = new CarteBFS(this.terrain, this.j1);
        this.ennemis = FXCollections.observableArrayList();
        this.objet = FXCollections.observableArrayList();
        this.height = height;
        this.width = width;
        this.deltaTime = 0;
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
            for (int j = i + 1; j < ennemis.size(); j++) {
                /*Personnage p1 = ennemis.get(i);
                Personnage p2 = ennemis.get(j);
                if (p1.collidesWith(p2)) {
                    repousserPersonnages(p1, p2);
                }*/
            }
            if (ennemis.get(i).collidesWith(j1)) {
                repousserPersonnages(j1, ennemis.get(i));
            }
        }
    }

    private void repousserPersonnages(Personnage p1, Personnage p2) {
        int dx = p1.getP().getX() - p2.getP().getX();
        int dy = p1.getP().getY() - p2.getP().getY();
        int distance = (int) Math.sqrt(dx * dx + dy * dy);
        if (distance == 0) return;

        int repulsionForce = 12;
        int repulsionX = (dx / distance) * repulsionForce;
        int repulsionY = (dy / distance) * repulsionForce;

        boolean p1CanMove =
                        terrain.estAutorisé(p1.getP().getX() + repulsionX, p1.getP().getY() + repulsionY) &&
                        terrain.estAutorisé(p1.getP().getX() + p1.getHitbox() + repulsionX, p1.getP().getY() + repulsionY) &&
                        terrain.estAutorisé(p1.getP().getX() + repulsionX, p1.getP().getY()+ p1.getHitbox() + repulsionY) &&
                        terrain.estAutorisé(p1.getP().getX()+ p1.getHitbox() + repulsionX, p1.getP().getY() +p1.getHitbox()+ repulsionY);
        boolean p2CanMove =
                        terrain.estAutorisé(p2.getP().getX() - repulsionX, p2.getP().getY() - repulsionY) &&
                        terrain.estAutorisé(p2.getP().getX()+ p2.getHitbox()-repulsionX,p2.getP().getY() - repulsionY ) &&
                        terrain.estAutorisé(p2.getP().getX()-repulsionX,p2.getP().getY()+ p2.getHitbox() - repulsionY ) &&
                        terrain.estAutorisé(p2.getP().getX()+p2.getHitbox()-repulsionX,p2.getP().getY() + p2.getHitbox()-repulsionY);


        if (p1CanMove && p2CanMove) {
            p1.move(repulsionX, repulsionY);
            p2.move(-repulsionX, -repulsionY);
        } else if (p1CanMove) {
            p1.move(repulsionX, repulsionY);
        } else if (p2CanMove) {
            p2.move(-repulsionX, -repulsionY);
        }
    }

    public void unTour() {
        this.getJ1().move();
        this.bfs_joueur.miseAJourCarte();
        this.getJ1().interact();
        if (!ennemis.isEmpty()) {
            for (int i = 0; i < ennemis.size(); i++) {
                ennemis.get(i).deplacementBFS();

                if (!ennemis.get(i).enVie()) {
                    sortirEnnemis(ennemis.get(i));
                }
            }
        }
        verifierCollisions();
        deltaTime++;
    }
}

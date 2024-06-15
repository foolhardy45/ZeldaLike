package com.example.zeldalike.modele;

import com.example.zeldalike.modele.Arme.Arme;
import com.example.zeldalike.modele.Arme.Poing;
import com.example.zeldalike.modele.Arme.gun.Gun;
import com.example.zeldalike.modele.Arme.gun.Munition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.LinkedList;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import com.example.zeldalike.vues.JoueurVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;

public class Joueur extends Personnage {
    private Queue<Character> déplacement;
    private boolean interaction;
    private Inventaire sac;
    private Arme arme;
    private boolean faitUneAttaque = false;
    private ObservableList<Munition> munitionObservableList;
    private int direction = this.getPositionPre();

    private IntegerProperty argent;

    public void setInteraction(boolean interaction) {
        this.interaction = interaction;
    }

    public Joueur(int def, Position p, Environnement env, Terrain terrain) {
        super(4, def, 4, p, env, terrain);
        this.sac = new Inventaire();
        this.arme = new Gun(this);
        this.munitionObservableList = FXCollections.observableArrayList();

    }

    public ObservableList<Munition> getMunitionObservableList() {
        return munitionObservableList;
    }

    public void changerArme(Arme a){
        this.arme = a;
    }

    public IntegerProperty argentProperty() {
        return argent;
    }


    public void donnerMunition() {
        if (this.arme instanceof Gun) {
            System.out.println("Munitions dans le sac avant transfert : " + this.sac.getListeMunition());
            List<Munition> munitions = new ArrayList<>(this.sac.getListeMunition()); // Copier la liste pour éviter ConcurrentModificationException
            for (Munition munition : munitions) {
                if (!((Gun) this.arme).getMunitionObservableList().contains(munition)) {
                    ((Gun) this.arme).getMunitionObservableList().add(munition);
                    this.sac.getListeMunition().remove(munition);
                    System.out.println("Munition transférée au Gun : " + munition);
                }
            }
            System.out.println("Munitions dans le sac après transfert : " + this.sac.getListeMunition());
            System.out.println("Munitions dans le Gun après transfert : " + ((Gun) this.arme).getMunitionObservableList());
        }
    }
    public Arme getArme() {
        return arme;
    }
    public int getArgent() {
        return argent.get();
    }

    public void setArgent(int argent) {
        this.argent.set(argent);
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }


    public boolean isFaitUnAttaque() {
        return faitUneAttaque;
    }

    public void setFaitUnAttaque(boolean faitUnAttaque) {
        this.faitUneAttaque = faitUnAttaque;
    }

    @Override
    public void personnageTouche(Personnage p) {
        //System.out.println("Personnage Touché - Joueur");
        if (p instanceof Ennemis) {
            //System.out.println(" ayyyyyyyaaaaaaaa");
        }
    }

    public void attaquer() {
        System.out.println("faire attaque");
        this.getArme().faireUneAttaque();
    }

    public Personnage getEnnemiProche() {
        Personnage ennemiProche = null;
        int distanceMin = 50;

        for (Personnage ennemi : this.getEnv().getEnnemis()) {
            if (ennemi.enVie()) {
                int distance = distanceEntreDeuxPersonnages(this, ennemi);
                if(ennemi instanceof Ennemis) {
                    if (distance < distanceMin) {

                        System.out.println("il est a " + distance);
                        distanceMin = distance;
                        ennemiProche = ennemi;
                    }
                }
            }
        }

        return ennemiProche;
    }

    public void updateProjectiles() {

        Iterator<Munition> iterator = this.munitionObservableList.iterator();
        while (iterator.hasNext()) {
            Munition munition = iterator.next();
            munition.move();


            boolean removed = false;
            for (Ennemis ennemi : this.getEnv().getEnnemis()) {
                if (munition.collidesWith(ennemi)) {
                    ennemi.subirDegats(munition.getDegats());

                    iterator.remove(); // Utilisez l'iterator pour éviter ConcurrentModificationException
                    removed = true;
                    break; // Sortir de la boucle des ennemis, car la munition a été supprimée
                }
            }
            if (removed) {
                continue; // Si la munition a été supprimée, passez à la suivante
            }

        }
        // Supprimer les projectiles qui sortent du terrain
        munitionObservableList.removeIf(munition -> !this.getTerrain().estDansTerrain(munition.getP().getX(), munition.getP().getY()));
    }




    public void interact() {
        ObjetRecuperables objet = null;
        if (this.interaction) {
            for (ObjetRecuperables o : this.getEnv().getObjet()) {
                if (this.getP().collisionEntreSprites(o.getP()) || this.getP().surSprites(o.getP())) {
                    objet = o;
                    break; // Sortir de la boucle dès qu'un objet est trouvé
                }
            }
            if (objet != null) {
                if (objet instanceof PotionVitale || objet instanceof Cle) {
                    this.getSac().ajoutInventaire(objet);
                } else if (objet instanceof Munition) {
                    this.getSac().ajoutInventaire(objet);
                    this.donnerMunition();
                    System.out.println("Munition ramassée et ajoutée au sac : " + objet);
                }
                this.getEnv().sortirObjet(objet);
            }
            interaction = false;
        }
    }


    public Inventaire getSac() {
        return sac;
    }
}

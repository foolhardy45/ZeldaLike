package com.example.zeldalike.modele;

import com.example.zeldalike.modele.Arme.Arme;
import com.example.zeldalike.modele.Arme.gun.Gun;
import com.example.zeldalike.modele.Arme.gun.Munition;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class Joueur extends Personnage {
    private Queue<Character> déplacement;
    private boolean interaction;
    private Inventaire sac;
    private Arme arme;
    private boolean faitUneAttaque = false;
    private ObservableList<Munition> munitionObservableList;
    private int direction = this.getPositionPre();

    private IntegerProperty argent;
    private boolean hydrophobe;

    public Joueur(int def, Position p, Environnement env, Terrain terrain) {
        super(4, def, 4, p, env, terrain);
        this.sac = new Inventaire();
        this.arme = new Gun(this);
        this.munitionObservableList = FXCollections.observableArrayList();
        this.hydrophobe=false;
    }

    public void setInteraction(boolean interaction) {
        this.interaction = interaction;
    }

    public ObservableList<Munition> getMunitionObservableList() {
        return munitionObservableList;
    }

    public void changerArme(Arme a) {
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

    public void setArme(Arme arme) {
        this.arme = arme;
    }

    public int getArgent() {
        return argent.get();
    }

    public void setArgent(int argent) {
        this.argent.set(argent);
    }

    public boolean isFaitUnAttaque() {
        return faitUneAttaque;
    }

    public void setFaitUnAttaque(boolean faitUnAttaque) {
        this.faitUneAttaque = faitUnAttaque;
    }

    public boolean getHydrophobe() {
        return this.hydrophobe;
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
                if (ennemi instanceof Ennemis) {
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
                if (objet instanceof PotionVitale || objet instanceof Cle ) {
                    this.getSac().ajoutInventaire(objet);

                } else if (objet instanceof ChaussuresHydrophobes) {
                    this.getSac().ajoutInventaire(objet);
                    hydrophobe=true;
                }
                else if (objet instanceof Munition) {
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
    public void move() {
        switch (this.getDirection()) {
            case 1:
                jMoveDown();
                jMoveLeft();
                break;
            case 2:
                jMoveDown();
                break;
            case 3:
                jMoveDown();
                jMoveRight();
                break;
            case 4:
                jMoveLeft();
                break;
            case 5:
                break;
            case 6:
                jMoveRight();
                break;
            case 7:
                jMoveUp();
                jMoveLeft();
                break;
            case 8:
                jMoveUp();
                break;
            case 9:
                jMoveUp();
                jMoveRight();
                break;
        }
        if (this.getDirection() != positionPre && this.getDirection() != 0) {
            setPositionPre(this.getDirection());
            System.out.println(positionPre);
        }
    }
    private void jMoveUp() {
        double nouvellePosY = this.getP().getY() - this.getVitesse();
        int newY = (int) Math.round(nouvellePosY);
        int PosX = this.getP().getX();
        if (this.getTerrain().estDansTerrain(PosX, newY) && getTerrain().estAutorisé(PosX + 1, newY + getHitbox(),hydrophobe) && getTerrain().estAutorisé(PosX + getHitbox(), newY + getHitbox(),hydrophobe)) {
            this.getP().setY(newY);
        }
    }

    private void jMoveDown() {
        double nouvellePosY = this.getP().getY() + this.getVitesse();
        int newY = (int) Math.round(nouvellePosY);
        int PosX = this.getP().getX();
        if (this.getTerrain().estDansTerrain(PosX, newY) && getTerrain().estAutorisé(PosX + 1, newY + getHitbox(),hydrophobe) && getTerrain().estAutorisé(PosX + getHitbox(), newY + getHitbox(),hydrophobe)) {
            this.getP().setY(newY);
        }
    }

    private void jMoveLeft() {
        double nouvellePosX = this.getP().getX() - this.getVitesse();
        int newX = (int) Math.round(nouvellePosX);
        int PosY = this.getP().getY();
        if (this.getTerrain().estDansTerrain(newX, PosY) && this.getTerrain().estAutorisé(newX, PosY + getHitbox(),hydrophobe)) {
            this.getP().setX(newX);
        }
    }

    private void jMoveRight() {
        double nouvellePosX = this.getP().getX() + this.getVitesse();
        int newX = (int) Math.round(nouvellePosX);
        int PosY = this.getP().getY();
        if (this.getTerrain().estDansTerrain(newX, PosY) && this.getTerrain().estAutorisé(newX + getHitbox(), PosY + getHitbox(),hydrophobe)) {
            this.getP().setX(newX);
        }
    }
}

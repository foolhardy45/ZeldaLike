package com.example.zeldalike.modele.Arme;

import com.example.zeldalike.modele.Joueur;
import com.example.zeldalike.modele.Personnage;
import com.example.zeldalike.modele.Position;

import java.awt.*;

public abstract class Arme {
    private final int attaque;
    private Position p;
    private Joueur joueur;

    public Arme(int attaque, Joueur j) {

        this.attaque = attaque;
        this.joueur = j;
        this.p = new Position(this.joueur.getP().getX(), this.joueur.getP().getY());
        ;
    }

    public Position getP() {
        return p;
    }

    public void setP(Position p) {
        this.p = p;
    }

    public int getAttaque() {
        return this.attaque;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void hit(Personnage p) {
        if (p.isBouclierActif()) {
            System.out.println("aucun dégats reçue");
        } else if (this.joueur.enVie() && p.enVie()) {
            int degats = attaque;
            if (p.getDef() < degats) {
                degats -= p.getDef();
            } else {
                degats = 0;
            }
            p.setHp(p.getHp() - degats);
            System.out.println("Dégâts infligés: " + degats);
        }
    }

    private Rectangle getBouds() {
        return new Rectangle(this.getP().getX(), this.getP().getY(), 32, 32);
    }

    public boolean collidesWith(Personnage other) {
        return this.getBouds().intersects(other.getBounds());
    }

    public Personnage toucherPersonnage() {
        Personnage ennemisProche = this.getJoueur().getEnnemiProche();
        System.out.println(ennemisProche);
        if (ennemisProche != null) {
            this.directionPersonnage();
            if (collidesWith(ennemisProche)) {
                System.out.println(" la");
                System.out.println(this.p.toString());
                System.out.println(this.joueur.getP().toString());
                return ennemisProche;
            }
        }
        return null;
    }

    public void directionPersonnage() {
        Position positionHaut = new Position(this.joueur.getP().getX(), this.joueur.getP().getY() - 32);
        Position positionBas = new Position(this.joueur.getP().getX(), this.joueur.getP().getY() + 32);
        Position positionGauche = new Position(this.joueur.getP().getX() - 32, this.joueur.getP().getY());
        Position positionDroite = new Position(this.joueur.getP().getX() + 32, this.joueur.getP().getY());

        switch (this.joueur.getPositionPre()) {
            case 6:
                this.setP(positionDroite);
                break;
            case 2:
                this.setP(positionBas);
                break;
            case 4:
                this.setP(positionGauche);
                break;
            case 8:
                this.setP(positionHaut);
                break;
        }
    }

    public abstract void faireUneAttaque();

}

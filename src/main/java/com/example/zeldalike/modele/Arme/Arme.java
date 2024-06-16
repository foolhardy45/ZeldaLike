package com.example.zeldalike.modele.Arme;

import com.example.zeldalike.modele.Joueur;
import com.example.zeldalike.modele.Personnage;
import com.example.zeldalike.modele.Position;

import java.awt.*;
import java.util.ArrayList;

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

    public ArrayList<Personnage> toucherPersonnage() {
        ArrayList<Personnage> ennemisProches = this.joueur.getEnnemisProches();
        ArrayList<Personnage> ennemisToucher = new ArrayList<Personnage>();// Supposons que cette méthode renvoie une ArrayList de Personnage.
        for (Personnage ennemi : ennemisProches) {
            System.out.println(ennemi);
            if (ennemi != null) {
                this.directionPersonnage(); // Ajustez la direction du personnage courant, si nécessaire.
                if (collidesWith(ennemi)) {
                    System.out.println(" la");
                    System.out.println(this.p.toString());
                    System.out.println(this.joueur.getP().toString());
                    ennemisToucher.add(ennemi);
                }
            }
        }
        System.out.println(ennemisToucher.toString());
        return ennemisToucher;
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

    @Override
    public String toString() {
        return "Arme ";
    }
}

package com.example.zeldalike.modele;

public abstract class Arme {
    private final int attaque;
    private Joueur joueur;

    public Arme(int attaque, Joueur j) {
        this.attaque = attaque;
        this.joueur = j;
    }

    public int getAttaque() {
        return this.attaque;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void hit(Personnage p) {

        if (this.joueur.enVie() && p.enVie()) {
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

    public abstract void faireUneAttaque();

}

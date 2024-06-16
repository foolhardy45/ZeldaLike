package com.example.zeldalike.modele;

import com.example.zeldalike.modele.Arme.gun.Munition;

import java.util.Random;

public abstract class Ennemis extends Personnage {
    private static int id = 0;
    private final String idEnnemi;
    private final int aireDetection;
    private int degats;
    private ObjetRecuperables objetMort;

    public Ennemis(int hp, int def, int vitesse, Position p, Environnement env, Terrain terrain, int detection) {
        super(hp, def, vitesse, p, env, terrain);
        id++;
        this.objetMort = objetAléatoire();
        this.idEnnemi = "E" + id;
        this.setValeurDirection(8); // 8 = haut, 4 = gauche, 2 = bas, 6 = droite
        this.aireDetection = detection;
        this.degats = degats;
    }

    public static int getId() {
        return id;
    }

    public ObjetRecuperables objetAléatoire() {
        ObjetRecuperables objet;
        double chance = Math.random();

        if (chance < 0.7) { // 70% de chances pour une Munition
            objet = new Munition(new Position(0, 0));
        } else { // 30% de chances pour une PotionVitale
            objet = new PotionVitale(new Position(0, 0));
        }
        return objet;
    }

    public void dropObjet() {
        objetMort.setP(this.getP());
        this.getEnv().ajouterObjet(objetMort);
    }

    public String getIdEnnemi() {
        return idEnnemi;
    }

    public void deplacementAleatoire() {
        Random quelleDirection = new Random();
        int t = quelleDirection.nextInt(500);
        if (t < 50) {
            t = quelleDirection.nextInt(400);
            if (t < 100) {
                this.setValeurDirection(8);
            } else if (t < 200) {
                this.setValeurDirection(4);
            } else if (t < 300) {
                this.setValeurDirection(2);
            } else {
                this.setValeurDirection(6);
            }

        }
        this.move();
    }

    public void deplacementBFS() {
        //ArrayList<Integer> adjacent = this.getEnv().getTerrain().getIndicesAdjacent(this.getP().getX(), this.getP().getY());

        int indiceposition = this.getEnv().getTerrain().getIndiceCaseSousPosition(this.getP().getX() + getHitbox(), this.getP().getY() + getHitbox());
        //ArrayList<Integer> pluspetits = this.getEnv().getBfs_joueur().tousIndicesMinimum(adjacent);
        int indicevalmin = this.getEnv().getBfs_joueur().indiceMinimumVal(indiceposition);
        boolean bfstrouve = false;

        // Si la valeur de la case actuelle est plus grande que celle d'une case à proximité
        if (this.getEnv().getBfs_joueur().getValeurCaseI(indicevalmin) < this.getEnv().getBfs_joueur().getValeurCaseI(indiceposition)) {

            int direction = this.getEnv().getTerrain().getDirectionI1versI2(indiceposition, indicevalmin);
            bfstrouve = true;
            if (direction % 2 == 1) {
                switch (direction) {
                    case 1:
                        this.setValeurDirection(2);
                        move();
                        direction = 4;
                        break;
                    case 3:
                        this.setValeurDirection(6);
                        move();
                        direction = 2;
                        break;
                    case 7:
                        this.setValeurDirection(8);
                        move();
                        direction = 4;
                        break;
                    case 9:
                        this.setValeurDirection(8);
                        move();
                        direction = 6;
                        break;
                }
            }
            this.setValeurDirection(direction);
            move();
        }

        if (!bfstrouve) {
            deplacementAleatoire();
        }

    }

    public abstract void compétence();
    public abstract void désacCompétence();
}

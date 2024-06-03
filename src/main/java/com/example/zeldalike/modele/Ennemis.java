package com.example.zeldalike.modele;

public abstract class Ennemis extends Personnage {
    private static int id = 0;
    private final String idEnnemi;
    private final int direction;

    public Ennemis(int hp, int def, int vitesse, Position p, Environnement env, Terrain terrain) {
        super(hp, def, vitesse, p, env, terrain);
        id++;
        this.idEnnemi = "E" + id;
        this.direction = 0; // 0 = haut, 1 = gauche, 2 = bas, 3 = droite
    }

    public static int getId() {
        return id;
    }

    public String getIdEnnemi() {
        return idEnnemi;
    }

    @Override
    public String toString() {
        return "Ennemis{" +
                "idEnnemi='" + idEnnemi + '\'' +
                ", direction=" + direction +
                '}';
    }

    /*public void deplacementAleatoire(long deltaTime) {
        Random quelleDirection = new Random();
        int t = quelleDirection.nextInt(500);
        if (t < 50) {
            t = quelleDirection.nextInt(400);
            if (t < 100) {
                this.direction = 0;
            } else if (t < 200) {
                this.direction = 1;
            } else if (t < 300) {
                this.direction = 2;
            } else {
                this.direction = 3;
            }

        }
        switch (this.direction) {
            case 0:
                moveUp(deltaTime);
                break;
            case 1:
                moveLeft(deltaTime);
                break;
            case 2:
                moveDown(deltaTime);
                break;
            case 3:
                moveRight(deltaTime);
                break;
        }
    }*/
}

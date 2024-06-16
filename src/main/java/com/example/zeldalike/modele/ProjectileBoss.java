package com.example.zeldalike.modele;

public class ProjectileBoss extends Ennemis {
    private boolean bordtouche;

    public ProjectileBoss(Position p, Environnement env) {
        super(1, 0, 2, p, env, env.getTerrain(), 0);
        this.bordtouche = false;
    }

    @Override
    public void deplacementBFS() {
        this.move();
    }

    @Override
    public int getHp() {
        if (bordtouche) {
            return 0;
        }
        return 1;
    }

    public void personnageTouche(Personnage p) {
        p.subirDegats(2);
    }

    @Override
    public void compétence() {
        //immortel
    }

    @Override
    public void désacCompétence() {
        //disparait
    }

    //todo : les faire avancer sans collisions, puis disparaitre à la limite de l'écran.
    @Override
    public void moveUp() {
        double nouvellePosY = this.getP().getY() - this.getVitesse();
        int newY = (int) Math.round(nouvellePosY);
        int PosX = this.getP().getX();
        if (this.getTerrain().estDansTerrain(PosX, newY)) {
            this.getP().setY(newY);
            if (collidesWith(getEnv().getJ1())) {
                this.bordtouche = true;
                personnageTouche(this.getEnv().getJ1());
            }
        } else {
            this.bordtouche = true;
        }
    }

    @Override
    public void moveRight() {
        double nouvellePosX = this.getP().getX() + this.getVitesse();
        int newX = (int) Math.round(nouvellePosX);
        int PosY = this.getP().getY();
        if (this.getTerrain().estDansTerrain(newX, PosY)) {
            this.getP().setX(newX);
            if (collidesWith(getEnv().getJ1())) {
                this.bordtouche = true;
                personnageTouche(this.getEnv().getJ1());
            }
        } else {
            this.bordtouche = true;
        }
    }

    @Override
    public void moveLeft() {
        double nouvellePosX = this.getP().getX() - this.getVitesse();
        int newX = (int) Math.round(nouvellePosX);
        int PosY = this.getP().getY();
        if (this.getTerrain().estDansTerrain(newX, PosY)) {
            this.getP().setX(newX);
            if (collidesWith(getEnv().getJ1())) {
                this.bordtouche = true;
                personnageTouche(this.getEnv().getJ1());
            }
        } else {
            this.bordtouche = true;
        }

    }

    public void moveDown() {
        double nouvellePosY = this.getP().getY() + this.getVitesse();
        int newY = (int) Math.round(nouvellePosY);
        int PosX = this.getP().getX();
        if (this.getTerrain().estDansTerrain(PosX, newY)) {
            this.getP().setY(newY);
            if (collidesWith(getEnv().getJ1())) {
                this.bordtouche = true;
                personnageTouche(this.getEnv().getJ1());
            }
        } else {
            this.bordtouche = true;
        }
    }

    @Override
    public void dropObjet() {
        // ne rien faire
    }
}

package com.example.zeldalike.modele;

public abstract class Personnage  {
    private int hp;
    private int def;
    private int vitesse;
    private Position p;
    private Environnement env;
    private Terrain terrain;
    private int hitbox;



    public Personnage(int hp, int def, int vitesse, Position p, Environnement env, Terrain terrain) {
        this.hp = hp;
        this.def = def;
        this.vitesse = vitesse;
        this.p = p;
        this.env = env;
        this.terrain = terrain;
        this.hitbox =31;
    }

    public Position getP() {
        return p;
    }

    public void setP(Position p) {
        this.p = p;
    }

    public Environnement getEnv() {
        return env;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }
    public abstract void personnageTouche();


    public void moveUp(){
        int nouvellePosY = this.getP().getY() - vitesse;
        int PosX = this.getP().getX();
        if (this.terrain.estDansTerrain(PosX, nouvellePosY) && terrain.estAutorisé(PosX+1,nouvellePosY+hitbox)&& terrain.estAutorisé(PosX+hitbox,nouvellePosY+hitbox)) {
            System.out.println("move Up");
            this.getP().setY(nouvellePosY);
        } else {
            System.out.println("stop");
        }
    }


    public void moveDown() {
        int nouvellePosY = this.getP().getY() + vitesse;
        int PosX = this.getP().getX();
        if (this.terrain.estDansTerrain(PosX, nouvellePosY) && terrain.estAutorisé(PosX+1,nouvellePosY+hitbox) && terrain.estAutorisé(PosX+hitbox,nouvellePosY+hitbox)) {
            System.out.println("move Down");
            this.getP().setY(nouvellePosY);
        } else {
            System.out.println("stop");
        }
    }

    public void moveLeft() {
        int nouvellePosX = this.getP().getX() - vitesse;
        int PosY = this.getP().getY();
        if (this.terrain.estDansTerrain(nouvellePosX, PosY) && this.terrain.estAutorisé(nouvellePosX, PosY+hitbox)) {
            System.out.println("move Left");
            this.getP().setX(nouvellePosX);
        } else {
            System.out.println("stop");
        }
    }

    public void moveRight() {
        int nouvellePosX = this.getP().getX() + vitesse;
        int PosY = this.getP().getY();
        if (this.terrain.estDansTerrain(nouvellePosX, PosY) && this.terrain.estAutorisé(nouvellePosX+ hitbox, PosY+hitbox)) {
            System.out.println("move Right");
            this.getP().setX(nouvellePosX);
        } else {
            System.out.println("stop");
        }
    }
    //todo: interaction entre deux personnages (collision)
    /* Recupere les coordonnees d'un personnage et teste  s'il le touche
    *  Si oui, appliquer une fonction speciale de chaque personnage pour réagir
    *  Si non, ne rien faire
    * */

    public boolean verificationCollision(Personnage perso){
        boolean touche = false;
        //verification touché droite
        if (this.p.collisionEntreSprites(perso.getP())){
            this.personnageTouche();
            perso.personnageTouche();
            touche = true;
        }
        //verification touché gauche
        //verification touché haut
        //verification touché bas
        return touche;
    }
}



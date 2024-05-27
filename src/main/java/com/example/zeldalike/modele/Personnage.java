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


    public void moveUp(long deltaTime){
        double nouvellePosY = this.getP().getY() - (this.getVitesse() *(deltaTime/1000.0));
        int newY = (int) Math.round(nouvellePosY);
        int PosX = this.getP().getX();
        if (this.terrain.estDansTerrain(PosX, newY) && terrain.estAutorisé(PosX+1,newY+hitbox)&& terrain.estAutorisé(PosX+hitbox,newY+hitbox)) {
            System.out.println("move Up");
            this.getP().setY(newY);
        } else {
            System.out.println("stop");
        }
    }


    public void moveDown(long deltaTime) {
        double nouvellePosY = this.getP().getY() + (this.getVitesse()*(deltaTime/1000.0));
        int newY = (int) Math.round(nouvellePosY);
        System.out.println(nouvellePosY);
        System.out.println(newY);
        int PosX = this.getP().getX();
        if (this.terrain.estDansTerrain(PosX, newY) && terrain.estAutorisé(PosX+1,newY+hitbox) && terrain.estAutorisé(PosX+hitbox,newY+hitbox)) {
            System.out.println("move Down");
            this.getP().setY(newY);
        } else {
            System.out.println("stop");
        }
    }

    public void moveLeft(long deltaTime) {
        double nouvellePosX = this.getP().getX() - (this.getVitesse()*(deltaTime/1000.0));
        int newX = (int) Math.round(nouvellePosX);
        int PosY = this.getP().getY();
        if (this.terrain.estDansTerrain(newX, PosY) && this.terrain.estAutorisé(newX, PosY+hitbox)) {
            System.out.println("move Left");
            this.getP().setX(newX);
        } else {
            System.out.println("stop");
        }
    }

    public void moveRight(long deltaTime) {
        double nouvellePosX = this.getP().getX() + (this.getVitesse() *(deltaTime/1000.0));
        int newX = (int) Math.round(nouvellePosX);
        int PosY = this.getP().getY();
        System.out.println(deltaTime);
        System.out.println(this.getVitesse());
        if (this.terrain.estDansTerrain(newX, PosY) && this.terrain.estAutorisé(newX+ hitbox, PosY+hitbox)) {
            System.out.println("move Right");
            this.getP().setX(newX);
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
        return touche;
    }
}



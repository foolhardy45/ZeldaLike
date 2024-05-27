package com.example.zeldalike.modele;

public abstract class Personnage  {
    private int hp;
    private int def;
    private int vitesse;
    private Position p;
    private Environnement env;
    private Terrain terrain;
    private int hitbox;
    private char direction;



    public Personnage(int hp, int def, int vitesse, Position p, Environnement env, Terrain terrain) {
        this.hp = hp;
        this.def = def;
        this.vitesse = vitesse;
        this.p = p;
        this.env = env;
        this.terrain = terrain;
        this.hitbox =31;
        this.direction = ' ';
    }

    public char getDirection() {
        return direction;
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
    public abstract void personnageTouche(Personnage p);


    public void moveUp(long deltaTime){
        double nouvellePosY = this.getP().getY() - (this.getVitesse() *(deltaTime/1000.0));
        int newY = (int) Math.round(nouvellePosY);
        int PosX = this.getP().getX();
        if (this.terrain.estDansTerrain(PosX, newY) && terrain.estAutorisé(PosX+1,newY+hitbox)&& terrain.estAutorisé(PosX+hitbox,newY+hitbox)) {
            System.out.println("move Up");
            this.getP().setY(newY);
            this.direction = 'N';
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
            this.direction = 'S';
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
            this.direction = 'O';
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
            this.direction = 'E';
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
            this.personnageTouche(perso);
            perso.personnageTouche(this);
            touche = true;
        }
        return touche;
    }

    public void projection (Personnage perso,long deltaTime){
        switch (this.direction){
            case 'N' :
                if(this.terrain.estDansTerrain(perso.getP().getX(), perso.getP().getY()+ vitesse)) {
                    perso.getP().setY(this.getP().getY() + vitesse);
                }
            break;
            case 'S' : perso.getP().setY(this.getP().getY() - vitesse);
                break;
            case 'O' : perso.getP().setX(this.getP().getX() - vitesse);
                break;
            case 'E' : perso.getP().setX(this.getP().getX() + vitesse);
                break;
        }
    }
}



package com.example.zeldalike.modele;

public class Environnement {
    private Joueur j1;
    private Ennemis ennemis;
    private int height;
    private  int width;
    private Terrain terrain;

    public Environnement( int height, int width) {
        Position p = new Position(0,0);
        this.j1 = new Joueur(1,1,1,p,this);
        this.ennemis = new Ennemis(1,1,0,p,this);
        this.height = height;
        this.width = width;
        this.terrain = new Terrain();
    }

    public Joueur getJ1() {
        return j1;
    }

    public void encoreSurJeu(Personnage personnage){
        if (personnage.getP().getY() + 32 > this.height ){
            personnage.getP().setY(personnage.getP().getY()-5);
        }
        if (personnage.getP().getX() + 32 > this.width ){
            personnage.getP().setX(personnage.getP().getX()-5);
        }

        if (personnage.getP().getY() + 16  <  0 ){
            personnage.getP().setY(personnage.getP().getY() +5);
        }
        if (personnage.getP().getX() < 0 ){
            personnage.getP().setX(personnage.getP().getX()+5);
        }

    }

    public Ennemis getEnnemis() {
        return ennemis;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void unTour(){
        this.getJ1().moveUp();
    }
}
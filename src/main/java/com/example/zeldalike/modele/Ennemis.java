package com.example.zeldalike.modele;

import javafx.beans.property.IntegerProperty;

import java.util.ArrayList;
import java.util.Random;

public abstract class Ennemis extends Personnage{
    private static int id = 0;
    private final String idEnnemi;

    public Ennemis(int hp, int def, int vitesse, Position p, Environnement env, Terrain terrain) {
        super(hp, def, vitesse, new Position(p.getX(), p.getY()), 31, env, terrain);
        id++;
        this.idEnnemi = "E" + id;
        this.setValeurDirection(8); // 8 = haut, 4 = gauche, 2 = bas, 6 = droite
    }

    public static int getId() {
        return id;
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

    public void deplacementBFS(){
        //ArrayList<Integer> adjacent = this.getEnv().getTerrain().getIndicesAdjacent(this.getP().getX(), this.getP().getY());

        int indiceposition = this.getEnv().getTerrain().getIndiceCaseSousPosition(this.getP().getX()+getHitbox(), this.getP().getY()+getHitbox());
        //ArrayList<Integer> pluspetits = this.getEnv().getBfs_joueur().tousIndicesMinimum(adjacent);
        int indicevalmin = this.getEnv().getBfs_joueur().indiceMinimumVal(indiceposition);
        System.out.println("IP : " + indiceposition);
        System.out.println("IVLM : " + indicevalmin);
        boolean bfstrouve = false;

            // Si la valeur de la case actuelle est plus grande que celle d'une case à proximité
            if (this.getEnv().getBfs_joueur().getValeurCaseI(indicevalmin) < this.getEnv().getBfs_joueur().getValeurCaseI(indiceposition) ){

                int direction = this.getEnv().getTerrain().getDirectionI1versI2(indiceposition, indicevalmin);
                bfstrouve = true;
                System.out.println("distance: "+this.getEnv().getBfs_joueur().getValeurCaseI(indiceposition));
                //todo ajouter une condition pour qu'il se prenne pas les murs // fait ?
                System.out.println("direction : " + direction);
                if (direction%2 == 1){
                    switch (direction){
                        case 1:
                            this.setValeurDirection(2);
                            move();
                            System.out.println(2);
                            direction = 4;
                            break;
                        case 3:
                            this.setValeurDirection(6);
                            move();
                            System.out.println(6);
                            direction = 2;
                            break;
                        case 7:
                            this.setValeurDirection(8);
                            move();
                            System.out.println(8);
                            direction = 4;
                            break;
                        case 9:
                            this.setValeurDirection(8);
                            move();
                            System.out.println(8);
                            direction = 6;
                            break;
                    }
                }
                this.setValeurDirection(direction);
                System.out.println(direction);
                move();
            }

        if (!bfstrouve){
            deplacementAleatoire();
        }

    }

}

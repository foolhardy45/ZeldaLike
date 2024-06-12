package com.example.zeldalike.modele;

public class Cle extends ObjetRecuperables{


        public Cle(Position p){
            super(p,2);
        }
        public boolean collisionJoueur(Joueur j){
            return false;
        }
}

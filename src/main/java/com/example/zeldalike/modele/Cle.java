package com.example.zeldalike.modele;

public class Cle extends ObjetRecuperables{


        public Cle(Position p){
            super(p);
        }
        public boolean collisionJoueur(Joueur j){
            return false;
        }
}

package com.example.zeldalike.modele;

public class cle extends ObjetRecuperables{


        public cle(Position p){
            super(p,2);
        }
        public boolean collisionJoueur(Joueur j){
            return false;
        }
}

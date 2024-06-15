package com.example.zeldalike.modele;

import java.util.ArrayList;
import java.util.List;

public class Macarena extends Ennemis{
    public Macarena( Position p, Environnement env) {
        super(5, 5, 1, p, env, env.getTerrain(),6);
    }

    public void boostArmure(){
        List<Personnage> allièsDuMale = this.getEnnemisProches();

        for (int i = 0; i < allièsDuMale.size(); i++) {
            if (allièsDuMale.get(i) instanceof Macarena){
                //System.out.println("nada");
            }else if (allièsDuMale.get(i) instanceof Ennemis){
                ((Ennemis) allièsDuMale.get(i)).setBouclierActif(true);
                //System.out.println(allièsDuMale.get(i).getDef());
            }
        }

    }

    public List<Personnage> getEnnemisProches() {
        List<Personnage> ennemisProches = new ArrayList<>();
        int distanceSeuil = 50;

        for (Personnage ennemi : this.getEnv().getEnnemis()) {
            if (ennemi.enVie()) {
                int distance = distanceEntreDeuxPersonnages(this, ennemi);
                if (ennemi instanceof Ennemis && distance < distanceSeuil) {
                    ennemisProches.add(ennemi);
                }
            }
        }

        return ennemisProches;
    }

    @Override
    public void personnageTouche(Personnage p) {

    }

    @Override
    public void compétence() {
        this.boostArmure();
    }
}

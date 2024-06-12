package com.example.zeldalike.modele.Arme;

public class Chargeur {
    private Munition[] capacité;

    public Chargeur(Munition[] capacité) {
        this.capacité = capacité;
    }

    public Munition[] getCapacité() {
        return capacité;
    }
    public void ajouterMunition(Munition munition) {
        for (int i = 0; i < this.capacité.length; i++) {
            if(this.capacité[i] != null){
                this.capacité[i] = munition;
            }
        }
    }
}

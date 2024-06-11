package com.example.zeldalike.modele;

import com.example.zeldalike.modele.Arme.gun.Munition;

import java.util.ArrayList;

public class Inventaire {
    private final ArrayList<ObjetRecuperables> articles;


    public Inventaire() {
        this.articles = new ArrayList<>();
    }

    public int getQuantitePotion() {
        int quantite = 0;
        for (ObjetRecuperables obj : this.articles){
            if (obj instanceof PotionVitale){
                quantite++;
            }
        }
        return quantite;
    }

    public int getQuantiteCle() {
        int quantite = 0;
        for (ObjetRecuperables obj : this.articles){
            if (obj instanceof Cle){
                quantite++;
            }
        }
        return quantite;
    }

    public int getQuantiteMunition() {
        int quantite = 0;
        for (ObjetRecuperables obj : this.articles){
            if (obj instanceof Munition){
                quantite++;
            }
        }
        return quantite;
    }




 /*   public int indiceInventaire(ObjetRecuperables obj) {
        boolean present = false;
        int i = 0;
        if (this.articles.size() > 0) {
            while (!present && i < this.articles.size()) {
                present = this.articles.get(i).getObj().deMemeType(obj);
                i++;
            }
            i--;
            if (this.articles.get(i).getObj().deMemeType(obj)) {
                return i;
            }
        }
        return -1;
    }*/

    public void ajoutInventaire(ObjetRecuperables obj) {
        this.articles.add(obj);}


    @Override
    public String toString() {
        String tout = "";
        for (ObjetRecuperables a : this.articles) {
            tout += a.toString();
            tout += "\n";
        }
        return tout;
    }
}

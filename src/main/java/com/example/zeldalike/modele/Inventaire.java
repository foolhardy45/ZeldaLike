package com.example.zeldalike.modele;

import java.util.ArrayList;
import java.util.HashMap;

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

    public int getQuantitecle() {
        int quantite = 0;
        for (ObjetRecuperables obj : this.articles){
            if (obj instanceof cle){
                quantite++;
            }
        }
        return quantite;
    }

    public HashMap<ObjetRecuperables, Integer> getQuantiteTout(){
        HashMap<ObjetRecuperables, Integer> quantites = new HashMap<>();
        if (getQuantitePotion()>0){
            quantites.put(new PotionVitale(), getQuantitePotion());
        }
        if (getQuantitecle()>0) {
            quantites.put(new cle(new Position(0, 0)), getQuantitePotion());
        }
        return quantites;
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
        HashMap<ObjetRecuperables, Integer> tout = getQuantiteTout();
        String texte = "";
        for (ObjetRecuperables o : tout.keySet()){
            texte += o +" : "+ tout.get(o) + "\n";
        }
        return texte;
    }
}

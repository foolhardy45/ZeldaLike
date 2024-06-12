package com.example.zeldalike.modele;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventaire {
    private final ArrayList<ObjetRecuperables> articles;


    public Inventaire() {
        this.articles = new ArrayList<>();
    }

    public ObjetRecuperables getUnePotion(){
        boolean obtenu = false;
        ObjetRecuperables potion = null;
        int i = 0;
        while (!obtenu && i< this.articles.size()){
            potion = this.articles.get(i);
            if (potion instanceof PotionVitale){
                obtenu = true;
            }
            i++;
        }
        return potion;
    }

    public ObjetRecuperables getUneCle(){
        boolean obtenu = false;
        ObjetRecuperables cle = null;
        int i = 0;
        while (!obtenu && i< this.articles.size()){
            cle = this.articles.get(i);
            if (cle instanceof cle){
                obtenu = true;
            }
            i++;
        }
        return cle;
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
        ObjetRecuperables objet;
        if (getQuantitePotion()>0){
            quantites.put(getUnePotion(), getQuantitePotion());
        }
        if (getQuantitecle()>0) {
            quantites.put(getUneCle(), getQuantitecle());
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
        obj.setP(new Position(0,0));
        this.articles.add(obj);
    }




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

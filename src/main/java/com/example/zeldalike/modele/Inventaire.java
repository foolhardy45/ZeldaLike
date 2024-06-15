package com.example.zeldalike.modele;

import com.example.zeldalike.modele.Arme.gun.Munition;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventaire {
    private final ArrayList<ObjetRecuperables> articles;



    public Inventaire() {
        this.articles = new ArrayList<>();
    }



    public ArrayList<ObjetRecuperables> getListePotion(){
        ArrayList<ObjetRecuperables> liste = new ArrayList<>();
        for (ObjetRecuperables obj : this.articles){
            if (obj instanceof PotionVitale){
                liste.add(obj);
            }
        }
        return liste;
    }

    public ArrayList<ObjetRecuperables> getListeCle(){
        ArrayList<ObjetRecuperables> liste = new ArrayList<>();
        for (ObjetRecuperables obj : this.articles){
            if (obj instanceof Cle){
                liste.add(obj);
            }
        }
        return liste;
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

    public ObjetRecuperables getUneCle(){
        boolean obtenu = false;
        ObjetRecuperables munition = null;
        int i = 0;
        while (!obtenu && i< this.articles.size()){
            munition = this.articles.get(i);
            if (munition instanceof Munition){
                obtenu = true;
            }
            i++;
        }
        return munition;
    }



    public ArrayList<Munition> getListeMunition(){
        ArrayList<Munition> liste = new ArrayList<>();
        for (ObjetRecuperables obj : this.articles){
            if (obj instanceof Munition){
                liste.add((Munition) obj);
            }
        }
        return liste;
    }




    public ObjetRecuperables getUnePotion(){
        ArrayList<ObjetRecuperables> liste = getListePotion();
        if (!liste.isEmpty()){
            return getListePotion().get(0);
        }
        return null;
    }
    public int getQuantitePotion() {
        return getListePotion().size();
    }
    public int getQuantiteCle() {
        return getListeCle().size();
    }

    public HashMap<ObjetRecuperables, Integer> getQuantiteTout(){
        HashMap<ObjetRecuperables, Integer> quantites = new HashMap<>();
        ObjetRecuperables objet;
        if (getQuantitePotion()>0){
            quantites.put(getUnePotion(), getQuantitePotion());
        }
        if (getQuantiteCle()>0) {
            quantites.put(getUneCle(), getQuantiteCle());
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

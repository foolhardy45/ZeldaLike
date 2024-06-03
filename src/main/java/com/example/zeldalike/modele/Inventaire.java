package com.example.zeldalike.modele;

import java.util.ArrayList;

public class Inventaire {
    private final ArrayList<ArticleInventaire> articles;


    public Inventaire() {
        this.articles = new ArrayList<>();
    }

    public int indiceInventaire(ObjetRecuperables obj) {
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
    }

    public void ajoutInventaire(ObjetRecuperables obj) {
        int indice = indiceInventaire(obj);
        if (indice >= 0) {
            this.articles.get(indice).incremente();
        } else {
            ArticleInventaire nouvelobjet = new ArticleInventaire(obj);
            this.articles.add(nouvelobjet);
        }
    }


    @Override
    public String toString() {
        String tout = "";
        for (ArticleInventaire a : this.articles) {
            tout += a.toString();
            tout += "\n";
        }
        return tout;
    }
}

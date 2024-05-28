package com.example.zeldalike.modele;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventaire {
    private ArrayList<ArticleInventaire> articles;

    public Inventaire(){
        this.articles = new ArrayList<>();
    }

    public boolean dansInventaire(ObjetRecuperables obj){
        boolean present = false;
        int i = 0;
        while(!present && i<this.articles.size()){
            present = this.articles.get(i).getObj().deMemeType(obj);
            i++;
        }
        return present;
    }
}

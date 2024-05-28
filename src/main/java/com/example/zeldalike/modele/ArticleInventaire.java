package com.example.zeldalike.modele;

public class ArticleInventaire {

    private ObjetRecuperables obj;
    private int quantite;

    public ArticleInventaire(ObjetRecuperables obj){
        this.obj = obj;
        this.quantite = 1;
    }

    public int getQuantite(){
        return this.quantite;
    }

    public ObjetRecuperables getObj() {
        return obj;
    }
}

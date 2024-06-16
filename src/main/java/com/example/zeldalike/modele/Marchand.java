package com.example.zeldalike.modele;

import com.example.zeldalike.vues.MarchandAvendreVue;
import com.example.zeldalike.vues.MarchandVue;

import java.util.ArrayList;

public class Marchand extends Personnage{

    private ArrayList<ObjetRecuperables> objetsvendre;
    private ArrayList<Integer> prixobjets;
    private MarchandAvendreVue boutique;
    

    public Marchand(Position p, Environnement env){
        super(1,1, 0, p, env, env.getTerrain());
        objetsvendre = new ArrayList<ObjetRecuperables>();
        prixobjets = new ArrayList<Integer>();
        objetsvendre.addFirst(new PotionVitale());
        prixobjets.addFirst(5);

    }

    @Override
    public void personnageTouche(Personnage p) {
    }

    public ObjetRecuperables getObjetAchetable(int indice){
        ObjetRecuperables achat = null;
        ObjetRecuperables typedobjet;
        if (indice <= this.objetsvendre.size() && indice>=0){
            typedobjet = this.objetsvendre.get(indice);
            if (typedobjet instanceof PotionVitale){
                achat = new PotionVitale();
            }
        }
        return achat;
    }

    public int getPrixObjet(int indice){
        int prix = 0;
        if (indice <= this.prixobjets.size() && indice>=0){
            prix = this.prixobjets.get(indice);

        }
        return prix;
    }

    public boolean peutAcheterObjet(int quantiteargent, int indiceObjet){
        return quantiteargent >= getPrixObjet(indiceObjet);
    }

    public ObjetRecuperables acheterObjet(int quantiteargent, int indiceObjet){
        if (peutAcheterObjet(quantiteargent, indiceObjet)){
            return getObjetAchetable(indiceObjet);
        }
        return null;
    }

    public ArrayList<ObjetRecuperables> getObjetsvendre(){
        return this.objetsvendre;
    }
    
    public void ouvrirBoutique(){
        this.boutique.ouvrirboutique();
    }

    public void setBoutique(MarchandAvendreVue boutique) {
        this.boutique = boutique;
    }
}

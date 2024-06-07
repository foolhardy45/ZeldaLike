package com.example.zeldalike.modele;

public abstract class ObjetRecuperables {
    private static int id = 0;
    private String idObjet;
    private Position p;


    public ObjetRecuperables(Position p, int type){
        this.idObjet = "Objet"+id;
        this.p = p;
        id++;
    }

    public Position getP() {
        return p;
    }

    public void setP(Position p) {
        this.p = p;
    }
    public String getIdObjet(){
        return this.idObjet;
    }

    public boolean memeID(ObjetRecuperables o){
        return this.idObjet.equals(o.getIdObjet());
    }

    @Override
    public String toString() {
        return this.idObjet;
    }
}

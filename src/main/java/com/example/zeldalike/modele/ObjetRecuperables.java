package com.example.zeldalike.modele;

public abstract class ObjetRecuperables {
    private static int id = 0;
    private final String idObjet;
    private final Position p;
    private final int type;


    public ObjetRecuperables(Position p, int type) {
        this.idObjet = "Objet " + id;
        this.p = p;
        this.type = type;
        id++;
    }

    public String getIdObjet() {
        return this.idObjet;
    }

    public boolean memeID(ObjetRecuperables o) {
        return this.idObjet.equals(o.getIdObjet());
    }

    public int getType() {
        return type;
    }

    public boolean deMemeType(ObjetRecuperables obj) {
        return this.type == obj.getType();
    }

    @Override
    public String toString() {
        return this.idObjet;
    }
}

package com.example.zeldalike.modele;

public class Ennemis extends Personnage{
    private static int id = 0;
    private String idEnnemi;
    public Ennemis(int hp, int def, int vitesse,Position p,Environnement env,Terrain terrain) {
        super(hp, def, vitesse, p,env,terrain);
        id++;
        this.idEnnemi = "E"+id;
    }

    public static int getId() {
        return id;
    }

    public String getIdEnnemi() {
        return idEnnemi;
    }
}

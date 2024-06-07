package com.example.zeldalike.vues;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.Inventaire;
import javafx.scene.image.Image;
import javafx.scene.layout.TilePane;

import java.awt.*;

public class InventaireVue {

    private TilePane affichage;
    private Inventaire inv;
    private int tailleInventaire = 4;

    public InventaireVue(TilePane affichage, Inventaire inv){
        this.affichage = affichage;
        this.inv = inv;
    }

    public void creeAffichage() {
        Image cases = new Image(String.valueOf(Main.class.getResource("images/case_inventaire.png")));
        this.affichage.setPrefColumns(tailleInventaire);

        //todo reste de la création de l'inventaire
    }
}

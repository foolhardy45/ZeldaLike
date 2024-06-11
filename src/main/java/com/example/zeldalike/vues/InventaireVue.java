package com.example.zeldalike.vues;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.Inventaire;
import com.example.zeldalike.modele.ObjetRecuperables;
import com.example.zeldalike.modele.PotionVitale;
import com.example.zeldalike.modele.cle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.awt.*;

public class InventaireVue {

    private TilePane affichage;
    private TilePane objets;
    private Inventaire inv;
    private int tailleInventaire = 4;

    public InventaireVue(TilePane affichage,TilePane objets, Inventaire inv){
        this.affichage = affichage;
        this.objets = objets;
        this.inv = inv;
    }

    public String getImageObjet(ObjetRecuperables objet){
        String image = "";
        if (objet instanceof PotionVitale){
            image = String.valueOf(Main.class.getResource("images/objets/potion.png"));
        }
        else if (objet instanceof cle){
            image = String.valueOf(Main.class.getResource("images/coins.gif"));
        }


        return image;
    }

    public void creeAffichage() {
        Image cases = new Image(String.valueOf(Main.class.getResource("images/case_inventaire.png")));
        this.affichage.setPrefColumns(tailleInventaire);
        for (ObjetRecuperables objet : this.inv.getQuantiteTout().keySet()){
            affichage.getChildren().add(new ImageView(cases));
            ObjetVue obj = new ObjetVue(objet, getImageObjet(objet));
            objets.getChildren().add(obj.getI());
        }

        //todo reste de la création de l'inventaire
        //todo : appeler inventairevue deja dans la scene normale/ essayer de centrer l'inventaire/A voir
    }


    public boolean ouvrirInventaire(){
        if (!this.affichage.isVisible()) {
            this.affichage.setVisible(true);
            this.objets.setVisible(true);
            return true;
        }
        else {
            this.affichage.setVisible(false);
            this.objets.setVisible(false);
            return false;
        }
    }
}

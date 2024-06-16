package com.example.zeldalike.vues;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.*;
import com.example.zeldalike.modele.Arme.gun.Munition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.util.ArrayList;
import java.util.HashMap;

public class MarchandAvendreVue {

    private TilePane affichage;
    private Marchand marchand;
    private TilePane objets;
    private int tailleInventaire = 4;
    //private HashMap<ObjetRecuperables, Integer> quantiteactuelle;
    private ArrayList<ObjetRecuperables> boutique;
    private int position;
    private final Image cases = new Image(String.valueOf(Main.class.getResource("images/case_inventaire.png")));
    private final Image caseselect = new Image(String.valueOf(Main.class.getResource("images/caseinventaireselect.png")));

    public MarchandAvendreVue(TilePane affichage, TilePane objets, Marchand mar) {
        this.affichage = affichage;
        this.objets = objets;
        this.marchand = mar;
    }


    public String getImageObjet(ObjetRecuperables objet) {
        String image = "";
        if (objet instanceof PotionVitale) {
            image = String.valueOf(Main.class.getResource("images/objets/potion.png"));
        }
        return image;
    }



    public void creeAffichage() {
        this.affichage.setPrefColumns(tailleInventaire);
        for (ObjetRecuperables objet : this.marchand.getObjetsvendre()) {
            affichage.getChildren().add(new ImageView(this.cases));
            ObjetVue obj = new ObjetVue(objet, getImageObjet(objet));
            objets.getChildren().add(obj.getI());
        }
        if (!affichage.getChildren().isEmpty()) {
            ((ImageView) affichage.getChildren().get(0)).setImage(caseselect);
        }
        this.position = 0;
        this.affichage.setVisible(true);
        this.objets.setVisible(true);
    }

    public void supprimeAffichage() {

        int taille = this.affichage.getChildren().size();
        for (int n = 0; n < taille; n++) {
            this.affichage.getChildren().remove(0);
        }
        for (int n = 0; n < taille; n++) {
            this.objets.getChildren().remove(0);
        }
        this.affichage.setVisible(false);
        this.objets.setVisible(false);
    }

    public boolean ouvrirboutique() {
        if (!this.affichage.isVisible()) {
            creeAffichage();
            return true;
        } else {
            supprimeAffichage();
            return false;
        }
    }
}

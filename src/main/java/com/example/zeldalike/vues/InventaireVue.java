package com.example.zeldalike.vues;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.*;
import com.example.zeldalike.modele.Arme.gun.Munition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.util.HashMap;

public class InventaireVue {

    private TilePane affichage;
    private TilePane objets;
    private Inventaire inv;
    private int tailleInventaire = 4;
    private HashMap<ObjetRecuperables, Integer> quantiteactuelle;
    private int position;
    private final Image cases = new Image(String.valueOf(Main.class.getResource("images/case_inventaire.png")));
    private final Image caseselect = new Image(String.valueOf(Main.class.getResource("images/caseinventaireselect.png")));

    public InventaireVue(TilePane affichage, TilePane objets, Inventaire inv) {
        this.affichage = affichage;
        this.objets = objets;
        this.inv = inv;
    }

    public String getImageObjet(ObjetRecuperables objet) {
        String image = "";
        if (objet instanceof PotionVitale) {
            image = String.valueOf(Main.class.getResource("images/objets/potion.png"));
        } else if (objet instanceof Cle) {
            image = String.valueOf(Main.class.getResource("images/coins.gif"));
        } else if (objet instanceof Munition) {
            image = String.valueOf(Main.class.getResource("images/marchand.png"));
        }
        else if (objet instanceof ChaussuresHydrophobes){
            image = String.valueOf(Main.class.getResource("images/objets/chaussuresHydrophobes.png"));
        }


        return image;
    }

    public void creeAffichage() {
        this.affichage.setPrefColumns(tailleInventaire);
        System.out.println(this.inv);
        this.quantiteactuelle = this.inv.getQuantiteTout();
        for (ObjetRecuperables objet : this.quantiteactuelle.keySet()) {
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

        //todo reste de la création de l'inventaire
        //todo : appeler inventairevue deja dans la scene normale/ essayer de centrer l'inventaire/A voir
    }

    public void supprimeAffichage() {

        int taille = this.affichage.getChildren().size();
        for (int n = 0; n < taille; n++) {
            this.affichage.getChildren().remove(0);
        }
        for (int n = 0; n < taille; n++) {
            this.objets.getChildren().remove(0);
        }
        this.quantiteactuelle.clear();
        this.affichage.setVisible(false);
        this.objets.setVisible(false);
    }


    public boolean ouvrirInventaire() {
        if (!this.affichage.isVisible()) {
            creeAffichage();
            return true;
        } else {
            supprimeAffichage();
            return false;
        }
    }

    public boolean deplacementpossibles(int nbcases){
        return this.position + nbcases < this.quantiteactuelle.size() && this.position + nbcases >= 0;
    }

    public void sedeplacer(int nbcases){
        this.position += nbcases ;
    }

    public void deplacerSelect(int direction){
        if (direction == 6 && deplacementpossibles(1)){
            ((ImageView)affichage.getChildren().get(this.position)).setImage(cases);
            sedeplacer(1);
            ((ImageView)affichage.getChildren().get(this.position)).setImage(caseselect);
        } else if (direction == 4 && deplacementpossibles(-1)){
            ((ImageView)affichage.getChildren().get(this.position)).setImage(cases);
            sedeplacer(-1);
            ((ImageView)affichage.getChildren().get(this.position)).setImage(caseselect);
        }
    }

    public void utiliserObjetSelect(){
        //Image transparent = new Image(String.valueOf(Main.class.getResource("images/objets/transparent.png")));
        int indiceobjet = 0;
        ObjetRecuperables obj = null;
        for (ObjetRecuperables o : this.quantiteactuelle.keySet()){
            if (indiceobjet == position){
                obj = o;
            }
            indiceobjet++;
        }
        indiceobjet--;
        if (obj instanceof PotionVitale){
            this.inv.utiliserPotion();
            this.quantiteactuelle.replace(obj, this.quantiteactuelle.get(obj)-1);
            if (this.quantiteactuelle.get(obj) <= 0){
                this.quantiteactuelle.remove(obj);
            }
            if (this.inv.getQuantitePotion()<= 0){
                if (deplacementpossibles(-1)){
                    sedeplacer(-1);
                } else if (deplacementpossibles(1)){
                    sedeplacer(1);
                }
                this.objets.getChildren().remove(indiceobjet);
                this.affichage.getChildren().remove(indiceobjet);
                deplacerSelect(6);
            }
        }
    }
}

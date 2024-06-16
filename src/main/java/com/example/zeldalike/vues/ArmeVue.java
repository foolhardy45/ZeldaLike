package com.example.zeldalike.vues;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.Arme.Arme;
import com.example.zeldalike.modele.Arme.Poing;
import com.example.zeldalike.modele.Arme.gun.Gun;
import com.example.zeldalike.modele.Joueur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ArmeVue {
    private final Joueur joueur;
    private final Arme arme;
    private final Image poingDroit;
    private final Image poingGauche;
    private final Image poingHaut;
    private final Image poingBas;
    private ImageView armeVue;

    public ArmeVue(Joueur joueur, Arme arme) {
        this.joueur = joueur;
        this.arme = arme;
        this.armeVue = new ImageView();

        poingDroit = new Image(String.valueOf(Main.class.getResource("images/gressif_simple/poinGressifDroite.png")));
        poingGauche = new Image(String.valueOf(Main.class.getResource("images/gressif_simple/poinGressifGauche.png")));
        poingHaut = new Image(String.valueOf(Main.class.getResource("images/gressif_simple/poinGressifHaut.png")));
        poingBas = new Image(String.valueOf(Main.class.getResource("images/gressif_simple/poinGressifBas.png")));
    }

    public void afficherarmeVue(ImageView mac) {
        if (this.joueur.getArme() instanceof Poing) {
            if (joueur.getPositionPre() == 8) {
                armeVue.setImage(poingHaut);
                armeVue.setVisible(true);
                armeVue.setX(joueur.getP().xProperty().get());
                armeVue.setY(joueur.getP().yProperty().get() - 32);
            } else if (joueur.getPositionPre() == 2) {
                armeVue.setImage(poingBas);
                armeVue.setVisible(true);
                armeVue.setX(joueur.getP().xProperty().get());
                armeVue.setY(joueur.getP().yProperty().get() + 32);
            } else if (joueur.getPositionPre() == 4) {
                armeVue.setImage(poingGauche);
                armeVue.setVisible(true);
                armeVue.setX(joueur.getP().xProperty().get() - 32);
                armeVue.setY(joueur.getP().yProperty().get());
            } else if (joueur.getPositionPre() == 6) {
                armeVue.setImage(poingDroit);
                armeVue.setVisible(true);
                armeVue.setX(joueur.getP().xProperty().get() + 32);
                armeVue.setY(joueur.getP().yProperty().get());
            }
        } else if (this.joueur.getArme() instanceof Gun) {
            // Logique pour afficher l'arme Gun
        }
    }


    public ImageView getArmeVue() {
        return armeVue;
    }
}

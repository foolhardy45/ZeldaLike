package com.example.zeldalike.controlleurs;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.Arme.gun.Munition;
import com.example.zeldalike.vues.MunitionVue;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

public class MonObservateurMunition implements ListChangeListener<Munition> {
    private Pane panneauDeJeu;
    private MunitionVue munitionVue;
    private int directionPrecedente;


    public MonObservateurMunition(Pane pane) {
        this.panneauDeJeu = pane;
        this.munitionVue = null;
    }

    @Override
    public void onChanged(Change<? extends Munition> change) {
        while (change.next()) {
            for (Munition munition : change.getAddedSubList()) {
                if (munition.getDirection() == 5){
                    munition.setDirection(directionPrecedente);
                }

                switch (munition.getDirection()) {
                    case 1:
                        munitionVue = new MunitionVue(munition, String.valueOf(Main.class.getResource("images/gressif_gun/munitionGaucheBas.png")));
                        break;
                    case 2:
                        munitionVue = new MunitionVue(munition, String.valueOf(Main.class.getResource("images/gressif_gun/munitionBas.png")));
                        break;
                    case 3:
                        munitionVue = new MunitionVue(munition, String.valueOf(Main.class.getResource("images/gressif_gun/munitionDroiteBas.png")));
                        break;
                    case 4:
                        munitionVue = new MunitionVue(munition, String.valueOf(Main.class.getResource("images/gressif_gun/munitionGauche.png")));
                        break;
                    case 5:
                        munitionVue = new MunitionVue(munition, String.valueOf(Main.class.getResource("images/gressif_gun/munitionGauche.png")));
                        break;
                    case 6:
                        munitionVue = new MunitionVue(munition, String.valueOf(Main.class.getResource("images/gressif_gun/munitionDroite.png")));
                        break;
                    case 7:
                        munitionVue = new MunitionVue(munition, String.valueOf(Main.class.getResource("images/gressif_gun/munitionGaucheHaut.png")));
                        break;
                    case 8:
                        System.out.println(munition.getDirection());
                        munitionVue = new MunitionVue(munition, String.valueOf(Main.class.getResource("images/gressif_gun/munitionHaut.png")));
                        break;
                    case 9:
                        munitionVue = new MunitionVue(munition, String.valueOf(Main.class.getResource("images/gressif_gun/munitionDroiteHaut.png")));
                        break;
                }
                directionPrecedente = munition.getDirection();

                this.panneauDeJeu.getChildren().add(munitionVue.getImage());
                System.out.println();

            }
            for (Munition munition : change.getRemoved()) {
                this.panneauDeJeu.getChildren().remove(this.panneauDeJeu.lookup("#" + munition.getIdObjet()));
            }
        }
    }
}

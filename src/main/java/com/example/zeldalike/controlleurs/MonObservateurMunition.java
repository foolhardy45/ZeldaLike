package com.example.zeldalike.controlleurs;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.Arme.gun.Munition;
import com.example.zeldalike.vues.MunitionVue;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

public class MonObservateurMunition implements ListChangeListener<Munition> {
    private Pane panneauDeJeu;
    private MunitionVue munitionVue;

    public MonObservateurMunition(Pane pane) {
        this.panneauDeJeu = pane;
        this.munitionVue = null;
    }

    @Override
    public void onChanged(Change<? extends Munition> change) {
        while (change.next()) {
            for(Munition munition : change.getAddedSubList()) {
                munitionVue = new MunitionVue(munition,String.valueOf(Main.class.getResource("images/gressif_gun/munitionDroite.png")));
                this.panneauDeJeu.getChildren().add(munitionVue.getImage());
                System.out.println();

            }
            for(Munition munition : change.getRemoved()) {
                this.panneauDeJeu.getChildren().remove(this.panneauDeJeu.lookup("#"+munition.getIdObjet()));
            }
        }
    }
}

package com.example.zeldalike.controlleurs;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.Arme.gun.Munition;
import com.example.zeldalike.modele.ObjetRecuperables;
import com.example.zeldalike.modele.PotionVitale;
import com.example.zeldalike.vues.ObjetVue;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

public class MonObservateurObjet implements ListChangeListener<ObjetRecuperables> {
    private Pane panneauDeJeu;
    private ObjetVue objetVue;

    public MonObservateurObjet(Pane panneauDeJeu) {
        this.panneauDeJeu = panneauDeJeu;
        this.objetVue = null;
    }

    @Override
    public void onChanged(Change<? extends ObjetRecuperables> change) {
        while (change.next()) {
            for (ObjetRecuperables o : change.getAddedSubList()) {
                if (o instanceof PotionVitale) {
                    objetVue = new ObjetVue(o, String.valueOf(Main.class.getResource("images/objets/potion.png")));
                } else if (o instanceof Munition) {
                    objetVue = new ObjetVue(o, String.valueOf(Main.class.getResource("images/gressif_gun/munitionHaut.png")));
                }
                this.panneauDeJeu.getChildren().add(objetVue.getI());

            }
            for (ObjetRecuperables objRecup : change.getRemoved()) {
                this.panneauDeJeu.getChildren().remove(this.panneauDeJeu.lookup("#" + objRecup.getIdObjet()));
            }
        }

    }
}

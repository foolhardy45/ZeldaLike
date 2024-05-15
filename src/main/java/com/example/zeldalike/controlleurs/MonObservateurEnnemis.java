package com.example.zeldalike.controlleurs;

import com.example.zeldalike.modele.Citron;
import com.example.zeldalike.modele.Ennemis;
import com.example.zeldalike.vues.EnnemisVue;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

public class MonObservateurEnnemis implements ListChangeListener<Ennemis> {
    private Pane panneauDeJeu;
    private EnnemisVue ennemisVue;

    public MonObservateurEnnemis(Pane panneauDeJeu){
        this.panneauDeJeu = panneauDeJeu;
        this.ennemisVue = null;
    }


    @Override
    public void onChanged(Change<? extends Ennemis> change) {
        while(change.next()){
            for (Ennemis e : change.getAddedSubList()){
                if (e instanceof Citron){
                    ennemisVue = new EnnemisVue(e,"citron.png");
                }

            }
            for (Ennemis mort : change.getRemoved()){
                this.panneauDeJeu.getChildren().remove(this.panneauDeJeu.lookup("#"+mort.getIdEnnemi()));
            }
        }
    }
}

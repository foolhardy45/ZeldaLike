package com.example.zeldalike.controlleurs;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.*;
import com.example.zeldalike.vues.BossSamuraiVue;
import com.example.zeldalike.modele.BusinessMan;
import com.example.zeldalike.modele.Citron;
import com.example.zeldalike.modele.Ennemis;
import com.example.zeldalike.modele.Macarena;
import com.example.zeldalike.vues.EnnemisVue;
import com.example.zeldalike.vues.MarchandAvendreVue;
import com.example.zeldalike.vues.MarchandVue;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

public class MonObservateurMarchand implements ListChangeListener<Marchand> {
    private final Pane panneauDeJeu;
    private final TilePane affichage;
    private final TilePane objets;
    private MarchandVue marchandVue;

    public MonObservateurMarchand(Pane panneauDeJeu, TilePane affichage, TilePane objets) {
        this.panneauDeJeu = panneauDeJeu;
        this.marchandVue = null;
        this.affichage =affichage;
        this.objets=objets;
    }


    @Override
    public void onChanged(Change<? extends Marchand> change) {
        while (change.next()) {
            for (Marchand e : change.getAddedSubList()) {
                marchandVue = new MarchandVue(e, String.valueOf(Main.class.getResource("images/marchand.png")));
                e.setBoutique(new MarchandAvendreVue(affichage, objets, e));
                this.panneauDeJeu.getChildren().add(marchandVue.getI());
            }
        }
    }
}

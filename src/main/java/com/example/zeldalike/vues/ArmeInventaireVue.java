package com.example.zeldalike.vues;

import com.example.zeldalike.modele.Arme.Arme;
import javafx.scene.image.ImageView;

public class ArmeInventaireVue {
    private Arme arme;
    private String file;
    private ImageView i;

    public ArmeInventaireVue(Arme arme, String file) {
        this.arme = arme;
        this.file = file;
        this.i = new ImageView(file);
        i.translateXProperty().bind(arme.getP().xProperty());
        i.translateYProperty().bind(arme.getP().yProperty());

    }

    public ImageView getI() {
        return i;
    }
}

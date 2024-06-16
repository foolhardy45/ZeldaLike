package com.example.zeldalike.vues;

import com.example.zeldalike.modele.Ennemis;
import javafx.scene.image.ImageView;

public class EnnemisVue {
    private final Ennemis ennemis;
    private final String file;
    private final ImageView i;

    public EnnemisVue(Ennemis ennemis, String file) {
        this.ennemis = ennemis;
        this.file = file;
        this.i = new ImageView(file);
        i.setId(ennemis.getIdEnnemi());
        i.translateXProperty().bind(ennemis.getP().xProperty());
        i.translateYProperty().bind(ennemis.getP().yProperty());


    }

    public ImageView getI() {
        return i;
    }

    public Ennemis getEnnemis() {
        return this.ennemis;
    }
}

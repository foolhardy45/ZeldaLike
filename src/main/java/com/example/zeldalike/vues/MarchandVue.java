package com.example.zeldalike.vues;

import com.example.zeldalike.modele.Ennemis;
import com.example.zeldalike.modele.Marchand;
import javafx.scene.image.ImageView;

public class MarchandVue {
    
    private Marchand marchand;
    private final String file;
    private final ImageView i;

    public MarchandVue(Marchand marchand, String file) {
        this.marchand = marchand;
        this.file = file;
        this.i = new ImageView(file);
        i.translateXProperty().bind(marchand.getP().xProperty());
        i.translateYProperty().bind(marchand.getP().yProperty());


    }

    public ImageView getI() {
        return i;
    }

    public Marchand getMarchand(){
        return this.marchand;
    }
}

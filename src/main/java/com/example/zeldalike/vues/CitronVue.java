package com.example.zeldalike.vues;

import com.example.zeldalike.modele.Citron;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CitronVue {

    private Citron citron;
    private Circle r;

    public CitronVue(Citron citra){
        this.citron = citra;
        this.r = new Circle(6);
        r.setFill(Color.YELLOW);
        r.translateXProperty().bind(citron.getP().xProperty());
        r.translateYProperty().bind(citron.getP().yProperty());
        System.out.println("ennemi citron créer");
    }

    public Citron getCitron(){
        return this.citron;
    }
}

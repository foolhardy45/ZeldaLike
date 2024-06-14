package com.example.zeldalike.vues;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.Ennemis;

import com.example.zeldalike.modele.ProjectileBoss;
import javafx.scene.image.ImageView;
import java.awt.*;

public class BossSamuraiVue extends EnnemisVue {
    private ImageView lame;
    private ImageView chapeau;

    public BossSamuraiVue(Ennemis ennemis, String file){
        super(ennemis, file);
    }


}

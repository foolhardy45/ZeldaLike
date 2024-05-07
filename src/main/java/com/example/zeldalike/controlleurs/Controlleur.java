package com.example.zeldalike.controlleurs;

import com.example.zeldalike.modele.Terrain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.TilePane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controlleur {
    Terrain T ;
    @FXML
    TilePane affichage;
    @FXML
    public void initialize(){
        Image image=new Image();
        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                switch (T[i][j]) {
                    case 1:
                        ;
                    case 2:
                        ;
                    case 3:
                        ;
                }

            }
        }
    }
}

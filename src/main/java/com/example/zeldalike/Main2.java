package com.example.zeldalike;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Création du cercle
        Circle circle = new Circle(50, Color.BLUE);
        circle.setCenterX(150);
        circle.setCenterY(150);

        // Création du conteneur de la scène
        Pane root = new Pane();
        root.getChildren().add(circle);

        // Création de la scène
        Scene scene = new Scene(root, 300, 300);

        // Gestion des événements clavier
        scene.setOnKeyPressed(event -> {
            double deltaX = 0;
            double deltaY = 0;
            // Déplacement du cercle selon la touche pressée
            switch (event.getCode()) {
                case UP:
                    deltaY = -10;
                    break;
                case DOWN:
                    deltaY = 10;
                    break;
                case LEFT:
                    deltaX = -10;
                    break;
                case RIGHT:
                    deltaX = 10;
                    break;
                default:
                    break;
            }
            // Appliquer le déplacement
            circle.setCenterX(circle.getCenterX() + deltaX);
            circle.setCenterY(circle.getCenterY() + deltaY);
        });

        // Affichage de la scène
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

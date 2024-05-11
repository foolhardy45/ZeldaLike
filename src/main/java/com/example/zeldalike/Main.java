package com.example.zeldalike;

import com.example.zeldalike.controlleurs.Controlleur;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {



    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("terrain2.fxml"));
        Parent root = fxmlLoader.load();
        Controlleur controlleur = fxmlLoader.getController();
        Scene scene = new Scene(root, 600, 600);
        stage.setScene(scene);
        stage.setTitle("KKDK!");
        controlleur.setStage(stage);

        // Afficher la scène
        stage.show();
    }
}

package com.example.zeldalike;

//import com.example.zeldalike.controlleurs.Controlleur;

import com.example.zeldalike.controlleurs.Menu_Controlleur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage stg;


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/zeldalike/Menu.fxml"));
        Parent root = fxmlLoader.load();
        Menu_Controlleur controlleur = fxmlLoader.getController();
        Scene scene = new Scene(root, 2560, 1440);
        stage.setScene(scene);
        stage.setTitle("KKDK!");
        stg = stage;


        // Afficher la scène
        stage.show();
    }
}

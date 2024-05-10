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
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        Controlleur controlleur = fxmlLoader.getController();
        stage.setTitle("KKDK!");
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch(event.getCode()){
                    case UP :
                        controlleur.moveUp();
                        break;
                    case DOWN:
                        controlleur.moveDown();
                        break;
                    case LEFT:
                        controlleur.moveLeft();
                        break;
                    case RIGHT:
                        controlleur.moveRight();
                        break;

                    default:
                        break;

                }
            }
        });
        stage.setScene(scene);
        stage.show();
    }
}

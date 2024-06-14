package com.example.zeldalike.controlleurs;

import com.example.zeldalike.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Menu_Controlleur implements Initializable {
    private Parent root;
    @FXML
    private Button startGameButton;

    @FXML
    private Button creditsButton;

    @FXML
    private Button optionsButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


    public void jouer(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.println("menu controller");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/zeldalike/terrain2.fxml"));
        root = fxmlLoader.load();
        Main.stg.setScene(new Scene(root, 2000, 1000));
        Main.stg.show();
    }
}

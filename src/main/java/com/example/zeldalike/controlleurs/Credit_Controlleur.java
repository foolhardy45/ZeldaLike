package com.example.zeldalike.controlleurs;

import com.example.zeldalike.Main;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Credit_Controlleur implements Initializable {
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void retour(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.println("menu controller");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/zeldalike/Menu.fxml"));
        root = fxmlLoader.load();
        Main.stg.setScene(new Scene(root, 500, 500));
        Main.stg.show();
    }
}

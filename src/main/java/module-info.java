module com.example.zeldalike {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jdk.management;


    opens com.example.zeldalike to javafx.fxml;
    exports com.example.zeldalike;
    exports com.example.zeldalike.controlleurs;
    opens com.example.zeldalike.controlleurs to javafx.fxml;
    exports com.example.zeldalike.modele;
    opens com.example.zeldalike.modele to javafx.fxml;
    exports com.example.zeldalike.modele.Arme;
    opens com.example.zeldalike.modele.Arme to javafx.fxml;
    exports com.example.zeldalike.modele.Arme.gun;
    opens com.example.zeldalike.modele.Arme.gun to javafx.fxml;
}
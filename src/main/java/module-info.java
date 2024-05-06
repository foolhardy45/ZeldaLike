module com.example.zeldalike {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zeldalike to javafx.fxml;
    exports com.example.zeldalike;
    exports com.example.zeldalike.controlleurs;
    opens com.example.zeldalike.controlleurs to javafx.fxml;
    exports com.example.zeldalike.modele;
    opens com.example.zeldalike.modele to javafx.fxml;
}
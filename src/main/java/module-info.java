module com.example.zeldalike {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zeldalike to javafx.fxml;
    exports com.example.zeldalike;
}
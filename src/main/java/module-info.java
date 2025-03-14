module com.example.microproyects {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.microproyects to javafx.fxml;
    exports com.example.microproyects;
}
module com.example.microproyects {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.microproyects.controller to javafx.fxml;
    exports com.example.microproyects.controller to javafx.fxml; // Agrega esta línea
    exports com.example.microproyects;// Si necesitas exportar el paquete principal
}
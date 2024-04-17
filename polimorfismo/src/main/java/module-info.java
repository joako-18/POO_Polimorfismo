module com.example.polimorfismo {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;


    opens com.example.polimorfismo to javafx.fxml;
    exports com.example.polimorfismo;
    exports com.example.polimorfismo.controllers;
    opens com.example.polimorfismo.controllers to javafx.fxml;
}
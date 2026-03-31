module com.example.badc {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.badc to javafx.fxml;
    opens com.example.badc.Mithila to javafx.fxml;
    opens com.example.badc.Arnima to javafx.fxml;
    opens com.example.badc.model to javafx.base;
    opens com.example.badc.service to javafx.base;

    exports com.example.badc;
    exports com.example.badc.model;
    exports com.example.badc.service;
    exports com.example.badc.Mithila;
    exports com.example.badc.Arnima;
}
module com.example.badc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.badc to javafx.fxml;
    opens com.example.badc.Arnima to javafx.fxml;

    exports com.example.badc;
    exports com.example.badc.Arnima;
}
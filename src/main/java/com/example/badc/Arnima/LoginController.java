package com.example.badc.Arnima;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML private ComboBox<String> cmbUserType;
    @FXML private TextField txtUsername;
    @FXML private TextField txtPassword;
    @FXML private Label lblMessage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbUserType.setItems(FXCollections.observableArrayList("Farmer", "Seed Dealer"));
    }

    @FXML
    private void handleLogin(ActionEvent event) {
        String type = cmbUserType.getValue();
        if (type == null) {
            lblMessage.setText("Please select user type.");
            return;
        }

        String fxmlFile = "";
        if (type.equals("Farmer")) {
            fxmlFile = "/com/example/badc/Arnima/farmer_dashboard.fxml";
        } else if (type.equals("Seed Dealer")) {
            fxmlFile = "/com/example/badc/Arnima/dealer_dashboard.fxml";
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            lblMessage.setText("Error loading dashboard.");
            e.printStackTrace();
        }
    }
}

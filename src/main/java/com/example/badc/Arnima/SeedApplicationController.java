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

public class SeedApplicationController implements Initializable {

    @FXML private TextField txtName;
    @FXML private TextField txtNID;
    @FXML private ComboBox<String> cmbSeedType;
    @FXML private TextField txtQuantity;
    @FXML private Label lblMessage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbSeedType.setItems(FXCollections.observableArrayList("Rice (BR-28)", "Rice (BR-16)", "Wheat", "Potato", "Jute"));
    }

    @FXML
    private void submitApplication(ActionEvent event) {
        if (txtName.getText().isEmpty() || txtNID.getText().isEmpty() || 
            txtQuantity.getText().isEmpty() || cmbSeedType.getValue() == null) {
            lblMessage.setText("Error: All fields are required!");
        } else {
            lblMessage.setText("Success: Application submitted for " + cmbSeedType.getValue());
        }
    }

    @FXML
    private void clearForm(ActionEvent event) {
        txtName.clear();
        txtNID.clear();
        txtQuantity.clear();
        cmbSeedType.getSelectionModel().clearSelection();
        lblMessage.setText("");
    }

    @FXML
    private void goBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/badc/Arnima/farmer_dashboard.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (Exception e) { e.printStackTrace(); }
    }
}

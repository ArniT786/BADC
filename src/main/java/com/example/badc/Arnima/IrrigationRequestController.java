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

public class IrrigationRequestController implements Initializable {

    @FXML private TextField txtNID;
    @FXML private TextField txtLandSize;
    @FXML private TextField txtLocation;
    @FXML private ComboBox<String> cmbPumpType;
    @FXML private Label lblTrackingID;
    @FXML private Label lblMessage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbPumpType.setItems(FXCollections.observableArrayList("Power Pump (Low Lift)", "Deep Tube Well", "Hand Pump"));
    }

    @FXML
    private void submitRequest(ActionEvent event) {
        if (txtNID.getText().isEmpty() || txtLandSize.getText().isEmpty() || txtLocation.getText().isEmpty() || cmbPumpType.getValue() == null) {
            lblMessage.setText("Error: Required fields are missing.");
        } else {
            lblTrackingID.setText("Tracking ID: BADC-IRR-" + (int)(Math.random() * 9000 + 1000));
            lblMessage.setText("Success: Irrigation request submitted.");
        }
    }

    @FXML private void clearForm(ActionEvent event) {
        txtNID.clear(); txtLandSize.clear(); txtLocation.clear();
        cmbPumpType.getSelectionModel().clearSelection();
        lblMessage.setText(""); lblTrackingID.setText("");
    }

    @FXML private void goBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/badc/Arnima/farmer_dashboard.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (Exception e) { e.printStackTrace(); }
    }
}

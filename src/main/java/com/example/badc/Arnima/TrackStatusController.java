package com.example.badc.Arnima;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class TrackStatusController implements Initializable {

    @FXML private TextField txtSearchID;
    @FXML private Label lblSeedAppID, lblSeedType, lblSeedStatus, lblSeedRemarks;
    @FXML private Label lblIrrigationID, lblIrrigationLocation, lblIrrigationStatus, lblMessage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    @FXML
    private void searchStatus(ActionEvent event) {
        if (txtSearchID.getText().isEmpty()) {
            lblMessage.setText("Please enter NID or Tracking ID.");
        } else {
            // Populate dummy data
            lblSeedAppID.setText("S-991");
            lblSeedType.setText("Rice BR-28");
            lblSeedStatus.setText("APPROVED");
            lblSeedRemarks.setText("Pick up from Local BADC Hub");
            
            lblIrrigationID.setText("IRR-552");
            lblIrrigationLocation.setText("Sector 4, Bogura");
            lblIrrigationStatus.setText("PENDING INSPECTION");
            lblMessage.setText("Results found for ID: " + txtSearchID.getText());
        }
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

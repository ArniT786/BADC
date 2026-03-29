package com.example.badc.Arnima;

import javafx.collections.FXCollections;
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

public class UpdateShopController implements Initializable {

    @FXML private TextField txtDealerNID, txtShopName, txtAddress, txtPhone;
    @FXML private Label lblMessage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    @FXML
    private void loadShopInfo(ActionEvent event) {
        if (txtDealerNID.getText().isEmpty()) {
            lblMessage.setText("Enter NID to fetch profile.");
        } else {
            txtShopName.setText("M/S Arnima Seed Stores");
            txtAddress.setText("College Road, Bogura");
            txtPhone.setText("01712344556");
            lblMessage.setText("Profile loaded for NID: " + txtDealerNID.getText());
        }
    }

    @FXML
    private void updateProfile(ActionEvent event) {
        if (txtShopName.getText().isEmpty() || txtAddress.getText().isEmpty()) {
            lblMessage.setText("Validation failed: No data to update.");
        } else {
            lblMessage.setText("Success: Shop profile updated locally.");
        }
    }

    @FXML private void clearForm(ActionEvent event) {
        txtShopName.clear(); txtAddress.clear(); txtPhone.clear(); lblMessage.setText("");
    }

    @FXML private void goBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/badc/Arnima/dealer_dashboard.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (Exception e) { e.printStackTrace(); }
    }
}

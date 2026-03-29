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

public class RecordSaleController implements Initializable {

    @FXML private TextField txtDealerNID;
    @FXML private TextField txtFarmerNID;
    @FXML private ComboBox<String> cmbSeedType;
    @FXML private TextField txtQuantity;
    @FXML private Label lblStockStatus;
    @FXML private Label lblMessage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbSeedType.setItems(FXCollections.observableArrayList("Rice (BR-28)", "Wheat (Gold)", "Potato Seed"));
    }

    @FXML
    private void confirmSale(ActionEvent event) {
        if (txtFarmerNID.getText().isEmpty() || txtQuantity.getText().isEmpty() || cmbSeedType.getValue() == null) {
            lblMessage.setText("Error: Fill all fields before confirming sale.");
        } else {
            lblStockStatus.setText("Checking Local Stock... [AVAILABLE]");
            lblMessage.setText("Sale recorded for NID: " + txtFarmerNID.getText());
        }
    }

    @FXML
    private void clearForm(ActionEvent event) {
        txtFarmerNID.clear();
        txtQuantity.clear();
        cmbSeedType.getSelectionModel().clearSelection();
        lblMessage.setText("");
        lblStockStatus.setText("");
    }

    @FXML
    private void goBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/badc/Arnima/dealer_dashboard.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (Exception e) { e.printStackTrace(); }
    }
}

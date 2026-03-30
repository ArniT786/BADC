package com.example.badc.Mithila;

import com.example.badc.model.StockRecord;
import com.example.badc.service.StockService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.example.badc.SceneSwitcher;

public class DistributeInputController implements Initializable {

    @FXML
    private TextField farmerNid;
    @FXML
    private ComboBox<String> itemTypeDrop;
    @FXML
    private ComboBox<String> itemNameDrop;
    @FXML
    private TextField qtyField;
    @FXML
    private Label eligibilityLabel;
    @FXML
    private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemTypeDrop.getItems().addAll("Seeds", "Fertilizer");
        itemTypeDrop.setOnAction(e -> {
            String selected = itemTypeDrop.getValue();
            if ("Seeds".equals(selected)) {
                itemNameDrop.getItems().setAll("Rice Seed", "Wheat Seed", "Jute Seed");
            } else if ("Fertilizer".equals(selected)) {
                itemNameDrop.getItems().setAll("Urea", "TSP", "MOP");
            }
            itemNameDrop.setValue(null);
        });
    }

    @FXML
    private void checkEligibility(ActionEvent event) {
        String nid = farmerNid.getText().trim();
        if (nid.isEmpty()) {
            eligibilityLabel.setText("Enter Farmer NID first");
            return;
        }
        boolean eligible = StockService.checkEligibility(nid);
        eligibilityLabel.setText(eligible
                ? "Farmer is eligible for distribution"
                : "Farmer not found. Not eligible.");
    }

    @FXML
    private void confirmDistribution(ActionEvent event) {
        String eligText = eligibilityLabel.getText();
        if (!eligText.contains("eligible")) {
            msgLabel.setText("Check eligibility first");
            return;
        }

        String itemType = itemTypeDrop.getValue();
        String itemName = itemNameDrop.getValue();
        if (itemType == null || itemName == null) {
            msgLabel.setText("Select item type and name");
            return;
        }

        String qtyText = qtyField.getText().trim();
        if (qtyText.isEmpty()) {
            msgLabel.setText("Quantity is required");
            return;
        }

        double qty;
        try {
            qty = Double.parseDouble(qtyText);
        } catch (NumberFormatException ex) {
            msgLabel.setText("Quantity must be a number");
            return;
        }

        if (qty <= 0) {
            msgLabel.setText("Quantity must be greater than zero");
            return;
        }

        String nid = farmerNid.getText().trim();
        String today = LocalDate.now().toString();
        StockRecord r = new StockRecord("", nid, itemType, itemName, qty, today, "OFFICER", true);

        if (StockService.distributeItem(r)) {
            msgLabel.setText("Distribution recorded successfully");
            clearForm();
        } else {
            msgLabel.setText("Distribution failed");
        }
    }

    @FXML
    private void clearForm(ActionEvent event) {
        clearForm();
    }

    private void clearForm() {
        farmerNid.clear();
        itemTypeDrop.setValue(null);
        itemNameDrop.setValue(null);
        itemNameDrop.getItems().clear();
        qtyField.clear();
        eligibilityLabel.setText("");
        msgLabel.setText("");
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/field_officer_dashboard.fxml");
    }
}

package com.example.badc.Mithila;

import com.example.badc.model.Farmer;
import com.example.badc.model.ProductionRecord;
import com.example.badc.service.FarmerService;
import com.example.badc.service.ProductionService;
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

public class CropYieldController implements Initializable {

    @FXML
    private TextField nidField;
    @FXML
    private ComboBox<String> cropDrop;
    @FXML
    private ComboBox<String> seasonDrop;
    @FXML
    private TextField harvestWt;
    @FXML
    private Label verifyLabel;
    @FXML
    private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cropDrop.getItems().addAll("Rice", "Wheat", "Jute", "Maize", "Potato");
        seasonDrop.getItems().addAll("Rabi 2024", "Kharif 2024", "Rabi 2025", "Kharif 2025");
    }

    @FXML
    private void verifyFarmer(ActionEvent event) {
        String nid = nidField.getText().trim();
        if (nid.isEmpty()) {
            verifyLabel.setText("Enter NID first");
            return;
        }
        Farmer f = FarmerService.findByNid(nid);
        if (f != null) {
            verifyLabel.setText("Found: " + f.getName() + " | District: " + f.getDistrict());
        } else {
            verifyLabel.setText("Farmer not found");
        }
    }

    @FXML
    private void saveYieldData(ActionEvent event) {
        String verifyText = verifyLabel.getText();
        if (verifyText.contains("not found") || verifyText.isEmpty()) {
            msgLabel.setText("Please verify farmer first");
            return;
        }

        String crop = cropDrop.getValue();
        if (crop == null) {
            msgLabel.setText("Select crop type");
            return;
        }

        String season = seasonDrop.getValue();
        if (season == null) {
            msgLabel.setText("Select season");
            return;
        }

        String wtText = harvestWt.getText().trim();
        if (wtText.isEmpty()) {
            msgLabel.setText("Harvest weight is required");
            return;
        }

        double weight;
        try {
            weight = Double.parseDouble(wtText);
        } catch (NumberFormatException ex) {
            msgLabel.setText("Harvest weight must be a number");
            return;
        }

        if (weight <= 0) {
            msgLabel.setText("Weight must be greater than zero");
            return;
        }

        String nid = nidField.getText().trim();
        String today = LocalDate.now().toString();
        ProductionRecord p = new ProductionRecord("", nid, crop, season, today, "OFFICER", weight);

        if (ProductionService.saveProduction(p)) {
            msgLabel.setText("Yield data saved successfully");
            clearForm();
        } else {
            msgLabel.setText("Failed to save yield data");
        }
    }

    @FXML
    private void clearForm(ActionEvent event) {
        clearForm();
    }

    private void clearForm() {
        nidField.clear();
        cropDrop.setValue(null);
        seasonDrop.setValue(null);
        harvestWt.clear();
        verifyLabel.setText("");
        msgLabel.setText("");
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/field_officer_dashboard.fxml");
    }
}

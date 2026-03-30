package com.example.badc.Mithila;

import com.example.badc.model.Inspection;
import com.example.badc.service.FarmerService;
import com.example.badc.service.InspectionService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.badc.SceneSwitcher;

public class CropInspectionController implements Initializable {

    @FXML
    private TextField farmerNid;
    @FXML
    private ComboBox<String> cropDrop;
    @FXML
    private TextField dateField;
    @FXML
    private ComboBox<String> stageDrop;
    @FXML
    private TextArea conditionArea;
    @FXML
    private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cropDrop.getItems().addAll("Rice", "Wheat", "Jute", "Maize", "Potato");
        stageDrop.getItems().addAll("Seedling", "Vegetative", "Flowering", "Harvesting");
    }

    @FXML
    private void saveInspection(ActionEvent event) {
        String nid = farmerNid.getText().trim();
        String crop = cropDrop.getValue();
        String date = dateField.getText().trim();
        String stage = stageDrop.getValue();
        String condition = conditionArea.getText().trim();

        if (nid.isEmpty()) {
            msgLabel.setText("Farmer NID is required");
            return;
        }
        if (!FarmerService.farmerExists(nid)) {
            msgLabel.setText("Farmer not found in system");
            return;
        }
        if (crop == null) {
            msgLabel.setText("Please select crop type");
            return;
        }
        if (date.isEmpty()) {
            msgLabel.setText("Inspection date is required");
            return;
        }
        if (stage == null) {
            msgLabel.setText("Please select growth stage");
            return;
        }
        if (condition.isEmpty()) {
            msgLabel.setText("Condition details are required");
            return;
        }

        Inspection i = new Inspection("", nid, crop, date, stage, condition, "OFFICER");
        if (InspectionService.saveInspection(i)) {
            msgLabel.setText("Inspection saved successfully");
            clearForm();
        } else {
            msgLabel.setText("Failed to save inspection");
        }
    }

    @FXML
    private void clearForm(ActionEvent event) {
        clearForm();
    }

    private void clearForm() {
        farmerNid.clear();
        cropDrop.setValue(null);
        dateField.clear();
        stageDrop.setValue(null);
        conditionArea.clear();
        msgLabel.setText("");
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/field_officer_dashboard.fxml");
    }
}

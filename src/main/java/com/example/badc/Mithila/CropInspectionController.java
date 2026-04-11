package com.example.badc.Mithila;

import com.example.badc.model.Inspection;
import com.example.badc.service.FarmerService;
import com.example.badc.service.InspectionService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import com.example.badc.SceneSwitcher;

public class CropInspectionController implements Initializable {

    @FXML private TextField nid_txt;
    @FXML private ComboBox<String> crop_cb;
    @FXML private DatePicker date_dp;
    @FXML private ComboBox<String> stage_cb;
    @FXML private TextField cond_txt;
    @FXML private Label msg_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        crop_cb.getItems().addAll("Rice", "Wheat", "Jute", "Maize", "Potato");
        stage_cb.getItems().addAll("Seedling", "Vegetative", "Flowering", "Harvesting");
        date_dp.setValue(LocalDate.now());
    }

    @FXML
    private void saveInspection(ActionEvent event) {
        String nid = nid_txt.getText().trim();
        String crop = crop_cb.getValue();
        LocalDate dateValue = date_dp.getValue();
        String stage = stage_cb.getValue();
        String condition = cond_txt.getText().trim();

        if (nid.isEmpty() || crop == null || dateValue == null || stage == null || condition.isEmpty()) {
            msg_lbl.setText("Please fill all fields");
            return;
        }

        if (!FarmerService.farmerExists(nid)) {
            msg_lbl.setText("Farmer not found");
            return;
        }

        Inspection i = new Inspection("", nid, crop, dateValue.toString(), stage, condition, "OFFICER");
        if (InspectionService.saveInspection(i)) {
            msg_lbl.setText("Success! Inspection saved.");
            clearForm();
        } else {
            msg_lbl.setText("Failed to save.");
        }
    }

    @FXML
    private void clearForm(ActionEvent event) {
        clearForm();
    }

    private void clearForm() {
        nid_txt.clear();
        crop_cb.setValue(null);
        date_dp.setValue(LocalDate.now());
        stage_cb.setValue(null);
        cond_txt.clear();
        msg_lbl.setText("");
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/field_officer_dashboard.fxml");
    }
}

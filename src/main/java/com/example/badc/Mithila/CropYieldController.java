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

    @FXML private TextField nid_txt;
    @FXML private ComboBox<String> crop_cb;
    @FXML private ComboBox<String> seas_cb;
    @FXML private TextField harv_txt;
    @FXML private Label veri_lbl;
    @FXML private Label msg_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        crop_cb.getItems().addAll("Rice", "Wheat", "Jute", "Maize", "Potato");
        seas_cb.getItems().addAll("Rabi 2024", "Kharif 2024", "Rabi 2025", "Kharif 2025");
    }

    @FXML
    private void verifyFarmer(ActionEvent event) {
        String nid = nid_txt.getText().trim();
        if (nid.isEmpty()) {
            veri_lbl.setText("Enter NID first");
            return;
        }
        Farmer f = FarmerService.findByNid(nid);
        if (f != null) {
            veri_lbl.setText("Found: " + f.getName());
        } else {
            veri_lbl.setText("Farmer not found");
        }
    }

    @FXML
    private void saveYieldData(ActionEvent event) {
        if (!veri_lbl.getText().contains("Found")) {
            msg_lbl.setText("Please verify farmer first");
            return;
        }

        String crop = crop_cb.getValue();
        String season = seas_cb.getValue();
        String wtStr = harv_txt.getText().trim();

        if (crop == null || season == null || wtStr.isEmpty()) {
            msg_lbl.setText("Please fill all fields");
            return;
        }

        double weight;
        try {
            weight = Double.parseDouble(wtStr);
        } catch (NumberFormatException ex) {
            msg_lbl.setText("Invalid weight");
            return;
        }

        String nid = nid_txt.getText().trim();
        String today = LocalDate.now().toString();
        ProductionRecord p = new ProductionRecord("", nid, crop, season, today, "OFFICER", weight);

        if (ProductionService.saveProduction(p)) {
            msg_lbl.setText("Success! Yield saved.");
            clearForm();
        } else {
            msg_lbl.setText("Failed.");
        }
    }

    @FXML
    private void clearForm(ActionEvent event) {
        clearForm();
    }

    private void clearForm() {
        nid_txt.clear();
        crop_cb.setValue(null);
        seas_cb.setValue(null);
        harv_txt.clear();
        veri_lbl.setText("");
        msg_lbl.setText("");
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/field_officer_dashboard.fxml");
    }
}

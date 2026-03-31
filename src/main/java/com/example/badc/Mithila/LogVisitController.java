package com.example.badc.Mithila;

import com.example.badc.model.VisitLog;
import com.example.badc.service.FarmerService;
import com.example.badc.service.VisitService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import com.example.badc.SceneSwitcher;

public class LogVisitController implements Initializable {

    @FXML private TextField nid_txt;
    @FXML private DatePicker date_dp;
    @FXML private TextField advice_txt;
    @FXML private TextField notes_txt;
    @FXML private Label msg_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        date_dp.setValue(LocalDate.now());
    }

    @FXML
    private void saveVisitLog(ActionEvent event) {
        String nid = nid_txt.getText().trim();
        LocalDate dateValue = date_dp.getValue();
        String advice = advice_txt.getText().trim();
        String notes = notes_txt.getText().trim();

        if (nid.isEmpty() || dateValue == null || advice.isEmpty() || notes.isEmpty()) {
            msg_lbl.setText("Please fill all fields");
            return;
        }

        if (!FarmerService.farmerExists(nid)) {
            msg_lbl.setText("Farmer not found");
            return;
        }

        VisitLog v = new VisitLog("", nid, dateValue.toString(), advice, notes, "OFFICER");
        if (VisitService.saveVisit(v)) {
            msg_lbl.setText("Success! Visit saved.");
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
        date_dp.setValue(LocalDate.now());
        advice_txt.clear();
        notes_txt.clear();
        msg_lbl.setText("");
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/Mithila/field_officer_dashboard.fxml");
    }
}

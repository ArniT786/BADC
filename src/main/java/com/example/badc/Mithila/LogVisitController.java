package com.example.badc.Mithila;

import com.example.badc.model.VisitLog;
import com.example.badc.service.FarmerService;
import com.example.badc.service.VisitService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.badc.SceneSwitcher;

public class LogVisitController implements Initializable {

    @FXML
    private TextField nidField;
    @FXML
    private TextField visitDate;
    @FXML
    private TextArea adviceArea;
    @FXML
    private TextArea notesArea;
    @FXML
    private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // No special initialization needed
    }

    @FXML
    private void saveVisitLog(ActionEvent event) {
        String nid = nidField.getText().trim();
        String date = visitDate.getText().trim();
        String advice = adviceArea.getText().trim();
        String notes = notesArea.getText().trim();

        if (nid.isEmpty()) {
            msgLabel.setText("Farmer NID is required");
            return;
        }
        if (!FarmerService.farmerExists(nid)) {
            msgLabel.setText("Farmer not found in system");
            return;
        }
        if (date.isEmpty()) {
            msgLabel.setText("Visit date is required");
            return;
        }
        if (advice.isEmpty() || advice.length() < 10) {
            msgLabel.setText("Advice must be at least 10 characters");
            return;
        }
        if (notes.isEmpty()) {
            msgLabel.setText("Notes are required");
            return;
        }

        VisitLog v = new VisitLog("", nid, date, advice, notes, "OFFICER");
        if (VisitService.saveVisit(v)) {
            msgLabel.setText("Visit log saved successfully");
            clearForm();
        } else {
            msgLabel.setText("Failed to save visit log");
        }
    }

    @FXML
    private void clearForm(ActionEvent event) {
        clearForm();
    }

    private void clearForm() {
        nidField.clear();
        visitDate.clear();
        adviceArea.clear();
        notesArea.clear();
        msgLabel.setText("");
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/field_officer_dashboard.fxml");
    }
}

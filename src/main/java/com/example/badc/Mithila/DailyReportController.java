package com.example.badc.Mithila;

import com.example.badc.model.DailyLog;
import com.example.badc.service.DailyLogService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.badc.SceneSwitcher;

public class DailyReportController implements Initializable {

    @FXML
    private TextField officerNid;
    @FXML
    private TextField reportDate;
    @FXML
    private TextArea summaryArea;
    @FXML
    private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // No special initialization needed
    }

    @FXML
    private void submitReport(ActionEvent event) {
        String nid = officerNid.getText().trim();
        String date = reportDate.getText().trim();
        String summary = summaryArea.getText().trim();

        if (nid.isEmpty()) {
            msgLabel.setText("Officer NID is required");
            return;
        }
        if (date.isEmpty()) {
            msgLabel.setText("Report date is required");
            return;
        }
        if (summary.isEmpty() || summary.length() < 20) {
            msgLabel.setText("Summary must be at least 20 characters");
            return;
        }

        DailyLog log = new DailyLog("", nid, date, summary);
        if (DailyLogService.saveLog(log)) {
            msgLabel.setText("Daily report submitted successfully");
            clearForm();
        } else {
            msgLabel.setText("Failed to submit report");
        }
    }

    @FXML
    private void clearForm(ActionEvent event) {
        clearForm();
    }

    private void clearForm() {
        officerNid.clear();
        reportDate.clear();
        summaryArea.clear();
        msgLabel.setText("");
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/field_officer_dashboard.fxml");
    }
}

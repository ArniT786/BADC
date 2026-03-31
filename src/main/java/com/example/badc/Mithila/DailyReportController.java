package com.example.badc.Mithila;

import com.example.badc.model.DailyLog;
import com.example.badc.service.DailyLogService;
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

public class DailyReportController implements Initializable {

    @FXML private TextField nid_txt;
    @FXML private DatePicker date_dp;
    @FXML private TextField summ_txt;
    @FXML private Label msg_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        date_dp.setValue(LocalDate.now());
    }

    @FXML
    private void submitReport(ActionEvent event) {
        String nid = nid_txt.getText().trim();
        LocalDate dateValue = date_dp.getValue();
        String summary = summ_txt.getText().trim();

        if (nid.isEmpty() || dateValue == null || summary.isEmpty()) {
            msg_lbl.setText("Please fill all fields");
            return;
        }

        DailyLog log = new DailyLog("", nid, dateValue.toString(), summary);
        if (DailyLogService.saveLog(log)) {
            msg_lbl.setText("Success! Report submitted.");
            clearForm();
        } else {
            msg_lbl.setText("Failed to submit.");
        }
    }

    @FXML
    private void clearForm(ActionEvent event) {
        clearForm();
    }

    private void clearForm() {
        nid_txt.clear();
        date_dp.setValue(LocalDate.now());
        summ_txt.clear();
        msg_lbl.setText("");
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/field_officer_dashboard.fxml");
    }
}

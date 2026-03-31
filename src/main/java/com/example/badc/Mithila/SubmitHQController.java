package com.example.badc.Mithila;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import com.example.badc.SceneSwitcher;

public class SubmitHQController implements Initializable {

    @FXML private TextField nid_txt;
    @FXML private ComboBox<String> type_cb;
    @FXML private TextField cont_txt;
    @FXML private Label msg_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        type_cb.getItems().addAll("Daily", "Weekly", "Monthly", "Emergency");
    }

    @FXML
    private void submitReport(ActionEvent event) {
        msg_lbl.setText("Report submitted to HQ.");
    }

    @FXML
    private void clearForm(ActionEvent event) {
        nid_txt.clear();
        type_cb.setValue(null);
        cont_txt.clear();
        msg_lbl.setText("");
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/Mithila/report_officer_dashboard.fxml");
    }
}

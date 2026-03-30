package com.example.badc.Mithila;

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

public class SubmitHQController implements Initializable {

    @FXML
    private TextField officerNid;
    @FXML
    private ComboBox reportTypeDrop;
    @FXML
    private TextArea reportArea;
    @FXML
    private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void submitReport(ActionEvent event) {
    }

    @FXML
    private void clearForm(ActionEvent event) {
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/report_officer_dashboard.fxml");
    }
}

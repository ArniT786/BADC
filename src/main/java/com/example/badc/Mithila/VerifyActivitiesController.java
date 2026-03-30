package com.example.badc.Mithila;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.badc.SceneSwitcher;

public class VerifyActivitiesController implements Initializable {

    @FXML
    private ComboBox officerDrop;
    @FXML
    private TextField officerNid;
    @FXML
    private TableView logTable;
    @FXML
    private TableColumn colDate;
    @FXML
    private TableColumn colSummary;
    @FXML
    private TableColumn colStat;
    @FXML
    private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void loadLogs(ActionEvent event) {
    }

    @FXML
    private void approveLog(ActionEvent event) {
    }

    @FXML
    private void rejectLog(ActionEvent event) {
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/report_officer_dashboard.fxml");
    }
}

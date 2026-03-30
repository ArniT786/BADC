package com.example.badc.Mithila;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.badc.SceneSwitcher;

public class FieldOfficerDashboardController implements Initializable {

    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void openRegisterFarmer(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/register_farmer.fxml");
    }

    @FXML
    private void openCropInspection(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/crop_inspection.fxml");
    }

    @FXML
    private void openDistribute(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/distribute_input.fxml");
    }

    @FXML
    private void openLogVisit(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/log_visit.fxml");
    }

    @FXML
    private void openCropYield(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/crop_yield.fxml");
    }

    @FXML
    private void openDailyReport(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/daily_report.fxml");
    }

    @FXML
    private void openViewTasks(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/view_tasks.fxml");
    }

    @FXML
    private void handleLogout(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/login.fxml");
    }
}

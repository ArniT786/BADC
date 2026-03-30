package com.example.badc.Mithila;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.badc.SceneSwitcher;

public class ReportOfficerDashboardController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void openFarmerSummary(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/farmer_summary.fxml");
    }

    @FXML
    private void openProductionReport(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/production_report.fxml");
    }

    @FXML
    private void openFertilizerTrends(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/fertilizer_trends.fxml");
    }

    @FXML
    private void openVerifyActivities(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/verify_activities.fxml");
    }

    @FXML
    private void openMonitorIssues(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/monitor_issues.fxml");
    }

    @FXML
    private void openSubmitHQ(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/submit_hq.fxml");
    }

    @FXML
    private void handleLogout(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/login.fxml");
    }
}

package com.example.badc.Mithila;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import com.example.badc.SceneSwitcher;

public class ReportOfficerDashboardController implements Initializable {

    @FXML private Label title_lbl;
    @FXML private Label welcome_lbl;
    @FXML private Button fsum_btn;
    @FXML private Button prod_btn;
    @FXML private Button trnd_btn;
    @FXML private Button veri_btn;
    @FXML private Button moni_btn;
    @FXML private Button shq_btn;
    @FXML private Button exit_btn;

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

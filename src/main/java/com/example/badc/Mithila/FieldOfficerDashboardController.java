package com.example.badc.Mithila;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import com.example.badc.SceneSwitcher;

public class FieldOfficerDashboardController implements Initializable {

    @FXML private Label title_lbl;
    @FXML private Label welcome_lbl;
    @FXML private Button reg_btn;
    @FXML private Button ins_btn;
    @FXML private Button dis_btn;
    @FXML private Button log_btn;
    @FXML private Button yiel_btn;
    @FXML private Button repo_btn;
    @FXML private Button task_btn;
    @FXML private Button exit_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    private void openRegisterFarmer(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/Mithila/register_farmer.fxml");
    }

    @FXML
    private void openCropInspection(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/Mithila/crop_inspection.fxml");
    }

    @FXML
    private void openDistribute(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/Mithila/distribute_input.fxml");
    }

    @FXML
    private void openLogVisit(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/Mithila/log_visit.fxml");
    }

    @FXML
    private void openCropYield(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/Mithila/crop_yield.fxml");
    }

    @FXML
    private void openDailyReport(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/Mithila/daily_report.fxml");
    }

    @FXML
    private void openViewTasks(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/Mithila/view_tasks.fxml");
    }

    @FXML
    private void handleLogout(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/Mithila/login.fxml");
    }
}

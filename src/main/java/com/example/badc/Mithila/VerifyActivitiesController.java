package com.example.badc.Mithila;

import com.example.badc.model.DailyLog;
import com.example.badc.service.DailyLogService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class VerifyActivitiesController implements Initializable {

    @FXML private ComboBox<String> officerDrop;
    @FXML private TextField officerNid;
    @FXML private TableView<DailyLog> logTable;
    @FXML private TableColumn<DailyLog, String> colDate;
    @FXML private TableColumn<DailyLog, String> colSummary;
    @FXML private TableColumn<DailyLog, String> colStat;
    @FXML private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        officerDrop.getItems().addAll("Rahim Uddin", "Karim Mia");
        
        colDate.setCellValueFactory(new PropertyValueFactory<>("reportDate"));
        colSummary.setCellValueFactory(new PropertyValueFactory<>("summary"));
        colStat.setCellValueFactory(new PropertyValueFactory<>("status"));

        officerDrop.setOnAction(e -> {
            String selected = officerDrop.getValue();
            if ("Rahim Uddin".equals(selected)) {
                officerNid.setText("1234567890");
            }
            if ("Karim Mia".equals(selected)) {
                officerNid.setText("0987654321");
            }
        });
    }

    @FXML
    public void loadLogs(ActionEvent e) {
        String officerNidVal = officerNid.getText().trim();
        if (officerNidVal.isEmpty()) {
            msgLabel.setText("Officer NID is required");
            return;
        }

        List<DailyLog> logList = DailyLogService.getByOfficerNid(officerNidVal);
        if (logList.isEmpty()) {
            msgLabel.setText("No logs found for this officer");
            return;
        }

        logTable.setItems(FXCollections.observableArrayList(logList));
        msgLabel.setText("Loaded " + logList.size() + " log(s) for officer " + officerNidVal);
    }

    @FXML
    public void approveLog(ActionEvent e) {
        DailyLog selectedLog = logTable.getSelectionModel().getSelectedItem();
        if (selectedLog == null) {
            msgLabel.setText("Please select a log first");
            return;
        }

        if (selectedLog.getStatus().equals("APPROVED")) {
            msgLabel.setText("This log is already approved");
            return;
        }

        boolean updated = DailyLogService.updateStatus(selectedLog.getLogId(), "APPROVED");
        if (updated) {
            List<DailyLog> reloaded = DailyLogService.getByOfficerNid(officerNid.getText().trim());
            logTable.setItems(FXCollections.observableArrayList(reloaded));
            msgLabel.setText("Log approved successfully");
        } else {
            msgLabel.setText("Could not update log status");
        }
    }

    @FXML
    public void rejectLog(ActionEvent e) {
        DailyLog selectedLog = logTable.getSelectionModel().getSelectedItem();
        if (selectedLog == null) {
            msgLabel.setText("Please select a log first");
            return;
        }

        if (selectedLog.getStatus().equals("NEEDS CORRECTION")) {
            msgLabel.setText("Already marked as needs correction");
            return;
        }

        boolean updated = DailyLogService.updateStatus(selectedLog.getLogId(), "NEEDS CORRECTION");
        if (updated) {
            List<DailyLog> reloaded = DailyLogService.getByOfficerNid(officerNid.getText().trim());
            logTable.setItems(FXCollections.observableArrayList(reloaded));
            msgLabel.setText("Log marked as needs correction");
        } else {
            msgLabel.setText("Could not update log status");
        }
    }

    @FXML
    public void goBack(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/badc/Mithila/report_officer_dashboard.fxml"));
            Stage stage = (Stage) officerNid.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            // file ops wrap catch
        }
    }
}

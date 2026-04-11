package com.example.badc.Mithila;

import com.example.badc.model.FieldIssue;
import com.example.badc.service.FieldIssueService;
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

public class MonitorIssuesController implements Initializable {

    @FXML private TableView<FieldIssue> issueTable;
    @FXML private TableColumn<FieldIssue, String> colId;
    @FXML private TableColumn<FieldIssue, String> colLocation;
    @FXML private TableColumn<FieldIssue, String> colDesc;
    @FXML private TableColumn<FieldIssue, String> colPriority;
    @FXML private TextArea detailArea;
    @FXML private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("issueId"));
        colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        colPriority.setCellValueFactory(new PropertyValueFactory<>("priority"));

        issueTable.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                detailArea.setText(
                    "Issue ID: " + newVal.getIssueId() + "\n" +
                    "Location: " + newVal.getLocation() + "\n" +
                    "Priority: " + newVal.getPriority() + "\n" +
                    "Reported By: " + newVal.getReportedByNid() + "\n" +
                    "Date: " + newVal.getReportDate() + "\n" +
                    "Detail: " + newVal.getDetail()
                );
            }
        });
    }

    @FXML
    public void loadIssues(ActionEvent e) {
        List<FieldIssue> issueList = FieldIssueService.getAllIssues();
        if (issueList.isEmpty()) {
            msgLabel.setText("No issues reported yet");
            return;
        }

        issueTable.setItems(FXCollections.observableArrayList(issueList));
        
        long highCount = 0;
        for (FieldIssue issue : issueList) {
            if ("HIGH".equals(issue.getPriority())) {
                highCount++;
            }
        }
        
        msgLabel.setText("Total issues: " + issueList.size() + " | High priority: " + highCount);
    }

    @FXML
    public void goBack(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/badc/Mithila/report_officer_dashboard.fxml"));
            Stage stage = (Stage) msgLabel.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            // file ops wrap catch
        }
    }
}

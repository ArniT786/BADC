package com.example.badc.Meraj.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class GenerateAdministrativeReportsController {

    @FXML
    private Button downloadButton;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private Button generateButton;
    @FXML
    private Button fetchDataButton;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private ComboBox<String> reportTypeCombo;
    @FXML
    private Button processButton;
    @FXML
    private Label confirmationLabel;
    @FXML
    private Button validateButton;
    @FXML
    private Button saveButton;
    @FXML
    private TextArea reportPreviewArea;


    @FXML
    public void initialize() {
        reportTypeCombo.getItems().addAll("Financial Report", "Inventory Report", "User Activity Report");
        confirmationLabel.setText("");
    }

    @FXML
    public void fetchDataButton(ActionEvent actionEvent) {
        reportPreviewArea.setText("Data fetched successfully...\n");
        confirmationLabel.setText("Data loaded");
    }

    @FXML
    public void validateButton(ActionEvent actionEvent) {

        LocalDate start = startDatePicker.getValue();
        LocalDate end = endDatePicker.getValue();
        String type = reportTypeCombo.getValue();

        if (start == null || end == null || type == null) {
            showAlert("Please fill all fields!");
            return;
        }

        if (end.isBefore(start)) {
            showAlert("End date must be after start date!");
            return;
        }

        confirmationLabel.setText("Validation successful");
    }

    @FXML
    public void processButton(ActionEvent actionEvent) {
        reportPreviewArea.appendText("Processing data...\n");
        confirmationLabel.setText("Processing complete");
    }

    @FXML
    public void generateButton(ActionEvent actionEvent) {
        reportPreviewArea.setText("Report generated...");
        confirmationLabel.setText("Done");
    }

    @FXML
    public void saveButton(ActionEvent actionEvent) {
        confirmationLabel.setText("Report saved successfully");
    }

    @FXML
    public void downloadButton(ActionEvent actionEvent) {
        confirmationLabel.setText("Report downloaded");
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
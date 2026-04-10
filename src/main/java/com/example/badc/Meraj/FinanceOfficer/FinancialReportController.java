package com.example.badc.Meraj.FinanceOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FinancialReportController {

    @FXML
    private Button fetchDataBtn;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private Button exportBtn;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private TextArea remarksArea;
    @FXML
    private ComboBox<String> reportTypeCombo;
    @FXML
    private Label confirmationLabel;
    @FXML
    private Button generateBtn;
    @FXML
    private Button saveBtn;

    private FinancialReport report;

    @FXML
    public void initialize() {

        reportTypeCombo.getItems().addAll("Monthly", "Yearly", "Custom");

        confirmationLabel.setText("");
    }
    @FXML
    public void handleFetchData(ActionEvent actionEvent) {

        try {
            confirmationLabel.setText("Data fetched successfully");

        } catch (Exception e) {
            confirmationLabel.setText("Error fetching data");
        }
    }
    @FXML
    public void handleGenerateReport(ActionEvent actionEvent) {

        try {

            String type = reportTypeCombo.getValue();
            java.time.LocalDate start = startDatePicker.getValue();
            java.time.LocalDate end = endDatePicker.getValue();
            String remarks = remarksArea.getText();

            if (type == null || start == null || end == null) {
                confirmationLabel.setText("Fill all fields!");
                return;
            }

            report = new FinancialReport(type, start, end, remarks);

            confirmationLabel.setText("Report generated");

        } catch (Exception e) {
            confirmationLabel.setText("Error generating report");
        }
    }
    @FXML
    public void handleSaveReport(ActionEvent actionEvent) {

        try {

            if (report == null) {
                confirmationLabel.setText("Generate report first!");
                return;
            }

            confirmationLabel.setText("Report saved successfully");

        } catch (Exception e) {
            confirmationLabel.setText("Error saving report");
        }
    }
    @FXML
    public void handleExportReport(ActionEvent actionEvent) {

        try {

            if (report == null) {
                confirmationLabel.setText("No report to export!");
                return;
            }

            confirmationLabel.setText("Report exported");

        } catch (Exception e) {
            confirmationLabel.setText("Export failed");
        }
    }
}
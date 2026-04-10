package com.example.badc.Meraj.FinanceOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class FinanceOfficerController {

    @FXML
    public void initialize() {
    }

    // Common method for scene switch
    private void switchScene(ActionEvent event, String fxmlFile) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            System.out.println("Error loading: " + fxmlFile);
        }
    }

    @FXML
    public void handleManagePayments(ActionEvent actionEvent) {
        switchScene(actionEvent, "/com/example/badc/Meraj/FinanceOfficer/ManagePayments.fxml");
    }

    @FXML
    public void handleFinanceDashboard(ActionEvent actionEvent) {
        switchScene(actionEvent, "/com/example/badc/Meraj/FinanceOfficer/FinanceDashboard.fxml");
    }

    @FXML
    public void handleSubsidyFund(ActionEvent actionEvent) {
        switchScene(actionEvent, "/com/example/badc/Meraj/FinanceOfficer/SubsidyFund.fxml");
    }

    @FXML
    public void handleAuditReview(ActionEvent actionEvent) {
        switchScene(actionEvent, "/com/example/badc/Meraj/FinanceOfficer/AuditTransaction.fxml");
    }

    @FXML
    public void handleFinancialReport(ActionEvent actionEvent) {
        switchScene(actionEvent, "/com/example/badc/Meraj/FinanceOfficer/FinancialReport.fxml");
    }

    @FXML
    public void handleBudgetManagement(ActionEvent actionEvent) {
        switchScene(actionEvent, "/com/example/badc/Meraj/FinanceOfficer/Budget.fxml");
    }

    @FXML
    public void handleExpenseTracking(ActionEvent actionEvent) {
        switchScene(actionEvent, "/com/example/badc/Meraj/FinanceOfficer/ExpenseTracking.fxml");
    }

    @FXML
    public void handleLogout(ActionEvent actionEvent) {
        switchScene(actionEvent, "/com/example/badc/Meraj/Login.fxml");
    }
}
package com.example.badc.Meraj.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AdminBADCController {

    @FXML
    public void initialize() {
        System.out.println("Admin Dashboard Loaded Successfully");
    }
    private void loadScene(ActionEvent event, String fxmlPath) {

        try {
            FXMLLoader loader =
                    new FXMLLoader(Objects.requireNonNull(
                            getClass().getResource(fxmlPath)));

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource())
                    .getScene()
                    .getWindow();

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            System.out.println("FXML Load Error: " + fxmlPath);
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLoginDashboard(ActionEvent event) {
        loadScene(event,
                "/com/example/badc/Meraj/Admin/AdminDashboard.fxml");
    }

    @FXML
    private void handleManageUsers(ActionEvent event) {
        loadScene(event,
                "/com/example/badc/Meraj/Admin/ManageUsers.fxml");
    }

    @FXML
    private void handleApproveRequests(ActionEvent event) {
        loadScene(event,
                "/com/example/badc/Meraj/Admin/ApproveRequests.fxml");
    }

    @FXML
    private void handleInventoryOverview(ActionEvent event) {
        loadScene(event,
                "/com/example/badc/Meraj/Admin/InventoryOverview.fxml");
    }

    @FXML
    private void handleSystemConfiguration(ActionEvent event) {
        loadScene(event,
                "/com/example/badc/Meraj/Admin/SystemConfiguration.fxml");
    }

    @FXML
    private void handleGenerateReports(ActionEvent event) {
        loadScene(event,
                "/com/example/badc/Meraj/Admin/GenerateReports.fxml");
    }

    @FXML
    private void handleSubsidyPolicies(ActionEvent event) {
        loadScene(event,
                "/com/example/badc/Meraj/Admin/SubsidyPolicies.fxml");
    }

    @FXML
    private void handleLogout(ActionEvent event) {
        loadScene(event,
                "/com/example/badc/Login.fxml");
    }
}
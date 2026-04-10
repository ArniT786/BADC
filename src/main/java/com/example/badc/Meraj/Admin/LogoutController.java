package com.example.badc.Meraj.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LogoutController {

    @FXML
    private Button cancelButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Label statusLabel;

    private Logout session;

    @FXML
    public void initialize() {
        session = new Logout("Admin", true);
        statusLabel.setText("");
    }

    @FXML
    public void handleLogout(ActionEvent event) {

        if (session != null && session.isActive()) {

            session.logout();
            statusLabel.setText("Logged out successfully");

            Stage stage = (Stage) logoutButton.getScene().getWindow();
            stage.close();

        } else {
            statusLabel.setText("No active session!");
        }
    }
    @FXML
    public void handleCancel(ActionEvent event) {

        statusLabel.setText("Logout cancelled");

        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
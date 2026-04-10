package com.example.badc.Meraj.FinanceOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LogoutController {

    @FXML
    private Button logoutBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private Label sessionStatusLabel;
    @FXML
    private Label messageLabel;

    private Logout session;

    @FXML
    public void initialize() {

        session = new Logout("FinanceOfficer", true);

        sessionStatusLabel.setText("Session Active");
        messageLabel.setText("");
    }

    @FXML
    public void handleLogout(ActionEvent actionEvent) {

        try {

            if (session != null && session.isActive()) {

                session.Logout();

                sessionStatusLabel.setText("Session Closed");
                messageLabel.setText("Logged out successfully");

                Parent root = FXMLLoader.load(
                        getClass().getResource("/com/example/badc/Meraj/Login.fxml")
                );

                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();

            } else {
                messageLabel.setText("No active session!");
            }

        } catch (Exception e) {
            messageLabel.setText("Logout error!");
        }
    }

    @FXML
    public void handleCancel(ActionEvent actionEvent) {

        try {

            messageLabel.setText("Logout cancelled");
            Stage stage = (Stage) cancelBtn.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            messageLabel.setText("Cancel error!");
        }
    }
}
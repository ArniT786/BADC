package com.example.badc.Meraj.FinanceOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginFinanceDashboardController {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;

    private LoginFinanceDashboard validUser;

    @FXML
    public void initialize() {
        validUser = new LoginFinanceDashboard("finance", "1234");
    }

    @FXML
    public void handleLogin(ActionEvent actionEvent) {

        try {
            String username = txtUsername.getText();
            String password = txtPassword.getText();

            if (username.isEmpty() || password.isEmpty()) {
                showAlert("Please enter username & password!");
                return;
            }
            if (username.equals(validUser.getUsername()) &&
                    password.equals(validUser.getPassword())) {
                Parent root = FXMLLoader.load(
                        getClass().getResource("/com/example/badc/Meraj/FinanceOfficer/FinanceDashboard.fxml")
                );

                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();

            } else {
                showAlert("Invalid username or password!");
            }

        } catch (Exception e) {
            showAlert("Login error!");
        }
    }
    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(msg);
        alert.show();
    }
}
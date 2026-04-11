package com.example.badc;

import com.example.badc.model.User;
import com.example.badc.service.TaskService;
import com.example.badc.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML private TextField nidField;
    @FXML private PasswordField passField;
    @FXML private ComboBox<String> roleDrop;
    @FXML private Label lblMessage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserService.initDummyUsers();
        TaskService.initDummyTasks();
        roleDrop.getItems().addAll("Farmer", "Seed Dealer", "Field Officer", "Report Officer", "Admin (BADC Officer)", "Finance Officer (BADC Finance Officer)");
    }

    @FXML
    private void handleLogin(ActionEvent event) {
        String nid = nidField.getText().trim();
        String password = passField.getText().trim();

        if (nid.isEmpty()) {
            lblMessage.setText("Please enter your NID.");
            return;
        }
        if (password.isEmpty()) {
            lblMessage.setText("Please enter your password.");
            return;
        }

        String selectedRole = roleDrop.getValue();
        if (selectedRole == null) {
            lblMessage.setText("Please select user type.");
            return;
        }

        User user = UserService.login(nid, password);
        if (user == null) {
            lblMessage.setText("Invalid NID or password.");
            return;
        }

        String mappedRole = mapDisplayRoleToInternal(selectedRole);
        if (!user.getRole().equalsIgnoreCase(mappedRole)) {
            lblMessage.setText("Role mismatch. You are " + user.getRole());
            return;
        }

        String fxmlPath;
        switch (user.getRole()) {
            case "FARMER"      -> fxmlPath = "/com/example/badc/Arnima/farmer_dashboard.fxml";
            case "SEED_DEALER" -> fxmlPath = "/com/example/badc/Arnima/dealer_dashboard.fxml";
            case "FIELD_OFFICER"  -> fxmlPath = "/com/example/badc/Mithila/field_officer_dashboard.fxml";
            case "REPORT_OFFICER" -> fxmlPath = "/com/example/badc/Mithila/report_officer_dashboard.fxml";
            case "ADMIN" -> fxmlPath = "/com/example/badc/admin_dashboard.fxml";
            case "FINANCE" -> fxmlPath = "/com/example/badc/finance_dashboard.fxml";
            default -> {
                lblMessage.setText("Unknown role: " + user.getRole());
                return;
            }
        }

        try {
            Stage stage = (Stage) nidField.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            lblMessage.setText("Error loading dashboard.");
            e.printStackTrace();
        }
    }

    @FXML
    private void goToSignup(ActionEvent event) {
        try {
            Stage stage = (Stage) nidField.getScene().getWindow();
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/badc/signup.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            lblMessage.setText("Error opening signup page.");
            e.printStackTrace();
        }
    }

    private String mapDisplayRoleToInternal(String displayRole) {
        return switch (displayRole) {
            case "Farmer" -> "FARMER";
            case "Seed Dealer" -> "SEED_DEALER";
            case "Field Officer" -> "FIELD_OFFICER";
            case "Report Officer" -> "REPORT_OFFICER";
            case "Admin (BADC Officer)" -> "ADMIN";
            case "Finance Officer (BADC Finance Officer)" -> "FINANCE";
            default -> "";
        };
    }
}


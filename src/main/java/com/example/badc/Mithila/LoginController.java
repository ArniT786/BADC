package com.example.badc.Mithila;

import com.example.badc.model.User;
import com.example.badc.service.TaskService;
import com.example.badc.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField nidField;
    @FXML
    private PasswordField passField;
    @FXML
    private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserService.initDummyUsers();
        TaskService.initDummyTasks();
    }

    @FXML
    private void handleLogin(ActionEvent e) {
        String nid = nidField.getText().trim();
        String password = passField.getText().trim();

        if (nid.isEmpty()) {
            msgLabel.setText("Please enter NID");
            return;
        }
        if (password.isEmpty()) {
            msgLabel.setText("Please enter password");
            return;
        }

        User user = UserService.login(nid, password);
        if (user == null) {
            msgLabel.setText("Invalid NID or password");
            return;
        }

        try {
            Stage stage = (Stage) nidField.getScene().getWindow();
            String fxmlPath;
            if (user.getRole().equals("FIELD_OFFICER")) {
                fxmlPath = "/com/example/badc/Mithila/field_officer_dashboard.fxml";
            } else {
                fxmlPath = "/com/example/badc/Mithila/report_officer_dashboard.fxml";
            }
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            msgLabel.setText("Error loading dashboard.");
            ex.printStackTrace();
        }
    }

    @FXML
    private void goToSignup(ActionEvent e) {
        try {
            Stage stage = (Stage) nidField.getScene().getWindow();
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/badc/Mithila/mithila_signup.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            msgLabel.setText("Error loading signup page.");
            ex.printStackTrace();
        }
    }
}

package com.example.badc.Mithila;

import com.example.badc.model.FieldOfficer;
import com.example.badc.model.ReportOfficer;
import com.example.badc.model.User;
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

public class SignupController implements Initializable {

    @FXML private TextField nameField;
    @FXML private TextField nidField;
    @FXML private PasswordField passField;
    @FXML private TextField phoneField;
    @FXML private ComboBox<String> roleDrop;
    @FXML private TextField districtField;
    @FXML private TextField deptField;
    @FXML private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roleDrop.getItems().addAll("FIELD_OFFICER", "REPORT_OFFICER");
    }

    @FXML
    private void handleSignup(ActionEvent e) {
        String name = nameField.getText().trim();
        String nid = nidField.getText().trim();
        String pass = passField.getText().trim();
        String phone = phoneField.getText().trim();
        String role = roleDrop.getValue();

        if (name.isEmpty()) {
            msgLabel.setText("Name is required");
            return;
        }
        if (!nid.matches("\\d{10}")) {
            msgLabel.setText("NID must be exactly 10 digits");
            return;
        }
        if (pass.length() < 6) {
            msgLabel.setText("Password must be at least 6 characters");
            return;
        }
        if (phone.isEmpty()) {
            msgLabel.setText("Phone is required");
            return;
        }
        if (role == null) {
            msgLabel.setText("Please select a role");
            return;
        }
        if (UserService.nidExists(nid)) {
            msgLabel.setText("This NID is already registered");
            return;
        }

        String userId = (role.equals("FIELD_OFFICER") ? "FO" : "RO") + System.currentTimeMillis();
        User user;

        if (role.equals("FIELD_OFFICER")) {
            String district = districtField.getText().trim();
            if (district.isEmpty()) {
                msgLabel.setText("District is required");
                return;
            }
            user = new FieldOfficer(userId, name, nid, pass, phone, district, "SUP001");
        } else {
            String dept = deptField.getText().trim();
            if (dept.isEmpty()) {
                msgLabel.setText("Department is required");
                return;
            }
            user = new ReportOfficer(userId, name, nid, pass, phone, dept);
        }

        UserService.signup(user);
        msgLabel.setText("Registration successful! Please login.");
        clearFields();
    }

    private void clearFields() {
        nameField.clear();
        nidField.clear();
        passField.clear();
        phoneField.clear();
        roleDrop.setValue(null);
        districtField.clear();
        deptField.clear();
    }

    @FXML
    private void goBack(ActionEvent e) {
        try {
            Stage stage = (Stage) nameField.getScene().getWindow();
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/badc/Mithila/mithila_login.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            msgLabel.setText("Error loading login page.");
            ex.printStackTrace();
        }
    }
}

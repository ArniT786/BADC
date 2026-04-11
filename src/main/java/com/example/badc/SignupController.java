package com.example.badc;

import com.example.badc.model.*;
import com.example.badc.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
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
    @FXML private Label msgLabel;

    // Role-specific field containers
    @FXML private VBox districtContainer;
    @FXML private VBox deptContainer;
    @FXML private VBox shopNameContainer;
    @FXML private VBox shopDistrictContainer;

    @FXML private Label districtLabel;
    @FXML private TextField districtField;
    @FXML private Label deptLabel;
    @FXML private TextField deptField;
    @FXML private Label shopNameLabel;
    @FXML private TextField shopNameField;
    @FXML private Label shopDistrictLabel;
    @FXML private TextField shopDistrictField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roleDrop.getItems().addAll("FARMER", "SEED_DEALER", "FIELD_OFFICER", "REPORT_OFFICER");
        hideAllRoleFields();
    }

    @FXML
    private void onRoleChanged(ActionEvent e) {
        hideAllRoleFields();
        String role = roleDrop.getValue();
        if (role == null) return;
        switch (role) {
            case "FARMER" -> setVisible(districtContainer);
            case "SEED_DEALER" -> setVisible(shopNameContainer, shopDistrictContainer);
            case "FIELD_OFFICER" -> setVisible(districtContainer);
            case "REPORT_OFFICER" -> setVisible(deptContainer);
        }
    }

    @FXML
    private void handleSignup(ActionEvent e) {
        String name     = nameField.getText().trim();
        String nid      = nidField.getText().trim();
        String pass     = passField.getText().trim();
        String phone    = phoneField.getText().trim();
        String role     = roleDrop.getValue();

        // --- Common validations ---
        if (name.isEmpty()) { msgLabel.setText("Full name is required."); return; }
        if (!nid.matches("\\d{10}")) { msgLabel.setText("NID must be exactly 10 digits."); return; }
        if (pass.length() < 6) { msgLabel.setText("Password must be at least 6 characters."); return; }
        if (phone.isEmpty()) { msgLabel.setText("Phone number is required."); return; }
        if (role == null) { msgLabel.setText("Please select a role."); return; }
        if (UserService.nidExists(nid)) { msgLabel.setText("This NID is already registered."); return; }

        String userId = role.substring(0, 2) + System.currentTimeMillis();
        User user;

        // --- Role-specific validations and object creation ---
        switch (role) {
            case "FARMER" -> {
                String district = districtField.getText().trim();
                if (district.isEmpty()) { msgLabel.setText("District is required for Farmer."); return; }
                user = new FarmerUser(userId, name, nid, pass, phone, district);
            }
            case "SEED_DEALER" -> {
                String shopName     = shopNameField.getText().trim();
                String shopDistrict = shopDistrictField.getText().trim();
                if (shopName.isEmpty())     { msgLabel.setText("Shop name is required."); return; }
                if (shopDistrict.isEmpty()) { msgLabel.setText("Shop district is required."); return; }
                user = new SeedDealer(userId, name, nid, pass, phone, shopName, shopDistrict);
            }
            case "FIELD_OFFICER" -> {
                String district = districtField.getText().trim();
                if (district.isEmpty()) { msgLabel.setText("District is required for Field Officer."); return; }
                user = new FieldOfficer(userId, name, nid, pass, phone, district, "SUP001");
            }
            case "REPORT_OFFICER" -> {
                String dept = deptField.getText().trim();
                if (dept.isEmpty()) { msgLabel.setText("Department is required for Report Officer."); return; }
                user = new ReportOfficer(userId, name, nid, pass, phone, dept);
            }
            default -> { msgLabel.setText("Unknown role selected."); return; }
        }

        boolean success = UserService.signup(user);
        if (success) {
            msgLabel.setText("Registration successful! You can now login with your NID.");
            clearAll();
        } else {
            msgLabel.setText("Registration failed. NID may already exist or input is invalid.");
        }
    }

    @FXML
    private void goBack(ActionEvent e) {
        try {
            Stage stage = (Stage) nameField.getScene().getWindow();
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/badc/login.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            msgLabel.setText("Error loading login page.");
            ex.printStackTrace();
        }
    }

    // --- Helpers ---
    private void hideAllRoleFields() {
        setHidden(districtContainer, deptContainer, shopNameContainer, shopDistrictContainer);
    }

    private void setVisible(javafx.scene.Node... nodes) {
        for (javafx.scene.Node n : nodes) { n.setVisible(true); n.setManaged(true); }
    }

    private void setHidden(javafx.scene.Node... nodes) {
        for (javafx.scene.Node n : nodes) { n.setVisible(false); n.setManaged(false); }
    }

    private void clearAll() {
        nameField.clear(); nidField.clear(); passField.clear();
        phoneField.clear(); roleDrop.setValue(null);
        districtField.clear(); deptField.clear();
        shopNameField.clear(); shopDistrictField.clear();
        hideAllRoleFields();
    }
}

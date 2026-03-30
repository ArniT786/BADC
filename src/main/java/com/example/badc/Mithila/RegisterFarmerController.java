package com.example.badc.Mithila;

import com.example.badc.model.Farmer;
import com.example.badc.service.FarmerService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.example.badc.SceneSwitcher;

public class RegisterFarmerController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private TextField nidField;
    @FXML
    private TextField landField;
    @FXML
    private ComboBox<String> districtBox;
    @FXML
    private TextField phoneField;
    @FXML
    private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        districtBox.getItems().addAll(
                "Dhaka", "Rajshahi", "Chittagong", "Sylhet",
                "Khulna", "Barisal", "Rangpur", "Mymensingh"
        );
    }

    @FXML
    private void registerFarmer(ActionEvent event) {
        String name = nameField.getText().trim();
        String nid = nidField.getText().trim();
        String land = landField.getText().trim();
        String district = districtBox.getValue();
        String phone = phoneField.getText().trim();

        if (name.isEmpty() || nid.isEmpty() || land.isEmpty() || district == null || phone.isEmpty()) {
            msgLabel.setText("All fields are required");
            return;
        }

        double landSize;
        try {
            landSize = Double.parseDouble(land);
        } catch (NumberFormatException ex) {
            msgLabel.setText("Land size must be a number");
            return;
        }

        String farmerId = "FRM" + System.currentTimeMillis();
        String today = LocalDate.now().toString();
        Farmer farmer = new Farmer(farmerId, name, nid, phone, district, landSize, "OFFICER", today);

        boolean result = FarmerService.registerFarmer(farmer);
        if (result) {
            msgLabel.setText("Farmer registered successfully. ID: " + farmerId);
            clearForm();
        } else {
            msgLabel.setText("Registration failed. NID may already exist or invalid input.");
        }
    }

    @FXML
    private void clearForm(ActionEvent event) {
        clearForm();
    }

    private void clearForm() {
        nameField.clear();
        nidField.clear();
        landField.clear();
        phoneField.clear();
        districtBox.setValue(null);
        msgLabel.setText("");
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/field_officer_dashboard.fxml");
    }
}

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

    @FXML private TextField name_txt;
    @FXML private TextField nid_txt;
    @FXML private TextField land_txt;
    @FXML private ComboBox<String> dist_cb;
    @FXML private TextField phone_txt;
    @FXML private Label msg_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dist_cb.getItems().addAll("Dhaka", "Rajshahi", "Chittagong", "Sylhet", "Khulna", "Barisal", "Rangpur", "Mymensingh");
    }

    @FXML
    private void registerFarmer(ActionEvent event) {
        String name = name_txt.getText().trim();
        String nid = nid_txt.getText().trim();
        String land = land_txt.getText().trim();
        String district = dist_cb.getValue();
        String phone = phone_txt.getText().trim();

        if (name.isEmpty() || nid.isEmpty() || land.isEmpty() || district == null || phone.isEmpty()) {
            msg_lbl.setText("All fields are required");
            return;
        }

        double landSize;
        try {
            landSize = Double.parseDouble(land);
        } catch (NumberFormatException ex) {
            msg_lbl.setText("Land size must be a number");
            return;
        }

        String farmerId = "FRM" + System.currentTimeMillis();
        String today = LocalDate.now().toString();
        Farmer farmer = new Farmer(farmerId, name, nid, phone, district, landSize, "OFFICER", today);

        boolean result = FarmerService.registerFarmer(farmer);
        if (result) {
            msg_lbl.setText("Success! ID: " + farmerId);
            clearForm();
        } else {
            msg_lbl.setText("Failed. NID may exist.");
        }
    }

    @FXML
    private void clearForm(ActionEvent event) {
        clearForm();
    }

    private void clearForm() {
        name_txt.clear();
        nid_txt.clear();
        land_txt.clear();
        phone_txt.clear();
        dist_cb.setValue(null);
        msg_lbl.setText("");
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/field_officer_dashboard.fxml");
    }
}

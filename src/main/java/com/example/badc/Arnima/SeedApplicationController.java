package com.example.badc.Arnima;

import com.example.badc.Arnima.service.SeedApplicationService;
import com.example.badc.model.SeedApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SeedApplicationController {
    @FXML private TextField txtName, txtNID, txtQuantity;
    @FXML private ComboBox<String> cmbSeedType;
    @FXML private Label lblMessage;

    public void initialize() {
        cmbSeedType.getItems().addAll("Rice Seed","Wheat Seed","Jute Seed","Maize Seed","Potato Seed");
    }

    @FXML
    public void submitApplication(ActionEvent e) {
        System.out.println("submit clicked");
        try {
            String n = txtName.getText();
            String id = txtNID.getText();
            String s = cmbSeedType.getValue() == null ? "" : cmbSeedType.getValue();
            String q = txtQuantity.getText();

            if (n.isEmpty() || id.isEmpty() || s.isEmpty() || q.isEmpty()) {
                lblMessage.setText("Please fill all fields");
            } else if (n.length() < 3) {
                lblMessage.setText("Name is too short");
            } else if (!id.matches("\\d+")) {
                lblMessage.setText("NID must be numbers only");
            } else if (id.length() != 10 && id.length() != 13) {
                lblMessage.setText("NID must be 10 or 13 digits");
            } else {
                double amt = Double.parseDouble(q);
                if (amt <= 0) {
                    lblMessage.setText("Quantity must be more than zero");
                } else if (amt > 1000) {
                    lblMessage.setText("Quantity cannot exceed 1000 kg");
                } else {
                    String appId = "APP" + System.currentTimeMillis();
                    SeedApplication app = new SeedApplication(appId, n, id, s, amt);
                    SeedApplicationService svc = new SeedApplicationService();
                    boolean ok = svc.save(app);
                    if (ok) {
                        lblMessage.setText("Application submitted! Your ID: " + appId);
                        clearForm();
                    } else {
                        lblMessage.setText("Something went wrong. Try again.");
                    }
                }
            }
        } catch (NumberFormatException ex) {
            lblMessage.setText("Quantity must be a valid number");
        } catch (Exception ex) {
            ex.printStackTrace();
            lblMessage.setText("Error: " + ex.getMessage());
        }
    }

    public void clearForm() {
        txtName.clear();
        txtNID.clear();
        txtQuantity.clear();
        cmbSeedType.setValue(null);
    }

    @FXML
    public void goBack(ActionEvent e) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("/com/example/badc/Arnima/farmer_dashboard.fxml"));
            Stage s = (Stage) txtName.getScene().getWindow();
            s.setScene(new Scene(p));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

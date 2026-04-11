package com.example.badc.Arnima;

import com.example.badc.Arnima.service.DealerProfileService;
import com.example.badc.model.DealerProfile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateShopController {
    @FXML private TextField txtDealerNID, txtShopName, txtAddress, txtPhone;
    @FXML private Label lblMessage;

    @FXML
    private void loadShopInfo(ActionEvent e) {
        System.out.println("load shop info");
        String id = txtDealerNID.getText();
        if (id.isEmpty()) {
            lblMessage.setText("Enter Dealer NID first");
        } else {
            DealerProfile p = new DealerProfileService().findByNid(id);
            if (p == null) {
                lblMessage.setText("No profile found for this NID");
            } else {
                txtShopName.setText(p.getShopName());
                txtAddress.setText(p.getAddress());
                txtPhone.setText(p.getPhone());
                lblMessage.setText("Profile loaded. You can now edit.");
            }
        }
    }

    @FXML
    private void updateProfile(ActionEvent e) {
        System.out.println("update profile");
        try {
            String id = txtDealerNID.getText();
            String sn = txtShopName.getText();
            String addr = txtAddress.getText();
            String ph = txtPhone.getText();
            if (id.isEmpty() || sn.isEmpty() || addr.isEmpty() || ph.isEmpty()) {
                lblMessage.setText("All fields are required");
            } else if (!ph.matches("\\d{11}")) {
                lblMessage.setText("Phone must be 11 digits");
            } else {
                DealerProfileService svc = new DealerProfileService();
                DealerProfile ex = svc.findByNid(id);
                if (ex == null) {
                    lblMessage.setText("Dealer profile not found. Load profile first.");
                } else {
                    ex.setShopName(sn);
                    ex.setAddress(addr);
                    ex.setPhone(ph);
                    boolean ok = svc.updateProfile(ex);
                    if (ok) {
                        lblMessage.setText("Profile updated successfully!");
                    } else {
                        lblMessage.setText("Could not update profile. Try again.");
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            lblMessage.setText("Error: " + ex.getMessage());
        }
    }

    @FXML
    private void clearForm() {
        txtDealerNID.clear();
        txtShopName.clear();
        txtAddress.clear();
        txtPhone.clear();
    }

    @FXML
    private void goBack(ActionEvent e) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("/com/example/badc/Arnima/dealer_dashboard.fxml"));
            Stage s = (Stage) txtDealerNID.getScene().getWindow();
            s.setScene(new Scene(p));
        } catch (Exception ex) { ex.printStackTrace(); }
    }
}

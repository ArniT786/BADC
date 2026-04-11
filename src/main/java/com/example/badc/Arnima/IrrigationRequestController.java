package com.example.badc.Arnima;

import com.example.badc.Arnima.service.IrrigationService;
import com.example.badc.model.IrrigationRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class IrrigationRequestController {
    @FXML private TextField txtNID, txtLandSize, txtLocation;
    @FXML private ComboBox<String> cmbPumpType;
    @FXML private Label lblTrackingID, lblMessage;

    public void initialize() {
        cmbPumpType.getItems().addAll("Shallow Tube Well","Deep Tube Well","Power Pump");
    }

    @FXML
    public void submitRequest(ActionEvent e) {
        System.out.println("irrigation submit");
        try {
            String id = txtNID.getText();
            String ls = txtLandSize.getText();
            String loc = txtLocation.getText();
            String pt = cmbPumpType.getValue() == null ? "" : cmbPumpType.getValue();

            if (id.isEmpty() || ls.isEmpty() || loc.isEmpty() || pt.isEmpty()) {
                lblMessage.setText("All fields are required");
            } else if (!id.matches("\\d{10}|\\d{13}")) {
                lblMessage.setText("NID must be 10 or 13 digits");
            } else if (loc.length() < 5) {
                lblMessage.setText("Please provide a full location");
            } else {
                double land = Double.parseDouble(ls);
                if (land <= 0) {
                    lblMessage.setText("Land size must be greater than zero");
                } else if (land > 50) {
                    lblMessage.setText("Max land size limit is 50 acres");
                } else {
                    String tid = "IRR" + System.currentTimeMillis();
                    IrrigationRequest req = new IrrigationRequest(tid, id, land, loc, pt);
                    IrrigationService svc = new IrrigationService();
                    boolean ok = svc.save(req);
                    if (ok) {
                        lblTrackingID.setText("Your Tracking ID: " + tid);
                        lblMessage.setText("Request submitted successfully!");
                        clearForm();
                    } else {
                        lblMessage.setText("Could not save. Try again.");
                    }
                }
            }
        } catch (NumberFormatException ex) {
            lblMessage.setText("Land size must be a number");
        } catch (Exception ex) {
            ex.printStackTrace();
            lblMessage.setText("Error: " + ex.getMessage());
        }
    }

    public void clearForm() {
        txtNID.clear();
        txtLandSize.clear();
        txtLocation.clear();
        cmbPumpType.setValue(null);
    }

    @FXML
    public void goBack(ActionEvent e) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("/com/example/badc/Arnima/farmer_dashboard.fxml"));
            Stage s = (Stage) txtNID.getScene().getWindow();
            s.setScene(new Scene(p));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

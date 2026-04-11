package com.example.badc.Arnima;

import com.example.badc.Arnima.service.IrrigationService;
import com.example.badc.Arnima.service.SeedApplicationService;
import com.example.badc.model.IrrigationRequest;
import com.example.badc.model.SeedApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TrackStatusController {
    @FXML private TextField txtSearchID;
    @FXML private Label lblSeedAppID, lblSeedType, lblSeedStatus, lblSeedRemarks, lblIrrigationID, lblIrrigationLocation, lblIrrigationStatus, lblMessage;

    @FXML
    public void searchStatus(ActionEvent e) {
        System.out.println("track clicked");
        String inp = txtSearchID.getText();
        if (inp.isEmpty()) {
            lblMessage.setText("Please enter NID or Tracking ID");
        } else {
            lblSeedAppID.setText("");
            lblSeedType.setText("");
            lblSeedStatus.setText("");
            lblSeedRemarks.setText("");
            lblIrrigationID.setText("");
            lblIrrigationLocation.setText("");
            lblIrrigationStatus.setText("");
            
            SeedApplicationService s1 = new SeedApplicationService();
            SeedApplication sa = s1.findByNidOrId(inp);
            if (sa != null) {
                lblSeedAppID.setText(sa.getAppId());
                lblSeedType.setText(sa.getSeedType());
                lblSeedStatus.setText(sa.getStatus());
                lblSeedRemarks.setText(sa.getRemarks());
            } else {
                lblSeedStatus.setText("No seed application found");
            }

            IrrigationService s2 = new IrrigationService();
            IrrigationRequest ir = s2.findByNidOrId(inp);
            if (ir != null) {
                lblIrrigationID.setText(ir.getTrackingId());
                lblIrrigationLocation.setText(ir.getLocation());
                lblIrrigationStatus.setText(ir.getStatus());
            } else {
                lblIrrigationStatus.setText("No irrigation request found");
            }

            lblMessage.setText("Search complete.");
        }
    }

    @FXML
    public void goBack(ActionEvent e) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("/com/example/badc/Arnima/farmer_dashboard.fxml"));
            Stage s = (Stage) txtSearchID.getScene().getWindow();
            s.setScene(new Scene(p));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

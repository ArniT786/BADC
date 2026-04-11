package com.example.badc.Arnima;

import com.example.badc.Arnima.service.StockRequestService;
import com.example.badc.model.StockRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RequestStockController {
    @FXML private TextField txtDealerNID, txtQuantity;
    @FXML private ComboBox<String> cmbSeedType;
    @FXML private Label lblMessage;

    public void initialize() {
        cmbSeedType.getItems().addAll("Rice Seed","Wheat Seed","Jute Seed","Maize Seed","Potato Seed");
    }

    @FXML
    private void submitRequest(ActionEvent e) {
        System.out.println("request stock submit");
        try {
            String id = txtDealerNID.getText();
            String s = cmbSeedType.getValue() == null ? "" : cmbSeedType.getValue();
            String q = txtQuantity.getText();
            if (id.isEmpty() || s.isEmpty() || q.isEmpty()) {
                lblMessage.setText("All fields are required");
            } else {
                double amt = Double.parseDouble(q);
                if (amt <= 0) {
                    lblMessage.setText("Quantity must be greater than zero");
                } else {
                    String rid = "REQ" + System.currentTimeMillis();
                    StockRequest req = new StockRequest(rid, id, s, amt);
                    boolean ok = new StockRequestService().save(req);
                    if (ok) {
                        lblMessage.setText("Request sent! Request ID: " + rid);
                        clearForm();
                    } else {
                        lblMessage.setText("Something went wrong. Try again.");
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
        txtQuantity.clear();
        cmbSeedType.setValue(null);
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

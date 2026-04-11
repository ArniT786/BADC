package com.example.badc.Arnima;

import com.example.badc.Arnima.service.InventoryService;
import com.example.badc.Arnima.service.SaleRecordService;
import com.example.badc.model.InventoryItem;
import com.example.badc.model.SaleRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.ArrayList;

public class RecordSaleController {
    @FXML private TextField txtDealerNID, txtFarmerNID, txtQuantity;
    @FXML private ComboBox<String> cmbSeedType;
    @FXML private Label lblStockStatus, lblMessage;

    public void initialize() {
        cmbSeedType.getItems().addAll("Rice Seed","Wheat Seed","Jute Seed","Maize Seed","Potato Seed");
    }

    @FXML
    private void confirmSale(ActionEvent e) {
        System.out.println("confirm sale clicked");
        try {
            String did = txtDealerNID.getText();
            String fid = txtFarmerNID.getText();
            String s = cmbSeedType.getValue() == null ? "" : cmbSeedType.getValue();
            String q = txtQuantity.getText();
            if (did.isEmpty() || fid.isEmpty() || s.isEmpty() || q.isEmpty()) {
                lblMessage.setText("All fields are required");
            } else {
                double amt = Double.parseDouble(q);
                if (amt <= 0) {
                    lblMessage.setText("Quantity must be greater than zero");
                } else {
                    InventoryService invSvc = new InventoryService();
                    ArrayList<InventoryItem> inv = invSvc.getByDealerNid(did);
                    InventoryItem item = null;
                    for (int i = 0; i < inv.size(); i++) {
                        if (inv.get(i).getSeedName().equals(s)) {
                            item = inv.get(i);
                        }
                    }
                    if (item == null) {
                        lblStockStatus.setText("Seed not found in inventory");
                        lblMessage.setText("Cannot complete sale");
                    } else if (item.getQuantity() < amt) {
                        lblStockStatus.setText("Not enough stock. Available: " + item.getQuantity() + " kg");
                        lblMessage.setText("Sale failed - insufficient stock");
                    } else {
                        double comm = amt * 2.5;
                        String today = java.time.LocalDate.now().toString();
                        String sid = "SAL" + System.currentTimeMillis();
                        SaleRecord sale = new SaleRecord(sid, did, fid, s, amt, comm, today);
                        boolean ok = new SaleRecordService().save(sale);
                        if (ok) {
                            invSvc.updateQuantity(item.getItemId(), item.getQuantity() - amt);
                            lblStockStatus.setText("Stock updated. Remaining: " + (item.getQuantity() - amt) + " kg");
                            lblMessage.setText("Sale confirmed! Commission: " + comm + " BDT");
                            clearForm();
                        } else {
                            lblMessage.setText("Could not save sale. Try again.");
                        }
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
        txtFarmerNID.clear();
        txtQuantity.clear();
        cmbSeedType.setValue(null);
        lblStockStatus.setText("");
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

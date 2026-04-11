package com.example.badc.Arnima;

import com.example.badc.Arnima.service.DealerProfileService;
import com.example.badc.Arnima.service.InventoryService;
import com.example.badc.Arnima.service.NoticeService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DealerDashboardController {
    @FXML private Button btnRequestStock, btnRecordSale, btnInventory, btnEarnings, btnUpdateShop, btnNotices;

    public void initialize() {
        new InventoryService().initDummyInventory();
        new DealerProfileService().initDummyProfiles();
        new NoticeService().initDummyNotices();
    }

    @FXML
    private void openRequestStock(ActionEvent e) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("/com/example/badc/Arnima/request_stock.fxml"));
            Stage s = (Stage) btnRequestStock.getScene().getWindow();
            s.setScene(new Scene(p));
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    @FXML
    private void openRecordSale(ActionEvent e) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("/com/example/badc/Arnima/record_sale.fxml"));
            Stage s = (Stage) btnRecordSale.getScene().getWindow();
            s.setScene(new Scene(p));
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    @FXML
    private void openInventory(ActionEvent e) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("/com/example/badc/Arnima/shop_inventory.fxml"));
            Stage s = (Stage) btnInventory.getScene().getWindow();
            s.setScene(new Scene(p));
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    @FXML
    private void openEarnings(ActionEvent e) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("/com/example/badc/Arnima/view_earnings.fxml"));
            Stage s = (Stage) btnEarnings.getScene().getWindow();
            s.setScene(new Scene(p));
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    @FXML
    private void openUpdateShop(ActionEvent e) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("/com/example/badc/Arnima/update_shop.fxml"));
            Stage s = (Stage) btnUpdateShop.getScene().getWindow();
            s.setScene(new Scene(p));
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    @FXML
    private void openNotices(ActionEvent e) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("/com/example/badc/Arnima/view_notices.fxml"));
            Stage s = (Stage) btnNotices.getScene().getWindow();
            s.setScene(new Scene(p));
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    @FXML
    private void handleLogout(ActionEvent e) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("/com/example/badc/login.fxml"));
            Stage s = (Stage) btnRequestStock.getScene().getWindow();
            s.setScene(new Scene(p));
        } catch (Exception ex) { ex.printStackTrace(); }
    }
}

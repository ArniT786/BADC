package com.example.badc.Arnima;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class DealerDashboardController implements Initializable {

    @FXML private Button btnRequestStock;
    @FXML private Button btnRecordSale;
    @FXML private Button btnInventory;
    @FXML private Button btnEarnings;
    @FXML private Button btnUpdateShop;
    @FXML private Button btnNotices;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    private void switchScene(ActionEvent event, String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @FXML private void openRequestStock(ActionEvent event) { switchScene(event, "/com/example/badc/Arnima/request_stock.fxml"); }
    @FXML private void openRecordSale(ActionEvent event) { switchScene(event, "/com/example/badc/Arnima/record_sale.fxml"); }
    @FXML private void openInventory(ActionEvent event) { switchScene(event, "/com/example/badc/Arnima/shop_inventory.fxml"); }
    @FXML private void openEarnings(ActionEvent event) { switchScene(event, "/com/example/badc/Arnima/view_earnings.fxml"); }
    @FXML private void openUpdateShop(ActionEvent event) { switchScene(event, "/com/example/badc/Arnima/update_shop.fxml"); }
    @FXML private void openNotices(ActionEvent event) { switchScene(event, "/com/example/badc/Arnima/view_notices.fxml"); }
}

package com.example.badc.Arnima;

import com.example.badc.Arnima.service.InventoryService;
import com.example.badc.model.InventoryItem;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.util.ArrayList;

public class ShopInventoryController {
    @FXML private TextField txtDealerNID;
    @FXML private TableView<InventoryItem> tblInventory;
    @FXML private TableColumn<InventoryItem, String> colSeedName, colStatus;
    @FXML private TableColumn<InventoryItem, Double> colQuantity;
    @FXML private Label lblMessage;

    public void initialize() {
        colSeedName.setCellValueFactory(new PropertyValueFactory<>("seedName"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("stockStatus"));
    }

    @FXML
    private void loadInventory(ActionEvent e) {
        System.out.println("load inventory");
        String id = txtDealerNID.getText();
        if (id.isEmpty()) {
            lblMessage.setText("Please enter Dealer NID");
        } else {
            ArrayList<InventoryItem> list = new InventoryService().getByDealerNid(id);
            if (list.isEmpty()) {
                lblMessage.setText("No inventory found for this dealer");
                tblInventory.getItems().clear();
            } else {
                tblInventory.setItems(FXCollections.observableArrayList(list));
                lblMessage.setText("Loaded " + list.size() + " item(s)");
            }
        }
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

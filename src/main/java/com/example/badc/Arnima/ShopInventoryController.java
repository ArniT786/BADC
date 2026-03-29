package com.example.badc.Arnima;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class ShopInventoryController implements Initializable {

    @FXML private TextField txtDealerNID;
    @FXML private TableView<?> tblInventory;
    @FXML private TableColumn<?, String> colSeedName;
    @FXML private TableColumn<?, String> colQuantity;
    @FXML private TableColumn<?, String> colStatus;
    @FXML private Label lblMessage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    @FXML private void loadInventory(ActionEvent event) {}
    @FXML private void goBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/badc/Arnima/dealer_dashboard.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (Exception e) { e.printStackTrace(); }
    }
}

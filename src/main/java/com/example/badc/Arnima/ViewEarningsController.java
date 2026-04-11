package com.example.badc.Arnima;

import com.example.badc.Arnima.service.SaleRecordService;
import com.example.badc.model.SaleRecord;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.util.ArrayList;

public class ViewEarningsController {
    @FXML private TextField txtDealerNID;
    @FXML private TableView<SaleRecord> tblEarnings;
    @FXML private TableColumn<SaleRecord, String> colDate, colSeedType;
    @FXML private TableColumn<SaleRecord, Double> colKgSold, colCommission;
    @FXML private ComboBox<String> cmbMonth;
    @FXML private Label lblTotalEarnings, lblMessage;

    public void initialize() {
        colDate.setCellValueFactory(new PropertyValueFactory<>("saleDate"));
        colSeedType.setCellValueFactory(new PropertyValueFactory<>("seedType"));
        colKgSold.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colCommission.setCellValueFactory(new PropertyValueFactory<>("commission"));
        cmbMonth.getItems().addAll("2025-10","2025-11","2025-12","2026-01","2026-02","2026-03");
    }

    @FXML
    private void loadEarnings(ActionEvent e) {
        System.out.println("load earnings");
        String id = txtDealerNID.getText();
        if (id.isEmpty()) {
            lblMessage.setText("Please enter Dealer NID");
        } else {
            ArrayList<SaleRecord> list = new SaleRecordService().getByDealerNid(id);
            if (list.isEmpty()) {
                lblMessage.setText("No sales found for this dealer");
                tblEarnings.getItems().clear();
                lblTotalEarnings.setText("");
            } else {
                tblEarnings.setItems(FXCollections.observableArrayList(list));
                double total = new SaleRecordService().getTotalCommission(id);
                lblTotalEarnings.setText(total + " BDT");
                lblMessage.setText("Showing all earnings for dealer " + id);
            }
        }
    }

    @FXML
    private void filterByMonth(ActionEvent e) {
        System.out.println("filter month");
        String id = txtDealerNID.getText();
        String m = cmbMonth.getValue() == null ? "" : cmbMonth.getValue();
        if (id.isEmpty()) {
            lblMessage.setText("Enter Dealer NID first");
        } else if (m.isEmpty()) {
            lblMessage.setText("Select a month to filter");
        } else {
            ArrayList<SaleRecord> list = new SaleRecordService().getByDealerNidAndMonth(id, m);
            if (list.isEmpty()) {
                lblMessage.setText("No sales found for " + m);
                tblEarnings.getItems().clear();
                lblTotalEarnings.setText("0.0 BDT");
            } else {
                tblEarnings.setItems(FXCollections.observableArrayList(list));
                double total = 0;
                for (int i = 0; i < list.size(); i++) {
                    total += list.get(i).getCommission();
                }
                lblTotalEarnings.setText(total + " BDT");
                lblMessage.setText("Showing earnings for " + m);
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

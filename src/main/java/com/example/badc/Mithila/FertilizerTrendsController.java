package com.example.badc.Mithila;

import com.example.badc.model.StockRecord;
import com.example.badc.service.StockService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FertilizerTrendsController implements Initializable {

    @FXML private ComboBox<String> fertDrop;
    @FXML private TextField fromDate;
    @FXML private TextField toDate;
    @FXML private TableView<StockRecord> trendTable;
    @FXML private TableColumn<StockRecord, String> colDate;
    @FXML private TableColumn<StockRecord, String> colFert;
    @FXML private TableColumn<StockRecord, Double> colUsed;
    @FXML private TableColumn<StockRecord, Double> colLeft;
    @FXML private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fertDrop.getItems().addAll("Urea", "TSP", "MOP", "DAP");
        
        colDate.setCellValueFactory(new PropertyValueFactory<>("distributionDate"));
        colFert.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colUsed.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        // placeholder, remaining stock not tracked in this version
        colLeft.setCellValueFactory(new PropertyValueFactory<>("recordId"));
    }

    @FXML
    public void analyseUsage(ActionEvent e) {
        String fertVal = fertDrop.getValue();
        if (fertVal == null) {
            msgLabel.setText("Please select a fertilizer type");
            return;
        }

        String fromVal = fromDate.getText().trim();
        if (fromVal.isEmpty()) {
            msgLabel.setText("From date is required");
            return;
        }

        String toVal = toDate.getText().trim();
        if (toVal.isEmpty()) {
            msgLabel.setText("To date is required");
            return;
        }

        List<StockRecord> allRecords = StockService.getAllRecords();
        List<StockRecord> filtered = new ArrayList<>();
        
        for (StockRecord record : allRecords) {
            if (record.getItemName().equalsIgnoreCase(fertVal) 
                && record.getDistributionDate().compareTo(fromVal) >= 0 
                && record.getDistributionDate().compareTo(toVal) <= 0) {
                filtered.add(record);
            }
        }

        if (filtered.isEmpty()) {
            msgLabel.setText("No usage records found for " + fertVal + " in this date range");
            return;
        }

        trendTable.setItems(FXCollections.observableArrayList(filtered));
        
        double totalUsed = 0;
        for (StockRecord s : filtered) {
            totalUsed += s.getQuantity();
        }
        
        msgLabel.setText("Total " + fertVal + " used: " + totalUsed + " kg across " + filtered.size() + " record(s)");
    }

    @FXML
    public void clearForm(ActionEvent e) {
        fertDrop.setValue(null);
        fromDate.clear();
        toDate.clear();
        trendTable.getItems().clear();
        msgLabel.setText("");
    }

    @FXML
    public void goBack(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/badc/Mithila/report_officer_dashboard.fxml"));
            Stage stage = (Stage) fertDrop.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            // file operations wrap catch
        }
    }
}

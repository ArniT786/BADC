package com.example.badc.Mithila;

import com.example.badc.model.ProductionRecord;
import com.example.badc.service.ProductionService;
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
import java.util.List;
import java.util.ResourceBundle;

public class ProductionReportController implements Initializable {

    @FXML private TextField cropField;
    @FXML private ComboBox<String> seasonDrop;
    @FXML private TextField officerNid;
    @FXML private TableView<ProductionRecord> productionTable;
    @FXML private TableColumn<ProductionRecord, String> colFarmer;
    @FXML private TableColumn<ProductionRecord, String> colCrop;
    @FXML private TableColumn<ProductionRecord, String> colSeason;
    @FXML private TableColumn<ProductionRecord, Double> colWeight;
    @FXML private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        seasonDrop.getItems().addAll("Rabi 2024", "Kharif 2024", "Rabi 2025", "Kharif 2025");
        
        colFarmer.setCellValueFactory(new PropertyValueFactory<>("farmerNid"));
        colCrop.setCellValueFactory(new PropertyValueFactory<>("cropType"));
        colSeason.setCellValueFactory(new PropertyValueFactory<>("season"));
        colWeight.setCellValueFactory(new PropertyValueFactory<>("harvestWeight"));
    }

    @FXML
    public void generateReport(ActionEvent e) {
        String cropVal = cropField.getText().trim();
        if (cropVal.isEmpty()) {
            msgLabel.setText("Crop type is required");
            return;
        }

        String seasonVal = seasonDrop.getValue();
        if (seasonVal == null) {
            msgLabel.setText("Please select a season");
            return;
        }

        String officerNidVal = officerNid.getText().trim();
        if (officerNidVal.isEmpty()) {
            msgLabel.setText("Officer NID is required");
            return;
        }

        List<ProductionRecord> resultList = ProductionService.getByCropAndSeason(cropVal, seasonVal);
        if (resultList.isEmpty()) {
            msgLabel.setText("No production records found");
            return;
        }

        productionTable.setItems(FXCollections.observableArrayList(resultList));
        double totalVal = ProductionService.getTotalProduction(cropVal, seasonVal);
        msgLabel.setText("Total production for " + cropVal + " in " + seasonVal + ": " + totalVal + " kg");
    }

    @FXML
    public void clearForm(ActionEvent e) {
        cropField.clear();
        seasonDrop.setValue(null);
        officerNid.clear();
        productionTable.getItems().clear();
        msgLabel.setText("");
    }

    @FXML
    public void goBack(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/badc/Mithila/report_officer_dashboard.fxml"));
            Stage stage = (Stage) cropField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            // file operations wrap catch
        }
    }
}

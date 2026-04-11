package com.example.badc.Mithila;

import com.example.badc.model.Farmer;
import com.example.badc.service.FarmerService;
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

public class FarmerSummaryController implements Initializable {

    @FXML private ComboBox<String> regionBox;
    @FXML private TextField officerNid;
    @FXML private TableView<Farmer> farmerTable;
    @FXML private TableColumn<Farmer, String> colNid;
    @FXML private TableColumn<Farmer, String> colName;
    @FXML private TableColumn<Farmer, String> colRegion;
    @FXML private TableColumn<Farmer, String> colLand;
    @FXML private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        regionBox.getItems().addAll("Dhaka", "Rajshahi", "Chittagong", "Sylhet", "Khulna", "Barisal", "Rangpur", "Mymensingh");
        
        colNid.setCellValueFactory(new PropertyValueFactory<>("nid"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colRegion.setCellValueFactory(new PropertyValueFactory<>("district"));
        colLand.setCellValueFactory(new PropertyValueFactory<>("landSize"));
    }

    @FXML
    public void generateReport(ActionEvent e) {
        String officerNidVal = officerNid.getText().trim();
        if (officerNidVal.isEmpty()) {
            msgLabel.setText("Officer NID is required");
            return;
        }

        String regionVal = regionBox.getValue();
        if (regionVal == null) {
            msgLabel.setText("Please select a region");
            return;
        }

        List<Farmer> resultList = FarmerService.getByDistrict(regionVal);
        if (resultList.isEmpty()) {
            msgLabel.setText("No farmers found in " + regionVal);
            return;
        }

        farmerTable.setItems(FXCollections.observableArrayList(resultList));
        msgLabel.setText("Found " + resultList.size() + " farmer(s) in " + regionVal);
    }

    @FXML
    public void goBack(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/badc/Mithila/report_officer_dashboard.fxml"));
            Stage stage = (Stage) regionBox.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            // file operations wrap catch
        }
    }
}

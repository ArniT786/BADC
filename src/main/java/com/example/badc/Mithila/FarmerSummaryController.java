package com.example.badc.Mithila;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.badc.SceneSwitcher;

public class FarmerSummaryController implements Initializable {

    @FXML
    private ComboBox regionBox;
    @FXML
    private TextField officerNid;
    @FXML
    private TableView farmerTable;
    @FXML
    private TableColumn colNid;
    @FXML
    private TableColumn colName;
    @FXML
    private TableColumn colRegion;
    @FXML
    private TableColumn colLand;
    @FXML
    private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void generateReport(ActionEvent event) {
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/report_officer_dashboard.fxml");
    }
}

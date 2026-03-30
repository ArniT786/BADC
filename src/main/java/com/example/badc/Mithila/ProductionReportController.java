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

public class ProductionReportController implements Initializable {

    @FXML
    private TextField cropField;
    @FXML
    private ComboBox seasonDrop;
    @FXML
    private TextField officerNid;
    @FXML
    private TableView productionTable;
    @FXML
    private TableColumn colFarmer;
    @FXML
    private TableColumn colCrop;
    @FXML
    private TableColumn colSeason;
    @FXML
    private TableColumn colWeight;
    @FXML
    private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void generateReport(ActionEvent event) {
    }

    @FXML
    private void clearForm(ActionEvent event) {
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/report_officer_dashboard.fxml");
    }
}

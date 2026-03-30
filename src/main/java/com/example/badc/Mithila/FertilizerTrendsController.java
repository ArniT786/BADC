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

public class FertilizerTrendsController implements Initializable {

    @FXML
    private ComboBox fertDrop;
    @FXML
    private TextField fromDate;
    @FXML
    private TextField toDate;
    @FXML
    private TableView trendTable;
    @FXML
    private TableColumn colDate;
    @FXML
    private TableColumn colFert;
    @FXML
    private TableColumn colUsed;
    @FXML
    private TableColumn colLeft;
    @FXML
    private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void analyseUsage(ActionEvent event) {
    }

    @FXML
    private void clearForm(ActionEvent event) {
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/report_officer_dashboard.fxml");
    }
}

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

    @FXML private ComboBox<String> reg_cb;
    @FXML private TextField nid_txt;
    @FXML private TableView<?> farmer_tbl;
    @FXML private TableColumn<?, String> nid_col;
    @FXML private TableColumn<?, String> name_col;
    @FXML private TableColumn<?, String> reg_col;
    @FXML private TableColumn<?, String> land_col;
    @FXML private Label msg_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reg_cb.getItems().addAll("Dhaka", "Rajshahi", "Chittagong", "Sylhet");
    }

    @FXML
    private void generateReport(ActionEvent event) {
        msg_lbl.setText("Report generation logic goes here.");
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/Mithila/report_officer_dashboard.fxml");
    }
}

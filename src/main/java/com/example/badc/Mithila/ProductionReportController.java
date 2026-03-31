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

    @FXML private TextField crop_txt;
    @FXML private ComboBox<String> seas_cb;
    @FXML private TextField nid_txt;
    @FXML private TableView<?> prod_tbl;
    @FXML private TableColumn<?, String> nid_col;
    @FXML private TableColumn<?, String> crop_col;
    @FXML private TableColumn<?, String> seas_col;
    @FXML private TableColumn<?, Double> wt_col;
    @FXML private Label msg_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        seas_cb.getItems().addAll("Rabi 2024", "Kharif 2024", "Rabi 2025");
    }

    @FXML
    private void generateReport(ActionEvent event) {
        msg_lbl.setText("Generating report...");
    }

    @FXML
    private void clearForm(ActionEvent event) {
        crop_txt.clear();
        seas_cb.setValue(null);
        nid_txt.clear();
        msg_lbl.setText("");
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/Mithila/report_officer_dashboard.fxml");
    }
}

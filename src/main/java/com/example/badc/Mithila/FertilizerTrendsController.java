package com.example.badc.Mithila;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;
import com.example.badc.SceneSwitcher;

public class FertilizerTrendsController implements Initializable {

    @FXML private ComboBox<String> type_cb;
    @FXML private DatePicker from_dp;
    @FXML private DatePicker to_dp;
    @FXML private TableView<?> trend_tbl;
    @FXML private TableColumn<?, String> date_col;
    @FXML private TableColumn<?, String> fert_col;
    @FXML private TableColumn<?, Double> used_col;
    @FXML private TableColumn<?, Double> left_col;
    @FXML private Label msg_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        type_cb.getItems().addAll("Urea", "TSP", "MOP");
    }

    @FXML
    private void analyseUsage(ActionEvent event) {
        msg_lbl.setText("Analysing...");
    }

    @FXML
    private void clearForm(ActionEvent event) {
        type_cb.setValue(null);
        from_dp.setValue(null);
        to_dp.setValue(null);
        msg_lbl.setText("");
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/Mithila/report_officer_dashboard.fxml");
    }
}

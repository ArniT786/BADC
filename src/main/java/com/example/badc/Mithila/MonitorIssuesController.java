package com.example.badc.Mithila;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import com.example.badc.SceneSwitcher;

public class MonitorIssuesController implements Initializable {

    @FXML private TableView<?> issue_tbl;
    @FXML private TableColumn<?, String> id_col;
    @FXML private TableColumn<?, String> loc_col;
    @FXML private TableColumn<?, String> desc_col;
    @FXML private TableColumn<?, String> prio_col;
    @FXML private TextField det_txt;
    @FXML private Label msg_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    private void loadIssues(ActionEvent event) {
        msg_lbl.setText("Issues loaded.");
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/Mithila/report_officer_dashboard.fxml");
    }
}

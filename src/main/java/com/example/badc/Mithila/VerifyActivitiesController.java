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

public class VerifyActivitiesController implements Initializable {

    @FXML private ComboBox<String> name_cb;
    @FXML private TextField nid_txt;
    @FXML private TableView<?> log_tbl;
    @FXML private TableColumn<?, String> date_col;
    @FXML private TableColumn<?, String> summ_col;
    @FXML private TableColumn<?, String> stat_col;
    @FXML private Label msg_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name_cb.getItems().addAll("Officer A", "Officer B", "Officer C");
    }

    @FXML
    private void loadLogs(ActionEvent event) {
        msg_lbl.setText("Logs loaded.");
    }

    @FXML
    private void approveLog(ActionEvent event) {
        msg_lbl.setText("Log approved.");
    }

    @FXML
    private void rejectLog(ActionEvent event) {
        msg_lbl.setText("Log rejected.");
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/Mithila/report_officer_dashboard.fxml");
    }
}

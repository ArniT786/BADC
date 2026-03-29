package com.example.badc.Arnima;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class ScheduleViewController implements Initializable {

    @FXML private ComboBox<String> cmbDistrict;
    @FXML private TableView<?> tblSchedule;
    @FXML private TableColumn<?, String> colDistrict;
    @FXML private TableColumn<?, String> colDate;
    @FXML private TableColumn<?, String> colLocation;
    @FXML private TableColumn<?, String> colSeedType;
    @FXML private Label lblMessage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    @FXML private void searchSchedule(ActionEvent event) {}
    @FXML private void goBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/badc/Arnima/farmer_dashboard.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (Exception e) { e.printStackTrace(); }
    }
}

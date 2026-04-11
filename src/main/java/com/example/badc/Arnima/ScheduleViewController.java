package com.example.badc.Arnima;

import com.example.badc.Arnima.service.ScheduleService;
import com.example.badc.model.Schedule;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.util.ArrayList;

public class ScheduleViewController {
    @FXML private ComboBox<String> cmbDistrict;
    @FXML private TableView<Schedule> tblSchedule;
    @FXML private TableColumn<Schedule, String> colDistrict, colDate, colLocation, colSeedType;
    @FXML private Label lblMessage;

    public void initialize() {
        cmbDistrict.getItems().addAll("Dhaka","Rajshahi","Chittagong","Sylhet","Khulna","Barisal","Rangpur","Mymensingh");
        colDistrict.setCellValueFactory(new PropertyValueFactory<>("district"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("deliveryDate"));
        colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        colSeedType.setCellValueFactory(new PropertyValueFactory<>("seedType"));
    }

    @FXML
    public void searchSchedule(ActionEvent e) {
        System.out.println("search schedule");
        String d = cmbDistrict.getValue() == null ? "" : cmbDistrict.getValue();
        if (d.isEmpty()) {
            lblMessage.setText("Please select a district");
        } else {
            ScheduleService svc = new ScheduleService();
            ArrayList<Schedule> list = svc.getByDistrict(d);
            if (list.isEmpty()) {
                lblMessage.setText("No schedule found for " + d);
                tblSchedule.getItems().clear();
            } else {
                tblSchedule.setItems(FXCollections.observableArrayList(list));
                lblMessage.setText("Found " + list.size() + " schedule(s) for " + d);
            }
        }
    }

    @FXML
    public void goBack(ActionEvent e) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("/com/example/badc/Arnima/farmer_dashboard.fxml"));
            Stage s = (Stage) cmbDistrict.getScene().getWindow();
            s.setScene(new Scene(p));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

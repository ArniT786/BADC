package com.example.badc.Meraj.Admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginDashboardController {

    @FXML
    private TableView<LoginDashboard > requestTable;
    @FXML
    private TableColumn<LoginDashboard , Integer> colId;
    @FXML
    private TableColumn<LoginDashboard , String> colUser;
    @FXML
    private TableColumn<LoginDashboard , String> colStatus;

    private ObservableList<LoginDashboard > list = FXCollections.observableArrayList();

    @FXML
    public void initialize() {


        colId.setCellValueFactory(colId.getCellValueFactory());
        colUser.setCellValueFactory(colUser.getCellValueFactory());
        colStatus.setCellValueFactory(colStatus.getCellValueFactory());

        loadData();
    }

    private void loadData() {
        list.add(new LoginDashboard (1, "Rahim", "Pending"));
        list.add(new LoginDashboard (2, "Karim", "Pending"));
        list.add(new LoginDashboard (3, "Hasan", "Pending"));

        requestTable.setItems(list);
    }
    @FXML
    public void handleApprove(ActionEvent actionEvent) {

        LoginDashboard  selected = requestTable.getSelectionModel().getSelectedItem();

        if (selected != null) {
            selected.setStatus("Approved");
            requestTable.refresh();
        } else {
            showAlert("Select a request first!");
        }
    }
    @FXML
    public void handleReject(ActionEvent actionEvent) {

        LoginDashboard  selected = requestTable.getSelectionModel().getSelectedItem();

        if (selected != null) {
            selected.setStatus("Rejected");
            requestTable.refresh();
        } else {
            showAlert("Select a request first!");
        }
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(msg);
        alert.show();
    }
}
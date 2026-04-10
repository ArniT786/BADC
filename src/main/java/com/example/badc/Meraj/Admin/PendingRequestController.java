package com.example.badc.Meraj.Admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PendingRequestController {
    @FXML
    private TableView<PendingRequest> requestTable;
    @FXML
    private TableColumn<PendingRequest, Integer> colRequestId;
    @FXML
    private TableColumn<PendingRequest, String> colUserName;
    @FXML
    private TableColumn<PendingRequest, String> colType;
    @FXML
    private TableColumn<PendingRequest, String> colStatus;
    @FXML
    private TextArea txtDetails;
    private ObservableList<PendingRequest> list = FXCollections.observableArrayList();
    @FXML
    public void initialize() {

        colRequestId.setCellValueFactory(colRequestId.getCellValueFactory());
        colUserName.setCellValueFactory(colUserName.getCellValueFactory());
        colType.setCellValueFactory(colType.getCellValueFactory());
        colStatus.setCellValueFactory(colStatus.getCellValueFactory());
        loadData();

        requestTable.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                txtDetails.setText(newVal.getDetails());
            }
        });
    }
    private void loadData() {

        list.add(new PendingRequest(1, "Rahim", "Subsidy", "Pending", "Farmer subsidy request"));
        list.add(new PendingRequest(2, "Karim", "Payment", "Pending", "Payment approval request"));
        list.add(new PendingRequest(3, "Hasan", "Inventory", "Pending", "Stock update request"));

        requestTable.setItems(list);
    }
    @FXML
    public void handleApprove(ActionEvent actionEvent) {

        PendingRequest selected = requestTable.getSelectionModel().getSelectedItem();

        if (selected != null) {
            selected.setStatus("Approved");
            requestTable.refresh();
        } else {
            showAlert("Select a request first!");
        }
    }
    @FXML
    public void handleReject(ActionEvent actionEvent) {

        PendingRequest selected = requestTable.getSelectionModel().getSelectedItem();

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
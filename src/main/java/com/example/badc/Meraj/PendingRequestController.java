package com.example.badc.Meraj;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class PendingRequestController
{
    @javafx.fxml.FXML
    private TableView requestTable;
    @javafx.fxml.FXML
    private TableColumn colType;
    @javafx.fxml.FXML
    private TextArea txtDetails;
    @javafx.fxml.FXML
    private TableColumn colUserName;
    @javafx.fxml.FXML
    private TableColumn colRequestId;
    @javafx.fxml.FXML
    private TableColumn colStatus;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleReject(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleApprove(ActionEvent actionEvent) {
    }
}
package com.example.badc.Meraj;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class SubsidyController
{
    @javafx.fxml.FXML
    private TableColumn colAccount;
    @javafx.fxml.FXML
    private TableColumn colAmount;
    @javafx.fxml.FXML
    private TableColumn colName;
    @javafx.fxml.FXML
    private TableView subsidyTable;
    @javafx.fxml.FXML
    private TextArea txtPaymentDetails;
    @javafx.fxml.FXML
    private TableColumn colBeneficiaryId;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleRefresh(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleReleasePayment(ActionEvent actionEvent) {
    }
}
package com.example.badc.Meraj;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class PaymentController
{
    @javafx.fxml.FXML
    private TableColumn colAmount;
    @javafx.fxml.FXML
    private TableColumn colPaymentId;
    @javafx.fxml.FXML
    private TableColumn colMethod;
    @javafx.fxml.FXML
    private TableView paymentTable;
    @javafx.fxml.FXML
    private TableColumn colUser;
    @javafx.fxml.FXML
    private TextArea txtDetails;
    @javafx.fxml.FXML
    private TableColumn colStatus;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleApprovePayment(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleRefresh(ActionEvent actionEvent) {
    }
}
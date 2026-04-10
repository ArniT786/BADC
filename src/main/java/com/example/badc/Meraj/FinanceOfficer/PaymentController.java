package com.example.badc.Meraj.FinanceOfficer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PaymentController {

    @FXML
    private TableColumn<Payment, Integer> colPaymentId;
    @FXML
    private TableColumn<Payment, String> colUser;
    @FXML
    private TableColumn<Payment, Double> colAmount;
    @FXML
    private TableColumn<Payment, String> colMethod;
    @FXML
    private TableColumn<Payment, String> colStatus;

    @FXML
    private TableView<Payment> paymentTable;
    @FXML
    private TextArea txtDetails;

    private ObservableList<Payment> paymentList = FXCollections.observableArrayList();
    private Payment selectedPayment;

    @FXML
    public void initialize() {


        colPaymentId.setCellValueFactory(colPaymentId.getCellValueFactory());
        colUser.setCellValueFactory(colUser.getCellValueFactory());
        colAmount.setCellValueFactory(colAmount.getCellValueFactory());
        colMethod.setCellValueFactory(colMethod.getCellValueFactory());
        colStatus.setCellValueFactory(colStatus.getCellValueFactory());
        loadData();

    }
    private void loadData() {

        paymentList.clear();

        paymentList.add(new Payment(1, "Rahim", 5000, "Bank", "Pending"));
        paymentList.add(new Payment(2, "Karim", 2000, "Cash", "Pending"));
        paymentList.add(new Payment(3, "Hasan", 8000, "Mobile Banking", "Approved"));

        paymentTable.setItems(paymentList);
    }

    @FXML
    public void handleRefresh(ActionEvent actionEvent) {

        try {
            loadData();
            txtDetails.setText("Data refreshed");

        } catch (Exception e) {
            txtDetails.setText("Error refreshing data");
        }
    }


    @FXML
    public void handleApprovePayment(ActionEvent actionEvent) {

        try {

            if (selectedPayment == null) {
                txtDetails.setText("Select a payment first!");
                return;
            }

            if (selectedPayment.getStatus().equals("Approved")) {
                txtDetails.setText("Already approved!");
                return;
            }

            selectedPayment.setStatus("Approved");

            paymentTable.refresh();

            txtDetails.setText("Payment approved successfully");

        } catch (Exception e) {
            txtDetails.setText("Error approving payment");
        }
    }
}
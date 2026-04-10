package com.example.badc.Meraj.FinanceOfficer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SubsidyController {

    @FXML
    private TableColumn<Subsidy, Integer> colBeneficiaryId;
    @FXML
    private TableColumn<Subsidy, String> colName;
    @FXML
    private TableColumn<Subsidy, String> colAccount;
    @FXML
    private TableColumn<Subsidy, Double> colAmount;

    @FXML
    private TableView<Subsidy> subsidyTable;
    @FXML
    private TextArea txtPaymentDetails;

    private ObservableList<Subsidy> subsidyList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colBeneficiaryId.setCellValueFactory(colBeneficiaryId.getCellValueFactory());
        colName.setCellValueFactory(colName.getCellValueFactory());
        colAccount.setCellValueFactory(colAccount.getCellValueFactory());
        colAmount.setCellValueFactory(colAmount.getCellValueFactory());

        loadData();
    }

    private void loadData() {

        subsidyList.clear();

        subsidyList.add(new Subsidy(101, "Rahim", "ACC123", 5000));
        subsidyList.add(new Subsidy(102, "Karim", "ACC456", 7000));
        subsidyList.add(new Subsidy(103, "Hasan", "ACC789", 6000));

        subsidyTable.setItems(subsidyList);
    }

    @FXML
    public void handleRefresh(ActionEvent actionEvent) {

        try {
            loadData();
            txtPaymentDetails.setText("Data refreshed");

        } catch (Exception e) {
            txtPaymentDetails.setText("Error refreshing data");
        }
    }

    @FXML
    public void handleReleasePayment(ActionEvent actionEvent) {

        try {

            Subsidy selected = subsidyTable.getSelectionModel().getSelectedItem();

            if (selected == null) {
                txtPaymentDetails.setText("Select a beneficiary first!");
                return;
            }

            txtPaymentDetails.setText(
                    "Payment Released!\n" +
                    "Name: " + selected.getName() +
                    "\nAccount: " + selected.getAccount() +
                    "\nAmount: " + selected.getAmount()
            );

        } catch (Exception e) {
            txtPaymentDetails.setText("Error processing payment");
        }
    }
}
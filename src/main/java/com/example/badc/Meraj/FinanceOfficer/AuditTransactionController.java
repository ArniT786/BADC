package com.example.badc.Meraj.FinanceOfficer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AuditTransactionController {

    @FXML
    private Button fetchBtn;
    @FXML
    private TableView<AuditTransaction> transactionTable;
    @FXML
    private TextField remarkField;
    @FXML
    private Button reviewBtn;
    @FXML
    private Button notifyBtn;
    @FXML
    private Button flagBtn;
    @FXML
    private Label statusLabel;
    @FXML
    private Button saveBtn;

    private ObservableList<AuditTransaction> transactionList = FXCollections.observableArrayList();

    private AuditTransaction selectedTransaction;

    @FXML
    public void initialize() {
        statusLabel.setText("");
    }
    @FXML
    public void handleFetchTransactions(ActionEvent actionEvent) {

        try {
            transactionList.clear();

            transactionList.add(new AuditTransaction(1, "Rahim", 5000, "Completed", ""));
            transactionList.add(new AuditTransaction(2, "Karim", 2000, "Pending", ""));
            transactionList.add(new AuditTransaction(3, "Hasan", 8000, "Completed", ""));

            transactionTable.setItems(transactionList);

            statusLabel.setText("Transactions loaded");

        } catch (Exception e) {
            statusLabel.setText("Error fetching data!");
        }
    }
    @FXML
    public void handleReviewEntries(ActionEvent actionEvent) {

        try {
            selectedTransaction = transactionTable.getSelectionModel().getSelectedItem();

            if (selectedTransaction == null) {
                statusLabel.setText("Select a transaction first!");
                return;
            }

            statusLabel.setText("Reviewing transaction ID: " + selectedTransaction.getId());

        } catch (Exception e) {
            statusLabel.setText("Error reviewing transaction!");
        }
    }
    @FXML
    public void handleFlagIssue(ActionEvent actionEvent) {

        try {
            selectedTransaction = transactionTable.getSelectionModel().getSelectedItem();

            if (selectedTransaction == null) {
                statusLabel.setText("Select a transaction first!");
                return;
            }

            selectedTransaction.setStatus("Flagged");
            transactionTable.refresh();

            statusLabel.setText("Transaction flagged");

        } catch (Exception e) {
            statusLabel.setText("Error flagging transaction!");
        }
    }
    @FXML
    public void handleSaveRemarks(ActionEvent actionEvent) {

        try {
            selectedTransaction = transactionTable.getSelectionModel().getSelectedItem();

            if (selectedTransaction == null) {
                statusLabel.setText("Select a transaction first!");
                return;
            }

            selectedTransaction.setRemark(remarkField.getText());
            transactionTable.refresh();

            statusLabel.setText("Remarks saved");

        } catch (Exception e) {
            statusLabel.setText("Error saving remarks!");
        }
    }
    @FXML
    public void handleNotifyAdmin(ActionEvent actionEvent) {

        try {
            if (selectedTransaction == null) {
                statusLabel.setText("No transaction selected!");
                return;
            }

            statusLabel.setText("Admin notified about transaction ID: " + selectedTransaction.getId());

        } catch (Exception e) {
            statusLabel.setText("Error sending notification!");
        }
    }
}
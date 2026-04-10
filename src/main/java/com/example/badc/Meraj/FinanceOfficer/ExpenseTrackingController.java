package com.example.badc.Meraj.FinanceOfficer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ExpenseTrackingController {

    @FXML
    private Button fetchBtn;
    @FXML
    private TextField categoryField;
    @FXML
    private TextArea descriptionArea;
    @FXML
    private Button processBtn;
    @FXML
    private Label summaryLabel;
    @FXML
    private Button editBtn;
    @FXML
    private TableView<ExpenseTracking> expenseTable;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button validateBtn;
    @FXML
    private Label confirmationLabel;
    @FXML
    private TextField amountField;
    @FXML
    private Button saveBtn;

    private ObservableList<ExpenseTracking> expenseList = FXCollections.observableArrayList();
    private ExpenseTracking selectedExpense;

    @FXML
    public void initialize() {
        summaryLabel.setText("");
        confirmationLabel.setText("");
    }


    @FXML
    public void handleFetchExpenses(ActionEvent actionEvent) {

        try {
            expenseList.clear();

            expenseList.add(new ExpenseTracking("Food", "Lunch", 200, java.time.LocalDate.now()));
            expenseList.add(new ExpenseTracking("Transport", "Bus fare", 50, java.time.LocalDate.now()));

            expenseTable.setItems(expenseList);

            summaryLabel.setText("Expenses loaded");

        } catch (Exception e) {
            summaryLabel.setText("Error loading data");
        }
    }

    @FXML
    public void handleSaveExpense(ActionEvent actionEvent) {

        try {
            String category = categoryField.getText();
            String desc = descriptionArea.getText();
            double amount = Double.parseDouble(amountField.getText());
            java.time.LocalDate date = datePicker.getValue();

            if (category.isEmpty() || desc.isEmpty() || date == null) {
                confirmationLabel.setText("Fill all fields!");
                return;
            }

            ExpenseTracking expense = new ExpenseTracking(category, desc, amount, date);
            expenseList.add(expense);

            expenseTable.setItems(expenseList);

            confirmationLabel.setText("Saved successfully");

        } catch (NumberFormatException e) {
            confirmationLabel.setText("Invalid amount!");
        } catch (Exception e) {
            confirmationLabel.setText("Error saving expense");
        }
    }

    @FXML
    public void handleValidateRecords(ActionEvent actionEvent) {

        try {
            if (expenseList.isEmpty()) {
                summaryLabel.setText("No data to validate");
                return;
            }

            summaryLabel.setText("Records validated");

        } catch (Exception e) {
            summaryLabel.setText("Validation error");
        }
    }

    @FXML
    public void handleEditExpense(ActionEvent actionEvent) {

        try {
            selectedExpense = expenseTable.getSelectionModel().getSelectedItem();

            if (selectedExpense == null) {
                confirmationLabel.setText("Select a row first!");
                return;
            }

            categoryField.setText(selectedExpense.getCategory());
            descriptionArea.setText(selectedExpense.getDescription());
            amountField.setText(String.valueOf(selectedExpense.getAmount()));
            datePicker.setValue(selectedExpense.getDate());

        } catch (Exception e) {
            confirmationLabel.setText("Error editing");
        }
    }

    @FXML
    public void handleProcessUpdate(ActionEvent actionEvent) {

        try {
            if (selectedExpense == null) {
                confirmationLabel.setText("Select expense first!");
                return;
            }

            selectedExpense.setCategory(categoryField.getText());
            selectedExpense.setDescription(descriptionArea.getText());
            selectedExpense.setAmount(Double.parseDouble(amountField.getText()));
            selectedExpense.setDate(datePicker.getValue());

            expenseTable.refresh();

            confirmationLabel.setText("Updated successfully");

        } catch (Exception e) {
            confirmationLabel.setText("Update failed");
        }
    }
}
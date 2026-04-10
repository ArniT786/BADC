package com.example.badc.Meraj.FinanceOfficer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class BudgetController {

    @FXML
    private TableColumn<Budget, String> colDept;
    @FXML
    private TableColumn<Budget, Double> colUsed;
    @FXML
    private TableColumn<Budget, Double> colAllocated;
    @FXML
    private TableColumn<Budget, Double> colRemaining;

    @FXML
    private TextField txtAllocation;
    @FXML
    private Label lblStatus;
    @FXML
    private TableView<Budget> budgetTable;

    private ObservableList<Budget> budgetList = FXCollections.observableArrayList();
    private Budget selectedBudget;

    @FXML
    public void initialize() {

        colDept.setCellValueFactory(colDept.getCellValueFactory());
        colAllocated.setCellValueFactory(colAllocated.getCellValueFactory());
        colUsed.setCellValueFactory(colUsed.getCellValueFactory());
        colRemaining.setCellValueFactory(colRemaining.getCellValueFactory());

        loadData();
        budgetTable.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            selectedBudget = newVal;
        });
    }

    private void loadData() {

        budgetList.clear();

        budgetList.add(new Budget("Agriculture", 100000, 40000));
        budgetList.add(new Budget("IT", 150000, 60000));
        budgetList.add(new Budget("Finance", 200000, 50000));

        budgetTable.setItems(budgetList);
    }

    @FXML
    public void handleRefresh(ActionEvent actionEvent) {

        try {
            loadData();
            lblStatus.setText("Data refreshed");

        } catch (Exception e) {
            lblStatus.setText("Error refreshing!");
        }
    }

    @FXML
    public void handleUpdateAllocation(ActionEvent actionEvent) {

        try {

            if (selectedBudget == null) {
                lblStatus.setText("Select a row first!");
                return;
            }

            double newValue = Double.parseDouble(txtAllocation.getText());

            selectedBudget.setAllocated(newValue);

            budgetTable.refresh();

            lblStatus.setText("Updated successfully");

        } catch (NumberFormatException e) {
            lblStatus.setText("Enter valid number!");
        } catch (Exception e) {
            lblStatus.setText("Error occurred!");
        }
    }
}
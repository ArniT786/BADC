package com.example.badc.Meraj;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BudgetController
{
    @javafx.fxml.FXML
    private TableColumn colDept;
    @javafx.fxml.FXML
    private TableColumn colUsed;
    @javafx.fxml.FXML
    private TableColumn colAllocated;
    @javafx.fxml.FXML
    private TableColumn colRemaining;
    @javafx.fxml.FXML
    private TextField txtAllocation;
    @javafx.fxml.FXML
    private Label lblStatus;
    @javafx.fxml.FXML
    private TableView budgetTable;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleUpdateAllocation(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleRefresh(ActionEvent actionEvent) {
    }
}
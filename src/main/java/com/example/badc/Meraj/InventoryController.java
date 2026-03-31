package com.example.badc.Meraj;

public class InventoryController
{
    @javafx.fxml.FXML
    private TableView inventoryTable;
    @javafx.fxml.FXML
    private TableColumn colItemId;
    @javafx.fxml.FXML
    private TableColumn colItemName;
    @javafx.fxml.FXML
    private TableColumn colQuantity;
    @javafx.fxml.FXML
    private ComboBox cmbCategory;
    @javafx.fxml.FXML
    private BarChart stockChart;
    @javafx.fxml.FXML
    private TableColumn colStatus;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleRefresh(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleFilter(ActionEvent actionEvent) {
    }
}
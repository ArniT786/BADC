package com.example.badc.Meraj.Admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;

public class InventoryController {

    @FXML
    private TableView<Inventory> inventoryTable;
    @FXML
    private TableColumn<Inventory, Integer> colItemId;
    @FXML
    private TableColumn<Inventory, String> colItemName;
    @FXML
    private TableColumn<Inventory, String> colQuantity;
    @FXML
    private TableColumn<Inventory, String> colStatus;

    @FXML
    private ComboBox<String> cmbCategory;

    @FXML
    private BarChart<String, Number> stockChart;

    private ObservableList<Inventory> list = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        colItemId.setCellValueFactory(colItemId.getCellValueFactory());
        colItemName.setCellValueFactory(colItemName.getCellValueFactory());
        colQuantity.setCellValueFactory(colQuantity.getCellValueFactory());
        colStatus.setCellValueFactory(colStatus.getCellValueFactory());

        cmbCategory.getItems().addAll("All", "Fertilizer", "Seeds", "Pesticide");
        cmbCategory.setValue("All");

        loadData();
        updateChart(list);
    }

    private void loadData() {
        list.clear();

        list.add(new Inventory("Urea", "50", "Available", 1, "Fertilizer"));
        list.add(new Inventory("Rice Seed", "20", "Low", 2, "Seeds"));
        list.add(new Inventory("Pesticide A", "10", "Low", 3, "Pesticide"));
        list.add(new Inventory("DAP", "70", "Available", 4, "Fertilizer"));

        inventoryTable.setItems(list);
    }

    @FXML
    public void handleRefresh(ActionEvent actionEvent) {
        loadData();
        updateChart(list);
    }

    @FXML
    public void handleFilter(ActionEvent actionEvent) {

        String selected = cmbCategory.getValue();

        if (selected.equals("All")) {
            inventoryTable.setItems(list);
            updateChart(list);
            return;
        }

        ObservableList<Inventory> filtered = FXCollections.observableArrayList();

        for (Inventory item : list) {
            if (item.getCategory().equals(selected)) {
                filtered.add(item);
            }
        }

        inventoryTable.setItems(filtered);
        updateChart(filtered);
    }

    private void updateChart(ObservableList<Inventory> dataList) {

        stockChart.getData().clear();

        XYChart.Series<String, Number> series = new XYChart.Series<>();

        for (Inventory item : dataList) {
            series.getData().add(
                    new XYChart.Data<>(item.getItemName(), Integer.parseInt(item.getQuantity()))
            );
        }

        stockChart.getData().add(series);
    }
}
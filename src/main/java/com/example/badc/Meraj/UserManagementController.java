package com.example.badc.Meraj;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class UserManagementController
{
    @javafx.fxml.FXML
    private TableColumn colName;
    @javafx.fxml.FXML
    private TextField txtName;
    @javafx.fxml.FXML
    private TableView userTable;
    @javafx.fxml.FXML
    private ComboBox cmbRole;
    @javafx.fxml.FXML
    private TableColumn colId;
    @javafx.fxml.FXML
    private TableColumn colRole;
    @javafx.fxml.FXML
    private TableColumn colStatus;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleEditUser(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleDeleteUser(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleAddUser(ActionEvent actionEvent) {
    }
}
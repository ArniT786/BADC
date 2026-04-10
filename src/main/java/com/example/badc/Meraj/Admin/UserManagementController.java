

      package com.example.badc.Meraj.Admin;

      import javafx.collections.FXCollections;
      import javafx.collections.ObservableList;
      import javafx.event.ActionEvent;
      import javafx.fxml.FXML;
      import javafx.scene.control.*;

      public class UserManagementController {

          @FXML
          private TableColumn<UserManagement, Integer> colId;
          @FXML
          private TableColumn<UserManagement, String> colName;
          @FXML
          private TableColumn<UserManagement, String> colRole;
          @FXML
          private TableColumn<UserManagement, String> colStatus;

          @FXML
          private TextField txtName;
          @FXML
          private TableView<UserManagement> userTable;
          @FXML
          private ComboBox<String> cmbRole;

          private ObservableList<UserManagement> userList = FXCollections.observableArrayList();

          private int idCounter = 1;

          @FXML
          public void initialize() {

              cmbRole.getItems().addAll("Admin", "Manager", "Officer");

              colId.setCellValueFactory(colId.getCellValueFactory());
              colName.setCellValueFactory(colName.getCellValueFactory());
              colRole.setCellValueFactory(colRole.getCellValueFactory());
              colStatus.setCellValueFactory(colStatus.getCellValueFactory());
              loadSampleData();
          }
          private void loadSampleData() {
              userList.add(new UserManagement(idCounter++, "Rahim", "Admin", "Active"));
              userList.add(new UserManagement(idCounter++, "Karim", "Officer", "Active"));

              userTable.setItems(userList);
          }
          @FXML
          public void handleAddUser(ActionEvent actionEvent) {

              try {
                  String name = txtName.getText();
                  String role = cmbRole.getValue();

                  if (name.isEmpty() || role == null) {
                      showAlert("Please fill all fields!");
                      return;
                  }

                  UserManagement newUser = new UserManagement(idCounter++, name, role, "Active");
                  userList.add(newUser);

                  userTable.setItems(userList);

                  txtName.clear();
                  cmbRole.setValue(null);

              } catch (Exception e) {
                  showAlert("Error adding user!");
              }
          }
          @FXML
          public void handleEditUser(ActionEvent actionEvent) {

              try {
                  UserManagement selected = userTable.getSelectionModel().getSelectedItem();

                  if (selected == null) {
                      showAlert("Select a user first!");
                      return;
                  }

                  selected.setName(txtName.getText());
                  selected.setRole(cmbRole.getValue());

                  userTable.refresh();

              } catch (Exception e) {
                  showAlert("Error editing user!");
              }
          }
          @FXML
          public void handleDeleteUser(ActionEvent actionEvent) {

              try {
                  UserManagement selected = userTable.getSelectionModel().getSelectedItem();

                  if (selected == null) {
                      showAlert("Select a user first!");
                      return;
                  }

                  userList.remove(selected);
                  userTable.refresh();

              } catch (Exception e) {
                  showAlert("Error deleting user!");
              }
          }
          private void showAlert(String msg) {
              Alert alert = new Alert(Alert.AlertType.WARNING);
              alert.setContentText(msg);
              alert.show();
          }
      }
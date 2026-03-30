package com.example.badc.Mithila;

import com.example.badc.model.Task;
import com.example.badc.service.TaskService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.example.badc.SceneSwitcher;

public class ViewTasksController implements Initializable {

    @FXML
    private TextField nidField;
    @FXML
    private TableView<Task> taskTable;
    @FXML
    private TableColumn<Task, String> colId;
    @FXML
    private TableColumn<Task, String> colDesc;
    @FXML
    private TableColumn<Task, String> colDue;
    @FXML
    private TableColumn<Task, String> colStat;
    @FXML
    private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("taskId"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        colDue.setCellValueFactory(new PropertyValueFactory<>("deadline"));
        colStat.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @FXML
    private void loadTasks(ActionEvent event) {
        String nid = nidField.getText().trim();
        if (nid.isEmpty()) {
            msgLabel.setText("Enter your NID first");
            return;
        }
        List<Task> tasks = TaskService.getByOfficerNid(nid);
        if (tasks.isEmpty()) {
            msgLabel.setText("No tasks found for this NID");
            taskTable.setItems(FXCollections.observableArrayList());
        } else {
            taskTable.setItems(FXCollections.observableArrayList(tasks));
            msgLabel.setText("Loaded " + tasks.size() + " task(s)");
        }
    }

    @FXML
    private void acknowledgeTask(ActionEvent event) {
        Task selected = taskTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            msgLabel.setText("Please select a task first");
            return;
        }
        if (selected.getStatus().equals("ACKNOWLEDGED")) {
            msgLabel.setText("Task already acknowledged");
            return;
        }
        TaskService.acknowledgeTask(selected.getTaskId());

        // Reload tasks
        String nid = nidField.getText().trim();
        List<Task> tasks = TaskService.getByOfficerNid(nid);
        taskTable.setItems(FXCollections.observableArrayList(tasks));
        msgLabel.setText("Task acknowledged successfully");
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/field_officer_dashboard.fxml");
    }
}

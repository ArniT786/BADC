package com.example.badc.Mithila;

import com.example.badc.model.Task;
import com.example.badc.service.TaskService;
import javafx.collections.FXCollections;
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

    @FXML private TextField nid_txt;
    @FXML private TableView<Task> task_tbl;
    @FXML private TableColumn<Task, String> id_col;
    @FXML private TableColumn<Task, String> desc_col;
    @FXML private TableColumn<Task, String> due_col;
    @FXML private TableColumn<Task, String> stat_col;
    @FXML private Label msg_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id_col.setCellValueFactory(new PropertyValueFactory<>("taskId"));
        desc_col.setCellValueFactory(new PropertyValueFactory<>("description"));
        due_col.setCellValueFactory(new PropertyValueFactory<>("deadline"));
        stat_col.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @FXML
    private void loadTasks(ActionEvent event) {
        String nid = nid_txt.getText().trim();
        if (nid.isEmpty()) {
            msg_lbl.setText("Enter NID first");
            return;
        }
        List<Task> tasks = TaskService.getByOfficerNid(nid);
        if (tasks.isEmpty()) {
            msg_lbl.setText("No tasks");
            task_tbl.setItems(FXCollections.observableArrayList());
        } else {
            task_tbl.setItems(FXCollections.observableArrayList(tasks));
            msg_lbl.setText("Loaded " + tasks.size() + " tasks");
        }
    }

    @FXML
    private void acknowledgeTask(ActionEvent event) {
        Task selected = task_tbl.getSelectionModel().getSelectedItem();
        if (selected == null) {
            msg_lbl.setText("Select a task");
            return;
        }
        TaskService.acknowledgeTask(selected.getTaskId());

        String nid = nid_txt.getText().trim();
        List<Task> tasks = TaskService.getByOfficerNid(nid);
        task_tbl.setItems(FXCollections.observableArrayList(tasks));
        msg_lbl.setText("Acknowledged");
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/field_officer_dashboard.fxml");
    }
}

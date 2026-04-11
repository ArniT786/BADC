package com.example.badc.Arnima;

import com.example.badc.Arnima.service.NoticeService;
import com.example.badc.model.Notice;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.util.ArrayList;

public class ViewNoticesController {
    @FXML private TableView<Notice> tblNotices;
    @FXML private TableColumn<Notice, String> colDate, colTitle, colType;
    @FXML private TextArea txtNoticeDetail;
    @FXML private Label lblMessage;

    public void initialize() {
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));

        tblNotices.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                txtNoticeDetail.setText(
                    "Title: " + newVal.getTitle() + "\n" +
                    "Date: " + newVal.getDate() + "\n" +
                    "Type: " + newVal.getType() + "\n\n" +
                    newVal.getFullText()
                );
            }
        });

        ArrayList<Notice> list = new NoticeService().getAll();
        if (!list.isEmpty()) {
            tblNotices.setItems(FXCollections.observableArrayList(list));
        }
    }

    @FXML
    private void viewSelected(ActionEvent e) {
        Notice n = tblNotices.getSelectionModel().getSelectedItem();
        if (n == null) {
            lblMessage.setText("Please select a notice first");
        } else {
            txtNoticeDetail.setText(
                "Title: " + n.getTitle() + "\n" +
                "Date: " + n.getDate() + "\n" +
                "Type: " + n.getType() + "\n\n" +
                n.getFullText()
            );
            lblMessage.setText("");
        }
    }

    @FXML
    private void goBack(ActionEvent e) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("/com/example/badc/Arnima/dealer_dashboard.fxml"));
            Stage s = (Stage) tblNotices.getScene().getWindow();
            s.setScene(new Scene(p));
        } catch (Exception ex) { ex.printStackTrace(); }
    }
}

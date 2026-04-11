package com.example.badc.Mithila;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SubmitHQController implements Initializable {

    @FXML private TextField officerNid;
    @FXML private ComboBox<String> reportTypeDrop;
    @FXML private TextArea reportArea;
    @FXML private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reportTypeDrop.getItems().addAll("Farmer Summary", "Production Report", "Fertilizer Report", "Activity Report");
    }

    @FXML
    public void submitReport(ActionEvent e) {
        String nidVal = officerNid.getText().trim();
        if (nidVal.isEmpty()) {
            msgLabel.setText("Officer NID is required");
            return;
        }

        String reportTypeVal = reportTypeDrop.getValue();
        if (reportTypeVal == null) {
            msgLabel.setText("Please select a report type");
            return;
        }

        String reportContent = reportArea.getText().trim();
        if (reportContent.isEmpty()) {
            msgLabel.setText("Report content cannot be empty");
            return;
        }

        if (reportContent.length() < 20) {
            msgLabel.setText("Report is too short. Add more details.");
            return;
        }

        String fileName = "data/HQ_" + nidVal + "_" + System.currentTimeMillis() + ".txt";

        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("Officer NID: " + nidVal);
            bw.newLine();
            bw.write("Report Type: " + reportTypeVal);
            bw.newLine();
            bw.write("Submitted On: " + LocalDate.now().toString());
            bw.newLine();
            bw.write("---");
            bw.newLine();
            bw.write(reportContent);
            
            bw.close();
            fw.close();

            msgLabel.setText("Report submitted to HQ successfully. File: " + fileName);
            clearForm(null);
            
        } catch (IOException ex) {
            msgLabel.setText("Failed to submit report. Try again.");
        }
    }

    @FXML
    public void clearForm(ActionEvent e) {
        officerNid.clear();
        reportTypeDrop.setValue(null);
        reportArea.clear();
        msgLabel.setText("");
    }

    @FXML
    public void goBack(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/badc/Mithila/report_officer_dashboard.fxml"));
            Stage stage = (Stage) officerNid.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            // file ops wrap catch
        }
    }
}

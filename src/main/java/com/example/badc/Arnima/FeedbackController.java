package com.example.badc.Arnima;

import com.example.badc.Arnima.service.FeedbackService;
import com.example.badc.model.Feedback;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FeedbackController {
    @FXML private TextField txtNID;
    @FXML private ComboBox<String> cmbCategory;
    @FXML private TextArea txtMessage;
    @FXML private Label lblMessage;

    public void initialize() {
        cmbCategory.getItems().addAll("Seed","Irrigation","Training","Other");
    }

    @FXML
    public void submitFeedback(ActionEvent e) {
        System.out.println("feedback submit");
        try {
            String id = txtNID.getText();
            String cat = cmbCategory.getValue() == null ? "" : cmbCategory.getValue();
            String msg = txtMessage.getText();

            if (id.isEmpty() || cat.isEmpty() || msg.isEmpty()) {
                lblMessage.setText("Please fill all fields");
            } else if (!id.matches("\\d{10}|\\d{13}")) {
                lblMessage.setText("NID must be 10 or 13 digits");
            } else if (msg.trim().length() < 15) {
                lblMessage.setText("Please write at least 15 characters");
            } else if (msg.length() > 500) {
                lblMessage.setText("Message is too long (max 500 chars)");
            } else {
                String fid = "FB" + System.currentTimeMillis();
                Feedback fb = new Feedback(fid, id, cat, msg);
                FeedbackService svc = new FeedbackService();
                boolean ok = svc.save(fb);
                if (ok) {
                    lblMessage.setText("Thank you! Feedback submitted.");
                    clearForm();
                } else {
                    lblMessage.setText("Could not save feedback. Try again.");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            lblMessage.setText("Error: " + ex.getMessage());
        }
    }

    public void clearForm() {
        txtNID.clear();
        txtMessage.clear();
        cmbCategory.setValue(null);
    }

    @FXML
    public void goBack(ActionEvent e) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("/com/example/badc/Arnima/farmer_dashboard.fxml"));
            Stage s = (Stage) txtNID.getScene().getWindow();
            s.setScene(new Scene(p));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

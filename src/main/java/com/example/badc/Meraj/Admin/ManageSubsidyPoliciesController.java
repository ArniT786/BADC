package com.example.badc.Meraj.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ManageSubsidyPoliciesController {

    @FXML
    private Label notificationLabel;
    @FXML
    private TextField policyNameField;
    @FXML
    private Label logLabel;
    @FXML
    private TextArea eligibilityArea;
    @FXML
    private ComboBox<String> statusCombo;
    @FXML
    private Button loadButton;
    @FXML
    private Button processButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button saveButton;
    @FXML
    private TextField subsidyRateField;

    private  ManageSubsidyPolicies policy;

    @FXML
    public void initialize() {
        statusCombo.getItems().addAll("Active", "Inactive");
        notificationLabel.setText("");
        logLabel.setText("");
    }
    @FXML
    public void handleLoad(ActionEvent event) {
        policy = new ManageSubsidyPolicies(
                "Farmer Support",
                "Small farmers only",
                "20%",
                "Active"
        );

        policyNameField.setText(policy.getPolicyName());
        eligibilityArea.setText(policy.getEligibility());
        subsidyRateField.setText(policy.getSubsidyRate());
        statusCombo.setValue(policy.getStatus());

        notificationLabel.setText("Policy loaded");
    }
    @FXML
    public void handleProcess(ActionEvent event) {

        if (policy == null) {
            showAlert("Load policy first!");
            return;
        }

        logLabel.setText("Processing policy...");
        notificationLabel.setText("Process complete");
    }
    @FXML
    public void handleUpdate(ActionEvent event) {

        if (policy == null) {
            showAlert("No policy loaded!");
            return;
        }

        policy.setPolicyName(policyNameField.getText());
        policy.setEligibility(eligibilityArea.getText());
        policy.setSubsidyRate(subsidyRateField.getText());
        policy.setStatus(statusCombo.getValue());

        notificationLabel.setText("Policy updated");
    }
    @FXML
    public void handleSave(ActionEvent event) {

        if (policy == null) {
            showAlert("Nothing to save!");
            return;
        }

        logLabel.setText("Policy saved to system");
        notificationLabel.setText("Saved successfully");
    }
    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(msg);
        alert.show();
    }
}
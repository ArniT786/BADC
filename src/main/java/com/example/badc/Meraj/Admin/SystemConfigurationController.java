package com.example.badc.Meraj.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SystemConfigurationController {

    @FXML
    private ComboBox<String> logLevelCombo;
    @FXML
    private Button restartButton;
    @FXML
    private CheckBox maintenanceCheckBox;
    @FXML
    private Button modifyButton;
    @FXML
    private TextField maxUsersField;
    @FXML
    private TextField systemNameField;
    @FXML
    private Button processButton;
    @FXML
    private Button loadConfigButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button validateAdminButton;
    @FXML
    private Label statusLabel;

    private SystemConfiguration config;

    @FXML
    public void initialize() {

        logLevelCombo.getItems().addAll("INFO", "DEBUG", "ERROR");

        statusLabel.setText("");
    }
    @FXML
    public void handleLoadConfig(ActionEvent event) {

        config = new SystemConfiguration(
                "BADC System",
                100,
                "INFO",
                false
        );
        systemNameField.setText(config.getSystemName());
        maxUsersField.setText(String.valueOf(config.getMaxUsers()));
        logLevelCombo.setValue(config.getLogLevel());
        maintenanceCheckBox.setSelected(config.isMaintenanceMode());
        statusLabel.setText("Config loaded");
    }
    @FXML
    public void handleValidateAdmin(ActionEvent event) {

        statusLabel.setText("Admin validated successfully");
    }
    @FXML
    public void handleModify(ActionEvent event) {

        if (config == null) {
            showAlert("Load config first!");
            return;
        }

        config.setSystemName(systemNameField.getText());
        config.setMaxUsers(Integer.parseInt(maxUsersField.getText()));
        config.setLogLevel(logLevelCombo.getValue());
        config.setMaintenanceMode(maintenanceCheckBox.isSelected());

        statusLabel.setText("Configuration modified");
    }
    @FXML
    public void handleProcess(ActionEvent event) {

        statusLabel.setText("Processing system configuration...");
    }

    @FXML
    public void handleSave(ActionEvent event) {

        statusLabel.setText("Configuration saved successfully");
    }
    @FXML
    public void handleRestart(ActionEvent event) {

        statusLabel.setText("System restarting...");
    }
    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(msg);
        alert.show();
    }
}
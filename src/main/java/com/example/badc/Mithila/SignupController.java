package com.example.badc.Mithila;

import com.example.badc.model.User;
import com.example.badc.model.FieldOfficer;
import com.example.badc.model.ReportOfficer;
import com.example.badc.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import com.example.badc.SceneSwitcher;

public class SignupController implements Initializable {

    @FXML private TextField name_txt;
    @FXML private TextField nid_txt;
    @FXML private PasswordField pass_pf;
    @FXML private TextField phone_txt;
    @FXML private ComboBox<String> role_cb;
    @FXML private TextField district_txt;
    @FXML private TextField dept_txt;
    @FXML private Label msg_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        role_cb.getItems().addAll("FIELD_OFFICER", "REPORT_OFFICER");
    }

    @FXML
    private void handleSignup(ActionEvent e) {
        String name = name_txt.getText().trim();
        String nid = nid_txt.getText().trim();
        String password = pass_pf.getText().trim();
        String phone = phone_txt.getText().trim();
        String role = role_cb.getValue();
        String district = district_txt.getText().trim();
        String department = dept_txt.getText().trim();

        if (name.isEmpty() || nid.isEmpty() || password.isEmpty() || phone.isEmpty() || role == null) {
            msg_lbl.setText("Basic fields are required");
            return;
        }

        String userId = (role.equals("FIELD_OFFICER") ? "FO" : "RO") + System.currentTimeMillis();
        User newUser;
        if (role.equals("FIELD_OFFICER")) {
            if (district.isEmpty()) {
                msg_lbl.setText("District required for Field Officer");
                return;
            }
            newUser = new FieldOfficer(userId, name, nid, password, phone, district, "SUP001");
        } else {
            if (department.isEmpty()) {
                msg_lbl.setText("Department required for Report Officer");
                return;
            }
            newUser = new ReportOfficer(userId, name, nid, password, phone, department);
        }

        if (UserService.signup(newUser)) {
            msg_lbl.setText("Success! Please login.");
            clearFields();
        } else {
            msg_lbl.setText("Failed! NID exists or invalid data.");
        }
    }

    private void clearFields() {
        name_txt.clear();
        nid_txt.clear();
        pass_pf.clear();
        phone_txt.clear();
        role_cb.setValue(null);
        district_txt.clear();
        dept_txt.clear();
    }

    @FXML
    private void goBack(ActionEvent e) {
        SceneSwitcher.switchScene(e, "/com/example/badc/Mithila/mithila_login.fxml");
    }
}

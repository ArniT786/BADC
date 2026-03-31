package com.example.badc.Mithila;

import com.example.badc.model.User;
import com.example.badc.service.TaskService;
import com.example.badc.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import com.example.badc.SceneSwitcher;

public class LoginController implements Initializable {

    @FXML
    private TextField nid_txt;
    @FXML
    private PasswordField pass_pf;
    @FXML
    private Label msg_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // init is already handled in HelloApplication.start()
    }

    @FXML
    private void handleLogin(ActionEvent e) {
        String nid = nid_txt.getText().trim();
        String password = pass_pf.getText().trim();

        if (nid.isEmpty()) {
            msg_lbl.setText("Please enter NID");
            return;
        }
        if (password.isEmpty()) {
            msg_lbl.setText("Please enter password");
            return;
        }

        User user = UserService.login(nid, password);
        if (user == null) {
            msg_lbl.setText("Invalid NID or password");
            return;
        }

        String fxmlPath;
        if (user.getRole().equals("FIELD_OFFICER")) {
            fxmlPath = "/Mithila/field_officer_dashboard.fxml";
        } else {
            fxmlPath = "/Mithila/report_officer_dashboard.fxml";
        }
        SceneSwitcher.switchScene(e, fxmlPath);
    }

    @FXML
    private void goToSignup(ActionEvent e) {
        SceneSwitcher.switchScene(e, "/Mithila/signup.fxml");
    }

}

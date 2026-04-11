package com.example.badc.Arnima;

import com.example.badc.Arnima.service.ScheduleService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FarmerDashboardController {

    @FXML private Button btnSeedApplication, btnIrrigation, btnSchedule, btnTrack, btnFeedback;

    public void initialize() {
        new ScheduleService().initDummySchedules();
    }

    @FXML
    public void openSeedApplication(ActionEvent event) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("/com/example/badc/Arnima/seed_application.fxml"));
            Stage s = (Stage) btnSeedApplication.getScene().getWindow();
            s.setScene(new Scene(p));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openIrrigationRequest(ActionEvent event) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("/com/example/badc/Arnima/irrigation_request.fxml"));
            Stage s = (Stage) btnIrrigation.getScene().getWindow();
            s.setScene(new Scene(p));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openScheduleView(ActionEvent event) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("/com/example/badc/Arnima/schedule_view.fxml"));
            Stage s = (Stage) btnSchedule.getScene().getWindow();
            s.setScene(new Scene(p));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openTrackStatus(ActionEvent event) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("/com/example/badc/Arnima/track_status.fxml"));
            Stage s = (Stage) btnTrack.getScene().getWindow();
            s.setScene(new Scene(p));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openFeedback(ActionEvent event) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("/com/example/badc/Arnima/feedback.fxml"));
            Stage s = (Stage) btnFeedback.getScene().getWindow();
            s.setScene(new Scene(p));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleLogout(ActionEvent event) {
        System.out.println("logout clicked");
        try {
            Parent p = FXMLLoader.load(getClass().getResource("/com/example/badc/login.fxml"));
            Stage s = (Stage) btnSeedApplication.getScene().getWindow();
            s.setScene(new Scene(p));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



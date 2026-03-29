package com.example.badc.Arnima;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class FarmerDashboardController implements Initializable {

    @FXML private Button btnSeedApplication;
    @FXML private Button btnIrrigation;
    @FXML private Button btnSchedule;
    @FXML private Button btnTrack;
    @FXML private Button btnFeedback;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    private void switchScene(ActionEvent event, String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @FXML private void openSeedApplication(ActionEvent event) { switchScene(event, "/com/example/badc/Arnima/seed_application.fxml"); }
    @FXML private void openIrrigationRequest(ActionEvent event) { switchScene(event, "/com/example/badc/Arnima/irrigation_request.fxml"); }
    @FXML private void openScheduleView(ActionEvent event) { switchScene(event, "/com/example/badc/Arnima/schedule_view.fxml"); }
    @FXML private void openTrackStatus(ActionEvent event) { switchScene(event, "/com/example/badc/Arnima/track_status.fxml"); }
    @FXML private void openFeedback(ActionEvent event) { switchScene(event, "/com/example/badc/Arnima/feedback.fxml"); }
}

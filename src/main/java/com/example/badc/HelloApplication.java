package com.example.badc;

import com.example.badc.service.FileService;
import com.example.badc.service.UserService;
import com.example.badc.service.TaskService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        try {
            FileService.ensureDataDir();
            UserService.initDummyUsers();
            TaskService.initDummyTasks();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/badc/login.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.setTitle("BADC System");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.example.badc.Mithila;

import com.example.badc.model.StockRecord;
import com.example.badc.service.StockService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import com.example.badc.SceneSwitcher;

public class DistributeInputController implements Initializable {

    @FXML private TextField nid_txt;
    @FXML private ComboBox<String> type_cb;
    @FXML private ComboBox<String> name_cb;
    @FXML private TextField qty_txt;
    @FXML private Label elig_lbl;
    @FXML private Label msg_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        type_cb.getItems().addAll("Seeds", "Fertilizer");
        type_cb.setOnAction(e -> {
            String selected = type_cb.getValue();
            if ("Seeds".equals(selected)) {
                name_cb.getItems().setAll("Rice Seed", "Wheat Seed", "Jute Seed");
            } else if ("Fertilizer".equals(selected)) {
                name_cb.getItems().setAll("Urea", "TSP", "MOP");
            }
            name_cb.setValue(null);
        });
    }

    @FXML
    private void checkEligibility(ActionEvent event) {
        String nid = nid_txt.getText().trim();
        if (nid.isEmpty()) {
            elig_lbl.setText("Enter NID first");
            return;
        }
        boolean eligible = StockService.checkEligibility(nid);
        elig_lbl.setText(eligible ? "Eligible" : "Not Eligible");
    }

    @FXML
    private void confirmDistribution(ActionEvent event) {
        if (!elig_lbl.getText().equals("Eligible")) {
            msg_lbl.setText("Check eligibility first");
            return;
        }

        String type = type_cb.getValue();
        String name = name_cb.getValue();
        String qtyStr = qty_txt.getText().trim();

        if (type == null || name == null || qtyStr.isEmpty()) {
            msg_lbl.setText("Please fill all fields");
            return;
        }

        double qty;
        try {
            qty = Double.parseDouble(qtyStr);
        } catch (NumberFormatException ex) {
            msg_lbl.setText("Invalid quantity");
            return;
        }

        String nid = nid_txt.getText().trim();
        String today = LocalDate.now().toString();
        StockRecord r = new StockRecord("", nid, type, name, qty, today, "OFFICER", true);

        if (StockService.distributeItem(r)) {
            msg_lbl.setText("Success! Distribution saved.");
            clearForm();
        } else {
            msg_lbl.setText("Failed.");
        }
    }

    @FXML
    private void clearForm(ActionEvent event) {
        clearForm();
    }

    private void clearForm() {
        nid_txt.clear();
        type_cb.setValue(null);
        name_cb.setValue(null);
        name_cb.getItems().clear();
        qty_txt.clear();
        elig_lbl.setText("");
        msg_lbl.setText("");
    }

    @FXML
    private void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/example/badc/Mithila/field_officer_dashboard.fxml");
    }
}

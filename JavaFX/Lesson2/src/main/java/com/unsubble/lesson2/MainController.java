package com.unsubble.lesson2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class MainController {
    @FXML
    private Label testLabel;

    @FXML
    protected void onButtonClick() {
        testLabel.setText("sa");
        testLabel.setTextFill(Color.WHEAT);
    }
}

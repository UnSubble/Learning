package com.unsubble.lesson4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoginCheckerController {
    @FXML
    private Label wlabel;

    void setName(String name) {
        wlabel.setText("Hello: " + name);
    }
}
